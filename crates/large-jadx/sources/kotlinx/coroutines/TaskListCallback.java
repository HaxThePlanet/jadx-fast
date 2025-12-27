package app.dogo.com.dogo_android.y.c0;

import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import kotlin.Metadata;

/* compiled from: TaskListCallback.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/TaskListCallback;", "", "onTaskCompleted", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "onTasksCompletedButtonClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public interface TaskListCallback {
    /* renamed from: j1, reason: from kotlin metadata */
    void onTasksCompletedButtonClick();

    /* renamed from: y, reason: from kotlin metadata */
    void onTaskCompleted(ProgramTasks item);
}
