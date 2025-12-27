package com.airbnb.lottie;

import android.graphics.Rect;
import com.airbnb.lottie.v.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class d {

    private final n a = new n();
    private final HashSet<String> b = new HashSet<>();
    private Map<String, List<com.airbnb.lottie.v.l.d>> c;
    private Map<String, g> d;
    private Map<String, c> e;
    private List<com.airbnb.lottie.v.h> f;
    private d.e.h<com.airbnb.lottie.v.d> g;
    private d.e.d<com.airbnb.lottie.v.l.d> h;
    private List<com.airbnb.lottie.v.l.d> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o = 0;
    public d() {
        super();
        com.airbnb.lottie.n nVar = new n();
        HashSet hashSet = new HashSet();
    }

    public void a(String str) {
        d.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public d.e.h<com.airbnb.lottie.v.d> c() {
        return this.g;
    }

    public float d() {
        float f = (e() / this.m) * 1000f;
        return f;
    }

    public float e() {
        return this.l - this.k;
    }

    public float f() {
        return this.l;
    }

    public Map<String, c> g() {
        return this.e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, g> i() {
        return this.d;
    }

    public List<com.airbnb.lottie.v.l.d> j() {
        return this.i;
    }

    public com.airbnb.lottie.v.h k(String str) {
        int i = 0;
        i = 0;
        while (i < this.f.size()) {
            Object item = this.f.get(i);
            if (item.a(str)) {
                return item;
            }
        }
        return null;
    }

    public int l() {
        return this.o;
    }

    public n m() {
        return this.a;
    }

    public List<com.airbnb.lottie.v.l.d> n(String str) {
        return (List)this.c.get(str);
    }

    public float o() {
        return this.k;
    }

    public boolean p() {
        return this.n;
    }

    public void q(int i) {
        this.o += i;
    }

    public void r(Rect rect, float f, float f2, float f3, List<com.airbnb.lottie.v.l.d> list, d.e.d<com.airbnb.lottie.v.l.d> dVar, Map<String, List<com.airbnb.lottie.v.l.d>> map, Map<String, g> map2, d.e.h<com.airbnb.lottie.v.d> hVar, Map<String, c> map3, List<com.airbnb.lottie.v.h> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = dVar;
        this.c = map;
        this.d = map2;
        this.g = hVar;
        this.e = map3;
        this.f = list2;
    }

    public com.airbnb.lottie.v.l.d s(long j) {
        return (d)this.h.f(j);
    }

    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            str2 = "\t";
            stringBuilder.append((d)it.next().w(str2));
        }
        return stringBuilder.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
