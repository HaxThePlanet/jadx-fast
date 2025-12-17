package app.dogo.com.dogo_android.i;

import androidx.lifecycle.f0;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.android.persistencedb.room.entity.CouponEntity;
import app.dogo.com.dogo_android.s.a.b2;
import app.dogo.com.dogo_android.s.b.e1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import e.a.a.a.b.b.s;
import i.b.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0016\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0010\u0010.\u001a\u00020(2\u0008\u0010/\u001a\u0004\u0018\u00010\u0016J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020(J\u0006\u00102\u001a\u00020(J\u0006\u00103\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001a0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "couponEntityDao", "Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "currentDogId", "", "getCurrentDogId", "()Ljava/lang/String;", "isAmbassador", "", "()Z", "isForcedUserDogPremium", "isForcedUserPremium", "isForcedUserResubscribe", "listRefreshNotifier", "Landroidx/lifecycle/MediatorLiveData;", "getListRefreshNotifier", "()Landroidx/lifecycle/MediatorLiveData;", "userInfoMap", "", "getUserInfoMap", "()Ljava/util/Map;", "clearDebugOverrides", "", "resetCouponsInRoom", "saveCoupon", "durationMs", "", "style", "setFirstOpen", "source", "toggleAmbassador", "toggleUserDogPremium", "toggleUserPremium", "toggleUserResubscribe", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h0 extends s {

    private final h2 a;
    private final r2 b;
    private final e1 c;
    private final s d;
    private final o3 e;
    private final p1 f;
    private final v2 g;
    private final b2 h;
    private final h0 i;
    private final v<Boolean> j;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.debug.DebugDataFragmentViewModel$saveCoupon$1", f = "DebugDataFragmentViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final long $durationMs;
        final String $style;
        int label;
        final app.dogo.com.dogo_android.i.h0 this$0;
        a(long l, app.dogo.com.dogo_android.i.h0 h02, String string3, d<? super app.dogo.com.dogo_android.i.h0.a> d4) {
            this.$durationMs = l;
            this.this$0 = string3;
            this.$style = d4;
            super(2, obj5);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (h0.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.$durationMs, obj2, this.this$0, this.$style, d2);
            return obj7;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                super("test_coupon", 1, obj4, "default", this.$durationMs, obj7, h0.j(this.this$0).g(), obj9, this.$style, 0, 0, 0);
                CouponEntity[] arr = new CouponEntity[1];
                h0.h(this.this$0).f(obj15).e();
                h0.i(this.this$0).c(m1.o(obj15));
                return w.a;
            }
            IllegalStateException obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj15;
        }
    }
    public h0(h2 h2, r2 r22, e1 e13, s s4, o3 o35, p1 p16, v2 v27, b2 b28, h0 h09) {
        n.f(h2, "authService");
        n.f(r22, "remoteConfigService");
        n.f(e13, "debugRepository");
        n.f(s4, "couponEntityDao");
        n.f(o35, "tracker");
        n.f(p16, "userRepository");
        n.f(v27, "timeUtils");
        n.f(b28, "couponNotificationInteractor");
        n.f(h09, "dispatcher");
        super();
        this.a = h2;
        this.b = r22;
        this.c = e13;
        this.d = s4;
        this.e = o35;
        this.f = p16;
        this.g = v27;
        this.h = b28;
        this.i = h09;
        v obj2 = new v();
        this.j = obj2;
    }

    public h0(h2 h2, r2 r22, e1 e13, s s4, o3 o35, p1 p16, v2 v27, b2 b28, h0 h09, int i10, g g11) {
        h0 i;
        h0 h0Var;
        if (i2 &= 256 != 0) {
            h0Var = i;
        } else {
            h0Var = h09;
        }
        super(h2, r22, e13, s4, o35, p16, v27, b28, h0Var);
    }

    public static final s h(app.dogo.com.dogo_android.i.h0 h0) {
        return h0.d;
    }

    public static final b2 i(app.dogo.com.dogo_android.i.h0 h0) {
        return h0.h;
    }

    public static final v2 j(app.dogo.com.dogo_android.i.h0 h0) {
        return h0.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.b.c();
    }

    public final v<Boolean> l() {
        return this.j;
    }

    public final Map<String, String> m() {
        kotlin.o[] arr = new o[4];
        return j0.k(u.a("Firebase user ID", this.a.v()), u.a("User location", this.b.v()), u.a("Current dog ID", this.f.H().f()), u.a("Dogs IDs", p.h0(this.f.H().m().keySet(), 0, 0, 0, 0, 0, 0, 63, 0)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n() {
        return this.c.e();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        return this.c.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.c.b();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.c.c();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        this.d.d();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(long l, String string2) {
        n.f(obj12, "style");
        super(l, obj5, this, obj12, 0);
        k.d(f0.a(this), this.i, 0, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(String string) {
        o3 o3Var;
        q3 firstAppOpenSource;
        if (string != null) {
            this.e.q(q3.FirstAppOpenSource, string);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        e1 e1Var;
        if (this.c.e()) {
            this.c.g();
        } else {
            this.c.f();
        }
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        e1 e1Var = this.c;
        e1Var.h(z ^= 1);
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        e1 e1Var = this.c;
        e1Var.i(z ^= 1);
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        e1 e1Var = this.c;
        e1Var.j(z ^= 1);
        this.j.postValue(Boolean.TRUE);
    }
}
