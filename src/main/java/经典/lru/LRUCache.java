package 经典.lru;

import java.util.HashMap;

/**
 * Created by liuzhiyang on 2020/4/7 下午6:27
 */
public class LRUCache {

    private HashMap<String, LRUNode> map;

    private int capacity;

    private LRUNode head;

    private LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    /**
     * 设置元素，存在的话修改然后设置为头节点；不存在新建节点，（容量满的话删除尾节点同时从链表移除）加入链表设置为头节点
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        LRUNode node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
        } else {
            node = new LRUNode(key, value);
            if (map.size() >= capacity) {
                // 每次容量不足时先删除最久未使用的元素
                remove(tail);
                map.remove(tail.key);
            }
            map.put(key, node);
        }
        // 将刚添加的元素设置为head
        setHead(node);
    }

    /**
     * 获取元素，存在需要从链表移除并设为头节点；不存在返回null
     * @param key
     * @return
     */
    public Object get(String key) {
        LRUNode node = map.get(key);
        if (node != null) {
            // 将刚操作的元素放到head
            remove(node);
            setHead(node);
            return node.value;
        }
        return null;
    }

    // 设置头节点，要考虑尾节点为空的情况
    private void setHead(LRUNode node) {
        // 先从链表中删除该元素
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    // 从链表中删除此Node，此时要注意该Node是head或者是tail的情形
    private void remove(LRUNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

}
