package androidx.core.app;

import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import androidx.annotation.ReplaceWith;

/* loaded from: classes5.dex */
public final class AlarmManagerCompat {

    static class Api21Impl {
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long triggerTime, PendingIntent showIntent) {
            AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(triggerTime, showIntent, obj3);
            return alarmClockInfo;
        }

        static void setAlarmClock(AlarmManager alarmManager, Object info, PendingIntent operation) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)info, operation);
        }
    }

    static class Api23Impl {
        static void setAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setAndAllowWhileIdle(type, triggerAtMillis, operation);
        }

        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setExactAndAllowWhileIdle(type, triggerAtMillis, operation);
        }
    }

    static class Api31Impl {
        static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }
    public static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AlarmManagerCompat.Api31Impl.canScheduleExactAlarms(alarmManager);
        }
        return 1;
    }

    public static void setAlarmClock(AlarmManager alarmManager, long triggerTime, PendingIntent showIntent, PendingIntent operation) {
        AlarmManagerCompat.Api21Impl.setAlarmClock(alarmManager, AlarmManagerCompat.Api21Impl.createAlarmClockInfo(triggerTime, showIntent), obj5);
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
        AlarmManagerCompat.Api23Impl.setAndAllowWhileIdle(alarmManager, type, triggerAtMillis, operation);
    }

    @ReplaceWith(expression = "alarmManager.setExact(type, triggerAtMillis, operation)")
    @Deprecated
    public static void setExact(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
        alarmManager.setExact(type, triggerAtMillis, operation);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
        AlarmManagerCompat.Api23Impl.setExactAndAllowWhileIdle(alarmManager, type, triggerAtMillis, operation);
    }
}
