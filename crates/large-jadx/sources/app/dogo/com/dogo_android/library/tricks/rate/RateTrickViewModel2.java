package app.dogo.com.dogo_android.n.m.t;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.s.a.q3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.v2;
import i.b.a0;
import i.b.r;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.l;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: RateTrickViewModel2.kt */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\r\u0008\u0016\u0018\u00002\u00020\u0001:\u0001RBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0018\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\u001f2\u0006\u00107\u001a\u000208H\u0002J\r\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010BJ\u0008\u0010C\u001a\u0004\u0018\u00010\u0007J\u0008\u0010D\u001a\u00020\u001fH\u0002J\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020F2\u0006\u00107\u001a\u000208J!\u0010H\u001a\u00020F2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u001f2\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020=J\u000e\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\u0007J\u0008\u0010N\u001a\u00020FH\u0002J\u0008\u0010O\u001a\u00020FH\u0002J\u0019\u0010P\u001a\u00020F2\u0006\u0010I\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010QR\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010)\u001a\u00020\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u001f\u0010,\u001a\u0010\u0012\u000c\u0012\n -*\u0004\u0018\u00010\u001f0\u001f0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010!R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\t0%¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010(R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u000208¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u001d\u0010;\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020=0<0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010(R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006S", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "screenName", "", "trainingDurationMs", "", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/lang/String;JLapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "animationSelection", "Landroidx/lifecycle/MutableLiveData;", "", "getAnimationSelection", "()Landroidx/lifecycle/MutableLiveData;", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "finished", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "getFinished", "()Lcom/hadilq/liveevent/LiveEvent;", "initialKnowledge", "getInitialKnowledge", "()I", "knowledge", "kotlin.jvm.PlatformType", "getKnowledge", "openZendeskArticle", "getOpenZendeskArticle", "getScreenName", "()Ljava/lang/String;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getTrainingDurationMs", "()J", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "updateKnowledge", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getUpdateKnowledge", "changed", "rank", "getArticleId", "()Ljava/lang/Long;", "getNextTrickName", "getRating", "onMoreTipsClicked", "", "saveIfChangedAndFinish", "saveTrick", "newRating", "(Ljava/lang/Integer;Lapp/dogo/com/dogo_android/repository/domain/TrickItem;)V", "shouldOpenTrainingReminders", "shouldShowVariationsUnlocked", "programId", "startAnimation", "trackMoreInfoClicked", "updateTrickKnowledge", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RateResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public class RateTrickViewModel2 extends s {

    private final app.dogo.com.dogo_android.n.m.n a;
    /* renamed from: b, reason: from kotlin metadata */
    private final DogProfile connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final String dispatcher;
    private final long d;
    private final q3 e;
    private final p1 f;
    private final p2 g;
    private final o3 h;
    /* renamed from: i, reason: from kotlin metadata */
    private final k1 preferenceService;
    /* renamed from: j, reason: from kotlin metadata */
    private final j2 programRepository;
    /* renamed from: k, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 rateRepository;
    /* renamed from: l, reason: from kotlin metadata */
    private final j1 remoteConfigService;
    private final h0 m;
    private final TrickItem n;
    /* renamed from: o, reason: from kotlin metadata */
    private final int tracker;
    private final x<Integer> p;
    /* renamed from: q, reason: from kotlin metadata */
    private final f.d.a.a<g.a> trainingTimeInteractor;
    private final f.d.a.a<Long> r;
    private final f.d.a.a<y<Boolean>> s;
    /* renamed from: t, reason: from kotlin metadata */
    private final x<Integer> userRepository;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\u0007\u0008B\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "", "knowledge", "", "(I)V", "getKnowledge", "()I", "Default", "TimeMetrics", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults$Default;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults$TimeMetrics;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a {
        private a(int i) {
            super();
        }

        public /* synthetic */ a(int i, kotlin.d0.d.g gVar) {
            this(i);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ g a;
        public b(CoroutineExceptionHandler.a exc, g gVar) {
            this.a = gVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.D().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements l<Throwable, w> {

        public static final g.d a = new g$d();

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements l<Long, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Long long) {
            Integer num = null;
            if (long == null) {
                int i2 = 0;
            } else {
                l2 = (long)5;
                l = (long.longValue() + 1L) % l2;
                num = Integer.valueOf((int)l);
            }
            g.this.q().postValue(num);
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.rate.RateTrickViewModel2$saveTrick$1", f = "RateTrickViewModel2.kt", l = {93, 97}, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ Integer $newRating;
        final /* synthetic */ TrickItem $trick;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.n.m.t.g.a.a rateTrickViewModel2_RateResults_Default;
            y.b bVar;
            int value;
            long l;
            q3 q3Var;
            long l2;
            long l3 = 0;
            ProgramSaveInfo programSaveInfo;
            String str;
            String variationId;
            Object obj;
            int value2;
            app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics;
            Object obj2 = b.d();
            int i = 2;
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        if (this.$newRating == null) {
                            value = g.this.u();
                        } else {
                            value = this.$newRating.intValue();
                        }
                        RateTrickViewModel2_RateResults_TimeMetrics rateTrickViewModel2_RateResults_TimeMetrics = new RateTrickViewModel2_RateResults_TimeMetrics(value, (TrainingTimeMetrics)trainingTimeMetrics);
                        g.this.f.g(g.this.s().getId(), "library");
                        g.this.D().postValue(new LoadResult_Success(b.a(true)));
                        g.this.t().postValue(rateTrickViewModel2_RateResults_Default);
                    }
                }
                q.b(object);
                g.this.preferenceService.c();
                if (g.this.rateRepository.g0()) {
                    l = g.this.B();
                    l3 = 0L;
                    if (l != l3) {
                        this.label = i;
                        if (g.this.e.j(g.this.B(), g.this.A().c(), this.$trick.getId(), this.$trick.getVariationId(), this) == obj2) {
                            return obj2;
                        }
                    } else {
                        if (this.$newRating == null) {
                            value2 = g.this.u();
                        } else {
                            value2 = this.$newRating.intValue();
                        }
                        rateTrickViewModel2_RateResults_Default = new RateTrickViewModel2_RateResults_Default(value2);
                    }
                }
            } else {
                q.b(object);
                g.this.D().postValue(LoadResult_Loading.a);
                if (g.this.programRepository.a()) {
                    if (this.$newRating != null && RateTrickViewModel2.o(g.this, this.$newRating.intValue(), this) == obj2) {
                        return obj2;
                    }
                } else {
                    g.this.h.setTrainingReminderUserProperties("rate_trick");
                    g.this.D().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
            return w.a;
        }

        c(Integer integer, TrickItem trickItem, d<? super g.c> dVar) {
            this.$newRating = integer;
            this.$trick = trickItem;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.library.tricks.rate.g.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.library.tricks.rate.g.c(g.this, this.$newRating, this.$trick, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.rate.RateTrickViewModel2$updateTrickKnowledge$2", f = "RateTrickViewModel2.kt", l = 181, m = "invokeSuspend")
    static final class f extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ int $newRating;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String programId = null;
            app.dogo.com.dogo_android.n.m.t.h.b trickRating_ClassicProgram;
            TrickItem trickItem;
            String str;
            String variationId;
            String dogId;
            int $newRating2;
            String str2;
            String programId2;
            String moduleId;
            String lessonId;
            Object obj2 = b.d();
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    g.this.f.g(g.this.s().getId(), "program").blockingGet();
                    return w.a;
                }
            }
            q.b(object);
            g.this.h.trackTrickRating(g.this.C().getId(), this.$newRating, g.this.z());
            ProgramSaveInfo programSaveInfo = g.this.A().c();
            if (programSaveInfo == null) {
                int i = 0;
            } else {
                programId = programSaveInfo.getProgramId();
            }
            if (programSaveInfo == null || !n.b(programId, "id_nipping_program")) {
                if (programSaveInfo != null) {
                    trickRating_ClassicProgram = new TrickRating_ClassicProgram(programSaveInfo.getDogId(), this.$newRating, g.this.C().getId(), programSaveInfo.getProgramId(), programSaveInfo.getModuleId(), programSaveInfo.getLessonId());
                } else {
                }
            } else {
                app.dogo.com.dogo_android.n.m.t.h.a trickRating_BitingProgram = new TrickRating_BitingProgram(programSaveInfo.getDogId(), this.$newRating, g.this.C().getId(), g.this.C().getVariationId());
            }
            this.label = i2;
            if (g.this.remoteConfigService.B(trickRating_ClassicProgram, this) == obj2) {
                return obj2;
            }
        }

        f(int i, d<? super g.f> dVar) {
            this.$newRating = i;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.library.tricks.rate.g.f)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.library.tricks.rate.g.f(g.this, this.$newRating, dVar);
        }
    }
    public /* synthetic */ g(app.dogo.com.dogo_android.n.m.n nVar, DogProfile dogProfile, String str, long j, q3 q3Var, p1 p1Var, p2 p2Var, o3 o3Var, k1 k1Var, j2 j2Var, app.dogo.com.dogo_android.service.r2 r2Var, j1 j1Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 i142;
        i142 = i & 4096 != 0 ? i142 : h0Var;
        this(nVar, dogProfile, str, j, q3Var, q3Var, p1Var, p2Var, o3Var, k1Var, j2Var, r2Var, j1Var, i142);
    }

    /* renamed from: K, reason: from kotlin metadata */
    private final void getArticleId() {
        this.userRepository.postValue(null);
        final r takeWhile = r.interval(4L, TimeUnit.SECONDS).takeWhile(new app.dogo.com.dogo_android.library.tricks.rate.d(this));
        n.e(takeWhile, "interval(4, TimeUnit.SECONDS).takeWhile { getRating() == 0 }");
        getDisposable().b(a.i(takeWhile, app.dogo.com.dogo_android.library.tricks.rate.g.d.a, null, new app.dogo.com.dogo_android.library.tricks.rate.g.e(this), 2, null));
    }

    /* renamed from: L, reason: from kotlin metadata */
    private static final boolean saveTrick(g newRating, Long trick) {
        boolean z = true;
        n.f(newRating, "this$0");
        n.f(trick, "it");
        newRating = newRating.y() == 0 ? 1 : 0;
        return (newRating.y() == 0 ? 1 : 0);
    }

    private final void M() {
        this.h.logEvent(E_Training.i.withParameters(u.a(new EP_TrickId(), this.n.getId()), u.a(new EP_ViewSource(), "library")));
    }

    private final Object N(int i, d<? super w> dVar) {
        Object obj = kotlinx.coroutines.internal.k.e(this.m, new app.dogo.com.dogo_android.library.tricks.rate.g.f(this, i, null), dVar);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 saveIfChangedAndFinish(g trick) {
        return trick.programRepository;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ j1 shouldShowVariationsUnlocked(g programId) {
        return programId.remoteConfigService;
    }

    /* renamed from: j, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ k1 updateTrickKnowledge(g newRating) {
        return newRating.preferenceService;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.service.r2 k(g gVar) {
        return gVar.rateRepository;
    }

    public static final /* synthetic */ o3 l(g gVar) {
        return gVar.h;
    }

    public static final /* synthetic */ q3 m(g gVar) {
        return gVar.e;
    }

    public static final /* synthetic */ p1 n(g gVar) {
        return gVar.f;
    }

    public static final /* synthetic */ Object o(g gVar, int i, d dVar) {
        return gVar.N(i, dVar);
    }

    private final boolean p(int i, TrickItem trickItem) {
        boolean z = false;
        i = i != trickItem.getKnowledge() && i != 0 ? 1 : 0;
        return (i != trickItem.getKnowledge() && i != 0 ? 1 : 0);
    }

    private final int y() {
        int value = 0;
        Object value2 = this.p.getValue();
        if (value2 == null) {
            value = 0;
        } else {
            value = value2.intValue();
        }
        return value;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.n.m.n A() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long B() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem C() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> D() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        Long num = r();
        if (num != null) {
            M();
            x().postValue(Long.valueOf(num.longValue()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G(TrickItem trickItem) {
        n.f(trickItem, "trick");
        str = "id_clicker";
        if (n.b(trickItem.getId(), str)) {
            this.g.A0(true);
        }
        int i = y();
        if (p(i, trickItem)) {
            H(Integer.valueOf(i), trickItem);
        } else {
            Integer num = null;
            H(num, trickItem);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void H(Integer integer, TrickItem trickItem) {
        n.f(trickItem, "trick");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.m.plus(new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this)), null, new app.dogo.com.dogo_android.library.tricks.rate.g.c(this, integer, trickItem, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean I() {
        return this.f.G();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean J(String str) {
        boolean hasVariations;
        boolean z2 = true;
        n.f(str, "programId");
        if (this.n.getHasVariations()) {
            if (n.b(str, "id_nipping_program")) {
                if (this.tracker != y()) {
                    int i = 4;
                    str = y() >= 4 ? 1 : 0;
                }
            }
        }
        return (y() >= 4 ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> q() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long r() {
        return this.rateRepository.d(LocaleService.a.a(this.g.W()), this.n.getId());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile s() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<g.a> t() {
        return this.trainingTimeInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int u() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> v() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String w() {
        int i = 0;
        TrickItem trickItem = this.a.b();
        if (trickItem == null) {
            i = 0;
        } else {
            String name = trickItem.getName();
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Long> x() {
        return this.r;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String z() {
        return this.dispatcher;
    }

    public g(app.dogo.com.dogo_android.n.m.n nVar, DogProfile dogProfile, String str, long j, q3 q3Var, p1 p1Var, p2 p2Var, o3 o3Var, k1 k1Var, j2 j2Var, app.dogo.com.dogo_android.service.r2 r2Var, j1 j1Var, h0 h0Var) {
        TrickItem trickItem;
        final Object nVar3 = this;
        Object nVar2 = nVar;
        Object dogProfile22 = dogProfile;
        str32 = str;
        p1Var62 = q3Var;
        p2Var72 = p1Var;
        o3Var82 = p2Var;
        k1Var92 = o3Var;
        j2Var102 = k1Var;
        r2Var112 = j2Var;
        j1Var122 = r2Var;
        h0Var132 = j1Var;
        final Object obj = h0Var;
        n.f(nVar2, "session");
        n.f(dogProfile22, "dogProfile");
        n.f(str32, "screenName");
        n.f(p1Var62, "trainingTimeInteractor");
        n.f(p2Var72, "userRepository");
        n.f(o3Var82, "preferenceService");
        n.f(k1Var92, "tracker");
        n.f(j2Var102, "rateRepository");
        n.f(r2Var112, "connectivityService");
        n.f(j1Var122, "remoteConfigService");
        n.f(h0Var132, "programRepository");
        str = "dispatcher";
        n.f(obj, str);
        super();
        nVar3.a = nVar2;
        nVar3.connectivityService = dogProfile22;
        nVar3.dispatcher = str32;
        nVar3.d = j;
        nVar3.e = p1Var62;
        nVar3.f = p2Var72;
        nVar3.g = o3Var82;
        nVar3.h = k1Var92;
        nVar3.preferenceService = j2Var102;
        nVar3.programRepository = r2Var112;
        nVar3.rateRepository = j1Var122;
        nVar3.remoteConfigService = h0Var132;
        nVar3.m = obj;
        if (nVar.a() == null) {
            java.util.List list = null;
            app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory = null;
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = null;
            boolean z2 = false;
            String str2 = null;
            java.util.List list2 = null;
            String str4 = null;
            int i = 0;
            int i2 = 0;
            kotlin.d0.d.g gVar = 1048575;
            int i3 = 0;
            super(null, null, null, null, false, 0, null, null, 0L, obj, 0, list, trickCategory, z, vimeoData, z2, str2, list2, str4, i, i2, gVar, i3);
        }
        nVar3.n = trickItem;
        int knowledge = trickItem.getKnowledge();
        nVar3.tracker = knowledge;
        x xVar = new x(Integer.valueOf(knowledge));
        nVar3.p = xVar;
        nVar3.trainingTimeInteractor = new a();
        nVar3.r = new a();
        nVar3.s = new a();
        nVar3.userRepository = new x();
        if (knowledge == 0) {
            getArticleId();
        } else {
            xVar.postValue(Integer.valueOf(knowledge));
        }
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static /* synthetic */ boolean changed(g rank, Long trick) {
        return RateTrickViewModel2.saveTrick(rank, trick);
    }
}
