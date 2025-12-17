package app.dogo.com.dogo_android.o;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.oe;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
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
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/newsletterbenefits/NewsletterBenefitsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentNewsletterBenefitsBinding;", "viewModel", "Lapp/dogo/com/dogo_android/newsletterbenefits/NewsletterBenefitsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/newsletterbenefits/NewsletterBenefitsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private oe a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.o.c a;
        public a(app.dogo.com.dogo_android.o.c c) {
            this.a = c;
            super();
        }

        public final void onChanged(T t) {
            boolean obj1;
            if (t instanceof y.c) {
                obj1 = this.a.getActivity();
                if (obj1 == null) {
                } else {
                    g1.O(obj1);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.o.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.o.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public c() {
        super();
        final int i = 0;
        c.b bVar = new c.b(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, bVar);
    }

    private final app.dogo.com.dogo_android.o.e B1() {
        return (e)this.b.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.o.c c, View view2) {
        c.E1(c, view2);
    }

    public static void D1(app.dogo.com.dogo_android.o.c c, View view2) {
        c.F1(c, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.o.c c, View view2) {
        Object obj0;
        n.f(c, "this$0");
        if (!obj1 instanceof y.b) {
            c.B1().k();
        }
    }

    private static final void F1(app.dogo.com.dogo_android.o.c c, View view2) {
        n.f(c, "this$0");
        c.B1().j();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        oe obj2 = oe.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(B1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        oe obj3 = this.a;
        String obj4 = "binding";
        i = 0;
        if (obj3 == null) {
        } else {
            obj3.M(getViewLifecycleOwner());
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                a aVar2 = new a(this);
                obj3.P.setNavigationOnClickListener(aVar2);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    obj4 = new b(this);
                    obj3.O.setOnClickListener(obj4);
                    obj3 = getActivity();
                    if (obj3 instanceof a0) {
                        i = obj3;
                    }
                    if (i == 0) {
                    } else {
                        i.F();
                    }
                    obj4 = getViewLifecycleOwner();
                    n.e(obj4, "viewLifecycleOwner");
                    c.a aVar = new c.a(this);
                    B1().i().observe(obj4, aVar);
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
