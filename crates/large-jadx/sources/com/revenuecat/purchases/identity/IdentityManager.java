package com.revenuecat.purchases.identity;

import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\u0008(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J7\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\u0008\u000e\u0010\u000fJC\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\u0008\u0014\u0010\u0015J7\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\u0008\u0016\u0010\u000fJ\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\u0008\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u000c¢\u0006\u0004\u0008\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001fR\u0013\u0010!\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0004R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008&\u0010'¨\u0006*", d2 = {"Lcom/revenuecat/purchases/identity/IdentityManager;", "", "", "generateRandomID", "()Ljava/lang/String;", "appUserID", "Lkotlin/w;", "configure", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "identify", "(Ljava/lang/String;Lkotlin/d0/c/a;Lkotlin/d0/c/l;)V", "newAppUserID", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchaserInfo;", "", "logIn", "(Ljava/lang/String;Lkotlin/d0/c/p;Lkotlin/d0/c/l;)V", "createAlias", "reset", "()V", "logOut", "()Lcom/revenuecat/purchases/PurchasesError;", "currentUserIsAnonymous", "()Z", "Lcom/revenuecat/purchases/common/Backend;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "getCurrentAppUserID", "currentAppUserID", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "subscriberAttributesCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "<init>", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/common/Backend;)V", "identity_release"}, k = 1, mv = {1, 4, 0})
public final class IdentityManager {

    private final Backend backend;
    private final DeviceCache deviceCache;
    private final SubscriberAttributesCache subscriberAttributesCache;
    public IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache2, Backend backend3) {
        n.f(deviceCache, "deviceCache");
        n.f(subscriberAttributesCache2, "subscriberAttributesCache");
        n.f(backend3, "backend");
        super();
        this.deviceCache = deviceCache;
        this.subscriberAttributesCache = subscriberAttributesCache2;
        this.backend = backend3;
    }

    public static final DeviceCache access$getDeviceCache$p(com.revenuecat.purchases.identity.IdentityManager identityManager) {
        return identityManager.deviceCache;
    }

    public static final SubscriberAttributesCache access$getSubscriberAttributesCache$p(com.revenuecat.purchases.identity.IdentityManager identityManager) {
        return identityManager.subscriberAttributesCache;
    }

    private final String generateRandomID() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$RCAnonymousID:");
        String string2 = UUID.randomUUID().toString();
        n.e(string2, "UUID.randomUUID().toString()");
        Locale rOOT = Locale.ROOT;
        n.e(rOOT, "Locale.ROOT");
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        final String lowerCase = string2.toLowerCase(rOOT);
        n.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        LogWrapperKt.log(LogIntent.USER, "Setting new anonymous App User ID - %s");
        w wVar = w.a;
        stringBuilder.append(l.G(lowerCase, "-", "", false, 4, 0));
        return stringBuilder.toString();
    }

    public final void configure(String string) {
        String obj6;
        synchronized (this) {
            if (obj6 != null) {
                try {
                    obj6 = this.deviceCache.getLegacyCachedAppUserID();
                    if (obj6 != null) {
                    } else {
                    }
                    obj6 = generateRandomID();
                    int i = 1;
                    final Object[] arr = new Object[i];
                    arr[0] = obj6;
                    String format = String.format("Identifying App User ID: %s", Arrays.copyOf(arr, i));
                    n.e(format, "java.lang.String.format(this, *args)");
                    LogWrapperKt.log(LogIntent.USER, format);
                    this.deviceCache.cacheAppUserID(obj6);
                    this.subscriberAttributesCache.cleanUpSubscriberAttributeCache(obj6);
                    throw string;
                }
            } else {
            }
        }
    }

    public final void createAlias(String string, a<w> a2, l<? super PurchasesError, w> l3) {
        n.f(string, "newAppUserID");
        n.f(a2, "onSuccess");
        n.f(l3, "onError");
        int i = 2;
        Object[] arr = new Object[i];
        arr[0] = getCurrentAppUserID();
        arr[1] = string;
        String format = String.format("Creating an alias to %s from %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.USER, format);
        IdentityManager.createAlias.1 anon = new IdentityManager.createAlias.1(this, string, a2);
        this.backend.createAlias(getCurrentAppUserID(), string, anon, l3);
    }

    public final boolean currentUserIsAnonymous() {
        String cachedAppUserID;
        int i;
        h hVar = new h("^\\$RCAnonymousID:([a-f0-9]{32})$");
        synchronized (this) {
            try {
                cachedAppUserID = "";
                if (!hVar.d(cachedAppUserID)) {
                } else {
                }
                if (n.b(this.deviceCache.getCachedAppUserID(), this.deviceCache.getLegacyCachedAppUserID())) {
                } else {
                }
                i = 0;
                i = 1;
                return i;
                throw th;
            }
        }
    }

    public final String getCurrentAppUserID() {
        String cachedAppUserID;
        if (this.deviceCache.getCachedAppUserID() != null) {
        } else {
            cachedAppUserID = "";
        }
        return cachedAppUserID;
    }

    public final void identify(String string, a<w> a2, l<? super PurchasesError, w> l3) {
        Object currentAppUserID;
        String format;
        String str;
        String str2;
        Object[] arr;
        String currentAppUserID2;
        Object obj7;
        Object obj9;
        n.f(string, "appUserID");
        n.f(a2, "onSuccess");
        n.f(l3, "onError");
        int i = 0;
        str = 1;
        if (currentUserIsAnonymous()) {
            arr = new Object[str];
            arr[i] = string;
            format = String.format("Identifying from an anonymous ID: %s. An alias will be created.", Arrays.copyOf(arr, str));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.USER, format);
            createAlias(string, a2, l3);
        } else {
            str2 = 2;
            arr = new Object[str2];
            arr[i] = getCurrentAppUserID();
            arr[str] = string;
            String format2 = String.format("Changing App User ID: %s -> %s", Arrays.copyOf(arr, str2));
            n.e(format2, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.USER, format2);
            this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
            this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
            this.deviceCache.cacheAppUserID(string);
            obj7 = w.a;
            a2.invoke();
            synchronized (this) {
                str2 = 2;
                arr = new Object[str2];
                arr[i] = getCurrentAppUserID();
                arr[str] = string;
                format2 = String.format("Changing App User ID: %s -> %s", Arrays.copyOf(arr, str2));
                n.e(format2, "java.lang.String.format(this, *args)");
                LogWrapperKt.log(LogIntent.USER, format2);
                this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
                this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
                this.deviceCache.cacheAppUserID(string);
                obj7 = w.a;
                a2.invoke();
            }
        }
    }

    public final void logIn(String string, p<? super PurchaserInfo, ? super Boolean, w> p2, l<? super PurchasesError, w> l3) {
        n.f(string, "newAppUserID");
        n.f(p2, "onSuccess");
        n.f(l3, "onError");
        if (l.z(string)) {
            PurchasesError obj6 = new PurchasesError(PurchasesErrorCode.InvalidAppUserIdError, "Error logging in: appUserID can't be null, empty or blank");
            LogUtilsKt.errorLog(obj6);
            w obj7 = w.a;
            l3.invoke(obj6);
        }
        int i = 2;
        Object[] arr = new Object[i];
        arr[0] = getCurrentAppUserID();
        arr[1] = string;
        String format = String.format("Logging in from %s -> %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.USER, format);
        String currentAppUserID = getCurrentAppUserID();
        IdentityManager.logIn.2 anon = new IdentityManager.logIn.2(this, string, currentAppUserID, p2);
        this.backend.logIn(currentAppUserID, string, anon, l3);
    }

    public final PurchasesError logOut() {
        final int i = 0;
        synchronized (this) {
            try {
                LogWrapperKt.log(LogIntent.RC_ERROR, "Called logOut but the current user is anonymous");
                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.LogOutWithAnonymousUserError, i, 2, i);
                return purchasesError;
                this.deviceCache.clearLatestAttributionData(getCurrentAppUserID());
                reset();
                LogWrapperKt.log(LogIntent.USER, "Logged out successfully");
                return i;
                throw th;
            }
        }
    }

    public final void reset() {
        this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
        this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
        this.deviceCache.cacheAppUserID(generateRandomID());
        return;
        synchronized (this) {
            this.deviceCache.clearCachesForAppUserID(getCurrentAppUserID());
            this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
            this.deviceCache.cacheAppUserID(generateRandomID());
        }
    }
}
