package app.dogo.com.dogo_android.subscription;

import app.dogo.android.persistencedb.room.entity.CouponEntity;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements Callable {

    public final /* synthetic */ CouponEntity a;
    public /* synthetic */ f(CouponEntity couponEntity) {
        super();
        this.a = couponEntity;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return BillingRepository.fetchAndSaveDiscount$lambda_4$lambda_3(this.a);
    }
}
