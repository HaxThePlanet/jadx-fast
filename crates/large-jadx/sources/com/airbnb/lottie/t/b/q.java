package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.k.o;
import com.airbnb.lottie.v.k.q.a;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class q implements m, a.b {

    private final Path a = new Path();
    private final boolean b;
    private final f c;
    private final com.airbnb.lottie.t.c.a<?, Path> d;
    private boolean e;
    private b f = new b();
    public q(f fVar, com.airbnb.lottie.v.l.a aVar, o oVar) {
        super();
        Path path = new Path();
        com.airbnb.lottie.t.b.b bVar = new b();
        oVar.b();
        this.b = oVar.d();
        this.c = fVar;
        com.airbnb.lottie.t.c.a aVar2 = oVar.c().j();
        this.d = aVar2;
        aVar.i(aVar2);
        aVar2.a(this);
    }

    private void c() {
        this.e = false;
        this.c.invalidateSelf();
    }

    public void a() {
        c();
    }

    public void b(List<c> list, List<c> list2) {
        boolean z;
        q.a sIMULTANEOUSLY2;
        int i = 0;
        i = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            z = item instanceof s;
            i = i + 1;
        }
    }

    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        final boolean z3 = true;
        if (this.b) {
            this.e = z3;
            return this.a;
        }
        this.a.set((Path)this.d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f.b(this.a);
        this.e = z3;
        return this.a;
    }
}
