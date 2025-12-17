package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.parceler.JSONObjectParceler;
import java.util.List;
import k.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001c\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bw\u0012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0008\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0008\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\u0008\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010&\u001a\u00020\u0016\u0012\u0008\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\u0008\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020\u001b¢\u0006\u0004\u0008R\u0010SJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0008HÆ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000c\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0098\u0001\u0010*\u001a\u00020\u00002\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u000e\u0008\u0002\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00052\u0008\u0008\u0002\u0010 \u001a\u00020\u00082\u0008\u0008\u0002\u0010!\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u00022\u0008\u0008\u0002\u0010#\u001a\u00020\u000f2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\u0008\u0008\u0002\u0010&\u001a\u00020\u00162\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\u0008\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\u0008\u0008\u0002\u0010)\u001a\u00020\u001bHÆ\u0001¢\u0006\u0004\u0008*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008,\u0010\u0004J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\u0008.\u0010/J\u001a\u00102\u001a\u00020\u00122\u0008\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\u00082\u00103J\u0010\u00104\u001a\u00020-HÖ\u0001¢\u0006\u0004\u00084\u0010/J \u00109\u001a\u0002082\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020-HÖ\u0001¢\u0006\u0004\u00089\u0010:R\u001b\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008(\u0010;\u001a\u0004\u0008<\u0010\u0004R\u001b\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008%\u0010;\u001a\u0004\u0008=\u0010\u0004R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008!\u0010>\u001a\u0004\u0008?\u0010\rR\u0019\u0010#\u001a\u00020\u000f8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008#\u0010@\u001a\u0004\u0008A\u0010\u0011R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001e\u0010;\u001a\u0004\u0008B\u0010\u0004R\u0019\u0010&\u001a\u00020\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008&\u0010C\u001a\u0004\u0008D\u0010\u0018R\u001b\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008'\u0010;\u001a\u0004\u0008E\u0010\u0004R\u0019\u0010 \u001a\u00020\u00088\u0006@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010F\u001a\u0004\u0008G\u0010\nR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010;\u001a\u0004\u0008H\u0010\u0004R\u0019\u0010)\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008)\u0010I\u001a\u0004\u0008J\u0010\u001dR\u001b\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000c\n\u0004\u0008$\u0010K\u001a\u0004\u0008$\u0010\u0014R\u001c\u0010O\u001a\u00020\u00028F@\u0007X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008M\u0010N\u001a\u0004\u0008L\u0010\u0004R\u001f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001f\u0010P\u001a\u0004\u0008Q\u0010\u0007¨\u0006T", d2 = {"Lcom/revenuecat/purchases/models/PurchaseDetails;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "Lcom/revenuecat/purchases/ProductType;", "component3", "()Lcom/revenuecat/purchases/ProductType;", "", "component4", "()J", "component5", "Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;", "component6", "()Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;", "", "component7", "()Ljava/lang/Boolean;", "component8", "Lorg/json/JSONObject;", "component9", "()Lorg/json/JSONObject;", "component10", "component11", "Lcom/revenuecat/purchases/models/PurchaseType;", "component12", "()Lcom/revenuecat/purchases/models/PurchaseType;", "orderId", "skus", "type", "purchaseTime", "purchaseToken", "purchaseState", "isAutoRenewing", "signature", "originalJson", "presentedOfferingIdentifier", "storeUserID", "purchaseType", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;)Lcom/revenuecat/purchases/models/PurchaseDetails;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getStoreUserID", "getSignature", "J", "getPurchaseTime", "Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;", "getPurchaseState", "getOrderId", "Lorg/json/JSONObject;", "getOriginalJson", "getPresentedOfferingIdentifier", "Lcom/revenuecat/purchases/ProductType;", "getType", "getPurchaseToken", "Lcom/revenuecat/purchases/models/PurchaseType;", "getPurchaseType", "Ljava/lang/Boolean;", "getSku", "getSku$annotations", "()V", "sku", "Ljava/util/List;", "getSkus", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/RevenueCatPurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class PurchaseDetails implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final Boolean isAutoRenewing;
    private final String orderId;
    private final JSONObject originalJson;
    private final String presentedOfferingIdentifier;
    private final com.revenuecat.purchases.models.RevenueCatPurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final com.revenuecat.purchases.models.PurchaseType purchaseType;
    private final String signature;
    private final List<String> skus;
    private final String storeUserID;
    private final ProductType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            int i;
            int valueOf;
            Object obj = parcel;
            n.f(obj, "in");
            if (parcel.readInt() != 0) {
                i = parcel.readInt() != 0 ? 1 : 0;
                valueOf = Boolean.valueOf(i);
            } else {
                valueOf = 0;
            }
            super(parcel.readString(), parcel.createStringArrayList(), (ProductType)Enum.valueOf(ProductType.class, parcel.readString()), parcel.readLong(), obj7, parcel.readString(), (RevenueCatPurchaseState)Enum.valueOf(RevenueCatPurchaseState.class, parcel.readString()), valueOf, parcel.readString(), (JSONObject)JSONObjectParceler.INSTANCE.create(obj), parcel.readString(), parcel.readString(), (PurchaseType)Enum.valueOf(PurchaseType.class, parcel.readString()));
            return purchaseDetails;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new PurchaseDetails[i];
        }
    }
    static {
        PurchaseDetails.Creator creator = new PurchaseDetails.Creator();
        PurchaseDetails.CREATOR = creator;
    }

    public PurchaseDetails(String string, List<String> list2, ProductType productType3, long l4, String string5, com.revenuecat.purchases.models.RevenueCatPurchaseState revenueCatPurchaseState6, Boolean boolean7, String string8, JSONObject jSONObject9, String string10, String string11, com.revenuecat.purchases.models.PurchaseType purchaseType12) {
        n.f(list2, "skus");
        n.f(productType3, "type");
        n.f(revenueCatPurchaseState6, "purchaseToken");
        n.f(boolean7, "purchaseState");
        n.f(string10, "originalJson");
        n.f(obj14, "purchaseType");
        super();
        this.orderId = string;
        this.skus = list2;
        this.type = productType3;
        this.purchaseTime = l4;
        this.purchaseToken = revenueCatPurchaseState6;
        this.purchaseState = boolean7;
        this.isAutoRenewing = string8;
        this.signature = jSONObject9;
        this.originalJson = string10;
        this.presentedOfferingIdentifier = string11;
        this.storeUserID = purchaseType12;
        this.purchaseType = obj14;
    }

    public static com.revenuecat.purchases.models.PurchaseDetails copy$default(com.revenuecat.purchases.models.PurchaseDetails purchaseDetails, String string2, List list3, ProductType productType4, long l5, String string6, com.revenuecat.purchases.models.RevenueCatPurchaseState revenueCatPurchaseState7, Boolean boolean8, String string9, JSONObject jSONObject10, String string11, String string12, com.revenuecat.purchases.models.PurchaseType purchaseType13, int i14, Object object15) {
        com.revenuecat.purchases.models.PurchaseType purchaseType;
        String orderId;
        List skus;
        ProductType type;
        long purchaseTime;
        String purchaseToken;
        com.revenuecat.purchases.models.RevenueCatPurchaseState purchaseState;
        Boolean isAutoRenewing;
        String signature;
        JSONObject originalJson;
        String presentedOfferingIdentifier;
        String storeUserID;
        Object obj = purchaseDetails;
        int i = object15;
        orderId = i & 1 != 0 ? obj.orderId : string2;
        skus = i & 2 != 0 ? obj.skus : list3;
        type = i & 4 != 0 ? obj.type : productType4;
        purchaseTime = i & 8 != 0 ? obj.purchaseTime : l5;
        purchaseToken = i & 16 != 0 ? obj.purchaseToken : revenueCatPurchaseState7;
        purchaseState = i & 32 != 0 ? obj.purchaseState : boolean8;
        isAutoRenewing = i & 64 != 0 ? obj.isAutoRenewing : string9;
        signature = i & 128 != 0 ? obj.signature : jSONObject10;
        originalJson = i & 256 != 0 ? obj.originalJson : string11;
        presentedOfferingIdentifier = i & 512 != 0 ? obj.presentedOfferingIdentifier : string12;
        storeUserID = i & 1024 != 0 ? obj.storeUserID : purchaseType13;
        purchaseType = i &= 2048 != 0 ? obj.purchaseType : i14;
        return purchaseDetails.copy(orderId, skus, type, purchaseTime, string6, purchaseToken, purchaseState, isAutoRenewing, signature, originalJson, presentedOfferingIdentifier, storeUserID);
    }

    public static void getSku$annotations() {
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.orderId;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.presentedOfferingIdentifier;
    }

    @Override // android.os.Parcelable
    public final String component11() {
        return this.storeUserID;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.models.PurchaseType component12() {
        return this.purchaseType;
    }

    public final List<String> component2() {
        return this.skus;
    }

    @Override // android.os.Parcelable
    public final ProductType component3() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final long component4() {
        return this.purchaseTime;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.purchaseToken;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.models.RevenueCatPurchaseState component6() {
        return this.purchaseState;
    }

    @Override // android.os.Parcelable
    public final Boolean component7() {
        return this.isAutoRenewing;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.signature;
    }

    @Override // android.os.Parcelable
    public final JSONObject component9() {
        return this.originalJson;
    }

    public final com.revenuecat.purchases.models.PurchaseDetails copy(String string, List<String> list2, ProductType productType3, long l4, String string5, com.revenuecat.purchases.models.RevenueCatPurchaseState revenueCatPurchaseState6, Boolean boolean7, String string8, JSONObject jSONObject9, String string10, String string11, com.revenuecat.purchases.models.PurchaseType purchaseType12) {
        final Object obj = list2;
        n.f(obj, "skus");
        final Object obj2 = productType3;
        n.f(obj2, "type");
        final Object obj3 = revenueCatPurchaseState6;
        n.f(obj3, "purchaseToken");
        final Object obj4 = boolean7;
        n.f(obj4, "purchaseState");
        final Object obj5 = string10;
        n.f(obj5, "originalJson");
        final Object obj6 = obj28;
        n.f(obj6, "purchaseType");
        super(string, obj, obj2, l4, obj6, obj3, obj4, string8, jSONObject9, obj5, string11, purchaseType12, obj6);
        return purchaseDetails;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        boolean purchaseType;
        Object presentedOfferingIdentifier;
        long purchaseTime;
        Object obj5;
        if (this != (PurchaseDetails)object && object instanceof PurchaseDetails && n.b(this.orderId, object.orderId) && n.b(this.skus, object.skus) && n.b(this.type, object.type) && Long.compare(purchaseTime2, purchaseTime) == 0 && n.b(this.purchaseToken, object.purchaseToken) && n.b(this.purchaseState, object.purchaseState) && n.b(this.isAutoRenewing, object.isAutoRenewing) && n.b(this.signature, object.signature) && n.b(this.originalJson, object.originalJson) && n.b(this.presentedOfferingIdentifier, object.presentedOfferingIdentifier) && n.b(this.storeUserID, object.storeUserID) && n.b(this.purchaseType, object.purchaseType)) {
            if (object instanceof PurchaseDetails) {
                if (n.b(this.orderId, object.orderId)) {
                    if (n.b(this.skus, object.skus)) {
                        if (n.b(this.type, object.type)) {
                            if (Long.compare(purchaseTime2, purchaseTime) == 0) {
                                if (n.b(this.purchaseToken, object.purchaseToken)) {
                                    if (n.b(this.purchaseState, object.purchaseState)) {
                                        if (n.b(this.isAutoRenewing, object.isAutoRenewing)) {
                                            if (n.b(this.signature, object.signature)) {
                                                if (n.b(this.originalJson, object.originalJson)) {
                                                    if (n.b(this.presentedOfferingIdentifier, object.presentedOfferingIdentifier)) {
                                                        if (n.b(this.storeUserID, object.storeUserID)) {
                                                            if (n.b(this.purchaseType, object.purchaseType)) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public final String getOrderId() {
        return this.orderId;
    }

    @Override // android.os.Parcelable
    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    @Override // android.os.Parcelable
    public final String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.models.RevenueCatPurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    @Override // android.os.Parcelable
    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    @Override // android.os.Parcelable
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.models.PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    @Override // android.os.Parcelable
    public final String getSignature() {
        return this.signature;
    }

    @Override // android.os.Parcelable
    public final String getSku() {
        return (String)this.skus.get(0);
    }

    public final List<String> getSkus() {
        return this.skus;
    }

    @Override // android.os.Parcelable
    public final String getStoreUserID() {
        return this.storeUserID;
    }

    @Override // android.os.Parcelable
    public final ProductType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i7;
        int i2;
        int i5;
        int i8;
        int i11;
        int i6;
        int i3;
        int i10;
        int i4;
        int i9;
        String orderId = this.orderId;
        i7 = 0;
        if (orderId != null) {
            i = orderId.hashCode();
        } else {
            i = i7;
        }
        List skus = this.skus;
        if (skus != null) {
            i2 = skus.hashCode();
        } else {
            i2 = i7;
        }
        ProductType type = this.type;
        if (type != null) {
            i5 = type.hashCode();
        } else {
            i5 = i7;
        }
        long purchaseTime = this.purchaseTime;
        String purchaseToken = this.purchaseToken;
        if (purchaseToken != null) {
            i8 = purchaseToken.hashCode();
        } else {
            i8 = i7;
        }
        com.revenuecat.purchases.models.RevenueCatPurchaseState purchaseState = this.purchaseState;
        if (purchaseState != null) {
            i11 = purchaseState.hashCode();
        } else {
            i11 = i7;
        }
        Boolean isAutoRenewing = this.isAutoRenewing;
        if (isAutoRenewing != null) {
            i6 = isAutoRenewing.hashCode();
        } else {
            i6 = i7;
        }
        String signature = this.signature;
        if (signature != null) {
            i3 = signature.hashCode();
        } else {
            i3 = i7;
        }
        JSONObject originalJson = this.originalJson;
        if (originalJson != null) {
            i10 = originalJson.hashCode();
        } else {
            i10 = i7;
        }
        String presentedOfferingIdentifier = this.presentedOfferingIdentifier;
        if (presentedOfferingIdentifier != null) {
            i4 = presentedOfferingIdentifier.hashCode();
        } else {
            i4 = i7;
        }
        String storeUserID = this.storeUserID;
        if (storeUserID != null) {
            i9 = storeUserID.hashCode();
        } else {
            i9 = i7;
        }
        com.revenuecat.purchases.models.PurchaseType purchaseType = this.purchaseType;
        if (purchaseType != null) {
            i7 = purchaseType.hashCode();
        }
        return i32 += i7;
    }

    @Override // android.os.Parcelable
    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PurchaseDetails(orderId=");
        stringBuilder.append(this.orderId);
        stringBuilder.append(", skus=");
        stringBuilder.append(this.skus);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", purchaseTime=");
        stringBuilder.append(this.purchaseTime);
        stringBuilder.append(", purchaseToken=");
        stringBuilder.append(this.purchaseToken);
        stringBuilder.append(", purchaseState=");
        stringBuilder.append(this.purchaseState);
        stringBuilder.append(", isAutoRenewing=");
        stringBuilder.append(this.isAutoRenewing);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append(", originalJson=");
        stringBuilder.append(this.originalJson);
        stringBuilder.append(", presentedOfferingIdentifier=");
        stringBuilder.append(this.presentedOfferingIdentifier);
        stringBuilder.append(", storeUserID=");
        stringBuilder.append(this.storeUserID);
        stringBuilder.append(", purchaseType=");
        stringBuilder.append(this.purchaseType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        boolean booleanValue;
        int i;
        n.f(parcel, "parcel");
        parcel.writeString(this.orderId);
        parcel.writeStringList(this.skus);
        parcel.writeString(this.type.name());
        parcel.writeLong(this.purchaseTime);
        parcel.writeString(this.purchaseToken);
        parcel.writeString(this.purchaseState.name());
        Boolean isAutoRenewing = this.isAutoRenewing;
        if (isAutoRenewing != null) {
            parcel.writeInt(1);
            booleanValue = isAutoRenewing.booleanValue();
        } else {
            booleanValue = 0;
        }
        parcel.writeInt(booleanValue);
        parcel.writeString(this.signature);
        JSONObjectParceler.INSTANCE.write(this.originalJson, parcel, i2);
        parcel.writeString(this.presentedOfferingIdentifier);
        parcel.writeString(this.storeUserID);
        parcel.writeString(this.purchaseType.name());
    }
}
