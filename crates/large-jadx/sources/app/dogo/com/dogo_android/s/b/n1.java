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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 22\u00020\u0001:\u00012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0019\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J)\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J)\u0010)\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J)\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020-H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J)\u0010/\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0002\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "trainingStreakEntityDao", "Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/android/persistencedb/room/dao/TrainingStreakEntityDao;)V", "getTimeTrained", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeTrainedSingle", "Lio/reactivex/Single;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initiateStreakSync", "mapResponseToEntity", "response", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "saveResponseToCache", "(Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTime", "dogId", "", "data", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTimeToRemote", "updateDogWorkoutDuration", "goalSec", "", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgramTrickTrainingDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgramVariationDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrickTrainingDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrickVariationDuration", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n1 {

    public static final app.dogo.com.dogo_android.s.b.n1.a Companion;
    private static final long f;
    private final DogoApiClient a;
    private final r2 b;
    private final h2 c;
    private final v2 d;
    private final k0 e;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository$Companion;", "", "()V", "CACHE_LIFETIME_MS", "", "getCACHE_LIFETIME_MS", "()J", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {37, 42, 43}, m = "getTimeTrained")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.n1 this$0;
        b(app.dogo.com.dogo_android.s.b.n1 n1, d<? super app.dogo.com.dogo_android.s.b.n1.b> d2) {
            this.this$0 = n1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {61, 66}, m = "initiateStreakSync")
    static final class d extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.n1 this$0;
        d(app.dogo.com.dogo_android.s.b.n1 n1, d<? super app.dogo.com.dogo_android.s.b.n1.d> d2) {
            this.this$0 = n1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.e(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = 71, m = "saveResponseToCache")
    static final class e extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.n1 this$0;
        e(app.dogo.com.dogo_android.s.b.n1 n1, d<? super app.dogo.com.dogo_android.s.b.n1.e> d2) {
            this.this$0 = n1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return n1.a(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository", f = "TrainingTimeRepository.kt", l = {32, 33}, m = "saveTrainingTime")
    static final class f extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.n1 this$0;
        f(app.dogo.com.dogo_android.s.b.n1 n1, d<? super app.dogo.com.dogo_android.s.b.n1.f> d2) {
            this.this$0 = n1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.i(i2, i2, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TrainingTimeRepository$getTimeTrainedSingle$1$1", f = "TrainingTimeRepository.kt", l = 51, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        final c0<TrainingStreakEntity> $emitter;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.s.b.n1 this$0;
        c(c0<TrainingStreakEntity> c0, app.dogo.com.dogo_android.s.b.n1 n12, d<? super app.dogo.com.dogo_android.s.b.n1.c> d3) {
            this.$emitter = c0;
            this.this$0 = n12;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n1.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n1.c obj3 = new n1.c(this.$emitter, this.this$0, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    l$0.onSuccess(obj4);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            obj4 = this.$emitter;
            this.L$0 = obj4;
            this.label = i;
            label = this.this$0.b(this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj4;
            obj4 = label;
        }
    }
    static {
        n1.a aVar = new n1.a(0);
        n1.Companion = aVar;
        n1.f = TimeUnit.MINUTES.toMillis(15);
    }

    public n1(DogoApiClient dogoApiClient, r2 r22, h2 h23, v2 v24, k0 k05) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(r22, "remoteConfigService");
        n.f(h23, "authService");
        n.f(v24, "timeUtils");
        n.f(k05, "trainingStreakEntityDao");
        super();
        this.a = dogoApiClient;
        this.b = r22;
        this.c = h23;
        this.d = v24;
        this.e = k05;
    }

    public static final Object a(app.dogo.com.dogo_android.s.b.n1 n1, DogTrainingDurationResponse dogTrainingDurationResponse2, d d3) {
        return n1.h(dogTrainingDurationResponse2, d3);
    }

    private static final void d(m0 m0, app.dogo.com.dogo_android.s.b.n1 n12, c0 c03) {
        n.f(m0, "$scope");
        n.f(n12, "this$0");
        n.f(c03, "emitter");
        n1.c cVar = new n1.c(c03, n12, 0);
        k.d(m0, 0, 0, cVar, 3, 0);
    }

    public static void f(m0 m0, app.dogo.com.dogo_android.s.b.n1 n12, c0 c03) {
        n1.d(m0, n12, c03);
    }

    private final TrainingStreakEntity g(DogTrainingDurationResponse dogTrainingDurationResponse) {
        super(this.c.v(), dogTrainingDurationResponse.getDailyTrainingTimeGoalStreak().getCurrentStreak(), dogTrainingDurationResponse.getDailyTrainingTimeGoalStreak().getLongestStreak(), dogTrainingDurationResponse.getDailyTrainingTimes(), dogTrainingDurationResponse.getTotalTrainingTimeSec(), obj6, this.d.g(), obj8);
        return trainingStreakEntity2;
    }

    private final Object h(DogTrainingDurationResponse dogTrainingDurationResponse, d<? super TrainingStreakEntity> d2) {
        boolean eVar;
        int label2;
        int i3;
        int label;
        int i;
        int i2;
        Object obj6;
        Object obj7;
        eVar = d2;
        label2 = eVar.label;
        i3 = Integer.MIN_VALUE;
        if (d2 instanceof n1.e && label2 & i3 != 0) {
            eVar = d2;
            label2 = eVar.label;
            i3 = Integer.MIN_VALUE;
            if (label2 & i3 != 0) {
                eVar.label = label2 -= i3;
            } else {
                eVar = new n1.e(this, d2);
            }
        } else {
        }
        obj7 = eVar.result;
        Object obj = b.d();
        label = eVar.label;
        int i4 = 1;
        if (label != 0) {
            if (label != i4) {
            } else {
                obj6 = eVar.L$0;
                q.b(obj7);
                return obj6;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        obj6 = g(dogTrainingDurationResponse);
        label = new TrainingStreakEntity[i4];
        label[0] = obj6;
        eVar.L$0 = obj6;
        eVar.label = i4;
        if (this.e.b(label, eVar) == obj) {
            return obj;
        }
    }

    private final Object j(String string, s s2, d<? super DogTrainingDurationResponse> d3) {
        final long l = (long)i;
        if (s2 instanceof s.a) {
            return this.n(string, l, obj4, (s.a)s2);
        }
        if (s2 instanceof s.b) {
            return this.o(string, l, obj4, (s.b)s2);
        }
        if (s2 instanceof s.c) {
            return this.l(string, l, obj4, (s.c)s2);
        }
        if (s2 instanceof s.d) {
            return this.m(string, l, obj4, (s.d)s2);
        }
        if (!s2 instanceof s.e) {
        } else {
            return this.k(string, l, obj4, (s.e)s2);
        }
        NoWhenBranchMatchedException obj8 = new NoWhenBranchMatchedException();
        throw obj8;
    }

    private final Object k(String string, long l2, s.e s$e3, d<? super DogTrainingDurationResponse> d4) {
        DogWorkoutDurationRequest dogWorkoutDurationRequest = new DogWorkoutDurationRequest(l2, e3, (long)obj8, obj3);
        return this.a.updateDogWorkoutDuration(string, dogWorkoutDurationRequest, obj9);
    }

    private final Object l(String string, long l2, s.c s$c3, d<? super DogTrainingDurationResponse> d4) {
        final Object obj = this;
        if (l.z(d4.c())) {
            DogSpecialProgramTrickDurationRequest dogSpecialProgramTrickDurationRequest = new DogSpecialProgramTrickDurationRequest(l2, obj13, (long)i, obj8);
            return obj.a.updateSpecialDogProgramTrickDuration(string, d4.e(), d4.d(), dogSpecialProgramTrickDurationRequest, obj21);
        }
        super(d4.c(), d4.b(), l2, obj13, (long)i2, obj15);
        return obj.a.updateDogProgramTrickDuration(string, d4.e(), d4.d(), dogProgramTrickDurationRequest, obj21);
    }

    private final Object m(String string, long l2, s.d s$d3, d<? super DogTrainingDurationResponse> d4) {
        final Object obj = this;
        if (l.z(d4.c())) {
            DogSpecialProgramVariationDurationRequest request = dogSpecialProgramVariationDurationRequest;
            super(d4.f(), l2, obj9, (long)i, obj11);
            return obj.a.updateSpecialDogProgramVariationDuration(string, d4.e(), d4.d(), request, obj19);
        }
        DogProgramVariationDurationRequest request2 = dogProgramVariationDurationRequest;
        super(d4.c(), d4.b(), d4.f(), l2, obj11, (long)i2, obj13);
        return obj.a.updateDogProgramVariationDuration(string, d4.e(), d4.d(), request2, obj19);
    }

    private final Object n(String string, long l2, s.a s$a3, d<? super DogTrainingDurationResponse> d4) {
        DogTrickDurationRequest dogTrickDurationRequest = new DogTrickDurationRequest(l2, a3, (long)obj9, obj4);
        return this.a.updateDogTrickDuration(string, d4.b(), dogTrickDurationRequest, obj10);
    }

    private final Object o(String string, long l2, s.b s$b3, d<? super DogTrainingDurationResponse> d4) {
        super(d4.c(), l2, obj5, (long)obj13, obj7);
        return this.a.updateDogTrickVariationDuration(string, d4.b(), dogTrickVariationDurationRequest, obj14);
    }

    public final Object b(d<? super TrainingStreakEntity> d) {
        boolean bVar;
        int label;
        int i2;
        app.dogo.com.dogo_android.s.b.n1 label2;
        int i3;
        int i4;
        int i5;
        int cmp;
        int i;
        long l;
        Object obj13;
        bVar = d;
        label = bVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof n1.b && label & i2 != 0) {
            bVar = d;
            label = bVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                bVar.label = label -= i2;
            } else {
                bVar = new n1.b(this, d);
            }
        } else {
        }
        obj13 = bVar.result;
        Object obj = b.d();
        label2 = bVar.label;
        int i6 = 3;
        i4 = 2;
        i5 = 1;
        if (label2 != 0) {
            if (label2 != i5) {
                if (label2 != i4) {
                    if (label2 != i6) {
                    } else {
                        q.b(obj13);
                        return obj13;
                    }
                    obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj13;
                }
                label2 = bVar.L$0;
                q.b(obj13);
            } else {
                label2 = bVar.L$0;
                q.b(obj13);
                if (Long.compare(l2, i) < 0) {
                } else {
                    i5 = 0;
                }
                if (i5 != 0) {
                    return obj13;
                }
                bVar.L$0 = label2;
                bVar.label = i4;
                if (label2.a.getTrainingTimeMetrics(bVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj13);
            bVar.L$0 = this;
            bVar.label = i5;
            if (this.e.c(this.c.v(), bVar) == obj) {
                return obj;
            }
            label2 = this;
        }
        bVar.L$0 = 0;
        bVar.label = i6;
        if (label2.h((DogTrainingDurationResponse)obj13, bVar) == obj) {
            return obj;
        }
    }

    public final a0<TrainingStreakEntity> c(m0 m0) {
        n.f(m0, "scope");
        b0 b0Var = new b0(m0, this);
        final a0 obj2 = a0.create(b0Var);
        n.e(obj2, "create { emitter ->\n            scope.launch {\n                try {\n                    emitter.onSuccess(getTimeTrained())\n                } catch (e: Exception) {\n                    emitter.onError(e)\n                }\n            }\n        }");
        return obj2;
    }

    public final Object e(d<? super TrainingStreakEntity> d) {
        boolean dVar;
        int label;
        int i;
        app.dogo.com.dogo_android.s.b.n1 label2;
        int i4;
        int i5;
        InitialTrainingStreakSyncRequest request;
        int i6;
        long l;
        int i3;
        int i2;
        Object obj12;
        dVar = d;
        label = dVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof n1.d && label & i != 0) {
            dVar = d;
            label = dVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                dVar.label = label -= i;
            } else {
                dVar = new n1.d(this, d);
            }
        } else {
        }
        obj12 = dVar.result;
        Object obj = b.d();
        label2 = dVar.label;
        int i7 = 2;
        i5 = 1;
        if (label2 != 0) {
            if (label2 != i5) {
                if (label2 != i7) {
                } else {
                    q.b(obj12);
                    return obj12;
                }
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
            }
            label2 = dVar.L$0;
            q.b(obj12);
        } else {
            q.b(obj12);
            super(0, (long)obj12, obj8, 1, 0);
            dVar.L$0 = this;
            dVar.label = i5;
            if (this.a.syncWorkoutStreakToTrainingMetrics(initialTrainingStreakSyncRequest, dVar) == obj) {
                return obj;
            }
            label2 = this;
        }
        dVar.L$0 = 0;
        dVar.label = i7;
        if (label2.h((DogTrainingDurationResponse)obj12, dVar) == obj) {
            return obj;
        }
    }

    public final Object i(String string, s s2, d<? super TrainingStreakEntity> d3) {
        boolean fVar;
        int label;
        int i;
        int i2;
        Object obj6;
        int obj7;
        Object obj8;
        fVar = d3;
        label = fVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof n1.f && label & i != 0) {
            fVar = d3;
            label = fVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                fVar.label = label -= i;
            } else {
                fVar = new n1.f(this, d3);
            }
        } else {
        }
        obj8 = fVar.result;
        Object obj = b.d();
        int label2 = fVar.label;
        int i3 = 2;
        final int i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
                if (label2 != i3) {
                } else {
                    q.b(obj8);
                    return obj8;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            obj6 = fVar.L$0;
            q.b(obj8);
        } else {
            q.b(obj8);
            fVar.L$0 = this;
            fVar.label = i4;
            if (j(string, s2, fVar) == obj) {
                return obj;
            }
            obj6 = this;
        }
        fVar.L$0 = 0;
        fVar.label = i3;
        if (obj6.h((DogTrainingDurationResponse)obj8, fVar) == obj) {
            return obj;
        }
    }
}
