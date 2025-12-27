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
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DebugDataFragmentViewModel.kt */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0016\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0010\u0010.\u001a\u00020(2\u0008\u0010/\u001a\u0004\u0018\u00010\u0016J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020(J\u0006\u00102\u001a\u00020(J\u0006\u00103\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001a0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "couponEntityDao", "Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lapp/dogo/android/persistencedb/room/dao/CouponEntityDao;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "currentDogId", "", "getCurrentDogId", "()Ljava/lang/String;", "isAmbassador", "", "()Z", "isForcedUserDogPremium", "isForcedUserPremium", "isForcedUserResubscribe", "listRefreshNotifier", "Landroidx/lifecycle/MediatorLiveData;", "getListRefreshNotifier", "()Landroidx/lifecycle/MediatorLiveData;", "userInfoMap", "", "getUserInfoMap", "()Ljava/util/Map;", "clearDebugOverrides", "", "resetCouponsInRoom", "saveCoupon", "durationMs", "", "style", "setFirstOpen", "source", "toggleAmbassador", "toggleUserDogPremium", "toggleUserPremium", "toggleUserResubscribe", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h0, reason: from kotlin metadata */
public final class DebugDataFragmentViewModel extends app.dogo.com.dogo_android.util.e0.s {

    /* renamed from: a, reason: from kotlin metadata */
    private final h2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 couponEntityDao;
    /* renamed from: c, reason: from kotlin metadata */
    private final e1 couponNotificationInteractor;
    private final e.a.a.a.b.b.s d;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 debugRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final p1 dispatcher;
    private final v2 g;
    private final b2 h;
    private final h0 i;
    private final v<Boolean> j;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.debug.DebugDataFragmentViewModel$saveCoupon$1", f = "DebugDataFragmentViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ long $durationMs;
        final /* synthetic */ String $style;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                CouponEntity object2 = new CouponEntity("test_coupon", 1L, str3, "default", this.$durationMs, str5, h0.this.g.g(), map, this.$style, 0, 0, 0);
                CouponEntity[] arr = new CouponEntity[1];
                h0.this.d.isCouponUsed(object2).e();
                h0.this.h.c(app.dogo.com.dogo_android.util.extensionfunction.m1.o(object2));
                return w.a;
            }
        }

        a(long j, h0 h0Var, String str, d<? super h0.a> dVar) {
            this.$durationMs = j;
            this.$style = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.debug.h0.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            app.dogo.com.dogo_android.debug.h0.a object2 = new app.dogo.com.dogo_android.debug.h0.a(this.$durationMs, h0Var, h0.this, this.$style, dVar);
            return object2;
        }
    }
    public /* synthetic */ h0(h2 h2Var, r2 r2Var, e1 e1Var, e.a.a.a.b.b.s sVar, o3 o3Var, p1 p1Var, v2 v2Var, b2 b2Var, h0 h0Var, int i, g gVar) {
        h0 h0Var92;
        h0Var92 = i & 256 != 0 ? h0Var92 : h0Var;
        this(h2Var, r2Var, e1Var, sVar, o3Var, p1Var, v2Var, b2Var, h0Var92);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ e.a.a.a.b.b.s setFirstOpen(h0 source) {
        return source.d;
    }

    public static final /* synthetic */ b2 i(h0 h0Var) {
        return h0Var.h;
    }

    public static final /* synthetic */ v2 j(h0 h0Var) {
        return h0Var.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final void clearDebugOverrides() {
        this.couponEntityDao.c();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final v<Boolean> l() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Map<String, String> m() {
        kotlin.o[] arr = new o[4];
        return j0.k(new o[] { u.a("Firebase user ID", this.authService.v()), u.a("User location", this.couponEntityDao.v()), u.a("Current dog ID", this.dispatcher.H().f()), u.a("Dogs IDs", p.h0(this.dispatcher.H().m().keySet(), null, null, null, 0, null, null, 63, null)) });
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean n() {
        return this.couponNotificationInteractor.e();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        return this.couponNotificationInteractor.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.couponNotificationInteractor.b();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.couponNotificationInteractor.c();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        this.d.d();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: s, reason: from kotlin metadata */
    public final void saveCoupon(long durationMs, String style) {
        n.f(style, "style");
        app.dogo.com.dogo_android.debug.h0.a aVar = new app.dogo.com.dogo_android.debug.h0.a(durationMs, h0Var2, this, style, 0);
        kotlinx.coroutines.internal.k.d(f0.a(this), this.i, null, aVar, 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(String str) {
        if (str != null) {
            this.debugRepository.setUserProperty(UserProperty.FirstAppOpenSource, str);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        if (this.couponNotificationInteractor.e()) {
            this.couponNotificationInteractor.g();
        } else {
            this.couponNotificationInteractor.f();
        }
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.couponNotificationInteractor.h(!this.couponNotificationInteractor.a());
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.couponNotificationInteractor.i(!this.couponNotificationInteractor.b());
        this.j.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.couponNotificationInteractor.j(!this.couponNotificationInteractor.c());
        this.j.postValue(Boolean.TRUE);
    }

    public h0(h2 h2Var, r2 r2Var, e1 e1Var, e.a.a.a.b.b.s sVar, o3 o3Var, p1 p1Var, v2 v2Var, b2 b2Var, h0 h0Var) {
        n.f(h2Var, "authService");
        n.f(r2Var, "remoteConfigService");
        n.f(e1Var, "debugRepository");
        n.f(sVar, "couponEntityDao");
        n.f(o3Var, "tracker");
        n.f(p1Var, "userRepository");
        n.f(v2Var, "timeUtils");
        n.f(b2Var, "couponNotificationInteractor");
        n.f(h0Var, "dispatcher");
        super();
        this.authService = h2Var;
        this.couponEntityDao = r2Var;
        this.couponNotificationInteractor = e1Var;
        this.d = sVar;
        this.debugRepository = o3Var;
        this.dispatcher = p1Var;
        this.g = v2Var;
        this.h = b2Var;
        this.i = h0Var;
        this.j = new v();
    }
}
