package app.dogo.com.dogo_android.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u0008\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster;", "Landroid/content/BroadcastReceiver;", "()V", "pottyReminderNotificationHelper", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$PottyReminderNotificationHelper;", "getPottyReminderNotificationHelper", "()Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$PottyReminderNotificationHelper;", "pottyReminderNotificationHelper$delegate", "Lkotlin/Lazy;", "trainingReminderNotificationHelper", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;", "getTrainingReminderNotificationHelper", "()Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;", "trainingReminderNotificationHelper$delegate", "isPottyAlarm", "", "intent", "Landroid/content/Intent;", "isTrainingAlarm", "onReceive", "", "context", "Landroid/content/Context;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NotificationBroadcaster extends BroadcastReceiver {

    public static final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a Companion;
    private final h a;
    private final h b;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0008\tB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion;", "", "()V", "POTTY_REMINDER_ID", "", "SNOOZE_DELAY_IN_MINUTES", "", "TRAINING_REMINDER_ID", "PottyReminderNotificationHelper", "TrainingReminderNotificationHelper", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$PottyReminderNotificationHelper;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a> {

        public static final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.b a;
        static {
            NotificationBroadcaster.b bVar = new NotificationBroadcaster.b();
            NotificationBroadcaster.b.a = bVar;
        }

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a a() {
            NotificationBroadcaster.a.a aVar = new NotificationBroadcaster.a.a();
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b> {

        public static final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.c a;
        static {
            NotificationBroadcaster.c cVar = new NotificationBroadcaster.c();
            NotificationBroadcaster.c.a = cVar;
        }

        c() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b a() {
            NotificationBroadcaster.a.b bVar = new NotificationBroadcaster.a.b();
            return bVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        NotificationBroadcaster.a aVar = new NotificationBroadcaster.a(0);
        NotificationBroadcaster.Companion = aVar;
    }

    public NotificationBroadcaster() {
        super();
        this.a = j.b(NotificationBroadcaster.c.a);
        this.b = j.b(NotificationBroadcaster.b.a);
    }

    private final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.a a() {
        return (NotificationBroadcaster.a.a)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b b() {
        return (NotificationBroadcaster.a.b)this.a.getValue();
    }

    private final boolean c(Intent intent) {
        Bundle extras;
        int str;
        int i;
        boolean obj5;
        extras = intent.getExtras();
        final String str2 = "reminder_id";
        final int i2 = 1;
        if (extras == null) {
            str = i;
        } else {
        }
        if (str != null && n.b(intent.getStringExtra(str2), "potty_reminder")) {
            if (n.b(intent.getStringExtra(str2), "potty_reminder")) {
                i = i2;
            }
        }
        return i;
    }

    private final boolean d(Intent intent) {
        Bundle extras;
        int str;
        int i;
        boolean obj5;
        extras = intent.getExtras();
        final String str2 = "reminder_id";
        final int i2 = 1;
        if (extras == null) {
            str = i;
        } else {
        }
        if (str != null && n.b(intent.getStringExtra(str2), "training_reminder")) {
            if (n.b(intent.getStringExtra(str2), "training_reminder")) {
                i = i2;
            }
        }
        return i;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        String str;
        boolean obj2;
        n.f(context, "context");
        n.f(intent2, "intent");
        obj2 = intent2.getAction();
        if (n.b(obj2, "android.intent.action.BOOT_COMPLETED")) {
            obj2 = 1;
        } else {
            obj2 = n.b(obj2, "android.intent.action.PACKAGE_REPLACED");
        }
        if (obj2 != null) {
            a().k();
            b().n();
        } else {
            if (d(intent2)) {
                b().k();
            } else {
                if (c(intent2)) {
                    a().h(intent2);
                }
            }
        }
    }
}
