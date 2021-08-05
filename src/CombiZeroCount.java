package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 ����� N!�� 0�� ������ N�� ��� 5�� ������ �� ����� ����(N�� 5���� ������ ���� ���) ���̴�.
 0�� ������ 2�� 5�� ��ġ�� �¼��� ���� ���� ������ 2�� 5�� �¼��� ���� �� �� �ּڰ��� ��ȯ�Ѵ�
 */

public class CombiZeroCount {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long answer = Math.min(divfive(n) - divfive(m) - divfive(n - m), divtwo(n) - divtwo(m) - divtwo(n - m));
		System.out.println(answer);
	}
	
	//5�� �� �� ���ߴ��� ��ȯ�ϴ� �޼���
	public static long divfive(long num) {
		int count = 0;
		while(num >= 5) {
			count += num / 5;
			num /= 5;
		}
		
		return count;
	}
	
	//2�� �� �� ���ߴ��� ��ȯ�ϴ� �޼���
	public static long divtwo(long num) {
		int count = 0;
		while(num >= 2) {
			count += num / 2;
			num /= 2;
		}
		
		return count;
	}
	
}
