package app.dogo.com.dogo_android.dogcreation.o;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.h.yb;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/welcome/DogCreationWelcomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationWelcomeBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private yb a;
    public static void B1(app.dogo.com.dogo_android.dogcreation.o.c c, View view2) {
        c.E1(c, view2);
    }

    public static void C1(app.dogo.com.dogo_android.dogcreation.o.c c, View view2) {
        c.D1(c, view2);
    }

    private static final void D1(app.dogo.com.dogo_android.dogcreation.o.c c, View view2) {
        androidx.fragment.app.e obj0;
        n.f(c, "this$0");
        if (obj0 instanceof DogCreationActivity != null) {
        } else {
            obj0 = 0;
        }
        if (obj0 == null) {
        } else {
            obj0.A();
        }
    }

    private static final void E1(app.dogo.com.dogo_android.dogcreation.o.c c, View view2) {
        androidx.fragment.app.e obj0;
        n.f(c, "this$0");
        if (obj0 instanceof DogCreationActivity != null) {
        } else {
            obj0 = 0;
        }
        if (obj0 == null) {
        } else {
            obj0.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        yb obj2 = yb.T(layoutInflater, viewGroup2, false);
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
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        yb obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            b bVar = new b(this);
            obj3.P.setOnClickListener(bVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new a(this);
                obj3.Q.setOnClickListener(obj4);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
