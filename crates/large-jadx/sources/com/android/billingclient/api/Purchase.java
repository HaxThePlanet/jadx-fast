package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Purchase {

    private final String a;
    private final String b;
    private final JSONObject c;

    public static class a {

        private final List<com.android.billingclient.api.Purchase> a;
        private final com.android.billingclient.api.g b;
        public a(com.android.billingclient.api.g g, List<com.android.billingclient.api.Purchase> list2) {
            super();
            this.a = list2;
            this.b = g;
        }

        public com.android.billingclient.api.g a() {
            return this.b;
        }

        public List<com.android.billingclient.api.Purchase> b() {
            return this.a;
        }

        public int c() {
            return a().b();
        }
    }
    public Purchase(String string, String string2) {
        super();
        this.a = string;
        this.b = string2;
        JSONObject obj2 = new JSONObject(string);
        this.c = obj2;
    }

    public String a() {
        return this.c.optString("orderId");
    }

    public String b() {
        return this.a;
    }

    public int c() {
        final int i3 = 1;
        if (this.c.optInt("purchaseState", i3) != 4) {
            return i3;
        }
        return 2;
    }

    public long d() {
        return this.c.optLong("purchaseTime");
    }

    public String e() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public boolean equals(Object object) {
        boolean equals;
        Object obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Purchase) {
            return i2;
        }
        if (TextUtils.equals(this.a, (Purchase)object.b()) && TextUtils.equals(this.b, object.f())) {
            if (TextUtils.equals(this.b, object.f())) {
                return i;
            }
        }
        return i2;
    }

    public String f() {
        return this.b;
    }

    public ArrayList<String> g() {
        boolean optJSONArray;
        String str;
        int optString;
        ArrayList arrayList = new ArrayList();
        str = "productIds";
        if (this.c.has(str)) {
            optJSONArray = this.c.optJSONArray(str);
            if (optJSONArray != null) {
                str = 0;
                while (str < optJSONArray.length()) {
                    arrayList.add(optJSONArray.optString(str));
                    str++;
                }
            }
        } else {
            str = "productId";
            if (this.c.has(str)) {
                arrayList.add(this.c.optString(str));
            }
        }
        return arrayList;
    }

    public boolean h() {
        return this.c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i() {
        return this.c.optBoolean("autoRenewing");
    }

    public String toString() {
        String concat;
        String valueOf = String.valueOf(this.a);
        final String str2 = "Purchase. Json: ";
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            concat = new String(str2);
        }
        return concat;
    }
}
