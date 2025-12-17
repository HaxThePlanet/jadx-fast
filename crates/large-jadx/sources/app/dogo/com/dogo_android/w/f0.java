package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Onboarding;", "", "()V", "Complete", "Lapp/dogo/com/dogo_android/tracking/Event0;", "Skip", "WelcomeNextTap", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "WelcomeSignIn", "WelcomeStart", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f0 {

    public static final app.dogo.com.dogo_android.w.t2 a;
    public static final app.dogo.com.dogo_android.w.t2 b;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.r2> c;
    static {
        final app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        companion.a("onboarding_completed");
        f0.a = companion.a("onboarding_welcome_sign_in");
        f0.b = companion.a("onboarding_welcome_start");
        r2 r2Var = new r2();
        f0.c = companion.a("welcome_slides_next_tapped").b(r2Var);
        companion.a("onboarding_skip");
    }
}
