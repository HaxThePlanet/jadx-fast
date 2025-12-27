package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveSpecialProgramTrickKnowledgeRequest.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "programId", "variationId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKnowledge", "()I", "getProgramId", "()Ljava/lang/String;", "getTrickId", "getVariationId", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveSpecialProgramTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<SaveSpecialProgramTrickKnowledgeRequest> CREATOR = new SaveSpecialProgramTrickKnowledgeRequest$Creator<>();
    private final int knowledge;
    private final String programId;
    private final String trickId;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveSpecialProgramTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveSpecialProgramTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SaveSpecialProgramTrickKnowledgeRequest(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final SaveSpecialProgramTrickKnowledgeRequest[] newArray(int i) {
            return new SaveSpecialProgramTrickKnowledgeRequest[i];
        }
    }
    public SaveSpecialProgramTrickKnowledgeRequest(String str, int i, String str2, String str3) {
        n.f(str, "trickId");
        n.f(str2, "programId");
        super();
        this.trickId = str;
        this.knowledge = i;
        this.programId = str2;
        this.variationId = str3;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final String getVariationId() {
        return this.variationId;
    }


    public static /* synthetic */ SaveSpecialProgramTrickKnowledgeRequest copy$default(SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest, String str, int i, String str2, String str3, int i2, Object object) {
        String trickId2;
        int knowledge2;
        String programId2;
        String variationId2;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        return saveSpecialProgramTrickKnowledgeRequest.copy(trickId2, knowledge2, programId2, variationId2);
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final int component2() {
        return this.knowledge;
    }

    /* operator */ public final String component3() {
        return this.programId;
    }

    /* operator */ public final String component4() {
        return this.variationId;
    }

    public final SaveSpecialProgramTrickKnowledgeRequest copy(String trickId, int knowledge, String programId, String variationId) {
        n.f(trickId, "trickId");
        n.f(programId, "programId");
        return new SaveSpecialProgramTrickKnowledgeRequest(trickId, knowledge, programId, variationId);
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
        final boolean z5 = false;
        if (!(other instanceof SaveSpecialProgramTrickKnowledgeRequest)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (this.knowledge != other.knowledge) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        return !n.b(this.variationId, other.variationId) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.variationId == null) {
            i = 0;
        } else {
            i = this.variationId.hashCode();
        }
        return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + this.programId.hashCode() * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveSpecialProgramTrickKnowledgeRequest(trickId=";
        String str3 = ", knowledge=";
        String str4 = ", programId=";
        String str5 = ", variationId=";
        str = str2 + this.trickId + str3 + this.knowledge + str4 + this.programId + str5 + this.variationId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeString(this.programId);
        parcel.writeString(this.variationId);
    }
}
