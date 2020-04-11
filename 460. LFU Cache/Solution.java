class LFUCache {
    class Node {
        int key;
        int value;
        int cnt;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int len;

        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len --;
            map.remove(node.key);
        }

        public void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            map.put(node.key, node);
            len ++;
        }

        public void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freq;
    int size, capacity;
    int maxFreq;

    public LFUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        freq = new HashMap<Integer, DLList>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int prevCnt = node.cnt;
        DLList prevList = freq.get(prevCnt);
        prevList.remove(node);
        int curCnt = prevCnt + 1;
        maxFreq = Math.max(maxFreq, curCnt);
        DLList curList = freq.getOrDefault(curCnt, new DLList());
        node.cnt ++;
        curList.addHead(node);
        freq.put(prevCnt, prevList);
        freq.put(curCnt, curList);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.get(key) != null) {
            map.get(key).value = value;
            get(key); // 让他的freq升1
            return;
        }

        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        size ++;

        if (size > capacity) {
            if (curList.len > 1) curList.removeTail();
            else {
                for (int i = 2; i <= maxFreq; i ++) {
                    if (freq.containsKey(i) && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size --;
        }

        freq.put(1, curList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */