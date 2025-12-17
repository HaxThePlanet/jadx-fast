package app.dogo.com.dogo_android.welcome_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.qe;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingDogNameV2Binding;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e0 extends Fragment {

    private final h a;
    private qe b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.welcome_v2.g0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.g0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public e0() {
        super();
        final int i = 0;
        e0.a aVar = new e0.a(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.welcome_v2.g0 B1() {
        return (g0)this.a.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.welcome_v2.e0 e0, View view2) {
        e0.H1(e0, view2);
    }

    public static void D1(app.dogo.com.dogo_android.welcome_v2.e0 e0, View view2) {
        e0.F1(e0, view2);
    }

    public static void E1(app.dogo.com.dogo_android.welcome_v2.e0 e0, y y2) {
        e0.G1(e0, y2);
    }

    private static final void F1(app.dogo.com.dogo_android.welcome_v2.e0 e0, View view2) {
        n.f(e0, "this$0");
        final androidx.fragment.app.e obj0 = e0.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void G1(app.dogo.com.dogo_android.welcome_v2.e0 e0, y y2) {
        boolean u0Var;
        String name;
        Object obj2;
        Object obj3;
        n.f(e0, "this$0");
        if (y2 instanceof y.c) {
            obj2 = e0.getActivity();
            if (obj2 == null) {
            } else {
                u0Var = new u0((DogProfile)(y.c)y2.a().getName(), (DogProfile)y2.a().getId());
                g1.o(obj2, u0Var);
            }
        }
    }

    private static final void H1(app.dogo.com.dogo_android.welcome_v2.e0 e0, View view2) {
        n.f(e0, "this$0");
        k1.c(e0);
        qe obj0 = e0.b;
        if (obj0 == null) {
        } else {
            e0.B1().u(String.valueOf(obj0.O.getText()));
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        qe obj2 = qe.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(B1());
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    k kVar = new k(this);
                    obj2.O.setOnClickListener(kVar);
                    obj2 = this.b;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.w();
                        n.e(obj2, "binding.root");
                        return obj2;
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
    public void onPause() {
        super.onPause();
        k1.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qe qeVar = this.b;
        if (qeVar == null) {
        } else {
            com.google.android.material.textfield.TextInputLayout textInputLayout = qeVar.Q;
            n.e(textInputLayout, "binding.nameField");
            k1.g(this, textInputLayout);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.lifecycle.q obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        l lVar = new l(this);
        B1().o().observe(obj3, lVar);
        qe obj2 = this.b;
        if (obj2 == null) {
        } else {
            obj3 = new j(this);
            obj2.R.setOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}
