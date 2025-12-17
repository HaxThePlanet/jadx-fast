package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.m0;

/* loaded from: classes2.dex */
public final class s {

    private final SparseArray<m0> a;
    public s() {
        super();
        SparseArray sparseArray = new SparseArray();
        this.a = sparseArray;
    }

    public m0 a(int i) {
        Object m0Var;
        SparseArray sparseArray;
        if ((m0)this.a.get(i) == null) {
            m0Var = new m0(9223372036854775806L, obj2);
            this.a.put(i, m0Var);
        }
        return m0Var;
    }

    public void b() {
        this.a.clear();
    }
}
