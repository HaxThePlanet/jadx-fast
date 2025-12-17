package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.util.e0.t;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B5\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0008B\u0007\u0008\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e8G¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000cR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000cR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000c¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/model/PhotoLikeModel;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "imageId", "", "entryId", "imageUrl", "dogId", "challengeId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "<set-?>", "getChallengeId", "()Ljava/lang/String;", "createdAt", "Lcom/google/firebase/Timestamp;", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "getDogId", "getEntryId", "getImageId", "getImageUrl", "setDocumentId", "", "id", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhotoLikeModel implements t {

    private String challengeId;
    private final Timestamp createdAt;
    private String dogId;
    private String entryId;
    private String imageId;
    private String imageUrl;
    public PhotoLikeModel(String string, String string2, String string3, String string4, String string5) {
        n.f(string, "imageId");
        n.f(string2, "entryId");
        super();
        this.imageId = string;
        this.entryId = string2;
        this.imageUrl = string3;
        this.dogId = string4;
        this.challengeId = string5;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getChallengeId() {
        return this.challengeId;
    }

    @Exclude
    public final Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogId() {
        return this.dogId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getEntryId() {
        String entryId = this.entryId;
        if (entryId == null) {
        } else {
            return entryId;
        }
        n.w("entryId");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageId() {
        String imageId = this.imageId;
        if (imageId == null) {
        } else {
            return imageId;
        }
        n.w("imageId");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public void setDocumentId(String string) {
        n.f(string, "id");
    }
}
