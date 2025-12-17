package app.dogo.com.dogo_android.n.m.u;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.s.a.c3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.j1.a;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.o1;
import app.dogo.com.dogo_android.util.j;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.q2;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;
import net.time4j.g1.v;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0001VBs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\r\u0010:\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010&J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0008\u0010?\u001a\u00020@H\u0016J\u0006\u0010A\u001a\u00020 J\u0008\u0010B\u001a\u00020 H\u0002J\u0008\u0010C\u001a\u00020 H\u0002J\u0006\u0010D\u001a\u00020@J\u0008\u0010E\u001a\u00020@H\u0014J\u0006\u0010F\u001a\u00020@J\u0006\u0010G\u001a\u00020@J\u0008\u0010H\u001a\u00020@H\u0016J\u000e\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020 J\u0006\u0010K\u001a\u00020@J\u0006\u0010L\u001a\u00020 J\u0006\u0010M\u001a\u00020 J\u0008\u0010N\u001a\u00020@H\u0016J\u0006\u0010O\u001a\u00020@J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020<J\u0008\u0010R\u001a\u00020@H\u0002J\u0006\u0010S\u001a\u00020@J\u0008\u0010T\u001a\u00020@H\u0016J\u0008\u0010U\u001a\u00020@H\u0016R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\"R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010'\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040,0+¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u001f\u0010/\u001a\u0010\u0012\u000c\u0012\n 0*\u0004\u0018\u00010 0 0+¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010.R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\u0008\u0012\u0004\u0012\u0002060\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "Lapp/dogo/com/dogo_android/util/extensionfunction/TrickDetailsClickerToolTipCallbacks;", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "pauseTimeSec", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getVideoStepsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Long;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "goToClickerIntroduction", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToClickerIntroduction", "()Lcom/hadilq/liveevent/LiveEvent;", "openZendeskArticle", "getOpenZendeskArticle", "getPauseTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "showSwipeAnimation", "kotlin.jvm.PlatformType", "getShowSwipeAnimation", "trainingDurationSeconds", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "videoError", "", "getVideoError", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "getArticleId", "getTrainingDurationString", "", "getTrainingFlowType", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "goToIntroductionFragment", "", "isClickerHidden", "isClickerIntroductionCompleted", "isTimedTrick", "loadList", "onCleared", "onMoreTipsClicked", "retry", "setClickerIntroductionAsCompleted", "setSwipeAnimationAsVisible", "isVisible", "setSwipeAnimationSeen", "shouldShowClickerTooltip", "shouldShowSwipeAnimation", "showSwipeAnimationIfNeeded", "trackFinishAndEvaluateTapped", "trackGoodExamplesClicked", "source", "trackMoreInfoClicked", "trackStartTrainingTapped", "trackTooltipReadClicked", "trackTooltipSkipClicked", "TrainingFlowType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends s implements o1 {

    private final j2 A;
    private final r2 B;
    private final o3 C;
    private final p1 D;
    private final h0 E;
    private final x<y<TrickItem>> F;
    private final x<Boolean> G;
    private final a<Boolean> H;
    private final a<Long> I;
    private final a<Throwable> J;
    private final long K;
    private final TrickItem a;
    private final ProgramSaveInfo b;
    private final Long c;
    private final c0 v;
    private final j w;
    private final c3 x;
    private final o1 y;
    private final p2 z;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "", "(Ljava/lang/String;I)V", "PAUSED", "TIMED", "RATED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum a {

        PAUSED,
        TIMED,
        RATED;
        private static final app.dogo.com.dogo_android.n.m.u.n.a[] $values() {
            app.dogo.com.dogo_android.n.m.u.n.a[] arr = new n.a[3];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.n.m.u.n a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.n.m.u.n n2) {
            this.a = n2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
            y.a aVar = new y.a(throwable2);
            this.a.q().postValue(aVar);
            this.a.v().postValue(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.trickdetails.TrickDetailsViewModel$loadList$1", f = "TrickDetailsViewModel.kt", l = 83, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.n.m.u.n this$0;
        c(app.dogo.com.dogo_android.n.m.u.n n, d<? super app.dogo.com.dogo_android.n.m.u.n.c> d2) {
            this.this$0 = n;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.c obj2 = new n.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object unknownHostException2;
            Object unknownHostException;
            TrickItem label;
            int i2;
            int i;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            i2 = 1;
            if (label != 0) {
                if (label != i2) {
                } else {
                    q.b(object);
                    Object blockingGet = n.l(this.this$0).v().blockingGet();
                    n.e((String)blockingGet, "dogId");
                    n.k(this.this$0).F(blockingGet, this.this$0.u().getId()).e();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Preparing trick ");
                    stringBuilder.append((TrickItem)obj5.getId());
                    stringBuilder.append(" , isVideo: ");
                    i = 0;
                    if (!obj5.getVideoSteps().isEmpty()) {
                    } else {
                        try {
                            i2 = i;
                            stringBuilder.append(i2);
                            a.f(stringBuilder.toString(), new Object[i]);
                            unknownHostException = new y.c(obj5);
                            this.this$0.q().postValue(unknownHostException);
                            a.d(object);
                            app.dogo.com.dogo_android.n.m.u.n nVar = this.this$0;
                            nVar = nVar.q();
                            y.a aVar2 = new y.a(object);
                            nVar.postValue(aVar2);
                            nVar = this.this$0;
                            nVar = nVar.v();
                            nVar.postValue(object);
                        }
                        return w.a;
                    }
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.q().postValue(y.b.a);
            if (!n.h(this.this$0).a()) {
                n.j(this.this$0).s("trick_details");
                unknownHostException = new UnknownHostException();
                y.a aVar = new y.a(unknownHostException);
                this.this$0.q().postValue(aVar);
                unknownHostException2 = new UnknownHostException();
                this.this$0.v().postValue(unknownHostException2);
            } else {
                this.label = i2;
                if (n.i(this.this$0).a(this.this$0.u(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public n(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, Long long3, c0 c04, j j5, c3 c36, o1 o17, p2 p28, j2 j29, r2 r210, o3 o311, p1 p112, h0 h013) {
        n.f(trickItem, "trick");
        n.f(c04, "videoPlayerFactory");
        n.f(j5, "clickerSoundPlayer");
        n.f(c36, "getVideoStepsInteractor");
        n.f(o17, "tricksRepository");
        n.f(p28, "preferenceService");
        n.f(j29, "connectivityService");
        n.f(r210, "remoteConfigService");
        n.f(o311, "tracker");
        n.f(p112, "userRepository");
        n.f(h013, "dispatcher");
        super();
        this.a = trickItem;
        this.b = programSaveInfo2;
        this.c = long3;
        this.v = c04;
        this.w = j5;
        this.x = c36;
        this.y = o17;
        this.z = p28;
        this.A = j29;
        this.B = r210;
        this.C = o311;
        this.D = p112;
        this.E = h013;
        x obj3 = new x();
        this.F = obj3;
        obj3 = new x(Boolean.FALSE);
        this.G = obj3;
        obj3 = new a();
        this.H = obj3;
        obj3 = new a();
        this.I = obj3;
        obj3 = new a();
        this.J = obj3;
        A();
        this.K = j1.Companion.d(trickItem.getKnowledge(), r210.J());
    }

    public n(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, Long long3, c0 c04, j j5, c3 c36, o1 o17, p2 p28, j2 j29, r2 r210, o3 o311, p1 p112, h0 h013, int i14, g g15) {
        h0 i;
        h0 h0Var;
        if (i2 &= 4096 != 0) {
            h0Var = i;
        } else {
            h0Var = h013;
        }
        super(trickItem, programSaveInfo2, long3, c04, j5, c36, o17, p28, j29, r210, o311, p112, h0Var);
    }

    private final void J() {
        n2 n2Var = new n2();
        r2 r2Var = new r2();
        this.C.d(p0.i.d(u.a(n2Var, this.a.getId()), u.a(r2Var, "library")));
    }

    public static final j2 h(app.dogo.com.dogo_android.n.m.u.n n) {
        return n.A;
    }

    public static final c3 i(app.dogo.com.dogo_android.n.m.u.n n) {
        return n.x;
    }

    public static final o3 j(app.dogo.com.dogo_android.n.m.u.n n) {
        return n.C;
    }

    public static final o1 k(app.dogo.com.dogo_android.n.m.u.n n) {
        return n.y;
    }

    public static final p1 l(app.dogo.com.dogo_android.n.m.u.n n) {
        return n.D;
    }

    private final boolean y() {
        return this.z.l();
    }

    private final boolean z() {
        int i;
        boolean z;
        if (n.b(this.a.getCategory().getId(), "id_games")) {
            if (this.b != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        n.b bVar = new n.b(CoroutineExceptionHandler.r, this);
        n.c cVar = new n.c(this, 0);
        k.d(f0.a(this), this.E.plus(bVar), 0, cVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B() {
        Long valueOf;
        a aVar;
        valueOf = m();
        if (valueOf == null) {
        } else {
            J();
            o().postValue(Long.valueOf(valueOf.longValue()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        A();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D(boolean z) {
        this.G.postValue(Boolean.valueOf(z));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void E() {
        this.z.s1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean F() {
        boolean z;
        int i;
        String str;
        if (!y() && !x() && !n.b(this.a.getId(), "id_clicker") && !this.z.m()) {
            if (!x()) {
                if (!n.b(this.a.getId(), "id_clicker")) {
                    i = !this.z.m() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean G() {
        boolean z;
        int i;
        if (!this.z.a0()) {
            if (!y()) {
                i = !F() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void H() {
        n2 n2Var = new n2();
        this.C.d(p0.n.d(u.a(n2Var, this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void I(String string) {
        n.f(string, "source");
        n2 n2Var = new n2();
        r2 r2Var = new r2();
        this.C.d(p0.h.c(n2Var, this.a.getId(), r2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void K() {
        n2 n2Var = new n2();
        q2 q2Var = new q2();
        this.C.d(p0.m.d(u.a(n2Var, this.a.getId()), u.a(q2Var, Long.valueOf(this.K))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void b() {
        this.C.c(p0.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void c() {
        this.C.c(p0.k);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void e() {
        this.G.postValue(Boolean.valueOf(G()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void f() {
        this.H.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void g() {
        this.z.z0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long m() {
        return this.B.d(n2.a.a(this.z.W()), this.a.getId());
    }

    public final a<Boolean> n() {
        return this.H;
    }

    public final a<Long> o() {
        return this.I;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.w.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long p() {
        return this.c;
    }

    public final x<y<TrickItem>> q() {
        return this.F;
    }

    public final x<Boolean> r() {
        return this.G;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String s() {
        String str;
        long l;
        v2.a companion;
        v2.b mINUTES;
        v sHORT;
        l = this.K;
        long minutes = TimeUnit.SECONDS.toMinutes(l);
        companion = Long.compare(minutes, i);
        if (companion != 0) {
            str = v2.Companion.c(minutes, l, v2.b.MINUTES);
        } else {
            str = v2.Companion.c(this.K, companion, v2.b.SECONDS);
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.n.m.u.n.a t() {
        app.dogo.com.dogo_android.n.m.u.n.a pAUSED;
        pAUSED = this.c != null ? n.a.PAUSED : z ? n.a.TIMED : n.a.RATED;
        return pAUSED;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem u() {
        return this.a;
    }

    public final a<Throwable> v() {
        return this.J;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 w() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        int i;
        boolean contains;
        if (!this.y.m().contains(this.a.getId())) {
            if (this.c != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
