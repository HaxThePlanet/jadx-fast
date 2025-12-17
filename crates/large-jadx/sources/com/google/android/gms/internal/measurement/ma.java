package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class ma extends com.google.android.gms.internal.measurement.ta {
    ma(int i) {
        super(i, 0);
    }

    @Override // com.google.android.gms.internal.measurement.ta
    public final void a() {
        boolean iterator;
        int i;
        boolean next2;
        int next;
        boolean unmodifiableList;
        if (!k()) {
            i = 0;
            while (i < c()) {
                next2 = h(i);
                if ((n8)next2.getKey().zzc()) {
                }
                i++;
                next2.setValue(Collections.unmodifiableList((List)next2.getValue()));
            }
            iterator = d().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((n8)(Map.Entry)next.getKey().zzc()) {
                }
                next.setValue(Collections.unmodifiableList((List)next.getValue()));
            }
        }
        super.a();
    }
}
