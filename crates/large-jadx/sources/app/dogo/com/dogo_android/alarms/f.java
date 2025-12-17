package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class f implements n {

    public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b a;
    public f(app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b notificationBroadcaster$a$b) {
        super();
        this.a = b;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return NotificationBroadcaster.a.b.h(this.a, (RemindersModel)object);
    }
}
