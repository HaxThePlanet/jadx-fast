package app.dogo.com.dogo_android.x.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wg;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: GoalNotAchievedFragment.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00172\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTimeGoalNotAchievedScreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingmetrics/goalnotachieved/GoalNotAchievedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goToNextScreen", "", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class GoalNotAchievedFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private wg binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            app.dogo.com.dogo_android.y.j jVar = b.this.D1().b();
            if (jVar != null) {
                b.this.onAttach(jVar);
            } else {
                androidx.fragment.app.e activity = b.this.getActivity();
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
    public static final class b extends p implements kotlin.d0.c.a<d> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(GoalNotAchievedViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[3];
            return org.koin.core.parameter.b.b(new Object[] { b.this.D1().e(), b.this.D1().f(), b.this.D1().g() });
        }

        c() {
            super(0);
        }
    }
    public b() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.b.b(this, null, new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.b.c(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ c goToNextScreen(b appScreen) {
        return appScreen.D1();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(b view, app.dogo.com.dogo_android.y.j savedInstanceState) {
        view.onAttach(savedInstanceState);
    }

    private final c D1() {
        return (GoalNotAchievedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final d E1() {
        return (GoalNotAchievedViewModel)this.b.getValue();
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

    private static final void H1(b bVar, View view) {
        n.f(bVar, "this$0");
        final androidx.fragment.app.e activity = bVar.getActivity();
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
        wg wgVar = wg.T(inflater, container, false);
        n.e(wgVar, "inflate(inflater, container, false)");
        this.binding = wgVar;
        int i = 0;
        String str4 = "binding";
        if (wgVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            wgVar.V(E1());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.b.a(this), 2, null);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.Q.setOnClickListener(new app.dogo.com.dogo_android.trainingmetrics.goalnotachieved.a(this));
            E1().p();
            return;
        }
    }


    public static /* synthetic */ void G1(b bVar, View view) {
        GoalNotAchievedFragment.H1(bVar, view);
    }
}
