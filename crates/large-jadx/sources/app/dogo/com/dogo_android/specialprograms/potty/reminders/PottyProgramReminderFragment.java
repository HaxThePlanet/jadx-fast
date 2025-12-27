package app.dogo.com.dogo_android.u.n.q;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.cf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: PottyProgramReminderFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00122\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyReminderScreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callReminderErrorDialog", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class PottyProgramReminderFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private cf binding;
    private final h b;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.p<Integer, Integer, w> {
        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            j.this.F1().q().postValue(Integer.valueOf(i));
            j.this.F1().r().postValue(Integer.valueOf(i2));
        }

        a() {
            super(2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.p<Integer, Integer, w> {
        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            j.this.F1().x().postValue(Integer.valueOf(i));
            j.this.F1().y().postValue(Integer.valueOf(i2));
        }

        b() {
            super(2);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements l<Long, w> {
        @Override // kotlin.d0.d.p
        public final void a(long j) {
            j.this.F1().u().postValue(Long.valueOf(j));
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(PottyProgramReminderViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { j.this.E1().createFragment() });
        }

        e() {
            super(0);
        }
    }
    public j() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.potty.reminders.j.d(this, null, new app.dogo.com.dogo_android.specialprograms.potty.reminders.j.e(this)));
    }

    public static final /* synthetic */ k B1(j jVar) {
        return jVar.E1();
    }

    public static final /* synthetic */ l C1(j jVar) {
        return jVar.F1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final void callReminderErrorDialog() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            int i = 2131886972;
            int i2 = 2131886971;
            app.dogo.com.dogo_android.util.extensionfunction.f1.E0(activity, i, i2);
        }
    }

    private final k E1() {
        return (PottyProgramReminderScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final l F1() {
        return (PottyProgramReminderViewModel)this.b.getValue();
    }

    private static final void N1(j jVar, View view) {
        n.f(jVar, "this$0");
        if (jVar.F1().m()) {
            jVar.F1().C();
            jVar.F1().atLeastOneDaySelected();
        } else {
            androidx.fragment.app.e activity = jVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887194);
            }
        }
    }

    private static final void O1(j jVar, View view) {
        Object value;
        Object value2;
        n.f(jVar, "this$0");
        androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            int i = 0;
            if ((Integer)jVar.F1().q().getValue() == null) {
                Integer num = 0;
            }
            if ((Integer)jVar.F1().r().getValue() == null) {
                Integer num2 = Integer.valueOf(i);
            }
            app.dogo.com.dogo_android.util.extensionfunction.g1.l0(activity, value.intValue(), value2.intValue(), new app.dogo.com.dogo_android.specialprograms.potty.reminders.j.a(jVar));
        }
    }

    private static final void P1(j jVar, View view) {
        Object value;
        Object value2;
        n.f(jVar, "this$0");
        androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            int i = 0;
            if ((Integer)jVar.F1().x().getValue() == null) {
                Integer num = 0;
            }
            if ((Integer)jVar.F1().y().getValue() == null) {
                Integer num2 = Integer.valueOf(i);
            }
            app.dogo.com.dogo_android.util.extensionfunction.g1.l0(activity, value.intValue(), value2.intValue(), new app.dogo.com.dogo_android.specialprograms.potty.reminders.j.b(jVar));
        }
    }

    private static final void Q1(j jVar, View view) {
        n.f(jVar, "this$0");
        androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.launchLogInActivity(activity, jVar.F1().t(), new app.dogo.com.dogo_android.specialprograms.potty.reminders.j.c(jVar));
        }
    }

    private static final void R1(j jVar, Boolean boolean) {
        n.f(jVar, "this$0");
        jVar.callReminderErrorDialog();
    }

    private static final void S1(j jVar, View view) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void T1(j jVar, Boolean boolean) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        cf cfVar = cf.T(inflater, container, false);
        n.e(cfVar, "inflate(inflater, container, false)");
        this.binding = cfVar;
        int i = 0;
        String str4 = "binding";
        if (cfVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            cfVar.V(F1());
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
    public void onViewCreated(View view, Bundle bundle) throws b {
        androidx.fragment.app.e activity;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (activity != null) {
            activity.F();
        }
        String str3 = "binding";
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.T.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.g(this));
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.Q.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.c(this));
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.R.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.d(this));
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding24.S.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.e(this));
                        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                        final String str2 = "viewLifecycleOwner";
                        n.e(viewLifecycleOwner, str2);
                        F1().w().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.specialprograms.potty.reminders.a(this));
                        if (this.binding == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            binding25.b0.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.f(this));
                            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                            n.e(viewLifecycleOwner2, str2);
                            F1().s().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.specialprograms.potty.reminders.b(this));
                            return;
                        }
                    }
                }
            }
        }
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, Boolean savedInstanceState) {
        PottyProgramReminderFragment.R1(view, savedInstanceState);
    }

    public static /* synthetic */ void H1(j jVar, Boolean boolean) {
        PottyProgramReminderFragment.T1(jVar, boolean);
    }

    public static /* synthetic */ void I1(j jVar, View view) {
        PottyProgramReminderFragment.O1(jVar, view);
    }

    public static /* synthetic */ void J1(j jVar, View view) {
        PottyProgramReminderFragment.P1(jVar, view);
    }

    public static /* synthetic */ void K1(j jVar, View view) {
        PottyProgramReminderFragment.Q1(jVar, view);
    }

    public static /* synthetic */ void L1(j jVar, View view) {
        PottyProgramReminderFragment.S1(jVar, view);
    }

    public static /* synthetic */ void M1(j jVar, View view) {
        PottyProgramReminderFragment.N1(jVar, view);
    }
}
