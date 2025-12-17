package com.squareup.moshi.v;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.i.b;
import com.squareup.moshi.o;

/* loaded from: classes2.dex */
public final class a<T>  extends f<T> {

    private final f<T> a;
    public a(f<T> f) {
        super();
        this.a = f;
    }

    public T b(i i) {
        if (i.E() == i.b.NULL) {
            return i.r();
        }
        return this.a.b(i);
    }

    public void i(o o, T t2) {
        f fVar;
        if (t2 == null) {
            o.n();
        } else {
            this.a.i(o, t2);
        }
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(".nullSafe()");
        return stringBuilder.toString();
    }
}
