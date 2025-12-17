package app.dogo.com.dogo_android.subscription.benefits;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.h.ug;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020\u0013H\u0016J\u0008\u0010#\u001a\u00020\u0013H\u0016J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001b\u0010\u000c\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSubscriptionChoosePlanBinding;", "recoveringPurchaseDialog", "Landroid/app/Dialog;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goBack", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelect", "position", "", "onPause", "onSelectedItemClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionPlanFragment extends Fragment implements app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks {

    private ug binding;
    private Dialog recoveringPurchaseDialog;
    private final h viewModel$delegate;
    static {
    }

    public SubscriptionPlanFragment() {
        super();
        SubscriptionPlanFragment.viewModel.2 anon = new SubscriptionPlanFragment.viewModel.2(this);
        SubscriptionPlanFragment.special$$inlined.viewModel.default.1 anon2 = new SubscriptionPlanFragment.special$$inlined.viewModel.default.1(this, 0, anon);
        this.viewModel$delegate = j.a(m.SYNCHRONIZED, anon2);
    }

    public static void B1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        SubscriptionPlanFragment.onViewCreated$lambda-1(subscriptionPlanFragment, view2);
    }

    public static void C1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        SubscriptionPlanFragment.onViewCreated$lambda-3(subscriptionPlanFragment, view2);
    }

    public static void D1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        SubscriptionPlanFragment.onViewCreated$lambda-0(subscriptionPlanFragment, view2);
    }

    public static void E1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, Boolean boolean2) {
        SubscriptionPlanFragment.onViewCreated$lambda-2(subscriptionPlanFragment, boolean2);
    }

    public static final Dialog access$getRecoveringPurchaseDialog$p(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.recoveringPurchaseDialog;
    }

    public static final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen access$getScreenKey(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.getScreenKey();
    }

    public static final SubscriptionViewModel access$getViewModel(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.getViewModel();
    }

    public static final void access$setRecoveringPurchaseDialog$p(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, Dialog dialog2) {
        subscriptionPlanFragment.recoveringPurchaseDialog = dialog2;
    }

    private final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanScreen getScreenKey() {
        return (SubscriptionPlanScreen)k1.a(this);
    }

    private final SubscriptionViewModel getViewModel() {
        return (SubscriptionViewModel)this.viewModel$delegate.getValue();
    }

    private final void goBack() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.O(activity);
        }
    }

    private static final void onViewCreated$lambda-0(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        n.f(subscriptionPlanFragment, "this$0");
        subscriptionPlanFragment.goBack();
    }

    private static final void onViewCreated$lambda-1(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        n.f(subscriptionPlanFragment, "this$0");
        final androidx.fragment.app.e obj1 = subscriptionPlanFragment.requireActivity();
        n.e(obj1, "requireActivity()");
        subscriptionPlanFragment.getViewModel().makePurchase(obj1);
    }

    private static final void onViewCreated$lambda-2(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, Boolean boolean2) {
        androidx.fragment.app.e activity;
        int i4;
        String str;
        int i3;
        int i;
        int i2;
        boolean obj7;
        n.f(subscriptionPlanFragment, "this$0");
        if (!subscriptionPlanFragment.getViewModel().isUserSignedIn() && subscriptionPlanFragment.getViewModel().getPurchaseWasMade()) {
            if (subscriptionPlanFragment.getViewModel().getPurchaseWasMade()) {
                activity = subscriptionPlanFragment.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "purchase_completed", 0, 5, 0);
                }
            }
        }
        subscriptionPlanFragment.goBack();
    }

    private static final void onViewCreated$lambda-3(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment, View view2) {
        n.f(subscriptionPlanFragment, "this$0");
        final androidx.fragment.app.e obj1 = subscriptionPlanFragment.requireActivity();
        n.e(obj1, "requireActivity()");
        subscriptionPlanFragment.getViewModel().makePurchase(obj1);
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ug obj2 = ug.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.binding = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.binding;
            if (obj2 == null) {
            } else {
                obj2.W(getViewModel());
                obj2 = this.binding;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.binding;
                    if (obj2 == null) {
                    } else {
                        return obj2.w();
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSelect(int i) {
        getViewModel().onSkuSelected(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.recoveringPurchaseDialog = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSelectedItemClick() {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        getViewModel().makePurchase(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        ug obj5 = this.binding;
        String obj6 = "binding";
        int i = 0;
        if (obj5 == null) {
        } else {
            l lVar = new l(this);
            obj5.W.setNavigationOnClickListener(lVar);
            obj5 = this.binding;
            if (obj5 == null) {
            } else {
                j jVar = new j(this);
                obj5.Q.setOnClickListener(jVar);
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                final String str3 = "viewLifecycleOwner";
                n.e(viewLifecycleOwner, str3);
                m mVar = new m(this);
                getViewModel().getShouldGoBack().observe(viewLifecycleOwner, mVar);
                obj5 = this.binding;
                if (obj5 == null) {
                } else {
                    obj6 = new k(this);
                    obj5.T.setOnClickListener(obj6);
                    SubscriptionViewModel.loadOffers$default(getViewModel(), i, 1, i);
                    obj6 = getViewLifecycleOwner();
                    n.e(obj6, str3);
                    SubscriptionPlanFragment.onViewCreated$$inlined.observe.1 anon = new SubscriptionPlanFragment.onViewCreated$$inlined.observe.1(this);
                    getViewModel().isPurchaseRestored().observe(obj6, anon);
                    obj6 = getViewLifecycleOwner();
                    n.e(obj6, str3);
                    SubscriptionPlanFragment.onViewCreated$$inlined.observe.2 anon2 = new SubscriptionPlanFragment.onViewCreated$$inlined.observe.2(this);
                    getViewModel().getShowInfoDialog().observe(obj6, anon2);
                    obj6 = requireActivity();
                    n.e(obj6, "requireActivity()");
                    SubscriptionPlanFragment.onViewCreated$$inlined.observe.3 anon3 = new SubscriptionPlanFragment.onViewCreated$$inlined.observe.3(this);
                    getViewModel().getOnZendeskOpen().observe(obj6, anon3);
                }
                n.w(obj6);
                throw i;
            }
            n.w(obj6);
            throw i;
        }
        n.w(obj6);
        throw i;
    }
}
