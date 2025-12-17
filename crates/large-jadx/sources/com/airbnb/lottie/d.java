package com.airbnb.lottie;

import android.graphics.Rect;
import com.airbnb.lottie.v.c;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.h;
import com.airbnb.lottie.v.l.d;
import com.airbnb.lottie.y.d;
import d.e.d;
import d.e.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    private final com.airbnb.lottie.n a;
    private final HashSet<String> b;
    private Map<String, List<d>> c;
    private Map<String, com.airbnb.lottie.g> d;
    private Map<String, c> e;
    private List<h> f;
    private h<d> g;
    private d<d> h;
    private List<d> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o = 0;
    public d() {
        super();
        n nVar = new n();
        this.a = nVar;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        int i = 0;
    }

    public void a(String string) {
        d.c(string);
        this.b.add(string);
    }

    public Rect b() {
        return this.j;
    }

    public h<d> c() {
        return this.g;
    }

    public float d() {
        return (float)l;
    }

    public float e() {
        return f -= f2;
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

    public Map<String, com.airbnb.lottie.g> i() {
        return this.d;
    }

    public List<d> j() {
        return this.i;
    }

    public h k(String string) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < this.f.size()) {
            obj = this.f.get(i);
            i++;
        }
        return null;
    }

    public int l() {
        return this.o;
    }

    public com.airbnb.lottie.n m() {
        return this.a;
    }

    public List<d> n(String string) {
        return (List)this.c.get(string);
    }

    public float o() {
        return this.k;
    }

    public boolean p() {
        return this.n;
    }

    public void q(int i) {
        this.o = i2 += i;
    }

    public void r(Rect rect, float f2, float f3, float f4, List<d> list5, d<d> d6, Map<String, List<d>> map7, Map<String, com.airbnb.lottie.g> map8, h<d> h9, Map<String, c> map10, List<h> list11) {
        this.j = rect;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.i = list5;
        this.h = d6;
        this.c = map7;
        this.d = map8;
        this.g = h9;
        this.e = map10;
        this.f = list11;
    }

    public d s(long l) {
        return (d)this.h.f(l);
    }

    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        Iterator iterator = this.i.iterator();
        for (d next2 : iterator) {
            stringBuilder.append(next2.w("\t"));
        }
        return stringBuilder.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
