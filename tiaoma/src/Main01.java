import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main01 {
    //跳马问题
    //BFS +算法
    //八行两列的马步。
    static int[][] ma = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        //ab,初始坐标。cd终点坐标。
        tiaoma(a, b, c, d);
    }

    static void tiaoma(int a, int b,int c, int d){
        //初始化队列
        Deque<int[]> B = new LinkedList<>();
        B.offer(new int[]{a,b});


        //计数器
        int cout = 0;
        int incout =0;

        //第0步
        if (a == c && c == d) {
            System.out.println(cout);
            return;
        }

        //第n步
        while (true)
        {
            for(int[] i : ma) {
                //临时数组
                int[] at = new int[2];
                at[0] = B.getFirst()[0]+i[0];
                at[1] = B.getFirst()[1]+i[1];

                //如果是目标值，就直接返回
                if(Arrays.toString(at).equals(Arrays.toString(new int[]{c, d}) )){
                    System.out.println(cout+1);
                    return;
                }

                //不是就存入.并且内部计数器+1
                B.offer(at);
                incout+=1;

                //如果存入的数据够了，就让外部计数器+1
                if (Math.pow(8,cout+1)==incout){
                    cout+=1;
                }


            }  //循环一次之后，新八值就找到了，那么可以弹栈了
            B.pollFirst();
        }




    }
}
