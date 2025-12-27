package app.dogo.com.dogo_android.n.m.s;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.s.a.q3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.j1.a;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.j;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import f.d.a.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.u;
import kotlin.w;

/* compiled from: TrickBigTimerViewModel.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010+\u001a\u00020,J\r\u0010-\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\"J\u0008\u00101\u001a\u00020,H\u0014J\u0006\u00102\u001a\u00020,J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020,2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020,J\u0008\u0010;\u001a\u00020,H\u0002R\u001f\u0010\u0015\u001a\u0010\u0012\u000c\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\"0\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001eR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010$\u001a\u0010\u0012\u000c\u0012\n \u0018*\u0004\u0018\u00010\"0\"0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001aR\u0011\u0010&\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "trainingTimer", "Lapp/dogo/com/dogo_android/util/TrainingTimer;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lapp/dogo/com/dogo_android/util/TrainingTimer;)V", "bigTimerLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getBigTimerLiveData", "()Landroidx/lifecycle/MutableLiveData;", "openZendeskArticle", "Lcom/hadilq/liveevent/LiveEvent;", "getOpenZendeskArticle", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "shouldVibrate", "", "getShouldVibrate", "trainingTargetReached", "getTrainingTargetReached", "trainingTargetSeconds", "getTrainingTargetSeconds", "()J", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "freezeTimer", "", "getArticleId", "()Ljava/lang/Long;", "getLastSessionTimeMs", "isClickerHidden", "onCleared", "onMoreTipsClicked", "pauseTimer", "resumeTimer", "trackEndEarlyTapped", "trackFinishAndEvaluateTapped", "trackGoodExamplesClicked", "source", "", "trackInstructionsTapped", "trackMoreInfoClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class TrickBigTimerViewModel extends s {

    private final TrickItem a;
    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramSaveInfo clickerSoundPlayer;
    private final j c;
    /* renamed from: d, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 preferenceService;
    private final o1 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final o3 remoteConfigService;
    private final p2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final q3 tracker;
    private a0 i;
    private final x<Long> j;
    /* renamed from: k, reason: from kotlin metadata */
    private final x<Boolean> trainingTimeInteractor;
    /* renamed from: l, reason: from kotlin metadata */
    private final a<Long> trainingTimer;
    private final a<Boolean> m;
    /* renamed from: n, reason: from kotlin metadata */
    private final long tricksRepository;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Long, w> {
        @Override // kotlin.d0.d.p
        public final void a(long j) {
            boolean z = false;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
            long l = i.this.o();
            final int i = 1;
            int r0 = seconds > l ? i : 0;
            i.this.j().postValue(Long.valueOf(seconds, r5));
            i.this.m().postValue(Boolean.valueOf(n.b(Boolean.valueOf(r0), i.this.n().getValue()) ^ i));
            i.this.n().postValue(Boolean.valueOf(r0));
        }

        a() {
            super(1);
        }
    }
    public /* synthetic */ i(TrickItem trickItem, ProgramSaveInfo programSaveInfo, j jVar, app.dogo.com.dogo_android.service.r2 r2Var, o1 o1Var, o3 o3Var, p2 p2Var, q3 q3Var, a0 a0Var, int i, g gVar) {
        a0 a0Var92;
        if (i & 256 != 0) {
            boolean z = false;
            i = 1;
            gVar = null;
        } else {
            a0Var92 = a0Var;
        }
        this(trickItem, programSaveInfo, jVar, r2Var, o1Var, o3Var, p2Var, q3Var, a0Var92);
    }

    /* renamed from: y, reason: from kotlin metadata */
    private final void freezeTimer() {
        this.remoteConfigService.logEvent(E_Training.i.withParameters(u.a(new EP_TrickId(), this.a.getId()), u.a(new EP_ViewSource(), "library")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        this.i.c();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long i() {
        return this.preferenceService.d(LocaleService.a.a(this.g.W()), this.a.getId());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Long> j() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long k() {
        return this.i.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<Long> l() {
        return this.trainingTimer;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<Boolean> m() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> n() {
        return this.trainingTimeInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long o() {
        return this.tricksRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.c.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem p() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.e.m().contains(this.a.getId());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        Long num = i();
        if (num != null) {
            freezeTimer();
            l().postValue(Long.valueOf(num.longValue()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        if (this.i.k()) {
            this.i.l();
            this.tracker.l(this.i.g(), this.clickerSoundPlayer, this.a.getId(), this.a.getVariationId());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.i.m(f0.a(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        this.remoteConfigService.logEvent(E_Training.o.d(u.a(new EP_TrickId(), this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.remoteConfigService.logEvent(E_Training.n.d(u.a(new EP_TrickId(), this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: w, reason: from kotlin metadata */
    public final void trackGoodExamplesClicked(String source) {
        n.f(source, "source");
        this.remoteConfigService.logEvent(E_Training.h.c(new EP_TrickId(), this.a.getId(), new EP_ViewSource(), source));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.remoteConfigService.logEvent(E_Training.l.d(u.a(new EP_TrickId(), this.a.getId())));
    }

    public i(TrickItem trickItem, ProgramSaveInfo programSaveInfo, j jVar, app.dogo.com.dogo_android.service.r2 r2Var, o1 o1Var, o3 o3Var, p2 p2Var, q3 q3Var, a0 a0Var) {
        n.f(trickItem, "trick");
        n.f(jVar, "clickerSoundPlayer");
        n.f(r2Var, "remoteConfigService");
        n.f(o1Var, "tricksRepository");
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        n.f(q3Var, "trainingTimeInteractor");
        n.f(a0Var, "trainingTimer");
        super();
        this.a = trickItem;
        this.clickerSoundPlayer = programSaveInfo;
        this.c = jVar;
        this.preferenceService = r2Var;
        this.e = o1Var;
        this.remoteConfigService = o3Var;
        this.g = p2Var;
        this.tracker = q3Var;
        this.i = a0Var;
        this.j = new x(Long.valueOf(0L));
        this.trainingTimeInteractor = new x(Boolean.FALSE);
        this.trainingTimer = new a();
        this.m = new a();
        this.i.h(1000L, new app.dogo.com.dogo_android.library.tricks.bigtimer.i.a(this));
        this.tricksRepository = ProgramRepository.Companion.d(trickItem.getKnowledge(), r2Var.J());
    }
}
