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
import androidx.activity.d;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.we;
import app.dogo.com.dogo_android.o.d;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.w.f0;
import app.dogo.com.dogo_android.w.o3;
import f.d.a.a;
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
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0011H\u0002J\u0008\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingStartBinding;", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartScreen;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "viewModel$delegate", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onNext", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q0 extends b<we, app.dogo.com.dogo_android.welcome_v2.r0> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingStartFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.welcome_v2.q0 c;
        b(app.dogo.com.dogo_android.welcome_v2.q0 q0) {
            this.c = q0;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            boolean requireActivity;
            if (!value instanceof y.b) {
                this.c.requireActivity().finish();
            }
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.welcome_v2.s0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.s0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(s0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, we> {

        public static final app.dogo.com.dogo_android.welcome_v2.q0.a a;
        static {
            q0.a aVar = new q0.a();
            q0.a.a = aVar;
        }

        a() {
            super(3, we.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingStartBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final we l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return we.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public q0() {
        super(q0.a.a);
        final int i = 0;
        q0.d dVar = new q0.d(this, i, i);
        this.v = j.a(m.SYNCHRONIZED, dVar);
        q0.c cVar = new q0.c(this, i, i);
        this.w = j.a(m.NONE, cVar);
    }

    public static void I1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        q0.Q1(q0, view2);
    }

    public static void J1(app.dogo.com.dogo_android.welcome_v2.q0 q0, Boolean boolean2) {
        q0.S1(q0, boolean2);
    }

    public static void K1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        q0.P1(q0, view2);
    }

    public static void L1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        q0.O1(q0, view2);
    }

    public static void M1(app.dogo.com.dogo_android.welcome_v2.q0 q0, Boolean boolean2) {
        q0.R1(q0, boolean2);
    }

    private final void N1() {
        Object j0Var;
        App.Companion.r().c(f0.b);
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            j0Var = new j0();
            g1.o(activity, j0Var);
        }
    }

    private static final void O1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        n.f(q0, "this$0");
        q0.H1().m();
    }

    private static final void P1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        n.f(q0, "this$0");
        q0.H1().m();
    }

    private static final void Q1(app.dogo.com.dogo_android.welcome_v2.q0 q0, View view2) {
        n.f(q0, "this$0");
        q0.H1().l();
        q0.H1().p();
    }

    private static final void R1(app.dogo.com.dogo_android.welcome_v2.q0 q0, Boolean boolean2) {
        n.f(q0, "this$0");
        g1.I(q0, 10002, "welcome", 0, 4, 0);
    }

    private static final void S1(app.dogo.com.dogo_android.welcome_v2.q0 q0, Boolean boolean2) {
        n.f(q0, "this$0");
        q0.N1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return G1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return H1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.welcome_v2.p0 G1() {
        return (p0)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.welcome_v2.s0 H1() {
        return (s0)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onActivityResult(int i, int i2, Intent intent3) {
        int booleanExtra;
        String str;
        int obj3;
        int obj4;
        Intent obj5;
        super.onActivityResult(i, i2, intent3);
        if (i == 10002 && i2 == -1) {
            if (i2 == -1) {
                obj3 = 1;
                obj4 = 0;
                if (intent3 == null) {
                    booleanExtra = obj4;
                } else {
                }
                if (intent3 == null) {
                    obj5 = obj4;
                } else {
                }
                if (booleanExtra == 0 && obj5 == null) {
                    if (obj5 == null) {
                        H1().n();
                        requireActivity().finish();
                        obj5 = getActivity();
                        if (obj5 == null) {
                        } else {
                            g1.u0(obj5, obj4, obj3, 0);
                        }
                    } else {
                        if (H1().o()) {
                            obj3 = getActivity();
                            if (obj3 == null) {
                            } else {
                                obj4 = new d("onboarding");
                                g1.n(obj3, obj4);
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        int i;
        super.onResume();
        Button button = view.Q;
        n.e(button, "binding.login");
        i = H1().k() ? 8 : 0;
        button.setVisibility(i);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        int obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        q0.b bVar = new q0.b(this);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), bVar);
        obj4 = new w(this);
        obj3.P.setOnClickListener(obj4);
        obj4 = new v(this);
        obj3.O.setOnClickListener(obj4);
        obj4 = new t(this);
        obj3.Q.setOnClickListener(obj4);
        obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        x xVar = new x(this);
        H1().i().observe(obj4, xVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        u uVar = new u(this);
        H1().j().observe(obj4, uVar);
        nl.dionsegijn.konfetti.KonfettiView obj3 = obj3.S;
        n.e(obj3, "binding.viewKonfetti");
        obj4 = getActivity();
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4 = (float)obj4;
        }
        j1.B0(obj3, obj4);
    }
}
