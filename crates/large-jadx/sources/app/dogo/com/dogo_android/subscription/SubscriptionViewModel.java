package app.dogo.com.dogo_android.subscription;

import android.app.Activity;
import android.app.ActivityManager.ProcessErrorStateInfo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.s.a.a3;
import app.dogo.com.dogo_android.s.a.b2;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.a.j2;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.benefits.RxJavaDogo;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.d2;
import app.dogo.com.dogo_android.w.e1;
import app.dogo.com.dogo_android.w.g2;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.a;
import app.dogo.com.dogo_android.w.t0;
import app.dogo.com.dogo_android.w.x2;
import app.dogo.com.dogo_android.w.y2;
import com.android.billingclient.api.SkuDetails;
import com.appsflyer.AppsFlyerLib;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import i.b.a0;
import i.b.g0;
import i.b.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.p;

/* compiled from: SubscriptionViewModel.kt */
@Metadata(d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010Z\u001a\u00020\u0005J\u0016\u0010[\u001a\u00020\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0018\u0010^\u001a\u0004\u0018\u00010\u00032\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0008\u0010_\u001a\u00020\\H\u0002J,\u0010`\u001a\u00020\\2\u000e\u0008\u0002\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\u00030I2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005H\u0002J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0003H\u0002J\u0018\u0010g\u001a\u0004\u0018\u00010J2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0016\u0010h\u001a\u00020A2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0006\u0010i\u001a\u00020jJ\u0017\u0010k\u001a\u00020l2\u0008\u0010m\u001a\u0004\u0018\u00010lH\u0002¢\u0006\u0002\u0010nJ$\u0010o\u001a\u0004\u0018\u00010\u00032\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0008\u0010p\u001a\u0004\u0018\u00010JH\u0002J \u0010q\u001a\u0004\u0018\u00010J2\u0006\u0010@\u001a\u00020A2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0018\u0010r\u001a\u0008\u0012\u0004\u0012\u00020\"0s2\u0008\u0010t\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010u\u001a\u00020\\2\u0006\u0010v\u001a\u00020wH\u0002J\u0017\u0010x\u001a\u00020\u00052\u0008\u0010m\u001a\u0004\u0018\u00010lH\u0002¢\u0006\u0002\u0010yJ\u0006\u0010z\u001a\u00020\u0005J\u0006\u0010{\u001a\u00020\u0005J\u000c\u0010|\u001a\u0008\u0012\u0004\u0012\u00020}0IJ\u0012\u0010~\u001a\u00020\\2\n\u0008\u0002\u0010\u007f\u001a\u0004\u0018\u00010\"J\u0011\u0010\u0080\u0001\u001a\u00020\\2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0010\u0010\u0083\u0001\u001a\u00020\\2\u0007\u0010\u0084\u0001\u001a\u00020AJ\u001b\u0010\u0085\u0001\u001a\u00020\\2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005J-\u0010\u0085\u0001\u001a\u00020\\2\u000e\u0008\u0002\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\u00030I2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005H\u0002J\t\u0010\u0086\u0001\u001a\u00020\\H\u0002J\u0018\u0010\u0087\u0001\u001a\u0008\u0012\u0004\u0012\u00020l0s2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J\u0007\u0010\u0089\u0001\u001a\u00020\\J\u0007\u0010\u008a\u0001\u001a\u00020\\J\u001a\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010v\u001a\u00020w2\u0007\u0010\u008c\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010\u008d\u0001\u001a\u00020\\J\u0007\u0010\u008e\u0001\u001a\u00020\\R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\"0!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00050)¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008-\u0010%R\u0017\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u00101\u001a\u0010\u0012\u000c\u0012\n 2*\u0004\u0018\u00010\u00050\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00100R\u001d\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0)¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010+R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u0002050)¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010+R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00100R\u001a\u00109\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010%\"\u0004\u0008;\u0010'R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\"0!0=¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u001f\u0010@\u001a\u0010\u0012\u000c\u0012\n 2*\u0004\u0018\u00010A0A0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u00100R\u0017\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00050)¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010+R\u001d\u0010E\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010%R\u001d\u0010H\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020J0I0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008K\u00100R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\u0008\u0012\u0004\u0012\u00020O0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u00100R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020R0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008S\u0010+R\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008U\u0010%\"\u0004\u0008V\u0010'R\u001a\u0010W\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008X\u0010%\"\u0004\u0008Y\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "viewSource", "", "showResubscribeLayout", "", "repository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getCustomerExperienceInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetCustomerExperienceInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getSubscriptionOffersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/subscription/BillingRepository;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/GetCustomerExperienceInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "allPlansTracked", "getAllPlansTracked", "()Z", "setAllPlansTracked", "(Z)V", "clickedOnSelectedBestValueCard", "Lcom/hadilq/liveevent/LiveEvent;", "getClickedOnSelectedBestValueCard", "()Lcom/hadilq/liveevent/LiveEvent;", "customersExperienceEnabled", "getCustomersExperienceEnabled", "discountVisible", "getDiscountVisible", "()Landroidx/lifecycle/MutableLiveData;", "isFreeTrailAvailable", "kotlin.jvm.PlatformType", "isPurchaseRestored", "onZendeskOpen", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getOnZendeskOpen", "purchaseUIState", "getPurchaseUIState", "purchaseWasMade", "getPurchaseWasMade", "setPurchaseWasMade", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "selected", "", "getSelected", "shouldGoBack", "getShouldGoBack", "showInfoDialog", "getShowInfoDialog", "getShowResubscribeLayout", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "getSkuList", "tick", "Ljava/util/concurrent/atomic/AtomicLong;", "timer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "getTimer", "userError", "", "getUserError", "userTestimonialsSwitched", "getUserTestimonialsSwitched", "setUserTestimonialsSwitched", "userTestimonialsTracked", "getUserTestimonialsTracked", "setUserTestimonialsTracked", "allPlansTopEnabled", "bestValueItemSelected", "", "list", "bestValueSavingsPercentString", "doubleCheckRevenueCatCache", "fetchDataAndOpenZendeskScreen", "customTags", "hasRequestHistory", "hasUnreadMessages", "findPackageType", "Lcom/revenuecat/purchases/PackageType;", "value", "getBestValueProduct", "getBestValueSelectedNumber", "getPricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "getRemainingCouponDurationMs", "", "endTimeMs", "(Ljava/lang/Long;)J", "getSavingsPercentString", "sku", "getSelectedSkuDetails", "getSubscriptionOffers", "Lio/reactivex/Flowable;", "preloadedOffers", "handleRecoverableRevenueCatError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "isDiscountStillValid", "(Ljava/lang/Long;)Z", "isUserNameSet", "isUserSignedIn", "listOfCustomerExperiences", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "loadOffers", "preloadedOffer", "makePurchase", "activity", "Landroid/app/Activity;", "onSkuSelected", "position", "openZendeskScreen", "restorePurchase", "setupDiscountTimerIfNeeded", "offer", "trackAllPlansShowedOnce", "trackCloseIfNeeded", "trackPurchaseError", "isUserCancelled", "trackTestimonialsShowedOnce", "trackTestimonialsSwitchedOnce", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final SubscriptionViewModel.Companion INSTANCE = null;
    public static final String INDIA_LOCATION_CODE = "in";
    private final x<y<SubscriptionOffer>> _result = new x<>();
    private boolean allPlansTracked;
    private final h2 authService;
    private final f.d.a.a<Boolean> clickedOnSelectedBestValueCard = new a<>();
    private final b2 couponNotificationInteractor;
    private final x<Boolean> discountVisible = new x<>();
    private final j2 getCustomerExperienceInteractor;
    private final a3 getSubscriptionOffersInteractor;
    private final d3 isDogPremiumInteractor;
    private final x<Boolean> isFreeTrailAvailable = new x<>();
    private final f.d.a.a<y<Boolean>> isPurchaseRestored = new a<>();
    private final f.d.a.a<ZendeskConfigurationInfo> onZendeskOpen = new a<>();
    private final p2 preferenceService;
    private final x<y<Boolean>> purchaseUIState = new x<>();
    private boolean purchaseWasMade;
    private final Purchases purchases;
    private final app.dogo.com.dogo_android.service.r2 remoteConfigService;
    private final BillingRepository repository;
    private final LiveData<y<SubscriptionOffer>> result = new x<>();
    private final x<Integer> selected = new x<>();
    private final f.d.a.a<Boolean> shouldGoBack = new a<>();
    private final f.d.a.a<y<Boolean>> showInfoDialog = new a<>();
    private final boolean showResubscribeLayout;
    private final x<List<DogoSkuDetails>> skuList = new x<>();
    private final n3 subscribeInteractor;
    private final AtomicLong tick = new AtomicLong();
    private final v2 timeUtils;
    private final x<CouponTimer> timer = new x<>();
    private final o3 tracker;
    private final f.d.a.a<Throwable> userError = new a<>();
    private boolean userTestimonialsSwitched;
    private boolean userTestimonialsTracked;
    private final String viewSource;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel$Companion;", "", "()V", "INDIA_LOCATION_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[PurchasesErrorCode.values().length];
            iArr[PurchasesErrorCode.UnknownError.ordinal()] = 1;
            iArr[PurchasesErrorCode.PurchaseCancelledError.ordinal()] = 2;
            iArr[PurchasesErrorCode.StoreProblemError.ordinal()] = 3;
            iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 4;
            iArr[PurchasesErrorCode.PurchaseInvalidError.ordinal()] = 5;
            iArr[PurchasesErrorCode.ProductNotAvailableForPurchaseError.ordinal()] = 6;
            iArr[PurchasesErrorCode.ProductAlreadyPurchasedError.ordinal()] = 7;
            iArr[PurchasesErrorCode.ReceiptAlreadyInUseError.ordinal()] = 8;
            iArr[PurchasesErrorCode.InvalidReceiptError.ordinal()] = 9;
            iArr[PurchasesErrorCode.MissingReceiptFileError.ordinal()] = 10;
            iArr[PurchasesErrorCode.NetworkError.ordinal()] = 11;
            iArr[PurchasesErrorCode.InvalidCredentialsError.ordinal()] = 12;
            iArr[PurchasesErrorCode.UnexpectedBackendResponseError.ordinal()] = 13;
            iArr[PurchasesErrorCode.InvalidAppUserIdError.ordinal()] = 14;
            iArr[PurchasesErrorCode.OperationAlreadyInProgressError.ordinal()] = 15;
            iArr[PurchasesErrorCode.UnknownBackendError.ordinal()] = 16;
            iArr[PurchasesErrorCode.InvalidAppleSubscriptionKeyError.ordinal()] = 17;
            iArr[PurchasesErrorCode.IneligibleError.ordinal()] = 18;
            iArr[PurchasesErrorCode.InsufficientPermissionsError.ordinal()] = 19;
            iArr[PurchasesErrorCode.PaymentPendingError.ordinal()] = 20;
            iArr[PurchasesErrorCode.InvalidSubscriberAttributesError.ordinal()] = 21;
            iArr[PurchasesErrorCode.LogOutWithAnonymousUserError.ordinal()] = 22;
            iArr[PurchasesErrorCode.ConfigurationError.ordinal()] = 23;
            iArr[PurchasesErrorCode.UnsupportedError.ordinal()] = 24;
            SubscriptionViewModel.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public SubscriptionViewModel(String str, boolean z, BillingRepository billingRepository, Purchases purchases, p2 p2Var, o3 o3Var, b2 b2Var, v2 v2Var, app.dogo.com.dogo_android.service.r2 r2Var, j2 j2Var, h2 h2Var, a3 a3Var, n3 n3Var, d3 d3Var) {
        n.f(str, "viewSource");
        n.f(billingRepository, "repository");
        n.f(purchases, "purchases");
        n.f(p2Var, "preferenceService");
        n.f(o3Var, "tracker");
        n.f(b2Var, "couponNotificationInteractor");
        n.f(v2Var, "timeUtils");
        n.f(r2Var, "remoteConfigService");
        n.f(j2Var, "getCustomerExperienceInteractor");
        n.f(h2Var, "authService");
        n.f(a3Var, "getSubscriptionOffersInteractor");
        n.f(n3Var, "subscribeInteractor");
        n.f(d3Var, "isDogPremiumInteractor");
        super();
        this.viewSource = str;
        this.showResubscribeLayout = z;
        this.repository = billingRepository;
        this.purchases = purchases;
        this.preferenceService = p2Var;
        this.tracker = o3Var;
        this.couponNotificationInteractor = b2Var;
        this.timeUtils = v2Var;
        this.remoteConfigService = r2Var;
        this.getCustomerExperienceInteractor = j2Var;
        this.authService = h2Var;
        this.getSubscriptionOffersInteractor = a3Var;
        this.subscribeInteractor = n3Var;
        this.isDogPremiumInteractor = d3Var;
        f.d.a.a aVar = new a();
        x xVar = new x();
        x xVar2 = new x();
        f.d.a.a aVar2 = new a();
        x xVar3 = new x(2);
        f.d.a.a aVar3 = new a();
        Boolean fALSE2 = Boolean.FALSE;
        x xVar4 = new x(fALSE2);
        x xVar5 = new x();
        AtomicLong atomicLong = new AtomicLong(0L, purchases);
        x xVar6 = new x();
        x xVar7 = new x(fALSE2);
        f.d.a.a aVar4 = new a();
        f.d.a.a aVar5 = new a();
        f.d.a.a aVar6 = new a();
    }

    public static final /* synthetic */ void access$doubleCheckRevenueCatCache(SubscriptionViewModel subscriptionViewModel) {
        subscriptionViewModel.doubleCheckRevenueCatCache();
    }

    public static final /* synthetic */ h2 access$getAuthService$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.authService;
    }

    public static final /* synthetic */ b2 access$getCouponNotificationInteractor$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.couponNotificationInteractor;
    }

    public static final /* synthetic */ Purchases access$getPurchases$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.purchases;
    }

    public static final /* synthetic */ BillingRepository access$getRepository$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.repository;
    }

    public static final /* synthetic */ AtomicLong access$getTick$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.tick;
    }

    public static final /* synthetic */ o3 access$getTracker$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.tracker;
    }

    public static final /* synthetic */ String access$getViewSource$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.viewSource;
    }

    public static final /* synthetic */ x access$get_result$p(SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel._result;
    }

    public static final /* synthetic */ void access$handleRecoverableRevenueCatError(SubscriptionViewModel subscriptionViewModel, PurchasesError th) {
        subscriptionViewModel.handleRecoverableRevenueCatError(th);
    }

    public static final /* synthetic */ void access$trackPurchaseError(SubscriptionViewModel subscriptionViewModel, PurchasesError th, boolean z) {
        subscriptionViewModel.trackPurchaseError(th, z);
    }

    private final void doubleCheckRevenueCatCache() {
        final kotlin.d0.c.l lVar = null;
        ListenerConversionsKt.getPurchaserInfoWith$default(this.purchases, lVar, new SubscriptionViewModel.doubleCheckRevenueCatCache.AnonymousClass1(this), 1, lVar);
    }

    private final void fetchDataAndOpenZendeskScreen(List<String> customTags, boolean hasRequestHistory, boolean hasUnreadMessages) {
        String str = null;
        a0 observable2 = a0.zip(App.INSTANCE.s().w(), IsDogPremiumInteractor.b(this.isDogPremiumInteractor, str, 1, str), new n(this, customTags, hasRequestHistory, hasUnreadMessages)).observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium()\n                ) { dogProfile, isPremium ->\n                    ZendeskConfigurationInfo(\n                        userId = authService.currentUserId,\n                        dogProfile = dogProfile,\n                        isDogPremium = isPremium,\n                        customTags = customTags,\n                        isUserLoggedIn = authService.isUserSignedIn,\n                        hasUnreadMessages = hasUnreadMessages,\n                        hasRequestHistory = hasRequestHistory,\n                        isHelpCenterEnabled = remoteConfigService.isHelpCenterEnabled(preferenceService.selectedLocale)\n                    )\n                }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new SubscriptionViewModel.fetchDataAndOpenZendeskScreen.AnonymousClass2(this), new SubscriptionViewModel.fetchDataAndOpenZendeskScreen.AnonymousClass3(this)));
    }

    static /* synthetic */ void fetchDataAndOpenZendeskScreen$default(SubscriptionViewModel subscriptionViewModel, List list, boolean z, boolean z2, int i, Object object) {
        if (i & 1 != 0) {
            list = p.g();
        }
        i = 0;
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        subscriptionViewModel.fetchDataAndOpenZendeskScreen(list, z, z2);
    }

    private static final ZendeskConfigurationInfo fetchDataAndOpenZendeskScreen$lambda_7(SubscriptionViewModel subscriptionViewModel, List list, boolean z, boolean z2, DogProfile dogProfile, Boolean boolean) {
        n.f(subscriptionViewModel, "this$0");
        n.f(list, "$customTags");
        n.f(dogProfile, "dogProfile");
        n.f(boolean, "isPremium");
        ZendeskConfigurationInfo subscriptionViewModel2 = new ZendeskConfigurationInfo(subscriptionViewModel.authService.v(), boolean, dogProfile, list, subscriptionViewModel.remoteConfigService.U(subscriptionViewModel.preferenceService.W()), subscriptionViewModel.authService.D(), z, z2);
        return subscriptionViewModel2;
    }

    private final PackageType findPackageType(String value) {
        int i;
        PackageType cUSTOM2;
        boolean z;
        PackageType[] values = PackageType.values();
        length = values.length;
        final boolean z3 = false;
        i = z3;
        Object obj = null;
        for (PackageType cUSTOM2 : values) {
            if (n.b(cUSTOM2.getIdentifier(), value)) {
                break;
            }
        }
        int i3 = obj;
        if (cUSTOM2 == null) {
            PackageType r5 = l.M(value, "$rc_", z3, 2, obj) ? PackageType.UNKNOWN : PackageType.CUSTOM;
        }
        return (l.M(value, "$rc_", z3, 2, obj) ? PackageType.UNKNOWN : PackageType.CUSTOM);
    }

    private final long getRemainingCouponDurationMs(Long endTimeMs) {
        int i = 0;
        if (endTimeMs == null) {
            i = 0;
        } else {
            long value = endTimeMs.longValue();
        }
        return i - this.timeUtils.g();
    }

    private final String getSavingsPercentString(List<DogoSkuDetails> list, DogoSkuDetails sku) {
        int i = 0;
        Object item;
        app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails;
        double value = 0;
        int i3;
        boolean hasNext;
        double value2;
        int compare;
        double value3;
        i = 0;
        if (list != null && sku != null) {
            Iterator it = list.iterator();
            i3 = 0;
            if (!it.hasNext()) {
            } else {
                if (it.hasNext()) {
                    Double tag2 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)it.next());
                    if (tag2 == null) {
                    } else {
                        double value4 = tag2.doubleValue();
                    }
                    item = it.next();
                    Double tag3 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)item);
                    do {
                        item = it.next();
                        tag3 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)item);
                        value2 = tag3.doubleValue();
                    } while (tag3 == null);
                }
            }
            Double tag4 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag(sku);
            if (tag4 == null) {
            } else {
                value3 = tag4.doubleValue();
            }
            if (dogoSkuDetails != null) {
                Double tag = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag(dogoSkuDetails);
                if (tag != null) {
                    value = tag.doubleValue();
                }
            }
            int i2 = 100;
            double d2 = (double)i2;
            d = d2 - (value3 / value) * d2;
            if (a.a(d) != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                int i5 = a.a(d);
                char c = '%';
                str = i5 + c;
            }
        }
        return i;
    }

    private final h<SubscriptionOffer> getSubscriptionOffers(SubscriptionOffer preloadedOffers) {
        h hVar;
        if (preloadedOffers != null) {
            str = "{\n            Flowable.just(preloadedOffers)\n        }";
            n.e(h.C(preloadedOffers), str);
        } else {
            str = "{\n            getSubscriptionOffersInteractor.getSubscriptionOffers()\n                .onErrorResumeNext {\n                    if (it is CouponExceptions.AlreadyPremium) {\n                        shouldGoBack.postValue(true)\n                    }\n                    throw it\n                }\n                .toFlowable()\n                .observeOn(Schedulers.io())\n        }";
            n.e(this.getSubscriptionOffersInteractor.a().onErrorResumeNext(new q(this)).toFlowable().F(a.b()), str);
        }
        return hVar;
    }

    private static final g0 getSubscriptionOffers$lambda_1(SubscriptionViewModel subscriptionViewModel, Throwable th) {
        n.f(subscriptionViewModel, "this$0");
        n.f(th, "it");
        z = th instanceof CouponExceptions_AlreadyPremium;
        if (!(th instanceof CouponExceptions_AlreadyPremium)) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        } else {
            subscriptionViewModel.getShouldGoBack().postValue(Boolean.TRUE);
        }
    }

    private final void handleRecoverableRevenueCatError(PurchasesError error) {
        PurchasesErrorCode[] arr = new PurchasesErrorCode[5];
        int i = 4;
        arr[i] = PurchasesErrorCode.ProductAlreadyPurchasedError;
        if (i.t(arr, error.getCode())) {
            this.showInfoDialog.postValue(new LoadResult_Error(new Exception(String.valueOf(error))));
            restorePurchase();
        }
    }

    private final boolean isDiscountStillValid(Long endTimeMs) {
        int i = 0;
        boolean z = false;
        long l = this.timeUtils.g();
        if (endTimeMs == null) {
            i = 0;
        } else {
            long value = endTimeMs.longValue();
        }
        endTimeMs = l < i ? 1 : 0;
        return (l < i ? 1 : 0);
    }

    public static /* synthetic */ void loadOffers$default(SubscriptionViewModel subscriptionViewModel, SubscriptionOffer subscriptionOffer, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        subscriptionViewModel.loadOffers(subscriptionOffer);
    }

    private static final m.c.a loadOffers$lambda_0(SubscriptionViewModel subscriptionViewModel, SubscriptionOffer subscriptionOffer) {
        n.f(subscriptionViewModel, "this$0");
        n.f(subscriptionOffer, "it");
        return subscriptionViewModel.setupDiscountTimerIfNeeded(subscriptionOffer);
    }

    private final void openZendeskScreen(List<String> customTags, boolean hasRequestHistory, boolean hasUnreadMessages) {
        fetchDataAndOpenZendeskScreen(customTags, hasRequestHistory, hasUnreadMessages);
    }

    static /* synthetic */ void openZendeskScreen$default(SubscriptionViewModel subscriptionViewModel, List list, boolean z, boolean z2, int i, Object object) {
        if (i & 1 != 0) {
            list = p.g();
        }
        i = 0;
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        subscriptionViewModel.openZendeskScreen(list, z, z2);
    }

    private final void restorePurchase() {
        this.isPurchaseRestored.postValue(LoadResult_Loading.a);
        a0 observable2 = this.subscribeInteractor.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "subscribeInteractor.restorePurchase()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new SubscriptionViewModel.restorePurchase.AnonymousClass1(this), new SubscriptionViewModel.restorePurchase.AnonymousClass2(this)));
    }

    private final h<Long> setupDiscountTimerIfNeeded(SubscriptionOffer offer) {
        boolean z = false;
        Integer num;
        Long endTimeMs = null;
        h repeatUntil;
        this._result.postValue(new LoadResult_Success(offer));
        this.skuList.postValue(offer.getList());
        this.selected.postValue(Integer.valueOf(getBestValueSelectedNumber(offer.getList())));
        if (offer.isFreeTrailAvailable()) {
            int r0 = !n.b(this.remoteConfigService.v(), "in") ? 1 : 0;
        }
        this.isFreeTrailAvailable.postValue((!n.b(this.remoteConfigService.v(), "in") ? 1 : 0));
        CouponDiscount coupon = offer.getCoupon();
        if (coupon == null) {
            int i4 = 0;
        } else {
            endTimeMs = coupon.getEndTimeMs();
        }
        if (isDiscountStillValid(endTimeMs)) {
            long l2 = (long)1000;
            long l = getRemainingCouponDurationMs(endTimeMs) / l2;
            this.timer.postValue(new CouponTimer(l2 * l, r3));
            this.discountVisible.postValue(Boolean.TRUE);
            str = "{\n            val durationInSeconds = getRemainingCouponDurationMs(absoluteEndTimeMs) / 1000\n            timer.postValue(CouponTimer(durationInSeconds * 1000))\n            discountVisible.postValue(true)\n            RxJavaDogo.timerWithStart(durationInSeconds)\n                .repeatUntil { tick.get() >= durationInSeconds }\n        }";
            n.e(RxJavaDogo.INSTANCE.timerWithStart(l).repeatUntil(new p(this, l, isFreeTrailAvailable2)), str);
        } else {
            str = "{\n            Flowable.empty()\n        }";
            n.e(h.l(), str);
        }
        return repeatUntil;
    }

    private static final boolean setupDiscountTimerIfNeeded$lambda_2(SubscriptionViewModel subscriptionViewModel, long j) {
        boolean z = true;
        n.f(subscriptionViewModel, "this$0");
        long l = subscriptionViewModel.tick.get();
        subscriptionViewModel = l >= j ? 1 : 0;
        return (l >= j ? 1 : 0);
    }

    private final void trackPurchaseError(PurchasesError th, boolean z) throws NoWhenBranchMatchedException {
        Exception exception;
        this.tracker.logEvent(E_Subscription.c.withParameters(u.a(new EP_AffiliateSource(), this.preferenceService.G()), u.a(new EP_ViewSource(), this.viewSource), u.a(new EP_ErrorCode(), th.getCode().getDescription()), u.a(new EP_ErrorMessage(), th.getUnderlyingErrorMessage())));
        StringBuilder stringBuilder = new StringBuilder();
        String str = ", userCancelled ";
        z = th + str + z;
        switch (SubscriptionViewModel.WhenMappings.$EnumSwitchMapping$0[th.getCode().ordinal()]) {
            case 1: /* ordinal */
                exception = new Exception(z);
                break;
            case 2: /* ordinal */
                exception = new Exception(z);
                break;
            case 3: /* ordinal */
                exception = new Exception(z);
                break;
            case 4: /* ordinal */
                exception = new Exception(z);
                break;
            case 5: /* ordinal */
                exception = new Exception(z);
                break;
            case 6: /* ordinal */
                exception = new Exception(z);
                break;
            case 7: /* ordinal */
                exception = new Exception(z);
                break;
            case 8: /* ordinal */
                exception = new Exception(z);
                break;
            case 9: /* ordinal */
                exception = new Exception(z);
                break;
            case 10: /* ordinal */
                exception = new Exception(z);
                break;
            case 11: /* ordinal */
                exception = new Exception(z);
                break;
            case 12: /* ordinal */
                exception = new Exception(z);
                break;
            case 13: /* ordinal */
                exception = new Exception(z);
                break;
            case 14: /* ordinal */
                exception = new Exception(z);
                break;
            case 15: /* ordinal */
                exception = new Exception(z);
                break;
            case 16: /* ordinal */
                exception = new Exception(z);
                break;
            case 17: /* ordinal */
                exception = new Exception(z);
                break;
            case 18: /* ordinal */
                exception = new Exception(z);
                break;
            case 19: /* ordinal */
                exception = new Exception(z);
                break;
            case 20: /* ordinal */
                exception = new Exception(z);
                break;
            case 21: /* ordinal */
                exception = new Exception(z);
                break;
            case 22: /* ordinal */
                exception = new Exception(z);
                break;
            case 23: /* ordinal */
                exception = new Exception(z);
                break;
            case 24: /* ordinal */
                exception = new Exception(z);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Tracker.INSTANCE.logException(exception);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean allPlansTopEnabled() {
        return this.remoteConfigService.f0();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void bestValueItemSelected(List<DogoSkuDetails> list) {
        int bestValueSelectedNumber = getBestValueSelectedNumber(list);
        Object value = this.selected.getValue();
        if (value == null) {
            this.selected.postValue(Integer.valueOf(bestValueSelectedNumber));
        } else {
            if (value.intValue() == bestValueSelectedNumber) {
                this.clickedOnSelectedBestValueCard.postValue(Boolean.TRUE);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String bestValueSavingsPercentString(List<DogoSkuDetails> list) {
        return getSavingsPercentString(list, getBestValueProduct(list));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getAllPlansTracked() {
        return this.allPlansTracked;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogoSkuDetails getBestValueProduct(List<DogoSkuDetails> list) {
        Object item;
        int i = 0;
        boolean hasNext;
        long l = 9218868437227405311L;
        double value;
        int compare;
        i = 0;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                if (it.hasNext()) {
                    Double tag = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)it.next());
                    l = 9218868437227405311L;
                    if (tag == null) {
                    } else {
                        double value2 = tag.doubleValue();
                    }
                    item = it.next();
                    Double tag2 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)item);
                    do {
                        item = it.next();
                        tag2 = app.dogo.com.dogo_android.util.extensionfunction.j1.containsTag((DogoSkuDetails)item);
                        value = tag2.doubleValue();
                    } while (tag2 == null);
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int getBestValueSelectedNumber(List<DogoSkuDetails> list) {
        int i = 0;
        if (list == null) {
            i = 0;
        } else {
            i = p.c0(list, getBestValueProduct(list));
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> getClickedOnSelectedBestValueCard() {
        return this.clickedOnSelectedBestValueCard;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getCustomersExperienceEnabled() {
        return this.remoteConfigService.R();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> getDiscountVisible() {
        return this.discountVisible;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ZendeskConfigurationInfo> getOnZendeskOpen() {
        return this.onZendeskOpen;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final app.dogo.com.dogo_android.k.n getPricePerPeriodType() {
        return this.remoteConfigService.H();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> getPurchaseUIState() {
        return this.purchaseUIState;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getPurchaseWasMade() {
        return this.purchaseWasMade;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<SubscriptionOffer>> getResult() {
        return this.result;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> getSelected() {
        return this.selected;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogoSkuDetails getSelectedSkuDetails(int i, List<DogoSkuDetails> list) {
        int i2 = 0;
        i2 = list == null ? 0 : (DogoSkuDetails)obj;
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> getShouldGoBack() {
        return this.shouldGoBack;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> getShowInfoDialog() {
        return this.showInfoDialog;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getShowResubscribeLayout() {
        return this.showResubscribeLayout;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<List<DogoSkuDetails>> getSkuList() {
        return this.skuList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<CouponTimer> getTimer() {
        return this.timer;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> getUserError() {
        return this.userError;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getUserTestimonialsSwitched() {
        return this.userTestimonialsSwitched;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getUserTestimonialsTracked() {
        return this.userTestimonialsTracked;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> isFreeTrailAvailable() {
        return this.isFreeTrailAvailable;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<Boolean>> isPurchaseRestored() {
        return this.isPurchaseRestored;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserNameSet() {
        UserAuthRecord userAuthRecord;
        boolean z2 = true;
        userAuthRecord = this.authService.A();
        int i = 1;
        int r1 = 0;
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.authService.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<CustomerExperience> listOfCustomerExperiences() {
        return this.getCustomerExperienceInteractor.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void loadOffers(SubscriptionOffer preloadedOffer) {
        h hVar3 = getSubscriptionOffers(preloadedOffer).o(new o(this)).F(a.a()).d0(a.a());
        n.e(hVar3, "getSubscriptionOffers(preloadedOffer)\n                .flatMap { setupDiscountTimerIfNeeded(it) }\n                .observeOn(Schedulers.computation())\n                .subscribeOn(Schedulers.computation())");
        getDisposable().b(a.e(hVar3, new SubscriptionViewModel.loadOffers.AnonymousClass2(this), new SubscriptionViewModel.loadOffers.AnonymousClass3(this), new SubscriptionViewModel.loadOffers.AnonymousClass4(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void makePurchase(Activity activity) {
        String priceCurrencyCode;
        int i = 0;
        n.f(activity, "activity");
        Object value = this.selected.getValue();
        if (value != null) {
            this.purchaseUIState.postValue(LoadResult_Loading.a);
            app.dogo.com.dogo_android.subscription.DogoSkuDetails selectedSkuDetails = getSelectedSkuDetails(value.intValue(), (List)this.skuList.getValue());
            if (selectedSkuDetails != null) {
                priceCurrencyCode = "";
                if (this.preferenceService.G() == null) {
                }
                String price = selectedSkuDetails.getPrice();
                i = 0;
                if (price != null) {
                    Double d = l.j(price);
                    if (d != null) {
                        double value4 = d.doubleValue();
                    }
                }
                if (selectedSkuDetails.getPriceCurrencyCode() == null) {
                }
                this.tracker.logEvent(E_Subscription.a.withParameters(u.a(new EP_AffiliateSource(), priceCurrencyCode), u.a(new EP_ViewSource(), this.viewSource), u.a(new EP_SkuId(), selectedSkuDetails.getSku()), u.a(new EP_Price(), Double.valueOf(i)), u.a(new EP_CurrencyCode(), priceCurrencyCode)));
                this.purchases.setAppsflyerID(AppsFlyerLib.getInstance().getAppsFlyerUID(activity));
                if (selectedSkuDetails.getOriginalJson() == null) {
                }
                SkuDetails skuDetails = new SkuDetails(priceCurrencyCode);
                Package obj = new Package(selectedSkuDetails.getIdentifier(), findPackageType(selectedSkuDetails.getIdentifier()), skuDetails, priceCurrencyCode);
                ListenerConversionsKt.purchasePackageWith(this.purchases, activity, obj, new SubscriptionViewModel.makePurchase.AnonymousClass1.AnonymousClass1(this), new SubscriptionViewModel.makePurchase.AnonymousClass1.AnonymousClass2(this, selectedSkuDetails));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void onSkuSelected(int position) {
        this.selected.postValue(Integer.valueOf(position));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void setAllPlansTracked(boolean z) {
        this.allPlansTracked = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void setPurchaseWasMade(boolean z) {
        this.purchaseWasMade = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void setUserTestimonialsSwitched(boolean z) {
        this.userTestimonialsSwitched = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void setUserTestimonialsTracked(boolean z) {
        this.userTestimonialsTracked = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackAllPlansShowedOnce() {
        this.tracker.logEvent(E_Subscription.f);
        this.allPlansTracked = true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackCloseIfNeeded() {
        this.preferenceService.r1(this.preferenceService.Z() + 1);
        int i2 = 4;
        if (this.preferenceService.Z() == 4) {
            this.tracker.logEvent(E_Subscription.i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackTestimonialsShowedOnce() {
        this.tracker.logEvent(E_Subscription.g);
        this.userTestimonialsTracked = true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackTestimonialsSwitchedOnce() {
        if (!this.userTestimonialsSwitched) {
            this.tracker.logEvent(E_Subscription.h);
            boolean userTestimonialsSwitched2 = true;
            this.userTestimonialsSwitched = userTestimonialsSwitched2;
        }
    }

    public static /* synthetic */ void openZendeskScreen$default(SubscriptionViewModel subscriptionViewModel, boolean z, boolean z2, int i, Object object) {
        boolean z4;
        i = 0;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        subscriptionViewModel.openZendeskScreen(z, z4);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void openZendeskScreen(boolean z, boolean z2) {
        openZendeskScreen(p.g(), z, z2);
    }

    static {
        SubscriptionViewModel.INSTANCE = new SubscriptionViewModel_Companion(null);
    }

    public static /* synthetic */ ZendeskConfigurationInfo h(SubscriptionViewModel subscriptionViewModel, List list, boolean z, boolean z2, DogProfile dogProfile, Boolean boolean) {
        return SubscriptionViewModel.fetchDataAndOpenZendeskScreen$lambda_7(subscriptionViewModel, list, z, z2, dogProfile, boolean);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static /* synthetic */ m.c.a getSelectedSkuDetails(SubscriptionViewModel selected, SubscriptionOffer list) {
        return SubscriptionViewModel.loadOffers$lambda_0(selected, list);
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static /* synthetic */ boolean openZendeskScreen(SubscriptionViewModel hasRequestHistory, long hasUnreadMessages) {
        return SubscriptionViewModel.setupDiscountTimerIfNeeded$lambda_2(hasRequestHistory, hasUnreadMessages);
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static /* synthetic */ g0 trackPurchaseError(SubscriptionViewModel error, Throwable isUserCancelled) {
        return SubscriptionViewModel.getSubscriptionOffers$lambda_1(error, isUserCancelled);
    }
}
