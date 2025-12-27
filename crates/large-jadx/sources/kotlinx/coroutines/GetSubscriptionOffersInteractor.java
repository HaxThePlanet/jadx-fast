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

/* compiled from: GetSubscriptionOffersInteractor.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "specialOfferInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;", "interactor", "Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/repository/interactor/SpecialOfferInteractor;Lapp/dogo/com/dogo_android/subscription/GetPremiumOfferingsInteractor;)V", "getSubscriptionOffers", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a3, reason: from kotlin metadata */
public final class GetSubscriptionOffersInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final n3 interactor;
    /* renamed from: b, reason: from kotlin metadata */
    private final Purchases purchases;
    /* renamed from: c, reason: from kotlin metadata */
    private final m3 specialOfferInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final GetPremiumOfferingsInteractor subscribeInteractor;
    public a3(n3 n3Var, Purchases purchases, m3 m3Var, GetPremiumOfferingsInteractor getPremiumOfferingsInteractor) {
        n.f(n3Var, "subscribeInteractor");
        n.f(purchases, "purchases");
        n.f(m3Var, "specialOfferInteractor");
        n.f(getPremiumOfferingsInteractor, "interactor");
        super();
        this.interactor = n3Var;
        this.purchases = purchases;
        this.specialOfferInteractor = m3Var;
        this.subscribeInteractor = getPremiumOfferingsInteractor;
    }

    private static final g0 b(a3 a3Var, Boolean boolean) {
        a0 flatMapped;
        n.f(a3Var, "this$0");
        n.f(boolean, "isUserPremium");
        if (!boolean.booleanValue()) {
            flatMapped = a3Var.specialOfferInteractor.checkAndTryToActivateSpecialOffer().onErrorReturn(kotlinx.coroutines.a0.a).flatMap(new kotlinx.coroutines.z(a3Var));
        } else {
            flatMapped = a0.error(new CouponExceptions_AlreadyPremium());
        }
        return flatMapped;
    }

    private static final CouponDiscount c(Throwable th) {
        n.f(th, "it");
        CouponDiscount th2 = new CouponDiscount(null, null, null, null, false, null, null, null, 255, null);
        return th2;
    }

    private static final g0 d(a3 a3Var, CouponDiscount couponDiscount) {
        n.f(a3Var, "this$0");
        n.f(couponDiscount, "coupon");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.Q(a3Var.purchases).flatMap(new kotlinx.coroutines.y(a3Var, couponDiscount));
    }

    private static final g0 e(a3 a3Var, CouponDiscount couponDiscount, Boolean boolean) {
        n.f(a3Var, "this$0");
        n.f(couponDiscount, "$coupon");
        n.f(boolean, "it");
        return a3Var.subscribeInteractor.getOffers(couponDiscount, boolean.booleanValue(), true);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<SubscriptionOffer> getSubscriptionOffers() {
        a0 flatMapped = this.interactor.t().flatMap(new kotlinx.coroutines.x(this));
        n.e(flatMapped, "subscribeInteractor.revenueCatUserPremiumAndWillRenew()\n            .flatMap { isUserPremium ->\n                if (!isUserPremium) {\n                    specialOfferInteractor.checkAndTryToActivateSpecialOffer()\n                        .onErrorReturn { CouponDiscount() }\n                        .flatMap { coupon ->\n                            purchases.isUserEligibleForFreeTrailByRegexCheck().flatMap {\n                                interactor.getOffers(coupon, it, true)\n                            }\n                        }\n                } else {\n                    Single.error(CouponExceptions.AlreadyPremium())\n                }\n            }");
        return flatMapped;
    }

    public static /* synthetic */ g0 f(a3 a3Var, Boolean boolean) {
        return GetSubscriptionOffersInteractor.b(a3Var, boolean);
    }

    public static /* synthetic */ g0 g(a3 a3Var, CouponDiscount couponDiscount, Boolean boolean) {
        return GetSubscriptionOffersInteractor.e(a3Var, couponDiscount, boolean);
    }

    public static /* synthetic */ g0 h(a3 a3Var, CouponDiscount couponDiscount) {
        return GetSubscriptionOffersInteractor.d(a3Var, couponDiscount);
    }

    public static /* synthetic */ CouponDiscount i(Throwable th) {
        return GetSubscriptionOffersInteractor.c(th);
    }
}
