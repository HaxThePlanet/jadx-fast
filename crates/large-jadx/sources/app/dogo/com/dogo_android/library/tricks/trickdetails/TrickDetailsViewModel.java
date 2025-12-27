package app.dogo.com.dogo_android.n.m.u;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.s.a.c3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.j1.a;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.j;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.q2;
import app.dogo.com.dogo_android.w.u2;
import i.b.a0;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;
import net.time4j.g1.v;

/* compiled from: TrickDetailsViewModel.kt */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0001VBs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\r\u0010:\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010&J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0008\u0010?\u001a\u00020@H\u0016J\u0006\u0010A\u001a\u00020 J\u0008\u0010B\u001a\u00020 H\u0002J\u0008\u0010C\u001a\u00020 H\u0002J\u0006\u0010D\u001a\u00020@J\u0008\u0010E\u001a\u00020@H\u0014J\u0006\u0010F\u001a\u00020@J\u0006\u0010G\u001a\u00020@J\u0008\u0010H\u001a\u00020@H\u0016J\u000e\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020 J\u0006\u0010K\u001a\u00020@J\u0006\u0010L\u001a\u00020 J\u0006\u0010M\u001a\u00020 J\u0008\u0010N\u001a\u00020@H\u0016J\u0006\u0010O\u001a\u00020@J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020<J\u0008\u0010R\u001a\u00020@H\u0002J\u0006\u0010S\u001a\u00020@J\u0008\u0010T\u001a\u00020@H\u0016J\u0008\u0010U\u001a\u00020@H\u0016R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\"R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010'\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040,0+¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u001f\u0010/\u001a\u0010\u0012\u000c\u0012\n 0*\u0004\u0018\u00010 0 0+¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010.R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\u0008\u0012\u0004\u0012\u0002060\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "Lapp/dogo/com/dogo_android/util/extensionfunction/TrickDetailsClickerToolTipCallbacks;", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "pauseTimeSec", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getVideoStepsInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Long;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;Lapp/dogo/com/dogo_android/repository/interactor/GetVideoStepsInteractor;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "goToClickerIntroduction", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToClickerIntroduction", "()Lcom/hadilq/liveevent/LiveEvent;", "openZendeskArticle", "getOpenZendeskArticle", "getPauseTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "showSwipeAnimation", "kotlin.jvm.PlatformType", "getShowSwipeAnimation", "trainingDurationSeconds", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "videoError", "", "getVideoError", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "getArticleId", "getTrainingDurationString", "", "getTrainingFlowType", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "goToIntroductionFragment", "", "isClickerHidden", "isClickerIntroductionCompleted", "isTimedTrick", "loadList", "onCleared", "onMoreTipsClicked", "retry", "setClickerIntroductionAsCompleted", "setSwipeAnimationAsVisible", "isVisible", "setSwipeAnimationSeen", "shouldShowClickerTooltip", "shouldShowSwipeAnimation", "showSwipeAnimationIfNeeded", "trackFinishAndEvaluateTapped", "trackGoodExamplesClicked", "source", "trackMoreInfoClicked", "trackStartTrainingTapped", "trackTooltipReadClicked", "trackTooltipSkipClicked", "TrainingFlowType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class TrickDetailsViewModel extends s implements app.dogo.com.dogo_android.util.h0.o1 {

    /* renamed from: A, reason: from kotlin metadata */
    private final j2 clickerSoundPlayer;
    /* renamed from: B, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 connectivityService;
    /* renamed from: C, reason: from kotlin metadata */
    private final o3 dispatcher;
    /* renamed from: D, reason: from kotlin metadata */
    private final p1 getVideoStepsInteractor;
    private final h0 E;
    private final x<y<TrickItem>> F;
    private final x<Boolean> G;
    /* renamed from: H, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> preferenceService;
    private final f.d.a.a<Long> I;
    /* renamed from: J, reason: from kotlin metadata */
    private final f.d.a.a<Throwable> remoteConfigService;
    private final long K;
    private final TrickItem a;
    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramSaveInfo tracker;
    /* renamed from: c, reason: from kotlin metadata */
    private final Long trainingDurationSeconds;
    private final c0 v;
    /* renamed from: w, reason: from kotlin metadata */
    private final j tricksRepository;
    /* renamed from: x, reason: from kotlin metadata */
    private final c3 userRepository;
    private final app.dogo.com.dogo_android.s.b.o1 y;
    private final p2 z;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "", "(Ljava/lang/String;I)V", "PAUSED", "TIMED", "RATED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum a {

        PAUSED,
        RATED,
        TIMED;
        private static final /* synthetic */ n.a[] $values() {
            app.dogo.com.dogo_android.n.m.u.n.a[] arr = new n.a[3];
            return new n.a[] { TrickDetailsViewModel_TrainingFlowType.PAUSED, TrickDetailsViewModel_TrainingFlowType.TIMED, TrickDetailsViewModel_TrainingFlowType.RATED };
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ n a;
        public b(CoroutineExceptionHandler.a exc, n nVar) {
            this.a = nVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            a.d(exception);
            this.a.q().postValue(new LoadResult_Error(exception));
            this.a.v().postValue(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.tricks.trickdetails.TrickDetailsViewModel$loadList$1", f = "TrickDetailsViewModel.kt", l = 83, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            boolean z = true;
            Object obj;
            Object obj2 = b.d();
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    try {
                        q.b(object);
                    } catch (Exception e) {
                    }
                    Object blockingGet = n.this.getVideoStepsInteractor.v().blockingGet();
                    n.e(blockingGet, "dogId");
                    n.this.y.F(blockingGet, n.this.u().getId()).e();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Preparing trick ");
                    stringBuilder.append(obj.getId());
                    stringBuilder.append(" , isVideo: ");
                    int i2 = 0;
                    if (obj.getVideoSteps().isEmpty()) {
                    }
                    stringBuilder.append(z);
                    a.f(stringBuilder.toString(), new Object[i2]);
                    n.this.q().postValue(new LoadResult_Success(obj));
                    return w.a;
                }
            }
            q.b(e);
            n.this.q().postValue(LoadResult_Loading.a);
            if (!n.this.clickerSoundPlayer.a()) {
                n.this.dispatcher.setTrainingReminderUserProperties("trick_details");
                n.this.q().postValue(new LoadResult_Error(new UnknownHostException()));
                n.this.v().postValue(new UnknownHostException());
            } else {
                try {
                    this.label = i;
                    if (n.this.userRepository.a(n.this.u(), this) == obj2) {
                        return obj2;
                    }
                    stringBuilder.append(z);
                    a.f(stringBuilder.toString(), new Object[i2]);
                    n.this.q().postValue(new LoadResult_Success(obj));
                } catch (Exception e) {
                }
                a.d(e);
                app.dogo.com.dogo_android.n.m.u.n nVar = n.this.q();
                n.this.postValue(new LoadResult_Error(e));
                nVar = n.this.v();
                n.this.postValue(e);
            }
        }

        c(d<? super n.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.library.tricks.trickdetails.n.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.library.tricks.trickdetails.n.c(n.this, dVar);
        }
    }
    public /* synthetic */ n(TrickItem trickItem, ProgramSaveInfo programSaveInfo, Long long, c0 c0Var, j jVar, c3 c3Var, app.dogo.com.dogo_android.s.b.o1 o1Var, p2 p2Var, j2 j2Var, app.dogo.com.dogo_android.service.r2 r2Var, o3 o3Var, p1 p1Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var132;
        h0Var132 = i & 4096 != 0 ? h0Var132 : h0Var;
        this(trickItem, programSaveInfo, long, c0Var, jVar, c3Var, o1Var, p2Var, j2Var, r2Var, o3Var, p1Var, h0Var132);
    }

    /* renamed from: J, reason: from kotlin metadata */
    private final void getArticleId() {
        this.dispatcher.logEvent(E_Training.i.withParameters(u.a(new EP_TrickId(), this.a.getId()), u.a(new EP_ViewSource(), "library")));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 setSwipeAnimationAsVisible(n isVisible) {
        return isVisible.clickerSoundPlayer;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ c3 trackGoodExamplesClicked(n source) {
        return source.userRepository;
    }

    public static final /* synthetic */ o3 j(n nVar) {
        return nVar.dispatcher;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.b.o1 k(n nVar) {
        return nVar.y;
    }

    public static final /* synthetic */ p1 l(n nVar) {
        return nVar.getVideoStepsInteractor;
    }

    private final boolean y() {
        return this.z.l();
    }

    private final boolean z() {
        boolean z2 = false;
        if (!n.b(this.a.getCategory().getId(), "id_games") || this.tracker != null) {
            int i2 = 1;
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        kotlinx.coroutines.internal.k.d(f0.a(this), this.E.plus(new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this)), null, new app.dogo.com.dogo_android.library.tricks.trickdetails.n.c(this, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B() {
        Long num = m();
        if (num != null) {
            getArticleId();
            o().postValue(Long.valueOf(num.longValue()));
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
        boolean z2 = true;
        String str;
        if (!y() && !this.x()) {
            str = "id_clicker";
            if (!n.b(this.a.getId(), str)) {
                int r0 = !this.z.m() ? 1 : 0;
            }
        }
        return (!this.z.m() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean G() {
        boolean z2 = true;
        if (this.z.a0() || !this.y()) {
            int i2 = 0;
        } else {
            int r0 = !F() ? 1 : 0;
        }
        return (!F() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void H() {
        this.dispatcher.logEvent(E_Training.n.withParameters(u.a(new EP_TrickId(), this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void I(String str) {
        n.f(str, "source");
        this.dispatcher.logEvent(E_Training.h.c(new EP_TrickId(), this.a.getId(), new EP_ViewSource(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void K() {
        this.dispatcher.logEvent(E_Training.m.withParameters(u.a(new EP_TrickId(), this.a.getId()), u.a(new EP_Value(), Long.valueOf(this.K))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void b() {
        this.dispatcher.logEvent(E_Training.j);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void c() {
        this.dispatcher.logEvent(E_Training.k);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void e() {
        this.G.postValue(Boolean.valueOf(G()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void f() {
        this.preferenceService.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void g() {
        this.z.z0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long m() {
        return this.connectivityService.d(LocaleService.a.a(this.z.W()), this.a.getId());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> n() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Long> o() {
        return this.I;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.tricksRepository.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long p() {
        return this.trainingDurationSeconds;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<TrickItem>> q() {
        return this.F;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> r() {
        return this.G;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String s() {
        String str;
        long minutes = TimeUnit.SECONDS.toMinutes(this.K);
        if (minutes != 0) {
            str = Utilities.Companion.c(minutes, Utilities_TimeUnit.MINUTES, v.SHORT);
        } else {
            str = Utilities.Companion.c(this.K, Utilities_TimeUnit.SECONDS, v.SHORT);
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final n.a t() {
        app.dogo.com.dogo_android.n.m.u.n.a pAUSED2;
        if (this.trainingDurationSeconds != null) {
            pAUSED2 = TrickDetailsViewModel_TrainingFlowType.PAUSED;
        } else {
            app.dogo.com.dogo_android.n.m.u.n.a r0 = z() ? TrickDetailsViewModel_TrainingFlowType.TIMED : TrickDetailsViewModel_TrainingFlowType.RATED;
        }
        return (z() ? TrickDetailsViewModel_TrainingFlowType.TIMED : TrickDetailsViewModel_TrainingFlowType.RATED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem u() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> v() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 w() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        boolean z = false;
        if (this.y.m().contains(this.a.getId()) || this.trainingDurationSeconds != null) {
            int i2 = 1;
        }
        return z;
    }

    public n(TrickItem trickItem, ProgramSaveInfo programSaveInfo, Long long, c0 c0Var, j jVar, c3 c3Var, app.dogo.com.dogo_android.s.b.o1 o1Var, p2 p2Var, j2 j2Var, app.dogo.com.dogo_android.service.r2 r2Var, o3 o3Var, p1 p1Var, h0 h0Var) {
        n.f(trickItem, "trick");
        n.f(c0Var, "videoPlayerFactory");
        n.f(jVar, "clickerSoundPlayer");
        n.f(c3Var, "getVideoStepsInteractor");
        n.f(o1Var, "tricksRepository");
        n.f(p2Var, "preferenceService");
        n.f(j2Var, "connectivityService");
        n.f(r2Var, "remoteConfigService");
        n.f(o3Var, "tracker");
        n.f(p1Var, "userRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.a = trickItem;
        this.tracker = programSaveInfo;
        this.trainingDurationSeconds = long;
        this.v = c0Var;
        this.tricksRepository = jVar;
        this.userRepository = c3Var;
        this.y = o1Var;
        this.z = p2Var;
        this.clickerSoundPlayer = j2Var;
        this.connectivityService = r2Var;
        this.dispatcher = o3Var;
        this.getVideoStepsInteractor = p1Var;
        this.E = h0Var;
        this.F = new x();
        this.G = new x(Boolean.FALSE);
        this.preferenceService = new a();
        this.I = new a();
        this.remoteConfigService = new a();
        A();
        this.K = ProgramRepository.Companion.d(trickItem.getKnowledge(), r2Var.J());
    }
}
