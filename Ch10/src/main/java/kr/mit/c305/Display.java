package kr.mit.c305;

import java.util.Scanner;

public class Display implements InterDisplay {
	Scanner scan = new Scanner(System.in);
	@Override
	public void title() {
		System.out.println("-----------------------");
		System.out.println("------������ ����------");
		System.out.println("-----------------------");
	}

	@Override
	public int menu() {
		int user;
		System.out.print("\n1.��ü ���� ����\n" + "2.���� ������ ���� ����\n" + "3.���� �Է�\n" + "4.���� �˻��ϱ�\n" + "5.���� ��¥ Ȯ��\n" + "6.���� �Ϸ��ϱ�\n" +
						"7.���� �����ϱ�\n" +"8.����\n" + "menu�Է�:");
		
		try {
			user = scan.nextInt();
		}catch(Exception e) {
			System.out.println("���ڸ� �Է��� �ּ���.");
			user = 6;
		}
		return user;
	}

	@Override
	public void end() {
		System.out.println("�����մϴ�.");

	}

}
