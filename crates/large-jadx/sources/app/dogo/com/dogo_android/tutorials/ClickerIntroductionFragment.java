package app.dogo.com.dogo_android.z;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.oa;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: ClickerIntroductionFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0012H\u0016J\u0008\u0010\u0016\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentClickerIntroductionDetailsBinding;", "Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionScreen;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionViewModel;", "viewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onNormalCardClick", "onNotFirstPageSelected", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class ClickerIntroductionFragment extends app.dogo.com.dogo_android.util.m0.b<oa, c> implements app.dogo.com.dogo_android.n.m.u.k {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public b(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<d> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ClickerIntroductionViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends kotlin.d0.d.k implements q<LayoutInflater, ViewGroup, Boolean, oa> {

        public static final b.a a = new b$a();
        @Override // kotlin.d0.d.k
        public final oa l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return oa.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, oa.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentClickerIntroductionDetailsBinding;", 0);
        }
    }
    public b() {
        super(app.dogo.com.dogo_android.tutorials.b.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.tutorials.b.c(this, aVar2, aVar2));
        this.w = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.tutorials.b.b(this, aVar2, aVar2));
    }

    private static final void I1(b bVar, View view) {
        n.f(bVar, "this$0");
        final androidx.fragment.app.e activity = bVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public d G1() {
        return (ClickerIntroductionViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public l getSharedViewModel() {
        return (SessionViewModel)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        (oa)B1().Q.setNavigationOnClickListener(new app.dogo.com.dogo_android.tutorials.a(this));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void t0() {
        n.e(viewPager2, "binding.trickDetailsViewPager");
        app.dogo.com.dogo_android.util.extensionfunction.j1.linkWithCredentialSingle(viewPager2);
    }


    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(b view, View savedInstanceState) {
        ClickerIntroductionFragment.I1(view, savedInstanceState);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void M() {
    }
}
