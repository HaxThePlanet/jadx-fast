package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveTrickKnowledgeRequest.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "(Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<SaveTrickKnowledgeRequest> CREATOR = new SaveTrickKnowledgeRequest$Creator<>();
    private final int knowledge;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SaveTrickKnowledgeRequest(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable$Creator
        public final SaveTrickKnowledgeRequest[] newArray(int i) {
            return new SaveTrickKnowledgeRequest[i];
        }
    }
    public SaveTrickKnowledgeRequest(String str, int i) {
        n.f(str, "trickId");
        super();
        this.trickId = str;
        this.knowledge = i;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final String getTrickId() {
        return this.trickId;
    }


    public static /* synthetic */ SaveTrickKnowledgeRequest copy$default(SaveTrickKnowledgeRequest saveTrickKnowledgeRequest, String str, int i, int i2, Object object) {
        String trickId2;
        int knowledge2;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        return saveTrickKnowledgeRequest.copy(trickId2, knowledge2);
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final int component2() {
        return this.knowledge;
    }

    public final SaveTrickKnowledgeRequest copy(String trickId, int knowledge) {
        n.f(trickId, "trickId");
        return new SaveTrickKnowledgeRequest(trickId, knowledge);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof SaveTrickKnowledgeRequest)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        return this.knowledge != other.knowledge ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveTrickKnowledgeRequest(trickId=";
        String str3 = ", knowledge=";
        str = str2 + this.trickId + str3 + this.knowledge + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
    }
}
