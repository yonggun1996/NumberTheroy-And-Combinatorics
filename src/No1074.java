package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1074 {
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int unit = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int nx = 0; int ny = 0;
        if(x == nx && y == ny){//0,0의 값을 출력하려는 경우 바로 0을 출력
            System.out.println(0);
            return;
        }

        int answer = 0;
        while(x != nx || y != ny){//nx와 ny가 목표하려던 지점이 도착한다면 탐색을 끝낸다
            if(x < nx + unit / 2 && y < ny + unit / 2){
                //1사분면
                unit /= 2;//단위만 반으로 줄어든다
            }else if(x < nx + unit / 2 && y >= ny + unit / 2){
                //2사분면
                ny += unit / 2;//최소 y를 단위의 반만큼 늘려준다
                answer += (unit / 2) * (unit / 2);//한 구역의 최소값을 늘린다
                unit /= 2;
            }else if(x >= nx + unit / 2 && y < ny + unit / 2){
                //3사분면
                nx += unit / 2;//최소 x를 단위의 반만큼 늘려준다
                answer += (unit / 2) * (unit / 2) * 2;
                unit /= 2;
            }else{
                //4사분면
                nx += unit / 2;//최소 x를 단위의 반만큼 늘려준다
                ny += unit / 2;//최소 y를 단위의 반만큼 늘려준다
                answer += (unit / 2) * (unit / 2) * 3;
                unit /= 2;
            }
        }
        System.out.println(answer);
    }
}
