package com.bumptech.glide.load.m;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    private static final v<?> a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        private static final v.a<?> a = new v$a<>();

        public static <T> v.a<T> a() {
            return v.a.a;
        }

        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        private final Model a;
        b(Model model) {
            super();
            this.a = model;
        }

        public Class<Model> a() {
            return this.a.getClass();
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super Model> aVar) {
            aVar.f(this.a);
        }

        public void b() {
        }

        public void cancel() {
        }
    }

    public static <T> v<T> c() {
        return v.a;
    }

    public n.a<Model> b(Model model, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(model), new v.b(model));
    }

    public boolean a(Model model) {
        return true;
    }
}
