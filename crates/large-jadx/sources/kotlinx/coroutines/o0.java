package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class o0 implements Callable {

    public final /* synthetic */ m3 a;
    public final /* synthetic */ SpecialOfferCoupon b;
    public /* synthetic */ o0(m3 m3Var, SpecialOfferCoupon specialOfferCoupon) {
        super();
        this.a = m3Var;
        this.b = specialOfferCoupon;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return SpecialOfferInteractor.e(this.a, this.b);
    }
}
