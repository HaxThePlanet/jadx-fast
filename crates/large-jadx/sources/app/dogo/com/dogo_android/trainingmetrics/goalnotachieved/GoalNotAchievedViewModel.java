package app.dogo.com.dogo_android.x.b;

import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.m0;
import n.a.a;

/* compiled from: GoalNotAchievedViewModel.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0008J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "trickRatingList", "", "", "viewSource", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/util/List;Ljava/lang/String;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getMotivationMessageRes", "getSpentTimeFormatted", "getTimeGoalMinutes", "", "getTimeGoalSeconds", "updateGoalNotReachedState", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class GoalNotAchievedViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final d.a INSTANCE = new d$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final TrainingTimeMetrics preferenceService;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<Integer> remoteConfigService;
    private final String c;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 timeUtils;
    /* renamed from: e, reason: from kotlin metadata */
    private final p1 trickRatingList;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 userRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private final v2 viewSource;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel$Companion;", "", "()V", "TRAINING_TIME_REF_SEC", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.GoalNotAchievedViewModel$updateGoalNotReachedState$1", f = "GoalNotAchievedViewModel.kt", l = 32, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            String format = new SimpleDateFormat("yyyy-MM-dd", LocaleService.b(d.this.userRepository.W())).format(d.this.viewSource.f().getTime());
            n.e(format, "todayDate");
            this.label = i;
            if (d.this.trickRatingList.x0(format, d.this.o().getTodayTrainingTimeSeconds(), this) == obj2) {
                return obj2;
            }
        }

        b(d<? super d.b> dVar) {
            super(2, dVar2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.d.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.d.b(d.this, dVar);
        }
    }
    public d(TrainingTimeMetrics trainingTimeMetrics, List<Integer> list, String str, r2 r2Var, p1 p1Var, p2 p2Var, v2 v2Var) {
        n.f(trainingTimeMetrics, "timeMetrics");
        n.f(list, "trickRatingList");
        n.f(str, "viewSource");
        n.f(r2Var, "remoteConfigService");
        n.f(p1Var, "userRepository");
        n.f(p2Var, "preferenceService");
        n.f(v2Var, "timeUtils");
        super();
        this.preferenceService = trainingTimeMetrics;
        this.remoteConfigService = list;
        this.c = str;
        this.timeUtils = r2Var;
        this.trickRatingList = p1Var;
        this.userRepository = p2Var;
        this.viewSource = v2Var;
    }

    public static final /* synthetic */ p2 h(d dVar) {
        return dVar.userRepository;
    }

    public static final /* synthetic */ v2 i(d dVar) {
        return dVar.viewSource;
    }

    public static final /* synthetic */ p1 j(d dVar) {
        return dVar.trickRatingList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final int getMotivationMessageRes() {
        int i;
        boolean hasNext;
        int i2 = 4;
        int i3 = 2131887528;
        i = 0;
        i = 1;
        int r0 = i;
        hasNext = remoteConfigService23 instanceof Collection;
        int r3 = i;
        if (this.preferenceService.getTodayTrainingTimeSeconds() <= 40) {
        }
        boolean z = n.b(this.c, "lesson");
        boolean z2 = n.b(this.c, "workout");
        i3 = 2131887527;
        if (i == 0 || !z2) {
            int r5 = R.string.time.streak.poor.exercise.lesson.not.reached;
        } else {
            r5 = 2131887534;
        }
        return R.string.time.streak.poor.exercise.lesson.not.reached;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String l() {
        long l = (long)this.preferenceService.getTodayTrainingTimeSeconds();
        final long l4 = 1L;
        int i3 = 2;
        final Object[] arr = new Object[i3];
        arr[0] = Long.valueOf(TimeUnit.SECONDS.toMinutes(l));
        arr[1] = Long.valueOf(l % TimeUnit.MINUTES.toSeconds(l4));
        String formatted = String.format("%d:%02d", Arrays.copyOf(arr, i3));
        n.e(formatted, "java.lang.String.format(format, *args)");
        return formatted;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long m() {
        return TimeUnit.SECONDS.toMinutes((long)n());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int n() {
        return this.timeUtils.s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrainingTimeMetrics o() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), dVar, null, new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.d.b(this, dVar), 3, null);
    }

}
