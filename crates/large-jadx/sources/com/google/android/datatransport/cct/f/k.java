package com.google.android.datatransport.cct.f;

/* loaded from: classes.dex */
public abstract class k {

    public static abstract class a {
        public abstract com.google.android.datatransport.cct.f.k a();

        public abstract com.google.android.datatransport.cct.f.k.a b(com.google.android.datatransport.cct.f.a a);

        public abstract com.google.android.datatransport.cct.f.k.a c(com.google.android.datatransport.cct.f.k.b k$b);
    }

    public static enum b {

        UNKNOWN(false),
        ANDROID_FIREBASE(23);

        private final int value;
    }
    public static com.google.android.datatransport.cct.f.k.a a() {
        e.b bVar = new e.b();
        return bVar;
    }

    public abstract com.google.android.datatransport.cct.f.a b();

    public abstract com.google.android.datatransport.cct.f.k.b c();
}
