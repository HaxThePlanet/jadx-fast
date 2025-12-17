package com.revenuecat.purchases.common;

import android.net.Uri;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.models.ProductDetails;
import com.revenuecat.purchases.models.ProductDetailsHelpers;
import com.revenuecat.purchases.utils.Iso8601Utils;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.y.j0;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a-\u0010\t\u001a\u00020\u0008*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\u0008\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a-\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00002\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a5\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\r2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a%\u0010#\u001a\u00020\"*\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\u0008#\u0010$\u001a'\u0010&\u001a\u0004\u0018\u00010%*\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\u0008&\u0010'\u001a/\u0010*\u001a\u0004\u0018\u00010)*\u00020\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010(\u001a\u00020\u000b¢\u0006\u0004\u0008*\u0010+\u001a\u0011\u0010-\u001a\u00020,*\u00020\u000b¢\u0006\u0004\u0008-\u0010.¨\u0006/", d2 = {"Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/PurchaserInfo;", "buildPurchaserInfo", "(Lorg/json/JSONObject;)Lcom/revenuecat/purchases/PurchaserInfo;", "subscriptions", "nonSubscriptionsLatestPurchases", "Ljava/util/Date;", "requestDate", "Lcom/revenuecat/purchases/EntitlementInfos;", "buildEntitlementInfos", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/util/Date;)Lcom/revenuecat/purchases/EntitlementInfos;", "", "name", "Lcom/revenuecat/purchases/Store;", "getStore", "(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/revenuecat/purchases/Store;", "Lcom/revenuecat/purchases/PeriodType;", "optPeriodType", "(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/revenuecat/purchases/PeriodType;", "identifier", "productData", "Lcom/revenuecat/purchases/EntitlementInfo;", "buildEntitlementInfo", "(Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Date;)Lcom/revenuecat/purchases/EntitlementInfo;", "store", "expirationDate", "unsubscribeDetectedAt", "billingIssueDetectedAt", "", "getWillRenew", "(Lcom/revenuecat/purchases/Store;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)Z", "", "Lcom/revenuecat/purchases/models/ProductDetails;", "products", "Lcom/revenuecat/purchases/Offerings;", "createOfferings", "(Lorg/json/JSONObject;Ljava/util/Map;)Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/Offering;", "createOffering", "(Lorg/json/JSONObject;Ljava/util/Map;)Lcom/revenuecat/purchases/Offering;", "offeringIdentifier", "Lcom/revenuecat/purchases/Package;", "createPackage", "(Lorg/json/JSONObject;Ljava/util/Map;Ljava/lang/String;)Lcom/revenuecat/purchases/Package;", "Lcom/revenuecat/purchases/PackageType;", "toPackageType", "(Ljava/lang/String;)Lcom/revenuecat/purchases/PackageType;", "common_release"}, k = 2, mv = {1, 4, 0})
public final class FactoriesKt {
    private static final EntitlementInfo buildEntitlementInfo(JSONObject jSONObject, String string2, JSONObject jSONObject3, Date date4) {
        boolean after;
        Date date;
        int i;
        JSONObject jSONObject2 = jSONObject;
        final JSONObject jSONObject4 = jSONObject3;
        final Date optDate = JSONObjectExtensionsKt.optDate(jSONObject2, "expires_date");
        final Date optDate2 = JSONObjectExtensionsKt.optDate(jSONObject4, "unsubscribe_detected_at");
        final Date optDate3 = JSONObjectExtensionsKt.optDate(jSONObject4, "billing_issues_detected_at");
        final Store store = FactoriesKt.getStore(jSONObject4, "store");
        if (optDate != null) {
            if (date4 != null) {
                date = date4;
            } else {
                date = new Date();
            }
            if (optDate.after(date)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        final String string = jSONObject2.getString("product_identifier");
        n.e(string, "getString(\"product_identifier\")");
        super(string2, i, FactoriesKt.getWillRenew(store, optDate, optDate2, optDate3), FactoriesKt.optPeriodType(jSONObject4, "period_type"), JSONObjectExtensionsKt.getDate(jSONObject2, "purchase_date"), JSONObjectExtensionsKt.getDate(jSONObject4, "original_purchase_date"), optDate, store, string, jSONObject4.getBoolean("is_sandbox"), optDate2, optDate3);
        return entitlementInfo;
    }

    private static final EntitlementInfos buildEntitlementInfos(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Date date4) {
        String next;
        Object entitlementInfo;
        int jSONObject4;
        int str2;
        String str;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator keys = jSONObject.keys();
        n.e(keys, "keys()");
        while (keys.hasNext()) {
            next = keys.next();
            entitlementInfo = jSONObject.getJSONObject((String)next);
            jSONObject4 = entitlementInfo.optString("product_identifier");
            n.e(jSONObject4, "it");
            if (jSONObject4.length() > 0) {
            } else {
            }
            str2 = 0;
            if (str2 != null) {
            } else {
            }
            jSONObject4 = 0;
            if (jSONObject4 != 0) {
            }
            str = "entitlement";
            str3 = "entitlementId";
            if (jSONObject2.has(jSONObject4)) {
            } else {
            }
            if (jSONObject3.has(jSONObject4)) {
            }
            n.e(next, str3);
            n.e(entitlementInfo, str);
            jSONObject4 = jSONObject3.getJSONObject(jSONObject4);
            n.e(jSONObject4, "nonSubscriptionsLatestPu…Object(productIdentifier)");
            linkedHashMap.put(next, FactoriesKt.buildEntitlementInfo(entitlementInfo, next, jSONObject4, date4));
            n.e(next, str3);
            n.e(entitlementInfo, str);
            jSONObject4 = jSONObject2.getJSONObject(jSONObject4);
            n.e(jSONObject4, "subscriptions.getJSONObject(productIdentifier)");
            linkedHashMap.put(next, FactoriesKt.buildEntitlementInfo(entitlementInfo, next, jSONObject4, date4));
            str2 = 1;
        }
        EntitlementInfos obj8 = new EntitlementInfos(linkedHashMap);
        return obj8;
    }

    public static final PurchaserInfo buildPurchaserInfo(JSONObject jSONObject) {
        Object optNullableString;
        Object entitlementInfos;
        Object next;
        Object jSONObject2;
        int optNullableString2;
        Object jSONObject3;
        int length;
        Object optJSONObject;
        int i;
        Uri uri;
        Object obj = jSONObject;
        n.f(obj, "$this$buildPurchaserInfo");
        String str2 = "subscriber";
        JSONObject jSONObject4 = obj.getJSONObject(str2);
        JSONObject jSONObject5 = jSONObject4.getJSONObject("non_subscriptions");
        entitlementInfos = new JSONObject();
        Iterator keys2 = jSONObject5.keys();
        String str7 = "nonSubscriptions.keys()";
        n.e(keys2, str7);
        while (keys2.hasNext()) {
            next = keys2.next();
            jSONObject3 = jSONObject5.getJSONArray((String)next);
            length = jSONObject3.length();
            if (length > 0) {
            }
            entitlementInfos.put(next, jSONObject3.getJSONObject(length--));
        }
        String str6 = "subscriptions";
        jSONObject2 = jSONObject4.getJSONObject(str6);
        n.e(jSONObject2, str6);
        optJSONObject = jSONObject4.optJSONObject("entitlements");
        Date parse = Iso8601Utils.parse(obj.getString("request_date"));
        Date parse2 = Iso8601Utils.parse(jSONObject4.getString("first_seen"));
        if (optJSONObject != null && FactoriesKt.buildEntitlementInfos(optJSONObject, jSONObject2, entitlementInfos, parse) != null) {
            if (FactoriesKt.buildEntitlementInfos(optJSONObject, jSONObject2, entitlementInfos, parse) != null) {
            } else {
                jSONObject2 = Collections.emptyMap();
                n.e(jSONObject2, "emptyMap()");
                entitlementInfos = new EntitlementInfos(jSONObject2);
            }
        } else {
        }
        n.e(jSONObject4, str2);
        optNullableString = JSONObjectExtensionsKt.optNullableString(jSONObject4, "management_url");
        optNullableString2 = JSONObjectExtensionsKt.optNullableString(jSONObject4, "original_purchase_date");
        int i2 = 0;
        if (optNullableString2 != null) {
            if (Iso8601Utils.parse(optNullableString2) != null) {
            } else {
                optNullableString2 = i2;
            }
            i = optNullableString2;
        } else {
            i = i2;
        }
        Iterator keys = jSONObject5.keys();
        n.e(keys, str7);
        n.e(parse, "requestDate");
        n.e(parse2, "firstSeen");
        final String optString = jSONObject4.optString("original_app_user_id");
        n.e(optString, "subscriber.optString(\"original_app_user_id\")");
        if (optNullableString != null) {
            uri = optNullableString;
        } else {
            uri = i2;
        }
        super(entitlementInfos, i.C(i.a(keys)), JSONObjectExtensionsKt.parseExpirations(jSONObject2), j0.o(JSONObjectExtensionsKt.parsePurchaseDates(jSONObject2), JSONObjectExtensionsKt.parsePurchaseDates(entitlementInfos)), parse, jSONObject, obj.optInt("schema_version"), parse2, optString, uri, i);
        return purchaserInfo2;
    }

    public static final Offering createOffering(JSONObject jSONObject, Map<String, ProductDetails> map2) {
        Object jSONArray;
        int i;
        Package package;
        JSONObject jSONObject2;
        String str;
        Object obj8;
        int obj9;
        n.f(jSONObject, "$this$createOffering");
        n.f(map2, "products");
        String string = jSONObject.getString("identifier");
        jSONArray = jSONObject.getJSONArray("packages");
        ArrayList arrayList = new ArrayList();
        i = 0;
        String str7 = "offeringIdentifier";
        while (i < jSONArray.length()) {
            jSONObject2 = jSONArray.getJSONObject(i);
            n.e(jSONObject2, "jsonPackages.getJSONObject(i)");
            n.e(string, str7);
            package = FactoriesKt.createPackage(jSONObject2, map2, string);
            if (package != null) {
            }
            i++;
            str7 = "offeringIdentifier";
            arrayList.add(package);
        }
        if (obj9 ^= 1 != 0) {
            n.e(string, str7);
            obj8 = jSONObject.getString("description");
            n.e(obj8, "getString(\"description\")");
            obj9 = new Offering(string, obj8, arrayList);
        } else {
            obj9 = 0;
        }
        return obj9;
    }

    public static final Offerings createOfferings(JSONObject jSONObject, Map<String, ProductDetails> map2) {
        int i;
        Offering offering;
        String identifier;
        n.f(jSONObject, "$this$createOfferings");
        n.f(map2, "products");
        JSONArray jSONArray = jSONObject.getJSONArray("offerings");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            n.e(jSONObject2, "jsonOfferings.getJSONObject(i)");
            offering = FactoriesKt.createOffering(jSONObject2, map2);
            if (offering != null) {
            }
            i++;
            linkedHashMap.put(offering.getIdentifier(), offering);
        }
        Offerings obj7 = new Offerings((Offering)linkedHashMap.get(jSONObject.getString("current_offering_id")), linkedHashMap);
        return obj7;
    }

    public static final Package createPackage(JSONObject jSONObject, Map<String, ProductDetails> map2, String string3) {
        n.f(jSONObject, "$this$createPackage");
        n.f(map2, "products");
        n.f(string3, "offeringIdentifier");
        Object obj3 = map2.get(jSONObject.getString("platform_product_identifier"));
        if ((ProductDetails)obj3 != null) {
            String str5 = "identifier";
            String obj2 = jSONObject.getString(str5);
            n.e(obj2, str5);
            Package obj = new Package(obj2, FactoriesKt.toPackageType(obj2), ProductDetailsHelpers.getSkuDetails((ProductDetails)obj3), string3);
            return obj;
        }
        return null;
    }

    private static final Store getStore(JSONObject jSONObject, String string2) {
        Store obj0;
        String obj1;
        obj0 = jSONObject.getString(string2);
        if (obj0 == null) {
            obj0 = Store.UNKNOWN_STORE;
        } else {
            switch (obj0) {
                case "amazon":
                    obj0 = Store.AMAZON;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                case "stripe":
                    obj0 = Store.STRIPE;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                case "mac_app_store":
                    obj0 = Store.MAC_APP_STORE;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                case "promotional":
                    obj0 = Store.PROMOTIONAL;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                case "app_store":
                    obj0 = Store.APP_STORE;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                case "play_store":
                    obj0 = Store.PLAY_STORE;
                    obj0 = Store.UNKNOWN_STORE;
                    break;
                default:
                    obj0 = Store.UNKNOWN_STORE;
            }
        }
        return obj0;
    }

    private static final boolean getWillRenew(Store store, Date date2, Date date3, Date date4) {
        int i;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        i = 1;
        final int i2 = 0;
        obj3 = store == Store.PROMOTIONAL ? i : i2;
        obj4 = date2 == null ? i : i2;
        obj5 = date3 != null ? i : i2;
        obj6 = date4 != null ? i : i2;
        if (obj3 == null && obj4 == null && obj5 == null && obj6 == null) {
            if (obj4 == null) {
                if (obj5 == null) {
                    if (obj6 == null) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final PeriodType optPeriodType(JSONObject jSONObject, String string2) {
        int i;
        PeriodType obj1;
        String obj2;
        obj1 = jSONObject.optString(string2);
        if (obj1 == null) {
            obj1 = PeriodType.NORMAL;
        } else {
            obj2 = obj1.hashCode();
            if (obj2 != -1039745817) {
                if (obj2 != 100361836) {
                    if (obj2 != 110628630) {
                    } else {
                        if (obj1.equals("trial")) {
                            obj1 = PeriodType.TRIAL;
                        } else {
                        }
                    }
                } else {
                    if (obj1.equals("intro")) {
                        obj1 = PeriodType.INTRO;
                    } else {
                    }
                }
            } else {
                if (obj1.equals("normal")) {
                    obj1 = PeriodType.NORMAL;
                } else {
                }
            }
        }
        return obj1;
    }

    public static final PackageType toPackageType(String string) {
        PackageType[] values;
        int length;
        int i;
        int i2;
        PackageType uNKNOWN;
        boolean z;
        Object obj7;
        n.f(string, "$this$toPackageType");
        values = PackageType.values();
        final int i3 = 0;
        i = i3;
        i2 = 0;
        while (i < values.length) {
            i++;
            i2 = 0;
        }
        uNKNOWN = i2;
        if (uNKNOWN != null) {
        } else {
            uNKNOWN = l.M(string, "$rc_", i3, 2, i2) ? PackageType.UNKNOWN : PackageType.CUSTOM;
        }
        return uNKNOWN;
    }
}
