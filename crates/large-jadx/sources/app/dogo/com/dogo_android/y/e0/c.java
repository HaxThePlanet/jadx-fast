package app.dogo.com.dogo_android.y.e0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.eg;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.s.k;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTrickTryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel;", "viewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private eg a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryFragment$onCreateView$3", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {
        a() {
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
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
    public static final class c extends p implements a<app.dogo.com.dogo_android.y.e0.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.e0.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.y.e0.c this$0;
        d(app.dogo.com.dogo_android.y.e0.c c) {
            this.this$0 = c;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(p.X(c.B1(this.this$0).b().getTrainingTricksList()), c.B1(this.this$0).a());
        }
    }
    static {
    }

    public c() {
        super();
        final int i = 0;
        c.b bVar = new c.b(this, i, i);
        this.b = j.a(m.NONE, bVar);
        c.d dVar = new c.d(this);
        c.c cVar = new c.c(this, i, dVar);
        this.c = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.y.e0.d B1(app.dogo.com.dogo_android.y.e0.c c) {
        return c.C1();
    }

    private final app.dogo.com.dogo_android.y.e0.d C1() {
        return (d)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.e0.e D1() {
        return (e)this.c.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.e0.c c, View view2) {
        c.H1(c, view2);
    }

    public static void F1(app.dogo.com.dogo_android.y.e0.c c, View view2) {
        c.G1(c, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.y.e0.c c, View view2) {
        n.f(c, "this$0");
        c.D1().j();
        final k kVar = obj8;
        super(c.C1().a().getLessonId(), c.C1().a().getProgramId(), c.C1().getFragmentParentReturnTag(), 0, 0);
        g1.f(c.getActivity(), c.C1().getFragmentReturnTag(), kVar, false, 4, 0);
    }

    private static final void H1(app.dogo.com.dogo_android.y.e0.c c, View view2) {
        n.f(c, "this$0");
        c.D1().i();
        super(c.C1().b().getTrainingTricksList(), c.C1().a(), 0, 0, 1, 12, 0);
        m mVar = new m(bVar2, c.C1().getTag(), c.C1().getFragmentParentReturnTag(), "trick_try");
        g1.n(c.getActivity(), mVar);
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
        eg obj3 = eg.T(layoutInflater, viewGroup2, false);
        n.e(obj3, "inflate(inflater, container, false)");
        this.a = obj3;
        int obj4 = 0;
        String obj5 = "binding";
        if (obj3 == null) {
        } else {
            obj3.M(getViewLifecycleOwner());
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj3.V(D1());
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    b bVar = new b(this);
                    obj3.Q.setOnClickListener(bVar);
                    obj3 = this.a;
                    if (obj3 == null) {
                    } else {
                        a aVar = new a(this);
                        obj3.P.setOnClickListener(aVar);
                        c.a aVar2 = new c.a();
                        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), aVar2);
                        obj3 = this.a;
                        if (obj3 == null) {
                        } else {
                            return obj3.w();
                        }
                        n.w(obj5);
                        throw obj4;
                    }
                    n.w(obj5);
                    throw obj4;
                }
                n.w(obj5);
                throw obj4;
            }
            n.w(obj5);
            throw obj4;
        }
        n.w(obj5);
        throw obj4;
    }
}
