package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.parceler.JSONObjectParceler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import k.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010.\u001a\u00020\u001a\u0012\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00103\u001a\u00020$\u0012\u0006\u00104\u001a\u00020\u0017\u0012\u0006\u00105\u001a\u00020\u0004\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0008\u00107\u001a\u0004\u0018\u00010*\u0012\u0008\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008n\u0010oJ+\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u000c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\u0008\u000c\u0010\u000bJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\u0008\u000e\u0010\u000bJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\u0008\u000f\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002HÆ\u0003¢\u0006\u0004\u0008\u001f\u0010 J\u001e\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002HÆ\u0003¢\u0006\u0004\u0008!\u0010 J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\u0008\"\u0010#J\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\u0008%\u0010&J\u0010\u0010'\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\u0008'\u0010\u0019J\u0010\u0010(\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\u0008(\u0010#J\u0010\u0010)\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\u0008)\u0010\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0004\u0008+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\u0008-\u0010#J¤\u0001\u00109\u001a\u00020\u00002\u0008\u0008\u0002\u0010.\u001a\u00020\u001a2\u000e\u0008\u0002\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00062\u0016\u0008\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0016\u0008\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0008\u0008\u0002\u00102\u001a\u00020\u00042\u0008\u0008\u0002\u00103\u001a\u00020$2\u0008\u0008\u0002\u00104\u001a\u00020\u00172\u0008\u0008\u0002\u00105\u001a\u00020\u00042\u0008\u0008\u0002\u00106\u001a\u00020\u00032\n\u0008\u0002\u00107\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\u00089\u0010:J\u0010\u0010;\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\u0008;\u0010\u0019J \u0010@\u001a\u00020?2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\u0008@\u0010AR$\u0010C\u001a\n B*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0082\u0004¢\u0006\u000c\n\u0004\u0008C\u0010D\u0012\u0004\u0008E\u0010FR'\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u00081\u0010G\u001a\u0004\u0008H\u0010 R'\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u00080\u0010G\u001a\u0004\u0008I\u0010 R\u0019\u00105\u001a\u00020\u00048\u0006@\u0006¢\u0006\u000c\n\u0004\u00085\u0010J\u001a\u0004\u0008K\u0010#R\u001b\u00107\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\u000c\n\u0004\u00087\u0010L\u001a\u0004\u0008M\u0010,R\u0019\u00104\u001a\u00020\u00178\u0006@\u0006¢\u0006\u000c\n\u0004\u00084\u0010N\u001a\u0004\u0008O\u0010\u0019R\u001b\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\u000c\n\u0004\u00088\u0010J\u001a\u0004\u0008P\u0010#R\u0019\u00106\u001a\u00020\u00038\u0006@\u0006¢\u0006\u000c\n\u0004\u00086\u0010Q\u001a\u0004\u0008R\u0010\u0016R\u0019\u0010.\u001a\u00020\u001a8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008.\u0010S\u001a\u0004\u0008T\u0010\u001cR)\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008U\u0010V\u0012\u0004\u0008X\u0010F\u001a\u0004\u0008W\u0010\u001eR)\u0010]\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008Z\u0010V\u0012\u0004\u0008\\\u0010F\u001a\u0004\u0008[\u0010\u001eR%\u0010a\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008^\u0010V\u0012\u0004\u0008`\u0010F\u001a\u0004\u0008_\u0010#R\u0019\u00102\u001a\u00020\u00048\u0006@\u0006¢\u0006\u000c\n\u0004\u00082\u0010J\u001a\u0004\u0008b\u0010#R\u0019\u00103\u001a\u00020$8\u0006@\u0006¢\u0006\u000c\n\u0004\u00083\u0010D\u001a\u0004\u0008c\u0010&R)\u0010j\u001a\u0008\u0012\u0004\u0012\u00020e0d8F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008f\u0010V\u0012\u0004\u0008i\u0010F\u001a\u0004\u0008g\u0010hR(\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\u0008/\u0010k\u0012\u0004\u0008m\u0010F\u001a\u0004\u0008l\u0010\u001e¨\u0006p", d2 = {"Lcom/revenuecat/purchases/PurchaserInfo;", "Landroid/os/Parcelable;", "", "", "Ljava/util/Date;", "expirations", "", "activeIdentifiers", "(Ljava/util/Map;)Ljava/util/Set;", "sku", "getExpirationDateForSku", "(Ljava/lang/String;)Ljava/util/Date;", "getPurchaseDateForSku", "entitlement", "getExpirationDateForEntitlement", "getPurchaseDateForEntitlement", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "Lcom/revenuecat/purchases/EntitlementInfos;", "component1", "()Lcom/revenuecat/purchases/EntitlementInfos;", "component2", "()Ljava/util/Set;", "component3", "()Ljava/util/Map;", "component4", "component5", "()Ljava/util/Date;", "Lorg/json/JSONObject;", "component6", "()Lorg/json/JSONObject;", "component7", "component8", "component9", "Landroid/net/Uri;", "component10", "()Landroid/net/Uri;", "component11", "entitlements", "purchasedNonSubscriptionSkus", "allExpirationDatesByProduct", "allPurchaseDatesByProduct", "requestDate", "jsonObject", "schemaVersion", "firstSeen", "originalAppUserId", "managementURL", "originalPurchaseDate", "copy", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;Lorg/json/JSONObject;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;)Lcom/revenuecat/purchases/PurchaserInfo;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "kotlin.jvm.PlatformType", "subscriberJSONObject", "Lorg/json/JSONObject;", "getSubscriberJSONObject$annotations", "()V", "Ljava/util/Map;", "getAllPurchaseDatesByProduct", "getAllExpirationDatesByProduct", "Ljava/util/Date;", "getFirstSeen", "Landroid/net/Uri;", "getManagementURL", "I", "getSchemaVersion", "getOriginalPurchaseDate", "Ljava/lang/String;", "getOriginalAppUserId", "Lcom/revenuecat/purchases/EntitlementInfos;", "getEntitlements", "activeSubscriptions$delegate", "Lkotlin/h;", "getActiveSubscriptions", "getActiveSubscriptions$annotations", "activeSubscriptions", "allPurchasedSkus$delegate", "getAllPurchasedSkus", "getAllPurchasedSkus$annotations", "allPurchasedSkus", "latestExpirationDate$delegate", "getLatestExpirationDate", "getLatestExpirationDate$annotations", "latestExpirationDate", "getRequestDate", "getJsonObject", "", "Lcom/revenuecat/purchases/models/Transaction;", "nonSubscriptionTransactions$delegate", "getNonSubscriptionTransactions", "()Ljava/util/List;", "getNonSubscriptionTransactions$annotations", "nonSubscriptionTransactions", "Ljava/util/Set;", "getPurchasedNonSubscriptionSkus", "getPurchasedNonSubscriptionSkus$annotations", "<init>", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;Lorg/json/JSONObject;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class PurchaserInfo implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final h activeSubscriptions$delegate;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final h allPurchasedSkus$delegate;
    private final com.revenuecat.purchases.EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;
    private final h latestExpirationDate$delegate;
    private final Uri managementURL;
    private final h nonSubscriptionTransactions$delegate;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final Set<String> purchasedNonSubscriptionSkus;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            int int3;
            int int2;
            int int;
            String string;
            String string2;
            java.io.Serializable serializable;
            java.io.Serializable serializable2;
            n.f(parcel, "in");
            LinkedHashSet linkedHashSet = new LinkedHashSet(parcel.readInt());
            while (int3 != 0) {
                linkedHashSet.add(parcel.readString());
                int3--;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(parcel.readInt());
            while (int2 != 0) {
                linkedHashMap.put(parcel.readString(), (Date)parcel.readSerializable());
                int2--;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(parcel.readInt());
            while (int != 0) {
                linkedHashMap2.put(parcel.readString(), (Date)parcel.readSerializable());
                int--;
            }
            super((EntitlementInfos)EntitlementInfos.CREATOR.createFromParcel(parcel), linkedHashSet, linkedHashMap, linkedHashMap2, (Date)parcel.readSerializable(), (JSONObject)JSONObjectParceler.INSTANCE.create(parcel), parcel.readInt(), (Date)parcel.readSerializable(), parcel.readString(), (Uri)parcel.readParcelable(PurchaserInfo.class.getClassLoader()), (Date)parcel.readSerializable());
            return purchaserInfo;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new PurchaserInfo[i];
        }
    }
    static {
        PurchaserInfo.Creator creator = new PurchaserInfo.Creator();
        PurchaserInfo.CREATOR = creator;
    }

    public PurchaserInfo(com.revenuecat.purchases.EntitlementInfos entitlementInfos, Set<String> set2, Map<String, ? extends Date> map3, Map<String, ? extends Date> map4, Date date5, JSONObject jSONObject6, int i7, Date date8, String string9, Uri uri10, Date date11) {
        n.f(entitlementInfos, "entitlements");
        n.f(set2, "purchasedNonSubscriptionSkus");
        n.f(map3, "allExpirationDatesByProduct");
        n.f(map4, "allPurchaseDatesByProduct");
        n.f(date5, "requestDate");
        n.f(jSONObject6, "jsonObject");
        n.f(date8, "firstSeen");
        n.f(string9, "originalAppUserId");
        super();
        this.entitlements = entitlementInfos;
        this.purchasedNonSubscriptionSkus = set2;
        this.allExpirationDatesByProduct = map3;
        this.allPurchaseDatesByProduct = map4;
        this.requestDate = date5;
        this.jsonObject = jSONObject6;
        this.schemaVersion = i7;
        this.firstSeen = date8;
        this.originalAppUserId = string9;
        this.managementURL = uri10;
        this.originalPurchaseDate = date11;
        PurchaserInfo.activeSubscriptions.2 obj2 = new PurchaserInfo.activeSubscriptions.2(this);
        this.activeSubscriptions$delegate = j.b(obj2);
        obj2 = new PurchaserInfo.allPurchasedSkus.2(this);
        this.allPurchasedSkus$delegate = j.b(obj2);
        obj2 = new PurchaserInfo.latestExpirationDate.2(this);
        this.latestExpirationDate$delegate = j.b(obj2);
        obj2 = new PurchaserInfo.nonSubscriptionTransactions.2(this);
        this.nonSubscriptionTransactions$delegate = j.b(obj2);
        this.subscriberJSONObject = jSONObject6.getJSONObject("subscriber");
    }

    public static final Set access$activeIdentifiers(com.revenuecat.purchases.PurchaserInfo purchaserInfo, Map map2) {
        return purchaserInfo.activeIdentifiers(map2);
    }

    public static final JSONObject access$getSubscriberJSONObject$p(com.revenuecat.purchases.PurchaserInfo purchaserInfo) {
        return purchaserInfo.subscriberJSONObject;
    }

    private final Set<String> activeIdentifiers(Map<String, ? extends Date> map) {
        Object value;
        int key;
        Object value2;
        Date requestDate;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj5 = map.entrySet().iterator();
        while (obj5.hasNext()) {
            value = obj5.next();
            value2 = (Map.Entry)value.getValue();
            if ((Date)value2 != null) {
            } else {
            }
            key = 1;
            if (key != null) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
            if ((Date)value2.after(this.requestDate)) {
            } else {
            }
            key = 0;
        }
        return linkedHashMap.keySet();
    }

    public static com.revenuecat.purchases.PurchaserInfo copy$default(com.revenuecat.purchases.PurchaserInfo purchaserInfo, com.revenuecat.purchases.EntitlementInfos entitlementInfos2, Set set3, Map map4, Map map5, Date date6, JSONObject jSONObject7, int i8, Date date9, String string10, Uri uri11, Date date12, int i13, Object object14) {
        Date originalPurchaseDate;
        com.revenuecat.purchases.EntitlementInfos entitlements;
        Set purchasedNonSubscriptionSkus;
        Map allExpirationDatesByProduct;
        Map allPurchaseDatesByProduct;
        Date requestDate;
        JSONObject jsonObject;
        int schemaVersion;
        Date firstSeen;
        String originalAppUserId;
        Uri managementURL;
        Object obj = purchaserInfo;
        int i = i13;
        entitlements = i & 1 != 0 ? obj.entitlements : entitlementInfos2;
        purchasedNonSubscriptionSkus = i & 2 != 0 ? obj.purchasedNonSubscriptionSkus : set3;
        allExpirationDatesByProduct = i & 4 != 0 ? obj.allExpirationDatesByProduct : map4;
        allPurchaseDatesByProduct = i & 8 != 0 ? obj.allPurchaseDatesByProduct : map5;
        requestDate = i & 16 != 0 ? obj.requestDate : date6;
        jsonObject = i & 32 != 0 ? obj.jsonObject : jSONObject7;
        schemaVersion = i & 64 != 0 ? obj.schemaVersion : i8;
        firstSeen = i & 128 != 0 ? obj.firstSeen : date9;
        originalAppUserId = i & 256 != 0 ? obj.originalAppUserId : string10;
        managementURL = i & 512 != 0 ? obj.managementURL : uri11;
        originalPurchaseDate = i &= 1024 != 0 ? obj.originalPurchaseDate : date12;
        return purchaserInfo.copy(entitlements, purchasedNonSubscriptionSkus, allExpirationDatesByProduct, allPurchaseDatesByProduct, requestDate, jsonObject, schemaVersion, firstSeen, originalAppUserId, managementURL, originalPurchaseDate);
    }

    public static void getActiveSubscriptions$annotations() {
    }

    public static void getAllPurchasedSkus$annotations() {
    }

    public static void getLatestExpirationDate$annotations() {
    }

    public static void getNonSubscriptionTransactions$annotations() {
    }

    public static void getPurchasedNonSubscriptionSkus$annotations() {
    }

    private static void getSubscriberJSONObject$annotations() {
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.EntitlementInfos component1() {
        return this.entitlements;
    }

    @Override // android.os.Parcelable
    public final Uri component10() {
        return this.managementURL;
    }

    @Override // android.os.Parcelable
    public final Date component11() {
        return this.originalPurchaseDate;
    }

    public final Set<String> component2() {
        return this.purchasedNonSubscriptionSkus;
    }

    public final Map<String, Date> component3() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> component4() {
        return this.allPurchaseDatesByProduct;
    }

    @Override // android.os.Parcelable
    public final Date component5() {
        return this.requestDate;
    }

    @Override // android.os.Parcelable
    public final JSONObject component6() {
        return this.jsonObject;
    }

    @Override // android.os.Parcelable
    public final int component7() {
        return this.schemaVersion;
    }

    @Override // android.os.Parcelable
    public final Date component8() {
        return this.firstSeen;
    }

    @Override // android.os.Parcelable
    public final String component9() {
        return this.originalAppUserId;
    }

    public final com.revenuecat.purchases.PurchaserInfo copy(com.revenuecat.purchases.EntitlementInfos entitlementInfos, Set<String> set2, Map<String, ? extends Date> map3, Map<String, ? extends Date> map4, Date date5, JSONObject jSONObject6, int i7, Date date8, String string9, Uri uri10, Date date11) {
        n.f(entitlementInfos, "entitlements");
        n.f(set2, "purchasedNonSubscriptionSkus");
        final Object obj = map3;
        n.f(obj, "allExpirationDatesByProduct");
        final Object obj2 = map4;
        n.f(obj2, "allPurchaseDatesByProduct");
        final Object obj3 = date5;
        n.f(obj3, "requestDate");
        final Object obj4 = jSONObject6;
        n.f(obj4, "jsonObject");
        final Object obj5 = date8;
        n.f(obj5, "firstSeen");
        final Object obj6 = string9;
        n.f(obj6, "originalAppUserId");
        super(entitlementInfos, set2, obj, obj2, obj3, obj4, i7, obj5, obj6, uri10, date11);
        return purchaserInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null) {
            class = object.getClass();
        } else {
            class = 0;
        }
        int i8 = 0;
        if (z ^= i != 0) {
            return i8;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.PurchaserInfo");
        if (z2 ^= i != 0) {
            return i8;
        }
        if (z3 ^= i != 0) {
            return i8;
        }
        if (z4 ^= i != 0) {
            return i8;
        }
        if (z5 ^= i != 0) {
            return i8;
        }
        if (this.schemaVersion != object.schemaVersion) {
            return i8;
        }
        if (z6 ^= i != 0) {
            return i8;
        }
        if (obj5 ^= i != 0) {
            return i8;
        }
        return i;
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set)this.activeSubscriptions$delegate.getValue();
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set)this.allPurchasedSkus$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    @Override // android.os.Parcelable
    public final Date getExpirationDateForEntitlement(String string) {
        Date obj2;
        n.f(string, "entitlement");
        obj2 = this.entitlements.getAll().get(string);
        if ((EntitlementInfo)obj2 != null) {
            obj2 = (EntitlementInfo)obj2.getExpirationDate();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // android.os.Parcelable
    public final Date getExpirationDateForSku(String string) {
        n.f(string, "sku");
        return (Date)this.allExpirationDatesByProduct.get(string);
    }

    @Override // android.os.Parcelable
    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    @Override // android.os.Parcelable
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @Override // android.os.Parcelable
    public final Date getLatestExpirationDate() {
        return (Date)this.latestExpirationDate$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List)this.nonSubscriptionTransactions$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    @Override // android.os.Parcelable
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    @Override // android.os.Parcelable
    public final Date getPurchaseDateForEntitlement(String string) {
        Date obj2;
        n.f(string, "entitlement");
        obj2 = this.entitlements.getAll().get(string);
        if ((EntitlementInfo)obj2 != null) {
            obj2 = (EntitlementInfo)obj2.getLatestPurchaseDate();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // android.os.Parcelable
    public final Date getPurchaseDateForSku(String string) {
        n.f(string, "sku");
        return (Date)this.allPurchaseDatesByProduct.get(string);
    }

    public final Set<String> getPurchasedNonSubscriptionSkus() {
        return this.purchasedNonSubscriptionSkus;
    }

    @Override // android.os.Parcelable
    public final Date getRequestDate() {
        return this.requestDate;
    }

    @Override // android.os.Parcelable
    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i16 += i24;
    }

    @Override // android.os.Parcelable
    public String toString() {
        Set activeSubscriptions;
        Map map;
        int string2;
        int string;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<PurchaserInfo\n ");
        stringBuilder.append("latestExpirationDate: ");
        stringBuilder.append(getLatestExpirationDate());
        int i = 10;
        stringBuilder.append(i);
        stringBuilder.append("activeSubscriptions:  ");
        activeSubscriptions = getActiveSubscriptions();
        ArrayList arrayList = new ArrayList(p.r(activeSubscriptions, i));
        Iterator iterator = activeSubscriptions.iterator();
        for (String next2 : iterator) {
            arrayList.add(u.a(next2, j0.e(u.a("expiresDate", getExpirationDateForSku(next2)))));
        }
        stringBuilder.append(j0.s(arrayList));
        String str4 = ",\n";
        stringBuilder.append(str4);
        stringBuilder.append("activeEntitlements: ");
        Map active = this.entitlements.getActive();
        ArrayList arrayList2 = new ArrayList(active.size());
        Iterator iterator2 = active.entrySet().iterator();
        for (Map.Entry next6 : iterator2) {
            arrayList2.add(next6.toString());
        }
        stringBuilder.append(arrayList2);
        stringBuilder.append(str4);
        stringBuilder.append("entitlements: ");
        Map all = this.entitlements.getAll();
        ArrayList arrayList3 = new ArrayList(all.size());
        Iterator iterator3 = all.entrySet().iterator();
        for (Map.Entry next5 : iterator3) {
            arrayList3.add(next5.toString());
        }
        stringBuilder.append(arrayList3);
        stringBuilder.append(str4);
        stringBuilder.append("nonSubscriptionTransactions: ");
        stringBuilder.append(getNonSubscriptionTransactions());
        stringBuilder.append(str4);
        stringBuilder.append("requestDate: ");
        stringBuilder.append(this.requestDate);
        stringBuilder.append("\n>");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        int value2;
        int value;
        Object key;
        n.f(parcel, "parcel");
        this.entitlements.writeToParcel(parcel, 0);
        Set purchasedNonSubscriptionSkus = this.purchasedNonSubscriptionSkus;
        parcel.writeInt(purchasedNonSubscriptionSkus.size());
        Iterator iterator = purchasedNonSubscriptionSkus.iterator();
        for (String size : iterator) {
            parcel.writeString(size);
        }
        Map allExpirationDatesByProduct = this.allExpirationDatesByProduct;
        parcel.writeInt(allExpirationDatesByProduct.size());
        Iterator iterator2 = allExpirationDatesByProduct.entrySet().iterator();
        for (Object next5 : iterator2) {
            parcel.writeString((String)next5.getKey());
            parcel.writeSerializable((Date)next5.getValue());
        }
        Map allPurchaseDatesByProduct = this.allPurchaseDatesByProduct;
        parcel.writeInt(allPurchaseDatesByProduct.size());
        Iterator iterator3 = allPurchaseDatesByProduct.entrySet().iterator();
        for (Object next4 : iterator3) {
            parcel.writeString((String)next4.getKey());
            parcel.writeSerializable((Date)next4.getValue());
        }
        parcel.writeSerializable(this.requestDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, i2);
        parcel.writeInt(this.schemaVersion);
        parcel.writeSerializable(this.firstSeen);
        parcel.writeString(this.originalAppUserId);
        parcel.writeParcelable(this.managementURL, i2);
        parcel.writeSerializable(this.originalPurchaseDate);
    }
}
