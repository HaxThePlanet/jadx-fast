package app.dogo.com.dogo_android.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.d;
import app.dogo.com.dogo_android.h.c9;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.main_screen.MainScreenActivity;
import com.google.android.play.core.review.ReviewInfo;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/view/RatePromptDialogV2;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogInAppRateBinding;", "viewModel", "Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "getViewModel", "()Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends d {

    private final h a;
    private c9 b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<d> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(d.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.view.m this$0;
        b(app.dogo.com.dogo_android.view.m m) {
            this.this$0 = m;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b((n)k1.a(this.this$0).getSource());
        }
    }
    static {
    }

    public m() {
        super();
        m.b bVar = new m.b(this);
        m.a aVar = new m.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final d B1() {
        return (d)this.a.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.view.m m, ReviewInfo reviewInfo2) {
        m.H1(m, reviewInfo2);
    }

    public static void D1(app.dogo.com.dogo_android.view.m m, Boolean boolean2) {
        m.F1(m, boolean2);
    }

    public static void E1(app.dogo.com.dogo_android.view.m m, Boolean boolean2) {
        m.G1(m, boolean2);
    }

    private static final void F1(app.dogo.com.dogo_android.view.m m, Boolean boolean2) {
        n.f(m, "this$0");
        final Dialog obj0 = m.getDialog();
        if (obj0 == null) {
        } else {
            obj0.dismiss();
        }
    }

    private static final void G1(app.dogo.com.dogo_android.view.m m, Boolean boolean2) {
        n.f(m, "this$0");
        androidx.fragment.app.e obj1 = m.getActivity();
        if (obj1 == null) {
        } else {
            g1.g(obj1);
        }
        final Dialog obj0 = m.getDialog();
        if (obj0 == null) {
        } else {
            obj0.dismiss();
        }
    }

    private static final void H1(app.dogo.com.dogo_android.view.m m, ReviewInfo reviewInfo2) {
        String activity;
        String source;
        n.f(m, "this$0");
        if (reviewInfo2 != null) {
            if (activity instanceof MainScreenActivity != null) {
            } else {
                activity = 0;
            }
            if (activity == null) {
            } else {
                activity.d1(reviewInfo2, (n)k1.a(m).getSource());
            }
        }
        final Dialog obj2 = m.getDialog();
        if (obj2 == null) {
        } else {
            obj2.dismiss();
        }
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        androidx.lifecycle.q viewLifecycleOwner;
        Object obj3;
        n.f(layoutInflater, "inflater");
        int obj5 = 0;
        obj3 = c9.T(layoutInflater, viewGroup2, obj5);
        n.e(obj3, "inflate(inflater, container, false)");
        this.b = obj3;
        int obj4 = 0;
        final String str = "binding";
        if (obj3 == null) {
        } else {
            obj3.V(B1());
            obj3 = this.b;
            if (obj3 == null) {
            } else {
                obj3.M(getViewLifecycleOwner());
                obj3 = getDialog();
                if (obj3 == null) {
                } else {
                    obj3 = obj3.getWindow();
                    if (obj3 == null) {
                    } else {
                        obj3.setBackgroundDrawableResource(2131230940);
                    }
                }
                obj3 = getDialog();
                if (obj3 == null) {
                } else {
                    obj3.setCanceledOnTouchOutside(obj5);
                }
                obj3 = this.b;
                if (obj3 == null) {
                } else {
                    return obj3.w();
                }
                n.w(str);
                throw obj4;
            }
            n.w(str);
            throw obj4;
        }
        n.w(str);
        throw obj4;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.lifecycle.q obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        c cVar = new c(this);
        B1().k().observe(obj4, cVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        d dVar = new d(this);
        B1().m().observe(obj4, dVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        b bVar = new b(this);
        B1().l().observe(obj4, bVar);
    }
}
