package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.c.g;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.view.main_screen.j.k0;

/* loaded from: classes.dex */
public class b {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[i.CHALLENGE_HOME_FRAGMENT.ordinal()] = 1;
            b.a.a[i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT.ordinal()] = 2;
        }
    }
    public static w a(i i) {
        return b.b(i, 0);
    }

    public static w b(i i, i i2) {
        if (i == null) {
        } else {
            int i3 = b.a.a[i.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 != 2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Fragment tag : [ ");
                    stringBuilder.append(i);
                    stringBuilder.append("] not recognised, switching to next choice :");
                    stringBuilder.append(i2);
                    Log.e("Fragment factory", stringBuilder.toString());
                    return b.b(i2, 0);
                }
                g obj2 = new g();
                return obj2;
            }
            obj2 = new k0();
            return obj2;
        }
        obj2 = new RuntimeException("Fragment factory,used nul tag or default fragment not found, look at past reports");
        throw obj2;
    }
}
