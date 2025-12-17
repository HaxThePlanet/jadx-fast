package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$RateDialog;", "", "()V", "DialogOpen", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "InAppRatingFinished", "NegativeButtonClick", "PositiveButtonClick", "RateUsClicked", "Lapp/dogo/com/dogo_android/tracking/Event0;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j0 {

    public static final app.dogo.com.dogo_android.w.t2 a;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.r2> b;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.r2> c;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.r2> d;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.r2> e;
    static {
        app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        j0.a = companion.a("rate_us_tapped");
        r2 r2Var2 = new r2();
        j0.b = companion.a("rate_app_yes_tapped").b(r2Var2);
        r2 r2Var3 = new r2();
        j0.c = companion.a("rate_app_no_tapped").b(r2Var3);
        r2 r2Var4 = new r2();
        j0.d = companion.a("view_rate_app").b(r2Var4);
        r2 r2Var = new r2();
        j0.e = companion.a("rate_in_app_finished").b(r2Var);
    }
}
