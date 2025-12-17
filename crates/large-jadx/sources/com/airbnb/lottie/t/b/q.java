package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.k.o;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import java.util.List;

/* loaded from: classes.dex */
public class q implements com.airbnb.lottie.t.b.m, a.b {

    private final Path a;
    private final boolean b;
    private final f c;
    private final a<?, Path> d;
    private boolean e;
    private com.airbnb.lottie.t.b.b f;
    public q(f f, a a2, o o3) {
        super();
        Path path = new Path();
        this.a = path;
        b bVar = new b();
        this.f = bVar;
        o3.b();
        this.b = o3.d();
        this.c = f;
        a obj2 = o3.c().j();
        this.d = obj2;
        a2.i(obj2);
        obj2.a(this);
    }

    private void c() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.m
    public void a() {
        c();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        Object obj;
        boolean z;
        q.a sIMULTANEOUSLY;
        int obj5;
        obj5 = 0;
        while (obj5 < list.size()) {
            obj = list.get(obj5);
            if (obj instanceof s && (s)(c)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            obj5++;
            if ((s)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            this.f.a(obj);
            obj.c(this);
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        final int i = 1;
        if (this.b) {
            this.e = i;
            return this.a;
        }
        this.a.set((Path)this.d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f.b(this.a);
        this.e = i;
        return this.a;
    }
}
