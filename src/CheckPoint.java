package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 도움이 된 블로그 : https://st-lab.tistory.com/155
 나머지가 같아야 하는데 이는 {(나눌 수 X 몫) + 나머지} 이 식을 가진 두 개의 식을 통해
 나머지가 같다는 것은 나머지1 - 나머지2가 0이라는 뜻
 나눌 수는 숫자1과 숫자2의 공약수가 되어야 한다
 분배법칙에 의해 (숫자1 - 숫자2)의 공약수를 연달아 찾으면 되는 문제
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
		
		//정렬을 한 후 인접한 2개의 값을 골라 뺀 값끼리 공약수를 구한다
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
	
	//최대공약수를 구하는 메소드
	public static int get_gcd(int num1, int num2) {
		while(num2 != 0) {
			int result = num1 % num2;
			num1 = num2;
			num2 = result;
		}
		
		return num1;
	}

}
