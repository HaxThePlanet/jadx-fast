package net.time4j.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: AbstractMetric.java */
/* loaded from: classes3.dex */
public abstract class b<U extends v, P extends a<U>> implements h0<U, P>, Comparator<U> {

    private final List<U> a;
    protected b(boolean z, U... uArr) {
        this(Arrays.asList(uArr), z);
    }

    public int a(U u, U u2) {
        return Double.compare(u2.getLength(), u.getLength());
    }

    private b(List<U> list, boolean z) {
        int z22;
        boolean equals;
        super();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing units.");
        } else {
            Collections.sort(list, this);
            z22 = 0;
            int size = list.size();
            while (z22 < size) {
                Object item = list.get(z22);
                z22 = z22 + 1;
                while (z22 < size) {
                    if (item.equals(list.get(z22))) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Duplicate unit: ";
                        z = str + item;
                        throw new IllegalArgumentException(z);
                    }
                }
                if (item.equals(list.get(z22))) {
                    stringBuilder = new StringBuilder();
                    str = "Duplicate unit: ";
                    z = str + item;
                    throw new IllegalArgumentException(z);
                }
            }
            this.a = Collections.unmodifiableList(list);
            return;
        }
    }
}
