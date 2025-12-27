package app.dogo.com.dogo_android.x.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.ke;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;

/* compiled from: MetricsIntroductionDailyTimeFragment.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentMetricsIntroDailyTimeBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionDailyTimeScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class MetricsIntroductionDailyTimeFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private ke binding;
    private final f B1() {
        return (MetricsIntroductionDailyTimeScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private static final void E1(e eVar, View view) {
        n.f(eVar, "this$0");
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void F1(e eVar, View view) {
        n.f(eVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(eVar.getActivity(), new TrainingReminderWithTimeScreen("dashboard", eVar.B1().getFragmentParentReturnTag()));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ke keVar = ke.T(inflater, container, false);
        n.e(keVar, "inflate(inflater, container, false)");
        this.binding = keVar;
        int i = 0;
        String str4 = "binding";
        if (keVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            keVar.M(getViewLifecycleOwner());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (i != 0) {
            i.F();
        }
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setNavigationOnClickListener(new app.dogo.com.dogo_android.trainingmetrics.metricintroduction.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.trainingmetrics.metricintroduction.b(this));
                return;
            }
        }
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(e view, View savedInstanceState) {
        MetricsIntroductionDailyTimeFragment.E1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(e eVar, View view) {
        MetricsIntroductionDailyTimeFragment.F1(eVar, view);
    }
}
