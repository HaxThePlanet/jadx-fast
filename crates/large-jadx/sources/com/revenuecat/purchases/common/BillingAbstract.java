package com.revenuecat.purchases.common;

import android.app.Activity;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.ProductDetails;
import com.revenuecat.purchases.models.PurchaseDetails;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008&\u0018\u00002\u00020\u0001:\u0002BCB\u0007¢\u0006\u0004\u0008A\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0004JI\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00020\u00082\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00020\u0008j\u0002`\rH&¢\u0006\u0004\u0008\u000f\u0010\u0010J[\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00132\u001c\u0010\u0017\u001a\u0018\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\t\u0012\u0004\u0012\u00020\u00020\u0008j\u0002`\u00162\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00020\u0008j\u0002`\rH&¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nH&¢\u0006\u0004\u0008\u001e\u0010\u001fJO\u0010\"\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00082\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00020\u0008H&¢\u0006\u0004\u0008\"\u0010#J;\u0010*\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00152\u0008\u0010(\u001a\u0004\u0018\u00010'2\u0008\u0010)\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\u0008*\u0010+J\u000f\u0010,\u001a\u00020\u001bH&¢\u0006\u0004\u0008,\u0010-JK\u00100\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0.\u0012\u0004\u0012\u00020\u00020\u00082\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00020\u0008H&¢\u0006\u0004\u00080\u0010\u0010R.\u00103\u001a\u0004\u0018\u0001012\u0008\u00102\u001a\u0004\u0018\u0001018F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u00083\u00104\u001a\u0004\u00085\u00106\"\u0004\u00087\u00108R.\u0010;\u001a\u0004\u0018\u0001092\u0008\u0010:\u001a\u0004\u0018\u0001098F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008;\u0010<\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@¨\u0006D", d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract;", "", "Lkotlin/w;", "startConnection", "()V", "endConnection", "", "appUserID", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "onReceivePurchaseHistory", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onReceivePurchaseHistoryError", "queryAllPurchases", "(Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "Lcom/revenuecat/purchases/ProductType;", "productType", "", "skus", "Lcom/revenuecat/purchases/models/ProductDetails;", "Lcom/revenuecat/purchases/common/ProductDetailsListCallback;", "onReceive", "onError", "querySkuDetailsAsync", "(Lcom/revenuecat/purchases/ProductType;Ljava/util/Set;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "", "shouldTryToConsume", "purchase", "consumeAndSave", "(ZLcom/revenuecat/purchases/models/PurchaseDetails;)V", "sku", "onCompletion", "findPurchaseInPurchaseHistory", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "Landroid/app/Activity;", "activity", "productDetails", "Lcom/revenuecat/purchases/common/ReplaceSkuInfo;", "replaceSkuInfo", "presentedOfferingIdentifier", "makePurchaseAsync", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/common/ReplaceSkuInfo;Ljava/lang/String;)V", "isConnected", "()Z", "", "onSuccess", "queryPurchases", "Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "<set-?>", "stateListener", "Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "getStateListener", "()Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "setStateListener", "(Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;)V", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "value", "purchasesUpdatedListener", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "getPurchasesUpdatedListener", "()Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "setPurchasesUpdatedListener", "(Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;)V", "<init>", "PurchasesUpdatedListener", "StateListener", "common_release"}, k = 1, mv = {1, 4, 0})
public abstract class BillingAbstract {

    private volatile com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
    private volatile com.revenuecat.purchases.common.BillingAbstract.StateListener stateListener;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0008H&¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "purchases", "Lkotlin/w;", "onPurchasesUpdated", "(Ljava/util/List;)V", "Lcom/revenuecat/purchases/PurchasesError;", "purchasesError", "onPurchasesFailedToUpdate", "(Lcom/revenuecat/purchases/PurchasesError;)V", "common_release"}, k = 1, mv = {1, 4, 0})
    public interface PurchasesUpdatedListener {
        public abstract void onPurchasesFailedToUpdate(PurchasesError purchasesError);

        public abstract void onPurchasesUpdated(List<PurchaseDetails> list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"Lcom/revenuecat/purchases/common/BillingAbstract$StateListener;", "", "Lkotlin/w;", "onConnected", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
    public interface StateListener {
        public abstract void onConnected();
    }
    public abstract void consumeAndSave(boolean z, PurchaseDetails purchaseDetails2);

    public abstract void endConnection();

    public abstract void findPurchaseInPurchaseHistory(String string, ProductType productType2, String string3, l<? super PurchaseDetails, w> l4, l<? super PurchasesError, w> l5);

    public final com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return this.purchasesUpdatedListener;
        synchronized (this) {
            return this.purchasesUpdatedListener;
        }
    }

    public final com.revenuecat.purchases.common.BillingAbstract.StateListener getStateListener() {
        return this.stateListener;
        synchronized (this) {
            return this.stateListener;
        }
    }

    public abstract boolean isConnected();

    public abstract void makePurchaseAsync(Activity activity, String string2, ProductDetails productDetails3, com.revenuecat.purchases.common.ReplaceSkuInfo replaceSkuInfo4, String string5);

    public abstract void queryAllPurchases(String string, l<? super List<PurchaseDetails>, w> l2, l<? super PurchasesError, w> l3);

    public abstract void queryPurchases(String string, l<? super Map<String, PurchaseDetails>, w> l2, l<? super PurchasesError, w> l3);

    public abstract void querySkuDetailsAsync(ProductType productType, Set<String> set2, l<? super List<ProductDetails>, w> l3, l<? super PurchasesError, w> l4);

    public final void setPurchasesUpdatedListener(com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener billingAbstract$PurchasesUpdatedListener) {
        this.purchasesUpdatedListener = purchasesUpdatedListener;
        final w wVar = w.a;
        synchronized (this) {
            this.purchasesUpdatedListener = purchasesUpdatedListener;
            wVar = w.a;
        }
        try {
            startConnection();
            endConnection();
            throw purchasesUpdatedListener;
        }
    }

    public final void setStateListener(com.revenuecat.purchases.common.BillingAbstract.StateListener billingAbstract$StateListener) {
        this.stateListener = stateListener;
        return;
        synchronized (this) {
            this.stateListener = stateListener;
        }
    }

    public abstract void startConnection();
}
