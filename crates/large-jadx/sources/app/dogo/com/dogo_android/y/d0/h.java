package app.dogo.com.dogo_android.y.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.id;
import app.dogo.com.dogo_android.util.e0.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;)V", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends Fragment {

    public id a;
    public static void C1(app.dogo.com.dogo_android.y.d0.h h, View view2) {
        h.D1(h, view2);
    }

    private static final void D1(app.dogo.com.dogo_android.y.d0.h h, View view2) {
        n.f(h, "this$0");
        final androidx.fragment.app.e obj0 = h.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final id B1() {
        id idVar = this.a;
        if (idVar == null) {
        } else {
            return idVar;
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void E1(id id) {
        n.f(id, "<set-?>");
        this.a = id;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        id obj1 = id.T(layoutInflater, viewGroup2, false);
        n.e(obj1, "inflate(inflater, container, false)");
        E1(obj1);
        B1().M(getViewLifecycleOwner());
        return B1().w();
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
        a obj3 = new a(this);
        obj2.O.setNavigationOnClickListener(obj3);
    }
}
