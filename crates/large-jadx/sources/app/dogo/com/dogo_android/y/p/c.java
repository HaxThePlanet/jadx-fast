package app.dogo.com.dogo_android.y.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.gf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.n.i;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramExamsCompletedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private gf a;
    private final app.dogo.com.dogo_android.y.p.d B1() {
        return (d)k1.a(this);
    }

    public static void C1(app.dogo.com.dogo_android.y.p.c c, View view2) {
        c.E1(c, view2);
    }

    public static void D1(app.dogo.com.dogo_android.y.p.c c, View view2) {
        c.F1(c, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.y.p.c c, View view2) {
        n.f(c, "this$0");
        final androidx.fragment.app.e obj0 = c.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void F1(app.dogo.com.dogo_android.y.p.c c, View view2) {
        n.f(c, "this$0");
        i iVar = new i(c.B1().b(), c.B1().a(), "all_exams_completed", c.B1().getFragmentReturnTag());
        g1.n(c.getActivity(), iVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        gf obj1 = gf.T(layoutInflater, viewGroup2, false);
        n.e(obj1, "inflate(inflater, container, false)");
        this.a = obj1;
        if (obj1 == null) {
        } else {
            return obj1.w();
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        gf obj3 = this.a;
        String obj4 = "binding";
        i = 0;
        if (obj3 == null) {
        } else {
            obj3.M(getViewLifecycleOwner());
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                a aVar = new a(this);
                obj3.P.setOnClickListener(aVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    obj4 = new b(this);
                    obj3.Q.setOnClickListener(obj4);
                    obj3 = getActivity();
                    if (obj3 instanceof a0) {
                        i = obj3;
                    }
                    if (i == 0) {
                    } else {
                        i.F();
                    }
                }
                n.w(obj4);
                throw i;
            }
            n.w(obj4);
            throw i;
        }
        n.w(obj4);
        throw i;
    }
}
