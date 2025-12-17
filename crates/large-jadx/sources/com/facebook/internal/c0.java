package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u0011\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u000e\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010\u000f\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0008\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0008\u0010\u0017\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010\"\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J$\u0010$\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010%\u001a\u00020\u000b2\u0008\u0010#\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010&\u001a\u00020\u00042\u0008\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J7\u0010'\u001a\u00020\u000b2\u0008\u0010#\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010(\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010)\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010*J\u0008\u0010+\u001a\u00020\u000bH\u0007J\u0008\u0010,\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lcom/facebook/internal/Validate;", "", "()V", "CONTENT_PROVIDER_BASE", "", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CUSTOM_TAB_REDIRECT_URI_PREFIX", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "NO_INTERNET_PERMISSION_REASON", "TAG", "containsNoNullOrEmpty", "", "container", "", "name", "containsNoNulls", "T", "hasAppID", "hasBluetoothPermission", "", "context", "Landroid/content/Context;", "hasChangeWifiStatePermission", "hasClientToken", "hasContentProvider", "hasCustomTabRedirectActivity", "redirectURI", "hasFacebookActivity", "shouldThrow", "hasInternetPermissions", "hasLocationPermission", "hasPermission", "permission", "hasWiFiPermission", "notEmpty", "arg", "notEmptyAndContainsNoNulls", "notNull", "notNullOrEmpty", "oneOf", "values", "", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "runningOnUiThread", "sdkInitialized", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c0 {

    private static final String a;
    static {
        String name = c0.class.getName();
        n.e(name, "Validate::class.java.name");
        c0.a = name;
    }

    public static final <T> void a(Collection<? extends T> collection, String string2) {
        String next;
        n.f(collection, "container");
        n.f(string2, "name");
        c0.j(collection, string2);
        Iterator obj2 = collection.iterator();
        for (Object next : obj2) {
        }
    }

    public static final String b() {
        String str = o.g();
        if (str == null) {
        } else {
            return str;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No App ID found, please set the App ID.".toString());
        throw illegalStateException;
    }

    public static final String c() {
        String str = o.l();
        if (str == null) {
        } else {
            return str;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No Client Token found, please set the Client Token.".toString());
        throw illegalStateException;
    }

    public static final boolean d(Context context, String string2) {
        int i;
        Intent intent;
        android.content.pm.ActivityInfo activityInfo;
        String packageName;
        String str;
        int obj5;
        String str2 = "context";
        n.f(context, str2);
        c0.j(context, str2);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(string2));
            obj5 = packageManager.queryIntentActivities(intent, 64);
        } else {
            obj5 = 0;
        }
        i = 0;
        if (obj5 != null) {
            obj5 = obj5.iterator();
            intent = i;
            for (ResolveInfo next : obj5) {
                activityInfo = next.activityInfo;
                intent = 1;
            }
            i = intent;
        }
        return i;
    }

    public static final void e(Context context, boolean z2) {
        ComponentName componentName;
        String str;
        int obj4;
        int obj5;
        String str2 = "context";
        n.f(context, str2);
        c0.j(context, str2);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            componentName = new ComponentName(context, "com.facebook.FacebookActivity");
            obj4 = packageManager.getActivityInfo(componentName, 1);
        } else {
            obj4 = 0;
        }
        if (obj4 == null) {
            obj5 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
            if (z2 ^ 1 == 0) {
            } else {
                Log.w(c0.a, obj5);
            }
            obj4 = new IllegalStateException(obj5.toString());
            throw obj4;
        }
    }

    public static final void f(Context context, boolean z2) {
        int obj1;
        int obj2;
        String str = "context";
        n.f(context, str);
        c0.j(context, str);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            obj2 = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
            if (z2 ^ 1 == 0) {
            } else {
                Log.w(c0.a, obj2);
            }
            obj1 = new IllegalStateException(obj2.toString());
            throw obj1;
        }
    }

    public static final void g(String string, String string2) {
        int obj1;
        n.f(string, "arg");
        n.f(string2, "name");
        obj1 = string.length() > 0 ? 1 : 0;
        if (obj1 == null) {
        } else {
        }
        obj1 = new StringBuilder();
        obj1.append("Argument '");
        obj1.append(string2);
        obj1.append("' cannot be empty");
        IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
        throw obj2;
    }

    public static final <T> void h(Collection<? extends T> collection, String string2) {
        n.f(collection, "container");
        n.f(string2, "name");
        if (obj1 ^= 1 == 0) {
        } else {
        }
        StringBuilder obj1 = new StringBuilder();
        obj1.append("Container '");
        obj1.append(string2);
        obj1.append("' cannot be empty");
        IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
        throw obj2;
    }

    public static final <T> void i(Collection<? extends T> collection, String string2) {
        n.f(collection, "container");
        n.f(string2, "name");
        c0.a(collection, string2);
        c0.h(collection, string2);
    }

    public static final void j(Object object, String string2) {
        n.f(string2, "name");
        if (object == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Argument '");
        stringBuilder.append(string2);
        stringBuilder.append("' cannot be null");
        NullPointerException obj2 = new NullPointerException(stringBuilder.toString());
        throw obj2;
    }

    public static final String k(String string, String string2) {
        int i;
        int i2;
        n.f(string2, "name");
        final int i3 = 0;
        if (string != null) {
            i2 = string.length() > 0 ? i : i3;
            if (i2 != 0) {
            } else {
                i = i3;
            }
        } else {
        }
        if (i == 0) {
        } else {
            return string;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Argument '");
        obj3.append(string2);
        obj3.append("' cannot be null or empty");
        IllegalArgumentException obj4 = new IllegalArgumentException(obj3.toString().toString());
        throw obj4;
    }

    public static final void l() {
        if (!o.y()) {
        } else {
        }
        FacebookSdkNotInitializedException facebookSdkNotInitializedException = new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        throw facebookSdkNotInitializedException;
    }
}
