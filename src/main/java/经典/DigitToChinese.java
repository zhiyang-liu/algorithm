package 经典;

/**
 * Created by liuzhiyang on 2021/2/28 下午5:58
 */
public class DigitToChinese {

    public String convert(int number) {
        // 数字对应的汉字
        String[] num = {"零", "一", "二", "三","四","五","六","七","八","九"};
        // 单位
        String[] unit = {"","十","百","千","万","十","百","千","亿","十","百","千","万亿"};

        // 将输入数字转换为字符串
        String numString = String.valueOf(number);
        // 将该字符串分割为数组存放
        char[] ch = numString.toCharArray();

        // 结果字符串
        String result = "";
        int length = ch.length;
        for (int i = 0; i < length; i++) {
            int c = ch[i] - '0';
            if (c != 0) {
                result += num[c] + unit[length - i - 1];
            } else {
                result += num[c];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DigitToChinese().convert(10109));
    }

}
