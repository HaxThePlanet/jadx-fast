package app.dogo.com.dogo_android.y.a0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.f2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.s1;
import app.dogo.com.dogo_android.w.v0;
import app.dogo.com.dogo_android.w.w2;
import f.d.a.a;
import java.net.UnknownHostException;
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
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00190\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "setQuestionAsComplete", "", "trackCorrectAnswerSelection", "trackIncorrectAnswerSelection", "answer", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends s {

    private final ProgramQuestion a;
    private final ProgramSaveInfo b;
    private final o3 c;
    private final j1 d;
    private final j2 e;
    private final a<y<Boolean>> f;
    private final a<Boolean> g;
    private final CoroutineExceptionHandler h;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.a0.h a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.a0.h h2) {
            this.a = h2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.n().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.question.ProgramQuestionViewModel$setQuestionAsComplete$1", f = "ProgramQuestionViewModel.kt", l = 44, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.a0.h this$0;
        a(app.dogo.com.dogo_android.y.a0.h h, d<? super app.dogo.com.dogo_android.y.a0.h.a> d2) {
            this.this$0 = h;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (h.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            h.a obj2 = new h.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Boolean unknownHostException;
            j1 j1Var;
            String dogId;
            String programId;
            String moduleId;
            String lessonId;
            String questionId;
            Object obj;
            a obj11;
            aVar = b.d();
            unknownHostException = this.label;
            final int i = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i));
                    this.this$0.n().postValue(cVar);
                    this.this$0.k().postValue(b.a(i));
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            if (!obj11 instanceof y.b) {
                this.this$0.n().postValue(y.b.a);
                if (!h.h(this.this$0).a()) {
                    h.j(this.this$0).s("program_question");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.n().postValue(aVar);
                } else {
                    this.this$0.l().setType(ProgramQuestion.Type.ANSWERED);
                    this.label = i;
                    if (h.i(this.this$0).I(this.this$0.m().getDogId(), this.this$0.m().getProgramId(), this.this$0.m().getModuleId(), this.this$0.m().getLessonId(), this.this$0.l().getQuestionId(), this) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }
    public h(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo2, o3 o33, j1 j14, j2 j25) {
        n.f(programQuestion, "programQuestion");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(o33, "tracker");
        n.f(j14, "programRepository");
        n.f(j25, "connectivityService");
        super();
        this.a = programQuestion;
        this.b = programSaveInfo2;
        this.c = o33;
        this.d = j14;
        this.e = j25;
        a obj2 = new a();
        this.f = obj2;
        obj2 = new a();
        this.g = obj2;
        h.b obj3 = new h.b(CoroutineExceptionHandler.r, this);
        this.h = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.y.a0.h h) {
        return h.e;
    }

    public static final j1 i(app.dogo.com.dogo_android.y.a0.h h) {
        return h.d;
    }

    public static final o3 j(app.dogo.com.dogo_android.y.a0.h h) {
        return h.c;
    }

    public final a<Boolean> k() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramQuestion l() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramSaveInfo m() {
        return this.b;
    }

    public final a<y<Boolean>> n() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.a.setType(ProgramQuestion.Type.ANSWERED);
        h.a aVar = new h.a(this, 0);
        k.d(f0.a(this), this.h, 0, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        f2 f2Var = new f2();
        s1 s1Var = new s1();
        v0 v0Var = new v0();
        this.c.d(q0.f.c(f2Var, this.a.getQuestionId(), s1Var, Boolean.TRUE, v0Var, Integer.valueOf(this.a.getCorrectAnswer())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q(String string) {
        n.f(string, "answer");
        f2 f2Var = new f2();
        s1 s1Var = new s1();
        v0 v0Var = new v0();
        this.c.d(q0.f.c(f2Var, this.a.getQuestionId(), s1Var, Boolean.FALSE, v0Var, Integer.valueOf(l.e0(this.a.getQuestion(), string, 0, false, 6, 0))));
    }
}
