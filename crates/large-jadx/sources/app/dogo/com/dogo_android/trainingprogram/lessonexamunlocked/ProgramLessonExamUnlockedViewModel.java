package app.dogo.com.dogo_android.y.u;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: ProgramLessonExamUnlockedViewModel.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fJ\u0016\u0010\u0018\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fJ\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u000f0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "hasUserUnlockedFirstExam", "", "lessonId", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "(ZLjava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "laterTrackButtonClick", "", "loadData", "showBecomePremium", "showContentUnlock", "subscribeTrackButtonClick", "tryTrackButtonClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ProgramLessonExamUnlockedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean hasUserUnlockedFirstExam;
    /* renamed from: b, reason: from kotlin metadata */
    private final String isDogPremiumInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 lessonId;
    private final d3 d;
    /* renamed from: e, reason: from kotlin metadata */
    private final x<y<Boolean>> tracker = new x<>();
    /* renamed from: f, reason: from kotlin metadata */
    private final LiveData<y<Boolean>> userRepository = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f.this.tracker.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Boolean, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            f.this.tracker.postValue(new LoadResult_Success(boolean));
        }

        b() {
            super(1);
        }
    }
    public f(boolean z, String str, o3 o3Var, p1 p1Var, d3 d3Var) {
        n.f(str, "lessonId");
        n.f(o3Var, "tracker");
        n.f(p1Var, "userRepository");
        n.f(d3Var, "isDogPremiumInteractor");
        super();
        this.hasUserUnlockedFirstExam = z;
        this.isDogPremiumInteractor = str;
        this.lessonId = o3Var;
        this.d = d3Var;
        final x xVar = new x();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x showBecomePremium(f result) {
        return result.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Boolean>> getResult() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void laterTrackButtonClick() {
        this.lessonId.logEvent(E_TrainingProgram.n.c(new EP_LessonId(), this.isDogPremiumInteractor));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        String str = null;
        a0 observable2 = IsDogPremiumInteractor.b(this.d, str, 1, str).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "isDogPremiumInteractor.isCurrentDogPremium()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.f.a(this), new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.f.b(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final boolean showContentUnlock(y<Boolean> result) {
        Object result2 = null;
        int i;
        boolean z3 = false;
        result2 = result instanceof LoadResult_Success ? (LoadResult_Success)result2 : 0;
        i = 0;
        i = 1;
        int r0 = i;
        result = i;
        if (this.hasUserUnlockedFirstExam != 0 && i == 0 && this.hasUserUnlockedFirstExam) {
        }
        return z3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean l(y<Boolean> yVar) {
        boolean z2 = false;
        int i2 = 0;
        int i;
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        i = 1;
        yVar = i2 == 0 ? 0 : i;
        int r0 = i;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        this.lessonId.logEvent(E_TrainingProgram.s.withoutParameters());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.lessonId.logEvent(E_TrainingProgram.m.c(new EP_LessonId(), this.isDogPremiumInteractor));
    }
}
