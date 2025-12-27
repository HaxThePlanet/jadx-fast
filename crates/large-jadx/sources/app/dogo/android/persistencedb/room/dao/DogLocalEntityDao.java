package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate;
import i.b.a0;
import i.b.b;
import i.b.f;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogLocalEntityDao.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J!\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0011\"\u00020\nH'¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0011\"\u00020\nH'¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH'J(\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0008H'J \u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u0005H'¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "", "createDogLocalEntityIfNeeded", "Lio/reactivex/Completable;", "dogId", "", "doesDogLocalEntityExists", "Lio/reactivex/Single;", "", "getDogLocalEntity", "Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;", "getDogLocalEntityOrEmpty", "getWorkoutUnlockSource", "getWorkoutUnlockSourceOrEmpty", "insert", "", "entity", "", "([Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;)V", "insertCompletable", "([Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;)Lio/reactivex/Completable;", "resetDogStreakInfo", "longestStreak", "", "setWorkoutUnlockScreenShown", "setWorkoutUnlocked", "source", "updateDogStreakInfo", "obj", "Lapp/dogo/android/persistencedb/room/entity/DogLocalStreakInfoUpdate;", "currentStreak", "timestamp", "", "updateWorkoutUnlockScreenShown", "workoutUnlockScreenShown", "updateWorkoutUnlocked", "workoutUnlocked", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public interface DogLocalEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private static b a(w wVar, String str) {
            final b flatMapCompletable = wVar.getWorkoutUnlockSource(str).flatMapCompletable(new app.dogo.android.persistencedb.room.dao.e(wVar, str));
            n.e(flatMapCompletable, "doesDogLocalEntityExists(dogId).flatMapCompletable {\n            if (!it) insertCompletable(DogLocalEntity(dogId)) else Completable.complete()\n        }");
            return flatMapCompletable;
        }

        private static f b(w wVar, String str, Boolean boolean) {
            b completable;
            n.f(wVar, "this$0");
            n.f(str, "$dogId");
            n.f(boolean, "it");
            if (!boolean.booleanValue()) {
                DogLocalEntity[] arr = new DogLocalEntity[1];
                int i = 0;
                boolean z = false;
                str = null;
                boolean z2 = false;
                int i2 = 0;
                int i3 = 0;
                long l = 0L;
                kotlin.d0.d.g gVar = 126;
                int i4 = 0;
                DogLocalEntity dogLocalEntity = new DogLocalEntity(str, z, str, z2, i2, i3, l, i5, gVar, i4);
                arr[i] = dogLocalEntity;
                completable = wVar.insertCompletable(arr);
            } else {
                completable = b.f();
            }
            return completable;
        }

        public static a0<DogLocalEntity> c(w wVar, String str) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            a0 onErrorReturn = wVar.insert(str).onErrorReturn(new app.dogo.android.persistencedb.room.dao.f(str));
            n.e(onErrorReturn, "getDogLocalEntity(dogId).onErrorReturn { DogLocalEntity(dogId) }");
            return onErrorReturn;
        }

        private static DogLocalEntity d(String str, Throwable th) {
            n.f(str, "$dogId");
            n.f(th, "it");
            DogLocalEntity th22 = new DogLocalEntity(str, false, null, false, 0, 0, 0L, i7, 126, 0);
            return th22;
        }

        public static a0<String> e(w wVar, String str) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            a0 a0Var = app.dogo.android.persistencedb.room.dao.w.a.a(wVar, str).d(wVar.getDogLocalEntity(str));
            n.e(a0Var, "createDogLocalEntityIfNeeded(dogId).andThen(\n            getWorkoutUnlockSource(dogId)\n        )");
            return a0Var;
        }

        public static void h(w wVar, String str, int i) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate = new DogLocalStreakInfoUpdate(str, i, 0, 0L, obj);
            wVar.createDogLocalEntityIfNeeded(dogLocalStreakInfoUpdate);
        }

        public static b i(w wVar, String str) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            b bVar2 = app.dogo.android.persistencedb.room.dao.w.a.a(wVar, str).c(wVar.updateWorkoutUnlockScreenShown(str, true));
            n.e(bVar2, "createDogLocalEntityIfNeeded(dogId).andThen(\n            updateWorkoutUnlockScreenShown(dogId, true)\n        )");
            return bVar2;
        }

        public static b j(w wVar, String str, String str2) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            n.f(str2, "source");
            b bVar2 = app.dogo.android.persistencedb.room.dao.w.a.a(wVar, str).c(wVar.updateWorkoutUnlocked(str, true, str2));
            n.e(bVar2, "createDogLocalEntityIfNeeded(dogId).andThen(\n            updateWorkoutUnlocked(dogId, true, source)\n        )");
            return bVar2;
        }

        public static void k(w wVar, String str, int i, int i2, long j) {
            n.f(wVar, "this");
            n.f(str, "dogId");
            DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate = new DogLocalStreakInfoUpdate(str, i, i2, j, obj);
            wVar.createDogLocalEntityIfNeeded(dogLocalStreakInfoUpdate);
        }

        public static /* synthetic */ f f(w wVar, String str, Boolean boolean) {
            return app.dogo.android.persistencedb.room.dao.w.a.b(wVar, str, boolean);
        }

        public static /* synthetic */ DogLocalEntity g(String str, Throwable th) {
            return app.dogo.android.persistencedb.room.dao.w.a.d(str, th);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    b resetDogStreakInfo(String dogId, String longestStreak);

    /* renamed from: b, reason: from kotlin metadata */
    void createDogLocalEntityIfNeeded(DogLocalStreakInfoUpdate dogId);

    /* renamed from: c, reason: from kotlin metadata */
    b doesDogLocalEntityExists(String dogId);

    /* renamed from: d, reason: from kotlin metadata */
    b updateWorkoutUnlocked(String dogId, boolean workoutUnlocked, String source);

    /* renamed from: e, reason: from kotlin metadata */
    a0<String> getDogLocalEntity(String dogId);

    /* renamed from: f, reason: from kotlin metadata */
    void updateDogStreakInfo(String dogId, int longestStreak, int currentStreak, long timestamp);

    /* renamed from: g, reason: from kotlin metadata */
    a0<String> getDogLocalEntityOrEmpty(String dogId);

    /* renamed from: h, reason: from kotlin metadata */
    a0<Boolean> getWorkoutUnlockSource(String dogId);

    /* renamed from: i, reason: from kotlin metadata */
    a0<DogLocalEntity> getWorkoutUnlockSourceOrEmpty(String dogId);

    /* renamed from: j, reason: from kotlin metadata */
    void setWorkoutUnlocked(String dogId, int source);

    /* renamed from: k, reason: from kotlin metadata */
    a0<DogLocalEntity> insert(String entity);

    /* renamed from: l, reason: from kotlin metadata */
    b insertCompletable(DogLocalEntity... entity);

    /* renamed from: m, reason: from kotlin metadata */
    b updateWorkoutUnlockScreenShown(String dogId, boolean workoutUnlockScreenShown);
}
