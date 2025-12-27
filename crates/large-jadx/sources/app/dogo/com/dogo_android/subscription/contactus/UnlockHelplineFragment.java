package app.dogo.com.dogo_android.subscription.contactus;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.eh;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: UnlockHelplineFragment.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentUnlockHelplineBinding;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class UnlockHelplineFragment extends Fragment {

    private eh binding;
    /* renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final h sharedViewModel;
    public UnlockHelplineFragment() {
        super();
        final m.a.c.j.a aVar = null;
        this.sharedViewModel = j.a(LazyThreadSafetyMode.NONE, new UnlockHelplineFragment.special$$inlined.sharedViewModel.default.AnonymousClass1(this, aVar, aVar));
    }

    private final UnlockHelplineScreen getScreenKey() {
        return (UnlockHelplineScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.sharedViewModel.getValue();
    }

    private static final void onViewCreated$lambda_0(UnlockHelplineFragment unlockHelplineFragment, View view) {
        n.f(unlockHelplineFragment, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(unlockHelplineFragment.getActivity(), SessionViewModel.H(unlockHelplineFragment.getSharedViewModel(), unlockHelplineFragment.getScreenKey().getSource(), unlockHelplineFragment.getScreenKey().getFragmentReturnTag(), false, null, 12, null));
    }

    private static final void onViewCreated$lambda_1(UnlockHelplineFragment unlockHelplineFragment, View view) {
        n.f(unlockHelplineFragment, "this$0");
        final androidx.fragment.app.e activity = unlockHelplineFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
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
        eh ehVar = eh.T(inflater, container, false);
        n.e(ehVar, "inflate(inflater, container, false)");
        this.binding = ehVar;
        int i = 0;
        String str4 = "binding";
        if (ehVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ehVar.M(getViewLifecycleOwner());
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
    public void onViewCreated(View view, Bundle bundle) throws b {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setOnClickListener(new a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.O.setOnClickListener(new b(this));
                return;
            }
        }
    }


    /* renamed from: B1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(UnlockHelplineFragment view, View savedInstanceState) {
        UnlockHelplineFragment.onViewCreated$lambda_0(view, savedInstanceState);
    }

    public static /* synthetic */ void C1(UnlockHelplineFragment unlockHelplineFragment, View view) {
        UnlockHelplineFragment.onViewCreated$lambda_1(unlockHelplineFragment, view);
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }
}
