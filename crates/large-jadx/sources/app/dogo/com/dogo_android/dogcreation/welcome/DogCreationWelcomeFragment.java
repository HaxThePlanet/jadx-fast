package app.dogo.com.dogo_android.dogcreation.o;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.h.yb;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogCreationWelcomeFragment.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/welcome/DogCreationWelcomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationWelcomeBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class DogCreationWelcomeFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private yb binding;
    private static final void D1(c cVar, View view) {
        androidx.fragment.app.e activity = null;
        n.f(cVar, "this$0");
        cVar = cVar.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)cVar.getActivity() : 0;
        if (activity != null) {
            activity.A();
        }
    }

    private static final void E1(c cVar, View view) {
        androidx.fragment.app.e activity = null;
        n.f(cVar, "this$0");
        cVar = cVar.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)cVar.getActivity() : 0;
        if (activity != null) {
            activity.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        yb ybVar = yb.T(inflater, container, false);
        n.e(ybVar, "inflate(inflater, container, false)");
        this.binding = ybVar;
        int i = 0;
        String str4 = "binding";
        if (ybVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ybVar.M(getViewLifecycleOwner());
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
    public void onViewCreated(View view, Bundle bundle) throws a {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.welcome.b(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.Q.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.welcome.a(this));
                return;
            }
        }
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, View savedInstanceState) {
        DogCreationWelcomeFragment.E1(view, savedInstanceState);
    }

    public static /* synthetic */ void C1(c cVar, View view) {
        DogCreationWelcomeFragment.D1(cVar, view);
    }
}
