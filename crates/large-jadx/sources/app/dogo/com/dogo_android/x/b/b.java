package app.dogo.com.dogo_android.x.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wg;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.g;
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
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00172\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTimeGoalNotAchievedScreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goToNextScreen", "", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends Fragment {

    private wg a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {

        final app.dogo.com.dogo_android.x.b.b this$0;
        a(app.dogo.com.dogo_android.x.b.b b) {
            this.this$0 = b;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            Object obj2;
            n.f(d, "$this$addCallback");
            obj2 = b.B1(this.this$0).b();
            app.dogo.com.dogo_android.x.b.b this$0 = this.this$0;
            if (obj2 != null) {
                b.C1(this$0, obj2);
            } else {
                obj2 = this$0.getActivity();
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.x.b.d> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.x.b.d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(d.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.x.b.b this$0;
        c(app.dogo.com.dogo_android.x.b.b b) {
            this.this$0 = b;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[3];
            return b.b(b.B1(this.this$0).e(), b.B1(this.this$0).f(), b.B1(this.this$0).g());
        }
    }
    static {
    }

    public b() {
        super();
        b.c cVar = new b.c(this);
        b.b bVar = new b.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.x.b.c B1(app.dogo.com.dogo_android.x.b.b b) {
        return b.D1();
    }

    public static final void C1(app.dogo.com.dogo_android.x.b.b b, j j2) {
        b.F1(j2);
    }

    private final app.dogo.com.dogo_android.x.b.c D1() {
        return (c)k1.a(this);
    }

    private final app.dogo.com.dogo_android.x.b.d E1() {
        return (d)this.b.getValue();
    }

    private final void F1(j j) {
        app.dogo.com.dogo_android.x.b.c activity2;
        androidx.fragment.app.e activity;
        String fragmentReturnTag;
        j jVar;
        int i;
        int i2;
        int i3;
        if (D1().a()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.f(activity, D1().getFragmentReturnTag(), j, false, 4, 0);
            }
        } else {
            activity2 = getActivity();
            if (activity2 == null) {
            } else {
                g1.n(activity2, j);
            }
        }
    }

    public static void G1(app.dogo.com.dogo_android.x.b.b b, View view2) {
        b.H1(b, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.x.b.b b, View view2) {
        n.f(b, "this$0");
        final androidx.fragment.app.e obj0 = b.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
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
        wg obj2 = wg.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        b.a aVar = new b.a(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, aVar, 2, 0);
        wg obj7 = this.a;
        if (obj7 == null) {
        } else {
            a obj8 = new a(this);
            obj7.Q.setOnClickListener(obj8);
            E1().p();
        }
        n.w("binding");
        throw 0;
    }
}
