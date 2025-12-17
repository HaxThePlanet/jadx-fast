package app.dogo.com.dogo_android.y.z;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.s.a.x2;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.j0.a;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.h2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.w.u2;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
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
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u00100\u001a\u00020\u0018J\u0006\u00101\u001a\u00020\u0018J\u0008\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\u0006\u00107\u001a\u000203J\u0010\u00108\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0008\u00109\u001a\u000203H\u0002R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001a\"\u0004\u0008\u001f\u0010\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0$0#¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050$0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010,\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u001a\"\u0004\u0008/\u0010\u001c¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programId", "", "initialOverViewItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "certificateSeen", "", "getCertificateSeen", "()Z", "setCertificateSeen", "(Z)V", "dogSkillOverviewSeen", "getDogSkillOverviewSeen", "setDogSkillOverviewSeen", "mainHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "programStart", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getProgramStart", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "startErrorHandler", "userSkillOverViewSeen", "getUserSkillOverViewSeen", "setUserSkillOverViewSeen", "getIntroductionShowedFlag", "isLessonFlowChangeEnabled", "loadList", "", "onStartProgramTapped", "setIntroductionShowedFlag", "trackCloseButtonTapped", "trackLessonTutorialShowed", "trackProgramStarted", "trackStartProgramTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends s {

    private final String a;
    private final ProgramOverview b;
    private final x2 c;
    private final o3 d;
    private final p1 e;
    private final p2 f;
    private final r2 g;
    private final j1 h;
    private final v2 i;
    private final a j;
    private final CoroutineExceptionHandler k;
    private final CoroutineExceptionHandler l;
    private final x<y<ProgramOverview>> m;
    private final a<y<ProgramLessonItem>> n;
    private boolean o;
    private boolean p;
    private boolean q;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.z.g a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.z.g g2) {
            this.a = g2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.t().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.z.g a;
        public d(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.z.g g2) {
            this.a = g2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.s().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewViewModel$loadList$1", f = "ProgramOverviewViewModel.kt", l = 59, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.z.g this$0;
        a(app.dogo.com.dogo_android.y.z.g g, d<? super app.dogo.com.dogo_android.y.z.g.a> d2) {
            this.this$0 = g;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.a obj2 = new g.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object cVar;
            Object cVar2;
            int label;
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    cVar2 = new y.c((ProgramOverview)obj4);
                    this.this$0.t().postValue(cVar2);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            if (g.h(this.this$0) != null) {
                cVar = new y.c(g.h(this.this$0));
                this.this$0.t().setValue(cVar);
            } else {
                this.this$0.t().postValue(y.b.a);
                this.label = i;
                if (g.i(this.this$0).b(g.k(this.this$0), this) == obj) {
                    return obj;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewViewModel$onStartProgramTapped$1", f = "ProgramOverviewViewModel.kt", l = {73, 74, 83}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        final app.dogo.com.dogo_android.y.z.g this$0;
        b(app.dogo.com.dogo_android.y.z.g g, d<? super app.dogo.com.dogo_android.y.z.g.b> d2) {
            this.this$0 = g;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.b obj2 = new g.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            y.b programStarted;
            Object l$02;
            int i3;
            String str;
            Object obj2;
            String str2;
            Long num;
            int i;
            Object obj;
            int i2;
            int i4;
            Object obj14;
            l$0 = b.d();
            programStarted = this.label;
            final int i5 = 3;
            i3 = 2;
            final int i6 = 1;
            if (programStarted != 0) {
                if (programStarted != i6) {
                    if (programStarted != i3) {
                        if (programStarted != i5) {
                        } else {
                            l$0 = this.L$0;
                            q.b(object);
                            obj14 = l$0;
                            y.c cVar = new y.c(obj14);
                            this.this$0.s().postValue(cVar);
                            return w.a;
                        }
                        obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj14;
                    }
                    l$02 = this.L$0;
                    q.b(object);
                } else {
                    q.b(object);
                    l$02 = obj14;
                    this.L$0 = (String)l$02;
                    this.label = i3;
                    if (g.l(this.this$0).r(l$02, g.k(this.this$0), this) == l$0) {
                        return l$0;
                    }
                }
            } else {
                q.b(object);
                this.this$0.s().postValue(y.b.a);
                this.label = i6;
                if (g.n(this.this$0).u(this) == l$0) {
                    return l$0;
                }
            }
            obj2 = l$02;
            obj14 = g.j(this.this$0).e((k.b)obj14, obj2, 0, i6);
            app.dogo.com.dogo_android.y.z.g this$04 = this.this$0;
            g.o(this$04, g.k(this$04));
            this.L$0 = obj14;
            this.label = i5;
            if (this.this$0.v() && !obj14.getProgramStarted() && j1.H(g.l(this.this$0), obj2, g.k(this.this$0), b.d(g.m(this.this$0).g()), 0, this, 8, 0) == l$0) {
                if (!obj14.getProgramStarted()) {
                    this$04 = this.this$0;
                    g.o(this$04, g.k(this$04));
                    this.L$0 = obj14;
                    this.label = i5;
                    if (j1.H(g.l(this.this$0), obj2, g.k(this.this$0), b.d(g.m(this.this$0).g()), 0, this, 8, 0) == l$0) {
                        return l$0;
                    }
                    l$0 = obj14;
                }
            }
        }
    }
    public g(String string, ProgramOverview programOverview2, x2 x23, o3 o34, p1 p15, p2 p26, r2 r27, j1 j18, v2 v29, a a10) {
        n.f(string, "programId");
        n.f(x23, "interactor");
        n.f(o34, "tracker");
        n.f(p15, "userRepository");
        n.f(p26, "preferenceService");
        n.f(r27, "remoteConfigService");
        n.f(j18, "programRepository");
        n.f(v29, "timeUtils");
        n.f(a10, "lessonItemHelper");
        super();
        this.a = string;
        this.b = programOverview2;
        this.c = x23;
        this.d = o34;
        this.e = p15;
        this.f = p26;
        this.g = r27;
        this.h = j18;
        this.i = v29;
        this.j = a10;
        CoroutineExceptionHandler.a obj2 = CoroutineExceptionHandler.r;
        g.c obj3 = new g.c(obj2, this);
        this.k = obj3;
        obj3 = new g.d(obj2, this);
        this.l = obj3;
        obj2 = new x();
        this.m = obj2;
        obj2 = new a();
        this.n = obj2;
        w();
    }

    public g(String string, ProgramOverview programOverview2, x2 x23, o3 o34, p1 p15, p2 p26, r2 r27, j1 j18, v2 v29, a a10, int i11, g g12) {
        a aVar;
        a aVar2;
        if (i &= 512 != 0) {
            aVar = new a();
            aVar2 = aVar;
        } else {
            aVar2 = a10;
        }
        super(string, programOverview2, x23, o34, p15, p26, r27, j18, v29, aVar2);
    }

    private final void E(String string) {
        e2 e2Var = new e2();
        this.d.d(q0.g.c(e2Var, string));
    }

    private final void F() {
        String str;
        str = this.q ? "certificates" : z2 ? "dogLearn" : z3 ? "youLearn" : "none";
        h2 h2Var = new h2();
        this.d.d(q0.y.d(u.a(h2Var, str)));
    }

    public static final ProgramOverview h(app.dogo.com.dogo_android.y.z.g g) {
        return g.b;
    }

    public static final x2 i(app.dogo.com.dogo_android.y.z.g g) {
        return g.c;
    }

    public static final a j(app.dogo.com.dogo_android.y.z.g g) {
        return g.j;
    }

    public static final String k(app.dogo.com.dogo_android.y.z.g g) {
        return g.a;
    }

    public static final j1 l(app.dogo.com.dogo_android.y.z.g g) {
        return g.h;
    }

    public static final v2 m(app.dogo.com.dogo_android.y.z.g g) {
        return g.i;
    }

    public static final p1 n(app.dogo.com.dogo_android.y.z.g g) {
        return g.e;
    }

    public static final void o(app.dogo.com.dogo_android.y.z.g g, String string2) {
        g.E(string2);
    }

    private final void w() {
        final int i = 0;
        g.a aVar = new g.a(this, i);
        k.d(f0.a(this), this.k, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.f.f1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(boolean z) {
        this.p = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.d.c(q0.x);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D() {
        this.d.d(q0.q.h());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.q;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r() {
        return this.f.N();
    }

    public final a<y<ProgramLessonItem>> s() {
        return this.n;
    }

    public final x<y<ProgramOverview>> t() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean v() {
        return this.g.W();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        F();
        final int i = 0;
        g.b bVar = new g.b(this, i);
        k.d(f0.a(this), this.l, i, bVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(boolean z) {
        this.q = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(boolean z) {
        this.o = z;
    }
}
