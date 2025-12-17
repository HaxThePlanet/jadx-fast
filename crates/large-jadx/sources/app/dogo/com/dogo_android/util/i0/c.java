package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.a.l;
import app.dogo.com.dogo_android.d.b.v;
import app.dogo.com.dogo_android.d.d.o;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.y.q.d;

/* loaded from: classes.dex */
public class c {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.a.a = iArr;
            iArr[j.CHALLENGE_COMMENTS_DIALOG.ordinal()] = 1;
            c.a.a[j.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT.ordinal()] = 2;
            c.a.a[j.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT.ordinal()] = 3;
            c.a.a[j.VIDEO_EXAM_PLAYBACK.ordinal()] = 4;
        }
    }
    public static x a(j j) {
        int obj1 = c.a.a[j.ordinal()];
        if (obj1 != 1 && obj1 != 2 && obj1 != 3 && obj1 != 4) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    if (obj1 != 4) {
                        Log.e("FullScreenDialogFactory", "Dialog tag not found, returning null");
                        return null;
                    }
                    obj1 = new d();
                    return obj1;
                }
                obj1 = new o();
                return obj1;
            }
            obj1 = new l();
            return obj1;
        }
        obj1 = new v();
        return obj1;
    }
}
