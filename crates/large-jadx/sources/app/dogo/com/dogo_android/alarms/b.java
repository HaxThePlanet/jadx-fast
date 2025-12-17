package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class b implements n {

    public final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a a;
    public b(app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a couponNotificationBroadcaster$a$a) {
        super();
        this.a = a;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return CouponNotificationBroadcaster.a.a.g(this.a, (CouponDiscount)object);
    }
}
