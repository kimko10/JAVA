package java_practice;

public class test {

	static int Mine = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] goldValues1 = {5,2,1,4,3,1};
		int[] goldValues2 = {1,2,1};
		int[] goldValues3 = {2,1,4,1,2,1,8,1};
		int[] a = {};
		// {2,3,1,9,5,6,7,4,10}
		
		while(goldValues2!=null) {
			goldValues2 = fun(goldValues2);
		}
		System.out.println("HJLOG ³¡ Mine : " + Mine);
	}
	
	public static int[] fun(int[] casee) {
		int temp = 0;
		int index = 0;
		for(int i=0;i<casee.length;i++) {
			for(int j=i+1;j<casee.length;j++) {
				if(temp !=0) {
					if(casee[j] > temp) {
						temp = casee[j];
						index = j;
					}
				} else {
					if(casee[i] > casee[j]) {
						temp = casee[i];
						index = i;
					}
				}
			}
		}
		casee[index] = 0;
		int temp2 = 0;
		int index2 = 0;
		
		for(int i=0;i<casee.length;i++) {
			for(int j=i+1;j<casee.length;j++){
				if(temp > casee[j]) {
					if(casee[i] > casee[j]) {
						temp2 = casee[j];
						index2 = j;
					}
				}
				
			}
		}
		casee[index2] = 0;
		
		System.out.println("HJLOG temp : " + temp + " index : " + index);
		System.out.println("HJLOG temp2 : " + temp2 + " index2 : " + index2);
		Mine += temp;
		
		return casee;
	}
	
	

}
