package net.time4j.engine;

import java.util.List;

/* compiled from: AbstractDuration.java */
/* loaded from: classes3.dex */
public abstract class a<U extends v> implements j0<U> {
    public boolean isEmpty() {
        int i;
        List list = c();
        i = 0;
        while (i < list.size()) {
            long l2 = (j0.a)list.get(i).a();
            long l = 0L;
            if (l2 > l) {
                return false;
            }
        }
        return true;
    }
}
