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
import i.b.a0;
import i.b.g0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;

/* compiled from: RedeemCodeViewModel.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "billingRepository", "Lapp/dogo/com/dogo_android/subscription/BillingRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "couponNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/subscription/BillingRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "_result", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "codeInput", "Landroidx/lifecycle/MutableLiveData;", "", "getCodeInput", "()Landroidx/lifecycle/MutableLiveData;", "openSubscription", "getOpenSubscription", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "tryToValidateAndSaveDiscount", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RedeemCodeViewModel extends s {

    private final f.d.a.a<y<Boolean>> _result = new a<>();
    private final BillingRepository billingRepository;
    private final x<String> codeInput = new x<>("");
    private final j2 connectivityService;
    private final b2 couponNotificationInteractor;
    private final f.d.a.a<Boolean> openSubscription = new a<>();
    private final LiveData<y<Boolean>> result = new a<>();
    private final n3 subscribeInteractor;
    private final o3 tracker;
    public RedeemCodeViewModel(BillingRepository billingRepository, n3 n3Var, b2 b2Var, j2 j2Var, o3 o3Var) {
        n.f(billingRepository, "billingRepository");
        n.f(n3Var, "subscribeInteractor");
        n.f(b2Var, "couponNotificationInteractor");
        n.f(j2Var, "connectivityService");
        n.f(o3Var, "tracker");
        super();
        this.billingRepository = billingRepository;
        this.subscribeInteractor = n3Var;
        this.couponNotificationInteractor = b2Var;
        this.connectivityService = j2Var;
        this.tracker = o3Var;
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        x xVar = new x("");
    }

    public static final /* synthetic */ f.d.a.a access$get_result$p(RedeemCodeViewModel redeemCodeViewModel) {
        return redeemCodeViewModel._result;
    }

    private static final g0 tryToValidateAndSaveDiscount$lambda_1(RedeemCodeViewModel redeemCodeViewModel, String str, Boolean boolean) throws CouponExceptions.AlreadyPremium {
        n.f(redeemCodeViewModel, "this$0");
        n.f(boolean, "isPremium");
        if (boolean.booleanValue()) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new CouponExceptions_AlreadyPremium();
        } else {
            return redeemCodeViewModel.billingRepository.validateAndSaveDiscount(str).map(new e(redeemCodeViewModel));
        }
    }

    private static final w tryToValidateAndSaveDiscount$lambda_1$lambda_0(RedeemCodeViewModel redeemCodeViewModel, CouponDiscount couponDiscount) {
        n.f(redeemCodeViewModel, "this$0");
        n.f(couponDiscount, "it");
        redeemCodeViewModel.couponNotificationInteractor.c(couponDiscount);
        return w.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> getCodeInput() {
        return this.codeInput;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> getOpenSubscription() {
        return this.openSubscription;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Boolean>> getResult() {
        return this.result;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void tryToValidateAndSaveDiscount() {
        Object obj = null;
        int i = 0;
        if (!this.connectivityService.getActiveNetworkType()) {
            this.tracker.setTrainingReminderUserProperties("redeem_code");
            this._result.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            Object value = this.codeInput.getValue();
            if (value == null) {
                int i2 = 0;
            } else {
                String str = app.dogo.com.dogo_android.util.extensionfunction.j1.v0(value);
            }
            bVar = LoadResult_Loading.a;
            if (!n.b(this._result.getValue(), bVar) && this.codeInput != null) {
                if (l.z(obj)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (this._result == null) {
                    this._result.postValue(LoadResult_Loading.a);
                    a0 observable2 = this.subscribeInteractor.q().flatMap(new d(this, obj)).observeOn(a.b()).subscribeOn(a.b());
                    n.e(observable2, "subscribeInteractor.revenueCatSubscribed()\n                        .flatMap { isPremium ->\n                            if (isPremium) {\n                                throw CouponExceptions.AlreadyPremium()\n                            } else {\n                                billingRepository.validateAndSaveDiscount(inputRedeemCode).map {\n                                    couponNotificationInteractor.scheduleNotification(it)\n                                }\n                            }\n                        }\n                        .observeOn(Schedulers.io())\n                        .subscribeOn(Schedulers.io())");
                    getDisposable().b(a.g(observable2, new RedeemCodeViewModel.tryToValidateAndSaveDiscount.AnonymousClass2(this), new RedeemCodeViewModel.tryToValidateAndSaveDiscount.AnonymousClass3(this)));
                }
            }
        }
    }

    public static /* synthetic */ g0 h(RedeemCodeViewModel redeemCodeViewModel, String str, Boolean boolean) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda_1(redeemCodeViewModel, str, boolean);
    }

    public static /* synthetic */ w i(RedeemCodeViewModel redeemCodeViewModel, CouponDiscount couponDiscount) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda_1$lambda_0(redeemCodeViewModel, couponDiscount);
    }
}
