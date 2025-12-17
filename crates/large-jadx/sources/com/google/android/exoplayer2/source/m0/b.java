package com.google.android.exoplayer2.source.m0;

import android.net.Uri;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class b implements Loader.e {

    public final long a;
    public final n b;
    public final int c;
    public final i1 d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final z i;
    public b(l l, n n2, int i3, i1 i14, int i5, Object object6, long l7, long l8) {
        super();
        z zVar = new z(l);
        this.i = zVar;
        g.e(n2);
        this.b = (n)n2;
        this.c = i3;
        this.d = i14;
        this.e = i5;
        this.f = object6;
        this.g = l7;
        this.h = obj10;
        this.a = s.a();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public final long c() {
        return this.i.n();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public final long d() {
        return l -= l2;
    }

    public final Map<String, List<String>> e() {
        return this.i.p();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public final Uri f() {
        return this.i.o();
    }
}
