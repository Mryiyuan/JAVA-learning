public class TowerOfHanoi {
    private static int sum = 0;

    public static void main(String[] args) {
        f(6,'1','2','3');
        System.out.println(sum);

    }

    //n 几层塔
    //A 塔1
    //B 塔2
    //C 塔3
    public static void f(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("move:" + A + "->" + C);
            sum++;
            return;
        }
        f(n - 1, A, C, B);//把A塔上编号1~n-1的块移动到B上，以C为中介
        f(1, A, B, C);//把A塔上编号n的块移动到C上
        f(n - 1, B, A, C);//把B塔上编号1~n-1的块移动到C上，以A为中介
    }
}
