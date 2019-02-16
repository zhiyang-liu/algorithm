package 栈和队列;

import java.util.Scanner;

/**
 * 汉诺塔问题
 *
 * 从左到右有A、B、C三根柱子，其中A柱子上面有从小叠到大的n个圆盘，
 * 现要求将A柱子上的圆盘移到C柱子上去，期间只有一个原则：
 * 一次只能移到一个盘子且大盘子不能在小盘子上面，求移动的步骤和移动的次数
 */
public class HanoiImpl {

    //p1为初始盘，p3为目标盘
    public static void solve(int n, int p1, int p2, int p3) {
        if (n == 1)
            System.out.println("从" + p1 + "移动到" + p3);
        else {
            solve(n - 1, p1, p3, p2);//先将1柱子上的n-1个盘子借助3移动到2
            System.out.println("从" + p1 + "移动到" + p3);//还没有移动结束，还要将1柱子上的最后一个盘子（第n个）盘子直接移动到3
            solve(n-1, p2, p1, p3);//最后将2柱子上的n-1个盘子借助1移动到3
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n,1,2,3);
    }

}
