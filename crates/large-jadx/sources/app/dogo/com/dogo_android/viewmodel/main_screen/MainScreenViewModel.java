package app.dogo.com.dogo_android.a0.g;

import android.net.Uri;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.s.a.a3;
import app.dogo.com.dogo_android.s.a.b2;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyPremium;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.x1;
import i.b.g0;
import i.b.r;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import org.json.JSONException;
import org.json.JSONObject;
import zendesk.support.Support;

/* compiled from: MainScreenViewModel.kt */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0018\u0000 N2\u00020\u0001:\u0001NB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020+2\u0008\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020!H\u0002J\u0018\u0010=\u001a\u0002072\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!H\u0002J\u0010\u0010A\u001a\u0004\u0018\u00010<2\u0006\u0010B\u001a\u00020!J\u0006\u0010C\u001a\u00020+J\u0006\u0010D\u001a\u000207J\u0006\u0010E\u001a\u000207J\u0006\u0010F\u001a\u00020+J\u0006\u0010G\u001a\u00020+J\u0006\u0010H\u001a\u00020+J\u0006\u0010I\u001a\u00020+J\u000e\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020<J\u000e\u0010J\u001a\u0002072\u0006\u0010L\u001a\u00020!J\u000e\u0010M\u001a\u0002072\u0006\u0010B\u001a\u00020!R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020+0*0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010(R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0014\u00100\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010/R\u0014\u00101\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00081\u0010/R\u0014\u00102\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00082\u0010/R\u0011\u00103\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\u00083\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010/R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "sharedPreferenceService", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "zendeskSupport", "Lzendesk/support/Support;", "dogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "getSubscriptionOffersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lzendesk/support/Support;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "currentDogId", "", "getCurrentDogId", "()Ljava/lang/String;", "delayedSubscriptionCalls", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getDelayedSubscriptionCalls", "()Lcom/hadilq/liveevent/LiveEvent;", "discountOpen", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getDiscountOpen", "instagramPopUpShowed", "getInstagramPopUpShowed", "()Z", "isInstagramFollowInviteDisabled", "isInstagramFollowed", "isTikTokFollowInviteDisabled", "isTimeToShowInstagramInvite", "tiktokInviteShowed", "getTiktokInviteShowed", "after2SecondOpenSubscriptionScreen", "", "millisecondsDelay", "", "checkImageSize", "imageUri", "Landroid/net/Uri;", "fetchAndSaveDiscountData", "coupon", "linkType", "partner", "getDogAvatar", "dogId", "isMobileInboxEnabled", "setInstagramInviteShowedTime", "setTiktokShowedFlag", "shouldShowInstagramPopup", "shouldShowNewsletter", "shouldShowTiktokPopUp", "socialTabDisabled", "trackAndOpenDiscountDeeplink", "deepLink", "couponCode", "updateCurrentDog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class MainScreenViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final e.a INSTANCE = new e$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final p2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 billingRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.u2 couponNotificationInteractor;
    private final h2 d;
    private final v2 e;
    private final o3 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final t2 dogPremiumInteractor;
    /* renamed from: h, reason: from kotlin metadata */
    private final p2 getSubscriptionOffersInteractor;
    private final BillingRepository i;
    private final b2 j;
    private final Support k;
    private final a3 l;
    private final p1 m;
    /* renamed from: n, reason: from kotlin metadata */
    private final n3 preferenceService;
    /* renamed from: o, reason: from kotlin metadata */
    private final f.d.a.a<SubscriptionOffer> remoteConfigService;
    /* renamed from: p, reason: from kotlin metadata */
    private final f.d.a.a<y<Boolean>> sharedPreferenceService;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel$Companion;", "", "()V", "HOUR_IN_MILLIS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.l<Throwable, w> {

        public static final e.b a = new e$b();
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.d(th);
        }


        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.l<SubscriptionOffer, w> {
        @Override // kotlin.d0.d.p
        public final void a(SubscriptionOffer subscriptionOffer) {
            e.this.r().postValue(subscriptionOffer);
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            e.this.s().postValue(new LoadResult_Error(th));
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.l<w, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(w wVar) {
            e.this.s().postValue(new LoadResult_Success(Boolean.TRUE));
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            e.this.s().postValue(new LoadResult_Error(th));
        }

        f() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements kotlin.d0.c.l<w, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(w wVar) {
            e.this.s().postValue(new LoadResult_Success(Boolean.TRUE));
        }

        g() {
            super(1);
        }
    }
    public e(p2 p2Var, r2 r2Var, app.dogo.com.dogo_android.service.u2 u2Var, h2 h2Var, v2 v2Var, o3 o3Var, t2 t2Var, p2 p2Var2, BillingRepository billingRepository, b2 b2Var, Support support, d3 d3Var, a3 a3Var, p1 p1Var, n3 n3Var) {
        final Object p2Var3 = this;
        Object p2Var22 = p2Var;
        Object r2Var22 = r2Var;
        Object u2Var32 = u2Var;
        final Object h2Var42 = h2Var;
        final Object v2Var52 = v2Var;
        final Object o3Var62 = o3Var;
        final Object t2Var72 = t2Var;
        final Object p2Var82 = p2Var2;
        final Object billingRepository92 = billingRepository;
        final Object b2Var102 = b2Var;
        final Object a3Var132 = a3Var;
        final Object p1Var142 = p1Var;
        final Object n3Var152 = n3Var;
        n.f(p2Var22, "preferenceService");
        n.f(r2Var22, "remoteConfigService");
        n.f(u2Var32, "userLocalCacheService");
        n.f(h2Var42, "authService");
        n.f(v2Var52, "utilities");
        n.f(o3Var62, "tracker");
        n.f(t2Var72, "storageService");
        n.f(p2Var82, "sharedPreferenceService");
        n.f(billingRepository92, "billingRepository");
        n.f(b2Var102, "couponNotificationInteractor");
        n.f(support, "zendeskSupport");
        n.f(d3Var, "dogPremiumInteractor");
        n.f(a3Var132, "getSubscriptionOffersInteractor");
        n.f(p1Var142, "userRepository");
        n.f(n3Var152, "subscribeInteractor");
        super();
        p2Var3.authService = p2Var22;
        p2Var3.billingRepository = r2Var22;
        p2Var3.couponNotificationInteractor = u2Var32;
        p2Var3.d = h2Var42;
        p2Var3.e = v2Var52;
        p2Var3.f = o3Var62;
        p2Var3.dogPremiumInteractor = t2Var72;
        p2Var3.getSubscriptionOffersInteractor = p2Var82;
        p2Var3.i = billingRepository92;
        p2Var3.j = b2Var102;
        Object support112 = support;
        p2Var3.k = support112;
        p2Var3.l = a3Var132;
        p2Var3.m = p1Var142;
        p2Var3.preferenceService = n3Var152;
        p2Var3.remoteConfigService = new a();
        p2Var3.sharedPreferenceService = new a();
        support112.setHelpCenterLocaleOverride(Locale.forLanguageTag(LocaleService.d(p2Var.W())));
    }

    public static /* synthetic */ void i(e eVar, long j, int i, Object object) {
        if (i & 1 != 0) {
            i = 2000;
        }
        eVar.trackAndOpenDiscountDeeplink(i);
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final void after2SecondOpenSubscriptionScreen(String millisecondsDelay) {
        this.sharedPreferenceService.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.preferenceService.q().flatMap(new app.dogo.com.dogo_android.viewmodel.main_screen.a(this, millisecondsDelay)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "subscribeInteractor.revenueCatSubscribed()\n                .flatMap { isPremium ->\n                    if (isPremium) {\n                        throw CouponExceptions.AlreadyPremium()\n                    } else {\n                        billingRepository.validateAndSaveDiscount(coupon).map {\n                            couponNotificationInteractor.scheduleNotification(it)\n                        }\n                    }\n                }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.viewmodel.main_screen.e.f(this), new app.dogo.com.dogo_android.viewmodel.main_screen.e.g(this)));
    }

    private final void m(String str, String str2) {
        this.sharedPreferenceService.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.i.validateAndSaveDiscountPromoCode(str, str2).map(new app.dogo.com.dogo_android.viewmodel.main_screen.c(this)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "billingRepository.validateAndSaveDiscountPromoCode(linkType, partner).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.viewmodel.main_screen.e.d(this), new app.dogo.com.dogo_android.viewmodel.main_screen.e.e(this)));
    }

    private static final w n(e eVar, CouponDiscount couponDiscount) {
        n.f(eVar, "this$0");
        n.f(couponDiscount, "it");
        eVar.j.scheduleNotification(couponDiscount);
        return w.a;
    }

    private static final g0 o(e eVar, String str, Boolean boolean) throws CouponExceptions.AlreadyPremium {
        n.f(eVar, "this$0");
        n.f(str, "$coupon");
        n.f(boolean, "isPremium");
        if (boolean.booleanValue()) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new CouponExceptions_AlreadyPremium();
        } else {
            return eVar.i.validateAndSaveDiscount(str).map(new app.dogo.com.dogo_android.viewmodel.main_screen.d(eVar));
        }
    }

    private static final w p(e eVar, CouponDiscount couponDiscount) {
        n.f(eVar, "this$0");
        n.f(couponDiscount, "it");
        eVar.j.scheduleNotification(couponDiscount);
        return w.a;
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final boolean isMobileInboxEnabled() {
        boolean z = true;
        long l = this.authService.H();
        int r0 = l > 0 ? 1 : 0;
        return (l > 0 ? 1 : 0);
    }

    private final boolean v() {
        return this.authService.b0();
    }

    private final boolean w() {
        boolean booleanValue;
        try {
            Object obj = new JSONObject(this.billingRepository.t()).get("is_disabled");
            booleanValue = obj.booleanValue();
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
        return booleanValue;
    }

    private final boolean x() {
        return this.authService.F();
    }

    private final boolean z() {
        boolean booleanValue;
        try {
            Object obj = new JSONObject(this.billingRepository.I()).get("is_disabled");
            booleanValue = obj.booleanValue();
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
        return booleanValue;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean A() {
        boolean z = true;
        long l2 = this.e.g() - this.authService.g();
        long millis = TimeUnit.DAYS.toMillis(3L);
        int r0 = this.e > millis ? 1 : 0;
        return (this.e > millis ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        this.authService.Y0(this.e.g());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G() {
        this.authService.t1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean H() {
        boolean z = true;
        int r0 = !x() && !this.w() && !this.isMobileInboxEnabled() && !this.v() ? 1 : 0;
        return (!x() && !this.w() && !this.isMobileInboxEnabled() && !this.v() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean I() {
        boolean z2 = false;
        String str;
        if (this.d.D()) {
            str = "marketing_emails_v1";
            int r0 = !this.couponNotificationInteractor.C(str) ? 1 : 0;
        }
        return (!this.couponNotificationInteractor.C(str) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean J() {
        boolean z2 = false;
        int r0 = !v() && !this.z() ? 1 : 0;
        return (!v() && !this.z() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean K() {
        return this.billingRepository.e0(this.getSubscriptionOffersInteractor.W());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: L, reason: from kotlin metadata */
    public final void checkImageSize(Uri imageUri) {
        int imageUri2;
        boolean z;
        n.f(imageUri, "deepLink");
        String queryParameter = imageUri.getQueryParameter("linkType");
        String queryParameter2 = imageUri.getQueryParameter("partner");
        this.f.logEvent(E_General.c.c(new EP_Link(), imageUri.toString()));
        this.authService.t0(queryParameter2);
        imageUri2 = 0;
        imageUri2 = 1;
        if (queryParameter == null || l.z(queryParameter)) {
        }
        if (E_General.c == 0 && queryParameter2 != null) {
            if (l.z(queryParameter2)) {
            }
            if (this.authService == null) {
                m(queryParameter, queryParameter2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: M, reason: from kotlin metadata */
    public final void fetchAndSaveDiscountData(String coupon) {
        n.f(coupon, "couponCode");
        this.f.logEvent(E_General.c.c(new EP_Link(), coupon));
        after2SecondOpenSubscriptionScreen(coupon);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: N, reason: from kotlin metadata */
    public final void getDogAvatar(String dogId) {
        n.f(dogId, "dogId");
        this.m.u0(dogId);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final void trackAndOpenDiscountDeeplink(long deepLink) {
        i.b.a0 observable2 = a0.zip(r.timer(deepLink, TimeUnit.MILLISECONDS, a.a()).singleOrError(), this.l.getSubscriptionOffers(), app.dogo.com.dogo_android.viewmodel.main_screen.b.a).subscribeOn(a.b()).observeOn(a.a());
        n.e(observable2, "zip(\n                delaySingle,\n                getSubscriptionOffersInteractor.getSubscriptionOffers(),\n                { _, offers ->\n                    offers\n                }\n            )\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        getDisposable().b(a.g(observable2, app.dogo.com.dogo_android.viewmodel.main_screen.e.b.a, new app.dogo.com.dogo_android.viewmodel.main_screen.e.c(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final boolean trackAndOpenDiscountDeeplink(Uri couponCode) {
        boolean z = false;
        int[] iArr = this.dogPremiumInteractor.e(couponCode);
        final int i = 1;
        final int i4 = 800;
        if (iArr[0] >= i4) {
            if (iArr[i] >= i4) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String q() {
        return this.couponNotificationInteractor.A().f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<SubscriptionOffer> r() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> s() {
        return this.sharedPreferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: t, reason: from kotlin metadata */
    public final Uri updateCurrentDog(String dogId) {
        n.f(dogId, "dogId");
        return this.dogPremiumInteractor.h(dogId, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean y() {
        return this.billingRepository.Y();
    }


    public static /* synthetic */ g0 B(e eVar, String str, Boolean boolean) {
        return MainScreenViewModel.o(eVar, str, boolean);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static /* synthetic */ SubscriptionOffer fetchAndSaveDiscountData(Long linkType, SubscriptionOffer partner) {
        MainScreenViewModel.j(linkType, partner);
        return partner;
    }

    public static /* synthetic */ w D(e eVar, CouponDiscount couponDiscount) {
        return MainScreenViewModel.n(eVar, couponDiscount);
    }

    public static /* synthetic */ w E(e eVar, CouponDiscount couponDiscount) {
        return MainScreenViewModel.p(eVar, couponDiscount);
    }

    private static final SubscriptionOffer j(Long long, SubscriptionOffer subscriptionOffer) {
        n.f(long, "$noName_0");
        n.f(subscriptionOffer, "offers");
        return subscriptionOffer;
    }
}
