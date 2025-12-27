package app.dogo.com.dogo_android.r;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ch;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: TrainingReminderFragment.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/reminder/TrainingReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTrainingReminderWithTimeBinding;", "viewModel", "Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weekdayButtons", "", "Landroid/widget/CompoundButton;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class TrainingReminderFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private ch binding;
    private final h b;
    /* renamed from: c, reason: from kotlin metadata */
    private final List<CompoundButton> weekdayButtons = new ArrayList<>();

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TrainingReminderViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public j() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.reminder.j.a(this, aVar2, aVar2));
        ArrayList arrayList = new ArrayList();
    }

    private final l B1() {
        return (TrainingReminderViewModel)this.b.getValue();
    }

    private static final void G1(j jVar, View view) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void H1(j jVar, Boolean boolean) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void I1(j jVar, Boolean boolean) {
        n.f(jVar, "this$0");
        n.e(boolean, "it");
        if (boolean.booleanValue()) {
            jVar.B1().p(jVar.weekdayButtons);
        }
    }

    private static final void J1(j jVar, View view) {
        n.f(jVar, "this$0");
        if (jVar.B1().atLeastOneDaySelected()) {
            jVar.B1().w();
        } else {
            androidx.fragment.app.e activity = jVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131887194);
            }
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
        ch chVar = ch.T(inflater, container, false);
        n.e(chVar, "inflate(inflater, container, false)");
        this.binding = chVar;
        int i = 0;
        String str4 = "binding";
        if (chVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            chVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.W(B1());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(Boolean.FALSE);
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
            TrainingReminderWithTimeFragment.Companion.a(this.weekdayButtons, binding2.O);
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.b0.setNavigationOnClickListener(new app.dogo.com.dogo_android.reminder.b(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                B1().r().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.reminder.a(this));
                B1().x();
                B1().v().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.reminder.c(this));
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.R.setOnClickListener(new app.dogo.com.dogo_android.reminder.d(this));
                    return;
                }
            }
        }
    }


    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, Boolean savedInstanceState) {
        TrainingReminderFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(j jVar, View view) {
        TrainingReminderFragment.G1(jVar, view);
    }

    public static /* synthetic */ void E1(j jVar, Boolean boolean) {
        TrainingReminderFragment.I1(jVar, boolean);
    }

    public static /* synthetic */ void F1(j jVar, View view) {
        TrainingReminderFragment.J1(jVar, view);
    }
}
