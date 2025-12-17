package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0016", d2 = {"Lapp/dogo/externalmodel/model/requests/CreateDogInviteRequest;", "Landroid/os/Parcelable;", "dogId", "", "(Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CreateDogInviteRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.CreateDogInviteRequest> CREATOR;
    private final String dogId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.CreateDogInviteRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.CreateDogInviteRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            CreateDogInviteRequest createDogInviteRequest = new CreateDogInviteRequest(parcel.readString());
            return createDogInviteRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.CreateDogInviteRequest[] newArray(int i) {
            return new CreateDogInviteRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        CreateDogInviteRequest.Creator creator = new CreateDogInviteRequest.Creator();
        CreateDogInviteRequest.CREATOR = creator;
    }

    public CreateDogInviteRequest(String string) {
        n.f(string, "dogId");
        super();
        this.dogId = string;
    }

    public static app.dogo.externalmodel.model.requests.CreateDogInviteRequest copy$default(app.dogo.externalmodel.model.requests.CreateDogInviteRequest createDogInviteRequest, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = createDogInviteRequest.dogId;
        }
        return createDogInviteRequest.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.CreateDogInviteRequest copy(String string) {
        n.f(string, "dogId");
        CreateDogInviteRequest createDogInviteRequest = new CreateDogInviteRequest(string);
        return createDogInviteRequest;
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
        if (object instanceof CreateDogInviteRequest == null) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.dogId.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreateDogInviteRequest(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
    }
}
