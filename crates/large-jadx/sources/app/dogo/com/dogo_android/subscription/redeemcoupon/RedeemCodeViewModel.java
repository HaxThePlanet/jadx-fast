package app.dogo.com.dogo_android.subscription.redeemcoupon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.s.a.b2;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.subscription.BillingRepository;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.exceptions.CouponExceptions.AlreadyPremium;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
import f.d.a.a;
import i.b.a0;
import i.b.g0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "_result", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "codeInput", "Landroidx/lifecycle/MutableLiveData;", "", "getCodeInput", "()Landroidx/lifecycle/MutableLiveData;", "openSubscription", "getOpenSubscription", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "tryToValidateAndSaveDiscount", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RedeemCodeViewModel extends s {

    private final a<y<Boolean>> _result;
    private final BillingRepository billingRepository;
    private final x<String> codeInput;
    private final j2 connectivityService;
    private final b2 couponNotificationInteractor;
    private final a<Boolean> openSubscription;
    private final LiveData<y<Boolean>> result;
    private final n3 subscribeInteractor;
    private final o3 tracker;
    public RedeemCodeViewModel(BillingRepository billingRepository, n3 n32, b2 b23, j2 j24, o3 o35) {
        n.f(billingRepository, "billingRepository");
        n.f(n32, "subscribeInteractor");
        n.f(b23, "couponNotificationInteractor");
        n.f(j24, "connectivityService");
        n.f(o35, "tracker");
        super();
        this.billingRepository = billingRepository;
        this.subscribeInteractor = n32;
        this.couponNotificationInteractor = b23;
        this.connectivityService = j24;
        this.tracker = o35;
        a obj2 = new a();
        this._result = obj2;
        this.result = obj2;
        obj2 = new a();
        this.openSubscription = obj2;
        obj2 = new x("");
        this.codeInput = obj2;
    }

    public static final a access$get_result$p(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel) {
        return redeemCodeViewModel._result;
    }

    public static g0 h(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel, String string2, Boolean boolean3) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda-1(redeemCodeViewModel, string2, boolean3);
    }

    public static w i(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel, CouponDiscount couponDiscount2) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda-1$lambda-0(redeemCodeViewModel, couponDiscount2);
    }

    private static final g0 tryToValidateAndSaveDiscount$lambda-1(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel, String string2, Boolean boolean3) {
        n.f(redeemCodeViewModel, "this$0");
        n.f(boolean3, "isPremium");
        if (boolean3.booleanValue()) {
        } else {
            e obj3 = new e(redeemCodeViewModel);
            return redeemCodeViewModel.billingRepository.validateAndSaveDiscount(string2).map(obj3);
        }
        CouponExceptions.AlreadyPremium obj1 = new CouponExceptions.AlreadyPremium();
        throw obj1;
    }

    private static final w tryToValidateAndSaveDiscount$lambda-1$lambda-0(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel, CouponDiscount couponDiscount2) {
        n.f(redeemCodeViewModel, "this$0");
        n.f(couponDiscount2, "it");
        redeemCodeViewModel.couponNotificationInteractor.c(couponDiscount2);
        return w.a;
    }

    public final x<String> getCodeInput() {
        return this.codeInput;
    }

    public final a<Boolean> getOpenSubscription() {
        return this.openSubscription;
    }

    public final LiveData<y<Boolean>> getResult() {
        return this.result;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void tryToValidateAndSaveDiscount() {
        int _result;
        int disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel.tryToValidateAndSaveDiscount.3 anon;
        if (!this.connectivityService.a()) {
            this.tracker.s("redeem_code");
            unknownHostException = new UnknownHostException();
            disposable = new y.a(unknownHostException);
            this._result.postValue(disposable);
        } else {
            Object value = this.codeInput.getValue();
            if ((String)value == null) {
                _result = 0;
            } else {
                _result = j1.v0((String)value);
            }
            unknownHostException = y.b.a;
            if (!n.b(this._result.getValue(), unknownHostException)) {
                if (_result != null) {
                    if (l.z(_result)) {
                        disposable = 1;
                    } else {
                        disposable = 0;
                    }
                } else {
                }
                if (disposable == 0) {
                    this._result.postValue(unknownHostException);
                    d dVar = new d(this, _result);
                    a0 subscribeOn = this.subscribeInteractor.q().flatMap(dVar).observeOn(a.b()).subscribeOn(a.b());
                    n.e(subscribeOn, "subscribeInteractor.revenueCatSubscribed()\n                        .flatMap { isPremium ->\n                            if (isPremium) {\n                                throw CouponExceptions.AlreadyPremium()\n                            } else {\n                                billingRepository.validateAndSaveDiscount(inputRedeemCode).map {\n                                    couponNotificationInteractor.scheduleNotification(it)\n                                }\n                            }\n                        }\n                        .observeOn(Schedulers.io())\n                        .subscribeOn(Schedulers.io())");
                    unknownHostException = new RedeemCodeViewModel.tryToValidateAndSaveDiscount.2(this);
                    anon = new RedeemCodeViewModel.tryToValidateAndSaveDiscount.3(this);
                    getDisposable().b(a.g(subscribeOn, unknownHostException, anon));
                }
            }
        }
    }
}
