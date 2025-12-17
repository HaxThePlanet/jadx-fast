package app.dogo.com.dogo_android.y.d0;

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
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.kd;
import app.dogo.com.dogo_android.m.b;
import app.dogo.com.dogo_android.m.d;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0018H\u0016J\u0008\u0010\u001a\u001a\u00020\u0018H\u0016J\u0008\u0010\u001b\u001a\u00020\u0018H\u0016J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleVideoBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleScreen;", "viewModel", "Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onResume", "onStart", "onStop", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment {

    private final h a;
    private kd b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.y.d0.j a;
        public a(app.dogo.com.dogo_android.y.d0.j j) {
            this.a = j;
            super();
        }

        public final void onChanged(T t) {
            n.e((Throwable)t, "it");
            j.b bVar = new j.b(this.a);
            j.c cVar = new j.c(this.a);
            f1.W(this.a, t, bVar, cVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.y.d0.j this$0;
        b(app.dogo.com.dogo_android.y.d0.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.C1(this.this$0).r();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.y.d0.j this$0;
        c(app.dogo.com.dogo_android.y.d0.j j) {
            this.this$0 = j;
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<b> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final b invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(b.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.y.d0.j this$0;
        e(app.dogo.com.dogo_android.y.d0.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(j.B1(this.this$0).a());
        }
    }
    static {
    }

    public j() {
        super();
        j.e eVar = new j.e(this);
        j.d dVar = new j.d(this, 0, eVar);
        this.a = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final app.dogo.com.dogo_android.y.d0.k B1(app.dogo.com.dogo_android.y.d0.j j) {
        return j.D1();
    }

    public static final b C1(app.dogo.com.dogo_android.y.d0.j j) {
        return j.E1();
    }

    private final app.dogo.com.dogo_android.y.d0.k D1() {
        return (k)k1.a(this);
    }

    private final b E1() {
        return (b)this.a.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.y.d0.j j, Boolean boolean2) {
        j.H1(j, boolean2);
    }

    public static void G1(app.dogo.com.dogo_android.y.d0.j j, View view2) {
        j.I1(j, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.y.d0.j j, Boolean boolean2) {
        n.f(j, "this$0");
        i iVar = new i(j.D1().a(), j.D1().getFragmentReturnTag());
        g1.n(j.getActivity(), iVar);
    }

    private static final void I1(app.dogo.com.dogo_android.y.d0.j j, View view2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        kd obj2 = kd.T(getLayoutInflater(), viewGroup2, false);
        n.e(obj2, "inflate(layoutInflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(E1());
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        kd kdVar = this.b;
        final int i = 0;
        if (kdVar == null) {
        } else {
            kdVar.R.setAdapter(i);
            super.onDestroyView();
        }
        n.w("binding");
        throw i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity;
        super.onResume();
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        int i;
        super.onStart();
        kd kdVar = this.b;
        if (kdVar == null) {
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = kdVar.R.getAdapter();
            if (adapter instanceof d) {
                i = adapter;
            }
            if (i == 0) {
            } else {
                i.j();
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        int i;
        super.onStop();
        kd kdVar = this.b;
        if (kdVar == null) {
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = kdVar.R.getAdapter();
            if (adapter instanceof d) {
                i = adapter;
            }
            if (i == 0) {
            } else {
                i.l();
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        b bVar = new b(this);
        E1().l().observe(getViewLifecycleOwner(), bVar);
        androidx.lifecycle.q obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        j.a aVar = new j.a(this);
        E1().m().observe(obj3, aVar);
        kd obj2 = this.b;
        if (obj2 == null) {
        } else {
            obj3 = new c(this);
            obj2.W.setNavigationOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}
