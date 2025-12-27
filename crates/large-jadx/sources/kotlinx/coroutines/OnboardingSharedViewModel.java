package app.dogo.com.dogo_android.welcome_v2;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.k;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.s.a.b2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x1;
import com.google.firebase.auth.AuthResult;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: OnboardingSharedViewModel.kt */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+J\u000e\u0010)\u001a\u00020\"2\u0006\u0010,\u001a\u00020$J\u001e\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u00100\u001a\u00020\u0018R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00150\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "_anonymousLoginForDeeplink", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "_discountOpen", "", "anonymousLoginForDeeplink", "Landroidx/lifecycle/LiveData;", "getAnonymousLoginForDeeplink", "()Landroidx/lifecycle/LiveData;", "discountOpen", "getDiscountOpen", "isLoggedIn", "()Z", "fetchDiscountData", "", "coupon", "", "linkType", "partner", "isConnectedToInternet", "loginAsAnonymous", "saveCodeAndStay", "deepLink", "Landroid/net/Uri;", "couponCode", "saveDiscountName", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "socialTabDisabled", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p0, reason: from kotlin metadata */
public final class OnboardingSharedViewModel extends s {

    private final h2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 authService;
    /* renamed from: c, reason: from kotlin metadata */
    private final BillingRepository billingRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final j2 connectivityService;
    /* renamed from: e, reason: from kotlin metadata */
    private final p2 couponNotificationInteractor;
    private final r2 f;
    private final b2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final f.d.a.a<y<k>> remoteConfigService = new a<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final LiveData<y<k>> sharedPreferenceService = new a<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final f.d.a.a<y<Boolean>> tracker = new a<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final LiveData<y<Boolean>> userRepository = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            p0.this.tracker.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.l<w, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(w wVar) {
            p0.this.tracker.postValue(new LoadResult_Success(Boolean.TRUE));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            p0.this.tracker.postValue(new LoadResult_Error(th));
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<w, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(w wVar) {
            p0.this.tracker.postValue(new LoadResult_Success(Boolean.TRUE));
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            p0.this.remoteConfigService.postValue(new LoadResult_Error(th));
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.l<AuthResult, w> {

        final /* synthetic */ k $linkType;
        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            p0.this.remoteConfigService.postValue(new LoadResult_Success(this.$linkType));
        }

        f(k kVar) {
            this.$linkType = kVar;
            super(1);
        }
    }
    public p0(h2 h2Var, o3 o3Var, BillingRepository billingRepository, j2 j2Var, p2 p2Var, r2 r2Var, b2 b2Var, p1 p1Var) {
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(billingRepository, "billingRepository");
        n.f(j2Var, "connectivityService");
        n.f(p2Var, "sharedPreferenceService");
        n.f(r2Var, "remoteConfigService");
        n.f(b2Var, "couponNotificationInteractor");
        n.f(p1Var, "userRepository");
        super();
        this.a = h2Var;
        this.authService = o3Var;
        this.billingRepository = billingRepository;
        this.connectivityService = j2Var;
        this.couponNotificationInteractor = p2Var;
        this.f = r2Var;
        this.g = b2Var;
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ f.d.a.a fetchDiscountData(p0 coupon) {
        return coupon.remoteConfigService;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ f.d.a.a loginAsAnonymous(p0 linkType) {
        return linkType.tracker;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void saveCodeAndStay(String deepLink) {
        this.tracker.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.billingRepository.validateAndSaveDiscount(deepLink).map(new kotlinx.coroutines.r(this)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "billingRepository.validateAndSaveDiscount(coupon).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.p0.c(this), new kotlinx.coroutines.p0.d(this)));
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final void fetchDiscountData(String linkType, String partner) {
        this.tracker.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = w(linkType, partner).map(new kotlinx.coroutines.s(this)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "saveDiscountName(linkType, partner).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.p0.a(this), new kotlinx.coroutines.p0.b(this)));
    }

    /* renamed from: l, reason: from kotlin metadata */
    private static final w saveDiscountName(p0 linkType, CouponDiscount partner) {
        n.f(linkType, "this$0");
        n.f(partner, "it");
        linkType.g.c(partner);
        return w.a;
    }

    private static final w m(p0 p0Var, CouponDiscount couponDiscount) {
        n.f(p0Var, "this$0");
        n.f(couponDiscount, "it");
        p0Var.g.c(couponDiscount);
        return w.a;
    }

    private final i.b.a0<CouponDiscount> w(String str, String str2) {
        return this.billingRepository.validateAndSaveDiscountPromoCode(str, str2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: n, reason: from kotlin metadata */
    public final LiveData<y<k>> isConnectedToInternet() {
        return this.sharedPreferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Boolean>> o() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.connectivityService.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return !l.z(this.a.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: t, reason: from kotlin metadata */
    public final void saveCodeAndStay(k couponCode) {
        n.f(couponCode, "linkType");
        this.remoteConfigService.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.a.c(false).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "authService.anonymousSignInSingle(false)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new kotlinx.coroutines.p0.e(this), new kotlinx.coroutines.p0.f(this, couponCode)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(Uri uri) {
        n.f(uri, "deepLink");
        String queryParameter = uri.getQueryParameter("linkType");
        if (queryParameter == null) {
            return;
        }
        String queryParameter2 = uri.getQueryParameter("partner");
        if (queryParameter2 == null) {
            return;
        }
        this.authService.d(E_General.c.c(new EP_Link(), uri.toString()));
        this.couponNotificationInteractor.t0(queryParameter2);
        fetchDiscountData(queryParameter, queryParameter2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String str) {
        n.f(str, "couponCode");
        this.authService.d(E_General.c.c(new EP_Link(), str));
        saveCodeAndStay(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        return this.f.e0(this.couponNotificationInteractor.W());
    }

    public static /* synthetic */ w r(p0 p0Var, CouponDiscount couponDiscount) {
        return OnboardingSharedViewModel.m(p0Var, couponDiscount);
    }

    public static /* synthetic */ w s(p0 p0Var, CouponDiscount couponDiscount) {
        return OnboardingSharedViewModel.saveDiscountName(p0Var, couponDiscount);
    }
}
