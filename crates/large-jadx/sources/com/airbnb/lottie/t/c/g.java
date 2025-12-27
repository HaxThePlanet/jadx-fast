package com.airbnb.lottie.t.c;

import android.graphics.Path;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.v.k.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {

    private final List<a<l, Path>> a = new ArrayList<>();
    private final List<a<Integer, Integer>> b = new ArrayList<>();
    private final List<g> c;
    public g(List<g> list) {
        int i = 0;
        super();
        this.c = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        i = 0;
        while (i < list.size()) {
            this.a.add((g)list.get(i).b().j());
            this.b.add((g)list.get(i).c().j());
            i = i + 1;
        }
    }

    public List<a<l, Path>> a() {
        return this.a;
    }

    public List<g> b() {
        return this.c;
    }

    public List<a<Integer, Integer>> c() {
        return this.b;
    }
}
