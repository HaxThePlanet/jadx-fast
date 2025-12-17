package com.airbnb.lottie.t.c;

import android.graphics.Path;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.v.k.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    private final List<com.airbnb.lottie.t.c.a<l, Path>> a;
    private final List<com.airbnb.lottie.t.c.a<Integer, Integer>> b;
    private final List<g> c;
    public g(List<g> list) {
        int i;
        int size;
        List list2;
        super();
        this.c = list;
        ArrayList arrayList = new ArrayList(list.size());
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        this.b = arrayList2;
        i = 0;
        while (i < list.size()) {
            this.a.add((g)list.get(i).b().j());
            this.b.add((g)list.get(i).c().j());
            i++;
        }
    }

    public List<com.airbnb.lottie.t.c.a<l, Path>> a() {
        return this.a;
    }

    public List<g> b() {
        return this.c;
    }

    public List<com.airbnb.lottie.t.c.a<Integer, Integer>> c() {
        return this.b;
    }
}
