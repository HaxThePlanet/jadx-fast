package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity;
import app.dogo.com.dogo_android.s.b.p1;
import e.a.a.a.b.b.s0;
import e.a.a.a.b.b.w;
import i.b.a0;
import i.b.g0;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "shouldShowWorkoutUnlocked", "Lio/reactivex/Single;", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l3 {

    private final s0 a;
    private final w b;
    private final p1 c;
    public l3(s0 s0, w w2, p1 p13) {
        n.f(s0, "workoutEntityDao");
        n.f(w2, "dogLocalEntityDao");
        n.f(p13, "userRepository");
        super();
        this.a = s0;
        this.b = w2;
        this.c = p13;
    }

    public static g0 a(app.dogo.com.dogo_android.s.a.l3 l3, String string2) {
        return l3.e(l3, string2);
    }

    public static Boolean b(WorkoutInfoEntity workoutInfoEntity, DogLocalEntity dogLocalEntity2) {
        return l3.g(workoutInfoEntity, dogLocalEntity2);
    }

    public static g0 c(app.dogo.com.dogo_android.s.a.l3 l3, String string2, WorkoutInfoEntity workoutInfoEntity3) {
        return l3.f(l3, string2, workoutInfoEntity3);
    }

    private static final g0 e(app.dogo.com.dogo_android.s.a.l3 l3, String string2) {
        n.f(l3, "this$0");
        n.f(string2, "dogId");
        m0 m0Var = new m0(l3, string2);
        return l3.a.e(string2).flatMap(m0Var);
    }

    private static final g0 f(app.dogo.com.dogo_android.s.a.l3 l3, String string2, WorkoutInfoEntity workoutInfoEntity3) {
        n.f(l3, "this$0");
        n.f(string2, "$dogId");
        n.f(workoutInfoEntity3, "workoutInfo");
        l0 obj2 = new l0(workoutInfoEntity3);
        return l3.b.i(string2).map(obj2);
    }

    private static final Boolean g(WorkoutInfoEntity workoutInfoEntity, DogLocalEntity dogLocalEntity2) {
        int i;
        int obj1;
        n.f(workoutInfoEntity, "$workoutInfo");
        n.f(dogLocalEntity2, "dogLocalEntity");
        if (obj1 ^= i != 0 && !dogLocalEntity2.getWorkoutUnlockScreenShown()) {
            if (!dogLocalEntity2.getWorkoutUnlockScreenShown()) {
            } else {
                i = 0;
            }
        } else {
        }
        return Boolean.valueOf(i);
    }

    public final a0<Boolean> d() {
        k0 k0Var = new k0(this);
        a0 flatMap = this.c.v().flatMap(k0Var);
        n.e(flatMap, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            workoutEntityDao.getDogWorkoutInfoOrEmpty(dogId).flatMap { workoutInfo ->\n                dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).map { dogLocalEntity ->\n                    workoutInfo.cachedWorkoutTrickIdList.isNotEmpty() && !dogLocalEntity.workoutUnlockScreenShown\n                }\n            }\n        }");
        return flatMap;
    }
}
