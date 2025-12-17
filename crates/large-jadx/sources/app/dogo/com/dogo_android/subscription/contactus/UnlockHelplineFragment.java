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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentUnlockHelplineBinding;", "screenKey", "Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UnlockHelplineFragment extends Fragment {

    private eh binding;
    private final h sharedViewModel$delegate;
    static {
    }

    public UnlockHelplineFragment() {
        super();
        final int i = 0;
        UnlockHelplineFragment.special$$inlined.sharedViewModel.default.1 anon = new UnlockHelplineFragment.special$$inlined.sharedViewModel.default.1(this, i, i);
        this.sharedViewModel$delegate = j.a(m.NONE, anon);
    }

    public static void B1(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment, View view2) {
        UnlockHelplineFragment.onViewCreated$lambda-0(unlockHelplineFragment, view2);
    }

    public static void C1(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment, View view2) {
        UnlockHelplineFragment.onViewCreated$lambda-1(unlockHelplineFragment, view2);
    }

    private final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen getScreenKey() {
        return (UnlockHelplineScreen)k1.a(this);
    }

    private final l getSharedViewModel() {
        return (l)this.sharedViewModel$delegate.getValue();
    }

    private static final void onViewCreated$lambda-0(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment, View view2) {
        n.f(unlockHelplineFragment, "this$0");
        g1.n(unlockHelplineFragment.getActivity(), l.H(unlockHelplineFragment.getSharedViewModel(), unlockHelplineFragment.getScreenKey().getSource(), unlockHelplineFragment.getScreenKey().getFragmentReturnTag(), false, 0, 12, 0));
    }

    private static final void onViewCreated$lambda-1(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineFragment unlockHelplineFragment, View view2) {
        n.f(unlockHelplineFragment, "this$0");
        final androidx.fragment.app.e obj0 = unlockHelplineFragment.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        eh obj2 = eh.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.binding = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.binding;
            if (obj2 == null) {
            } else {
                obj2 = obj2.w();
                n.e(obj2, "binding.root");
                return obj2;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        eh obj3 = this.binding;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            a aVar = new a(this);
            obj3.P.setOnClickListener(aVar);
            obj3 = this.binding;
            if (obj3 == null) {
            } else {
                obj4 = new b(this);
                obj3.O.setOnClickListener(obj4);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
