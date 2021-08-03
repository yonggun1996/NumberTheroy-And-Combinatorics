package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FactorialZeroCount {
	
	static ArrayList<Integer> sosulist = new ArrayList<Integer>();//�Ҽ��� ��� ����Ʈ

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		if(n >= 5){//5 ���� ���� ���� ���丮�� ���� 0�� ���� �ʴ´�
			set_sosu(n);//�Ҽ��� ���ϴ� �޼��� ȣ��
			for(int i = 2; i <= n; i++) {
				answer += get_fivecount(i);//���μ����ظ� �ϴ� �޼��� ȣ��
			}
		}
		
		System.out.println(answer);
	}
	
	//�Ҽ��� ���ϴ� �޼���
	//�����佺�׳׽��� ü�� ���� ����
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
	
	//���μ� ���ظ��ϴ� �޼���
	//�� �߿��� 5�� �� �� ���ߴ��� Ȯ���ϴ� �޼���
	public static int get_fivecount(int num) {
		int count = 0;
		for(int i = 0; i < sosulist.size(); i++) {
			int divnum = sosulist.get(i);
			
			if(num % divnum == 0) {
				num /= sosulist.get(i);
				i = -1;//�ٽ� 2���� ���� �� �ְ� i�� -1�� �ʱ�ȭ
				
				if(divnum == 5) {//5�� �����ٸ� count�� �ø���
					count++;
				}
			}else {//�׷��� ������ i�� �ø���
				continue;
			}
			
			if(num == 1) {//���� ���̻� ���� �� ������ �ݺ����� ���� ���´�
				break;
			}
		}
		
		return count;
	}

}
