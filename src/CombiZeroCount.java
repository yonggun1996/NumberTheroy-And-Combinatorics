package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 참고로 N!의 0의 개수는 N을 계속 5로 나눴을 때 몫들을 더한(N이 5보다 작을때 까지 계산) 값이다.
 0의 개수는 2와 5의 겹치는 승수의 값과 같기 때문에 2롸 5의 승수를 구해 그 중 최솟값을 반환한다
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
	
	//5를 몇 번 곱했는지 반환하는 메서드
	public static long divfive(long num) {
		int count = 0;
		while(num >= 5) {
			count += num / 5;
			num /= 5;
		}
		
		return count;
	}
	
	//2를 몇 번 곱했는지 반환하는 메서드
	public static long divtwo(long num) {
		int count = 0;
		while(num >= 2) {
			count += num / 2;
			num /= 2;
		}
		
		return count;
	}
	
}
