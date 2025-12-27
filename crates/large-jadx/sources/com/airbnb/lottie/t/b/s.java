package com.airbnb.lottie.t.b;

import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.k.q;
import com.airbnb.lottie.v.k.q.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s implements c, a.b {

    private final boolean a;
    private final List<a.b> b = new ArrayList<>();
    private final q.a c;
    private final com.airbnb.lottie.t.c.a<?, Float> d;
    private final com.airbnb.lottie.t.c.a<?, Float> e;
    private final com.airbnb.lottie.t.c.a<?, Float> f;
    public s(com.airbnb.lottie.v.l.a aVar, q qVar) {
        super();
        ArrayList arrayList = new ArrayList();
        qVar.c();
        this.a = qVar.g();
        this.c = qVar.f();
        com.airbnb.lottie.t.c.a aVar3 = qVar.e().j();
        this.d = aVar3;
        com.airbnb.lottie.t.c.a aVar4 = qVar.b().j();
        this.e = aVar4;
        com.airbnb.lottie.t.c.a aVar5 = qVar.d().j();
        this.f = aVar5;
        aVar.i(aVar3);
        aVar.i(aVar4);
        aVar.i(aVar5);
        aVar3.a(this);
        aVar4.a(this);
        aVar5.a(this);
    }

    public void a() {
        int i = 0;
        i = 0;
        while (i < this.b.size()) {
            (a.b)this.b.get(i).a();
            i = i + 1;
        }
    }

    void c(a.b bVar) {
        this.b.add(bVar);
    }

    public com.airbnb.lottie.t.c.a<?, Float> e() {
        return this.e;
    }

    public com.airbnb.lottie.t.c.a<?, Float> g() {
        return this.f;
    }

    public com.airbnb.lottie.t.c.a<?, Float> h() {
        return this.d;
    }

    q.a i() {
        return this.c;
    }

    public boolean j() {
        return this.a;
    }

    public void b(List<c> list, List<c> list2) {
    }
}
