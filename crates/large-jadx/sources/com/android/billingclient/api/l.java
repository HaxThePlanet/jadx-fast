package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class l {

    private String a;
    private List<String> b;

    public static class a {

        private String a;
        private List<String> b;
        public l a() {
            if (this.a == null) {
                throw new IllegalArgumentException("SKU type must be set");
            } else {
                if (this.b == null) {
                    throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
                } else {
                    com.android.billingclient.api.l lVar = new l();
                    lVar.a = this.a;
                    lVar.b = this.b;
                    return lVar;
                }
            }
        }

        public l.a b(List<String> list) {
            this.b = new ArrayList(list);
            return this;
        }

        /* synthetic */ a(z zVar) {
            super();
        }

        public l.a c(String str) {
            this.a = str;
            return this;
        }
    }
    public static l.a c() {
        return new l.a(null);
    }

    static /* synthetic */ String d(l lVar, String str) {
        lVar.a = str;
        return str;
    }

    static /* synthetic */ List e(l lVar, List list) {
        lVar.b = list;
        return list;
    }

    public String a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }
}
