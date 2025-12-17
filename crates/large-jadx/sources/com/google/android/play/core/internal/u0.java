package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class u0<T>  extends com.google.android.play.core.internal.v0<T[]> {
    u0(Object object, Field field2, Class<T> class3) {
        super(object, field2, Array.newInstance(class3, 0).getClass());
    }

    private final Class<T> f() {
        return b().getType().getComponentType();
    }

    public final void d(Collection<T> collection) {
        Object next;
        int length;
        int length2;
        next = a();
        final int i = 0;
        length = (Object[])next == null ? i : next.length;
        Object instance = Array.newInstance(f(), size += length);
        if ((Object[])next != null) {
            System.arraycopy((Object[])next, i, (Object[])instance, i, next.length);
        }
        final Iterator obj6 = collection.iterator();
        for (Object next : obj6) {
            instance[length] = next;
            length++;
        }
        c(instance);
    }

    public final void e(Collection<T> collection) {
        Object next;
        int i;
        int length2;
        Class size;
        int length;
        next = a();
        i = 0;
        length2 = (Object[])next == null ? i : next.length;
        Object instance = Array.newInstance(f(), length2 += length);
        if ((Object[])next != null) {
            System.arraycopy((Object[])next, i, (Object[])instance, collection.size(), next.length);
        }
        final Iterator obj6 = collection.iterator();
        for (Object next : obj6) {
            instance[i] = next;
            i++;
        }
        c(instance);
    }
}
