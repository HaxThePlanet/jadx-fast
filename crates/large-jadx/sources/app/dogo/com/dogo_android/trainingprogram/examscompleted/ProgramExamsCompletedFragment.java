package app.dogo.com.dogo_android.y.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.gf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.n.i;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramExamsCompletedFragment.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramExamsCompletedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ProgramExamsCompletedFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private gf binding;
    private final d B1() {
        return (ProgramExamsCompletedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private static final void E1(c cVar, View view) {
        n.f(cVar, "this$0");
        final androidx.fragment.app.e activity = cVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void F1(c cVar, View view) {
        n.f(cVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(cVar.getActivity(), new CertificateDetailScreen(cVar.B1().b(), cVar.B1().createFragment(), "all_exams_completed", cVar.B1().getFragmentReturnTag()));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        gf gfVar = gf.T(inflater, container, false);
        n.e(gfVar, "inflate(inflater, container, false)");
        this.binding = gfVar;
        if (gfVar == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return gfVar.w();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        String str2 = "binding";
        i = 0;
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            this.binding.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.P.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.examscompleted.a(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.Q.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.examscompleted.b(this));
                    androidx.fragment.app.e view2 = getActivity();
                    if (view2 instanceof Navigator) {
                    }
                    if (i != 0) {
                        i.F();
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, View savedInstanceState) {
        ProgramExamsCompletedFragment.E1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(c cVar, View view) {
        ProgramExamsCompletedFragment.F1(cVar, view);
    }
}
