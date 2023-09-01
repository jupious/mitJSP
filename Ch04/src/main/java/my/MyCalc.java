package my;

public class MyCalc {
	private int num1, num2;
	public MyCalc(String num1, String num2) {
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}
	
	public int sum() {
		int temp, t1, t2, sum = 0;
		t1 = num1;
		t2 = num2;
		if(t1 > t2) {
			temp = t1;
			t1 = t2;
			t2 = temp;
		}
		for(;t1 <= t2;t1++) {
			sum+=t1;
		}
		return sum;
	}
}
