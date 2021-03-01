package 经典;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhiyang on 2021/3/1 下午3:21
 */
public class FileStatic {

    public Map<String, Integer> getUserNum(String fileName) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String tempStr;
        while ((tempStr = br.readLine()) != null) {
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/liuzhiyang/Desktop/test/user.txt";
        Map<String, Integer> userNum = new FileStatic().getUserNum(fileName);
        System.out.println(userNum.toString());
    }

}
