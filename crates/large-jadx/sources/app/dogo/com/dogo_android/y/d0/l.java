package app.dogo.com.dogo_android.y.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.cg;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0008\u0010!\u001a\u00020\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010$\u001a\u00020\u001e2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTrainingPlanBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onResume", "onViewCreated", "view", "startTraining", "selectedTrick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends Fragment implements app.dogo.com.dogo_android.y.d0.n.a {

    private cg a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
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
    public static final class b extends p implements a<app.dogo.com.dogo_android.y.d0.o> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.d0.o invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(o.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.y.d0.l this$0;
        c(app.dogo.com.dogo_android.y.d0.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(l.B1(this.this$0).b(), l.B1(this.this$0).a());
        }
    }
    static {
    }

    public l() {
        super();
        l.c cVar = new l.c(this);
        final int i = 0;
        l.b bVar = new l.b(this, i, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
        l.a aVar = new l.a(this, i, i);
        this.c = j.a(m.NONE, aVar);
    }

    public static final app.dogo.com.dogo_android.y.d0.m B1(app.dogo.com.dogo_android.y.d0.l l) {
        return l.C1();
    }

    private final app.dogo.com.dogo_android.y.d0.m C1() {
        return (m)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.d0.o D1() {
        return (o)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.d0.l l, View view2) {
        l.H1(l, view2);
    }

    public static void F1(app.dogo.com.dogo_android.y.d0.l l, View view2) {
        l.G1(l, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.y.d0.l l, View view2) {
        n.f(l, "this$0");
        l.requireActivity().onBackPressed();
    }

    private static final void H1(app.dogo.com.dogo_android.y.d0.l l, View view2) {
        n.f(l, "this$0");
        l.getSharedViewModel().d0(l.C1().b());
        int obj2 = 0;
        l.J1(l, obj2, 1, obj2);
    }

    private final void I1(TrickItem trickItem) {
        super(j1.E0(C1().b().getTrainingTricksList(), trickItem), C1().a(), 0, 0, 0, 24, 0);
        m mVar2 = new m(bVar2, C1().getFragmentParentReturnTag(), C1().getFragmentParentReturnTag(), "lesson");
        g1.n(getActivity(), mVar2);
    }

    static void J1(app.dogo.com.dogo_android.y.d0.l l, TrickItem trickItem2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        l.I1(obj1);
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void R(TrickItem trickItem) {
        n.f(trickItem, "item");
        getSharedViewModel().d0(C1().b());
        I1(trickItem);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        cg obj2 = cg.T(layoutInflater, viewGroup2, false);
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
                obj2.X(D1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.W(getSharedViewModel());
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
        n.w(obj4);
        throw obj3;
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
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        getSharedViewModel().d0(C1().b());
        cg obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            e eVar = new e(this);
            obj3.P.setNavigationOnClickListener(eVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new d(this);
                obj3.O.setOnClickListener(obj4);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
