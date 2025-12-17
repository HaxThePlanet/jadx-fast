package app.dogo.com.dogo_android.welcome_v2;

import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.f0;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "slides", "", "Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "getSlides", "()Ljava/util/List;", "isConnectedToInternet", "", "trackContinueTap", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class k0 extends s {

    private final o3 a;
    private final List<WelcomeSlide> b;
    public k0(o3 o3, j2 j22) {
        n.f(o3, "tracker");
        n.f(j22, "connectivityService");
        super();
        this.a = o3;
        WelcomeSlide[] obj8 = new WelcomeSlide[4];
        super(2131887677, 2131887669, 2131887673, 2131231372, j3.N0.f());
        super(2131887680, 2131887672, 2131887676, 2131231371, j3.O0.f());
        super(2131887678, 2131887670, 2131887674, 2131231374, j3.P0.f());
        super(2131887679, 2131887671, 2131887675, 2131231375, j3.Q0.f());
        this.b = p.j(obj9, obj9, obj9, obj9);
    }

    public final List<WelcomeSlide> h() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i(int i) {
        int i2;
        u2 u2Var;
        r2 r2Var;
        List list;
        int obj5;
        if (p.i(this.b) >= i) {
            r2Var = new r2();
            this.a.d(f0.c.d(u.a(r2Var, (WelcomeSlide)this.b.get(i).getTrackingTag().a())));
        }
    }
}
