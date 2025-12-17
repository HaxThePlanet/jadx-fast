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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B/\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u00101\u001a\u000202H\u0016J\u0006\u00103\u001a\u00020\u001aJ\u0010\u00104\u001a\u0002022\u0008\u0010(\u001a\u0004\u0018\u00010)J\u000e\u00105\u001a\u0002022\u0006\u0010*\u001a\u00020\u000cR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0010R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001bR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010\u001b\"\u0004\u0008&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0010R\u0013\u0010-\u001a\u0004\u0018\u00010\u000e8G¢\u0006\u0006\u001a\u0004\u0008.\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\u00080\u0010\u0010¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/ChallengeFanListItemObservable;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseFlexibleItemObservable;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "resources", "Landroid/content/res/Resources;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "(Lapp/dogo/com/dogo_android/service/AuthService;Landroid/content/res/Resources;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/FirestoreService;)V", "TIMEOUT_LENGTH_FOR_CLICKS", "", "challengeName", "", "getChallengeName", "()Ljava/lang/String;", "dogName", "Landroid/text/SpannableStringBuilder;", "getDogName", "()Landroid/text/SpannableStringBuilder;", "entryId", "getEntryId", "id", "getId", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isClickStillInTimeout", "isUserThisEntriesAuthor", "lastRegisteredClickTime", "", "lastToggleClickTime", "state", "likeState", "getLikeState", "setLikeState", "(Z)V", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "position", "userEntry", "getUserEntry", "userIcon", "getUserIcon", "voteCount", "getVoteCount", "notifyModelChange", "", "registerClickAndDetectDouble", "setModel", "setSelectedPage", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends o {

    private final h2 a;
    private final Resources b;
    private final v2 c;
    private final int v;
    private ChallengeEntryVoter w;
    private long x;
    private long y;
    private int z;
    public e() {
        super(0, 0, 0, 0, 15, 0);
    }

    public e(h2 h2, Resources resources2, v2 v23, m2 m24) {
        n.f(h2, "authService");
        n.f(resources2, "resources");
        n.f(v23, "utilities");
        n.f(m24, "firestoreService");
        super();
        this.a = h2;
        this.b = resources2;
        this.c = v23;
        this.v = 500;
    }

    public e(h2 h2, Resources resources2, v2 v23, m2 m24, int i5, g g6) {
        h2 obj1;
        Resources obj2;
        v2 obj3;
        m2 obj4;
        int obj6;
        if (i5 & 1 != 0) {
            obj1 = App.Companion.c();
        }
        if (i5 & 2 != 0) {
            n.e(App.Companion.b().getResources(), "appContext.resources");
        }
        if (i5 & 4 != 0) {
            obj3 = App.Companion.t();
        }
        if (i5 &= 8 != 0) {
            obj4 = App.Companion.j();
        }
        super(obj1, obj2, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String a() {
        Object challengeName;
        String str;
        challengeName = this.w;
        str = "";
        if (challengeName != null) {
            n.d(challengeName);
            challengeName = challengeName.getChallengeName();
            if (challengeName == null) {
            } else {
                str = challengeName;
            }
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final SpannableStringBuilder b() {
        String string;
        int length;
        StyleSpan styleSpan;
        String name;
        Object str2;
        int i2;
        SpannableStringBuilder spannableStringBuilder;
        String string2;
        String str;
        int i3;
        int i4;
        int i5;
        int i;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        n.d(challengeEntryVoter);
        DogProfileModel dogProfile = challengeEntryVoter.getDogProfile();
        ChallengeEntryVoter challengeEntryVoter2 = this.w;
        n.d(challengeEntryVoter2);
        if (dogProfile == null) {
            name = 0;
        } else {
            name = dogProfile.getName();
        }
        if (name != null) {
            String name2 = dogProfile.getName();
            n.d(name2);
            string = j1.W0(name2, this.b);
        } else {
            n.e(this.b.getString(2131886675), "resources.getString(R.string.general_anonymous)");
        }
        int i6 = 33;
        i2 = 0;
        final int i9 = 1;
        if (challengeEntryVoter2.getVoterEntryModel() != null) {
            Object[] arr = new Object[i9];
            arr[i2] = string;
            int i8 = 2131886281;
            String string3 = this.b.getString(i8, arr);
            n.e(string3, "resources.getString(R.string.challenge_fan_participant, name)");
            string2 = this.b.getString(i8);
            n.e(string2, "resources.getString(R.string.challenge_fan_participant)");
            i2 = l.e0(string2, "%s", 0, false, 6, 0);
            spannableStringBuilder = new SpannableStringBuilder(string3);
            styleSpan = new StyleSpan(i9);
            spannableStringBuilder.setSpan(styleSpan, i2, length2 += i2, i6);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(string);
            styleSpan = new StyleSpan(i9);
            spannableStringBuilder.setSpan(styleSpan, i2, string.length(), i6);
        }
        return spannableStringBuilder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String c() {
        String documentId;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        if (challengeEntryVoter == null) {
            return "";
        }
        n.d(challengeEntryVoter);
        ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
        if (voterEntryModel != null) {
            documentId = voterEntryModel.getDocumentId();
        }
        return documentId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String d() {
        int avatar;
        Resources resources;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        n.d(challengeEntryVoter);
        DogProfileModel dogProfile = challengeEntryVoter.getDogProfile();
        if (dogProfile == null) {
            avatar = 0;
        } else {
            avatar = dogProfile.getAvatar(this.b);
        }
        return avatar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean e() {
        ChallengeEntryVoter authorAdmin;
        int i;
        authorAdmin = this.w;
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
    public final boolean f() {
        ChallengeEntryVoter authorAmbassador;
        int i;
        authorAmbassador = this.w;
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
    public final boolean g() {
        ChallengeEntryVoter authorPremium;
        int i;
        authorPremium = this.w;
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
    public final boolean getLikeState() {
        boolean likeStateForImageAt;
        int i2;
        boolean imageCount;
        int i;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        if (challengeEntryVoter == null) {
            return 0;
        }
        n.d(challengeEntryVoter);
        likeStateForImageAt = challengeEntryVoter.getVoterEntryModel();
        n.d(likeStateForImageAt);
        if (this.z < 0) {
            if (!i()) {
                if (likeStateForImageAt.hasUserLiked()) {
                    i2 = i4;
                }
            } else {
            }
        } else {
            if (!i()) {
                i = this.z;
                if (likeStateForImageAt.getImageCount() > i && likeStateForImageAt.getLikeStateForImageAt(i)) {
                    if (likeStateForImageAt.getLikeStateForImageAt(i)) {
                    }
                }
            } else {
            }
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final String getVoteCount() {
        String voteString;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        n.d(challengeEntryVoter);
        ChallengeEntryModel voterEntryModel = challengeEntryVoter.getVoterEntryModel();
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
        if (Long.compare(i3, l3) > 0) {
            this.y = l;
            return 1;
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean i() {
        ChallengeEntryModel voterEntryModel;
        int i;
        String str;
        ChallengeEntryVoter challengeEntryVoter = this.w;
        n.d(challengeEntryVoter);
        voterEntryModel = challengeEntryVoter.getVoterEntryModel();
        if (voterEntryModel != null && n.b(voterEntryModel.getAuthor(), this.a.v())) {
            i = n.b(voterEntryModel.getAuthor(), this.a.v()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final boolean j() {
        long l = this.c.g();
        if (Long.compare(i4, l3) < 0) {
            this.x = 0;
            return 1;
        }
        this.x = l;
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void k(ChallengeEntryVoter challengeEntryVoter) {
        this.w = challengeEntryVoter;
        this.z = 0;
        notifyModelChange();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public final void l(int i) {
        Object voterEntryModel;
        int i2;
        int imageIdAt;
        int obj3;
        voterEntryModel = this.w;
        imageIdAt = 0;
        if (voterEntryModel == null) {
        } else {
            voterEntryModel = voterEntryModel.getVoterEntryModel();
            if (voterEntryModel == null) {
            } else {
                imageIdAt = voterEntryModel.getImageIdAt(i);
            }
        }
        if (imageIdAt != 0) {
            if (l.z(imageIdAt)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        if (i2 == 0) {
            i2 = this.w;
            if (i2 == null) {
            } else {
                i2.setSelectedPhotoId(imageIdAt);
            }
            this.z = i;
            notifyChange(123);
            notifyChange(121);
            notifyChange(101);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void notifyModelChange() {
        notifyChangeAll();
        notifyChange(174);
    }
}
