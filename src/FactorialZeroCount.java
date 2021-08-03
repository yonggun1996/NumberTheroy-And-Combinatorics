package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FactorialZeroCount {
	
	static ArrayList<Integer> sosulist = new ArrayList<Integer>();//소수를 담는 리스트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		if(n >= 5){//5 보다 작은 수는 팩토리얼 값에 0이 들어가지 않는다
			set_sosu(n);//소수를 구하는 메서드 호출
			for(int i = 2; i <= n; i++) {
				answer += get_fivecount(i);//소인수분해를 하는 메서드 호출
			}
		}
		
		System.out.println(answer);
	}
	
	//소수를 구하는 메서드
	//에라토스테네스이 체로 구한 문제
	public static void set_sosu(int n) {
		boolean[] sosu = new boolean[n + 1];
		Arrays.fill(sosu, true);
		
		sosu[0] = false;
		sosu[1] = false;
		
		for(int i = 2; i <= n; i++) {
			if(sosu[i]) {
				sosulist.add(i);
				for(int j = 2; i * j <= n; j++) {
					sosu[i * j] = false;
				}
			}
		}
	}
	
	//소인수 분해를하는 메서드
	//그 중에서 5를 몇 번 곱했는지 확인하는 메서드
	public static int get_fivecount(int num) {
		int count = 0;
		for(int i = 0; i < sosulist.size(); i++) {
			int divnum = sosulist.get(i);
			
			if(num % divnum == 0) {
				num /= sosulist.get(i);
				i = -1;//다시 2부터 나눌 수 있게 i를 -1로 초기화
				
				if(divnum == 5) {//5를 나눴다면 count를 늘린다
					count++;
				}
			}else {//그렇지 않으면 i를 늘린다
				continue;
			}
			
			if(num == 1) {//만약 더이상 나눌 수 없으면 반복문을 빠져 나온다
				break;
			}
		}
		
		return count;
	}

}
