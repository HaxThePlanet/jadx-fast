package androidx.core.telephony;

import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class TelephonyManagerCompat {

    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private static class Api23Impl {
        static String getDeviceId(TelephonyManager telephonyManager, int slotIndex) {
            return telephonyManager.getDeviceId(slotIndex);
        }
    }

    private static class Api26Impl {
        static String getImei(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    private static class Api30Impl {
        static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }
    public static String getImei(TelephonyManager telephonyManager) {
        return TelephonyManagerCompat.Api26Impl.getImei(telephonyManager);
    }

    public static int getSubscriptionId(TelephonyManager telephonyManager) {
        Method sGetSubIdMethod;
        Object invoke;
        Object[] intValue;
        int i;
        Class[] arr;
        if (Build.VERSION.SDK_INT >= 30) {
            return TelephonyManagerCompat.Api30Impl.getSubscriptionId(telephonyManager);
        }
        int i4 = 0;
        if (TelephonyManagerCompat.sGetSubIdMethod == null) {
            TelephonyManagerCompat.sGetSubIdMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[i4]);
            TelephonyManagerCompat.sGetSubIdMethod.setAccessible(true);
        }
        invoke = TelephonyManagerCompat.sGetSubIdMethod.invoke(telephonyManager, new Object[i4]);
        if (invoke != null && (Integer)invoke.intValue() != -1) {
            if (invoke.intValue() != -1) {
                return invoke.intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
