package app.dogo.com.dogo_android.dogcreation.l;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.o.d;
import app.dogo.com.dogo_android.h.ge;
import app.dogo.com.dogo_android.h.ob;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: DogCreationLoginFragment.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0016H\u0016J\u0008\u0010 \u001a\u00020\u0016H\u0016J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationLoginProvidersBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrivacyClick", "onTermsClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class DogCreationLoginFragment extends Fragment implements app.dogo.com.dogo_android.login_v2.c0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ob b;
    private final h c;

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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public b(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public m() {
        super();
        m nONE2 = LazyThreadSafetyMode.NONE;
        final m.a.c.j.a aVar2 = null;
        this.binding = j.a(nONE2, new app.dogo.com.dogo_android.dogcreation.login.m.a(this, aVar2, aVar2));
        this.c = j.a(nONE2, new app.dogo.com.dogo_android.dogcreation.login.m.b(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final n goToNextScreen() {
        return (DogCreationLoginScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final g C1() {
        return (DogCreationSharedViewModel)this.c.getValue();
    }

    private final b0 D1() {
        return (LoginViewModel)this.binding.getValue();
    }

    private final void E1() {
        int i = 0;
        if (!C1().q()) {
            DogCreationActivity r0 = getActivity() instanceof DogCreationActivity ? (DogCreationActivity)this.getActivity() : 0;
            if (i != 0) {
                i.z();
            }
        } else {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationWelcomeScreen());
            }
        }
    }

    private static final void L1(m mVar, View view) {
        n.f(mVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(mVar.getActivity(), new DogCreationEmailLoginScreen());
    }

    private static final void M1(m mVar, View view) {
        n.f(mVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(mVar.getActivity(), new DogCreationEmailRegisterScreen());
    }

    private static final void N1(m mVar, View view) {
        n.f(mVar, "this$0");
        final androidx.fragment.app.e requireActivity = mVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        mVar.D1().i(requireActivity);
    }

    private static final void O1(m mVar, View view) {
        n.f(mVar, "this$0");
        final androidx.fragment.app.e requireActivity = mVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        mVar.D1().t(requireActivity);
    }

    private static final void P1(m mVar, View view) {
        n.f(mVar, "this$0");
        mVar.E1();
    }

    private static final void Q1(m mVar, View view) {
        n.f(mVar, "this$0");
        final androidx.fragment.app.e activity = mVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.j0(activity, goToNextScreen().getTag());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ob obVar = ob.T(inflater, container, false);
        n.e(obVar, "inflate(inflater, container, false)");
        this.b = obVar;
        int i = 0;
        String str4 = "binding";
        if (obVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            obVar.W(D1());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.M(getViewLifecycleOwner());
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
    public void onViewCreated(View view, Bundle bundle) throws f {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.b == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            obVar.O.O.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.g(this));
            if (this.b == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                obVar2.O.P.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.h(this));
                if (this.b == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    obVar3.O.Q.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.e(this));
                    if (this.b == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        obVar4.O.R.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.c(this));
                        if (this.b == null) {
                            n.w(str2);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            obVar5.Q.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.d(this));
                            if (this.b == null) {
                                n.w(str2);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                obVar6.P.setNavigationOnClickListener(new app.dogo.com.dogo_android.dogcreation.login.f(this));
                                D1().s().postValue(getString(2131886838));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.k0(activity, goToNextScreen().getTag());
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(m view, View savedInstanceState) {
        DogCreationLoginFragment.O1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(m mVar, View view) {
        DogCreationLoginFragment.P1(mVar, view);
    }

    public static /* synthetic */ void H1(m mVar, View view) {
        DogCreationLoginFragment.N1(mVar, view);
    }

    public static /* synthetic */ void I1(m mVar, View view) {
        DogCreationLoginFragment.Q1(mVar, view);
    }

    public static /* synthetic */ void J1(m mVar, View view) {
        DogCreationLoginFragment.L1(mVar, view);
    }

    public static /* synthetic */ void K1(m mVar, View view) {
        DogCreationLoginFragment.M1(mVar, view);
    }
}
