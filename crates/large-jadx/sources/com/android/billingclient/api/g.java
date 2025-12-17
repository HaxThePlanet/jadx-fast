package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class g {

    private int a;
    private String b;

    public static class a {

        private int a;
        private String b;
        a(com.android.billingclient.api.v v) {
            super();
            this.b = "";
        }

        public com.android.billingclient.api.g a() {
            g gVar = new g();
            g.d(gVar, this.a);
            g.e(gVar, this.b);
            return gVar;
        }

        public com.android.billingclient.api.g.a b(String string) {
            this.b = string;
            return this;
        }

        public com.android.billingclient.api.g.a c(int i) {
            this.a = i;
            return this;
        }
    }
    public static com.android.billingclient.api.g.a c() {
        g.a aVar = new g.a(0);
        return aVar;
    }

    static int d(com.android.billingclient.api.g g, int i2) {
        g.a = i2;
        return i2;
    }

    static String e(com.android.billingclient.api.g g, String string2) {
        g.b = string2;
        return string2;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }
}
