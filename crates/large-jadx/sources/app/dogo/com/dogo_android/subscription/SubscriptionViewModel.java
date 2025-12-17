package app.dogo.com.dogo_android.subscription;

import android.app.Activity;
import android.app.ActivityManager.ProcessErrorStateInfo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.n;
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
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.subscription.benefits.RxJavaDogo;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.d2;
import app.dogo.com.dogo_android.w.e1;
import app.dogo.com.dogo_android.w.g2;
import app.dogo.com.dogo_android.w.j1;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.a;
import app.dogo.com.dogo_android.w.r2;
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
import f.d.a.a;
import i.b.a0;
import i.b.g0;
import i.b.h;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.p;
import m.c.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010Z\u001a\u00020\u0005J\u0016\u0010[\u001a\u00020\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0018\u0010^\u001a\u0004\u0018\u00010\u00032\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0008\u0010_\u001a\u00020\\H\u0002J,\u0010`\u001a\u00020\\2\u000e\u0008\u0002\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\u00030I2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005H\u0002J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0003H\u0002J\u0018\u0010g\u001a\u0004\u0018\u00010J2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0016\u0010h\u001a\u00020A2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0006\u0010i\u001a\u00020jJ\u0017\u0010k\u001a\u00020l2\u0008\u0010m\u001a\u0004\u0018\u00010lH\u0002¢\u0006\u0002\u0010nJ$\u0010o\u001a\u0004\u0018\u00010\u00032\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0008\u0010p\u001a\u0004\u0018\u00010JH\u0002J \u0010q\u001a\u0004\u0018\u00010J2\u0006\u0010@\u001a\u00020A2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0018\u0010r\u001a\u0008\u0012\u0004\u0012\u00020\"0s2\u0008\u0010t\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010u\u001a\u00020\\2\u0006\u0010v\u001a\u00020wH\u0002J\u0017\u0010x\u001a\u00020\u00052\u0008\u0010m\u001a\u0004\u0018\u00010lH\u0002¢\u0006\u0002\u0010yJ\u0006\u0010z\u001a\u00020\u0005J\u0006\u0010{\u001a\u00020\u0005J\u000c\u0010|\u001a\u0008\u0012\u0004\u0012\u00020}0IJ\u0012\u0010~\u001a\u00020\\2\n\u0008\u0002\u0010\u007f\u001a\u0004\u0018\u00010\"J\u0011\u0010\u0080\u0001\u001a\u00020\\2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0010\u0010\u0083\u0001\u001a\u00020\\2\u0007\u0010\u0084\u0001\u001a\u00020AJ\u001b\u0010\u0085\u0001\u001a\u00020\\2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005J-\u0010\u0085\u0001\u001a\u00020\\2\u000e\u0008\u0002\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\u00030I2\u0008\u0008\u0002\u0010b\u001a\u00020\u00052\u0008\u0008\u0002\u0010c\u001a\u00020\u0005H\u0002J\t\u0010\u0086\u0001\u001a\u00020\\H\u0002J\u0018\u0010\u0087\u0001\u001a\u0008\u0012\u0004\u0012\u00020l0s2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J\u0007\u0010\u0089\u0001\u001a\u00020\\J\u0007\u0010\u008a\u0001\u001a\u00020\\J\u001a\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010v\u001a\u00020w2\u0007\u0010\u008c\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010\u008d\u0001\u001a\u00020\\J\u0007\u0010\u008e\u0001\u001a\u00020\\R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\"0!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00050)¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008-\u0010%R\u0017\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u00101\u001a\u0010\u0012\u000c\u0012\n 2*\u0004\u0018\u00010\u00050\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00100R\u001d\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0)¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010+R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u0002050)¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010+R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00100R\u001a\u00109\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010%\"\u0004\u0008;\u0010'R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\"0!0=¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u001f\u0010@\u001a\u0010\u0012\u000c\u0012\n 2*\u0004\u0018\u00010A0A0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u00100R\u0017\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00050)¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010+R\u001d\u0010E\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010%R\u001d\u0010H\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020J0I0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008K\u00100R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\u0008\u0012\u0004\u0012\u00020O0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u00100R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020R0)¢\u0006\u0008\n\u0000\u001a\u0004\u0008S\u0010+R\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008U\u0010%\"\u0004\u0008V\u0010'R\u001a\u0010W\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008X\u0010%\"\u0004\u0008Y\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "viewSource", "", "showResubscribeLayout", "", "repository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getCustomerExperienceInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetCustomerExperienceInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getSubscriptionOffersInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "(Ljava/lang/String;ZLapp/dogo/com/dogo_android/subscription/BillingRepository;Lcom/revenuecat/purchases/Purchases;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/GetCustomerExperienceInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/interactor/GetSubscriptionOffersInteractor;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "allPlansTracked", "getAllPlansTracked", "()Z", "setAllPlansTracked", "(Z)V", "clickedOnSelectedBestValueCard", "Lcom/hadilq/liveevent/LiveEvent;", "getClickedOnSelectedBestValueCard", "()Lcom/hadilq/liveevent/LiveEvent;", "customersExperienceEnabled", "getCustomersExperienceEnabled", "discountVisible", "getDiscountVisible", "()Landroidx/lifecycle/MutableLiveData;", "isFreeTrailAvailable", "kotlin.jvm.PlatformType", "isPurchaseRestored", "onZendeskOpen", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getOnZendeskOpen", "purchaseUIState", "getPurchaseUIState", "purchaseWasMade", "getPurchaseWasMade", "setPurchaseWasMade", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "selected", "", "getSelected", "shouldGoBack", "getShouldGoBack", "showInfoDialog", "getShowInfoDialog", "getShowResubscribeLayout", "skuList", "", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "getSkuList", "tick", "Ljava/util/concurrent/atomic/AtomicLong;", "timer", "Lapp/dogo/com/dogo_android/repository/domain/CouponTimer;", "getTimer", "userError", "", "getUserError", "userTestimonialsSwitched", "getUserTestimonialsSwitched", "setUserTestimonialsSwitched", "userTestimonialsTracked", "getUserTestimonialsTracked", "setUserTestimonialsTracked", "allPlansTopEnabled", "bestValueItemSelected", "", "list", "bestValueSavingsPercentString", "doubleCheckRevenueCatCache", "fetchDataAndOpenZendeskScreen", "customTags", "hasRequestHistory", "hasUnreadMessages", "findPackageType", "Lcom/revenuecat/purchases/PackageType;", "value", "getBestValueProduct", "getBestValueSelectedNumber", "getPricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "getRemainingCouponDurationMs", "", "endTimeMs", "(Ljava/lang/Long;)J", "getSavingsPercentString", "sku", "getSelectedSkuDetails", "getSubscriptionOffers", "Lio/reactivex/Flowable;", "preloadedOffers", "handleRecoverableRevenueCatError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "isDiscountStillValid", "(Ljava/lang/Long;)Z", "isUserNameSet", "isUserSignedIn", "listOfCustomerExperiences", "Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "loadOffers", "preloadedOffer", "makePurchase", "activity", "Landroid/app/Activity;", "onSkuSelected", "position", "openZendeskScreen", "restorePurchase", "setupDiscountTimerIfNeeded", "offer", "trackAllPlansShowedOnce", "trackCloseIfNeeded", "trackPurchaseError", "isUserCancelled", "trackTestimonialsShowedOnce", "trackTestimonialsSwitchedOnce", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionViewModel extends s {

    public static final app.dogo.com.dogo_android.subscription.SubscriptionViewModel.Companion Companion = null;
    public static final String INDIA_LOCATION_CODE = "in";
    private final x<y<SubscriptionOffer>> _result;
    private boolean allPlansTracked;
    private final h2 authService;
    private final a<Boolean> clickedOnSelectedBestValueCard;
    private final b2 couponNotificationInteractor;
    private final x<Boolean> discountVisible;
    private final j2 getCustomerExperienceInteractor;
    private final a3 getSubscriptionOffersInteractor;
    private final d3 isDogPremiumInteractor;
    private final x<Boolean> isFreeTrailAvailable;
    private final a<y<Boolean>> isPurchaseRestored;
    private final a<ZendeskConfigurationInfo> onZendeskOpen;
    private final p2 preferenceService;
    private final x<y<Boolean>> purchaseUIState;
    private boolean purchaseWasMade;
    private final Purchases purchases;
    private final r2 remoteConfigService;
    private final app.dogo.com.dogo_android.subscription.BillingRepository repository;
    private final LiveData<y<SubscriptionOffer>> result;
    private final x<Integer> selected;
    private final a<Boolean> shouldGoBack;
    private final a<y<Boolean>> showInfoDialog;
    private final boolean showResubscribeLayout;
    private final x<List<app.dogo.com.dogo_android.subscription.DogoSkuDetails>> skuList;
    private final n3 subscribeInteractor;
    private final AtomicLong tick;
    private final v2 timeUtils;
    private final x<CouponTimer> timer;
    private final o3 tracker;
    private final a<Throwable> userError;
    private boolean userTestimonialsSwitched;
    private boolean userTestimonialsTracked;
    private final String viewSource;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel$Companion;", "", "()V", "INDIA_LOCATION_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
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
    static {
        SubscriptionViewModel.Companion companion = new SubscriptionViewModel.Companion(0);
        SubscriptionViewModel.Companion = companion;
    }

    public SubscriptionViewModel(String string, boolean z2, app.dogo.com.dogo_android.subscription.BillingRepository billingRepository3, Purchases purchases4, p2 p25, o3 o36, b2 b27, v2 v28, r2 r29, j2 j210, h2 h211, a3 a312, n3 n313, d3 d314) {
        n.f(string, "viewSource");
        n.f(billingRepository3, "repository");
        n.f(purchases4, "purchases");
        n.f(p25, "preferenceService");
        n.f(o36, "tracker");
        n.f(b27, "couponNotificationInteractor");
        n.f(v28, "timeUtils");
        n.f(r29, "remoteConfigService");
        n.f(j210, "getCustomerExperienceInteractor");
        n.f(h211, "authService");
        n.f(a312, "getSubscriptionOffersInteractor");
        n.f(n313, "subscribeInteractor");
        n.f(d314, "isDogPremiumInteractor");
        super();
        this.viewSource = string;
        this.showResubscribeLayout = z2;
        this.repository = billingRepository3;
        this.purchases = purchases4;
        this.preferenceService = p25;
        this.tracker = o36;
        this.couponNotificationInteractor = b27;
        this.timeUtils = v28;
        this.remoteConfigService = r29;
        this.getCustomerExperienceInteractor = j210;
        this.authService = h211;
        this.getSubscriptionOffersInteractor = a312;
        this.subscribeInteractor = n313;
        this.isDogPremiumInteractor = d314;
        a obj2 = new a();
        this.shouldGoBack = obj2;
        obj2 = new x();
        this._result = obj2;
        this.result = obj2;
        obj2 = new x();
        this.skuList = obj2;
        obj2 = new a();
        this.userError = obj2;
        obj2 = new x(2);
        this.selected = obj2;
        obj2 = new a();
        this.clickedOnSelectedBestValueCard = obj2;
        Boolean obj3 = Boolean.FALSE;
        obj2 = new x(obj3);
        this.isFreeTrailAvailable = obj2;
        obj2 = new x();
        this.purchaseUIState = obj2;
        obj2 = new AtomicLong(0, purchases4);
        this.tick = obj2;
        obj2 = new x();
        this.timer = obj2;
        obj2 = new x(obj3);
        this.discountVisible = obj2;
        obj2 = new a();
        this.isPurchaseRestored = obj2;
        obj2 = new a();
        this.showInfoDialog = obj2;
        obj2 = new a();
        this.onZendeskOpen = obj2;
    }

    public static final void access$doubleCheckRevenueCatCache(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        subscriptionViewModel.doubleCheckRevenueCatCache();
    }

    public static final h2 access$getAuthService$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.authService;
    }

    public static final b2 access$getCouponNotificationInteractor$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.couponNotificationInteractor;
    }

    public static final Purchases access$getPurchases$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.purchases;
    }

    public static final app.dogo.com.dogo_android.subscription.BillingRepository access$getRepository$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.repository;
    }

    public static final AtomicLong access$getTick$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.tick;
    }

    public static final o3 access$getTracker$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.tracker;
    }

    public static final String access$getViewSource$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel.viewSource;
    }

    public static final x access$get_result$p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        return subscriptionViewModel._result;
    }

    public static final void access$handleRecoverableRevenueCatError(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, PurchasesError purchasesError2) {
        subscriptionViewModel.handleRecoverableRevenueCatError(purchasesError2);
    }

    public static final void access$trackPurchaseError(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, PurchasesError purchasesError2, boolean z3) {
        subscriptionViewModel.trackPurchaseError(purchasesError2, z3);
    }

    private final void doubleCheckRevenueCatCache() {
        SubscriptionViewModel.doubleCheckRevenueCatCache.1 anon = new SubscriptionViewModel.doubleCheckRevenueCatCache.1(this);
        final int i = 0;
        ListenerConversionsKt.getPurchaserInfoWith$default(this.purchases, i, anon, 1, i);
    }

    private final void fetchDataAndOpenZendeskScreen(List<String> list, boolean z2, boolean z3) {
        int i = 0;
        n nVar = new n(this, list, z2, z3);
        a0 obj6 = a0.zip(App.Companion.s().w(), d3.b(this.isDogPremiumInteractor, i, 1, i), nVar).observeOn(a.b()).subscribeOn(a.b());
        n.e(obj6, "zip(\n                    userRepository.getCurrentDogProfile(),\n                    isDogPremiumInteractor.isCurrentDogPremium()\n                ) { dogProfile, isPremium ->\n                    ZendeskConfigurationInfo(\n                        userId = authService.currentUserId,\n                        dogProfile = dogProfile,\n                        isDogPremium = isPremium,\n                        customTags = customTags,\n                        isUserLoggedIn = authService.isUserSignedIn,\n                        hasUnreadMessages = hasUnreadMessages,\n                        hasRequestHistory = hasRequestHistory,\n                        isHelpCenterEnabled = remoteConfigService.isHelpCenterEnabled(preferenceService.selectedLocale)\n                    )\n                }\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        SubscriptionViewModel.fetchDataAndOpenZendeskScreen.2 obj7 = new SubscriptionViewModel.fetchDataAndOpenZendeskScreen.2(this);
        SubscriptionViewModel.fetchDataAndOpenZendeskScreen.3 obj8 = new SubscriptionViewModel.fetchDataAndOpenZendeskScreen.3(this);
        getDisposable().b(a.g(obj6, obj7, obj8));
    }

    static void fetchDataAndOpenZendeskScreen$default(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, List list2, boolean z3, boolean z4, int i5, Object object6) {
        List obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = p.g();
        }
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        subscriptionViewModel.fetchDataAndOpenZendeskScreen(obj2, obj3, obj4);
    }

    private static final ZendeskConfigurationInfo fetchDataAndOpenZendeskScreen$lambda-7(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, List list2, boolean z3, boolean z4, DogProfile dogProfile5, Boolean boolean6) {
        n.f(subscriptionViewModel, "this$0");
        n.f(list2, "$customTags");
        n.f(dogProfile5, "dogProfile");
        n.f(boolean6, "isPremium");
        super(subscriptionViewModel.authService.v(), boolean6, dogProfile5, list2, subscriptionViewModel.remoteConfigService.U(subscriptionViewModel.preferenceService.W()), subscriptionViewModel.authService.D(), z3, z4);
        return obj10;
    }

    private final PackageType findPackageType(String string) {
        PackageType[] values;
        int length;
        int i2;
        int i;
        PackageType uNKNOWN;
        boolean z;
        Object obj8;
        values = PackageType.values();
        final int i3 = 0;
        i2 = i3;
        i = 0;
        while (i2 < values.length) {
            i2++;
            i = 0;
        }
        uNKNOWN = i;
        if (uNKNOWN == null) {
            uNKNOWN = l.M(string, "$rc_", i3, 2, i) ? PackageType.UNKNOWN : PackageType.CUSTOM;
        }
        return uNKNOWN;
    }

    private final long getRemainingCouponDurationMs(Long long) {
        int longValue;
        if (long == null) {
            longValue = 0;
        } else {
            longValue = long.longValue();
        }
        return longValue -= l;
    }

    private final String getSavingsPercentString(List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list, app.dogo.com.dogo_android.subscription.DogoSkuDetails dogoSkuDetails2) {
        int string;
        Object next;
        int i;
        double doubleValue2;
        int doubleValue;
        boolean next2;
        double doubleValue3;
        int compare;
        double obj11;
        app.dogo.com.dogo_android.subscription.DogoSkuDetails obj12;
        if (list != null && dogoSkuDetails2 != null) {
            if (dogoSkuDetails2 != null) {
                obj11 = list.iterator();
                doubleValue2 = 0;
                if (!obj11.hasNext()) {
                    next = string;
                } else {
                    if (!obj11.hasNext()) {
                    } else {
                        Double num = j1.E((DogoSkuDetails)obj11.next());
                        if (num == null) {
                            doubleValue = doubleValue2;
                        } else {
                            doubleValue = num.doubleValue();
                        }
                        Object next4 = obj11.next();
                        Double num2 = j1.E((DogoSkuDetails)next4);
                        do {
                            next4 = obj11.next();
                            num2 = j1.E((DogoSkuDetails)next4);
                            doubleValue3 = num2.doubleValue();
                            if (Double.compare(doubleValue, obj5) < 0) {
                            }
                            if (obj11.hasNext()) {
                            }
                            next = next4;
                            doubleValue = doubleValue3;
                            doubleValue3 = doubleValue2;
                        } while (num2 == null);
                    }
                }
                obj11 = j1.E(dogoSkuDetails2);
                if (obj11 == null) {
                    obj11 = doubleValue2;
                } else {
                    obj11 = obj11.doubleValue();
                }
                if ((DogoSkuDetails)next == 0) {
                } else {
                    next = j1.E((DogoSkuDetails)next);
                    if (next == null) {
                    } else {
                        doubleValue2 = next.doubleValue();
                    }
                }
                double d = (double)i;
                d -= obj11;
                if (a.a(doubleValue) == 0) {
                } else {
                    obj11 = new StringBuilder();
                    obj11.append(a.a(doubleValue));
                    obj11.append('%');
                    string = obj11.toString();
                }
            }
        }
        return string;
    }

    private final h<SubscriptionOffer> getSubscriptionOffers(SubscriptionOffer subscriptionOffer) {
        String str;
        h obj2;
        if (subscriptionOffer != null) {
            n.e(h.C(subscriptionOffer), "{\n            Flowable.just(preloadedOffers)\n        }");
        } else {
            q qVar = new q(this);
            n.e(this.getSubscriptionOffersInteractor.a().onErrorResumeNext(qVar).toFlowable().F(a.b()), "{\n            getSubscriptionOffersInteractor.getSubscriptionOffers()\n                .onErrorResumeNext {\n                    if (it is CouponExceptions.AlreadyPremium) {\n                        shouldGoBack.postValue(true)\n                    }\n                    throw it\n                }\n                .toFlowable()\n                .observeOn(Schedulers.io())\n        }");
        }
        return obj2;
    }

    private static final g0 getSubscriptionOffers$lambda-1(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, Throwable throwable2) {
        boolean tRUE;
        Object obj1;
        n.f(subscriptionViewModel, "this$0");
        n.f(throwable2, "it");
        if (!throwable2 instanceof CouponExceptions.AlreadyPremium) {
        } else {
            subscriptionViewModel.getShouldGoBack().postValue(Boolean.TRUE);
        }
        throw throwable2;
    }

    public static ZendeskConfigurationInfo h(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, List list2, boolean z3, boolean z4, DogProfile dogProfile5, Boolean boolean6) {
        return SubscriptionViewModel.fetchDataAndOpenZendeskScreen$lambda-7(subscriptionViewModel, list2, z3, z4, dogProfile5, boolean6);
    }

    private final void handleRecoverableRevenueCatError(PurchasesError purchasesError) {
        boolean showInfoDialog;
        Object aVar;
        int exception;
        Object obj4;
        PurchasesErrorCode[] arr = new PurchasesErrorCode[5];
        if (i.t(arr, purchasesError.getCode())) {
            exception = new Exception(String.valueOf(purchasesError));
            aVar = new y.a(exception);
            this.showInfoDialog.postValue(aVar);
            restorePurchase();
        }
    }

    public static a i(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, SubscriptionOffer subscriptionOffer2) {
        return SubscriptionViewModel.loadOffers$lambda-0(subscriptionViewModel, subscriptionOffer2);
    }

    private final boolean isDiscountStillValid(Long long) {
        int longValue;
        int obj5;
        if (long == null) {
            longValue = 0;
        } else {
            longValue = long.longValue();
        }
        obj5 = Long.compare(l, longValue) < 0 ? 1 : 0;
        return obj5;
    }

    public static boolean j(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, long l2) {
        return SubscriptionViewModel.setupDiscountTimerIfNeeded$lambda-2(subscriptionViewModel, l2);
    }

    public static g0 k(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, Throwable throwable2) {
        return SubscriptionViewModel.getSubscriptionOffers$lambda-1(subscriptionViewModel, throwable2);
    }

    public static void loadOffers$default(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, SubscriptionOffer subscriptionOffer2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        subscriptionViewModel.loadOffers(obj1);
    }

    private static final a loadOffers$lambda-0(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, SubscriptionOffer subscriptionOffer2) {
        n.f(subscriptionViewModel, "this$0");
        n.f(subscriptionOffer2, "it");
        return subscriptionViewModel.setupDiscountTimerIfNeeded(subscriptionOffer2);
    }

    private final void openZendeskScreen(List<String> list, boolean z2, boolean z3) {
        fetchDataAndOpenZendeskScreen(list, z2, z3);
    }

    static void openZendeskScreen$default(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, List list2, boolean z3, boolean z4, int i5, Object object6) {
        List obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = p.g();
        }
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        subscriptionViewModel.openZendeskScreen(obj2, obj3, obj4);
    }

    public static void openZendeskScreen$default(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, boolean z2, boolean z3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 1 != 0) {
            obj2 = i;
        }
        if (i4 &= 2 != 0) {
            obj3 = i;
        }
        subscriptionViewModel.openZendeskScreen(obj2, obj3);
    }

    private final void restorePurchase() {
        this.isPurchaseRestored.postValue(y.b.a);
        a0 subscribeOn = this.subscribeInteractor.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "subscribeInteractor.restorePurchase()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        SubscriptionViewModel.restorePurchase.1 anon = new SubscriptionViewModel.restorePurchase.1(this);
        SubscriptionViewModel.restorePurchase.2 anon2 = new SubscriptionViewModel.restorePurchase.2(this);
        getDisposable().b(a.g(subscribeOn, anon, anon2));
    }

    private final h<Long> setupDiscountTimerIfNeeded(SubscriptionOffer subscriptionOffer) {
        boolean freeTrailAvailable;
        int i;
        String str;
        Object valueOf;
        app.dogo.com.dogo_android.subscription.p pVar;
        CouponTimer couponTimer;
        Long obj6;
        y.c cVar = new y.c(subscriptionOffer);
        this._result.postValue(cVar);
        this.skuList.postValue(subscriptionOffer.getList());
        this.selected.postValue(Integer.valueOf(getBestValueSelectedNumber(subscriptionOffer.getList())));
        if (subscriptionOffer.isFreeTrailAvailable() && !n.b(this.remoteConfigService.v(), "in")) {
            i = !n.b(this.remoteConfigService.v(), "in") ? 1 : 0;
        } else {
        }
        x isFreeTrailAvailable = this.isFreeTrailAvailable;
        isFreeTrailAvailable.postValue(Boolean.valueOf(i));
        obj6 = subscriptionOffer.getCoupon();
        if (obj6 == null) {
            obj6 = 0;
        } else {
            obj6 = obj6.getEndTimeMs();
        }
        if (isDiscountStillValid(obj6)) {
            long l = (long)obj6;
            remainingCouponDurationMs /= l;
            couponTimer = new CouponTimer(l *= i2, obj3);
            this.timer.postValue(couponTimer);
            this.discountVisible.postValue(Boolean.TRUE);
            pVar = new p(this, i2, isFreeTrailAvailable);
            n.e(RxJavaDogo.INSTANCE.timerWithStart(i2).repeatUntil(pVar), "{\n            val durationInSeconds = getRemainingCouponDurationMs(absoluteEndTimeMs) / 1000\n            timer.postValue(CouponTimer(durationInSeconds * 1000))\n            discountVisible.postValue(true)\n            RxJavaDogo.timerWithStart(durationInSeconds)\n                .repeatUntil { tick.get() >= durationInSeconds }\n        }");
        } else {
            n.e(h.l(), "{\n            Flowable.empty()\n        }");
        }
        return obj6;
    }

    private static final boolean setupDiscountTimerIfNeeded$lambda-2(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, long l2) {
        int obj2;
        n.f(subscriptionViewModel, "this$0");
        obj2 = Long.compare(l, l2) >= 0 ? 1 : 0;
        return obj2;
    }

    private final void trackPurchaseError(PurchasesError purchasesError, boolean z2) {
        Exception obj8;
        t0 t0Var = new t0();
        r2 r2Var = new r2();
        j1 j1Var = new j1();
        k1 k1Var = new k1();
        this.tracker.d(o0.c.b(u.a(t0Var, this.preferenceService.G()), u.a(r2Var, this.viewSource), u.a(j1Var, purchasesError.getCode().getDescription()), u.a(k1Var, purchasesError.getUnderlyingErrorMessage())));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(purchasesError);
        stringBuilder.append(", userCancelled ");
        stringBuilder.append(z2);
        String obj9 = stringBuilder.toString();
        switch (obj8) {
            case 1:
                obj8 = new Exception(obj9);
                break;
            case 2:
                obj8 = new Exception(obj9);
                break;
            case 3:
                obj8 = new Exception(obj9);
                break;
            case 4:
                obj8 = new Exception(obj9);
                break;
            case 5:
                obj8 = new Exception(obj9);
                break;
            case 6:
                obj8 = new Exception(obj9);
                break;
            case 7:
                obj8 = new Exception(obj9);
                break;
            case 8:
                obj8 = new Exception(obj9);
                break;
            case 9:
                obj8 = new Exception(obj9);
                break;
            case 10:
                obj8 = new Exception(obj9);
                break;
            case 11:
                obj8 = new Exception(obj9);
                break;
            case 12:
                obj8 = new Exception(obj9);
                break;
            case 13:
                obj8 = new Exception(obj9);
                break;
            case 14:
                obj8 = new Exception(obj9);
                break;
            case 15:
                obj8 = new Exception(obj9);
                break;
            case 16:
                obj8 = new Exception(obj9);
                break;
            case 17:
                obj8 = new Exception(obj9);
                break;
            case 18:
                obj8 = new Exception(obj9);
                break;
            case 19:
                obj8 = new Exception(obj9);
                break;
            case 20:
                obj8 = new Exception(obj9);
                break;
            case 21:
                obj8 = new Exception(obj9);
                break;
            case 22:
                obj8 = new Exception(obj9);
                break;
            case 23:
                obj8 = new Exception(obj9);
                break;
            case 24:
                obj8 = new Exception(obj9);
                break;
            default:
                obj8 = new NoWhenBranchMatchedException();
                throw obj8;
        }
        o3.Companion.a(obj8);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean allPlansTopEnabled() {
        return this.remoteConfigService.f0();
    }

    public final void bestValueItemSelected(List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list) {
        Object intValue;
        Object tRUE;
        Object obj2;
        obj2 = getBestValueSelectedNumber(list);
        intValue = this.selected.getValue();
        if ((Integer)intValue == null) {
            this.selected.postValue(Integer.valueOf(obj2));
        } else {
            if ((Integer)intValue.intValue() != obj2) {
            } else {
                this.clickedOnSelectedBestValueCard.postValue(Boolean.TRUE);
            }
        }
    }

    public final String bestValueSavingsPercentString(List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list) {
        return getSavingsPercentString(list, getBestValueProduct(list));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getAllPlansTracked() {
        return this.allPlansTracked;
    }

    public final app.dogo.com.dogo_android.subscription.DogoSkuDetails getBestValueProduct(List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list) {
        Object next2;
        Double next;
        long l;
        long doubleValue2;
        double doubleValue;
        int compare;
        Iterator obj10;
        next2 = 0;
        if (list == null) {
        } else {
            obj10 = list.iterator();
            if (!obj10.hasNext()) {
            } else {
                if (!obj10.hasNext()) {
                } else {
                    next = j1.E((DogoSkuDetails)obj10.next());
                    l = 9218868437227405311L;
                    if (next == null) {
                        doubleValue2 = l;
                    } else {
                        doubleValue2 = next.doubleValue();
                    }
                    Object next3 = obj10.next();
                    Double num = j1.E((DogoSkuDetails)next3);
                    do {
                        next3 = obj10.next();
                        num = j1.E((DogoSkuDetails)next3);
                        doubleValue = num.doubleValue();
                        if (Double.compare(doubleValue2, obj5) > 0) {
                        }
                        if (obj10.hasNext()) {
                        }
                        next2 = next3;
                        doubleValue2 = doubleValue;
                        doubleValue = l;
                    } while (num == null);
                }
            }
        }
        return next2;
    }

    public final int getBestValueSelectedNumber(List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list) {
        int obj2;
        if (list == null) {
            obj2 = 0;
        } else {
            obj2 = p.c0(list, getBestValueProduct(list));
        }
        return obj2;
    }

    public final a<Boolean> getClickedOnSelectedBestValueCard() {
        return this.clickedOnSelectedBestValueCard;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getCustomersExperienceEnabled() {
        return this.remoteConfigService.R();
    }

    public final x<Boolean> getDiscountVisible() {
        return this.discountVisible;
    }

    public final a<ZendeskConfigurationInfo> getOnZendeskOpen() {
        return this.onZendeskOpen;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final n getPricePerPeriodType() {
        return this.remoteConfigService.H();
    }

    public final x<y<Boolean>> getPurchaseUIState() {
        return this.purchaseUIState;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getPurchaseWasMade() {
        return this.purchaseWasMade;
    }

    public final LiveData<y<SubscriptionOffer>> getResult() {
        return this.result;
    }

    public final x<Integer> getSelected() {
        return this.selected;
    }

    public final app.dogo.com.dogo_android.subscription.DogoSkuDetails getSelectedSkuDetails(int i, List<app.dogo.com.dogo_android.subscription.DogoSkuDetails> list2) {
        int obj1;
        if (list2 == null) {
            obj1 = 0;
        } else {
            obj1 = p.a0(list2, i);
        }
        return obj1;
    }

    public final a<Boolean> getShouldGoBack() {
        return this.shouldGoBack;
    }

    public final a<y<Boolean>> getShowInfoDialog() {
        return this.showInfoDialog;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean getShowResubscribeLayout() {
        return this.showResubscribeLayout;
    }

    public final x<List<app.dogo.com.dogo_android.subscription.DogoSkuDetails>> getSkuList() {
        return this.skuList;
    }

    public final x<CouponTimer> getTimer() {
        return this.timer;
    }

    public final a<Throwable> getUserError() {
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

    public final x<Boolean> isFreeTrailAvailable() {
        return this.isFreeTrailAvailable;
    }

    public final a<y<Boolean>> isPurchaseRestored() {
        return this.isPurchaseRestored;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserNameSet() {
        UserAuthRecord displayName;
        int i;
        displayName = this.authService.A();
        i = 1;
        if (displayName == null) {
            i = i2;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.authService.D();
    }

    public final List<CustomerExperience> listOfCustomerExperiences() {
        return this.getCustomerExperienceInteractor.a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void loadOffers(SubscriptionOffer subscriptionOffer) {
        o oVar = new o(this);
        h obj5 = getSubscriptionOffers(subscriptionOffer).o(oVar).F(a.a()).d0(a.a());
        n.e(obj5, "getSubscriptionOffers(preloadedOffer)\n                .flatMap { setupDiscountTimerIfNeeded(it) }\n                .observeOn(Schedulers.computation())\n                .subscribeOn(Schedulers.computation())");
        SubscriptionViewModel.loadOffers.2 anon = new SubscriptionViewModel.loadOffers.2(this);
        SubscriptionViewModel.loadOffers.3 anon2 = new SubscriptionViewModel.loadOffers.3(this);
        SubscriptionViewModel.loadOffers.4 anon3 = new SubscriptionViewModel.loadOffers.4(this);
        getDisposable().b(a.e(obj5, anon, anon2, anon3));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void makePurchase(Activity activity) {
        Object selectedSkuDetails;
        Object purchases;
        Object obj;
        app.dogo.com.dogo_android.subscription.SubscriptionViewModel.makePurchase.1.1 anon2;
        String str;
        app.dogo.com.dogo_android.subscription.SubscriptionViewModel.makePurchase.1.2 anon;
        SkuDetails skuDetails;
        String originalJson;
        Object price;
        kotlin.o oVar;
        String str2;
        int doubleValue;
        String priceCurrencyCode;
        n.f(activity, "activity");
        selectedSkuDetails = this.selected.getValue();
        if ((Integer)selectedSkuDetails != null) {
            this.purchaseUIState.postValue(y.b.a);
            selectedSkuDetails = getSelectedSkuDetails((Integer)selectedSkuDetails.intValue(), (List)this.skuList.getValue());
            if (selectedSkuDetails == null) {
            } else {
                t0 t0Var = new t0();
                str2 = "";
                if (this.preferenceService.G() == null) {
                    str = str2;
                }
                r2 r2Var = new r2();
                g2 g2Var = new g2();
                d2 d2Var = new d2();
                price = selectedSkuDetails.getPrice();
                doubleValue = 0;
                if (price == null) {
                } else {
                    price = l.j(price);
                    if (price == null) {
                    } else {
                        doubleValue = price.doubleValue();
                    }
                }
                e1 e1Var = new e1();
                if (selectedSkuDetails.getPriceCurrencyCode() == null) {
                    priceCurrencyCode = str2;
                }
                this.tracker.d(o0.a.c(u.a(t0Var, str), u.a(r2Var, this.viewSource), u.a(g2Var, selectedSkuDetails.getSku()), u.a(d2Var, Double.valueOf(doubleValue)), u.a(e1Var, priceCurrencyCode)));
                this.purchases.setAppsflyerID(AppsFlyerLib.getInstance().getAppsFlyerUID(activity));
                if (selectedSkuDetails.getOriginalJson() == null) {
                    originalJson = str2;
                }
                skuDetails = new SkuDetails(originalJson);
                obj = new Package(selectedSkuDetails.getIdentifier(), findPackageType(selectedSkuDetails.getIdentifier()), skuDetails, str2);
                anon2 = new SubscriptionViewModel.makePurchase.1.1(this);
                anon = new SubscriptionViewModel.makePurchase.1.2(this, selectedSkuDetails);
                ListenerConversionsKt.purchasePackageWith(this.purchases, activity, obj, anon2, anon);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void onSkuSelected(int i) {
        this.selected.postValue(Integer.valueOf(i));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void openZendeskScreen(boolean z, boolean z2) {
        openZendeskScreen(p.g(), z, z2);
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
        this.tracker.c(o0.f);
        this.allPlansTracked = true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackCloseIfNeeded() {
        int tracker;
        int i;
        p2 preferenceService = this.preferenceService;
        preferenceService.r1(i2++);
        if (preferenceService.Z() == 4) {
            this.tracker.c(o0.i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackTestimonialsShowedOnce() {
        this.tracker.c(o0.g);
        this.userTestimonialsTracked = true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void trackTestimonialsSwitchedOnce() {
        boolean userTestimonialsSwitched;
        app.dogo.com.dogo_android.w.t2 t2Var;
        if (!this.userTestimonialsSwitched) {
            this.tracker.c(o0.h);
            this.userTestimonialsSwitched = true;
        }
    }
}
