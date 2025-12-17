package app.dogo.com.dogo_android.x.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.ke;
import app.dogo.com.dogo_android.r.n;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentMetricsIntroDailyTimeBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends Fragment {

    private ke a;
    private final app.dogo.com.dogo_android.x.c.f B1() {
        return (f)k1.a(this);
    }

    public static void C1(app.dogo.com.dogo_android.x.c.e e, View view2) {
        e.E1(e, view2);
    }

    public static void D1(app.dogo.com.dogo_android.x.c.e e, View view2) {
        e.F1(e, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.x.c.e e, View view2) {
        n.f(e, "this$0");
        final androidx.fragment.app.e obj0 = e.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void F1(app.dogo.com.dogo_android.x.c.e e, View view2) {
        n.f(e, "this$0");
        n nVar = new n("dashboard", e.B1().getFragmentParentReturnTag());
        g1.n(e.getActivity(), nVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ke obj2 = ke.T(layoutInflater, viewGroup2, false);
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
            obj3.F();
        }
        obj3 = this.a;
        String obj4 = "binding";
        if (obj3 == null) {
        } else {
            a aVar = new a(this);
            obj3.P.setNavigationOnClickListener(aVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new b(this);
                obj3.O.setOnClickListener(obj4);
            }
            n.w(obj4);
            throw i;
        }
        n.w(obj4);
        throw i;
    }
}
