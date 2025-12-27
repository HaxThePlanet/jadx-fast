package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$RateDialog;", "", "()V", "DialogOpen", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "InAppRatingFinished", "NegativeButtonClick", "PositiveButtonClick", "RateUsClicked", "Lapp/dogo/com/dogo_android/tracking/Event0;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j0, reason: from kotlin metadata */
public final class E_RateDialog {

    public static final t2 a;
    public static final u2<r2> b;
    public static final u2<r2> c;
    public static final u2<r2> d;
    public static final u2<r2> e;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_RateDialog.a = companion2.a("rate_us_tapped");
        E_RateDialog.b = companion2.a("rate_app_yes_tapped").b(new EP_ViewSource());
        E_RateDialog.c = companion2.a("rate_app_no_tapped").b(new EP_ViewSource());
        E_RateDialog.d = companion2.a("view_rate_app").b(new EP_ViewSource());
        E_RateDialog.e = companion2.a("rate_in_app_finished").b(new EP_ViewSource());
    }
}
