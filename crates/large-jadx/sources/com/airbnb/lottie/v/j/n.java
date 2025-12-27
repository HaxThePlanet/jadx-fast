package com.airbnb.lottie.v.j;

import com.airbnb.lottie.z.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {

    final List<a<V>> a;
    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    public boolean i() {
        boolean empty;
        boolean z = false;
        final int i = 1;
        if (!this.a.isEmpty()) {
            if (this.a.size() == i) {
                if ((a)this.a.get(0).h()) {
                }
            }
        }
        return z;
    }

    public List<a<V>> q() {
        return this.a;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.a.isEmpty()) {
            stringBuilder.append("values=");
            stringBuilder.append(Arrays.toString(this.a.toArray()));
        }
        return stringBuilder.toString();
    }

    n(List<a<V>> list) {
        super();
        this.a = list;
    }
}
