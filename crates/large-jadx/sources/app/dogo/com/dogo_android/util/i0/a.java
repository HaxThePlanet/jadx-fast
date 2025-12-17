package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.f.e;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.p.a.c;
import app.dogo.com.dogo_android.p.b.c;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.s;
import app.dogo.com.dogo_android.view.main_screen.j.h0;
import app.dogo.com.dogo_android.view.main_screen.j.i0;
import app.dogo.com.dogo_android.view.main_screen.j.j0;
import app.dogo.com.dogo_android.y.v.c;

/* loaded from: classes.dex */
public class a {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[c.LOADING_DIALOG_FRAGMENT.ordinal()] = 1;
            a.a.a[c.CHALLENGE_ENTRY_CREATION.ordinal()] = 2;
            a.a.a[c.CHALLENGE_DETAILS_DIALOG.ordinal()] = 3;
            a.a.a[c.CHALLENGE_FILTER_DIALOG_FRAGMENT.ordinal()] = 4;
            a.a.a[c.CHALLENGE_SHARE_DIALOG.ordinal()] = 5;
            a.a.a[c.INSTAGRAM_INVITE_DIALOG.ordinal()] = 6;
            a.a.a[c.TIKTOK_INVITE_DIALOG.ordinal()] = 7;
            a.a.a[c.LESSON_INTRODUCTION_DIALOG.ordinal()] = 8;
        }
    }
    public static u a(c c) {
        switch (obj1) {
            case 1:
                s obj1 = new s();
                return obj1;
            case 2:
                obj1 = new i0();
                return obj1;
            case 3:
                obj1 = new h0();
                return obj1;
            case 4:
                obj1 = new j0();
                return obj1;
            case 5:
                obj1 = new e();
                return obj1;
            case 6:
                obj1 = new c();
                return obj1;
            case 7:
                obj1 = new c();
                return obj1;
            case 8:
                obj1 = new c();
                return obj1;
            default:
                Log.e("Dialog Factory", "Dialog tag not found, returning null");
                return null;
        }
    }
}
