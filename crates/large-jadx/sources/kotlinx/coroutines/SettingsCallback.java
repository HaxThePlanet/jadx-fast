package app.dogo.com.dogo_android.t;

import app.dogo.com.dogo_android.model.RemindersModel;
import kotlin.Metadata;

/* compiled from: SettingsCallback.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/SettingsCallback;", "", "toggleTrainingReminder", "", "remindersModel", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "trainingReminderRetry", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b0, reason: from kotlin metadata */
public interface SettingsCallback {
    /* renamed from: N0, reason: from kotlin metadata */
    void trainingReminderRetry();

    /* renamed from: W, reason: from kotlin metadata */
    void toggleTrainingReminder(RemindersModel remindersModel);
}
