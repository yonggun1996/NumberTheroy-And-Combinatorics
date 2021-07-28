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
		factorial[0] = new BigInteger("1");//k�� 0�� �� �� �ִ�. �̶� 0�� ������ �Ǹ� ������ �߻��ϱ� ������ 1�� �����͸� �����Ų��
		factorial[1] = new BigInteger("1");
		
		//DP�� �̿��� ���丮���� ���ϴ� ���
		for(int i = 2; i <= n; i++) {
			BigInteger bignum = new BigInteger(String.valueOf(i));
			factorial[i] = (factorial[i - 1].multiply(bignum));
		}
		
		//int answer = (factorial[n] / (factorial[k] * factorial[n - k])) % 10007;
		BigInteger answer = (factorial[n].divide(factorial[k].multiply(factorial[n - k]))).mod(modnum);
		System.out.println(answer);

	}

}
