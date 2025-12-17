package app.dogo.com.dogo_android.p.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import app.dogo.com.dogo_android.h.e9;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/popups/instagram/InstagramInviteDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogInstagramInviteBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewmodel", "Lapp/dogo/com/dogo_android/popups/instagram/InstagramInviteViewModel;", "getViewmodel", "()Lapp/dogo/com/dogo_android/popups/instagram/InstagramInviteViewModel;", "viewmodel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "openAppStore", "packageName", "", "openInstagram", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends u {

    private e9 w;
    private final h x;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.p.a.d> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.p.a.d invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(d.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public c() {
        super();
        final int i = 0;
        c.a aVar = new c.a(this, i, i);
        this.x = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.p.a.d X1() {
        return (d)this.x.getValue();
    }

    public static void Y1(app.dogo.com.dogo_android.p.a.c c, View view2) {
        c.a2(c, view2);
    }

    public static void Z1(app.dogo.com.dogo_android.p.a.c c, View view2) {
        c.b2(c, view2);
    }

    private static final void a2(app.dogo.com.dogo_android.p.a.c c, View view2) {
        n.f(c, "this$0");
        c.dismiss();
    }

    private static final void b2(app.dogo.com.dogo_android.p.a.c c, View view2) {
        n.f(c, "this$0");
        c.X1().k();
        c.d2();
        c.dismiss();
    }

    private final void c2(String string) {
        Intent intent;
        Uri parse;
        Object obj4;
        intent = new Intent("android.intent.action.VIEW", Uri.parse(n.o("market://details?id=", string)));
        startActivity(intent);
        try {
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.INSTAGRAM_INVITE_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return j3.F0;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void d2() {
        PackageManager packageManager;
        Object intent;
        Intent launchIntentForPackage;
        Uri parse;
        app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
        if (a0Var == null) {
            packageManager = launchIntentForPackage;
        } else {
            packageManager = a0Var.getPackageManager();
        }
        if (packageManager == null) {
        } else {
            launchIntentForPackage = packageManager.getLaunchIntentForPackage(X1().i());
        }
        if (launchIntentForPackage != null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(X1().h()));
            startActivity(intent);
        } else {
            c2(X1().i());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        Dialog obj4 = getDialog();
        n.d(obj4);
        obj4 = obj4.getWindow();
        n.d(obj4);
        obj4.setBackgroundDrawableResource(2131230939);
        e9 obj2 = e9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.w = obj2;
        int obj3 = 0;
        obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(X1());
            obj2 = this.w;
            if (obj2 == null) {
            } else {
                return obj2.w();
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        e9 obj3 = this.w;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            a aVar = new a(this);
            obj3.O.setOnClickListener(aVar);
            obj3 = this.w;
            if (obj3 == null) {
            } else {
                obj4 = new b(this);
                obj3.P.setOnClickListener(obj4);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}
