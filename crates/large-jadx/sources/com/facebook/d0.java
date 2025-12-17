package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.facebook.e0.m;
import com.facebook.internal.a;
import com.facebook.internal.a.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0010\u0008Á\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001d\u001a\u00020\u001eH\u0007J\u0008\u0010\u001f\u001a\u00020\u001eH\u0007J\u0008\u0010 \u001a\u00020\u001eH\u0007J\u0008\u0010!\u001a\u00020\u001eH\u0007J\u0008\u0010\"\u001a\u00020\u001eH\u0007J\u0008\u0010#\u001a\u00020$H\u0002J\u0008\u0010%\u001a\u00020$H\u0002J!\u0010&\u001a\u00020$2\u0012\u0010'\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00130(\"\u00020\u0013H\u0002¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0008\u0010,\u001a\u00020$H\u0007J\u0008\u0010-\u001a\u00020$H\u0002J\u0008\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001eH\u0007J\u0010\u00102\u001a\u00020$2\u0006\u00101\u001a\u00020\u001eH\u0007J\u0010\u00103\u001a\u00020$2\u0006\u00101\u001a\u00020\u001eH\u0007J\u0010\u00104\u001a\u00020$2\u0006\u00101\u001a\u00020\u001eH\u0007J\u0008\u00105\u001a\u00020$H\u0002J\u0010\u00106\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u00068", d2 = {"Lcom/facebook/UserSettingsManager;", "", "()V", "ADVERTISERID_COLLECTION_FALSE_WARNING", "", "ADVERTISERID_COLLECTION_NOT_SET_WARNING", "ADVERTISER_ID_KEY", "APPLICATION_FIELDS", "AUTOLOG_APPEVENT_NOT_SET_WARNING", "AUTO_APP_LINK_WARNING", "EVENTS_CODELESS_SETUP_ENABLED", "LAST_TIMESTAMP", "TAG", "TIMEOUT_7D", "", "USER_SETTINGS", "USER_SETTINGS_BITMASK", "VALUE", "advertiserIDCollectionEnabled", "Lcom/facebook/UserSettingsManager$UserSetting;", "autoInitEnabled", "autoLogAppEventsEnabled", "codelessSetupEnabled", "isFetchingCodelessStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "monitorEnabled", "userSettingPref", "Landroid/content/SharedPreferences;", "getAdvertiserIDCollectionEnabled", "", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCodelessSetupEnabled", "getMonitorEnabled", "initializeCodelessSetupEnabledAsync", "", "initializeIfNotInitialized", "initializeUserSetting", "userSettings", "", "([Lcom/facebook/UserSettingsManager$UserSetting;)V", "loadSettingFromManifest", "userSetting", "logIfAutoAppLinkEnabled", "logIfSDKSettingsChanged", "logWarnings", "readSettingFromCache", "setAdvertiserIDCollectionEnabled", "flag", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setMonitorEnabled", "validateInitialized", "writeSettingToCache", "UserSetting", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d0 {

    private static final String a;
    private static final AtomicBoolean b;
    private static final AtomicBoolean c;
    private static final com.facebook.d0.a d;
    private static final com.facebook.d0.a e;
    private static final com.facebook.d0.a f;
    private static final com.facebook.d0.a g;
    private static final com.facebook.d0.a h;
    private static SharedPreferences i;
    public static final com.facebook.d0 j;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019¨\u0006\u001b", d2 = {"Lcom/facebook/UserSettingsManager$UserSetting;", "", "defaultVal", "", "key", "", "(ZLjava/lang/String;)V", "getDefaultVal", "()Z", "setDefaultVal", "(Z)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "lastTS", "", "getLastTS", "()J", "setLastTS", "(J)V", "value", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        private Boolean a;
        private long b;
        private boolean c;
        private String d;
        public a(boolean z, String string2) {
            n.f(string2, "key");
            super();
            this.c = z;
            this.d = string2;
        }

        public final boolean a() {
            return this.c;
        }

        public final String b() {
            return this.d;
        }

        public final long c() {
            return this.b;
        }

        public final Boolean d() {
            return this.a;
        }

        public final boolean e() {
            boolean booleanValue;
            Boolean bool = this.a;
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = this.c;
            }
            return booleanValue;
        }

        public final void f(long l) {
            this.b = l;
        }

        public final void g(Boolean boolean) {
            this.a = boolean;
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final long a;
        b(long l) {
            this.a = l;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object str;
            String z;
            int i;
            String bundle;
            String str2;
            str = "auto_event_setup_enabled";
            if (a.d(this)) {
            }
            com.facebook.d0 d0Var = d0.j;
            final int i2 = 0;
            z = q.o(o.g(), i2);
            if (d0.a(d0Var).e() && z != null && z.b()) {
                z = q.o(o.g(), i2);
                if (z != null) {
                    if (z.b()) {
                        a aVar3 = a.h.e(o.f());
                        i = 0;
                        if (aVar3 != null && aVar3.h() != null) {
                            if (aVar3.h() != null) {
                                z = aVar3.h();
                            } else {
                                z = i;
                            }
                        } else {
                        }
                        try {
                            if (z != null) {
                            }
                            bundle = new Bundle();
                            bundle.putString("advertiser_id", z);
                            bundle.putString("fields", str);
                            if (b0.W(o.l())) {
                            } else {
                            }
                            com.facebook.p pVar = p.t.v(i, o.g(), i);
                            pVar.G(true);
                            pVar.F(bundle);
                            z = pVar.i().c();
                            com.facebook.p pVar2 = p.t.v(i, "app", i);
                            pVar2.F(bundle);
                            z = pVar2.i().c();
                            if (z != null) {
                            }
                            d0.b(d0Var).g(Boolean.valueOf(z.optBoolean(str, i2)));
                            d0.b(d0Var).f(this.a);
                            d0.d(d0Var, d0.b(d0Var));
                            d0.c(d0Var).set(i2);
                            a.b(th, this);
                        }
                    }
                }
            }
        }
    }
    static {
        d0 d0Var = new d0();
        d0.j = d0Var;
        String name = d0.class.getName();
        n.e(name, "UserSettingsManager::class.java.name");
        d0.a = name;
        int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        d0.b = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i);
        d0.c = atomicBoolean2;
        final int i2 = 1;
        d0.a aVar = new d0.a(i2, "com.facebook.sdk.AutoInitEnabled");
        d0.d = aVar;
        d0.a aVar2 = new d0.a(i2, "com.facebook.sdk.AutoLogAppEventsEnabled");
        d0.e = aVar2;
        d0.a aVar3 = new d0.a(i2, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
        d0.f = aVar3;
        d0.a aVar4 = new d0.a(i, "auto_event_setup_enabled");
        d0.g = aVar4;
        d0.a aVar5 = new d0.a(i2, "com.facebook.sdk.MonitorEnabled");
        d0.h = aVar5;
    }

    public static final com.facebook.d0.a a(com.facebook.d0 d0) {
        if (a.d(d0.class)) {
            return null;
        }
        return d0.f;
    }

    public static final com.facebook.d0.a b(com.facebook.d0 d0) {
        if (a.d(d0.class)) {
            return null;
        }
        return d0.g;
    }

    public static final AtomicBoolean c(com.facebook.d0 d0) {
        if (a.d(d0.class)) {
            return null;
        }
        return d0.c;
    }

    public static final void d(com.facebook.d0 d0, com.facebook.d0.a d0$a2) {
        if (a.d(d0.class)) {
        }
        d0.r(a2);
    }

    public static final boolean e() {
        if (a.d(d0.class)) {
            return 0;
        }
        d0.j.j();
        return d0.f.e();
    }

    public static final boolean f() {
        if (a.d(d0.class)) {
            return 0;
        }
        d0.j.j();
        return d0.d.e();
    }

    public static final boolean g() {
        if (a.d(d0.class)) {
            return 0;
        }
        d0.j.j();
        return d0.e.e();
    }

    public static final boolean h() {
        if (a.d(d0.class)) {
            return 0;
        }
        d0.j.j();
        return d0.g.e();
    }

    private final void i() {
        Boolean cmp;
        int i;
        if (a.d(this)) {
        }
        com.facebook.d0.a aVar = d0.g;
        p(aVar);
        final long currentTimeMillis = System.currentTimeMillis();
        if (aVar.d() != null && Long.compare(i2, i) < 0) {
            if (Long.compare(i2, i) < 0) {
            }
        }
        aVar.g(0);
        aVar.f(0);
        if (!d0.c.compareAndSet(false, true)) {
        }
        try {
            d0.b bVar = new d0.b(currentTimeMillis, obj2);
            o.n().execute(bVar);
            a.b(th, this);
        }
    }

    private final void j() {
        if (a.d(this)) {
        }
        if (!o.y()) {
        }
        int i2 = 1;
        int i4 = 0;
        if (!d0.b.compareAndSet(i4, i2)) {
        }
        SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", i4);
        n.e(sharedPreferences, "FacebookSdk.getApplicati…GS, Context.MODE_PRIVATE)");
        d0.i = sharedPreferences;
        com.facebook.d0.a[] arr = new d0.a[3];
        arr[i4] = d0.e;
        arr[i2] = d0.f;
        arr[2] = d0.d;
        k(arr);
        i();
        o();
        n();
    }

    private final void k(com.facebook.d0.a... d0$aArr) {
        int i;
        Object obj;
        Boolean bool;
        if (a.d(this)) {
        }
        i = 0;
        while (i < aArr.length) {
            obj = aArr[i];
            if (obj == d0.g) {
            } else {
            }
            if (obj.d() == null) {
            } else {
            }
            r(obj);
            i++;
            p(obj);
            if (obj.d() == null) {
            }
            l(obj);
            i();
        }
    }

    private final void l(com.facebook.d0.a d0$a) {
        Object applicationInfo;
        Bundle metaData;
        int i;
        Throwable obj4;
        if (a.d(this)) {
        }
        q();
        Context context = o.f();
        applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        metaData = applicationInfo != null ? applicationInfo.metaData : 0;
        if (metaData != null && applicationInfo.metaData.containsKey(a.b())) {
            if (applicationInfo.metaData.containsKey(a.b())) {
                try {
                    a.g(Boolean.valueOf(applicationInfo.metaData.getBoolean(a.b(), a.a())));
                    b0.c0(d0.a, a);
                } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                } catch (Throwable th1) {
                }
            }
        }
    }

    public static final void m() {
        String str;
        Object bundle;
        android.content.pm.ApplicationInfo applicationInfo;
        Bundle metaData;
        int i;
        str = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
        if (a.d(d0.class)) {
        }
        bundle = o.f();
        applicationInfo = bundle.getPackageManager().getApplicationInfo(bundle.getPackageName(), 128);
        metaData = applicationInfo != null ? applicationInfo.metaData : 0;
        applicationInfo = new m(bundle);
        bundle = new Bundle();
        if (metaData != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false) && !b0.O()) {
            if (applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                applicationInfo = new m(bundle);
                bundle = new Bundle();
                if (!b0.O()) {
                    bundle.putString("SchemeWarning", str);
                    Log.w(d0.a, str);
                }
                applicationInfo.d("fb_auto_applink", bundle);
            }
        }
        try {
        }
    }

    private final void n() {
        Object mVar;
        Object bundle;
        int i;
        int str;
        int i5;
        int i6;
        int i7;
        int i3;
        int i11;
        int i2;
        int i10;
        String packageName;
        int metaData;
        int zArr;
        int i8;
        int i9;
        int i4;
        Object obj;
        boolean z;
        mVar = "com.facebook.sdk.USER_SETTINGS_BITMASK";
        if (a.d(this)) {
        }
        if (!d0.b.get()) {
        }
        if (!o.y()) {
        }
        bundle = o.f();
        str = 1;
        i6 = 0;
        i = d0.d.e() ? str : i6;
        try {
            if (d0.e.e()) {
            } else {
            }
            i7 = str;
            i7 = i6;
            if (d0.f.e()) {
            } else {
            }
            i3 = str;
            i3 = i6;
            i2 = 2;
            if (d0.h.e()) {
            } else {
            }
            i11 = str;
            i11 = i6;
            i10 = 3;
            i15 |= i19;
            SharedPreferences sharedPreferences = d0.i;
            packageName = "userSettingPref";
            metaData = 0;
            if (sharedPreferences == null) {
            } else {
            }
            int int2 = sharedPreferences.getInt(mVar, i6);
            if (int2 != i16) {
            }
            SharedPreferences sharedPreferences2 = d0.i;
            if (sharedPreferences2 == null) {
            } else {
            }
            sharedPreferences2.edit().putInt(mVar, i16).apply();
            android.content.pm.ApplicationInfo applicationInfo = bundle.getPackageManager().getApplicationInfo(bundle.getPackageName(), 128);
            if (applicationInfo != null) {
            }
            metaData = applicationInfo.metaData;
            if (metaData != null) {
            } else {
            }
            packageName = /* result */;
            metaData = 4;
            zArr = new boolean[metaData];
            zArr[i6] = str;
            zArr[str] = str;
            zArr[i2] = str;
            zArr[i10] = str;
            i8 = i10;
            while (i2 < metaData) {
                if (applicationInfo.metaData.containsKey(packageName[i2])) {
                } else {
                }
                i4 = i6;
                i8 |= i21;
                i10 |= i9;
                i2++;
                i4 = str;
            }
            if (applicationInfo.metaData.containsKey(packageName[i2])) {
            } else {
            }
            i4 = str;
            i4 = i6;
            i8 |= i21;
            i10 |= i9;
            i2++;
            i5 = i20;
            i10 = i6;
            i8 = i5;
            i6 = i8;
            mVar = new m(bundle);
            bundle = new Bundle();
            bundle.putInt("usage", i6);
            bundle.putInt("initial", i10);
            bundle.putInt("previous", int2);
            bundle.putInt("current", i16);
            mVar.b(bundle);
            n.w(packageName);
            throw metaData;
            n.w(packageName);
            throw metaData;
            a.b(th, this);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
        } catch (Throwable th1) {
        }
    }

    private final void o() {
        boolean key;
        android.content.pm.ApplicationInfo applicationInfo;
        Bundle metaData;
        boolean key2;
        String str;
        if (a.d(this)) {
        }
        Context context = o.f();
        applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        metaData = applicationInfo != null ? applicationInfo.metaData : 0;
        if (metaData != null && !applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
            if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                try {
                    Log.w(d0.a, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                    if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    }
                    Log.w(d0.a, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                    if (!d0.e()) {
                    }
                    Log.w(d0.a, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
                    a.b(th, this);
                }
            }
        }
    }

    private final void p(com.facebook.d0.a d0$a) {
        String long;
        int jSONObject;
        Throwable obj4;
        if (a.d(this)) {
        }
        q();
        SharedPreferences sharedPreferences = d0.i;
        if (sharedPreferences == null) {
        } else {
            String string = sharedPreferences.getString(a.b(), "");
            if (string != null) {
                long = string;
            }
            n.e(long, "userSettingPref.getStrin…serSetting.key, \"\") ?: \"\"");
            jSONObject = long.length() > 0 ? 1 : 0;
            if (jSONObject != null) {
                try {
                    jSONObject = new JSONObject(long);
                    a.g(Boolean.valueOf(jSONObject.getBoolean("value")));
                    a.f(jSONObject.getLong("last_timestamp"));
                    n.w("userSettingPref");
                    throw 0;
                    b0.c0(d0.a, a);
                } catch (org.json.JSONException jSON) {
                } catch (Throwable th1) {
                }
            }
            try {
                a.b(a, this);
            }
        }
    }

    private final void q() {
        if (a.d(this)) {
        }
        if (!d0.b.get()) {
        } else {
        }
        FacebookSdkNotInitializedException facebookSdkNotInitializedException = new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        throw facebookSdkNotInitializedException;
    }

    private final void r(com.facebook.d0.a d0$a) {
        String string;
        SharedPreferences.Editor obj5;
        if (a.d(this)) {
        }
        q();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", a.d());
        jSONObject.put("last_timestamp", a.c());
        SharedPreferences sharedPreferences = d0.i;
        if (sharedPreferences == null) {
        } else {
            sharedPreferences.edit().putString(a.b(), jSONObject.toString()).apply();
            n();
        }
        n.w("userSettingPref");
        throw 0;
    }
}
