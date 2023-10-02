class ArrayUtil {
    public static int[] concat(int[] a, int[] b) {
        int[] tmp = new int[a.length + b.length];
        for (int i = 0; i < tmp.length; i++) {
            if (i < a.length)
                tmp[i] = a[i];
            else
                tmp[i] = b[i - a.length];
        }
        return tmp;
    }

    public static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print(" ]");
    }
}

public class ch4_9 {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 7, 9};
        int[] a2 = {3, 6, -1, 100, 77};
        int[] a3 = ArrayUtil.concat(a1, a2);
        ArrayUtil.print(a3);
    }
}
