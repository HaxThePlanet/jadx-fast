package com.airbnb.lottie.v.j;

import com.airbnb.lottie.z.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
abstract class n<V, O>  implements com.airbnb.lottie.v.j.m<V, O> {

    final List<a<V>> a;
    n(V v) {
        a aVar = new a(v);
        super(Collections.singletonList(aVar));
    }

    n(List<a<V>> list) {
        super();
        this.a = list;
    }

    @Override // com.airbnb.lottie.v.j.m
    public boolean i() {
        boolean empty;
        int i;
        final int i2 = 1;
        if (!this.a.isEmpty()) {
            if (this.a.size() == i2 && (a)this.a.get(0).h()) {
                if ((a)this.a.get(i).h()) {
                    i = i2;
                }
            }
        } else {
        }
        return i;
    }

    public List<a<V>> q() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.j.m
    public String toString() {
        boolean string;
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.a.isEmpty()) {
            stringBuilder.append("values=");
            stringBuilder.append(Arrays.toString(this.a.toArray()));
        }
        return stringBuilder.toString();
    }
}
