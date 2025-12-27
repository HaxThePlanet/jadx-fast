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
import app.dogo.com.dogo_android.h.ql;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: OnboardingNameFragment.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingDogNameV2Binding;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public final class OnboardingNameFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private qe b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<g0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingNameViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public e0() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.e0.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final g0 onPause() {
        return (OnboardingNameViewModel)this.binding.getValue();
    }

    private static final void F1(e0 e0Var, View view) {
        n.f(e0Var, "this$0");
        final androidx.fragment.app.e activity = e0Var.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void G1(e0 e0Var, y yVar) {
        n.f(e0Var, "this$0");
        z = yVar instanceof LoadResult_Success;
    }

    private static final void H1(e0 e0Var, View view) {
        n.f(e0Var, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(e0Var);
        if (e0Var.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            e0Var.onPause().u(String.valueOf(qeVar.O.getText()));
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        qe qeVar = qe.T(inflater, container, false);
        n.e(qeVar, "inflate(inflater, container, false)");
        this.b = qeVar;
        int i = 0;
        String str4 = "binding";
        if (qeVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            qeVar.M(getViewLifecycleOwner());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(onPause());
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    qeVar3.T.O.setOnClickListener(new kotlinx.coroutines.k(this));
                    if (this.b == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.b.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(qeVar.Q, "binding.nameField");
            app.dogo.com.dogo_android.util.extensionfunction.k1.legacyShowDialog(this, qeVar.Q);
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        n.e(viewLifecycleOwner, "viewLifecycleOwner");
        onPause().o().observe(viewLifecycleOwner, new kotlinx.coroutines.l(this));
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            qeVar.R.setOnClickListener(new kotlinx.coroutines.j(this));
            return;
        }
    }


    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(e0 view, View savedInstanceState) {
        OnboardingNameFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(e0 e0Var, View view) {
        OnboardingNameFragment.F1(e0Var, view);
    }

    public static /* synthetic */ void E1(e0 e0Var, y yVar) {
        OnboardingNameFragment.G1(e0Var, yVar);
    }
}
