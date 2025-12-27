package app.dogo.com.dogo_android.f.n;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.f.k.g;
import app.dogo.com.dogo_android.h.sa;
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

/* compiled from: DailyWorkoutUnlockedFragment.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDailyWorkoutUnlockedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dailyworkout/unlock/DailyWorkoutUnlockedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class DailyWorkoutUnlockedFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private sa binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DailyWorkoutUnlockedViewModel.class), this.$parameters);
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
            return org.koin.core.parameter.b.b(new Object[] { c.this.C1().a() });
        }

        b() {
            super(0);
        }
    }
    public c() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dailyworkout.unlock.c.a(this, null, new app.dogo.com.dogo_android.dailyworkout.unlock.c.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ d onAttach(c context) {
        return context.C1();
    }

    private final d C1() {
        return (DailyWorkoutUnlockedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final e D1() {
        return (DailyWorkoutUnlockedViewModel)this.b.getValue();
    }

    private static final void G1(c cVar, Boolean boolean) {
        n.f(cVar, "this$0");
        androidx.fragment.app.e activity = cVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(cVar.getActivity(), new DailyWorkoutOverviewScreen(cVar.C1().getFragmentReturnTag()));
    }

    private static final void H1(c cVar, Boolean boolean) {
        n.f(cVar, "this$0");
        final androidx.fragment.app.e activity = cVar.getActivity();
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
        sa saVar = sa.T(inflater, container, false);
        n.e(saVar, "inflate(inflater, container, false)");
        this.binding = saVar;
        int i = 0;
        String str3 = "binding";
        if (saVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            saVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(D1());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        D1().workoutLaterClicked().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.dailyworkout.unlock.a(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        D1().i().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.dailyworkout.unlock.b(this));
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, Boolean savedInstanceState) {
        DailyWorkoutUnlockedFragment.G1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(c cVar, Boolean boolean) {
        DailyWorkoutUnlockedFragment.H1(cVar, boolean);
    }
}
