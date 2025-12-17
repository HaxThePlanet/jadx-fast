package app.dogo.com.dogo_android.y.t;

import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0006\u0010\r\u001a\u00020\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getLessonIndex", "", "setOneLessonCompleted", "", "trackButtonClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final ProgramLessonItem a;
    private final o3 b;
    private final p2 c;
    public d(ProgramLessonItem programLessonItem, o3 o32, p2 p23) {
        n.f(programLessonItem, "lessonItem");
        n.f(o32, "tracker");
        n.f(p23, "preferenceService");
        super();
        this.a = programLessonItem;
        this.b = o32;
        this.c = p23;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int h() {
        return this.a.getCurrentLessonPositionData().getLessonNumber();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.c.g1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        w1 w1Var = new w1();
        this.b.d(q0.j.c(w1Var, this.a.getProgramSaveInfo().getLessonId()));
    }
}
