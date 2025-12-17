package app.dogo.com.dogo_android.util.m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008&\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B1\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0007j\u0008\u0012\u0004\u0012\u00028\u0000`\u000b¢\u0006\u0002\u0010\u000cJ&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00082\u0008\u0010 \u001a\u0004\u0018\u00010\t2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u00028\u0000X\u0086.¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R2\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0007j\u0008\u0012\u0004\u0012\u00028\u0000`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001a¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "VB", "Landroidx/databinding/ViewDataBinding;", "SK", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroidx/fragment/app/Fragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Lapp/dogo/com/dogo_android/util/navigation/Inflate;", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/databinding/ViewDataBinding;", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "screenKey", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "viewModel", "getViewModel", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class b<VB extends ViewDataBinding, SK extends app.dogo.com.dogo_android.y.j>  extends Fragment {

    private final q<LayoutInflater, ViewGroup, Boolean, VB> a;
    private VB b;
    public VB c;
    public b(q<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> q) {
        n.f(q, "inflate");
        super();
        this.a = q;
    }

    public final VB B1() {
        ViewDataBinding view = this.c;
        if (view == null) {
        } else {
            return view;
        }
        n.w("binding");
        throw 0;
    }

    public final SK C1() {
        return k1.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public abstract s D1();

    @Override // androidx.fragment.app.Fragment
    public abstract s E1();

    public final void F1(VB vb) {
        n.f(vb, "<set-?>");
        this.c = vb;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int obj3;
        Object obj4;
        n.f(layoutInflater, "inflater");
        Object obj2 = this.a.invoke(layoutInflater, viewGroup2, Boolean.FALSE);
        this.b = (ViewDataBinding)obj2;
        if (obj2 == null) {
        } else {
            obj2.O(177, E1());
        }
        obj2 = this.b;
        if (obj2 == null) {
        } else {
            obj2.O(141, D1());
        }
        obj2 = this.b;
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
        }
        obj2 = this.b;
        if (obj2 == null) {
        } else {
            obj2.O(29, this);
        }
        obj2 = this.b;
        n.d(obj2);
        F1(obj2);
        return B1().w();
    }
}
