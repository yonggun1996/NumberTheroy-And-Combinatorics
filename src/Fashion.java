package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 �־��� ���� �з��� �� ���� �������� ��� ���Ѵ�
 */

public class Fashion {
	
	/*
	 ������ �� ��α� : https://st-lab.tistory.com/164
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());//�׽�Ʈ ���̽�
		
		for(int i = 0; i < testcase; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine());//������ ���� ���� ����
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();//���� �̸�
				String kind = st.nextToken();//�� ����
				
				//�ش� ���� ������ �ľ��ϱ� ���� for��
				if(map.containsKey(kind)) {//�̹� �ش� ���� ������ ���� �ִٸ� ������ ������ 1�� ���� �����Ѵ�
					int count = map.get(kind);
					map.put(kind, count + 1);
				}else {//�׷��� ������ ���� �ִ´�
					map.put(kind, 1);
				}
			}
			
			//�ش� ���� ������ �װ��� �������� �ʴ� ���(�� ������ 1�� ���ϴ� ���)�� ���� ��� ���Ѵ�
			long answer = 1;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {//map�� ���� ���캸�� for��
				int num = entry.getValue() + 1;//�ش� ���� �������� �ʴ� ��쵵 �ֱ� ������ 1�� ���Ѵ�
				answer *= num;
			}
			
			System.out.println(answer - 1);//���� �� �Դ� ���� �����ϱ� ������ 1�� ����
		}
	}

}
