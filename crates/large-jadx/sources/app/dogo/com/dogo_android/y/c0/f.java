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
import f.d.a.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B3\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0008\u0010!\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020#R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u001d0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "Landroidx/lifecycle/ViewModel;", "taskList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "isNewChanges", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "result", "Landroidx/lifecycle/MutableLiveData;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "getTaskList", "()Ljava/util/List;", "isAllTasksCompleted", "saveCompletedTasks", "", "setTaskAsComplete", "item", "trackTasksCompletedClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends e0 {

    private final List<ProgramTasks> a;
    private final ProgramSaveInfo b;
    private final j1 c;
    private final o3 d;
    private final j2 e;
    private final x<List<ProgramTasks>> f;
    private final a<y<Boolean>> g;
    private final a<Boolean> h;
    private boolean i;
    private final CoroutineExceptionHandler j;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.c0.f a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.c0.f f2) {
            this.a = f2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.n().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.tasklist.ProgramTasksListViewModel$saveCompletedTasks$1", f = "ProgramTasksListViewModel.kt", l = 44, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.c0.f this$0;
        a(app.dogo.com.dogo_android.y.c0.f f, d<? super app.dogo.com.dogo_android.y.c0.f.a> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.a obj2 = new f.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            int unknownHostException;
            ArrayList arrayList2;
            j1 next;
            String dogId;
            String booleanValue;
            int i;
            String cOMPLETED;
            String lessonId;
            ArrayList arrayList;
            Object obj;
            boolean obj11;
            aVar = b.d();
            unknownHostException = this.label;
            final int i2 = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i2) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i2));
                    this.this$0.n().postValue(cVar);
                    this.this$0.k().postValue(b.a(i2));
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            if (!obj11 instanceof y.b) {
                this.this$0.n().postValue(y.b.a);
                if (!f.h(this.this$0).a()) {
                    f.j(this.this$0).s("program_task_list");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.n().postValue(aVar);
                } else {
                    arrayList2 = new ArrayList();
                    obj11 = this.this$0.o().iterator();
                    while (obj11.hasNext()) {
                        next = obj11.next();
                        if ((ProgramTasks)next.getType() == ProgramTasks.Type.COMPLETED) {
                        } else {
                        }
                        i = 0;
                        if (b.a(i).booleanValue()) {
                        }
                        arrayList2.add(next);
                        i = i2;
                    }
                    arrayList = new ArrayList(p.r(arrayList2, 10));
                    obj11 = arrayList2.iterator();
                    for (ProgramTasks next2 : obj11) {
                        arrayList.add(next2.getTaskId());
                    }
                    this.label = i2;
                    if (f.i(this.this$0).J(this.this$0.l().getDogId(), this.this$0.l().getProgramId(), this.this$0.l().getModuleId(), this.this$0.l().getLessonId(), arrayList, this) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }
    public f(List<ProgramTasks> list, ProgramSaveInfo programSaveInfo2, j1 j13, o3 o34, j2 j25) {
        n.f(list, "taskList");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(j13, "programRepository");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        super();
        this.a = list;
        this.b = programSaveInfo2;
        this.c = j13;
        this.d = o34;
        this.e = j25;
        x obj3 = new x(list);
        this.f = obj3;
        a obj2 = new a();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        obj3 = new f.b(CoroutineExceptionHandler.r, this);
        this.j = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.y.c0.f f) {
        return f.e;
    }

    public static final j1 i(app.dogo.com.dogo_android.y.c0.f f) {
        return f.c;
    }

    public static final o3 j(app.dogo.com.dogo_android.y.c0.f f) {
        return f.d;
    }

    private final boolean p() {
        Object iterator;
        boolean empty;
        int i;
        ProgramTasks.Type nOT_STARTED;
        iterator = this.a;
        final int i2 = 1;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
                i = i2;
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if ((ProgramTasks)iterator.next().getType() == ProgramTasks.Type.NOT_STARTED) {
                    } else {
                    }
                    empty = i;
                    if (!empty) {
                        break;
                    }
                    empty = i2;
                }
            }
        } else {
        }
        return i;
    }

    public final a<Boolean> k() {
        return this.h;
    }

    @Override // androidx.lifecycle.e0
    public final ProgramSaveInfo l() {
        return this.b;
    }

    public final x<List<ProgramTasks>> m() {
        return this.f;
    }

    public final a<y<Boolean>> n() {
        return this.g;
    }

    public final List<ProgramTasks> o() {
        return this.a;
    }

    @Override // androidx.lifecycle.e0
    public final boolean q() {
        return this.i;
    }

    @Override // androidx.lifecycle.e0
    public final void r() {
        final int i = 0;
        f.a aVar = new f.a(this, i);
        k.d(f0.a(this), this.j, i, aVar, 2, 0);
    }

    @Override // androidx.lifecycle.e0
    public final void s(ProgramTasks programTasks) {
        Object o3Var;
        boolean obj5;
        n.f(programTasks, "item");
        this.i = true;
        k2 k2Var = new k2();
        q2 q2Var = new q2();
        this.d.d(q0.d.d(u.a(k2Var, programTasks.getTaskId()), u.a(q2Var, Boolean.TRUE)));
        if (p()) {
            this.d.c(q0.a);
        }
        this.f.setValue(this.a);
    }

    @Override // androidx.lifecycle.e0
    public final void t() {
        this.d.c(q0.b);
    }
}
