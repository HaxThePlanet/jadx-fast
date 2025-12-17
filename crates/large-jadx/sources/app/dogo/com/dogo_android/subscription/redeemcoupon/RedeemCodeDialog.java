package app.dogo.com.dogo_android.subscription.redeemcoupon;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import app.dogo.com.dogo_android.h.q9;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0012\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;)V", "screenKey", "Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RedeemCodeDialog extends d {

    public q9 binding;
    private final h sharedViewModel$delegate;
    private final h viewModel$delegate;
    static {
    }

    public RedeemCodeDialog() {
        super();
        final int i = 0;
        RedeemCodeDialog.special$$inlined.viewModel.default.1 anon = new RedeemCodeDialog.special$$inlined.viewModel.default.1(this, i, i);
        this.viewModel$delegate = j.a(m.SYNCHRONIZED, anon);
        RedeemCodeDialog.special$$inlined.sharedViewModel.default.1 anon2 = new RedeemCodeDialog.special$$inlined.sharedViewModel.default.1(this, i, i);
        this.sharedViewModel$delegate = j.a(m.NONE, anon2);
    }

    public static void B1(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, Boolean boolean2) {
        RedeemCodeDialog.onViewCreated$lambda-0(redeemCodeDialog, boolean2);
    }

    public static void C1(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, View view2) {
        RedeemCodeDialog.onViewCreated$lambda-1(redeemCodeDialog, view2);
    }

    public static void D1(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, View view2) {
        RedeemCodeDialog.onViewCreated$lambda-2(redeemCodeDialog, view2);
    }

    private final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeScreen getScreenKey() {
        return (RedeemCodeScreen)k1.a(this);
    }

    private static final void onViewCreated$lambda-0(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, Boolean boolean2) {
        n.f(redeemCodeDialog, "this$0");
        g1.n(redeemCodeDialog.getActivity(), l.H(redeemCodeDialog.getSharedViewModel(), "redeem_code", redeemCodeDialog.getScreenKey().getSubscriptionReturnKey(), false, 0, 12, 0));
        redeemCodeDialog.dismiss();
    }

    private static final void onViewCreated$lambda-1(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, View view2) {
        n.f(redeemCodeDialog, "this$0");
        k1.c(redeemCodeDialog);
        redeemCodeDialog.getViewModel().tryToValidateAndSaveDiscount();
    }

    private static final void onViewCreated$lambda-2(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog, View view2) {
        n.f(redeemCodeDialog, "this$0");
        k1.c(redeemCodeDialog);
        redeemCodeDialog.dismiss();
    }

    @Override // androidx.fragment.app.d
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.d
    public final q9 getBinding() {
        q9 binding = this.binding;
        if (binding == null) {
        } else {
            return binding;
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.d
    public final l getSharedViewModel() {
        return (l)this.sharedViewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.d
    public final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel getViewModel() {
        return (RedeemCodeViewModel)this.viewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj3;
        n.f(layoutInflater, "inflater");
        obj3 = getDialog();
        if (obj3 == null) {
        } else {
            obj3 = obj3.getWindow();
            if (obj3 == null) {
            } else {
                f1.H(obj3);
            }
        }
        obj3 = 0;
        q9 obj1 = q9.T(layoutInflater, viewGroup2, obj3);
        n.e(obj1, "inflate(inflater, container, false)");
        setBinding(obj1);
        getBinding().V(getViewModel());
        getBinding().M(getViewLifecycleOwner());
        obj1 = getDialog();
        if (obj1 == null) {
        } else {
            obj1.setCanceledOnTouchOutside(obj3);
        }
        obj1 = getBinding().w();
        n.e(obj1, "binding.root");
        return obj1;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.lifecycle.q obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        a aVar = new a(this);
        getViewModel().getOpenSubscription().observe(obj3, aVar);
        obj3 = new b(this);
        obj2.Q.setOnClickListener(obj3);
        obj3 = new c(this);
        obj2.O.setOnClickListener(obj3);
    }

    @Override // androidx.fragment.app.d
    public final void setBinding(q9 q9) {
        n.f(q9, "<set-?>");
        this.binding = q9;
    }
}
