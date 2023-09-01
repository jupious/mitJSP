package model;

public class MyNum {
	
	public static int sum(int num1, int num2) {
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
