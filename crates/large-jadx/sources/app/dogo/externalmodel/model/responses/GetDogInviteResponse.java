package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.DogInviteModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0008\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "Landroid/os/Parcelable;", "invite", "Lapp/dogo/externalmodel/model/DogInviteModel;", "(Lapp/dogo/externalmodel/model/DogInviteModel;)V", "getInvite", "()Lapp/dogo/externalmodel/model/DogInviteModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetDogInviteResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.GetDogInviteResponse> CREATOR;
    private final DogInviteModel invite;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.GetDogInviteResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetDogInviteResponse createFromParcel(Parcel parcel) {
            int cREATOR;
            int obj3;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                obj3 = 0;
            } else {
                obj3 = DogInviteModel.CREATOR.createFromParcel(parcel);
            }
            GetDogInviteResponse getDogInviteResponse = new GetDogInviteResponse((DogInviteModel)obj3);
            return getDogInviteResponse;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetDogInviteResponse[] newArray(int i) {
            return new GetDogInviteResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        GetDogInviteResponse.Creator creator = new GetDogInviteResponse.Creator();
        GetDogInviteResponse.CREATOR = creator;
    }

    public GetDogInviteResponse() {
        final int i = 0;
        super(i, 1, i);
    }

    public GetDogInviteResponse(DogInviteModel dogInviteModel) {
        super();
        this.invite = dogInviteModel;
    }

    public GetDogInviteResponse(DogInviteModel dogInviteModel, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static app.dogo.externalmodel.model.responses.GetDogInviteResponse copy$default(app.dogo.externalmodel.model.responses.GetDogInviteResponse getDogInviteResponse, DogInviteModel dogInviteModel2, int i3, Object object4) {
        DogInviteModel obj1;
        if (i3 &= 1 != 0) {
            obj1 = getDogInviteResponse.invite;
        }
        return getDogInviteResponse.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final DogInviteModel component1() {
        return this.invite;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.GetDogInviteResponse copy(DogInviteModel dogInviteModel) {
        GetDogInviteResponse getDogInviteResponse = new GetDogInviteResponse(dogInviteModel);
        return getDogInviteResponse;
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
        if (object instanceof GetDogInviteResponse == null) {
            return i2;
        }
        if (!n.b(this.invite, object.invite)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final DogInviteModel getInvite() {
        return this.invite;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        DogInviteModel invite = this.invite;
        if (invite == null) {
            i = 0;
        } else {
            i = invite.hashCode();
        }
        return i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetDogInviteResponse(invite=");
        stringBuilder.append(this.invite);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        DogInviteModel invite = this.invite;
        if (invite == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            invite.writeToParcel(parcel, i2);
        }
    }
}
