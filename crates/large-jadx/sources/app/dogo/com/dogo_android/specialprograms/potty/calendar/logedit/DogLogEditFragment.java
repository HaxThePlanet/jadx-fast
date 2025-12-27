package app.dogo.com.dogo_android.u.n.p.l;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.mc;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: DogLogEditFragment.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J \u0010\u001c\u001a\u00020\u00112\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\u0008\u0012\u0004\u0012\u00020\u001f` H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010#\u001a\u00020\u0011H\u0002J\u0008\u0010$\u001a\u00020\u0011H\u0002J\u0008\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogLogEditBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTagSelected", "types", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onViewCreated", "view", "scrollToButton", "showDatePicker", "showTimePicker", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class DogLogEditFragment extends Fragment implements j.a {

    /* renamed from: a, reason: from kotlin metadata */
    private mc binding;
    private final h b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<Long, w> {
        @Override // kotlin.d0.d.p
        public final void a(long j) {
            g.this.E1().z(j);
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.p<Integer, Integer, w> {
        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            g.this.E1().B(i, i2);
        }

        b() {
            super(2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<i> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogLogEditViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[3];
            return org.koin.core.parameter.b.b(new Object[] { g.this.scrollToButton().createFragment(), g.this.scrollToButton().c(), g.this.scrollToButton().b() });
        }

        d() {
            super(0);
        }
    }
    public g() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.g.c(this, null, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.g.d(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ h onAttach(g context) {
        return context.scrollToButton();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ i onTagSelected(g types) {
        return types.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final h scrollToButton() {
        return (DogLogEditScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final i E1() {
        return (DogLogEditViewModel)this.b.getValue();
    }

    private static final void K1(g gVar, Boolean boolean) {
        n.f(gVar, "this$0");
        final androidx.fragment.app.e activity = gVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    private static final void L1(g gVar, Boolean boolean) {
        n.f(gVar, "this$0");
        n.e(boolean, "isTagSelected");
        if (boolean.booleanValue()) {
            gVar.P1();
        }
    }

    private static final void M1(g gVar, View view) {
        n.f(gVar, "this$0");
        final androidx.fragment.app.e activity = gVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void N1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.Q1();
    }

    private static final void O1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.R1();
    }

    private final void P1() {
        final int i = 0;
        final String str = "binding";
        if (this.binding == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding2.S.smoothScrollTo(0, binding2.R.getBottom());
                return;
            }
        }
    }

    private final void Q1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.clearBackstackToTagAndGoToFragment(activity, (Long)E1().l().getValue(), new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.g.a(this));
        }
    }

    private final void R1() {
        Object value;
        Object value2;
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            int i = 0;
            if ((Integer)E1().p().getValue() == null) {
                Integer num = 0;
            }
            if ((Integer)E1().q().getValue() == null) {
                Integer num2 = Integer.valueOf(i);
            }
            app.dogo.com.dogo_android.util.extensionfunction.g1.l0(activity, value.intValue(), value2.intValue(), new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.g.b(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C0(ArrayList<String> arrayList) {
        n.f(arrayList, "types");
        E1().trackSaveButtonPressed(arrayList);
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
        mc mcVar = mc.T(inflater, container, false);
        n.e(mcVar, "inflate(inflater, container, false)");
        this.binding = mcVar;
        int i = 0;
        String str4 = "binding";
        if (mcVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            mcVar.W(E1());
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
    public void onViewCreated(View view, Bundle bundle) throws e {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        E1().o().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.c(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        E1().t().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.a(this));
        int i = 0;
        String str3 = "binding";
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.X.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.b(this));
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.P.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.d(this));
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.U.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.e(this));
                    return;
                }
            }
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(g view, Boolean savedInstanceState) {
        DogLogEditFragment.L1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(g gVar, View view) {
        DogLogEditFragment.M1(gVar, view);
    }

    public static /* synthetic */ void H1(g gVar, Boolean boolean) {
        DogLogEditFragment.K1(gVar, boolean);
    }

    public static /* synthetic */ void I1(g gVar, View view) {
        DogLogEditFragment.N1(gVar, view);
    }

    public static /* synthetic */ void J1(g gVar, View view) {
        DogLogEditFragment.O1(gVar, view);
    }
}
