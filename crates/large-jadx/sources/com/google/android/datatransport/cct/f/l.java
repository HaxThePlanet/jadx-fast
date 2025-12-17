package com.google.android.datatransport.cct.f;

/* loaded from: classes.dex */
public abstract class l {

    public static abstract class a {
        public abstract com.google.android.datatransport.cct.f.l a();

        public abstract com.google.android.datatransport.cct.f.l.a b(Integer integer);

        public abstract com.google.android.datatransport.cct.f.l.a c(long l);

        public abstract com.google.android.datatransport.cct.f.l.a d(long l);

        public abstract com.google.android.datatransport.cct.f.l.a e(com.google.android.datatransport.cct.f.o o);

        abstract com.google.android.datatransport.cct.f.l.a f(byte[] bArr);

        abstract com.google.android.datatransport.cct.f.l.a g(String string);

        public abstract com.google.android.datatransport.cct.f.l.a h(long l);
    }
    private static com.google.android.datatransport.cct.f.l.a a() {
        f.b bVar = new f.b();
        return bVar;
    }

    public static com.google.android.datatransport.cct.f.l.a i(String string) {
        final com.google.android.datatransport.cct.f.l.a aVar = l.a();
        aVar.g(string);
        return aVar;
    }

    public static com.google.android.datatransport.cct.f.l.a j(byte[] bArr) {
        final com.google.android.datatransport.cct.f.l.a aVar = l.a();
        aVar.f(bArr);
        return aVar;
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract com.google.android.datatransport.cct.f.o e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
