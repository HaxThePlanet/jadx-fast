package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.c;
import java.util.Calendar;

/* loaded from: classes.dex */
class n {

    private static androidx.appcompat.app.n d;
    private final Context a;
    private final LocationManager b;
    private final androidx.appcompat.app.n.a c;

    private static class a {

        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;
    }
    n(Context context, LocationManager locationManager2) {
        super();
        n.a aVar = new n.a();
        this.c = aVar;
        this.a = context;
        this.b = locationManager2;
    }

    static androidx.appcompat.app.n a(Context context) {
        androidx.appcompat.app.n nVar;
        Object systemService;
        Context obj2;
        if (n.d == null) {
            obj2 = context.getApplicationContext();
            nVar = new n(obj2, (LocationManager)obj2.getSystemService("location"));
            n.d = nVar;
        }
        return n.d;
    }

    private Location b() {
        int i;
        int i2;
        if (c.b(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            i = c("network");
        } else {
            i = i2;
        }
        if (c.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            i2 = c("gps");
        }
        if (i2 != 0 && i != 0 && Long.compare(time, time2) > 0) {
            if (i != 0) {
                if (Long.compare(time, time2) > 0) {
                    i = i2;
                }
                return i;
            }
        }
        if (i2 != 0) {
            i = i2;
        }
        return i;
    }

    private Location c(String string) {
        boolean providerEnabled;
        String str;
        String obj3;
        try {
            if (this.b.isProviderEnabled(string)) {
            }
            return this.b.getLastKnownLocation(string);
            Log.d("TwilightManager", "Failed to get last known location", string);
            return null;
        }
    }

    private boolean e() {
        int i;
        i = Long.compare(l, currentTimeMillis) > 0 ? 1 : 0;
        return i;
    }

    private void f(Location location) {
        int i3;
        int i;
        int i2;
        int cmp;
        int cmp2;
        final androidx.appcompat.app.n.a aVar = obj.c;
        final long currentTimeMillis = System.currentTimeMillis();
        final androidx.appcompat.app.m mVar3 = m.b();
        int i11 = 86400000;
        androidx.appcompat.app.m mVar = mVar3;
        mVar.a(currentTimeMillis - i11, obj4, location.getLatitude());
        mVar.a(currentTimeMillis, obj4, location.getLatitude());
        if (mVar3.c == 1) {
        } else {
            i3 = 0;
        }
        long l8 = l3;
        long l6 = l4;
        mVar3.a(i11 += currentTimeMillis, obj4, location.getLatitude());
        long l = mVar3.b;
        int i8 = 0;
        cmp = -1;
        if (Long.compare(l6, cmp) != 0) {
            if (Long.compare(l8, cmp) == 0) {
                i9 += currentTimeMillis;
            } else {
                i2 = Long.compare(currentTimeMillis, l8) > 0 ? i8 + l : cmp2 > 0 ? i8 + l8 : i8 + l6;
                i2 += cmp;
            }
        } else {
        }
        aVar.a = i3;
        aVar.b = mVar3.a;
        aVar.c = l6;
        aVar.d = l8;
        aVar.e = l;
        aVar.f = i;
    }

    boolean d() {
        int i2;
        int i;
        androidx.appcompat.app.n.a aVar = this.c;
        if (e()) {
            return aVar.a;
        }
        Location location = b();
        if (location != null) {
            f(location);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        if (i3 >= 6) {
            if (i3 >= 22) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }
}
