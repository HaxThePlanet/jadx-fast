package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class h {

    private String a;

    public static final class a {

        private String a;
        public h a() {
            if (this.a == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            } else {
                com.android.billingclient.api.h hVar = new h(null);
                hVar.a = this.a;
                return hVar;
            }
        }

        /* synthetic */ a(x xVar) {
            super();
        }

        public h.a b(String str) {
            this.a = str;
            return this;
        }
    }
    /* synthetic */ h(x xVar) {
        super();
    }

    public static h.a b() {
        return new h.a(null);
    }

    static /* synthetic */ String c(h hVar, String str) {
        hVar.a = str;
        return str;
    }

    public String a() {
        return this.a;
    }
}
