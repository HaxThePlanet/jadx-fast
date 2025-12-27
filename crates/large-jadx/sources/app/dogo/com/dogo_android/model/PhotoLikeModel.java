package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.util.e0.t;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: PhotoLikeModel.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0008B\u0007\u0008\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e8G¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000cR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000cR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000c¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/model/PhotoLikeModel;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "imageId", "", "entryId", "imageUrl", "dogId", "challengeId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "<set-?>", "getChallengeId", "()Ljava/lang/String;", "createdAt", "Lcom/google/firebase/Timestamp;", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "getDogId", "getEntryId", "getImageId", "getImageUrl", "setDocumentId", "", "id", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PhotoLikeModel implements t {

    private String challengeId;
    private final Timestamp createdAt;
    private String dogId;
    private String entryId;
    private String imageId;
    private String imageUrl;
    public PhotoLikeModel(String str, String str2, String str3, String str4, String str5) {
        n.f(str, "imageId");
        n.f(str2, "entryId");
        super();
        this.imageId = str;
        this.entryId = str2;
        this.imageUrl = str3;
        this.dogId = str4;
        this.challengeId = str5;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    @Exclude
    public final Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getEntryId() {
        if (this.entryId == null) {
            n.w("entryId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.entryId;
        }
    }

    public final String getImageId() {
        if (this.imageId == null) {
            n.w("imageId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.imageId;
        }
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public void setDocumentId(String id) {
        n.f(id, "id");
    }
}
