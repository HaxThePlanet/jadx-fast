package app.dogo.com.dogo_android.n.m;

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
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.f.n.d;
import app.dogo.com.dogo_android.h.ae;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.q;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.w;

/* compiled from: TrickListFragment.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class TrickListFragment extends Fragment implements o.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ae b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ p a;
        public final void onChanged(T t) {
            n.e(t, "it");
            app.dogo.com.dogo_android.util.extensionfunction.f1.W(this.a, t, new app.dogo.com.dogo_android.library.tricks.p.b(this.a), new app.dogo.com.dogo_android.library.tricks.p.c(this.a));
        }

        public a() {
            this.a = pVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            p.this.D1().C();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = p.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public d(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<r> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final r invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TrickListViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.a(p.this);
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { jVar.component1(), jVar.b() });
        }

        f() {
            super(0);
        }
    }
    public p() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.library.tricks.p.e(this, aVar, new app.dogo.com.dogo_android.library.tricks.p.f(this)));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.library.tricks.p.d(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ r onTrickSelected(p trick) {
        return trick.D1();
    }

    private final q C1() {
        return (TrickListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final r D1() {
        return (TrickListViewModel)this.binding.getValue();
    }

    private static final void I1(p pVar, View view) {
        n.f(pVar, "this$0");
        final androidx.fragment.app.e activity = pVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(p pVar, q2.a aVar) {
        str = "this$0";
        n.f(pVar, str);
        if (aVar != null) {
            androidx.fragment.app.e activity = pVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new RatePromptV2Screen(aVar.getTag()));
            }
        }
    }

    private static final void K1(p pVar, q2.a aVar) {
        str = "this$0";
        n.f(pVar, str);
        if (aVar != null) {
            androidx.fragment.app.e activity = pVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new SharePromptScreen(aVar.getTag()));
            }
        }
    }

    private static final void L1(p pVar, String str) {
        n.f(pVar, "this$0");
        androidx.fragment.app.e activity = pVar.getActivity();
        if (activity != null) {
            str3 = "it";
            n.e(str, str3);
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(activity, new DailyWorkoutUnlockedScreen(pVar.D1().t(str), str, pVar.C1().getTag()));
        }
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void j(TrickItem trickItem) {
        n.f(trickItem, "trick");
        D1().J(trickItem.getId());
        if (trickItem.getLocked()) {
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
            int i = 12;
            Object obj = null;
            str = "trick_list";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, C1().getTag(), z, profilePreview, i, obj));
        } else {
            app.dogo.com.dogo_android.y.j jVar2 = app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(new TrickDetailsPlan_LibraryPlan(trickItem), jVar2.getTag(), jVar2.getTag(), "library"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ae aeVar = ae.T(inflater, container, false);
        n.e(aeVar, "inflate(inflater, container, false)");
        this.b = aeVar;
        int i = 0;
        String str4 = "binding";
        if (aeVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            aeVar.W(D1());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws p.a {
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
            aeVar.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.library.tricks.e(this));
            D1().n().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.library.tricks.b(this));
            D1().o().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.library.tricks.d(this));
            androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner3, str2);
            D1().p().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.library.tricks.c(this));
            D1().C();
            androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner4, str2);
            D1().m().observe(viewLifecycleOwner4, new app.dogo.com.dogo_android.library.tricks.p.a(this));
            return;
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(p view, q2.a savedInstanceState) {
        TrickListFragment.J1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(p pVar, String str) {
        TrickListFragment.L1(pVar, str);
    }

    public static /* synthetic */ void G1(p pVar, q2.a aVar) {
        TrickListFragment.K1(pVar, aVar);
    }

    public static /* synthetic */ void H1(p pVar, View view) {
        TrickListFragment.I1(pVar, view);
    }
}
