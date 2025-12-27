package app.dogo.com.dogo_android.login_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.ge;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: LoginProvidersFragment.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginProvidersFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLoginProvidersBinding;", "screenKey", "Lapp/dogo/com/dogo_android/login_v2/LoginScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/login_v2/LoginScreen;", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrivacyClick", "", "onTermsClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z, reason: from kotlin metadata */
public final class LoginProvidersFragment extends Fragment implements c0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ge b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<b0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final b0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(LoginViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public z() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.binding = j.a(LazyThreadSafetyMode.NONE, new z.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final a0 onPrivacyClick() {
        return (LoginScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final b0 C1() {
        return (LoginViewModel)this.binding.getValue();
    }

    private static final void H1(z zVar, View view) {
        n.f(zVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(zVar.getActivity(), new EmailLoginScreen());
    }

    private static final void I1(z zVar, View view) {
        n.f(zVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(zVar.getActivity(), new EmailRegisterScreen());
    }

    private static final void J1(z zVar, View view) {
        n.f(zVar, "this$0");
        final androidx.fragment.app.e requireActivity = zVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        zVar.C1().i(requireActivity);
    }

    private static final void K1(z zVar, View view) {
        n.f(zVar, "this$0");
        final androidx.fragment.app.e requireActivity = zVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        zVar.C1().t(requireActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.j0(activity, onPrivacyClick().getTag());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ge geVar = ge.T(inflater, container, false);
        n.e(geVar, "inflate(inflater, container, false)");
        this.b = geVar;
        int i = 0;
        String str3 = "binding";
        if (geVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            geVar.W(C1());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
                if (this.b == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.M(getViewLifecycleOwner());
                    if (this.b == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.b.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws i {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.b == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            geVar.O.setOnClickListener(new g(this));
            if (this.b == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                geVar2.P.setOnClickListener(new j(this));
                if (this.b == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    geVar3.Q.setOnClickListener(new h(this));
                    if (this.b == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        geVar4.R.setOnClickListener(new i(this));
                        C1().s().postValue(getString(2131886838));
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.k0(activity, onPrivacyClick().getTag());
        }
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(z view, View savedInstanceState) {
        LoginProvidersFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(z zVar, View view) {
        LoginProvidersFragment.J1(zVar, view);
    }

    public static /* synthetic */ void F1(z zVar, View view) {
        LoginProvidersFragment.K1(zVar, view);
    }

    public static /* synthetic */ void G1(z zVar, View view) {
        LoginProvidersFragment.I1(zVar, view);
    }
}
