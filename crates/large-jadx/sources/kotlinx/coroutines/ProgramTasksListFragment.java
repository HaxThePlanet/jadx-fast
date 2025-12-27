package app.dogo.com.dogo_android.y.c0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ag;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: ProgramTasksListFragment.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0011H\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/TaskListCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTaskBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/tasklist/ProgramTasksListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTaskCompleted", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "onTasksCompletedButtonClick", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ProgramTasksListFragment extends Fragment implements g {

    /* renamed from: a, reason: from kotlin metadata */
    private ag binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            if (d.this.E1().q()) {
                d.this.E1().r();
            } else {
                androidx.fragment.app.e activity = d.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
                }
            }
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            d.this.E1().r();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = d.this.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramTasksListViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { d.this.onTasksCompletedButtonClick().b(), d.this.onTasksCompletedButtonClick().createFragment() });
        }

        e() {
            super(0);
        }
    }
    public d() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.d.d(this, null, new kotlinx.coroutines.d.e(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ e onAttach(d context) {
        return context.onTasksCompletedButtonClick();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ f onTaskCompleted(d item) {
        return item.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final e onTasksCompletedButtonClick() {
        return (ProgramTasksListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final f E1() {
        return (ProgramTasksListViewModel)this.b.getValue();
    }

    private static final void I1(d dVar, View view) {
        n.f(dVar, "this$0");
        final androidx.fragment.app.e activity = dVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(d dVar, y yVar) {
        n.f(dVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            a.d(yVar.component1());
            Context requireContext = dVar.requireContext();
            str = "requireContext()";
            n.e(requireContext, str);
            app.dogo.com.dogo_android.util.extensionfunction.f1.m0(dVar, BindingAdapters.a.i(new Exception(yVar.component1()), requireContext), new kotlinx.coroutines.d.b(dVar), new kotlinx.coroutines.d.c(dVar));
        }
    }

    private static final void K1(d dVar, Boolean boolean) {
        n.f(dVar, "this$0");
        final androidx.fragment.app.e activity = dVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j1() {
        E1().t();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ag agVar = ag.T(inflater, container, false);
        n.e(agVar, "inflate(inflater, container, false)");
        this.binding = agVar;
        int i = 0;
        String str3 = "binding";
        if (agVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            agVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(E1());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.O.setNavigationOnClickListener(new kotlinx.coroutines.a(this));
            androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
            n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
            e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new kotlinx.coroutines.d.a(this), 2, null);
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner2, str2);
            E1().n().observe(viewLifecycleOwner2, new kotlinx.coroutines.b(this));
            androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner3, str2);
            E1().k().observe(viewLifecycleOwner3, new kotlinx.coroutines.c(this));
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y(ProgramTasks programTasks) {
        n.f(programTasks, "item");
        E1().s(programTasks);
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(d view, View savedInstanceState) {
        ProgramTasksListFragment.I1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(d dVar, y yVar) {
        ProgramTasksListFragment.J1(dVar, yVar);
    }

    public static /* synthetic */ void H1(d dVar, Boolean boolean) {
        ProgramTasksListFragment.K1(dVar, boolean);
    }
}
