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

/* compiled from: NotificationService.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u0010\u000f\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J.\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u000eJ\"\u0010 \u001a\u00020\u000c2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/service/NotificationService;", "", "context", "Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "(Landroid/content/Context;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;)V", "areNotificationsEnabled", "", "cancelNotification", "", "id", "", "cancelNotificationAlarm", "T", "broadcasterClass", "Ljava/lang/Class;", "requestCode", "", "createNotificationChannel", "channelName", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "preBuildNotification", "Landroidx/core/app/NotificationCompat$Builder;", "title", "description", "channelId", "showNotification", "notification", "Landroid/app/Notification;", "tag", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o2, reason: from kotlin metadata */
public final class NotificationService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final o2.a INSTANCE = new o2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final Context alarmManager;
    /* renamed from: b, reason: from kotlin metadata */
    private final PackageManager context;
    /* renamed from: c, reason: from kotlin metadata */
    private final AlarmManager packageManager;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/service/NotificationService$Companion;", "", "()V", "ANNOUNCEMENT_CHANNEL_ID", "", "DOG_ID", "IS_INTERVAL_ALARM", "NOTIFICATION_MAIN_ACTION_CODE", "", "POTTY_NOTIFICATION_ID_KEY", "POTTY_REMINDER_ID_KEY", "POTTY_REMINDER_REQUEST_CODE", "REMINDERS_CHANNEL_ID", "REMINDER_ID_KEY", "SNOOZE_TRAINING_CODE", "SPECIAL_OFFER_REQUEST_CODE", "TEMP_REMINDER_KEY", "TRAINING_REMINDER_REQUEST_CODE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public o2(Context context, PackageManager packageManager, AlarmManager alarmManager) {
        n.f(context, "context");
        n.f(packageManager, "packageManager");
        n.f(alarmManager, "alarmManager");
        super();
        this.alarmManager = context;
        this.context = packageManager;
        this.packageManager = alarmManager;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final PendingIntent cancelNotificationAlarm(Context context, Intent broadcasterClass, int requestCode) {
        final PendingIntent broadcast = PendingIntent.getBroadcast(context, requestCode, broadcasterClass, 201326592);
        n.e(broadcast, "getBroadcast(\n            context,\n            requestCode,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return broadcast;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean areNotificationsEnabled() {
        java.util.List notificationChannels;
        boolean hasNext;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = this.alarmManager.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            notificationChannels = systemService.getNotificationChannels();
            n.e(notificationChannels, "manager.notificationChannels");
            hasNext = notificationChannels instanceof Collection;
            final int i2 = 0;
            int r2 = i2;
            return i2;
        }
        return m.c(this.alarmManager).a();
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void cancelNotification(String id) {
        m mVar = m.c(this.alarmManager);
        n.e(mVar, "from(context)");
        mVar.b(id, 0);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final <T> void getPendingIntent(Context context, Class<T> intent, int requestCode) {
        n.f(context, "context");
        n.f(intent, "broadcasterClass");
        this.context.setComponentEnabledSetting(new ComponentName(context, intent), 2, 1);
        final PendingIntent cancelNotificationAlarm = cancelNotificationAlarm(context, new Intent(context, intent), requestCode);
        this.packageManager.cancel(cancelNotificationAlarm);
        cancelNotificationAlarm.cancel();
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void createNotificationChannel(String id, String channelName) {
        int i = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            int sDK_INT2 = 3;
            obj = NotificationManager.class;
            Object systemService = this.alarmManager.getSystemService(obj);
            n.d(systemService);
            systemService.createNotificationChannel(new NotificationChannel(id, channelName, sDK_INT2));
        }
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final j.e preBuildNotification(Intent intent, String title, String description, String channelId) {
        n.d(channelId);
        j.e eVar = new j.e(this.alarmManager, channelId);
        eVar.y(2131231341);
        eVar.m(title);
        eVar.l(description);
        eVar.v(0);
        eVar.h("reminder");
        int i5 = 1;
        eVar.D(i5);
        eVar.C(new long[] { 0, 500 });
        eVar.k(PendingIntent.getActivity(this.alarmManager, 1000, intent, 335544320));
        eVar.z(RingtoneManager.getDefaultUri(2));
        eVar.g(true);
        n.e(eVar, "Builder(context, channelId!!)\n            .setSmallIcon(R.drawable.vector_dogo_icon)\n            .setContentTitle(title)\n            .setContentText(description)\n            .setPriority(NotificationCompat.PRIORITY_DEFAULT)\n            .setCategory(NotificationCompat.CATEGORY_REMINDER)\n            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)\n            .setVibrate(longArrayOf(0, 500))\n            .setContentIntent(pendingIntent)\n            .setSound(uri)\n            .setAutoCancel(true)");
        return eVar;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final void showNotification(Notification notification, String tag, int id) {
        m mVar = m.c(this.alarmManager);
        n.e(mVar, "from(context)");
        n.d(notification);
        mVar.e(tag, id, notification);
    }

}
