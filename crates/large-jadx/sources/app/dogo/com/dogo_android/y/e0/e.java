package app.dogo.com.dogo_android.y.e0;

import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.v2;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTracker", "()Lapp/dogo/com/dogo_android/tracking/Tracker;", "getTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "trackLetsTryButtonTap", "", "trackNotNowButtonTap", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    public static final app.dogo.com.dogo_android.y.e0.e.a Companion;
    private final TrickItem a;
    private final o3 b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel$Companion;", "", "()V", "TRACKING_BUTTON_TYPE_LETS_TRY", "", "TRACKING_BUTTON_TYPE_NOT_NOW", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.Companion = aVar;
    }

    public e(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, o3 o33) {
        n.f(trickItem, "trick");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(o33, "tracker");
        super();
        this.a = trickItem;
        this.b = o33;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem h() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        n2 n2Var = new n2();
        o2 o2Var = new o2();
        this.b.d(q0.B.d(u.a(n2Var, this.a.getId()), u.a(o2Var, "try")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        n2 n2Var = new n2();
        o2 o2Var = new o2();
        this.b.d(q0.B.d(u.a(n2Var, this.a.getId()), u.a(o2Var, "no")));
    }
}
