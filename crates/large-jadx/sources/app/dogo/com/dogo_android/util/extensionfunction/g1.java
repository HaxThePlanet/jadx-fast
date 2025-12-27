package app.dogo.com.dogo_android.util.h0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Insets;
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
import androidx.appcompat.app.c.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n.k;
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
import app.dogo.com.dogo_android.u.n.q.n.a;
import app.dogo.com.dogo_android.u.n.q.o;
import app.dogo.com.dogo_android.w.a1;
import app.dogo.com.dogo_android.w.b0;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.z0;
import com.bumptech.glide.k;
import com.google.android.material.datepicker.j.e;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.u;
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

/* compiled from: ActivityExtensions.kt */
@Metadata(d1 = "\u0000²\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a \u0010\u0014\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b\u001a&\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b\u001a\n\u0010\u0018\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0019\u001a\u00020\t*\u00020\u0011\u001a\u001e\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e\u001a\u0019\u0010\u001b\u001a\u0002H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u001d*\u00020\u000c¢\u0006\u0002\u0010\u001e\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u000c\u001a \u0010!\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\"\u001a\u00020\t2\u0008\u0008\u0002\u0010#\u001a\u00020 \u001a\u001c\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(\u001a\u001c\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020)\u001a\u0014\u0010$\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0014\u0010*\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010+\u001a\u00020\u0010*\u00020\u0011\u001a\u0012\u0010,\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001a\u0010-\u001a\u00020\u0010*\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201\u001a(\u00102\u001a\u00020\u0010*\u00020\u000c2\u0008\u0008\u0002\u00103\u001a\u00020 2\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a(\u00102\u001a\u00020\u0010*\u00020&2\u0008\u0008\u0002\u00103\u001a\u00020 2\u0006\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\n\u00104\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00105\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00106\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00107\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00108\u001a\u00020\u0010*\u00020\u000c\u001a\n\u00109\u001a\u00020\u0010*\u00020\u0011\u001a8\u0010:\u001a\u00020\u0010*\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020 2\u0008\u0008\u0002\u0010=\u001a\u00020 2\u0008\u0008\u0002\u0010>\u001a\u00020 H\u0002\u001a\u0014\u0010?\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0016\u0010@\u001a\u00020\u000b*\u00020\u00112\u0008\u0010A\u001a\u0004\u0018\u00010\tH\u0002\u001a=\u0010B\u001a\u00020\u0010*\u00020\u00112\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(D\u0012\u0004\u0012\u00020\u00100F\u001a<\u0010H\u001a\u00020\u0010*\u00020\u00112\u0008\u0010I\u001a\u0004\u0018\u00010J2!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(L\u0012\u0004\u0012\u00020\u00100F¢\u0006\u0002\u0010M\u001a\u0014\u0010N\u001a\u0004\u0018\u00010O*\u00020\u00112\u0006\u0010P\u001a\u00020Q\u001a5\u0010R\u001a\u00020\u0010*\u00020\u00112\u0006\u0010C\u001a\u00020\t2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(C\u0012\u0004\u0012\u00020\u00100F\u001a;\u0010S\u001a\u00020\u0010*\u00020\u00112\u000c\u0010T\u001a\u0008\u0012\u0004\u0012\u00020J0\u000e2!\u0010U\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(V\u0012\u0004\u0012\u00020\u00100F\u001a\u0012\u0010W\u001a\u00020\u0010*\u00020\u00112\u0006\u0010X\u001a\u00020\t\u001a\u0012\u0010Y\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0006\u0010[\u001a\u00020\\\u001a\u0014\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0008\u0008\u0001\u0010]\u001a\u00020 \u001a\u0012\u0010Z\u001a\u00020\u0010*\u00020\u00112\u0006\u0010^\u001a\u00020\t\u001a\u0012\u0010_\u001a\u00020\u0010*\u00020\u00112\u0006\u0010`\u001a\u00020\t\u001a\u0012\u0010a\u001a\u00020\u0010*\u00020\u00112\u0006\u0010`\u001a\u00020\t\u001aR\u0010b\u001a\u00020\u0010*\u00020\u00112\u0006\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020 26\u0010K\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(f\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008G\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(g\u0012\u0004\u0012\u00020\u00100e\u001a\u0012\u0010h\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010i\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010j\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010k\u001a\u00020\u0010*\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020 H\u0002\u001a\u0016\u0010l\u001a\u00020\u0010*\u00020\u00112\u0008\u0010m\u001a\u0004\u0018\u00010\tH\u0002\u001a\u001a\u0010n\u001a\u00020\u0010*\u00020\u000c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r\u001a\u0014\u0010s\u001a\u00020\u0010*\u00020\u000c2\u0008\u0008\u0002\u0010t\u001a\u00020\u000b¨\u0006u", d2 = {"getActivityConfig", "Lzendesk/configurations/Configuration;", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "getLoginIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "viewSource", "", "anyPermissionsIgnored", "", "Landroid/app/Activity;", "requiredPermissions", "", "clearBackstackAndGoToFragment", "", "Landroidx/fragment/app/FragmentActivity;", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "clearBackstackToTag", "returnTag", "inclusive", "clearBackstackToTagAndGoToFragment", "directToPlayStore", "getCurrentBackstackTag", "getMissingPermissions", "getScreenKey", "T", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "(Landroid/app/Activity;)Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "getScreenWidth", "", "goBackToTag", "tag", "flag", "goToFragment", "fragment", "Landroidx/fragment/app/Fragment;", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "Lapp/dogo/com/dogo_android/tracking/Screen;", "goToFragmentSmooth", "goToMobileInbox", "goToZendeskScreenAndLog", "handleCustomInAppDisplay", "inAppMessage", "Lcom/google/firebase/inappmessaging/model/InAppMessage;", "callbacks", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplayCallbacks;", "launchLogInActivity", "requestCode", "openDogoFacebook", "openDogoInstagram", "openDogoTikTok", "openDogoYoutube", "openPermissionSettings", "processBackPress", "replace", "name", "id", "enterAnimation", "exitAnimation", "replaceScreenWithStateLoss", "shouldLoadImage", "imageUrl", "showCommentReportDialog", "entryId", "commentId", "onReportCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "showDatePicker", "initialTimeMs", "", "positiveCallback", "selectedTimeMs", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "showDialogFragment", "Landroidx/fragment/app/DialogFragment;", "appDialogScreen", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "showEntryReportDialog", "showIntervalPicker", "intervalList", "onSelection", "intervalMs", "showLinkShareDialog", "deeplink", "showLoginForZendeskPopUp", "showLongToast", "message", "Lapp/dogo/com/dogo_android/login_v2/DogoLoginMessage;", "resId", "text", "showPrivacyWebView", "source", "showTermsWebView", "showTimePicker", "initialHours", "initialMinutes", "Lkotlin/Function2;", "selectedHours", "selectedMinutes", "showZendeskAnswerBot", "showZendeskScreen", "showZendeskTicketInboxScreen", "smoothReplace", "startDeeplinkIfFound", "actionUri", "startExamActivity", "exam", "Lapp/dogo/com/dogo_android/model/Exam;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "startMainScreenFromOnboarding", "recommendedProgramGenerated", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class g1 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[MessageType.values().length];
            int i = 1;
            iArr[MessageType.CARD.ordinal()] = i;
            app.dogo.com.dogo_android.util.extensionfunction.g1.a.a = iArr;
            int[] iArr2 = new int[FiamType.values().length];
            iArr2[FiamType.FEEDBACK_SCORE.ordinal()] = i;
            iArr2[FiamType.FEEDBACK_COMMENT.ordinal()] = 2;
            app.dogo.com.dogo_android.util.extensionfunction.g1.a.b = iArr2;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {

        public static final g1.b a = new g1$b();

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }
    public static final void F(Activity activity, int i, String str, ZendeskConfigurationInfo zendeskConfigurationInfo) throws ActivityNotFoundException {
        n.f(activity, "<this>");
        n.f(str, "viewSource");
        activity.startActivityForResult(app.dogo.com.dogo_android.util.extensionfunction.g1.showTimePicker(activity, str, zendeskConfigurationInfo), i);
    }

    public static final void G(Fragment fragment, int i, String str, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(fragment, "<this>");
        n.f(str, "viewSource");
        Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        fragment.startActivityForResult(app.dogo.com.dogo_android.util.extensionfunction.g1.showTimePicker(requireContext, str, zendeskConfigurationInfo), i);
    }

    public static /* synthetic */ void H(Activity activity, int i, String str, ZendeskConfigurationInfo zendeskConfigurationInfo, int i2, Object object) {
        if (i2 & 1 != 0) {
            i = 10000;
        }
        if (i2 & 4 != 0) {
            int i3 = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.F(activity, i, str, zendeskConfigurationInfo);
    }

    public static /* synthetic */ void I(Fragment fragment, int i, String str, ZendeskConfigurationInfo zendeskConfigurationInfo, int i2, Object object) {
        if (i2 & 1 != 0) {
            i = 10000;
        }
        if (i2 & 4 != 0) {
            int i3 = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.G(fragment, i, str, zendeskConfigurationInfo);
    }

    /* renamed from: J, reason: from kotlin metadata */
    public static final void getActivityConfig(Activity zendeskInfo) {
        n.f(zendeskInfo, "<this>");
        try {
            zendeskInfo.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("fb://page/308330892859866")));
        } catch (android.content.ActivityNotFoundException activityNotFound) {
            String parse2 = "http://www.facebook.com/dogoTrain/";
            parse2 = Uri.parse(parse2);
            zendeskInfo.startActivity(new Intent(r0, parse2));
            a.d(activityNotFound);
        }
    }

    /* renamed from: K, reason: from kotlin metadata */
    public static final void anyPermissionsIgnored(Activity requiredPermissions) {
        n.f(requiredPermissions, "<this>");
        String str3 = "com.instagram.android";
        try {
        } catch (android.content.ActivityNotFoundException unused) {
        }
        final String str7 = "android.intent.action.VIEW";
        if (requiredPermissions.getPackageManager().getLaunchIntentForPackage(str3) != null) {
            try {
                requiredPermissions.startActivity(new Intent(str7, Uri.parse("https://www.instagram.com/_u/dogoapp/")));
            } catch (android.content.ActivityNotFoundException unused) {
            }
        } else {
            try {
                requiredPermissions.startActivity(new Intent(str7, Uri.parse(n.o("market://details?id=", str3))));
            } catch (android.content.ActivityNotFoundException unused) {
            }
        }
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static final void clearBackstackAndGoToFragment(Activity appScreen) {
        n.f(appScreen, "<this>");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (appScreen.getPackageManager().getLaunchIntentForPackage("com.zhiliaoapp.musically") != null) {
                intent.setData(Uri.parse("tiktok://user/profile/6732021464432575494"));
            } else {
                intent.setData(Uri.parse("https://www.tiktok.com/@dogoapp"));
            }
            appScreen.startActivity(intent);
        } catch (android.content.ActivityNotFoundException activityNotFound) {
            a.d(activityNotFound);
        }
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static final void getMissingPermissions(Activity requiredPermissions) {
        n.f(requiredPermissions, "<this>");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (requiredPermissions.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube") != null) {
                intent.setData(Uri.parse("vnd.youtube://www.youtube.com/channel/UCImKCUFSzo1UH-vZvw7N1Bw"));
            } else {
                intent.setData(Uri.parse("https://www.youtube.com/channel/UCImKCUFSzo1UH-vZvw7N1Bw"));
            }
            requiredPermissions.startActivity(intent);
        } catch (android.content.ActivityNotFoundException activityNotFound) {
            a.d(activityNotFound);
        }
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static final void goToFragment(Activity appScreen) {
        n.f(appScreen, "<this>");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(n.o("package:", appScreen.getPackageName())));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        appScreen.startActivity(intent);
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static final void goToFragmentSmooth(androidx.fragment.app.e appScreen) {
        int i;
        int i2;
        n.f(appScreen, "<this>");
        List list = appScreen.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator listIterator = list.listIterator(list.size());
        i = 0;
        i = 1;
        while (listIterator.hasPrevious()) {
            i2 = (Fragment)prev instanceof t ^ i;
            if (listIterator.previous() instanceof t ^ i) {
                break;
            }
            i = 0;
            i = 1;
        }
        if (i != 0) {
            Bundle arguments = i.getArguments();
            if (arguments != null) {
            }
        }
        i = 0;
        int r3 = i;
        if (i != 0) {
            appScreen.getSupportFragmentManager().b1(i.getFragmentReturnTag(), n.b(i.getFragmentReturnTag(), i.getTag()));
        } else {
            appScreen.getSupportFragmentManager().Z0();
        }
    }

    private static final void P(androidx.fragment.app.e eVar, Fragment fragment, String str, int i, int i2, int i3) {
        androidx.fragment.app.w wVar = eVar.getSupportFragmentManager().n();
        wVar.q(i2, i3);
        wVar.p(i, fragment, str);
        wVar.f(str);
        wVar.h();
    }

    static /* synthetic */ void Q(androidx.fragment.app.e eVar, Fragment fragment, String str, int i, int i2, int i3, int i4, Object object) {
        int i52;
        i52 = 0;
        int r5 = i4 & 8 != 0 ? i52 : i2;
        int r6 = i4 & 16 != 0 ? i52 : i3;
        app.dogo.com.dogo_android.util.extensionfunction.g1.P(eVar, fragment, str, i, i52, (i4 & 16 != 0 ? i52 : i3));
    }

    /* renamed from: R, reason: from kotlin metadata */
    public static final void goToFragment(androidx.fragment.app.e fragment, app.dogo.com.dogo_android.y.j screen) {
        n.f(screen, "appScreen");
        if (fragment != null) {
            App.INSTANCE.r().logScreenView(fragment, screen.createTrackingParameters());
            androidx.fragment.app.w wVar = fragment.getSupportFragmentManager().n();
            n.e(wVar, "supportFragmentManager.beginTransaction()");
            int i = 2131362533;
            wVar.p(i, screen.newFragment(), screen.getTag());
            wVar.f(screen.getTag());
            wVar.h();
        } else {
            tag2 = "Activity not attached";
            a.c(tag2, new Object[0]);
        }
    }

    /* renamed from: S, reason: from kotlin metadata */
    private static final boolean goToFragment(androidx.fragment.app.e fragment, String screen) {
        boolean z2 = false;
        int i;
        i = 1;
        if (screen == null || l.z(screen)) {
        }
        if (i == 0 && !fragment.isFinishing()) {
        }
        return z2;
    }

    public static final void T(androidx.fragment.app.e eVar, String str, String str2, kotlin.d0.c.l<? super String, kotlin.w> lVar) {
        androidx.fragment.app.d showEntryReportDialog = null;
        n.f(eVar, "<this>");
        n.f(str, "entryId");
        n.f(str2, "commentId");
        n.f(lVar, "onReportCallback");
        eVar = app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(eVar, new ChallengeReportScreen(new ChallengeReportInfo(str, str2, ChallengeReportInfo_ReportType.COMMENT))) instanceof ChallengeReportDialog ? (ChallengeReportDialog)app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(eVar, challengeReportScreen) : 0;
        if (showEntryReportDialog != null) {
            showEntryReportDialog.C1(new app.dogo.com.dogo_android.util.extensionfunction.e0(lVar));
        }
    }

    /* renamed from: U, reason: from kotlin metadata */
    private static final void handleCustomInAppDisplay(kotlin.d0.c.l inAppMessage, String callbacks) {
        n.f(inAppMessage, "$onReportCallback");
        n.e(callbacks, "it");
        inAppMessage.invoke(callbacks);
    }

    /* renamed from: V, reason: from kotlin metadata */
    public static final void clearBackstackToTagAndGoToFragment(androidx.fragment.app.e returnTag, Long appScreen, kotlin.d0.c.l<? super Long, kotlin.w> inclusive) {
        n.f(returnTag, "<this>");
        n.f(inclusive, "positiveCallback");
        j.e eVar = j.e.c();
        if (appScreen != null) {
            eVar.e(appScreen);
        }
        final com.google.android.material.datepicker.j jVar = eVar.a();
        jVar.J1(new app.dogo.com.dogo_android.util.extensionfunction.f0(inclusive));
        jVar.show(returnTag.getSupportFragmentManager(), "datePickerDialog");
    }

    /* renamed from: W, reason: from kotlin metadata */
    private static final void showDatePicker(kotlin.d0.c.l initialTimeMs, Long positiveCallback) {
        n.f(initialTimeMs, "$positiveCallback");
        n.e(positiveCallback, "it");
        initialTimeMs.invoke(positiveCallback);
    }

    /* renamed from: X, reason: from kotlin metadata */
    public static final androidx.fragment.app.d showEntryReportDialog(androidx.fragment.app.e entryId, app.dogo.com.dogo_android.util.e onReportCallback) {
        n.f(entryId, "<this>");
        n.f(onReportCallback, "appDialogScreen");
        app.dogo.com.dogo_android.w.i3 trackingParameters = onReportCallback.createTrackingParameters();
        App.INSTANCE.r().logScreenView(entryId, trackingParameters);
        androidx.fragment.app.n supportFragmentManager = entryId.getSupportFragmentManager();
        n.e(supportFragmentManager, "supportFragmentManager");
        return onReportCallback.showDialog(supportFragmentManager, trackingParameters.a());
    }

    /* renamed from: Y, reason: from kotlin metadata */
    public static final void launchLogInActivity(androidx.fragment.app.e requestCode, String viewSource, kotlin.d0.c.l<? super String, kotlin.w> zendeskInfo) {
        androidx.fragment.app.d showEntryReportDialog = null;
        n.f(requestCode, "<this>");
        n.f(viewSource, "entryId");
        n.f(zendeskInfo, "onReportCallback");
        ChallengeReportInfo challengeReportInfo = new ChallengeReportInfo(viewSource, null, ChallengeReportInfo_ReportType.ENTRY, 2, null);
        requestCode = app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(requestCode, new ChallengeReportScreen(challengeReportInfo)) instanceof ChallengeReportDialog ? (ChallengeReportDialog)app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(requestCode, challengeReportScreen) : 0;
        if (showEntryReportDialog != null) {
            showEntryReportDialog.C1(new app.dogo.com.dogo_android.util.extensionfunction.g0(zendeskInfo));
        }
    }

    /* renamed from: Z, reason: from kotlin metadata */
    private static final void showIntervalPicker(kotlin.d0.c.l intervalList, String onSelection) {
        n.f(intervalList, "$onReportCallback");
        n.e(onSelection, "it");
        intervalList.invoke(onSelection);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final boolean startExamActivity(Activity exam, List<String> programSaveInfo) {
        boolean hasNext;
        boolean z = true;
        int checkSelfPermission;
        int i3 = -1;
        Iterator it;
        n.f(exam, "<this>");
        n.f(programSaveInfo, "requiredPermissions");
        hasNext = programSaveInfo instanceof Collection;
        final int i2 = 0;
        int r1 = i2;
        return i2;
    }

    /* renamed from: a0, reason: from kotlin metadata */
    public static final void launchLogInActivity(androidx.fragment.app.e requestCode, List<Long> viewSource, kotlin.d0.c.l<? super Long, kotlin.w> zendeskInfo) {
        n.f(requestCode, "<this>");
        n.f(viewSource, "intervalList");
        n.f(zendeskInfo, "onSelection");
        final app.dogo.com.dogo_android.u.n.q.n nVar = ReminderIntervalDialog.Companion.a(new ReminderIntervalScreen(viewSource));
        nVar.C1(new app.dogo.com.dogo_android.util.extensionfunction.j0(zendeskInfo));
        nVar.show(requestCode.getSupportFragmentManager(), "intervalSelectionTag");
    }

    public static final void b(androidx.fragment.app.e eVar, app.dogo.com.dogo_android.y.j jVar) {
        n.f(jVar, "appScreen");
        app.dogo.com.dogo_android.util.extensionfunction.g1.f(eVar, "", jVar, false, 4, null);
    }

    private static final void b0(kotlin.d0.c.l lVar, Long long) {
        n.f(lVar, "$onSelection");
        n.e(long, "it");
        lVar.invoke(long);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final void showCommentReportDialog(androidx.fragment.app.e entryId, String commentId, boolean onReportCallback) {
        str = "returnTag";
        n.f(commentId, str);
        if (entryId == null) {
            str3 = "Activity not attached";
            a.c(str3, new Object[0]);
        } else {
            if (entryId.getSupportFragmentManager().N0()) {
                str3 = "Tried to navigate after saveInstance was called";
                a.d(new IllegalStateException(str3));
            } else {
                androidx.fragment.app.n supportFragmentManager2 = entryId.getSupportFragmentManager();
                str2 = "supportFragmentManager";
                n.e(supportFragmentManager2, str2);
                if (app.dogo.com.dogo_android.util.extensionfunction.j1.f(supportFragmentManager2, commentId)) {
                    entryId.getSupportFragmentManager().b1(commentId, onReportCallback);
                } else {
                    androidx.fragment.app.n supportFragmentManager4 = entryId.getSupportFragmentManager();
                    n.e(supportFragmentManager4, str2);
                    app.dogo.com.dogo_android.util.extensionfunction.j1.e(supportFragmentManager4);
                }
            }
        }
    }

    public static final void c0(androidx.fragment.app.e eVar, String str) throws android.content.res.Resources.NotFoundException {
        n.f(eVar, "<this>");
        n.f(str, "deeplink");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        eVar.startActivity(Intent.createChooser(intent, eVar.getResources().getString(2131886703)));
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static /* synthetic */ void replace(androidx.fragment.app.e fragment, String name, boolean id, int enterAnimation, Object exitAnimation) {
        String str;
        boolean z = false;
        if (enterAnimation & 1 != 0) {
            str = "";
        }
        if (enterAnimation & 2 != 0) {
            int i = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.showCommentReportDialog(fragment, str, z);
    }

    public static final void d0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        new b(activity).w(2131887323).D(2131886838, new app.dogo.com.dogo_android.util.extensionfunction.d0(activity, zendeskConfigurationInfo)).y(2131886677, app.dogo.com.dogo_android.util.extensionfunction.l0.a).t(false).o();
    }

    public static final void e(androidx.fragment.app.e eVar, String str, app.dogo.com.dogo_android.y.j jVar, boolean z) {
        n.f(str, "returnTag");
        n.f(jVar, "appScreen");
        if (eVar == null) {
            str = "Activity not attached";
            a.c(str, new Object[0]);
        } else {
            if (!eVar.getSupportFragmentManager().N0()) {
                App.INSTANCE.r().logScreenView(eVar, jVar.createTrackingParameters());
                app.dogo.com.dogo_android.util.extensionfunction.g1.showCommentReportDialog(eVar, str, z);
                int i = 2131362533;
                int i2 = 0;
                int i3 = 0;
                int i4 = 24;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.Q(eVar, jVar.newFragment(), jVar.getTag(), i, i2, i3, i4, obj);
            } else {
                str = "Tried to navigate after saveInstance was called";
                a.d(new IllegalStateException(str));
            }
        }
    }

    private static final void e0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        n.f(activity, "$this_showLoginForZendeskPopUp");
        n.f(zendeskConfigurationInfo, "$zendeskInfo");
        app.dogo.com.dogo_android.util.extensionfunction.g1.F(activity, 7001, "support", zendeskConfigurationInfo);
    }

    public static /* synthetic */ void f(androidx.fragment.app.e eVar, String str, app.dogo.com.dogo_android.y.j jVar, boolean z, int i, Object object) {
        if (i & 4 != 0) {
            i = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.e(eVar, str, jVar, z);
    }

    private static final void f0(DialogInterface dialogInterface, int i) {
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final void goToZendeskScreenAndLog(androidx.fragment.app.e appScreen) {
        n.f(appScreen, "<this>");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(n.o("market://details?id=", appScreen.getPackageName())));
        int i = 1208483840;
        intent.addFlags(i);
        try {
            appScreen.startActivity(intent);
        } catch (android.content.ActivityNotFoundException unused) {
            String str2 = appScreen.getPackageName();
            str2 = n.o("http://play.google.com/store/apps/details?id=", str2);
            str2 = Uri.parse(str2);
            Intent chooser = new Intent(r2, str2);
            str2 = "";
            chooser = Intent.createChooser(chooser, str2);
            appScreen.startActivity(chooser);
        }
    }

    public static final void g0(androidx.fragment.app.e eVar, int i) throws android.content.res.Resources.NotFoundException {
        n.f(eVar, "<this>");
        Toast.makeText(eVar, i, 1).show();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final o.a.a replaceScreenWithStateLoss(ZendeskConfigurationInfo appScreen) {
        String breedId;
        Object obj;
        n.f(appScreen, "zendeskInfo");
        DogProfile dogProfile = appScreen.getDogProfile();
        breedId = "";
        long l2 = breedId;
        CustomField customField = new CustomField(Long.valueOf(360014716920L), breedId);
        DogProfile dogProfile2 = appScreen.getDogProfile();
        long l7 = breedId;
        CustomField customField4 = new CustomField(Long.valueOf(360018672760L, l7), breedId);
        DogProfile dogProfile3 = appScreen.getDogProfile();
        if (dogProfile3 != null) {
            breedId = dogProfile3.getBreedId();
            if (breedId != null) {
            }
        }
        CustomField customField8 = new CustomField(Long.valueOf(360020343899L, l15), breedId);
        List list2 = p.m(new String[] { "android", "mobile", "contact_us" });
        int i9 = 1;
        if (appScreen.getCustomTags().isEmpty() ^ i9) {
            list2.addAll(appScreen.getCustomTags());
        }
        CustomField[] arr = new CustomField[8];
        o.a.a config = RequestActivity.builder().withCustomFields(p.j(new CustomField[] { customField, new CustomField(Long.valueOf(360014696679L, l5), appScreen.getDogPremiumStatus()), new CustomField(Long.valueOf(360014718880L, l5), appScreen.getUserId()), customField4, new CustomField(Long.valueOf(360014719180L, l9), "Android"), new CustomField(Long.valueOf(360014746620L, l11), "7.22.1"), new CustomField(Long.valueOf(360020343919L, l13), appScreen.getDogAge()), customField8 })).withTags(list2).config();
        n.e(config, "builder()\n        .withCustomFields(listOf(dogNameField, dogPremiumField, userIdField, dogIdField, platformField, appVersionField, dogAgeField, dogBreedField))\n        .withTags(tags)\n        .config()");
        return config;
    }

    public static final void h0(androidx.fragment.app.e eVar, t tVar) {
        n.f(eVar, "<this>");
        n.f(tVar, "message");
        if (tVar.b() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string = eVar.getString(tVar.b());
            char c = ' ';
            String str4 = tVar.a();
            str = string + c + str4;
            app.dogo.com.dogo_android.util.extensionfunction.g1.i0(eVar, str);
        } else {
            app.dogo.com.dogo_android.util.extensionfunction.g1.i0(eVar, tVar.a());
        }
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final String shouldLoadImage(androidx.fragment.app.e imageUrl) {
        String name;
        n.f(imageUrl, "<this>");
        androidx.fragment.app.n supportFragmentManager = imageUrl.getSupportFragmentManager();
        n.e(supportFragmentManager, "supportFragmentManager");
        supportFragmentManager.g0();
        if (supportFragmentManager.o0(g.b(supportFragmentManager.p0() - 1, 0)).getName() == null) {
            name = "";
        }
        return name;
    }

    public static final void i0(androidx.fragment.app.e eVar, String str) throws android.content.res.Resources.NotFoundException {
        n.f(eVar, "<this>");
        n.f(str, "text");
        Toast.makeText(eVar, str, 1).show();
    }

    /* renamed from: j, reason: from kotlin metadata */
    private static final Intent showTimePicker(Context initialHours, String initialMinutes, ZendeskConfigurationInfo positiveCallback) {
        final Intent intent = app.dogo.com.dogo_android.util.extensionfunction.i1.f(initialHours, initialMinutes, null, null, 6, null);
        if (positiveCallback != null) {
            str = "zendesk_info_configuration";
            intent.putExtra(str, positiveCallback);
        }
        return intent;
    }

    public static final void j0(androidx.fragment.app.e eVar, String str) {
        n.f(eVar, "<this>");
        n.f(str, "source");
        String string = eVar.getString(2131887104);
        n.e(string, "getString(R.string.privacy)");
        String string2 = eVar.getString(2131886694);
        n.e(string2, "getString(R.string.general_privacy_policy)");
        eVar.startActivity(new GenericWebViewScreen(string, string2, str).buildIntent(eVar));
    }

    public static final List<String> k(Activity activity, List<String> list) {
        int i = 1;
        n.f(activity, "<this>");
        n.f(list, "requiredPermissions");
        ArrayList arrayList = new ArrayList();
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            int i2 = -1;
            int r2 = activity.checkSelfPermission((String)item) == -1 ? 1 : 0;
        }
        return arrayList;
    }

    public static final void k0(androidx.fragment.app.e eVar, String str) throws java.io.IOException, java.io.UnsupportedEncodingException, android.content.res.Resources.NotFoundException {
        n.f(eVar, "<this>");
        n.f(str, "source");
        try {
            InputStream rawResource = eVar.getResources().openRawResource(2131820551);
            n.e(rawResource, "resources.openRawResource(R.raw.terms_and_services)");
            byte[] bArr = new byte[rawResource.available()];
            rawResource.read(bArr);
            String string = eVar.getString(2131886708);
            n.e(string, "getString(R.string.general_terms_use)");
            eVar.startActivity(new GenericWebViewScreen(new String(bArr, Charsets.a), string, str).buildIntent(eVar));
        } catch (Exception e) {
            str = new Exception("failed to show terms and services", e);
            a.d(str);
        }
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final <T extends app.dogo.com.dogo_android.util.m0.a> T showDialogFragment(Activity appDialogScreen) {
        n.f(appDialogScreen, "<this>");
        android.os.Parcelable parcelableExtra = appDialogScreen.getIntent().getParcelableExtra("SCREEN_KEY");
        n.d(parcelableExtra);
        n.e(parcelableExtra, "intent.getParcelableExtra<T>(ActivityScreenKey.SCREEN_KEY)!!");
        return parcelableExtra;
    }

    public static final void l0(androidx.fragment.app.e eVar, int i, int i2, kotlin.d0.c.p<? super Integer, ? super Integer, kotlin.w> pVar) {
        n.f(eVar, "<this>");
        n.f(pVar, "positiveCallback");
        b.d dVar = new b.d();
        dVar.m(DateFormat.is24HourFormat(eVar));
        dVar.k(i);
        dVar.l(i2);
        final com.google.android.material.timepicker.b bVar = dVar.j();
        bVar.I1(new app.dogo.com.dogo_android.util.extensionfunction.h0(pVar, bVar));
        bVar.show(eVar.getSupportFragmentManager(), "timePickerDialog");
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final int showLinkShareDialog(Activity deeplink) {
        int widthPixels2;
        n.f(deeplink, "<this>");
        int left2 = 30;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = deeplink.getWindowManager().getCurrentWindowMetrics();
            n.e(currentWindowMetrics, "windowManager.currentWindowMetrics");
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            n.e(insetsIgnoringVisibility, "windowMetrics.windowInsets\n            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())");
            widthPixels2 = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            deeplink.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return widthPixels2;
    }

    /* renamed from: m0, reason: from kotlin metadata */
    private static final void smoothReplace(kotlin.d0.c.p fragment, com.google.android.material.timepicker.b name, View id) {
        n.f(fragment, "$positiveCallback");
        n.f(name, "$this_apply");
        fragment.invoke(Integer.valueOf(name.K1()), Integer.valueOf(name.L1()));
    }

    public static final void n(androidx.fragment.app.e eVar, app.dogo.com.dogo_android.y.j jVar) {
        n.f(jVar, "appScreen");
        if (eVar == null) {
            str = "Activity not attached";
            a.c(str, new Object[0]);
        } else {
            if (!eVar.getSupportFragmentManager().N0()) {
                App.INSTANCE.r().logScreenView(eVar, jVar.createTrackingParameters());
                int i = 2131362533;
                int i2 = 0;
                int i3 = 0;
                int i4 = 24;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.Q(eVar, jVar.newFragment(), jVar.getTag(), i, i2, i3, i4, obj);
            } else {
                str = "Tried to navigate after saveInstance was called";
                a.d(new IllegalStateException(str));
            }
        }
    }

    public static final void n0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        final MessagingConfiguration.Builder builder = MessagingActivity.builder();
        zendesk.messaging.Engine[] arr2 = new Engine[2];
        final int i3 = 0;
        arr2[i3] = AnswerBotEngine.engine();
        int i = 1;
        arr2[i] = SupportEngine.engine();
        builder.withEngines(arr2);
        o.a.a[] arr = new a[i];
        arr[i3] = app.dogo.com.dogo_android.util.extensionfunction.g1.replaceScreenWithStateLoss(zendeskConfigurationInfo);
        builder.show(activity, arr);
    }

    public static final void o(androidx.fragment.app.e eVar, app.dogo.com.dogo_android.y.j jVar) {
        n.f(jVar, "appScreen");
        if (eVar == null) {
            str = "Activity not attached";
            a.c(str, new Object[0]);
        } else {
            if (!eVar.getSupportFragmentManager().N0()) {
                App.INSTANCE.r().logScreenView(eVar, jVar.createTrackingParameters());
                int i = 2131362533;
                app.dogo.com.dogo_android.util.extensionfunction.g1.q0(eVar, jVar.newFragment(), jVar.getTag(), i);
            } else {
                str = "Tried to navigate after saveInstance was called";
                a.d(new IllegalStateException(str));
            }
        }
    }

    public static final void o0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        boolean hasUnreadMessages;
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        if (!zendeskConfigurationInfo.isUserLoggedIn()) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.d0(activity, zendeskConfigurationInfo);
        } else {
            if (zendeskConfigurationInfo.getHasUnreadMessages() || !zendeskConfigurationInfo.isHelpCenterEnabled()) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.p0(activity, zendeskConfigurationInfo);
            }
        }
    }

    /* renamed from: p, reason: from kotlin metadata */
    public static final void showLoginForZendeskPopUp(androidx.fragment.app.e zendeskInfo) {
        n.f(zendeskInfo, "<this>");
        zendeskInfo.startActivity(new Intent(zendeskInfo, CustomIterableInboxActivity.class));
    }

    public static final void p0(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(activity, "<this>");
        n.f(zendeskConfigurationInfo, "zendeskInfo");
        o.a.a[] arr = new a[1];
        RequestListActivity.builder().show(activity, new a[] { app.dogo.com.dogo_android.util.extensionfunction.g1.replaceScreenWithStateLoss(zendeskConfigurationInfo) });
    }

    public static final void q(androidx.fragment.app.e eVar, app.dogo.com.dogo_android.y.j jVar) {
        n.f(eVar, "<this>");
        n.f(jVar, "appScreen");
        final app.dogo.com.dogo_android.w.i3 trackingParameters = jVar.createTrackingParameters();
        App.INSTANCE.r().logScreenView(eVar, trackingParameters);
        z = jVar instanceof ZendeskKnowledgeScreen;
        if (jVar instanceof ZendeskKnowledgeScreen) {
            ViewArticleActivity.builder(jVar.component1()).show(eVar, new a[0]);
        }
    }

    private static final void q0(androidx.fragment.app.e eVar, Fragment fragment, String str, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.P(eVar, fragment, str, i, 2130772003, 2130772006);
    }

    public static final void r(androidx.fragment.app.e eVar, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        Button button2;
        Text text;
        String string;
        o3 o3Var;
        int i2 = -1;
        Object obj;
        app.dogo.com.dogo_android.w.i3 i3Var;
        z0 eP_CampaignId = null;
        int i4 = 1;
        int i5 = 2;
        androidx.fragment.app.e eVar2;
        CardMessage cardMessage;
        int i = 0;
        String text2 = null;
        Object obj3;
        String text3 = null;
        String campaignId;
        String campaignName;
        String imageUrl;
        f.c.a.e.s.b bVar = null;
        Object obj2;
        app.dogo.com.dogo_android.util.h0.k0 k0Var;
        app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo examHistorySaveInfo = null;
        int i6 = 12;
        kotlin.d0.d.g gVar = null;
        final Object eVar3 = eVar;
        Object inAppMessage22 = inAppMessage;
        n.f(eVar3, "<this>");
        n.f(inAppMessage22, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks, "callbacks");
        MessageType messageType = inAppMessage.getMessageType();
        if (messageType == null) {
            i2 = -1;
        } else {
            i2 = app.dogo.com.dogo_android.util.extensionfunction.g1.a.a[messageType.ordinal()];
        }
        int i3 = 0;
        i4 = 1;
        if (i2 == i4) {
            cardMessage = inAppMessage22;
            CampaignMetadata campaignMetadata = cardMessage.getCampaignMetadata();
            i = 0;
            i = campaignMetadata == null ? i : campaignId;
            CampaignMetadata campaignMetadata2 = cardMessage.getCampaignMetadata();
            i = campaignMetadata2 == null ? i : campaignName;
            int i7 = app.dogo.com.dogo_android.util.extensionfunction.g1.a.b[app.dogo.com.dogo_android.util.extensionfunction.j1.y(cardMessage).ordinal()];
            String str6 = "Missing info %s";
            if (i7 != i4) {
                i5 = 2;
                if (i7 != 2) {
                    ImageData portraitImageData = cardMessage.getPortraitImageData();
                    i = portraitImageData == null ? i : imageUrl;
                    Text body = cardMessage.getBody();
                    if (body == null) {
                    } else {
                        String text7 = body.getText();
                    }
                    bVar = new b(eVar3, 2131952117).H(cardMessage.getTitle().getText()).x(obj);
                    if (app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(eVar3, imageUrl)) {
                        bVar.I(2131558602);
                    }
                    Action primaryAction = cardMessage.getPrimaryAction();
                    n.e(primaryAction, "message.primaryAction");
                    if (primaryAction.getButton() != null) {
                        Button button3 = primaryAction.getButton();
                        int r0 = i;
                        if ("message.primaryAction" == null) {
                            string = eVar3.getString(2131886979);
                        }
                        k0Var = new app.dogo.com.dogo_android.util.extensionfunction.k0(firebaseInAppMessagingDisplayCallbacks, primaryAction, campaignId, campaignName, eVar);
                        bVar.E(string, k0Var);
                    }
                    Action secondaryAction = cardMessage.getSecondaryAction();
                    if (secondaryAction == null) {
                    } else {
                        button2 = secondaryAction.getButton();
                    }
                    if ("message.primaryAction" != null) {
                        Button button4 = secondaryAction.getButton();
                        if (button4 != null) {
                            text = button4.getText();
                            if (text != null) {
                                text2 = text.getText();
                            }
                        }
                        if (text2 == null) {
                            String string4 = eVar3.getString(2131886677);
                        }
                        app.dogo.com.dogo_android.util.extensionfunction.i0 i0Var = new app.dogo.com.dogo_android.util.extensionfunction.i0(firebaseInAppMessagingDisplayCallbacks, secondaryAction, campaignId, campaignName, eVar);
                        bVar.z(obj3, i0Var);
                    }
                    androidx.appcompat.app.c bVar4 = bVar.create();
                    n.e(bVar4, "materialAlertDialogBuilder\n                        .setTitle(message.title.text)\n                        .setMessage(message.body?.text)\n                        .apply { if (shouldLoadImage(imageUrl)) setView(R.layout.dialog_in_app_message) }\n                        .apply {\n                            val primaryAction = message.primaryAction\n                            if (primaryAction.button != null) {\n                                setPositiveButton(primaryAction.button?.text?.text ?: getString(R.string.ok_general)) { _, _ ->\n                                    callbacks.messageClicked(primaryAction)\n                                    App.tracker.logEvent(E.InAppMessage.PrimaryActionClicked.withParameters(EP.CampaignId() to campaignId, EP.CampaignName() to campaignName))\n                                    startDeeplinkIfFound(primaryAction.actionUrl)\n                                }\n                            }\n                        }\n                        .apply {\n                            val secondaryAction = message.secondaryAction\n                            if (secondaryAction?.button != null) {\n                                setNegativeButton(\n                                    secondaryAction.button?.text?.text ?: getString(R.string.general_cancel)\n                                ) { _, _ ->\n                                    callbacks.messageClicked(secondaryAction)\n                                    App.tracker.logEvent(E.InAppMessage.SecondaryActionClicked.withParameters(EP.CampaignId() to campaignId, EP.CampaignName() to campaignName))\n                                    startDeeplinkIfFound(secondaryAction.actionUrl)\n                                }\n                            }\n                        }\n                        .create()");
                    bVar4.setOnShowListener(new app.dogo.com.dogo_android.util.extensionfunction.c0(eVar3, imageUrl, bVar4));
                    bVar4.show();
                    App.INSTANCE.r().logScreenView(eVar3, S.examCamera.b(new EP_CampaignId(), campaignId));
                } else {
                    String text5 = cardMessage.getTitle().getText();
                    Text body2 = cardMessage.getBody();
                    if (body2 != null) {
                        text3 = body2.getText();
                    }
                    if (campaignId == null || campaignName == null || text5 == null || text3 == null) {
                        Object[] arr2 = new Object[i4];
                        a.c(str6, new Object[] { cardMessage });
                    } else {
                        examHistorySaveInfo = null;
                        i6 = 12;
                        gVar = null;
                        InAppFeedbackScreen inAppFeedbackScreen = new InAppFeedbackScreen(0, new InAppMessageDataHolder(text5, text3, campaignId, campaignName), null, examHistorySaveInfo, i6, gVar);
                        app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(eVar3, inAppFeedbackScreen);
                    }
                }
            } else {
                if (campaignId == null || campaignName == null) {
                    Object[] arr3 = new Object[i4];
                    a.c(str6, new Object[] { cardMessage });
                } else {
                    String string2 = eVar3.getString(2131886762);
                    n.e(string2, "getString(R.string.in_app_rate_us_text)");
                    String string3 = eVar3.getString(2131886759);
                    n.e(string3, "getString(R.string.in_app_nps_score_subheader)");
                    InAppOneTenScreen inAppOneTenScreen = new InAppOneTenScreen(inAppMessageDataHolder, null, null, 6, null);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(eVar3, inAppOneTenScreen);
                }
            }
            firebaseInAppMessagingDisplayCallbacks.impressionDetected();
        } else {
            str = "Received UNSUPPORTED InAppMessage";
            a.a(str, new Object[i3]);
        }
    }

    private static final void r0(androidx.fragment.app.e eVar, String str) {
        if (str != null) {
            Intent intent = new Intent();
            str = "android.intent.action.VIEW";
            intent.setAction(str);
            intent.setData(Uri.parse(str));
            eVar.startActivity(intent);
        }
    }

    private static final void s(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action, String str, String str2, androidx.fragment.app.e eVar, DialogInterface dialogInterface, int i) {
        n.f(firebaseInAppMessagingDisplayCallbacks, "$callbacks");
        n.f(eVar, "$this_handleCustomInAppDisplay");
        firebaseInAppMessagingDisplayCallbacks.messageClicked(action);
        App.INSTANCE.r().logEvent(E_InAppMessage.b.withParameters(u.a(new EP_CampaignId(), str), u.a(new EP_CampaignName(), str2)));
        app.dogo.com.dogo_android.util.extensionfunction.g1.r0(eVar, action.getActionUrl());
    }

    public static final void s0(Activity activity, Exam exam, ProgramSaveInfo programSaveInfo) throws ActivityNotFoundException {
        String programSaveInfo32;
        n.f(activity, "<this>");
        n.f(exam, "exam");
        n.f(programSaveInfo, "programSaveInfo");
        if (exam.getInstructions() == null) {
            programSaveInfo32 = "";
        }
        ExamUploadData examUploadData = new ExamUploadData(programSaveInfo.getDogId(), exam.getTrickId(), programSaveInfo.getProgramId(), programSaveInfo32, exam.getVideoTimeLimit(), obj);
        ExamFlowScreenKey examFlowScreenKey = new ExamFlowScreenKey(examUploadData);
        activity.startActivityForResult(examFlowScreenKey.buildIntent(activity), 11102);
    }

    private static final void t(androidx.fragment.app.e eVar, String str, androidx.appcompat.app.c cVar, DialogInterface dialogInterface) {
        n.f(eVar, "$this_handleCustomInAppDisplay");
        n.f(cVar, "$dialog");
        if (app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(eVar, str)) {
            View viewById = cVar.findViewById(2131362633);
            n.d(viewById);
            (j)c.v(eVar).d().K0(str).V().C0(viewById);
        }
    }

    public static final void t0(Activity activity, boolean z) {
        android.os.Parcelable parcelableExtra = null;
        n.f(activity, "<this>");
        Intent intent = new Intent(activity.getBaseContext(), MainScreenActivity.class);
        intent.putExtra("called_from_onboarding", true);
        intent.putExtra("show_recommended_program_list", z);
        Intent intent2 = activity.getIntent();
        String str4 = "android.intent.extra.STREAM";
        int i2 = intent2 == null ? 0 : (Uri)parcelableExtra;
        intent.putExtra("android.intent.extra.STREAM", parcelableExtra);
        activity.startActivity(intent);
        activity.finish();
    }

    private static final void u(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action, String str, String str2, androidx.fragment.app.e eVar, DialogInterface dialogInterface, int i) {
        n.f(firebaseInAppMessagingDisplayCallbacks, "$callbacks");
        n.f(action, "$primaryAction");
        n.f(eVar, "$this_handleCustomInAppDisplay");
        firebaseInAppMessagingDisplayCallbacks.messageClicked(action);
        App.INSTANCE.r().logEvent(E_InAppMessage.a.withParameters(u.a(new EP_CampaignId(), str), u.a(new EP_CampaignName(), str2)));
        app.dogo.com.dogo_android.util.extensionfunction.g1.r0(eVar, action.getActionUrl());
    }

    public static /* synthetic */ void u0(Activity activity, boolean z, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.t0(activity, z);
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ void getLoginIntent(kotlin.d0.c.p context, com.google.android.material.timepicker.b viewSource, View zendeskInfo) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.smoothReplace(context, viewSource, zendeskInfo);
    }

    public static /* synthetic */ void B(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action, String str, String str2, androidx.fragment.app.e eVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.s(firebaseInAppMessagingDisplayCallbacks, action, str, str2, eVar, dialogInterface, i);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static /* synthetic */ void clearBackstackToTag(kotlin.d0.c.l returnTag, Long inclusive) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.b0(returnTag, inclusive);
    }

    public static /* synthetic */ void D(FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks, Action action, String str, String str2, androidx.fragment.app.e eVar, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.u(firebaseInAppMessagingDisplayCallbacks, action, str, str2, eVar, dialogInterface, i);
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static /* synthetic */ void goBackToTag(DialogInterface tag, int flag) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.f0(tag, flag);
    }

    public static /* synthetic */ void v(androidx.fragment.app.e eVar, String str, androidx.appcompat.app.c cVar, DialogInterface dialogInterface) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.t(eVar, str, cVar, dialogInterface);
    }

    public static /* synthetic */ void w(Activity activity, ZendeskConfigurationInfo zendeskConfigurationInfo, DialogInterface dialogInterface, int i) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.e0(activity, zendeskConfigurationInfo, dialogInterface, i);
    }

    public static /* synthetic */ void x(kotlin.d0.c.l lVar, String str) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.handleCustomInAppDisplay(lVar, str);
    }

    public static /* synthetic */ void y(kotlin.d0.c.l lVar, Long long) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.showDatePicker(lVar, long);
    }

    public static /* synthetic */ void z(kotlin.d0.c.l lVar, String str) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.showIntervalPicker(lVar, str);
    }
}
