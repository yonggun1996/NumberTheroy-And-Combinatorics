package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BinomialCoefficient2 {
	
	static BigInteger[] factorial;
	static BigInteger modnum = new BigInteger("10007");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		factorial = new BigInteger[n + 1];
		factorial[0] = new BigInteger("1");//k가 0이 올 수 있다. 이때 0을 나누게 되면 에러가 발생하기 때문에 1로 데이터를 저장시킨다
		factorial[1] = new BigInteger("1");
		
		//DP를 이용해 팩토리얼을 구하는 방법
		for(int i = 2; i <= n; i++) {
			BigInteger bignum = new BigInteger(String.valueOf(i));
			factorial[i] = (factorial[i - 1].multiply(bignum));
		}
		
		//int answer = (factorial[n] / (factorial[k] * factorial[n - k])) % 10007;
		BigInteger answer = (factorial[n].divide(factorial[k].multiply(factorial[n - k]))).mod(modnum);
		System.out.println(answer);

	}

}
