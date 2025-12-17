package app.dogo.com.dogo_android.util.h0;

import android.net.Uri;
import android.text.TextUtils;
import app.dogo.com.dogo_android.inbox.b;
import app.dogo.com.dogo_android.n.i;
import app.dogo.com.dogo_android.n.k.l;
import app.dogo.com.dogo_android.n.k.p;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.n.m.q;
import app.dogo.com.dogo_android.n.m.u.m;
import app.dogo.com.dogo_android.q.p.y;
import app.dogo.com.dogo_android.q.s.d;
import app.dogo.com.dogo_android.r.n;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.s.b.i1.b;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.t.i0.a;
import app.dogo.com.dogo_android.t.i0.b;
import app.dogo.com.dogo_android.t.i0.c;
import app.dogo.com.dogo_android.u.m.o;
import app.dogo.com.dogo_android.u.n.m;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.view.o;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.o.s;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.w.n;
import app.dogo.com.dogo_android.y.y.g;
import com.coremedia.iso.boxes.MovieBox;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0013\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e*\u00020 \u001a\n\u0010!\u001a\u00020\u0001*\u00020 \u001a\n\u0010\"\u001a\u00020\u0001*\u00020 \u001a\u000c\u0010#\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010%\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010&\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010'\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010(\u001a\u00020$*\u00020 H\u0002\u001a\n\u0010)\u001a\u00020$*\u00020 \u001a\u000c\u0010*\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010+\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010,\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010-\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010.\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u0010/\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00100\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00101\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00102\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00103\u001a\u00020$*\u00020 H\u0002\u001a\u000c\u00104\u001a\u00020$*\u00020 H\u0002\u001a\u0012\u00105\u001a\u00020$*\u00020 2\u0006\u00106\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00067", d2 = {"ADD_LOG_SEGMENT", "", "ADD_PARENT_SEGMENT", "ARTICLES_SEGMENT", "CALENDAR_SEGMENT", "CATEGORY_SEGMENT", "CERTIFICATE_SEGMENT", "CODE_PARAMETER", "CONTACT_US", "DOG_ID_PARAMETER", "EXAM_SEGMENT", "INBOX_SEGMENT", "INVITE_SEGMENT", "KNOWLEDGE_BASE_SEGMENT", "LESSONS_SEGMENT", "LIBRARY_SEGMENT", "LINK_PARAMETER", "POTTY_SEGMENT", "PROFILE_SEGMENT", "PROGRAMS_SEGMENT", "SET_REMINDER_SEGMENT", "SHARE_DIALOG", "SUBSCRIPTION", "TAG_SEGMENT", "TRICKS_SEGMENT", "ZENDESK_SEGMENT", "getEmptyProgramSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "programId", "getAppScreenWithHistory", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroid/net/Uri;", "getDogId", "getInviteId", "isAddNewParentLink", "", "isAddPottyLogLink", "isArticleId", "isBitingProgram", "isInboxLink", "isInvite", "isMessageId", "isPottyProgram", "isProgramExamId", "isProgramExams", "isProgramLessonId", "isSecondPathId", "isSetPottyReminderLink", "isSetTrainingReminderLink", "isSharableLink", "isSubscription", "isSubscriptionCoupon", "shouldSwitchDog", "currentDogId", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class p1 {
    public static final List<j> a(Uri uri) {
        List list;
        Object equals;
        Object z2;
        boolean subscriptionBenefitsScreen;
        double d;
        String trickCategory2;
        int programExamSummary;
        long trickCategory;
        String queryParameter;
        String str;
        String str3;
        Boolean bool;
        int i2;
        int i21;
        int i6;
        int i;
        int lastPathSegment3;
        String lastPathSegment2;
        int lastPathSegment;
        int i12;
        int str2;
        int i11;
        int i19;
        int i13;
        boolean z;
        int i8;
        int i18;
        int i20;
        int i9;
        int i14;
        int i4;
        int i15;
        int i16;
        int i10;
        int i5;
        int i17;
        int i7;
        int i3;
        equals = uri;
        n.f(equals, "<this>");
        List pathSegments4 = uri.getPathSegments();
        n.e(pathSegments4, "pathSegments");
        subscriptionBenefitsScreen = p.Z(pathSegments4);
        if ((String)subscriptionBenefitsScreen != null) {
            programExamSummary = 3;
            trickCategory = "library";
            queryParameter = "tag";
            str = "lastPathSegment!!";
            str3 = "";
            bool = 0;
            i2 = 2;
            i21 = 1;
            i6 = 0;
            switch (subscriptionBenefitsScreen) {
                case "articles":
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar16 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar16;
                    lastPathSegment3 = uri.getLastPathSegment();
                    n.d(lastPathSegment3);
                    n.e(lastPathSegment3, str);
                    super(0, lastPathSegment3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4093, 0);
                    trickCategory2 = new l(programExamSummary, trickCategory, bool);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar15 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar15;
                    String queryParameter6 = equals.getQueryParameter(queryParameter);
                    n.d(queryParameter6);
                    trickCategory2 = new p(queryParameter6);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    j[] arr6 = new j[i2];
                    i iVar7 = new i(i6, i21, i6);
                    arr6[bool] = iVar7;
                    subscriptionBenefitsScreen = new p(i6, i21, i6);
                    arr6[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr6);
                    list = p.g();
                    break;
                case "programs":
                    j[] arr4 = new j[i2];
                    i iVar5 = new i(i6, i21, i6);
                    arr4[bool] = iVar5;
                    subscriptionBenefitsScreen = new m(str3);
                    arr4[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr4);
                    j[] arr3 = new j[i2];
                    i iVar4 = new i(i6, i21, i6);
                    arr3[bool] = iVar4;
                    subscriptionBenefitsScreen = new o(str3);
                    arr3[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr3);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar12 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar12;
                    lastPathSegment2 = uri.getLastPathSegment();
                    n.d(lastPathSegment2);
                    n.e(lastPathSegment2, str);
                    super(0, lastPathSegment2, 0, 0, "", 13, 0);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar11 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar11;
                    lastPathSegment3 = uri.getLastPathSegment();
                    n.d(lastPathSegment3);
                    Object obj4 = uri.getPathSegments().get(i21);
                    n.d(obj4);
                    super(lastPathSegment3, (String)obj4, "", 0, 0, 24, 0);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar10 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar10;
                    Object obj3 = uri.getPathSegments().get(i21);
                    n.d(obj3);
                    super(p1.c((String)obj3), "", "", 0, 8, 0);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar9 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar9;
                    programExamSummary = uri.getPathSegments().get(i21);
                    n.d(programExamSummary);
                    lastPathSegment = uri.getLastPathSegment();
                    n.d(lastPathSegment);
                    n.e(lastPathSegment, str);
                    super(p1.c((String)programExamSummary), "", lastPathSegment, 0, 0, 16, 0);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar8 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar8;
                    Object obj2 = uri.getPathSegments().get(i21);
                    n.e(obj2, "pathSegments[1]");
                    i12 = 0;
                    i11 = 0;
                    super(p1.c((String)obj2), 0, 0, 0, i12, 0, i11, 0, 0, 0, 1022, 0);
                    super(programExamSummary, "", "", i12, 8, i11);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    j[] arr2 = new j[i2];
                    i iVar3 = new i(i6, i21, i6);
                    arr2[bool] = iVar3;
                    subscriptionBenefitsScreen = new g(i6, bool, programExamSummary, i6);
                    arr2[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr2);
                    list = p.g();
                    break;
                case "set_reminder":
                    n nVar = new n("deeplink", i6, i2, i6);
                    list = p.b(nVar);
                    list = p.g();
                    list = p.g();
                    break;
                case "tricks":
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar14 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar14;
                    String lastPathSegment6 = uri.getLastPathSegment();
                    n.d(lastPathSegment6);
                    n.e(lastPathSegment6, str);
                    super(lastPathSegment6, 0, 0, 0, 0, 0, 0, 0, 0, obj21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048574, 0);
                    programExamSummary = new n.a(queryParameter);
                    trickCategory2 = new m(programExamSummary, str3, str3, trickCategory);
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    String str9 = "category";
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar17 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar17;
                    String queryParameter3 = equals.getQueryParameter(str9);
                    n.d(queryParameter3);
                    n.e(queryParameter3, "getQueryParameter(CATEGORY_SEGMENT)!!");
                    trickCategory = new TrickItem.TrickCategory(queryParameter3, i6, i2, i6);
                    programExamSummary = new q(trickCategory, i6, i2, i6);
                    subscriptionBenefitsScreen[i21] = programExamSummary;
                    list = p.j(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new j[i2];
                    i iVar13 = new i(i6, i21, i6);
                    subscriptionBenefitsScreen[bool] = iVar13;
                    trickCategory = new TrickItem.TrickCategory(i6, i6, programExamSummary, i6);
                    trickCategory2 = new q(trickCategory, equals.getQueryParameter(queryParameter));
                    subscriptionBenefitsScreen[i21] = trickCategory2;
                    list = p.j(subscriptionBenefitsScreen);
                    j[] arr5 = new j[i2];
                    i iVar6 = new i(i6, i21, i6);
                    arr5[bool] = iVar6;
                    trickCategory2 = new TrickItem.TrickCategory("id_tricks", i6, i2, i6);
                    subscriptionBenefitsScreen = new q(trickCategory2, i6, i2, i6);
                    arr5[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr5);
                    list = p.g();
                    break;
                case "share_dialog":
                    String queryParameter2 = equals.getQueryParameter("link");
                    n.d(queryParameter2);
                    n.e(queryParameter2, "getQueryParameter(LINK_PARAMETER)!!");
                    subscriptionBenefitsScreen = new o(queryParameter2);
                    list = p.b(subscriptionBenefitsScreen);
                    list = p.g();
                    list = p.g();
                    break;
                case "zendesk":
                    String lastPathSegment4 = uri.getLastPathSegment();
                    n.d(lastPathSegment4);
                    n.e(lastPathSegment4, str);
                    subscriptionBenefitsScreen = new c(lastPathSegment4);
                    list = p.b(subscriptionBenefitsScreen);
                    list = p.g();
                    list = p.g();
                    break;
                case "profile":
                    j[] arr = new j[i2];
                    y yVar = new y(bool, i6, programExamSummary, i6);
                    arr[bool] = yVar;
                    super(0, 0, "", 0, 0, 0, 0, 0, 0, 0, 1019, 0);
                    subscriptionBenefitsScreen = new d(trickCategory2);
                    arr[i21] = subscriptionBenefitsScreen;
                    list = p.j(arr);
                    list = p.g();
                    list = p.g();
                    break;
                case "calendar":
                    i iVar2 = new i(str3, str3);
                    list = p.b(iVar2);
                    list = p.g();
                    break;
                case "knowledgebase":
                    String lastPathSegment5 = uri.getLastPathSegment();
                    n.d(lastPathSegment5);
                    n.e(lastPathSegment5, str);
                    subscriptionBenefitsScreen = new b(Long.parseLong(lastPathSegment5), programExamSummary);
                    list = p.b(subscriptionBenefitsScreen);
                    list = p.g();
                    list = p.g();
                    break;
                case "inbox":
                    super("", "", 0, 0, 12, 0);
                    list = p.b(bVar);
                    list = p.g();
                    list = p.g();
                    break;
                case "potty":
                    k kVar = new k(i6, i21, i6);
                    list = p.b(kVar);
                    super("", 0, 0, 0, 0, 30, 0);
                    list = p.b(hVar);
                    list = p.g();
                    list = p.g();
                    break;
                case "contact_us":
                    subscriptionBenefitsScreen = new a(equals.getQueryParameter("campaign"));
                    list = p.b(subscriptionBenefitsScreen);
                    list = p.g();
                    break;
                case "library":
                    i iVar = new i(i6, i21, i6);
                    list = p.b(iVar);
                    list = p.g();
                    break;
                case "subscription":
                    queryParameter = equals.getQueryParameter("code");
                    n.d(queryParameter);
                    n.e(queryParameter, "getQueryParameter(\"code\")!!");
                    trickCategory2 = new DogProfile("", "", queryParameter, 0, 0, 0, 56, 0);
                    list = p.b(subscriptionBenefitsScreen);
                    subscriptionBenefitsScreen = new SubscriptionBenefitsScreen("", "", 0, 0, 0, 0, 60, 0);
                    list = p.b(subscriptionBenefitsScreen2);
                    list = p.g();
                    list = p.g();
                    break;
                default:
                    list = p.g();
            }
        } else {
        }
        return list;
    }

    public static final String b(Uri uri) {
        String obj1;
        n.f(uri, "<this>");
        if (uri.getQueryParameter("dog") == null) {
            obj1 = "";
        }
        return obj1;
    }

    private static final ProgramSaveInfo c(String string) {
        final String str = "";
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(string, str, str, str);
        return programSaveInfo;
    }

    public static final String d(Uri uri) {
        n.f(uri, "<this>");
        Object obj1 = uri.getPathSegments().get(1);
        n.e(obj1, "pathSegments[1]");
        return (String)obj1;
    }

    private static final boolean e(Uri uri) {
        int size;
        int i;
        boolean obj3;
        if (uri.getPathSegments().size() == 2 && n.b(uri.getPathSegments().get(1), "add_parent")) {
            if (n.b(uri.getPathSegments().get(i), "add_parent")) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean f(Uri uri) {
        int size;
        int i;
        boolean obj3;
        if (uri.getPathSegments().size() == 2 && n.b(uri.getPathSegments().get(1), "add_log")) {
            if (n.b(uri.getPathSegments().get(i), "add_log")) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean g(Uri uri) {
        int size;
        boolean obj2;
        obj2 = uri.getLastPathSegment();
        n.d(obj2);
        n.e(obj2, "lastPathSegment!!");
        if (uri.getPathSegments().size() == 2 && TextUtils.isDigitsOnly(obj2)) {
            obj2 = uri.getLastPathSegment();
            n.d(obj2);
            n.e(obj2, "lastPathSegment!!");
            obj2 = TextUtils.isDigitsOnly(obj2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static final boolean h(Uri uri) {
        int size;
        int i;
        boolean obj2;
        i = 1;
        if (uri.getPathSegments().size() > i && n.b(uri.getPathSegments().get(i), "id_nipping_program")) {
            if (n.b(uri.getPathSegments().get(i), "id_nipping_program")) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean i(Uri uri) {
        int size;
        int i;
        boolean obj3;
        final int i2 = 1;
        if (uri.getPathSegments().size() == i2 && n.b(uri.getPathSegments().get(0), "inbox")) {
            if (n.b(uri.getPathSegments().get(i), "inbox")) {
                i = i2;
            }
        }
        return i;
    }

    public static final boolean j(Uri uri) {
        int size;
        int i;
        Object obj3;
        n.f(uri, "<this>");
        if (uri.getPathSegments().size() == 2 && n.b(uri.getPathSegments().get(0), "invite")) {
            if (n.b(uri.getPathSegments().get(i), "invite")) {
                i = 1;
            }
        }
        return i;
    }

    private static final boolean k(Uri uri) {
        int size;
        boolean obj2;
        obj2 = uri.getLastPathSegment();
        n.d(obj2);
        n.e(obj2, "lastPathSegment!!");
        if (uri.getPathSegments().size() == 2 && TextUtils.isDigitsOnly(obj2)) {
            obj2 = uri.getLastPathSegment();
            n.d(obj2);
            n.e(obj2, "lastPathSegment!!");
            obj2 = TextUtils.isDigitsOnly(obj2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static final boolean l(Uri uri) {
        int size;
        int i;
        boolean obj2;
        i = 1;
        if (uri.getPathSegments().size() > i && n.b(uri.getPathSegments().get(i), "id_potty_program")) {
            if (n.b(uri.getPathSegments().get(i), "id_potty_program")) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean m(Uri uri) {
        String lastPathSegment;
        int size;
        int i;
        int str;
        Object obj4;
        i = 0;
        final int i2 = 1;
        if (uri.getPathSegments().size() == 4 && n.b(uri.getPathSegments().get(2), "exams")) {
            if (n.b(uri.getPathSegments().get(2), "exams")) {
                lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    if (l.z(lastPathSegment)) {
                        size = i2;
                    } else {
                        size = i;
                    }
                } else {
                }
                if (size == 0) {
                    obj4 = uri.getPathSegments().get(i2);
                    if ((CharSequence)obj4 != null) {
                        if (l.z((CharSequence)obj4)) {
                            obj4 = i2;
                        } else {
                            obj4 = i;
                        }
                    } else {
                    }
                    if (obj4 == null) {
                        i = i2;
                    }
                }
            }
        }
        return i;
    }

    private static final boolean n(Uri uri) {
        int size;
        int i;
        int str;
        int obj4;
        final int i2 = 1;
        if (uri.getPathSegments().size() == 3 && n.b(uri.getLastPathSegment(), "exams")) {
            if (n.b(uri.getLastPathSegment(), "exams")) {
                obj4 = uri.getPathSegments().get(i2);
                if ((CharSequence)obj4 != null) {
                    if (l.z((CharSequence)obj4)) {
                        obj4 = i2;
                    } else {
                        obj4 = i;
                    }
                } else {
                }
                if (obj4 == null) {
                    i = i2;
                }
            }
        }
        return i;
    }

    private static final boolean o(Uri uri) {
        int size;
        int i;
        int str;
        int obj4;
        final int i2 = 0;
        if (uri.getPathSegments().size() == 4 && n.b(uri.getPathSegments().get(2), "lessons")) {
            if (n.b(uri.getPathSegments().get(2), "lessons")) {
                obj4 = uri.getLastPathSegment();
                if (obj4 != null) {
                    if (l.z(obj4)) {
                        obj4 = i;
                    } else {
                        obj4 = i2;
                    }
                } else {
                }
                if (obj4 == null) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean p(Uri uri) {
        int i;
        int obj4;
        final int i2 = 0;
        if (uri.getPathSegments().size() == 2) {
            obj4 = uri.getLastPathSegment();
            if (obj4 != null) {
                if (l.z(obj4)) {
                    obj4 = i;
                } else {
                    obj4 = i2;
                }
            } else {
            }
            if (obj4 == null) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    private static final boolean q(Uri uri) {
        int size;
        int i;
        boolean obj3;
        if (uri.getPathSegments().size() == 2 && n.b(uri.getPathSegments().get(1), "set_reminder")) {
            if (n.b(uri.getPathSegments().get(i), "set_reminder")) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean r(Uri uri) {
        int size;
        int i;
        boolean obj3;
        final int i2 = 1;
        if (uri.getPathSegments().size() == i2 && n.b(uri.getPathSegments().get(0), "set_reminder")) {
            if (n.b(uri.getPathSegments().get(i), "set_reminder")) {
                i = i2;
            }
        }
        return i;
    }

    private static final boolean s(Uri uri) {
        int size;
        int i;
        int obj3;
        final int i2 = 1;
        if (uri.getPathSegments().size() == i2) {
            obj3 = uri.getQueryParameter("link");
            if (obj3 != null) {
                if (l.z(obj3)) {
                    obj3 = i2;
                } else {
                    obj3 = i;
                }
            } else {
            }
            if (obj3 == null) {
                i = i2;
            }
        }
        return i;
    }

    private static final boolean t(Uri uri) {
        int size;
        int i;
        int obj3;
        final int i2 = 1;
        if (uri.getPathSegments().size() == i2) {
            obj3 = uri.getQueryParameter("code");
            if (obj3 != null) {
                if (l.z(obj3)) {
                    obj3 = i2;
                } else {
                    obj3 = i;
                }
            } else {
            }
            if (obj3 != null) {
                i = i2;
            }
        }
        return i;
    }

    private static final boolean u(Uri uri) {
        int size;
        int i;
        int obj3;
        final int i2 = 1;
        if (uri.getPathSegments().size() == i2) {
            obj3 = uri.getQueryParameter("code");
            if (obj3 != null) {
                if (l.z(obj3)) {
                    obj3 = i2;
                } else {
                    obj3 = i;
                }
            } else {
            }
            if (obj3 == null) {
                i = i2;
            }
        }
        return i;
    }

    public static final boolean v(Uri uri, String string2) {
        int i;
        int i2;
        int length;
        String obj3;
        n.f(uri, "<this>");
        n.f(string2, "currentDogId");
        obj3 = p1.b(uri);
        final int i3 = 1;
        if (obj3 != null) {
            if (obj3.length() == 0) {
                i2 = i3;
            } else {
                i2 = i;
            }
        } else {
        }
        if (i2 == 0 && !n.b(obj3, string2)) {
            if (!n.b(obj3, string2)) {
                i = i3;
            }
        }
        return i;
    }
}
