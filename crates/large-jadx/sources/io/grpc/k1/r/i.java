package io.grpc.k1.r;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class i {

    public static final String[] a;
    public static final Charset b;
    static {
        i.a = new String[0];
        i.b = Charset.forName("UTF-8");
    }

    public static <T> List<T> a(T[] tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[])tArr.clone()));
    }

    private static <T> List<T> b(T[] tArr, T[] t2Arr2) {
        int i2;
        Object obj;
        int length;
        int i;
        Object obj2;
        boolean equals;
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        i2 = i3;
        while (i2 < tArr.length) {
            i = i3;
            while (i < t2Arr2.length) {
                obj2 = t2Arr2[i];
                if (tArr[i2].equals(obj2)) {
                    break loop_3;
                } else {
                }
                i++;
            }
            i2++;
            obj2 = t2Arr2[i];
            if (obj.equals(obj2)) {
            } else {
            }
            i++;
            arrayList.add(obj2);
        }
        return arrayList;
    }

    public static <T> T[] c(Class<T> class, T[] t2Arr2, T[] t3Arr3) {
        final List obj1 = i.b(t2Arr2, t3Arr3);
        return obj1.toArray((Object[])Array.newInstance(class, obj1.size()));
    }
}
