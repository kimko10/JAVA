package java_practice;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 313;
		int quotient = 0, remainder = 0, result = 0; /* 몫, 나머지, 13의 개수를 저장하기 위한 변수 */
        int tmpRemainder; /* 이전 자릿수의 값을 저장하기 위한 변수 */
        
        for(int i=1; i<=a; i++) {
            quotient = i;
            tmpRemainder = 0;
            while(quotient > 0) {
                remainder = quotient%10;
                quotient = quotient/10;
                if (remainder == 1 && tmpRemainder == 3) { /* 현재 자릿수의 값이 1 이고, 이전 자릿수의 값이 3이면 참 */
                    result++;
                    System.out.println("i : " + i);
                    break;
                }
                tmpRemainder = remainder; /* 이전 자릿수의 값 저장 */
            }
        }
        System.out.println("result : " + result);
	}

}
