package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class SubscriptionManagerCompat {

    private static Method sGetSlotIndexMethod;

    private static class Api29Impl {
        static int getSlotIndex(int subId) {
            return SubscriptionManager.getSlotIndex(subId);
        }
    }
    public static int getSlotIndex(int subId) {
        int i = -1;
        if (subId == i) {
            return i;
        }
        return SubscriptionManagerCompat.Api29Impl.getSlotIndex(subId);
    }
}
