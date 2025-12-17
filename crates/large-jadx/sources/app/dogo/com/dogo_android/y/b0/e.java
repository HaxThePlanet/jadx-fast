package app.dogo.com.dogo_android.y.b0;

import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.f2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.u2;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "programQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "getProgramQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getCorrectAnswer", "", "trackDoneClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final ProgramQuestion a;
    private final o3 b;
    public e(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo2, o3 o33) {
        n.f(programQuestion, "programQuestion");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(o33, "tracker");
        super();
        this.a = programQuestion;
        this.b = o33;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String h() {
        return (String)this.a.getAnswers().get(this.a.getCorrectAnswer());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final ProgramQuestion i() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        f2 f2Var = new f2();
        this.b.d(q0.i.c(f2Var, this.a.getQuestionId()));
    }
}
