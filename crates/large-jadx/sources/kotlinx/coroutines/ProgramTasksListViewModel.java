package app.dogo.com.dogo_android.y.c0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.k2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.q2;
import app.dogo.com.dogo_android.w.v2;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: ProgramTasksListViewModel.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B3\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0008\u0010!\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020#R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u001d0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "Landroidx/lifecycle/ViewModel;", "taskList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "isNewChanges", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "result", "Landroidx/lifecycle/MutableLiveData;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "getTaskList", "()Ljava/util/List;", "isAllTasksCompleted", "saveCompletedTasks", "", "setTaskAsComplete", "item", "trackTasksCompletedClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ProgramTasksListViewModel extends e0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<ProgramTasks> connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramSaveInfo exceptionHandler;
    private final j1 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 isNewChanges;
    /* renamed from: e, reason: from kotlin metadata */
    private final j2 programRepository;
    private final x<List<ProgramTasks>> f = new x<>();
    private final f.d.a.a<y<Boolean>> g = new a<>();
    private final f.d.a.a<Boolean> h = new a<>();
    private boolean i;
    /* renamed from: j, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new f$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ f a;
        public b(CoroutineExceptionHandler.a exc, f fVar) {
            this.a = fVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.n().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.tasklist.ProgramTasksListViewModel$saveCompletedTasks$1", f = "ProgramTasksListViewModel.kt", l = 44, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            j1 j1Var;
            String dogId;
            boolean z2 = false;
            String programId;
            String moduleId;
            String lessonId;
            ArrayList arrayList2;
            d dVar;
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    f.this.n().postValue(new LoadResult_Success(b.a(true)));
                    f.this.k().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            z = f.this.n().getValue() instanceof LoadResult_Loading;
            if (!(f.this.n().getValue() instanceof oadResult_Loading)) {
                f.this.n().postValue(LoadResult_Loading.a);
                if (f.this.programRepository.a()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = f.this.o().iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        int r5 = (ProgramTasks)item.getType() == ProgramTasks_Type.COMPLETED ? i : 0;
                    }
                    arrayList2 = new ArrayList(p.r(arrayList, 10));
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add((ProgramTasks)it2.next().getTaskId());
                    }
                    this.label = i;
                    if (f.this.c.J(f.this.l().getDogId(), f.this.l().getProgramId(), f.this.l().getModuleId(), f.this.l().getLessonId(), arrayList2, this) == obj) {
                        return obj;
                    }
                } else {
                    f.this.isNewChanges.setTrainingReminderUserProperties("program_task_list");
                    f.this.n().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(d<? super f.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.f.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.f.a(f.this, dVar);
        }
    }
    public f(List<ProgramTasks> list, ProgramSaveInfo programSaveInfo, j1 j1Var, o3 o3Var, j2 j2Var) {
        n.f(list, "taskList");
        n.f(programSaveInfo, "programSaveInfo");
        n.f(j1Var, "programRepository");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = list;
        this.exceptionHandler = programSaveInfo;
        this.c = j1Var;
        this.isNewChanges = o3Var;
        this.programRepository = j2Var;
        x xVar = new x(list);
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        app.dogo.com.dogo_android.y.c0.f.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 setTaskAsComplete(f item) {
        return item.programRepository;
    }

    public static final /* synthetic */ j1 i(f fVar) {
        return fVar.c;
    }

    public static final /* synthetic */ o3 j(f fVar) {
        return fVar.isNewChanges;
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final boolean isAllTasksCompleted() {
        Iterator it;
        boolean hasNext;
        boolean z = false;
        ProgramTasks.Type nOT_STARTED2;
        hasNext = connectivityService2 instanceof Collection;
        final int i2 = 1;
        int r2 = i2;
        return i2;
    }

    @Override // androidx.lifecycle.e0
    public final f.d.a.a<Boolean> k() {
        return this.h;
    }

    @Override // androidx.lifecycle.e0
    public final ProgramSaveInfo l() {
        return this.exceptionHandler;
    }

    @Override // androidx.lifecycle.e0
    public final x<List<ProgramTasks>> m() {
        return this.f;
    }

    @Override // androidx.lifecycle.e0
    public final f.d.a.a<y<Boolean>> n() {
        return this.g;
    }

    @Override // androidx.lifecycle.e0
    public final List<ProgramTasks> o() {
        return this.connectivityService;
    }

    @Override // androidx.lifecycle.e0
    public final boolean q() {
        return this.i;
    }

    @Override // androidx.lifecycle.e0
    public final void r() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.f.a(this, dVar), 2, null);
    }

    @Override // androidx.lifecycle.e0
    public final void s(ProgramTasks programTasks) {
        n.f(programTasks, "item");
        this.i = true;
        this.isNewChanges.logEvent(E_TrainingProgram.d.withParameters(u.a(new EP_TaskId(), programTasks.getTaskId()), u.a(new EP_Value(), Boolean.TRUE)));
        if (isAllTasksCompleted()) {
            this.isNewChanges.logEvent(E_TrainingProgram.a);
        }
        this.f.setValue(this.connectivityService);
    }

    @Override // androidx.lifecycle.e0
    public final void t() {
        this.isNewChanges.logEvent(E_TrainingProgram.b);
    }
}
