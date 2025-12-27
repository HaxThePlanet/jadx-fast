package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: CreateDogInviteRequest.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0016", d2 = {"Lapp/dogo/externalmodel/model/requests/CreateDogInviteRequest;", "Landroid/os/Parcelable;", "dogId", "", "(Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CreateDogInviteRequest implements Parcelable {

    public static final Parcelable.Creator<CreateDogInviteRequest> CREATOR = new CreateDogInviteRequest$Creator<>();
    private final String dogId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CreateDogInviteRequest> {
        @Override // android.os.Parcelable$Creator
        public final CreateDogInviteRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new CreateDogInviteRequest(parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final CreateDogInviteRequest[] newArray(int i) {
            return new CreateDogInviteRequest[i];
        }
    }
    public CreateDogInviteRequest(String str) {
        n.f(str, "dogId");
        super();
        this.dogId = str;
    }

    public final String getDogId() {
        return this.dogId;
    }


    public static /* synthetic */ CreateDogInviteRequest copy$default(CreateDogInviteRequest createDogInviteRequest, String str, int i, Object object) {
        String dogId2;
        if (i & 1 != 0) {
        }
        return createDogInviteRequest.copy(dogId2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    public final CreateDogInviteRequest copy(String dogId) {
        n.f(dogId, "dogId");
        return new CreateDogInviteRequest(dogId);
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
        final boolean z3 = false;
        if (!(other instanceof CreateDogInviteRequest)) {
            return false;
        }
        return !n.b(this.dogId, other.dogId) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.dogId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CreateDogInviteRequest(dogId=";
        str = str2 + this.dogId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
    }
}
