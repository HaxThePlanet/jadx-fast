package com.revenuecat.purchases;

import android.app.Application;
import android.os.Handler;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.google.BillingWrapper;
import com.revenuecat.purchases.google.BillingWrapper.ClientFactory;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u000b\u0010\u000c¨\u0006\u000f", d2 = {"Lcom/revenuecat/purchases/BillingFactory;", "", "Lcom/revenuecat/purchases/Store;", "store", "Landroid/app/Application;", "application", "Lcom/revenuecat/purchases/common/Backend;", "backend", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "cache", "Lcom/revenuecat/purchases/common/BillingAbstract;", "createBilling", "(Lcom/revenuecat/purchases/Store;Landroid/app/Application;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/caching/DeviceCache;)Lcom/revenuecat/purchases/common/BillingAbstract;", "<init>", "()V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class BillingFactory {

    public static final com.revenuecat.purchases.BillingFactory INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            BillingFactory.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[Store.PLAY_STORE.ordinal()] = 1;
            iArr[Store.AMAZON.ordinal()] = 2;
        }
    }
    static {
        BillingFactory billingFactory = new BillingFactory();
        BillingFactory.INSTANCE = billingFactory;
    }

    public final BillingAbstract createBilling(com.revenuecat.purchases.Store store, Application application2, Backend backend3, DeviceCache deviceCache4) {
        Handler handler;
        int i;
        Class[] arr;
        Class<DeviceCache> obj;
        int i2;
        Object obj7;
        Object obj8;
        Object obj9;
        n.f(store, "store");
        n.f(application2, "application");
        n.f(backend3, "backend");
        n.f(deviceCache4, "cache");
        int i3 = BillingFactory.WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        int i5 = 1;
        if (i3 != i5) {
            i = 2;
            if (i3 != i) {
            } else {
                int i4 = 3;
                arr = new Class[i4];
                i2 = 0;
                arr[i2] = Context.class;
                arr[i5] = Backend.class;
                arr[i] = DeviceCache.class;
                handler = new Object[i4];
                handler[i2] = application2.getApplicationContext();
                handler[i5] = backend3;
                handler[i] = deviceCache4;
                if (Class.forName("com.revenuecat.purchases.amazon.AmazonBilling").getConstructor(arr).newInstance(handler) == null) {
                } else {
                    return obj7;
                }
                obj7 = new NullPointerException("null cannot be cast to non-null type com.revenuecat.purchases.common.BillingAbstract");
                throw obj7;
            }
            obj8 = new StringBuilder();
            obj8.append("Incompatible store (");
            obj8.append(store);
            obj9 = ") used";
            obj8.append(obj9);
            LogUtilsKt.errorLog(obj8.toString());
            StringBuilder obj10 = new StringBuilder();
            obj10.append("Couldn't configure SDK. Incompatible store (");
            obj10.append(store);
            obj10.append(obj9);
            obj8 = new IllegalArgumentException(obj10.toString());
            throw obj8;
        }
        obj9 = new BillingWrapper.ClientFactory(application2);
        handler = new Handler(application2.getMainLooper());
        obj7 = new BillingWrapper(obj9, handler, deviceCache4);
    }
}
