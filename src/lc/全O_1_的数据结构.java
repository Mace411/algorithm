package lc;

import java.util.HashMap;

/**
 * O(1) 的时间复杂度实现所有操作
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 */
public class 全O_1_的数据结构 {

    /**
     * 十字链表
     */
    private class Node {
        /**
         * 左右前后节点
         */
        Node pre, next, up, down;
        /**
         * 节点的值
         */
        int value;
    }

    private HashMap<String, Node> map = new HashMap<>();

    /**
     * 十字链表中横向的第一个元素
     */
    private Node first;
    /**
     * 十字链表中横向的最后一个元素
     */
    private Node last;

    /**
     * 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
     * @param key
     */
    public void inc(String key) {
        Node node = map.get(key);
        //为空就插入
        if (node == null) {
            node = new Node();
            if (map.isEmpty()) {
                //如果是第一个元素，那么就既是first，又是last
                node.value = 1;
                first = node;
                last = node;
            } else {
                //因为值最小就是1了，那么就看最后一个元素的值是不是比1大
                if (last.value > 1) {
                    //添加到last的右边
                    last.next = node;
                    node.pre = last;
                    last = node;
                } else {
                    //添加到last的下面
                    node.up = last;
                    node.down = last.down;
                    if (last.down != null) {
                        last.down.up = node;
                    }
                    node.pre = last.pre;
                    node.next = last.next;
                }
            }
            map.put(key, node);
        } else {
            //不为空+1
            ++node.value;
            //看前面的元素的值大小
            //如果前面没有元素，那就把这个元素作为first
            if (node.pre == null) {
                first = node;
                //这里分几种情况
                //node的左右都没有元素，那么选取他的up或down作为他的next
                if (node.next == null) {
                    Node next = null;
                    if (node.up != null) {
                        next = node.up;
                        node.up.pre = node;
                    }
                    node.next = next;
                }

            }
            if (node.pre.value == node.value) {
                //相等，则插入前一个元素的纵向链表里
            }
        }
    }

}
