package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.TrainingStreakEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity;
import app.dogo.android.persistencedb.room.entity.UserStateEntity.GoalNotReachedState;
import app.dogo.com.dogo_android.k.s;
import app.dogo.com.dogo_android.k.s.a;
import app.dogo.com.dogo_android.k.s.b;
import app.dogo.com.dogo_android.k.s.c;
import app.dogo.com.dogo_android.k.s.d;
import app.dogo.com.dogo_android.k.s.e;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus;
import app.dogo.com.dogo_android.s.b.n1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlin.y.h0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y1;

/* compiled from: TrainingTimeInteractor.kt */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0012\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J9\u0010$\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trainingTimeRepository", "Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lkotlinx/coroutines/CoroutineScope;)V", "deferredSaveOperation", "Lkotlinx/coroutines/Deferred;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getTimeTrained", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapTrainingTimeSaveData", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationMs", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickId", "", "variationId", "parseTrainingMetricsModel", "metricsModel", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "trainingGoalSec", "", "userStateEntity", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "saveTrainingTime", "(JLapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTimeInBackground", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q3, reason: from kotlin metadata */
public final class TrainingTimeInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final r2 deferredSaveOperation;
    /* renamed from: b, reason: from kotlin metadata */
    private final n1 externalScope;
    /* renamed from: c, reason: from kotlin metadata */
    private final p1 preferenceService;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 remoteConfigService;
    /* renamed from: e, reason: from kotlin metadata */
    private final p2 timeUtils;
    /* renamed from: f, reason: from kotlin metadata */
    private final m0 trainingTimeRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private u0<TrainingTimeMetrics> userRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor", f = "TrainingTimeInteractor.kt", l = {62, 64, 65, 71, 73}, m = "getTimeTrained")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super q3.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return q3.this.g(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor", f = "TrainingTimeInteractor.kt", l = {90, 93, 94}, m = "saveTrainingTime")
    static final class b extends kotlin.b0.k.a.d {

        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super q3.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return q3.this.j(0L, null, null, null, this);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor$saveTrainingTimeInBackground$1", f = "TrainingTimeInteractor.kt", l = 47, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ long $durationMs;
        final /* synthetic */ ProgramSaveInfo $programSaveInfo;
        final /* synthetic */ String $trickId;
        final /* synthetic */ String $variationId;
        private /* synthetic */ Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            m0 m0Var;
            Object obj;
            Object obj2 = b.d();
            int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    kotlinx.coroutines.q3.d.a aVar = new kotlinx.coroutines.q3.d.a(q3.this, (String)obj, q3.this.saveTrainingTime(this.$durationMs, l, this.$programSaveInfo, this.$trickId, this.$variationId), q3.this.deferredSaveOperation.s(), null);
                    q3.this.userRepository = kotlinx.coroutines.internal.k.b(m0Var, null, null, aVar, 3, null);
                    return w.a;
                }
            }
            q.b(object);
            this.L$0 = object2;
            this.label = i2;
            obj = q3.this.preferenceService.u(this);
            if (obj == obj2) {
                return obj2;
            }
        }

        d(long j, ProgramSaveInfo programSaveInfo, String str, String str2, kotlin.b0.d<? super q3.d> dVar) {
            this.$durationMs = j;
            this.$programSaveInfo = programSaveInfo;
            this.$trickId = str;
            this.$variationId = str2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.q3.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            dVar = new kotlinx.coroutines.q3.d(q3.this, this.$durationMs, programSaveInfo, this.$programSaveInfo, this.$trickId, this.$variationId, dVar);
            dVar.L$0 = object;
            return dVar;
        }
    }
    public q3(r2 r2Var, n1 n1Var, p1 p1Var, v2 v2Var, p2 p2Var, m0 m0Var) {
        n.f(r2Var, "remoteConfigService");
        n.f(n1Var, "trainingTimeRepository");
        n.f(p1Var, "userRepository");
        n.f(v2Var, "timeUtils");
        n.f(p2Var, "preferenceService");
        n.f(m0Var, "externalScope");
        super();
        this.deferredSaveOperation = r2Var;
        this.externalScope = n1Var;
        this.preferenceService = p1Var;
        this.remoteConfigService = v2Var;
        this.timeUtils = p2Var;
        this.trainingTimeRepository = m0Var;
    }

    public static final /* synthetic */ r2 a(q3 q3Var) {
        return q3Var.deferredSaveOperation;
    }

    public static final /* synthetic */ n1 b(q3 q3Var) {
        return q3Var.externalScope;
    }

    public static final /* synthetic */ p1 c(q3 q3Var) {
        return q3Var.preferenceService;
    }

    public static final /* synthetic */ s d(q3 q3Var, long j, ProgramSaveInfo programSaveInfo, String str, String str2) {
        return q3Var.saveTrainingTime(j, programSaveInfo, str, str2);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final /* synthetic */ TrainingTimeMetrics mapTrainingTimeSaveData(q3 durationMs, TrainingStreakEntity programSaveInfo, int trickId, UserStateEntity variationId) {
        return durationMs.parseTrainingMetricsModel(programSaveInfo, trickId, variationId);
    }

    public static final /* synthetic */ void f(q3 q3Var, u0 u0Var) {
        q3Var.userRepository = u0Var;
    }

    /* renamed from: h, reason: from kotlin metadata */
    /* suspend */ private final s saveTrainingTime(long durationMs, ProgramSaveInfo programSaveInfo, String trickId, String variationId) {
        s.d durationMs2;
        long l;
        l = durationMs / (long)1000;
        final int i3 = (int)l;
        if (programSaveInfo != null) {
            if (!l.z(variationId) != 0) {
                if (!l.z(trickId) != 0) {
                    durationMs2 = new TrainingTimeSaveData_ProgramVariationSaveData(i3, trickId, programSaveInfo.getProgramId(), variationId, programSaveInfo.getModuleId(), programSaveInfo.getLessonId());
                } else {
                    if (programSaveInfo != null) {
                        if (!l.z(trickId) != 0) {
                            TrainingTimeSaveData_ProgramTrickSaveData durationMs3 = new TrainingTimeSaveData_ProgramTrickSaveData(i3, trickId, programSaveInfo.getProgramId(), programSaveInfo.getModuleId(), programSaveInfo.getLessonId());
                        } else {
                            i = !l.z(variationId);
                            if (!l.z(variationId) != 0) {
                                i = !l.z(trickId);
                                if (!l.z(trickId) != 0) {
                                    s.b trainingTimeSaveData_LibraryTrickVariationSaveData = new TrainingTimeSaveData_LibraryTrickVariationSaveData(i3, trickId, variationId);
                                } else {
                                    durationMs = !l.z(trickId) != 0 ? new TrainingTimeSaveData_LibraryTrickSaveData(i3, trickId) : new TrainingTimeSaveData_WorkoutSaveData(i3);
                                }
                            }
                        }
                    }
                }
            }
        }
        return (!l.z(trickId) != 0 ? new TrainingTimeSaveData_LibraryTrickSaveData(i3, trickId) : new TrainingTimeSaveData_WorkoutSaveData(i3));
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final TrainingTimeMetrics parseTrainingMetricsModel(TrainingStreakEntity metricsModel, int trainingGoalSec, UserStateEntity userStateEntity) {
        Object value;
        String date = null;
        int i2 = 0;
        int i3 = 0;
        int trainingGoalSec2;
        int i4 = 0;
        List subList;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus bROKEN2;
        int durationSec = 0;
        int i5 = 10;
        boolean hasNext2;
        ArrayList arrayList2;
        int value2 = 0;
        int i6 = 7;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus nONE2;
        String format;
        boolean z4 = false;
        int i7;
        int i8;
        String str;
        String str2;
        int i9;
        Object obj;
        final Object metricsModel2 = this;
        trainingGoalSec2 = trainingGoalSec;
        Calendar calendar = metricsModel2.remoteConfigService.f();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", LocaleService.b(metricsModel2.timeUtils.W()));
        final String format3 = simpleDateFormat.format(calendar.getTime());
        value2 = 0;
        i6 = 7;
        kotlin.h0.f fVar = g.l(value2, i6);
        i5 = 10;
        arrayList2 = new ArrayList(p.r(fVar, i5));
        final Iterator it = fVar.iterator();
        while (it.hasNext()) {
            calendar.set(i6, calendar.getFirstDayOfWeek() + (IntIterator)it.d());
            String format2 = simpleDateFormat.format(calendar.getTime());
            value = metricsModel.getTrainingTimesSec().get(format2);
            n.e(format2, "currentDate");
            format = new SimpleDateFormat("E", LocaleService.b(metricsModel2.timeUtils.W())).format(calendar.getTime());
            n.e(format, "weekdayFormat.format(calendar.time)");
            fVar = new TrainingTimeMetrics_TrainingTimeDay(z2, value2, trainingGoalSec, format2, format, nONE2);
            arrayList2.add(trainingTimeMetrics_TrainingTimeDay);
            i5 = 10;
            value2 = 0;
            i6 = 7;
        }
        Iterator it2 = arrayList2.iterator();
        i3 = 0;
        while (it2.hasNext()) {
            if ((TrainingTimeMetrics_TrainingTimeDay)it2.next().isToday()) {
                break;
            }
        }
        i3 = -1;
        ArrayList arrayList = new ArrayList(p.r(arrayList2, 10));
        Iterator it3 = arrayList2.iterator();
        i4 = 0;
        i5 = 1;
        while (it3.hasNext()) {
            calendar = i4 + 1;
            if (i4 < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
        UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState = userStateEntity.getLastSeenGoalNotReachedState();
        if (lastSeenGoalNotReachedState != null) {
            date = lastSeenGoalNotReachedState.getDate();
        }
        if (n.b(date, format3)) {
            n.d(lastSeenGoalNotReachedState);
        } else {
            durationSec = 0;
        }
        TrainingTimeMetrics trainingTimeMetrics = new TrainingTimeMetrics(arrayList, metricsModel.getCurrentStreak(), durationSec, metricsModel2.deferredSaveOperation.g0(), i5 ^ metricsModel.getTrainingTimesSec().isEmpty(), z3);
        return trainingTimeMetrics;
    }

    public static /* synthetic */ Object k(q3 q3Var, long j, ProgramSaveInfo programSaveInfo, String str, String str2, kotlin.b0.d dVar, int i, Object object) {
        String str52;
        Object obj;
        if (i & 2 != 0) {
            i = 0;
        }
        str52 = "";
        String r4 = i & 4 != 0 ? str52 : str;
        String r5 = i & 8 != 0 ? str52 : str2;
        return q3Var.j(j, programSaveInfo, i, str52, (i & 8 != 0 ? str52 : str2), dVar);
    }

    public static /* synthetic */ void m(q3 q3Var, long j, ProgramSaveInfo programSaveInfo, String str, String str2, int i, Object object) {
        String str52;
        if (i & 2 != 0) {
            i = 0;
        }
        str52 = "";
        String r4 = i & 4 != 0 ? str52 : str;
        String r5 = i & 8 != 0 ? str52 : str2;
        q3Var.saveTrainingTimeInBackground(j, i, str52, (i & 8 != 0 ? str52 : str2));
    }

    public final Object g(kotlin.b0.d<? super TrainingTimeMetrics> dVar) {
        Object dVar2;
        Object dVar3;
        int label2;
        TrainingStreakEntity trainingStreakEntity;
        UserStateEntity userStateEntity2;
        int i = -2147483648;
        UserStateEntity userStateEntity;
        int i2;
        p1 preferenceService2;
        int i3 = 4;
        boolean z2;
        u0 userRepository2;
        int i4 = 3;
        int i5 = 2;
        boolean workoutStreakSyncedToTrainingMetrics;
        TrainingTimeMetrics dVar4;
        TrainingStreakEntity trainingStreakEntity2;
        z = dVar instanceof kotlinx.coroutines.q3.a;
        if (dVar instanceof kotlinx.coroutines.q3.a) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.q3.a aVar = new kotlinx.coroutines.q3.a(this, dVar);
            }
        }
        Object obj3 = b.d();
        int i8 = 5;
        i3 = 4;
        i4 = 3;
        i5 = 2;
        i5 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i5) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4 && dVar2.label != i3) {
                        if (dVar2.label != i8) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar2.result);
                            dVar4 = dVar3.parseTrainingMetricsModel((TrainingStreakEntity)trainingStreakEntity2, dVar3.deferredSaveOperation.s(), userStateEntity2);
                        }
                    }
                    q.b(dVar2.result);
                } else {
                    q.b(dVar2.result);
                    dVar2.L$0 = dVar3;
                    dVar2.L$1 = dVar3;
                    dVar2.L$2 = dVar3;
                    dVar2.label = i4;
                    if (dVar3.preferenceService.n0(dVar2) == obj3) {
                        return obj3;
                    }
                }
                dVar4 = dVar3.parseTrainingMetricsModel(trainingStreakEntity, dVar3.deferredSaveOperation.s(), userStateEntity);
            } else {
                q.b(dVar2.result);
                if (!dVar3.isWorkoutStreakSyncedToTrainingMetrics()) {
                    dVar2.L$0 = dVar3;
                    dVar2.L$1 = dVar3;
                    dVar2.label = i5;
                    dVar3 = dVar3.externalScope.e(dVar2);
                    if (dVar3 == obj3) {
                        return obj3;
                    }
                } else {
                    i5 = 0;
                    int r7 = dVar3.userRepository == null ? 0 : i5;
                    if (i5 != 0) {
                        n.d(dVar3.userRepository);
                        dVar2.L$0 = null;
                        dVar2.label = i3;
                        return dVar3.userRepository.o(dVar2) == obj3 ? obj3 : dVar3;
                    }
                    dVar2.L$0 = dVar3;
                    dVar2.L$1 = dVar3;
                    dVar2.label = i8;
                    Object obj = dVar3.externalScope.b(dVar2);
                    if (obj == obj3) {
                        return obj3;
                    }
                }
            }
        } else {
            q.b(dVar2.result);
            if (this.deferredSaveOperation.g0()) {
                dVar2.L$0 = this;
                dVar2.label = i5;
                if (this.preferenceService.J(dVar2) == obj3) {
                    return obj3;
                }
                app.dogo.com.dogo_android.s.a.q3 dVar5 = this;
            } else {
                i5 = 63;
                dVar4 = new TrainingTimeMetrics(null, 0, 0, false, false, false, i5, null);
            }
        }
        return dVar4;
    }

    public final Object j(long j, ProgramSaveInfo programSaveInfo, String str, String str2, kotlin.b0.d<? super TrainingTimeMetrics> dVar) {
        TrainingStreakEntity trainingStreakEntity;
        TrainingTimeMetrics trainingMetricsModel;
        Object result2;
        Object obj;
        Object obj2;
        int label2;
        int i;
        int i2 = -2147483648;
        UserStateEntity userStateEntity;
        ProgramSaveInfo str32;
        int i3;
        int i5 = 2;
        s trainingTime;
        int i6 = 1;
        app.dogo.com.dogo_android.s.a.q3 q3Var;
        String str5;
        Object str42;
        Object dVar52;
        long j2;
        Object obj5;
        Object obj6;
        q3Var = this;
        obj = dVar;
        z = obj instanceof kotlinx.coroutines.q3.b;
        if (obj instanceof kotlinx.coroutines.q3.b) {
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                obj.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.a.q3.b bVar = new kotlinx.coroutines.q3.b(q3Var, obj);
            }
        }
        Object obj8 = b.d();
        Object obj4 = null;
        int i4 = 3;
        i5 = 2;
        i6 = 1;
        if (obj.label != 0) {
            if (obj.label != i6) {
                if (obj.label != i5) {
                    if (obj.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(obj.result);
                        trainingMetricsModel = obj2.parseTrainingMetricsModel((TrainingStreakEntity)trainingStreakEntity, i, userStateEntity);
                    }
                }
                q.b(obj.result);
            } else {
                q.b(obj.result);
                trainingTime = q3Var.saveTrainingTime(j2, str32, str42, dVar52);
                obj.L$0 = q3Var;
                obj.L$1 = result2;
                obj.L$2 = trainingTime;
                obj.L$3 = obj4;
                obj.I$0 = q3Var.deferredSaveOperation.s();
                obj.label = i5;
                result2 = q3Var.preferenceService.J(obj);
                if (result2 == obj8) {
                    return obj8;
                }
            }
            obj.L$0 = q3Var;
            obj.L$1 = (UserStateEntity)result2;
            obj.L$2 = obj4;
            obj.I$0 = i;
            obj.label = i4;
            if (q3Var.externalScope.i(str5, trainingTime, obj) == obj8) {
                return obj8;
            }
        } else {
            q.b(obj.result);
            if (q3Var.deferredSaveOperation.g0()) {
                obj.L$0 = q3Var;
                obj.L$1 = programSaveInfo;
                obj.L$2 = str;
                obj.L$3 = str2;
                obj.J$0 = j;
                obj.label = i6;
                if (q3Var.preferenceService.u(obj) == obj8) {
                    return obj8;
                }
            } else {
                trainingMetricsModel = new TrainingTimeMetrics(null, 0, 0, false, false, false, 63, null);
            }
        }
        return trainingMetricsModel;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final void saveTrainingTimeInBackground(long durationMs, ProgramSaveInfo programSaveInfo, String trickId, String variationId) {
        final Object durationMs4 = this;
        n.f(trickId, "trickId");
        n.f(variationId, "variationId");
        if (durationMs4.deferredSaveOperation.g0()) {
            int i2 = 0;
            int i = 0;
            kotlinx.coroutines.q3.d dVar = new kotlinx.coroutines.q3.d(this, durationMs, programSaveInfo2, programSaveInfo, trickId, variationId, i);
            Object obj2 = null;
            kotlinx.coroutines.internal.k.d(trainingTimeRepository2, new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r), i2, dVar, 2, obj2);
        }
    }

    public /* synthetic */ q3(r2 r2Var, n1 n1Var, p1 p1Var, v2 v2Var, p2 p2Var, m0 m0Var, int i, kotlin.d0.d.g gVar) {
        r1 r1Var;
        r1Var = i & 32 != 0 ? GlobalScope.a : r1Var;
        this(r2Var, n1Var, p1Var, v2Var, p2Var, r1Var);
    }
}
