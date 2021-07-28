package NumberTheroyAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 ���� ����� ���ϴ� ����
 ������ ���� N�� K�� �־����ٰ� ����
 (N!) / (K! * (N - K)!)
 (1 + x) ^ N�� ���� �־��� �� x�� K�� ���� �� �տ� �ٴ� ����� ������ Ȯ���غ��� ����
 */
public class BinomialCoefficient {
	
	static int[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		factorial = new int[n + 1];
		factorial[0] = 1;//k�� 0�� �� �� �ִ�. �̶� 0�� ������ �Ǹ� ������ �߻��ϱ� ������ 1�� �����͸� �����Ų��
		factorial[1] = 1;
		
		//DP�� �̿��� ���丮���� ���ϴ� ���
		for(int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		
		int answer = factorial[n] / (factorial[k] * factorial[n - k]);
		System.out.println(answer);

	}

}
