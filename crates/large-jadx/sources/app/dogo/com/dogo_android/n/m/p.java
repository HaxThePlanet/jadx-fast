package app.dogo.com.dogo_android.n.m;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.f.n.d;
import app.dogo.com.dogo_android.h.ae;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.view.q;
import app.dogo.com.dogo_android.y.j;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
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
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends Fragment implements app.dogo.com.dogo_android.n.m.o.a {

    private final h a;
    private ae b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.n.m.p a;
        public a(app.dogo.com.dogo_android.n.m.p p) {
            this.a = p;
            super();
        }

        public final void onChanged(T t) {
            n.e((Throwable)t, "it");
            p.b bVar = new p.b(this.a);
            p.c cVar = new p.c(this.a);
            f1.W(this.a, t, bVar, cVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.p this$0;
        b(app.dogo.com.dogo_android.n.m.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            p.B1(this.this$0).C();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.p this$0;
        c(app.dogo.com.dogo_android.n.m.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public d(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements a<app.dogo.com.dogo_android.n.m.r> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.m.r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(r.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<a> {

        final app.dogo.com.dogo_android.n.m.p this$0;
        f(app.dogo.com.dogo_android.n.m.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            j jVar = k1.a(this.this$0);
            Object[] arr = new Object[2];
            return b.b((q)jVar.a(), jVar.b());
        }
    }
    static {
    }

    public p() {
        super();
        p.f fVar = new p.f(this);
        final int i = 0;
        p.e eVar = new p.e(this, i, fVar);
        this.a = j.a(m.SYNCHRONIZED, eVar);
        p.d dVar = new p.d(this, i, i);
        this.c = j.a(m.NONE, dVar);
    }

    public static final app.dogo.com.dogo_android.n.m.r B1(app.dogo.com.dogo_android.n.m.p p) {
        return p.D1();
    }

    private final app.dogo.com.dogo_android.n.m.q C1() {
        return (q)k1.a(this);
    }

    private final app.dogo.com.dogo_android.n.m.r D1() {
        return (r)this.a.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.n.m.p p, q2.a q2$a2) {
        p.J1(p, a2);
    }

    public static void F1(app.dogo.com.dogo_android.n.m.p p, String string2) {
        p.L1(p, string2);
    }

    public static void G1(app.dogo.com.dogo_android.n.m.p p, q2.a q2$a2) {
        p.K1(p, a2);
    }

    public static void H1(app.dogo.com.dogo_android.n.m.p p, View view2) {
        p.I1(p, view2);
    }

    private static final void I1(app.dogo.com.dogo_android.n.m.p p, View view2) {
        n.f(p, "this$0");
        final androidx.fragment.app.e obj0 = p.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.n.m.p p, q2.a q2$a2) {
        Object nVar;
        Object obj1;
        String obj2;
        n.f(p, "this$0");
        if (a2 == null) {
        } else {
            obj1 = p.getActivity();
            if (obj1 == null) {
            } else {
                nVar = new n(a2.getTag());
                g1.X(obj1, nVar);
            }
        }
    }

    private static final void K1(app.dogo.com.dogo_android.n.m.p p, q2.a q2$a2) {
        Object qVar;
        Object obj1;
        String obj2;
        n.f(p, "this$0");
        if (a2 == null) {
        } else {
            obj1 = p.getActivity();
            if (obj1 == null) {
            } else {
                qVar = new q(a2.getTag());
                g1.X(obj1, qVar);
            }
        }
    }

    private static final void L1(app.dogo.com.dogo_android.n.m.p p, String string2) {
        d dVar;
        String str2;
        String str;
        Object obj4;
        n.f(p, "this$0");
        androidx.fragment.app.e activity = p.getActivity();
        if (activity == null) {
        } else {
            n.e(string2, "it");
            dVar = new d(p.D1().t(string2), string2, p.C1().getTag());
            g1.o(activity, dVar);
        }
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void j(TrickItem trickItem) {
        Object activity;
        Object sharedViewModel;
        Object mVar;
        Object aVar;
        int str;
        int i3;
        int i;
        int i2;
        Object obj9;
        n.f(trickItem, "trick");
        D1().J(trickItem.getId());
        if (trickItem.getLocked()) {
            g1.n(getActivity(), l.H(getSharedViewModel(), "trick_list", C1().getTag(), false, 0, 12, 0));
        } else {
            j jVar = k1.a(this);
            aVar = new n.a(trickItem);
            mVar = new m(aVar, (q)jVar.getTag(), jVar.getTag(), "library");
            g1.n(getActivity(), mVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ae obj2 = ae.T(layoutInflater, viewGroup2, false);
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
        int obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i = 0;
        if (obj3 instanceof a0) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            obj3.p0();
        }
        obj3 = this.b;
        if (obj3 == null) {
        } else {
            e obj4 = new e(this);
            obj3.R.setNavigationOnClickListener(obj4);
            b bVar = new b(this);
            D1().n().observe(getViewLifecycleOwner(), bVar);
            d dVar = new d(this);
            D1().o().observe(getViewLifecycleOwner(), dVar);
            obj4 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(obj4, str2);
            c cVar = new c(this);
            D1().p().observe(obj4, cVar);
            D1().C();
            obj4 = getViewLifecycleOwner();
            n.e(obj4, str2);
            p.a aVar = new p.a(this);
            D1().m().observe(obj4, aVar);
        }
        n.w("binding");
        throw i;
    }
}
