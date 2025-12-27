package app.dogo.com.dogo_android.d.a.n;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.o;
import app.dogo.com.dogo_android.util.h0.j1;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: ChallengeFanListItemObservable.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B/\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u00101\u001a\u000202H\u0016J\u0006\u00103\u001a\u00020\u001aJ\u0010\u00104\u001a\u0002022\u0008\u0010(\u001a\u0004\u0018\u00010)J\u000e\u00105\u001a\u0002022\u0006\u0010*\u001a\u00020\u000cR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0010R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001bR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010\u001b\"\u0004\u0008&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0010R\u0013\u0010-\u001a\u0004\u0018\u00010\u000e8G¢\u0006\u0006\u001a\u0004\u0008.\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u00080\u0010\u0010¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListItemObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "resources", "Landroid/content/res/Resources;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "(Lapp/dogo/com/dogo_android/service/AuthService;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/FirestoreService;)V", "TIMEOUT_LENGTH_FOR_CLICKS", "", "challengeName", "", "getChallengeName", "()Ljava/lang/String;", "dogName", "Landroid/text/SpannableStringBuilder;", "getDogName", "()Landroid/text/SpannableStringBuilder;", "entryId", "getEntryId", "id", "getId", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isClickStillInTimeout", "isUserThisEntriesAuthor", "lastRegisteredClickTime", "", "lastToggleClickTime", "state", "likeState", "getLikeState", "setLikeState", "(Z)V", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "position", "userEntry", "getUserEntry", "userIcon", "getUserIcon", "voteCount", "getVoteCount", "notifyModelChange", "", "registerClickAndDetectDouble", "setModel", "setSelectedPage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ChallengeFanListItemObservable extends o {

    /* renamed from: a, reason: from kotlin metadata */
    private final h2 TIMEOUT_LENGTH_FOR_CLICKS;
    /* renamed from: b, reason: from kotlin metadata */
    private final Resources authService;
    private final v2 c;
    private final int v;
    private ChallengeEntryVoter w;
    /* renamed from: x, reason: from kotlin metadata */
    private long firestoreService;
    private long y;
    private int z;
    public e(h2 h2Var, Resources resources, v2 v2Var, m2 m2Var) {
        n.f(h2Var, "authService");
        n.f(resources, "resources");
        n.f(v2Var, "utilities");
        n.f(m2Var, "firestoreService");
        super();
        this.TIMEOUT_LENGTH_FOR_CLICKS = h2Var;
        this.authService = resources;
        this.c = v2Var;
        this.v = 500;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: a, reason: from kotlin metadata */
    public final String notifyModelChange() {
        String challengeName;
        challengeName = "";
        if (this.w != null) {
            n.d(this.w);
            challengeName = this.w.getChallengeName();
            if (challengeName != null) {
            }
        }
        return challengeName;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final SpannableStringBuilder b() throws android.content.res.Resources.NotFoundException {
        Object obj2;
        String name = null;
        SpannableStringBuilder spannableStringBuilder;
        n.d(this.w);
        DogProfileModel dogProfile = this.w.getDogProfile();
        n.d(this.w);
        if (dogProfile == null) {
            int i6 = 0;
        } else {
            name = dogProfile.getName();
        }
        if (name != null) {
            String name2 = dogProfile.getName();
            n.d(name2);
            String str3 = app.dogo.com.dogo_android.util.extensionfunction.j1.W0(name2, this.authService);
        } else {
            str = "resources.getString(R.string.general_anonymous)";
            n.e(this.authService.getString(2131886675), str);
        }
        int i4 = 33;
        int i = 0;
        final int i8 = 1;
        if (this.w.getVoterEntryModel() != null) {
            Object[] arr = new Object[i8];
            int i7 = 2131886281;
            String string3 = this.authService.getString(i7, new Object[] { obj2 });
            n.e(string3, "resources.getString(R.string.challenge_fan_participant, name)");
            String string = this.authService.getString(i7);
            n.e(string, "resources.getString(R.string.challenge_fan_participant)");
            int i2 = 0;
            boolean z = false;
            int i3 = 6;
            Object obj = null;
            str2 = "%s";
            i = l.e0(string, str2, i2, z, i3, obj);
            length = obj2.length() + i;
            new SpannableStringBuilder(string3).setSpan(new StyleSpan(i8), i, length, i4);
        } else {
            new SpannableStringBuilder(obj2).setSpan(new StyleSpan(i8), i, obj2.length(), i4);
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String c() {
        String documentId;
        documentId = "";
        if (this.w == null) {
            return "";
        }
        n.d(this.w);
        ChallengeEntryModel voterEntryModel = this.w.getVoterEntryModel();
        if (voterEntryModel != null) {
            documentId = voterEntryModel.getDocumentId();
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String d() {
        int i = 0;
        n.d(this.w);
        DogProfileModel dogProfile = this.w.getDogProfile();
        if (dogProfile == null) {
            i = 0;
        } else {
            String avatar = dogProfile.getAvatar(this.authService);
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean e() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.w != null) {
            if (this.w.isAuthorAdmin()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean f() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.w != null) {
            if (this.w.isAuthorAmbassador()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean g() {
        boolean z = false;
        int i2 = 0;
        final int i = 1;
        if (this.w != null) {
            if (this.w.isAuthorPremium()) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean getLikeState() {
        ChallengeEntryModel voterEntryModel;
        boolean z = false;
        boolean z2;
        int i;
        z = false;
        if (this.w == null) {
            return false;
        }
        n.d(this.w);
        voterEntryModel = this.w.getVoterEntryModel();
        n.d(voterEntryModel);
        if (this.z < 0) {
            if (i() || voterEntryModel.hasUserLiked()) {
                int i2 = 1;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getVoteCount() {
        String voteString;
        n.d(this.w);
        ChallengeEntryModel voterEntryModel = this.w.getVoterEntryModel();
        if (voterEntryModel != null) {
            voteString = voterEntryModel.getVoteString();
        } else {
            voteString = "";
        }
        return voteString;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean h() {
        long l = this.c.g();
        long l3 = l - this.y;
        long l4 = (long)this.v;
        if (this.y > this.v) {
            this.y = l;
            return true;
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean i() {
        boolean z2 = false;
        String str;
        n.d(this.w);
        ChallengeEntryModel voterEntryModel = this.w.getVoterEntryModel();
        if (voterEntryModel != null) {
            int r0 = n.b(voterEntryModel.getAuthor(), this.TIMEOUT_LENGTH_FOR_CLICKS.v()) ? 1 : 0;
        }
        return (n.b(voterEntryModel.getAuthor(), this.TIMEOUT_LENGTH_FOR_CLICKS.v()) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean j() {
        long l = this.c.g();
        long l2 = l - this.firestoreService;
        long l3 = (long)this.v;
        if (this.firestoreService < this.v) {
            this.firestoreService = 0L;
            return true;
        }
        this.firestoreService = l;
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: k, reason: from kotlin metadata */
    public final void setModel(ChallengeEntryVoter model) {
        this.w = model;
        this.z = 0;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    /* renamed from: l, reason: from kotlin metadata */
    public final void setSelectedPage(int position) {
        ChallengeEntryVoter challengeEntryVoter;
        int i = 0;
        Object obj = null;
        int i3 = 0;
        if (this.w != null) {
            ChallengeEntryModel voterEntryModel = this.w.getVoterEntryModel();
            if (voterEntryModel != null) {
                String imageIdAt = voterEntryModel.getImageIdAt(position);
            }
        }
        if (obj == null || l.z(obj)) {
            i = 1;
        }
        if (this.w == 0 && this.w == null) {
            this.z = position;
            notifyChange(123);
            notifyChange(121);
            int i2 = 101;
            notifyChange(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
        notifyChange(174);
    }

    public /* synthetic */ e(h2 h2Var, Resources resources, v2 v2Var, m2 m2Var, int i, g gVar) {
        h2 h2Var2;
        if (i & 1 != 0) {
            h2Var2 = App.INSTANCE.c();
        }
        i = i & 2;
        if (i & 2 != 0) {
            n.e(App.INSTANCE.b().getResources(), "appContext.resources");
        }
        if (i & 4 != 0) {
            v2Var = App.INSTANCE.t();
        }
        if (i & 8 != 0) {
            m2Var = App.INSTANCE.j();
        }
        this(h2Var2, resources, v2Var, m2Var);
    }

    public e() {
        this(null, null, null, null, 15, null);
    }
}
