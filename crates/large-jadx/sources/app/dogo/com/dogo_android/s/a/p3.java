package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.dailytraining.l.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0008J\"\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingSessionInteractor;", "", "getProgramTricksInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;)V", "addTrainingSession", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "lesson", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "allTricks", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "lessonTricks", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p3 {

    private final app.dogo.com.dogo_android.s.a.y2 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.TrainingSessionInteractor", f = "TrainingSessionInteractor.kt", l = 12, m = "addTrainingSession")
    static final class a extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.p3 this$0;
        a(app.dogo.com.dogo_android.s.a.p3 p3, d<? super app.dogo.com.dogo_android.s.a.p3.a> d2) {
            this.this$0 = p3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(0, this);
        }
    }
    public p3(app.dogo.com.dogo_android.s.a.y2 y2) {
        n.f(y2, "getProgramTricksInteractor");
        super();
        this.a = y2;
    }

    public final Object a(ProgramLessonItem programLessonItem, d<? super ProgramLessonItem> d2) {
        Object result;
        boolean aVar;
        Object l$0;
        int label;
        Object l$1;
        int i;
        Object obj;
        int i2;
        Object obj2;
        final app.dogo.com.dogo_android.s.a.p3 p3Var = this;
        Object obj3 = d2;
        aVar = obj3;
        label = aVar.label;
        i = Integer.MIN_VALUE;
        if (obj3 instanceof p3.a && label & i != 0) {
            aVar = obj3;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                aVar.label = label -= i;
            } else {
                aVar = new p3.a(p3Var, obj3);
            }
        } else {
        }
        result = aVar.result;
        l$1 = b.d();
        int label2 = aVar.label;
        int i6 = 1;
        if (label2 != 0) {
            if (label2 != i6) {
            } else {
                l$0 = aVar.L$0;
                q.b(result);
                obj = l$1;
                return ProgramLessonItem.copy$default(obj, 0, 0, 0, 0, 0, 0, TrainingSession.copy$default(l$0.b((List)result, obj.getTrainingSession().getTrainingTricksList()), 0, obj.getTrainingSession().getExams(), obj.getTrainingSession().getHasUserUnlockedFirstModuleExam(), obj.getTrainingSession().isRepeatedTraining(), 1, 0), 0, 0, 0, false, false, 4031, 0);
            }
            IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw illegalStateException;
        }
        q.b(result);
        aVar.L$0 = p3Var;
        obj2 = programLessonItem;
        aVar.L$1 = obj2;
        aVar.label = i6;
        if (p3Var.a.a(programLessonItem.getProgramSaveInfo(), aVar) == l$1) {
            return l$1;
        }
        l$0 = p3Var;
        obj = obj2;
    }

    public final TrainingSession b(List<TrickItem> list, List<TrickItem> list2) {
        n.f(list, "allTricks");
        n.f(list2, "lessonTricks");
        return l.Companion.a(list, list2);
    }
}
