package app.dogo.com.dogo_android.dogcreation.n;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.o.d;
import app.dogo.com.dogo_android.h.wb;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.r.m.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import m.a.b.a.d.a.b;

/* compiled from: DogCreationReminderFragment.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/reminder/DogCreationReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationReminderWithTimeBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "viewModel$delegate", "weekdayButtons", "", "Landroid/widget/CompoundButton;", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DogCreationReminderFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private wb binding;
    private final h b;
    private final h c;
    /* renamed from: v, reason: from kotlin metadata */
    private final List<CompoundButton> weekdayButtons = new ArrayList<>();

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TrainingReminderViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public h() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.dogcreation.reminder.h.a(this, aVar2, aVar2));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dogcreation.reminder.h.b(this, aVar2, aVar2));
        ArrayList arrayList = new ArrayList();
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final g goToNextScreen() {
        return (DogCreationSharedViewModel)this.b.getValue();
    }

    private final l C1() {
        return (TrainingReminderViewModel)this.c.getValue();
    }

    private final void D1() {
        androidx.fragment.app.e activity = null;
        if (goToNextScreen().isUserSignedIn()) {
            if (!goToNextScreen().q()) {
                DogCreationActivity r0 = getActivity() instanceof DogCreationActivity ? (DogCreationActivity)this.getActivity() : 0;
                if (activity != null) {
                    activity.z();
                }
            } else {
                activity = getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationWelcomeScreen());
                }
            }
        } else {
            goToNextScreen().r(app.dogo.com.dogo_android.util.extensionfunction.k1.a(this));
            activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationLoginScreen());
            }
        }
    }

    private static final void L1(h hVar, View view) {
        n.f(hVar, "this$0");
        final androidx.fragment.app.e activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void M1(h hVar, Boolean boolean) {
        n.f(hVar, "this$0");
        hVar.D1();
    }

    private static final void N1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.D1();
    }

    private static final void O1(h hVar, View view) {
        n.f(hVar, "this$0");
        final androidx.fragment.app.e activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void P1(h hVar, y yVar) {
        Exception component1 = null;
        int i;
        n.f(hVar, "this$0");
        yVar = yVar instanceof LoadResult_Error ? (oadResult_Error)yVar : 0;
        if (i != 0) {
            component1 = i.component1();
        }
        z = component1 instanceof UnknownHostException;
    }

    private static final void Q1(h hVar, View view) {
        n.f(hVar, "this$0");
        if (hVar.C1().atLeastOneDaySelected()) {
            hVar.C1().w();
        } else {
            androidx.fragment.app.e activity = hVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887194);
            }
        }
    }

    private static final void R1(h hVar, Boolean boolean) {
        n.f(hVar, "this$0");
        n.e(boolean, "it");
        if (boolean.booleanValue()) {
            hVar.C1().p(hVar.weekdayButtons);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        wb wbVar = wb.T(inflater, container, false);
        n.e(wbVar, "inflate(inflater, container, false)");
        this.binding = wbVar;
        int i = 0;
        String str4 = "binding";
        if (wbVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            wbVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(C1());
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
    public void onResume() {
        int i = 0;
        super.onResume();
        if (goToNextScreen().l() == null) {
            z = getActivity() instanceof DogCreationActivity;
            DogCreationActivity r0 = this.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)this.getActivity() : 0;
            if (i != 0) {
                i.y();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        final int i = 0;
        final String str3 = "binding";
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            n.e(binding2.O, "binding.checkGroupView");
            TrainingReminderWithTimeFragment.INSTANCE.fillButtons(this.weekdayButtons, binding2.O);
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.X.setNavigationOnClickListener(new app.dogo.com.dogo_android.dogcreation.reminder.g(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                C1().r().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.dogcreation.reminder.d(this));
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.Y.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.reminder.f(this));
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding24.X.setNavigationOnClickListener(new app.dogo.com.dogo_android.dogcreation.reminder.e(this));
                        C1().u().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.dogcreation.reminder.b(this));
                        if (this.binding == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            binding25.P.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.reminder.a(this));
                            C1().x();
                            C1().v().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.dogcreation.reminder.c(this));
                            return;
                        }
                    }
                }
            }
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, View savedInstanceState) {
        DogCreationReminderFragment.Q1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(h hVar, y yVar) {
        DogCreationReminderFragment.P1(hVar, yVar);
    }

    public static /* synthetic */ void G1(h hVar, Boolean boolean) {
        DogCreationReminderFragment.R1(hVar, boolean);
    }

    public static /* synthetic */ void H1(h hVar, Boolean boolean) {
        DogCreationReminderFragment.M1(hVar, boolean);
    }

    public static /* synthetic */ void I1(h hVar, View view) {
        DogCreationReminderFragment.O1(hVar, view);
    }

    public static /* synthetic */ void J1(h hVar, View view) {
        DogCreationReminderFragment.N1(hVar, view);
    }

    public static /* synthetic */ void K1(h hVar, View view) {
        DogCreationReminderFragment.L1(hVar, view);
    }
}
