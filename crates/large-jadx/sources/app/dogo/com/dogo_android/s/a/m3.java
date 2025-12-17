package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import i.b.a0;
import i.b.b;
import i.b.g0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "timeUtil", "Lapp/dogo/com/dogo_android/service/Utilities;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "checkAndTryToActivateSpecialOffer", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m3 {

    private final BillingRepository a;
    private final v2 b;
    private final app.dogo.com.dogo_android.s.a.b2 c;
    private final r2 d;
    private final app.dogo.com.dogo_android.s.a.n3 e;
    public m3(BillingRepository billingRepository, v2 v22, app.dogo.com.dogo_android.s.a.b2 b23, r2 r24, app.dogo.com.dogo_android.s.a.n3 n35) {
        n.f(billingRepository, "billingRepository");
        n.f(v22, "timeUtil");
        n.f(b23, "couponNotificationInteractor");
        n.f(r24, "remoteConfigService");
        n.f(n35, "subscribeInteractor");
        super();
        this.a = billingRepository;
        this.b = v22;
        this.c = b23;
        this.d = r24;
        this.e = n35;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.m3 m3, CouponDiscount couponDiscount2) {
        n.f(m3, "this$0");
        n.f(couponDiscount2, "currentCoupon");
        n0 n0Var = new n0(couponDiscount2, m3);
        return m3.e.q().flatMap(n0Var);
    }

    private static final g0 c(CouponDiscount couponDiscount, app.dogo.com.dogo_android.s.a.m3 m32, Boolean boolean3) {
        String next;
        int q0Var;
        String cmp;
        int cmp2;
        long l2;
        long l;
        a0 obj6;
        boolean obj8;
        n.f(couponDiscount, "$currentCoupon");
        n.f(m32, "this$0");
        n.f(boolean3, "isPremium");
        if (!boolean3.booleanValue()) {
            if (!couponDiscount.getWelcomeOffer()) {
                if (couponDiscount.isEmpty()) {
                    obj8 = m32.d.r().iterator();
                    while (obj8.hasNext()) {
                        cmp = next;
                        if (Long.compare(startTimeMs, l) < 0 && Long.compare(endTimeMs, l2) > 0) {
                        } else {
                        }
                        q0Var = 0;
                        if (Long.compare(endTimeMs, l2) > 0) {
                        } else {
                        }
                        q0Var = 1;
                    }
                    next = 0;
                    if ((SpecialOfferCoupon)next != 0) {
                        q0Var = new q0(m32, next, couponDiscount);
                        obj6 = m32.a.validateDiscount((SpecialOfferCoupon)next.getOfferCode()).flatMap(q0Var);
                    } else {
                        obj6 = a0.just(couponDiscount);
                    }
                } else {
                    obj6 = a0.just(couponDiscount);
                }
            } else {
            }
        } else {
        }
        return obj6;
    }

    private static final g0 d(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2, CouponDiscount couponDiscount3, Boolean boolean4) {
        a0 obj1;
        Object obj3;
        app.dogo.com.dogo_android.s.a.o0 obj4;
        n.f(m3, "this$0");
        n.f(couponDiscount3, "$currentCoupon");
        n.f(boolean4, "it");
        if (boolean4.booleanValue()) {
            obj4 = new o0(m3, specialOfferCoupon2);
            obj1 = m3.a.saveSpecialOfferCoupon(specialOfferCoupon2).B(obj4);
        } else {
            obj1 = a0.just(couponDiscount3);
        }
        return obj1;
    }

    private static final CouponDiscount e(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2) {
        n.f(m3, "this$0");
        m3.c.c(specialOfferCoupon2.toCouponDiscount());
        return specialOfferCoupon2.toCouponDiscount();
    }

    public static g0 f(CouponDiscount couponDiscount, app.dogo.com.dogo_android.s.a.m3 m32, Boolean boolean3) {
        return m3.c(couponDiscount, m32, boolean3);
    }

    public static CouponDiscount g(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2) {
        return m3.e(m3, specialOfferCoupon2);
    }

    public static g0 h(app.dogo.com.dogo_android.s.a.m3 m3, CouponDiscount couponDiscount2) {
        return m3.b(m3, couponDiscount2);
    }

    public static g0 i(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2, CouponDiscount couponDiscount3, Boolean boolean4) {
        return m3.d(m3, specialOfferCoupon2, couponDiscount3, boolean4);
    }

    public final a0<CouponDiscount> a() {
        p0 p0Var = new p0(this);
        a0 flatMap = this.a.getDiscount().flatMap(p0Var);
        n.e(flatMap, "billingRepository.getDiscount().flatMap { currentCoupon ->\n            subscribeInteractor.revenueCatSubscribed().flatMap { isPremium ->\n                if (!isPremium && (currentCoupon.welcomeOffer || currentCoupon.isEmpty())) {\n                    val activeSpecialOffer = remoteConfigService.getSpecialOffers.firstOrNull { it.startTimeMs < timeUtil.currentTimeInMillis && it.endTimeMs > timeUtil.currentTimeInMillis }\n                    if (activeSpecialOffer != null) {\n                        billingRepository.validateDiscount(activeSpecialOffer.offerCode).flatMap {\n                            if (it) {\n                                billingRepository.saveSpecialOfferCoupon(activeSpecialOffer).toSingle {\n                                    couponNotificationInteractor.scheduleNotification(activeSpecialOffer.toCouponDiscount())\n                                    activeSpecialOffer.toCouponDiscount()\n                                }\n                            } else {\n                                Single.just(currentCoupon)\n                            }\n                        }\n                    } else {\n                        Single.just(currentCoupon)\n                    }\n                } else {\n                    Single.just(currentCoupon)\n                }\n            }\n        }");
        return flatMap;
    }
}
