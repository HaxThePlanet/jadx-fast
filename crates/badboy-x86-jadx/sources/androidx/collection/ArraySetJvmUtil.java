package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
class ArraySetJvmUtil {
    static <T> T[] resizeForToArray(T[] tArr, int size) {
        int length;
        if (tArr.length < size) {
            return (Object[])Array.newInstance(tArr.getClass().getComponentType(), size);
        }
        if (tArr.length > size) {
            tArr[size] = 0;
        }
        return tArr;
    }
}
