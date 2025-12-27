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

/* compiled from: ProgramLessonCompleteViewModel.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0006\u0010\r\u001a\u00020\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getLessonIndex", "", "setOneLessonCompleted", "", "trackButtonClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ProgramLessonCompleteViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramLessonItem lessonItem;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 preferenceService;
    /* renamed from: c, reason: from kotlin metadata */
    private final p2 tracker;
    public d(ProgramLessonItem programLessonItem, o3 o3Var, p2 p2Var) {
        n.f(programLessonItem, "lessonItem");
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        super();
        this.lessonItem = programLessonItem;
        this.preferenceService = o3Var;
        this.tracker = p2Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final int getLessonIndex() {
        return this.lessonItem.getCurrentLessonPositionData().getLessonNumber();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.tracker.g1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        this.preferenceService.logEvent(E_TrainingProgram.j.c(new EP_LessonId(), this.lessonItem.getProgramSaveInfo().getLessonId()));
    }
}
