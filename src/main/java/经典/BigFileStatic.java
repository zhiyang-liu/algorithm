package 经典;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuzhiyang on 2021/3/1 下午3:48
 */
public class BigFileStatic {

    private String fileName = "/Users/liuzhiyang/Desktop/test/user.txt";

    private int FILE_CNT = 10;

    Map<String, Integer> map = new ConcurrentHashMap<>();

    public void hashToSmallFiles() throws IOException {
        HashMap<String, FileWriter> fileWriters = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String tempStr;

        while ((tempStr = br.readLine()) != null) {
            int tmp = Math.abs(tempStr.hashCode() % FILE_CNT);
            String tempFileName = fileName + tmp + ".txt";
            FileWriter fw;
            if (fileWriters.containsKey(tempFileName)) {
                fw = fileWriters.get(tempFileName);
            } else {
                fw = new FileWriter(tempFileName, true);
                fileWriters.put(tempFileName, fw);
            }
            fw.write(tempStr + "\n");
        }

        br.close();
        for (FileWriter ff : fileWriters.values()) {
            ff.close();
        }
    }

    public class MyThread extends Thread {

        private int index;

        public MyThread(int index){
            this.index = index;
        }

        @Override
        public void run() {
            File file = new File(fileName + index + ".txt");
            if (! file.exists()) {
                return;
            }

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String tempStr;
                while ((tempStr = br.readLine()) != null) {
                    map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public Map<String, Integer> countEverySmallFile() throws InterruptedException {
        Thread[] thread = new Thread[FILE_CNT];
        for (int i = 0; i < FILE_CNT; i++) {
            thread[i] = new Thread(new BigFileStatic.MyThread(i));
        }
        for (int i = 0; i < FILE_CNT; i++) {
            thread[i].start();
        }
        for (int i = 0; i < FILE_CNT; i++) {
            thread[i].join();
        }

        return map;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BigFileStatic bigFileStatic = new BigFileStatic();
//        bigFileStatic.hashToSmallFiles();
        Map<String, Integer> map = bigFileStatic.countEverySmallFile();
        System.out.println(map.toString());

    }

}
