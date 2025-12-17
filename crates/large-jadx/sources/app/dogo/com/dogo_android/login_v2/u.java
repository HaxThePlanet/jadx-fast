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
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/login_v2/EmailLoginFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLoginEmailBinding;", "screenKey", "Lapp/dogo/com/dogo_android/login_v2/EmailLoginScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/login_v2/EmailLoginScreen;", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrivacyClick", "", "onTermsClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u extends Fragment implements app.dogo.com.dogo_android.login_v2.c0 {

    private final h a;
    private ee b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.login_v2.u this$0;
        a(app.dogo.com.dogo_android.login_v2.u u) {
            this.this$0 = u;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            boolean requireActivity;
            n.f(d, "$this$addCallback");
            if (!value instanceof y.b) {
                d.f(false);
                this.this$0.requireActivity().onBackPressed();
            }
            d.f(true);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.login_v2.b0> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.login_v2.b0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(b0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public u() {
        super();
        final int i = 0;
        u.b bVar = new u.b(this, i, i);
        this.a = j.a(m.NONE, bVar);
    }

    public static final app.dogo.com.dogo_android.login_v2.b0 B1(app.dogo.com.dogo_android.login_v2.u u) {
        return u.D1();
    }

    private final app.dogo.com.dogo_android.login_v2.v C1() {
        return (v)k1.a(this);
    }

    private final app.dogo.com.dogo_android.login_v2.b0 D1() {
        return (b0)this.a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        String tag;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.j0(activity, C1().getTag());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ee obj2 = ee.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(D1());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.b;
                    if (obj2 == null) {
                    } else {
                        return obj2.w();
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
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        D1().s().postValue(getString(2131886838));
        D1().S();
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        u.a aVar = new u.a(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar, 2, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        String tag;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.k0(activity, C1().getTag());
        }
    }
}
