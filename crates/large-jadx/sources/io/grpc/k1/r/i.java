package io.grpc.k1.r;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Util.java */
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

    private static <T> List<T> b(T[] tArr, T[] tArr2) {
        int i;
        Object obj2;
        boolean equals;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : tArr) {
            length = tArr2.length;
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    break loop_3;
                }
            }
            obj2 = tArr2[i];
        }
        return arrayList;
    }

    public static <T> T[] c(Class<T> cls, T[] tArr, T[] tArr2) {
        final List list = i.b(tArr, tArr2);
        return list.toArray((Object[])Array.newInstance(cls, list.size()));
    }
}
