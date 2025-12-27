package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$PottyProgram;", "", "()V", "CalendarTooltipDone", "Lapp/dogo/com/dogo_android/tracking/Event0;", "PottyArticleTapped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ArticleId;", "PottyCertificateTapped", "PottyRemindersSet", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "PottyTrackerTapped", "Lapp/dogo/com/dogo_android/tracking/EP$Action;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h0, reason: from kotlin metadata */
public final class E_PottyProgram {

    public static final u2<o2> a;
    public static final t2 b;
    public static final u2<w0> c;
    public static final t2 d;
    public static final u2<s0> e;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_PottyProgram.a = companion2.a("potty_reminder_set").b(new EP_Type());
        E_PottyProgram.b = companion2.a("calendar_tooltip_done");
        E_PottyProgram.c = companion2.a("potty_article_tapped").b(new EP_ArticleId());
        E_PottyProgram.d = companion2.a("potty_certificate_tapped");
        E_PottyProgram.e = companion2.a("potty_tracker_tapped").b(new EP_Action());
    }
}
