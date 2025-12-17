package com.android.billingclient.api;

/* loaded from: classes.dex */
public final class a {

    private String a;

    public static final class a {

        private String a;
        a(com.android.billingclient.api.n n) {
            super();
        }

        public com.android.billingclient.api.a a() {
            String str = this.a;
            if (str == null) {
            } else {
                a aVar = new a(0);
                a.c(aVar, str);
                return aVar;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Purchase token must be set");
            throw illegalArgumentException;
        }

        public com.android.billingclient.api.a.a b(String string) {
            this.a = string;
            return this;
        }
    }
    a(com.android.billingclient.api.n n) {
        super();
    }

    public static com.android.billingclient.api.a.a b() {
        a.a aVar = new a.a(0);
        return aVar;
    }

    static String c(com.android.billingclient.api.a a, String string2) {
        a.a = string2;
        return string2;
    }

    public String a() {
        return this.a;
    }
}
