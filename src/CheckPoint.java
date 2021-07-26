package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 ������ �� ��α� : https://st-lab.tistory.com/155
 �������� ���ƾ� �ϴµ� �̴� {(���� �� X ��) + ������} �� ���� ���� �� ���� ���� ����
 �������� ���ٴ� ���� ������1 - ������2�� 0�̶�� ��
 ���� ���� ����1�� ����2�� ������� �Ǿ�� �Ѵ�
 �й��Ģ�� ���� (����1 - ����2)�� ������� ���޾� ã���� �Ǵ� ����
 */
public class CheckPoint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		//������ �� �� ������ 2���� ���� ��� �� ������ ������� ���Ѵ�
		int result = arr[1] - arr[0];
		
		for(int i = 2; i < n; i++) {
			result = get_gcd(result, arr[i] - arr[i - 1]);
		}
		
		for(int i = 2; i <= result; i++) {
			if(result % i == 0) {
				answer.append(i);
				answer.append(" ");
			}
		}
		
		System.out.println(answer);
	}
	
	//�ִ������� ���ϴ� �޼ҵ�
	public static int get_gcd(int num1, int num2) {
		while(num2 != 0) {
			int result = num1 % num2;
			num1 = num2;
			num2 = result;
		}
		
		return num1;
	}

}
