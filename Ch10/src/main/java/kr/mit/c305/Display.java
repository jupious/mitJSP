package kr.mit.c305;

import java.util.Scanner;

public class Display implements InterDisplay {
	Scanner scan = new Scanner(System.in);
	@Override
	public void title() {
		System.out.println("-----------------------");
		System.out.println("------오늘의 할일------");
		System.out.println("-----------------------");
	}

	@Override
	public int menu() {
		int user;
		System.out.print("\n1.전체 일정 보기\n" + "2.가장 근접한 일정 보기\n" + "3.일정 입력\n" + "4.일정 검색하기\n" + "5.남은 날짜 확인\n" + "6.일정 완료하기\n" +
						"7.일정 삭제하기\n" +"8.종료\n" + "menu입력:");
		
		try {
			user = scan.nextInt();
		}catch(Exception e) {
			System.out.println("숫자를 입력해 주세요.");
			user = 6;
		}
		return user;
	}

	@Override
	public void end() {
		System.out.println("감사합니다.");

	}

}
