package app.dogo.com.dogo_android.util.e0;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.u.a;
import app.dogo.com.dogo_android.util.u.b;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u000e\n\u0000\u0008&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u000f\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0008\u0010*\u001a\u00020\u001fH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020(2\u0008\u00100\u001a\u0004\u0018\u000101H\u0016J\u001c\u00102\u001a\u00020(2\u0008\u00103\u001a\u0004\u0018\u00010\u00102\u0008\u00104\u001a\u0004\u0018\u000101H\u0014J\u0008\u00105\u001a\u00020(H\u0016J\u0008\u00106\u001a\u00020(H\u0016J\u0008\u00107\u001a\u00020(H\u0016J\u0008\u00108\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020(2\u0006\u0010:\u001a\u000201H\u0016J\u0008\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010=\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020(2\u0008\u0008\u0001\u00104\u001a\u00020BJ\u0010\u0010A\u001a\u00020(2\u0008\u00104\u001a\u0004\u0018\u00010CR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u001a\u0010#\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0$X¦\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseFragment;", "()V", "mockEndpoint", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "(Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;)V", "channelListener", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "messagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getMessagingFilters", "()Ljava/util/Set;", "navAdapterInterface", "getNavAdapterInterface", "()Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "<set-?>", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "viewModel", "getViewModel", "()Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "viewModelClass", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "callLoadingDialog", "", "dismissLoadingDialog", "getBaseViewModel", "getNavigator", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onDestroy", "onDetach", "onPause", "onResume", "onSaveInstanceState", "outState", "onStop", "refresh", "setNavigator", "showSoftKeyboard", "view", "Landroid/view/View;", "showToast", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class u extends d implements app.dogo.com.dogo_android.util.e0.v {

    private app.dogo.com.dogo_android.util.e0.a0 a;
    private app.dogo.com.dogo_android.util.e0.r b;
    protected o3 c;
    private final u.a v;

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment$1", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "onMessageReceived", "", "action", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "message", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends u.a {

        final app.dogo.com.dogo_android.util.e0.u e;
        a(app.dogo.com.dogo_android.util.e0.u u, c c2, Set<? extends h> set3) {
            this.e = u;
            super(c2, set3);
        }

        @Override // app.dogo.com.dogo_android.util.u$a
        public void d(h h, Bundle bundle2) {
            n.f(h, "action");
            n.f(bundle2, "message");
            this.e.S1(h, bundle2);
        }
    }
    public u() {
        super();
        this.c = App.Companion.r();
        u.a aVar = new u.a(this, E1(), F1());
        this.v = aVar;
    }

    public static void K1(app.dogo.com.dogo_android.util.e0.u u, Boolean boolean2) {
        u.Q1(u, boolean2);
    }

    public static void L1(app.dogo.com.dogo_android.util.e0.u u, String string2) {
        u.P1(u, string2);
    }

    public static void M1(app.dogo.com.dogo_android.util.e0.u u, Integer integer2) {
        u.O1(u, integer2);
    }

    public static void N1(app.dogo.com.dogo_android.util.e0.u u, u.b u$b2) {
        u.R1(u, b2);
    }

    private static final void O1(app.dogo.com.dogo_android.util.e0.u u, Integer integer2) {
        int obj2;
        n.f(u, "this$0");
        if (integer2 == 0) {
        } else {
            u.V1(integer2.intValue());
        }
    }

    private static final void P1(app.dogo.com.dogo_android.util.e0.u u, String string2) {
        n.f(u, "this$0");
        if (string2 == null) {
        } else {
            u.W1(string2);
        }
    }

    private static final void Q1(app.dogo.com.dogo_android.util.e0.u u, Boolean boolean2) {
        boolean obj2;
        n.f(u, "this$0");
        if (boolean2) {
            if (boolean2.booleanValue()) {
                u.B1();
            } else {
                u.C1();
            }
        }
    }

    private static final void R1(app.dogo.com.dogo_android.util.e0.u u, u.b u$b2) {
        Object str;
        Object obj1;
        Bundle obj2;
        n.f(u, "this$0");
        if (b2 != null) {
            u.v.a(b2.a(), b2.b());
        }
    }

    @Override // androidx.fragment.app.d
    public final void B1() {
        app.dogo.com.dogo_android.util.e0.a0 arr;
        String str;
        arr = this.a;
        if (arr != null) {
            n.d(arr);
            arr.m();
        } else {
            a.c("Navigator was null when trying to call loading spinner", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public final void C1() {
        app.dogo.com.dogo_android.util.e0.a0 arr;
        String str;
        arr = this.a;
        if (arr != null) {
            n.d(arr);
            arr.s();
        } else {
            a.c("Navigator was null when trying to dismiss loading spinner", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public app.dogo.com.dogo_android.util.e0.r D1() {
        return I1();
    }

    @Override // androidx.fragment.app.d
    public abstract c E1();

    protected Set<h> F1() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    @Override // androidx.fragment.app.d
    public app.dogo.com.dogo_android.util.e0.a0 G1() {
        return this.a;
    }

    @Override // androidx.fragment.app.d
    public abstract k3 H1();

    @Override // androidx.fragment.app.d
    public final app.dogo.com.dogo_android.util.e0.r I1() {
        app.dogo.com.dogo_android.util.e0.r rVar = this.b;
        if (rVar == null) {
        } else {
            return rVar;
        }
        n.w("viewModel");
        throw 0;
    }

    public abstract Class<? extends app.dogo.com.dogo_android.util.e0.r> J1();

    @Override // androidx.fragment.app.d
    protected void S1(h h, Bundle bundle2) {
    }

    @Override // androidx.fragment.app.d
    public final void T1(app.dogo.com.dogo_android.util.e0.a0 a0) {
        D1().u(E1(), a0);
    }

    @Override // androidx.fragment.app.d
    public final void U1(View view) {
        boolean requestFocus;
        int i;
        Object obj3;
        n.f(view, "view");
        if (view.requestFocus()) {
            obj3 = view.getContext().getSystemService("input_method");
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            (InputMethodManager)obj3.toggleSoftInput(1, 0);
        }
    }

    @Override // androidx.fragment.app.d
    public final void V1(int i) {
        Object str;
        int obj2;
        str = this.a;
        if (str != null) {
            n.d(str);
            str.t0(i);
        } else {
            a.c("Navigator was null when trying to show toast", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public final void W1(String string) {
        Object str;
        String obj2;
        str = this.a;
        if (str != null) {
            n.d(str);
            str.u0(string);
        } else {
            a.c("Navigator was null when trying to show toast", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public void f0(app.dogo.com.dogo_android.util.e0.a0 a0) {
        n.f(a0, "navigator");
        this.a = a0;
        a0.Z(this.v);
    }

    @Override // androidx.fragment.app.d
    public void onAttach(Context context) {
        n.f(context, "context");
        super.onAttach(context);
        this.b = (r)h0.a(this).a(J1());
        c cVar = new c(this);
        obj2.c.observe(this, cVar);
        b bVar = new b(this);
        obj2.b.observe(this, bVar);
        a aVar = new a(this);
        obj2.v.observe(this, aVar);
        obj2.w = E1();
        d dVar = new d(this);
        D1().k().observe(this, dVar);
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        app.dogo.com.dogo_android.util.e0.r requireActivity;
        String str;
        Bundle obj3;
        super.onCreate(bundle);
        if (bundle != null) {
            D1().p(bundle.getBundle("view_model_bundle"));
        }
        if (H1() != null) {
            requireActivity = requireActivity();
            n.e(requireActivity, "requireActivity()");
            str = H1();
            n.d(str);
            this.c.h(requireActivity, str);
        }
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        D1().n();
    }

    @Override // androidx.fragment.app.d
    public void onDetach() {
        super.onDetach();
        this.v.g();
        this.v.f();
        this.a = 0;
    }

    @Override // androidx.fragment.app.d
    public void onPause() {
        super.onPause();
        D1().o();
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        Object dialog;
        super.onResume();
        D1().q();
        if (this.a == null) {
            dialog = getDialog();
            n.d(dialog);
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        String str;
        n.f(bundle, "outState");
        Bundle bundle2 = D1().r();
        if (bundle2 != null) {
            bundle.putBundle("view_model_bundle", bundle2);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        super.onStop();
        D1().t();
    }
}
