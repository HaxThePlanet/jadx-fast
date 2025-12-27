package app.dogo.com.dogo_android.y.d0;

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
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.kd;
import app.dogo.com.dogo_android.m.d;
import app.dogo.com.dogo_android.util.e0.a0;
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

/* compiled from: ProgramTrainingGoodExampleFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0018H\u0016J\u0008\u0010\u001a\u001a\u00020\u0018H\u0016J\u0008\u0010\u001b\u001a\u00020\u0018H\u0016J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleVideoBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingGoodExampleScreen;", "viewModel", "Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onResume", "onStart", "onStop", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class ProgramTrainingGoodExampleFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private kd b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ j a;
        public final void onChanged(T t) {
            n.e(t, "it");
            app.dogo.com.dogo_android.util.extensionfunction.f1.W(this.a, t, new app.dogo.com.dogo_android.trainingprogram.trainingsession.j.b(this.a), new app.dogo.com.dogo_android.trainingprogram.trainingsession.j.c(this.a));
        }

        public a() {
            this.a = jVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.this.E1().r();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = j.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.m.b> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.m.b invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(GoodExampleVideoViewModel.class), this.$parameters);
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
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { j.this.onDestroyView().createFragment() });
        }

        e() {
            super(0);
        }
    }
    public j() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.trainingsession.j.d(this, null, new app.dogo.com.dogo_android.trainingprogram.trainingsession.j.e(this)));
    }

    public static final /* synthetic */ k B1(j jVar) {
        return jVar.onDestroyView();
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.m.b C1(j jVar) {
        return jVar.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final k onDestroyView() {
        return (ProgramTrainingGoodExampleScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final app.dogo.com.dogo_android.m.b E1() {
        return (GoodExampleVideoViewModel)this.binding.getValue();
    }

    private static final void H1(j jVar, Boolean boolean) {
        n.f(jVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(jVar.getActivity(), new ProgramGoodExampleNotAvailableScreen(jVar.onDestroyView().createFragment(), jVar.onDestroyView().getFragmentReturnTag()));
    }

    private static final void I1(j jVar, View view) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        kd kdVar = kd.T(getLayoutInflater(), container, false);
        n.e(kdVar, "inflate(layoutInflater, container, false)");
        this.b = kdVar;
        int i = 0;
        String str3 = "binding";
        if (kdVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            kdVar.M(getViewLifecycleOwner());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(E1());
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        final androidx.recyclerview.widget.RecyclerView.h hVar = null;
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) hVar;
        } else {
            kdVar.R.setAdapter(hVar);
            super.onDestroyView();
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity = null;
        super.onResume();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        int i = 0;
        super.onStart();
        i = 0;
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = kdVar.R.getAdapter();
            if (adapter instanceof VimeoVideoAdapter) {
            }
            if (i != 0) {
                i.j();
            }
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        i = 0;
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = kdVar.R.getAdapter();
            if (adapter instanceof VimeoVideoAdapter) {
            }
            if (i != 0) {
                i.l();
            }
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        E1().l().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.trainingprogram.trainingsession.b(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
        E1().m().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.trainingprogram.trainingsession.j.a(this));
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            kdVar.W.setNavigationOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.c(this));
            return;
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, Boolean savedInstanceState) {
        ProgramTrainingGoodExampleFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(j jVar, View view) {
        ProgramTrainingGoodExampleFragment.I1(jVar, view);
    }
}
