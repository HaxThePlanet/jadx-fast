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
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyPremium;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x1;
import f.d.a.a;
import i.b.a0;
import i.b.g0;
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r;
import i.b.r0.a;
import i.b.s0.a;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import n.a.a;
import org.json.JSONException;
import org.json.JSONObject;
import zendesk.support.Support;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0018\u0000 N2\u00020\u0001:\u0001NB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0002072\u0008\u0008\u0002\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020+2\u0008\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020!H\u0002J\u0018\u0010=\u001a\u0002072\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!H\u0002J\u0010\u0010A\u001a\u0004\u0018\u00010<2\u0006\u0010B\u001a\u00020!J\u0006\u0010C\u001a\u00020+J\u0006\u0010D\u001a\u000207J\u0006\u0010E\u001a\u000207J\u0006\u0010F\u001a\u00020+J\u0006\u0010G\u001a\u00020+J\u0006\u0010H\u001a\u00020+J\u0006\u0010I\u001a\u00020+J\u000e\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020<J\u000e\u0010J\u001a\u0002072\u0006\u0010L\u001a\u00020!J\u000e\u0010M\u001a\u0002072\u0006\u0010B\u001a\u00020!R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020+0*0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010(R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0014\u00100\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010/R\u0014\u00101\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00081\u0010/R\u0014\u00102\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00082\u0010/R\u0011\u00103\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\u00083\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010/R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "sharedPreferenceService", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "zendeskSupport", "Lzendesk/support/Support;", "dogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "getSubscriptionOffersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lzendesk/support/Support;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "currentDogId", "", "getCurrentDogId", "()Ljava/lang/String;", "delayedSubscriptionCalls", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "getDelayedSubscriptionCalls", "()Lcom/hadilq/liveevent/LiveEvent;", "discountOpen", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getDiscountOpen", "instagramPopUpShowed", "getInstagramPopUpShowed", "()Z", "isInstagramFollowInviteDisabled", "isInstagramFollowed", "isTikTokFollowInviteDisabled", "isTimeToShowInstagramInvite", "tiktokInviteShowed", "getTiktokInviteShowed", "after2SecondOpenSubscriptionScreen", "", "millisecondsDelay", "", "checkImageSize", "imageUri", "Landroid/net/Uri;", "fetchAndSaveDiscountData", "coupon", "linkType", "partner", "getDogAvatar", "dogId", "isMobileInboxEnabled", "setInstagramInviteShowedTime", "setTiktokShowedFlag", "shouldShowInstagramPopup", "shouldShowNewsletter", "shouldShowTiktokPopUp", "socialTabDisabled", "trackAndOpenDiscountDeeplink", "deepLink", "couponCode", "updateCurrentDog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    public static final app.dogo.com.dogo_android.a0.g.e.a Companion;
    private final p2 a;
    private final r2 b;
    private final u2 c;
    private final h2 d;
    private final v2 e;
    private final o3 f;
    private final t2 g;
    private final p2 h;
    private final BillingRepository i;
    private final b2 j;
    private final Support k;
    private final a3 l;
    private final p1 m;
    private final n3 n;
    private final a<SubscriptionOffer> o;
    private final a<y<Boolean>> p;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel$Companion;", "", "()V", "HOUR_IN_MILLIS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        public static final app.dogo.com.dogo_android.a0.g.e.b a;
        static {
            e.b bVar = new e.b();
            e.b.a = bVar;
        }

        b() {
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
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<SubscriptionOffer, w> {

        final app.dogo.com.dogo_android.a0.g.e this$0;
        c(app.dogo.com.dogo_android.a0.g.e e) {
            this.this$0 = e;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(SubscriptionOffer subscriptionOffer) {
            this.this$0.r().postValue(subscriptionOffer);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((SubscriptionOffer)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.a0.g.e this$0;
        d(app.dogo.com.dogo_android.a0.g.e e) {
            this.this$0 = e;
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
            this.this$0.s().postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<w, w> {

        final app.dogo.com.dogo_android.a0.g.e this$0;
        e(app.dogo.com.dogo_android.a0.g.e e) {
            this.this$0 = e;
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
            this.this$0.s().postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.a0.g.e this$0;
        f(app.dogo.com.dogo_android.a0.g.e e) {
            this.this$0 = e;
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
            this.this$0.s().postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<w, w> {

        final app.dogo.com.dogo_android.a0.g.e this$0;
        g(app.dogo.com.dogo_android.a0.g.e e) {
            this.this$0 = e;
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
            this.this$0.s().postValue(cVar);
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.Companion = aVar;
    }

    public e(p2 p2, r2 r22, u2 u23, h2 h24, v2 v25, o3 o36, t2 t27, p2 p28, BillingRepository billingRepository9, b2 b210, Support support11, d3 d312, a3 a313, p1 p114, n3 n315) {
        final Object obj = this;
        Object obj2 = p2;
        Object obj3 = r22;
        Object obj4 = u23;
        final Object obj5 = h24;
        final Object obj6 = v25;
        final Object obj7 = o36;
        final Object obj8 = t27;
        final Object obj9 = p28;
        final Object obj10 = billingRepository9;
        final Object obj11 = b210;
        final Object obj14 = a313;
        final Object obj15 = p114;
        final Object obj16 = n315;
        n.f(obj2, "preferenceService");
        n.f(obj3, "remoteConfigService");
        n.f(obj4, "userLocalCacheService");
        n.f(obj5, "authService");
        n.f(obj6, "utilities");
        n.f(obj7, "tracker");
        n.f(obj8, "storageService");
        n.f(obj9, "sharedPreferenceService");
        n.f(obj10, "billingRepository");
        n.f(obj11, "couponNotificationInteractor");
        n.f(support11, "zendeskSupport");
        n.f(d312, "dogPremiumInteractor");
        n.f(obj14, "getSubscriptionOffersInteractor");
        n.f(obj15, "userRepository");
        n.f(obj16, "subscribeInteractor");
        super();
        obj.a = obj2;
        obj.b = obj3;
        obj.c = obj4;
        obj.d = obj5;
        obj.e = obj6;
        obj.f = obj7;
        obj.g = obj8;
        obj.h = obj9;
        obj.i = obj10;
        obj.j = obj11;
        Support support = support11;
        obj.k = support;
        obj.l = obj14;
        obj.m = obj15;
        obj.n = obj16;
        a aVar = new a();
        obj.o = aVar;
        a aVar2 = new a();
        obj.p = aVar2;
        support.setHelpCenterLocaleOverride(Locale.forLanguageTag(n2.d(p2.W())));
    }

    public static g0 B(app.dogo.com.dogo_android.a0.g.e e, String string2, Boolean boolean3) {
        return e.o(e, string2, boolean3);
    }

    public static SubscriptionOffer C(Long long, SubscriptionOffer subscriptionOffer2) {
        e.j(long, subscriptionOffer2);
        return subscriptionOffer2;
    }

    public static w D(app.dogo.com.dogo_android.a0.g.e e, CouponDiscount couponDiscount2) {
        return e.n(e, couponDiscount2);
    }

    public static w E(app.dogo.com.dogo_android.a0.g.e e, CouponDiscount couponDiscount2) {
        return e.p(e, couponDiscount2);
    }

    public static void i(app.dogo.com.dogo_android.a0.g.e e, long l2, int i3, Object object4) {
        int obj1;
        if (object4 &= 1 != 0) {
            obj1 = 2000;
        }
        e.h(obj1);
    }

    private static final SubscriptionOffer j(Long long, SubscriptionOffer subscriptionOffer2) {
        n.f(long, "$noName_0");
        n.f(subscriptionOffer2, "offers");
        return subscriptionOffer2;
    }

    private final void l(String string) {
        this.p.postValue(y.b.a);
        a aVar2 = new a(this, string);
        a0 obj4 = this.n.q().flatMap(aVar2).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj4, "subscribeInteractor.revenueCatSubscribed()\n                .flatMap { isPremium ->\n                    if (isPremium) {\n                        throw CouponExceptions.AlreadyPremium()\n                    } else {\n                        billingRepository.validateAndSaveDiscount(coupon).map {\n                            couponNotificationInteractor.scheduleNotification(it)\n                        }\n                    }\n                }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        e.f fVar = new e.f(this);
        e.g gVar = new e.g(this);
        getDisposable().b(a.g(obj4, fVar, gVar));
    }

    private final void m(String string, String string2) {
        this.p.postValue(y.b.a);
        c obj4 = new c(this);
        a0 obj3 = this.i.validateAndSaveDiscountPromoCode(string, string2).map(obj4).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj3, "billingRepository.validateAndSaveDiscountPromoCode(linkType, partner).map {\n                couponNotificationInteractor.scheduleNotification(it)\n            }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        obj4 = new e.d(this);
        e.e eVar = new e.e(this);
        getDisposable().b(a.g(obj3, obj4, eVar));
    }

    private static final w n(app.dogo.com.dogo_android.a0.g.e e, CouponDiscount couponDiscount2) {
        n.f(e, "this$0");
        n.f(couponDiscount2, "it");
        e.j.c(couponDiscount2);
        return w.a;
    }

    private static final g0 o(app.dogo.com.dogo_android.a0.g.e e, String string2, Boolean boolean3) {
        n.f(e, "this$0");
        n.f(string2, "$coupon");
        n.f(boolean3, "isPremium");
        if (boolean3.booleanValue()) {
        } else {
            d obj3 = new d(e);
            return e.i.validateAndSaveDiscount(string2).map(obj3);
        }
        CouponExceptions.AlreadyPremium obj1 = new CouponExceptions.AlreadyPremium();
        throw obj1;
    }

    private static final w p(app.dogo.com.dogo_android.a0.g.e e, CouponDiscount couponDiscount2) {
        n.f(e, "this$0");
        n.f(couponDiscount2, "it");
        e.j.c(couponDiscount2);
        return w.a;
    }

    private final boolean u() {
        int i;
        i = Long.compare(l, i2) > 0 ? 1 : 0;
        return i;
    }

    private final boolean v() {
        return this.a.b0();
    }

    private final boolean w() {
        boolean booleanValue;
        try {
            JSONObject jSONObject = new JSONObject(this.b.t());
            Object obj = jSONObject.get("is_disabled");
            if (obj == null) {
            } else {
            }
            booleanValue = (Boolean)obj.booleanValue();
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            throw nullPointerException;
            th.printStackTrace();
            return booleanValue;
        }
    }

    private final boolean x() {
        return this.a.F();
    }

    private final boolean z() {
        boolean booleanValue;
        try {
            JSONObject jSONObject = new JSONObject(this.b.I());
            Object obj = jSONObject.get("is_disabled");
            if (obj == null) {
            } else {
            }
            booleanValue = (Boolean)obj.booleanValue();
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            throw nullPointerException;
            th.printStackTrace();
            return booleanValue;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean A() {
        int i;
        i = Long.compare(i2, millis) > 0 ? 1 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void F() {
        this.a.Y0(this.e.g());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void G() {
        this.a.t1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean H() {
        boolean z;
        int i;
        if (!x() && !w() && !u() && !v()) {
            if (!w()) {
                if (!u()) {
                    i = !v() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean I() {
        boolean z;
        int i;
        String str;
        if (this.d.D() && !this.c.C("marketing_emails_v1")) {
            i = !this.c.C("marketing_emails_v1") ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean J() {
        boolean z;
        int i;
        if (!v() && !z()) {
            i = !z() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean K() {
        return this.b.e0(this.h.W());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void L(Uri uri) {
        int i;
        u2 u2Var;
        int obj6;
        n.f(uri, "deepLink");
        String queryParameter = uri.getQueryParameter("linkType");
        String queryParameter2 = uri.getQueryParameter("partner");
        x1 x1Var = new x1();
        this.f.d(a0.c.c(x1Var, uri.toString()));
        this.a.t0(queryParameter2);
        int i2 = 1;
        if (queryParameter != null) {
            if (l.z(queryParameter)) {
                i = i2;
            } else {
                i = obj6;
            }
        } else {
        }
        if (i == 0) {
            if (queryParameter2 != null) {
                if (l.z(queryParameter2)) {
                    obj6 = i2;
                }
            } else {
            }
            if (obj6 == null) {
                m(queryParameter, queryParameter2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void M(String string) {
        n.f(string, "couponCode");
        x1 x1Var = new x1();
        this.f.d(a0.c.c(x1Var, string));
        l(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void N(String string) {
        n.f(string, "dogId");
        this.m.u0(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h(long l) {
        a0 obj3 = a0.zip(r.timer(l, obj4, TimeUnit.MILLISECONDS).singleOrError(), this.l.a(), b.a).subscribeOn(a.b()).observeOn(a.a());
        n.e(obj3, "zip(\n                delaySingle,\n                getSubscriptionOffersInteractor.getSubscriptionOffers(),\n                { _, offers ->\n                    offers\n                }\n            )\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())");
        e.c cVar = new e.c(this);
        getDisposable().b(a.g(obj3, e.b.a, cVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean k(Uri uri) {
        int i;
        int[] obj5;
        obj5 = this.g.e(uri);
        final int i3 = 1;
        final int i4 = 800;
        if (obj5[0] >= i4 && obj5[i3] >= i4) {
            if (obj5[i3] >= i4) {
                i = i3;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String q() {
        return this.c.A().f();
    }

    public final a<SubscriptionOffer> r() {
        return this.o;
    }

    public final a<y<Boolean>> s() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri t(String string) {
        n.f(string, "dogId");
        return this.g.h(string, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean y() {
        return this.b.Y();
    }
}
