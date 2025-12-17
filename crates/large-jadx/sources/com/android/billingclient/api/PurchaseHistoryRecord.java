package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PurchaseHistoryRecord {

    private final String a;
    private final String b;
    private final JSONObject c;
    public PurchaseHistoryRecord(String string, String string2) {
        super();
        this.a = string;
        this.b = string2;
        JSONObject obj2 = new JSONObject(string);
        this.c = obj2;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.c.optLong("purchaseTime");
    }

    public String c() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String d() {
        return this.b;
    }

    public ArrayList<String> e() {
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

    public boolean equals(Object object) {
        boolean equals;
        Object obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PurchaseHistoryRecord) {
            return i2;
        }
        if (TextUtils.equals(this.a, (PurchaseHistoryRecord)object.a()) && TextUtils.equals(this.b, object.d())) {
            if (TextUtils.equals(this.b, object.d())) {
                return i;
            }
        }
        return i2;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        String concat;
        String valueOf = String.valueOf(this.a);
        final String str2 = "PurchaseHistoryRecord. Json: ";
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            concat = new String(str2);
        }
        return concat;
    }
}
