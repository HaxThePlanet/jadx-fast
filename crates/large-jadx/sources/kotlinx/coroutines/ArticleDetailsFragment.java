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
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: ArticleDetailsFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryArticleDetailsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class ArticleDetailsFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private qd b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<m> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final m invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ArticleDetailsViewModel.class), this.$parameters);
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
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.a(k.this);
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { jVar.component1(), Boolean.valueOf(jVar.b()) });
        }

        b() {
            super(0);
        }
    }
    public k() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.k.a(this, null, new kotlinx.coroutines.k.b(this)));
    }

    private final l B1() {
        return (ArticleDetailsScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final m C1() {
        return (ArticleDetailsViewModel)this.binding.getValue();
    }

    private static final void G1(k kVar, View view) {
        n.f(kVar, "this$0");
        final androidx.fragment.app.e activity = kVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void H1(k kVar, View view) {
        n.f(kVar, "this$0");
        kVar.C1().n(kVar.B1().component1().getArticleId());
        kVar.C1().m(kVar.B1().component1().getArticleId());
    }

    private static final void I1(k kVar, Boolean boolean) {
        n.f(kVar, "this$0");
        final androidx.fragment.app.e activity = kVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        qd qdVar = qd.T(inflater, container, false);
        n.e(qdVar, "inflate(inflater, container, false)");
        this.b = qdVar;
        int i = 0;
        String str4 = "binding";
        if (qdVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            qdVar.V(C1());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.M(getViewLifecycleOwner());
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    View view = this.b.w();
                    n.e(view, "binding.root");
                    return view;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws c {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (i != 0) {
            i.F();
        }
        String str3 = "binding";
        if (this.b == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            qdVar.T.setNavigationOnClickListener(new kotlinx.coroutines.b(this));
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                qdVar2.Q.setOnClickListener(new kotlinx.coroutines.a(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                C1().k().observe(viewLifecycleOwner, new kotlinx.coroutines.c(this));
                return;
            }
        }
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(k view, View savedInstanceState) {
        ArticleDetailsFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(k kVar, View view) {
        ArticleDetailsFragment.G1(kVar, view);
    }

    public static /* synthetic */ void F1(k kVar, Boolean boolean) {
        ArticleDetailsFragment.I1(kVar, boolean);
    }
}
