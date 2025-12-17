package app.dogo.com.dogo_android.n.k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.sd;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.view.q;
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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryArticleListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/articles/ArticleListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/articles/ArticleListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends Fragment implements app.dogo.com.dogo_android.n.k.n.b {

    private final h a;
    private sd b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.n.k.q> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.k.q invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(q.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.n.k.o this$0;
        b(app.dogo.com.dogo_android.n.k.o o) {
            this.this$0 = o;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(o.B1(this.this$0).a());
        }
    }
    static {
    }

    public o() {
        super();
        o.b bVar = new o.b(this);
        o.a aVar = new o.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.n.k.p B1(app.dogo.com.dogo_android.n.k.o o) {
        return o.C1();
    }

    private final app.dogo.com.dogo_android.n.k.p C1() {
        return (p)k1.a(this);
    }

    private final app.dogo.com.dogo_android.n.k.q D1() {
        return (q)this.a.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.n.k.o o, q2.a q2$a2) {
        o.J1(o, a2);
    }

    public static void F1(app.dogo.com.dogo_android.n.k.o o, View view2) {
        o.H1(o, view2);
    }

    public static void G1(app.dogo.com.dogo_android.n.k.o o, q2.a q2$a2) {
        o.I1(o, a2);
    }

    private static final void H1(app.dogo.com.dogo_android.n.k.o o, View view2) {
        n.f(o, "this$0");
        final androidx.fragment.app.e obj0 = o.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void I1(app.dogo.com.dogo_android.n.k.o o, q2.a q2$a2) {
        Object nVar;
        Object obj1;
        String obj2;
        n.f(o, "this$0");
        if (a2 == null) {
        } else {
            obj1 = o.getActivity();
            if (obj1 == null) {
            } else {
                nVar = new n(a2.getTag());
                g1.X(obj1, nVar);
            }
        }
    }

    private static final void J1(app.dogo.com.dogo_android.n.k.o o, q2.a q2$a2) {
        Object qVar;
        Object obj1;
        String obj2;
        n.f(o, "this$0");
        if (a2 == null) {
        } else {
            obj1 = o.getActivity();
            if (obj1 == null) {
            } else {
                qVar = new q(a2.getTag());
                g1.X(obj1, qVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Article article) {
        n.f(article, "article");
        D1().y(article.getArticleId());
        l lVar = new l(article, "library", 0);
        g1.n(getActivity(), lVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        sd obj2 = sd.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(D1());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.b;
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
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int obj2;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i = 0;
        if (obj2 instanceof a0) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
        } else {
            obj2.p0();
        }
        obj2 = this.b;
        if (obj2 == null) {
        } else {
            f obj3 = new f(this);
            obj2.R.setNavigationOnClickListener(obj3);
            g gVar = new g(this);
            D1().p().observe(getViewLifecycleOwner(), gVar);
            e eVar = new e(this);
            D1().q().observe(getViewLifecycleOwner(), eVar);
            D1().w();
        }
        n.w("binding");
        throw i;
    }
}
