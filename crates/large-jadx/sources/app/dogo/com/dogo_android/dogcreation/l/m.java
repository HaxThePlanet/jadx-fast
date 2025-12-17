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
import app.dogo.com.dogo_android.h.ob;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0016H\u0016J\u0008\u0010 \u001a\u00020\u0016H\u0016J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationLoginProvidersBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/login/DogCreationLoginScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrivacyClick", "onTermsClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends Fragment implements c0 {

    private final h a;
    private ob b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<b0> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final b0 invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(b0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public m() {
        super();
        m nONE = m.NONE;
        final int i = 0;
        m.a aVar = new m.a(this, i, i);
        this.a = j.a(nONE, aVar);
        m.b bVar = new m.b(this, i, i);
        this.c = j.a(nONE, bVar);
    }

    private final app.dogo.com.dogo_android.dogcreation.l.n B1() {
        return (n)k1.a(this);
    }

    private final g C1() {
        return (g)this.c.getValue();
    }

    private final b0 D1() {
        return (b0)this.a.getValue();
    }

    private final void E1() {
        androidx.fragment.app.e activity;
        d dVar;
        if (C1().q()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                dVar = new d();
                g1.n(activity, dVar);
            }
        } else {
            if (activity instanceof DogCreationActivity != null) {
            } else {
                activity = 0;
            }
            if (activity == null) {
            } else {
                activity.z();
            }
        }
    }

    public static void F1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.O1(m, view2);
    }

    public static void G1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.P1(m, view2);
    }

    public static void H1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.N1(m, view2);
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.Q1(m, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.L1(m, view2);
    }

    public static void K1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        m.M1(m, view2);
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        j obj1 = new j();
        g1.R(m.getActivity(), obj1);
    }

    private static final void M1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        l obj1 = new l();
        g1.R(m.getActivity(), obj1);
    }

    private static final void N1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        final androidx.fragment.app.e obj1 = m.requireActivity();
        n.e(obj1, "requireActivity()");
        m.D1().i(obj1);
    }

    private static final void O1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        final androidx.fragment.app.e obj1 = m.requireActivity();
        n.e(obj1, "requireActivity()");
        m.D1().t(obj1);
    }

    private static final void P1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        m.E1();
    }

    private static final void Q1(app.dogo.com.dogo_android.dogcreation.l.m m, View view2) {
        n.f(m, "this$0");
        final androidx.fragment.app.e obj0 = m.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G() {
        String tag;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.j0(activity, B1().getTag());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ob obj2 = ob.T(layoutInflater, viewGroup2, false);
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
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        ob obj3 = this.b;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            g gVar = new g(this);
            obj3.O.setOnClickListener(gVar);
            obj3 = this.b;
            if (obj3 == null) {
            } else {
                h hVar = new h(this);
                obj3.P.setOnClickListener(hVar);
                obj3 = this.b;
                if (obj3 == null) {
                } else {
                    e eVar = new e(this);
                    obj3.Q.setOnClickListener(eVar);
                    obj3 = this.b;
                    if (obj3 == null) {
                    } else {
                        c cVar = new c(this);
                        obj3.R.setOnClickListener(cVar);
                        obj3 = this.b;
                        if (obj3 == null) {
                        } else {
                            d dVar = new d(this);
                            obj3.Q.setOnClickListener(dVar);
                            obj3 = this.b;
                            if (obj3 == null) {
                            } else {
                                obj4 = new f(this);
                                obj3.P.setNavigationOnClickListener(obj4);
                                D1().s().postValue(getString(2131886838));
                            }
                            n.w(str2);
                            throw obj4;
                        }
                        n.w(str2);
                        throw obj4;
                    }
                    n.w(str2);
                    throw obj4;
                }
                n.w(str2);
                throw obj4;
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }

    @Override // androidx.fragment.app.Fragment
    public void q0() {
        String tag;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.k0(activity, B1().getTag());
        }
    }
}
