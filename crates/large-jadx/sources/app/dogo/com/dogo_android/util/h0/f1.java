package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.h;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import app.dogo.com.dogo_android.h.ai;
import app.dogo.com.dogo_android.h.i9;
import app.dogo.com.dogo_android.h.s;
import app.dogo.com.dogo_android.h.u;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.o3;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a$\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a$\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a\u0012\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c\u001a\n\u0010\r\u001a\u00020\t*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\t*\u00020\n\u001a&\u0010\u0010\u001a\u00020\t*\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010\u0015\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a0\u0010\u0017\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u0016\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013\u001a\u001a\u0010\u001b\u001a\u00020\t*\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0013\u001a\u0018\u0010\u001c\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a2\u0010\u001d\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u00192\u0012\u0008\u0002\u0010\u0016\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013\u001a3\u0010 \u001a\u00020\t*\u00020\n2\n\u0008\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u00192\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\u0010!\u001a(\u0010\"\u001a\u00020\t*\u00020\u00112\u0008\u0010#\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u00062\u0008\u0010%\u001a\u0004\u0018\u00010\u0006\u001a\u0014\u0010&\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010'\u001a\u00020\u0019\u001a.\u0010(\u001a\u00020\t*\u00020)2\u0006\u0010*\u001a\u00020+2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a5\u0010.\u001a\u00020\t*\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00062!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u00080\u0012\u0008\u00081\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020\t0/\u001a\u0018\u00103\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\n\u00104\u001a\u00020\t*\u00020\n\u001a\u0014\u00105\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u0019\u001a4\u00106\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u00109\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a4\u0010:\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a.\u0010<\u001a\u00020\t*\u00020)2\u0006\u0010=\u001a\u00020\u00062\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a&\u0010>\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010@\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010A\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a<\u0010B\u001a\u00020\t*\u00020\n2\u0006\u0010=\u001a\u00020\u00062\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010D\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\n\u0010E\u001a\u00020F*\u00020\n\u001a\u0018\u0010G\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a \u0010H\u001a\u00020\t*\u00020)2\u0006\u0010'\u001a\u00020\u00192\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a \u0010I\u001a\u00020\t*\u00020\n2\u0006\u0010J\u001a\u00020\u00062\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u001a\u0010K\u001a\u00020\t*\u00020\u00112\u0006\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u0019\u001a\n\u0010N\u001a\u00020\t*\u00020\u0011\u001a\u0018\u0010O\u001a\u00020\t*\u00020\n2\u000c\u0010P\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013¨\u0006Q", d2 = {"buildPermissionDescriptionList", "", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "resources", "Landroid/content/res/Resources;", "permissions", "", "buildPermissionNoticeList", "callZendeskDialog", "", "Landroid/app/Activity;", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "setBackgroundRoundDrawable", "Landroid/view/Window;", "showAlreadyPremiumDialog", "showChallengeDeleteOrReportDialog", "Landroidx/fragment/app/FragmentActivity;", "reportCallback", "Lkotlin/Function0;", "deleteCallback", "showCloseDogInviteDialog", "callback", "showCustomViewDialog", "layoutId", "", "okText", "showDeleteDialog", "showDeleteDogDialog", "showDialogWithYes", "title", "message", "showDialogYesCancel", "(Landroid/app/Activity;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "showDogAcceptedDialog", "dogName", "inviterName", "dogAvatar", "showErrorDialog", "stringId", "showErrorRetryOrBackDialog", "Landroidx/fragment/app/Fragment;", "error", "", "retryCallback", "backCallback", "showInputDialog", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "showLogoutDialog", "showLongTextDialog", "showMessageOkDialog", "showNecessaryPermissionMissingDialog", "goBackCallback", "onSettingsCallback", "showNoInternetRetryDialog", "showOptionalPermissionMissingDialog", "continueCallback", "showPermissionDialog", "string", "showPermissionExplanationDialog", "confirmCallback", "showProfileBlockDialog", "showProfileReportDialog", "showProgramAlertDialog", "skipCallback", "showPurchaseErrorDialog", "showRecoverablePurchaseErrorDialog", "Landroid/app/Dialog;", "showRemoveDogOwnerDialog", "showRetryBackDialog", "showRetryDialog", "description", "showSimpleCancelableDialog", "titleRes", "descriptionRes", "showSingleChoiceDialog", "showStopTrainingDialog", "quitCallback", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class f1 {
    public static void A(a a, DialogInterface dialogInterface2, int i3) {
        f1.U(a, dialogInterface2, i3);
    }

    public static final void A0(Fragment fragment, int i2, a<w> a3) {
        Object tVar;
        Object obj1;
        int obj2;
        Object obj3;
        n.f(fragment, "<this>");
        n.f(a3, "confirmCallback");
        obj1 = fragment.getContext();
        if (obj1 == null) {
        } else {
            b bVar = new b(obj1);
            tVar = new t(a3);
            bVar.w(i2).D(2131886979, tVar).y(2131886677, 0).o();
        }
    }

    public static void B(a a, DialogInterface dialogInterface2, int i3) {
        f1.s0(a, dialogInterface2, i3);
    }

    private static final void B0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$confirmCallback");
        a.invoke();
    }

    public static void C(a a, DialogInterface dialogInterface2, int i3) {
        f1.c0(a, dialogInterface2, i3);
    }

    public static final void C0(Activity activity, String string2, a<w> a3) {
        n.f(activity, "<this>");
        n.f(string2, "description");
        n.f(a3, "callback");
        b bVar = new b(activity);
        a obj2 = new a(a3);
        bVar.x(string2).t(false).D(2131887253, obj2).o();
    }

    public static void D(a a, DialogInterface dialogInterface2, int i3) {
        f1.N(a, dialogInterface2, i3);
    }

    private static final void D0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }

    public static void E(Activity activity, a a2, DialogInterface dialogInterface3, int i4) {
        f1.l0(activity, a2, dialogInterface3, i4);
    }

    public static final void E0(e e, int i2, int i3) {
        n.f(e, "<this>");
        b bVar = new b(e);
        bVar.H(e.getResources().getString(i2)).x(e.getResources().getString(i3)).y(2131886677, 0).o();
    }

    public static void F(a a, DialogInterface dialogInterface2, int i3) {
        f1.P(a, dialogInterface2, i3);
    }

    public static final void F0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "quitCallback");
        b bVar = new b(activity);
        l lVar = new l(a2);
        bVar.w(2131887546).D(2131886591, lVar).y(2131886800, i.a).o();
    }

    public static void G(a a, DialogInterface dialogInterface2, int i3) {
        f1.k0(a, dialogInterface2, i3);
    }

    private static final void G0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$quitCallback");
        a.invoke();
    }

    public static final void H(Window window) {
        n.f(window, "<this>");
        k kVar2 = new k();
        k.b bVar = kVar2.v();
        bVar.q(0, window.getContext().getResources().getDimension(2131165385));
        k kVar = bVar.m();
        n.e(kVar, "ShapeAppearanceModel()\n        .toBuilder()\n        .setAllCorners(CornerFamily.ROUNDED, radius)\n        .build()");
        g gVar = new g(kVar);
        gVar.Z(a.e(window.getContext(), 2131100379));
        window.setBackgroundDrawable(gVar);
    }

    private static final void H0(DialogInterface dialogInterface, int i2) {
    }

    public static final void I(Activity activity) {
        n.f(activity, "<this>");
        App.Companion.r().h(activity, j3.b);
        b bVar = new b(activity);
        bVar.w(2131887175).t(true).D(2131886679, 0).o();
    }

    public static final void J(e e, a<w> a2, a<w> a3) {
        n.f(e, "<this>");
        n.f(a2, "reportCallback");
        n.f(a3, "deleteCallback");
        ai aiVar = ai.T(e.getLayoutInflater());
        n.e(aiVar, "inflate(layoutInflater)");
        b bVar = new b(e);
        c obj3 = bVar.J(aiVar.w()).o();
        n nVar = new n(a3, obj3);
        aiVar.O.setOnClickListener(nVar);
        p pVar = new p(a2, obj3);
        aiVar.P.setOnClickListener(pVar);
    }

    private static final void K(a a, c c2, View view3) {
        n.f(a, "$deleteCallback");
        a.invoke();
        c2.dismiss();
    }

    private static final void L(a a, c c2, View view3) {
        n.f(a, "$reportCallback");
        a.invoke();
        c2.dismiss();
    }

    public static final void M(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        y yVar = new y(a2);
        bVar.G(2131886785).w(2131886786).D(2131886784, yVar).y(2131886677, 0).o();
    }

    private static final void N(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        n.f(dialogInterface2, "$noName_0");
        a.invoke();
    }

    public static final void O(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "deleteCallback");
        b bVar = new b(activity);
        a0 a0Var = new a0(a2);
        bVar.w(2131886269).D(2131886681, a0Var).y(2131886744, 0).o();
    }

    private static final void P(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$deleteCallback");
        a.invoke();
    }

    public static final void Q(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        r rVar = new r(a2);
        bVar.G(2131886459).w(2131886458).D(2131886681, rVar).y(2131886677, 0).o();
    }

    private static final void R(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }

    public static final void S(Activity activity, Integer integer2, int i3, a<w> a4) {
        Object obj1;
        n.f(activity, "<this>");
        n.f(a4, "callback");
        b bVar = new b(activity);
        if (integer2 == null) {
        } else {
            bVar.G(integer2.intValue());
        }
        v obj3 = new v(a4);
        bVar.w(i3).D(2131886714, obj3).y(2131886677, 0).o();
    }

    public static void T(Activity activity, Integer integer2, int i3, a a4, int i5, Object object6) {
        int obj1;
        if (i5 &= 1 != 0) {
            obj1 = 0;
        }
        f1.S(activity, obj1, i3, a4);
    }

    private static final void U(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        n.f(dialogInterface2, "$noName_0");
        a.invoke();
    }

    public static final void V(e e, String string2, String string3, String string4) {
        n.f(e, "<this>");
        i9 i9Var = i9.T(e.getLayoutInflater());
        n.e(i9Var, "inflate(layoutInflater)");
        i9Var.V(string4);
        i9Var.W(string2);
        i9Var.X(string3);
        b obj3 = new b(e);
        obj3.J(i9Var.w()).D(2131886528, 0).o();
    }

    public static final void W(Fragment fragment, Throwable throwable2, a<w> a3, a<w> a4) {
        Object sVar;
        b bVar;
        Exception exception;
        Object obj3;
        Object obj4;
        Object obj5;
        n.f(fragment, "<this>");
        n.f(throwable2, "error");
        n.f(a3, "retryCallback");
        n.f(a4, "backCallback");
        a.d(throwable2);
        sVar = fragment.getContext();
        if (sVar == null) {
        } else {
            bVar = new b(sVar);
            exception = new Exception(throwable2);
            obj3 = fragment.requireContext();
            n.e(obj3, "requireContext()");
            sVar = new s(a3);
            obj5 = new h(a4);
            bVar.x(n.a.i(exception, obj3)).D(2131887253, sVar).y(2131886199, obj5).o().setCanceledOnTouchOutside(false);
        }
    }

    private static final void X(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$retryCallback");
        a.invoke();
    }

    private static final void Y(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$backCallback");
        a.invoke();
    }

    public static final void Z(Activity activity, String string2, l<? super String, w> l3) {
        n.f(activity, "<this>");
        n.f(string2, "message");
        n.f(l3, "callback");
        b bVar = new b(activity);
        m obj2 = new m(l3);
        bVar.x(string2).D(2131886979, obj2).y(2131886677, 0).I(2131558604).o();
    }

    private static final List<PermissionDescription> a(Resources resources, List<String> list2) {
        PermissionDescription permissionDescription;
        String string;
        String string2;
        String str;
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            if (n.b((String)next2, "android.permission.RECORD_AUDIO")) {
            } else {
            }
            if (n.b(next2, "android.permission.CAMERA")) {
            } else {
            }
            permissionDescription = 0;
            if (permissionDescription != null) {
            }
            arrayList.add(permissionDescription);
            string = resources.getString(2131887034);
            n.e(string, "resources.getString(R.string.permissions_camera_header)");
            string2 = resources.getString(2131887036);
            n.e(string2, "resources.getString(R.string.permissions_camera_subheader)");
            permissionDescription = new PermissionDescription(string, string2);
            string = resources.getString(2131887037);
            n.e(string, "resources.getString(R.string.permissions_mic_header)");
            string2 = resources.getString(2131887038);
            n.e(string2, "resources.getString(R.string.permissions_mic_subheader)");
            permissionDescription = new PermissionDescription(string, string2);
        }
        return arrayList;
    }

    private static final void a0(l l, DialogInterface dialogInterface2, int i3) {
        int i;
        int obj2;
        Object obj3;
        n.f(l, "$callback");
        n.f(dialogInterface2, "dialog");
        if (dialogInterface2 instanceof c) {
        } else {
            obj2 = 0;
        }
        obj3 = "";
        if (obj2 == null) {
        } else {
            obj2 = obj2.findViewById(2131362671);
            if ((EditText)obj2 == null) {
            } else {
                obj2 = (EditText)obj2.getText();
                if (obj2 == null) {
                } else {
                    obj3 = obj2;
                }
            }
        }
        l.invoke(obj3.toString());
    }

    private static final List<PermissionDescription> b(Resources resources, List<String> list2) {
        PermissionDescription permissionDescription;
        String string2;
        String string;
        String str;
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            if (n.b((String)obj6.next(), "android.permission.CAMERA")) {
            } else {
            }
            permissionDescription = 0;
            if (permissionDescription != null) {
            }
            arrayList.add(permissionDescription);
            string2 = resources.getString(2131887034);
            n.e(string2, "resources.getString(R.string.permissions_camera_header)");
            string = resources.getString(2131887033);
            n.e(string, "resources.getString(R.string.permissions_camera_declined)");
            permissionDescription = new PermissionDescription(string2, string);
        }
        return arrayList;
    }

    public static final void b0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        x xVar = new x(a2);
        bVar.w(2131887308).D(2131886714, xVar).y(2131886677, 0).o();
    }

    public static final void c(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo2, "zendeskInfo");
        b bVar = new b(activity);
        k kVar = new k(activity, zendeskConfigurationInfo2);
        b bVar4 = new b(activity, zendeskConfigurationInfo2);
        bVar.x(activity.getResources().getString(2131886770)).E(activity.getResources().getString(2131886771), kVar).y(2131886772, bVar4).o();
    }

    private static final void c0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }

    private static final void d(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        n.f(activity, "$this_callZendeskDialog");
        n.f(zendeskConfigurationInfo2, "$zendeskInfo");
        g1.n0(activity, zendeskConfigurationInfo2);
    }

    public static final void d0(Activity activity, int i2) {
        n.f(activity, "<this>");
        b bVar = new b(activity);
        bVar.w(i2).D(2131886979, 0).o();
    }

    private static final void e(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        n.f(activity, "$this_callZendeskDialog");
        n.f(zendeskConfigurationInfo2, "$zendeskInfo");
        g1.p0(activity, zendeskConfigurationInfo2);
    }

    public static final void e0(Activity activity, List<String> list2, a<w> a3, a<w> a4) {
        Object cVar;
        int i;
        app.dogo.com.dogo_android.util.h0.g gVar;
        String str;
        Object obj4;
        boolean obj5;
        Object obj6;
        n.f(activity, "<this>");
        n.f(list2, "permissions");
        n.f(a3, "goBackCallback");
        n.f(a4, "onSettingsCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        cVar = f1.a(resources, list2);
        gVar = 0;
        if (empty ^= 1 != 0) {
            android.view.LayoutInflater layoutInflater = activity.getLayoutInflater();
            n.e(layoutInflater, "layoutInflater");
            u uVar = u.T(layoutInflater, 0, gVar);
            n.e(uVar, "inflate(inflater, null, false)");
            uVar.V(cVar);
            b bVar = new b(activity);
            gVar = new g(a3);
            obj6 = bVar.t(gVar).J(uVar.w()).G(2131887040).D(2131886199, gVar);
            n.e(obj6, "MaterialAlertDialogBuilder(this)\n            .setCancelable(false)\n            .setView(binding.root)\n            .setTitle(R.string.permissions_needed_title)\n            .setPositiveButton(R.string.back_general) { _, _ ->\n                goBackCallback()\n            }");
            if (g1.a(activity, list2)) {
                cVar = new c(activity, a4);
                obj6.y(2131887321, cVar);
            }
            obj6.o();
        } else {
            a.c("No permissions passed", new Object[gVar]);
            a3.invoke();
        }
    }

    public static void f(a a, DialogInterface dialogInterface2, int i3) {
        f1.D0(a, dialogInterface2, i3);
    }

    private static final void f0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$goBackCallback");
        a.invoke();
    }

    public static void g(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        f1.e(activity, zendeskConfigurationInfo2, dialogInterface3, i4);
    }

    private static final void g0(Activity activity, a a2, DialogInterface dialogInterface3, int i4) {
        n.f(activity, "$this_showNecessaryPermissionMissingDialog");
        n.f(a2, "$onSettingsCallback");
        g1.N(activity);
        a2.invoke();
    }

    public static void h(Activity activity, a a2, DialogInterface dialogInterface3, int i4) {
        f1.g0(activity, a2, dialogInterface3, i4);
    }

    public static final void h0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        q qVar = new q(a2);
        bVar.w(2131886953).t(false).D(2131887253, qVar).o();
    }

    public static void i(a a, DialogInterface dialogInterface2, int i3) {
        f1.q0(a, dialogInterface2, i3);
    }

    private static final void i0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }

    public static void j(a a, DialogInterface dialogInterface2, int i3) {
        f1.n0(a, dialogInterface2, i3);
    }

    public static final void j0(Activity activity, List<String> list2, a<w> a3, a<w> a4) {
        Object zVar;
        int i;
        app.dogo.com.dogo_android.util.h0.b0 b0Var;
        String str;
        Object obj4;
        boolean obj5;
        Object obj6;
        n.f(activity, "<this>");
        n.f(list2, "permissions");
        n.f(a3, "continueCallback");
        n.f(a4, "onSettingsCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        zVar = f1.b(resources, list2);
        b0Var = 0;
        if (empty ^= 1 != 0) {
            u uVar = u.T(activity.getLayoutInflater(), 0, b0Var);
            n.e(uVar, "inflate(layoutInflater, null, false)");
            uVar.V(zVar);
            b bVar = new b(activity);
            b0Var = new b0(a3);
            obj6 = bVar.t(b0Var).J(uVar.w()).G(2131887040).D(2131886679, b0Var);
            n.e(obj6, "MaterialAlertDialogBuilder(this)\n            .setCancelable(false)\n            .setView(binding.root)\n            .setTitle(R.string.permissions_needed_title)\n            .setPositiveButton(R.string.general_continue) { _, _ ->\n                continueCallback()\n            }");
            if (g1.a(activity, list2)) {
                zVar = new z(activity, a4);
                obj6.y(2131887321, zVar);
            }
            obj6.o();
        } else {
            a.c("No permissions passed", new Object[b0Var]);
            a3.invoke();
        }
    }

    public static void k(a a, DialogInterface dialogInterface2, int i3) {
        f1.u0(a, dialogInterface2, i3);
    }

    private static final void k0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$continueCallback");
        a.invoke();
    }

    public static void l(a a, DialogInterface dialogInterface2, int i3) {
        f1.f0(a, dialogInterface2, i3);
    }

    private static final void l0(Activity activity, a a2, DialogInterface dialogInterface3, int i4) {
        n.f(activity, "$this_showOptionalPermissionMissingDialog");
        n.f(a2, "$onSettingsCallback");
        g1.N(activity);
        a2.invoke();
    }

    public static void m(a a, DialogInterface dialogInterface2, int i3) {
        f1.Y(a, dialogInterface2, i3);
    }

    public static final void m0(Fragment fragment, String string2, a<w> a3, a<w> a4) {
        Object eVar;
        Object obj1;
        Object obj2;
        Object obj3;
        n.f(fragment, "<this>");
        n.f(string2, "string");
        n.f(a3, "retryCallback");
        n.f(a4, "backCallback");
        obj1 = fragment.getContext();
        if (obj1 == null) {
        } else {
            b bVar = new b(obj1);
            eVar = new e(a3);
            obj3 = new j(a4);
            bVar.x(string2).D(2131887253, eVar).y(2131886199, obj3).o().setCanceledOnTouchOutside(false);
        }
    }

    public static void n(DialogInterface dialogInterface, int i2) {
        f1.H0(dialogInterface, i2);
    }

    private static final void n0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$retryCallback");
        a.invoke();
    }

    public static void o(a a, DialogInterface dialogInterface2, int i3) {
        f1.o0(a, dialogInterface2, i3);
    }

    private static final void o0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$backCallback");
        a.invoke();
    }

    public static void p(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        f1.d(activity, zendeskConfigurationInfo2, dialogInterface3, i4);
    }

    public static final void p0(Activity activity, List<String> list2, a<w> a3) {
        app.dogo.com.dogo_android.util.h0.d dVar;
        String str;
        b obj3;
        int obj4;
        n.f(activity, "<this>");
        n.f(list2, "permissions");
        n.f(a3, "confirmCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        obj4 = f1.a(resources, list2);
        int i = 0;
        if (empty ^= 1 != 0) {
            s sVar = s.T(activity.getLayoutInflater(), 0, i);
            n.e(sVar, "inflate(layoutInflater, null, false)");
            sVar.V(obj4);
            obj4 = new b(activity);
            dVar = new d(a3);
            obj4.t(i).G(2131887040).J(sVar.w()).D(2131886679, dVar).o();
        } else {
            a.c("No permissions passed", new Object[i]);
            a3.invoke();
        }
    }

    public static void q(a a, DialogInterface dialogInterface2, int i3) {
        f1.G0(a, dialogInterface2, i3);
    }

    private static final void q0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$confirmCallback");
        a.invoke();
    }

    public static void r(l l, DialogInterface dialogInterface2, int i3) {
        f1.a0(l, dialogInterface2, i3);
    }

    public static final void r0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        bVar.G(2131886676);
        w wVar = new w(a2);
        bVar.w(2131886329).D(2131886714, wVar).y(2131886677, 0).o();
    }

    public static void s(a a, c c2, View view3) {
        f1.K(a, c2, view3);
    }

    private static final void s0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        n.f(dialogInterface2, "$noName_0");
        a.invoke();
    }

    public static void t(a a, DialogInterface dialogInterface2, int i3) {
        f1.w0(a, dialogInterface2, i3);
    }

    public static final void t0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        String string = activity.getString(2131886313);
        n.e(string, "getString(R.string.challenge_report_mesage)");
        String string3 = activity.getString(2131886314);
        n.e(string3, "getString(R.string.challenge_report_text)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" \n\n");
        stringBuilder.append(string3);
        b bVar = new b(activity);
        bVar.G(2131886699);
        f fVar = new f(a2);
        bVar.x(stringBuilder.toString()).D(2131886714, fVar).y(2131886677, 0).o();
    }

    public static void u(a a, c c2, View view3) {
        f1.L(a, c2, view3);
    }

    private static final void u0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        n.f(dialogInterface2, "$noName_0");
        a.invoke();
    }

    public static void v(a a, DialogInterface dialogInterface2, int i3) {
        f1.i0(a, dialogInterface2, i3);
    }

    public static final void v0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        o oVar = new o(a2);
        bVar.w(2131887239).D(2131887306, oVar).y(2131886678, 0).o();
    }

    public static void w(a a, DialogInterface dialogInterface2, int i3) {
        f1.R(a, dialogInterface2, i3);
    }

    private static final void w0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }

    public static void x(a a, DialogInterface dialogInterface2, int i3) {
        f1.X(a, dialogInterface2, i3);
    }

    public static final Dialog x0(Activity activity) {
        n.f(activity, "<this>");
        b bVar = new b(activity);
        c obj2 = bVar.w(2131887241).A(2131886678, 0).o();
        n.e(obj2, "MaterialAlertDialogBuilder(this)\n        .setMessage(R.string.restoring_purchase_spinner)\n        .setNeutralButton(R.string.general_close, null)\n        .show()");
        return obj2;
    }

    public static void y(a a, DialogInterface dialogInterface2, int i3) {
        f1.B0(a, dialogInterface2, i3);
    }

    public static final void y0(Activity activity, a<w> a2) {
        n.f(activity, "<this>");
        n.f(a2, "callback");
        b bVar = new b(activity);
        u uVar = new u(a2);
        bVar.G(2131886478).w(2131886483).D(2131886697, uVar).y(2131886744, 0).o();
    }

    public static void z(a a, DialogInterface dialogInterface2, int i3) {
        f1.z0(a, dialogInterface2, i3);
    }

    private static final void z0(a a, DialogInterface dialogInterface2, int i3) {
        n.f(a, "$callback");
        a.invoke();
    }
}
