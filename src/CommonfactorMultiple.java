package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 �ּ� ������� �ִ� ������� ���ϴ� ����
 ��Ŭ���� ȣ���� ���
 �� ���� �������� ���ϴµ� �������� 0�� �� �� ���� ���ϸ�
 �� �� ���� ���� �ִ� �����
 �ּ� ������� �ִ����� * (��1/�ִ�����) * (��2/�ּҰ����)
 */
public class CommonfactorMultiple {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		int gcf = 0;
		
		while(true) {
			int result = max % min;
			
			if(result == 0) {
				gcf = min;
				break;
			}else {
				max = min;
				min = result;
			}
		}
		
		System.out.println(gcf);
		System.out.println(gcf * (num1 / gcf) * (num2 / gcf));
	}

}
