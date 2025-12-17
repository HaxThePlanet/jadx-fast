package androidx.core.content.res;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
final class GrowingArrayUtils {
    public static int[] append(int[] array, int currentSize, int element) {
        int iArr;
        int length;
        Object obj2;
        if (currentSize + 1 > array.length) {
            iArr = new int[GrowingArrayUtils.growSize(currentSize)];
            length = 0;
            System.arraycopy(array, length, iArr, length, currentSize);
            obj2 = iArr;
        }
        obj2[currentSize] = element;
        return obj2;
    }

    public static long[] append(long[] array, int currentSize, long element) {
        int lArr;
        int length;
        Object obj2;
        if (currentSize + 1 > array.length) {
            lArr = new long[GrowingArrayUtils.growSize(currentSize)];
            length = 0;
            System.arraycopy(array, length, lArr, length, currentSize);
            obj2 = lArr;
        }
        obj2[currentSize] = element;
        return obj2;
    }

    public static <T> T[] append(T[] tArr, int currentSize, T t3) {
        int instance;
        int length;
        Object obj2;
        if (currentSize + 1 > tArr.length) {
            instance = Array.newInstance(tArr.getClass().getComponentType(), GrowingArrayUtils.growSize(currentSize));
            length = 0;
            System.arraycopy(tArr, length, (Object[])instance, length, currentSize);
            obj2 = instance;
        }
        obj2[currentSize] = t3;
        return obj2;
    }

    public static boolean[] append(boolean[] array, int currentSize, boolean element) {
        int zArr;
        int length;
        Object obj2;
        if (currentSize + 1 > array.length) {
            zArr = new boolean[GrowingArrayUtils.growSize(currentSize)];
            length = 0;
            System.arraycopy(array, length, zArr, length, currentSize);
            obj2 = zArr;
        }
        obj2[currentSize] = element;
        return obj2;
    }

    public static int growSize(int currentSize) {
        int i;
        i = currentSize <= 4 ? 8 : currentSize * 2;
        return i;
    }

    public static int[] insert(int[] array, int currentSize, int index, int element) {
        if (currentSize + 1 <= array.length) {
            System.arraycopy(array, index, array, index + 1, currentSize - index);
            array[index] = element;
            return array;
        }
        int[] iArr = new int[GrowingArrayUtils.growSize(currentSize)];
        int i4 = 0;
        System.arraycopy(array, i4, iArr, i4, index);
        iArr[index] = element;
        System.arraycopy(array, index, iArr, index + 1, length2 -= index);
        return iArr;
    }

    public static long[] insert(long[] array, int currentSize, int index, long element) {
        if (currentSize + 1 <= array.length) {
            System.arraycopy(array, index, array, index + 1, currentSize - index);
            array[index] = element;
            return array;
        }
        long[] lArr = new long[GrowingArrayUtils.growSize(currentSize)];
        int i4 = 0;
        System.arraycopy(array, i4, lArr, i4, index);
        lArr[index] = element;
        System.arraycopy(array, index, lArr, index + 1, length2 -= index);
        return lArr;
    }

    public static <T> T[] insert(T[] tArr, int currentSize, int index, T t4) {
        if (currentSize + 1 <= tArr.length) {
            System.arraycopy(tArr, index, tArr, index + 1, currentSize - index);
            tArr[index] = t4;
            return tArr;
        }
        Object instance = Array.newInstance(tArr.getClass().getComponentType(), GrowingArrayUtils.growSize(currentSize));
        int i4 = 0;
        System.arraycopy(tArr, i4, (Object[])instance, i4, index);
        instance[index] = t4;
        System.arraycopy(tArr, index, instance, index + 1, length2 -= index);
        return instance;
    }

    public static boolean[] insert(boolean[] array, int currentSize, int index, boolean element) {
        if (currentSize + 1 <= array.length) {
            System.arraycopy(array, index, array, index + 1, currentSize - index);
            array[index] = element;
            return array;
        }
        boolean[] zArr = new boolean[GrowingArrayUtils.growSize(currentSize)];
        int i4 = 0;
        System.arraycopy(array, i4, zArr, i4, index);
        zArr[index] = element;
        System.arraycopy(array, index, zArr, index + 1, length2 -= index);
        return zArr;
    }
}
