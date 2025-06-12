import java.util.*;

public class Tm {
    //棋盘大小
    private static int N=8;
    private static int M=9;
    //坐标
    private static int x=0;
    private static int y=0;
    //方向
    private static int D=0;
    //走法数
    private static int count = 0;
    //栈
    private static List<Map<String,Integer>> s = new ArrayList<>();
    public static void main(String[] args) {
        while (s.size()>0||D<4){
            if(D<4){
                push();
                zou();
                if(x>N||y>M||x<0||y<0){
                    pop();
                    D++;
                }else{
                    if(x==N&&y==M){
                        count++;
                        System.out.println(s);
                    }else{
                        D=0;
                    }
                }
            }else {
                pop();
                D++;
            }
        }
        System.out.println(count);

    }

    public static void pop() {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map = s.remove(s.size() - 1);
        x=map.get("x");
        y=map.get("y");
        D=map.get("D");
    }

    public static void push(){
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("x",x);
        map.put("y",y);
        map.put("D",D);
        s.add(map);
    }

    public static void zou (){
        switch (D){
            case 0:{
                x+=1;
                y+=2;
                break;
            }
            case 1:{
                x+=2;
                y+=1;
                break;
            }
            case 2:{
                x+=2;
                y-=1;
                break;
            }
            case 3:{
                x+=1;
                y-=2;
                break;
            }
        }
    }
}
