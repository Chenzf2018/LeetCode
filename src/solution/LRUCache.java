package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode_146_LRU缓存机制
 * @author Chenzf
 * @date 2020/7/7
 * @version 1.0
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    class DoubleLinkedNode {
        int key, value;
        DoubleLinkedNode prev, next;

        public DoubleLinkedNode() {}

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * @ cache 哈希表存放缓存数据，并根据key定位对应数据在双向链表中的位置
     * @ size 双向链表的大小
     * @ capacity LRUCache的容量
     * @ head, tail 双向链表的伪头部和伪尾部
     */

    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 创建伪头部和伪尾部节点
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 如果key存在，则先通过哈希表定位，再删除结点并移至头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 根据哈希表定位数据在链表中的位置
        DoubleLinkedNode node = cache.get(key);

        // 如果结点不存在，则在链表头部创建新结点，并添加至哈希表
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            // 添加至哈希表
            cache.put(key, newNode);
            // 添加至双向链表头部
            addToHead(newNode);
            size++;

            // 如果超出容量，删除双向链表的尾部结点
            if (size > capacity) {
                DoubleLinkedNode lastNode = removeTail();
                size--;
                // 删除哈希表中对应的项
                cache.remove(lastNode.key);
            }

        } else {
            // 如果结点存在，则更新数据，并在链表中将其移至头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DoubleLinkedNode node) {
        // 先删除结点
        removeNode(node);
        // 在头部添加结点
        addToHead(node);
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DoubleLinkedNode removeTail() {
        // 找到欲删除的最后一个结点
        DoubleLinkedNode lastNode = tail.prev;
        // 删除该结点
        removeNode(lastNode);
        return lastNode;
    }
}
