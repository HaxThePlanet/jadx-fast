package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.util.e0.t;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeEntryVoter.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u00103\u001a\u00020\u001c2\u0008\u00104\u001a\u0004\u0018\u000105H\u0096\u0002J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR*\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\r\"\u0004\u0008\u0014\u0010\u000fR*\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0008\u0010\n\u001a\u0004\u0018\u00010\u00158G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001dR&\u0010 \u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c8G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u001d\"\u0004\u0008!\u0010\"R&\u0010#\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c8G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u001d\"\u0004\u0008$\u0010\"R \u0010%\u001a\u0004\u0018\u00010\u00058G@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\r\"\u0004\u0008'\u0010\u000fR\u001c\u0010(\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010\r\"\u0004\u0008*\u0010\u000fR*\u0010,\u001a\u0004\u0018\u00010+2\u0008\u0010\n\u001a\u0004\u0018\u00010+8G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u00058G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010\r¨\u00069", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "()V", "badges", "", "", "getBadges", "()Ljava/util/List;", "setBadges", "(Ljava/util/List;)V", "<set-?>", "challengeName", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "date", "Lcom/google/firebase/Timestamp;", "dogId", "getDogId", "setDogId", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "dogProfile", "getDogProfile", "()Lapp/dogo/com/dogo_android/model/DogProfileModel;", "setDogProfile", "(Lapp/dogo/com/dogo_android/model/DogProfileModel;)V", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isDogProfileFetched", "setDogProfileFetched", "(Z)V", "isEntryModelFetched", "setEntryModelFetched", "selectedPhotoId", "getSelectedPhotoId", "setSelectedPhotoId", "voterEntryId", "getVoterEntryId", "setVoterEntryId", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "voterEntryModel", "getVoterEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "setVoterEntryModel", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;)V", "voterId", "getVoterId", "equals", "other", "", "setDocumentId", "", "id", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeEntryVoter implements t {

    private List<String> badges = new ArrayList<>();
    @Exclude
    private String challengeName;
    @ServerTimestamp
    private final Timestamp date;
    private String dogId;
    @Exclude
    private DogProfileModel dogProfile;
    @Exclude
    private boolean isDogProfileFetched;
    @Exclude
    private boolean isEntryModelFetched;
    @Exclude
    private String selectedPhotoId;
    private String voterEntryId;
    @Exclude
    private ChallengeEntryModel voterEntryModel;
    @Exclude
    private String voterId;
    public ChallengeEntryVoter() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        boolean z = false;
        if (other instanceof ChallengeEntryVoter) {
            z = n.b(this.voterId, other.voterId);
        } else {
            int i = 0;
        }
        return z;
    }

    public final List<String> getBadges() {
        return this.badges;
    }

    @Exclude
    public final String getChallengeName() {
        return this.challengeName;
    }

    public final String getDogId() {
        String dogId;
        if (this.voterEntryModel != null) {
            n.d(this.voterEntryModel);
            dogId = this.voterEntryModel.getDogId();
        } else {
        }
        return dogId;
    }

    @Exclude
    public final DogProfileModel getDogProfile() {
        return this.dogProfile;
    }

    @Exclude
    public final String getSelectedPhotoId() {
        return this.selectedPhotoId;
    }

    public final String getVoterEntryId() {
        return this.voterEntryId;
    }

    @Exclude
    public final ChallengeEntryModel getVoterEntryModel() {
        return this.voterEntryModel;
    }

    @Exclude
    public final String getVoterId() {
        return this.voterId;
    }

    public final boolean isAuthorAdmin() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.u(this), "admin");
    }

    public final boolean isAuthorAmbassador() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.u(this), "ambassador");
    }

    public final boolean isAuthorPremium() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.u(this), "premium");
    }

    @Exclude
    public final boolean isDogProfileFetched() {
        boolean z = false;
        if (this.dogProfile != null || this.isDogProfileFetched != null) {
            int i2 = 1;
        }
        return z;
    }

    @Exclude
    public final boolean isEntryModelFetched() {
        boolean z = false;
        if (this.voterEntryModel != null || this.isEntryModelFetched) {
            int i2 = 1;
        }
        return z;
    }

    public final void setBadges(List<String> list) {
        n.f(list, "<set-?>");
        this.badges = list;
    }

    @Exclude
    public final void setChallengeName(String str) {
        this.challengeName = str;
    }

    public void setDocumentId(String id) {
        n.f(id, "id");
        this.voterId = id;
    }

    public final void setDogId(String str) {
        this.dogId = str;
    }

    @Exclude
    public final void setDogProfile(DogProfileModel dogProfileModel) {
        this.dogProfile = dogProfileModel;
    }

    @Exclude
    public final void setDogProfileFetched(boolean z) {
        this.isDogProfileFetched = z;
    }

    @Exclude
    public final void setEntryModelFetched(boolean z) {
        this.isEntryModelFetched = z;
    }

    public final void setSelectedPhotoId(String str) {
        this.selectedPhotoId = str;
    }

    public final void setVoterEntryId(String str) {
        this.voterEntryId = str;
    }

    @Exclude
    public final void setVoterEntryModel(ChallengeEntryModel challengeEntryModel) {
        this.voterEntryModel = challengeEntryModel;
    }
}
