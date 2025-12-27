package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public class PurchaseHistoryRecord {

    private final String a;
    private final String b;
    private final JSONObject c = new JSONObject();
    public PurchaseHistoryRecord(String str, String str2) throws org.json.JSONException {
        super();
        this.a = str;
        this.b = str2;
        final JSONObject jSONObject = new JSONObject(str);
    }

    public long b() {
        return this.c.optLong("purchaseTime");
    }

    public String c() {
        return this.c.optString("token", this.c.optString("purchaseToken"));
    }

    public ArrayList<String> e() {
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

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z3 = false;
        if (!(object instanceof PurchaseHistoryRecord)) {
            return false;
        }
        if (TextUtils.equals(this.a, object.a())) {
            return TextUtils.equals(this.b, object.d()) ? z : z3;
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() throws java.io.UnsupportedEncodingException {
        String concatenated;
        String str2 = String.valueOf(this.a);
        final String str3 = "PurchaseHistoryRecord. Json: ";
        if (str2.length() != 0) {
            concatenated = "PurchaseHistoryRecord. Json: ".concat(str2);
        } else {
            concatenated = new String(str3);
        }
        return concatenated;
    }

    public String a() {
        return this.a;
    }

    public String d() {
        return this.b;
    }
}
