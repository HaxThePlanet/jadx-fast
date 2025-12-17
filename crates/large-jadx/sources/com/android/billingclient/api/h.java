package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class h {

    private String a;

    public static final class a {

        private String a;
        a(com.android.billingclient.api.x x) {
            super();
        }

        public com.android.billingclient.api.h a() {
            String str = this.a;
            if (str == null) {
            } else {
                h hVar = new h(0);
                h.c(hVar, str);
                return hVar;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Purchase token must be set");
            throw illegalArgumentException;
        }

        public com.android.billingclient.api.h.a b(String string) {
            this.a = string;
            return this;
        }
    }
    h(com.android.billingclient.api.x x) {
        super();
    }

    public static com.android.billingclient.api.h.a b() {
        h.a aVar = new h.a(0);
        return aVar;
    }

    static String c(com.android.billingclient.api.h h, String string2) {
        h.a = string2;
        return string2;
    }

    public String a() {
        return this.a;
    }
}
