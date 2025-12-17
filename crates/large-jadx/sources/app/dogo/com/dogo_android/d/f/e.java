package app.dogo.com.dogo_android.d.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.s8;
import app.dogo.com.dogo_android.k.a;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import com.google.android.gms.tasks.j;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeShareBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "shareLink", "shareToInstagram", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends u {

    public static final app.dogo.com.dogo_android.d.f.e.a Companion;
    private s8 w;
    private final h x;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareDialog$Companion;", "", "()V", "CHALLENGE_SHARE_LINKTYPE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.d.f.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.d.f.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.Companion = aVar;
    }

    public e() {
        super();
        final int i = 0;
        e.b bVar = new e.b(this, i, i);
        this.x = j.a(m.SYNCHRONIZED, bVar);
    }

    private final app.dogo.com.dogo_android.d.f.f X1() {
        return (f)this.x.getValue();
    }

    public static void Y1(app.dogo.com.dogo_android.d.f.e e, View view2) {
        e.e2(e, view2);
    }

    public static void Z1(app.dogo.com.dogo_android.d.f.e e, View view2) {
        e.c2(e, view2);
    }

    public static void a2(app.dogo.com.dogo_android.d.f.e e, j j2) {
        e.g2(e, j2);
    }

    public static void b2(app.dogo.com.dogo_android.d.f.e e, View view2) {
        e.d2(e, view2);
    }

    private static final void c2(app.dogo.com.dogo_android.d.f.e e, View view2) {
        n.f(e, "this$0");
        e.dismiss();
    }

    private static final void d2(app.dogo.com.dogo_android.d.f.e e, View view2) {
        n.f(e, "this$0");
        e.h2();
    }

    private static final void e2(app.dogo.com.dogo_android.d.f.e e, View view2) {
        n.f(e, "this$0");
        e.f2();
    }

    private static final void g2(app.dogo.com.dogo_android.d.f.e e, j j2) {
        boolean successful;
        int i;
        int obj3;
        n.f(e, "this$0");
        e.C1();
        if (!j2.isSuccessful()) {
            e.V1(2131886123);
        } else {
            if (j2.getResult() != null) {
                successful = new Intent("android.intent.action.SEND");
                successful.setType("text/plain");
                obj3 = j2.getResult();
                n.d(obj3);
                successful.putExtra("android.intent.extra.TEXT", String.valueOf((ShortDynamicLink)obj3.getShortLink()));
                e.X1().m();
                e.startActivity(Intent.createChooser(successful, e.getResources().getString(2131887330)));
                e.dismiss();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.CHALLENGE_SHARE_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return j3.Q;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void f2() {
        B1();
        c cVar = new c(this);
        X1().h("sharing_challenge_photo").addOnCompleteListener(cVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void h2() {
        Object packageManager;
        int intentActivities;
        app.dogo.com.dogo_android.util.e0.a0 a0Var;
        android.net.Uri uri;
        int i;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", X1().i());
        intent.setPackage(a.INSTAGRAM_PACKAGE_NAME.getTag());
        intent.setType("image/*");
        packageManager = G1();
        intentActivities = 0;
        if (packageManager == null) {
        } else {
            packageManager = packageManager.getPackageManager();
            if (packageManager == null) {
            } else {
                intentActivities = packageManager.queryIntentActivities(intent, 65536);
            }
        }
        if (intentActivities != 0) {
            packageManager = intentActivities.iterator();
            while (packageManager.hasNext()) {
                a0Var = G1();
                if (a0Var == null) {
                } else {
                }
                a0Var.grantUriPermission(activityInfo.packageName, X1().i(), 3);
            }
        }
        startActivity(Intent.createChooser(intent, getResources().getString(2131887330)));
        X1().l();
        dismiss();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        Dialog obj4 = getDialog();
        n.d(obj4);
        obj4 = obj4.getWindow();
        n.d(obj4);
        obj4.setBackgroundDrawableResource(2131230939);
        s8 obj2 = s8.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.w = obj2;
        obj2 = getDialog();
        n.d(obj2);
        obj2.setCanceledOnTouchOutside(true);
        X1().j(getArguments());
        obj2 = this.w;
        int obj3 = 0;
        obj4 = "binding";
        if (obj2 == null) {
        } else {
            b bVar = new b(this);
            obj2.O.setOnClickListener(bVar);
            obj2 = this.w;
            if (obj2 == null) {
            } else {
                d dVar = new d(this);
                obj2.P.setOnClickListener(dVar);
                obj2 = this.w;
                if (obj2 == null) {
                } else {
                    a aVar = new a(this);
                    obj2.Q.setOnClickListener(aVar);
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
        C1();
    }
}
