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

/* compiled from: LegacyBaseDialogFragment.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u000e\n\u0000\u0008&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u000f\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0008\u0010*\u001a\u00020\u001fH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020(2\u0008\u00100\u001a\u0004\u0018\u000101H\u0016J\u001c\u00102\u001a\u00020(2\u0008\u00103\u001a\u0004\u0018\u00010\u00102\u0008\u00104\u001a\u0004\u0018\u000101H\u0014J\u0008\u00105\u001a\u00020(H\u0016J\u0008\u00106\u001a\u00020(H\u0016J\u0008\u00107\u001a\u00020(H\u0016J\u0008\u00108\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020(2\u0006\u0010:\u001a\u000201H\u0016J\u0008\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010=\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020(2\u0008\u0008\u0001\u00104\u001a\u00020BJ\u0010\u0010A\u001a\u00020(2\u0008\u00104\u001a\u0004\u0018\u00010CR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u001a\u0010#\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001f0$X¦\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseFragment;", "()V", "mockEndpoint", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "(Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;)V", "channelListener", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "messagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getMessagingFilters", "()Ljava/util/Set;", "navAdapterInterface", "getNavAdapterInterface", "()Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "<set-?>", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "viewModel", "getViewModel", "()Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "viewModelClass", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "callLoadingDialog", "", "dismissLoadingDialog", "getBaseViewModel", "getNavigator", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onDestroy", "onDetach", "onPause", "onResume", "onSaveInstanceState", "outState", "onStop", "refresh", "setNavigator", "showSoftKeyboard", "view", "Landroid/view/View;", "showToast", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public abstract class LegacyBaseDialogFragment extends d implements v {

    /* renamed from: a, reason: from kotlin metadata */
    private a0 channelListener;
    private r b;
    /* renamed from: c, reason: from kotlin metadata */
    protected o3 messageBroadcaster;
    private final u.a v = new u$a();

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment$1", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "onMessageReceived", "", "action", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "message", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends u.a {

        final /* synthetic */ u e;
        a(c cVar, Set<? extends h> set) {
            this.e = uVar;
            super(cVar, set);
        }

        @Override // app.dogo.com.dogo_android.util.u$a
        /* renamed from: d, reason: from kotlin metadata */
        public void onMessageReceived(h action, Bundle message) {
            n.f(action, "action");
            n.f(message, "message");
            this.e.S1(action, message);
        }
    }
    public u() {
        super();
        this.messageBroadcaster = App.INSTANCE.r();
        final app.dogo.com.dogo_android.util.e0.u.a legacyBaseDialogFragment_1 = new LegacyBaseDialogFragment_1(this, E1(), F1());
    }

    private static final void O1(u uVar, Integer integer) {
        n.f(uVar, "this$0");
        if (integer != null) {
            uVar.onSaveInstanceState(integer.intValue());
        }
    }

    private static final void P1(u uVar, String str) {
        n.f(uVar, "this$0");
        if (str != null) {
            uVar.refresh(str);
        }
    }

    private static final void Q1(u uVar, Boolean boolean) {
        n.f(uVar, "this$0");
        if (boolean != null && boolean.booleanValue()) {
            uVar.callLoadingDialog();
        }
    }

    private static final void R1(u uVar, u.b bVar) {
        str = "this$0";
        n.f(uVar, str);
        if (bVar != null) {
            uVar.v.a(bVar.a(), bVar.b());
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: B1, reason: from kotlin metadata */
    public final void callLoadingDialog() {
        if (this.channelListener != null) {
            n.d(this.channelListener);
            this.channelListener.m();
        } else {
            str = "Navigator was null when trying to call loading spinner";
            a.c(str, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public final void C1() {
        if (this.channelListener != null) {
            n.d(this.channelListener);
            this.channelListener.s();
        } else {
            str = "Navigator was null when trying to dismiss loading spinner";
            a.c(str, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    public r D1() {
        return I1();
    }

    @Override // androidx.fragment.app.d
    protected Set<h> F1() {
        return new HashSet();
    }

    @Override // androidx.fragment.app.d
    public a0 G1() {
        return this.channelListener;
    }

    @Override // androidx.fragment.app.d
    public final r I1() {
        if (this.b == null) {
            n.w("viewModel");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.b;
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: T1, reason: from kotlin metadata */
    public final void onAttach(a0 context) {
        D1().refreshView(E1(), context);
    }

    @Override // androidx.fragment.app.d
    /* renamed from: U1, reason: from kotlin metadata */
    public final void onCreate(View savedInstanceState) {
        n.f(savedInstanceState, "view");
        if (savedInstanceState.requestFocus()) {
            Object systemService = savedInstanceState.getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            int i = 0;
            systemService.toggleSoftInput(1, i);
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: V1, reason: from kotlin metadata */
    public final void onSaveInstanceState(int outState) {
        if (this.channelListener != null) {
            n.d(this.channelListener);
            this.channelListener.t0(outState);
        } else {
            a.c("Navigator was null when trying to show toast", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: W1, reason: from kotlin metadata */
    public final void refresh(String navigator) {
        if (this.channelListener != null) {
            n.d(this.channelListener);
            this.channelListener.u0(navigator);
        } else {
            a.c("Navigator was null when trying to show toast", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: f0, reason: from kotlin metadata */
    public void setNavigator(a0 navigator) {
        n.f(navigator, "navigator");
        this.channelListener = navigator;
        navigator.Z(this.v);
    }

    @Override // androidx.fragment.app.d
    public void onAttach(Context context) {
        n.f(context, "context");
        super.onAttach(context);
        this.b = (BaseViewModel)h0.a(this).a(J1());
        D1().c.observe(this, new app.dogo.com.dogo_android.util.base_classes.c(this));
        D1().loadingDialogTrigger.observe(this, new app.dogo.com.dogo_android.util.base_classes.b(this));
        D1().parent.observe(this, new app.dogo.com.dogo_android.util.base_classes.a(this));
        D1().registry = E1();
        D1().k().observe(this, new app.dogo.com.dogo_android.util.base_classes.d(this));
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        app.dogo.com.dogo_android.util.e0.r rVar;
        String str;
        super.onCreate(bundle);
        if (bundle != null) {
            str = "view_model_bundle";
            D1().onRestoreState(bundle.getBundle(str));
        }
        if (H1() != null) {
            androidx.fragment.app.e requireActivity = requireActivity();
            n.e(requireActivity, "requireActivity()");
            k3 k3Var2 = H1();
            n.d(k3Var2);
            this.messageBroadcaster.logScreenView(requireActivity, k3Var2);
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
        this.channelListener = null;
    }

    @Override // androidx.fragment.app.d
    public void onPause() {
        super.onPause();
        D1().o();
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        D1().q();
        if (this.channelListener == null) {
            Dialog dialog = getDialog();
            n.d(dialog);
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        n.f(bundle, "outState");
        Bundle bundle2 = D1().r();
        if (bundle2 != null) {
            str = "view_model_bundle";
            bundle.putBundle(str, bundle2);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        super.onStop();
        D1().t();
    }

    /* renamed from: K1, reason: from kotlin metadata */
    public static /* synthetic */ void onDataReceived(u action, Boolean message) {
        LegacyBaseDialogFragment.Q1(action, message);
    }

    public static /* synthetic */ void L1(u uVar, String str) {
        LegacyBaseDialogFragment.P1(uVar, str);
    }

    public static /* synthetic */ void M1(u uVar, Integer integer) {
        LegacyBaseDialogFragment.O1(uVar, integer);
    }

    public static /* synthetic */ void N1(u uVar, u.b bVar) {
        LegacyBaseDialogFragment.R1(uVar, bVar);
    }

    @Override // androidx.fragment.app.d
    public abstract c E1();

    @Override // androidx.fragment.app.d
    public abstract k3 H1();

    @Override // androidx.fragment.app.d
    public abstract Class<? extends r> J1();

    @Override // androidx.fragment.app.d
    protected void S1(h hVar, Bundle bundle) {
    }
}
