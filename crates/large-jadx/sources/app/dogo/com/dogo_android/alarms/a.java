package app.dogo.com.dogo_android.alarms;

import android.content.Context;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class a implements n {

    public final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a a;
    public final Context b;
    public a(app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a couponNotificationBroadcaster$a$a, Context context2) {
        super();
        this.a = a;
        this.b = context2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return CouponNotificationBroadcaster.a.a.f(this.a, this.b, (String)object);
    }
}
