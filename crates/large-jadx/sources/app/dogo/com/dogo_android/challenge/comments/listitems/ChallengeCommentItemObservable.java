package app.dogo.com.dogo_android.d.b.z;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import app.dogo.com.dogo_android.d.b.y;
import app.dogo.com.dogo_android.d.b.y.a;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.o;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.w2;
import com.google.android.gms.tasks.e;
import com.google.firebase.Timestamp;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.k0.l;

/* compiled from: ChallengeCommentItemObservable.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u00002\u00020\u0001BW\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001a\u0010R\u001a\u00020S2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010T\u001a\u00020/H\u0002J\u0018\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140V2\u0006\u0010W\u001a\u00020\u0014H\u0002J\u0008\u0010X\u001a\u00020\u0014H\u0002J\u0010\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020GH\u0002J\u0010\u0010[\u001a\u00020/2\u0006\u0010Z\u001a\u00020GH\u0002J\u0008\u0010\\\u001a\u00020SH\u0016J\u0006\u0010]\u001a\u00020SJ\u0006\u0010^\u001a\u00020SJ\u0010\u0010_\u001a\u00020S2\u0008\u0010`\u001a\u0004\u0018\u00010\u0014J\u0010\u0010a\u001a\u00020S2\u0006\u0010b\u001a\u00020/H\u0002J\u0006\u0010c\u001a\u00020SR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148G¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u001d\u0010(\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008*\u0010+\u001a\u0004\u0008)\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008-\u0010\u0016R\u0011\u0010.\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008.\u00100R\u0011\u00101\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u00081\u00100R\u0011\u00102\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u00082\u00100R\u001b\u00103\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00084\u0010+\u001a\u0004\u00083\u00100R\u001b\u00105\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00086\u0010+\u001a\u0004\u00085\u00100R\u001b\u00107\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00088\u0010+\u001a\u0004\u00087\u00100R\u001b\u00109\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008:\u0010+\u001a\u0004\u00089\u00100R \u0010<\u001a\u00020/2\u0006\u0010;\u001a\u00020/8G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00100R\u0011\u0010=\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008=\u00100R\u0011\u0010>\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u0008>\u00100R\u0011\u0010?\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u0008?\u00100R\u0011\u0010@\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008A\u00100R\u001a\u0010B\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u00100\"\u0004\u0008D\u0010ER(\u0010H\u001a\u0004\u0018\u00010G2\u0008\u0010F\u001a\u0004\u0018\u00010G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008O\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008Q\u0010\u0016¨\u0006d", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItemObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "resources", "Landroid/content/res/Resources;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;)V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "comment", "getComment", "commentAge", "getCommentAge", "commentText", "Landroid/text/SpannableStringBuilder;", "getCommentText", "()Landroid/text/SpannableStringBuilder;", "commentTextSize", "", "getCommentTextSize", "()F", "deviceLanguage", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "getDogProfile", "()Lapp/dogo/com/dogo_android/model/DogProfileModel;", "entryId", "getEntryId", "entryId$delegate", "Lkotlin/Lazy;", "id", "getId", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isDeleteVisible", "isDeleteVisible$delegate", "isLikeVisible", "isLikeVisible$delegate", "isReplyVisible", "isReplyVisible$delegate", "isReportVisible", "isReportVisible$delegate", "<set-?>", "isSpinnerVisible", "isTranslateButtonVisible", "isUserSignedIn", "isUsersComment", "likeState", "getLikeState", "marked", "getMarked", "setMarked", "(Z)V", "value", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "model", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeComment;", "setModel", "(Lapp/dogo/com/dogo_android/model/ChallengeComment;)V", "parentTag", "translationButtonString", "getTranslationButtonString", "voteCountString", "getVoteCountString", "applyTranslateChanges", "", "state", "getCommentTranslationListener", "Lcom/google/android/gms/tasks/OnCompleteListener;", "commentId", "getDeviceLanguage", "isCurrentAdminAndNotSpam", "commentModel", "isEntryOrCommentAuthor", "notifyModelChange", "onLikeClick", "onTranslateButtonPress", "setParentTag", "tag", "setSpinnerVisibility", "visibilityState", "updateTimeStamp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ChallengeCommentItemObservable extends o {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean authService;
    private ChallengeComment B;
    /* renamed from: C, reason: from kotlin metadata */
    private String cloudFunctionsService;
    private boolean D;
    /* renamed from: E, reason: from kotlin metadata */
    private String commentAge;
    private final h F;
    private final h G;
    /* renamed from: H, reason: from kotlin metadata */
    private final h deviceLanguage;
    private final h I;
    private final h J;
    /* renamed from: a, reason: from kotlin metadata */
    private final m2 firestoreService;
    private final u2 b;
    private final h2 c;
    private final v2 v;
    private final Resources w;
    private final o3 x;
    private final p2 y;
    private final i2 z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<String> {
        @Override // kotlin.d0.d.p
        public final String invoke() {
            ChallengeComment challengeComment = l.this.n();
            n.d(challengeComment);
            return challengeComment.getEntryId();
        }

        a() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<Boolean> {
        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            boolean z = true;
            ChallengeComment challengeComment;
            challengeComment = l.this.n();
            n.d(challengeComment);
            if (l.this.setParentTag(challengeComment)) {
                if (l.this.p()) {
                    challengeComment = l.this.n();
                    n.d(challengeComment);
                    int r0 = l.this.isEntryOrCommentAuthor(challengeComment) ? 1 : 0;
                }
            }
            return (l.this.isEntryOrCommentAuthor(challengeComment) ? 1 : 0);
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<Boolean> {
        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            ChallengeComment challengeComment = l.this.n();
            n.d(challengeComment);
            return !challengeComment.isSpam();
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<Boolean> {
        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            ChallengeComment challengeComment = l.this.n();
            n.d(challengeComment);
            return !challengeComment.isSpam();
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<Boolean> {
        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            boolean z = true;
            if (!l.this.t()) {
                ChallengeComment challengeComment = l.this.n();
                n.d(challengeComment);
                if (!challengeComment.isSpam()) {
                    int r0 = !l.this.p() ? 1 : 0;
                }
            }
            return (!l.this.p() ? 1 : 0);
        }

        e() {
            super(0);
        }
    }
    public /* synthetic */ l(m2 m2Var, u2 u2Var, h2 h2Var, v2 v2Var, Resources resources, o3 o3Var, p2 p2Var, i2 i2Var, int i, g gVar) {
        i2 i2Var82;
        m2 m2Var2;
        u2 u2Var22;
        h2 h2Var32;
        v2 v2Var42;
        Resources resources52;
        o3 o3Var62;
        p2 p2Var72;
        int i92 = i;
        if (i92 & 1 != 0) {
            m2Var2 = App.INSTANCE.j();
        } else {
            m2Var2 = m2Var;
        }
        if (i92 & 2 != 0) {
            u2Var22 = App.INSTANCE.h();
        } else {
            u2Var22 = u2Var;
        }
        if (i92 & 4 != 0) {
            h2Var32 = App.INSTANCE.c();
        } else {
            h2Var32 = h2Var;
        }
        if (i92 & 8 != 0) {
            v2Var42 = App.INSTANCE.t();
        } else {
            v2Var42 = v2Var;
        }
        if (i92 & 16 != 0) {
            str = "appContext.resources";
            n.e(App.INSTANCE.b().getResources(), str);
        } else {
            resources52 = resources;
        }
        if (i92 & 32 != 0) {
            o3Var62 = App.INSTANCE.r();
        } else {
            o3Var62 = o3Var;
        }
        if (i92 & 64 != 0) {
            p2Var72 = App.INSTANCE.l();
        } else {
            p2Var72 = p2Var;
        }
        if (i92 & 128 != 0) {
            i2Var82 = App.INSTANCE.d();
        } else {
            i2Var82 = i2Var;
        }
        this(m2Var2, u2Var22, h2Var32, v2Var42, resources52, o3Var62, p2Var72, i2Var82);
    }

    /* renamed from: F, reason: from kotlin metadata */
    private final void getCommentTranslationListener(boolean commentId) {
        this.D = commentId;
        notifyChange(147);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ boolean applyTranslateChanges(l comment, ChallengeComment state) {
        return comment.isEntryOrCommentAuthor(state);
    }

    public static final /* synthetic */ boolean b(l lVar, ChallengeComment challengeComment) {
        return lVar.setParentTag(challengeComment);
    }

    private final void c(String str, boolean z) {
        n.d(this.B);
        this.B.setTranslatedComment(str);
        notifyChange(40);
        notifyChange(48);
        notifyChange(165);
        n.d(this.B);
        this.B.setTranslatePressed(z);
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final e<String> isCurrentAdminAndNotSpam(String commentModel) {
        return new app.dogo.com.dogo_android.challenge.comments.listitems.g(commentModel, this);
    }

    private static final void j(String str, l lVar, com.google.android.gms.tasks.j jVar) {
        n.f(str, "$commentId");
        n.f(lVar, "this$0");
        n.f(jVar, "task");
        ChallengeComment challengeComment = lVar.n();
        n.d(challengeComment);
        if (n.b(str, challengeComment.getDocumentId())) {
            Object result = jVar.getResult();
            if (result != null) {
                ChallengeComment challengeComment5 = lVar.n();
                n.d(challengeComment5);
                challengeComment5.setEntryTranslations(lVar.getDeviceLanguage(), result);
                lVar.getCommentTranslationListener(false);
                boolean z2 = true;
                lVar.c(result, z2);
            } else {
                ChallengeComment challengeComment2 = lVar.n();
                n.d(challengeComment2);
                String entryId = challengeComment2.getEntryId();
                n.d(entryId);
                ChallengeComment challengeComment3 = lVar.n();
                n.d(challengeComment3);
                String documentId2 = challengeComment3.getDocumentId();
                n.d(documentId2);
                ChallengeComment challengeComment4 = lVar.n();
                n.d(challengeComment4);
                lVar.z.m(lVar.e(), challengeComment4.getLocale(), lVar.y.W(), FirestorePath.commentTranslations.forEntryId(entryId).forCommentId(documentId2).forLocale(lVar.getDeviceLanguage()).getPath()).addOnCompleteListener(new app.dogo.com.dogo_android.challenge.comments.listitems.h(str, lVar));
            }
        }
    }

    private static final void k(String str, l lVar, com.google.android.gms.tasks.j jVar) {
        n.f(str, "$commentId");
        n.f(lVar, "this$0");
        n.f(jVar, "task1");
        if (jVar.isSuccessful()) {
            ChallengeComment challengeComment = lVar.n();
            n.d(challengeComment);
            if (n.b(str, challengeComment.getDocumentId())) {
                lVar.getCommentTranslationListener(false);
                boolean z2 = true;
                lVar.c((String)jVar.getResult(), z2);
            }
        }
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final String getDeviceLanguage() {
        String language = Locale.forLanguageTag(this.commentAge).getLanguage();
        n.e(language, "it");
        this.commentAge = language;
        n.e(language, "forLanguageTag(deviceLanguage).language.also { deviceLanguage = it }");
        return language;
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean isEntryOrCommentAuthor(ChallengeComment commentModel) {
        boolean z2 = false;
        commentModel = this.c.C() && !commentModel.isSpam() ? 1 : 0;
        return (this.c.C() && !commentModel.isSpam() ? 1 : 0);
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final boolean setParentTag(ChallengeComment tag) {
        boolean z;
        boolean z2 = false;
        if (!n.b(tag.getUserId(), this.c.v())) {
            if (tag.isEntryAuthor(this.c.v())) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void B() {
        int i;
        String str2;
        app.dogo.com.dogo_android.model.DogProfileModel model;
        String str3;
        String challengeId;
        r2 eP_ViewSource;
        y commentSourceParser;
        String cloudFunctionsService2;
        n.d(this.B);
        if (!n.b(this.B.getUserId(), this.c.v())) {
            n.d(this.B);
            boolean z2 = true;
            if (!this.B.isHasUserLiked()) {
                n.d(this.B);
                n.d(this.B);
                this.x.logEvent(E_Challenges.g.c(new EP_EntryId(), this.B.getDocumentId(), new EP_ChallengeId(), this.B.getChallengeId(), new EP_ViewSource(), CommentSource.INSTANCE.commentSourceParser(this.cloudFunctionsService)));
                n.d(this.B);
                this.firestoreService.fetchUserEntries(this.B, this.c.v(), this.b.getUserAndDogCache().g().toModel(this.c.v()));
                n.d(this.B);
                this.B.setHasUserLiked(z2);
                n.d(this.B);
                n.d(this.B);
                i = this.B.getVotes() + z2;
                this.B.setVotes(i);
            } else {
                n.d(this.B);
                this.firestoreService.z0(this.B, this.c.v());
                n.d(this.B);
                this.B.setHasUserLiked(false);
                n.d(this.B);
                n.d(this.B);
                i = this.B.getVotes() - z2;
                this.B.setVotes(i);
            }
            notifyChange(101);
            notifyChange(185);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: C, reason: from kotlin metadata */
    public final void setSpinnerVisibility(boolean visibilityState) {
        this.authService = visibilityState;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void D(ChallengeComment challengeComment) {
        this.B = challengeComment;
        this.D = false;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void E(String str) {
        this.cloudFunctionsService = str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void G() {
        notifyChange(41);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String d() {
        String dogAvatarUrl = null;
        if (this.B != null) {
            n.d(this.B);
            dogAvatarUrl = this.B.getDogAvatarUrl();
        } else {
            int i = 0;
        }
        return dogAvatarUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String e() {
        String translatedComment2;
        int i = 0;
        ChallengeComment challengeComment;
        n.d(this.B);
        translatedComment2 = "";
        if (this.B.getTranslatedComment() != null) {
            n.d(this.B);
            if (this.B.isTranslatePressed()) {
                n.d(this.B);
                if (this.B.getTranslatedComment() != null) {
                }
            }
        }
        return translatedComment2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String f() {
        String str;
        n.d(this.B);
        Timestamp date = this.B.getDate();
        final int i2 = 0;
        final boolean z = true;
        if (date != null) {
            l2 = (long)1000;
            l = date.getSeconds() * l2;
            str = this.v.j(l, z, false);
        } else {
            str = this.v.j(this.v.g(), z, false);
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final SpannableStringBuilder g() throws android.content.res.Resources.NotFoundException {
        String dogName;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        int color = 1;
        final Object obj2 = this;
        if (obj2.B == null) {
            spannableStringBuilder = new SpannableStringBuilder();
        } else {
            n.d(obj2.B);
            dogName = obj2.B.getDogName();
            n.d(obj2.B);
            int length2 = 2131100378;
            str2 = "  ";
            String str7 = "resources.getString(R.string.general_anonymous)";
            int i10 = 2131886675;
            android.content.res.Resources.Theme theme = null;
            color = 1;
            color = 0;
            int i = 33;
            if (obj2.B.isSpam()) {
                if (dogName == null) {
                    n.e(obj2.w.getString(i10), str7);
                }
                String str3 = n.o(dogName, str2);
                String string = obj2.w.getString(2131887329);
                n.e(string, "resources.getString(R.string.social_comments_spam_message2)");
                Object[] arr = new Object[color];
                String string2 = obj2.w.getString(2131887328, new Object[] { string });
                n.e(string2, "resources.getString(R.string.social_comments_spam_message1, communityRuleText)");
                String str6 = n.o(str3, string2);
                int i3 = 0;
                boolean z = false;
                int i4 = 6;
                Object obj = null;
                int length3 = l.e0(str6, string, i3, z, i4, obj);
                length = string.length() + length3;
                spannableStringBuilder = new SpannableStringBuilder(str6);
                spannableStringBuilder.setSpan(new StyleSpan(color), color, str3.length(), i);
                int i2 = 2131099834;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(obj2.w.getColor(i2, theme)), str3.length(), str6.length(), i);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(obj2.w.getColor(length2, theme)), length3, length, i);
            } else {
                if (dogName == null) {
                    n.e(obj2.w.getString(i10), str7);
                }
                String str4 = n.o(dogName, str2);
                n.d(obj2.B);
                if (obj2.B.getReplyTagName() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    n.d(obj2.B);
                    String replyTagName2 = obj2.B.getReplyTagName();
                    char c = ' ';
                    str = 64 + replyTagName2 + c;
                } else {
                    str = "";
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                String str9 = e();
                r4 = str4 + str + str9;
                spannableStringBuilder = new SpannableStringBuilder(r4);
                spannableStringBuilder.setSpan(new StyleSpan(color), color, str4.length(), i);
                i2 = 2131165293;
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(a.b(obj2.w.getDimension(i2))), color, str4.length(), i);
                if (str.length() <= 0) {
                }
                if (color != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(obj2.w.getColor(length2, theme)), str4.length(), str4.length() + str.length(), i);
                }
            }
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean getLikeState() {
        boolean z = false;
        n.d(this.B);
        if (!n.b(this.B.getUserId(), this.c.v())) {
            n.d(this.B);
            if (this.B.isHasUserLiked()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getTranslationButtonString() throws android.content.res.Resources.NotFoundException {
        String string;
        n.d(this.B);
        if (this.B.isTranslatePressed()) {
            str = "{\n            resources.getString(R.string.challenge_original)\n        }";
            n.e(this.w.getString(2131886301), str);
        } else {
            str = "{\n            resources.getString(R.string.challenge_translate)\n        }";
            n.e(this.w.getString(2131886326), str);
        }
        return string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final float h() throws android.content.res.Resources.NotFoundException {
        Resources resources;
        int i = 2131165878;
        n.d(this.B);
        String message = this.B.getMessage();
        n.d(message);
        i = this.v.isPackageInstalled(message) ? R.dimen.normal_text_size : R.dimen.card_tiny_text;
        return resources.getDimension(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isSpinnerVisible() {
        return this.D;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isTranslateButtonVisible() {
        boolean z = true;
        String locale;
        n.d(this.B);
        if (!this.B.isSpam()) {
            n.d(this.B);
            if (!n.b(LocaleService.getLocale(this.y.W()), this.B.getLocale())) {
                n.d(this.B);
                if (!n.b(this.B.getUserId(), this.c.v())) {
                    int r0 = !this.v.isPackageInstalled(e()) ? 1 : 0;
                }
            }
        }
        return (!this.v.isPackageInstalled(e()) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean m() {
        return this.authService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final ChallengeComment n() {
        return this.B;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String o() {
        n.d(this.B);
        return n.o("", Integer.valueOf(this.B.getVotes()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void onTranslateButtonPress() {
        n.d(this.B);
        String documentId = this.B.getDocumentId();
        n.d(this.B);
        boolean z2 = false;
        if (this.B.isTranslatePressed()) {
            c(e(), z2);
        } else {
            boolean z = true;
            getCommentTranslationListener(z);
            n.d(this.B);
            if (this.B.getEntryTranslations().containsKey(getDeviceLanguage())) {
                getCommentTranslationListener(z2);
                n.d(this.B);
                c((String)this.B.getEntryTranslations().get(getDeviceLanguage()), z);
            } else {
                n.d(this.B);
                String entryId = this.B.getEntryId();
                n.d(entryId);
                n.d(this.B);
                String documentId2 = this.B.getDocumentId();
                n.d(documentId2);
                n.d(documentId);
                this.firestoreService.w(FirestorePath.commentTranslations.forEntryId(entryId).forCommentId(documentId2).forLocale(getDeviceLanguage())).addOnCompleteListener(isCurrentAdminAndNotSpam(documentId));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean p() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.B != null) {
            if (this.B.isAuthorAdmin()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean q() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.B != null) {
            if (this.B.isAuthorAmbassador()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean r() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.B != null) {
            if (this.B.isAuthorPremium()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean t() {
        return (Boolean)this.F.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean v() {
        return (Boolean)this.I.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean w() {
        return (Boolean)this.deviceLanguage.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean x() {
        return (Boolean)this.G.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean y() {
        boolean z2 = false;
        String str;
        n.d(this.B);
        if (this.B.getUserId() != null) {
            n.d(this.B);
            int r0 = n.b(this.B.getUserId(), this.c.v()) ? 1 : 0;
        }
        return (n.b(this.B.getUserId(), this.c.v()) ? 1 : 0);
    }

    public l(m2 m2Var, u2 u2Var, h2 h2Var, v2 v2Var, Resources resources, o3 o3Var, p2 p2Var, i2 i2Var) {
        n.f(m2Var, "firestoreService");
        n.f(u2Var, "userLocalCacheService");
        n.f(h2Var, "authService");
        n.f(v2Var, "utilities");
        n.f(resources, "resources");
        n.f(o3Var, "tracker");
        n.f(p2Var, "preferenceService");
        n.f(i2Var, "cloudFunctionsService");
        super();
        this.firestoreService = m2Var;
        this.b = u2Var;
        this.c = h2Var;
        this.v = v2Var;
        this.w = resources;
        this.x = o3Var;
        this.y = p2Var;
        this.z = i2Var;
        this.F = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.l.b(this));
        this.G = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.l.e(this));
        this.deviceLanguage = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.l.d(this));
        this.I = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.l.c(this));
        this.J = j.b(new app.dogo.com.dogo_android.challenge.comments.listitems.l.a(this));
        this.commentAge = p2Var.W();
    }


    public l() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ void A(String str, l lVar, com.google.android.gms.tasks.j jVar) {
        ChallengeCommentItemObservable.k(str, lVar, jVar);
    }

    public static /* synthetic */ void z(String str, l lVar, com.google.android.gms.tasks.j jVar) {
        ChallengeCommentItemObservable.j(str, lVar, jVar);
    }
}
