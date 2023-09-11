package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import model.ChatDAO;
import model.ChatVO;

@ServerEndpoint("/ChatSocket")
public class ChatSocket {
private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	
	@OnOpen //클라이언트 접속시 실행
	public void onOpen(Session session) {
		clients.add(session);
		System.out.println("웹소켓 연결됨 id = " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		ChatDAO dao = new ChatDAO();
		String[] msg = message.split("\\|");
		String content = "";
		System.out.println("이름: " + msg[0]);
		
		for(int i = 1; i < msg.length ; i++) {
			content += msg[i]+"|";
		}
		if(content.length() >= 2) {
			content = content.substring(0, content.length() -2);
		}
		
		System.out.println("내용: " + content);
		ChatVO vo = new ChatVO();
		vo.setName(msg[0]);
		vo.setText(content);
		dao.saveChat(vo);
		System.out.println("메세지 전송 : " + session.getId() + ":" + message);
		synchronized (clients) {
			for (Session client : clients) {	//모든 클라이언트에 메세지 전달
				if(!client.equals(session)) {	//메세지를 보낸 클라이언트 제외
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	@OnClose	//클라이언트 접속 해제시 실행
	public void onClose(Session session) {
		clients.remove(session);
		System.out.println("웹소켓 종료 id = " + session.getId());
	}
	
	@OnError
	public void onError(Throwable e) {
		System.out.println("에러");
		e.printStackTrace();
	}
}
