package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Commonfactor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int max = Math.max(num1, num2);
			int min = Math.min(num1, num2);
			int result = 0;//최대공약수
			
			while(true) {
				if(max % min == 0) {
					result = min;
					break;
				}else {
					result = max % min;
					max = min;
					min = result;
				}
			}
			
			bw.write(String.valueOf(result * (num1 / result) * (num2 / result)));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

}
