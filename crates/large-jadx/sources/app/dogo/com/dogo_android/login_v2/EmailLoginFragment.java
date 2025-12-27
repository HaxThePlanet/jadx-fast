package app.dogo.com.dogo_android.login_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.ee;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: EmailLoginFragment.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/login_v2/EmailLoginFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLoginEmailBinding;", "screenKey", "Lapp/dogo/com/dogo_android/login_v2/EmailLoginScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/login_v2/EmailLoginScreen;", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrivacyClick", "", "onTermsClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public final class EmailLoginFragment extends Fragment implements c0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ee b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            z = u.this.D1().q().getValue() instanceof LoadResult_Loading;
            if (!(EmailLoginFragment.B1(u.this).q().getValue() instanceof oadResult_Loading)) {
                dVar.f(false);
                u.this.requireActivity().onBackPressed();
            }
            dVar.f(true);
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<b0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final b0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(LoginViewModel.class), this.$parameters);
        }

        public b(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public u() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.NONE, new u.b(this, aVar, aVar));
    }

    public static final /* synthetic */ b0 B1(u uVar) {
        return uVar.D1();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final v onPrivacyClick() {
        return (EmailLoginScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final b0 D1() {
        return (LoginViewModel)this.binding.getValue();
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
        ee eeVar = ee.T(inflater, container, false);
        n.e(eeVar, "inflate(inflater, container, false)");
        this.b = eeVar;
        int i = 0;
        String str3 = "binding";
        if (eeVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            eeVar.W(D1());
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        n.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        D1().s().postValue(getString(2131886838));
        D1().S();
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new u.a(this), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.k0(activity, onPrivacyClick().getTag());
        }
    }

}
