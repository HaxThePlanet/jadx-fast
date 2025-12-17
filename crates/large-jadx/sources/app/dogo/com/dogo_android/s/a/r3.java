package app.dogo.com.dogo_android.s.a;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.DogLocalEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession.Companion;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest;
import app.dogo.externalmodel.model.responses.DogWorkoutResponse;
import app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutStreak;
import app.dogo.externalmodel.model.responses.DogWorkoutResponse.WorkoutTrickModel;
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.s0;
import e.a.a.a.b.b.w;
import e.a.a.a.b.d.g;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.g0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018J*\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u0019H\u0002J\u0016\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010$\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eJ\"\u0010)\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010*\u001a\u0004\u0018\u00010#H\u0002J\u0006\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "fetchRemoteWorkoutTrickEventListAndUpdateCache", "Lio/reactivex/Single;", "", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "dogId", "", "fetchWorkoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "getCachedWorkoutTrickModelList", "trickList", "getWorkoutSession", "getWorkoutStreakModel", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "getWorkoutTrickModelList", "isWorkoutUnlockScreenShown", "", "resetStreakIfNeededAndSetStreakIncreaseFlag", "workoutSession", "updateDogWorkoutStreak", "unsyncedStreak", "updateWorkoutCacheIfUnlockedAndUnlockScreenNotYetShown", "Lio/reactivex/Completable;", "updateWorkoutStreak", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r3 {

    private final o1 a;
    private final r2 b;
    private final DogoApiClient c;
    private final p1 d;
    private final s0 e;
    private final o0 f;
    private final w g;
    private final v2 h;
    private final o3 i;
    private final p2 j;
    public r3(o1 o1, r2 r22, DogoApiClient dogoApiClient3, p1 p14, s0 s05, o0 o06, w w7, v2 v28, o3 o39, p2 p210) {
        n.f(o1, "tricksRepository");
        n.f(r22, "remoteConfigService");
        n.f(dogoApiClient3, "apiClient");
        n.f(p14, "userRepository");
        n.f(s05, "workoutEntityDao");
        n.f(o06, "trickKnowledgeDao");
        n.f(w7, "dogLocalEntityDao");
        n.f(v28, "utilities");
        n.f(o39, "tracker");
        n.f(p210, "preferenceService");
        super();
        this.a = o1;
        this.b = r22;
        this.c = dogoApiClient3;
        this.d = p14;
        this.e = s05;
        this.f = o06;
        this.g = w7;
        this.h = v28;
        this.i = o39;
        this.j = p210;
    }

    public static List A(List list, List list2) {
        return r3.h(list, list2);
    }

    public static f B(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.s.a.r3 r33, String string4, List list5) {
        return r3.S(boolean, boolean2, r33, string4, list5);
    }

    public static f C(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3, Boolean boolean4) {
        return r3.R(r3, string2, boolean3, boolean4);
    }

    public static g0 D(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogWorkoutResponse dogWorkoutResponse3) {
        return r3.b(r3, string2, dogWorkoutResponse3);
    }

    public static g0 E(app.dogo.com.dogo_android.s.a.r3 r3, List list2, String string3, WorkoutStreakInfo workoutStreakInfo4) {
        return r3.k(r3, list2, string3, workoutStreakInfo4);
    }

    public static WorkoutStreakInfo F(WorkoutStreakInfo workoutStreakInfo, app.dogo.com.dogo_android.s.a.r3 r32, String string3, DogWorkoutResponse dogWorkoutResponse4) {
        return r3.N(workoutStreakInfo, r32, string3, dogWorkoutResponse4);
    }

    public static g0 G(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3) {
        return r3.f(r3, string2, boolean3);
    }

    public static Boolean H(DogLocalEntity dogLocalEntity) {
        return r3.s(dogLocalEntity);
    }

    public static WorkoutStreakInfo I(DogLocalEntity dogLocalEntity, DogWorkoutResponse dogWorkoutResponse2) {
        return r3.o(dogLocalEntity, dogWorkoutResponse2);
    }

    public static f J(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3) {
        return r3.Q(r3, string2, boolean3);
    }

    public static g0 K(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogLocalEntity dogLocalEntity3) {
        return r3.n(r3, string2, dogLocalEntity3);
    }

    private final a0<WorkoutStreakInfo> M(String string, WorkoutStreakInfo workoutStreakInfo2) {
        a0 dogWorkoutStreakSingle;
        DogoApiClient client;
        Integer valueOf2;
        Long valueOf;
        if (workoutStreakInfo2 != null) {
            DogWorkoutCompletedRequest dogWorkoutCompletedRequest = new DogWorkoutCompletedRequest(Integer.valueOf(workoutStreakInfo2.getCurrentStreak()), Integer.valueOf(workoutStreakInfo2.getLongestStreak()), Long.valueOf(workoutStreakInfo2.getLastAchievedStreakTimestampMs()));
            dogWorkoutStreakSingle = this.c.updateDogWorkoutStreakSingle(string, dogWorkoutCompletedRequest);
        } else {
            dogWorkoutStreakSingle = this.c.updateDogWorkoutStreakSingle(string);
        }
        l1 l1Var = new l1(workoutStreakInfo2, this, string);
        final a0 obj6 = dogWorkoutStreakSingle.map(l1Var);
        n.e(obj6, "responseSingle.map {\n            if (unsyncedStreak != null) {\n                preferenceService.setDogWorkoutStreakSynced(dogId)\n            }\n            val streakInfo = WorkoutStreakInfo(\n                currentStreak = it.streak.currentStreakCount,\n                longestStreak = it.streak.longestStreakCount,\n                lastAchievedStreakTimestampMs = utilities.currentTimeInMillis\n            )\n            dogLocalEntityDao.updateDogStreakInfo(\n                dogId,\n                streakInfo.longestStreak,\n                streakInfo.currentStreak,\n                streakInfo.lastAchievedStreakTimestampMs\n            )\n            streakInfo\n        }");
        return obj6;
    }

    private static final WorkoutStreakInfo N(WorkoutStreakInfo workoutStreakInfo, app.dogo.com.dogo_android.s.a.r3 r32, String string3, DogWorkoutResponse dogWorkoutResponse4) {
        p2 obj9;
        n.f(r32, "this$0");
        n.f(string3, "$dogId");
        n.f(dogWorkoutResponse4, "it");
        if (workoutStreakInfo != null) {
            r32.j.H0(string3);
        }
        obj9 = new WorkoutStreakInfo(dogWorkoutResponse4.getStreak().getCurrentStreakCount(), dogWorkoutResponse4.getStreak().getLongestStreakCount(), r32.h.g(), obj2);
        r32.g.f(string3, obj9.getLongestStreak(), obj9.getCurrentStreak(), obj9.getLastAchievedStreakTimestampMs());
        return obj9;
    }

    private static final f P(app.dogo.com.dogo_android.s.a.r3 r3, String string2) {
        n.f(r3, "this$0");
        n.f(string2, "dogId");
        p1 p1Var2 = new p1(r3, string2);
        return r3.d.k(string2).flatMapCompletable(p1Var2);
    }

    private static final f Q(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3) {
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(boolean3, "workoutUnlocked");
        i1 i1Var = new i1(r3, string2, boolean3);
        return r3.r(string2).flatMapCompletable(i1Var);
    }

    private static final f R(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3, Boolean boolean4) {
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(boolean3, "$workoutUnlocked");
        n.f(boolean4, "unlockScreenShown");
        h1 h1Var = new h1(boolean3, boolean4, r3, string2);
        return r3.e.f(string2).flatMapCompletable(h1Var);
    }

    private static final f S(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.s.a.r3 r33, String string4, List list5) {
        b obj1;
        n.f(boolean, "$workoutUnlocked");
        n.f(boolean2, "$unlockScreenShown");
        n.f(r33, "this$0");
        n.f(string4, "$dogId");
        n.f(list5, "cachedList");
        if (boolean.booleanValue() && !boolean2.booleanValue() && list5.isEmpty()) {
            if (!boolean2.booleanValue()) {
                if (list5.isEmpty()) {
                    obj1 = r33.a(string4).ignoreElement();
                } else {
                    obj1 = b.f();
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static final g0 U(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogLocalEntity dogLocalEntity3) {
        boolean workoutStreakInfo;
        int currentStreak;
        int longestStreak;
        long lastAchievedStreakTimestampMs;
        int obj7;
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLocalEntity3, "dogLocalEntity");
        if (r3.j.r(string2)) {
            obj7 = 0;
        } else {
            workoutStreakInfo = new WorkoutStreakInfo(dogLocalEntity3.getCurrentStreak(), dogLocalEntity3.getLongestStreak(), dogLocalEntity3.getLastAchievedStreakTimestampMs(), obj4);
            obj7 = workoutStreakInfo;
        }
        return r3.M(string2, obj7);
    }

    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> a(String string) {
        j1 j1Var = new j1(this, string);
        final a0 obj3 = this.c.getDogWorkoutTrickListAndStreakSingle(string).flatMap(j1Var);
        n.e(obj3, "apiClient.getDogWorkoutTrickListAndStreakSingle(dogId)\n            .flatMap { workoutSessionModel ->\n                workoutEntityDao.updateWorkoutTrickIdListCache(\n                    dogId,\n                    workoutSessionModel.workout.map { it.trickId }\n                ).toSingle { workoutSessionModel.workout }\n            }");
        return obj3;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogWorkoutResponse dogWorkoutResponse3) {
        int trickId;
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(dogWorkoutResponse3, "workoutSessionModel");
        List workout = dogWorkoutResponse3.getWorkout();
        ArrayList arrayList = new ArrayList(p.r(workout, 10));
        Iterator iterator = workout.iterator();
        for (DogWorkoutResponse.WorkoutTrickModel next2 : iterator) {
            arrayList.add(next2.getTrickId());
        }
        c1 obj4 = new c1(dogWorkoutResponse3);
        return r3.e.b(string2, arrayList).B(obj4);
    }

    private static final List c(DogWorkoutResponse dogWorkoutResponse) {
        n.f(dogWorkoutResponse, "$workoutSessionModel");
        return dogWorkoutResponse.getWorkout();
    }

    private static final g0 e(app.dogo.com.dogo_android.s.a.r3 r3, String string2) {
        n.f(r3, "this$0");
        n.f(string2, "dogId");
        m1 m1Var = new m1(r3, string2);
        return r3.d.k(string2).flatMap(m1Var);
    }

    private static final g0 f(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3) {
        a0 obj1;
        Object obj2;
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(boolean3, "workoutUnlocked");
        if (boolean3.booleanValue()) {
            obj1 = r3.i(string2);
        } else {
            n.e(a0.just(WorkoutSession.Companion.createEmpty(string2)), "{\n                    Single.just(WorkoutSession.createEmpty(dogId))\n                }");
        }
        return obj1;
    }

    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> g(String string, List<String> list2) {
        g1 g1Var = new g1(list2);
        a0 obj2 = this.f.d(string).map(g1Var);
        n.e(obj2, "trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { trickKnowledgeList ->\n            trickList.map { trickId ->\n                val trickData = trickKnowledgeList.find { it.trickId == trickId }\n                val knowledge = trickData?.knowledge ?: 0\n                val lastUpdateTimeMs = trickData?.updatedAt ?: 0\n                DogWorkoutResponse.WorkoutTrickModel(trickId, knowledge, lastUpdateTimeMs)\n            }\n        }");
        return obj2;
    }

    private static final List h(List list, List list2) {
        int next;
        int knowledge;
        int updatedAt;
        boolean z;
        DogWorkoutResponse.WorkoutTrickModel workoutTrickModel;
        n.f(list, "$trickList");
        n.f(list2, "trickKnowledgeList");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj6 = list.iterator();
        for (String next : obj6) {
            Iterator iterator = list2.iterator();
            for (Object updatedAt : iterator) {
            }
            updatedAt = 0;
            if ((TrickProgressEntity)updatedAt == 0) {
            } else {
            }
            knowledge = (TrickProgressEntity)updatedAt.getKnowledge();
            if (updatedAt == 0) {
            } else {
            }
            updatedAt = updatedAt.getUpdatedAt();
            workoutTrickModel = new DogWorkoutResponse.WorkoutTrickModel(next, knowledge, updatedAt, z);
            arrayList.add(workoutTrickModel);
            updatedAt = 0;
            knowledge = 0;
            if (n.b((TrickProgressEntity)iterator.next().getTrickId(), next)) {
            } else {
            }
        }
        return arrayList;
    }

    private final a0<WorkoutSession> i(String string) {
        z0 z0Var = new z0(this, string);
        final a0 obj3 = p(string).flatMap(z0Var);
        n.e(obj3, "getWorkoutTrickModelList(dogId).flatMap { workoutTrickIds ->\n            getWorkoutStreakModel(dogId).flatMap { streak ->\n                tricksRepository.getAllTricks().map { tricks ->\n                    val trickItems = workoutTrickIds.mapNotNull { trickEvent ->\n                        tricks.find { it.trick.trickId == trickEvent.trickId }?.toTrickItem(trickEvent.knowledge)\n                    }\n                    // Time Metrics streak technically overrides workouts streaks\n                    val isWorkoutStreaksEnabled = remoteConfigService.workoutStreaksEnabled && !remoteConfigService.isTimeMetricEnabled\n                    WorkoutSession(\n                        trainingTricksList = trickItems,\n                        dogId = dogId,\n                        isStreaksEnabled = isWorkoutStreaksEnabled,\n                        currentStreak = streak.currentStreak,\n                        longestStreak = streak.longestStreak,\n                        lastAchievedStreakTimestampMs = streak.lastAchievedStreakTimestampMs\n                    )\n                }\n            }\n        }");
        return obj3;
    }

    private static final g0 j(app.dogo.com.dogo_android.s.a.r3 r3, String string2, List list3) {
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(list3, "workoutTrickIds");
        k1 k1Var = new k1(r3, list3, string2);
        return r3.m(string2).flatMap(k1Var);
    }

    private static final g0 k(app.dogo.com.dogo_android.s.a.r3 r3, List list2, String string3, WorkoutStreakInfo workoutStreakInfo4) {
        n.f(r3, "this$0");
        n.f(list2, "$workoutTrickIds");
        n.f(string3, "$dogId");
        n.f(workoutStreakInfo4, "streak");
        b1 b1Var = new b1(list2, r3, workoutStreakInfo4, string3);
        return r3.a.j().map(b1Var);
    }

    private static final WorkoutSession l(List list, app.dogo.com.dogo_android.s.a.r3 r32, WorkoutStreakInfo workoutStreakInfo3, String string4, List list5) {
        Object obj;
        int i2;
        Integer valueOf;
        Iterator iterator;
        int next;
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem;
        int i;
        String trickId;
        obj = r32;
        Object obj2 = list;
        n.f(list, "$workoutTrickIds");
        n.f(r32, "this$0");
        Object obj3 = workoutStreakInfo3;
        n.f(workoutStreakInfo3, "$streak");
        n.f(string4, "$dogId");
        n.f(list5, "tricks");
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = list.iterator();
        for (DogWorkoutResponse.WorkoutTrickModel valueOf : iterator2) {
            iterator = list5.iterator();
            for (Object next : iterator) {
            }
            next = trickItem;
            if ((g)next == 0) {
            } else {
            }
            trickItem = m1.E((g)next, Integer.valueOf(valueOf.getKnowledge()));
            if (trickItem != null) {
            }
            arrayList.add(trickItem);
            if (n.b((g)iterator.next().d().getTrickId(), valueOf.getTrickId())) {
            } else {
            }
        }
        if (obj.b.O() && !obj.b.g0()) {
            i2 = !obj.b.g0() ? 1 : 0;
        } else {
        }
        super(string4, arrayList, workoutStreakInfo3.getCurrentStreak(), workoutStreakInfo3.getLongestStreak(), 0, i2, workoutStreakInfo3.getLastAchievedStreakTimestampMs(), i, 16, 0);
        return workoutSession;
    }

    private final a0<WorkoutStreakInfo> m(String string) {
        q1 q1Var = new q1(this, string);
        final a0 obj3 = this.g.i(string).flatMap(q1Var);
        n.e(obj3, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            val isCacheInvalid = (utilities.currentTimeInMillis - dogLocalEntity.lastAchievedStreakTimestampMs) > TimeUnit.HOURS.toMillis(24)\n            if (preferenceService.getDogWorkoutStreakSynced(dogId) && isCacheInvalid) {\n                apiClient.getDogWorkoutTrickListAndStreakSingle(dogId).map {\n                    WorkoutStreakInfo(\n                        currentStreak = it.streak.currentStreakCount,\n                        longestStreak = it.streak.longestStreakCount,\n                        lastAchievedStreakTimestampMs = dogLocalEntity.lastAchievedStreakTimestampMs\n                    )\n                }\n            } else {\n                val streakInfo = WorkoutStreakInfo(\n                    currentStreak = dogLocalEntity.currentStreak,\n                    longestStreak = dogLocalEntity.longestStreak,\n                    lastAchievedStreakTimestampMs = dogLocalEntity.lastAchievedStreakTimestampMs\n                )\n                Single.just(streakInfo)\n            }\n        }");
        return obj3;
    }

    private static final g0 n(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogLocalEntity dogLocalEntity3) {
        int longestStreak;
        long lastAchievedStreakTimestampMs;
        a0 obj5;
        int obj6;
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLocalEntity3, "dogLocalEntity");
        long millis = TimeUnit.HOURS.toMillis(24);
        longestStreak = Long.compare(i, millis) > 0 ? 1 : 0;
        if (r3.j.r(string2) && longestStreak != 0) {
            if (longestStreak != 0) {
                obj6 = new o1(dogLocalEntity3);
                obj5 = r3.c.getDogWorkoutTrickListAndStreakSingle(string2).map(obj6);
            } else {
                obj5 = new WorkoutStreakInfo(dogLocalEntity3.getCurrentStreak(), dogLocalEntity3.getLongestStreak(), dogLocalEntity3.getLastAchievedStreakTimestampMs(), millis);
                obj5 = a0.just(obj5);
            }
        } else {
        }
        return obj5;
    }

    private static final WorkoutStreakInfo o(DogLocalEntity dogLocalEntity, DogWorkoutResponse dogWorkoutResponse2) {
        n.f(dogLocalEntity, "$dogLocalEntity");
        n.f(dogWorkoutResponse2, "it");
        WorkoutStreakInfo workoutStreakInfo = new WorkoutStreakInfo(dogWorkoutResponse2.getStreak().getCurrentStreakCount(), dogWorkoutResponse2.getStreak().getLongestStreakCount(), dogLocalEntity.getLastAchievedStreakTimestampMs(), obj3);
        return workoutStreakInfo;
    }

    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> p(String string) {
        d1 d1Var = new d1(this, string);
        final a0 obj3 = this.e.f(string).flatMap(d1Var);
        n.e(obj3, "workoutEntityDao.getCachedWorkoutListOrEmpty(dogId).flatMap { cachedList ->\n            if (cachedList.isNotEmpty()) {\n                getCachedWorkoutTrickModelList(dogId, cachedList)\n            } else {\n                fetchRemoteWorkoutTrickEventListAndUpdateCache(dogId)\n            }\n        }");
        return obj3;
    }

    private static final g0 q(app.dogo.com.dogo_android.s.a.r3 r3, String string2, List list3) {
        a0 obj1;
        n.f(r3, "this$0");
        n.f(string2, "$dogId");
        n.f(list3, "cachedList");
        if (empty ^= 1 != 0) {
            obj1 = r3.g(string2, list3);
        } else {
            obj1 = r3.a(string2);
        }
        return obj1;
    }

    private final a0<Boolean> r(String string) {
        a0 obj2 = this.g.i(string).map(n1.a);
        n.e(obj2, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).map {\n            it.workoutUnlockScreenShown\n        }");
        return obj2;
    }

    private static final Boolean s(DogLocalEntity dogLocalEntity) {
        n.f(dogLocalEntity, "it");
        return Boolean.valueOf(dogLocalEntity.getWorkoutUnlockScreenShown());
    }

    public static g0 t(app.dogo.com.dogo_android.s.a.r3 r3, String string2, List list3) {
        return r3.j(r3, string2, list3);
    }

    public static f u(app.dogo.com.dogo_android.s.a.r3 r3, String string2) {
        return r3.P(r3, string2);
    }

    public static WorkoutSession v(List list, app.dogo.com.dogo_android.s.a.r3 r32, WorkoutStreakInfo workoutStreakInfo3, String string4, List list5) {
        return r3.l(list, r32, workoutStreakInfo3, string4, list5);
    }

    public static List w(DogWorkoutResponse dogWorkoutResponse) {
        return r3.c(dogWorkoutResponse);
    }

    public static g0 x(app.dogo.com.dogo_android.s.a.r3 r3, String string2, List list3) {
        return r3.q(r3, string2, list3);
    }

    public static g0 y(app.dogo.com.dogo_android.s.a.r3 r3, String string2, DogLocalEntity dogLocalEntity3) {
        return r3.U(r3, string2, dogLocalEntity3);
    }

    public static g0 z(app.dogo.com.dogo_android.s.a.r3 r3, String string2) {
        return r3.e(r3, string2);
    }

    public final WorkoutSession L(WorkoutSession workoutSession) {
        int longestStreak;
        Object copy$default;
        Object obj;
        int i5;
        int i4;
        long days;
        int i3;
        int i6;
        int i7;
        int i2;
        int i8;
        int i;
        n.f(workoutSession, "workoutSession");
        Calendar calendar = this.h.f();
        calendar.setTimeInMillis(workoutSession.getLastAchievedStreakTimestampMs());
        i4 = 0;
        calendar.set(10, i4);
        calendar.set(12, i4);
        calendar.set(13, i4);
        calendar.set(14, i4);
        days = TimeUnit.MILLISECONDS.toDays(l -= timeInMillis);
        if (Long.compare(days, i13) == 0) {
            copy$default = WorkoutSession.copy$default(workoutSession, 0, 0, 0, 0, true, false, 0, obj9, 111);
        } else {
            if (Long.compare(days, i6) == 0) {
                copy$default = workoutSession;
            } else {
                if (workoutSession.getCurrentStreak() > workoutSession.getLongestStreak()) {
                    longestStreak = workoutSession.getCurrentStreak();
                } else {
                    longestStreak = workoutSession.getLongestStreak();
                }
                i3 = longestStreak;
                this.g.j(workoutSession.getDogId(), i3);
                this.i.q(q3.CurrentStreak, Integer.valueOf(i4));
                this.i.q(q3.LongestStreak, Integer.valueOf(i3));
                copy$default = WorkoutSession.copy$default(workoutSession, 0, 0, 0, i3, true, false, 0, obj9, 35);
            }
        }
        return copy$default;
    }

    public final b O() {
        a1 a1Var = new a1(this);
        b flatMapCompletable = this.d.v().flatMapCompletable(a1Var);
        n.e(flatMapCompletable, "userRepository.getCurrentDogIdSingle().flatMapCompletable { dogId ->\n            userRepository.checkIfUserUnlockedWorkout(dogId).flatMapCompletable { workoutUnlocked ->\n                isWorkoutUnlockScreenShown(dogId).flatMapCompletable { unlockScreenShown ->\n                    workoutEntityDao.getCachedWorkoutListOrEmpty(dogId).flatMapCompletable { cachedList ->\n                        if (workoutUnlocked && !unlockScreenShown && cachedList.isEmpty()) {\n                            fetchRemoteWorkoutTrickEventListAndUpdateCache(dogId).ignoreElement()\n                        } else {\n                            Completable.complete()\n                        }\n                    }\n                }\n            }\n        }");
        return flatMapCompletable;
    }

    public final a0<WorkoutStreakInfo> T(String string) {
        n.f(string, "dogId");
        e1 e1Var = new e1(this, string);
        final a0 obj3 = this.g.i(string).flatMap(e1Var);
        n.e(obj3, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            val unsyncedStreak = if (preferenceService.getDogWorkoutStreakSynced(dogId)) {\n                null\n            } else {\n                WorkoutStreakInfo(\n                    dogLocalEntity.currentStreak,\n                    dogLocalEntity.longestStreak,\n                    dogLocalEntity.lastAchievedStreakTimestampMs\n                )\n            }\n            updateDogWorkoutStreak(dogId, unsyncedStreak)\n        }");
        return obj3;
    }

    public final a0<WorkoutSession> d() {
        f1 f1Var = new f1(this);
        a0 flatMap = this.d.v().flatMap(f1Var);
        n.e(flatMap, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            userRepository.checkIfUserUnlockedWorkout(dogId).flatMap { workoutUnlocked ->\n                if (workoutUnlocked) {\n                    getWorkoutSession(dogId)\n                } else {\n                    Single.just(WorkoutSession.createEmpty(dogId))\n                }\n            }\n        }");
        return flatMap;
    }
}
