package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class Collection1<V> {

    private ArrayList<V> list = new ArrayList();

    private HashMap<V, Integer> map = new HashMap<>();

//    /**
//     * 构造方法，初始化数据
//     */
//    public Collection1() {
//
//    }

    /**
     * O(1)时间插入元素
     *
     * @param val 元素
     * @return 插入成功
     */
    public boolean insert(V val) {
        //先判断val存不存在
        if (Optional.ofNullable(map.get(val)).isPresent()) {
            return false;
        }
        int index = list.size();
        list.add(val);
        return map.put(val, index) == null;
    }

    /**
     * O(1)删除指定元素
     *
     * @param val 元素
     * @return 删除成功
     */
    public boolean remove(V val) {
        //先判断有没有这个元素
        Optional<Integer> optionalIndex = Optional.ofNullable(map.remove(val));
        if (optionalIndex.isPresent()) {
            //在数组中删除元素
            Integer index = optionalIndex.get();
            removeIndex(index);
            return true;
        }
        return false;

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
     *
     * @return
     */
    public V getRandom() {
        int size = list.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return list.get(index);
    }
}
