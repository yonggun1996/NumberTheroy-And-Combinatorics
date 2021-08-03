package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 주어진 옷을 분류를 해 옷의 종류들을 모두 곱한다
 */

public class Fashion {
	
	/*
	 도움이 된 블로그 : https://st-lab.tistory.com/164
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());//테스트 케이스
		
		for(int i = 0; i < testcase; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine());//가지고 있은 옷의 개수
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();//옷의 이름
				String kind = st.nextToken();//옷 종류
				
				//해당 옷의 개수를 파악하기 위한 for문
				if(map.containsKey(kind)) {//이미 해당 옷을 집계한 적이 있다면 기존의 개수에 1을 더해 저장한다
					int count = map.get(kind);
					map.put(kind, count + 1);
				}else {//그렇지 않으면 새로 넣는다
					map.put(kind, 1);
				}
			}
			
			//해당 옷의 개수와 그것을 선택하지 않는 경우(옷 개수에 1을 더하는 방식)를 구해 계속 곱한다
			long answer = 1;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {//map을 전부 살펴보는 for문
				int num = entry.getValue() + 1;//해당 옷을 선택하지 않는 경우도 있기 때문에 1을 더한다
				answer *= num;
			}
			
			System.out.println(answer - 1);//전부 안 입는 경우는 배제하기 때문에 1을 뺀다
		}
	}

}
