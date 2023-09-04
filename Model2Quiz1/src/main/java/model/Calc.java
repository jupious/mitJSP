package model;

public class Calc {
	private int num1;
	private int num2;
	
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int even() {
		int temp, sum = 0;
		if(num1 > num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		for(int i = num1 ; i <= num2; i++){
			if(i%2 == 0)
				sum+=i;
		}
		return sum;
	}
	
	public int odd() {
		int temp, sum = 0;
		if(num1 > num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		for(int i = num1 ; i <= num2; i++){
			if(i%2 == 1)
				sum+=i;
		}
		return sum;
	}
	
}
