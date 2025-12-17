package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "programId", "variationId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKnowledge", "()I", "getProgramId", "()Ljava/lang/String;", "getTrickId", "getVariationId", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SaveSpecialProgramTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest> CREATOR;
    private final int knowledge;
    private final String programId;
    private final String trickId;
    private final String variationId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest = new SaveSpecialProgramTrickKnowledgeRequest(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
            return saveSpecialProgramTrickKnowledgeRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest[] newArray(int i) {
            return new SaveSpecialProgramTrickKnowledgeRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SaveSpecialProgramTrickKnowledgeRequest.Creator creator = new SaveSpecialProgramTrickKnowledgeRequest.Creator();
        SaveSpecialProgramTrickKnowledgeRequest.CREATOR = creator;
    }

    public SaveSpecialProgramTrickKnowledgeRequest(String string, int i2, String string3, String string4) {
        n.f(string, "trickId");
        n.f(string3, "programId");
        super();
        this.trickId = string;
        this.knowledge = i2;
        this.programId = string3;
        this.variationId = string4;
    }

    public static app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest copy$default(app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest, String string2, int i3, String string4, String string5, int i6, Object object7) {
        String obj1;
        int obj2;
        String obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = saveSpecialProgramTrickKnowledgeRequest.trickId;
        }
        if (i6 & 2 != 0) {
            obj2 = saveSpecialProgramTrickKnowledgeRequest.knowledge;
        }
        if (i6 & 4 != 0) {
            obj3 = saveSpecialProgramTrickKnowledgeRequest.programId;
        }
        if (i6 &= 8 != 0) {
            obj4 = saveSpecialProgramTrickKnowledgeRequest.variationId;
        }
        return saveSpecialProgramTrickKnowledgeRequest.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest copy(String string, int i2, String string3, String string4) {
        n.f(string, "trickId");
        n.f(string3, "programId");
        SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest = new SaveSpecialProgramTrickKnowledgeRequest(string, i2, string3, string4);
        return saveSpecialProgramTrickKnowledgeRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof SaveSpecialProgramTrickKnowledgeRequest == null) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (!n.b(this.variationId, object.variationId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getKnowledge() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String getVariationId() {
        return this.variationId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        String variationId = this.variationId;
        if (variationId == null) {
            i = 0;
        } else {
            i = variationId.hashCode();
        }
        return i7 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveSpecialProgramTrickKnowledgeRequest(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", variationId=");
        stringBuilder.append(this.variationId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeString(this.programId);
        parcel.writeString(this.variationId);
    }
}
