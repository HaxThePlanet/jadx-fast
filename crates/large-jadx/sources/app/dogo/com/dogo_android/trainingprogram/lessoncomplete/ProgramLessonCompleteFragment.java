package app.dogo.com.dogo_android.y.t;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.g.q;
import app.dogo.com.dogo_android.h.kf;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.e.c;

/* compiled from: ProgramLessonCompleteFragment.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonCompleteBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class ProgramLessonCompleteFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private kf binding;
    private final h b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final /* synthetic */ b c;
        a() {
            this.c = bVar;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            if (this.c.C1().createFragment()) {
                androidx.fragment.app.e activity = this.c.getActivity();
                if (activity != null) {
                    boolean z = false;
                    boolean z2 = false;
                    int i2 = 9;
                    kotlin.d0.d.g gVar = null;
                    ProgramLessonsListScreen programLessonsListScreen = new ProgramLessonsListScreen(z, this.c.C1().c().getProgramSaveInfo().getProgramId(), true, z2, this.c.C1().getFragmentReturnTag(), i2, gVar);
                    int i = 4;
                    Object obj = null;
                    app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, this.c.C1().getFragmentReturnTag(), programLessonsListScreen, z, i, obj);
                }
            } else {
                if (this.c.C1().b()) {
                    androidx.fragment.app.e activity2 = this.c.getActivity();
                    if (activity2 != null) {
                        app.dogo.com.dogo_android.util.extensionfunction.g1.b(activity2, new DashboardScreen());
                    }
                } else {
                    androidx.fragment.app.e activity3 = this.c.getActivity();
                    if (activity3 != null) {
                        app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity3);
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<d> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramLessonCompleteViewModel.class), this.$parameters);
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
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { b.this.C1().c() });
        }

        c() {
            super(0);
        }
    }
    public b() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.lessoncomplete.b.b(this, null, new app.dogo.com.dogo_android.trainingprogram.lessoncomplete.b.c(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ c onAttach(b context) {
        return context.C1();
    }

    private final c C1() {
        return (ProgramLessonCompleteScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final d D1() {
        return (ProgramLessonCompleteViewModel)this.b.getValue();
    }

    private static final void F1(b bVar, View view) {
        n.f(bVar, "this$0");
        bVar.D1().j();
        bVar.requireActivity().onBackPressed();
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
        boolean z = false;
        kf kfVar = kf.T(inflater, container, z);
        n.e(kfVar, "inflate(inflater, container, false)");
        this.binding = kfVar;
        int i = 0;
        final String str = "binding";
        if (kfVar == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            kfVar.w().measure(z, z);
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                return this.binding.w();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i12 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i12;
        } else {
            this.binding.V(D1());
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i12;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i12;
                } else {
                    binding24.O.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.lessoncomplete.a(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i12;
                    } else {
                        if (this.binding == null) {
                            n.w(str2);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i12;
                        } else {
                            nl.dionsegijn.konfetti.b bVar = binding2.R.a();
                            int i = 1;
                            int[] iArr = new int[i];
                            int i6 = a.d(requireContext(), 2131100336);
                            int i9 = 0;
                            iArr[i9] = i6;
                            bVar.a(iArr);
                            bVar.h(0.0d, 359d);
                            float f2 = 8f;
                            bVar.k(5f, f2);
                            bVar.i(true);
                            bVar.l(6000L);
                            nl.dionsegijn.konfetti.e.b[] arr2 = new b[i];
                            arr2[i9] = b.a;
                            bVar.b(arr2);
                            c[] arr = new c[i];
                            arr[i9] = new c(18, 500f);
                            bVar.c(arr);
                            float f = -100f;
                            bVar.j(0.0f, Float.valueOf((float)this.binding.w().getMeasuredWidth()), f, Float.valueOf(f));
                            bVar.o(30, Long.MAX_VALUE);
                            D1().i();
                            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new ProgramLessonCompleteFragment_onViewCreated_2(this));
                            return;
                        }
                    }
                }
            }
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(b view, View savedInstanceState) {
        ProgramLessonCompleteFragment.F1(view, savedInstanceState);
    }
}
