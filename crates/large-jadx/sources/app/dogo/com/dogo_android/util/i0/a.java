package app.dogo.com.dogo_android.util.i0;

import android.util.Log;
import app.dogo.com.dogo_android.d.f.e;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.s;
import app.dogo.com.dogo_android.view.main_screen.j.h0;
import app.dogo.com.dogo_android.view.main_screen.j.i0;
import app.dogo.com.dogo_android.view.main_screen.j.j0;

/* compiled from: DialogFactory.java */
/* loaded from: classes.dex */
public class a {

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DialogTags.values().length];
            a.a.a = iArr;
            try {
                iArr[DialogTags.LOADING_DIALOG_FRAGMENT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.CHALLENGE_ENTRY_CREATION.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.CHALLENGE_DETAILS_DIALOG.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.CHALLENGE_FILTER_DIALOG_FRAGMENT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.CHALLENGE_SHARE_DIALOG.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.INSTAGRAM_INVITE_DIALOG.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.TIKTOK_INVITE_DIALOG.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[DialogTags.LESSON_INTRODUCTION_DIALOG.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public static u a(app.dogo.com.dogo_android.k.c cVar) {
        switch (a.a.a[cVar.ordinal()]) {
            case 1: /* ordinal */
                return new LoadingSpinnerDialog();
            case 2: /* ordinal */
                return new ChallengeEntryCreationDialog();
            case 3: /* ordinal */
                return new ChallengeDetailsDialog();
            case 4: /* ordinal */
                return new app.dogo.com.dogo_android.view.main_screen.challenge.j0();
            case 5: /* ordinal */
                return new ChallengeShareDialog();
            case 6: /* ordinal */
                return new InstagramInviteDialog();
            case 7: /* ordinal */
                return new TiktokInviteDialog();
            case 8: /* ordinal */
                return new LessonIntroductionDialog();
            default:
                Log.e("Dialog Factory", "Dialog tag not found, returning null");
                return null;
        }
    }
}
