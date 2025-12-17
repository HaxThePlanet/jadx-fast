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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getExam", "Lapp/dogo/com/dogo_android/model/Exam;", "trackRecordExamClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final TrickItem a;
    private final DogProfile b;
    private final h2 c;
    private final p2 d;
    public e(TrickItem trickItem, DogProfile dogProfile2, h2 h23, p2 p24) {
        n.f(trickItem, "trickItem");
        n.f(dogProfile2, "dogProfile");
        n.f(h23, "authService");
        n.f(p24, "preferenceService");
        super();
        this.a = trickItem;
        this.b = dogProfile2;
        this.c = h23;
        this.d = p24;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Exam h() {
        super(this.a, this.b.toModel(this.c.v()), this.c.v(), this.d.W(), 0, 16, 0);
        return exam2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        n2 n2Var = new n2();
        App.Companion.r().d(p0.p.c(n2Var, this.a.getId()));
    }
}
