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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH'J\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u000f0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J!\u0010\u0012\u001a\u00020\u00082\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0013\"\u00020\nH'¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00032\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0013\"\u00020\nH'¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H'J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "", "clearWorkoutTrickIdListCache", "Lio/reactivex/Completable;", "dogId", "", "createWorkoutEntityIfNeeded", "deleteWorkoutEntity", "", "entity", "Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;", "doesWorkoutEntityExists", "Lio/reactivex/Single;", "", "getCachedWorkoutListOrEmpty", "", "getDogWorkoutInfo", "getDogWorkoutInfoOrEmpty", "insertWorkoutEntity", "", "([Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;)V", "insertWorkoutEntityCompletable", "([Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoEntity;)Lio/reactivex/Completable;", "updateWorkoutTrickIdListCache", "obj", "Lapp/dogo/android/persistencedb/room/entity/WorkoutInfoCacheUpdate;", "workoutTrickIdList", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface s0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static b a(e.a.a.a.b.b.s0 s0, String string2) {
            n.f(s0, "this");
            n.f(string2, "dogId");
            return s0.b(string2, p.g());
        }

        private static b b(e.a.a.a.b.b.s0 s0, String string2) {
            p pVar = new p(s0, string2);
            final b obj2 = s0.h(string2).flatMapCompletable(pVar);
            n.e(obj2, "doesWorkoutEntityExists(dogId).flatMapCompletable {\n            if (!it) insertWorkoutEntityCompletable(WorkoutInfoEntity(dogId)) else Completable.complete()\n        }");
            return obj2;
        }

        private static f c(e.a.a.a.b.b.s0 s0, String string2, Boolean boolean3) {
            int str;
            WorkoutInfoEntity workoutInfoEntity;
            int i2;
            int i;
            b obj4;
            WorkoutInfoEntity[] obj6;
            n.f(s0, "this$0");
            n.f(string2, "$dogId");
            n.f(boolean3, "it");
            if (!boolean3.booleanValue()) {
                obj6 = new WorkoutInfoEntity[1];
                i = 0;
                workoutInfoEntity = new WorkoutInfoEntity(string2, i, 2, i);
                obj4 = s0.c(workoutInfoEntity);
            } else {
                obj4 = b.f();
            }
            return obj4;
        }

        public static a0<List<String>> d(e.a.a.a.b.b.s0 s0, String string2) {
            n.f(s0, "this");
            n.f(string2, "dogId");
            a0 obj1 = s0.e(string2).map(o.a);
            n.e(obj1, "getDogWorkoutInfoOrEmpty(dogId).map { it.cachedWorkoutTrickIdList }");
            return obj1;
        }

        private static List e(WorkoutInfoEntity workoutInfoEntity) {
            n.f(workoutInfoEntity, "it");
            return workoutInfoEntity.getCachedWorkoutTrickIdList();
        }

        public static a0<WorkoutInfoEntity> f(e.a.a.a.b.b.s0 s0, String string2) {
            n.f(s0, "this");
            n.f(string2, "dogId");
            n nVar = new n(string2);
            a0 obj1 = s0.d(string2).onErrorReturn(nVar);
            n.e(obj1, "getDogWorkoutInfo(dogId).onErrorReturn { WorkoutInfoEntity(dogId) }");
            return obj1;
        }

        private static WorkoutInfoEntity g(String string, Throwable throwable2) {
            n.f(string, "$dogId");
            n.f(throwable2, "it");
            int i = 0;
            WorkoutInfoEntity obj3 = new WorkoutInfoEntity(string, i, 2, i);
            return obj3;
        }

        public static WorkoutInfoEntity h(String string, Throwable throwable2) {
            return s0.a.g(string, throwable2);
        }

        public static List i(WorkoutInfoEntity workoutInfoEntity) {
            return s0.a.e(workoutInfoEntity);
        }

        public static f j(e.a.a.a.b.b.s0 s0, String string2, Boolean boolean3) {
            return s0.a.c(s0, string2, boolean3);
        }

        public static b k(e.a.a.a.b.b.s0 s0, String string2, List<String> list3) {
            n.f(s0, "this");
            n.f(string2, "dogId");
            n.f(list3, "workoutTrickIdList");
            WorkoutInfoCacheUpdate workoutInfoCacheUpdate = new WorkoutInfoCacheUpdate(string2, list3);
            b obj2 = s0.a.b(s0, string2).c(s0.a(workoutInfoCacheUpdate));
            n.e(obj2, "createWorkoutEntityIfNeeded(dogId).andThen(\n            updateWorkoutTrickIdListCache(WorkoutInfoCacheUpdate(dogId, workoutTrickIdList))\n        )");
            return obj2;
        }
    }
    public abstract b a(WorkoutInfoCacheUpdate workoutInfoCacheUpdate);

    public abstract b b(String string, List<String> list2);

    public abstract b c(WorkoutInfoEntity... workoutInfoEntityArr);

    public abstract a0<WorkoutInfoEntity> d(String string);

    public abstract a0<WorkoutInfoEntity> e(String string);

    public abstract a0<List<String>> f(String string);

    public abstract b g(String string);

    public abstract a0<Boolean> h(String string);
}
