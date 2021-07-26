package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 ������ �� �� ù ��°�� ���� ���� ���� ������ �ȴ�
 �м��� ǥ���ؼ� ��Ÿ���´� ���ڴ� ���� ���� �ִ������� ���� ��
 �и�� �Է¹��� ���� �ִ������� ���� ���� �ȴ�.
 */

public class Ring {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int flag = 0;//���� ������ �� ����

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				//������ �Ǵ� ���� ���Ѵ�
				flag = num;
			}else {
				//������ ������ ���� ���� �м��� ����� ����
				int gcd = get_gcd(flag, num);
				System.out.println((flag / gcd) + "/" + (num / gcd));
			}
		}
	}
	
	static int get_gcd(int num1, int num2) {
		while(num2 != 0) {
			int mod = num1 % num2;
			num1 = num2;
			num2 = mod;
		}
		
		return num1;
	}

}
