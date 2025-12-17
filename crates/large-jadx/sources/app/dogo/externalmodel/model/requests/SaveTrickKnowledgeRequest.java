package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "(Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SaveTrickKnowledgeRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest> CREATOR;
    private final int knowledge;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            SaveTrickKnowledgeRequest saveTrickKnowledgeRequest = new SaveTrickKnowledgeRequest(parcel.readString(), parcel.readInt());
            return saveTrickKnowledgeRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest[] newArray(int i) {
            return new SaveTrickKnowledgeRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SaveTrickKnowledgeRequest.Creator creator = new SaveTrickKnowledgeRequest.Creator();
        SaveTrickKnowledgeRequest.CREATOR = creator;
    }

    public SaveTrickKnowledgeRequest(String string, int i2) {
        n.f(string, "trickId");
        super();
        this.trickId = string;
        this.knowledge = i2;
    }

    public static app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest copy$default(app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest saveTrickKnowledgeRequest, String string2, int i3, int i4, Object object5) {
        String obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = saveTrickKnowledgeRequest.trickId;
        }
        if (i4 &= 2 != 0) {
            obj2 = saveTrickKnowledgeRequest.knowledge;
        }
        return saveTrickKnowledgeRequest.copy(obj1, obj2);
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
    public final app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest copy(String string, int i2) {
        n.f(string, "trickId");
        SaveTrickKnowledgeRequest saveTrickKnowledgeRequest = new SaveTrickKnowledgeRequest(string, i2);
        return saveTrickKnowledgeRequest;
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
        if (object instanceof SaveTrickKnowledgeRequest == null) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getKnowledge() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveTrickKnowledgeRequest(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
    }
}
