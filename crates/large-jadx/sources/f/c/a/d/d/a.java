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

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public class a {

    private static final f a;
    private static final Object b = new Object();
    private static Method c;
    private static Method d;

    public interface a {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }
    static {
        a.a = f.f();
        Method method = null;
        a.c = method;
        a.d = method;
    }

    public static void a(Context context) {
        Throwable string;
        Throwable length;
        Context context2;
        String str;
        String str2;
        r.k(context, "Context must not be null");
        a.a.k(context, 11925000);
        Object obj2 = a.b;
        synchronized (obj2) {
            try {
            } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loading) {
            } catch (Throwable unused) {
            }
            try {
                final String str10 = "com.google.android.gms.providerinstaller.dynamite";
                context2 = DynamiteModule.e(context, DynamiteModule.c, str10).b();
            } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loading) {
            } catch (Throwable unused) {
            }
            if (DynamiteModule.c == null) {
                final Context context3 = h.d(context);
                if (context3 != null) {
                    try {
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i7 = 3;
                        if (a.d == null) {
                            Class[] arr2 = new Class[i7];
                            Class tYPE2 = Long.TYPE;
                            str = "com.google.android.gms.common.security.ProviderInstallerImpl";
                            str2 = "reportRequestStats";
                            a.d = a.e(context3, str, str2, new Class[] { Context.class, tYPE2, tYPE2 });
                        }
                        Object[] arr = new Object[i7];
                        a.d.invoke(null, new Object[] { context, Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(SystemClock.elapsedRealtime()) });
                    } catch (Exception e) {
                    } catch (Throwable unused) {
                    }
                }
                if (context3 == null) {
                    Log.e("ProviderInstaller", "Failed to get remote context");
                    throw new GooglePlayServicesNotAvailableException(8);
                } else {
                    a.d(context3, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                }
            }
            a.d(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
            return;
        }
    }

    public static void b(Context context, a.a aVar) {
        r.k(context, "Context must not be null");
        r.k(aVar, "Listener must not be null");
        r.e("Must be called on the UI thread");
        new b(context, aVar).execute(new Void[0]);
    }

    private static void d(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException, java.io.UnsupportedEncodingException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            final int i = 0;
            final int i2 = 1;
            if (a.c == null) {
                Class[] arr = new Class[i2];
                str = "insertProvider";
                a.c = a.e(context, str, str, new Class[] { Context.class });
            }
        } catch (Exception e) {
            context2 = e.getCause();
            str = 6;
            String str2 = "ProviderInstaller";
            str = Log.isLoggable(str2, str);
        }
    }

    private static Method e(Context context, String str, String str2, Class[] clsArr) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    static /* synthetic */ f c() {
        return a.a;
    }
}
