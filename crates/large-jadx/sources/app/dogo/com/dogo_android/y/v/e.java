package app.dogo.com.dogo_android.y.v;

import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;
import app.dogo.com.dogo_android.s.a.u2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getProgramLessonIntroductionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonIntroductionInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonIntroductionInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "listOfLessonIntroduction", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "trackLessonTutorialCompleted", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final u2 a;
    private final o3 b;
    public e(u2 u2, o3 o32) {
        n.f(u2, "getProgramLessonIntroductionInteractor");
        n.f(o32, "tracker");
        super();
        this.a = u2;
        this.b = o32;
    }

    public final List<LessonIntroduction> h() {
        return this.a.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.b.d(q0.r.h());
    }
}
