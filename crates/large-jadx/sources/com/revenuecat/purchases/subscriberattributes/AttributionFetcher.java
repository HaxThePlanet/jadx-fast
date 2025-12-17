package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import android.provider.Settings.Secure;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\u0008\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0008\u0010\u0007J1\u0010\u000c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010¨\u0006\u0013", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionFetcher;", "", "Landroid/app/Application;", "applicationContext", "", "kotlin.jvm.PlatformType", "getAndroidID", "(Landroid/app/Application;)Ljava/lang/String;", "getAdvertisingID", "Lkotlin/Function2;", "Lkotlin/w;", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lkotlin/d0/c/p;)V", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "<init>", "(Lcom/revenuecat/purchases/common/Dispatcher;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class AttributionFetcher {

    private final Dispatcher dispatcher;
    public AttributionFetcher(Dispatcher dispatcher) {
        n.f(dispatcher, "dispatcher");
        super();
        this.dispatcher = dispatcher;
    }

    public static final String access$getAdvertisingID(com.revenuecat.purchases.subscriberattributes.AttributionFetcher attributionFetcher, Application application2) {
        return attributionFetcher.getAdvertisingID(application2);
    }

    public static final String access$getAndroidID(com.revenuecat.purchases.subscriberattributes.AttributionFetcher attributionFetcher, Application application2) {
        return attributionFetcher.getAndroidID(application2);
    }

    private final String getAdvertisingID(Application application) {
        int i;
        boolean limitAdTrackingEnabled;
        Object[] arr;
        String obj6;
        final String str = "java.lang.String.format(this, *args)";
        i = 0;
        final int i2 = 1;
        obj6 = AdvertisingIdClient.getAdvertisingIdInfo(application);
        n.e(obj6, "adInfo");
        if (!obj6.isLimitAdTrackingEnabled()) {
            obj6 = obj6.getId();
        } else {
            obj6 = 0;
        }
        return obj6;
    }

    private final String getAndroidID(Application application) {
        return Settings.Secure.getString(application.getContentResolver(), "android_id");
    }

    public final void getDeviceIdentifiers(Application application, p<? super String, ? super String, w> p2) {
        n.f(application, "applicationContext");
        n.f(p2, "completion");
        AttributionFetcher.getDeviceIdentifiers.1 anon = new AttributionFetcher.getDeviceIdentifiers.1(this, application, p2);
        Dispatcher.enqueue$default(this.dispatcher, anon, false, 2, 0);
    }
}
