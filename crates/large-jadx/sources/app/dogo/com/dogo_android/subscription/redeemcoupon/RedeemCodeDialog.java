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

/* compiled from: RedeemCodeDialog.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0012\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogRedeemCodePromptBinding;)V", "screenKey", "Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/redeemcoupon/RedeemCodeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RedeemCodeDialog extends d {

    public q9 binding;
    /* renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final h sharedViewModel;
    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final h viewModel;
    public RedeemCodeDialog() {
        super();
        final m.a.c.j.a aVar = null;
        this.viewModel = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new RedeemCodeDialog.special$$inlined.viewModel.default.AnonymousClass1(this, aVar, aVar));
        this.sharedViewModel = j.a(LazyThreadSafetyMode.NONE, new RedeemCodeDialog.special$$inlined.sharedViewModel.default.AnonymousClass1(this, aVar, aVar));
    }

    private final RedeemCodeScreen getScreenKey() {
        return (RedeemCodeScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private static final void onViewCreated$lambda_0(RedeemCodeDialog redeemCodeDialog, Boolean boolean) {
        n.f(redeemCodeDialog, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(redeemCodeDialog.getActivity(), SessionViewModel.H(redeemCodeDialog.getSharedViewModel(), "redeem_code", redeemCodeDialog.getScreenKey().getSubscriptionReturnKey(), false, null, 12, null));
        redeemCodeDialog.dismiss();
    }

    private static final void onViewCreated$lambda_1(RedeemCodeDialog redeemCodeDialog, View view) {
        n.f(redeemCodeDialog, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(redeemCodeDialog);
        redeemCodeDialog.getViewModel().tryToValidateAndSaveDiscount();
    }

    private static final void onViewCreated$lambda_2(RedeemCodeDialog redeemCodeDialog, View view) {
        n.f(redeemCodeDialog, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(redeemCodeDialog);
        redeemCodeDialog.dismiss();
    }

    @Override // androidx.fragment.app.d
    public final q9 getBinding() {
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.binding;
        }
    }

    @Override // androidx.fragment.app.d
    public final l getSharedViewModel() {
        return (SessionViewModel)this.sharedViewModel.getValue();
    }

    @Override // androidx.fragment.app.d
    public final RedeemCodeViewModel getViewModel() {
        return (RedeemCodeViewModel)this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            android.view.Window window = dialog2.getWindow();
            if (window != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.callZendeskDialog(window);
            }
        }
        boolean z = false;
        q9 q9Var = q9.T(inflater, container, z);
        n.e(q9Var, "inflate(inflater, container, false)");
        setBinding(q9Var);
        getBinding().V(getViewModel());
        getBinding().M(getViewLifecycleOwner());
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(z);
        }
        View view = getBinding().w();
        n.e(view, "binding.root");
        return view;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        n.e(viewLifecycleOwner, "viewLifecycleOwner");
        getViewModel().getOpenSubscription().observe(viewLifecycleOwner, new a(this));
        getBinding().Q.setOnClickListener(new b(this));
        getBinding().O.setOnClickListener(new c(this));
    }

    @Override // androidx.fragment.app.d
    public final void setBinding(q9 q9Var) {
        n.f(q9Var, "<set-?>");
        this.binding = q9Var;
    }


    /* renamed from: B1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(RedeemCodeDialog view, Boolean savedInstanceState) {
        RedeemCodeDialog.onViewCreated$lambda_0(view, savedInstanceState);
    }

    public static /* synthetic */ void C1(RedeemCodeDialog redeemCodeDialog, View view) {
        RedeemCodeDialog.onViewCreated$lambda_1(redeemCodeDialog, view);
    }

    public static /* synthetic */ void D1(RedeemCodeDialog redeemCodeDialog, View view) {
        RedeemCodeDialog.onViewCreated$lambda_2(redeemCodeDialog, view);
    }

    @Override // androidx.fragment.app.d
    public void _$_clearFindViewByIdCache() {
    }
}
