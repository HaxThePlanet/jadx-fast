package app.dogo.com.dogo_android.alarms;

import android.app.IntentService;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/alarms/SnoozeAction;", "Landroid/app/IntentService;", "()V", "trainingReminderNotificationHelper", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;", "getTrainingReminderNotificationHelper", "()Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;", "trainingReminderNotificationHelper$delegate", "Lkotlin/Lazy;", "onHandleIntent", "", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SnoozeAction extends IntentService {

    private final h a;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster$Companion$TrainingReminderNotificationHelper;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b> {

        public static final app.dogo.com.dogo_android.alarms.SnoozeAction.a a;
        static {
            SnoozeAction.a aVar = new SnoozeAction.a();
            SnoozeAction.a.a = aVar;
        }

        a() {
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
    }

    public SnoozeAction() {
        super("snooze service");
        this.a = j.b(SnoozeAction.a.a);
    }

    private final app.dogo.com.dogo_android.alarms.NotificationBroadcaster.a.b a() {
        return (NotificationBroadcaster.a.b)this.a.getValue();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        a().p();
    }
}
