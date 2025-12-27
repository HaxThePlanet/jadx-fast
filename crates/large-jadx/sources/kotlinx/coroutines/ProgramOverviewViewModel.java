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
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.h2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.w.u2;
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
import kotlinx.coroutines.m0;

/* compiled from: ProgramOverviewViewModel.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u00100\u001a\u00020\u0018J\u0006\u00101\u001a\u00020\u0018J\u0008\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\u0006\u00107\u001a\u000203J\u0010\u00108\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0008\u00109\u001a\u000203H\u0002R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001a\"\u0004\u0008\u001f\u0010\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0$0#¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050$0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010,\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u001a\"\u0004\u0008/\u0010\u001c¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programId", "", "initialOverViewItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "lessonItemHelper", "Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;)V", "certificateSeen", "", "getCertificateSeen", "()Z", "setCertificateSeen", "(Z)V", "dogSkillOverviewSeen", "getDogSkillOverviewSeen", "setDogSkillOverviewSeen", "mainHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "programStart", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getProgramStart", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "startErrorHandler", "userSkillOverViewSeen", "getUserSkillOverViewSeen", "setUserSkillOverViewSeen", "getIntroductionShowedFlag", "isLessonFlowChangeEnabled", "loadList", "", "onStartProgramTapped", "setIntroductionShowedFlag", "trackCloseButtonTapped", "trackLessonTutorialShowed", "trackProgramStarted", "trackStartProgramTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ProgramOverviewViewModel extends s {

    private final String a;
    private final ProgramOverview b;
    /* renamed from: c, reason: from kotlin metadata */
    private final x2 initialOverViewItem;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 interactor;
    /* renamed from: e, reason: from kotlin metadata */
    private final p1 lessonItemHelper;
    /* renamed from: f, reason: from kotlin metadata */
    private final p2 mainHandler;
    /* renamed from: g, reason: from kotlin metadata */
    private final r2 preferenceService;
    /* renamed from: h, reason: from kotlin metadata */
    private final j1 programId;
    /* renamed from: i, reason: from kotlin metadata */
    private final v2 programRepository;
    private final app.dogo.com.dogo_android.util.j0.a j;
    /* renamed from: k, reason: from kotlin metadata */
    private final CoroutineExceptionHandler remoteConfigService;
    private final CoroutineExceptionHandler l;
    /* renamed from: m, reason: from kotlin metadata */
    private final x<y<ProgramOverview>> startErrorHandler;
    /* renamed from: n, reason: from kotlin metadata */
    private final f.d.a.a<y<ProgramLessonItem>> timeUtils;
    /* renamed from: o, reason: from kotlin metadata */
    private boolean tracker;
    /* renamed from: p, reason: from kotlin metadata */
    private boolean userRepository;
    /* renamed from: q, reason: from kotlin metadata */
    private boolean userSkillOverViewSeen;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ g a;
        public c(CoroutineExceptionHandler.a exc, g gVar) {
            this.a = gVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.t().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ g a;
        public d(CoroutineExceptionHandler.a exc, g gVar) {
            this.a = gVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.s().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewViewModel$loadList$1", f = "ProgramOverviewViewModel.kt", l = 59, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    g.this.t().postValue(new LoadResult_Success((ProgramOverview)obj));
                    return w.a;
                }
            }
            q.b(object);
            if (g.this.b == null) {
                g.this.t().postValue(LoadResult_Loading.a);
                this.label = i;
                if (g.this.initialOverViewItem.b(g.this.a, this) == obj2) {
                    return obj2;
                }
            } else {
                g.this.t().setValue(new LoadResult_Success(g.this.b));
            }
        }

        a(d<? super g.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.g.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.g.a(g.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewViewModel$onStartProgramTapped$1", f = "ProgramOverviewViewModel.kt", l = {73, 74, 83}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            String object3;
            int label2;
            int i = 2;
            String str2;
            j1 j1Var;
            String str3;
            Long l;
            Long l2 = null;
            d dVar;
            int i2 = 8;
            Object obj2 = null;
            Object obj3;
            app.dogo.com.dogo_android.y.k.b bVar2;
            ProgramLessonItem object2;
            obj = b.d();
            final int i3 = 3;
            i = 2;
            final int i4 = 1;
            if (this.label != 0) {
                if (this.label != i4) {
                    if (this.label != i) {
                        if (this.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            g.this.s().postValue(new LoadResult_Success(object2));
                            return w.a;
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    object3 = obj3;
                    this.L$0 = object3;
                    this.label = i;
                    if (g.this.programId.r(object3, g.this.a, this) == obj) {
                        return obj;
                    }
                }
            } else {
                q.b(object);
                g.this.s().postValue(LoadResult_Loading.a);
                this.label = i4;
                if (g.this.lessonItemHelper.u(this) == obj) {
                    return obj;
                }
            }
            String str = null;
            object2 = g.this.j.generateLessonItem((DogoProgram_ClassicProgram)bVar2, object3, str, true);
            if (g.this.v() && !object2.getProgramStarted()) {
                g.this.trackProgramStarted(g.this.a);
                l2 = null;
                i2 = 8;
                obj2 = null;
                this.L$0 = object2;
                this.label = i3;
                if (ProgramRepository.H(g.this.programId, object3, g.this.a, b.d(g.this.programRepository.g()), l2, this, i2, obj2) == obj) {
                    return obj;
                }
            }
        }

        b(d<? super g.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.g.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.g.b(g.this, dVar);
        }
    }
    public /* synthetic */ g(String str, ProgramOverview programOverview, x2 x2Var, o3 o3Var, p1 p1Var, p2 p2Var, r2 r2Var, j1 j1Var, v2 v2Var, app.dogo.com.dogo_android.util.j0.a aVar, int i, kotlin.d0.d.g gVar) {
        app.dogo.com.dogo_android.util.j0.a aVar102;
        LessonItemHelper r11 = i & 512 != 0 ? new essonItemHelper() : aVar;
        this(str, programOverview, x2Var, o3Var, p1Var, p2Var, r2Var, j1Var, v2Var, (i & 512 != 0 ? new essonItemHelper() : aVar));
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final void trackProgramStarted(String programId) {
        this.interactor.logEvent(E_TrainingProgram.g.c(new EP_ProgramId(), programId));
    }

    /* renamed from: F, reason: from kotlin metadata */
    private final void getIntroductionShowedFlag() {
        String str;
        if (this.userSkillOverViewSeen) {
            str = "certificates";
        } else {
            if (this.tracker) {
                str = "dogLearn";
            } else {
                String r0 = this.userRepository ? "youLearn" : "none";
            }
        }
        this.interactor.logEvent((this.userRepository ? "youLearn" : "none"));
    }

    public static final /* synthetic */ ProgramOverview h(g gVar) {
        return gVar.b;
    }

    public static final /* synthetic */ x2 i(g gVar) {
        return gVar.initialOverViewItem;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.util.j0.a j(g gVar) {
        return gVar.j;
    }

    public static final /* synthetic */ String k(g gVar) {
        return gVar.a;
    }

    public static final /* synthetic */ j1 l(g gVar) {
        return gVar.programId;
    }

    public static final /* synthetic */ v2 m(g gVar) {
        return gVar.programRepository;
    }

    public static final /* synthetic */ p1 n(g gVar) {
        return gVar.lessonItemHelper;
    }

    public static final /* synthetic */ void o(g gVar, String str) {
        gVar.trackProgramStarted(str);
    }

    private final void w() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.remoteConfigService, dVar, new kotlinx.coroutines.g.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.mainHandler.f1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(boolean z) {
        this.userRepository = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.interactor.logEvent(E_TrainingProgram.x);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D() {
        this.interactor.logEvent(E_TrainingProgram.q.withoutParameters());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.userSkillOverViewSeen;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r() {
        return this.mainHandler.N();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<ProgramLessonItem>> s() {
        return this.timeUtils;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<ProgramOverview>> t() {
        return this.startErrorHandler;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean v() {
        return this.preferenceService.W();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        getIntroductionShowedFlag();
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.l, dVar, new kotlinx.coroutines.g.b(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(boolean z) {
        this.userSkillOverViewSeen = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(boolean z) {
        this.tracker = z;
    }

    public g(String str, ProgramOverview programOverview, x2 x2Var, o3 o3Var, p1 p1Var, p2 p2Var, r2 r2Var, j1 j1Var, v2 v2Var, app.dogo.com.dogo_android.util.j0.a aVar) {
        n.f(str, "programId");
        n.f(x2Var, "interactor");
        n.f(o3Var, "tracker");
        n.f(p1Var, "userRepository");
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        n.f(j1Var, "programRepository");
        n.f(v2Var, "timeUtils");
        n.f(aVar, "lessonItemHelper");
        super();
        this.a = str;
        this.b = programOverview;
        this.initialOverViewItem = x2Var;
        this.interactor = o3Var;
        this.lessonItemHelper = p1Var;
        this.mainHandler = p2Var;
        this.preferenceService = r2Var;
        this.programId = j1Var;
        this.programRepository = v2Var;
        this.j = aVar;
        CoroutineExceptionHandler.a aVar2 = kotlinx.coroutines.internal.CoroutineExceptionHandler.r;
        this.remoteConfigService = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(aVar2, this);
        this.l = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(aVar2, this);
        this.startErrorHandler = new x();
        this.timeUtils = new a();
        w();
    }
}
