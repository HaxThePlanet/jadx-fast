package com.squareup.moshi.v;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.i.b;
import com.squareup.moshi.o;

/* compiled from: NullSafeJsonAdapter.java */
/* loaded from: classes2.dex */
public final class a<T> extends f<T> {

    private final f<T> a;
    public a(f<T> fVar) {
        super();
        this.a = fVar;
    }

    @Override // com.squareup.moshi.f
    public T b(i iVar) {
        if (iVar.E() == i.b.NULL) {
            return iVar.r();
        }
        return this.a.b(iVar);
    }

    @Override // com.squareup.moshi.f
    public void i(o oVar, T t) {
        if (t == null) {
            oVar.n();
        } else {
            this.a.i(oVar, t);
        }
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ".nullSafe()";
        str = this.a + str2;
        return str;
    }
}
