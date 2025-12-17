package androidx.core.content.e;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class e {
    public static int[] a(int[] iArr, int i2, int i3) {
        int iArr2;
        int length;
        Object obj2;
        if (i2 + 1 > iArr.length) {
            iArr2 = new int[e.c(i2)];
            length = 0;
            System.arraycopy(iArr, length, iArr2, length, i2);
            obj2 = iArr2;
        }
        obj2[i2] = i3;
        return obj2;
    }

    public static <T> T[] b(T[] tArr, int i2, T t3) {
        int instance;
        int length;
        Object obj2;
        if (i2 + 1 > tArr.length) {
            instance = Array.newInstance(tArr.getClass().getComponentType(), e.c(i2));
            length = 0;
            System.arraycopy(tArr, length, (Object[])instance, length, i2);
            obj2 = instance;
        }
        obj2[i2] = t3;
        return obj2;
    }

    public static int c(int i) {
        int obj1;
        obj1 = i <= 4 ? 8 : i * 2;
        return obj1;
    }
}
