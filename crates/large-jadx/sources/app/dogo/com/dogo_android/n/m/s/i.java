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
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.j;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.r2;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010+\u001a\u00020,J\r\u0010-\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\"J\u0008\u00101\u001a\u00020,H\u0014J\u0006\u00102\u001a\u00020,J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020,2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020,J\u0008\u0010;\u001a\u00020,H\u0002R\u001f\u0010\u0015\u001a\u0010\u0012\u000c\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\"0\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001eR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010$\u001a\u0010\u0012\u000c\u0012\n \u0018*\u0004\u0018\u00010\"0\"0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001aR\u0011\u0010&\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trainingTimeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;", "trainingTimer", "Lapp/dogo/com/dogo_android/util/TrainingTimer;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/TrainingTimeInteractor;Lapp/dogo/com/dogo_android/util/TrainingTimer;)V", "bigTimerLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getBigTimerLiveData", "()Landroidx/lifecycle/MutableLiveData;", "openZendeskArticle", "Lcom/hadilq/liveevent/LiveEvent;", "getOpenZendeskArticle", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "shouldVibrate", "", "getShouldVibrate", "trainingTargetReached", "getTrainingTargetReached", "trainingTargetSeconds", "getTrainingTargetSeconds", "()J", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "freezeTimer", "", "getArticleId", "()Ljava/lang/Long;", "getLastSessionTimeMs", "isClickerHidden", "onCleared", "onMoreTipsClicked", "pauseTimer", "resumeTimer", "trackEndEarlyTapped", "trackFinishAndEvaluateTapped", "trackGoodExamplesClicked", "source", "", "trackInstructionsTapped", "trackMoreInfoClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends s {

    private final TrickItem a;
    private final ProgramSaveInfo b;
    private final j c;
    private final r2 d;
    private final o1 e;
    private final o3 f;
    private final p2 g;
    private final q3 h;
    private a0 i;
    private final x<Long> j;
    private final x<Boolean> k;
    private final a<Long> l;
    private final a<Boolean> m;
    private final long n;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Long, w> {

        final app.dogo.com.dogo_android.n.m.s.i this$0;
        a(app.dogo.com.dogo_android.n.m.s.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(long l) {
            int i;
            long obj4 = TimeUnit.MILLISECONDS.toSeconds(l);
            final int i2 = 1;
            i = Long.compare(obj4, l2) > 0 ? i2 : 0;
            this.this$0.j().postValue(Long.valueOf(obj4));
            this.this$0.m().postValue(Boolean.valueOf(obj5 ^= i2));
            this.this$0.n().postValue(Boolean.valueOf(i));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Number)object.longValue());
            return w.a;
        }
    }
    public i(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, j j3, r2 r24, o1 o15, o3 o36, p2 p27, q3 q38, a0 a09) {
        n.f(trickItem, "trick");
        n.f(j3, "clickerSoundPlayer");
        n.f(r24, "remoteConfigService");
        n.f(o15, "tricksRepository");
        n.f(o36, "tracker");
        n.f(p27, "preferenceService");
        n.f(q38, "trainingTimeInteractor");
        n.f(a09, "trainingTimer");
        super();
        this.a = trickItem;
        this.b = programSaveInfo2;
        this.c = j3;
        this.d = r24;
        this.e = o15;
        this.f = o36;
        this.g = p27;
        this.h = q38;
        this.i = a09;
        x obj3 = new x(Long.valueOf(0));
        this.j = obj3;
        obj3 = new x(Boolean.FALSE);
        this.k = obj3;
        obj3 = new a();
        this.l = obj3;
        obj3 = new a();
        this.m = obj3;
        i.a obj4 = new i.a(this);
        this.i.h(1000, o36);
        this.n = j1.Companion.d(trickItem.getKnowledge(), r24.J());
    }

    public i(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, j j3, r2 r24, o1 o15, o3 o36, p2 p27, q3 q38, a0 a09, int i10, g g11) {
        a0 a0Var2;
        int i3;
        int i;
        int i2;
        a0 a0Var;
        if (i4 &= 256 != 0) {
            a0Var2 = new a0(0, 1, 0);
            a0Var = a0Var2;
        } else {
            a0Var = a09;
        }
        super(trickItem, programSaveInfo2, j3, r24, o15, o36, p27, q38, a0Var);
    }

    private final void y() {
        n2 n2Var = new n2();
        r2 r2Var = new r2();
        this.f.d(p0.i.d(u.a(n2Var, this.a.getId()), u.a(r2Var, "library")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        this.i.c();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Long i() {
        return this.d.d(n2.a.a(this.g.W()), this.a.getId());
    }

    public final x<Long> j() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long k() {
        return this.i.g();
    }

    public final a<Long> l() {
        return this.l;
    }

    public final a<Boolean> m() {
        return this.m;
    }

    public final x<Boolean> n() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long o() {
        return this.n;
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
        Long valueOf;
        a aVar;
        valueOf = i();
        if (valueOf == null) {
        } else {
            y();
            l().postValue(Long.valueOf(valueOf.longValue()));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        boolean z;
        q3 q3Var;
        long l;
        ProgramSaveInfo programSaveInfo;
        String str;
        String variationId;
        if (this.i.k()) {
            this.i.l();
            this.h.l(this.i.g(), obj3, this.b, this.a.getId());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.i.m(f0.a(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        n2 n2Var = new n2();
        this.f.d(p0.o.d(u.a(n2Var, this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        n2 n2Var = new n2();
        this.f.d(p0.n.d(u.a(n2Var, this.a.getId())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(String string) {
        n.f(string, "source");
        n2 n2Var = new n2();
        r2 r2Var = new r2();
        this.f.d(p0.h.c(n2Var, this.a.getId(), r2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        n2 n2Var = new n2();
        this.f.d(p0.l.d(u.a(n2Var, this.a.getId())));
    }
}
