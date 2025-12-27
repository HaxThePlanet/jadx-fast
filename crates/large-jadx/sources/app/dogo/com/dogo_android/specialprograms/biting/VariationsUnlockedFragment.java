package app.dogo.com.dogo_android.u.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.aa;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.m;
import kotlin.w;

/* compiled from: VariationsUnlockedFragment.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentBitingProgramVariationsUnlockedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goToNextScreen", "", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onVariationSelected", "variation", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public final class VariationsUnlockedFragment extends Fragment implements v.a {

    /* renamed from: a, reason: from kotlin metadata */
    private aa binding;
    private final kotlin.h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            app.dogo.com.dogo_android.y.j jVar = u.this.D1().b();
            if (jVar != null) {
                u.this.onAttach(jVar);
            } else {
                androidx.fragment.app.e activity = u.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
                }
            }
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<x> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(VariationsUnlockedViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { (VariationsUnlockedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(u.this).f() });
        }

        c() {
            super(0);
        }
    }
    public u() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.biting.u.b(this, null, new app.dogo.com.dogo_android.specialprograms.biting.u.c(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ w goToNextScreen(u appScreen) {
        return appScreen.D1();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(u view, app.dogo.com.dogo_android.y.j savedInstanceState) {
        view.onAttach(savedInstanceState);
    }

    private final w D1() {
        return (VariationsUnlockedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final x E1() {
        return (VariationsUnlockedViewModel)this.b.getValue();
    }

    /* renamed from: F1, reason: from kotlin metadata */
    private final void onAttach(app.dogo.com.dogo_android.y.j context) {
        if (D1().a()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                boolean z = false;
                int i = 4;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, D1().getFragmentReturnTag(), context, z, i, obj);
            }
        } else {
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, context);
            }
        }
    }

    private static final void I1(u uVar, View view) {
        n.f(uVar, "this$0");
        final androidx.fragment.app.e activity = uVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(u uVar, View view) {
        n.f(uVar, "this$0");
        final androidx.fragment.app.e activity = uVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: k0, reason: from kotlin metadata */
    public void onVariationSelected(TrickItem variation) {
        String fragmentReturnTag = null;
        String fragmentReturnTag2;
        boolean z = false;
        int i = 4;
        Object obj = null;
        n.f(variation, "variation");
        E1().n(variation.getVariationId());
        app.dogo.com.dogo_android.y.j jVar = D1().b();
        if (jVar == null) {
            int i4 = 0;
        } else {
            fragmentReturnTag = jVar.getTag();
        }
        if (fragmentReturnTag == null) {
            fragmentReturnTag = D1().getFragmentReturnTag();
        }
        if (jVar != null) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                z = false;
                i = 4;
                obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, D1().getFragmentReturnTag(), jVar, z, i, obj);
            }
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            int i3 = 28;
            kotlin.d0.d.g gVar = null;
            TrickDetailsPlan_ProgramPlan trickDetailsPlan_ProgramPlan = new TrickDetailsPlan_ProgramPlan(p.b(variation), D1().e(), i2, z2, z3, i3, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, new TrickBigTimerScreen(trickDetailsPlan_ProgramPlan, D1().getTag(), fragmentReturnTag, D1().getSource()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        super.onAttach(context);
        context = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        aa aaVar = aa.T(inflater, container, false);
        n.e(aaVar, "inflate(inflater, container, false)");
        this.binding = aaVar;
        int i = 0;
        String str4 = "binding";
        if (aaVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            aaVar.W(E1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.binding.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws j {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.specialprograms.biting.u.a(this), 2, null);
        E1().m();
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.i(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.T.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.biting.j(this));
                return;
            }
        }
    }


    public static /* synthetic */ void G1(u uVar, View view) {
        VariationsUnlockedFragment.I1(uVar, view);
    }

    public static /* synthetic */ void H1(u uVar, View view) {
        VariationsUnlockedFragment.J1(uVar, view);
    }
}
