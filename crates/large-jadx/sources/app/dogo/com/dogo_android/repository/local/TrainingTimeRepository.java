package app.dogo.com.dogo_android.s.b;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import app.dogo.com.dogo_android.k.s;
import app.dogo.com.dogo_android.k.s.a;
import app.dogo.com.dogo_android.k.s.b;
import app.dogo.com.dogo_android.k.s.c;
import app.dogo.com.dogo_android.k.s.d;
import app.dogo.com.dogo_android.k.s.e;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogSpecialProgramTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogTrickVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest;
import app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest;
import app.dogo.externalmodel.model.responses.DogTrainingDurationResponse;
import app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak;
import e.a.a.a.b.b.k0;
import i.b.a0;
import i.b.c0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.m0;

/* compiled from: TrainingTimeRepository.kt */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 22\u00020\u0001:\u00012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0019\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J)\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J)\u0010)\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J)\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020-H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J)\u0010/\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0002\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "trainingStreakEntityDao", "Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;)V", "getTimeTrained", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeTrainedSingle", "Lio/reactivex/Single;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initiateStreakSync", "mapResponseToEntity", "response", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "saveResponseToCache", "(Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTime", "dogId", "", "data", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTimeToRemote", "updateDogWorkoutDuration", "goalSec", "", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgramTrickTrainingDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgramVariationDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrickTrainingDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrickVariationDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n1, reason: from kotlin metadata */
public final class TrainingTimeRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final n1.a INSTANCE = new n1$a(0);
    private static final long f = 0L;
    /* renamed from: a, reason: from kotlin metadata */
    private final DogoApiClient authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 dogoApiClient;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 remoteConfigService;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 timeUtils;
    /* renamed from: e, reason: from kotlin metadata */
    private final k0 trainingStreakEntityDao;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository$Companion;", "", "()V", "CACHE_LIFETIME_MS", "", "getCACHE_LIFETIME_MS", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {37, 42, 43}, m = "getTimeTrained")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super n1.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return n1.this.mapResponseToEntity(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {61, 66}, m = "initiateStreakSync")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super n1.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return n1.this.e(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = 71, m = "saveResponseToCache")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super n1.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return n1.this.saveTrainingTime(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {32, 33}, m = "saveTrainingTime")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super n1.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return n1.this.updateTrickVariationDuration(str, str, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository$getTimeTrainedSingle$1$1", f = "TrainingTimeRepository.kt", l = 51, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ c0<TrainingStreakEntity> $emitter;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            c0 object2;
            Object mapResponseToEntity;
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    try {
                        q.b(object);
                    } catch (Exception e) {
                        this.$emitter.onError(e);
                    }
                    object2.onSuccess(mapResponseToEntity);
                    return w.a;
                }
            }
            q.b(e);
            try {
                this.L$0 = this.$emitter;
                this.label = i;
                mapResponseToEntity = n1.this.mapResponseToEntity(this);
                if (mapResponseToEntity == obj) {
                    return obj;
                }
                object2.onSuccess(mapResponseToEntity);
            } catch (Exception e) {
                this.$emitter.onError(e);
            }
        }

        c(c0<TrainingStreakEntity> c0Var, n1 n1Var, kotlin.b0.d<? super n1.c> dVar) {
            this.$emitter = c0Var;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.repository.local.n1.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.repository.local.n1.c(this.$emitter, n1.this, dVar);
        }
    }
    static {
        TrainingTimeRepository.f = TimeUnit.MINUTES.toMillis(15L);
    }

    public n1(DogoApiClient dogoApiClient, r2 r2Var, h2 h2Var, v2 v2Var, k0 k0Var) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(r2Var, "remoteConfigService");
        n.f(h2Var, "authService");
        n.f(v2Var, "timeUtils");
        n.f(k0Var, "trainingStreakEntityDao");
        super();
        this.authService = dogoApiClient;
        this.dogoApiClient = r2Var;
        this.remoteConfigService = h2Var;
        this.timeUtils = v2Var;
        this.trainingStreakEntityDao = k0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ Object updateDogWorkoutDuration(n1 dogId, DogTrainingDurationResponse goalSec, kotlin.b0.d data) {
        return dogId.saveTrainingTime(goalSec, data);
    }

    /* renamed from: d, reason: from kotlin metadata */
    /* suspend */ private static final void updateProgramTrickTrainingDuration(m0 dogId, n1 goalSec, c0 data) {
        n.f(dogId, "$scope");
        n.f(goalSec, "this$0");
        n.f(data, "emitter");
        kotlinx.coroutines.internal.k.d(dogId, null, null, new app.dogo.com.dogo_android.repository.local.n1.c(data, goalSec, null), 3, null);
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final TrainingStreakEntity getTimeTrainedSingle(DogTrainingDurationResponse scope) {
        TrainingStreakEntity trainingStreakEntity = new TrainingStreakEntity(this.remoteConfigService.v(), scope.getDailyTrainingTimeGoalStreak().getCurrentStreak(), scope.getDailyTrainingTimeGoalStreak().getLongestStreak(), scope.getDailyTrainingTimes(), scope.getTotalTrainingTimeSec(), l, this.timeUtils.g(), obj);
        return trainingStreakEntity;
    }

    /* renamed from: h, reason: from kotlin metadata */
    /* suspend */ private final Object saveTrainingTime(DogTrainingDurationResponse dogId, kotlin.b0.d<? super TrainingStreakEntity> data) {
        Object data2;
        int label2;
        int i = -2147483648;
        int i2;
        Object obj;
        z = data instanceof app.dogo.com.dogo_android.repository.local.n1.e;
        if (data instanceof app.dogo.com.dogo_android.repository.local.n1.e) {
            data2 = data;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                data2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.n1.e eVar = new app.dogo.com.dogo_android.repository.local.n1.e(this, data);
            }
        }
        Object obj2 = b.d();
        int i4 = 1;
        if (data2.label != 0 && data2.label == i4) {
            q.b(data2.result);
            return obj;
        }
        q.b(data2.result);
        TrainingStreakEntity timeTrainedSingle = getTimeTrainedSingle(dogId);
        TrainingStreakEntity[] arr = new TrainingStreakEntity[i4];
        int i3 = 0;
        arr[i3] = timeTrainedSingle;
        data2.L$0 = timeTrainedSingle;
        data2.label = i4;
        return this.trainingStreakEntityDao.b(arr, data2) == obj2 ? obj2 : obj;
    }

    /* renamed from: j, reason: from kotlin metadata */
    /* suspend */ private final Object updateTrickTrainingDuration(String dogId, s goalSec, kotlin.b0.d<? super DogTrainingDurationResponse> data) throws NoWhenBranchMatchedException {
        final long l = (long)this.dogoApiClient.s();
        if (goalSec instanceof TrainingTimeSaveData_LibraryTrickSaveData) {
            return this.n(dogId, l, (TrainingTimeSaveData_LibraryTrickSaveData)goalSec, data);
        }
        if (goalSec instanceof TrainingTimeSaveData_LibraryTrickVariationSaveData) {
            return this.o(dogId, l, (TrainingTimeSaveData_LibraryTrickVariationSaveData)goalSec, data);
        }
        if (goalSec instanceof TrainingTimeSaveData_ProgramTrickSaveData) {
            return this.l(dogId, l, (TrainingTimeSaveData_ProgramTrickSaveData)goalSec, data);
        }
        if (goalSec instanceof TrainingTimeSaveData_ProgramVariationSaveData) {
            return this.m(dogId, l, (TrainingTimeSaveData_ProgramVariationSaveData)goalSec, data);
        }
        if (!(goalSec instanceof TrainingTimeSaveData_WorkoutSaveData)) {
            throw new NoWhenBranchMatchedException();
        } else {
            return this.k(dogId, l, (TrainingTimeSaveData_WorkoutSaveData)goalSec, data);
        }
    }

    private final Object k(String str, long j, s.e eVar, kotlin.b0.d<? super DogTrainingDurationResponse> dVar) {
        return this.authService.updateDogWorkoutDuration(str, new DogWorkoutDurationRequest(j, r7, (long)eVar.component1(), r3), dVar);
    }

    private final Object l(String str, long j, s.c cVar, kotlin.b0.d<? super DogTrainingDurationResponse> dVar) {
        final Object str3 = this;
        if (l.z(cVar.c())) {
            return str3.authService.updateSpecialDogProgramTrickDuration(str, cVar.e(), cVar.d(), new DogSpecialProgramTrickDurationRequest(j, l2, (long)cVar.component1(), r8), dVar);
        }
        DogProgramTrickDurationRequest dogProgramTrickDurationRequest = new DogProgramTrickDurationRequest(cVar.c(), cVar.b(), j, l2, (long)cVar.component1(), obj);
        return str3.authService.updateDogProgramTrickDuration(str, cVar.e(), cVar.d(), dogProgramTrickDurationRequest, dVar);
    }

    private final Object m(String str, long j, s.d dVar, kotlin.b0.d<? super DogTrainingDurationResponse> dVar2) {
        final Object str3 = this;
        if (l.z(dVar.c())) {
            DogSpecialProgramVariationDurationRequest dogSpecialProgramVariationDurationRequest = new DogSpecialProgramVariationDurationRequest(dVar.f(), j, l, (long)dVar.component1(), l3);
            return str3.authService.updateSpecialDogProgramVariationDuration(str, dVar.e(), dVar.d(), dogSpecialProgramVariationDurationRequest, dVar2);
        }
        DogProgramVariationDurationRequest dogProgramVariationDurationRequest = new DogProgramVariationDurationRequest(dVar.c(), dVar.b(), dVar.f(), j, l3, (long)dVar.component1(), obj);
        return str3.authService.updateDogProgramVariationDuration(str, dVar.e(), dVar.d(), dogProgramVariationDurationRequest, dVar2);
    }

    private final Object n(String str, long j, s.a aVar, kotlin.b0.d<? super DogTrainingDurationResponse> dVar) {
        return this.authService.updateDogTrickDuration(str, aVar.b(), new DogTrickDurationRequest(j, r8, (long)aVar.component1(), r4), dVar);
    }

    private final Object o(String str, long j, s.b bVar, kotlin.b0.d<? super DogTrainingDurationResponse> dVar) {
        DogTrickVariationDurationRequest dogTrickVariationDurationRequest = new DogTrickVariationDurationRequest(bVar.c(), j, l, (long)bVar.component1(), obj);
        return this.authService.updateDogTrickVariationDuration(str, bVar.b(), dogTrickVariationDurationRequest, dVar);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final Object mapResponseToEntity(kotlin.b0.d<? super TrainingStreakEntity> response) {
        Object response2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.n1 n1Var;
        int i2;
        int i3 = 1;
        int cmp;
        long l;
        long l2;
        DogTrainingDurationResponse dogTrainingDurationResponse;
        Object trainingTime;
        z = response instanceof app.dogo.com.dogo_android.repository.local.n1.b;
        if (response instanceof app.dogo.com.dogo_android.repository.local.n1.b) {
            response2 = response;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                response2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.n1.b bVar = new app.dogo.com.dogo_android.repository.local.n1.b(this, response);
            }
        }
        Object obj2 = b.d();
        int i4 = 3;
        int i5 = 2;
        i3 = 1;
        if (response2.label != 0) {
            if (response2.label != i3) {
                if (response2.label != i5) {
                    if (response2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(response2.result);
                        return trainingTime;
                    }
                }
                q.b(response2.result);
            } else {
                q.b(response2.result);
                long l3 = n1Var.timeUtils.g();
                l = trainingTime.getRemoteUpdateTimeMs() + TrainingTimeRepository.f;
                if (l3 >= l) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    return trainingTime;
                }
                response2.L$0 = n1Var;
                response2.label = i5;
                if (n1Var.authService.getTrainingTimeMetrics(response2) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(response2.result);
            response2.L$0 = this;
            response2.label = i3;
            if (this.trainingStreakEntityDao.c(this.remoteConfigService.v(), response2) == obj2) {
                return obj2;
            }
            n1Var = this;
        }
        Object obj = null;
        response2.L$0 = obj;
        response2.label = i4;
        return n1Var.saveTrainingTime((DogTrainingDurationResponse)dogTrainingDurationResponse, response2) == obj2 ? obj2 : trainingTime;
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ public final a0<TrainingStreakEntity> saveResponseToCache(m0 response) {
        n.f(response, "scope");
        final a0 a0Var = a0.create(new app.dogo.com.dogo_android.repository.local.b0(response, this));
        n.e(a0Var, "create { emitter ->\n            scope.launch {\n                try {\n                    emitter.onSuccess(getTimeTrained())\n                } catch (e: Exception) {\n                    emitter.onError(e)\n                }\n            }\n        }");
        return a0Var;
    }

    public final Object e(kotlin.b0.d<? super TrainingStreakEntity> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.n1 n1Var;
        int i2;
        InitialTrainingStreakSyncRequest initialTrainingStreakSyncRequest;
        java.util.List list = null;
        long l;
        g gVar;
        int i3 = 0;
        Object trainingTime;
        DogTrainingDurationResponse dogTrainingDurationResponse;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.n1.d;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.n1.d) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.n1.d dVar3 = new app.dogo.com.dogo_android.repository.local.n1.d(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i4 = 2;
        int i5 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i5) {
                if (dVar2.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar2.result);
                    return trainingTime;
                }
            }
            q.b(dVar2.result);
        } else {
            q.b(dVar2.result);
            l = (long)this.dogoApiClient.s();
            list = null;
            gVar = 1;
            i3 = 0;
            initialTrainingStreakSyncRequest = new InitialTrainingStreakSyncRequest(list, l, i6, gVar, i3);
            dVar2.L$0 = this;
            dVar2.label = i5;
            if (this.authService.syncWorkoutStreakToTrainingMetrics(initialTrainingStreakSyncRequest, dVar2) == obj2) {
                return obj2;
            }
            n1Var = this;
        }
        Object obj = null;
        dVar2.L$0 = obj;
        dVar2.label = i4;
        return n1Var.saveTrainingTime((DogTrainingDurationResponse)dogTrainingDurationResponse, dVar2) == obj2 ? obj2 : trainingTime;
    }

    /* renamed from: i, reason: from kotlin metadata */
    /* suspend */ public final Object updateTrickVariationDuration(String dogId, s goalSec, kotlin.b0.d<? super TrainingStreakEntity> data) {
        Object data2;
        int label2;
        int i = -2147483648;
        int i2;
        app.dogo.com.dogo_android.s.b.n1 n1Var;
        Object trainingTime;
        DogTrainingDurationResponse dogTrainingDurationResponse;
        z = data instanceof app.dogo.com.dogo_android.repository.local.n1.f;
        if (data instanceof app.dogo.com.dogo_android.repository.local.n1.f) {
            data2 = data;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                data2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.n1.f fVar = new app.dogo.com.dogo_android.repository.local.n1.f(this, data);
            }
        }
        Object obj2 = b.d();
        int i3 = 2;
        final int i4 = 1;
        if (data2.label != 0) {
            if (data2.label != i4) {
                if (data2.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(data2.result);
                    return trainingTime;
                }
            }
            q.b(data2.result);
        } else {
            q.b(data2.result);
            data2.L$0 = this;
            data2.label = i4;
            if (updateTrickTrainingDuration(dogId, goalSec, data2) == obj2) {
                return obj2;
            }
            n1Var = this;
        }
        Object obj = null;
        data2.L$0 = obj;
        data2.label = i3;
        return n1Var.saveTrainingTime((DogTrainingDurationResponse)dogTrainingDurationResponse, data2) == obj2 ? obj2 : trainingTime;
    }

    /* renamed from: f, reason: from kotlin metadata */
    /* suspend */ public static /* synthetic */ void updateProgramVariationDuration(m0 dogId, n1 goalSec, c0 data) {
        TrainingTimeRepository.updateProgramTrickTrainingDuration(dogId, goalSec, data);
    }
}
