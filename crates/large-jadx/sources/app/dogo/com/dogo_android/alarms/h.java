package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class h implements n {

    public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b a;
    public final String b;
    public h(app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b notificationBroadcaster$a$b, String string2) {
        super();
        this.a = b;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return NotificationBroadcaster.a.b.j(this.a, this.b, (RemindersModel)object);
    }
}
