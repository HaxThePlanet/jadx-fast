package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.Base64;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.g;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\u0011\u0010\u0008\u001a\u00020\u0001*\u00020\u0005¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\u0008\n\u0010\u000b\u001a\u0011\u0010\u000c\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\u0008\u000c\u0010\u000b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\r¢\u0006\u0004\u0008\u0002\u0010\u000e\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u000f¢\u0006\u0004\u0008\u0002\u0010\u0010\u001a\u0011\u0010\u0012\u001a\u00020\u0011*\u00020\r¢\u0006\u0004\u0008\u0012\u0010\u0013\"\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0019¨\u0006\u001a", d2 = {"Lcom/android/billingclient/api/Purchase;", "", "toHumanReadableDescription", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "Landroid/content/Context;", "Ljava/util/Locale;", "getLocale", "(Landroid/content/Context;)Ljava/util/Locale;", "toBCP47", "(Ljava/util/Locale;)Ljava/lang/String;", "sha1", "(Ljava/lang/String;)Ljava/lang/String;", "sha256", "Lcom/android/billingclient/api/g;", "(Lcom/android/billingclient/api/g;)Ljava/lang/String;", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "(Lcom/android/billingclient/api/PurchaseHistoryRecord;)Ljava/lang/String;", "", "isSuccessful", "(Lcom/android/billingclient/api/g;)Z", "getVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "versionName", "", "MICROS_MULTIPLIER", "I", "common_release"}, k = 2, mv = {1, 4, 0})
public final class UtilsKt {

    public static final int MICROS_MULTIPLIER = 1000000;
    public static final Locale getLocale(Context context) {
        int sDK_INT;
        Locale obj3;
        n.f(context, "$this$getLocale");
        final String str3 = "resources";
        if (Build.VERSION.SDK_INT >= 24) {
            obj3 = context.getResources();
            n.e(obj3, str3);
            obj3 = obj3.getConfiguration();
            n.e(obj3, "resources.configuration");
            obj3 = obj3.getLocales().get(0);
        } else {
            obj3 = context.getResources();
            n.e(obj3, str3);
            obj3 = obj3.locale;
        }
        return obj3;
    }

    public static final String getVersionName(Context context) {
        n.f(context, "$this$versionName");
        return obj2.versionName;
    }

    public static final boolean isSuccessful(g g) {
        int obj1;
        n.f(g, "$this$isSuccessful");
        obj1 = g.b() == 0 ? 1 : 0;
        return obj1;
    }

    public static final String sha1(String string) {
        n.f(string, "$this$sha1");
        final java.nio.charset.Charset charset = d.a;
        byte[] obj3 = string.getBytes(charset);
        n.e(obj3, "(this as java.lang.String).getBytes(charset)");
        obj3 = Base64.encode(MessageDigest.getInstance("SHA-1").digest(obj3), 2);
        n.e(obj3, "Base64.encode(it, Base64.NO_WRAP)");
        String string2 = new String(obj3, charset);
        return string2;
    }

    public static final String sha256(String string) {
        n.f(string, "$this$sha256");
        final java.nio.charset.Charset charset = d.a;
        byte[] obj3 = string.getBytes(charset);
        n.e(obj3, "(this as java.lang.String).getBytes(charset)");
        obj3 = Base64.encode(MessageDigest.getInstance("SHA-256").digest(obj3), 2);
        n.e(obj3, "Base64.encode(it, Base64.NO_WRAP)");
        String string2 = new String(obj3, charset);
        return string2;
    }

    public static final String toBCP47(Locale locale) {
        String language;
        int i2;
        String country;
        boolean z;
        int i3;
        int i;
        String str;
        String str2;
        String obj8;
        n.f(locale, "$this$toBCP47");
        if (Build.VERSION.SDK_INT >= 21) {
            obj8 = locale.toLanguageTag();
            n.e(obj8, "toLanguageTag()");
            return obj8;
        }
        int i4 = 45;
        String str14 = "NO";
        str = "";
        if (n.b(locale.getLanguage(), "no") && n.b(locale.getCountry(), str14) && n.b(locale.getVariant(), "NY")) {
            if (n.b(country, str14)) {
                if (n.b(obj8, "NY")) {
                    language = "nn";
                    country = str14;
                    obj8 = str;
                }
            }
        }
        n.e(language, "language");
        i = 1;
        final int i6 = 0;
        i3 = language.length() == 0 ? i : i6;
        if (i3 == 0) {
            h hVar = new h("\\p{Alpha}{2,8}");
            if (!hVar.d(language)) {
                language = "und";
            } else {
                if (n.b(language, "iw")) {
                    language = "he";
                } else {
                    if (n.b(language, "in")) {
                        language = "id";
                    } else {
                        if (n.b(language, "ji")) {
                            language = "yi";
                        }
                    }
                }
            }
        } else {
        }
        n.e(country, "region");
        h hVar2 = new h("\\p{Alpha}{2}|\\p{Digit}{3}");
        if (!hVar2.d(country)) {
            country = str;
        }
        n.e(obj8, "variant");
        h hVar3 = new h("\\p{Alnum}{5,8}|\\p{Digit}\\p{Alnum}{3}");
        if (!hVar3.d(obj8)) {
        } else {
            str = obj8;
        }
        obj8 = new StringBuilder(language);
        i2 = country.length() > 0 ? i : i6;
        if (i2 != 0) {
            obj8.append(i4);
            obj8.append(country);
        }
        if (str.length() > 0) {
        } else {
            i = i6;
        }
        if (i != 0) {
            obj8.append(i4);
            obj8.append(str);
        }
        obj8 = obj8.toString();
        n.e(obj8, "bcp47Tag.toString()");
        return obj8;
    }

    public static final String toHumanReadableDescription(Purchase purchase) {
        n.f(purchase, "$this$toHumanReadableDescription");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("skus: ");
        final java.util.ArrayList list = purchase.g();
        n.e(list, "this.skus");
        stringBuilder.append(p.h0(list, 0, "[", "]", 0, 0, 0, 57, 0));
        stringBuilder.append(", orderId: ");
        stringBuilder.append(purchase.a());
        stringBuilder.append(", purchaseToken: ");
        stringBuilder.append(purchase.e());
        return stringBuilder.toString();
    }

    public static final String toHumanReadableDescription(PurchaseHistoryRecord purchaseHistoryRecord) {
        n.f(purchaseHistoryRecord, "$this$toHumanReadableDescription");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("skus: ");
        final java.util.ArrayList list = purchaseHistoryRecord.e();
        n.e(list, "this.skus");
        stringBuilder.append(p.h0(list, 0, "[", "]", 0, 0, 0, 57, 0));
        stringBuilder.append(", purchaseTime: ");
        stringBuilder.append(purchaseHistoryRecord.b());
        stringBuilder.append(", purchaseToken: ");
        stringBuilder.append(purchaseHistoryRecord.c());
        return stringBuilder.toString();
    }

    public static final String toHumanReadableDescription(g g) {
        n.f(g, "$this$toHumanReadableDescription");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DebugMessage: ");
        stringBuilder.append(g.a());
        stringBuilder.append(". ErrorCode: ");
        stringBuilder.append(ErrorsKt.getBillingResponseCodeName(g.b()));
        stringBuilder.append('.');
        return stringBuilder.toString();
    }
}
