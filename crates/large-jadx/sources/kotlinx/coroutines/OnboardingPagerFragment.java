package app.dogo.com.dogo_android.welcome_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.se;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: OnboardingPagerFragment.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0014H\u0002J\u0008\u0010\u0016\u001a\u00020\u0012H\u0002J\u0008\u0010\u0017\u001a\u00020\u0012H\u0016J\u0008\u0010\u0018\u001a\u00020\u0012H\u0016J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0012H\u0002J\u001a\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingPagerBinding;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerScreen;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerViewModel;", "viewModel$delegate", "goToNextScreen", "", "isFirstPage", "", "isLastPage", "onBack", "onItemClicked", "onLastItemSwiped", "onNextPressed", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "onSkip", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i0, reason: from kotlin metadata */
public final class OnboardingPagerFragment extends app.dogo.com.dogo_android.util.m0.b<se, j0> implements app.dogo.com.dogo_android.util.l0.b {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingPagerFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final /* synthetic */ i0 c;
        b() {
            this.c = i0Var;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            this.c.P1();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<p0> {

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
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<k0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final k0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingPagerViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, se> {

        public static final i0.a a = new i0$a();
        @Override // kotlin.d0.d.k
        public final se l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return se.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, se.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingPagerBinding;", 0);
        }
    }
    public i0() {
        super(kotlinx.coroutines.i0.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.i0.d(this, aVar2, aVar2));
        this.w = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.i0.c(this, aVar2, aVar2));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static final /* synthetic */ void onPageChange(i0 screen) {
        screen.P1();
    }

    /* renamed from: J1, reason: from kotlin metadata */
    private final void goToNextScreen() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(activity, new OnboardingNameScreen());
        }
    }

    private final boolean K1() {
        boolean z = true;
        int r0 = (se)B1().R.getCurrentItem() == 0 ? 1 : 0;
        return ((se)B1().R.getCurrentItem() == 0 ? 1 : 0);
    }

    private final boolean L1() {
        boolean z = true;
        int r0 = (se)B1().R.getCurrentItem() == p.i(I1().isConnectedToInternet()) ? 1 : 0;
        return ((se)B1().R.getCurrentItem() == p.i(I1().isConnectedToInternet()) ? 1 : 0);
    }

    private final void P1() {
        if (!K1()) {
            str = "binding.onboardingViewPager";
            n.e(viewPager2, str);
            app.dogo.com.dogo_android.util.extensionfunction.j1.logEvent(viewPager2);
        } else {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    private final void Q1() {
        if (L1()) {
            goToNextScreen();
        } else {
            str = "binding.onboardingViewPager";
            n.e(viewPager2, str);
            app.dogo.com.dogo_android.util.extensionfunction.j1.linkWithCredentialSingle(viewPager2);
        }
    }

    private final void R1() {
        goToNextScreen();
    }

    private static final void S1(i0 i0Var, View view) {
        n.f(i0Var, "this$0");
        i0Var.P1();
    }

    private static final void T1(i0 i0Var, View view) {
        n.f(i0Var, "this$0");
        i0Var.R1();
    }

    private static final void U1(i0 i0Var, View view) {
        n.f(i0Var, "this$0");
        i0Var.I1().trackContinueTap((se)i0Var.B1().R.getCurrentItem());
        i0Var.Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public p0 H1() {
        return (OnboardingSharedViewModel)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public k0 I1() {
        return (OnboardingPagerViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void f() {
        Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new OnboardingPagerFragment_onViewCreated_1(this));
        (se)B1().T.setNavigationOnClickListener(new kotlinx.coroutines.o(this));
        (se)B1().U.setOnClickListener(new kotlinx.coroutines.n(this));
        (se)B1().Q.setOnClickListener(new kotlinx.coroutines.m(this));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void p() {
        goToNextScreen();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void s1(i3 i3Var) {
        if (i3Var != null) {
            androidx.fragment.app.e requireActivity = requireActivity();
            str = "requireActivity()";
            n.e(requireActivity, str);
            App.INSTANCE.r().logScreenView(requireActivity, i3Var);
        }
        if (L1()) {
            int i = 2131886409;
            (se)B1().Q.setText(i);
        } else {
            i = 2131886689;
            (se)B1().Q.setText(i);
        }
    }


    /* renamed from: M1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(i0 view, View savedInstanceState) {
        OnboardingPagerFragment.U1(view, savedInstanceState);
    }

    public static /* synthetic */ void N1(i0 i0Var, View view) {
        OnboardingPagerFragment.T1(i0Var, view);
    }

    public static /* synthetic */ void O1(i0 i0Var, View view) {
        OnboardingPagerFragment.S1(i0Var, view);
    }
}
