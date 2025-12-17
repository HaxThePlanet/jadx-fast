package app.dogo.com.dogo_android.s.a;

import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.s.b.e1;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.externalmodel.model.responses.UserApiModel;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import i.b.a0;
import i.b.b;
import i.b.c0;
import i.b.f;
import i.b.g0;
import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "(Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;)V", "restorePurchase", "Lio/reactivex/Single;", "", "revenueCatShowResubscribe", "revenueCatSubscribed", "revenueCatUserPremiumAndWillRenew", "updatePremiumUserProperties", "", "isUserPremium", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n3 {

    private final e1 a;
    private final Purchases b;
    private final o3 c;
    private final BillingRepository d;
    private final DogoApiClient e;
    private final u2 f;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<PurchasesError, w> {

        final c0<Boolean> $emitter;
        a(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchasesError)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            Throwable throwable = new Throwable(purchasesError.getMessage());
            this.$emitter.onError(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<PurchaserInfo, w> {

        final c0<Boolean> $emitter;
        final app.dogo.com.dogo_android.s.a.n3 this$0;
        b(app.dogo.com.dogo_android.s.a.n3 n3, c0<Boolean> c02) {
            this.this$0 = n3;
            this.$emitter = c02;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchaserInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            boolean z;
            long time;
            n.f(purchaserInfo, "purchaserInfo");
            if (j1.O(purchaserInfo)) {
                Date latestExpirationDate = purchaserInfo.getLatestExpirationDate();
                if (latestExpirationDate == null) {
                    time = 0;
                } else {
                    time = latestExpirationDate.getTime();
                }
                n3.a(this.this$0).handleRestorePurchase(time);
            }
            this.$emitter.onSuccess(Boolean.valueOf(j1.O(purchaserInfo)));
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<PurchasesError, w> {

        final c0<Boolean> $emitter;
        c(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchasesError)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            a.c(String.valueOf(purchasesError), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<PurchaserInfo, w> {

        final c0<Boolean> $emitter;
        d(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchaserInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            Object obj3;
            n.f(purchaserInfo, "purchaserInfo");
            if (j1.O(purchaserInfo) && j1.X0(purchaserInfo)) {
                obj3 = j1.X0(purchaserInfo) ? 1 : 0;
            } else {
            }
            this.$emitter.onSuccess(Boolean.valueOf(obj3));
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<PurchasesError, w> {

        final c0<Boolean> $emitter;
        e(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchasesError)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            a.c(String.valueOf(purchasesError), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<PurchaserInfo, w> {

        final c0<Boolean> $emitter;
        f(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchaserInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            Boolean fALSE;
            c0 obj2;
            n.f(purchaserInfo, "purchaserInfo");
            if (j1.O(purchaserInfo)) {
                this.$emitter.onSuccess(Boolean.TRUE);
            } else {
                this.$emitter.onSuccess(Boolean.FALSE);
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<PurchasesError, w> {

        final c0<Boolean> $emitter;
        g(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchasesError)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            a.c(String.valueOf(purchasesError), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements l<PurchaserInfo, w> {

        final c0<Boolean> $emitter;
        h(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchaserInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            Boolean fALSE;
            Object obj2;
            n.f(purchaserInfo, "purchaserInfo");
            if (j1.O(purchaserInfo) && j1.Z0(purchaserInfo)) {
                if (j1.Z0(purchaserInfo)) {
                    this.$emitter.onSuccess(Boolean.TRUE);
                } else {
                    this.$emitter.onSuccess(Boolean.FALSE);
                }
            } else {
            }
        }
    }
    public n3(e1 e1, Purchases purchases2, o3 o33, BillingRepository billingRepository4, DogoApiClient dogoApiClient5, u2 u26) {
        n.f(e1, "debugRepository");
        n.f(purchases2, "purchases");
        n.f(o33, "tracker");
        n.f(billingRepository4, "billingRepository");
        n.f(dogoApiClient5, "dogoApiClient");
        n.f(u26, "userLocalCacheService");
        super();
        this.a = e1;
        this.b = purchases2;
        this.c = o33;
        this.d = billingRepository4;
        this.e = dogoApiClient5;
        this.f = u26;
    }

    public static final BillingRepository a(app.dogo.com.dogo_android.s.a.n3 n3) {
        return n3.d;
    }

    public static Boolean b(app.dogo.com.dogo_android.s.a.n3 n3, Boolean boolean2) {
        n3.s(n3, boolean2);
        return boolean2;
    }

    public static void c(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n3.u(n3, c02);
    }

    public static g0 d(app.dogo.com.dogo_android.s.a.n3 n3, Boolean boolean2) {
        return n3.l(n3, boolean2);
    }

    public static Boolean e(Boolean boolean) {
        n3.n(boolean);
        return boolean;
    }

    public static void f(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n3.p(n3, c02);
    }

    public static void g(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n3.k(n3, c02);
    }

    public static void h(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n3.r(n3, c02);
    }

    public static f i(app.dogo.com.dogo_android.s.a.n3 n3, UserApiModel userApiModel2) {
        return n3.m(n3, userApiModel2);
    }

    private static final void k(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n.f(n3, "this$0");
        n.f(c02, "emitter");
        n3.a aVar = new n3.a(c02);
        n3.b bVar = new n3.b(n3, c02);
        ListenerConversionsKt.restorePurchasesWith(n3.b, aVar, bVar);
    }

    private static final g0 l(app.dogo.com.dogo_android.s.a.n3 n3, Boolean boolean2) {
        app.dogo.com.dogo_android.s.a.u0 booleanValue;
        app.dogo.com.dogo_android.s.a.y0 y0Var;
        a0 obj2;
        n.f(n3, "this$0");
        n.f(boolean2, "isRestored");
        if (boolean2.booleanValue()) {
            y0Var = new y0(n3);
            booleanValue = new u0(boolean2);
            obj2 = n3.e.restoreUserPurchases().flatMapCompletable(y0Var).B(booleanValue);
        } else {
            obj2 = a0.just(boolean2);
        }
        return obj2;
    }

    private static final f m(app.dogo.com.dogo_android.s.a.n3 n3, UserApiModel userApiModel2) {
        n.f(n3, "this$0");
        n.f(userApiModel2, "it");
        int i = 0;
        return u2.c0(n3.f, userApiModel2, i, 2, i);
    }

    private static final Boolean n(Boolean boolean) {
        n.f(boolean, "$isRestored");
        return boolean;
    }

    private static final void p(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n.f(n3, "this$0");
        n.f(c02, "emitter");
        n3.c cVar = new n3.c(c02);
        n3.d dVar = new n3.d(c02);
        ListenerConversionsKt.getPurchaserInfoWith(n3.b, cVar, dVar);
    }

    private static final void r(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n.f(n3, "this$0");
        n.f(c02, "emitter");
        n3.e eVar = new n3.e(c02);
        n3.f fVar = new n3.f(c02);
        ListenerConversionsKt.getPurchaserInfoWith(n3.b, eVar, fVar);
    }

    private static final Boolean s(app.dogo.com.dogo_android.s.a.n3 n3, Boolean boolean2) {
        n.f(n3, "this$0");
        n.f(boolean2, "it");
        n3.v(boolean2.booleanValue());
        return boolean2;
    }

    private static final void u(app.dogo.com.dogo_android.s.a.n3 n3, c0 c02) {
        n.f(n3, "this$0");
        n.f(c02, "emitter");
        n3.g gVar = new n3.g(c02);
        n3.h hVar = new n3.h(c02);
        ListenerConversionsKt.getPurchaserInfoWith(n3.b, gVar, hVar);
    }

    private final void v(boolean z) {
        String obj3;
        obj3 = z ? "premium" : 0;
        this.c.q(q3.Entitlements, obj3);
    }

    public final a0<Boolean> j() {
        w0 w0Var = new w0(this);
        t0 t0Var = new t0(this);
        a0 flatMap = a0.create(w0Var).flatMap(t0Var);
        n.e(flatMap, "create { emitter: SingleEmitter<Boolean> ->\n            purchases.restorePurchasesWith(\n                onError = { error ->\n                    emitter.onError(Throwable(error.message))\n                },\n                onSuccess = { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive()) {\n                        billingRepository.handleRestorePurchase(purchaserInfo.latestExpirationDate?.time ?: 0)\n                    }\n                    emitter.onSuccess(purchaserInfo.isPremiumActive())\n                }\n            )\n        }.flatMap { isRestored ->\n            if (isRestored) {\n                dogoApiClient.restoreUserPurchases().flatMapCompletable {\n                    userLocalCacheService.updateLocalUserData(it)\n                }.toSingle { isRestored }\n            } else {\n                Single.just(isRestored)\n            }\n        }");
        return flatMap;
    }

    public final a0<Boolean> o() {
        a0 create;
        String str;
        if (this.a.c()) {
            n.e(a0.just(Boolean.TRUE), "{\n            Single.just(true)\n        }");
        } else {
            v0 v0Var = new v0(this);
            n.e(a0.create(v0Var), "{\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    emitter.onSuccess(purchaserInfo.isPremiumActive() && purchaserInfo.userCancelledSubscription())\n                }\n            }\n        }");
        }
        return create;
    }

    public final a0<Boolean> q() {
        a0 create;
        if (this.a.b()) {
            create = a0.just(Boolean.TRUE);
        } else {
            x0 x0Var = new x0(this);
            create = a0.create(x0Var);
        }
        r0 r0Var = new r0(this);
        a0 a0Var = create.map(r0Var);
        n.e(a0Var, "if (debugRepository.forceUserPremium) {\n            Single.just(true)\n        } else {\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive()) {\n                        emitter.onSuccess(true)\n                    } else {\n                        emitter.onSuccess(false)\n                    }\n                }\n            }\n        }.map {\n            updatePremiumUserProperties(it)\n            it\n        }");
        return a0Var;
    }

    public final a0<Boolean> t() {
        a0 create;
        String str;
        if (this.a.b()) {
            n.e(a0.just(Boolean.TRUE), "{\n            Single.just(true)\n        }");
        } else {
            s0 s0Var = new s0(this);
            n.e(a0.create(s0Var), "{\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive() && purchaserInfo.userWillRenewSubscription()) {\n                        emitter.onSuccess(true)\n                    } else {\n                        emitter.onSuccess(false)\n                    }\n                }\n            }\n        }");
        }
        return create;
    }
}
