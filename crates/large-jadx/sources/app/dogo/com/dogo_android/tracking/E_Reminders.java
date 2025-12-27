package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Reminders;", "", "()V", "ActivateReminder", "Lapp/dogo/com/dogo_android/tracking/Event0;", "DeactivateReminder", "ReminderNotNowPressed", "ReminderYesPressed", "SetReminder", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$Time;", "Lapp/dogo/com/dogo_android/tracking/EP$Day;", "SetReminderInDogCreation", "SnoozeAlarm", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k0, reason: from kotlin metadata */
public final class E_Reminders {

    public static final t2 a;
    public static final v2<l2, g1> b;
    public static final t2 c;
    public static final t2 d;
    public static final t2 e;
    static {
        final app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Reminders.a = companion2.a("alarm_pressed_snooze");
        E_Reminders.b = companion2.a("set_training_reminders").c(new EP_Time(), new EP_Day());
        companion2.a("reminder_set_in_dog_creation");
        E_Reminders.c = companion2.a("reminder_activated");
        E_Reminders.d = companion2.a("reminder_deactivated");
        E_Reminders.e = companion2.a("enable_training_reminders_yes_tapped");
        companion2.a("enable_training_reminders_no_tapped");
    }
}
