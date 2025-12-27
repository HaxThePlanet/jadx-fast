package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.WorkoutInfoCacheUpdate;
import app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity;
import i.b.a0;
import i.b.b;
import i.b.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: WorkoutEntityDao.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH'J\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u000f0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J!\u0010\u0012\u001a\u00020\u00082\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0013\"\u00020\nH'¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00032\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0013\"\u00020\nH'¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H'J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "", "clearWorkoutTrickIdListCache", "Lio/reactivex/Completable;", "dogId", "", "createWorkoutEntityIfNeeded", "deleteWorkoutEntity", "", "entity", "Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;", "doesWorkoutEntityExists", "Lio/reactivex/Single;", "", "getCachedWorkoutListOrEmpty", "", "getDogWorkoutInfo", "getDogWorkoutInfoOrEmpty", "insertWorkoutEntity", "", "([Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;)V", "insertWorkoutEntityCompletable", "([Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;)Lio/reactivex/Completable;", "updateWorkoutTrickIdListCache", "obj", "Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoCacheUpdate;", "workoutTrickIdList", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s0, reason: from kotlin metadata */
public interface WorkoutEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(s0 s0Var, String str) {
            n.f(s0Var, "this");
            n.f(str, "dogId");
            return s0Var.updateWorkoutTrickIdListCache(str, p.g());
        }

        private static b b(s0 s0Var, String str) {
            final b flatMapCompletable = s0Var.getDogWorkoutInfoOrEmpty(str).flatMapCompletable(new app.dogo.android.persistencedb.room.dao.p(s0Var, str));
            n.e(flatMapCompletable, "doesWorkoutEntityExists(dogId).flatMapCompletable {\n            if (!it) insertWorkoutEntityCompletable(WorkoutInfoEntity(dogId)) else Completable.complete()\n        }");
            return flatMapCompletable;
        }

        private static f c(s0 s0Var, String str, Boolean boolean) {
            b workoutEntityIfNeeded;
            n.f(s0Var, "this$0");
            n.f(str, "$dogId");
            n.f(boolean, "it");
            if (!boolean.booleanValue()) {
                WorkoutInfoEntity[] arr = new WorkoutInfoEntity[1];
                int i = 0;
                int i2 = 2;
                List list = null;
                arr[i] = new WorkoutInfoEntity(str, list, i2, list);
                workoutEntityIfNeeded = s0Var.createWorkoutEntityIfNeeded(arr);
            } else {
                workoutEntityIfNeeded = b.f();
            }
            return workoutEntityIfNeeded;
        }

        public static a0<List<String>> d(s0 s0Var, String str) {
            n.f(s0Var, "this");
            n.f(str, "dogId");
            a0 map = s0Var.doesWorkoutEntityExists(str).map(app.dogo.android.persistencedb.room.dao.o.a);
            n.e(map, "getDogWorkoutInfoOrEmpty(dogId).map { it.cachedWorkoutTrickIdList }");
            return map;
        }

        private static List e(WorkoutInfoEntity workoutInfoEntity) {
            n.f(workoutInfoEntity, "it");
            return workoutInfoEntity.getCachedWorkoutTrickIdList();
        }

        public static a0<WorkoutInfoEntity> f(s0 s0Var, String str) {
            n.f(s0Var, "this");
            n.f(str, "dogId");
            a0 onErrorReturn = s0Var.deleteWorkoutEntity(str).onErrorReturn(new app.dogo.android.persistencedb.room.dao.n(str));
            n.e(onErrorReturn, "getDogWorkoutInfo(dogId).onErrorReturn { WorkoutInfoEntity(dogId) }");
            return onErrorReturn;
        }

        private static WorkoutInfoEntity g(String str, Throwable th) {
            n.f(str, "$dogId");
            n.f(th, "it");
            List list = null;
            return new WorkoutInfoEntity(str, list, 2, list);
        }

        public static b k(s0 s0Var, String str, List<String> list) {
            n.f(s0Var, "this");
            n.f(str, "dogId");
            n.f(list, "workoutTrickIdList");
            b bVar2 = app.dogo.android.persistencedb.room.dao.s0.a.b(s0Var, str).c(s0Var.clearWorkoutTrickIdListCache(new WorkoutInfoCacheUpdate(str, list)));
            n.e(bVar2, "createWorkoutEntityIfNeeded(dogId).andThen(\n            updateWorkoutTrickIdListCache(WorkoutInfoCacheUpdate(dogId, workoutTrickIdList))\n        )");
            return bVar2;
        }

        public static /* synthetic */ WorkoutInfoEntity h(String str, Throwable th) {
            return app.dogo.android.persistencedb.room.dao.s0.a.g(str, th);
        }

        public static /* synthetic */ List i(WorkoutInfoEntity workoutInfoEntity) {
            return app.dogo.android.persistencedb.room.dao.s0.a.e(workoutInfoEntity);
        }

        public static /* synthetic */ f j(s0 s0Var, String str, Boolean boolean) {
            return app.dogo.android.persistencedb.room.dao.s0.a.c(s0Var, str, boolean);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    b clearWorkoutTrickIdListCache(WorkoutInfoCacheUpdate dogId);

    /* renamed from: b, reason: from kotlin metadata */
    b updateWorkoutTrickIdListCache(String dogId, List<String> workoutTrickIdList);

    /* renamed from: c, reason: from kotlin metadata */
    b createWorkoutEntityIfNeeded(WorkoutInfoEntity... dogId);

    /* renamed from: d, reason: from kotlin metadata */
    a0<WorkoutInfoEntity> deleteWorkoutEntity(String entity);

    /* renamed from: e, reason: from kotlin metadata */
    a0<WorkoutInfoEntity> doesWorkoutEntityExists(String dogId);

    /* renamed from: f, reason: from kotlin metadata */
    a0<List<String>> getCachedWorkoutListOrEmpty(String dogId);

    /* renamed from: g, reason: from kotlin metadata */
    b getDogWorkoutInfo(String dogId);

    /* renamed from: h, reason: from kotlin metadata */
    a0<Boolean> getDogWorkoutInfoOrEmpty(String dogId);
}
