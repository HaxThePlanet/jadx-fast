package com.bumptech.glide.load.m;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;

/* loaded from: classes.dex */
public class v<Model>  implements com.bumptech.glide.load.m.n<Model, Model> {

    private static final com.bumptech.glide.load.m.v<?> a;

    public static class a implements com.bumptech.glide.load.m.o<Model, Model> {

        private static final com.bumptech.glide.load.m.v.a<?> a;
        static {
            v.a aVar = new v.a();
            v.a.a = aVar;
        }

        public static <T> com.bumptech.glide.load.m.v.a<T> a() {
            return v.a.a;
        }

        public com.bumptech.glide.load.m.n<Model, Model> b(com.bumptech.glide.load.m.r r) {
            return v.c();
        }
    }

    private static class b implements d<Model> {

        private final Model a;
        b(Model model) {
            super();
            this.a = model;
        }

        public Class<Model> a() {
            return this.a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super Model> d$a2) {
            a2.f(this.a);
        }
    }
    static {
        v vVar = new v();
        v.a = vVar;
    }

    public static <T> com.bumptech.glide.load.m.v<T> c() {
        return v.a;
    }

    public boolean a(Model model) {
        return 1;
    }

    public com.bumptech.glide.load.m.n.a<Model> b(Model model, int i2, int i3, h h4) {
        d obj3 = new d(model);
        v.b obj4 = new v.b(model);
        n.a obj2 = new n.a(obj3, obj4);
        return obj2;
    }
}
