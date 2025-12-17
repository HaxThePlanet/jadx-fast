package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    private String a;
    private List<String> b;

    public static class a {

        private String a;
        private List<String> b;
        a(com.android.billingclient.api.z z) {
            super();
        }

        public com.android.billingclient.api.l a() {
            String str = this.a;
            if (str == null) {
            } else {
                if (this.b == null) {
                } else {
                    l lVar = new l();
                    l.d(lVar, str);
                    l.e(lVar, this.b);
                    return lVar;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("SKU type must be set");
            throw illegalArgumentException2;
        }

        public com.android.billingclient.api.l.a b(List<String> list) {
            ArrayList arrayList = new ArrayList(list);
            this.b = arrayList;
            return this;
        }

        public com.android.billingclient.api.l.a c(String string) {
            this.a = string;
            return this;
        }
    }
    public static com.android.billingclient.api.l.a c() {
        l.a aVar = new l.a(0);
        return aVar;
    }

    static String d(com.android.billingclient.api.l l, String string2) {
        l.a = string2;
        return string2;
    }

    static List e(com.android.billingclient.api.l l, List list2) {
        l.b = list2;
        return list2;
    }

    public String a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }
}
