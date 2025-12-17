package com.revenuecat.purchases.google;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase.a;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.c;
import com.android.billingclient.api.c.b;
import com.android.billingclient.api.e;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.android.billingclient.api.k;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener;
import com.revenuecat.purchases.common.ErrorsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceSkuInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.models.ProductDetails;
import com.revenuecat.purchases.models.PurchaseDetails;
import com.revenuecat.purchases.models.RevenueCatPurchaseState;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001wB\u001f\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010s\u001a\u00020r¢\u0006\u0004\u0008u\u0010vJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J%\u0010\n\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0012\u0004\u0012\u00020\u00040\u0007H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J-\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001a*\u0008\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\u0008\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u0007H\u0002¢\u0006\u0004\u0008 \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0004\u0008!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008$\u0010\u0006J[\u0010.\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00180'2\u001c\u0010+\u001a\u0018\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u0016\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`*2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`,H\u0016¢\u0006\u0004\u0008.\u0010/J;\u00105\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000c2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020)2\u0008\u00103\u001a\u0004\u0018\u0001022\u0008\u00104\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\u00085\u00106JC\u0010:\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0018\u00108\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002070\u0016\u0012\u0004\u0012\u00020\u00040\u00072\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\u0008:\u0010;JE\u0010<\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00182\u0018\u00108\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u0016\u0012\u0004\u0012\u00020\u00040\u00072\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\u0008<\u0010;J\u001f\u0010?\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u001bH\u0016¢\u0006\u0004\u0008?\u0010@J1\u0010G\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00182\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040BH\u0000¢\u0006\u0004\u0008E\u0010FJ1\u0010J\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00182\u0018\u0010H\u001a\u0014\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040BH\u0000¢\u0006\u0004\u0008I\u0010FJK\u0010L\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00182\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00040\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\u0008L\u0010;JO\u0010O\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00182\u0006\u0010&\u001a\u00020%2\u0006\u0010M\u001a\u00020\u00182\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\u0008O\u0010PJ\u0017\u0010T\u001a\u00020%2\u0006\u0010Q\u001a\u00020\u0018H\u0000¢\u0006\u0004\u0008R\u0010SJ'\u0010W\u001a\u00020\u00042\u0006\u0010U\u001a\u00020C2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016¢\u0006\u0004\u0008W\u0010XJ\u0017\u0010Y\u001a\u00020\u00042\u0006\u0010U\u001a\u00020CH\u0016¢\u0006\u0004\u0008Y\u0010ZJ\u000f\u0010[\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008[\u0010\u0006J\u000f\u0010\\\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\\\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008_\u0010`R\"\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020%0a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008b\u0010cR.\u0010e\u001a\u0004\u0018\u00010\u001e2\u0008\u0010d\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008e\u0010f\u001a\u0004\u0008g\u0010h\"\u0004\u0008i\u0010jR$\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008k\u0010cR*\u0010m\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0012\u0004\u0012\u00020\u00040\u00070l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008m\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008p\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008s\u0010t¨\u0006x", d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/android/billingclient/api/k;", "Lcom/android/billingclient/api/e;", "Lkotlin/w;", "executePendingRequests", "()V", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "request", "executeRequestOnUIThread", "(Lkotlin/d0/c/l;)V", "Landroid/app/Activity;", "activity", "Lcom/android/billingclient/api/f;", "params", "launchBillingFlow", "(Landroid/app/Activity;Lcom/android/billingclient/api/f;)V", "Lcom/android/billingclient/api/Purchase$a;", "", "isSuccessful", "(Lcom/android/billingclient/api/Purchase$a;)Z", "", "Lcom/android/billingclient/api/Purchase;", "", "skuType", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "toMapOfGooglePurchaseWrapper", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;", "Lcom/android/billingclient/api/c;", "receivingFunction", "withConnectedClient", "getStackTrace", "()Ljava/lang/String;", "startConnection", "endConnection", "Lcom/revenuecat/purchases/ProductType;", "productType", "", "skus", "Lcom/revenuecat/purchases/models/ProductDetails;", "Lcom/revenuecat/purchases/common/ProductDetailsListCallback;", "onReceive", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onError", "querySkuDetailsAsync", "(Lcom/revenuecat/purchases/ProductType;Ljava/util/Set;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "appUserID", "productDetails", "Lcom/revenuecat/purchases/common/ReplaceSkuInfo;", "replaceSkuInfo", "presentedOfferingIdentifier", "makePurchaseAsync", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/common/ReplaceSkuInfo;Ljava/lang/String;)V", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "onReceivePurchaseHistory", "onReceivePurchaseHistoryError", "queryPurchaseHistoryAsync", "(Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "queryAllPurchases", "shouldTryToConsume", "purchase", "consumeAndSave", "(ZLcom/revenuecat/purchases/models/PurchaseDetails;)V", "token", "Lkotlin/Function2;", "Lcom/android/billingclient/api/g;", "onConsumed", "consumePurchase$google_release", "(Ljava/lang/String;Lkotlin/d0/c/p;)V", "consumePurchase", "onAcknowledged", "acknowledge$google_release", "acknowledge", "onSuccess", "queryPurchases", "sku", "onCompletion", "findPurchaseInPurchaseHistory", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "purchaseToken", "getPurchaseType$google_release", "(Ljava/lang/String;)Lcom/revenuecat/purchases/ProductType;", "getPurchaseType", "billingResult", "purchases", "onPurchasesUpdated", "(Lcom/android/billingclient/api/g;Ljava/util/List;)V", "onBillingSetupFinished", "(Lcom/android/billingclient/api/g;)V", "onBillingServiceDisconnected", "isConnected", "()Z", "Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "clientFactory", "Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "", "productTypes", "Ljava/util/Map;", "<set-?>", "billingClient", "Lcom/android/billingclient/api/c;", "getBillingClient", "()Lcom/android/billingclient/api/c;", "setBillingClient", "(Lcom/android/billingclient/api/c;)V", "presentedOfferingsByProductIdentifier", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "serviceRequests", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "<init>", "(Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;Landroid/os/Handler;Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "ClientFactory", "google_release"}, k = 1, mv = {1, 4, 0})
public final class BillingWrapper extends BillingAbstract implements k, e {

    private volatile c billingClient;
    private final com.revenuecat.purchases.google.BillingWrapper.ClientFactory clientFactory;
    private final DeviceCache deviceCache;
    private final Handler mainHandler;
    private final Map<String, String> presentedOfferingsByProductIdentifier;
    private final Map<String, ProductType> productTypes;
    private final ConcurrentLinkedQueue<l<PurchasesError, w>> serviceRequests;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lcom/revenuecat/purchases/google/BillingWrapper$ClientFactory;", "", "Lcom/android/billingclient/api/k;", "listener", "Lcom/android/billingclient/api/c;", "buildClient", "(Lcom/android/billingclient/api/k;)Lcom/android/billingclient/api/c;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "google_release"}, k = 1, mv = {1, 4, 0})
    public static final class ClientFactory {

        private final Context context;
        public ClientFactory(Context context) {
            n.f(context, "context");
            super();
            this.context = context;
        }

        public final c buildClient(k k) {
            n.f(k, "listener");
            c.b bVar = c.g(this.context);
            bVar.b();
            bVar.c(k);
            final c obj2 = bVar.a();
            n.e(obj2, "BillingClient.newBuilder…\n                .build()");
            return obj2;
        }
    }
    public BillingWrapper(com.revenuecat.purchases.google.BillingWrapper.ClientFactory billingWrapper$ClientFactory, Handler handler2, DeviceCache deviceCache3) {
        n.f(clientFactory, "clientFactory");
        n.f(handler2, "mainHandler");
        n.f(deviceCache3, "deviceCache");
        super();
        this.clientFactory = clientFactory;
        this.mainHandler = handler2;
        this.deviceCache = deviceCache3;
        LinkedHashMap obj2 = new LinkedHashMap();
        this.productTypes = obj2;
        obj2 = new LinkedHashMap();
        this.presentedOfferingsByProductIdentifier = obj2;
        obj2 = new ConcurrentLinkedQueue();
        this.serviceRequests = obj2;
    }

    public static final void access$executePendingRequests(com.revenuecat.purchases.google.BillingWrapper billingWrapper) {
        billingWrapper.executePendingRequests();
    }

    public static final com.revenuecat.purchases.google.BillingWrapper.ClientFactory access$getClientFactory$p(com.revenuecat.purchases.google.BillingWrapper billingWrapper) {
        return billingWrapper.clientFactory;
    }

    public static final DeviceCache access$getDeviceCache$p(com.revenuecat.purchases.google.BillingWrapper billingWrapper) {
        return billingWrapper.deviceCache;
    }

    public static final Handler access$getMainHandler$p(com.revenuecat.purchases.google.BillingWrapper billingWrapper) {
        return billingWrapper.mainHandler;
    }

    public static final ConcurrentLinkedQueue access$getServiceRequests$p(com.revenuecat.purchases.google.BillingWrapper billingWrapper) {
        return billingWrapper.serviceRequests;
    }

    public static final boolean access$isSuccessful(com.revenuecat.purchases.google.BillingWrapper billingWrapper, Purchase.a purchase$a2) {
        return billingWrapper.isSuccessful(a2);
    }

    public static final void access$launchBillingFlow(com.revenuecat.purchases.google.BillingWrapper billingWrapper, Activity activity2, f f3) {
        billingWrapper.launchBillingFlow(activity2, f3);
    }

    public static final Map access$toMapOfGooglePurchaseWrapper(com.revenuecat.purchases.google.BillingWrapper billingWrapper, List list2, String string3) {
        return billingWrapper.toMapOfGooglePurchaseWrapper(list2, string3);
    }

    public static final void access$withConnectedClient(com.revenuecat.purchases.google.BillingWrapper billingWrapper, l l2) {
        billingWrapper.withConnectedClient(l2);
    }

    private final void executePendingRequests() {
        Object remove;
        c billingClient;
        Handler mainHandler;
        com.revenuecat.purchases.google.BillingWrapper.executePendingRequests.1.1.1 anon;
        synchronized (this) {
            try {
                billingClient = this.billingClient;
                while (billingClient != null) {
                    if (billingClient.e() == 1) {
                    }
                    if (!this.serviceRequests.isEmpty()) {
                    }
                    anon = new BillingWrapper.executePendingRequests.1.1.1((l)this.serviceRequests.remove());
                    this.mainHandler.post(anon);
                    billingClient = this.billingClient;
                }
                if (billingClient.e() == 1) {
                }
                if (!this.serviceRequests.isEmpty()) {
                }
                anon = new BillingWrapper.executePendingRequests.1.1.1((l)this.serviceRequests.remove());
                this.mainHandler.post(anon);
                w wVar = w.a;
                throw remove;
            }
        }
    }

    private final void executeRequestOnUIThread(l<? super PurchasesError, w> l) {
        Object purchasesUpdatedListener;
        c obj2;
        synchronized (this) {
            try {
                this.serviceRequests.add(l);
                obj2 = this.billingClient;
                if (obj2 != null && !obj2.e()) {
                } else {
                }
                if (!obj2.e()) {
                } else {
                }
                startConnection();
                executePendingRequests();
                throw l;
            }
        }
    }

    private final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable throwable = new Throwable();
        throwable.printStackTrace(printWriter);
        String string = stringWriter.toString();
        n.e(string, "stringWriter.toString()");
        return string;
    }

    private final boolean isSuccessful(Purchase.a purchase$a) {
        int obj1;
        obj1 = a.c() == 0 ? 1 : 0;
        return obj1;
    }

    private final void launchBillingFlow(Activity activity, f f2) {
        BillingWrapper.launchBillingFlow.1 anon = new BillingWrapper.launchBillingFlow.1(activity, f2);
        withConnectedClient(anon);
    }

    private final Map<String, PurchaseDetails> toMapOfGooglePurchaseWrapper(List<? extends Purchase> list, String string2) {
        int i;
        String sha1;
        ProductType productType;
        int i2;
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator obj6 = list.iterator();
        for (Purchase next2 : obj6) {
            String str = next2.e();
            n.e(str, "purchase.purchaseToken");
            arrayList.add(u.a(UtilsKt.sha1(str), PurchaseDetailsConversionsKt.toRevenueCatPurchaseDetails(next2, ProductTypeConversionsKt.toProductType(string2), 0)));
        }
        return j0.s(arrayList);
    }

    private final void withConnectedClient(l<? super c, w> l) {
        String billingClient;
        String str;
        int i;
        String stackTrace;
        LogIntent obj5;
        billingClient = this.billingClient;
        if (billingClient != null) {
            if (billingClient.e()) {
            } else {
                billingClient = 0;
            }
            if (billingClient != 0) {
                l.invoke(billingClient);
            } else {
                int i2 = 1;
                Object[] arr = new Object[i2];
                arr[0] = getStackTrace();
                billingClient = String.format("Billing is disconnected and purchase methods won't work. Stacktrace: %s", Arrays.copyOf(arr, i2));
                n.e(billingClient, "java.lang.String.format(this, *args)");
                LogWrapperKt.log(LogIntent.GOOGLE_WARNING, billingClient);
            }
        } else {
        }
    }

    public final void acknowledge$google_release(String string, p<? super g, ? super String, w> p2) {
        n.f(string, "token");
        n.f(p2, "onAcknowledged");
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = string;
        String format = String.format("Acknowledging purchase with token %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.PURCHASE, format);
        BillingWrapper.acknowledge.1 anon = new BillingWrapper.acknowledge.1(this, string, p2);
        executeRequestOnUIThread(anon);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean z, PurchaseDetails purchaseDetails2) {
        int i;
        Enum pENDING;
        ProductType iNAPP;
        Object obj4;
        Object obj5;
        n.f(purchaseDetails2, "purchase");
        if (purchaseDetails2.getType() == ProductType.UNKNOWN) {
        }
        if (purchaseDetails2.getPurchaseState() == RevenueCatPurchaseState.PENDING) {
        }
        Purchase originalGooglePurchase = PurchaseDetailsConversionsKt.getOriginalGooglePurchase(purchaseDetails2);
        if (originalGooglePurchase != null) {
            i = originalGooglePurchase.h();
        } else {
            i = 0;
        }
        if (z && purchaseDetails2.getType() == ProductType.INAPP) {
            if (purchaseDetails2.getType() == ProductType.INAPP) {
                obj5 = new BillingWrapper.consumeAndSave.1(this);
                consumePurchase$google_release(purchaseDetails2.getPurchaseToken(), obj5);
            } else {
                if (z && i == 0) {
                    if (i == 0) {
                        obj5 = new BillingWrapper.consumeAndSave.2(this);
                        acknowledge$google_release(purchaseDetails2.getPurchaseToken(), obj5);
                    } else {
                        this.deviceCache.addSuccessfullyPostedToken(purchaseDetails2.getPurchaseToken());
                    }
                } else {
                }
            }
        } else {
        }
    }

    public final void consumePurchase$google_release(String string, p<? super g, ? super String, w> p2) {
        n.f(string, "token");
        n.f(p2, "onConsumed");
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = string;
        String format = String.format("Consuming purchase with token %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.PURCHASE, format);
        BillingWrapper.consumePurchase.1 anon = new BillingWrapper.consumePurchase.1(this, string, p2);
        executeRequestOnUIThread(anon);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void endConnection() {
        BillingWrapper.endConnection.1 anon = new BillingWrapper.endConnection.1(this);
        this.mainHandler.post(anon);
    }

    public void findPurchaseInPurchaseHistory(String string, ProductType productType2, String string3, l<? super PurchaseDetails, w> l4, l<? super PurchasesError, w> l5) {
        n.f(string, "appUserID");
        n.f(productType2, "productType");
        n.f(string3, "sku");
        n.f(l4, "onCompletion");
        n.f(l5, "onError");
        BillingWrapper.findPurchaseInPurchaseHistory.1 obj2 = new BillingWrapper.findPurchaseInPurchaseHistory.1(string3, productType2, l4, l5);
        withConnectedClient(obj2);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public final c getBillingClient() {
        return this.billingClient;
        synchronized (this) {
            return this.billingClient;
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public final ProductType getPurchaseType$google_release(String string) {
        Object billingClient;
        int i3;
        Object iterator;
        int i;
        int empty;
        int i2;
        int i4;
        String str;
        boolean empty2;
        n.f(string, "purchaseToken");
        billingClient = this.billingClient;
        if (billingClient != null) {
            Purchase.a aVar2 = billingClient.i("subs");
            n.e(aVar2, "client.queryPurchases(SkuType.SUBS)");
            i2 = 1;
            i4 = 0;
            empty = aVar2.c() == 0 ? i2 : i4;
            iterator = aVar2.b();
            str = "it";
            if (iterator != null) {
                if (iterator instanceof Collection != null && iterator.isEmpty()) {
                    if (iterator.isEmpty()) {
                        i = i4;
                    } else {
                        iterator = iterator.iterator();
                        for (Purchase next2 : iterator) {
                            n.e(next2, str);
                        }
                    }
                } else {
                }
            } else {
            }
            if (empty != 0 && i != 0) {
                if (i != 0) {
                    return ProductType.SUBS;
                }
            }
            Purchase.a aVar = billingClient.i("inapp");
            n.e(aVar, "client.queryPurchases(SkuType.INAPP)");
            i3 = aVar.c() == 0 ? i2 : i4;
            billingClient = aVar.b();
            if (billingClient != null) {
                if (billingClient instanceof Collection != null && billingClient.isEmpty()) {
                    if (billingClient.isEmpty()) {
                        i2 = i4;
                    } else {
                        billingClient = billingClient.iterator();
                        for (Purchase next : billingClient) {
                            n.e(next, str);
                        }
                    }
                } else {
                }
            } else {
            }
            if (i3 != 0 && i2 != 0) {
                if (i2 != 0) {
                    return ProductType.INAPP;
                }
            }
        }
        return ProductType.UNKNOWN;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public boolean isConnected() {
        boolean z;
        c billingClient = this.billingClient;
        if (billingClient != null) {
            z = billingClient.e();
        } else {
            z = 0;
        }
        return z;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String string2, ProductDetails productDetails3, ReplaceSkuInfo replaceSkuInfo4, String string5) {
        String format;
        String str;
        LogIntent pURCHASE;
        String str2;
        int arr;
        Object[] arr2;
        Object obj;
        n.f(activity, "activity");
        n.f(string2, "appUserID");
        n.f(productDetails3, "productDetails");
        int i = 1;
        int i2 = 0;
        if (replaceSkuInfo4 != null) {
            arr = 2;
            arr2 = new Object[arr];
            arr2[i2] = replaceSkuInfo4.getOldPurchase().getSkus().get(i2);
            arr2[i] = productDetails3.getSku();
            format = String.format("Moving from old SKU %s to sku %s", Arrays.copyOf(arr2, arr));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.PURCHASE, format);
        } else {
            arr = new Object[i];
            arr[i2] = productDetails3.getSku();
            format = String.format("Purchasing product: %s", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.PURCHASE, format);
        }
        this.productTypes.put(productDetails3.getSku(), productDetails3.getType());
        this.presentedOfferingsByProductIdentifier.put(productDetails3.getSku(), string5);
        w obj12 = w.a;
        super(this, productDetails3, replaceSkuInfo4, string2, activity);
        executeRequestOnUIThread(obj12);
        return;
        synchronized (this) {
            this.productTypes.put(productDetails3.getSku(), productDetails3.getType());
            this.presentedOfferingsByProductIdentifier.put(productDetails3.getSku(), string5);
            obj12 = w.a;
            super(this, productDetails3, replaceSkuInfo4, string2, activity);
            executeRequestOnUIThread(obj12);
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void onBillingServiceDisconnected() {
        BillingWrapper.onBillingServiceDisconnected.1 anon = new BillingWrapper.onBillingServiceDisconnected.1(this);
        this.mainHandler.post(anon);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void onBillingSetupFinished(g g) {
        n.f(g, "billingResult");
        BillingWrapper.onBillingSetupFinished.1 anon = new BillingWrapper.onBillingSetupFinished.1(this, g);
        this.mainHandler.post(anon);
    }

    public void onPurchasesUpdated(g g, List<? extends Purchase> list2) {
        List stringBuilder2;
        String string2;
        int i;
        Object billingResponseToPurchasesError;
        Object purchasesUpdatedListener;
        int i5;
        StringBuilder stringBuilder;
        int revenueCatPurchaseDetails;
        boolean empty;
        String str;
        int string;
        Object purchaseType$google_release;
        List list;
        Object[] arr;
        String humanReadableDescription;
        int i7;
        int i3;
        int i2;
        com.revenuecat.purchases.google.BillingWrapper.onPurchasesUpdated.4.1 iNSTANCE;
        int i4;
        int i6;
        final Object obj = this;
        n.f(g, "billingResult");
        if (list2 != null) {
            stringBuilder2 = list2;
        } else {
            stringBuilder2 = p.g();
        }
        str = 0;
        string = 1;
        if (g.b() == 0 && empty2 ^= string != null) {
            if (empty2 ^= string != null) {
                purchasesUpdatedListener = new ArrayList(p.r(stringBuilder2, 10));
                Iterator iterator = stringBuilder2.iterator();
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    Object[] arr2 = new Object[string];
                    arr2[str] = UtilsKt.toHumanReadableDescription((Purchase)next);
                    String format2 = String.format("BillingWrapper purchases updated: %s", Arrays.copyOf(arr2, string));
                    n.e(format2, "java.lang.String.format(this, *args)");
                    LogWrapperKt.log(LogIntent.DEBUG, format2);
                    arr = w.a;
                    if ((ProductType)obj.productTypes.get(ExtensionsKt.getSku(next)) != null) {
                    } else {
                    }
                    String str5 = next.e();
                    n.e(str5, "purchase.purchaseToken");
                    purchaseType$google_release = obj.getPurchaseType$google_release(str5);
                    purchasesUpdatedListener.add(PurchaseDetailsConversionsKt.toRevenueCatPurchaseDetails(next, purchaseType$google_release, (String)obj.presentedOfferingsByProductIdentifier.get(ExtensionsKt.getSku(next))));
                }
                billingResponseToPurchasesError = getPurchasesUpdatedListener();
                if (billingResponseToPurchasesError != null) {
                    billingResponseToPurchasesError.onPurchasesUpdated(purchasesUpdatedListener);
                }
            } else {
                if (g.b() == 0) {
                    billingResponseToPurchasesError = getPurchasesUpdatedListener();
                    if (billingResponseToPurchasesError != null) {
                        billingResponseToPurchasesError.onPurchasesUpdated(p.g());
                    }
                } else {
                    purchaseType$google_release = new StringBuilder();
                    arr = new Object[string];
                    arr[str] = UtilsKt.toHumanReadableDescription(g);
                    String format = String.format("BillingWrapper purchases failed to update: %s", Arrays.copyOf(arr, string));
                    n.e(format, "java.lang.String.format(this, *args)");
                    purchaseType$google_release.append(format);
                    list = !stringBuilder2.isEmpty() ? stringBuilder2 : string;
                    if (list != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Purchases:");
                        stringBuilder2.append(p.h0(list, ", ", 0, 0, 0, 0, BillingWrapper.onPurchasesUpdated.4.1.INSTANCE, 30, 0));
                        string = stringBuilder2.toString();
                    }
                    purchaseType$google_release.append(string);
                    LogWrapperKt.log(LogIntent.GOOGLE_ERROR, purchaseType$google_release.toString());
                    if (list2 == null && g.b() == 0) {
                        if (g.b() == 0) {
                            i = 6;
                        } else {
                            i = g.b();
                        }
                    } else {
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error updating purchases. ");
                    stringBuilder.append(UtilsKt.toHumanReadableDescription(g));
                    billingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(i, stringBuilder.toString());
                    LogUtilsKt.errorLog(billingResponseToPurchasesError);
                    purchasesUpdatedListener = getPurchasesUpdatedListener();
                    if (purchasesUpdatedListener != null) {
                        purchasesUpdatedListener.onPurchasesFailedToUpdate(billingResponseToPurchasesError);
                    }
                }
            }
        } else {
        }
    }

    public void queryAllPurchases(String string, l<? super List<PurchaseDetails>, w> l2, l<? super PurchasesError, w> l3) {
        n.f(string, "appUserID");
        n.f(l2, "onReceivePurchaseHistory");
        n.f(l3, "onReceivePurchaseHistoryError");
        BillingWrapper.queryAllPurchases.1 obj2 = new BillingWrapper.queryAllPurchases.1(this, l2, l3);
        queryPurchaseHistoryAsync("subs", obj2, l3);
    }

    public final void queryPurchaseHistoryAsync(String string, l<? super List<? extends PurchaseHistoryRecord>, w> l2, l<? super PurchasesError, w> l3) {
        n.f(string, "skuType");
        n.f(l2, "onReceivePurchaseHistory");
        n.f(l3, "onReceivePurchaseHistoryError");
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = string;
        String format = String.format("Querying purchase history for type %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        BillingWrapper.queryPurchaseHistoryAsync.1 anon = new BillingWrapper.queryPurchaseHistoryAsync.1(this, string, l2, l3);
        executeRequestOnUIThread(anon);
    }

    public void queryPurchases(String string, l<? super Map<String, PurchaseDetails>, w> l2, l<? super PurchasesError, w> l3) {
        n.f(string, "appUserID");
        n.f(l2, "onSuccess");
        n.f(l3, "onError");
        BillingWrapper.queryPurchases.1 obj2 = new BillingWrapper.queryPurchases.1(this, l3, l2);
        withConnectedClient(obj2);
    }

    public void querySkuDetailsAsync(ProductType productType, Set<String> set2, l<? super List<ProductDetails>, w> l3, l<? super PurchasesError, w> l4) {
        Object next;
        int length;
        int i;
        int i2;
        Object obj3 = l3;
        n.f(productType, "productType");
        n.f(set2, "skus");
        n.f(obj3, "onReceive");
        n.f(l4, "onError");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = set2.iterator();
        i = 1;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((String)next.length() > 0) {
            }
            if (i2 != 0) {
            }
            i = 1;
            arrayList.add(next);
            i2 = i;
        }
        if (arrayList.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, "SKU list is empty, skipping querySkuDetailsAsync call");
            obj3.invoke(p.g());
        }
        Object[] arr = new Object[i];
        arr[0] = p.h0(set2, 0, 0, 0, 0, 0, 0, 63, 0);
        String format = String.format("Requesting products from the store with identifiers: %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        super(this, productType, arrayList, set2, l3, l4);
        this.executeRequestOnUIThread(anon2);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public final void setBillingClient(c c) {
        this.billingClient = c;
        return;
        synchronized (this) {
            this.billingClient = c;
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        BillingWrapper.startConnection.1 anon = new BillingWrapper.startConnection.1(this);
        this.mainHandler.post(anon);
    }
}
