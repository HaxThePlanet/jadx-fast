package app.dogo.com.dogo_android.subscription;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class f implements Callable {

    public final CouponEntity a;
    public f(CouponEntity couponEntity) {
        super();
        this.a = couponEntity;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return BillingRepository.f(this.a);
    }
}
