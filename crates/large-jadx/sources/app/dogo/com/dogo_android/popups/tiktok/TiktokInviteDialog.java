package app.dogo.com.dogo_android.p.b;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.u9;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: TiktokInviteDialog.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/popups/tiktok/TiktokInviteDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogTiktokInviteBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewmodel", "Lapp/dogo/com/dogo_android/popups/tiktok/TiktokInviteViewModel;", "getViewmodel", "()Lapp/dogo/com/dogo_android/popups/tiktok/TiktokInviteViewModel;", "viewmodel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class TiktokInviteDialog extends u {

    /* renamed from: w, reason: from kotlin metadata */
    private u9 binding;
    private final h x;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<d> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TiktokInviteViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public c() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.x = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.popups.tiktok.c.a(this, aVar2, aVar2));
    }

    private final d X1() {
        return (TiktokInviteViewModel)this.x.getValue();
    }

    private static final void a2(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.dismiss();
    }

    private static final void b2(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.X1().i();
        androidx.fragment.app.e activity = cVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.clearBackstackAndGoToFragment(activity);
        }
        cVar.dismiss();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.TIKTOK_INVITE_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return S.challengeNotificationCenter;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog = getDialog();
        n.d(dialog);
        Window window = dialog.getWindow();
        n.d(window);
        window.setBackgroundDrawableResource(2131230939);
        u9 u9Var = u9.T(inflater, container, false);
        n.e(u9Var, "inflate(inflater, container, false)");
        this.binding = u9Var;
        int i2 = 0;
        String str3 = "binding";
        if (u9Var == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            u9Var.V(X1());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                return this.binding.w();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
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
            binding2.O.setOnClickListener(new app.dogo.com.dogo_android.popups.tiktok.b(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.P.setOnClickListener(new app.dogo.com.dogo_android.popups.tiktok.a(this));
                return;
            }
        }
    }


    /* renamed from: Y1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, View savedInstanceState) {
        TiktokInviteDialog.b2(view, savedInstanceState);
    }

    public static /* synthetic */ void Z1(c cVar, View view) {
        TiktokInviteDialog.a2(cVar, view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return BaseViewModel.class;
    }
}
