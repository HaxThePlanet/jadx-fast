package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class Purchase {

    private final String a;
    private final String b;
    private final JSONObject c = new JSONObject();

    public static class a {

        private final List<Purchase> a;
        private final g b;
        public int c() {
            return a().b();
        }

        public a(g gVar, List<Purchase> list) {
            super();
            this.a = list;
            this.b = gVar;
        }

        public g a() {
            return this.b;
        }

        public List<Purchase> b() {
            return this.a;
        }
    }
    public Purchase(String str, String str2) throws org.json.JSONException {
        super();
        this.a = str;
        this.b = str2;
        final JSONObject jSONObject = new JSONObject(str);
    }

    public String a() {
        return this.c.optString("orderId");
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
        return this.c.optString("token", this.c.optString("purchaseToken"));
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z3 = false;
        if (!(object instanceof Purchase)) {
            return false;
        }
        if (TextUtils.equals(this.a, object.b())) {
            return TextUtils.equals(this.b, object.f()) ? z : z3;
        }
    }

    public ArrayList<String> g() {
        int i = 0;
        final ArrayList arrayList = new ArrayList();
        str = "productIds";
        if (this.c.has(str)) {
            JSONArray optJSONArray = this.c.optJSONArray(str);
            if (optJSONArray != null) {
                i = 0;
                while (i < optJSONArray.length()) {
                    arrayList.add(optJSONArray.optString(i));
                    i = i + 1;
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

    public String toString() throws java.io.UnsupportedEncodingException {
        String concatenated;
        String str2 = String.valueOf(this.a);
        final String str3 = "Purchase. Json: ";
        if (str2.length() != 0) {
            concatenated = "Purchase. Json: ".concat(str2);
        } else {
            concatenated = new String(str3);
        }
        return concatenated;
    }

    public String b() {
        return this.a;
    }

    public String f() {
        return this.b;
    }
}
