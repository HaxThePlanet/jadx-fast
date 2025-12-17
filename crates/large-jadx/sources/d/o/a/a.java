package d.o.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* loaded from: classes.dex */
@Deprecated
public abstract class a extends BroadcastReceiver {

    private static final SparseArray<PowerManager.WakeLock> a;
    private static int b;
    static {
        SparseArray sparseArray = new SparseArray();
        a.a = sparseArray;
        a.b = 1;
    }

    public static boolean b(Intent intent) {
        int i = 0;
        int obj5 = intent.getIntExtra("androidx.contentpager.content.wakelockid", i);
        if (obj5 == null) {
            return i;
        }
        SparseArray sparseArray = a.a;
        Object obj = sparseArray.get(obj5);
        final int i2 = 1;
        synchronized (sparseArray) {
            (PowerManager.WakeLock)obj.release();
            sparseArray.remove(obj5);
            return i2;
        }
    }

    public static ComponentName c(Context context, Intent intent2) {
        final SparseArray sparseArray = a.a;
        final int i = a.b;
        int i2 = i + 1;
        a.b = i2;
        final int i5 = 1;
        synchronized (sparseArray) {
            a.b = i5;
            intent2.putExtra("androidx.contentpager.content.wakelockid", i);
            final ComponentName obj6 = context.startService(intent2);
            if (obj6 == null) {
                try {
                    return null;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("androidx.core:wake:");
                    stringBuilder.append(obj6.flattenToShortString());
                    PowerManager.WakeLock obj5 = (PowerManager)context.getSystemService("power").newWakeLock(i5, stringBuilder.toString());
                    obj5.setReferenceCounted(false);
                    obj5.acquire(60000);
                    sparseArray.put(i, obj5);
                    return obj6;
                    throw context;
                }
            }
        }
    }
}
