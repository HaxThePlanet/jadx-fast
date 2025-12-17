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
import com.google.android.gms.tasks.j;
import com.google.firebase.Timestamp;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.e0.a;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u00002\u00020\u0001BW\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001a\u0010R\u001a\u00020S2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010T\u001a\u00020/H\u0002J\u0018\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140V2\u0006\u0010W\u001a\u00020\u0014H\u0002J\u0008\u0010X\u001a\u00020\u0014H\u0002J\u0010\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020GH\u0002J\u0010\u0010[\u001a\u00020/2\u0006\u0010Z\u001a\u00020GH\u0002J\u0008\u0010\\\u001a\u00020SH\u0016J\u0006\u0010]\u001a\u00020SJ\u0006\u0010^\u001a\u00020SJ\u0010\u0010_\u001a\u00020S2\u0008\u0010`\u001a\u0004\u0018\u00010\u0014J\u0010\u0010a\u001a\u00020S2\u0006\u0010b\u001a\u00020/H\u0002J\u0006\u0010c\u001a\u00020SR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148G¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u001d\u0010(\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008*\u0010+\u001a\u0004\u0008)\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u0008-\u0010\u0016R\u0011\u0010.\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008.\u00100R\u0011\u00101\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u00081\u00100R\u0011\u00102\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u00082\u00100R\u001b\u00103\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00084\u0010+\u001a\u0004\u00083\u00100R\u001b\u00105\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00086\u0010+\u001a\u0004\u00085\u00100R\u001b\u00107\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u00088\u0010+\u001a\u0004\u00087\u00100R\u001b\u00109\u001a\u00020/8GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008:\u0010+\u001a\u0004\u00089\u00100R \u0010<\u001a\u00020/2\u0006\u0010;\u001a\u00020/8G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00100R\u0011\u0010=\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008=\u00100R\u0011\u0010>\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u0008>\u00100R\u0011\u0010?\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\u0008?\u00100R\u0011\u0010@\u001a\u00020/8G¢\u0006\u0006\u001a\u0004\u0008A\u00100R\u001a\u0010B\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u00100\"\u0004\u0008D\u0010ER(\u0010H\u001a\u0004\u0018\u00010G2\u0008\u0010F\u001a\u0004\u0018\u00010G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008O\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\u0008Q\u0010\u0016¨\u0006d", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentItemObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "resources", "Landroid/content/res/Resources;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;)V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "comment", "getComment", "commentAge", "getCommentAge", "commentText", "Landroid/text/SpannableStringBuilder;", "getCommentText", "()Landroid/text/SpannableStringBuilder;", "commentTextSize", "", "getCommentTextSize", "()F", "deviceLanguage", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "getDogProfile", "()Lapp/dogo/com/dogo_android/model/DogProfileModel;", "entryId", "getEntryId", "entryId$delegate", "Lkotlin/Lazy;", "id", "getId", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isDeleteVisible", "isDeleteVisible$delegate", "isLikeVisible", "isLikeVisible$delegate", "isReplyVisible", "isReplyVisible$delegate", "isReportVisible", "isReportVisible$delegate", "<set-?>", "isSpinnerVisible", "isTranslateButtonVisible", "isUserSignedIn", "isUsersComment", "likeState", "getLikeState", "marked", "getMarked", "setMarked", "(Z)V", "value", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "model", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeComment;", "setModel", "(Lapp/dogo/com/dogo_android/model/ChallengeComment;)V", "parentTag", "translationButtonString", "getTranslationButtonString", "voteCountString", "getVoteCountString", "applyTranslateChanges", "", "state", "getCommentTranslationListener", "Lcom/google/android/gms/tasks/OnCompleteListener;", "commentId", "getDeviceLanguage", "isCurrentAdminAndNotSpam", "commentModel", "isEntryOrCommentAuthor", "notifyModelChange", "onLikeClick", "onTranslateButtonPress", "setParentTag", "tag", "setSpinnerVisibility", "visibilityState", "updateTimeStamp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends o {

    private boolean A;
    private ChallengeComment B;
    private String C;
    private boolean D;
    private String E;
    private final h F;
    private final h G;
    private final h H;
    private final h I;
    private final h J;
    private final m2 a;
    private final u2 b;
    private final h2 c;
    private final v2 v;
    private final Resources w;
    private final o3 x;
    private final p2 y;
    private final i2 z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<String> {

        final app.dogo.com.dogo_android.d.b.z.l this$0;
        a(app.dogo.com.dogo_android.d.b.z.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            ChallengeComment challengeComment = this.this$0.n();
            n.d(challengeComment);
            return challengeComment.getEntryId();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<Boolean> {

        final app.dogo.com.dogo_android.d.b.z.l this$0;
        b(app.dogo.com.dogo_android.d.b.z.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            boolean z;
            int i;
            ChallengeComment challengeComment;
            app.dogo.com.dogo_android.d.b.z.l this$0 = this.this$0;
            challengeComment = this$0.n();
            n.d(challengeComment);
            if (l.b(this$0, challengeComment)) {
                if (this.this$0.p()) {
                    app.dogo.com.dogo_android.d.b.z.l this$03 = this.this$0;
                    challengeComment = this$03.n();
                    n.d(challengeComment);
                    i = l.a(this$03, challengeComment) ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<Boolean> {

        final app.dogo.com.dogo_android.d.b.z.l this$0;
        c(app.dogo.com.dogo_android.d.b.z.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            ChallengeComment challengeComment = this.this$0.n();
            n.d(challengeComment);
            return spam ^= 1;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<Boolean> {

        final app.dogo.com.dogo_android.d.b.z.l this$0;
        d(app.dogo.com.dogo_android.d.b.z.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            ChallengeComment challengeComment = this.this$0.n();
            n.d(challengeComment);
            return spam ^= 1;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<Boolean> {

        final app.dogo.com.dogo_android.d.b.z.l this$0;
        e(app.dogo.com.dogo_android.d.b.z.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Boolean.valueOf(invoke());
        }

        @Override // kotlin.d0.d.p
        public final boolean invoke() {
            int i;
            boolean spam;
            ChallengeComment challengeComment = this.this$0.n();
            n.d(challengeComment);
            if (!this.this$0.t() && !challengeComment.isSpam() && !this.this$0.p()) {
                challengeComment = this.this$0.n();
                n.d(challengeComment);
                if (!challengeComment.isSpam()) {
                    i = !this.this$0.p() ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }
    }
    static {
    }

    public l() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
    }

    public l(m2 m2, u2 u22, h2 h23, v2 v24, Resources resources5, o3 o36, p2 p27, i2 i28) {
        n.f(m2, "firestoreService");
        n.f(u22, "userLocalCacheService");
        n.f(h23, "authService");
        n.f(v24, "utilities");
        n.f(resources5, "resources");
        n.f(o36, "tracker");
        n.f(p27, "preferenceService");
        n.f(i28, "cloudFunctionsService");
        super();
        this.a = m2;
        this.b = u22;
        this.c = h23;
        this.v = v24;
        this.w = resources5;
        this.x = o36;
        this.y = p27;
        this.z = i28;
        l.b obj2 = new l.b(this);
        this.F = j.b(obj2);
        obj2 = new l.e(this);
        this.G = j.b(obj2);
        obj2 = new l.d(this);
        this.H = j.b(obj2);
        obj2 = new l.c(this);
        this.I = j.b(obj2);
        obj2 = new l.a(this);
        this.J = j.b(obj2);
        this.E = p27.W();
    }

    public l(m2 m2, u2 u22, h2 h23, v2 v24, Resources resources5, o3 o36, p2 p27, i2 i28, int i9, g g10) {
        i2 i2Var;
        m2 m2Var;
        u2 u2Var;
        h2 h2Var;
        v2 v2Var;
        Resources resources;
        String str;
        o3 o3Var;
        p2 p2Var;
        int i = i9;
        if (i & 1 != 0) {
            m2Var = App.Companion.j();
        } else {
            m2Var = m2;
        }
        if (i & 2 != 0) {
            u2Var = App.Companion.h();
        } else {
            u2Var = u22;
        }
        if (i & 4 != 0) {
            h2Var = App.Companion.c();
        } else {
            h2Var = h23;
        }
        if (i & 8 != 0) {
            v2Var = App.Companion.t();
        } else {
            v2Var = v24;
        }
        if (i & 16 != 0) {
            n.e(App.Companion.b().getResources(), "appContext.resources");
        } else {
            resources = resources5;
        }
        if (i & 32 != 0) {
            o3Var = App.Companion.r();
        } else {
            o3Var = o36;
        }
        if (i & 64 != 0) {
            p2Var = App.Companion.l();
        } else {
            p2Var = p27;
        }
        if (i &= 128 != 0) {
            i2Var = App.Companion.d();
        } else {
            i2Var = i28;
        }
        super(m2Var, u2Var, h2Var, v2Var, resources, o3Var, p2Var, i2Var);
    }

    public static void A(String string, app.dogo.com.dogo_android.d.b.z.l l2, j j3) {
        l.k(string, l2, j3);
    }

    private final void F(boolean z) {
        this.D = z;
        notifyChange(147);
    }

    public static final boolean a(app.dogo.com.dogo_android.d.b.z.l l, ChallengeComment challengeComment2) {
        return l.s(challengeComment2);
    }

    public static final boolean b(app.dogo.com.dogo_android.d.b.z.l l, ChallengeComment challengeComment2) {
        return l.u(challengeComment2);
    }

    private final void c(String string, boolean z2) {
        final ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        challengeComment.setTranslatedComment(string);
        notifyChange(40);
        notifyChange(48);
        notifyChange(165);
        ChallengeComment obj2 = this.B;
        n.d(obj2);
        obj2.setTranslatePressed(z2);
    }

    private final e<String> i(String string) {
        g gVar = new g(string, this);
        return gVar;
    }

    private static final void j(String string, app.dogo.com.dogo_android.d.b.z.l l2, j j3) {
        boolean hVar;
        String str;
        String locale;
        String str2;
        Object obj4;
        Object obj6;
        n.f(string, "$commentId");
        n.f(l2, "this$0");
        n.f(j3, "task");
        ChallengeComment challengeComment = l2.n();
        n.d(challengeComment);
        if (n.b(string, challengeComment.getDocumentId())) {
            obj6 = j3.getResult();
            if ((String)obj6 != null) {
                obj4 = l2.n();
                n.d(obj4);
                obj4.setEntryTranslations(l2.l(), (String)obj6);
                l2.F(false);
                l2.c(obj6, true);
            } else {
                ChallengeComment challengeComment2 = l2.n();
                n.d(challengeComment2);
                String entryId = challengeComment2.getEntryId();
                n.d(entryId);
                ChallengeComment challengeComment3 = l2.n();
                n.d(challengeComment3);
                String documentId2 = challengeComment3.getDocumentId();
                n.d(documentId2);
                ChallengeComment challengeComment4 = l2.n();
                n.d(challengeComment4);
                hVar = new h(string, l2);
                l2.z.m(l2.e(), challengeComment4.getLocale(), l2.y.W(), f.commentTranslations.forEntryId(entryId).forCommentId(documentId2).forLocale(l2.l()).getPath()).addOnCompleteListener(hVar);
            }
        }
    }

    private static final void k(String string, app.dogo.com.dogo_android.d.b.z.l l2, j j3) {
        boolean documentId;
        Object obj1;
        Object obj3;
        n.f(string, "$commentId");
        n.f(l2, "this$0");
        n.f(j3, "task1");
        ChallengeComment challengeComment = l2.n();
        n.d(challengeComment);
        if (j3.isSuccessful() && n.b(string, challengeComment.getDocumentId())) {
            challengeComment = l2.n();
            n.d(challengeComment);
            if (n.b(string, challengeComment.getDocumentId())) {
                l2.F(false);
                l2.c((String)j3.getResult(), true);
            }
        }
    }

    private final String l() {
        String language = Locale.forLanguageTag(this.E).getLanguage();
        n.e(language, "it");
        this.E = language;
        n.e(language, "forLanguageTag(deviceLanguage).language.also { deviceLanguage = it }");
        return language;
    }

    private final boolean s(ChallengeComment challengeComment) {
        boolean obj2;
        if (this.c.C() && !challengeComment.isSpam()) {
            obj2 = !challengeComment.isSpam() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private final boolean u(ChallengeComment challengeComment) {
        String z;
        int obj3;
        if (!n.b(challengeComment.getUserId(), this.c.v())) {
            if (challengeComment.isEntryAuthor(this.c.v())) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    public static void z(String string, app.dogo.com.dogo_android.d.b.z.l l2, j j3) {
        l.j(string, l2, j3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void B() {
        ChallengeComment challengeComment;
        boolean z;
        String str;
        int i;
        String str2;
        app.dogo.com.dogo_android.model.DogProfileModel model;
        String str4;
        String challengeId;
        r2 r2Var;
        y yVar;
        String str3;
        ChallengeComment challengeComment2 = this.B;
        n.d(challengeComment2);
        if (!n.b(challengeComment2.getUserId(), this.c.v())) {
            ChallengeComment challengeComment3 = this.B;
            n.d(challengeComment3);
            str = 1;
            if (!challengeComment3.isHasUserLiked()) {
                i1 i1Var = new i1();
                ChallengeComment challengeComment10 = this.B;
                n.d(challengeComment10);
                c1 c1Var = new c1();
                ChallengeComment challengeComment11 = this.B;
                n.d(challengeComment11);
                r2Var = new r2();
                this.x.d(u.g.c(i1Var, challengeComment10.getDocumentId(), c1Var, challengeComment11.getChallengeId(), r2Var, y.Companion.a(this.C)));
                ChallengeComment challengeComment8 = this.B;
                n.d(challengeComment8);
                this.a.F0(challengeComment8, this.c.v(), this.b.A().g().toModel(this.c.v()));
                ChallengeComment challengeComment5 = this.B;
                n.d(challengeComment5);
                challengeComment5.setHasUserLiked(str);
                challengeComment = this.B;
                n.d(challengeComment);
                ChallengeComment challengeComment9 = this.B;
                n.d(challengeComment9);
                challengeComment.setVotes(votes2 += str);
            } else {
                ChallengeComment challengeComment6 = this.B;
                n.d(challengeComment6);
                this.a.z0(challengeComment6, this.c.v());
                ChallengeComment challengeComment4 = this.B;
                n.d(challengeComment4);
                challengeComment4.setHasUserLiked(false);
                challengeComment = this.B;
                n.d(challengeComment);
                ChallengeComment challengeComment7 = this.B;
                n.d(challengeComment7);
                challengeComment.setVotes(votes -= str);
            }
            notifyChange(101);
            notifyChange(185);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void C(boolean z) {
        this.A = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void D(ChallengeComment challengeComment) {
        this.B = challengeComment;
        this.D = false;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void E(String string) {
        this.C = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void G() {
        notifyChange(41);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String d() {
        String dogAvatarUrl;
        ChallengeComment challengeComment = this.B;
        if (challengeComment != null) {
            n.d(challengeComment);
            dogAvatarUrl = challengeComment.getDogAvatarUrl();
        } else {
            dogAvatarUrl = 0;
        }
        return dogAvatarUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String e() {
        String translatedComment;
        String translatedComment2;
        String str;
        int challengeComment;
        ChallengeComment challengeComment2 = this.B;
        n.d(challengeComment2);
        str = "";
        ChallengeComment challengeComment4 = this.B;
        n.d(challengeComment4);
        ChallengeComment challengeComment5 = this.B;
        n.d(challengeComment5);
        if (challengeComment2.getTranslatedComment() != null && challengeComment4.isTranslatePressed() && challengeComment5.getTranslatedComment() == null) {
            challengeComment4 = this.B;
            n.d(challengeComment4);
            if (challengeComment4.isTranslatePressed()) {
                challengeComment5 = this.B;
                n.d(challengeComment5);
                if (challengeComment5.getTranslatedComment() == null) {
                } else {
                    str = translatedComment2;
                }
            } else {
            }
        } else {
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String f() {
        String str;
        v2 v2Var;
        int i;
        long l;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        Timestamp date = challengeComment.getDate();
        final int i3 = 0;
        final int i4 = 1;
        if (date != null) {
            str = this.v.j(seconds *= l, obj5, i4);
        } else {
            v2 v2Var2 = this.v;
            str = v2Var2.j(v2Var2.g(), obj4, i4);
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final SpannableStringBuilder g() {
        String dogName;
        ForegroundColorSpan foregroundColorSpan;
        String length;
        int length3;
        String str;
        Resources foregroundColorSpan3;
        int length2;
        SpannableStringBuilder spannableStringBuilder;
        int i3;
        int foregroundColorSpan2;
        int color;
        int i6;
        int i5;
        String str2;
        int i;
        int i2;
        int i4;
        int i7;
        final Object obj = this;
        foregroundColorSpan = obj.B;
        if (foregroundColorSpan != null) {
            n.d(foregroundColorSpan);
            dogName = foregroundColorSpan.getDogName();
            ChallengeComment challengeComment = obj.B;
            n.d(challengeComment);
            length3 = 2131100378;
            str = "  ";
            String str6 = "resources.getString(R.string.general_anonymous)";
            int i12 = 2131886675;
            i3 = 0;
            foregroundColorSpan2 = 1;
            color = 0;
            i6 = 33;
            if (challengeComment.isSpam()) {
                if (dogName == null) {
                    n.e(obj.w.getString(i12), str6);
                }
                String str3 = n.o(dogName, str);
                String string = obj.w.getString(2131887329);
                n.e(string, "resources.getString(R.string.social_comments_spam_message2)");
                Object[] arr = new Object[foregroundColorSpan2];
                arr[color] = string;
                String string2 = obj.w.getString(2131887328, arr);
                n.e(string2, "resources.getString(R.string.social_comments_spam_message1, communityRuleText)");
                String str5 = n.o(str3, string2);
                length2 = l.e0(str5, string, 0, false, 6, 0);
                spannableStringBuilder = new SpannableStringBuilder(str5);
                StyleSpan styleSpan2 = new StyleSpan(foregroundColorSpan2);
                spannableStringBuilder.setSpan(styleSpan2, color, str3.length(), i6);
                foregroundColorSpan2 = new ForegroundColorSpan(obj.w.getColor(2131099834, i3));
                spannableStringBuilder.setSpan(foregroundColorSpan2, str3.length(), str5.length(), i6);
                foregroundColorSpan = new ForegroundColorSpan(obj.w.getColor(length3, i3));
                spannableStringBuilder.setSpan(foregroundColorSpan, length2, length6 += length2, i6);
            } else {
                if (dogName == null) {
                    n.e(obj.w.getString(i12), str6);
                }
                foregroundColorSpan = n.o(dogName, str);
                ChallengeComment challengeComment2 = obj.B;
                n.d(challengeComment2);
                if (challengeComment2.getReplyTagName() != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('@');
                    ChallengeComment challengeComment3 = obj.B;
                    n.d(challengeComment3);
                    stringBuilder.append(challengeComment3.getReplyTagName());
                    stringBuilder.append(' ');
                    length = stringBuilder.toString();
                } else {
                    length = "";
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(foregroundColorSpan);
                stringBuilder2.append(length);
                stringBuilder2.append(e());
                spannableStringBuilder = new SpannableStringBuilder(stringBuilder2.toString());
                StyleSpan styleSpan = new StyleSpan(foregroundColorSpan2);
                spannableStringBuilder.setSpan(styleSpan, color, foregroundColorSpan.length(), i6);
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(a.b(obj.w.getDimension(2131165293)));
                spannableStringBuilder.setSpan(absoluteSizeSpan, color, foregroundColorSpan.length(), i6);
                if (length.length() > 0) {
                } else {
                    foregroundColorSpan2 = color;
                }
                if (foregroundColorSpan2 != 0) {
                    foregroundColorSpan3 = new ForegroundColorSpan(obj.w.getColor(length3, i3));
                    spannableStringBuilder.setSpan(foregroundColorSpan3, foregroundColorSpan.length(), length5 += length, i6);
                }
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean getLikeState() {
        int i;
        boolean hasUserLiked;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        if (!n.b(challengeComment.getUserId(), this.c.v())) {
            ChallengeComment challengeComment2 = this.B;
            n.d(challengeComment2);
            if (challengeComment2.isHasUserLiked()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getTranslationButtonString() {
        String string;
        String str;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        if (challengeComment.isTranslatePressed()) {
            n.e(this.w.getString(2131886301), "{\n            resources.getString(R.string.challenge_original)\n        }");
        } else {
            n.e(this.w.getString(2131886326), "{\n            resources.getString(R.string.challenge_translate)\n        }");
        }
        return string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final float h() {
        Resources resources;
        int i;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        String message = challengeComment.getMessage();
        n.d(message);
        i = this.v.n(message) ? R.dimen.normal_text_size : R.dimen.card_tiny_text;
        return resources.getDimension(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isSpinnerVisible() {
        return this.D;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean isTranslateButtonVisible() {
        boolean spam;
        int i;
        String locale;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        ChallengeComment challengeComment3 = this.B;
        n.d(challengeComment3);
        ChallengeComment challengeComment2 = this.B;
        n.d(challengeComment2);
        if (!challengeComment.isSpam() && !n.b(n2.d(this.y.W()), challengeComment3.getLocale()) && !n.b(challengeComment2.getUserId(), this.c.v()) && !this.v.n(e())) {
            challengeComment3 = this.B;
            n.d(challengeComment3);
            if (!n.b(n2.d(this.y.W()), challengeComment3.getLocale())) {
                challengeComment2 = this.B;
                n.d(challengeComment2);
                if (!n.b(challengeComment2.getUserId(), this.c.v())) {
                    i = !this.v.n(e()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean m() {
        return this.A;
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
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        return n.o("", Integer.valueOf(challengeComment.getVotes()));
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void onTranslateButtonPress() {
        Object eVar;
        j translatePressed;
        m2 i;
        boolean key;
        String str;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        String documentId = challengeComment.getDocumentId();
        ChallengeComment challengeComment3 = this.B;
        n.d(challengeComment3);
        i = 0;
        if (!challengeComment3.isTranslatePressed()) {
            translatePressed = 1;
            F(translatePressed);
            ChallengeComment challengeComment6 = this.B;
            n.d(challengeComment6);
            if (challengeComment6.getEntryTranslations().containsKey(l())) {
                F(i);
                ChallengeComment challengeComment2 = this.B;
                n.d(challengeComment2);
                c((String)challengeComment2.getEntryTranslations().get(l()), translatePressed);
            } else {
                ChallengeComment challengeComment4 = this.B;
                n.d(challengeComment4);
                String entryId = challengeComment4.getEntryId();
                n.d(entryId);
                ChallengeComment challengeComment5 = this.B;
                n.d(challengeComment5);
                String documentId2 = challengeComment5.getDocumentId();
                n.d(documentId2);
                n.d(documentId);
                this.a.w(f.commentTranslations.forEntryId(entryId).forCommentId(documentId2).forLocale(l())).addOnCompleteListener(i(documentId));
            }
        } else {
            c(e(), i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean p() {
        ChallengeComment authorAdmin;
        int i;
        authorAdmin = this.B;
        i = 0;
        final int i2 = 1;
        if (authorAdmin == null) {
        } else {
            if (authorAdmin.isAuthorAdmin() == i2) {
                i = i2;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean q() {
        ChallengeComment authorAmbassador;
        int i;
        authorAmbassador = this.B;
        i = 0;
        final int i2 = 1;
        if (authorAmbassador == null) {
        } else {
            if (authorAmbassador.isAuthorAmbassador() == i2) {
                i = i2;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean r() {
        ChallengeComment authorPremium;
        int i;
        authorPremium = this.B;
        i = 0;
        final int i2 = 1;
        if (authorPremium == null) {
        } else {
            if (authorPremium.isAuthorPremium() == i2) {
                i = i2;
            }
        }
        return i;
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
        return (Boolean)this.H.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean x() {
        return (Boolean)this.G.getValue().booleanValue();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean y() {
        String userId;
        int i;
        String str;
        ChallengeComment challengeComment = this.B;
        n.d(challengeComment);
        ChallengeComment challengeComment2 = this.B;
        n.d(challengeComment2);
        if (challengeComment.getUserId() != null && n.b(challengeComment2.getUserId(), this.c.v())) {
            challengeComment2 = this.B;
            n.d(challengeComment2);
            i = n.b(challengeComment2.getUserId(), this.c.v()) ? 1 : 0;
        } else {
        }
        return i;
    }
}
