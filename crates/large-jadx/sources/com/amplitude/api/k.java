package com.amplitude.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfo.java */
/* loaded from: classes.dex */
public class k {

    private static final String d = "com.amplitude.api.k";
    private boolean a = true;
    private Context b;
    private k.b c;

    static class a {
    }

    private class b {

        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private boolean k;
        private boolean l;
        private String m;
        final /* synthetic */ k n;
        /* synthetic */ b(k.a aVar) {
            this(kVar);
        }

        private String A() {
            return Build.MODEL;
        }

        private String C() {
            return Build.VERSION.RELEASE;
        }

        private String D() {
            try {
            } catch (android.content.pm.PackageManager.NameNotFoundException | Exception unused) {
                return null;
            }
            return this.n.b.getPackageManager().getPackageInfo(this.n.b.getPackageName(), 0).versionName;
        }

        static /* synthetic */ String a(k.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ String b(k.b bVar) {
            return bVar.j;
        }

        static /* synthetic */ String c(k.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ boolean d(k.b bVar) {
            return bVar.k;
        }

        static /* synthetic */ String e(k.b bVar) {
            return bVar.m;
        }

        static /* synthetic */ boolean f(k.b bVar) {
            return bVar.l;
        }

        static /* synthetic */ String g(k.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ String h(k.b bVar) {
            return bVar.d;
        }

        static /* synthetic */ String i(k.b bVar) {
            return bVar.e;
        }

        static /* synthetic */ String j(k.b bVar) {
            return bVar.f;
        }

        static /* synthetic */ String k(k.b bVar) {
            return bVar.g;
        }

        static /* synthetic */ String l(k.b bVar) {
            return bVar.h;
        }

        static /* synthetic */ String m(k.b bVar) {
            return bVar.i;
        }

        private boolean n() {
            com.amplitude.api.g gVar;
            boolean z2 = false;
            String str3;
            StringBuilder stringBuilder;
            String str6;
            str = "Google Play Services Util not found!";
            int i2 = 0;
            try {
                final int i = 1;
                Class[] arr = new Class[i];
                arr[i2] = Context.class;
                Object[] arr2 = new Object[i];
                arr2[i2] = this.n.b;
                Object invoke = Class.forName("com.google.android.gms.common.g").getMethod("isGooglePlayServicesAvailable", arr).invoke(null, arr2);
            } catch (Exception e) {
                gVar = g.d();
                str3 = k.d;
                stringBuilder = new StringBuilder();
                str6 = "Error when checking for Google Play Services: ";
                e = str6 + e;
                gVar.e(str3, e);
            } catch (java.lang.IllegalAccessException unused) {
                Throwable e2 = g.d();
                str3 = k.d;
                e2.e(str3, gVar);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                e2 = g.d();
                str3 = k.d;
                e2.e(str3, gVar);
            } catch (java.lang.NoSuchMethodException unused) {
                e2 = g.d();
                str3 = k.d;
                e2.e(str3, gVar);
            } catch (java.lang.ClassNotFoundException unused) {
                gVar = g.d();
                str3 = k.d;
                gVar.e(str3, e2);
            } catch (java.lang.NoClassDefFoundError unused) {
                gVar = g.d();
                str3 = k.d;
                gVar.e(str3, e2);
            }
            return z2;
        }

        private String o() {
            if ("Amazon".equals(z())) {
                return p();
            }
            return q();
        }

        private String p() throws android.provider.Settings.SettingNotFoundException {
            int i = 0;
            android.content.ContentResolver contentResolver = this.n.b.getContentResolver();
            i = 0;
            i = 1;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking", i) == i) {
            }
            this.k = i;
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            this.a = string;
            return string;
        }

        private String q() throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException {
            Object invoke2;
            int i = 1;
            try {
                i = 1;
                Class[] arr3 = new Class[i];
                i = 0;
                arr3[i] = Context.class;
                Object[] arr4 = new Object[i];
                arr4[i] = this.n.b;
                Object invoke3 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", arr3).invoke(null, arr4);
                invoke2 = invoke3.getClass().getMethod("isLimitAdTrackingEnabled", new Class[i]).invoke(invoke3, new Object[i]);
                if (invoke2 == null || !invoke2.booleanValue()) {
                }
                this.k = i;
                this.a = (String)invoke3.getClass().getMethod("getId", new Class[i]).invoke(invoke3, new Object[i]);
            } catch (Exception e) {
                com.amplitude.api.g gVar = g.d();
                String str4 = k.d;
                gVar.c(str4, "Encountered an error connecting to Google Play Services for advertising id", e);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                Throwable e2 = g.d();
                gVar = k.d;
                str4 = "Google Play Services not available for advertising id";
                e2.e(gVar, str4);
            } catch (java.lang.ClassNotFoundException unused) {
                e2 = g.d();
                gVar = k.d;
                str4 = "Google Play Services SDK not found for advertising id!";
                e2.e(gVar, str4);
            }
            return this.a;
        }

        private String r() throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException {
            try {
                int i = 1;
                Class[] arr5 = new Class[i];
                final int i2 = 0;
                arr5[i2] = Context.class;
                Object[] arr3 = new Object[i];
                arr3[i2] = this.n.b;
                Object obj = null;
                Object invoke2 = Class.forName("com.google.android.gms.appset.AppSet").getMethod("getClient", arr5).invoke(obj, arr3);
                Class[] arr8 = new Class[i];
                arr8[i2] = Class.forName("com.google.android.gms.tasks.j");
                Object[] arr4 = new Object[i];
                arr4[i2] = invoke2.getClass().getMethod("getAppSetInfo", new Class[i2]).invoke(invoke2, new Object[i2]);
                Object invoke4 = Class.forName("com.google.android.gms.tasks.m").getMethod("await", arr8).invoke(obj, arr4);
                this.m = (String)invoke4.getClass().getMethod("getId", new Class[i2]).invoke(invoke4, new Object[i2]);
            } catch (Exception e) {
                com.amplitude.api.g gVar = g.d();
                String str5 = k.d;
                gVar.c(str5, "Encountered an error connecting to Google Play Services for app set id", e);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                Throwable e2 = g.d();
                gVar = k.d;
                str5 = "Google Play Services not available for app set id";
                e2.e(gVar, str5);
            } catch (java.lang.ClassNotFoundException unused) {
                e2 = g.d();
                gVar = k.d;
                str5 = "Google Play Services SDK not found for app set id!";
                e2.e(gVar, str5);
            }
            return this.m;
        }

        private String s() {
            return Build.BRAND;
        }

        private String t() {
            try {
            } catch (Exception unused) {
                return null;
            }
            return (TelephonyManager)this.n.b.getSystemService("phone").getNetworkOperatorName();
        }

        private String u() {
            String str = w();
            if (!n.d(str)) {
                return str;
            }
            String str2 = x();
            if (!n.d(str2)) {
                return str2;
            }
            return v();
        }

        private String v() {
            return Locale.getDefault().getCountry();
        }

        private String w() {
            final int i2 = 0;
            if (!this.n.t()) {
                return null;
            }
            Location location = this.n.n();
            if (location != null && Geocoder.isPresent()) {
                List fromLocation = this.n.j().getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation != null) {
                    Iterator it = fromLocation.iterator();
                    while (it.hasNext()) {
                        com.amplitude.api.k item = it.next();
                        if (item != null) {
                        }
                    }
                }
            }
            return i2;
        }

        private String x() {
            try {
                Object systemService = this.n.b.getSystemService("phone");
                String networkCountryIso = systemService.getNetworkCountryIso();
            } catch (Exception unused) {
                return null;
            }
            return networkCountryIso.toUpperCase(Locale.US);
        }

        private String y() {
            return Locale.getDefault().getLanguage();
        }

        private String z() {
            return Build.MANUFACTURER;
        }

        private b() {
            this.n = kVar;
            super();
            this.a = o();
            this.c = D();
            this.d = B();
            this.e = C();
            this.f = s();
            this.g = z();
            this.h = A();
            this.i = t();
            this.b = u();
            this.j = y();
            this.l = n();
            this.m = r();
        }

        private String B() {
            return "android";
        }
    }
    public k(Context context, boolean z) {
        super();
        this.b = context;
        this.a = z;
    }

    static /* synthetic */ Context a(k kVar) {
        return kVar.b;
    }

    static /* synthetic */ String b() {
        return k.d;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    private k.b g() {
        if (this.c == null) {
            com.amplitude.api.k.a aVar = null;
            this.c = new k.b(this, aVar);
        }
        return this.c;
    }

    public String d() {
        return g().a;
    }

    public String e() {
        return g().m;
    }

    public String f() {
        return g().f;
    }

    public String h() {
        return g().i;
    }

    public String i() {
        return g().b;
    }

    protected Geocoder j() {
        return new Geocoder(this.b, Locale.ENGLISH);
    }

    public String k() {
        return g().j;
    }

    public String l() {
        return g().g;
    }

    public String m() {
        return g().h;
    }

    public Location n() {
        int time = -1;
        int i = 0;
        List providers;
        com.amplitude.api.g gVar;
        Object obj;
        String str4;
        String obj2;
        i = 0;
        if (!t()) {
            return null;
        }
        if (!n.a(this.b)) {
            return i;
        }
        Object systemService = this.b.getSystemService("location");
        if (systemService == null) {
            return i;
        }
        try {
            providers = systemService.getProviders(true);
        } catch (Exception unused) {
            gVar = g.d();
            str4 = k.d;
            gVar.e(str4, str);
        } catch (java.lang.SecurityException unused) {
            gVar = g.d();
            str4 = k.d;
            gVar.e(str4, str);
        }
        if (providers == null) {
            return i;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = providers.iterator();
        while (it.hasNext()) {
            try {
                Location lastKnownLocation = systemService.getLastKnownLocation((String)it.next());
            } catch (Exception unused) {
                gVar = g.d();
                str4 = k.d;
                gVar.e(str4, str);
            } catch (java.lang.SecurityException unused) {
                gVar = g.d();
                str4 = k.d;
                gVar.e(str4, str);
            }
        }
        time = -1;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList = it2.next();
            long time2 = arrayList.getTime();
        }
        return i;
    }

    public String o() {
        return g().d;
    }

    public String p() {
        return g().e;
    }

    public String q() {
        return g().c;
    }

    public boolean r() {
        return g().l;
    }

    public boolean s() {
        return g().k;
    }

    public boolean t() {
        return this.a;
    }

    public void u() {
        g();
    }

}
