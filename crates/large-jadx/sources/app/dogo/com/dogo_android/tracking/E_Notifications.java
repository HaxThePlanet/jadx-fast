package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Notifications;", "", "()V", "FcmNotificationClick", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$MessageId;", "NotificationClick", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "Lapp/dogo/com/dogo_android/tracking/EP$NotificationId;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public final class E_Notifications {

    public static final v2<o2, c2> a;
    public static final u2<b2> b;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        String str = "notification_clicked";
        E_Notifications.a = companion2.a(str).c(new EP_Type(), new EP_NotificationId());
        E_Notifications.b = companion2.a(str).b(new EP_MessageId());
    }
}
