package app.dogo.com.dogo_android.dogcreation.k;

import android.content.res.Resources;
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
import app.dogo.com.dogo_android.dogcreation.l.n;
import app.dogo.com.dogo_android.dogcreation.n.i;
import app.dogo.com.dogo_android.dogcreation.o.d;
import app.dogo.com.dogo_android.h.kb;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/gender/DogCreationGenderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationGenderBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/gender/DogCreationGenderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/gender/DogCreationGenderViewModel;", "viewModel$delegate", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends Fragment {

    private kb a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.dogcreation.k.d a;
        public a(app.dogo.com.dogo_android.dogcreation.k.d d) {
            this.a = d;
            super();
        }

        public final void onChanged(T t) {
            boolean obj2;
            n.e((Boolean)t, "it");
            if (t.booleanValue()) {
                d.D1(this.a);
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {

        final app.dogo.com.dogo_android.dogcreation.k.d this$0;
        b(app.dogo.com.dogo_android.dogcreation.k.d d) {
            this.this$0 = d;
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.dogcreation.k.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.k.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.dogcreation.k.d this$0;
        e(app.dogo.com.dogo_android.dogcreation.k.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            int gender;
            Object[] arr = new Object[1];
            DogProfile dogProfile = d.B1(this.this$0).l();
            if (dogProfile == null) {
                gender = 0;
            } else {
                gender = dogProfile.getGender();
            }
            return b.b(gender);
        }
    }
    static {
    }

    public d() {
        super();
        final int i = 0;
        d.c cVar = new d.c(this, i, i);
        this.b = j.a(m.NONE, cVar);
        d.e eVar = new d.e(this);
        d.d dVar = new d.d(this, i, eVar);
        this.c = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final g B1(app.dogo.com.dogo_android.dogcreation.k.d d) {
        return d.E1();
    }

    public static final app.dogo.com.dogo_android.dogcreation.k.f C1(app.dogo.com.dogo_android.dogcreation.k.d d) {
        return d.F1();
    }

    public static final void D1(app.dogo.com.dogo_android.dogcreation.k.d d) {
        d.G1();
    }

    private final g E1() {
        return (g)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.k.f F1() {
        return (f)this.c.getValue();
    }

    private final void G1() {
        androidx.fragment.app.e activity;
        n nVar;
        if (E1().p()) {
            if (E1().isUserSignedIn()) {
                if (E1().q()) {
                    activity = getActivity();
                    if (activity == null) {
                    } else {
                        nVar = new d();
                        g1.n(activity, nVar);
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
            } else {
                E1().r(k1.a(this));
                activity = getActivity();
                if (activity == null) {
                } else {
                    nVar = new n();
                    g1.n(activity, nVar);
                }
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                nVar = new i();
                g1.n(activity, nVar);
            }
        }
    }

    public static void H1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        d.K1(d, view2);
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        d.L1(d, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        d.M1(d, view2);
    }

    private static final void K1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        String str;
        Object obj1;
        n.f(d, "this$0");
        obj1 = d.E1().l();
        str = "";
        if (obj1 == null) {
        } else {
            obj1 = obj1.getId();
            if (obj1 == null) {
            } else {
                str = obj1;
            }
        }
        d.F1().n(str);
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        n.f(d, "this$0");
        final androidx.fragment.app.e obj0 = d.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.dogcreation.k.d d, View view2) {
        n.f(d, "this$0");
        d.G1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int name;
        n.f(layoutInflater, "inflater");
        int obj8 = 0;
        kb obj6 = kb.T(layoutInflater, viewGroup2, obj8);
        n.e(obj6, "inflate(inflater, container, false)");
        this.a = obj6;
        String obj7 = "binding";
        final int i = 0;
        if (obj6 == null) {
        } else {
            obj6.V(F1());
            obj6 = this.a;
            if (obj6 == null) {
            } else {
                Object[] arr = new Object[1];
                DogProfile dogProfile = E1().l();
                if (dogProfile == null) {
                    name = i;
                } else {
                    name = dogProfile.getName();
                }
                arr[obj8] = name;
                obj6.Q.setText(getResources().getString(2131886453, arr));
                obj6 = this.a;
                if (obj6 == null) {
                } else {
                    obj6.M(getViewLifecycleOwner());
                    obj6 = this.a;
                    if (obj6 == null) {
                    } else {
                        obj6 = obj6.w();
                        n.e(obj6, "binding.root");
                        return obj6;
                    }
                    n.w(obj7);
                    throw i;
                }
                n.w(obj7);
                throw i;
            }
            n.w(obj7);
            throw i;
        }
        n.w(obj7);
        throw i;
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
        d.b bVar2 = new d.b(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, bVar2, 2, 0);
        kb obj7 = this.a;
        int obj8 = 0;
        String str2 = "binding";
        if (obj7 == null) {
        } else {
            a aVar2 = new a(this);
            obj7.P.setOnClickListener(aVar2);
            obj7 = this.a;
            if (obj7 == null) {
            } else {
                b bVar = new b(this);
                obj7.R.setNavigationOnClickListener(bVar);
                obj7 = this.a;
                if (obj7 == null) {
                } else {
                    obj8 = new c(this);
                    obj7.S.setOnClickListener(obj8);
                    obj8 = getViewLifecycleOwner();
                    n.e(obj8, "viewLifecycleOwner");
                    d.a aVar = new d.a(this);
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
}
