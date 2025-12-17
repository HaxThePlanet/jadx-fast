package app.dogo.com.dogo_android.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import androidx.core.app.j.e;
import androidx.core.app.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u0010\u000f\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J.\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u000eJ\"\u0010 \u001a\u00020\u000c2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/service/NotificationService;", "", "context", "Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "(Landroid/content/Context;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;)V", "areNotificationsEnabled", "", "cancelNotification", "", "id", "", "cancelNotificationAlarm", "T", "broadcasterClass", "Ljava/lang/Class;", "requestCode", "", "createNotificationChannel", "channelName", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "preBuildNotification", "Landroidx/core/app/NotificationCompat$Builder;", "title", "description", "channelId", "showNotification", "notification", "Landroid/app/Notification;", "tag", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o2 {

    public static final app.dogo.com.dogo_android.service.o2.a Companion;
    private final Context a;
    private final PackageManager b;
    private final AlarmManager c;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/service/NotificationService$Companion;", "", "()V", "ANNOUNCEMENT_CHANNEL_ID", "", "DOG_ID", "IS_INTERVAL_ALARM", "NOTIFICATION_MAIN_ACTION_CODE", "", "POTTY_NOTIFICATION_ID_KEY", "POTTY_REMINDER_ID_KEY", "POTTY_REMINDER_REQUEST_CODE", "REMINDERS_CHANNEL_ID", "REMINDER_ID_KEY", "SNOOZE_TRAINING_CODE", "SPECIAL_OFFER_REQUEST_CODE", "TEMP_REMINDER_KEY", "TRAINING_REMINDER_REQUEST_CODE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        o2.a aVar = new o2.a(0);
        o2.Companion = aVar;
    }

    public o2(Context context, PackageManager packageManager2, AlarmManager alarmManager3) {
        n.f(context, "context");
        n.f(packageManager2, "packageManager");
        n.f(alarmManager3, "alarmManager");
        super();
        this.a = context;
        this.b = packageManager2;
        this.c = alarmManager3;
    }

    private final PendingIntent e(Context context, Intent intent2, int i3) {
        final PendingIntent obj2 = PendingIntent.getBroadcast(context, i3, intent2, 201326592);
        n.e(obj2, "getBroadcast(\n            context,\n            requestCode,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return obj2;
    }

    public final boolean a() {
        java.util.List notificationChannels;
        boolean empty;
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = this.a.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            notificationChannels = (NotificationManager)systemService.getNotificationChannels();
            n.e(notificationChannels, "manager.notificationChannels");
            final int i3 = 0;
            if (notificationChannels instanceof Collection != null && notificationChannels.isEmpty()) {
                if (notificationChannels.isEmpty()) {
                    i = i3;
                } else {
                    notificationChannels = notificationChannels.iterator();
                    while (notificationChannels.hasNext()) {
                        if ((NotificationChannel)notificationChannels.next().getImportance() != 0) {
                        } else {
                        }
                        empty = i3;
                        if (!empty) {
                            break;
                        }
                        empty = i;
                    }
                }
            } else {
            }
            return i;
        }
        return m.c(this.a).a();
    }

    public final void b(String string) {
        m mVar = m.c(this.a);
        n.e(mVar, "from(context)");
        mVar.b(string, 0);
    }

    public final <T> void c(Context context, Class<T> class2, int i3) {
        n.f(context, "context");
        n.f(class2, "broadcasterClass");
        ComponentName componentName = new ComponentName(context, class2);
        this.b.setComponentEnabledSetting(componentName, 2, 1);
        Intent intent = new Intent(context, class2);
        final PendingIntent obj5 = e(context, intent, i3);
        this.c.cancel(obj5);
        obj5.cancel();
    }

    public final void d(String string, String string2) {
        int sDK_INT;
        int notificationChannel;
        Object obj3;
        java.lang.CharSequence obj4;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationChannel = new NotificationChannel(string, string2, 3);
            obj3 = this.a.getSystemService(NotificationManager.class);
            n.d(obj3);
            (NotificationManager)obj3.createNotificationChannel(notificationChannel);
        }
    }

    public final j.e f(Intent intent, String string2, String string3, String string4) {
        final int i = 2;
        n.d(string4);
        j.e eVar = new j.e(this.a, string4);
        eVar.y(2131231341);
        eVar.m(string2);
        eVar.l(string3);
        eVar.v(0);
        eVar.h("reminder");
        int obj7 = 1;
        eVar.D(obj7);
        final long[] obj8 = new long[i];
        obj8 = new long[]{0L, 500L};
        eVar.C(obj8);
        eVar.k(PendingIntent.getActivity(this.a, 1000, intent, 335544320));
        eVar.z(RingtoneManager.getDefaultUri(i));
        eVar.g(obj7);
        n.e(eVar, "Builder(context, channelId!!)\n            .setSmallIcon(R.drawable.vector_dogo_icon)\n            .setContentTitle(title)\n            .setContentText(description)\n            .setPriority(NotificationCompat.PRIORITY_DEFAULT)\n            .setCategory(NotificationCompat.CATEGORY_REMINDER)\n            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)\n            .setVibrate(longArrayOf(0, 500))\n            .setContentIntent(pendingIntent)\n            .setSound(uri)\n            .setAutoCancel(true)");
        return eVar;
    }

    public final void g(Notification notification, String string2, int i3) {
        m mVar = m.c(this.a);
        n.e(mVar, "from(context)");
        n.d(notification);
        mVar.e(string2, i3, notification);
    }
}
