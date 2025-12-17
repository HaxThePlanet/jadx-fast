package app.dogo.com.dogo_android.n.m.t;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.s.a.q3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.v2;
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r;
import i.b.r0.a;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\r\u0008\u0016\u0018\u00002\u00020\u0001:\u0001RBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0018\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\u001f2\u0006\u00107\u001a\u000208H\u0002J\r\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010BJ\u0008\u0010C\u001a\u0004\u0018\u00010\u0007J\u0008\u0010D\u001a\u00020\u001fH\u0002J\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020F2\u0006\u00107\u001a\u000208J!\u0010H\u001a\u00020F2\n\u0008\u0002\u0010I\u001a\u0004\u0018\u00010\u001f2\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020=J\u000e\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\u0007J\u0008\u0010N\u001a\u00020FH\u0002J\u0008\u0010O\u001a\u00020FH\u0002J\u0019\u0010P\u001a\u00020F2\u0006\u0010I\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010QR\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010)\u001a\u00020\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u001f\u0010,\u001a\u0010\u0012\u000c\u0012\n -*\u0004\u0018\u00010\u001f0\u001f0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010!R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\t0%¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010(R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u000208¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u001d\u0010;\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020=0<0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010(R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006S", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "screenName", "", "trainingDurationMs", "", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/lang/String;JLapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "animationSelection", "Landroidx/lifecycle/MutableLiveData;", "", "getAnimationSelection", "()Landroidx/lifecycle/MutableLiveData;", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "finished", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "getFinished", "()Lcom/hadilq/liveevent/LiveEvent;", "initialKnowledge", "getInitialKnowledge", "()I", "knowledge", "kotlin.jvm.PlatformType", "getKnowledge", "openZendeskArticle", "getOpenZendeskArticle", "getScreenName", "()Ljava/lang/String;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getTrainingDurationMs", "()J", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "updateKnowledge", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getUpdateKnowledge", "changed", "rank", "getArticleId", "()Ljava/lang/Long;", "getNextTrickName", "getRating", "onMoreTipsClicked", "", "saveIfChangedAndFinish", "saveTrick", "newRating", "(Ljava/lang/Integer;Lapp/dogo/com/dogo_android/repository/domain/TrickItem;)V", "shouldOpenTrainingReminders", "shouldShowVariationsUnlocked", "programId", "startAnimation", "trackMoreInfoClicked", "updateTrickKnowledge", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RateResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class g extends s {

    private final n a;
    private final DogProfile b;
    private final String c;
    private final long d;
    private final q3 e;
    private final p1 f;
    private final p2 g;
    private final o3 h;
    private final k1 i;
    private final j2 j;
    private final r2 k;
    private final j1 l;
    private final h0 m;
    private final TrickItem n;
    private final int o;
    private final x<Integer> p;
    private final a<app.dogo.com.dogo_android.n.m.t.g.a> q;
    private final a<Long> r;
    private final a<y<Boolean>> s;
    private final x<Integer> t;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\u0007\u0008B\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "", "knowledge", "", "(I)V", "getKnowledge", "()I", "Default", "TimeMetrics", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults$Default;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults$TimeMetrics;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class a {
        private a(int i) {
            super();
        }

        public a(int i, g g2) {
            super(i);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.n.m.t.g a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.n.m.t.g g2) {
            this.a = g2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.D().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        public static final app.dogo.com.dogo_android.n.m.t.g.d a;
        static {
            g.d dVar = new g.d();
            g.d.a = dVar;
        }

        d() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<Long, w> {

        final app.dogo.com.dogo_android.n.m.t.g this$0;
        e(app.dogo.com.dogo_android.n.m.t.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Long)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Long long) {
            int i;
            long l;
            int obj6;
            if (long == null) {
                obj6 = 0;
            } else {
                obj6 = Integer.valueOf((int)i);
            }
            this.this$0.q().postValue(obj6);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.rate.RateTrickViewModel2$saveTrick$1", f = "RateTrickViewModel2.kt", l = {93, 97}, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        final Integer $newRating;
        final TrickItem $trick;
        int label;
        final app.dogo.com.dogo_android.n.m.t.g this$0;
        c(app.dogo.com.dogo_android.n.m.t.g g, Integer integer2, TrickItem trickItem3, d<? super app.dogo.com.dogo_android.n.m.t.g.c> d4) {
            this.this$0 = g;
            this.$newRating = integer2;
            this.$trick = trickItem3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.c obj4 = new g.c(this.this$0, this.$newRating, this.$trick, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.n.m.t.g.a aVar;
            y.b intValue;
            Object unknownHostException;
            int i2;
            q3 l;
            long l2;
            int i;
            ProgramSaveInfo programSaveInfo;
            String str;
            String variationId;
            Object obj;
            Object obj12;
            Object obj2 = b.d();
            intValue = this.label;
            i2 = 2;
            final int i3 = 1;
            if (intValue != 0) {
                if (intValue != i3) {
                    if (intValue != i2) {
                    } else {
                        q.b(object);
                        Integer $newRating = this.$newRating;
                        if ($newRating == null) {
                            intValue = this.this$0.u();
                        } else {
                            intValue = $newRating.intValue();
                        }
                        aVar = new g.a.b(intValue, (TrainingTimeMetrics)obj12);
                        g.n(this.this$0).g(this.this$0.s().getId(), "library");
                        unknownHostException = new y.c(b.a(i3));
                        this.this$0.D().postValue(unknownHostException);
                        this.this$0.t().postValue(aVar);
                    }
                    obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj12;
                }
                q.b(object);
                g.j(this.this$0).c();
                i = 0;
                if (g.k(this.this$0).g0() && Long.compare(l, i) != 0) {
                    i = 0;
                    if (Long.compare(l, i) != 0) {
                        this.label = i2;
                        if (g.m(this.this$0).j(this.this$0.B(), i, this.this$0.A().c(), this.$trick.getId(), this.$trick.getVariationId()) == obj2) {
                            return obj2;
                        }
                    } else {
                        obj12 = this.$newRating;
                        if (obj12 == null) {
                            obj12 = this.this$0.u();
                        } else {
                            obj12 = obj12.intValue();
                        }
                        aVar = new g.a.a(obj12);
                    }
                } else {
                }
            } else {
                q.b(object);
                this.this$0.D().postValue(y.b.a);
                if (!g.h(this.this$0).a()) {
                    g.l(this.this$0).s("rate_trick");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.D().postValue(aVar);
                } else {
                    obj12 = this.$newRating;
                    this.label = i3;
                    if (obj12 != null && g.o(this.this$0, obj12.intValue(), this) == obj2) {
                        this.label = i3;
                        if (g.o(this.this$0, obj12.intValue(), this) == obj2) {
                            return obj2;
                        }
                    }
                }
            }
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.rate.RateTrickViewModel2$updateTrickKnowledge$2", f = "RateTrickViewModel2.kt", l = 181, m = "invokeSuspend")
    static final class f extends k implements p<m0, d<? super w>, Object> {

        final int $newRating;
        int label;
        final app.dogo.com.dogo_android.n.m.t.g this$0;
        f(app.dogo.com.dogo_android.n.m.t.g g, int i2, d<? super app.dogo.com.dogo_android.n.m.t.g.f> d3) {
            this.this$0 = g;
            this.$newRating = i2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.f)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.f obj3 = new g.f(this.this$0, this.$newRating, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String programId2;
            app.dogo.com.dogo_android.n.m.t.h bVar;
            TrickItem $newRating;
            String $newRating2;
            String variationId;
            app.dogo.com.dogo_android.n.m.t.h.b bVar2;
            String dogId;
            int $newRating3;
            String str;
            String programId;
            String moduleId;
            String lessonId;
            Object obj14;
            Object obj = b.d();
            bVar = this.label;
            final int i = 1;
            if (bVar != 0) {
                if (bVar != i) {
                } else {
                    q.b(object);
                    g.n(this.this$0).g(this.this$0.s().getId(), "program").blockingGet();
                    return w.a;
                }
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
            }
            q.b(object);
            g.l(this.this$0).u(this.this$0.C().getId(), this.$newRating, this.this$0.z());
            obj14 = this.this$0.A().c();
            if (obj14 == null) {
                programId2 = 0;
            } else {
                programId2 = obj14.getProgramId();
            }
            if (obj14 != null && n.b(programId2, "id_nipping_program")) {
                if (n.b(programId2, "id_nipping_program")) {
                    bVar = new h.a(obj14.getDogId(), this.$newRating, this.this$0.C().getId(), this.this$0.C().getVariationId());
                } else {
                    if (obj14 != null) {
                        super(obj14.getDogId(), this.$newRating, this.this$0.C().getId(), obj14.getProgramId(), obj14.getModuleId(), obj14.getLessonId());
                    } else {
                        $newRating = new h.c(this.this$0.s().getId(), this.$newRating, this.this$0.C().getId());
                        bVar = $newRating;
                    }
                }
            } else {
            }
            this.label = i;
            if (g.i(this.this$0).B(bVar, this) == obj) {
                return obj;
            }
        }
    }
    public g(n n, DogProfile dogProfile2, String string3, long l4, q3 q35, p1 p16, p2 p27, o3 o38, k1 k19, j2 j210, r2 r211, j1 j112, h0 h013) {
        TrickItem trickItem;
        int valueOf;
        long l;
        Object obj9;
        Object obj3;
        Object obj8;
        Object obj4;
        Object obj;
        Object obj5;
        Object obj7;
        Object obj2;
        Object obj6;
        String str;
        int i7;
        int i;
        int i5;
        int i3;
        int i6;
        int i9;
        int i4;
        int i8;
        int i10;
        int i2;
        int i11;
        int i12;
        final Object obj10 = this;
        Object obj11 = n;
        Object obj12 = dogProfile2;
        obj9 = string3;
        obj3 = p16;
        obj8 = p27;
        obj4 = o38;
        obj = k19;
        obj5 = j210;
        obj7 = r211;
        obj2 = j112;
        obj6 = h013;
        final Object obj13 = obj40;
        n.f(obj11, "session");
        n.f(obj12, "dogProfile");
        n.f(obj9, "screenName");
        n.f(obj3, "trainingTimeInteractor");
        n.f(obj8, "userRepository");
        n.f(obj4, "preferenceService");
        n.f(obj, "tracker");
        n.f(obj5, "rateRepository");
        n.f(obj7, "connectivityService");
        n.f(obj2, "remoteConfigService");
        n.f(obj6, "programRepository");
        n.f(obj13, "dispatcher");
        super();
        obj10.a = obj11;
        obj10.b = obj12;
        obj10.c = obj9;
        obj10.d = l4;
        obj10.e = obj3;
        obj10.f = obj8;
        obj10.g = obj4;
        obj10.h = obj;
        obj10.i = obj5;
        obj10.j = obj7;
        obj10.k = obj2;
        obj10.l = obj6;
        obj10.m = obj13;
        if (n.a() == null) {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, obj13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048575, 0);
        }
        obj10.n = trickItem;
        valueOf = trickItem.getKnowledge();
        obj10.o = valueOf;
        x xVar = new x(Integer.valueOf(valueOf));
        obj10.p = xVar;
        a aVar = new a();
        obj10.q = aVar;
        a aVar2 = new a();
        obj10.r = aVar2;
        a aVar3 = new a();
        obj10.s = aVar3;
        x xVar2 = new x();
        obj10.t = xVar2;
        if (valueOf == 0) {
            K();
        } else {
            xVar.postValue(Integer.valueOf(valueOf));
        }
    }

    public g(n n, DogProfile dogProfile2, String string3, long l4, q3 q35, p1 p16, p2 p27, o3 o38, k1 k19, j2 j210, r2 r211, j1 j112, h0 h013, int i14, g g15) {
        h0 i;
        h0 h0Var;
        if (i2 &= 4096 != 0) {
            h0Var = i;
        } else {
            h0Var = i14;
        }
        super(n, dogProfile2, string3, l4, obj6, p16, p27, o38, k19, j210, r211, j112, h013, h0Var);
    }

    public static boolean E(app.dogo.com.dogo_android.n.m.t.g g, Long long2) {
        return g.L(g, long2);
    }

    private final void K() {
        this.t.postValue(0);
        d dVar = new d(this);
        final r takeWhile = r.interval(4, obj3).takeWhile(dVar);
        n.e(takeWhile, "interval(4, TimeUnit.SECONDS).takeWhile { getRating() == 0 }");
        g.e eVar = new g.e(this);
        getDisposable().b(a.i(takeWhile, g.d.a, 0, eVar, 2, 0));
    }

    private static final boolean L(app.dogo.com.dogo_android.n.m.t.g g, Long long2) {
        int obj1;
        n.f(g, "this$0");
        n.f(long2, "it");
        obj1 = g.y() == 0 ? 1 : 0;
        return obj1;
    }

    private final void M() {
        n2 n2Var = new n2();
        r2 r2Var = new r2();
        this.h.d(p0.i.d(u.a(n2Var, this.n.getId()), u.a(r2Var, "library")));
    }

    private final Object N(int i, d<? super w> d2) {
        g.f fVar = new g.f(this, i, 0);
        Object obj4 = k.e(this.m, fVar, d2);
        if (obj4 == b.d()) {
            return obj4;
        }
        return w.a;
    }

    public static final j2 h(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.j;
    }

    public static final j1 i(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.l;
    }

    public static final k1 j(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.i;
    }

    public static final r2 k(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.k;
    }

    public static final o3 l(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.h;
    }

    public static final q3 m(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.e;
    }

    public static final p1 n(app.dogo.com.dogo_android.n.m.t.g g) {
        return g.f;
    }

    public static final Object o(app.dogo.com.dogo_android.n.m.t.g g, int i2, d d3) {
        return g.N(i2, d3);
    }

    private final boolean p(int i, TrickItem trickItem2) {
        int obj1;
        if (i != trickItem2.getKnowledge() && i != 0) {
            obj1 = i != 0 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private final int y() {
        int intValue;
        Object value = this.p.getValue();
        if ((Integer)value == null) {
            intValue = 0;
        } else {
            intValue = (Integer)value.intValue();
        }
        return intValue;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final n A() {
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

    public final a<y<Boolean>> D() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        Long valueOf;
        a aVar;
        valueOf = r();
        if (valueOf == null) {
        } else {
            M();
            x().postValue(Long.valueOf(valueOf.longValue()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G(TrickItem trickItem) {
        boolean z;
        Integer valueOf;
        String str;
        n.f(trickItem, "trick");
        if (n.b(trickItem.getId(), "id_clicker")) {
            this.g.A0(true);
        }
        int i = y();
        if (p(i, trickItem)) {
            H(Integer.valueOf(i), trickItem);
        } else {
            H(0, trickItem);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void H(Integer integer, TrickItem trickItem2) {
        n.f(trickItem2, "trick");
        g.b bVar = new g.b(CoroutineExceptionHandler.r, this);
        g.c cVar = new g.c(this, integer, trickItem2, 0);
        k.d(f0.a(this), this.m.plus(bVar), 0, cVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean I() {
        return this.f.G();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean J(String string) {
        boolean hasVariations;
        Object obj2;
        n.f(string, "programId");
        if (this.n.getHasVariations() && n.b(string, "id_nipping_program") && this.o != y() && y() >= 4) {
            if (n.b(string, "id_nipping_program")) {
                if (this.o != y()) {
                    obj2 = y() >= 4 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public final x<Integer> q() {
        return this.t;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long r() {
        return this.k.d(n2.a.a(this.g.W()), this.n.getId());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogProfile s() {
        return this.b;
    }

    public final a<app.dogo.com.dogo_android.n.m.t.g.a> t() {
        return this.q;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int u() {
        return this.o;
    }

    public final x<Integer> v() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String w() {
        int name;
        TrickItem trickItem = this.a.b();
        if (trickItem == null) {
            name = 0;
        } else {
            name = trickItem.getName();
        }
        return name;
    }

    public final a<Long> x() {
        return this.r;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String z() {
        return this.c;
    }
}
