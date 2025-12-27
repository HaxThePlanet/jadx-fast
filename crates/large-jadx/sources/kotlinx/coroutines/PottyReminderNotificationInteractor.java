package app.dogo.com.dogo_android.s.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.core.app.m;
import app.dogo.com.dogo_android.alarms.NotificationBroadcaster;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.x;
import app.dogo.com.dogo_android.util.x.a;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.w;

/* compiled from: PottyReminderNotificationInteractor.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 .2\u00020\u0001:\u0001.B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0008\u0010\u0018\u001a\u00020\u0016H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J8\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0\"2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u001cJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J8\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;", "", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "applicationContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/NotificationService;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;)V", "cancelPottyReminderNotificationAlarm", "", "notificationId", "", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "getPottyReminderDescription", "", "dogName", "getPottyReminderTitle", "isDayCorrect", "", "dayFilter", "", "isLastReminderNotificationForToday", "endTime", "interval", "", "parseReminderStartTimeMs", "Lkotlin/Pair;", "startTime", "setPottyReminderNotification", "reminder", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "setupNotificationAlarm", "startTimeMs", "reminderId", "dogId", "intervalFlag", "showPottyReminderNotification", "remindersModel", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h3, reason: from kotlin metadata */
public final class PottyReminderNotificationInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h3.a INSTANCE = new h3$a(0);
    private static final Class<NotificationBroadcaster> f = app.dogo.com.dogo_android.alarms.NotificationBroadcaster.class;
    /* renamed from: a, reason: from kotlin metadata */
    private final o2 alarmManager;
    /* renamed from: b, reason: from kotlin metadata */
    private final PackageManager applicationContext;
    /* renamed from: c, reason: from kotlin metadata */
    private final AlarmManager notificationService;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 packageManager;
    /* renamed from: e, reason: from kotlin metadata */
    private final Context utilities;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor$Companion;", "", "()V", "POTTY_NOTIFICATION_SOURCE", "", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public h3(o2 o2Var, PackageManager packageManager, AlarmManager alarmManager, v2 v2Var, Context context) {
        n.f(o2Var, "notificationService");
        n.f(packageManager, "packageManager");
        n.f(alarmManager, "alarmManager");
        n.f(v2Var, "utilities");
        n.f(context, "applicationContext");
        super();
        this.alarmManager = o2Var;
        this.applicationContext = packageManager;
        this.notificationService = alarmManager;
        this.packageManager = v2Var;
        this.utilities = context;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final PendingIntent getPendingIntent(Intent intent, int notificationId) {
        final PendingIntent broadcast = PendingIntent.getBroadcast(this.utilities, notificationId + (0x013130e8 /* Unknown resource */), intent, 201326592);
        n.e(broadcast, "getBroadcast(\n            applicationContext,\n            POTTY_REMINDER_REQUEST_CODE + notificationId,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return broadcast;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final String cancelPottyReminderNotificationAlarm(String notificationId) {
        int i;
        String string;
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            i = 2131887192;
            string = this.utilities.getString(i);
        }
        n.e(string, "if (dogName.isEmpty()) {\n            applicationContext.getString(R.string.reminder_daily_training_your_dog)\n        } else {\n            dogName\n        }");
        Object[] arr = new Object[i];
        String string2 = this.utilities.getString(2131887095, new Object[] { string });
        n.e(string2, "applicationContext.getString(R.string.potty_training_notification, tempDogName)");
        return string2;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final String getPottyReminderTitle() {
        String string = this.utilities.getString(2131886080);
        n.e(string, "applicationContext.getString(R.string.CFBundleDisplayName)");
        return string;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean getPottyReminderDescription(List<Boolean> dogName) {
        final int i4 = 7;
        return (Boolean)dogName.get((this.packageManager.f().get(i4) + 5) % i4).booleanValue();
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final void setupNotificationAlarm(long startTimeMs, long interval, int notificationId, String reminderId, String dogId, boolean intervalFlag) {
        final Object startTimeMs3 = this;
        final int dogId2 = notificationId;
        final boolean z = intervalFlag;
        isDayCorrect(dogId2);
        Class cls = PottyReminderNotificationInteractor.f;
        int i2 = 1;
        startTimeMs3.applicationContext.setComponentEnabledSetting(new ComponentName(startTimeMs3.utilities, cls), i2, i2);
        Intent intent = new Intent(startTimeMs3.utilities, cls);
        intent.putExtra("reminder_id", "potty_reminder");
        intent.putExtra("potty_reminder_id_key", reminderId);
        intent.putExtra("potty_notification_id_key", dogId2);
        intent.putExtra("dog_id", dogId);
        intent.putExtra("interval_alarm", z);
        final PendingIntent pendingIntent = getPendingIntent(intent, dogId2);
        if (z) {
            int i = 0;
            startTimeMs3.notificationService.setRepeating(i, startTimeMs, interval, pendingIntent);
        } else {
            i = 0;
            PendingIntent notificationId2 = 86400000;
            startTimeMs3.notificationService.setRepeating(i, startTimeMs, notificationId2, pendingIntent);
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final void isDayCorrect(int dayFilter) {
        this.alarmManager.c(this.utilities, PottyReminderNotificationInteractor.f, dayFilter + (0x013130e8 /* Unknown resource */));
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean isLastReminderNotificationForToday(String endTime, long interval) {
        boolean z = false;
        n.f(endTime, "endTime");
        Calendar calendar = this.packageManager.f();
        o timeToInts = ReminderHelper.INSTANCE.parseTimeToInts(endTime);
        calendar.set(11, (Number)timeToInts.a().intValue());
        calendar.set(12, (Number)timeToInts.b().intValue());
        calendar.set(13, 0);
        long l2 = this.packageManager.g() + interval;
        long timeInMillis = calendar.getTimeInMillis();
        if (l2 > timeInMillis) {
            int i3 = 1;
        }
        return z;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final o<Long, Boolean> parseReminderStartTimeMs(String startTime, String endTime, long interval, List<Boolean> dayFilter) {
        long timeInMillis;
        o interval2;
        n.f(startTime, "startTime");
        n.f(endTime, "endTime");
        n.f(dayFilter, "dayFilter");
        Calendar calendar = this.packageManager.f();
        Calendar calendar2 = this.packageManager.f();
        long l = this.packageManager.g();
        x.a iNSTANCE2 = ReminderHelper.INSTANCE;
        o timeToInts = iNSTANCE2.parseTimeToInts(startTime);
        o timeToInts2 = iNSTANCE2.parseTimeToInts(endTime);
        final int i2 = 11;
        calendar.set(i2, (Number)timeToInts.a().intValue());
        int i = 12;
        calendar.set(i, (Number)timeToInts.b().intValue());
        int i4 = 13;
        final int i3 = 0;
        calendar.set(i4, i3);
        calendar2.set(i2, (Number)timeToInts2.a().intValue());
        calendar2.set(i, (Number)timeToInts2.b().intValue());
        calendar2.set(i4, i3);
        timeInMillis = calendar.getTimeInMillis();
        if (timeInMillis > l || !getPottyReminderDescription(dayFilter)) {
            interval2 = new Pair(Long.valueOf(calendar.getTimeInMillis()), Boolean.FALSE);
        }
        return interval2;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final void setPottyReminderNotification(PottyRemindersItem reminder) {
        n.f(reminder, "reminder");
        if (reminder.getEndTime() != null && reminder.getRepeatIntervalMs() != null) {
            String endTime2 = reminder.getEndTime();
            n.d(endTime2);
            long value = reminder.getRepeatIntervalMs().longValue();
            List days = reminder.getDays();
            o reminderStartTimeMs = this.parseReminderStartTimeMs(reminder.getStartTime(), endTime2, value, days);
            if (!reminder.isActive()) {
                isDayCorrect(reminder.getNotificationId());
            } else {
                this.setupNotificationAlarm((Number)reminderStartTimeMs.a().longValue(), reminder.getRepeatIntervalMs().longValue(), reminder.getNotificationId(), reminder.getReminderId(), reminder.getDogId(), (Boolean)reminderStartTimeMs.b().booleanValue());
            }
        }
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final void showPottyReminderNotification(PottyRemindersItem remindersModel, String dogName) {
        n.f(remindersModel, "remindersModel");
        n.f(dogName, "dogName");
        if (remindersModel.isActive()) {
            if (getPottyReminderDescription(remindersModel.getDays())) {
                Intent intent = new Intent(this.utilities, SplashActivity.class);
                intent.putExtra("source", "potty_notification");
                intent.putExtra("uri", n.o("dogoapp://dogo.app/calendar?dog=", remindersModel.getDogId()));
                String cancelPottyReminderNotificationAlarm = cancelPottyReminderNotificationAlarm(dogName);
                str2 = "reminders_id";
                j.e eVar = this.alarmManager.f(intent, getPottyReminderTitle(), cancelPottyReminderNotificationAlarm, str2);
                j.c cVar = new j.c();
                cVar.h(cancelPottyReminderNotificationAlarm);
                eVar.A(cVar);
                m mVar = m.c(this.utilities);
                n.e(mVar, "from(applicationContext)");
                str = "potty_reminder";
                mVar.e(str, remindersModel.getNotificationId(), eVar.c());
            }
        }
    }
}
