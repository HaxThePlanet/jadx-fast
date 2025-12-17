package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.TaskEntity;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\t0\u0008H'J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000cJ%\u0010\r\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "", "deleteTask", "", "task", "Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTasks", "Lio/reactivex/Single;", "", "getLatestTaskTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTask", "", "([Lapp/dogo/android/persistencedb/room/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface i0 {
    public abstract Object a(TaskEntity[] taskEntityArr, d<? super w> d2);

    public abstract Object b(d<? super Long> d);
}
