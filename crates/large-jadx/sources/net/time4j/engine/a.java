package net.time4j.engine;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class a<U extends net.time4j.engine.v>  implements net.time4j.engine.j0<U> {
    @Override // net.time4j.engine.j0
    public boolean isEmpty() {
        int i2;
        int cmp;
        int i;
        List list = c();
        final int i4 = 0;
        i2 = i4;
        while (i2 < list.size()) {
            i2++;
        }
        return 1;
    }
}
