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
			
			if(num1 == 0 && num2 == 0) {//���� 2���� ��� 0�̶�� �ݺ��� Ż��
				break;
			}
			
			if((num1 < num2) && (num2 % num1 == 0)) {//�ι�° ���� ū ���� ����� ���ϴ� ����̸� �������� 0�̸� ������� �ƴ��� �Ǻ�
				bw.write("factor");
				bw.newLine();
			}else if((num1 > num2) && (num1 % num2 == 0)) {//ù��° ���� ū ���� ����� ���ϴ� ����̸� �������� 0�̸� ������� �ƴ��� �Ǻ�
				bw.write("multiple");
				bw.newLine();
			}else {//�� ���� ���� neither ���
				bw.write("neither");
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}

}
