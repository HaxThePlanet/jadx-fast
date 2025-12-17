package com.google.common.collect;

import com.google.common.base.n;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class j {
    static StringBuilder a(int i) {
        i.b(i, "size");
        StringBuilder stringBuilder = new StringBuilder((int)l2);
        return stringBuilder;
    }

    static boolean b(Collection<?> collection, Object object2) {
        n.o(collection);
        return collection.contains(object2);
    }
}
