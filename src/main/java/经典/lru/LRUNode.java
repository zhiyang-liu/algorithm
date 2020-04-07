package 经典.lru;

/**
 * Created by liuzhiyang on 2020/4/7 下午6:27
 */
public class LRUNode {

    String key;

    Object value;

    LRUNode prev;

    LRUNode next;

    public LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }

}
