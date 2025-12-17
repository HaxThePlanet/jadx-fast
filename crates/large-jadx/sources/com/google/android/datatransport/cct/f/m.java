package com.google.android.datatransport.cct.f;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m {

    public static abstract class a {
        public abstract com.google.android.datatransport.cct.f.m a();

        public abstract com.google.android.datatransport.cct.f.m.a b(com.google.android.datatransport.cct.f.k k);

        public abstract com.google.android.datatransport.cct.f.m.a c(List<com.google.android.datatransport.cct.f.l> list);

        abstract com.google.android.datatransport.cct.f.m.a d(Integer integer);

        abstract com.google.android.datatransport.cct.f.m.a e(String string);

        public abstract com.google.android.datatransport.cct.f.m.a f(com.google.android.datatransport.cct.f.p p);

        public abstract com.google.android.datatransport.cct.f.m.a g(long l);

        public abstract com.google.android.datatransport.cct.f.m.a h(long l);

        public com.google.android.datatransport.cct.f.m.a i(int i) {
            d(Integer.valueOf(i));
            return this;
        }

        public com.google.android.datatransport.cct.f.m.a j(String string) {
            e(string);
            return this;
        }
    }
    public static com.google.android.datatransport.cct.f.m.a a() {
        g.b bVar = new g.b();
        return bVar;
    }

    public abstract com.google.android.datatransport.cct.f.k b();

    @Encodable$Field(name = "logEvent")
    public abstract List<com.google.android.datatransport.cct.f.l> c();

    public abstract Integer d();

    public abstract String e();

    public abstract com.google.android.datatransport.cct.f.p f();

    public abstract long g();

    public abstract long h();
}
