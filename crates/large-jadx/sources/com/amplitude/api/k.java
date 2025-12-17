package com.amplitude.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class k {

    private static final String d = "com.amplitude.api.k";
    private boolean a = true;
    private Context b;
    private com.amplitude.api.k.b c;

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
        final com.amplitude.api.k n;
        private b(com.amplitude.api.k k) {
            this.n = k;
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

        b(com.amplitude.api.k k, com.amplitude.api.k.a k$a2) {
            super(k);
        }

        private String A() {
            return Build.MODEL;
        }

        private String B() {
            return "android";
        }

        private String C() {
            return Build.VERSION.RELEASE;
        }

        private String D() {
            try {
                return packageInfo.versionName;
                return null;
            }
        }

        static String a(com.amplitude.api.k.b k$b) {
            return b.b;
        }

        static String b(com.amplitude.api.k.b k$b) {
            return b.j;
        }

        static String c(com.amplitude.api.k.b k$b) {
            return b.a;
        }

        static boolean d(com.amplitude.api.k.b k$b) {
            return b.k;
        }

        static String e(com.amplitude.api.k.b k$b) {
            return b.m;
        }

        static boolean f(com.amplitude.api.k.b k$b) {
            return b.l;
        }

        static String g(com.amplitude.api.k.b k$b) {
            return b.c;
        }

        static String h(com.amplitude.api.k.b k$b) {
            return b.d;
        }

        static String i(com.amplitude.api.k.b k$b) {
            return b.e;
        }

        static String j(com.amplitude.api.k.b k$b) {
            return b.f;
        }

        static String k(com.amplitude.api.k.b k$b) {
            return b.g;
        }

        static String l(com.amplitude.api.k.b k$b) {
            return b.h;
        }

        static String m(com.amplitude.api.k.b k$b) {
            return b.i;
        }

        private boolean n() {
            String intValue;
            com.amplitude.api.g gVar;
            int i;
            String str;
            StringBuilder stringBuilder;
            String str2;
            intValue = "Google Play Services Util not found!";
            final String str3 = "Google Play Services not available";
            i = 0;
            final int i3 = 1;
            Class[] arr = new Class[i3];
            arr[i] = Context.class;
            Object[] arr2 = new Object[i3];
            arr2[i] = k.a(this.n);
            Object invoke = Class.forName("com.google.android.gms.common.g").getMethod("isGooglePlayServicesAvailable", arr).invoke(0, arr2);
            if (invoke != null && (Integer)invoke.intValue() == 0) {
                if (invoke.intValue() == 0) {
                    i = i3;
                }
            }
            return i;
        }

        private String o() {
            if ("Amazon".equals(z())) {
                return p();
            }
            return q();
        }

        private String p() {
            int i;
            android.content.ContentResolver contentResolver = k.a(this.n).getContentResolver();
            final int i2 = 1;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == i2) {
                i = i2;
            }
            this.k = i;
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            this.a = string;
            return string;
        }

        private String q() {
            Object invoke;
            Object booleanValue;
            Method method;
            int i;
            Object[] arr2;
            Class[] arr;
            try {
                i = 1;
                Class[] arr3 = new Class[i];
                final int i3 = 0;
                arr3[i3] = Context.class;
                Object[] arr4 = new Object[i];
                arr4[i3] = k.a(this.n);
                Object invoke2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", arr3).invoke(0, arr4);
                booleanValue = invoke2.getClass().getMethod("isLimitAdTrackingEnabled", new Class[i3]).invoke(invoke2, new Object[i3]);
                if (booleanValue != null && (Boolean)booleanValue.booleanValue()) {
                } else {
                }
                if (booleanValue.booleanValue()) {
                } else {
                }
                i = i3;
                this.k = i;
                this.a = (String)invoke2.getClass().getMethod("getId", new Class[i3]).invoke(invoke2, new Object[i3]);
                com.amplitude.api.g gVar = g.d();
                String str4 = k.b();
                gVar.c(str4, "Encountered an error connecting to Google Play Services for advertising id", th);
                Throwable th = g.d();
                gVar = k.b();
                str4 = "Google Play Services not available for advertising id";
                th.e(gVar, str4);
                th = g.d();
                gVar = k.b();
                str4 = "Google Play Services SDK not found for advertising id!";
                th.e(gVar, str4);
                return this.a;
            }
        }

        private String r() {
            Object invoke;
            Method method;
            Object[] arr2;
            Class[] arr;
            try {
                int i = 1;
                Class[] arr5 = new Class[i];
                final int i3 = 0;
                arr5[i3] = Context.class;
                Object[] arr3 = new Object[i];
                arr3[i3] = k.a(this.n);
                int i2 = 0;
                Object invoke2 = Class.forName("com.google.android.gms.appset.AppSet").getMethod("getClient", arr5).invoke(i2, arr3);
                Class[] arr8 = new Class[i];
                arr8[i3] = Class.forName("com.google.android.gms.tasks.j");
                Object[] arr4 = new Object[i];
                arr4[i3] = invoke2.getClass().getMethod("getAppSetInfo", new Class[i3]).invoke(invoke2, new Object[i3]);
                Object invoke4 = Class.forName("com.google.android.gms.tasks.m").getMethod("await", arr8).invoke(i2, arr4);
                this.m = (String)invoke4.getClass().getMethod("getId", new Class[i3]).invoke(invoke4, new Object[i3]);
                com.amplitude.api.g gVar = g.d();
                String str5 = k.b();
                gVar.c(str5, "Encountered an error connecting to Google Play Services for app set id", th);
                Throwable th = g.d();
                gVar = k.b();
                str5 = "Google Play Services not available for app set id";
                th.e(gVar, str5);
                th = g.d();
                gVar = k.b();
                str5 = "Google Play Services SDK not found for app set id!";
                th.e(gVar, str5);
                return this.m;
            }
        }

        private String s() {
            return Build.BRAND;
        }

        private String t() {
            try {
                return (TelephonyManager)k.a(this.n).getSystemService("phone").getNetworkOperatorName();
                return null;
            }
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
            Object fromLocation;
            com.amplitude.api.k present;
            Geocoder geocoder;
            double latitude;
            double longitude;
            int i;
            final int i2 = 0;
            if (!this.n.t()) {
                return i2;
            }
            fromLocation = this.n.n();
            fromLocation = this.n.j().getFromLocation(fromLocation.getLatitude(), obj5, fromLocation.getLongitude());
            if (fromLocation != null && Geocoder.isPresent() && fromLocation != null) {
                if (Geocoder.isPresent()) {
                    fromLocation = this.n.j().getFromLocation(fromLocation.getLatitude(), obj5, fromLocation.getLongitude());
                    if (fromLocation != null) {
                        fromLocation = fromLocation.iterator();
                        for (Address present : fromLocation) {
                        }
                    }
                }
            }
            return i2;
        }

        private String x() {
            Object networkCountryIso;
            try {
                networkCountryIso = k.a(this.n).getSystemService("phone");
                networkCountryIso = networkCountryIso.getNetworkCountryIso();
                if ((TelephonyManager)networkCountryIso.getPhoneType() != 2 && networkCountryIso != null) {
                }
                networkCountryIso = networkCountryIso.getNetworkCountryIso();
                if (networkCountryIso != null) {
                }
                return networkCountryIso.toUpperCase(Locale.US);
                return null;
            }
        }

        private String y() {
            return Locale.getDefault().getLanguage();
        }

        private String z() {
            return Build.MANUFACTURER;
        }
    }
    static {
    }

    public k(Context context, boolean z2) {
        super();
        final int i = 1;
        this.b = context;
        this.a = z2;
    }

    static Context a(com.amplitude.api.k k) {
        return k.b;
    }

    static String b() {
        return k.d;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    private com.amplitude.api.k.b g() {
        com.amplitude.api.k.b bVar;
        int i;
        if (this.c == null) {
            bVar = new k.b(this, 0);
            this.c = bVar;
        }
        return this.c;
    }

    public String d() {
        return k.b.c(g());
    }

    public String e() {
        return k.b.e(g());
    }

    public String f() {
        return k.b.j(g());
    }

    public String h() {
        return k.b.m(g());
    }

    public String i() {
        return k.b.a(g());
    }

    protected Geocoder j() {
        Geocoder geocoder = new Geocoder(this.b, Locale.ENGLISH);
        return geocoder;
    }

    public String k() {
        return k.b.b(g());
    }

    public String l() {
        return k.b.k(g());
    }

    public String m() {
        return k.b.l(g());
    }

    public Location n() {
        int time;
        int i;
        List providers;
        ArrayList arrayList;
        com.amplitude.api.g lastKnownLocation;
        boolean next;
        String str;
        String str2 = "Failed to get most recent location";
        i = 0;
        if (!t()) {
            return i;
        }
        if (!n.a(this.b)) {
            return i;
        }
        Object systemService = this.b.getSystemService("location");
        if ((LocationManager)systemService == null) {
            return i;
        }
        providers = (LocationManager)systemService.getProviders(true);
        if (providers == null) {
            return i;
        }
        arrayList = new ArrayList();
        Iterator iterator = providers.iterator();
        for (String next3 : iterator) {
            lastKnownLocation = systemService.getLastKnownLocation(next3);
            if (lastKnownLocation != null) {
            }
            arrayList.add(lastKnownLocation);
            lastKnownLocation = g.d();
            str = k.d;
            lastKnownLocation.e(str, obj0);
            lastKnownLocation = g.d();
            str = k.d;
            lastKnownLocation.e(str, obj0);
            lastKnownLocation = obj2;
        }
        time = -1;
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            arrayList = iterator2.next();
            if (Long.compare(time2, time) > 0) {
            }
            time = arrayList.getTime();
            i = arrayList;
        }
        return i;
    }

    public String o() {
        return k.b.h(g());
    }

    public String p() {
        return k.b.i(g());
    }

    public String q() {
        return k.b.g(g());
    }

    public boolean r() {
        return k.b.f(g());
    }

    public boolean s() {
        return k.b.d(g());
    }

    public boolean t() {
        return this.a;
    }

    public void u() {
        g();
    }
}
