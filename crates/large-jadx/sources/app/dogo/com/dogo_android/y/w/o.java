package app.dogo.com.dogo_android.y.w;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.s.a.v2;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110!¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u0016\"\u0004\u0008&\u0010'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programId", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "certificateEnabled", "", "getCertificateEnabled", "()Z", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "programDescription", "getProgramDescription", "()Landroidx/lifecycle/MutableLiveData;", "programName", "getProgramName", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldScrollToLastUnlocked", "getShouldScrollToLastUnlocked", "setShouldScrollToLastUnlocked", "(Z)V", "getIntroductionShowedFlag", "isProgramTutorialFinished", "loadList", "", "setIntroductionShowedFlag", "setLastRateUsPopUpCallTime", "timeToShowPopUp", "trackLessonTutorialShowed", "trackLockedItemPressed", "trackPremiumOpenFromLockedAlert", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends s {

    private final String a;
    private final v2 b;
    private final o3 c;
    private final r2 d;
    private final k1 e;
    private final p2 f;
    private final x<String> g;
    private final x<String> h;
    private boolean i = true;
    private final x<y<Program>> j;
    private final LiveData<y<Program>> k;
    private final CoroutineExceptionHandler l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.w.o a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.w.o o2) {
            this.a = o2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            o.k(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.lessonslist.ProgramLessonsListViewModel$loadList$1", f = "ProgramLessonsListViewModel.kt", l = 49, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.w.o this$0;
        a(app.dogo.com.dogo_android.y.w.o o, d<? super app.dogo.com.dogo_android.y.w.o.a> d2) {
            this.this$0 = o;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (o.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            o.a obj2 = new o.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Object unknownHostException;
            int label;
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c((Program)obj4);
                    o.k(this.this$0).postValue(cVar);
                    this.this$0.o().postValue(obj4.getName());
                    this.this$0.n().postValue(obj4.getDescription());
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            o.k(this.this$0).postValue(y.b.a);
            if (!App.Companion.e().a()) {
                o.j(this.this$0).s("program_lesson_list");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                o.k(this.this$0).postValue(aVar);
            } else {
                this.label = i;
                if (o.h(this.this$0).w(o.i(this.this$0), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public o(String string, v2 v22, o3 o33, r2 r24, k1 k15, p2 p26) {
        n.f(string, "programId");
        n.f(v22, "interactor");
        n.f(o33, "tracker");
        n.f(r24, "remoteConfigService");
        n.f(k15, "rateRepository");
        n.f(p26, "preferenceService");
        super();
        this.a = string;
        this.b = v22;
        this.c = o33;
        this.d = r24;
        this.e = k15;
        this.f = p26;
        x obj2 = new x();
        this.g = obj2;
        obj2 = new x();
        this.h = obj2;
        obj2 = 1;
        obj2 = new x();
        this.j = obj2;
        this.k = obj2;
        o.b obj3 = new o.b(CoroutineExceptionHandler.r, this);
        this.l = obj3;
    }

    public static final v2 h(app.dogo.com.dogo_android.y.w.o o) {
        return o.b;
    }

    public static final String i(app.dogo.com.dogo_android.y.w.o o) {
        return o.a;
    }

    public static final o3 j(app.dogo.com.dogo_android.y.w.o o) {
        return o.c;
    }

    public static final x k(app.dogo.com.dogo_android.y.w.o o) {
        return o.j;
    }

    public final LiveData<y<Program>> getResult() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean l() {
        return this.d.P();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.f.N();
    }

    public final x<String> n() {
        return this.h;
    }

    public final x<String> o() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.f.k0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        final int i = 0;
        o.a aVar = new o.a(this, i);
        k.d(f0.a(this), this.l, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        this.f.f1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.e.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(boolean z) {
        this.i = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean v() {
        return this.e.i();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.c.d(q0.q.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.c.d(q0.c.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y() {
        this.c.d(q0.c.h());
    }
}
