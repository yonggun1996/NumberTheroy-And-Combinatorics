package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 들어오는 수 중 첫 번째로 들어온 수는 링의 기준이 된다
 분수를 표현해서 나타내는다 분자는 기준 링과 최대공약수를 나눈 값
 분모는 입력받은 값과 최대공약수를 나눈 값이 된다.
 */

public class Ring {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int flag = 0;//링의 기준이 될 변수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				//기준이 되는 링을 정한다
				flag = num;
			}else {
				//기준이 정해진 링을 통해 분수를 만들어 낸다
				int gcd = get_gcd(flag, num);
				System.out.println((flag / gcd) + "/" + (num / gcd));
			}
		}
	}
	
	static int get_gcd(int num1, int num2) {
		while(num2 != 0) {
			int mod = num1 % num2;
			num1 = num2;
			num2 = mod;
		}
		
		return num1;
	}

}
