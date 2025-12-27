package app.dogo.com.dogo_android.util.m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.n;

/* compiled from: BaseFragment.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008&\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B1\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0007j\u0008\u0012\u0004\u0012\u00028\u0000`\u000b¢\u0006\u0002\u0010\u000cJ&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00082\u0008\u0010 \u001a\u0004\u0018\u00010\t2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u00028\u0000X\u0086.¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R2\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0007j\u0008\u0012\u0004\u0012\u00028\u0000`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001a¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "VB", "Landroidx/databinding/ViewDataBinding;", "SK", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroidx/fragment/app/Fragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Lapp/dogo/com/dogo_android/util/navigation/Inflate;", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/databinding/ViewDataBinding;", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "screenKey", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "viewModel", "getViewModel", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public abstract class BaseFragment<VB extends ViewDataBinding, SK extends j> extends Fragment {

    private final q<LayoutInflater, ViewGroup, Boolean, VB> a;
    /* renamed from: b, reason: from kotlin metadata */
    private VB inflate;
    public VB c;
    public b(q<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> qVar) {
        n.f(qVar, "inflate");
        super();
        this.a = qVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final VB B1() {
        if (this.c == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.c;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final SK C1() {
        return app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void F1(VB vb) {
        n.f(vb, "<set-?>");
        this.c = vb;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = 177;
        s sVar;
        n.f(inflater, "inflater");
        Object invoke = this.a.invoke(inflater, container, Boolean.FALSE);
        this.inflate = invoke;
        if (invoke != null) {
            i = 177;
            invoke.O(i, E1());
        }
        if (this.inflate != null) {
            i = 141;
            this.inflate.O(i, D1());
        }
        if (this.inflate != null) {
            this.inflate.M(getViewLifecycleOwner());
        }
        if (this.inflate != null) {
            i = 29;
            this.inflate.O(i, this);
        }
        n.d(this.inflate);
        F1(this.inflate);
        return B1().w();
    }

    @Override // androidx.fragment.app.Fragment
    public abstract s D1();

    @Override // androidx.fragment.app.Fragment
    public abstract s E1();
}
