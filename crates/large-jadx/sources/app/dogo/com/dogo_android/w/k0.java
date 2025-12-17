package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Reminders;", "", "()V", "ActivateReminder", "Lapp/dogo/com/dogo_android/tracking/Event0;", "DeactivateReminder", "ReminderNotNowPressed", "ReminderYesPressed", "SetReminder", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$Time;", "Lapp/dogo/com/dogo_android/tracking/EP$Day;", "SetReminderInDogCreation", "SnoozeAlarm", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k0 {

    public static final app.dogo.com.dogo_android.w.t2 a;
    public static final app.dogo.com.dogo_android.w.v2<app.dogo.com.dogo_android.w.l2, app.dogo.com.dogo_android.w.g1> b;
    public static final app.dogo.com.dogo_android.w.t2 c;
    public static final app.dogo.com.dogo_android.w.t2 d;
    public static final app.dogo.com.dogo_android.w.t2 e;
    static {
        final app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        k0.a = companion.a("alarm_pressed_snooze");
        l2 l2Var = new l2();
        g1 g1Var = new g1();
        k0.b = companion.a("set_training_reminders").c(l2Var, g1Var);
        companion.a("reminder_set_in_dog_creation");
        k0.c = companion.a("reminder_activated");
        k0.d = companion.a("reminder_deactivated");
        k0.e = companion.a("enable_training_reminders_yes_tapped");
        companion.a("enable_training_reminders_no_tapped");
    }
}
