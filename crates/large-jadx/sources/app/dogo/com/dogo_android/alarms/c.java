package app.dogo.com.dogo_android.alarms;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements n {

    public final /* synthetic */ String a;
    public final /* synthetic */ NotificationBroadcaster.a.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean v;
    public /* synthetic */ c(String str, NotificationBroadcaster.a.a aVar, String str2, boolean z) {
        super();
        this.a = str;
        this.b = aVar;
        this.c = str2;
        this.v = z;
    }

    public final Object apply(Object object) {
        return NotificationBroadcaster_Companion_PottyReminderNotificationHelper.j(this.a, this.b, this.c, this.v, object);
    }
}
