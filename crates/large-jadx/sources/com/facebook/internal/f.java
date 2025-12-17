package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\u0008\u0010\u0008\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b", d2 = {"Lcom/facebook/internal/CustomTabUtils;", "", "()V", "CHROME_PACKAGES", "", "", "[Ljava/lang/String;", "getChromePackage", "getDefaultRedirectURI", "getValidRedirectURI", "developerDefinedRedirectURI", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    private static final String[] a;
    static {
        f.a = /* result */;
    }

    public static final String a() {
        Object intentServices;
        Object intent;
        int serviceInfo;
        boolean contains;
        final int i = 0;
        if (a.d(f.class)) {
            return i;
        }
        intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intentServices = o.f().getPackageManager().queryIntentServices(intent, 0);
        if (intentServices != null) {
            intentServices = intentServices.iterator();
            for (ResolveInfo next : intentServices) {
                serviceInfo = next.serviceInfo;
            }
        }
        return i;
    }

    public static final String b() {
        if (a.d(f.class)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fbconnect://cct.");
        stringBuilder.append(o.f().getPackageName());
        return stringBuilder.toString();
    }

    public static final String c(String string) {
        if (a.d(f.class)) {
            return null;
        }
        n.f(string, "developerDefinedRedirectURI");
        if (c0.d(o.f(), string)) {
            return string;
        }
        if (c0.d(o.f(), f.b())) {
            return f.b();
        }
        return "";
    }
}
