package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.UpdatedPurchaserInfoListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0015\u0008\u0080\u0008\u0018\u00002\u00020\u0001Ba\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0002\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\u00084\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008HÆ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0015\u0010\u0014Jj\u0010\u001d\u001a\u00020\u00002\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0014\u0008\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00082\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\u0008\"\u0010#J\u001a\u0010%\u001a\u00020\u00022\u0008\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008%\u0010&R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001b\u0010'\u001a\u0004\u0008(\u0010\u0014R%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00088\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0018\u0010)\u001a\u0004\u0008*\u0010\u000cR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0016\u0010+\u001a\u0004\u0008,\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001a\u0010-\u001a\u0004\u0008.\u0010\u0012R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010'\u001a\u0004\u0008/\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0019\u00100\u001a\u0004\u00081\u0010\u000fR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u00102\u001a\u0004\u00083\u0010\u0007¨\u00066", d2 = {"Lcom/revenuecat/purchases/PurchasesState;", "", "", "component1", "()Ljava/lang/Boolean;", "Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;", "component2", "()Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;", "", "", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "component3", "()Ljava/util/Map;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "component4", "()Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/PurchaserInfo;", "component5", "()Lcom/revenuecat/purchases/PurchaserInfo;", "component6", "()Z", "component7", "allowSharingPlayStoreAccount", "updatedPurchaserInfoListener", "purchaseCallbacks", "productChangeCallback", "lastSentPurchaserInfo", "appInBackground", "firstTimeInForeground", "copy", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;Ljava/util/Map;Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;Lcom/revenuecat/purchases/PurchaserInfo;ZZ)Lcom/revenuecat/purchases/PurchasesState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAppInBackground", "Ljava/util/Map;", "getPurchaseCallbacks", "Ljava/lang/Boolean;", "getAllowSharingPlayStoreAccount", "Lcom/revenuecat/purchases/PurchaserInfo;", "getLastSentPurchaserInfo", "getFirstTimeInForeground", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "getProductChangeCallback", "Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;", "getUpdatedPurchaserInfoListener", "<init>", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;Ljava/util/Map;Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;Lcom/revenuecat/purchases/PurchaserInfo;ZZ)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class PurchasesState {

    private final Boolean allowSharingPlayStoreAccount;
    private final boolean appInBackground;
    private final boolean firstTimeInForeground;
    private final com.revenuecat.purchases.PurchaserInfo lastSentPurchaserInfo;
    private final ProductChangeCallback productChangeCallback;
    private final Map<String, PurchaseCallback> purchaseCallbacks;
    private final UpdatedPurchaserInfoListener updatedPurchaserInfoListener;
    public PurchasesState() {
        super(0, 0, 0, 0, 0, 0, 0, 127, 0);
    }

    public PurchasesState(Boolean boolean, UpdatedPurchaserInfoListener updatedPurchaserInfoListener2, Map<String, ? extends PurchaseCallback> map3, ProductChangeCallback productChangeCallback4, com.revenuecat.purchases.PurchaserInfo purchaserInfo5, boolean z6, boolean z7) {
        n.f(map3, "purchaseCallbacks");
        super();
        this.allowSharingPlayStoreAccount = boolean;
        this.updatedPurchaserInfoListener = updatedPurchaserInfoListener2;
        this.purchaseCallbacks = map3;
        this.productChangeCallback = productChangeCallback4;
        this.lastSentPurchaserInfo = purchaserInfo5;
        this.appInBackground = z6;
        this.firstTimeInForeground = z7;
    }

    public PurchasesState(Boolean boolean, UpdatedPurchaserInfoListener updatedPurchaserInfoListener2, Map map3, ProductChangeCallback productChangeCallback4, com.revenuecat.purchases.PurchaserInfo purchaserInfo5, boolean z6, boolean z7, int i8, g g9) {
        int i4;
        int i2;
        int i3;
        int i;
        Map obj8;
        int obj13;
        int obj14;
        i4 = 0;
        obj14 = i8 & 1 != 0 ? i4 : boolean;
        i2 = i8 & 2 != 0 ? i4 : updatedPurchaserInfoListener2;
        if (i8 & 4 != 0) {
            obj8 = j0.h();
        }
        i3 = i8 & 8 != 0 ? i4 : productChangeCallback4;
        if (i8 & 16 != 0) {
        } else {
            i4 = purchaserInfo5;
        }
        int obj7 = 1;
        i = i8 & 32 != 0 ? obj7 : z6;
        obj13 = i8 & 64 != 0 ? obj7 : z7;
        super(obj14, i2, obj8, i3, i4, i, obj13);
    }

    public static com.revenuecat.purchases.PurchasesState copy$default(com.revenuecat.purchases.PurchasesState purchasesState, Boolean boolean2, UpdatedPurchaserInfoListener updatedPurchaserInfoListener3, Map map4, ProductChangeCallback productChangeCallback5, com.revenuecat.purchases.PurchaserInfo purchaserInfo6, boolean z7, boolean z8, int i9, Object object10) {
        Boolean obj6;
        UpdatedPurchaserInfoListener obj7;
        Map obj8;
        ProductChangeCallback obj9;
        com.revenuecat.purchases.PurchaserInfo obj10;
        boolean obj11;
        boolean obj12;
        if (i9 & 1 != 0) {
            obj6 = purchasesState.allowSharingPlayStoreAccount;
        }
        if (i9 & 2 != 0) {
            obj7 = purchasesState.updatedPurchaserInfoListener;
        }
        if (i9 & 4 != 0) {
            obj8 = purchasesState.purchaseCallbacks;
        }
        if (i9 & 8 != 0) {
            obj9 = purchasesState.productChangeCallback;
        }
        if (i9 & 16 != 0) {
            obj10 = purchasesState.lastSentPurchaserInfo;
        }
        if (i9 & 32 != 0) {
            obj11 = purchasesState.appInBackground;
        }
        if (i9 & 64 != 0) {
            obj12 = purchasesState.firstTimeInForeground;
        }
        return purchasesState.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    public final Boolean component1() {
        return this.allowSharingPlayStoreAccount;
    }

    public final UpdatedPurchaserInfoListener component2() {
        return this.updatedPurchaserInfoListener;
    }

    public final Map<String, PurchaseCallback> component3() {
        return this.purchaseCallbacks;
    }

    public final ProductChangeCallback component4() {
        return this.productChangeCallback;
    }

    public final com.revenuecat.purchases.PurchaserInfo component5() {
        return this.lastSentPurchaserInfo;
    }

    public final boolean component6() {
        return this.appInBackground;
    }

    public final boolean component7() {
        return this.firstTimeInForeground;
    }

    public final com.revenuecat.purchases.PurchasesState copy(Boolean boolean, UpdatedPurchaserInfoListener updatedPurchaserInfoListener2, Map<String, ? extends PurchaseCallback> map3, ProductChangeCallback productChangeCallback4, com.revenuecat.purchases.PurchaserInfo purchaserInfo5, boolean z6, boolean z7) {
        n.f(map3, "purchaseCallbacks");
        super(boolean, updatedPurchaserInfoListener2, map3, productChangeCallback4, purchaserInfo5, z6, z7);
        return purchasesState;
    }

    public boolean equals(Object object) {
        boolean firstTimeInForeground;
        boolean allowSharingPlayStoreAccount;
        Object obj3;
        if (this != (PurchasesState)object && object instanceof PurchasesState && n.b(this.allowSharingPlayStoreAccount, object.allowSharingPlayStoreAccount) && n.b(this.updatedPurchaserInfoListener, object.updatedPurchaserInfoListener) && n.b(this.purchaseCallbacks, object.purchaseCallbacks) && n.b(this.productChangeCallback, object.productChangeCallback) && n.b(this.lastSentPurchaserInfo, object.lastSentPurchaserInfo) && this.appInBackground == object.appInBackground && this.firstTimeInForeground == object.firstTimeInForeground) {
            if (object instanceof PurchasesState) {
                if (n.b(this.allowSharingPlayStoreAccount, object.allowSharingPlayStoreAccount)) {
                    if (n.b(this.updatedPurchaserInfoListener, object.updatedPurchaserInfoListener)) {
                        if (n.b(this.purchaseCallbacks, object.purchaseCallbacks)) {
                            if (n.b(this.productChangeCallback, object.productChangeCallback)) {
                                if (n.b(this.lastSentPurchaserInfo, object.lastSentPurchaserInfo)) {
                                    if (this.appInBackground == object.appInBackground) {
                                        if (this.firstTimeInForeground == object.firstTimeInForeground) {
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

    public final Boolean getAllowSharingPlayStoreAccount() {
        return this.allowSharingPlayStoreAccount;
    }

    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final boolean getFirstTimeInForeground() {
        return this.firstTimeInForeground;
    }

    public final com.revenuecat.purchases.PurchaserInfo getLastSentPurchaserInfo() {
        return this.lastSentPurchaserInfo;
    }

    public final ProductChangeCallback getProductChangeCallback() {
        return this.productChangeCallback;
    }

    public final Map<String, PurchaseCallback> getPurchaseCallbacks() {
        return this.purchaseCallbacks;
    }

    public final UpdatedPurchaserInfoListener getUpdatedPurchaserInfoListener() {
        return this.updatedPurchaserInfoListener;
    }

    public int hashCode() {
        int i6;
        int i3;
        boolean appInBackground;
        int i4;
        int i5;
        int i;
        int i2;
        Boolean allowSharingPlayStoreAccount = this.allowSharingPlayStoreAccount;
        i3 = 0;
        if (allowSharingPlayStoreAccount != null) {
            i6 = allowSharingPlayStoreAccount.hashCode();
        } else {
            i6 = i3;
        }
        UpdatedPurchaserInfoListener updatedPurchaserInfoListener = this.updatedPurchaserInfoListener;
        if (updatedPurchaserInfoListener != null) {
            i4 = updatedPurchaserInfoListener.hashCode();
        } else {
            i4 = i3;
        }
        Map purchaseCallbacks = this.purchaseCallbacks;
        if (purchaseCallbacks != null) {
            i5 = purchaseCallbacks.hashCode();
        } else {
            i5 = i3;
        }
        ProductChangeCallback productChangeCallback = this.productChangeCallback;
        if (productChangeCallback != null) {
            i = productChangeCallback.hashCode();
        } else {
            i = i3;
        }
        com.revenuecat.purchases.PurchaserInfo lastSentPurchaserInfo = this.lastSentPurchaserInfo;
        if (lastSentPurchaserInfo != null) {
            i3 = lastSentPurchaserInfo.hashCode();
        }
        if (this.appInBackground) {
            appInBackground = i2;
        }
        boolean firstTimeInForeground = this.firstTimeInForeground;
        if (firstTimeInForeground) {
        } else {
            i2 = firstTimeInForeground;
        }
        return i17 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PurchasesState(allowSharingPlayStoreAccount=");
        stringBuilder.append(this.allowSharingPlayStoreAccount);
        stringBuilder.append(", updatedPurchaserInfoListener=");
        stringBuilder.append(this.updatedPurchaserInfoListener);
        stringBuilder.append(", purchaseCallbacks=");
        stringBuilder.append(this.purchaseCallbacks);
        stringBuilder.append(", productChangeCallback=");
        stringBuilder.append(this.productChangeCallback);
        stringBuilder.append(", lastSentPurchaserInfo=");
        stringBuilder.append(this.lastSentPurchaserInfo);
        stringBuilder.append(", appInBackground=");
        stringBuilder.append(this.appInBackground);
        stringBuilder.append(", firstTimeInForeground=");
        stringBuilder.append(this.firstTimeInForeground);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
