package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class f {
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> b(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    public static <T> List<T> c(T... tArr) {
        int length = tArr.length;
        if (length != 0 && length != 1) {
            if (length != 1) {
                return Collections.unmodifiableList(Arrays.asList(tArr));
            }
            return f.b(tArr[0]);
        }
        return f.a();
    }
}
