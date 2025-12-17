package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Type;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.h;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.n.k;
import androidx.fragment.app.w;
import app.dogo.com.dogo_android.d.e.c;
import app.dogo.com.dogo_android.d.e.d;
import app.dogo.com.dogo_android.exam.e;
import app.dogo.com.dogo_android.exam.g;
import app.dogo.com.dogo_android.inappmessaging.j;
import app.dogo.com.dogo_android.inappmessaging.m;
import app.dogo.com.dogo_android.login_v2.t;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.t.i0.b;
import app.dogo.com.dogo_android.u.n.q.n;
import app.dogo.com.dogo_android.u.n.q.n.a;
import app.dogo.com.dogo_android.u.n.q.o;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.view.l;
import app.dogo.com.dogo_android.view.main_screen.h;
import app.dogo.com.dogo_android.w.a1;
import app.dogo.com.dogo_android.w.b0;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.z0;
import app.dogo.com.dogo_android.y.j;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.r.a;
import com.google.android.material.datepicker.j;
import com.google.android.material.datepicker.j.e;
import com.google.android.material.timepicker.b;
import com.google.android.material.timepicker.b.d;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.Button;
import com.google.firebase.inappmessaging.model.CampaignMetadata;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.Text;
import f.c.a.e.s.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.g;
import kotlin.k0.d;
import kotlin.k0.l;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import n.a.a;
import o.a.a;
import zendesk.answerbot.AnswerBotEngine;
import zendesk.messaging.MessagingActivity;
import zendesk.messaging.MessagingConfiguration.Builder;
import zendesk.support.CustomField;
import zendesk.support.SupportEngine;
import zendesk.support.guide.ArticleConfiguration.Builder;
import zendesk.support.guide.ViewArticleActivity;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestConfiguration.Builder;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListConfiguration.Builder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000²\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a \u0010\u0014\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b\u001a&\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b\u001a\n\u0010\u0018\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0019\u001a\u00020\t*\u00020\u0011\u001a\u001e\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e\u001a\u0019\u0010\u001b\u001a\u0002H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u001d*\u00020\u000c¢\u0006\u0002\u0010\u001e\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u000c\u001a \u0010!\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\t2\u0008\u0008\u0002\u0010#\u001a\u00020 \u001a\u001c\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(\u001a\u001c\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020)\u001a\u0014\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0014\u0010*\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010+\u001a\u00020\u0010*\u00020\u0011\u001a\u0012\u0010,\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001a\u0010-\u001a\u00020\u0010*\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201\u001a(\u00102\u001a\u00020\u0010*\u00020\u000c2\u0008\u0008\u0002\u00103\u001a\u00020 2\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a(\u00102\u001a\u00020\u0010*\u00020&2\u0008\u0008\u0002\u00103\u001a\u00020 2\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\n\u00104\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00105\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00106\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00107\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00108\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00109\u001a\u00020\u0010*\u00020\u0011\u001a8\u0010:\u001a\u00020\u0010*\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020 2\u0008\u0008\u0002\u0010=\u001a\u00020 2\u0008\u0008\u0002\u0010>\u001a\u00020 H\u0002\u001a\u0014\u0010?\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0016\u0010@\u001a\u00020\u000b*\u00020\u00112\u0008\u0010A\u001a\u0004\u0018\u00010\tH\u0002\u001a=\u0010B\u001a\u00020\u0010*\u00020\u00112\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(D\u0012\u0004\u0012\u00020\u00100F\u001a<\u0010H\u001a\u00020\u0010*\u00020\u00112\u0008\u0010I\u001a\u0004\u0018\u00010J2!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(L\u0012\u0004\u0012\u00020\u00100F¢\u0006\u0002\u0010M\u001a\u0014\u0010N\u001a\u0004\u0018\u00010O*\u00020\u00112\u0006\u0010P\u001a\u00020Q\u001a5\u0010R\u001a\u00020\u0010*\u00020\u00112\u0006\u0010C\u001a\u00020\t2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(C\u0012\u0004\u0012\u00020\u00100F\u001a;\u0010S\u001a\u00020\u0010*\u00020\u00112\u000c\u0010T\u001a\u0008\u0012\u0004\u0012\u00020J0\u000e2!\u0010U\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(V\u0012\u0004\u0012\u00020\u00100F\u001a\u0012\u0010W\u001a\u00020\u0010*\u00020\u00112\u0006\u0010X\u001a\u00020\t\u001a\u0012\u0010Y\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0006\u0010[\u001a\u00020\\\u001a\u0014\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0008\u0008\u0001\u0010]\u001a\u00020 \u001a\u0012\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0006\u0010^\u001a\u00020\t\u001a\u0012\u0010_\u001a\u00020\u0010*\u00020\u00112\u0006\u0010`\u001a\u00020\t\u001a\u0012\u0010a\u001a\u00020\u0010*\u00020\u00112\u0006\u0010`\u001a\u00020\t\u001aR\u0010b\u001a\u00020\u0010*\u00020\u00112\u0006\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020 26\u0010K\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(f\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(g\u0012\u0004\u0012\u00020\u00100e\u001a\u0012\u0010h\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010i\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010j\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010k\u001a\u00020\u0010*\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020 H\u0002\u001a\u0016\u0010l\u001a\u00020\u0010*\u00020\u00112\u0008\u0010m\u001a\u0004\u0018\u00010\tH\u0002\u001a\u001a\u0010n\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r\u001a\u0014\u0010s\u001a\u00020\u0010*\u00020\u000c2\u0008\u0008\u0002\u0010t\u001a\u00020\u000b¨\u0006u", d2 = {"getActivityConfig", "Lzendesk/configurations/Configuration;", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getLoginIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "viewSource", "", "anyPermissionsIgnored", "", "Landroid/app/Activity;", "requiredPermissions", "", "clearBackstackAndGoToFragment", "", "Landroidx/fragment/app/FragmentActivity;", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "clearBackstackToTag", "returnTag", "inclusive", "clearBackstackToTagAndGoToFragment", "directToPlayStore", "getCurrentBackstackTag", "getMissingPermissions", "getScreenKey", "T", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "(Landroid/app/Activity;)Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "getScreenWidth", "", "goBackToTag", "tag", "flag", "goToFragment", "fragment", "Landroidx/fragment/app/Fragment;", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lapp/dogo/com/dogo_android/tracking/Screen;", "goToFragmentSmooth", "goToMobileInbox", "goToZendeskScreenAndLog", "handleCustomInAppDisplay", "inAppMessage", "Lcom/google/firebase/inappmessaging/model/InAppMessage;", "callbacks", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplayCallbacks;", "launchLogInActivity", "requestCode", "openDogoFacebook", "openDogoInstagram", "openDogoTikTok", "openDogoYoutube", "openPermissionSettings", "processBackPress", "replace", "name", "id", "enterAnimation", "exitAnimation", "replaceScreenWithStateLoss", "shouldLoadImage", "imageUrl", "showCommentReportDialog", "entryId", "commentId", "onReportCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "showDatePicker", "initialTimeMs", "", "positiveCallback", "selectedTimeMs", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "showDialogFragment", "Landroidx/fragment/app/DialogFragment;", "appDialogScreen", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "showEntryReportDialog", "showIntervalPicker", "intervalList", "onSelection", "intervalMs", "showLinkShareDialog", "deeplink", "showLoginForZendeskPopUp", "showLongToast", "message", "Lapp/dogo/com/dogo_android/login_v2/DogoLoginMessage;", "resId", "text", "showPrivacyWebView", "source", "showTermsWebView", "showTimePicker", "initialHours", "initialMinutes", "Lkotlin/Function2;", "selectedHours", "selectedMinutes", "showZendeskAnswerBot", "showZendeskScreen", "showZendeskTicketInboxScreen", "smoothReplace", "startDeeplinkIfFound", "actionUri", "startExamActivity", "exam", "Lapp/dogo/com/dogo_android/model/Exam;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "startMainScreenFromOnboarding", "recommendedProgramGenerated", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class g1 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        public static final int[] b;
        static {
            int[] iArr = new int[values.length];
            int i = 1;
            iArr[MessageType.CARD.ordinal()] = i;
            g1.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[h.FEEDBACK_SCORE.ordinal()] = i;
            iArr2[h.FEEDBACK_COMMENT.ordinal()] = 2;
            g1.a.b = iArr2;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        public static final app.dogo.com.dogo_android.util.h0.g1.b a;
        static {
            g1.b bVar = new g1.b();
            g1.b.a = bVar;
        }

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }
    public static void A(p p, b b2, View view3) {
        g1.m0(p, b2, view3);
    }

    public static void B(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action2, String string3, String string4, e e5, DialogInterface dialogInterface6, int i7) {
        g1.s(firebaseInAppMessagingDisplayCallbacks, action2, string3, string4, e5, dialogInterface6, i7);
    }

    public static void C(l l, Long long2) {
        g1.b0(l, long2);
    }

    public static void D(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action2, String string3, String string4, e e5, DialogInterface dialogInterface6, int i7) {
        g1.u(firebaseInAppMessagingDisplayCallbacks, action2, string3, string4, e5, dialogInterface6, i7);
    }

    public static void E(DialogInterface dialogInterface, int i2) {
        g1.f0(dialogInterface, i2);
    }

    public static final void F(Activity activity, int i2, String string3, ZendeskConfigurationInfo zendeskConfigurationInfo4) {
        n.f(activity, "<this>");
        n.f(string3, "viewSource");
        activity.startActivityForResult(g1.j(activity, string3, zendeskConfigurationInfo4), i2);
    }

    public static final void G(Fragment fragment, int i2, String string3, ZendeskConfigurationInfo zendeskConfigurationInfo4) {
        n.f(fragment, "<this>");
        n.f(string3, "viewSource");
        Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        fragment.startActivityForResult(g1.j(requireContext, string3, zendeskConfigurationInfo4), i2);
    }

    public static void H(Activity activity, int i2, String string3, ZendeskConfigurationInfo zendeskConfigurationInfo4, int i5, Object object6) {
        int obj1;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = 10000;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        g1.F(activity, obj1, string3, obj3);
    }

    public static void I(Fragment fragment, int i2, String string3, ZendeskConfigurationInfo zendeskConfigurationInfo4, int i5, Object object6) {
        int obj1;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = 10000;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        g1.G(fragment, obj1, string3, obj3);
    }

    public static final void J(Activity activity) {
        Uri parse2;
        Intent intent;
        String parse;
        n.f(activity, "<this>");
        intent = new Intent("android.intent.action.VIEW", Uri.parse("fb://page/308330892859866"));
        activity.startActivity(intent);
    }

    public static final void K(Activity activity) {
        Object intent;
        Object intent2;
        Object launchIntentForPackage;
        Object obj4;
        n.f(activity, "<this>");
        intent2 = "com.instagram.android";
        final String str6 = "android.intent.action.VIEW";
        if (activity.getPackageManager().getLaunchIntentForPackage(intent2) != null) {
            intent2 = new Intent(str6, Uri.parse("https://www.instagram.com/_u/dogoapp/"));
            activity.startActivity(intent2);
        } else {
            intent = new Intent(str6, Uri.parse(n.o("market://details?id=", intent2)));
            activity.startActivity(intent);
        }
    }

    public static final void L(Activity activity) {
        Uri parse;
        Object obj3;
        n.f(activity, "<this>");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (activity.getPackageManager().getLaunchIntentForPackage("com.zhiliaoapp.musically") != null) {
            intent.setData(Uri.parse("tiktok://user/profile/6732021464432575494"));
        } else {
            intent.setData(Uri.parse("https://www.tiktok.com/@dogoapp"));
        }
        activity.startActivity(intent);
    }

    public static final void M(Activity activity) {
        Uri parse;
        Object obj3;
        n.f(activity, "<this>");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (activity.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube") != null) {
            intent.setData(Uri.parse("vnd.youtube://www.youtube.com/channel/UCImKCUFSzo1UH-vZvw7N1Bw"));
        } else {
            intent.setData(Uri.parse("https://www.youtube.com/channel/UCImKCUFSzo1UH-vZvw7N1Bw"));
        }
        activity.startActivity(intent);
    }

    public static final void N(Activity activity) {
        n.f(activity, "<this>");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(n.o("package:", activity.getPackageName())));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public static final void O(e e) {
        Object listIterator;
        int i;
        int fragmentReturnTag;
        int i2;
        int i3;
        int i4;
        n obj5;
        n.f(e, "<this>");
        List list = e.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        listIterator = list.listIterator(list.size());
        i3 = 1;
        while (listIterator.hasPrevious()) {
            i3 = 1;
        }
        fragmentReturnTag = i2;
        if ((Fragment)fragmentReturnTag == 0) {
        } else {
            listIterator = (Fragment)fragmentReturnTag.getArguments();
            if (listIterator == null) {
            } else {
                i2 = listIterator;
            }
        }
        i = 0;
        if (i2 == 0) {
            i3 = i;
        } else {
        }
        if (i3 != 0) {
            e.getSupportFragmentManager().b1(i2.getFragmentReturnTag(), n.b(i2.getFragmentReturnTag(), i2.getTag()));
        } else {
            e.getSupportFragmentManager().Z0();
        }
    }

    private static final void P(e e, Fragment fragment2, String string3, int i4, int i5, int i6) {
        w obj0 = e.getSupportFragmentManager().n();
        obj0.q(i5, i6);
        obj0.p(i4, fragment2, string3);
        obj0.f(string3);
        obj0.h();
    }

    static void Q(e e, Fragment fragment2, String string3, int i4, int i5, int i6, int i7, Object object8) {
        int i;
        int i2;
        final int i3 = 0;
        i = i7 & 8 != 0 ? i3 : i5;
        i2 = i7 & 16 != 0 ? i3 : i6;
        g1.P(e, fragment2, string3, i4, i, i2);
    }

    public static final void R(e e, j j2) {
        int str;
        Fragment fragment;
        String tag;
        w obj3;
        String obj4;
        n.f(j2, "appScreen");
        if (e != null) {
            App.Companion.r().g(e, j2.createTrackingParameters());
            obj3 = e.getSupportFragmentManager().n();
            n.e(obj3, "supportFragmentManager.beginTransaction()");
            obj3.p(2131362533, j2.newFragment(), j2.getTag());
            obj3.f(j2.getTag());
            obj3.h();
        } else {
            a.c("Activity not attached", new Object[0]);
        }
    }

    private static final boolean S(e e, String string2) {
        int i;
        boolean obj2;
        int obj3;
        final int i2 = 1;
        if (string2 != null) {
            if (l.z(string2)) {
                obj3 = i2;
            } else {
                obj3 = i;
            }
        } else {
        }
        if (obj3 == null && !e.isFinishing()) {
            if (!e.isFinishing()) {
                i = i2;
            }
        }
        return i;
    }

    public static final void T(e e, String string2, String string3, l<? super String, w> l4) {
        d obj3;
        app.dogo.com.dogo_android.util.h0.e0 obj4;
        n.f(e, "<this>");
        n.f(string2, "entryId");
        n.f(string3, "commentId");
        n.f(l4, "onReportCallback");
        ChallengeReportInfo challengeReportInfo = new ChallengeReportInfo(string2, string3, ChallengeReportInfo.ReportType.COMMENT);
        d dVar = new d(challengeReportInfo);
        if (obj3 instanceof c) {
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
        } else {
            obj4 = new e0(l4);
            obj3.C1(obj4);
        }
    }

    private static final void U(l l, String string2) {
        n.f(l, "$onReportCallback");
        n.e(string2, "it");
        l.invoke(string2);
    }

    public static final void V(e e, Long long2, l<? super Long, w> l3) {
        n.f(e, "<this>");
        n.f(l3, "positiveCallback");
        j.e eVar = j.e.c();
        if (long2 != null) {
            eVar.e(long2);
        }
        final j obj2 = eVar.a();
        f0 f0Var = new f0(l3);
        obj2.J1(f0Var);
        obj2.show(e.getSupportFragmentManager(), "datePickerDialog");
    }

    private static final void W(l l, Long long2) {
        n.f(l, "$positiveCallback");
        n.e(long2, "it");
        l.invoke(long2);
    }

    public static final d X(e e, e e2) {
        n.f(e, "<this>");
        n.f(e2, "appDialogScreen");
        app.dogo.com.dogo_android.w.i3 trackingParameters = e2.createTrackingParameters();
        App.Companion.r().g(e, trackingParameters);
        n obj2 = e.getSupportFragmentManager();
        n.e(obj2, "supportFragmentManager");
        return e2.showDialog(obj2, trackingParameters.a());
    }

    public static final void Y(e e, String string2, l<? super String, w> l3) {
        d obj8;
        app.dogo.com.dogo_android.util.h0.g0 obj9;
        n.f(e, "<this>");
        n.f(string2, "entryId");
        n.f(l3, "onReportCallback");
        super(string2, 0, ChallengeReportInfo.ReportType.ENTRY, 2, 0);
        d dVar = new d(challengeReportInfo2);
        if (obj8 instanceof c) {
        } else {
            obj8 = 0;
        }
        if (obj8 == null) {
        } else {
            obj9 = new g0(l3);
            obj8.C1(obj9);
        }
    }

    private static final void Z(l l, String string2) {
        n.f(l, "$onReportCallback");
        n.e(string2, "it");
        l.invoke(string2);
    }

    public static final boolean a(Activity activity, List<String> list2) {
        boolean empty;
        Object showRequestPermissionRationale;
        int i;
        int checkSelfPermission;
        int i2;
        Object obj6;
        n.f(activity, "<this>");
        n.f(list2, "requiredPermissions");
        final int i3 = 0;
        if (list2 instanceof Collection != null && list2.isEmpty()) {
            if (list2.isEmpty()) {
                i = i3;
            } else {
                obj6 = list2.iterator();
                while (obj6.hasNext()) {
                    showRequestPermissionRationale = obj6.next();
                    if (activity.checkSelfPermission((String)showRequestPermissionRationale) == -1 && !activity.shouldShowRequestPermissionRationale(showRequestPermissionRationale)) {
                    } else {
                    }
                    empty = i3;
                    if (!empty) {
                        break;
                    }
                    if (!activity.shouldShowRequestPermissionRationale(showRequestPermissionRationale)) {
                    } else {
                    }
                    empty = i;
                }
            }
        } else {
        }
        return i;
    }

    public static final void a0(e e, List<Long> list2, l<? super Long, w> l3) {
        n.f(e, "<this>");
        n.f(list2, "intervalList");
        n.f(l3, "onSelection");
        o oVar = new o(list2);
        final n obj3 = n.Companion.a(oVar);
        j0 j0Var = new j0(l3);
        obj3.C1(j0Var);
        obj3.show(e.getSupportFragmentManager(), "intervalSelectionTag");
    }

    public static final void b(e e, j j2) {
        n.f(j2, "appScreen");
        g1.f(e, "", j2, false, 4, 0);
    }

    private static final void b0(l l, Long long2) {
        n.f(l, "$onSelection");
        n.e(long2, "it");
        l.invoke(long2);
    }

    public static final void c(e e, String string2, boolean z3) {
        String str;
        String str2;
        Object obj2;
        Object obj3;
        n.f(string2, "returnTag");
        if (e != null) {
            if (!e.getSupportFragmentManager().N0()) {
                n supportFragmentManager2 = e.getSupportFragmentManager();
                str2 = "supportFragmentManager";
                n.e(supportFragmentManager2, str2);
                if (j1.f(supportFragmentManager2, string2)) {
                    e.getSupportFragmentManager().b1(string2, z3);
                } else {
                    obj2 = e.getSupportFragmentManager();
                    n.e(obj2, str2);
                    j1.e(obj2);
                }
            } else {
                obj2 = new IllegalStateException("Tried to navigate after saveInstance was called");
                a.d(obj2);
            }
        } else {
            a.c("Activity not attached", new Object[0]);
        }
    }

    public static final void c0(e e, String string2) {
        n.f(e, "<this>");
        n.f(string2, "deeplink");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", string2);
        e.startActivity(Intent.createChooser(intent, e.getResources().getString(2131886703)));
    }

    public static void d(e e, String string2, boolean z3, int i4, Object object5) {
        String obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = "";
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        g1.c(e, obj1, obj2);
    }

    public static final void d0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo2, "zendeskInfo");
        b bVar = new b(activity);
        d0 d0Var = new d0(activity, zendeskConfigurationInfo2);
        bVar.w(2131887323).D(2131886838, d0Var).y(2131886677, l0.a).t(false).o();
    }

    public static final void e(e e, String string2, j j3, boolean z4) {
        boolean trackingParameters;
        o3 o3Var;
        Activity activity;
        Fragment fragment;
        String tag;
        int i3;
        int i2;
        int i4;
        int i5;
        int i;
        Object obj10;
        Object obj11;
        n.f(string2, "returnTag");
        n.f(j3, "appScreen");
        if (e != null) {
            if (!e.getSupportFragmentManager().N0()) {
                App.Companion.r().g(e, j3.createTrackingParameters());
                g1.c(e, string2, z4);
                g1.Q(e, j3.newFragment(), j3.getTag(), 2131362533, 0, 0, 24, 0);
            } else {
                obj10 = new IllegalStateException("Tried to navigate after saveInstance was called");
                a.d(obj10);
            }
        } else {
            a.c("Activity not attached", new Object[0]);
        }
    }

    private static final void e0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        n.f(activity, "$this_showLoginForZendeskPopUp");
        n.f(zendeskConfigurationInfo2, "$zendeskInfo");
        g1.F(activity, 7001, "support", zendeskConfigurationInfo2);
    }

    public static void f(e e, String string2, j j3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        g1.e(e, string2, j3, obj3);
    }

    private static final void f0(DialogInterface dialogInterface, int i2) {
        final app.dogo.com.dogo_android.util.h0.g1.b obj0 = g1.b.a;
    }

    public static final void g(e e) {
        Intent intent;
        int i;
        String str;
        n.f(e, "<this>");
        intent = new Intent("android.intent.action.VIEW", Uri.parse(n.o("market://details?id=", e.getPackageName())));
        intent.addFlags(1208483840);
        e.startActivity(intent);
    }

    public static final void g0(e e, int i2) {
        n.f(e, "<this>");
        Toast.makeText(e, i2, 1).show();
    }

    public static final a h(ZendeskConfigurationInfo zendeskConfigurationInfo) {
        DogProfile dogProfile2;
        String str;
        DogProfile dogProfile3;
        Object dogProfile;
        Object obj12;
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        dogProfile2 = zendeskConfigurationInfo.getDogProfile();
        str = "";
        if (dogProfile2 == null) {
            dogProfile2 = str;
        } else {
        }
        CustomField customField = new CustomField(Long.valueOf(360014716920L), dogProfile2);
        CustomField customField2 = new CustomField(Long.valueOf(360014696679L), zendeskConfigurationInfo.getDogPremiumStatus());
        CustomField customField3 = new CustomField(Long.valueOf(360014718880L), zendeskConfigurationInfo.getUserId());
        dogProfile3 = zendeskConfigurationInfo.getDogProfile();
        if (dogProfile3 == null) {
            dogProfile3 = str;
        } else {
        }
        CustomField customField4 = new CustomField(Long.valueOf(360018672760L), dogProfile3);
        CustomField customField5 = new CustomField(Long.valueOf(360014719180L), "Android");
        CustomField customField6 = new CustomField(Long.valueOf(360014746620L), "7.22.1");
        CustomField customField7 = new CustomField(Long.valueOf(360020343919L), zendeskConfigurationInfo.getDogAge());
        dogProfile = zendeskConfigurationInfo.getDogProfile();
        if (dogProfile == null) {
        } else {
            dogProfile = dogProfile.getBreedId();
            if (dogProfile == null) {
            } else {
                str = dogProfile;
            }
        }
        CustomField customField8 = new CustomField(Long.valueOf(360020343899L), str);
        List list2 = p.m(/* result */);
        int i9 = 1;
        if (empty ^= i9 != 0) {
            list2.addAll(zendeskConfigurationInfo.getCustomTags());
        }
        CustomField[] arr = new CustomField[8];
        arr[i9] = customField2;
        arr[2] = customField3;
        arr[3] = customField4;
        arr[4] = customField5;
        arr[5] = customField6;
        arr[6] = customField7;
        arr[7] = customField8;
        obj12 = RequestActivity.builder().withCustomFields(p.j(arr)).withTags(list2).config();
        n.e(obj12, "builder()\n        .withCustomFields(listOf(dogNameField, dogPremiumField, userIdField, dogIdField, platformField, appVersionField, dogAgeField, dogBreedField))\n        .withTags(tags)\n        .config()");
        return obj12;
    }

    public static final void h0(e e, t t2) {
        StringBuilder stringBuilder;
        int i;
        String obj3;
        n.f(e, "<this>");
        n.f(t2, "message");
        if (t2.b() != 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(e.getString(t2.b()));
            stringBuilder.append(' ');
            stringBuilder.append(t2.a());
            g1.i0(e, stringBuilder.toString());
        } else {
            g1.i0(e, t2.a());
        }
    }

    public static final String i(e e) {
        String obj2;
        n.f(e, "<this>");
        obj2 = e.getSupportFragmentManager();
        n.e(obj2, "supportFragmentManager");
        obj2.g0();
        if (obj2.o0(g.b(i--, 0)).getName() == null) {
            obj2 = "";
        }
        return obj2;
    }

    public static final void i0(e e, String string2) {
        n.f(e, "<this>");
        n.f(string2, "text");
        Toast.makeText(e, string2, 1).show();
    }

    private static final Intent j(Context context, String string2, ZendeskConfigurationInfo zendeskConfigurationInfo3) {
        String obj7;
        final Intent obj6 = i1.f(context, string2, 0, 0, 6, 0);
        if (zendeskConfigurationInfo3 != null) {
            obj6.putExtra("zendesk_info_configuration", zendeskConfigurationInfo3);
        }
        return obj6;
    }

    public static final void j0(e e, String string2) {
        n.f(e, "<this>");
        n.f(string2, "source");
        String string = e.getString(2131887104);
        n.e(string, "getString(R.string.privacy)");
        String string3 = e.getString(2131886694);
        n.e(string3, "getString(R.string.general_privacy_policy)");
        l lVar = new l(string, string3, string2);
        e.startActivity(lVar.buildIntent(e));
    }

    public static final List<String> k(Activity activity, List<String> list2) {
        Object next;
        int i2;
        int i;
        n.f(activity, "<this>");
        n.f(list2, "requiredPermissions");
        ArrayList arrayList = new ArrayList();
        final Iterator obj5 = list2.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (activity.checkSelfPermission((String)next) == -1) {
            } else {
            }
            i2 = 0;
            if (i2 != 0) {
            }
            arrayList.add(next);
            i2 = 1;
        }
        return arrayList;
    }

    public static final void k0(e e, String string2) {
        l lVar;
        Object obj4;
        Intent obj5;
        n.f(e, "<this>");
        n.f(string2, "source");
        InputStream rawResource = e.getResources().openRawResource(2131820551);
        n.e(rawResource, "resources.openRawResource(R.raw.terms_and_services)");
        byte[] bArr = new byte[rawResource.available()];
        rawResource.read(bArr);
        String string3 = new String(bArr, d.a);
        String string = e.getString(2131886708);
        n.e(string, "getString(R.string.general_terms_use)");
        lVar = new l(string3, string, string2);
        e.startActivity(lVar.buildIntent(e));
    }

    public static final <T extends a> T l(Activity activity) {
        n.f(activity, "<this>");
        android.os.Parcelable obj1 = activity.getIntent().getParcelableExtra("SCREEN_KEY");
        n.d(obj1);
        n.e(obj1, "intent.getParcelableExtra<T>(ActivityScreenKey.SCREEN_KEY)!!");
        return (a)obj1;
    }

    public static final void l0(e e, int i2, int i3, p<? super Integer, ? super Integer, w> p4) {
        n.f(e, "<this>");
        n.f(p4, "positiveCallback");
        b.d dVar = new b.d();
        dVar.m(DateFormat.is24HourFormat(e));
        dVar.k(i2);
        dVar.l(i3);
        final b obj3 = dVar.j();
        h0 obj4 = new h0(p4, obj3);
        obj3.I1(obj4);
        obj3.show(e.getSupportFragmentManager(), "timePickerDialog");
    }

    public static final int m(Activity activity) {
        int displayMetrics;
        int left;
        int obj2;
        n.f(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            obj2 = activity.getWindowManager().getCurrentWindowMetrics();
            n.e(obj2, "windowManager.currentWindowMetrics");
            android.graphics.Insets insetsIgnoringVisibility = obj2.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            n.e(insetsIgnoringVisibility, "windowMetrics.windowInsets\n            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())");
            obj2 -= displayMetrics;
        } else {
            displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            obj2 = displayMetrics.widthPixels;
        }
        return obj2;
    }

    private static final void m0(p p, b b2, View view3) {
        n.f(p, "$positiveCallback");
        n.f(b2, "$this_apply");
        p.invoke(Integer.valueOf(b2.K1()), Integer.valueOf(b2.L1()));
    }

    public static final void n(e e, j j2) {
        boolean trackingParameters;
        o3 o3Var;
        Activity activity;
        Fragment fragment;
        String tag;
        int i4;
        int i;
        int i3;
        int i2;
        int i5;
        Object obj10;
        Object obj11;
        n.f(j2, "appScreen");
        if (e != null) {
            if (!e.getSupportFragmentManager().N0()) {
                App.Companion.r().g(e, j2.createTrackingParameters());
                g1.Q(e, j2.newFragment(), j2.getTag(), 2131362533, 0, 0, 24, 0);
            } else {
                obj10 = new IllegalStateException("Tried to navigate after saveInstance was called");
                a.d(obj10);
            }
        } else {
            a.c("Activity not attached", new Object[0]);
        }
    }

    public static final void n0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo2, "zendeskInfo");
        final MessagingConfiguration.Builder builder = MessagingActivity.builder();
        zendesk.messaging.Engine[] arr2 = new Engine[2];
        final int i3 = 0;
        arr2[i3] = AnswerBotEngine.engine();
        int i = 1;
        arr2[i] = SupportEngine.engine();
        builder.withEngines(arr2);
        a[] arr = new a[i];
        arr[i3] = g1.h(zendeskConfigurationInfo2);
        builder.show(activity, arr);
    }

    public static final void o(e e, j j2) {
        boolean fragment;
        int i;
        Object obj2;
        String obj3;
        n.f(j2, "appScreen");
        if (e != null) {
            if (!e.getSupportFragmentManager().N0()) {
                App.Companion.r().g(e, j2.createTrackingParameters());
                g1.q0(e, j2.newFragment(), j2.getTag(), 2131362533);
            } else {
                obj2 = new IllegalStateException("Tried to navigate after saveInstance was called");
                a.d(obj2);
            }
        } else {
            a.c("Activity not attached", new Object[0]);
        }
    }

    public static final void o0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        boolean hasUnreadMessages;
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo2, "zendeskInfo");
        if (!zendeskConfigurationInfo2.isUserLoggedIn()) {
            g1.d0(activity, zendeskConfigurationInfo2);
        } else {
            if (!zendeskConfigurationInfo2.getHasUnreadMessages()) {
                if (!zendeskConfigurationInfo2.isHelpCenterEnabled()) {
                    g1.p0(activity, zendeskConfigurationInfo2);
                } else {
                    if (zendeskConfigurationInfo2.getHasRequestHistory()) {
                        f1.c(activity, zendeskConfigurationInfo2);
                    } else {
                        g1.n0(activity, zendeskConfigurationInfo2);
                    }
                }
            } else {
            }
        }
    }

    public static final void p(e e) {
        n.f(e, "<this>");
        Intent intent = new Intent(e, CustomIterableInboxActivity.class);
        e.startActivity(intent);
    }

    public static final void p0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo2, "zendeskInfo");
        a[] arr = new a[1];
        RequestListActivity.builder().show(activity, g1.h(zendeskConfigurationInfo2));
    }

    public static final void q(e e, j j2) {
        boolean arr;
        Object obj3;
        n.f(e, "<this>");
        n.f(j2, "appScreen");
        final app.dogo.com.dogo_android.w.i3 trackingParameters = j2.createTrackingParameters();
        App.Companion.r().g(e, trackingParameters);
        if (j2 instanceof b) {
            ViewArticleActivity.builder((b)j2.a()).show(e, new a[0]);
        }
    }

    private static final void q0(e e, Fragment fragment2, String string3, int i4) {
        g1.P(e, fragment2, string3, i4, 2130772003, 2130772006);
    }

    public static final void r(e e, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        Object campaignMetadata2;
        Object campaignMetadata;
        boolean z;
        Object button;
        Button button2;
        Object button4;
        Button button3;
        String string3;
        Object mVar;
        int i4;
        Object portraitImageData;
        String text;
        Object inAppMessageDataHolder2;
        int[] iArr;
        z0 z0Var;
        int string;
        int body;
        e eVar;
        Object i0Var;
        int string2;
        String str;
        String str3;
        String str2;
        b bVar;
        String inAppMessageDataHolder;
        app.dogo.com.dogo_android.util.h0.k0 k0Var;
        int i2;
        int i3;
        int i;
        final Object obj2 = e;
        Object obj = inAppMessage2;
        n.f(obj2, "<this>");
        n.f(obj, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks3, "callbacks");
        MessageType messageType = inAppMessage2.getMessageType();
        if (messageType == null) {
            i4 = -1;
        } else {
            i4 = g1.a.a[messageType.ordinal()];
        }
        z0Var = 0;
        string = 1;
        if (i4 == string) {
            i0Var = obj;
            campaignMetadata2 = (CardMessage)i0Var.getCampaignMetadata();
            string2 = 0;
            if (campaignMetadata2 == null) {
                str = string2;
            } else {
                str = campaignMetadata2;
            }
            campaignMetadata = i0Var.getCampaignMetadata();
            if (campaignMetadata == null) {
                str3 = string2;
            } else {
                str3 = campaignMetadata;
            }
            int i5 = g1.a.b[j1.y(i0Var).ordinal()];
            inAppMessageDataHolder2 = "Missing info %s";
            if (i5 != string) {
                if (i5 != 2) {
                    b bVar2 = new b(obj2, 2131952117);
                    portraitImageData = i0Var.getPortraitImageData();
                    if (portraitImageData == null) {
                        str2 = string2;
                    } else {
                        str2 = portraitImageData;
                    }
                    Text body2 = i0Var.getBody();
                    if (body2 == null) {
                        text = string2;
                    } else {
                        text = body2.getText();
                    }
                    bVar = bVar2.H(i0Var.getTitle().getText()).x(text);
                    if (g1.S(obj2, str2)) {
                        bVar.I(2131558602);
                    }
                    Action primaryAction = i0Var.getPrimaryAction();
                    n.e(primaryAction, "message.primaryAction");
                    if (primaryAction.getButton() != null) {
                        button3 = primaryAction.getButton();
                        if (button3 == null) {
                            string3 = string2;
                        } else {
                        }
                        if (string3 == null) {
                            string3 = obj2.getString(2131886979);
                        }
                        super(firebaseInAppMessagingDisplayCallbacks3, primaryAction, str, str3, e);
                        bVar.E(string3, k0Var);
                    }
                    Action secondaryAction = i0Var.getSecondaryAction();
                    if (secondaryAction == null) {
                        button2 = string2;
                    } else {
                        button2 = secondaryAction.getButton();
                    }
                    if (button2 != null) {
                        button4 = secondaryAction.getButton();
                        if (button4 == null) {
                        } else {
                            button4 = button4.getText();
                            if (button4 == null) {
                            } else {
                                string2 = button4.getText();
                            }
                        }
                        if (string2 == null) {
                            string2 = obj2.getString(2131886677);
                        }
                        super(firebaseInAppMessagingDisplayCallbacks3, secondaryAction, str, str3, e);
                        bVar.z(string2, i0Var);
                    }
                    c create = bVar.create();
                    n.e(create, "materialAlertDialogBuilder\n                        .setTitle(message.title.text)\n                        .setMessage(message.body?.text)\n                        .apply { if (shouldLoadImage(imageUrl)) setView(R.layout.dialog_in_app_message) }\n                        .apply {\n                            val primaryAction = message.primaryAction\n                            if (primaryAction.button != null) {\n                                setPositiveButton(primaryAction.button?.text?.text ?: getString(R.string.ok_general)) { _, _ ->\n                                    callbacks.messageClicked(primaryAction)\n                                    App.tracker.logEvent(E.InAppMessage.PrimaryActionClicked.withParameters(EP.CampaignId() to campaignId, EP.CampaignName() to campaignName))\n                                    startDeeplinkIfFound(primaryAction.actionUrl)\n                                }\n                            }\n                        }\n                        .apply {\n                            val secondaryAction = message.secondaryAction\n                            if (secondaryAction?.button != null) {\n                                setNegativeButton(\n                                    secondaryAction.button?.text?.text ?: getString(R.string.general_cancel)\n                                ) { _, _ ->\n                                    callbacks.messageClicked(secondaryAction)\n                                    App.tracker.logEvent(E.InAppMessage.SecondaryActionClicked.withParameters(EP.CampaignId() to campaignId, EP.CampaignName() to campaignName))\n                                    startDeeplinkIfFound(secondaryAction.actionUrl)\n                                }\n                            }\n                        }\n                        .create()");
                    c0 c0Var = new c0(obj2, str2, create);
                    create.setOnShowListener(c0Var);
                    create.show();
                    z0Var = new z0();
                    App.Companion.r().g(obj2, j3.X0.b(z0Var, str));
                } else {
                    mVar = i0Var.getTitle().getText();
                    body = i0Var.getBody();
                    if (body == null) {
                    } else {
                        string2 = body.getText();
                    }
                    if (str != null && str3 != null && mVar != null && string2 != null) {
                        if (str3 != null) {
                            if (mVar != null) {
                                if (string2 != null) {
                                    inAppMessageDataHolder = new InAppMessageDataHolder(mVar, string2, str, str3);
                                    super(0, inAppMessageDataHolder, 0, 0, 12, 0);
                                    g1.X(obj2, inAppMessageDataHolder2);
                                } else {
                                    mVar = new Object[string];
                                    mVar[z0Var] = i0Var;
                                    a.c(inAppMessageDataHolder2, mVar);
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
                if (str != null && str3 != null) {
                    if (str3 != null) {
                        z0Var = obj2.getString(2131886762);
                        n.e(z0Var, "getString(R.string.in_app_rate_us_text)");
                        string = obj2.getString(2131886759);
                        n.e(string, "getString(R.string.in_app_nps_score_subheader)");
                        inAppMessageDataHolder2 = new InAppMessageDataHolder(z0Var, string, str, str3);
                        super(inAppMessageDataHolder2, 0, 0, 6, 0);
                        g1.X(obj2, mVar);
                    } else {
                        mVar = new Object[string];
                        mVar[z0Var] = i0Var;
                        a.c(inAppMessageDataHolder2, mVar);
                    }
                } else {
                }
            }
            firebaseInAppMessagingDisplayCallbacks3.impressionDetected();
        } else {
            a.a("Received UNSUPPORTED InAppMessage", new Object[z0Var]);
        }
    }

    private static final void r0(e e, String string2) {
        Intent intent;
        String str;
        Object obj3;
        if (string2 == null) {
        } else {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(string2));
            e.startActivity(intent);
        }
    }

    private static final void s(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action2, String string3, String string4, e e5, DialogInterface dialogInterface6, int i7) {
        n.f(firebaseInAppMessagingDisplayCallbacks, "$callbacks");
        n.f(e5, "$this_handleCustomInAppDisplay");
        firebaseInAppMessagingDisplayCallbacks.messageClicked(action2);
        z0 obj6 = new z0();
        obj6 = new a1();
        App.Companion.r().d(b0.b.d(u.a(obj6, string3), u.a(obj6, string4)));
        g1.r0(e5, action2.getActionUrl());
    }

    public static final void s0(Activity activity, Exam exam2, ProgramSaveInfo programSaveInfo3) {
        String obj11;
        n.f(activity, "<this>");
        n.f(exam2, "exam");
        n.f(programSaveInfo3, "programSaveInfo");
        if (exam2.getInstructions() == null) {
            obj11 = "";
        }
        super(programSaveInfo3.getDogId(), exam2.getTrickId(), programSaveInfo3.getProgramId(), obj11, exam2.getVideoTimeLimit(), obj7);
        e eVar = new e(gVar2);
        activity.startActivityForResult(eVar.buildIntent(activity), 11102);
    }

    private static final void t(e e, String string2, c c3, DialogInterface dialogInterface4) {
        Object obj0;
        Object obj1;
        n.f(e, "$this_handleCustomInAppDisplay");
        n.f(c3, "$dialog");
        if (g1.S(e, string2)) {
            obj1 = c3.findViewById(2131362633);
            n.d(obj1);
            (j)c.v(e).d().K0(string2).V().C0((ImageView)obj1);
        }
    }

    public static final void t0(Activity activity, boolean z2) {
        int obj4;
        n.f(activity, "<this>");
        Intent intent = new Intent(activity.getBaseContext(), MainScreenActivity.class);
        intent.putExtra("called_from_onboarding", true);
        intent.putExtra("show_recommended_program_list", z2);
        obj4 = activity.getIntent();
        String str4 = "android.intent.extra.STREAM";
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4 = obj4.getParcelableExtra(str4);
        }
        intent.putExtra(str4, obj4);
        activity.startActivity(intent);
        activity.finish();
    }

    private static final void u(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action2, String string3, String string4, e e5, DialogInterface dialogInterface6, int i7) {
        n.f(firebaseInAppMessagingDisplayCallbacks, "$callbacks");
        n.f(action2, "$primaryAction");
        n.f(e5, "$this_handleCustomInAppDisplay");
        firebaseInAppMessagingDisplayCallbacks.messageClicked(action2);
        z0 obj6 = new z0();
        obj6 = new a1();
        App.Companion.r().d(b0.a.d(u.a(obj6, string3), u.a(obj6, string4)));
        g1.r0(e5, action2.getActionUrl());
    }

    public static void u0(Activity activity, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        g1.t0(activity, obj1);
    }

    public static void v(e e, String string2, c c3, DialogInterface dialogInterface4) {
        g1.t(e, string2, c3, dialogInterface4);
    }

    public static void w(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo2, DialogInterface dialogInterface3, int i4) {
        g1.e0(activity, zendeskConfigurationInfo2, dialogInterface3, i4);
    }

    public static void x(l l, String string2) {
        g1.U(l, string2);
    }

    public static void y(l l, Long long2) {
        g1.W(l, long2);
    }

    public static void z(l l, String string2) {
        g1.Z(l, string2);
    }
}
