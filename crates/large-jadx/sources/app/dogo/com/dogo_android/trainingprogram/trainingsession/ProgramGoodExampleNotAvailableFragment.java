package app.dogo.com.dogo_android.y.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.id;
import app.dogo.com.dogo_android.util.e0.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramGoodExampleNotAvailableFragment.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/FragmentGoodExampleNotAvailableBinding;)V", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramGoodExampleNotAvailableScreen;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ProgramGoodExampleNotAvailableFragment extends Fragment {

    public id a;
    private static final void D1(h hVar, View view) {
        n.f(hVar, "this$0");
        final androidx.fragment.app.e activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: B1, reason: from kotlin metadata */
    public final id onResume() {
        if (this.a == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.a;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void E1(id idVar) {
        n.f(idVar, "<set-?>");
        this.a = idVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        id idVar = id.T(inflater, container, false);
        n.e(idVar, "inflate(inflater, container, false)");
        E1(idVar);
        onResume().M(getViewLifecycleOwner());
        return onResume().w();
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
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        onResume().O.setNavigationOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.a(this));
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, View savedInstanceState) {
        ProgramGoodExampleNotAvailableFragment.D1(view, savedInstanceState);
    }
}
