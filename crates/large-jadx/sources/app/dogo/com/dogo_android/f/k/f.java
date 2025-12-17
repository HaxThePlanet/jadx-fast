package app.dogo.com.dogo_android.f.k;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.f.j.c;
import app.dogo.com.dogo_android.f.l.k;
import app.dogo.com.dogo_android.h.qa;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDailyWorkoutOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewScreen;", "viewModel", "Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends Fragment {

    private qa a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.f.k.f a;
        public a(app.dogo.com.dogo_android.f.k.f f) {
            this.a = f;
            super();
        }

        public final void onChanged(T t) {
            boolean bVar;
            Exception i;
            int obj3;
            if (t instanceof y.a) {
            } else {
                obj3 = i;
            }
            if (obj3 == null) {
            } else {
                i = obj3.a();
            }
            if (i instanceof UnknownHostException != null) {
                obj3 = this.a.getActivity();
                if (obj3 == null) {
                } else {
                    bVar = new f.b(this.a);
                    f1.h0(obj3, bVar);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.f.k.f this$0;
        b(app.dogo.com.dogo_android.f.k.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            f.B1(this.this$0).n();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.f.k.h> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.f.k.h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public f() {
        super();
        final int i = 0;
        f.c cVar = new f.c(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.f.k.h B1(app.dogo.com.dogo_android.f.k.f f) {
        return f.D1();
    }

    private final app.dogo.com.dogo_android.f.k.g C1() {
        return (g)k1.a(this);
    }

    private final app.dogo.com.dogo_android.f.k.h D1() {
        return (h)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.f.k.f f, WorkoutSession workoutSession2) {
        f.I1(f, workoutSession2);
    }

    public static void F1(app.dogo.com.dogo_android.f.k.f f, View view2) {
        f.J1(f, view2);
    }

    public static void G1(app.dogo.com.dogo_android.f.k.f f, View view2) {
        f.H1(f, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.f.k.f f, View view2) {
        n.f(f, "this$0");
        f.D1().p();
        c obj2 = new c("daily_workout_overview");
        g1.n(f.getActivity(), obj2);
    }

    private static final void I1(app.dogo.com.dogo_android.f.k.f f, WorkoutSession workoutSession2) {
        n.f(f, "this$0");
        f.D1().q();
        n.e(workoutSession2, "it");
        k kVar = new k(workoutSession2, f.C1().getFragmentReturnTag());
        g1.n(f.getActivity(), kVar);
    }

    private static final void J1(app.dogo.com.dogo_android.f.k.f f, View view2) {
        n.f(f, "this$0");
        final androidx.fragment.app.e obj0 = f.getActivity();
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
        qa obj2 = qa.T(layoutInflater, viewGroup2, false);
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
                obj2.V(D1());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        qa obj5 = this.a;
        int obj6 = 0;
        String str2 = "binding";
        if (obj5 == null) {
        } else {
            c cVar = new c(this);
            obj5.O.setOnClickListener(cVar);
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            final String str3 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner, str3);
            a aVar2 = new a(this);
            D1().j().observe(viewLifecycleOwner, aVar2);
            obj5 = this.a;
            if (obj5 == null) {
            } else {
                obj6 = new b(this);
                obj5.Q.setNavigationOnClickListener(obj6);
                obj6 = getViewLifecycleOwner();
                n.e(obj6, str3);
                f.a aVar = new f.a(this);
                D1().i().observe(obj6, aVar);
            }
            n.w(str2);
            throw obj6;
        }
        n.w(str2);
        throw obj6;
    }
}
