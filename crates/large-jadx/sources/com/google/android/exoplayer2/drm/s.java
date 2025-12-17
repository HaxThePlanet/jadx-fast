package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m1.e;
import com.google.android.exoplayer2.upstream.HttpDataSource.a;
import com.google.android.exoplayer2.upstream.s.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import f.c.c.b.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s implements com.google.android.exoplayer2.drm.w {

    private final Object a;
    private m1.e b;
    private com.google.android.exoplayer2.drm.v c;
    private HttpDataSource.a d;
    private String e;
    public s() {
        super();
        Object object = new Object();
        this.a = object;
    }

    private com.google.android.exoplayer2.drm.v b(m1.e m1$e) {
        HttpDataSource.a bVar;
        String str;
        String string;
        boolean key;
        if (this.d != null) {
        } else {
            bVar = new s.b();
            bVar.d(this.e);
        }
        Uri uri = e.b;
        if (uri == null) {
            string = 0;
        } else {
            string = uri.toString();
        }
        e0 e0Var = new e0(string, e.f, bVar);
        Iterator iterator = e.c.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            e0Var.e((String)next2.getKey(), (String)next2.getValue());
        }
        DefaultDrmSessionManager.b bVar2 = new DefaultDrmSessionManager.b();
        bVar2.e(e.a, d0.d);
        bVar2.b(e.d);
        bVar2.c(e.e);
        bVar2.d(b.k(e.g));
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager = bVar2.a(e0Var);
        defaultDrmSessionManager.F(0, e.a());
        return defaultDrmSessionManager;
    }

    @Override // com.google.android.exoplayer2.drm.w
    public com.google.android.exoplayer2.drm.v a(m1 m1) {
        com.google.android.exoplayer2.m1.g gVar;
        int i;
        Object obj3;
        g.e(m1.b);
        obj3 = obj3.c;
        if (obj3 != null) {
            if (p0.a < 18) {
            } else {
                Object obj = this.a;
                synchronized (obj) {
                    this.b = obj3;
                    this.c = b(obj3);
                }
            }
        }
        return v.a;
    }
}
