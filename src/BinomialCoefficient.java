package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 이항 계수를 구하는 공식
 문제와 같이 N과 K가 주어졌다고 가정
 (N!) / (K! * (N - K)!)
 (1 + x) ^ N의 식이 주어질 때 x를 K번 썼을 때 앞에 붙는 계수는 몇인지 확인해보는 문제
 */
public class BinomialCoefficient {
	
	static int[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		factorial = new int[n + 1];
		factorial[0] = 1;//k가 0이 올 수 있다. 이때 0을 나누게 되면 에러가 발생하기 때문에 1로 데이터를 저장시킨다
		factorial[1] = 1;
		
		//DP를 이용해 팩토리얼을 구하는 방법
		for(int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		
		int answer = factorial[n] / (factorial[k] * factorial[n - k]);
		System.out.println(answer);

	}

}
