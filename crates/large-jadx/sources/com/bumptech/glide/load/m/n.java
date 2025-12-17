package com.bumptech.glide.load.m;

import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface n<Model, Data>  {

    public static class a {

        public final f a;
        public final List<f> b;
        public final d<Data> c;
        public a(f f, d<Data> d2) {
            super(f, Collections.emptyList(), d2);
        }

        public a(f f, List<f> list2, d<Data> d3) {
            super();
            k.d(f);
            this.a = (f)f;
            k.d(list2);
            this.b = (List)list2;
            k.d(d3);
            this.c = (d)d3;
        }
    }
    public abstract boolean a(Model model);

    public abstract com.bumptech.glide.load.m.n.a<Data> b(Model model, int i2, int i3, h h4);
}
