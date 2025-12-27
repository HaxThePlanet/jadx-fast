package app.dogo.com.dogo_android.d.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ChallengeShareDialog.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeShareBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "shareLink", "shareToInstagram", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ChallengeShareDialog extends u {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final e.a INSTANCE = new e$a(0);
    /* renamed from: w, reason: from kotlin metadata */
    private s8 binding;
    private final h x;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/share/ChallengeShareDialog$Companion;", "", "()V", "CHALLENGE_SHARE_LINKTYPE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeShareViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public e() {
        super();
        final m.a.c.j.a aVar = null;
        this.x = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.challenge.share.e.b(this, aVar, aVar));
    }

    /* renamed from: X1, reason: from kotlin metadata */
    private final f shareLink() {
        return (ChallengeShareViewModel)this.x.getValue();
    }

    private static final void c2(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.dismiss();
    }

    private static final void d2(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.h2();
    }

    private static final void e2(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.f2();
    }

    private static final void g2(e eVar, com.google.android.gms.tasks.j jVar) throws android.content.res.Resources.NotFoundException {
        n.f(eVar, "this$0");
        eVar.C1();
        if (!jVar.isSuccessful()) {
            int i2 = 2131886123;
            eVar.onSaveInstanceState(i2);
        } else {
            if (jVar.getResult() != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                Object result2 = jVar.getResult();
                n.d(result2);
                intent.putExtra("android.intent.extra.TEXT", String.valueOf(result2.getShortLink()));
                eVar.shareLink().m();
                int i = 2131887330;
                eVar.startActivity(Intent.createChooser(intent, eVar.getResources().getString(i)));
                eVar.dismiss();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.CHALLENGE_SHARE_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return S.debugEditJsonArray;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void f2() {
        callLoadingDialog();
        shareLink().h("sharing_challenge_photo").addOnCompleteListener(new app.dogo.com.dogo_android.challenge.share.c(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public final void h2() throws android.content.res.Resources.NotFoundException {
        PackageManager packageManager;
        int i = 0;
        app.dogo.com.dogo_android.util.e0.a0 a0Var;
        android.net.Uri uri;
        int i2 = 3;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", shareLink().i());
        intent.setPackage(ApplicationPackageNames.INSTAGRAM_PACKAGE_NAME.getTag());
        intent.setType("image/*");
        app.dogo.com.dogo_android.util.e0.a0 a0Var2 = G1();
        i = 0;
        if (a0Var2 != null) {
            packageManager = a0Var2.getPackageManager();
            if (packageManager != null) {
                List intentActivities = packageManager.queryIntentActivities(intent, 65536);
            }
        }
        if ("android.intent.extra.STREAM" != 0) {
            Iterator it = i.iterator();
            while (it.hasNext()) {
                a0Var = G1();
            }
        }
        startActivity(Intent.createChooser(intent, getResources().getString(2131887330)));
        shareLink().l();
        dismiss();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog2 = getDialog();
        n.d(dialog2);
        Window window = dialog2.getWindow();
        n.d(window);
        window.setBackgroundDrawableResource(2131230939);
        s8 s8Var = s8.T(inflater, container, false);
        n.e(s8Var, "inflate(inflater, container, false)");
        this.binding = s8Var;
        Dialog dialog = getDialog();
        n.d(dialog);
        dialog.setCanceledOnTouchOutside(true);
        shareLink().j(getArguments());
        int i3 = 0;
        String str3 = "binding";
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        } else {
            binding2.O.setOnClickListener(new app.dogo.com.dogo_android.challenge.share.b(this));
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i3;
            } else {
                binding22.P.setOnClickListener(new app.dogo.com.dogo_android.challenge.share.d(this));
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    binding23.Q.setOnClickListener(new app.dogo.com.dogo_android.challenge.share.a(this));
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i3;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        C1();
    }

    /* renamed from: Y1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(e view, View savedInstanceState) {
        ChallengeShareDialog.e2(view, savedInstanceState);
    }

    public static /* synthetic */ void Z1(e eVar, View view) {
        ChallengeShareDialog.c2(eVar, view);
    }

    public static /* synthetic */ void a2(e eVar, com.google.android.gms.tasks.j jVar) {
        ChallengeShareDialog.g2(eVar, jVar);
    }

    public static /* synthetic */ void b2(e eVar, View view) {
        ChallengeShareDialog.d2(eVar, view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return BaseViewModel.class;
    }
}
