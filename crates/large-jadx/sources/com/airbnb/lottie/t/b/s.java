package com.airbnb.lottie.t.b;

import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.k.q;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class s implements com.airbnb.lottie.t.b.c, a.b {

    private final boolean a;
    private final List<a.b> b;
    private final q.a c;
    private final a<?, Float> d;
    private final a<?, Float> e;
    private final a<?, Float> f;
    public s(a a, q q2) {
        super();
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        q2.c();
        this.a = q2.g();
        this.c = q2.f();
        a aVar2 = q2.e().j();
        this.d = aVar2;
        a aVar3 = q2.b().j();
        this.e = aVar3;
        a obj4 = q2.d().j();
        this.f = obj4;
        a.i(aVar2);
        a.i(aVar3);
        a.i(obj4);
        aVar2.a(this);
        aVar3.a(this);
        obj4.a(this);
    }

    @Override // com.airbnb.lottie.t.b.c
    public void a() {
        int i;
        Object obj;
        i = 0;
        while (i < this.b.size()) {
            (a.b)this.b.get(i).a();
            i++;
        }
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
    }

    @Override // com.airbnb.lottie.t.b.c
    void c(a.b a$b) {
        this.b.add(b);
    }

    public a<?, Float> e() {
        return this.e;
    }

    public a<?, Float> g() {
        return this.f;
    }

    public a<?, Float> h() {
        return this.d;
    }

    @Override // com.airbnb.lottie.t.b.c
    q.a i() {
        return this.c;
    }

    @Override // com.airbnb.lottie.t.b.c
    public boolean j() {
        return this.a;
    }
}
