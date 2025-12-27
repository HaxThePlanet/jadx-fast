package d.o.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* compiled from: WakefulBroadcastReceiver.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class a extends BroadcastReceiver {

    private static final SparseArray<PowerManager.WakeLock> a = new SparseArray<>();
    private static int b;
    static {
        a.b = 1;
    }

    public static boolean b(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", i);
        if (intExtra == 0) {
            return false;
        }
        SparseArray sparseArray = a.a;
        synchronized (sparseArray) {
            try {
                Object obj2 = sparseArray.get(intExtra);
                final boolean z = true;
                if (obj2 != null) {
                    obj2.release();
                    sparseArray.remove(intExtra);
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        final SparseArray sparseArray = a.a;
        synchronized (sparseArray) {
            try {
                final int i = a.b;
                a.b++;
                final int i5 = 1;
                if (i2 <= 0) {
                    a.b = i5;
                }
                intent.putExtra("androidx.contentpager.content.wakelockid", a.b);
                final ComponentName service = context.startService(intent);
                if (service == null) {
                    return null;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }
}
