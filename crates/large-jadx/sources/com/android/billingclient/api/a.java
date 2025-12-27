package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class a {

    private String a;

    public static final class a {

        private String a;
        public a a() {
            if (this.a == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            } else {
                com.android.billingclient.api.a aVar = new a(null);
                aVar.a = this.a;
                return aVar;
            }
        }

        /* synthetic */ a(n nVar) {
            super();
        }

        public a.a b(String str) {
            this.a = str;
            return this;
        }
    }
    /* synthetic */ a(n nVar) {
        super();
    }

    public static a.a b() {
        return new a.a(null);
    }

    static /* synthetic */ String c(a aVar, String str) {
        aVar.a = str;
        return str;
    }

    public String a() {
        return this.a;
    }
}
