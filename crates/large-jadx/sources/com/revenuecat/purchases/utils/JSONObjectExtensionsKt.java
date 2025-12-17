package com.revenuecat.purchases.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.j0.i;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0006\u0010\u0005\u001a9\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0008j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\n\u0010\u000b\u001a\u0019\u0010\u000c\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\r\u001a\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\u0008\u0012\u0010\u0011\u001a%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001\"\u0004\u0008\u0000\u0010\u0013*\u00020\u0000¢\u0006\u0004\u0008\u0014\u0010\u0005¨\u0006\u0015", d2 = {"Lorg/json/JSONObject;", "", "", "Ljava/util/Date;", "parseExpirations", "(Lorg/json/JSONObject;)Ljava/util/Map;", "parsePurchaseDates", "jsonKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parseDates", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/HashMap;", "getDate", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/Date;", "optDate", "name", "getNullableString", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "optNullableString", "T", "toMap", "utils_release"}, k = 2, mv = {1, 4, 0})
public final class JSONObjectExtensionsKt {
    public static final Date getDate(JSONObject jSONObject, String string2) {
        n.f(jSONObject, "$this$getDate");
        n.f(string2, "jsonKey");
        Date obj1 = Iso8601Utils.parse(jSONObject.getString(string2));
        n.e(obj1, "Iso8601Utils.parse(getString(jsonKey))");
        return obj1;
    }

    public static final String getNullableString(JSONObject jSONObject, String string2) {
        int string;
        Object obj2;
        n.f(jSONObject, "$this$getNullableString");
        n.f(string2, "name");
        if (!jSONObject.isNull(string2)) {
        } else {
            obj2 = string;
        }
        if (obj2 != null) {
            string = obj2.getString(string2);
        }
        return string;
    }

    public static final Date optDate(JSONObject jSONObject, String string2) {
        int date;
        Object obj2;
        n.f(jSONObject, "$this$optDate");
        n.f(string2, "jsonKey");
        if (!jSONObject.isNull(string2)) {
        } else {
            obj2 = date;
        }
        if (obj2 != null) {
            date = JSONObjectExtensionsKt.getDate(obj2, string2);
        }
        return date;
    }

    public static final String optNullableString(JSONObject jSONObject, String string2) {
        int nullableString;
        Object obj2;
        n.f(jSONObject, "$this$optNullableString");
        n.f(string2, "name");
        if (jSONObject.has(string2)) {
        } else {
            obj2 = nullableString;
        }
        if (obj2 != null) {
            nullableString = JSONObjectExtensionsKt.getNullableString(obj2, string2);
        }
        return nullableString;
    }

    public static final HashMap<String, Date> parseDates(JSONObject jSONObject, String string2) {
        Object next;
        Date optDate;
        String str;
        n.f(jSONObject, "$this$parseDates");
        n.f(string2, "jsonKey");
        HashMap hashMap = new HashMap();
        final Iterator keys = jSONObject.keys();
        for (String next : keys) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            n.e(next, "key");
            n.e(jSONObject2, "expirationObject");
            hashMap.put(next, JSONObjectExtensionsKt.optDate(jSONObject2, string2));
        }
        return hashMap;
    }

    public static final Map<String, Date> parseExpirations(JSONObject jSONObject) {
        n.f(jSONObject, "$this$parseExpirations");
        return JSONObjectExtensionsKt.parseDates(jSONObject, "expires_date");
    }

    public static final Map<String, Date> parsePurchaseDates(JSONObject jSONObject) {
        n.f(jSONObject, "$this$parsePurchaseDates");
        return JSONObjectExtensionsKt.parseDates(jSONObject, "purchase_date");
    }

    public static final <T> Map<String, T> toMap(JSONObject jSONObject) {
        Object keys;
        com.revenuecat.purchases.utils.JSONObjectExtensionsKt.toMap.1 anon;
        Map obj2;
        n.f(jSONObject, "$this$toMap");
        keys = jSONObject.keys();
        keys = i.a(keys);
        anon = new JSONObjectExtensionsKt.toMap.1(jSONObject);
        obj2 = i.u(keys, anon);
        if (keys != null && keys != null && obj2 != null) {
            keys = i.a(keys);
            if (keys != null) {
                anon = new JSONObjectExtensionsKt.toMap.1(jSONObject);
                obj2 = i.u(keys, anon);
                if (obj2 != null) {
                    obj2 = j0.v(obj2);
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }
}
