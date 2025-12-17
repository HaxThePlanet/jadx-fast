package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class c implements n {

    public final String a;
    public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a b;
    public final String c;
    public final boolean v;
    public c(String string, app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a notificationBroadcaster$a$a2, String string3, boolean z4) {
        super();
        this.a = string;
        this.b = a2;
        this.c = string3;
        this.v = z4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return NotificationBroadcaster.a.a.f(this.a, this.b, this.c, this.v, (PottyRemindersItem)object);
    }
}
