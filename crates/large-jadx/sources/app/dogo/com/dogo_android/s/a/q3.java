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
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y1;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0012\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J9\u0010$\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trainingTimeRepository", "Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TrainingTimeRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lkotlinx/coroutines/CoroutineScope;)V", "deferredSaveOperation", "Lkotlinx/coroutines/Deferred;", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getTimeTrained", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapTrainingTimeSaveData", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationMs", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickId", "", "variationId", "parseTrainingMetricsModel", "metricsModel", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "trainingGoalSec", "", "userStateEntity", "Lapp/dogo/android/persistencedb/room/entity/UserStateEntity;", "saveTrainingTime", "(JLapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingTimeInBackground", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q3 {

    private final r2 a;
    private final n1 b;
    private final p1 c;
    private final v2 d;
    private final p2 e;
    private final m0 f;
    private u0<TrainingTimeMetrics> g;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor", f = "TrainingTimeInteractor.kt", l = {62, 64, 65, 71, 73}, m = "getTimeTrained")
    static final class a extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.q3 this$0;
        a(app.dogo.com.dogo_android.s.a.q3 q3, d<? super app.dogo.com.dogo_android.s.a.q3.a> d2) {
            this.this$0 = q3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.g(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor", f = "TrainingTimeInteractor.kt", l = {90, 93, 94}, m = "saveTrainingTime")
    static final class b extends d {

        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.q3 this$0;
        b(app.dogo.com.dogo_android.s.a.q3 q3, d<? super app.dogo.com.dogo_android.s.a.q3.b> d2) {
            this.this$0 = q3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj8 |= i;
            return this.this$0.j(0, obj2, 0, 0, 0);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingTimeInteractor$saveTrainingTimeInBackground$1", f = "TrainingTimeInteractor.kt", l = 47, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        final long $durationMs;
        final ProgramSaveInfo $programSaveInfo;
        final String $trickId;
        final String $variationId;
        private Object L$0;
        int label;
        final app.dogo.com.dogo_android.s.a.q3 this$0;
        d(app.dogo.com.dogo_android.s.a.q3 q3, long l2, ProgramSaveInfo programSaveInfo3, String string4, String string5, d<? super app.dogo.com.dogo_android.s.a.q3.d> d6) {
            this.this$0 = q3;
            this.$durationMs = l2;
            this.$programSaveInfo = string4;
            this.$trickId = string5;
            this.$variationId = d6;
            super(2, obj7);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (q3.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$durationMs, obj3, this.$programSaveInfo, this.$trickId, this.$variationId, d2);
            dVar2.L$0 = object;
            return dVar2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            Object obj13;
            Object obj = b.d();
            label = this.label;
            int i2 = 1;
            if (label != 0) {
                if (label != i2) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    super(this.this$0, (String)obj13, q3.d(this.this$0, this.$durationMs, obj8, this.$programSaveInfo, this.$trickId), q3.a(this.this$0).s(), 0);
                    q3.f(this.this$0, k.b(l$0, 0, 0, aVar3, 3, 0));
                    return w.a;
                }
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
            }
            q.b(object);
            obj13 = this.L$0;
            this.L$0 = (m0)obj13;
            this.label = i2;
            label = q3.c(this.this$0).u(this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj13;
            obj13 = label;
        }
    }
    public q3(r2 r2, n1 n12, p1 p13, v2 v24, p2 p25, m0 m06) {
        n.f(r2, "remoteConfigService");
        n.f(n12, "trainingTimeRepository");
        n.f(p13, "userRepository");
        n.f(v24, "timeUtils");
        n.f(p25, "preferenceService");
        n.f(m06, "externalScope");
        super();
        this.a = r2;
        this.b = n12;
        this.c = p13;
        this.d = v24;
        this.e = p25;
        this.f = m06;
    }

    public q3(r2 r2, n1 n12, p1 p13, v2 v24, p2 p25, m0 m06, int i7, g g8) {
        r1 obj13;
        obj13 = i7 &= 32 != 0 ? r1.a : obj13;
        super(r2, n12, p13, v24, p25, obj13);
    }

    public static final r2 a(app.dogo.com.dogo_android.s.a.q3 q3) {
        return q3.a;
    }

    public static final n1 b(app.dogo.com.dogo_android.s.a.q3 q3) {
        return q3.b;
    }

    public static final p1 c(app.dogo.com.dogo_android.s.a.q3 q3) {
        return q3.c;
    }

    public static final s d(app.dogo.com.dogo_android.s.a.q3 q3, long l2, ProgramSaveInfo programSaveInfo3, String string4, String string5) {
        return q3.h(l2, programSaveInfo3, string4, string5);
    }

    public static final TrainingTimeMetrics e(app.dogo.com.dogo_android.s.a.q3 q3, TrainingStreakEntity trainingStreakEntity2, int i3, UserStateEntity userStateEntity4) {
        return q3.i(trainingStreakEntity2, i3, userStateEntity4);
    }

    public static final void f(app.dogo.com.dogo_android.s.a.q3 q3, u0 u02) {
        q3.g = u02;
    }

    private final s h(long l, ProgramSaveInfo programSaveInfo2, String string3, String string4) {
        s.d dVar;
        java.lang.CharSequence charSequence;
        String programId;
        Object moduleId;
        String moduleId2;
        String lessonId;
        s obj8;
        final int i2 = (int)obj8;
        if (string3 != null && obj8 ^= 1 != 0 && obj8 ^= 1 != 0) {
            if (obj8 ^= 1 != 0) {
                if (obj8 ^= 1 != 0) {
                    super(i2, string4, string3.getProgramId(), obj12, string3.getModuleId(), string3.getLessonId());
                } else {
                    if (string3 != null && obj8 ^= 1 != 0) {
                        if (obj8 ^= 1 != 0) {
                            super(i2, string4, string3.getProgramId(), string3.getModuleId(), string3.getLessonId());
                        } else {
                            if (obj8 ^= 1 != 0 && obj8 ^= 1 != 0) {
                                if (obj8 ^= 1 != 0) {
                                    obj8 = new s.b(i2, string4, obj12);
                                } else {
                                    if (obj8 ^= 1 != 0) {
                                        obj8 = new s.a(i2, string4);
                                    } else {
                                        obj8 = new s.e(i2);
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return obj8;
    }

    private final TrainingTimeMetrics i(TrainingStreakEntity trainingStreakEntity, int i2, UserStateEntity userStateEntity3) {
        kotlin.h0.f fVar;
        Object intValue;
        int i10;
        String valueOf;
        boolean durationSec;
        int i11;
        int i7;
        int today;
        String format;
        int bROKEN;
        Object subList;
        int i8;
        int empty;
        ArrayList arrayList;
        Calendar calendar;
        int i4;
        int i14;
        int i12;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus copy$default;
        String str;
        int i6;
        int i9;
        int i13;
        int i3;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus time;
        int i5;
        int i;
        final Object obj = this;
        int i20 = i2;
        calendar = obj.d.f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", n2.b(obj.e.W()));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("E", n2.b(obj.e.W()));
        final String format3 = simpleDateFormat.format(calendar.getTime());
        fVar = g.l(0, 7);
        arrayList = new ArrayList(p.r(fVar, 10));
        final Iterator iterator3 = fVar.iterator();
        while (iterator3.hasNext()) {
            calendar.set(i14, firstDayOfWeek += i15);
            format = simpleDateFormat.format(calendar.getTime());
            intValue = trainingStreakEntity.getTrainingTimesSec().get(format);
            if ((Long)intValue == null) {
            } else {
            }
            valueOf = Integer.valueOf((int)longValue);
            if (valueOf == 0) {
            } else {
            }
            i12 = intValue;
            n.e(format, "currentDate");
            String format2 = simpleDateFormat2.format(calendar.getTime());
            n.e(format2, "weekdayFormat.format(calendar.time)");
            int i21 = empty;
            ArrayList list3 = arrayList;
            super(n.b(format, format3), i12, i2, format, format2, TrainingTimeMetrics.TrainingTimeDay.StreakStatus.NONE);
            list3.add(trainingTimeDay);
            arrayList = list3;
            empty = 10;
            i4 = 0;
            i14 = 7;
            i12 = i4;
        }
        ArrayList list2 = arrayList;
        Iterator iterator = list2.iterator();
        i7 = 0;
        for (TrainingTimeMetrics.TrainingTimeDay next2 : iterator) {
            i7++;
        }
        i7 = -1;
        ArrayList arrayList2 = new ArrayList(p.r(list2, 10));
        Iterator iterator2 = list2.iterator();
        bROKEN = 0;
        arrayList = 1;
        for (Object next4 : iterator2) {
            copy$default = next4;
            if ((TrainingTimeMetrics.TrainingTimeDay)copy$default.getDurationSec() >= i20) {
            } else {
            }
            empty = 0;
            if (empty != 0 && bROKEN <= i7) {
            }
            arrayList2.add(copy$default);
            bROKEN = calendar;
            arrayList = 1;
            if (bROKEN <= i7) {
            }
            subList = list2.subList(bROKEN, i7);
            if (subList instanceof Collection != null && subList.isEmpty()) {
            } else {
            }
            subList = subList.iterator();
            while (subList.hasNext()) {
                if ((TrainingTimeMetrics.TrainingTimeDay)subList.next().getDurationSec() >= i20) {
                } else {
                }
                empty = 0;
                if (!empty) {
                    break loop_27;
                } else {
                }
                empty = arrayList;
            }
            if (arrayList == null) {
            } else {
            }
            bROKEN = TrainingTimeMetrics.TrainingTimeDay.StreakStatus.ACTIVE;
            copy$default = TrainingTimeMetrics.TrainingTimeDay.copy$default(copy$default, false, 0, 0, 0, 0, bROKEN, 31, 0);
            if (copy$default.isToday()) {
            } else {
            }
            bROKEN = TrainingTimeMetrics.TrainingTimeDay.StreakStatus.BROKEN;
            if ((TrainingTimeMetrics.TrainingTimeDay)subList.next().getDurationSec() >= i20) {
            } else {
            }
            empty = 0;
            if (!empty) {
            } else {
            }
            arrayList = 0;
            empty = arrayList;
            if (subList.isEmpty()) {
            } else {
            }
            empty = arrayList;
        }
        UserStateEntity.GoalNotReachedState lastSeenGoalNotReachedState = userStateEntity3.getLastSeenGoalNotReachedState();
        if (lastSeenGoalNotReachedState == null) {
        } else {
            valueOf = lastSeenGoalNotReachedState.getDate();
        }
        if (n.b(valueOf, format3)) {
            n.d(lastSeenGoalNotReachedState);
            i8 = durationSec;
        } else {
            i8 = 0;
        }
        super(arrayList2, trainingStreakEntity.getCurrentStreak(), i8, obj.a.g0(), arrayList ^= empty2, obj.e.l0());
        return trainingTimeMetrics;
    }

    public static Object k(app.dogo.com.dogo_android.s.a.q3 q3, long l2, ProgramSaveInfo programSaveInfo3, String string4, String string5, d d6, int i7, Object object8) {
        String str2;
        String str;
        int obj10;
        if (object8 & 2 != 0) {
            obj10 = 0;
        }
        String obj15 = "";
        str2 = object8 & 4 != 0 ? obj15 : string5;
        str = object8 & 8 != 0 ? obj15 : d6;
        return q3.j(l2, obj2, obj10, str2, str);
    }

    public static void m(app.dogo.com.dogo_android.s.a.q3 q3, long l2, ProgramSaveInfo programSaveInfo3, String string4, String string5, int i6, Object object7) {
        String str2;
        String str;
        int obj9;
        if (object7 & 2 != 0) {
            obj9 = 0;
        }
        String obj13 = "";
        str2 = object7 & 4 != 0 ? obj13 : string5;
        str = object7 & 8 != 0 ? obj13 : i6;
        q3.l(l2, obj2, obj9, str2);
    }

    public final Object g(d<? super TrainingTimeMetrics> d) {
        boolean aVar;
        Object l$0;
        int label;
        Object l$1;
        int i;
        int label2;
        Object l$12;
        int i2;
        Object i6;
        p1 i4;
        int i5;
        int i7;
        int i3;
        boolean workoutStreakSyncedToTrainingMetrics;
        Object obj;
        Object obj11;
        aVar = d;
        label = aVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof q3.a && label & i != 0) {
            aVar = d;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                aVar.label = label -= i;
            } else {
                aVar = new q3.a(this, d);
            }
        } else {
        }
        obj11 = aVar.result;
        Object obj4 = b.d();
        label2 = aVar.label;
        i6 = 5;
        i4 = 4;
        i5 = 3;
        i7 = 2;
        i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
                if (label2 != i7) {
                    if (label2 != i5 && label2 != i4) {
                        if (label2 != i4) {
                            if (label2 != i6) {
                            } else {
                                l$1 = aVar.L$1;
                                l$0 = aVar.L$0;
                                q.b(obj11);
                                obj11 = l$0.i((TrainingStreakEntity)obj11, l$0.a.s(), l$1);
                            }
                            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            throw obj11;
                        }
                        q.b(obj11);
                        return obj11;
                    }
                    l$1 = aVar.L$2;
                    l$12 = aVar.L$1;
                    l$0 = aVar.L$0;
                    q.b(obj11);
                } else {
                    q.b(obj11);
                    i6 = l$13;
                    label2 = obj;
                    aVar.L$0 = label2;
                    aVar.L$1 = i6;
                    aVar.L$2 = (TrainingStreakEntity)obj11;
                    aVar.label = i5;
                    if (label2.c.n0(aVar) == obj4) {
                        return obj4;
                    }
                    l$1 = obj11;
                    l$0 = label2;
                    l$12 = i6;
                }
                obj11 = l$0.i(l$1, l$0.a.s(), l$12);
            } else {
                label2 = aVar.L$0;
                q.b(obj11);
                if (!(UserStateEntity)obj11.isWorkoutStreakSyncedToTrainingMetrics()) {
                    aVar.L$0 = label2;
                    aVar.L$1 = obj11;
                    aVar.label = i7;
                    Object obj5 = label2.b.e(aVar);
                    if (obj5 == obj4) {
                        return obj4;
                    }
                    i6 = obj11;
                    obj11 = obj;
                } else {
                    i5 = label2.g;
                    if (i5 == null) {
                        i3 = i7;
                    } else {
                    }
                    obj11 = label2.g;
                    n.d(obj11);
                    aVar.L$0 = 0;
                    aVar.label = i4;
                    if (i3 != 0 && obj11.o(aVar) == obj4) {
                        obj11 = label2.g;
                        n.d(obj11);
                        aVar.L$0 = 0;
                        aVar.label = i4;
                        if (obj11.o(aVar) == obj4) {
                            return obj4;
                        }
                    }
                    aVar.L$0 = label2;
                    aVar.L$1 = obj11;
                    aVar.label = i6;
                    Object obj3 = label2.b.b(aVar);
                    if (obj3 == obj4) {
                        return obj4;
                    }
                    l$1 = obj11;
                    obj11 = obj3;
                    l$0 = label2;
                }
            }
        } else {
            q.b(obj11);
            if (this.a.g0()) {
                aVar.L$0 = this;
                aVar.label = i3;
                if (this.c.J(aVar) == obj4) {
                    return obj4;
                }
                label2 = this;
            } else {
                super(0, 0, 0, 0, 0, 0, 63, 0);
            }
        }
        return obj11;
    }

    public final Object j(long l, ProgramSaveInfo programSaveInfo2, String string3, String string4, d<? super TrainingTimeMetrics> d5) {
        Object result;
        TrainingTimeMetrics trainingTimeMetrics;
        boolean bVar;
        Object l$03;
        int label;
        int i$02;
        int i3;
        Object l$12;
        Object obj2;
        s i$0;
        int i2;
        int i4;
        int i5;
        int l$2;
        int l$1;
        Object q3Var;
        Object l$02;
        Object obj3;
        Object obj4;
        long l2;
        Object l$0;
        int i;
        Object obj;
        long l3;
        app.dogo.com.dogo_android.s.a.q3 obj18;
        long obj19;
        Object obj21;
        Object obj22;
        Object obj23;
        final app.dogo.com.dogo_android.s.a.q3 q3Var2 = this;
        Object obj5 = obj23;
        bVar = obj5;
        label = bVar.label;
        i3 = Integer.MIN_VALUE;
        if (obj5 instanceof q3.b && label & i3 != 0) {
            bVar = obj5;
            label = bVar.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                bVar.label = label -= i3;
            } else {
                bVar = new q3.b(q3Var2, obj5);
            }
        } else {
        }
        result = bVar.result;
        Object obj6 = b.d();
        int label2 = bVar.label;
        i4 = 0;
        i5 = 3;
        l$2 = 2;
        l$1 = 1;
        if (label2 != 0) {
            if (label2 != l$1) {
                if (label2 != l$2) {
                    if (label2 != i5) {
                    } else {
                        i$02 = bVar.I$0;
                        l$12 = bVar.L$1;
                        l$03 = bVar.L$0;
                        q.b(result);
                        trainingTimeMetrics = l$03.i((TrainingStreakEntity)result, i$02, l$12);
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                l$2 = bVar.L$2;
                l$1 = bVar.L$1;
                l$02 = bVar.L$0;
                q.b(result);
                i = i$0;
            } else {
                q.b(result);
                obj4 = l$3;
                obj2 = l$13;
                obj3 = obj;
                q3Var = l$0;
                l2 = l3;
                i$0 = q3Var.h(l2, string3, obj2, obj3);
                bVar.L$0 = q3Var;
                bVar.L$1 = (String)result;
                bVar.L$2 = i$0;
                bVar.L$3 = i4;
                bVar.I$0 = q3Var.a.s();
                bVar.label = l$2;
                Object obj7 = q3Var.c.J(bVar);
                if (obj7 == obj6) {
                    return obj6;
                }
                l$02 = q3Var;
                l$1 = result;
                result = obj7;
                l$2 = i$0;
            }
            bVar.L$0 = l$02;
            bVar.L$1 = (UserStateEntity)result;
            bVar.L$2 = i4;
            bVar.I$0 = i;
            bVar.label = i5;
            if (l$02.b.i(l$1, l$2, bVar) == obj6) {
                return obj6;
            }
            l$03 = l$02;
            i$02 = i;
        } else {
            q.b(result);
            if (q3Var2.a.g0()) {
                bVar.L$0 = q3Var2;
                bVar.L$1 = string3;
                bVar.L$2 = string4;
                bVar.L$3 = d5;
                bVar.J$0 = l;
                bVar.label = l$1;
                if (q3Var2.c.u(bVar) == obj6) {
                    return obj6;
                }
                q3Var = q3Var2;
            } else {
                super(0, 0, 0, 0, 0, 0, 63, 0);
            }
        }
        return trainingTimeMetrics;
    }

    public final void l(long l, ProgramSaveInfo programSaveInfo2, String string3, String string4) {
        boolean z;
        m0 m0Var;
        app.dogo.com.dogo_android.s.a.q3.c cVar;
        ProgramSaveInfo programSaveInfo;
        app.dogo.com.dogo_android.s.a.q3.d dVar2;
        Object obj2;
        Object obj;
        int i;
        app.dogo.com.dogo_android.s.a.q3.c cVar2;
        m0 m0Var2;
        int i2;
        app.dogo.com.dogo_android.s.a.q3.d dVar;
        final Object obj3 = this;
        n.f(string4, "trickId");
        n.f(obj18, "variationId");
        if (obj3.a.g0()) {
            cVar2 = new q3.c(CoroutineExceptionHandler.r);
            super(this, l, obj3, string3, string4, obj18, 0);
            k.d(obj3.f, cVar2, 0, dVar, 2, 0);
        }
    }
}
