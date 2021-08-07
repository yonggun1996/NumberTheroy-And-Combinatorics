# 정수론 및 조합론

이번 섹션에선 정수론과 조합론에 대한 다양한 문제를 풀어봤다.
그 중 최대공약수와 최소공배수를 구하는 문제, N개의 종류 중 M개를 선택하는 방법은 몇 개인지 확인할 수 있는 조합 계산방법을 알게 되었다.

1. 유클리드 호제법
최대공약수와 최소공배수를 빠르게 구할 수 있는 방법이다.

예를 들어 22와 8의 최대공약수를 구한다고 가정하자. 가로가 22, 세로가 8인 직사각형을 가로를 8cm로 나눠보면 다음과 같다.

![유클리드 호제법1](https://user-images.githubusercontent.com/68115246/128592919-1ff638e1-b8e6-46a2-ab92-e773c1856306.png)

이 때 세로가 8cm 가로가 6cm인 직사각형이 남는다. 이번엔 세로 8cm를 6cm로 나누면 다음과 같다.

![유클리드 호제법2](https://user-images.githubusercontent.com/68115246/128592434-27d9af6f-c7cd-46da-b572-62bba59d993e.png)

이번엔 세로 2cm가 남았다. 아까의 연산을 반복해 가로 6cm를 2cm으로 나눠보면 다음과 같다.

![유클리드 호제법3](https://user-images.githubusercontent.com/68115246/128592900-4360acad-f827-4d9f-86b8-cd5f95f13fd1.png)


이번엔 특별히 작은 사각형이 없고 모두 똑같이 나눠 떨어진다. 8과 22를 최대로 나눌 수 있는 최대 공약수는 2이며 최소공배수는 구한 최대공약수를 토대로 (8 / 2) * (22 / 2) * 2를 하면 88이 된다.

이를 소스코드로 구현할 때는 나머지 연산을 이용하면 된다.

![유클리드 호제법4](https://user-images.githubusercontent.com/68115246/128592574-7c8d8d30-01ba-4b63-9aa7-065c7430f800.png)

- 유클리드 호제법을 이용한 문제(백준 알고리즘 2609번 문제)
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
    //큰 수와 작은 수를 미리 정해준다
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		int gcf = 0;
		
		while(true) {
			int result = max % min;
			
			if(result == 0) {//값이 나누어 떨어지면 최대공약수는 두 수중 작은 값이 되며 연산을 중지한다
				gcf = min;
				break;
			}else {
				max = min;//두 수중 작은 값이 최대값이 되고
				min = result;//나머지로 나온 값이 최소값이 된다.
			}
		}
		
		System.out.println(gcf);
		System.out.println(gcf * (num1 / gcf) * (num2 / gcf));
	}

}
```

2. 조합공식
조합공식은 서로 다른 n개중 r개를 선택하는 경우의 수를 구하는 공식이다. 예를 들어 6개중 4개를 고른다고 하면 6C4 이런식으로 사용한다.

더 정확한 공식은 아래 그림을 참조하면 된다.

![조합1](https://user-images.githubusercontent.com/68115246/128592779-2d3de5dc-2911-4a6c-999c-61cca7ef7394.png)

팩토리얼 연산을 이용해 구하는데 이것을 하나하나 곱하면 시간상의 문제가 생길 수 있다.
그래서 다음 소스코드를 보면 팩토리얼은 DP를 이용해서 구현했고, 이에 따라 공식을 대입해 문제를 풀었다.

- 백준 알고리즘 문제(11050번 문제)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 이항 계수를 구하는 공식
 문제와 같이 N과 K가 주어졌다고 가정
 (N!) / (K! * (N - K)!)
 (1 + x) ^ N의 식이 주어질 때 x를 K번 썼을 때 앞에 붙는 계수는 몇인지 확인해보는 문제
 */
public class BinomialCoefficient {
	
	static int[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		factorial = new int[n + 1];
		factorial[0] = 1;//k가 0이 올 수 있다. 이때 0을 나누게 되면 에러가 발생하기 때문에 1로 데이터를 저장시킨다
		factorial[1] = 1;
		
		//DP를 이용해 팩토리얼을 구하는 방법
		for(int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		
		int answer = factorial[n] / (factorial[k] * factorial[n - k]);
		System.out.println(answer);

	}

}
```
