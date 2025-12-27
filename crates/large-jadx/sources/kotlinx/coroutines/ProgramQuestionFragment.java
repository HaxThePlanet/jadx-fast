package app.dogo.com.dogo_android.y.a0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.b0.d;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: ProgramQuestionFragment.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0011H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramQuestionBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCorrectItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onIncorrectItemSelected", "item", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class ProgramQuestionFragment extends Fragment implements e.c {

    /* renamed from: a, reason: from kotlin metadata */
    private wf binding;
    private final h b;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            f.this.E1().o();
        }

        a() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = f.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<h> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramQuestionViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { f.this.onCorrectItemSelected().b(), f.this.onCorrectItemSelected().c() });
        }

        d() {
            super(0);
        }
    }
    public f() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.f.c(this, null, new kotlinx.coroutines.f.d(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ g onAttach(f context) {
        return context.onCorrectItemSelected();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ h onIncorrectItemSelected(f item) {
        return item.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final g onCorrectItemSelected() {
        return (ProgramQuestionScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h E1() {
        return (ProgramQuestionViewModel)this.b.getValue();
    }

    private static final void I1(f fVar, View view) {
        n.f(fVar, "this$0");
        final androidx.fragment.app.e activity = fVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(f fVar, Boolean boolean) {
        n.f(fVar, "this$0");
        androidx.fragment.app.e activity = fVar.getActivity();
        if (activity != null) {
            ProgramQuestionCorrectAnswerScreen programQuestionCorrectAnswerScreen = new ProgramQuestionCorrectAnswerScreen(fVar.onCorrectItemSelected().b(), fVar.onCorrectItemSelected().c(), fVar.onCorrectItemSelected().getFragmentReturnTag(), fVar.onCorrectItemSelected().createFragment(), fVar.onCorrectItemSelected().d());
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, programQuestionCorrectAnswerScreen);
        }
    }

    private static final void K1(f fVar, y yVar) {
        n.f(fVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            a.d(yVar.component1());
            Context requireContext = fVar.requireContext();
            str = "requireContext()";
            n.e(requireContext, str);
            app.dogo.com.dogo_android.util.extensionfunction.f1.m0(fVar, BindingAdapters.a.i(new Exception(yVar.component1()), requireContext), new kotlinx.coroutines.f.a(fVar), new kotlinx.coroutines.f.b(fVar));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V() {
        E1().p();
        E1().o();
    }

    @Override // androidx.fragment.app.Fragment
    public void c1(String str) {
        n.f(str, "item");
        E1().q(str);
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
        wf wfVar = wf.T(inflater, container, false);
        n.e(wfVar, "inflate(inflater, container, false)");
        this.binding = wfVar;
        int i = 0;
        String str3 = "binding";
        if (wfVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            wfVar.M(getViewLifecycleOwner());
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
            binding2.O.setNavigationOnClickListener(new kotlinx.coroutines.c(this));
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner, str2);
            E1().setQuestionAsComplete().observe(viewLifecycleOwner, new kotlinx.coroutines.d(this));
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner2, str2);
            E1().n().observe(viewLifecycleOwner2, new kotlinx.coroutines.b(this));
            return;
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(f view, y savedInstanceState) {
        ProgramQuestionFragment.K1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(f fVar, View view) {
        ProgramQuestionFragment.I1(fVar, view);
    }

    public static /* synthetic */ void H1(f fVar, Boolean boolean) {
        ProgramQuestionFragment.J1(fVar, boolean);
    }
}
