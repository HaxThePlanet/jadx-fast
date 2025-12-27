package com.bumptech.glide.load.m;

import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.k;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface n<Model, Data> {

    public static class a<Data> {

        public final f a;
        public final List<f> b;
        public final d<Data> c;
        public a(f fVar, d<Data> dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(f fVar, List<f> list, d<Data> dVar) {
            super();
            k.d(fVar);
            this.a = fVar;
            k.d(list);
            this.b = list;
            k.d(dVar);
            this.c = dVar;
        }
    }
    boolean a(Model model);

    n.a<Data> b(Model model, int i, int i2, h hVar);
}
