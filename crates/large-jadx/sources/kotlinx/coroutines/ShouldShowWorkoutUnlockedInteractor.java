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

/* compiled from: ShouldShowWorkoutUnlockedInteractor.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "shouldShowWorkoutUnlocked", "Lio/reactivex/Single;", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l3, reason: from kotlin metadata */
public final class ShouldShowWorkoutUnlockedInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final s0 dogLocalEntityDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final w userRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final p1 workoutEntityDao;
    public l3(s0 s0Var, w wVar, p1 p1Var) {
        n.f(s0Var, "workoutEntityDao");
        n.f(wVar, "dogLocalEntityDao");
        n.f(p1Var, "userRepository");
        super();
        this.dogLocalEntityDao = s0Var;
        this.userRepository = wVar;
        this.workoutEntityDao = p1Var;
    }

    private static final g0 e(l3 l3Var, String str) {
        n.f(l3Var, "this$0");
        n.f(str, "dogId");
        return l3Var.dogLocalEntityDao.doesWorkoutEntityExists(str).flatMap(new kotlinx.coroutines.m0(l3Var, str));
    }

    private static final g0 f(l3 l3Var, String str, WorkoutInfoEntity workoutInfoEntity) {
        n.f(l3Var, "this$0");
        n.f(str, "$dogId");
        n.f(workoutInfoEntity, "workoutInfo");
        return l3Var.userRepository.getWorkoutUnlockSourceOrEmpty(str).map(new kotlinx.coroutines.l0(workoutInfoEntity));
    }

    private static final Boolean g(WorkoutInfoEntity workoutInfoEntity, DogLocalEntity dogLocalEntity) {
        boolean z = false;
        int i;
        n.f(workoutInfoEntity, "$workoutInfo");
        n.f(dogLocalEntity, "dogLocalEntity");
        i = workoutInfoEntity.getCachedWorkoutTrickIdList().isEmpty() ^ 1;
        if (!workoutInfoEntity.getCachedWorkoutTrickIdList().isEmpty() ^ 1 || dogLocalEntity.getWorkoutUnlockScreenShown()) {
            int i3 = 0;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final a0<Boolean> shouldShowWorkoutUnlocked() {
        a0 flatMapped = this.workoutEntityDao.v().flatMap(new kotlinx.coroutines.k0(this));
        n.e(flatMapped, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            workoutEntityDao.getDogWorkoutInfoOrEmpty(dogId).flatMap { workoutInfo ->\n                dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).map { dogLocalEntity ->\n                    workoutInfo.cachedWorkoutTrickIdList.isNotEmpty() && !dogLocalEntity.workoutUnlockScreenShown\n                }\n            }\n        }");
        return flatMapped;
    }

    public static /* synthetic */ g0 a(l3 l3Var, String str) {
        return ShouldShowWorkoutUnlockedInteractor.e(l3Var, str);
    }

    public static /* synthetic */ Boolean b(WorkoutInfoEntity workoutInfoEntity, DogLocalEntity dogLocalEntity) {
        return ShouldShowWorkoutUnlockedInteractor.g(workoutInfoEntity, dogLocalEntity);
    }

    public static /* synthetic */ g0 c(l3 l3Var, String str, WorkoutInfoEntity workoutInfoEntity) {
        return ShouldShowWorkoutUnlockedInteractor.f(l3Var, str, workoutInfoEntity);
    }
}
