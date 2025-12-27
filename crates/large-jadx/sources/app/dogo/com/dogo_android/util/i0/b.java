package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.c.g;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.view.main_screen.j.k0;

/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class b {

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[FragmentTags.values().length];
            b.a.a = iArr;
            try {
                iArr[FragmentTags.CHALLENGE_HOME_FRAGMENT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[FragmentTags.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public static w a(i iVar) {
        return b.b(iVar, i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT);
    }

    public static w b(i iVar, i iVar2) {
        if (iVar == null) {
            throw new RuntimeException("Fragment factory,used nul tag or default fragment not found, look at past reports");
        } else {
            int i = b.a.a[iVar.ordinal()];
            if (b.a.a != 1 && b.a.a != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Fragment tag : [ ";
                String str3 = "] not recognised, switching to next choice :";
                str4 = str2 + iVar + str3 + iVar2;
                Log.e("Fragment factory", str4);
                return b.b(iVar2, i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT);
            }
            return new ChallengeHomeFragmentLegacy();
        }
    }
}
