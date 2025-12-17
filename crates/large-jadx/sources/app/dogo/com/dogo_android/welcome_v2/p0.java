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
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x1;
import com.google.firebase.auth.AuthResult;
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+J\u000e\u0010)\u001a\u00020\"2\u0006\u0010,\u001a\u00020$J\u001e\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u00100\u001a\u00020\u0018R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00150\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "_anonymousLoginForDeeplink", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "_discountOpen", "", "anonymousLoginForDeeplink", "Landroidx/lifecycle/LiveData;", "getAnonymousLoginForDeeplink", "()Landroidx/lifecycle/LiveData;", "discountOpen", "getDiscountOpen", "isLoggedIn", "()Z", "fetchDiscountData", "", "coupon", "", "linkType", "partner", "isConnectedToInternet", "loginAsAnonymous", "saveCodeAndStay", "deepLink", "Landroid/net/Uri;", "couponCode", "saveDiscountName", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "socialTabDisabled", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p0 extends s {

    private final h2 a;
    private final o3 b;
    private final BillingRepository c;
    private final j2 d;
    private final p2 e;
    private final r2 f;
    private final b2 g;
    private final a<y<k>> h;
    private final LiveData<y<k>> i;
    private final a<y<Boolean>> j;
    private final LiveData<y<Boolean>> k;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        a(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
            this.this$0 = p0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar2 = new y.a(throwable);
            p0.i(this.this$0).postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<w, w> {

        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        b(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
            this.this$0 = p0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((w)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(w w) {
            y.c cVar = new y.c(Boolean.TRUE);
            p0.i(this.this$0).postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        c(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
            this.this$0 = p0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar2 = new y.a(throwable);
            p0.i(this.this$0).postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<w, w> {

        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        d(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
            this.this$0 = p0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((w)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(w w) {
            y.c cVar = new y.c(Boolean.TRUE);
            p0.i(this.this$0).postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        e(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
            this.this$0 = p0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar2 = new y.a(throwable);
            p0.h(this.this$0).postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<AuthResult, w> {

        final k $linkType;
        final app.dogo.com.dogo_android.welcome_v2.p0 this$0;
        f(app.dogo.com.dogo_android.welcome_v2.p0 p0, k k2) {
            this.this$0 = p0;
            this.$linkType = k2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            y.c cVar = new y.c(this.$linkType);
            p0.h(this.this$0).postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((AuthResult)object);
            return w.a;
        }
    }
    public p0(h2 h2, o3 o32, BillingRepository billingRepository3, j2 j24, p2 p25, r2 r26, b2 b27, p1 p18) {
        n.f(h2, "authService");
        n.f(o32, "tracker");
        n.f(billingRepository3, "billingRepository");
        n.f(j24, "connectivityService");
        n.f(p25, "sharedPreferenceService");
        n.f(r26, "remoteConfigService");
        n.f(b27, "couponNotificationInteractor");
        n.f(p18, "userRepository");
        super();
        this.a = h2;
        this.b = o32;
        this.c = billingRepository3;
        this.d = j24;
        this.e = p25;
        this.f = r26;
        this.g = b27;
        a obj2 = new a();
        this.h = obj2;
        this.i = obj2;
        obj2 = new a();
        this.j = obj2;
        this.k = obj2;
    }

    public static final a h(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
        return p0.h;
    }

    public static final a i(app.dogo.com.dogo_android.welcome_v2.p0 p0) {
        return p0.j;
    }

    private final void j(String string) {
        this.j.postValue(y.b.a);
        r rVar = new r(this);
        a0 obj4 = this.c.validateAndSaveDiscount(string).map(rVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj4, "billingRepository.validateAndSaveDiscount(coupon).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        p0.c cVar = new p0.c(this);
        p0.d dVar = new p0.d(this);
        getDisposable().b(a.g(obj4, cVar, dVar));
    }

    private final void k(String string, String string2) {
        this.j.postValue(y.b.a);
        s obj4 = new s(this);
        a0 obj3 = w(string, string2).map(obj4).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj3, "saveDiscountName(linkType, partner).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        obj4 = new p0.a(this);
        p0.b bVar2 = new p0.b(this);
        getDisposable().b(a.g(obj3, obj4, bVar2));
    }

    private static final w l(app.dogo.com.dogo_android.welcome_v2.p0 p0, CouponDiscount couponDiscount2) {
        n.f(p0, "this$0");
        n.f(couponDiscount2, "it");
        p0.g.c(couponDiscount2);
        return w.a;
    }

    private static final w m(app.dogo.com.dogo_android.welcome_v2.p0 p0, CouponDiscount couponDiscount2) {
        n.f(p0, "this$0");
        n.f(couponDiscount2, "it");
        p0.g.c(couponDiscount2);
        return w.a;
    }

    public static w r(app.dogo.com.dogo_android.welcome_v2.p0 p0, CouponDiscount couponDiscount2) {
        return p0.m(p0, couponDiscount2);
    }

    public static w s(app.dogo.com.dogo_android.welcome_v2.p0 p0, CouponDiscount couponDiscount2) {
        return p0.l(p0, couponDiscount2);
    }

    private final a0<CouponDiscount> w(String string, String string2) {
        return this.c.validateAndSaveDiscountPromoCode(string, string2);
    }

    public final LiveData<y<k>> n() {
        return this.i;
    }

    public final LiveData<y<Boolean>> o() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        return this.d.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return z ^= 1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(k k) {
        n.f(k, "linkType");
        this.h.postValue(y.b.a);
        a0 subscribeOn = this.a.c(false).observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "authService.anonymousSignInSingle(false)\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        p0.e eVar = new p0.e(this);
        p0.f fVar = new p0.f(this, k);
        getDisposable().b(a.g(subscribeOn, eVar, fVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(Uri uri) {
        n.f(uri, "deepLink");
        String queryParameter = uri.getQueryParameter("linkType");
        if (queryParameter == null) {
        }
        String queryParameter2 = uri.getQueryParameter("partner");
        if (queryParameter2 == null) {
        }
        x1 x1Var = new x1();
        this.b.d(a0.c.c(x1Var, uri.toString()));
        this.e.t0(queryParameter2);
        k(queryParameter, queryParameter2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String string) {
        n.f(string, "couponCode");
        x1 x1Var = new x1();
        this.b.d(a0.c.c(x1Var, string));
        j(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean x() {
        return this.f.e0(this.e.W());
    }
}
