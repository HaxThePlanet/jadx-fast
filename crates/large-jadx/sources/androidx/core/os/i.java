package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
@Deprecated
public final class i {
    static {
        Class<String> obj;
        int sDK_INT;
        int str;
        int i3;
        Class[] arr2;
        Class tYPE2;
        int i2;
        Class[] arr;
        Class tYPE;
        int i;
        obj = String.class;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 18 && sDK_INT < 29) {
            if (sDK_INT < 29) {
                Trace.class.getField("TRACE_TAG_APP").getLong(0);
                i3 = 1;
                Class[] arr3 = new Class[i3];
                tYPE2 = Long.TYPE;
                i2 = 0;
                arr3[i2] = tYPE2;
                Trace.class.getMethod("isTagEnabled", arr3);
                int i5 = 3;
                Class[] arr4 = new Class[i5];
                arr4[i2] = tYPE2;
                arr4[i3] = obj;
                tYPE = Integer.TYPE;
                i = 2;
                arr4[i] = tYPE;
                Trace.class.getMethod("asyncTraceBegin", arr4);
                arr = new Class[i5];
                arr[i2] = tYPE2;
                arr[i3] = obj;
                arr[i] = tYPE;
                Trace.class.getMethod("asyncTraceEnd", arr);
                arr2 = new Class[i5];
                arr2[i2] = tYPE2;
                arr2[i3] = obj;
                arr2[i] = tYPE;
                Trace.class.getMethod("traceCounter", arr2);
            }
        }
    }

    public static void a(String string) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(string);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
