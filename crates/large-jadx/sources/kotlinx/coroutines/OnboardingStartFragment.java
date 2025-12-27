package app.dogo.com.dogo_android.welcome_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.we;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.f0;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: OnboardingStartFragment.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0011H\u0002J\u0008\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingStartBinding;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartScreen;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "viewModel$delegate", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onNext", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q0, reason: from kotlin metadata */
public final class OnboardingStartFragment extends app.dogo.com.dogo_android.util.m0.b<we, r0> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingStartFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends androidx.activity.d {

        final /* synthetic */ q0 c;
        b() {
            this.c = q0Var;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            z = this.c.H1().isUserLoggedIn().getValue() instanceof LoadResult_Loading;
            if (!(this.c.H1().isUserLoggedIn().getValue() instanceof oadResult_Loading)) {
                this.c.requireActivity().finish();
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<p0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final p0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(OnboardingSharedViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<s0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final s0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingStartViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, we> {

        public static final q0.a a = new q0$a();
        @Override // kotlin.d0.d.k
        public final we l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return we.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, we.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingStartBinding;", 0);
        }
    }
    public q0() {
        super(kotlinx.coroutines.q0.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.q0.d(this, aVar2, aVar2));
        this.w = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.q0.c(this, aVar2, aVar2));
    }

    /* renamed from: N1, reason: from kotlin metadata */
    private final void onNext() {
        App.INSTANCE.r().logEvent(E_Onboarding.b);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(activity, new OnboardingPagerScreen());
        }
    }

    private static final void O1(q0 q0Var, View view) {
        n.f(q0Var, "this$0");
        q0Var.H1().m();
    }

    private static final void P1(q0 q0Var, View view) {
        n.f(q0Var, "this$0");
        q0Var.H1().m();
    }

    private static final void Q1(q0 q0Var, View view) {
        n.f(q0Var, "this$0");
        q0Var.H1().l();
        q0Var.H1().p();
    }

    private static final void R1(q0 q0Var, Boolean boolean) {
        n.f(q0Var, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.I(q0Var, 10002, "welcome", null, 4, null);
    }

    private static final void S1(q0 q0Var, Boolean boolean) {
        n.f(q0Var, "this$0");
        q0Var.onNext();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public p0 G1() {
        return (OnboardingSharedViewModel)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s0 H1() {
        return (OnboardingStartViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int resultCode2;
        String str;
        boolean resultCode3;
        super.onActivityResult(requestCode, resultCode, data);
        resultCode2 = 10002;
        if (requestCode == 10002 && resultCode == -1 && data == null) {
            resultCode2 = resultCode3;
            data = resultCode3;
            if (resultCode2 == 0 || resultCode3) {
                H1().n();
                requireActivity().finish();
                androidx.fragment.app.e activity = getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.u0(activity, resultCode3, resultCode2, null);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        int i = 8;
        super.onResume();
        n.e(button, "binding.login");
        int r1 = H1().k() ? 8 : 0;
        button.setVisibility((H1().k() ? 8 : 0));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new OnboardingStartFragment_onViewCreated_1(this));
        (we)B1().P.setOnClickListener(new kotlinx.coroutines.w(this));
        (we)B1().O.setOnClickListener(new kotlinx.coroutines.v(this));
        (we)B1().Q.setOnClickListener(new kotlinx.coroutines.t(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner2, str2);
        H1().i().observe(viewLifecycleOwner2, new kotlinx.coroutines.x(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        H1().j().observe(viewLifecycleOwner3, new kotlinx.coroutines.u(this));
        n.e(konfettiView, "binding.viewKonfetti");
        androidx.fragment.app.e activity = getActivity();
        i = activity == null ? 0 : (float)showLinkShareDialog;
        app.dogo.com.dogo_android.util.extensionfunction.j1.createSingle(konfettiView, i);
    }


    /* renamed from: I1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(q0 view, View savedInstanceState) {
        OnboardingStartFragment.Q1(view, savedInstanceState);
    }

    public static /* synthetic */ void J1(q0 q0Var, Boolean boolean) {
        OnboardingStartFragment.S1(q0Var, boolean);
    }

    public static /* synthetic */ void K1(q0 q0Var, View view) {
        OnboardingStartFragment.P1(q0Var, view);
    }

    public static /* synthetic */ void L1(q0 q0Var, View view) {
        OnboardingStartFragment.O1(q0Var, view);
    }

    public static /* synthetic */ void M1(q0 q0Var, Boolean boolean) {
        OnboardingStartFragment.R1(q0Var, boolean);
    }
}
