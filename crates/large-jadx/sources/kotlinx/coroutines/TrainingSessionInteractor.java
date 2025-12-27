package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.dailytraining.l.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: TrainingSessionInteractor.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0008J\"\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;", "", "getProgramTricksInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;)V", "addTrainingSession", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "lesson", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "allTricks", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "lessonTricks", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p3, reason: from kotlin metadata */
public final class TrainingSessionInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final y2 getProgramTricksInteractor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingSessionInteractor", f = "TrainingSessionInteractor.kt", l = 12, m = "addTrainingSession")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super p3.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return p3.this.generateSession(null, this);
        }
    }
    public p3(y2 y2Var) {
        n.f(y2Var, "getProgramTricksInteractor");
        super();
        this.getProgramTricksInteractor = y2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final Object generateSession(ProgramLessonItem allTricks, kotlin.b0.d<? super ProgramLessonItem> lessonTricks) {
        List list;
        Object lessonTricks2;
        Object obj;
        int label2;
        int i = -2147483648;
        ProgramLessonItem programLessonItem;
        int i2;
        final app.dogo.com.dogo_android.s.a.p3 p3Var = this;
        lessonTricks2 = lessonTricks;
        z = lessonTricks2 instanceof kotlinx.coroutines.p3.a;
        if (lessonTricks2 instanceof kotlinx.coroutines.p3.a) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                lessonTricks2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.p3.a aVar = new kotlinx.coroutines.p3.a(p3Var, lessonTricks2);
            }
        }
        Object obj2 = b.d();
        int i6 = 1;
        if (lessonTricks2.label != 0) {
            if (lessonTricks2.label != i6) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(lessonTricks2.result);
                return ProgramLessonItem.copy$default(programLessonItem, null, null, null, null, null, ProgramLessonItem$ProgramLessonStatus.NOT_STARTED, TrainingSession.copy$default(obj.b((List)list, programLessonItem.getTrainingSession().getTrainingTricksList()), null, programLessonItem.getTrainingSession().getExams(), programLessonItem.getTrainingSession().getHasUserUnlockedFirstModuleExam(), programLessonItem.getTrainingSession().isRepeatedTraining(), 1, null), null, null, null, false, false, 4031, null);
            }
        }
        q.b(lessonTricks2.result);
        lessonTricks2.L$0 = p3Var;
        allTricks2 = allTricks;
        lessonTricks2.L$1 = allTricks2;
        lessonTricks2.label = i6;
        if (p3Var.getProgramTricksInteractor.a(allTricks.getProgramSaveInfo(), lessonTricks2) == obj2) {
            return obj2;
        }
    }

    public final TrainingSession b(List<TrickItem> list, List<TrickItem> list2) {
        n.f(list, "allTricks");
        n.f(list2, "lessonTricks");
        return SessionViewModel.INSTANCE.fillTrainingSession(list, list2);
    }
}
