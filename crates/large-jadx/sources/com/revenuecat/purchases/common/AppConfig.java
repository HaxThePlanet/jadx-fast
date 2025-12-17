package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.Store;
import java.net.URL;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0008\u0010)\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008*\u0010+J\u001a\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\u000c8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u0012\u001a\u0004\u0008\u001b\u0010\u000bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%¨\u0006,", d2 = {"Lcom/revenuecat/purchases/common/AppConfig;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/revenuecat/purchases/Store;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "versionName", "Ljava/lang/String;", "getVersionName", "finishTransactions", "Z", "getFinishTransactions", "()Z", "setFinishTransactions", "(Z)V", "languageTag", "getLanguageTag", "Ljava/net/URL;", "baseURL", "Ljava/net/URL;", "getBaseURL", "()Ljava/net/URL;", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "Landroid/content/Context;", "context", "observerMode", "proxyURL", "<init>", "(Landroid/content/Context;ZLcom/revenuecat/purchases/common/PlatformInfo;Ljava/net/URL;Lcom/revenuecat/purchases/Store;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class AppConfig {

    private final URL baseURL;
    private boolean finishTransactions;
    private final String languageTag;
    private final com.revenuecat.purchases.common.PlatformInfo platformInfo;
    private final Store store;
    private final String versionName;
    public AppConfig(Context context, boolean z2, com.revenuecat.purchases.common.PlatformInfo platformInfo3, URL uRL4, Store store5) {
        Object obj2;
        String obj3;
        Object obj4;
        URL obj5;
        String obj6;
        n.f(context, "context");
        n.f(platformInfo3, "platformInfo");
        n.f(store5, "store");
        super();
        this.platformInfo = platformInfo3;
        this.store = store5;
        obj4 = UtilsKt.getLocale(context);
        if (obj4 != null && UtilsKt.toBCP47(obj4) != null) {
            if (UtilsKt.toBCP47(obj4) != null) {
            } else {
                obj4 = obj6;
            }
        } else {
        }
        this.languageTag = obj4;
        obj2 = UtilsKt.getVersionName(context);
        obj6 = obj2 != null ? obj2 : obj6;
        this.versionName = obj6;
        this.finishTransactions = z2 ^ 1;
        LogWrapperKt.log(LogIntent.INFO, "Purchases is being configured using a proxy for RevenueCat");
        obj2 = w.a;
        if (uRL4 != null && uRL4 != null) {
            LogWrapperKt.log(LogIntent.INFO, "Purchases is being configured using a proxy for RevenueCat");
            obj2 = w.a;
            if (uRL4 != null) {
            } else {
                obj5 = new URL("https://api.revenuecat.com/");
            }
        } else {
        }
        this.baseURL = obj5;
    }

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
        int i6 = 0;
        if (z ^= i != 0) {
            return i6;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.common.AppConfig");
        if (z2 ^= i != 0) {
            return i6;
        }
        if (z3 ^= i != 0) {
            return i6;
        }
        if (z4 ^= i != 0) {
            return i6;
        }
        if (this.finishTransactions != object.finishTransactions) {
            return i6;
        }
        if (obj5 ^= i != 0) {
            return i6;
        }
        return i;
    }

    public final URL getBaseURL() {
        return this.baseURL;
    }

    public final boolean getFinishTransactions() {
        return this.finishTransactions;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final com.revenuecat.purchases.common.PlatformInfo getPlatformInfo() {
        return this.platformInfo;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public final void setFinishTransactions(boolean z) {
        this.finishTransactions = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppConfig(");
        stringBuilder.append("platformInfo=");
        stringBuilder.append(this.platformInfo);
        String str3 = ", ";
        stringBuilder.append(str3);
        stringBuilder.append("languageTag='");
        stringBuilder.append(this.languageTag);
        String str6 = "', ";
        stringBuilder.append(str6);
        stringBuilder.append("versionName='");
        stringBuilder.append(this.versionName);
        stringBuilder.append(str6);
        stringBuilder.append("finishTransactions=");
        stringBuilder.append(this.finishTransactions);
        stringBuilder.append(str3);
        stringBuilder.append("baseURL=");
        stringBuilder.append(this.baseURL);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
