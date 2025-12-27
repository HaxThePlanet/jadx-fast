package app.dogo.com.dogo_android.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.c9;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.main_screen.MainScreenActivity;
import com.google.android.play.core.review.ReviewInfo;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: RatePromptDialogV2.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/view/RatePromptDialogV2;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogInAppRateBinding;", "viewModel", "Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "getViewModel", "()Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class RatePromptDialogV2 extends androidx.fragment.app.d {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private c9 b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.a0.d> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.a0.d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(RatePromptViewModelV2.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { (RatePromptV2Screen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(m.this).getSource() });
        }

        b() {
            super(0);
        }
    }
    public m() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new m.a(this, null, new m.b(this)));
    }

    private final app.dogo.com.dogo_android.a0.d B1() {
        return (RatePromptViewModelV2)this.binding.getValue();
    }

    private static final void F1(m mVar, Boolean boolean) {
        n.f(mVar, "this$0");
        final Dialog dialog = mVar.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private static final void G1(m mVar, Boolean boolean) {
        n.f(mVar, "this$0");
        androidx.fragment.app.e activity = mVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToZendeskScreenAndLog(activity);
        }
        final Dialog dialog = mVar.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private static final void H1(m mVar, ReviewInfo reviewInfo) {
        int i = 0;
        str = "this$0";
        n.f(mVar, str);
        if (reviewInfo != null) {
            MainScreenActivity r0 = mVar.getActivity() instanceof MainScreenActivity ? (MainScreenActivity)mVar.getActivity() : 0;
            if (i != 0) {
                i.d1(reviewInfo, (RatePromptV2Screen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(mVar).getSource());
            }
        }
        final Dialog dialog = mVar.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        boolean z = false;
        c9 c9Var = c9.T(inflater, container, z);
        n.e(c9Var, "inflate(inflater, container, false)");
        this.b = c9Var;
        int i2 = 0;
        final String str = "binding";
        if (c9Var == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            c9Var.V(B1());
            if (this.b == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                this.b.M(getViewLifecycleOwner());
                Dialog dialog = getDialog();
                if (dialog != null) {
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawableResource(2131230940);
                    }
                }
                Dialog dialog2 = getDialog();
                if (dialog2 != null) {
                    dialog2.setCanceledOnTouchOutside(z);
                }
                if (this.b == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    return this.b.w();
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        B1().k().observe(viewLifecycleOwner, new c(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        B1().m().observe(viewLifecycleOwner2, new d(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        B1().l().observe(viewLifecycleOwner3, new b(this));
    }


    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(m view, ReviewInfo savedInstanceState) {
        RatePromptDialogV2.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(m mVar, Boolean boolean) {
        RatePromptDialogV2.F1(mVar, boolean);
    }

    public static /* synthetic */ void E1(m mVar, Boolean boolean) {
        RatePromptDialogV2.G1(mVar, boolean);
    }
}
