package java_practice;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 313;
		int quotient = 0, remainder = 0, result = 0; /* ��, ������, 13�� ������ �����ϱ� ���� ���� */
        int tmpRemainder; /* ���� �ڸ����� ���� �����ϱ� ���� ���� */
        
        for(int i=1; i<=a; i++) {
            quotient = i;
            tmpRemainder = 0;
            while(quotient > 0) {
                remainder = quotient%10;
                quotient = quotient/10;
                if (remainder == 1 && tmpRemainder == 3) { /* ���� �ڸ����� ���� 1 �̰�, ���� �ڸ����� ���� 3�̸� �� */
                    result++;
                    System.out.println("i : " + i);
                    break;
                }
                tmpRemainder = remainder; /* ���� �ڸ����� �� ���� */
            }
        }
        System.out.println("result : " + result);
	}

}
