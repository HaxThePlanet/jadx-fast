package app.dogo.com.dogo_android.s.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import app.dogo.com.dogo_android.alarms.NotificationBroadcaster;
import app.dogo.com.dogo_android.k.l.a;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import n.a.a;
import net.time4j.g1.v;
import net.time4j.k0;

/* compiled from: TrainingReminderNotificationInteractor.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 22\u00020\u0001:\u00012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0008\u0010 \u001a\u00020\u001dH\u0002J\u0016\u0010!\u001a\u00020\"2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\"0\u000eH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020'J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;", "", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "applicationContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/NotificationService;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;)V", "trainingMessageResIds", "", "", "getTrainingMessageResIds", "()Ljava/util/List;", "cancelNotification", "", "cancelTrainingReminderNotificationAlarm", "requestCode", "delayReminderNotificationByMinutes", "delayMinutes", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "getTrainingReminderDescription", "", "reminderNumber", "dogName", "getTrainingReminderTitle", "isDayCorrect", "", "dayFilter", "parseRemindersCalendar", "Ljava/util/Calendar;", "remindersModel", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "parseTrainingMessage", "fullMessage", "setTrainingReminderNotification", "reminder", "setupNotificationAlarm", "timeMs", "", "repeatFrequency", "Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "showTrainingReminderNotification", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o3, reason: from kotlin metadata */
public final class TrainingReminderNotificationInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final o3.a INSTANCE = new o3$a(0);
    private static final Class<NotificationBroadcaster> f = app.dogo.com.dogo_android.alarms.NotificationBroadcaster.class;
    /* renamed from: a, reason: from kotlin metadata */
    private final o2 alarmManager;
    /* renamed from: b, reason: from kotlin metadata */
    private final PackageManager applicationContext;
    /* renamed from: c, reason: from kotlin metadata */
    private final AlarmManager notificationService;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 packageManager;
    private final Context e;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor$Companion;", "", "()V", "TRAINING_NOTIFICATION_SOURCE", "", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public o3(o2 o2Var, PackageManager packageManager, AlarmManager alarmManager, v2 v2Var, Context context) {
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
        this.e = context;
    }

    public static /* synthetic */ void c(o3 o3Var, int i, int i2, Object object) {
        if (i2 & 1 != 0) {
            i = 10001000;
        }
        o3Var.parseRemindersCalendar(i);
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final PendingIntent getPendingIntent(Intent intent, int requestCode) {
        final PendingIntent broadcast = PendingIntent.getBroadcast(this.e, requestCode, intent, 201326592);
        n.e(broadcast, "getBroadcast(\n            applicationContext,\n            requestCode,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return broadcast;
    }

    static /* synthetic */ PendingIntent f(o3 o3Var, Intent intent, int i, int i2, Object object) {
        if (i2 & 2 != 0) {
            i = 10001000;
        }
        return o3Var.getPendingIntent(intent, i);
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final List<Integer> cancelNotification() {
        Integer[] arr = new Integer[8];
        return p.j(new Integer[] { 2131887184, 2131887185, 2131887186, 2131887187, 2131887188, 2131887189, 2131887190, 2131887191 });
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final String getTrainingReminderDescription(int reminderNumber, String dogName) {
        int i;
        int intValue;
        String string;
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            i = 2131887192;
            string = this.e.getString(i);
        }
        n.e(string, "if (dogName.isEmpty()) {\n            applicationContext.getString(R.string.reminder_daily_training_your_dog)\n        } else {\n            dogName\n        }");
        Object obj = p.a0(cancelNotification(), reminderNumber);
        if (obj == null) {
            intValue = (Number)p.j0(cancelNotification()).intValue();
        } else {
            intValue = obj.intValue();
        }
        Object[] arr = new Object[i];
        String string2 = this.e.getString(intValue, new Object[] { string });
        n.e(string2, "applicationContext.getString(\n            trainingMessageResIds.getOrNull(reminderNumber)\n                ?: trainingMessageResIds.last(),\n            tempDogName\n        )");
        return l.r(app.dogo.com.dogo_android.util.extensionfunction.j1.d(isDayCorrect(string2)));
    }

    private final String i() {
        String string = this.e.getString(2131886080);
        n.e(string, "applicationContext.getString(R.string.CFBundleDisplayName)");
        return string;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final boolean cancelTrainingReminderNotificationAlarm(List<Boolean> requestCode) {
        final int i4 = 7;
        return (Boolean)requestCode.get((this.packageManager.f().get(i4) + 5) % i4).booleanValue();
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final Calendar delayReminderNotificationByMinutes(RemindersModel delayMinutes) {
        int i;
        Calendar calendar = this.packageManager.f();
        if (delayMinutes.getTime() == null) {
            str2 = "remindersModel time is null ";
            a.d(new Throwable(n.o(str2, delayMinutes.getId())));
        }
        String time2 = delayMinutes.getTime();
        n.d(time2);
        i = 0;
        Object[] array = new Regex(":").f(time2, i).toArray(new String[i]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Object obj = array[i];
        i = 1;
        i = obj.length() - i;
        int i2 = 32;
        while (i <= i) {
            int r10 = i;
            r10 = i;
            if (i != 0) {
                break;
            }
        }
        calendar.set(11, Integer.parseInt(obj.subSequence(i, i + i).toString()));
        Object obj2 = array[i];
        i = obj2.length() - i;
        while (i <= i) {
            int r8 = i;
            r8 = i;
            if (i != 0) {
                break;
            }
        }
        calendar.set(12, Integer.parseInt(obj2.subSequence(i, i + i).toString()));
        calendar.set(13, i);
        if (calendar.before(this.packageManager.f())) {
            calendar.add(5, i);
        }
        return calendar;
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final String isDayCorrect(String dayFilter) {
        String str;
        boolean z2 = false;
        int length = 2;
        Object obj = null;
        if (l.R(dayFilter, "{", z2, length, obj)) {
            if (l.R(dayFilter, "}", z2, length, obj)) {
                String str6 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(dayFilter, str6);
                String substring2 = dayFilter.substring(l.e0(dayFilter, "{", 0, false, 6, null));
                n.e(substring2, "(this as java.lang.String).substring(startIndex)");
                int i = 1;
                Objects.requireNonNull(substring2, str6);
                String substring = substring2.substring(z2, (l.e0(substring2, "}", 0, false, 6, null)) + i);
                String str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                n.e(substring, str4);
                Objects.requireNonNull(substring, str6);
                String substring3 = substring.substring(i, substring.length() - i);
                n.e(substring3, str4);
                Object[] array = new Regex(",").f(substring3, z2).toArray(new String[z2]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                length = array.length;
                boolean z3 = false;
                int i2 = 4;
                Object obj3 = null;
                str = l.G(dayFilter, substring, array[new Random().nextInt(length)], z3, i2, obj3);
            }
        }
        return str;
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void setupNotificationAlarm(long timeMs, app.dogo.com.dogo_android.k.l repeatFrequency) {
        app.dogo.com.dogo_android.k.l daily2;
        app.dogo.com.dogo_android.k.l temp2;
        final int i = 0;
        int i2 = 1;
        final Object obj = null;
        TrainingReminderNotificationInteractor.c(this, i, i2, obj);
        Class cls = TrainingReminderNotificationInteractor.f;
        this.applicationContext.setComponentEnabledSetting(new ComponentName(this.e, cls), i2, i2);
        Intent intent = new Intent(this.e, cls);
        str = "training_reminder";
        intent.putExtra("reminder_id", str);
        if (repeatFrequency == NotificationRepeating.Temp) {
            intent.putExtra("temp_reminder", true);
        }
        final PendingIntent pendingIntent2 = TrainingReminderNotificationInteractor.f(this, intent, i, 2, obj);
        if (repeatFrequency == NotificationRepeating.Daily || repeatFrequency == NotificationRepeating.Weekly) {
            PendingIntent pendingIntent = 86400000;
            this.notificationService.setRepeating(0, timeMs, pendingIntent, pendingIntent2);
        }
    }

    public final void a() {
        this.alarmManager.b("reminder_id");
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void parseRemindersCalendar(int remindersModel) {
        this.alarmManager.c(this.e, TrainingReminderNotificationInteractor.f, remindersModel);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void parseTrainingMessage(int fullMessage) {
        Calendar calendar = this.packageManager.f();
        final int i = 12;
        calendar.add(i, fullMessage);
        setupNotificationAlarm(calendar.getTimeInMillis(), NotificationRepeating.Temp);
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final void setTrainingReminderNotification(RemindersModel reminder) {
        n.f(reminder, "reminder");
        if (!reminder.isActive()) {
            int i2 = 0;
            int i = 1;
            Object obj = null;
            TrainingReminderNotificationInteractor.c(this, i2, i, obj);
        } else {
            setupNotificationAlarm(delayReminderNotificationByMinutes(reminder).getTimeInMillis(), NotificationRepeating.INSTANCE.getEnum(reminder.getRepeating()));
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final void showTrainingReminderNotification(RemindersModel remindersModel, String dogName) {
        int i2 = 2131231358;
        String string;
        int i3 = 2131887183;
        Object[] arr;
        String str;
        long l = 15;
        net.time4j.h mINUTES2;
        v wIDE2;
        n.f(remindersModel, "remindersModel");
        n.f(dogName, "dogName");
        if (remindersModel.isActive()) {
            if (cancelTrainingReminderNotificationAlarm(remindersModel.getDays())) {
                int nextInt = new Random().nextInt(p.i(cancelNotification()));
                Intent intent = new Intent(this.e, SplashActivity.class);
                intent.putExtra("source", "training_notification");
                intent.putExtra("notification_string_id", nextInt);
                String trainingReminderDescription = getTrainingReminderDescription(nextInt, dogName);
                j.e eVar = this.alarmManager.f(intent, i(), trainingReminderDescription, "reminders_id");
                training2 = NotificationType.Training;
                int i = 0;
                if (n.b(remindersModel.getType(), training2.getTag())) {
                    Intent intent2 = new Intent(this.e, SnoozeAction.class);
                    intent2.putExtra("reminder_id", remindersModel.getId());
                    i2 = 2131231358;
                    i3 = 2131887183;
                    arr = new Object[1];
                    l = 15L;
                    eVar.a(i2, this.e.getString(i3, new Object[] { k0.d(Locale.getDefault()).f(l, h.MINUTES, v.WIDE) }), PendingIntent.getService(this.e, i, intent2, 335544320));
                }
                j.c cVar = new j.c();
                cVar.h(trainingReminderDescription);
                eVar.A(cVar);
                androidx.core.app.m mVar = m.c(this.e);
                n.e(mVar, "from(applicationContext)");
                if (n.b(remindersModel.getType(), NotificationType.Training.getTag())) {
                    mVar.e("training_reminder", i, eVar.c());
                }
            }
        }
    }
}
