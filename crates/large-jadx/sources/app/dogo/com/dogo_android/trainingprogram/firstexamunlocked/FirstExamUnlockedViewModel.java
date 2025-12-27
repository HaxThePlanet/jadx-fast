package app.dogo.com.dogo_android.y.r;

import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.u2;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: FirstExamUnlockedViewModel.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "trackRecordExamClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class FirstExamUnlockedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final TrickItem authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final DogProfile dogProfile;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 preferenceService;
    /* renamed from: d, reason: from kotlin metadata */
    private final p2 trickItem;
    public e(TrickItem trickItem, DogProfile dogProfile, h2 h2Var, p2 p2Var) {
        n.f(trickItem, "trickItem");
        n.f(dogProfile, "dogProfile");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        super();
        this.authService = trickItem;
        this.dogProfile = dogProfile;
        this.preferenceService = h2Var;
        this.trickItem = p2Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final Exam getExam() {
        Exam exam = new Exam(this.authService, this.dogProfile.toModel(this.preferenceService.v()), this.preferenceService.v(), this.trickItem.W(), null, 16, null);
        return exam;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        App.INSTANCE.r().logEvent(E_Training.p.c(new EP_TrickId(), this.authService.getId()));
    }
}
