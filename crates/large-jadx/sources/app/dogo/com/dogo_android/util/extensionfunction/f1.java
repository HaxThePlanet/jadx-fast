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
import kotlin.d0.c.l;
import kotlin.w;

/* compiled from: ActivityDialogExtensions.kt */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a$\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a$\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a\u0012\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c\u001a\n\u0010\r\u001a\u00020\t*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\t*\u00020\n\u001a&\u0010\u0010\u001a\u00020\t*\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010\u0015\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a0\u0010\u0017\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u0016\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013\u001a\u001a\u0010\u001b\u001a\u00020\t*\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0013\u001a\u0018\u0010\u001c\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a2\u0010\u001d\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u00192\u0012\u0008\u0002\u0010\u0016\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013\u001a3\u0010 \u001a\u00020\t*\u00020\n2\n\u0008\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u00192\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\u0010!\u001a(\u0010\"\u001a\u00020\t*\u00020\u00112\u0008\u0010#\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u00062\u0008\u0010%\u001a\u0004\u0018\u00010\u0006\u001a\u0014\u0010&\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010'\u001a\u00020\u0019\u001a.\u0010(\u001a\u00020\t*\u00020)2\u0006\u0010*\u001a\u00020+2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a5\u0010.\u001a\u00020\t*\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00062!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u00080\u0012\u0008\u00081\u0012\u0004\u0008\u0008(2\u0012\u0004\u0012\u00020\t0/\u001a\u0018\u00103\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\n\u00104\u001a\u00020\t*\u00020\n\u001a\u0014\u00105\u001a\u00020\t*\u00020\n2\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u0019\u001a4\u00106\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u00109\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a4\u0010:\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a.\u0010<\u001a\u00020\t*\u00020)2\u0006\u0010=\u001a\u00020\u00062\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a&\u0010>\u001a\u00020\t*\u00020\n2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00012\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010@\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010A\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a<\u0010B\u001a\u00020\t*\u00020\n2\u0006\u0010=\u001a\u00020\u00062\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00132\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u0018\u0010D\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\n\u0010E\u001a\u00020F*\u00020\n\u001a\u0018\u0010G\u001a\u00020\t*\u00020\n2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a \u0010H\u001a\u00020\t*\u00020)2\u0006\u0010'\u001a\u00020\u00192\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a \u0010I\u001a\u00020\t*\u00020\n2\u0006\u0010J\u001a\u00020\u00062\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013\u001a\u001a\u0010K\u001a\u00020\t*\u00020\u00112\u0006\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u0019\u001a\n\u0010N\u001a\u00020\t*\u00020\u0011\u001a\u0018\u0010O\u001a\u00020\t*\u00020\n2\u000c\u0010P\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0013¨\u0006Q", d2 = {"buildPermissionDescriptionList", "", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "resources", "Landroid/content/res/Resources;", "permissions", "", "buildPermissionNoticeList", "callZendeskDialog", "", "Landroid/app/Activity;", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "setBackgroundRoundDrawable", "Landroid/view/Window;", "showAlreadyPremiumDialog", "showChallengeDeleteOrReportDialog", "Landroidx/fragment/app/FragmentActivity;", "reportCallback", "Lkotlin/Function0;", "deleteCallback", "showCloseDogInviteDialog", "callback", "showCustomViewDialog", "layoutId", "", "okText", "showDeleteDialog", "showDeleteDogDialog", "showDialogWithYes", "title", "message", "showDialogYesCancel", "(Landroid/app/Activity;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "showDogAcceptedDialog", "dogName", "inviterName", "dogAvatar", "showErrorDialog", "stringId", "showErrorRetryOrBackDialog", "Landroidx/fragment/app/Fragment;", "error", "", "retryCallback", "backCallback", "showInputDialog", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "showLogoutDialog", "showLongTextDialog", "showMessageOkDialog", "showNecessaryPermissionMissingDialog", "goBackCallback", "onSettingsCallback", "showNoInternetRetryDialog", "showOptionalPermissionMissingDialog", "continueCallback", "showPermissionDialog", "string", "showPermissionExplanationDialog", "confirmCallback", "showProfileBlockDialog", "showProfileReportDialog", "showProgramAlertDialog", "skipCallback", "showPurchaseErrorDialog", "showRecoverablePurchaseErrorDialog", "Landroid/app/Dialog;", "showRemoveDogOwnerDialog", "showRetryBackDialog", "showRetryDialog", "description", "showSimpleCancelableDialog", "titleRes", "descriptionRes", "showSingleChoiceDialog", "showStopTrainingDialog", "quitCallback", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class f1 {
    /* renamed from: A0, reason: from kotlin metadata */
    public static final void showDialogWithYes(Fragment title, int message, kotlin.d0.c.a<w> callback) {
        n.f(title, "<this>");
        str = "confirmCallback";
        n.f(callback, str);
        Context context = title.getContext();
        if (context != null) {
            int i = 2131886677;
            android.content.DialogInterface.OnClickListener onClickListener = null;
            new b(context).w(message).D(2131886979, new app.dogo.com.dogo_android.util.extensionfunction.t(callback)).y(i, onClickListener).o();
        }
    }

    /* renamed from: B0, reason: from kotlin metadata */
    private static final void showDogAcceptedDialog(kotlin.d0.c.a dogName, DialogInterface inviterName, int dogAvatar) {
        n.f(dogName, "$confirmCallback");
        dogName.invoke();
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public static final void showNecessaryPermissionMissingDialog(Activity permissions, String goBackCallback, kotlin.d0.c.a<w> onSettingsCallback) {
        n.f(permissions, "<this>");
        n.f(goBackCallback, "description");
        n.f(onSettingsCallback, "callback");
        new b(permissions).x(goBackCallback).t(false).D(2131887253, new app.dogo.com.dogo_android.util.extensionfunction.a(onSettingsCallback)).o();
    }

    /* renamed from: D0, reason: from kotlin metadata */
    private static final void showPermissionDialog(kotlin.d0.c.a string, DialogInterface retryCallback, int backCallback) {
        n.f(string, "$callback");
        string.invoke();
    }

    public static final void E0(e eVar, int i, int i2) throws android.content.res.Resources.NotFoundException {
        n.f(eVar, "<this>");
        new b(eVar).H(eVar.getResources().getString(i)).x(eVar.getResources().getString(i2)).y(2131886677, null).o();
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public static final void buildPermissionDescriptionList(Activity resources, kotlin.d0.c.a<w> permissions) {
        n.f(resources, "<this>");
        n.f(permissions, "quitCallback");
        new b(resources).w(2131887546).D(2131886591, new app.dogo.com.dogo_android.util.extensionfunction.l(permissions)).y(2131886800, app.dogo.com.dogo_android.util.extensionfunction.i.a).o();
    }

    private static final void G0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$quitCallback");
        aVar.invoke();
    }

    /* renamed from: H, reason: from kotlin metadata */
    public static final void callZendeskDialog(Window zendeskInfo) throws android.content.res.Resources.NotFoundException {
        n.f(zendeskInfo, "<this>");
        k.b bVar = new k().v();
        bVar.q(0, zendeskInfo.getContext().getResources().getDimension(2131165385));
        k kVar = bVar.m();
        n.e(kVar, "ShapeAppearanceModel()\n        .toBuilder()\n        .setAllCorners(CornerFamily.ROUNDED, radius)\n        .build()");
        g gVar = new g(kVar);
        gVar.Z(a.e(zendeskInfo.getContext(), 2131100379));
        zendeskInfo.setBackgroundDrawable(gVar);
    }

    /* renamed from: I, reason: from kotlin metadata */
    public static final void showCloseDogInviteDialog(Activity callback) {
        n.f(callback, "<this>");
        App.INSTANCE.r().h(callback, S.firstExamUnlockedScreen);
        new b(callback).w(2131887175).t(true).D(2131886679, null).o();
    }

    public static final void J(e eVar, kotlin.d0.c.a<w> aVar, kotlin.d0.c.a<w> aVar2) {
        n.f(eVar, "<this>");
        n.f(aVar, "reportCallback");
        n.f(aVar2, "deleteCallback");
        ai aiVar = ai.T(eVar.getLayoutInflater());
        n.e(aiVar, "inflate(layoutInflater)");
        c cVar = new b(eVar).J(aiVar.w()).o();
        aiVar.O.setOnClickListener(new app.dogo.com.dogo_android.util.extensionfunction.n(aVar2, cVar));
        aiVar.P.setOnClickListener(new app.dogo.com.dogo_android.util.extensionfunction.p(aVar, cVar));
    }

    private static final void K(kotlin.d0.c.a aVar, c cVar, View view) {
        n.f(aVar, "$deleteCallback");
        aVar.invoke();
        cVar.dismiss();
    }

    private static final void L(kotlin.d0.c.a aVar, c cVar, View view) {
        n.f(aVar, "$reportCallback");
        aVar.invoke();
        cVar.dismiss();
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static final void showChallengeDeleteOrReportDialog(Activity reportCallback, kotlin.d0.c.a<w> deleteCallback) {
        n.f(reportCallback, "<this>");
        n.f(deleteCallback, "callback");
        new b(reportCallback).G(2131886785).w(2131886786).D(2131886784, new app.dogo.com.dogo_android.util.extensionfunction.y(deleteCallback)).y(2131886677, null).o();
    }

    private static final void N(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        n.f(dialogInterface, "$noName_0");
        aVar.invoke();
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static final void showInputDialog(Activity message, kotlin.d0.c.a<w> callback) {
        n.f(message, "<this>");
        n.f(callback, "deleteCallback");
        new b(message).w(2131886269).D(2131886681, new app.dogo.com.dogo_android.util.extensionfunction.a0(callback)).y(2131886744, null).o();
    }

    private static final void P(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$deleteCallback");
        aVar.invoke();
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static final void showPermissionExplanationDialog(Activity permissions, kotlin.d0.c.a<w> confirmCallback) {
        n.f(permissions, "<this>");
        n.f(confirmCallback, "callback");
        new b(permissions).G(2131886459).w(2131886458).D(2131886681, new app.dogo.com.dogo_android.util.extensionfunction.r(confirmCallback)).y(2131886677, null).o();
    }

    private static final void R(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        aVar.invoke();
    }

    public static final void S(Activity activity, Integer integer, int i, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        b bVar = new b(activity);
        if (integer != null) {
            bVar.G(integer.intValue());
        }
        bVar.w(i).D(2131886714, new app.dogo.com.dogo_android.util.extensionfunction.v(aVar)).y(2131886677, null).o();
    }

    public static /* synthetic */ void T(Activity activity, Integer integer, int i, kotlin.d0.c.a aVar, int i2, Object object) {
        Integer num = null;
        if (i2 & 1 != 0) {
            i = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.f1.S(activity, num, i, aVar);
    }

    private static final void U(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        n.f(dialogInterface, "$noName_0");
        aVar.invoke();
    }

    public static final void V(e eVar, String str, String str2, String str3) {
        n.f(eVar, "<this>");
        i9 i9Var = i9.T(eVar.getLayoutInflater());
        n.e(i9Var, "inflate(layoutInflater)");
        i9Var.V(str3);
        i9Var.W(str);
        i9Var.X(str2);
        new b(eVar).J(i9Var.w()).D(2131886528, null).o();
    }

    public static final void W(Fragment fragment, Throwable th, kotlin.d0.c.a<w> aVar, kotlin.d0.c.a<w> aVar2) {
        n.f(fragment, "<this>");
        n.f(th, "error");
        n.f(aVar, "retryCallback");
        n.f(aVar2, "backCallback");
        a.d(th);
        Context context = fragment.getContext();
        if (context != null) {
            Context requireContext = fragment.requireContext();
            n.e(requireContext, "requireContext()");
            boolean z = false;
            new b(context).x(BindingAdapters.a.i(new Exception(th), requireContext)).D(2131887253, new app.dogo.com.dogo_android.util.extensionfunction.s(aVar)).y(2131886199, new app.dogo.com.dogo_android.util.extensionfunction.h(aVar2)).o().setCanceledOnTouchOutside(z);
        }
    }

    private static final void X(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$retryCallback");
        aVar.invoke();
    }

    private static final void Y(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$backCallback");
        aVar.invoke();
    }

    public static final void Z(Activity activity, String str, l<? super String, w> lVar) {
        n.f(activity, "<this>");
        n.f(str, "message");
        n.f(lVar, "callback");
        new b(activity).x(str).D(2131886979, new app.dogo.com.dogo_android.util.extensionfunction.m(lVar)).y(2131886677, null).I(2131558604).o();
    }

    /* renamed from: a, reason: from kotlin metadata */
    private static final List<PermissionDescription> showRetryBackDialog(Resources stringId, List<String> confirmCallback) throws android.content.res.Resources.NotFoundException {
        Object obj = null;
        String string;
        String string2;
        String str;
        final ArrayList arrayList = new ArrayList();
        final Iterator it = confirmCallback.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    private static final void a0(l lVar, DialogInterface dialogInterface, int i) {
        int i2 = 0;
        android.text.Editable dialogInterface22;
        n.f(lVar, "$callback");
        n.f(dialogInterface, "dialog");
        dialogInterface = dialogInterface instanceof c ? (c)dialogInterface : 0;
        String str3 = "";
        if (i2 != 0) {
            i = 2131362671;
            View viewById = i2.findViewById(i);
            if (viewById != null) {
                dialogInterface22 = viewById.getText();
                if (dialogInterface22 != null) {
                }
            }
        }
        lVar.invoke(dialogInterface22.toString());
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final List<PermissionDescription> showRetryDialog(Resources description, List<String> callback) throws android.content.res.Resources.NotFoundException {
        Object obj = null;
        String string;
        String string2;
        String str;
        final ArrayList arrayList = new ArrayList();
        final Iterator it = callback.iterator();
        while (it.hasNext()) {
            string = "android.permission.CAMERA";
        }
        return arrayList;
    }

    /* renamed from: b0, reason: from kotlin metadata */
    public static final void showSimpleCancelableDialog(Activity titleRes, kotlin.d0.c.a<w> descriptionRes) {
        n.f(titleRes, "<this>");
        n.f(descriptionRes, "callback");
        new b(titleRes).w(2131887308).D(2131886714, new app.dogo.com.dogo_android.util.extensionfunction.x(descriptionRes)).y(2131886677, null).o();
    }

    public static final void c(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) throws android.content.res.Resources.NotFoundException {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        new b(activity).x(activity.getResources().getString(2131886770)).E(activity.getResources().getString(2131886771), new app.dogo.com.dogo_android.util.extensionfunction.k(activity, zendeskConfigurationInfo)).y(2131886772, new app.dogo.com.dogo_android.util.extensionfunction.b(activity, zendeskConfigurationInfo)).o();
    }

    private static final void c0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        aVar.invoke();
    }

    private static final void d(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        n.f(activity, "$this_callZendeskDialog");
        n.f(zendeskConfigurationInfo, "$zendeskInfo");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n0(activity, zendeskConfigurationInfo);
    }

    public static final void d0(Activity activity, int i) {
        n.f(activity, "<this>");
        new b(activity).w(i).D(2131886979, null).o();
    }

    private static final void e(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        n.f(activity, "$this_callZendeskDialog");
        n.f(zendeskConfigurationInfo, "$zendeskInfo");
        app.dogo.com.dogo_android.util.extensionfunction.g1.p0(activity, zendeskConfigurationInfo);
    }

    public static final void e0(Activity activity, List<String> list, kotlin.d0.c.a<w> aVar, kotlin.d0.c.a<w> aVar2) {
        String str;
        boolean z;
        n.f(activity, "<this>");
        n.f(list, "permissions");
        n.f(aVar, "goBackCallback");
        n.f(aVar2, "onSettingsCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        List showRetryBackDialog = app.dogo.com.dogo_android.util.extensionfunction.f1.showRetryBackDialog(resources, list);
        i = !showRetryBackDialog.isEmpty();
        boolean z2 = false;
        if (!showRetryBackDialog.isEmpty()) {
            android.view.LayoutInflater layoutInflater = activity.getLayoutInflater();
            n.e(layoutInflater, "layoutInflater");
            u uVar = u.T(layoutInflater, null, z2);
            str2 = "inflate(inflater, null, false)";
            n.e(uVar, str2);
            uVar.V(showRetryBackDialog);
            int i = 2131886199;
            b bVar = new b(activity).t(z2).J(uVar.w()).G(2131887040).D(i, new app.dogo.com.dogo_android.util.extensionfunction.g(aVar));
            str = "MaterialAlertDialogBuilder(this)\n            .setCancelable(false)\n            .setView(binding.root)\n            .setTitle(R.string.permissions_needed_title)\n            .setPositiveButton(R.string.back_general) { _, _ ->\n                goBackCallback()\n            }";
            n.e(bVar, str);
            if (app.dogo.com.dogo_android.util.extensionfunction.g1.a(activity, list)) {
                bVar.y(2131887321, new app.dogo.com.dogo_android.util.extensionfunction.c(activity, aVar2));
            }
            bVar.o();
        } else {
            a.c("No permissions passed", new Object[z2]);
            aVar.invoke();
        }
    }

    private static final void f0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$goBackCallback");
        aVar.invoke();
    }

    private static final void g0(Activity activity, kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(activity, "$this_showNecessaryPermissionMissingDialog");
        n.f(aVar, "$onSettingsCallback");
        app.dogo.com.dogo_android.util.extensionfunction.g1.N(activity);
        aVar.invoke();
    }

    public static final void h0(Activity activity, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        new b(activity).w(2131886953).t(false).D(2131887253, new app.dogo.com.dogo_android.util.extensionfunction.q(aVar)).o();
    }

    private static final void i0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        aVar.invoke();
    }

    public static final void j0(Activity activity, List<String> list, kotlin.d0.c.a<w> aVar, kotlin.d0.c.a<w> aVar2) {
        String str;
        boolean z;
        n.f(activity, "<this>");
        n.f(list, "permissions");
        n.f(aVar, "continueCallback");
        n.f(aVar2, "onSettingsCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        List showRetryDialog = app.dogo.com.dogo_android.util.extensionfunction.f1.showRetryDialog(resources, list);
        i = !showRetryDialog.isEmpty();
        boolean z2 = false;
        if (!showRetryDialog.isEmpty()) {
            u uVar = u.T(activity.getLayoutInflater(), null, z2);
            str2 = "inflate(layoutInflater, null, false)";
            n.e(uVar, str2);
            uVar.V(showRetryDialog);
            int i = 2131886679;
            b bVar = new b(activity).t(z2).J(uVar.w()).G(2131887040).D(i, new app.dogo.com.dogo_android.util.extensionfunction.b0(aVar));
            str = "MaterialAlertDialogBuilder(this)\n            .setCancelable(false)\n            .setView(binding.root)\n            .setTitle(R.string.permissions_needed_title)\n            .setPositiveButton(R.string.general_continue) { _, _ ->\n                continueCallback()\n            }";
            n.e(bVar, str);
            if (app.dogo.com.dogo_android.util.extensionfunction.g1.a(activity, list)) {
                bVar.y(2131887321, new app.dogo.com.dogo_android.util.extensionfunction.z(activity, aVar2));
            }
            bVar.o();
        } else {
            a.c("No permissions passed", new Object[z2]);
            aVar.invoke();
        }
    }

    private static final void k0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$continueCallback");
        aVar.invoke();
    }

    private static final void l0(Activity activity, kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(activity, "$this_showOptionalPermissionMissingDialog");
        n.f(aVar, "$onSettingsCallback");
        app.dogo.com.dogo_android.util.extensionfunction.g1.N(activity);
        aVar.invoke();
    }

    public static final void m0(Fragment fragment, String str, kotlin.d0.c.a<w> aVar, kotlin.d0.c.a<w> aVar2) {
        n.f(fragment, "<this>");
        n.f(str, "string");
        n.f(aVar, "retryCallback");
        str = "backCallback";
        n.f(aVar2, str);
        Context context = fragment.getContext();
        if (context != null) {
            boolean z = false;
            new b(context).x(str).D(2131887253, new app.dogo.com.dogo_android.util.extensionfunction.e(aVar)).y(2131886199, new app.dogo.com.dogo_android.util.extensionfunction.j(aVar2)).o().setCanceledOnTouchOutside(z);
        }
    }

    private static final void n0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$retryCallback");
        aVar.invoke();
    }

    private static final void o0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$backCallback");
        aVar.invoke();
    }

    public static final void p0(Activity activity, List<String> list, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(list, "permissions");
        n.f(aVar, "confirmCallback");
        Resources resources = activity.getResources();
        n.e(resources, "this.resources");
        List showRetryBackDialog = app.dogo.com.dogo_android.util.extensionfunction.f1.showRetryBackDialog(resources, list);
        boolean z = false;
        if (!showRetryBackDialog.isEmpty()) {
            s sVar = s.T(activity.getLayoutInflater(), null, z);
            str = "inflate(layoutInflater, null, false)";
            n.e(sVar, str);
            sVar.V(showRetryBackDialog);
            int i = 2131886679;
            new b(activity).t(z).G(2131887040).J(sVar.w()).D(i, new app.dogo.com.dogo_android.util.extensionfunction.d(aVar)).o();
        } else {
            a.c("No permissions passed", new Object[z]);
            aVar.invoke();
        }
    }

    private static final void q0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$confirmCallback");
        aVar.invoke();
    }

    public static final void r0(Activity activity, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        b bVar = new b(activity);
        bVar.G(2131886676);
        bVar.w(2131886329).D(2131886714, new app.dogo.com.dogo_android.util.extensionfunction.w(aVar)).y(2131886677, null).o();
    }

    private static final void s0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        n.f(dialogInterface, "$noName_0");
        aVar.invoke();
    }

    public static final void t0(Activity activity, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        String string = activity.getString(2131886313);
        n.e(string, "getString(R.string.challenge_report_mesage)");
        String string2 = activity.getString(2131886314);
        n.e(string2, "getString(R.string.challenge_report_text)");
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = " \n\n";
        str4 = string + str3 + string2;
        b bVar = new b(activity);
        bVar.G(2131886699);
        bVar.x(str4).D(2131886714, new app.dogo.com.dogo_android.util.extensionfunction.f(aVar)).y(2131886677, null).o();
    }

    private static final void u0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        n.f(dialogInterface, "$noName_0");
        aVar.invoke();
    }

    public static final void v0(Activity activity, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        new b(activity).w(2131887239).D(2131887306, new app.dogo.com.dogo_android.util.extensionfunction.o(aVar)).y(2131886678, null).o();
    }

    private static final void w0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        aVar.invoke();
    }

    /* renamed from: x0, reason: from kotlin metadata */
    public static final Dialog showDeleteDialog(Activity deleteCallback) {
        n.f(deleteCallback, "<this>");
        c cVar = new b(deleteCallback).w(2131887241).A(2131886678, null).o();
        n.e(cVar, "MaterialAlertDialogBuilder(this)\n        .setMessage(R.string.restoring_purchase_spinner)\n        .setNeutralButton(R.string.general_close, null)\n        .show()");
        return cVar;
    }

    public static final void y0(Activity activity, kotlin.d0.c.a<w> aVar) {
        n.f(activity, "<this>");
        n.f(aVar, "callback");
        new b(activity).G(2131886478).w(2131886483).D(2131886697, new app.dogo.com.dogo_android.util.extensionfunction.u(aVar)).y(2131886744, null).o();
    }

    private static final void z0(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        n.f(aVar, "$callback");
        aVar.invoke();
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ void showCustomViewDialog(kotlin.d0.c.a layoutId, DialogInterface okText, int callback) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.U(layoutId, okText, callback);
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static /* synthetic */ void showDialogYesCancel(kotlin.d0.c.a title, DialogInterface message, int callback) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.s0(title, message, callback);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static /* synthetic */ void showErrorRetryOrBackDialog(kotlin.d0.c.a error, DialogInterface retryCallback, int backCallback) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.c0(error, retryCallback, backCallback);
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static /* synthetic */ void showOptionalPermissionMissingDialog(kotlin.d0.c.a permissions, DialogInterface continueCallback, int onSettingsCallback) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.N(permissions, continueCallback, onSettingsCallback);
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static /* synthetic */ void showProgramAlertDialog(Activity string, kotlin.d0.c.a retryCallback, DialogInterface skipCallback, int backCallback) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.l0(string, retryCallback, skipCallback, backCallback);
    }

    public static /* synthetic */ void F(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.P(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void G(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.k0(aVar, dialogInterface, i);
    }

    /* renamed from: H0, reason: from kotlin metadata */
    private static final void buildPermissionNoticeList(DialogInterface resources, int permissions) {
    }

    public static /* synthetic */ void f(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.showPermissionDialog(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void g(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.e(activity, zendeskConfigurationInfo, dialogInterface, i);
    }

    public static /* synthetic */ void h(Activity activity, kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.g0(activity, aVar, dialogInterface, i);
    }

    public static /* synthetic */ void i(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.q0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void j(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.n0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void k(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.u0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void l(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.f0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void m(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.Y(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void n(DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.buildPermissionNoticeList(dialogInterface, i);
    }

    public static /* synthetic */ void o(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.o0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void p(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.d(activity, zendeskConfigurationInfo, dialogInterface, i);
    }

    public static /* synthetic */ void q(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.G0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void r(l lVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.a0(lVar, dialogInterface, i);
    }

    public static /* synthetic */ void s(kotlin.d0.c.a aVar, c cVar, View view) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.K(aVar, cVar, view);
    }

    public static /* synthetic */ void t(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.w0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void u(kotlin.d0.c.a aVar, c cVar, View view) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.L(aVar, cVar, view);
    }

    public static /* synthetic */ void v(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.i0(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void w(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.R(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void x(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.X(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void y(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.showDogAcceptedDialog(aVar, dialogInterface, i);
    }

    public static /* synthetic */ void z(kotlin.d0.c.a aVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.f1.z0(aVar, dialogInterface, i);
    }
}
