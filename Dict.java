import java.util.Arrays;

public class Dict {

    private int size = 3;
    private int filled = 0;
    private Item[] arr;

    public Dict() {
        arr = new Item[size];
    }
    public Dict(int size) {
        this.size = size;
        arr = new Item[size];
    }

    public void put(String key, int value) {
        if (((double) size) / filled > 0.75) {
            size *= 2;
            Item[] newArr = new Item[size];
            Arrays.fill(newArr, null);
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[hash(key)] = new Item(key, value);
        filled++;
    }

    public String get(String key) {
        Item res = arr[hash(key)];
        return res == null ? "" : Integer.toString(res.value());
    }

    private int hash(String key) {
        int tempSize = size;
        int i = key.charAt(0) * 43 + key.charAt(key.length() / 2) * 43 * 43;
        while (tempSize >= 3) {
            int init = i % tempSize;
            while (arr[init] != null) {
                if (arr[init].key().equals(key)) {
                    return init;
                }
                init = (init + 1) % size;
            }
            tempSize /= 2;
        }
        return i % size;
    }
}
