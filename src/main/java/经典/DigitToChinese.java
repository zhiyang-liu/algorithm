package 经典;

/**
 * Created by liuzhiyang on 2021/2/28 下午5:58
 */
public class DigitToChinese {

    public String intToChinese(int number) {
        String[] num = {"零", "一", "二", "三","四","五","六","七","八","九"};
        String[] unit = {"","十","百","千","万","十","百","千","亿","十","百","千","万亿"};

        char[] val = String.valueOf(number).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int n = val[i] - '0';
            boolean isZero = n == 0;
            String unitName = unit[(len - 1) - i];
            if (isZero) {
                if ((len - 1 - i) % 4 == 0) {
                    sb.append(unitName);
                }
                if (i != len - 1 && i != 0 && '0' != val[i + 1]) {
                    sb.append(num[n]);
                }
            } else {
                sb.append(num[n]);
                sb.append(unitName);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DigitToChinese().intToChinese(1000109));
    }

}
