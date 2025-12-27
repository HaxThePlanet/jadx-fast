package app.dogo.com.dogo_android.f.k;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.f.j.c;
import app.dogo.com.dogo_android.f.l.k;
import app.dogo.com.dogo_android.h.qa;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: DailyWorkoutOverviewFragment.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDailyWorkoutOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewScreen;", "viewModel", "Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dailyworkout/overview/DailyWorkoutOverviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DailyWorkoutOverviewFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private qa binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ f a;
        public final void onChanged(T t) {
            Exception component1 = null;
            int i;
            z = t instanceof LoadResult_Error;
            t = t instanceof oadResult_Error ? (oadResult_Error)t : 0;
            if (i != 0) {
                component1 = i.component1();
            }
            z2 = component1 instanceof UnknownHostException;
            if (component1 instanceof UnknownHostException) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.h0(activity, new app.dogo.com.dogo_android.dailyworkout.overview.f.b(this.a));
                }
            }
        }

        public a() {
            this.a = fVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            f.this.D1().n();
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
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DailyWorkoutOverviewViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public f() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dailyworkout.overview.f.c(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ h onAttach(f context) {
        return context.D1();
    }

    private final g C1() {
        return (DailyWorkoutOverviewScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h D1() {
        return (DailyWorkoutOverviewViewModel)this.b.getValue();
    }

    private static final void H1(f fVar, View view) {
        n.f(fVar, "this$0");
        fVar.D1().p();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(fVar.getActivity(), new DailyWorkoutInfoScreen("daily_workout_overview"));
    }

    private static final void I1(f fVar, WorkoutSession workoutSession) {
        n.f(fVar, "this$0");
        fVar.D1().q();
        n.e(workoutSession, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(fVar.getActivity(), new DailyWorkoutScreen(workoutSession, fVar.C1().getFragmentReturnTag()));
    }

    private static final void J1(f fVar, View view) {
        n.f(fVar, "this$0");
        final androidx.fragment.app.e activity = fVar.getActivity();
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
        qa qaVar = qa.T(inflater, container, false);
        n.e(qaVar, "inflate(inflater, container, false)");
        this.binding = qaVar;
        int i = 0;
        String str3 = "binding";
        if (qaVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            qaVar.M(getViewLifecycleOwner());
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
    public void onViewCreated(View view, Bundle bundle) throws b {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.O.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.overview.c(this));
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            final String str3 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner, str3);
            D1().j().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.dailyworkout.overview.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.Q.setNavigationOnClickListener(new app.dogo.com.dogo_android.dailyworkout.overview.b(this));
                androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                n.e(viewLifecycleOwner2, str3);
                D1().i().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.dailyworkout.overview.f.a(this));
                return;
            }
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(f view, WorkoutSession savedInstanceState) {
        DailyWorkoutOverviewFragment.I1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(f fVar, View view) {
        DailyWorkoutOverviewFragment.J1(fVar, view);
    }

    public static /* synthetic */ void G1(f fVar, View view) {
        DailyWorkoutOverviewFragment.H1(fVar, view);
    }
}
