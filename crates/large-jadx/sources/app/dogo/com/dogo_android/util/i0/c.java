package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.a.l;
import app.dogo.com.dogo_android.d.b.v;
import app.dogo.com.dogo_android.d.d.o;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.y.q.d;

/* compiled from: FullScreenFactory.java */
/* loaded from: classes.dex */
public class c {

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[FullScreenTag.values().length];
            c.a.a = iArr;
            try {
                iArr[FullScreenTag.CHALLENGE_COMMENTS_DIALOG.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.a.a[FullScreenTag.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.a.a[FullScreenTag.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.a.a[FullScreenTag.VIDEO_EXAM_PLAYBACK.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public static x a(j jVar) {
        int i5 = c.a.a[jVar.ordinal()];
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3 && i5 != 4) {
                Log.e("FullScreenDialogFactory", "Dialog tag not found, returning null");
                return null;
            }
            return new ChallengeProfileDialog();
        }
        return new ChallengeCommentsDialog();
    }
}
