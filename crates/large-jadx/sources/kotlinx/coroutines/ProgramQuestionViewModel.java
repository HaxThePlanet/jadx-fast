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
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: ProgramQuestionViewModel.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00190\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "getProgramQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "setQuestionAsComplete", "", "trackCorrectAnswerSelection", "trackIncorrectAnswerSelection", "answer", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ProgramQuestionViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramQuestion connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramSaveInfo exceptionHandler;
    private final o3 c;
    private final j1 d;
    /* renamed from: e, reason: from kotlin metadata */
    private final j2 programRepository;
    private final f.d.a.a<y<Boolean>> f = new a<>();
    private final f.d.a.a<Boolean> g = new a<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new h$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ h a;
        public b(CoroutineExceptionHandler.a exc, h hVar) {
            this.a = hVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.n().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.question.ProgramQuestionViewModel$setQuestionAsComplete$1", f = "ProgramQuestionViewModel.kt", l = 44, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            j1 j1Var;
            String dogId;
            String programId;
            String moduleId;
            String lessonId;
            String questionId;
            d dVar;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    h.this.n().postValue(new LoadResult_Success(b.a(true)));
                    h.this.setQuestionAsComplete().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            if (!(h.this.n().getValue() instanceof LoadResult_Loading)) {
                h.this.n().postValue(LoadResult_Loading.a);
                if (h.this.programRepository.a()) {
                    h.this.l().setType(ProgramQuestion_Type.ANSWERED);
                    this.label = i;
                    if (h.this.d.I(h.this.m().getDogId(), h.this.m().getProgramId(), h.this.m().getModuleId(), h.this.m().getLessonId(), h.this.l().getQuestionId(), this) == obj2) {
                        return obj2;
                    }
                } else {
                    h.this.c.setTrainingReminderUserProperties("program_question");
                    h.this.n().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(d<? super h.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.h.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.h.a(h.this, dVar);
        }
    }
    public h(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo, o3 o3Var, j1 j1Var, j2 j2Var) {
        n.f(programQuestion, "programQuestion");
        n.f(programSaveInfo, "programSaveInfo");
        n.f(o3Var, "tracker");
        n.f(j1Var, "programRepository");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = programQuestion;
        this.exceptionHandler = programSaveInfo;
        this.c = o3Var;
        this.d = j1Var;
        this.programRepository = j2Var;
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        final app.dogo.com.dogo_android.y.a0.h.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackIncorrectAnswerSelection(h answer) {
        return answer.programRepository;
    }

    public static final /* synthetic */ j1 i(h hVar) {
        return hVar.d;
    }

    public static final /* synthetic */ o3 j(h hVar) {
        return hVar.c;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final f.d.a.a<Boolean> setQuestionAsComplete() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramQuestion l() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramSaveInfo m() {
        return this.exceptionHandler;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> n() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        this.connectivityService.setType(ProgramQuestion_Type.ANSWERED);
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, null, new kotlinx.coroutines.h.a(this, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.c.logEvent(E_TrainingProgram.f.c(new EP_QuestionId(), this.connectivityService.getQuestionId(), new EP_IsCorrect(), Boolean.TRUE, new EP_AnswerIndex(), Integer.valueOf(this.connectivityService.getCorrectAnswer())));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q(String str) {
        n.f(str, "answer");
        this.c.logEvent(E_TrainingProgram.f.c(new EP_QuestionId(), this.connectivityService.getQuestionId(), new EP_IsCorrect(), Boolean.FALSE, new EP_AnswerIndex(), Integer.valueOf(l.e0(this.connectivityService.getQuestion(), str, 0, false, 6, null))));
    }
}
