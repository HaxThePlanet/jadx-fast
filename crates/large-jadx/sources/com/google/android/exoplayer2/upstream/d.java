package com.google.android.exoplayer2.upstream;

import com.google.common.base.o;

/* loaded from: classes2.dex */
public final class d implements o {

    public static final com.google.android.exoplayer2.upstream.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // com.google.common.base.o
    public final boolean apply(Object object) {
        return HttpDataSource.b((String)object);
    }
}
