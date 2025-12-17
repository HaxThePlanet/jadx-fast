package app.dogo.com.dogo_android.dogcreation.n;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.l.n;
import app.dogo.com.dogo_android.dogcreation.o.d;
import app.dogo.com.dogo_android.h.wb;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.r.m;
import app.dogo.com.dogo_android.r.m.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import java.util.ArrayList;
import java.util.List;
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
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/reminder/DogCreationReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationReminderWithTimeBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "viewModel$delegate", "weekdayButtons", "", "Landroid/widget/CompoundButton;", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends Fragment {

    private wb a;
    private final h b;
    private final h c;
    private final List<CompoundButton> v;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
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
    public static final class b extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public h() {
        super();
        final int i = 0;
        h.a aVar = new h.a(this, i, i);
        this.b = j.a(m.NONE, aVar);
        h.b bVar = new h.b(this, i, i);
        this.c = j.a(m.SYNCHRONIZED, bVar);
        ArrayList arrayList = new ArrayList();
        this.v = arrayList;
    }

    private final g B1() {
        return (g)this.b.getValue();
    }

    private final l C1() {
        return (l)this.c.getValue();
    }

    private final void D1() {
        androidx.fragment.app.e activity;
        app.dogo.com.dogo_android.y.j nVar;
        if (B1().isUserSignedIn()) {
            if (B1().q()) {
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
            B1().r(k1.a(this));
            activity = getActivity();
            if (activity == null) {
            } else {
                nVar = new n();
                g1.n(activity, nVar);
            }
        }
    }

    public static void E1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        h.Q1(h, view2);
    }

    public static void F1(app.dogo.com.dogo_android.dogcreation.n.h h, y y2) {
        h.P1(h, y2);
    }

    public static void G1(app.dogo.com.dogo_android.dogcreation.n.h h, Boolean boolean2) {
        h.R1(h, boolean2);
    }

    public static void H1(app.dogo.com.dogo_android.dogcreation.n.h h, Boolean boolean2) {
        h.M1(h, boolean2);
    }

    public static void I1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        h.O1(h, view2);
    }

    public static void J1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        h.N1(h, view2);
    }

    public static void K1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        h.L1(h, view2);
    }

    private static final void L1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        n.f(h, "this$0");
        final androidx.fragment.app.e obj0 = h.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.dogcreation.n.h h, Boolean boolean2) {
        n.f(h, "this$0");
        h.D1();
    }

    private static final void N1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        n.f(h, "this$0");
        h.D1();
    }

    private static final void O1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        n.f(h, "this$0");
        final androidx.fragment.app.e obj0 = h.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void P1(app.dogo.com.dogo_android.dogcreation.n.h h, y y2) {
        Exception i;
        Object obj2;
        int obj3;
        n.f(h, "this$0");
        if (y2 instanceof y.a) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            i = obj3.a();
        }
        if (i instanceof UnknownHostException != null) {
            obj2 = h.getActivity();
            if (obj2 == null) {
            } else {
                g1.g0(obj2, 2131886953);
            }
        }
    }

    private static final void Q1(app.dogo.com.dogo_android.dogcreation.n.h h, View view2) {
        Object obj0;
        boolean obj1;
        n.f(h, "this$0");
        if (h.C1().m()) {
            h.C1().w();
        } else {
            obj0 = h.getActivity();
            if (obj0 == null) {
            } else {
                g1.g0(obj0, 2131887194);
            }
        }
    }

    private static final void R1(app.dogo.com.dogo_android.dogcreation.n.h h, Boolean boolean2) {
        Object obj1;
        boolean obj2;
        n.f(h, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            h.C1().p(h.v);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        wb obj2 = wb.T(layoutInflater, viewGroup2, false);
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
                obj2.V(C1());
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
    public void onResume() {
        app.dogo.com.dogo_android.repository.domain.DogProfile activity;
        boolean z;
        super.onResume();
        if (B1().l() == null) {
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
        wb wbVar = this.a;
        final int i = 0;
        final String str3 = "binding";
        if (wbVar == null) {
        } else {
            android.widget.LinearLayout linearLayout = wbVar.O;
            n.e(linearLayout, "binding.checkGroupView");
            m.Companion.a(this.v, linearLayout);
            wb obj5 = this.a;
            if (obj5 == null) {
            } else {
                g obj6 = new g(this);
                obj5.X.setNavigationOnClickListener(obj6);
                obj6 = getViewLifecycleOwner();
                n.e(obj6, "viewLifecycleOwner");
                d dVar = new d(this);
                C1().r().observe(obj6, dVar);
                obj5 = this.a;
                if (obj5 == null) {
                } else {
                    obj6 = new f(this);
                    obj5.Y.setOnClickListener(obj6);
                    obj5 = this.a;
                    if (obj5 == null) {
                    } else {
                        obj6 = new e(this);
                        obj5.X.setNavigationOnClickListener(obj6);
                        b bVar = new b(this);
                        C1().u().observe(getViewLifecycleOwner(), bVar);
                        obj5 = this.a;
                        if (obj5 == null) {
                        } else {
                            obj6 = new a(this);
                            obj5.P.setOnClickListener(obj6);
                            C1().x();
                            c cVar = new c(this);
                            C1().v().observe(getViewLifecycleOwner(), cVar);
                        }
                        n.w(str3);
                        throw i;
                    }
                    n.w(str3);
                    throw i;
                }
                n.w(str3);
                throw i;
            }
            n.w(str3);
            throw i;
        }
        n.w(str3);
        throw i;
    }
}
