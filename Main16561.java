import java.util.Scanner;

public class Main16561 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int sum=1;
//        int cnt =2;
//        for(int i=9;i<n;i+=3){
//            sum+=cnt;
//            cnt+=1;
//        }
//        System.out.println(sum);

        int count=0;
        int sum =0;

        //3의 배수 2개를 선택하면 나머지 하나는 자동으로 정해짐
        //3의 배수 2개를 선택하고 그 합을 구한 다음에
        //입력 받은 수 n에서 3의 배수 2개의 합을 뺀 다음에 그 결과가 3이상이면
        //3의 배수로 만들 수 있다
        //첫번째 3의 배수 고르기
        for (int j=0;j<n/3;j++){
            sum=j*3;
            for (int k=1;k<n/3;k++){
                int tempSum = sum+k*3;
                if(n-tempSum>=3){
                    count++;
                }
            }
        }
    }
}
