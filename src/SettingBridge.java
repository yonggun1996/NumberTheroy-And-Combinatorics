package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 이번에도 조합 공식을 이용해 구하는 방식
 만약 7개의 다리 중 3개를 선택 한다면
 (m!) / (m - n)! * (n!)
 이 공식을 통해 문제를 풀었다
 또한 숫자가 커질 수 있기 때문에 Biginteger를 사용했다.
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
			
			for(int j = 2; j <= m; j++) {//팩토리얼 값을 담는 for문
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
