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

/* compiled from: WorkoutSessionInteractor.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018J*\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u0019H\u0002J\u0016\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010$\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eJ\"\u0010)\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010*\u001a\u0004\u0018\u00010#H\u0002J\u0006\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u0008\u0012\u0004\u0012\u00020#0\u00182\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "fetchRemoteWorkoutTrickEventListAndUpdateCache", "Lio/reactivex/Single;", "", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse$WorkoutTrickModel;", "dogId", "", "fetchWorkoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "getCachedWorkoutTrickModelList", "trickList", "getWorkoutSession", "getWorkoutStreakModel", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "getWorkoutTrickModelList", "isWorkoutUnlockScreenShown", "", "resetStreakIfNeededAndSetStreakIncreaseFlag", "workoutSession", "updateDogWorkoutStreak", "unsyncedStreak", "updateWorkoutCacheIfUnlockedAndUnlockScreenNotYetShown", "Lio/reactivex/Completable;", "updateWorkoutStreak", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r3, reason: from kotlin metadata */
public final class WorkoutSessionInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final o1 apiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 dogLocalEntityDao;
    /* renamed from: c, reason: from kotlin metadata */
    private final DogoApiClient preferenceService;
    /* renamed from: d, reason: from kotlin metadata */
    private final p1 remoteConfigService;
    /* renamed from: e, reason: from kotlin metadata */
    private final s0 tracker;
    /* renamed from: f, reason: from kotlin metadata */
    private final o0 trickKnowledgeDao;
    /* renamed from: g, reason: from kotlin metadata */
    private final w tricksRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final v2 userRepository;
    /* renamed from: i, reason: from kotlin metadata */
    private final o3 utilities;
    /* renamed from: j, reason: from kotlin metadata */
    private final p2 workoutEntityDao;
    public r3(o1 o1Var, r2 r2Var, DogoApiClient dogoApiClient, p1 p1Var, s0 s0Var, o0 o0Var, w wVar, v2 v2Var, o3 o3Var, p2 p2Var) {
        n.f(o1Var, "tricksRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(dogoApiClient, "apiClient");
        n.f(p1Var, "userRepository");
        n.f(s0Var, "workoutEntityDao");
        n.f(o0Var, "trickKnowledgeDao");
        n.f(wVar, "dogLocalEntityDao");
        n.f(v2Var, "utilities");
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        super();
        this.apiClient = o1Var;
        this.dogLocalEntityDao = r2Var;
        this.preferenceService = dogoApiClient;
        this.remoteConfigService = p1Var;
        this.tracker = s0Var;
        this.trickKnowledgeDao = o0Var;
        this.tricksRepository = wVar;
        this.userRepository = v2Var;
        this.utilities = o3Var;
        this.workoutEntityDao = p2Var;
    }

    private final a0<WorkoutStreakInfo> M(String str, WorkoutStreakInfo workoutStreakInfo) {
        a0 dogWorkoutStreakSingle;
        if (workoutStreakInfo != null) {
            dogWorkoutStreakSingle = this.preferenceService.updateDogWorkoutStreakSingle(str, new DogWorkoutCompletedRequest(Integer.valueOf(workoutStreakInfo.getCurrentStreak()), Integer.valueOf(workoutStreakInfo.getLongestStreak()), Long.valueOf(workoutStreakInfo.getLastAchievedStreakTimestampMs())));
        } else {
            dogWorkoutStreakSingle = this.preferenceService.updateDogWorkoutStreakSingle(str);
        }
        final a0 map = dogWorkoutStreakSingle.map(new kotlinx.coroutines.l1(workoutStreakInfo, this, str));
        n.e(map, "responseSingle.map {\n            if (unsyncedStreak != null) {\n                preferenceService.setDogWorkoutStreakSynced(dogId)\n            }\n            val streakInfo = WorkoutStreakInfo(\n                currentStreak = it.streak.currentStreakCount,\n                longestStreak = it.streak.longestStreakCount,\n                lastAchievedStreakTimestampMs = utilities.currentTimeInMillis\n            )\n            dogLocalEntityDao.updateDogStreakInfo(\n                dogId,\n                streakInfo.longestStreak,\n                streakInfo.currentStreak,\n                streakInfo.lastAchievedStreakTimestampMs\n            )\n            streakInfo\n        }");
        return map;
    }

    private static final WorkoutStreakInfo N(WorkoutStreakInfo workoutStreakInfo, r3 r3Var, String str, DogWorkoutResponse dogWorkoutResponse) {
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogWorkoutResponse, "it");
        if (workoutStreakInfo != null) {
            r3Var.workoutEntityDao.H0(str);
        }
        WorkoutStreakInfo workoutStreakInfo2 = new WorkoutStreakInfo(dogWorkoutResponse.getStreak().getCurrentStreakCount(), dogWorkoutResponse.getStreak().getLongestStreakCount(), r3Var.userRepository.g(), r2);
        r3Var.tricksRepository.updateDogStreakInfo(str, workoutStreakInfo2.getLongestStreak(), workoutStreakInfo2.getCurrentStreak(), workoutStreakInfo2.getLastAchievedStreakTimestampMs());
        return workoutStreakInfo2;
    }

    private static final f P(r3 r3Var, String str) {
        n.f(r3Var, "this$0");
        n.f(str, "dogId");
        return r3Var.remoteConfigService.k(str).flatMapCompletable(new kotlinx.coroutines.p1(r3Var, str));
    }

    private static final f Q(r3 r3Var, String str, Boolean boolean) {
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(boolean, "workoutUnlocked");
        return r3Var.updateWorkoutStreak(str).flatMapCompletable(new kotlinx.coroutines.i1(r3Var, str, boolean));
    }

    private static final f R(r3 r3Var, String str, Boolean boolean, Boolean boolean2) {
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(boolean, "$workoutUnlocked");
        n.f(boolean2, "unlockScreenShown");
        return r3Var.tracker.getCachedWorkoutListOrEmpty(str).flatMapCompletable(new kotlinx.coroutines.h1(boolean, boolean2, r3Var, str));
    }

    private static final f S(Boolean boolean, Boolean boolean2, r3 r3Var, String str, List list) {
        b ignoreElement;
        n.f(boolean, "$workoutUnlocked");
        n.f(boolean2, "$unlockScreenShown");
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(list, "cachedList");
        if (!boolean.booleanValue() || boolean2.booleanValue() || !list.isEmpty()) {
            ignoreElement = b.f();
        } else {
            ignoreElement = r3Var.getWorkoutSession(str).ignoreElement();
        }
        return ignoreElement;
    }

    private static final g0 U(r3 r3Var, String str, DogLocalEntity dogLocalEntity) {
        WorkoutStreakInfo workoutStreakInfo = null;
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLocalEntity, "dogLocalEntity");
        if (r3Var.workoutEntityDao.r(str)) {
            int i = 0;
        } else {
        }
        return r3Var.M(str, workoutStreakInfo);
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> getWorkoutSession(String dogId) {
        final a0 flatMapped = this.preferenceService.getDogWorkoutTrickListAndStreakSingle(dogId).flatMap(new kotlinx.coroutines.j1(this, dogId));
        n.e(flatMapped, "apiClient.getDogWorkoutTrickListAndStreakSingle(dogId)\n            .flatMap { workoutSessionModel ->\n                workoutEntityDao.updateWorkoutTrickIdListCache(\n                    dogId,\n                    workoutSessionModel.workout.map { it.trickId }\n                ).toSingle { workoutSessionModel.workout }\n            }");
        return flatMapped;
    }

    private static final g0 b(r3 r3Var, String str, DogWorkoutResponse dogWorkoutResponse) {
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogWorkoutResponse, "workoutSessionModel");
        List workout = dogWorkoutResponse.getWorkout();
        final ArrayList arrayList = new ArrayList(p.r(workout, 10));
        Iterator it = workout.iterator();
        while (it.hasNext()) {
            arrayList.add((DogWorkoutResponse_WorkoutTrickModel)it.next().getTrickId());
        }
        return r3Var.tracker.updateWorkoutTrickIdListCache(str, arrayList).B(new kotlinx.coroutines.c1(dogWorkoutResponse));
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final List getWorkoutStreakModel(DogWorkoutResponse dogId) {
        n.f(dogId, "$workoutSessionModel");
        return dogId.getWorkout();
    }

    private static final g0 e(r3 r3Var, String str) {
        n.f(r3Var, "this$0");
        n.f(str, "dogId");
        return r3Var.remoteConfigService.k(str).flatMap(new kotlinx.coroutines.m1(r3Var, str));
    }

    private static final g0 f(r3 r3Var, String str, Boolean boolean) {
        a0 workoutTrickModelList;
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(boolean, "workoutUnlocked");
        if (boolean.booleanValue()) {
            workoutTrickModelList = r3Var.getWorkoutTrickModelList(str);
        } else {
            str = "{\n                    Single.just(WorkoutSession.createEmpty(dogId))\n                }";
            n.e(a0.just(WorkoutSession.INSTANCE.createEmpty(str)), str);
        }
        return workoutTrickModelList;
    }

    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> g(String str, List<String> list) {
        a0 map = this.trickKnowledgeDao.insertTrickProgressCompletable(str).map(new kotlinx.coroutines.g1(list));
        n.e(map, "trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { trickKnowledgeList ->\n            trickList.map { trickId ->\n                val trickData = trickKnowledgeList.find { it.trickId == trickId }\n                val knowledge = trickData?.knowledge ?: 0\n                val lastUpdateTimeMs = trickData?.updatedAt ?: 0\n                DogWorkoutResponse.WorkoutTrickModel(trickId, knowledge, lastUpdateTimeMs)\n            }\n        }");
        return map;
    }

    private static final List h(List list, List list2) {
        int knowledge = 0;
        long l;
        int i2 = 0;
        int i3 = 0;
        boolean z;
        n.f(list, "$trickList");
        n.f(list2, "trickKnowledgeList");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (n.b((TrickProgressEntity)item.getTrickId(), item2)) {
                    break loop_3;
                }
            }
            i2 = 0;
            arrayList.add(new DogWorkoutResponse_WorkoutTrickModel(item2, knowledge, i3, z));
        }
        return arrayList;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final a0<WorkoutSession> getWorkoutTrickModelList(String dogId) {
        final a0 flatMapped = resetStreakIfNeededAndSetStreakIncreaseFlag(dogId).flatMap(new kotlinx.coroutines.z0(this, dogId));
        n.e(flatMapped, "getWorkoutTrickModelList(dogId).flatMap { workoutTrickIds ->\n            getWorkoutStreakModel(dogId).flatMap { streak ->\n                tricksRepository.getAllTricks().map { tricks ->\n                    val trickItems = workoutTrickIds.mapNotNull { trickEvent ->\n                        tricks.find { it.trick.trickId == trickEvent.trickId }?.toTrickItem(trickEvent.knowledge)\n                    }\n                    // Time Metrics streak technically overrides workouts streaks\n                    val isWorkoutStreaksEnabled = remoteConfigService.workoutStreaksEnabled && !remoteConfigService.isTimeMetricEnabled\n                    WorkoutSession(\n                        trainingTricksList = trickItems,\n                        dogId = dogId,\n                        isStreaksEnabled = isWorkoutStreaksEnabled,\n                        currentStreak = streak.currentStreak,\n                        longestStreak = streak.longestStreak,\n                        lastAchievedStreakTimestampMs = streak.lastAchievedStreakTimestampMs\n                    )\n                }\n            }\n        }");
        return flatMapped;
    }

    private static final g0 j(r3 r3Var, String str, List list) {
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(list, "workoutTrickIds");
        return r3Var.isWorkoutUnlockScreenShown(str).flatMap(new kotlinx.coroutines.k1(r3Var, list, str));
    }

    private static final g0 k(r3 r3Var, List list, String str, WorkoutStreakInfo workoutStreakInfo) {
        n.f(r3Var, "this$0");
        n.f(list, "$workoutTrickIds");
        n.f(str, "$dogId");
        n.f(workoutStreakInfo, "streak");
        return r3Var.apiClient.j().map(new kotlinx.coroutines.b1(list, r3Var, workoutStreakInfo, str));
    }

    private static final WorkoutSession l(List list, r3 r3Var, WorkoutStreakInfo workoutStreakInfo, String str, List list2) {
        int i = 0;
        Integer num;
        g item;
        Object obj;
        int i2;
        String trickId;
        r3Var22 = r3Var;
        n.f(list, "$workoutTrickIds");
        n.f(r3Var, "this$0");
        n.f(workoutStreakInfo, "$streak");
        n.f(str, "$dogId");
        n.f(list2, "tricks");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            Iterator it = list2.iterator();
            obj = null;
            while (it.hasNext()) {
                if (n.b((TrickFullEntity)item.d().getTrickId(), item2.getTrickId())) {
                    break loop_3;
                }
                obj = null;
            }
        }
        if (r3Var22.dogLocalEntityDao.O()) {
            int r0 = !r3Var22.dogLocalEntityDao.g0() ? 1 : 0;
        }
        WorkoutSession workoutSession = new WorkoutSession(str, arrayList, workoutStreakInfo.getCurrentStreak(), workoutStreakInfo.getLongestStreak(), false, (!r3Var22.dogLocalEntityDao.g0() ? 1 : 0), workoutStreakInfo.getLastAchievedStreakTimestampMs(), i2, 16, 0);
        return r0;
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final a0<WorkoutStreakInfo> isWorkoutUnlockScreenShown(String dogId) {
        final a0 flatMapped = this.tricksRepository.getWorkoutUnlockSourceOrEmpty(dogId).flatMap(new kotlinx.coroutines.q1(this, dogId));
        n.e(flatMapped, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            val isCacheInvalid = (utilities.currentTimeInMillis - dogLocalEntity.lastAchievedStreakTimestampMs) > TimeUnit.HOURS.toMillis(24)\n            if (preferenceService.getDogWorkoutStreakSynced(dogId) && isCacheInvalid) {\n                apiClient.getDogWorkoutTrickListAndStreakSingle(dogId).map {\n                    WorkoutStreakInfo(\n                        currentStreak = it.streak.currentStreakCount,\n                        longestStreak = it.streak.longestStreakCount,\n                        lastAchievedStreakTimestampMs = dogLocalEntity.lastAchievedStreakTimestampMs\n                    )\n                }\n            } else {\n                val streakInfo = WorkoutStreakInfo(\n                    currentStreak = dogLocalEntity.currentStreak,\n                    longestStreak = dogLocalEntity.longestStreak,\n                    lastAchievedStreakTimestampMs = dogLocalEntity.lastAchievedStreakTimestampMs\n                )\n                Single.just(streakInfo)\n            }\n        }");
        return flatMapped;
    }

    private static final g0 n(r3 r3Var, String str, DogLocalEntity dogLocalEntity) {
        int longestStreak = 0;
        a0 just;
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLocalEntity, "dogLocalEntity");
        long l2 = r3Var.userRepository.g() - dogLocalEntity.getLastAchievedStreakTimestampMs();
        long millis = TimeUnit.HOURS.toMillis(24L);
        int r0 = r3Var.userRepository > millis ? 1 : 0;
        if (!r3Var.workoutEntityDao.r(str) || r3Var.userRepository == 0) {
            just = a0.just(new WorkoutStreakInfo(dogLocalEntity.getCurrentStreak(), dogLocalEntity.getLongestStreak(), dogLocalEntity.getLastAchievedStreakTimestampMs(), millis));
        } else {
            just = r3Var.preferenceService.getDogWorkoutTrickListAndStreakSingle(str).map(new kotlinx.coroutines.o1(dogLocalEntity));
        }
        return just;
    }

    private static final WorkoutStreakInfo o(DogLocalEntity dogLocalEntity, DogWorkoutResponse dogWorkoutResponse) {
        n.f(dogLocalEntity, "$dogLocalEntity");
        n.f(dogWorkoutResponse, "it");
        return new WorkoutStreakInfo(dogWorkoutResponse.getStreak().getCurrentStreakCount(), dogWorkoutResponse.getStreak().getLongestStreakCount(), dogLocalEntity.getLastAchievedStreakTimestampMs(), r3);
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final a0<List<DogWorkoutResponse.WorkoutTrickModel>> resetStreakIfNeededAndSetStreakIncreaseFlag(String workoutSession) {
        final a0 flatMapped = this.tracker.getCachedWorkoutListOrEmpty(workoutSession).flatMap(new kotlinx.coroutines.d1(this, workoutSession));
        n.e(flatMapped, "workoutEntityDao.getCachedWorkoutListOrEmpty(dogId).flatMap { cachedList ->\n            if (cachedList.isNotEmpty()) {\n                getCachedWorkoutTrickModelList(dogId, cachedList)\n            } else {\n                fetchRemoteWorkoutTrickEventListAndUpdateCache(dogId)\n            }\n        }");
        return flatMapped;
    }

    private static final g0 q(r3 r3Var, String str, List list) {
        a0 workoutSession;
        n.f(r3Var, "this$0");
        n.f(str, "$dogId");
        n.f(list, "cachedList");
        if (!list.isEmpty()) {
            workoutSession = r3Var.g(str, list);
        } else {
            workoutSession = r3Var.getWorkoutSession(str);
        }
        return workoutSession;
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final a0<Boolean> updateWorkoutStreak(String dogId) {
        a0 map = this.tricksRepository.getWorkoutUnlockSourceOrEmpty(dogId).map(kotlinx.coroutines.n1.a);
        n.e(map, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).map {\n            it.workoutUnlockScreenShown\n        }");
        return map;
    }

    private static final Boolean s(DogLocalEntity dogLocalEntity) {
        n.f(dogLocalEntity, "it");
        return Boolean.valueOf(dogLocalEntity.getWorkoutUnlockScreenShown());
    }

    public final WorkoutSession L(WorkoutSession workoutSession) {
        int longestStreak;
        Object workoutSession2;
        n.f(workoutSession, "workoutSession");
        Calendar calendar = this.userRepository.f();
        calendar.setTimeInMillis(workoutSession.getLastAchievedStreakTimestampMs());
        int i2 = 0;
        calendar.set(10, i2);
        calendar.set(12, i2);
        calendar.set(13, i2);
        int i = 14;
        calendar.set(i, i2);
        long days = TimeUnit.MILLISECONDS.toDays(this.userRepository.g() - calendar.getTimeInMillis());
        if (days == 1) {
            longestStreak = 0;
            boolean z = false;
            boolean z2 = false;
            int i3 = 111;
            Object obj = null;
            WorkoutSession copy$default2 = WorkoutSession.copy$default(workoutSession, null, null, null, longestStreak, true, z, z2, i3, obj);
        } else {
            long l = 0L;
            if (days == l) {
                workoutSession2 = workoutSession;
            } else {
                if (workoutSession.getCurrentStreak() > workoutSession.getLongestStreak()) {
                    longestStreak = workoutSession.getCurrentStreak();
                } else {
                    longestStreak = workoutSession.getLongestStreak();
                }
                this.tricksRepository.setWorkoutUnlocked(workoutSession.getDogId(), longestStreak);
                this.utilities.setUserProperty(UserProperty.CurrentStreak, null);
                this.utilities.setUserProperty(UserProperty.LongestStreak, Integer.valueOf(longestStreak));
                z = false;
                z2 = false;
                i3 = 35;
                obj = null;
                WorkoutSession copy$default = WorkoutSession.copy$default(workoutSession, null, null, null, longestStreak, true, z, z2, i3, obj);
            }
        }
        return workoutSession2;
    }

    /* renamed from: O, reason: from kotlin metadata */
    public final b fetchWorkoutSession() {
        b flatMapCompletable = this.remoteConfigService.v().flatMapCompletable(new kotlinx.coroutines.a1(this));
        n.e(flatMapCompletable, "userRepository.getCurrentDogIdSingle().flatMapCompletable { dogId ->\n            userRepository.checkIfUserUnlockedWorkout(dogId).flatMapCompletable { workoutUnlocked ->\n                isWorkoutUnlockScreenShown(dogId).flatMapCompletable { unlockScreenShown ->\n                    workoutEntityDao.getCachedWorkoutListOrEmpty(dogId).flatMapCompletable { cachedList ->\n                        if (workoutUnlocked && !unlockScreenShown && cachedList.isEmpty()) {\n                            fetchRemoteWorkoutTrickEventListAndUpdateCache(dogId).ignoreElement()\n                        } else {\n                            Completable.complete()\n                        }\n                    }\n                }\n            }\n        }");
        return flatMapCompletable;
    }

    public final a0<WorkoutStreakInfo> T(String str) {
        n.f(str, "dogId");
        final a0 flatMapped = this.tricksRepository.getWorkoutUnlockSourceOrEmpty(str).flatMap(new kotlinx.coroutines.e1(this, str));
        n.e(flatMapped, "dogLocalEntityDao.getDogLocalEntityOrEmpty(dogId).flatMap { dogLocalEntity ->\n            val unsyncedStreak = if (preferenceService.getDogWorkoutStreakSynced(dogId)) {\n                null\n            } else {\n                WorkoutStreakInfo(\n                    dogLocalEntity.currentStreak,\n                    dogLocalEntity.longestStreak,\n                    dogLocalEntity.lastAchievedStreakTimestampMs\n                )\n            }\n            updateDogWorkoutStreak(dogId, unsyncedStreak)\n        }");
        return flatMapped;
    }

    public final a0<WorkoutSession> d() {
        a0 flatMapped = this.remoteConfigService.v().flatMap(new kotlinx.coroutines.f1(this));
        n.e(flatMapped, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            userRepository.checkIfUserUnlockedWorkout(dogId).flatMap { workoutUnlocked ->\n                if (workoutUnlocked) {\n                    getWorkoutSession(dogId)\n                } else {\n                    Single.just(WorkoutSession.createEmpty(dogId))\n                }\n            }\n        }");
        return flatMapped;
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ List getCachedWorkoutTrickModelList(List dogId, List trickList) {
        return WorkoutSessionInteractor.h(dogId, trickList);
    }

    public static /* synthetic */ f B(Boolean boolean, Boolean boolean2, r3 r3Var, String str, List list) {
        return WorkoutSessionInteractor.S(boolean, boolean2, r3Var, str, list);
    }

    public static /* synthetic */ f C(r3 r3Var, String str, Boolean boolean, Boolean boolean2) {
        return WorkoutSessionInteractor.R(r3Var, str, boolean, boolean2);
    }

    public static /* synthetic */ g0 D(r3 r3Var, String str, DogWorkoutResponse dogWorkoutResponse) {
        return WorkoutSessionInteractor.b(r3Var, str, dogWorkoutResponse);
    }

    public static /* synthetic */ g0 E(r3 r3Var, List list, String str, WorkoutStreakInfo workoutStreakInfo) {
        return WorkoutSessionInteractor.k(r3Var, list, str, workoutStreakInfo);
    }

    public static /* synthetic */ WorkoutStreakInfo F(WorkoutStreakInfo workoutStreakInfo, r3 r3Var, String str, DogWorkoutResponse dogWorkoutResponse) {
        return WorkoutSessionInteractor.N(workoutStreakInfo, r3Var, str, dogWorkoutResponse);
    }

    public static /* synthetic */ g0 G(r3 r3Var, String str, Boolean boolean) {
        return WorkoutSessionInteractor.f(r3Var, str, boolean);
    }

    /* renamed from: H, reason: from kotlin metadata */
    public static /* synthetic */ Boolean fetchRemoteWorkoutTrickEventListAndUpdateCache(DogLocalEntity dogId) {
        return WorkoutSessionInteractor.s(dogId);
    }

    /* renamed from: I, reason: from kotlin metadata */
    public static /* synthetic */ WorkoutStreakInfo updateDogWorkoutStreak(DogLocalEntity dogId, DogWorkoutResponse unsyncedStreak) {
        return WorkoutSessionInteractor.o(dogId, unsyncedStreak);
    }

    public static /* synthetic */ f J(r3 r3Var, String str, Boolean boolean) {
        return WorkoutSessionInteractor.Q(r3Var, str, boolean);
    }

    public static /* synthetic */ g0 K(r3 r3Var, String str, DogLocalEntity dogLocalEntity) {
        return WorkoutSessionInteractor.n(r3Var, str, dogLocalEntity);
    }

    public static /* synthetic */ g0 t(r3 r3Var, String str, List list) {
        return WorkoutSessionInteractor.j(r3Var, str, list);
    }

    public static /* synthetic */ f u(r3 r3Var, String str) {
        return WorkoutSessionInteractor.P(r3Var, str);
    }

    public static /* synthetic */ WorkoutSession v(List list, r3 r3Var, WorkoutStreakInfo workoutStreakInfo, String str, List list2) {
        return WorkoutSessionInteractor.l(list, r3Var, workoutStreakInfo, str, list2);
    }

    public static /* synthetic */ List w(DogWorkoutResponse dogWorkoutResponse) {
        return WorkoutSessionInteractor.getWorkoutStreakModel(dogWorkoutResponse);
    }

    public static /* synthetic */ g0 x(r3 r3Var, String str, List list) {
        return WorkoutSessionInteractor.q(r3Var, str, list);
    }

    public static /* synthetic */ g0 y(r3 r3Var, String str, DogLocalEntity dogLocalEntity) {
        return WorkoutSessionInteractor.U(r3Var, str, dogLocalEntity);
    }

    public static /* synthetic */ g0 z(r3 r3Var, String str) {
        return WorkoutSessionInteractor.e(r3Var, str);
    }
}
