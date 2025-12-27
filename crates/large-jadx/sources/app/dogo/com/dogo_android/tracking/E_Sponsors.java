package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Sponsors;", "", "()V", "BannerClick", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ChallengeId;", "BannerClickInDetails", "BannerClickInFeed", "BannerImpression", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n0, reason: from kotlin metadata */
public final class E_Sponsors {

    public static final u2<c1> a;
    public static final u2<c1> b;
    public static final u2<c1> c;
    public static final u2<c1> d;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Sponsors.a = companion2.a("sponsor_banner_image_clicked").b(new EP_ChallengeId());
        E_Sponsors.b = companion2.a("sponsor_banner_in_feed_clicked").b(new EP_ChallengeId());
        E_Sponsors.c = companion2.a("sponsor_banner_image_impression").b(new EP_ChallengeId());
        E_Sponsors.d = companion2.a("sponsor_banner_in_details_clicked").b(new EP_ChallengeId());
    }
}
