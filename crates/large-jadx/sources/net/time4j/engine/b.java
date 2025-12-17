package net.time4j.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class b<U extends net.time4j.engine.v, P extends net.time4j.engine.a<U>>  implements net.time4j.engine.h0<U, P>, Comparator<U> {

    private final List<U> a;
    private b(List<U> list, boolean z2) {
        Object obj;
        int i;
        boolean equals;
        int obj6;
        super();
        if (list.isEmpty()) {
        } else {
            Collections.sort(list, this);
            obj6 = 0;
            int size = list.size();
            while (obj6 < size) {
                obj = list.get(obj6);
                i = obj6;
                while (i < size) {
                    i++;
                }
                i++;
            }
            this.a = Collections.unmodifiableList(list);
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("Missing units.");
        throw obj5;
    }

    protected b(boolean z, U... u2Arr2) {
        super(Arrays.asList(u2Arr2), z);
    }

    public int a(U u, U u2) {
        return Double.compare(u2.getLength(), obj1);
    }

    @Override // net.time4j.engine.h0
    public int compare(Object object, Object object2) {
        return a((v)object, (v)object2);
    }
}
