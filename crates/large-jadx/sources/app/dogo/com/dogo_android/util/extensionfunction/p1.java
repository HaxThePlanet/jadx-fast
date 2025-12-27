package app.dogo.com.dogo_android.util.h0;

import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.SearchView;
import app.dogo.com.dogo_android.h.u6;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.n.m.q;
import app.dogo.com.dogo_android.q.p.y;
import app.dogo.com.dogo_android.q.s.d;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.s.b.i1.b;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.t.i0.a;
import app.dogo.com.dogo_android.t.i0.c;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.o.s;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.y.g;
import com.coremedia.iso.boxes.MovieBox;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: UriToScreensExtension.kt */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0013\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e*\u00020 \u001a\n\u0010!\u001a\u00020\u0001*\u00020 \u001a\n\u0010\"\u001a\u00020\u0001*\u00020 \u001a\u000c\u0010#\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010%\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010&\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010'\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010(\u001a\u00020$*\u00020 H\u0002\u001a\n\u0010)\u001a\u00020$*\u00020 \u001a\u000c\u0010*\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010+\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010,\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010-\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010.\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010/\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00100\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00101\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00102\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00103\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00104\u001a\u00020$*\u00020 H\u0002\u001a\u0012\u00105\u001a\u00020$*\u00020 2\u0006\u00106\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00067", d2 = {"ADD_LOG_SEGMENT", "", "ADD_PARENT_SEGMENT", "ARTICLES_SEGMENT", "CALENDAR_SEGMENT", "CATEGORY_SEGMENT", "CERTIFICATE_SEGMENT", "CODE_PARAMETER", "CONTACT_US", "DOG_ID_PARAMETER", "EXAM_SEGMENT", "INBOX_SEGMENT", "INVITE_SEGMENT", "KNOWLEDGE_BASE_SEGMENT", "LESSONS_SEGMENT", "LIBRARY_SEGMENT", "LINK_PARAMETER", "POTTY_SEGMENT", "PROFILE_SEGMENT", "PROGRAMS_SEGMENT", "SET_REMINDER_SEGMENT", "SHARE_DIALOG", "SUBSCRIPTION", "TAG_SEGMENT", "TRICKS_SEGMENT", "ZENDESK_SEGMENT", "getEmptyProgramSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "programId", "getAppScreenWithHistory", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroid/net/Uri;", "getDogId", "getInviteId", "isAddNewParentLink", "", "isAddPottyLogLink", "isArticleId", "isBitingProgram", "isInboxLink", "isInvite", "isMessageId", "isPottyProgram", "isProgramExamId", "isProgramExams", "isProgramLessonId", "isSecondPathId", "isSetPottyReminderLink", "isSetTrainingReminderLink", "isSharableLink", "isSubscription", "isSubscriptionCoupon", "shouldSwitchDog", "currentDogId", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class p1 {
    /* renamed from: a, reason: from kotlin metadata */
    public static final List<j> getEmptyProgramSaveInfo(Uri programId) {
        List list;
        Object obj;
        Object obj2;
        double d;
        String str;
        int i = 3;
        String str2;
        String queryParameter;
        String str3;
        String str4;
        boolean z = false;
        int i2 = 2;
        double d2;
        int i3 = 1;
        int i14;
        j jVar = null;
        int c;
        programId2 = programId;
        n.f(programId2, "<this>");
        List pathSegments4 = programId.getPathSegments();
        str = "pathSegments";
        n.e(pathSegments4, str);
        obj2 = p.Z(pathSegments4);
        if (obj2 != null) {
            i = 3;
            str2 = "library";
            queryParameter = "tag";
            str3 = "lastPathSegment!!";
            str4 = "";
            z = false;
            i2 = 2;
            i3 = 1;
            jVar = null;
            switch (obj2.hashCode()) {
                case -1228877251:
                    str = "articles";
                    j[] arr16 = new j[i2];
                    arr16[z] = new LibraryScreen(jVar, i3, jVar);
                    String lastPathSegment = null;
                    String lastPathSegment2 = programId.getLastPathSegment();
                    n.d(lastPathSegment2);
                    n.e(lastPathSegment2, str3);
                    String lastPathSegment3 = null;
                    String str6 = null;
                    String str8 = null;
                    Article article = new Article(null, lastPathSegment2, null, null, 0, null, false, null, null, false, null, null, 4093, null);
                    arr16[i3] = new ArticleDetailsScreen(article, str2, z);
                    list = p.j(arr16);
                    j[] arr15 = new j[i2];
                    arr15[z] = new LibraryScreen(jVar, i3, jVar);
                    String queryParameter6 = programId2.getQueryParameter(queryParameter);
                    n.d(queryParameter6);
                    arr15[i3] = new ArticleListScreen(queryParameter6);
                    list = p.j(arr15);
                    j[] arr6 = new j[i2];
                    arr6[z] = new LibraryScreen(jVar, i3, jVar);
                    arr6[i3] = new ArticleListScreen(jVar, i3, jVar);
                    list = p.j(arr6);
                    list = p.g();
                    break;
                case -1001082257:
                    str = "programs";
                    j[] arr4 = new j[i2];
                    arr4[z] = new LibraryScreen(jVar, i3, jVar);
                    arr4[i3] = new PottyProgramOverviewScreen(str4);
                    list = p.j(arr4);
                    j[] arr3 = new j[i2];
                    arr3[z] = new LibraryScreen(jVar, i3, jVar);
                    arr3[i3] = new BitingProgramOverviewScreen(str4);
                    list = p.j(arr3);
                    j[] arr11 = new j[i2];
                    arr11[z] = new LibraryScreen(jVar, i3, jVar);
                    lastPathSegment3 = programId.getLastPathSegment();
                    n.d(lastPathSegment3);
                    n.e(lastPathSegment3, str3);
                    str6 = "";
                    ProgramLessonsListScreen programLessonsListScreen = new ProgramLessonsListScreen(false, lastPathSegment3, false, false, "", 13, null);
                    arr11[i3] = programLessonsListScreen;
                    list = p.j(arr11);
                    j[] arr10 = new j[i2];
                    arr10[z] = new LibraryScreen(jVar, i3, jVar);
                    lastPathSegment2 = programId.getLastPathSegment();
                    n.d(lastPathSegment2);
                    Object item3 = programId.getPathSegments().get(i3);
                    n.d(item3);
                    ProgramLessonScreen programLessonScreen = new ProgramLessonScreen(lastPathSegment2, (String)item3, "", false, false, 24, null);
                    arr10[i3] = programLessonScreen;
                    list = p.j(arr10);
                    j[] arr9 = new j[i2];
                    arr9[z] = new LibraryScreen(jVar, i3, jVar);
                    Object item2 = programId.getPathSegments().get(i3);
                    n.d(item2);
                    lastPathSegment3 = "";
                    LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(app.dogo.com.dogo_android.util.extensionfunction.p1.c(item2), "", "", false, 8, null);
                    arr9[i3] = lessonExamListScreen;
                    list = p.j(arr9);
                    j[] arr8 = new j[i2];
                    arr8[z] = new LibraryScreen(jVar, i3, jVar);
                    Object item4 = programId.getPathSegments().get(i3);
                    n.d(item4);
                    String lastPathSegment7 = programId.getLastPathSegment();
                    n.d(lastPathSegment7);
                    n.e(lastPathSegment7, str3);
                    str6 = null;
                    lastPathSegment3 = "";
                    LessonExamHistoryScreen lessonExamHistoryScreen = new LessonExamHistoryScreen(app.dogo.com.dogo_android.util.extensionfunction.p1.c(item4), "", lastPathSegment7, false, null, 16, null);
                    arr8[i3] = lessonExamHistoryScreen;
                    list = p.j(arr8);
                    str = "certificate";
                    j[] arr7 = new j[i2];
                    arr7[z] = new LibraryScreen(jVar, i3, jVar);
                    Object item = programId.getPathSegments().get(i3);
                    str2 = "pathSegments[1]";
                    n.e(item, "pathSegments[1]");
                    String str5 = null;
                    String str7 = null;
                    str8 = null;
                    int i4 = 1022;
                    kotlin.d0.d.g gVar = null;
                    ProgramExamSummary programExamSummary = new ProgramExamSummary(app.dogo.com.dogo_android.util.extensionfunction.p1.c(item), null, null, null, str5, null, str7, null, null, null, 1022, null);
                    lastPathSegment3 = "";
                    CertificateDetailScreen certificateDetailScreen = new CertificateDetailScreen(programExamSummary, "", "", str5, 8, str7);
                    arr7[i3] = certificateDetailScreen;
                    list = p.j(arr7);
                    j[] arr2 = new j[i2];
                    arr2[z] = new LibraryScreen(jVar, i3, jVar);
                    arr2[i3] = new ProgramListScreen(jVar, z, i, jVar);
                    list = p.j(arr2);
                    list = p.g();
                    break;
                case -892664913:
                    str = "set_reminder";
                    list = p.b(new TrainingReminderWithTimeScreen("deeplink", jVar, i2, jVar));
                    list = p.g();
                    list = p.g();
                    break;
                case -865477760:
                    str = "tricks";
                    j[] arr14 = new j[i2];
                    arr14[z] = new LibraryScreen(jVar, i3, jVar);
                    lastPathSegment = programId.getLastPathSegment();
                    n.d(lastPathSegment);
                    n.e(lastPathSegment, str3);
                    lastPathSegment2 = null;
                    lastPathSegment3 = null;
                    i4 = 0;
                    TrickItem.TrickCategory trickCategory = null;
                    boolean z2 = false;
                    app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = null;
                    boolean z3 = false;
                    String str9 = null;
                    List list2 = null;
                    String str10 = null;
                    int i5 = 0;
                    int i6 = 0;
                    kotlin.d0.d.g gVar2 = 1048574;
                    int i7 = 0;
                    TrickItem trickItem = new TrickItem(lastPathSegment, null, null, null, false, 0, null, null, 0L, z29, 0, null, null, false, null, false, null, null, null, 0, 0, 1048574, 0);
                    arr14[i3] = new TrickDetailsScreen(new TrickDetailsPlan_LibraryPlan(trickItem), str4, str4, str2);
                    list = p.j(arr14);
                    String str17 = "category";
                    j[] arr12 = new j[i2];
                    arr12[z] = new LibraryScreen(jVar, i3, jVar);
                    String queryParameter3 = programId2.getQueryParameter(str17);
                    n.d(queryParameter3);
                    str = "getQueryParameter(CATEGORY_SEGMENT)!!";
                    n.e(queryParameter3, "getQueryParameter(CATEGORY_SEGMENT)!!");
                    arr12[i3] = new TrickListScreen(new TrickItem_TrickCategory(queryParameter3, jVar, i2, jVar), jVar, i2, jVar);
                    list = p.j(arr12);
                    j[] arr13 = new j[i2];
                    arr13[z] = new LibraryScreen(jVar, i3, jVar);
                    arr13[i3] = new TrickListScreen(new TrickItem_TrickCategory(jVar, jVar, i, jVar), programId2.getQueryParameter(queryParameter));
                    list = p.j(arr13);
                    j[] arr5 = new j[i2];
                    arr5[z] = new LibraryScreen(jVar, i3, jVar);
                    arr5[i3] = new TrickListScreen(new TrickItem_TrickCategory("id_tricks", jVar, i2, jVar), jVar, i2, jVar);
                    list = p.j(arr5);
                    list = p.g();
                    break;
                case -706485848:
                    str = "share_dialog";
                    String queryParameter2 = programId2.getQueryParameter("link");
                    n.d(queryParameter2);
                    str = "getQueryParameter(LINK_PARAMETER)!!";
                    n.e(queryParameter2, "getQueryParameter(LINK_PARAMETER)!!");
                    list = p.b(new SharableDialogScreen(queryParameter2));
                    list = p.g();
                    list = p.g();
                    break;
                case -397489220:
                    str = "zendesk";
                    String lastPathSegment4 = programId.getLastPathSegment();
                    n.d(lastPathSegment4);
                    n.e(lastPathSegment4, str3);
                    list = p.b(new ZendeskMessageScreen(lastPathSegment4));
                    list = p.g();
                    list = p.g();
                    break;
                case -309425751:
                    str = "profile";
                    j[] arr = new j[i2];
                    arr[z] = new DogPreviewFullscreenScreen(z, jVar, i, jVar);
                    lastPathSegment = null;
                    lastPathSegment2 = null;
                    Long l = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    Long l2 = null;
                    app.dogo.com.dogo_android.k.d dVar = null;
                    i4 = 1019;
                    gVar = null;
                    lastPathSegment3 = "";
                    DogProfile dogProfile = new DogProfile(null, null, "", null, null, null, null, null, null, null, 1019, null);
                    arr[i3] = new DogParentsScreen(dogProfile);
                    list = p.j(arr);
                    list = p.g();
                    list = p.g();
                    break;
                case -178324674:
                    list = p.b(new DogLogCalendarScreen(str4, str4));
                    list = p.g();
                    break;
                case 76218447:
                    str = "knowledgebase";
                    String lastPathSegment5 = programId.getLastPathSegment();
                    n.d(lastPathSegment5);
                    n.e(lastPathSegment5, str3);
                    list = p.b(new ZendeskKnowledgeScreen(Long.parseLong(lastPathSegment5), i));
                    list = p.g();
                    list = p.g();
                    break;
                case 100344454:
                    str = "inbox";
                    str = "";
                    MobileInboxScreen mobileInboxScreen = new MobileInboxScreen("", "", null, 0, 12, null);
                    list = p.b(mobileInboxScreen);
                    list = p.g();
                    list = p.g();
                    break;
                case 106856346:
                    str = "potty";
                    list = p.b(new PottyProgramReminderScreen(jVar, i3, jVar));
                    queryParameter = null;
                    str3 = null;
                    str = "";
                    DogLogEditScreen dogLogEditScreen = new DogLogEditScreen("", null, null, null, null, 30, null);
                    list = p.b(dogLogEditScreen);
                    list = p.g();
                    list = p.g();
                    break;
                case 139877149:
                    str = "contact_us";
                    str = "campaign";
                    list = p.b(new ZendeskContactUsScreen(programId2.getQueryParameter("campaign")));
                    list = p.g();
                    break;
                case 166208699:
                    list = p.b(new LibraryScreen(jVar, i3, jVar));
                    list = p.g();
                    break;
                case 341203229:
                    str = "subscription";
                    queryParameter = programId2.getQueryParameter("code");
                    n.d(queryParameter);
                    n.e(queryParameter, "getQueryParameter(\"code\")!!");
                    i2 = 56;
                    str2 = "";
                    DogProfile subscriptionBenefitsScreen2 = new DogProfile("", "", queryParameter, false, null, null, 56, null);
                    list = p.b(subscriptionBenefitsScreen2);
                    str2 = null;
                    str = "";
                    SubscriptionBenefitsScreen subscriptionBenefitsScreen = new SubscriptionBenefitsScreen("", "", null, false, null, null, 60, null);
                    list = p.b(subscriptionBenefitsScreen);
                    list = p.g();
                    list = p.g();
                    break;
                default:
                    list = p.g();
            }
        }
        return list;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final String shouldSwitchDog(Uri currentDogId) {
        String queryParameter;
        n.f(currentDogId, "<this>");
        if (currentDogId.getQueryParameter("dog") == null) {
            queryParameter = "";
        }
        return queryParameter;
    }

    private static final ProgramSaveInfo c(String str) {
        final String str2 = "";
        return new ProgramSaveInfo(str, str2, str2, str2);
    }

    public static final String d(Uri uri) {
        n.f(uri, "<this>");
        Object item = uri.getPathSegments().get(1);
        n.e(item, "pathSegments[1]");
        return item;
    }

    private static final boolean e(Uri uri) {
        int size;
        boolean z2 = false;
        boolean z;
        if (uri.getPathSegments().size() == 2) {
            if (!(n.b(uri.getPathSegments().get(1), "add_parent"))) {
                int i2 = 0;
            }
        }
        return z2;
    }

    private static final boolean f(Uri uri) {
        int size;
        boolean z2 = false;
        boolean z;
        if (uri.getPathSegments().size() == 2) {
            if (!(n.b(uri.getPathSegments().get(1), "add_log"))) {
                int i2 = 0;
            }
        }
        return z2;
    }

    private static final boolean g(Uri uri) {
        int size;
        boolean z = false;
        if (uri.getPathSegments().size() == 2) {
            String lastPathSegment = uri.getLastPathSegment();
            n.d(lastPathSegment);
            n.e(lastPathSegment, "lastPathSegment!!");
            uri = TextUtils.isDigitsOnly(lastPathSegment) ? 1 : 0;
        }
        return (TextUtils.isDigitsOnly(lastPathSegment) ? 1 : 0);
    }

    private static final boolean h(Uri uri) {
        int size;
        boolean z2 = false;
        boolean z;
        int i = 1;
        if (uri.getPathSegments().size() > i) {
            if (!(n.b(uri.getPathSegments().get(i), "id_nipping_program"))) {
                int i2 = 0;
            }
        }
        return z2;
    }

    private static final boolean i(Uri uri) {
        boolean z2 = false;
        final int i = 1;
        if (uri.getPathSegments().size() == i) {
            if (n.b(uri.getPathSegments().get(0), "inbox")) {
            }
        }
        return z2;
    }

    public static final boolean j(Uri uri) {
        boolean z2 = false;
        n.f(uri, "<this>");
        if (uri.getPathSegments().size() == 2) {
            if (n.b(uri.getPathSegments().get(0), "invite")) {
                int i2 = 1;
            }
        }
        return z2;
    }

    private static final boolean k(Uri uri) {
        int size;
        boolean z = false;
        if (uri.getPathSegments().size() == 2) {
            String lastPathSegment = uri.getLastPathSegment();
            n.d(lastPathSegment);
            n.e(lastPathSegment, "lastPathSegment!!");
            uri = TextUtils.isDigitsOnly(lastPathSegment) ? 1 : 0;
        }
        return (TextUtils.isDigitsOnly(lastPathSegment) ? 1 : 0);
    }

    private static final boolean l(Uri uri) {
        int size;
        boolean z2 = false;
        boolean z;
        int i = 1;
        if (uri.getPathSegments().size() > i) {
            if (!(n.b(uri.getPathSegments().get(i), "id_potty_program"))) {
                int i2 = 0;
            }
        }
        return z2;
    }

    private static final boolean m(Uri uri) {
        int size;
        boolean z3 = false;
        size = 0;
        size = 1;
        int i = 4;
        if (uri.getPathSegments().size() == 4) {
            if (n.b(uri.getPathSegments().get(2), "exams") && lastPathSegment != null) {
                if (l.z(lastPathSegment)) {
                } else {
                }
                if (size == 0) {
                    Object item = uri.getPathSegments().get(size);
                    if (item == null || l.z(item)) {
                    }
                    if (size == 0) {
                    }
                }
            }
        }
        return z3;
    }

    private static final boolean n(Uri uri) {
        boolean z2 = false;
        int i;
        i = 1;
        int i2 = 3;
        if (uri.getPathSegments().size() == 3) {
            if (n.b(uri.getLastPathSegment(), "exams")) {
                Object item = uri.getPathSegments().get(i);
                if (item == null || l.z(item)) {
                }
                if (i == 0) {
                }
            }
        }
        return z2;
    }

    private static final boolean o(Uri uri) {
        int size;
        boolean z2 = true;
        int i2 = 4;
        int i;
        i = 0;
        i2 = 4;
        if (uri.getPathSegments().size() == 4) {
            if (n.b(uri.getPathSegments().get(2), "lessons")) {
                String lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment == null || l.z(lastPathSegment)) {
                }
                if (i != 0) {
                }
            }
        }
        return z2;
    }

    private static final boolean p(Uri uri) {
        boolean z = true;
        int i;
        i = 0;
        if (uri.getPathSegments().size() == 2) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null || l.z(lastPathSegment)) {
            }
            if (i != 0) {
            }
        }
        return z;
    }

    private static final boolean q(Uri uri) {
        int size;
        boolean z2 = false;
        boolean z;
        if (uri.getPathSegments().size() == 2) {
            if (!(n.b(uri.getPathSegments().get(1), "set_reminder"))) {
                int i2 = 0;
            }
        }
        return z2;
    }

    private static final boolean r(Uri uri) {
        boolean z2 = false;
        final int i = 1;
        if (uri.getPathSegments().size() == i) {
            if (n.b(uri.getPathSegments().get(0), "set_reminder")) {
            }
        }
        return z2;
    }

    private static final boolean s(Uri uri) {
        boolean z = false;
        int i;
        i = 1;
        if (uri.getPathSegments().size() == i) {
            String queryParameter = uri.getQueryParameter("link");
            if (queryParameter == null || l.z(queryParameter)) {
            }
            if (i == 0) {
            }
        }
        return z;
    }

    private static final boolean t(Uri uri) {
        boolean z = false;
        int i;
        i = 1;
        if (uri.getPathSegments().size() == i) {
            String queryParameter = uri.getQueryParameter("code");
            if (queryParameter == null || l.z(queryParameter)) {
            }
            if (i != 0) {
            }
        }
        return z;
    }

    private static final boolean u(Uri uri) {
        boolean z = false;
        int i;
        i = 1;
        if (uri.getPathSegments().size() == i) {
            String queryParameter = uri.getQueryParameter("code");
            if (queryParameter == null || l.z(queryParameter)) {
            }
            if (i == 0) {
            }
        }
        return z;
    }

    public static final boolean v(Uri uri, String str) {
        boolean z = false;
        int i;
        n.f(uri, "<this>");
        n.f(str, "currentDogId");
        String switchDog = app.dogo.com.dogo_android.util.extensionfunction.p1.shouldSwitchDog(uri);
        i = 1;
        if (switchDog == null || switchDog.length() == 0) {
        }
        if (i == 0 && !n.b(switchDog, str)) {
        }
        return z;
    }
}
