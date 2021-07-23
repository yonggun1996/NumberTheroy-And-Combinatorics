package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MultiAndDiv {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(num1 == 0 && num2 == 0) {//숫자 2개가 모두 0이라면 반복무 탈출
				break;
			}
			
			if((num1 < num2) && (num2 % num1 == 0)) {//두번째 수가 큰 경우는 약수를 구하는 경우이며 나머지가 0이면 약수인지 아닌지 판별
				bw.write("factor");
				bw.newLine();
			}else if((num1 > num2) && (num1 % num2 == 0)) {//첫번째 수가 큰 경우는 배수를 구하는 경우이며 나머지가 0이면 배수인지 아닌지 판별
				bw.write("multiple");
				bw.newLine();
			}else {//그 외의 경우는 neither 출력
				bw.write("neither");
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}

}
