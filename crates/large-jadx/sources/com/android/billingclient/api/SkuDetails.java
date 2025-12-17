package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SkuDetails {

    private final String a;
    private final JSONObject b;
    public SkuDetails(String string) {
        super();
        this.a = string;
        JSONObject jSONObject = new JSONObject(string);
        this.b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
        } else {
            if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("SkuType cannot be empty.");
            throw obj2;
        }
        obj2 = new IllegalArgumentException("SKU cannot be empty.");
        throw obj2;
    }

    public String a() {
        return this.b.optString("description");
    }

    public String b() {
        return this.b.optString("freeTrialPeriod");
    }

    public String c() {
        return this.b.optString("iconUrl");
    }

    public String d() {
        return this.b.optString("introductoryPrice");
    }

    public long e() {
        return this.b.optLong("introductoryPriceAmountMicros");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof SkuDetails) {
            return 0;
        }
        return TextUtils.equals(this.a, object.a);
    }

    public int f() {
        return this.b.optInt("introductoryPriceCycles");
    }

    public String g() {
        return this.b.optString("introductoryPricePeriod");
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String i() {
        final String str2 = "original_price";
        if (this.b.has(str2)) {
            return this.b.optString(str2);
        }
        return k();
    }

    public long j() {
        final String str = "original_price_micros";
        if (this.b.has(str)) {
            return this.b.optLong(str);
        }
        return l();
    }

    public String k() {
        return this.b.optString("price");
    }

    public long l() {
        return this.b.optLong("price_amount_micros");
    }

    public String m() {
        return this.b.optString("price_currency_code");
    }

    public String n() {
        return this.b.optString("productId");
    }

    public String o() {
        return this.b.optString("subscriptionPeriod");
    }

    public String p() {
        return this.b.optString("title");
    }

    public String q() {
        return this.b.optString("type");
    }

    public int r() {
        return this.b.optInt("offer_type");
    }

    public String s() {
        return this.b.optString("offer_id");
    }

    public final String t() {
        return this.b.optString("packageName");
    }

    public String toString() {
        String concat;
        String valueOf = String.valueOf(this.a);
        final String str2 = "SkuDetails: ";
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            concat = new String(str2);
        }
        return concat;
    }

    public String u() {
        return this.b.optString("serializedDocid");
    }

    final String v() {
        return this.b.optString("skuDetailsToken");
    }
}
