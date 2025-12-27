package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class g {

    private int a;
    private String b;

    public static class a {

        private int a;
        private String b = "";
        public g a() {
            final com.android.billingclient.api.g gVar = new g();
            gVar.a = this.a;
            gVar.b = this.b;
            return gVar;
        }

        /* synthetic */ a(v vVar) {
            super();
        }

        public g.a b(String str) {
            this.b = str;
            return this;
        }

        public g.a c(int i) {
            this.a = i;
            return this;
        }
    }
    public static g.a c() {
        return new g.a(null);
    }

    static /* synthetic */ int d(g gVar, int i) {
        gVar.a = i;
        return i;
    }

    static /* synthetic */ String e(g gVar, String str) {
        gVar.b = str;
        return str;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }
}
