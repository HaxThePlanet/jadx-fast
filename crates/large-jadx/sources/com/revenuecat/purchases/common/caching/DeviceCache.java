package com.revenuecat.purchases.common.caching;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.FactoriesKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.attribution.AttributionNetwork;
import com.revenuecat.purchases.models.PurchaseDetails;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010q\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020D0[\u0012\u0008\u0008\u0002\u0010i\u001a\u00020h¢\u0006\u0004\u0008u\u0010vJ\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\u001b\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u001d\u0010\r\u001a\u00020\u000c2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u0017*\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\u0008\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008 \u0010\u001fJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008!\u0010\"J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008#\u0010\"J\u0017\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008%\u0010&J\u001d\u0010(\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010'\u001a\u00020$¢\u0006\u0004\u0008(\u0010)J\u001d\u0010*\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008*\u0010+J\u0015\u0010\u0008\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\u001fJ\u0015\u0010,\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008,\u0010\u001fJ\u0015\u0010-\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008-\u0010\u001fJ\u001d\u0010/\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0016¢\u0006\u0004\u0008/\u00100J\u0017\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u00081\u00102J\u001f\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\u00083\u00104J%\u00106\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006¢\u0006\u0004\u00086\u00107J\u0015\u00108\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\u00088\u0010\u001fJ\u0013\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\u00089\u0010:J\u0015\u0010<\u001a\u00020\u000c2\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\u0008<\u0010\u001fJ\u001b\u0010>\u001a\u00020\u000c2\u000c\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\u0008>\u0010\u000eJ'\u0010B\u001a\u0008\u0012\u0004\u0012\u00020@0A2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@0?¢\u0006\u0004\u0008B\u0010CJ\u0015\u0010F\u001a\u00020\u000c2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\u0008F\u0010GJ\u0015\u0010H\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008H\u0010IJ\r\u0010J\u001a\u00020\u000c¢\u0006\u0004\u0008J\u0010\u0010J\r\u0010K\u001a\u00020\u000c¢\u0006\u0004\u0008K\u0010\u0010J\u0019\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008N\u0010OJ\u001f\u0010R\u001a\u00020\u000c2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008R\u0010SJ\u0015\u0010T\u001a\u00020\u000c2\u0006\u0010P\u001a\u00020\u0006¢\u0006\u0004\u0008T\u0010\u001fJ\u001b\u0010U\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010P\u001a\u00020\u0006¢\u0006\u0004\u0008U\u0010VJ\u0015\u0010W\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006¢\u0006\u0004\u0008W\u0010\"R\u001c\u0010X\u001a\u00020\u00068\u0006@\u0006X\u0086D¢\u0006\u000c\n\u0004\u0008X\u0010Y\u001a\u0004\u0008Z\u0010\u001cR\u001c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020D0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\\\u0010]R\u0015\u0010`\u001a\u0004\u0018\u00010D8F@\u0006¢\u0006\u0006\u001a\u0004\u0008^\u0010_R\u001d\u0010d\u001a\u00020\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008a\u0010b\u001a\u0004\u0008c\u0010\u001cR\u001d\u0010g\u001a\u00020\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008e\u0010b\u001a\u0004\u0008f\u0010\u001cR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008i\u0010jR\u001d\u0010m\u001a\u00020\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008k\u0010b\u001a\u0004\u0008l\u0010\u001cR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008o\u0010pR\u0016\u0010q\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008q\u0010YR\u001d\u0010t\u001a\u00020\u00068B@\u0002X\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008r\u0010b\u001a\u0004\u0008s\u0010\u001c¨\u0006w", d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache;", "", "Landroid/content/SharedPreferences$Editor;", "clearPurchaserInfo", "(Landroid/content/SharedPreferences$Editor;)Landroid/content/SharedPreferences$Editor;", "clearAppUserID", "", "appUserID", "clearPurchaserInfoCacheTimestamp", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", "", "newSet", "Lkotlin/w;", "setSavedTokenHashes", "(Ljava/util/Set;)V", "clearOfferingsCache", "()V", "userId", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "network", "getAttributionDataCacheKey", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;)Ljava/lang/String;", "Ljava/util/Date;", "", "appInBackground", "isStale", "(Ljava/util/Date;Z)Z", "getLegacyCachedAppUserID", "()Ljava/lang/String;", "getCachedAppUserID", "cacheAppUserID", "(Ljava/lang/String;)V", "clearCachesForAppUserID", "purchaserInfoCacheKey", "(Ljava/lang/String;)Ljava/lang/String;", "purchaserInfoLastUpdatedCacheKey", "Lcom/revenuecat/purchases/PurchaserInfo;", "getCachedPurchaserInfo", "(Ljava/lang/String;)Lcom/revenuecat/purchases/PurchaserInfo;", "info", "cachePurchaserInfo", "(Ljava/lang/String;Lcom/revenuecat/purchases/PurchaserInfo;)V", "isPurchaserInfoCacheStale", "(Ljava/lang/String;Z)Z", "clearPurchaserInfoCache", "setPurchaserInfoCacheTimestampToNow", "date", "setPurchaserInfoCacheTimestamp", "(Ljava/lang/String;Ljava/util/Date;)V", "getPurchaserInfoCachesLastUpdated", "(Ljava/lang/String;)Ljava/util/Date;", "getCachedAttributionData", "(Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;)Ljava/lang/String;", "cacheValue", "cacheAttributionData", "(Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;Ljava/lang/String;)V", "clearLatestAttributionData", "getPreviouslySentHashedTokens", "()Ljava/util/Set;", "token", "addSuccessfullyPostedToken", "hashedTokens", "cleanPreviouslySentTokens", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "", "getActivePurchasesNotInCache", "(Ljava/util/Map;)Ljava/util/List;", "Lcom/revenuecat/purchases/Offerings;", "offerings", "cacheOfferings", "(Lcom/revenuecat/purchases/Offerings;)V", "isOfferingsCacheStale", "(Z)Z", "clearOfferingsCacheTimestamp", "setOfferingsCacheTimestampToNow", "key", "Lorg/json/JSONObject;", "getJSONObjectOrNull", "(Ljava/lang/String;)Lorg/json/JSONObject;", "cacheKey", "value", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "remove", "findKeysThatStartWith", "(Ljava/lang/String;)Ljava/util/Set;", "newKey", "attributionCacheKey", "Ljava/lang/String;", "getAttributionCacheKey", "Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "offeringsCachedObject", "Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "getCachedOfferings", "()Lcom/revenuecat/purchases/Offerings;", "cachedOfferings", "legacyAppUserIDCacheKey$delegate", "Lkotlin/h;", "getLegacyAppUserIDCacheKey", "legacyAppUserIDCacheKey", "appUserIDCacheKey$delegate", "getAppUserIDCacheKey", "appUserIDCacheKey", "Lcom/revenuecat/purchases/common/DateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "tokensCacheKey$delegate", "getTokensCacheKey", "tokensCacheKey", "Landroid/content/SharedPreferences;", "preferences", "Landroid/content/SharedPreferences;", "apiKey", "purchaserInfoCachesLastUpdatedCacheBaseKey$delegate", "getPurchaserInfoCachesLastUpdatedCacheBaseKey", "purchaserInfoCachesLastUpdatedCacheBaseKey", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;Lcom/revenuecat/purchases/common/DateProvider;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public class DeviceCache {

    private final String apiKey;
    private final h appUserIDCacheKey$delegate;
    private final String attributionCacheKey;
    private final DateProvider dateProvider;
    private final h legacyAppUserIDCacheKey$delegate;
    private final com.revenuecat.purchases.common.caching.InMemoryCachedObject<Offerings> offeringsCachedObject;
    private final SharedPreferences preferences;
    private final h purchaserInfoCachesLastUpdatedCacheBaseKey$delegate;
    private final h tokensCacheKey$delegate;
    public DeviceCache(SharedPreferences sharedPreferences, String string2, com.revenuecat.purchases.common.caching.InMemoryCachedObject<Offerings> inMemoryCachedObject3, DateProvider dateProvider4) {
        n.f(sharedPreferences, "preferences");
        n.f(string2, "apiKey");
        n.f(inMemoryCachedObject3, "offeringsCachedObject");
        n.f(dateProvider4, "dateProvider");
        super();
        this.preferences = sharedPreferences;
        this.apiKey = string2;
        this.offeringsCachedObject = inMemoryCachedObject3;
        this.dateProvider = dateProvider4;
        DeviceCache.legacyAppUserIDCacheKey.2 obj2 = new DeviceCache.legacyAppUserIDCacheKey.2(this);
        this.legacyAppUserIDCacheKey$delegate = j.b(obj2);
        obj2 = new DeviceCache.appUserIDCacheKey.2(this);
        this.appUserIDCacheKey$delegate = j.b(obj2);
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        obj2 = new DeviceCache.tokensCacheKey.2(this);
        this.tokensCacheKey$delegate = j.b(obj2);
        obj2 = new DeviceCache.purchaserInfoCachesLastUpdatedCacheBaseKey.2(this);
        this.purchaserInfoCachesLastUpdatedCacheBaseKey$delegate = j.b(obj2);
    }

    public DeviceCache(SharedPreferences sharedPreferences, String string2, com.revenuecat.purchases.common.caching.InMemoryCachedObject inMemoryCachedObject3, DateProvider dateProvider4, int i5, g g6) {
        int i;
        com.revenuecat.purchases.common.caching.InMemoryCachedObject obj4;
        DefaultDateProvider obj5;
        int obj7;
        if (i5 & 4 != 0) {
            i = 0;
            obj4 = new InMemoryCachedObject(i, i, 3, i);
        }
        if (i5 &= 8 != 0) {
            obj5 = new DefaultDateProvider();
        }
        super(sharedPreferences, string2, obj4, obj5);
    }

    public static final String access$getApiKey$p(com.revenuecat.purchases.common.caching.DeviceCache deviceCache) {
        return deviceCache.apiKey;
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor sharedPreferences$Editor) {
        editor.remove(getAppUserIDCacheKey());
        editor.remove(getLegacyAppUserIDCacheKey());
        return editor;
    }

    private final void clearOfferingsCache() {
        this.offeringsCachedObject.clearCache();
    }

    private final SharedPreferences.Editor clearPurchaserInfo(SharedPreferences.Editor sharedPreferences$Editor) {
        String purchaserInfoCacheKey;
        String legacyCachedAppUserID;
        purchaserInfoCacheKey = getCachedAppUserID();
        if (purchaserInfoCacheKey != null) {
            editor.remove(purchaserInfoCacheKey(purchaserInfoCacheKey));
        }
        legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(purchaserInfoCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearPurchaserInfoCacheTimestamp(SharedPreferences.Editor sharedPreferences$Editor, String string2) {
        editor.remove(purchaserInfoLastUpdatedCacheKey(string2));
        return editor;
    }

    private final String getAttributionDataCacheKey(String string, AttributionNetwork attributionNetwork2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.attributionCacheKey);
        int i = 46;
        stringBuilder.append(i);
        stringBuilder.append(string);
        stringBuilder.append(i);
        stringBuilder.append(attributionNetwork2);
        return stringBuilder.toString();
    }

    private final String getPurchaserInfoCachesLastUpdatedCacheBaseKey() {
        return (String)this.purchaserInfoCachesLastUpdatedCacheBaseKey$delegate.getValue();
    }

    private final boolean isStale(Date date, boolean z2) {
        int i;
        int i2;
        String format;
        String str;
        int i3;
        long time;
        int obj8;
        boolean obj9;
        i = 1;
        if (date != 0) {
            Object[] arr = new Object[i];
            i3 = 0;
            arr[i3] = Boolean.valueOf(z2);
            format = String.format("Checking if cache is stale AppInBackground %s", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.DEBUG, format);
            obj9 = z2 ? 90000000 : 300000;
            if (Long.compare(i2, obj8) >= 0) {
            } else {
                i = i3;
            }
        }
        return i;
    }

    private final void setSavedTokenHashes(Set<String> set) {
        int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = set;
        String format = String.format("Saving tokens %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.preferences.edit().putStringSet(getTokensCacheKey(), set).apply();
        return;
        synchronized (this) {
            i = 1;
            arr = new Object[i];
            arr[0] = set;
            format = String.format("Saving tokens %s", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.DEBUG, format);
            this.preferences.edit().putStringSet(getTokensCacheKey(), set).apply();
        }
    }

    public final void addSuccessfullyPostedToken(String string) {
        n.f(string, "token");
        LogIntent dEBUG = LogIntent.DEBUG;
        int i = 2;
        Object[] arr = new Object[i];
        final int i2 = 0;
        arr[i2] = string;
        final int i3 = 1;
        arr[i3] = UtilsKt.sha1(string);
        String format = String.format("Saving token %s with hash %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(dEBUG, format);
        Set previouslySentHashedTokens = getPreviouslySentHashedTokens();
        Object[] arr2 = new Object[i3];
        arr2[i2] = previouslySentHashedTokens;
        String format2 = String.format("Tokens in cache before saving %s", Arrays.copyOf(arr2, i3));
        n.e(format2, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(dEBUG, format2);
        Set set = p.O0(previouslySentHashedTokens);
        set.add(UtilsKt.sha1(string));
        w obj8 = w.a;
        setSavedTokenHashes(set);
        return;
        synchronized (this) {
            n.f(string, "token");
            dEBUG = LogIntent.DEBUG;
            i = 2;
            arr = new Object[i];
            i2 = 0;
            arr[i2] = string;
            i3 = 1;
            arr[i3] = UtilsKt.sha1(string);
            format = String.format("Saving token %s with hash %s", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(dEBUG, format);
            previouslySentHashedTokens = getPreviouslySentHashedTokens();
            arr2 = new Object[i3];
            arr2[i2] = previouslySentHashedTokens;
            format2 = String.format("Tokens in cache before saving %s", Arrays.copyOf(arr2, i3));
            n.e(format2, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(dEBUG, format2);
            set = p.O0(previouslySentHashedTokens);
            set.add(UtilsKt.sha1(string));
            obj8 = w.a;
            setSavedTokenHashes(set);
        }
    }

    public final void cacheAppUserID(String string) {
        n.f(string, "appUserID");
        this.preferences.edit().putString(getAppUserIDCacheKey(), string).apply();
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            this.preferences.edit().putString(getAppUserIDCacheKey(), string).apply();
        }
    }

    public final void cacheAttributionData(AttributionNetwork attributionNetwork, String string2, String string3) {
        n.f(attributionNetwork, "network");
        n.f(string2, "userId");
        n.f(string3, "cacheValue");
        this.preferences.edit().putString(getAttributionDataCacheKey(string2, attributionNetwork), string3).apply();
        return;
        synchronized (this) {
            n.f(attributionNetwork, "network");
            n.f(string2, "userId");
            n.f(string3, "cacheValue");
            this.preferences.edit().putString(getAttributionDataCacheKey(string2, attributionNetwork), string3).apply();
        }
    }

    public final void cacheOfferings(Offerings offerings) {
        n.f(offerings, "offerings");
        this.offeringsCachedObject.cacheInstance(offerings);
        return;
        synchronized (this) {
            n.f(offerings, "offerings");
            this.offeringsCachedObject.cacheInstance(offerings);
        }
    }

    public final void cachePurchaserInfo(String string, PurchaserInfo purchaserInfo2) {
        n.f(string, "appUserID");
        n.f(purchaserInfo2, "info");
        JSONObject obj4 = purchaserInfo2.getJsonObject();
        obj4.put("schema_version", 3);
        this.preferences.edit().putString(purchaserInfoCacheKey(string), obj4.toString()).apply();
        setPurchaserInfoCacheTimestampToNow(string);
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            n.f(purchaserInfo2, "info");
            obj4 = purchaserInfo2.getJsonObject();
            obj4.put("schema_version", 3);
            this.preferences.edit().putString(purchaserInfoCacheKey(string), obj4.toString()).apply();
            setPurchaserInfoCacheTimestampToNow(string);
        }
    }

    public final void cleanPreviouslySentTokens(Set<String> set) {
        n.f(set, "hashedTokens");
        LogWrapperKt.log(LogIntent.DEBUG, "Cleaning previously sent tokens");
        setSavedTokenHashes(p.d0(set, getPreviouslySentHashedTokens()));
        return;
        synchronized (this) {
            n.f(set, "hashedTokens");
            LogWrapperKt.log(LogIntent.DEBUG, "Cleaning previously sent tokens");
            setSavedTokenHashes(p.d0(set, getPreviouslySentHashedTokens()));
        }
    }

    public final void clearCachesForAppUserID(String string) {
        n.f(string, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        n.e(edit, "preferences.edit()");
        clearPurchaserInfoCacheTimestamp(clearAppUserID(clearPurchaserInfo(edit)), string).apply();
        clearOfferingsCache();
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            edit = this.preferences.edit();
            n.e(edit, "preferences.edit()");
            clearPurchaserInfoCacheTimestamp(clearAppUserID(clearPurchaserInfo(edit)), string).apply();
            clearOfferingsCache();
        }
    }

    public final void clearLatestAttributionData(String string) {
        int i;
        String attributionDataCacheKey;
        n.f(string, "userId");
        SharedPreferences.Editor edit = this.preferences.edit();
        final AttributionNetwork[] values = AttributionNetwork.values();
        i = 0;
        synchronized (this) {
            try {
                while (i < values.length) {
                    edit.remove(getAttributionDataCacheKey(string, values[i]));
                    i++;
                }
                edit.remove(getAttributionDataCacheKey(string, values[i]));
                i++;
                edit.apply();
                throw string;
            }
        }
    }

    public final void clearOfferingsCacheTimestamp() {
        this.offeringsCachedObject.clearCacheTimestamp();
        return;
        synchronized (this) {
            this.offeringsCachedObject.clearCacheTimestamp();
        }
    }

    public final void clearPurchaserInfoCache(String string) {
        n.f(string, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        n.e(edit, "editor");
        clearPurchaserInfoCacheTimestamp(edit, string);
        edit.remove(purchaserInfoCacheKey(string));
        edit.apply();
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            edit = this.preferences.edit();
            n.e(edit, "editor");
            clearPurchaserInfoCacheTimestamp(edit, string);
            edit.remove(purchaserInfoCacheKey(string));
            edit.apply();
        }
    }

    public final void clearPurchaserInfoCacheTimestamp(String string) {
        n.f(string, "appUserID");
        SharedPreferences.Editor edit = this.preferences.edit();
        n.e(edit, "preferences.edit()");
        clearPurchaserInfoCacheTimestamp(edit, string).apply();
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            edit = this.preferences.edit();
            n.e(edit, "preferences.edit()");
            clearPurchaserInfoCacheTimestamp(edit, string).apply();
        }
    }

    public final Set<String> findKeysThatStartWith(String string) {
        Object iterator;
        LinkedHashMap linkedHashMap;
        boolean value;
        boolean key;
        int i;
        int i2;
        int i3;
        Object obj8;
        n.f(string, "cacheKey");
        iterator = this.preferences.getAll();
        if (iterator != null) {
            linkedHashMap = new LinkedHashMap();
            iterator = iterator.entrySet().iterator();
            while (iterator.hasNext()) {
                value = iterator.next();
                Object key2 = (Map.Entry)value.getKey();
                n.e((String)key2, "it");
                if (l.M(key2, string, false, 2, 0)) {
                }
                linkedHashMap.put(value.getKey(), value.getValue());
            }
            try {
                if (linkedHashMap.keySet() != null) {
                } else {
                }
                obj8 = q0.b();
                string = q0.b();
                return obj8;
            }
        } else {
        }
    }

    public final List<PurchaseDetails> getActivePurchasesNotInCache(Map<String, PurchaseDetails> map) {
        n.f(map, "hashedTokens");
        return p.L0(j0.l(map, getPreviouslySentHashedTokens()).values());
        synchronized (this) {
            n.f(map, "hashedTokens");
            return p.L0(j0.l(map, getPreviouslySentHashedTokens()).values());
        }
    }

    public final String getAppUserIDCacheKey() {
        return (String)this.appUserIDCacheKey$delegate.getValue();
    }

    public final String getAttributionCacheKey() {
        return this.attributionCacheKey;
    }

    public final String getCachedAppUserID() {
        return this.preferences.getString(getAppUserIDCacheKey(), 0);
        synchronized (this) {
            return this.preferences.getString(getAppUserIDCacheKey(), 0);
        }
    }

    public final String getCachedAttributionData(AttributionNetwork attributionNetwork, String string2) {
        n.f(attributionNetwork, "network");
        n.f(string2, "userId");
        return this.preferences.getString(getAttributionDataCacheKey(string2, attributionNetwork), 0);
        synchronized (this) {
            n.f(attributionNetwork, "network");
            n.f(string2, "userId");
            return this.preferences.getString(getAttributionDataCacheKey(string2, attributionNetwork), 0);
        }
    }

    public final Offerings getCachedOfferings() {
        return (Offerings)this.offeringsCachedObject.getCachedInstance();
    }

    public final PurchaserInfo getCachedPurchaserInfo(String string) {
        int purchaserInfo;
        n.f(string, "appUserID");
        purchaserInfo = 0;
        String obj4 = this.preferences.getString(purchaserInfoCacheKey(string), purchaserInfo);
        JSONObject jSONObject = new JSONObject(obj4);
        if (obj4 != null && jSONObject.optInt("schema_version") == 3) {
            jSONObject = new JSONObject(obj4);
            if (jSONObject.optInt("schema_version") == 3) {
                purchaserInfo = FactoriesKt.buildPurchaserInfo(jSONObject);
            }
            return purchaserInfo;
        }
        return (PurchaserInfo)purchaserInfo;
    }

    public JSONObject getJSONObjectOrNull(String string) {
        Object jSONObject;
        int i;
        n.f(string, "key");
        final String obj3 = this.preferences.getString(string, 0);
        if (obj3 != null) {
            jSONObject = new JSONObject(obj3);
            i = jSONObject;
        }
        return i;
    }

    public final String getLegacyAppUserIDCacheKey() {
        return (String)this.legacyAppUserIDCacheKey$delegate.getValue();
    }

    public final String getLegacyCachedAppUserID() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey(), 0);
        synchronized (this) {
            return this.preferences.getString(getLegacyAppUserIDCacheKey(), 0);
        }
    }

    public final Set<String> getPreviouslySentHashedTokens() {
        Set stringSet;
        stringSet = this.preferences.getStringSet(getTokensCacheKey(), q0.b());
        synchronized (this) {
            try {
                if (p.P0(stringSet) != null) {
                } else {
                }
                stringSet = q0.b();
                int i = 1;
                final Object[] arr = new Object[i];
                arr[0] = stringSet;
                String format = String.format("Tokens already posted: %s", Arrays.copyOf(arr, i));
                n.e(format, "java.lang.String.format(this, *args)");
                LogWrapperKt.log(LogIntent.DEBUG, format);
                return stringSet;
                throw q0.b();
            } catch (Throwable th) {
            }
        }
    }

    public final Date getPurchaserInfoCachesLastUpdated(String string) {
        n.f(string, "appUserID");
        final int i = 0;
        Date date = new Date(this.preferences.getLong(purchaserInfoLastUpdatedCacheKey(string), i), i);
        return date;
        synchronized (this) {
            n.f(string, "appUserID");
            i = 0;
            date = new Date(this.preferences.getLong(purchaserInfoLastUpdatedCacheKey(string), i), i);
            return date;
        }
    }

    public final String getTokensCacheKey() {
        return (String)this.tokensCacheKey$delegate.getValue();
    }

    public final boolean isOfferingsCacheStale(boolean z) {
        return isStale(this.offeringsCachedObject.getLastUpdatedAt$common_release(), z);
        synchronized (this) {
            return isStale(this.offeringsCachedObject.getLastUpdatedAt$common_release(), z);
        }
    }

    public final boolean isPurchaserInfoCacheStale(String string, boolean z2) {
        n.f(string, "appUserID");
        return isStale(getPurchaserInfoCachesLastUpdated(string), z2);
        synchronized (this) {
            n.f(string, "appUserID");
            return isStale(getPurchaserInfoCachesLastUpdated(string), z2);
        }
    }

    public final String newKey(String string) {
        n.f(string, "key");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.revenuecat.purchases.");
        stringBuilder.append(this.apiKey);
        stringBuilder.append('.');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final String purchaserInfoCacheKey(String string) {
        n.f(string, "appUserID");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getLegacyAppUserIDCacheKey());
        stringBuilder.append('.');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final String purchaserInfoLastUpdatedCacheKey(String string) {
        n.f(string, "appUserID");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPurchaserInfoCachesLastUpdatedCacheBaseKey());
        stringBuilder.append('.');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public void putString(String string, String string2) {
        n.f(string, "cacheKey");
        n.f(string2, "value");
        this.preferences.edit().putString(string, string2).apply();
    }

    public final void remove(String string) {
        n.f(string, "cacheKey");
        this.preferences.edit().remove(string).apply();
    }

    public final void setOfferingsCacheTimestampToNow() {
        Date date = new Date();
        this.offeringsCachedObject.updateCacheTimestamp(date);
        return;
        synchronized (this) {
            date = new Date();
            this.offeringsCachedObject.updateCacheTimestamp(date);
        }
    }

    public final void setPurchaserInfoCacheTimestamp(String string, Date date2) {
        n.f(string, "appUserID");
        n.f(date2, "date");
        this.preferences.edit().putLong(purchaserInfoLastUpdatedCacheKey(string), date2.getTime()).apply();
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            n.f(date2, "date");
            this.preferences.edit().putLong(purchaserInfoLastUpdatedCacheKey(string), date2.getTime()).apply();
        }
    }

    public final void setPurchaserInfoCacheTimestampToNow(String string) {
        n.f(string, "appUserID");
        Date date = new Date();
        setPurchaserInfoCacheTimestamp(string, date);
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            date = new Date();
            setPurchaserInfoCacheTimestamp(string, date);
        }
    }
}
