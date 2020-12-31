package 设计模式.适配器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午2:43
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 什么也不做
    }

}
