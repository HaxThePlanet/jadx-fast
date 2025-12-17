package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate;
import i.b.a0;
import i.b.b;
import i.b.f;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J!\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0011\"\u00020\nH'¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0011\"\u00020\nH'¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH'J(\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0008H'J \u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u0005H'¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "", "createDogLocalEntityIfNeeded", "Lio/reactivex/Completable;", "dogId", "", "doesDogLocalEntityExists", "Lio/reactivex/Single;", "", "getDogLocalEntity", "Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;", "getDogLocalEntityOrEmpty", "getWorkoutUnlockSource", "getWorkoutUnlockSourceOrEmpty", "insert", "", "entity", "", "([Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;)V", "insertCompletable", "([Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;)Lio/reactivex/Completable;", "resetDogStreakInfo", "longestStreak", "", "setWorkoutUnlockScreenShown", "setWorkoutUnlocked", "source", "updateDogStreakInfo", "obj", "Lapp/dogo/android/persistencedb/room/entity/DogLocalStreakInfoUpdate;", "currentStreak", "timestamp", "", "updateWorkoutUnlockScreenShown", "workoutUnlockScreenShown", "updateWorkoutUnlocked", "workoutUnlocked", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface w {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private static b a(e.a.a.a.b.b.w w, String string2) {
            e eVar = new e(w, string2);
            final b obj2 = w.h(string2).flatMapCompletable(eVar);
            n.e(obj2, "doesDogLocalEntityExists(dogId).flatMapCompletable {\n            if (!it) insertCompletable(DogLocalEntity(dogId)) else Completable.complete()\n        }");
            return obj2;
        }

        private static f b(e.a.a.a.b.b.w w, String string2, Boolean boolean3) {
            int str;
            DogLocalEntity dogLocalEntity2;
            Object obj;
            int i4;
            int i5;
            int i6;
            int i;
            int i2;
            int i8;
            int i7;
            int i3;
            DogLocalEntity dogLocalEntity;
            b obj13;
            DogLocalEntity[] obj15;
            n.f(w, "this$0");
            n.f(string2, "$dogId");
            n.f(boolean3, "it");
            if (!boolean3.booleanValue()) {
                obj15 = new DogLocalEntity[1];
                super(string2, 0, 0, 0, 0, 0, 0, obj9, 126, 0);
                obj13 = w.l(dogLocalEntity);
            } else {
                obj13 = b.f();
            }
            return obj13;
        }

        public static a0<DogLocalEntity> c(e.a.a.a.b.b.w w, String string2) {
            n.f(w, "this");
            n.f(string2, "dogId");
            f fVar = new f(string2);
            a0 obj1 = w.k(string2).onErrorReturn(fVar);
            n.e(obj1, "getDogLocalEntity(dogId).onErrorReturn { DogLocalEntity(dogId) }");
            return obj1;
        }

        private static DogLocalEntity d(String string, Throwable throwable2) {
            n.f(string, "$dogId");
            n.f(throwable2, "it");
            super(string, 0, 0, 0, 0, 0, 0, obj9, 126, 0);
            return obj13;
        }

        public static a0<String> e(e.a.a.a.b.b.w w, String string2) {
            n.f(w, "this");
            n.f(string2, "dogId");
            a0 obj1 = w.a.a(w, string2).d(w.e(string2));
            n.e(obj1, "createDogLocalEntityIfNeeded(dogId).andThen(\n            getWorkoutUnlockSource(dogId)\n        )");
            return obj1;
        }

        public static f f(e.a.a.a.b.b.w w, String string2, Boolean boolean3) {
            return w.a.b(w, string2, boolean3);
        }

        public static DogLocalEntity g(String string, Throwable throwable2) {
            return w.a.d(string, throwable2);
        }

        public static void h(e.a.a.a.b.b.w w, String string2, int i3) {
            n.f(w, "this");
            n.f(string2, "dogId");
            super(string2, i3, 0, 0, obj6);
            w.b(dogLocalStreakInfoUpdate);
        }

        public static b i(e.a.a.a.b.b.w w, String string2) {
            n.f(w, "this");
            n.f(string2, "dogId");
            b obj2 = w.a.a(w, string2).c(w.m(string2, true));
            n.e(obj2, "createDogLocalEntityIfNeeded(dogId).andThen(\n            updateWorkoutUnlockScreenShown(dogId, true)\n        )");
            return obj2;
        }

        public static b j(e.a.a.a.b.b.w w, String string2, String string3) {
            n.f(w, "this");
            n.f(string2, "dogId");
            n.f(string3, "source");
            b obj2 = w.a.a(w, string2).c(w.d(string2, true, string3));
            n.e(obj2, "createDogLocalEntityIfNeeded(dogId).andThen(\n            updateWorkoutUnlocked(dogId, true, source)\n        )");
            return obj2;
        }

        public static void k(e.a.a.a.b.b.w w, String string2, int i3, int i4, long l5) {
            n.f(w, "this");
            n.f(string2, "dogId");
            super(string2, i3, i4, l5, obj6);
            w.b(dogLocalStreakInfoUpdate);
        }
    }
    public abstract b a(String string, String string2);

    public abstract void b(DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate);

    public abstract b c(String string);

    public abstract b d(String string, boolean z2, String string3);

    public abstract a0<String> e(String string);

    public abstract void f(String string, int i2, int i3, long l4);

    public abstract a0<String> g(String string);

    public abstract a0<Boolean> h(String string);

    public abstract a0<DogLocalEntity> i(String string);

    public abstract void j(String string, int i2);

    public abstract a0<DogLocalEntity> k(String string);

    public abstract b l(DogLocalEntity... dogLocalEntityArr);

    public abstract b m(String string, boolean z2);
}
