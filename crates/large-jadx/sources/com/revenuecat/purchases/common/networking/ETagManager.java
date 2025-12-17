package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\u0008.\u0010/J'\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ-\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J9\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0019\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008!\u0010\"J'\u0010'\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008&\u0010\tJ\u000f\u0010*\u001a\u00020\u0007H\u0000¢\u0006\u0004\u0008(\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008,\u0010-¨\u00061", d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager;", "", "", "path", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "result", "eTag", "Lkotlin/w;", "storeResult", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult;Ljava/lang/String;)V", "Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "getStoredResultSavedInSharedPreferences", "(Ljava/lang/String;)Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "getETag", "(Ljava/lang/String;)Ljava/lang/String;", "", "refreshETag", "", "getETagHeader$common_release", "(Ljava/lang/String;Z)Ljava/util/Map;", "getETagHeader", "", "responseCode", "payload", "Ljava/net/HttpURLConnection;", "connection", "urlPathWithVersion", "getHTTPResultFromCacheOrBackend$common_release", "(ILjava/lang/String;Ljava/net/HttpURLConnection;Ljava/lang/String;Z)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "getHTTPResultFromCacheOrBackend", "shouldUseCachedVersion$common_release", "(I)Z", "shouldUseCachedVersion", "getStoredResult$common_release", "(Ljava/lang/String;)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "getStoredResult", "resultFromBackend", "eTagInResponse", "storeBackendResultIfNoError$common_release", "storeBackendResultIfNoError", "clearCaches$common_release", "()V", "clearCaches", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "Companion", "common_release"}, k = 1, mv = {1, 4, 0})
public final class ETagManager {

    public static final com.revenuecat.purchases.common.networking.ETagManager.Companion Companion;
    private final SharedPreferences prefs;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager$Companion;", "", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "initializeSharedPreferences", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            n.f(context, "context");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("_preferences_etags");
            final SharedPreferences obj3 = context.getSharedPreferences(stringBuilder.toString(), 0);
            n.e(obj3, "context.getSharedPrefere…ODE_PRIVATE\n            )");
            return obj3;
        }
    }
    static {
        ETagManager.Companion companion = new ETagManager.Companion(0);
        ETagManager.Companion = companion;
    }

    public ETagManager(SharedPreferences sharedPreferences) {
        n.f(sharedPreferences, "prefs");
        super();
        this.prefs = sharedPreferences;
    }

    private final String getETag(String string) {
        String obj1;
        obj1 = getStoredResultSavedInSharedPreferences(string);
        if (obj1 != null) {
            obj1 = obj1.getETag();
        } else {
            obj1 = 0;
        }
        if (obj1 != null) {
        } else {
            obj1 = "";
        }
        return obj1;
    }

    public static Map getETagHeader$common_release$default(com.revenuecat.purchases.common.networking.ETagManager eTagManager, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return eTagManager.getETagHeader$common_release(string2, obj2);
    }

    private final com.revenuecat.purchases.common.networking.HTTPResultWithETag getStoredResultSavedInSharedPreferences(String string) {
        Object companion;
        int deserialize;
        final String obj3 = this.prefs.getString(string, 0);
        if (obj3 != null) {
            deserialize = HTTPResultWithETag.Companion.deserialize(obj3);
        }
        return deserialize;
    }

    private final void storeResult(String string, com.revenuecat.purchases.common.networking.HTTPResult hTTPResult2, String string3) {
        HTTPResultWithETag hTTPResultWithETag = new HTTPResultWithETag(string3, hTTPResult2);
        this.prefs.edit().putString(string, hTTPResultWithETag.serialize()).apply();
        return;
        synchronized (this) {
            hTTPResultWithETag = new HTTPResultWithETag(string3, hTTPResult2);
            this.prefs.edit().putString(string, hTTPResultWithETag.serialize()).apply();
        }
    }

    public final void clearCaches$common_release() {
        this.prefs.edit().clear().apply();
        return;
        synchronized (this) {
            this.prefs.edit().clear().apply();
        }
    }

    public final Map<String, String> getETagHeader$common_release(String string, boolean z2) {
        String obj2;
        n.f(string, "path");
        if (z2) {
            obj2 = "";
        } else {
            obj2 = getETag(string);
        }
        return j0.e(u.a("X-RevenueCat-ETag", obj2));
    }

    public final com.revenuecat.purchases.common.networking.HTTPResult getHTTPResultFromCacheOrBackend$common_release(int i, String string2, HttpURLConnection httpURLConnection3, String string4, boolean z5) {
        com.revenuecat.purchases.common.networking.HTTPResult hTTPResult;
        int obj2;
        String obj3;
        Object obj4;
        Object obj5;
        n.f(string2, "payload");
        n.f(httpURLConnection3, "connection");
        n.f(string4, "urlPathWithVersion");
        hTTPResult = new HTTPResult(i, string2);
        obj3 = ETagManagerKt.getETagHeader(httpURLConnection3);
        if (obj3 != null && shouldUseCachedVersion$common_release(i)) {
            if (shouldUseCachedVersion$common_release(i)) {
                obj2 = getStoredResult$common_release(string4);
                if (obj2 != null) {
                    hTTPResult = obj2;
                } else {
                    if (z5) {
                        obj3 = 1;
                        obj4 = new Object[obj3];
                        obj4[0] = hTTPResult;
                        obj3 = String.format("We can't find the cached response, but call has already been retried. Returning result from backend: %s", Arrays.copyOf(obj4, obj3));
                        n.e(obj3, "java.lang.String.format(this, *args)");
                        LogWrapperKt.log(LogIntent.WARNING, obj3);
                    } else {
                        hTTPResult = 0;
                    }
                }
                return hTTPResult;
            }
            storeBackendResultIfNoError$common_release(string4, hTTPResult, obj3);
        }
        return hTTPResult;
    }

    public final com.revenuecat.purchases.common.networking.HTTPResult getStoredResult$common_release(String string) {
        com.revenuecat.purchases.common.networking.HTTPResult obj2;
        n.f(string, "path");
        obj2 = getStoredResultSavedInSharedPreferences(string);
        if (obj2 != null) {
            obj2 = obj2.getHttpResult();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public final boolean shouldUseCachedVersion$common_release(int i) {
        int obj2;
        obj2 = i == 304 ? 1 : 0;
        return obj2;
    }

    public final void storeBackendResultIfNoError$common_release(String string, com.revenuecat.purchases.common.networking.HTTPResult hTTPResult2, String string3) {
        int i;
        n.f(string, "path");
        n.f(hTTPResult2, "resultFromBackend");
        n.f(string3, "eTagInResponse");
        int responseCode = hTTPResult2.getResponseCode();
        if (responseCode != 304 && responseCode < 500) {
            if (responseCode < 500) {
                storeResult(string, hTTPResult2, string3);
            }
        }
    }
}
