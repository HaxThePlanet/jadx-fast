package app.dogo.com.dogo_android.n.k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.qd;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryArticleDetailsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends Fragment {

    private final h a;
    private qd b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.n.k.m> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.k.m invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(m.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.n.k.k this$0;
        b(app.dogo.com.dogo_android.n.k.k k) {
            this.this$0 = k;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            app.dogo.com.dogo_android.y.j jVar = k1.a(this.this$0);
            Object[] arr = new Object[2];
            return b.b((l)jVar.a(), Boolean.valueOf(jVar.b()));
        }
    }
    static {
    }

    public k() {
        super();
        k.b bVar = new k.b(this);
        k.a aVar = new k.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.n.k.l B1() {
        return (l)k1.a(this);
    }

    private final app.dogo.com.dogo_android.n.k.m C1() {
        return (m)this.a.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.n.k.k k, View view2) {
        k.H1(k, view2);
    }

    public static void E1(app.dogo.com.dogo_android.n.k.k k, View view2) {
        k.G1(k, view2);
    }

    public static void F1(app.dogo.com.dogo_android.n.k.k k, Boolean boolean2) {
        k.I1(k, boolean2);
    }

    private static final void G1(app.dogo.com.dogo_android.n.k.k k, View view2) {
        n.f(k, "this$0");
        final androidx.fragment.app.e obj0 = k.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void H1(app.dogo.com.dogo_android.n.k.k k, View view2) {
        n.f(k, "this$0");
        k.C1().n(k.B1().a().getArticleId());
        k.C1().m(k.B1().a().getArticleId());
    }

    private static final void I1(app.dogo.com.dogo_android.n.k.k k, Boolean boolean2) {
        n.f(k, "this$0");
        final androidx.fragment.app.e obj0 = k.getActivity();
        if (obj0 == null) {
        } else {
            g1.O(obj0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        qd obj2 = qd.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(C1());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.b;
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
        obj3 = this.b;
        String obj4 = "binding";
        if (obj3 == null) {
        } else {
            b bVar = new b(this);
            obj3.T.setNavigationOnClickListener(bVar);
            obj3 = this.b;
            if (obj3 == null) {
            } else {
                obj4 = new a(this);
                obj3.Q.setOnClickListener(obj4);
                obj4 = getViewLifecycleOwner();
                n.e(obj4, "viewLifecycleOwner");
                c cVar = new c(this);
                C1().k().observe(obj4, cVar);
            }
            n.w(obj4);
            throw i;
        }
        n.w(obj4);
        throw i;
    }
}
