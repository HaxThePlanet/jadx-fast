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
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0014H\u0002J\u0008\u0010\u0016\u001a\u00020\u0012H\u0002J\u0008\u0010\u0017\u001a\u00020\u0012H\u0016J\u0008\u0010\u0018\u001a\u00020\u0012H\u0016J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0012H\u0002J\u001a\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingPagerBinding;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerScreen;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingPagerViewModel;", "viewModel$delegate", "goToNextScreen", "", "isFirstPage", "", "isLastPage", "onBack", "onItemClicked", "onLastItemSwiped", "onNextPressed", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "onSkip", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i0 extends b<se, app.dogo.com.dogo_android.welcome_v2.j0> implements b {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingPagerFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.welcome_v2.i0 c;
        b(app.dogo.com.dogo_android.welcome_v2.i0 i0) {
            this.c = i0;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            i0.G1(this.c);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.welcome_v2.p0> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.p0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(p0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.welcome_v2.k0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.k0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(k0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, se> {

        public static final app.dogo.com.dogo_android.welcome_v2.i0.a a;
        static {
            i0.a aVar = new i0.a();
            i0.a.a = aVar;
        }

        a() {
            super(3, se.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingPagerBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final se l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return se.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public i0() {
        super(i0.a.a);
        final int i = 0;
        i0.d dVar = new i0.d(this, i, i);
        this.v = j.a(m.SYNCHRONIZED, dVar);
        i0.c cVar = new i0.c(this, i, i);
        this.w = j.a(m.NONE, cVar);
    }

    public static final void G1(app.dogo.com.dogo_android.welcome_v2.i0 i0) {
        i0.P1();
    }

    private final void J1() {
        app.dogo.com.dogo_android.welcome_v2.f0 f0Var;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            f0Var = new f0();
            g1.o(activity, f0Var);
        }
    }

    private final boolean K1() {
        int i;
        i = view.R.getCurrentItem() == 0 ? 1 : 0;
        return i;
    }

    private final boolean L1() {
        int i;
        i = view.R.getCurrentItem() == p.i(I1().h()) ? 1 : 0;
        return i;
    }

    public static void M1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        i0.U1(i0, view2);
    }

    public static void N1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        i0.T1(i0, view2);
    }

    public static void O1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        i0.S1(i0, view2);
    }

    private final void P1() {
        Object activity;
        String str;
        if (K1()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.O(activity);
            }
        } else {
            activity = view.R;
            n.e(activity, "binding.onboardingViewPager");
            j1.H0(activity);
        }
    }

    private final void Q1() {
        boolean z;
        String str;
        if (L1()) {
            J1();
        } else {
            z = view.R;
            n.e(z, "binding.onboardingViewPager");
            j1.G0(z);
        }
    }

    private final void R1() {
        J1();
    }

    private static final void S1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        n.f(i0, "this$0");
        i0.P1();
    }

    private static final void T1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        n.f(i0, "this$0");
        i0.R1();
    }

    private static final void U1(app.dogo.com.dogo_android.welcome_v2.i0 i0, View view2) {
        n.f(i0, "this$0");
        i0.I1().i(view.R.getCurrentItem());
        i0.Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return H1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return I1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.welcome_v2.p0 H1() {
        return (p0)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.welcome_v2.k0 I1() {
        return (k0)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void f() {
        Q1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        i0.b bVar = new i0.b(this);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), bVar);
        o obj3 = new o(this);
        obj2.T.setNavigationOnClickListener(obj3);
        obj3 = new n(this);
        obj2.U.setOnClickListener(obj3);
        obj3 = new m(this);
        obj2.Q.setOnClickListener(obj3);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void p() {
        J1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void s1(i3 i3) {
        o3 o3Var;
        int i;
        androidx.fragment.app.e requireActivity;
        String str;
        Button obj4;
        if (i3 == null) {
        } else {
            requireActivity = requireActivity();
            n.e(requireActivity, "requireActivity()");
            App.Companion.r().g(requireActivity, i3);
        }
        if (L1()) {
            obj4.Q.setText(2131886409);
        } else {
            obj4.Q.setText(2131886689);
        }
    }
}
