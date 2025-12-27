package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.o;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R.\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Subscription;", "", "()V", "AllPlansShowed", "Lapp/dogo/com/dogo_android/tracking/Event0;", "ChoosePlanTapped", "Completed", "Lapp/dogo/com/dogo_android/tracking/Event5;", "Lapp/dogo/com/dogo_android/tracking/EP$AffiliateSource;", "Lapp/dogo/com/dogo_android/tracking/EP$ViewSource;", "Lapp/dogo/com/dogo_android/tracking/EP$SkuId;", "Lapp/dogo/com/dogo_android/tracking/EP$FireAnalyticsValue;", "Lapp/dogo/com/dogo_android/tracking/EP$FireAnalyticsCurrency;", "CouponActivated", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$Code;", "Failed", "Lapp/dogo/com/dogo_android/tracking/Event4;", "Lapp/dogo/com/dogo_android/tracking/EP$ErrorCode;", "Lapp/dogo/com/dogo_android/tracking/EP$ErrorMessage;", "RevenueCatCacheCleared", "Started", "Lapp/dogo/com/dogo_android/tracking/EP$Price;", "Lapp/dogo/com/dogo_android/tracking/EP$CurrencyCode;", "SubscriptionViewClosed4Times", "TestimonialsShowed", "TestimonialsSwitched", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o0, reason: from kotlin metadata */
public final class E_Subscription {

    public static final y2<t0, r2, g2, d2, e1> a;
    public static final y2<t0, r2, g2, p1, o1> b;
    public static final x2<t0, r2, j1, k1> c;
    public static final t2 d;
    public static final u2<d1> e;
    public static final t2 f;
    public static final t2 g;
    public static final t2 h;
    public static final t2 i;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Subscription.a = companion2.a("purchase_started").f(new EP_AffiliateSource(), new EP_ViewSource(), new EP_SkuId(), new EP_Price(), new EP_CurrencyCode()).withFacebookEvent(app.dogo.com.dogo_android.tracking.h.a);
        E_Subscription.b = companion2.a("purchase_completed_v2").f(new EP_AffiliateSource(), new EP_ViewSource(), new EP_SkuId(), new EP_FireAnalyticsValue(), new EP_FireAnalyticsCurrency());
        E_Subscription.c = companion2.a("purchase_failed").e(new EP_AffiliateSource(), new EP_ViewSource(), new EP_ErrorCode(), new EP_ErrorMessage());
        companion2.a("choose_plan_tapped");
        E_Subscription.d = companion2.a("revenue_cat_cache_cleared");
        E_Subscription.e = companion2.a("coupon_activated").b(new EP_Code());
        E_Subscription.f = companion2.a("subscription_all_plans_showed");
        E_Subscription.g = companion2.a("subscription_testimonials_showed");
        E_Subscription.h = companion2.a("subscription_testimonials_switched");
        E_Subscription.i = companion2.a("subscription_view_closed_4_times");
    }

    private static final a3 a(o oVar, o oVar2, o oVar3, o oVar4, o oVar5) {
        Object obj = null;
        String oVar22;
        int i = 0;
        oVar = oVar4.d() instanceof Double ? (Double)oVar4.d() : 0;
        if (obj == null) {
            i = 0;
        } else {
            double value = obj.doubleValue();
        }
        Object obj2 = oVar2.d();
        oVar22 = "";
        oVar = obj2 == null ? "" : oVar22;
        Object obj3 = oVar5.d();
        if (obj3 != null) {
            oVar22 = obj3.toString();
            if (oVar22 != null) {
            }
        }
        return FBEvent.INSTANCE.initiatedCheckout(i, oVar22, oVar22);
    }

    public static /* synthetic */ a3 b(o oVar, o oVar2, o oVar3, o oVar4, o oVar5) {
        return E_Subscription.a(oVar, oVar2, oVar3, oVar4, oVar5);
    }
}
