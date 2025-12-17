package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyPremium;
import app.dogo.com.dogo_android.util.h0.j1;
import com.revenuecat.purchases.Purchases;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "specialOfferInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "interactor", "Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;)V", "getSubscriptionOffers", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a3 {

    private final app.dogo.com.dogo_android.s.a.n3 a;
    private final Purchases b;
    private final app.dogo.com.dogo_android.s.a.m3 c;
    private final GetPremiumOfferingsInteractor d;
    public a3(app.dogo.com.dogo_android.s.a.n3 n3, Purchases purchases2, app.dogo.com.dogo_android.s.a.m3 m33, GetPremiumOfferingsInteractor getPremiumOfferingsInteractor4) {
        n.f(n3, "subscribeInteractor");
        n.f(purchases2, "purchases");
        n.f(m33, "specialOfferInteractor");
        n.f(getPremiumOfferingsInteractor4, "interactor");
        super();
        this.a = n3;
        this.b = purchases2;
        this.c = m33;
        this.d = getPremiumOfferingsInteractor4;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.a3 a3, Boolean boolean2) {
        Object zVar;
        a0 obj1;
        a0 obj2;
        n.f(a3, "this$0");
        n.f(boolean2, "isUserPremium");
        if (!boolean2.booleanValue()) {
            zVar = new z(a3);
            obj1 = a3.c.a().onErrorReturn(a0.a).flatMap(zVar);
        } else {
            obj1 = new CouponExceptions.AlreadyPremium();
            obj1 = a0.error(obj1);
        }
        return obj1;
    }

    private static final CouponDiscount c(Throwable throwable) {
        n.f(throwable, "it");
        super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
        return obj12;
    }

    private static final g0 d(app.dogo.com.dogo_android.s.a.a3 a3, CouponDiscount couponDiscount2) {
        n.f(a3, "this$0");
        n.f(couponDiscount2, "coupon");
        y yVar = new y(a3, couponDiscount2);
        return j1.Q(a3.b).flatMap(yVar);
    }

    private static final g0 e(app.dogo.com.dogo_android.s.a.a3 a3, CouponDiscount couponDiscount2, Boolean boolean3) {
        n.f(a3, "this$0");
        n.f(couponDiscount2, "$coupon");
        n.f(boolean3, "it");
        return a3.d.getOffers(couponDiscount2, boolean3.booleanValue(), true);
    }

    public static g0 f(app.dogo.com.dogo_android.s.a.a3 a3, Boolean boolean2) {
        return a3.b(a3, boolean2);
    }

    public static g0 g(app.dogo.com.dogo_android.s.a.a3 a3, CouponDiscount couponDiscount2, Boolean boolean3) {
        return a3.e(a3, couponDiscount2, boolean3);
    }

    public static g0 h(app.dogo.com.dogo_android.s.a.a3 a3, CouponDiscount couponDiscount2) {
        return a3.d(a3, couponDiscount2);
    }

    public static CouponDiscount i(Throwable throwable) {
        return a3.c(throwable);
    }

    public final a0<SubscriptionOffer> a() {
        x xVar = new x(this);
        a0 flatMap = this.a.t().flatMap(xVar);
        n.e(flatMap, "subscribeInteractor.revenueCatUserPremiumAndWillRenew()\n            .flatMap { isUserPremium ->\n                if (!isUserPremium) {\n                    specialOfferInteractor.checkAndTryToActivateSpecialOffer()\n                        .onErrorReturn { CouponDiscount() }\n                        .flatMap { coupon ->\n                            purchases.isUserEligibleForFreeTrailByRegexCheck().flatMap {\n                                interactor.getOffers(coupon, it, true)\n                            }\n                        }\n                } else {\n                    Single.error(CouponExceptions.AlreadyPremium())\n                }\n            }");
        return flatMap;
    }
}
