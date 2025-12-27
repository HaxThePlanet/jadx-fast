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
import app.dogo.com.dogo_android.view.q;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: ArticleListFragment.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryArticleListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/articles/ArticleListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/articles/ArticleListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class ArticleListFragment extends Fragment implements n.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private sd b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<q> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final q invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ArticleListViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { o.this.C1().component1() });
        }

        b() {
            super(0);
        }
    }
    public o() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.o.a(this, null, new kotlinx.coroutines.o.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ p onArticleSelected(o article) {
        return article.C1();
    }

    private final p C1() {
        return (ArticleListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final q D1() {
        return (ArticleListViewModel)this.binding.getValue();
    }

    private static final void H1(o oVar, View view) {
        n.f(oVar, "this$0");
        final androidx.fragment.app.e activity = oVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void I1(o oVar, q2.a aVar) {
        str = "this$0";
        n.f(oVar, str);
        if (aVar != null) {
            androidx.fragment.app.e activity = oVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new RatePromptV2Screen(aVar.getTag()));
            }
        }
    }

    private static final void J1(o oVar, q2.a aVar) {
        str = "this$0";
        n.f(oVar, str);
        if (aVar != null) {
            androidx.fragment.app.e activity = oVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new SharePromptScreen(aVar.getTag()));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Article article) {
        n.f(article, "article");
        D1().y(article.getArticleId());
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ArticleDetailsScreen(article, "library", false));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        sd sdVar = sd.T(inflater, container, false);
        n.e(sdVar, "inflate(inflater, container, false)");
        this.b = sdVar;
        int i = 0;
        String str3 = "binding";
        if (sdVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            sdVar.W(D1());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
                if (this.b == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.M(getViewLifecycleOwner());
                    if (this.b == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.b.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws e {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (i != 0) {
            i.p0();
        }
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            sdVar.R.setNavigationOnClickListener(new kotlinx.coroutines.f(this));
            D1().p().observe(getViewLifecycleOwner(), new kotlinx.coroutines.g(this));
            D1().q().observe(getViewLifecycleOwner(), new kotlinx.coroutines.e(this));
            D1().w();
            return;
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(o view, q2.a savedInstanceState) {
        ArticleListFragment.J1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(o oVar, View view) {
        ArticleListFragment.H1(oVar, view);
    }

    public static /* synthetic */ void G1(o oVar, q2.a aVar) {
        ArticleListFragment.I1(oVar, aVar);
    }
}
