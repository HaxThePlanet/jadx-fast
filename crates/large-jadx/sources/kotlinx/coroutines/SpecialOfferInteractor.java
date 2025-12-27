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

/* compiled from: SpecialOfferInteractor.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "timeUtil", "Lapp/dogo/com/dogo_android/service/Utilities;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "checkAndTryToActivateSpecialOffer", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m3, reason: from kotlin metadata */
public final class SpecialOfferInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final BillingRepository billingRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final v2 couponNotificationInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final b2 remoteConfigService;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 subscribeInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final n3 timeUtil;
    public m3(BillingRepository billingRepository, v2 v2Var, b2 b2Var, r2 r2Var, n3 n3Var) {
        n.f(billingRepository, "billingRepository");
        n.f(v2Var, "timeUtil");
        n.f(b2Var, "couponNotificationInteractor");
        n.f(r2Var, "remoteConfigService");
        n.f(n3Var, "subscribeInteractor");
        super();
        this.billingRepository = billingRepository;
        this.couponNotificationInteractor = v2Var;
        this.remoteConfigService = b2Var;
        this.subscribeInteractor = r2Var;
        this.timeUtil = n3Var;
    }

    private static final g0 b(m3 m3Var, CouponDiscount couponDiscount) {
        n.f(m3Var, "this$0");
        n.f(couponDiscount, "currentCoupon");
        return m3Var.timeUtil.q().flatMap(new kotlinx.coroutines.n0(couponDiscount, m3Var));
    }

    private static final g0 c(CouponDiscount couponDiscount, m3 m3Var, Boolean boolean) {
        Object obj = null;
        int i;
        int cmp;
        long l;
        long l2;
        a0 flatMapped;
        boolean booleanValue;
        n.f(couponDiscount, "$currentCoupon");
        n.f(m3Var, "this$0");
        n.f(boolean, "isPremium");
        if (!(boolean.booleanValue() || !couponDiscount.getWelcomeOffer())) {
            if (couponDiscount.isEmpty()) {
                Iterator it = m3Var.subscribeInteractor.r().iterator();
                while (it.hasNext()) {
                    long startTimeMs = item.getStartTimeMs();
                    l2 = m3Var.couponNotificationInteractor.g();
                    if (i != 0) {
                        break;
                    }
                }
                int i2 = 0;
                if (obj != null) {
                    flatMapped = m3Var.billingRepository.validateDiscount(obj.getOfferCode()).flatMap(new kotlinx.coroutines.q0(m3Var, obj, couponDiscount));
                } else {
                    flatMapped = a0.just(couponDiscount);
                }
            }
        } else {
            flatMapped = a0.just(couponDiscount);
        }
        return flatMapped;
    }

    private static final g0 d(m3 m3Var, SpecialOfferCoupon specialOfferCoupon, CouponDiscount couponDiscount, Boolean boolean) {
        a0 just;
        n.f(m3Var, "this$0");
        n.f(couponDiscount, "$currentCoupon");
        n.f(boolean, "it");
        if (boolean.booleanValue()) {
            just = m3Var.billingRepository.saveSpecialOfferCoupon(specialOfferCoupon).B(new kotlinx.coroutines.o0(m3Var, specialOfferCoupon));
        } else {
            just = a0.just(couponDiscount);
        }
        return just;
    }

    private static final CouponDiscount e(m3 m3Var, SpecialOfferCoupon specialOfferCoupon) {
        n.f(m3Var, "this$0");
        m3Var.remoteConfigService.c(specialOfferCoupon.toCouponDiscount());
        return specialOfferCoupon.toCouponDiscount();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<CouponDiscount> checkAndTryToActivateSpecialOffer() {
        a0 flatMapped = this.billingRepository.getDiscount().flatMap(new kotlinx.coroutines.p0(this));
        n.e(flatMapped, "billingRepository.getDiscount().flatMap { currentCoupon ->\n            subscribeInteractor.revenueCatSubscribed().flatMap { isPremium ->\n                if (!isPremium && (currentCoupon.welcomeOffer || currentCoupon.isEmpty())) {\n                    val activeSpecialOffer = remoteConfigService.getSpecialOffers.firstOrNull { it.startTimeMs < timeUtil.currentTimeInMillis && it.endTimeMs > timeUtil.currentTimeInMillis }\n                    if (activeSpecialOffer != null) {\n                        billingRepository.validateDiscount(activeSpecialOffer.offerCode).flatMap {\n                            if (it) {\n                                billingRepository.saveSpecialOfferCoupon(activeSpecialOffer).toSingle {\n                                    couponNotificationInteractor.scheduleNotification(activeSpecialOffer.toCouponDiscount())\n                                    activeSpecialOffer.toCouponDiscount()\n                                }\n                            } else {\n                                Single.just(currentCoupon)\n                            }\n                        }\n                    } else {\n                        Single.just(currentCoupon)\n                    }\n                } else {\n                    Single.just(currentCoupon)\n                }\n            }\n        }");
        return flatMapped;
    }

    public static /* synthetic */ g0 f(CouponDiscount couponDiscount, m3 m3Var, Boolean boolean) {
        return SpecialOfferInteractor.c(couponDiscount, m3Var, boolean);
    }

    public static /* synthetic */ CouponDiscount g(m3 m3Var, SpecialOfferCoupon specialOfferCoupon) {
        return SpecialOfferInteractor.e(m3Var, specialOfferCoupon);
    }

    public static /* synthetic */ g0 h(m3 m3Var, CouponDiscount couponDiscount) {
        return SpecialOfferInteractor.b(m3Var, couponDiscount);
    }

    public static /* synthetic */ g0 i(m3 m3Var, SpecialOfferCoupon specialOfferCoupon, CouponDiscount couponDiscount, Boolean boolean) {
        return SpecialOfferInteractor.d(m3Var, specialOfferCoupon, couponDiscount, boolean);
    }
}
