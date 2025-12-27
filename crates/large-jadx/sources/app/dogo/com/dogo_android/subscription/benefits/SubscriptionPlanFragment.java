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

/* compiled from: SubscriptionPlanFragment.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020\u0013H\u0016J\u0008\u0010#\u001a\u00020\u0013H\u0016J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001b\u0010\u000c\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionBenefitsOfferAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentSubscriptionChoosePlanBinding;", "recoveringPurchaseDialog", "Landroid/app/Dialog;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/benefits/SubscriptionPlanScreen;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goBack", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelect", "position", "", "onPause", "onSelectedItemClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionPlanFragment extends Fragment implements SubscriptionBenefitsOfferAdapter.Callbacks {

    private ug binding;
    private Dialog recoveringPurchaseDialog;
    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final h viewModel;
    public SubscriptionPlanFragment() {
        super();
        this.viewModel = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new SubscriptionPlanFragment.special$$inlined.viewModel.default.AnonymousClass1(this, null, new SubscriptionPlanFragment.viewModel.AnonymousClass2(this)));
    }

    public static final /* synthetic */ Dialog access$getRecoveringPurchaseDialog$p(SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.recoveringPurchaseDialog;
    }

    public static final /* synthetic */ SubscriptionPlanScreen access$getScreenKey(SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.getScreenKey();
    }

    public static final /* synthetic */ SubscriptionViewModel access$getViewModel(SubscriptionPlanFragment subscriptionPlanFragment) {
        return subscriptionPlanFragment.getViewModel();
    }

    public static final /* synthetic */ void access$setRecoveringPurchaseDialog$p(SubscriptionPlanFragment subscriptionPlanFragment, Dialog dialog) {
        subscriptionPlanFragment.recoveringPurchaseDialog = dialog;
    }

    private final SubscriptionPlanScreen getScreenKey() {
        return (SubscriptionPlanScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final SubscriptionViewModel getViewModel() {
        return (SubscriptionViewModel)this.viewModel.getValue();
    }

    private final void goBack() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    private static final void onViewCreated$lambda_0(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        n.f(subscriptionPlanFragment, "this$0");
        subscriptionPlanFragment.goBack();
    }

    private static final void onViewCreated$lambda_1(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        n.f(subscriptionPlanFragment, "this$0");
        final androidx.fragment.app.e requireActivity = subscriptionPlanFragment.requireActivity();
        n.e(requireActivity, "requireActivity()");
        subscriptionPlanFragment.getViewModel().makePurchase(requireActivity);
    }

    private static final void onViewCreated$lambda_2(SubscriptionPlanFragment subscriptionPlanFragment, Boolean boolean) {
        n.f(subscriptionPlanFragment, "this$0");
        subscriptionPlanFragment.goBack();
    }

    private static final void onViewCreated$lambda_3(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        n.f(subscriptionPlanFragment, "this$0");
        final androidx.fragment.app.e requireActivity = subscriptionPlanFragment.requireActivity();
        n.e(requireActivity, "requireActivity()");
        subscriptionPlanFragment.getViewModel().makePurchase(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ug ugVar = ug.T(inflater, container, false);
        n.e(ugVar, "inflate(inflater, container, false)");
        this.binding = ugVar;
        int i = 0;
        String str3 = "binding";
        if (ugVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ugVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(getViewModel());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onItemSelect(int position) {
        getViewModel().onSkuSelected(position);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.recoveringPurchaseDialog = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSelectedItemClick() {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        getViewModel().makePurchase(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws SubscriptionPlanFragment.onViewCreated$$inlined.observe.AnonymousClass3 {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        String str4 = "binding";
        app.dogo.com.dogo_android.repository.domain.SubscriptionOffer subscriptionOffer = null;
        if (this.binding == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) subscriptionOffer;
        } else {
            binding2.W.setNavigationOnClickListener(new l(this));
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) subscriptionOffer;
            } else {
                binding22.Q.setOnClickListener(new j(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                final String str3 = "viewLifecycleOwner";
                n.e(viewLifecycleOwner, str3);
                getViewModel().getShouldGoBack().observe(viewLifecycleOwner, new m(this));
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) subscriptionOffer;
                } else {
                    binding23.T.setOnClickListener(new k(this));
                    SubscriptionViewModel.loadOffers$default(getViewModel(), subscriptionOffer, 1, subscriptionOffer);
                    androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                    n.e(viewLifecycleOwner2, str3);
                    getViewModel().isPurchaseRestored().observe(viewLifecycleOwner2, new SubscriptionPlanFragment.onViewCreated$$inlined.observe.AnonymousClass1(this));
                    androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
                    n.e(viewLifecycleOwner3, str3);
                    getViewModel().getShowInfoDialog().observe(viewLifecycleOwner3, new SubscriptionPlanFragment.onViewCreated$$inlined.observe.AnonymousClass2(this));
                    androidx.fragment.app.e requireActivity = requireActivity();
                    n.e(requireActivity, "requireActivity()");
                    getViewModel().getOnZendeskOpen().observe(requireActivity, new SubscriptionPlanFragment.onViewCreated$$inlined.observe.AnonymousClass3(this));
                    return;
                }
            }
        }
    }


    /* renamed from: B1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(SubscriptionPlanFragment view, View savedInstanceState) {
        SubscriptionPlanFragment.onViewCreated$lambda_1(view, savedInstanceState);
    }

    public static /* synthetic */ void C1(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        SubscriptionPlanFragment.onViewCreated$lambda_3(subscriptionPlanFragment, view);
    }

    public static /* synthetic */ void D1(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        SubscriptionPlanFragment.onViewCreated$lambda_0(subscriptionPlanFragment, view);
    }

    public static /* synthetic */ void E1(SubscriptionPlanFragment subscriptionPlanFragment, Boolean boolean) {
        SubscriptionPlanFragment.onViewCreated$lambda_2(subscriptionPlanFragment, boolean);
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }
}
