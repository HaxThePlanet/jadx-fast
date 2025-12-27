package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements n {

    public final /* synthetic */ NotificationBroadcaster.a.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public /* synthetic */ d(NotificationBroadcaster.a.a aVar, String str, boolean z) {
        super();
        this.a = aVar;
        this.b = str;
        this.c = z;
    }

    public final Object apply(Object object) {
        return NotificationBroadcaster_Companion_PottyReminderNotificationHelper.i(this.a, this.b, this.c, object);
    }
}
