package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 �̹����� ���� ������ �̿��� ���ϴ� ���
 ���� 7���� �ٸ� �� 3���� ���� �Ѵٸ�
 (m!) / (m - n)! * (n!)
 �� ������ ���� ������ Ǯ����
 ���� ���ڰ� Ŀ�� �� �ֱ� ������ Biginteger�� ����ߴ�.
 */

public class SettingBridge {
	
	static BigInteger[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			result = new BigInteger[m + 1];
			result[0] = BigInteger.ONE;
			result[1] = BigInteger.ONE;
			
			for(int j = 2; j <= m; j++) {//���丮�� ���� ��� for��
				BigInteger num1 = new BigInteger(result[j - 1].toString());
				BigInteger num2 = new BigInteger(String.valueOf(j));
				
				result[j] = num1.multiply(num2);
			}
			
			BigInteger n1 = result[m];
			BigInteger n2 = result[n];
			BigInteger n3 = result[m - n];
			
			System.out.println(n1.divide(n2.multiply(n3)));
		}
	}
}
