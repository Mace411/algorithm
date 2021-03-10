package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class Collection2<V> {

    private ArrayList<V> list = new ArrayList<>();

    private HashMap<V, HashSet<Integer>> map = new HashMap<>();

//    /**
//     * 构造方法，初始化数据
//     */
//    public Collection2() {
//
//    }

    /**
     * O(1)插入元素，可以重复
     *
     * @param val
     * @return
     */
    public boolean insert(V val) {
        list.add(val);
        HashSet<Integer> set = map.computeIfAbsent(val, k -> new HashSet<>());
        return set.add(list.size() - 1);
    }

    /**
     * O(1)删除元素
     *
     * @param val
     * @return
     */
    public boolean remove(V val) {
        HashSet<Integer> set = map.get(val);
        if (set == null) {
            return false;
        }
        Integer index = set.iterator().next();
        V v = removeIndex(index);
        set.remove(index);
        if (set.isEmpty()) {
            map.remove(v);
        }
        return true;
    }

    /***
     * 数组中删除指定index的元素
     * @param index
     * @return 被删掉的元素
     */
    private V removeIndex(int index) {
        V finalV = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return list.set(index, finalV);
    }

    /**
     * O(1)获取随机元素
     * @return
     */
    public V getRandom() {
        int size = list.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return list.get(index);
    }
}
