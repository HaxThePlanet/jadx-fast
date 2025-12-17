package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q implements com.google.android.exoplayer2.upstream.l {

    private final Context a;
    private final List<com.google.android.exoplayer2.upstream.b0> b;
    private final com.google.android.exoplayer2.upstream.l c;
    private com.google.android.exoplayer2.upstream.l d;
    private com.google.android.exoplayer2.upstream.l e;
    private com.google.android.exoplayer2.upstream.l f;
    private com.google.android.exoplayer2.upstream.l g;
    private com.google.android.exoplayer2.upstream.l h;
    private com.google.android.exoplayer2.upstream.l i;
    private com.google.android.exoplayer2.upstream.l j;
    private com.google.android.exoplayer2.upstream.l k;
    public q(Context context, com.google.android.exoplayer2.upstream.l l2) {
        super();
        this.a = context.getApplicationContext();
        g.e(l2);
        this.c = (l)l2;
        ArrayList obj1 = new ArrayList();
        this.b = obj1;
    }

    private void n(com.google.android.exoplayer2.upstream.l l) {
        int i;
        Object obj;
        i = 0;
        while (i < this.b.size()) {
            l.d((b0)this.b.get(i));
            i++;
        }
    }

    private com.google.android.exoplayer2.upstream.l o() {
        com.google.android.exoplayer2.upstream.l assetDataSource;
        Context context;
        if (this.e == null) {
            assetDataSource = new AssetDataSource(this.a);
            this.e = assetDataSource;
            n(assetDataSource);
        }
        return this.e;
    }

    private com.google.android.exoplayer2.upstream.l p() {
        com.google.android.exoplayer2.upstream.l contentDataSource;
        Context context;
        if (this.f == null) {
            contentDataSource = new ContentDataSource(this.a);
            this.f = contentDataSource;
            n(contentDataSource);
        }
        return this.f;
    }

    private com.google.android.exoplayer2.upstream.l q() {
        com.google.android.exoplayer2.upstream.l jVar;
        if (this.i == null) {
            jVar = new j();
            this.i = jVar;
            n(jVar);
        }
        return this.i;
    }

    private com.google.android.exoplayer2.upstream.l r() {
        com.google.android.exoplayer2.upstream.l fileDataSource;
        if (this.d == null) {
            fileDataSource = new FileDataSource();
            this.d = fileDataSource;
            n(fileDataSource);
        }
        return this.d;
    }

    private com.google.android.exoplayer2.upstream.l s() {
        com.google.android.exoplayer2.upstream.l rawResourceDataSource;
        Context context;
        if (this.j == null) {
            rawResourceDataSource = new RawResourceDataSource(this.a);
            this.j = rawResourceDataSource;
            n(rawResourceDataSource);
        }
        return this.j;
    }

    private com.google.android.exoplayer2.upstream.l t() {
        Object instance;
        com.google.android.exoplayer2.upstream.l lVar;
        Object[] str;
        String str2;
        if (this.g == null) {
            int i = 0;
            instance = Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[i]).newInstance(new Object[i]);
            this.g = (l)instance;
            n(instance);
            try {
                if (this.g == null) {
                }
                this.g = this.c;
                return this.g;
            }
        }
    }

    private com.google.android.exoplayer2.upstream.l u() {
        com.google.android.exoplayer2.upstream.l udpDataSource;
        if (this.h == null) {
            udpDataSource = new UdpDataSource();
            this.h = udpDataSource;
            n(udpDataSource);
        }
        return this.h;
    }

    private void v(com.google.android.exoplayer2.upstream.l l, com.google.android.exoplayer2.upstream.b0 b02) {
        if (l != null) {
            l.d(b02);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(com.google.android.exoplayer2.upstream.n n) {
        int i;
        com.google.android.exoplayer2.upstream.l lVar;
        String startsWith;
        String scheme;
        boolean equals;
        i = this.k == null ? 1 : 0;
        g.f(i);
        scheme = n.a.getScheme();
        if (p0.i0(n.a)) {
            startsWith = n.a.getPath();
            if (startsWith != null && startsWith.startsWith("/android_asset/")) {
                if (startsWith.startsWith("/android_asset/")) {
                    this.k = o();
                } else {
                    this.k = r();
                }
            } else {
            }
        } else {
            if ("asset".equals(scheme)) {
                this.k = o();
            } else {
                if ("content".equals(scheme)) {
                    this.k = p();
                } else {
                    if ("rtmp".equals(scheme)) {
                        this.k = t();
                    } else {
                        if ("udp".equals(scheme)) {
                            this.k = u();
                        } else {
                            if ("data".equals(scheme)) {
                                this.k = q();
                            } else {
                                if (!"rawresource".equals(scheme)) {
                                    if ("android.resource".equals(scheme)) {
                                        this.k = s();
                                    } else {
                                        this.k = this.c;
                                    }
                                } else {
                                }
                            }
                        }
                    }
                }
            }
        }
        return this.k.c(n);
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        com.google.android.exoplayer2.upstream.l lVar;
        final com.google.android.exoplayer2.upstream.l lVar2 = this.k;
        if (lVar2 != null) {
            lVar2.close();
            this.k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void d(com.google.android.exoplayer2.upstream.b0 b0) {
        g.e(b0);
        this.c.d(b0);
        this.b.add(b0);
        v(this.d, b0);
        v(this.e, b0);
        v(this.f, b0);
        v(this.g, b0);
        v(this.h, b0);
        v(this.i, b0);
        v(this.j, b0);
    }

    public Map<String, List<String>> h() {
        Map emptyMap;
        com.google.android.exoplayer2.upstream.l lVar = this.k;
        if (lVar == null) {
            emptyMap = Collections.emptyMap();
        } else {
            emptyMap = lVar.h();
        }
        return emptyMap;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Uri l() {
        int i;
        com.google.android.exoplayer2.upstream.l lVar = this.k;
        if (lVar == null) {
            i = 0;
        } else {
            i = lVar.l();
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public int read(byte[] bArr, int i2, int i3) {
        final com.google.android.exoplayer2.upstream.l lVar = this.k;
        g.e(lVar);
        return (l)lVar.read(bArr, i2, i3);
    }
}
