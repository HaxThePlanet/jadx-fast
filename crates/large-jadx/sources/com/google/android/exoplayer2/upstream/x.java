package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class x<T>  implements com.google.android.exoplayer2.upstream.Loader.e {

    public final long a;
    public final com.google.android.exoplayer2.upstream.n b;
    public final int c;
    private final com.google.android.exoplayer2.upstream.z d;
    private final com.google.android.exoplayer2.upstream.x.a<? extends T> e;
    private volatile T f;

    public interface a {
        public abstract T a(Uri uri, InputStream inputStream2);
    }
    public x(com.google.android.exoplayer2.upstream.l l, Uri uri2, int i3, com.google.android.exoplayer2.upstream.x.a<? extends T> x$a4) {
        n.b bVar = new n.b();
        bVar.i(uri2);
        bVar.b(1);
        super(l, bVar.a(), i3, a4);
    }

    public x(com.google.android.exoplayer2.upstream.l l, com.google.android.exoplayer2.upstream.n n2, int i3, com.google.android.exoplayer2.upstream.x.a<? extends T> x$a4) {
        super();
        z zVar = new z(l);
        this.d = zVar;
        this.b = n2;
        this.c = i3;
        this.e = a4;
        this.a = s.a();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public final void a() {
        this.d.q();
        m mVar = new m(this.d, this.b);
        mVar.c();
        Uri uri = this.d.l();
        g.e(uri);
        this.f = this.e.a((Uri)uri, mVar);
        p0.m(mVar);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public final void b() {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public long c() {
        return this.d.n();
    }

    public Map<String, List<String>> d() {
        return this.d.p();
    }

    public final T e() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$e
    public Uri f() {
        return this.d.o();
    }
}
