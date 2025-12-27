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

/* compiled from: SubscribeInteractor.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "", "debugRepository", "Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "(Lapp/dogo/com/dogo_android/repository/local/DebugRepository;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;)V", "restorePurchase", "Lio/reactivex/Single;", "", "revenueCatShowResubscribe", "revenueCatSubscribed", "revenueCatUserPremiumAndWillRenew", "updatePremiumUserProperties", "", "isUserPremium", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n3, reason: from kotlin metadata */
public final class SubscribeInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final e1 billingRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final Purchases debugRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 dogoApiClient;
    /* renamed from: d, reason: from kotlin metadata */
    private final BillingRepository purchases;
    /* renamed from: e, reason: from kotlin metadata */
    private final DogoApiClient tracker;
    /* renamed from: f, reason: from kotlin metadata */
    private final u2 userLocalCacheService;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<PurchasesError, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError th) {
            n.f(th, "error");
            this.$emitter.onError(new Throwable(th.getMessage()));
        }

        a(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<PurchaserInfo, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            long time = 0;
            n.f(purchaserInfo, "purchaserInfo");
            if (app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo)) {
                Date latestExpirationDate = purchaserInfo.getLatestExpirationDate();
                if (latestExpirationDate == null) {
                    int i = 0;
                } else {
                    time = latestExpirationDate.getTime();
                }
                n3.this.purchases.handleRestorePurchase(time);
            }
            this.$emitter.onSuccess(Boolean.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo)));
        }

        b(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<PurchasesError, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError th) {
            n.f(th, "error");
            a.c(String.valueOf(th), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }

        c(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<PurchaserInfo, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            boolean z3 = false;
            n.f(purchaserInfo, "purchaserInfo");
            purchaserInfo = app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo) && app.dogo.com.dogo_android.util.extensionfunction.j1.X0(purchaserInfo) ? 1 : 0;
            this.$emitter.onSuccess((app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo) && app.dogo.com.dogo_android.util.extensionfunction.j1.X0(purchaserInfo) ? 1 : 0));
        }

        d(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<PurchasesError, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError th) {
            n.f(th, "error");
            a.c(String.valueOf(th), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }

        e(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<PurchaserInfo, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            n.f(purchaserInfo, "purchaserInfo");
            if (app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo)) {
                this.$emitter.onSuccess(Boolean.TRUE);
            } else {
                this.$emitter.onSuccess(Boolean.FALSE);
            }
        }

        f(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<PurchasesError, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError th) {
            n.f(th, "error");
            a.c(String.valueOf(th), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }

        g(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements l<PurchaserInfo, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            n.f(purchaserInfo, "purchaserInfo");
            if (!app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo) || !app.dogo.com.dogo_android.util.extensionfunction.j1.Z0(purchaserInfo)) {
                this.$emitter.onSuccess(Boolean.FALSE);
            } else {
                this.$emitter.onSuccess(Boolean.TRUE);
            }
        }

        h(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }
    public n3(e1 e1Var, Purchases purchases, o3 o3Var, BillingRepository billingRepository, DogoApiClient dogoApiClient, u2 u2Var) {
        n.f(e1Var, "debugRepository");
        n.f(purchases, "purchases");
        n.f(o3Var, "tracker");
        n.f(billingRepository, "billingRepository");
        n.f(dogoApiClient, "dogoApiClient");
        n.f(u2Var, "userLocalCacheService");
        super();
        this.billingRepository = e1Var;
        this.debugRepository = purchases;
        this.dogoApiClient = o3Var;
        this.purchases = billingRepository;
        this.tracker = dogoApiClient;
        this.userLocalCacheService = u2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ BillingRepository updatePremiumUserProperties(n3 isUserPremium) {
        return isUserPremium.purchases;
    }

    private static final void k(n3 n3Var, c0 c0Var) {
        n.f(n3Var, "this$0");
        n.f(c0Var, "emitter");
        ListenerConversionsKt.restorePurchasesWith(n3Var.debugRepository, new kotlinx.coroutines.n3.a(c0Var), new kotlinx.coroutines.n3.b(n3Var, c0Var));
    }

    private static final g0 l(n3 n3Var, Boolean boolean) {
        a0 just;
        n.f(n3Var, "this$0");
        n.f(boolean, "isRestored");
        if (boolean.booleanValue()) {
            just = n3Var.tracker.restoreUserPurchases().flatMapCompletable(new kotlinx.coroutines.y0(n3Var)).B(new kotlinx.coroutines.u0(boolean));
        } else {
            just = a0.just(boolean);
        }
        return just;
    }

    private static final f m(n3 n3Var, UserApiModel userApiModel) {
        n.f(n3Var, "this$0");
        n.f(userApiModel, "it");
        String str3 = null;
        return UserLocalCacheService.c0(n3Var.userLocalCacheService, userApiModel, str3, 2, str3);
    }

    private static final void p(n3 n3Var, c0 c0Var) {
        n.f(n3Var, "this$0");
        n.f(c0Var, "emitter");
        ListenerConversionsKt.getPurchaserInfoWith(n3Var.debugRepository, new kotlinx.coroutines.n3.c(c0Var), new kotlinx.coroutines.n3.d(c0Var));
    }

    private static final void r(n3 n3Var, c0 c0Var) {
        n.f(n3Var, "this$0");
        n.f(c0Var, "emitter");
        ListenerConversionsKt.getPurchaserInfoWith(n3Var.debugRepository, new kotlinx.coroutines.n3.e(c0Var), new kotlinx.coroutines.n3.f(c0Var));
    }

    private static final Boolean s(n3 n3Var, Boolean boolean) {
        n.f(n3Var, "this$0");
        n.f(boolean, "it");
        n3Var.v(boolean.booleanValue());
        return boolean;
    }

    private static final void u(n3 n3Var, c0 c0Var) {
        n.f(n3Var, "this$0");
        n.f(c0Var, "emitter");
        ListenerConversionsKt.getPurchaserInfoWith(n3Var.debugRepository, new kotlinx.coroutines.n3.g(c0Var), new kotlinx.coroutines.n3.h(c0Var));
    }

    private final void v(boolean z) {
        String str = null;
        z = z ? "premium" : 0;
        this.dogoApiClient.setUserProperty(UserProperty.Entitlements, (z ? "premium" : 0));
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final a0<Boolean> restorePurchase() {
        a0 flatMapped = a0.create(new kotlinx.coroutines.w0(this)).flatMap(new kotlinx.coroutines.t0(this));
        n.e(flatMapped, "create { emitter: SingleEmitter<Boolean> ->\n            purchases.restorePurchasesWith(\n                onError = { error ->\n                    emitter.onError(Throwable(error.message))\n                },\n                onSuccess = { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive()) {\n                        billingRepository.handleRestorePurchase(purchaserInfo.latestExpirationDate?.time ?: 0)\n                    }\n                    emitter.onSuccess(purchaserInfo.isPremiumActive())\n                }\n            )\n        }.flatMap { isRestored ->\n            if (isRestored) {\n                dogoApiClient.restoreUserPurchases().flatMapCompletable {\n                    userLocalCacheService.updateLocalUserData(it)\n                }.toSingle { isRestored }\n            } else {\n                Single.just(isRestored)\n            }\n        }");
        return flatMapped;
    }

    public final a0<Boolean> o() {
        a0 a0Var;
        if (this.billingRepository.c()) {
            str = "{\n            Single.just(true)\n        }";
            n.e(a0.just(Boolean.TRUE), str);
        } else {
            str = "{\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    emitter.onSuccess(purchaserInfo.isPremiumActive() && purchaserInfo.userCancelledSubscription())\n                }\n            }\n        }";
            n.e(a0.create(new kotlinx.coroutines.v0(this)), str);
        }
        return a0Var;
    }

    public final a0<Boolean> q() {
        a0 a0Var;
        if (this.billingRepository.b()) {
            a0Var = a0.just(Boolean.TRUE);
        } else {
            a0Var = a0.create(new kotlinx.coroutines.x0(this));
        }
        a0 map = a0Var.map(new kotlinx.coroutines.r0(this));
        n.e(map, "if (debugRepository.forceUserPremium) {\n            Single.just(true)\n        } else {\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive()) {\n                        emitter.onSuccess(true)\n                    } else {\n                        emitter.onSuccess(false)\n                    }\n                }\n            }\n        }.map {\n            updatePremiumUserProperties(it)\n            it\n        }");
        return map;
    }

    public final a0<Boolean> t() {
        a0 a0Var;
        if (this.billingRepository.b()) {
            str = "{\n            Single.just(true)\n        }";
            n.e(a0.just(Boolean.TRUE), str);
        } else {
            str = "{\n            Single.create { emitter: SingleEmitter<Boolean> ->\n                purchases.getPurchaserInfoWith({ error ->\n                    Timber.e(\"$error\")\n                    emitter.onSuccess(false)\n                }) { purchaserInfo ->\n                    if (purchaserInfo.isPremiumActive() && purchaserInfo.userWillRenewSubscription()) {\n                        emitter.onSuccess(true)\n                    } else {\n                        emitter.onSuccess(false)\n                    }\n                }\n            }\n        }";
            n.e(a0.create(new kotlinx.coroutines.s0(this)), str);
        }
        return a0Var;
    }

    public static /* synthetic */ Boolean b(n3 n3Var, Boolean boolean) {
        SubscribeInteractor.s(n3Var, boolean);
        return boolean;
    }

    public static /* synthetic */ void c(n3 n3Var, c0 c0Var) {
        SubscribeInteractor.u(n3Var, c0Var);
    }

    public static /* synthetic */ g0 d(n3 n3Var, Boolean boolean) {
        return SubscribeInteractor.l(n3Var, boolean);
    }

    public static /* synthetic */ Boolean e(Boolean boolean) {
        SubscribeInteractor.n(boolean);
        return boolean;
    }

    public static /* synthetic */ void f(n3 n3Var, c0 c0Var) {
        SubscribeInteractor.p(n3Var, c0Var);
    }

    public static /* synthetic */ void g(n3 n3Var, c0 c0Var) {
        SubscribeInteractor.k(n3Var, c0Var);
    }

    public static /* synthetic */ void h(n3 n3Var, c0 c0Var) {
        SubscribeInteractor.r(n3Var, c0Var);
    }

    public static /* synthetic */ f i(n3 n3Var, UserApiModel userApiModel) {
        return SubscribeInteractor.m(n3Var, userApiModel);
    }

    private static final Boolean n(Boolean boolean) {
        n.f(boolean, "$isRestored");
        return boolean;
    }
}
