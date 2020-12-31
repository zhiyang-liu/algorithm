package 设计模式.适配器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:44
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // 什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }

}
