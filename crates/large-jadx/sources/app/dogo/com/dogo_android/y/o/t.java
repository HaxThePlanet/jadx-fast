package app.dogo.com.dogo_android.y.o;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.a.n2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.a;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.l1;
import app.dogo.com.dogo_android.w.m2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.u2;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
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
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018J\u001c\u0010+\u001a\u00020\u00052\u0014\u0010 \u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016J\u0008\u0010,\u001a\u00020\u0005H\u0002J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020/J\u0008\u00100\u001a\u00020/H\u0002J\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\u000e\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u0005R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001fR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160!¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickName", "", "trickId", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "isUserIntroducedToExams", "", "()Z", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getTrickId", "()Ljava/lang/String;", "getTrickName", "getCountryCode", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "item", "getLoadedTrickName", "getSelectedLocale", "getUserId", "loadList", "", "loadModuleExam", "retry", "setUserAsIntroducedToExams", "trackLeaveFeedbackTapped", "trainerName", "trackRetakeExamTapped", "examId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t extends s {

    private final ProgramSaveInfo a;
    private final String b;
    private final String c;
    private final n2 d;
    private final h2 e;
    private final p2 f;
    private final u2 g;
    private final o3 h;
    private final j2 i;
    private final CoroutineExceptionHandler j;
    private final x<y<List<ProgramExam>>> k;
    private final LiveData<y<List<ProgramExam>>> l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.o.t a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.o.t t2) {
            this.a = t2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            t.l(this.a).postValue(aVar);
            a.d(throwable2);
            k1 k1Var = new k1();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exam with trickId: ");
            stringBuilder.append(this.a.q());
            stringBuilder.append(" fetch failed");
            t.k(this.a).d(a0.j.d(u.a(k1Var, stringBuilder.toString())));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.examlist.LessonExamHistoryViewModel$loadModuleExam$1", f = "LessonExamHistoryViewModel.kt", l = 60, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.o.t this$0;
        a(app.dogo.com.dogo_android.y.o.t t, d<? super app.dogo.com.dogo_android.y.o.t.a> d2) {
            this.this$0 = t;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (t.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            t.a obj2 = new t.a(this.this$0, d2);
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
            int dogId;
            String programId;
            String str;
            Object obj6;
            Object obj = b.d();
            dogId = this.label;
            final int i = 1;
            if (dogId != 0) {
                if (dogId != i) {
                } else {
                    q.b(object);
                    unknownHostException = new y.c((List)obj6);
                    t.l(this.this$0).postValue(unknownHostException);
                    return w.a;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            q.b(object);
            t.l(this.this$0).postValue(y.b.a);
            if (!t.h(this.this$0).a()) {
                t.k(this.this$0).s("lesson_exam_list");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                t.l(this.this$0).postValue(aVar);
            } else {
                this.label = i;
                if (t.i(this.this$0).e(t.j(this.this$0).getDogId(), t.j(this.this$0).getProgramId(), this.this$0.q(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public t(ProgramSaveInfo programSaveInfo, String string2, String string3, n2 n24, h2 h25, p2 p26, u2 u27, o3 o38, j2 j29) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "trickName");
        n.f(string3, "trickId");
        n.f(n24, "interactor");
        n.f(h25, "authService");
        n.f(p26, "preferenceService");
        n.f(u27, "userLocalCacheService");
        n.f(o38, "tracker");
        n.f(j29, "connectivityService");
        super();
        this.a = programSaveInfo;
        this.b = string2;
        this.c = string3;
        this.d = n24;
        this.e = h25;
        this.f = p26;
        this.g = u27;
        this.h = o38;
        this.i = j29;
        t.b obj3 = new t.b(CoroutineExceptionHandler.r, this);
        this.j = obj3;
        x obj2 = new x();
        this.k = obj2;
        this.l = obj2;
    }

    public static final j2 h(app.dogo.com.dogo_android.y.o.t t) {
        return t.i;
    }

    public static final n2 i(app.dogo.com.dogo_android.y.o.t t) {
        return t.d;
    }

    public static final ProgramSaveInfo j(app.dogo.com.dogo_android.y.o.t t) {
        return t.a;
    }

    public static final o3 k(app.dogo.com.dogo_android.y.o.t t) {
        return t.h;
    }

    public static final x l(app.dogo.com.dogo_android.y.o.t t) {
        return t.k;
    }

    private final String p() {
        return this.f.W();
    }

    private final void u() {
        final int i = 0;
        t.a aVar = new t.a(this, i);
        k.d(f0.a(this), this.j, i, aVar, 2, 0);
    }

    public final LiveData<y<List<ProgramExam>>> getResult() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String m() {
        String str;
        if (this.g.A().i().b() == null) {
            str = "null";
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Exam n(ProgramExam programExam) {
        n.f(programExam, "item");
        return j1.m0(programExam, this.g.A().g().toModel(this.e.v()), r(), p());
    }

    public final String o(y<? extends List<ProgramExam>> y) {
        boolean next;
        int name;
        boolean z;
        String str;
        Object obj5;
        name = 0;
        if (y instanceof y.c) {
        } else {
            obj5 = name;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((List)obj5 == null) {
            } else {
                obj5 = (List)obj5.iterator();
                for (Object next : obj5) {
                }
                next = name;
                if ((ProgramExam)next == 0) {
                } else {
                    name = (ProgramExam)next.getName();
                }
            }
        }
        if (name == null) {
            name = this.b;
        }
        return name;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String q() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.e.v();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean s() {
        return this.f.s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        u();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        t();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.f.I0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x(String string) {
        n.f(string, "trainerName");
        m2 m2Var = new m2();
        this.h.d(q0.w.c(m2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String string) {
        n.f(string, "examId");
        l1 l1Var = new l1();
        this.h.d(q0.v.c(l1Var, string));
    }
}
