package f.c.a.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.f;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class a {

    private static final f a;
    private static final Object b;
    private static Method c;
    private static Method d;

    public interface a {
        public abstract void onProviderInstallFailed(int i, Intent intent2);

        public abstract void onProviderInstalled();
    }
    static {
        a.a = f.f();
        Object object = new Object();
        a.b = object;
        int i = 0;
        a.c = i;
        a.d = i;
    }

    public static void a(Context context) {
        Throwable string;
        long elapsedRealtime;
        Throwable length;
        Context context2;
        Method method;
        int length2;
        int i;
        int i3;
        int i2;
        Object[] arr;
        String str;
        String str2;
        r.k(context, "Context must not be null");
        a.a.k(context, 11925000);
        Object obj = a.b;
        final String str10 = "com.google.android.gms.providerinstaller.dynamite";
        context2 = DynamiteModule.e(context, DynamiteModule.c, str10).b();
        synchronized (obj) {
            final Context context3 = h.d(context);
            i = 2;
            i3 = 1;
            i2 = 0;
            int i7 = 3;
            if (context2 == null && context3 != null && a.d == null) {
                context3 = h.d(context);
                if (context3 != null) {
                    i = 2;
                    i3 = 1;
                    i2 = 0;
                    i7 = 3;
                    if (a.d == null) {
                        Class[] arr2 = new Class[i7];
                        arr2[i2] = Context.class;
                        Class tYPE = Long.TYPE;
                        arr2[i3] = tYPE;
                        arr2[i] = tYPE;
                        a.d = a.e(context3, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", arr2);
                    }
                    arr = new Object[i7];
                    arr[i2] = context;
                    arr[i3] = Long.valueOf(SystemClock.elapsedRealtime());
                    arr[i] = Long.valueOf(SystemClock.elapsedRealtime());
                    a.d.invoke(0, arr);
                }
                if (context3 == null) {
                } else {
                    a.d(context3, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                }
                try {
                    Log.e("ProviderInstaller", "Failed to get remote context");
                    GooglePlayServicesNotAvailableException obj14 = new GooglePlayServicesNotAvailableException(8);
                    throw obj14;
                    a.d(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                    throw context;
                } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loading) {
                } catch (Throwable th1) {
                }
            }
        }
    }

    public static void b(Context context, f.c.a.d.d.a.a a$a2) {
        r.k(context, "Context must not be null");
        r.k(a2, "Listener must not be null");
        r.e("Must be called on the UI thread");
        b bVar = new b(context, a2);
        bVar.execute(new Void[0]);
    }

    static f c() {
        return a.a;
    }

    private static void d(Context context, Context context2, String string3) {
        String str;
        Method obj4;
        try {
            final int i = 0;
            final int i2 = 1;
            if (a.c == null) {
            }
            obj4 = new Class[i2];
            obj4[i] = Context.class;
            a.c = a.e(context, string3, "insertProvider", obj4);
            final Object[] obj5 = new Object[i2];
            obj5[i] = context;
            a.c.invoke(0, obj5);
            context2 = context.getCause();
            string3 = 6;
            String str2 = "ProviderInstaller";
            string3 = Log.isLoggable(str2, string3);
            if (string3 == null) {
            } else {
            }
            if (context2 == null) {
            } else {
            }
            context = context.getMessage();
            context = context2.getMessage();
            context = String.valueOf(context);
            context2 = "Failed to install provider: ";
            string3 = context.length();
            if (string3 != null) {
            } else {
            }
            context = context2.concat(context);
            context = new String(context2);
            Log.e(str2, context);
            context2 = 8;
            context = new GooglePlayServicesNotAvailableException(context2);
            throw context;
        }
    }

    private static Method e(Context context, String string2, String string3, Class[] class4Arr4) {
        return context.getClassLoader().loadClass(string2).getMethod(string3, class4Arr4);
    }
}
