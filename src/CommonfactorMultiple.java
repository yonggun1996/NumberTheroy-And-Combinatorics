package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 최소 공배수와 최대 공약수를 구하는 문제
 유클리드 호제법 사용
 두 수의 나머지를 구하는데 나머지가 0이 될 때 까지 구하며
 그 중 작은 수가 최대 공약수
 최소 공배수는 최대공약수 * (수1/최대공약수) * (수2/최소공배수)
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
