package app.dogo.com.dogo_android.y.c0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ag;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
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
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0011H\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/TaskListCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTaskBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTaskCompleted", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "onTasksCompletedButtonClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends Fragment implements app.dogo.com.dogo_android.y.c0.g {

    private ag a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.y.c0.d this$0;
        a(app.dogo.com.dogo_android.y.c0.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            Object obj2;
            n.f(d, "$this$addCallback");
            if (d.C1(this.this$0).q()) {
                d.C1(this.this$0).r();
            } else {
                obj2 = this.this$0.getActivity();
                if (obj2 == null) {
                } else {
                    g1.O(obj2);
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.y.c0.d this$0;
        b(app.dogo.com.dogo_android.y.c0.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            d.C1(this.this$0).r();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.y.c0.d this$0;
        c(app.dogo.com.dogo_android.y.c0.d d) {
            this.this$0 = d;
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
                g1.O(activity);
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.y.c0.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.c0.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.y.c0.d this$0;
        e(app.dogo.com.dogo_android.y.c0.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(d.B1(this.this$0).b(), d.B1(this.this$0).a());
        }
    }
    static {
    }

    public d() {
        super();
        d.e eVar = new d.e(this);
        d.d dVar = new d.d(this, 0, eVar);
        this.b = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final app.dogo.com.dogo_android.y.c0.e B1(app.dogo.com.dogo_android.y.c0.d d) {
        return d.D1();
    }

    public static final app.dogo.com.dogo_android.y.c0.f C1(app.dogo.com.dogo_android.y.c0.d d) {
        return d.E1();
    }

    private final app.dogo.com.dogo_android.y.c0.e D1() {
        return (e)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.c0.f E1() {
        return (f)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.y.c0.d d, View view2) {
        d.I1(d, view2);
    }

    public static void G1(app.dogo.com.dogo_android.y.c0.d d, y y2) {
        d.J1(d, y2);
    }

    public static void H1(app.dogo.com.dogo_android.y.c0.d d, Boolean boolean2) {
        d.K1(d, boolean2);
    }

    private static final void I1(app.dogo.com.dogo_android.y.c0.d d, View view2) {
        n.f(d, "this$0");
        final androidx.fragment.app.e obj0 = d.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.y.c0.d d, y y2) {
        boolean bVar;
        app.dogo.com.dogo_android.y.c0.d.c cVar;
        String str;
        Object obj4;
        n.f(d, "this$0");
        if (y2 instanceof y.a) {
            a.d((y.a)y2.a());
            Exception exception = new Exception(y2.a());
            obj4 = d.requireContext();
            n.e(obj4, "requireContext()");
            bVar = new d.b(d);
            cVar = new d.c(d);
            f1.m0(d, n.a.i(exception, obj4), bVar, cVar);
        }
    }

    private static final void K1(app.dogo.com.dogo_android.y.c0.d d, Boolean boolean2) {
        n.f(d, "this$0");
        final androidx.fragment.app.e obj0 = d.getActivity();
        if (obj0 == null) {
        } else {
            g1.O(obj0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j1() {
        E1().t();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ag obj2 = ag.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.W(E1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.a;
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
        ag obj7 = this.a;
        if (obj7 == null) {
        } else {
            a obj8 = new a(this);
            obj7.O.setNavigationOnClickListener(obj8);
            androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
            n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
            d.a aVar = new d.a(this);
            e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar, 2, 0);
            obj8 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(obj8, str2);
            b bVar = new b(this);
            E1().n().observe(obj8, bVar);
            obj8 = getViewLifecycleOwner();
            n.e(obj8, str2);
            c cVar = new c(this);
            E1().k().observe(obj8, cVar);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void y(ProgramTasks programTasks) {
        n.f(programTasks, "item");
        E1().s(programTasks);
    }
}
