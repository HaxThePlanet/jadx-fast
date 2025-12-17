package app.dogo.com.dogo_android.dogcreation.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.i.e;
import app.dogo.com.dogo_android.h.gb;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.g1;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationBreedBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "viewModel$delegate", "callSearchDialog", "", "goToNextScreen", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment {

    private gb a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.dogcreation.j.j a;
        public a(app.dogo.com.dogo_android.dogcreation.j.j j) {
            this.a = j;
            super();
        }

        public final void onChanged(T t) {
            boolean obj2;
            n.e((Boolean)t, "it");
            if (t.booleanValue()) {
                j.C1(this.a);
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {

        final app.dogo.com.dogo_android.dogcreation.j.j this$0;
        b(app.dogo.com.dogo_android.dogcreation.j.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            String str;
            boolean obj2;
            n.f(d, "$this$addCallback");
            if (!obj2 instanceof y.b) {
                obj2 = this.this$0.requireActivity();
                n.e(obj2, "requireActivity()");
                g1.O(obj2);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.dogcreation.j.n> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.j.n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(n.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public j() {
        super();
        final int i = 0;
        j.c cVar = new j.c(this, i, i);
        this.b = j.a(m.NONE, cVar);
        j.d dVar = new j.d(this, i, i);
        this.c = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final app.dogo.com.dogo_android.dogcreation.j.n B1(app.dogo.com.dogo_android.dogcreation.j.j j) {
        return j.F1();
    }

    public static final void C1(app.dogo.com.dogo_android.dogcreation.j.j j) {
        j.G1();
    }

    private final void D1() {
        String name;
        String str;
        Object value = E1().k().getValue();
        if (value != null && (DogBreed)value.getId() == null) {
            if (value.getId() == null) {
                name = value.getName();
            } else {
                name = "";
            }
        } else {
        }
        k kVar = new k(name);
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.X(activity, kVar);
        }
    }

    private final g E1() {
        return (g)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.j.n F1() {
        return (n)this.c.getValue();
    }

    private final void G1() {
        e eVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            eVar = new e();
            g1.n(activity, eVar);
        }
    }

    public static void H1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        j.L1(j, view2);
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        j.O1(j, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        j.M1(j, view2);
    }

    public static void K1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        j.N1(j, view2);
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        app.dogo.com.dogo_android.dogcreation.j.n nVar;
        String str;
        Object obj2;
        n.f(j, "this$0");
        Object obj3 = j.E1().k().getValue();
        if ((DogBreed)obj3 != null) {
            obj2 = j.E1().l();
            str = "";
            if (obj2 == null) {
            } else {
                obj2 = obj2.getId();
                if (obj2 == null) {
                } else {
                    str = obj2;
                }
            }
            j.F1().m(str, (DogBreed)obj3);
        } else {
            j.G1();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        n.f(j, "this$0");
        j.D1();
    }

    private static final void N1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void O1(app.dogo.com.dogo_android.dogcreation.j.j j, View view2) {
        n.f(j, "this$0");
        j.G1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        gb obj2 = gb.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(F1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(E1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
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
    public void onResume() {
        DogProfile activity;
        boolean z;
        super.onResume();
        if (E1().l() == null) {
            if (activity instanceof DogCreationActivity != null) {
            } else {
                activity = 0;
            }
            if (activity == null) {
            } else {
                activity.y();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        j.b bVar = new j.b(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, bVar, 2, 0);
        gb obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            c cVar = new c(this);
            obj7.P.setOnClickListener(cVar);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                e eVar = new e(this);
                obj7.O.setOnClickListener(eVar);
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    f fVar = new f(this);
                    obj7.R.setNavigationOnClickListener(fVar);
                    obj7 = this.a;
                    if (obj7 == null) {
                    } else {
                        obj8 = new d(this);
                        obj7.S.setOnClickListener(obj8);
                        obj8 = getViewLifecycleOwner();
                        n.e(obj8, "viewLifecycleOwner");
                        j.a aVar = new j.a(this);
                        F1().k().observe(obj8, aVar);
                    }
                    n.w(str2);
                    throw obj8;
                }
                n.w(str2);
                throw obj8;
            }
            n.w(str2);
            throw obj8;
        }
        n.w(str2);
        throw obj8;
    }
}
