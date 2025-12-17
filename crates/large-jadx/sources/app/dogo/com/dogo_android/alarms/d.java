package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class d implements n {

    public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a a;
    public final String b;
    public final boolean c;
    public d(app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a notificationBroadcaster$a$a, String string2, boolean z3) {
        super();
        this.a = a;
        this.b = string2;
        this.c = z3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return NotificationBroadcaster.a.a.g(this.a, this.b, this.c, (String)object);
    }
}
