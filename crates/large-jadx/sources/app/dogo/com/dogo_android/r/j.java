package app.dogo.com.dogo_android.r;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ch;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/reminder/TrainingReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTrainingReminderWithTimeBinding;", "viewModel", "Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weekdayButtons", "", "Landroid/widget/CompoundButton;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment {

    private ch a;
    private final h b;
    private final List<CompoundButton> c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.r.l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.r.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
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
        j.a aVar = new j.a(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, aVar);
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
    }

    private final app.dogo.com.dogo_android.r.l B1() {
        return (l)this.b.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.r.j j, Boolean boolean2) {
        j.H1(j, boolean2);
    }

    public static void D1(app.dogo.com.dogo_android.r.j j, View view2) {
        j.G1(j, view2);
    }

    public static void E1(app.dogo.com.dogo_android.r.j j, Boolean boolean2) {
        j.I1(j, boolean2);
    }

    public static void F1(app.dogo.com.dogo_android.r.j j, View view2) {
        j.J1(j, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.r.j j, View view2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void H1(app.dogo.com.dogo_android.r.j j, Boolean boolean2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void I1(app.dogo.com.dogo_android.r.j j, Boolean boolean2) {
        Object obj1;
        boolean obj2;
        n.f(j, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            j.B1().p(j.c);
        }
    }

    private static final void J1(app.dogo.com.dogo_android.r.j j, View view2) {
        Object obj0;
        boolean obj1;
        n.f(j, "this$0");
        if (j.B1().m()) {
            j.B1().w();
        } else {
            obj0 = j.getActivity();
            if (obj0 == null) {
            } else {
                g1.g0(obj0, 2131887194);
            }
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
        ch obj2 = ch.T(layoutInflater, viewGroup2, false);
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
                obj2.W(B1());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(Boolean.FALSE);
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
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        ch chVar = this.a;
        final int i = 0;
        final String str3 = "binding";
        if (chVar == null) {
        } else {
            android.widget.LinearLayout linearLayout = chVar.O;
            n.e(linearLayout, "binding.checkGroupView");
            m.Companion.a(this.c, linearLayout);
            ch obj5 = this.a;
            if (obj5 == null) {
            } else {
                b obj6 = new b(this);
                obj5.b0.setNavigationOnClickListener(obj6);
                obj6 = getViewLifecycleOwner();
                n.e(obj6, "viewLifecycleOwner");
                a aVar = new a(this);
                B1().r().observe(obj6, aVar);
                B1().x();
                c cVar = new c(this);
                B1().v().observe(getViewLifecycleOwner(), cVar);
                obj5 = this.a;
                if (obj5 == null) {
                } else {
                    obj6 = new d(this);
                    obj5.R.setOnClickListener(obj6);
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
