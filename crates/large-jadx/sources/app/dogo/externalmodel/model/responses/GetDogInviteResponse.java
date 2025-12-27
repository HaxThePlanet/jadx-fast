package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.DogInviteModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: GetDogInviteResponse.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0008\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "Landroid/os/Parcelable;", "invite", "Lapp/dogo/externalmodel/model/DogInviteModel;", "(Lapp/dogo/externalmodel/model/DogInviteModel;)V", "getInvite", "()Lapp/dogo/externalmodel/model/DogInviteModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GetDogInviteResponse implements Parcelable {

    public static final Parcelable.Creator<GetDogInviteResponse> CREATOR = new GetDogInviteResponse$Creator<>();
    private final DogInviteModel invite;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GetDogInviteResponse> {
        @Override // android.os.Parcelable$Creator
        public final GetDogInviteResponse createFromParcel(Parcel parcel) {
            DogInviteModel dogInviteModel = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = DogInviteModel.CREATOR.createFromParcel(parcel);
            }
            GetDogInviteResponse getDogInviteResponse = new GetDogInviteResponse((DogInviteModel)dogInviteModel);
            return getDogInviteResponse;
        }

        @Override // android.os.Parcelable$Creator
        public final GetDogInviteResponse[] newArray(int i) {
            return new GetDogInviteResponse[i];
        }
    }
    public GetDogInviteResponse(DogInviteModel dogInviteModel) {
        super();
        this.invite = dogInviteModel;
    }

    public final DogInviteModel getInvite() {
        return this.invite;
    }

    public /* synthetic */ GetDogInviteResponse(DogInviteModel dogInviteModel, int i, g gVar) {
        DogInviteModel dogInviteModel2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(dogInviteModel2);
    }


    public GetDogInviteResponse() {
        final DogInviteModel dogInviteModel = null;
        this(dogInviteModel, 1, dogInviteModel);
    }

    public static /* synthetic */ GetDogInviteResponse copy$default(GetDogInviteResponse getDogInviteResponse, DogInviteModel dogInviteModel, int i, Object object) {
        DogInviteModel invite2;
        if (i & 1 != 0) {
        }
        return getDogInviteResponse.copy(invite2);
    }

    /* operator */ public final DogInviteModel component1() {
        return this.invite;
    }

    public final GetDogInviteResponse copy(DogInviteModel invite) {
        return new GetDogInviteResponse(invite);
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
        if (!(other instanceof GetDogInviteResponse)) {
            return false;
        }
        return !n.b(this.invite, other.invite) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.invite == null) {
            i = 0;
        } else {
            i = this.invite.hashCode();
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GetDogInviteResponse(invite=";
        str = str2 + this.invite + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        if (this.invite == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.invite.writeToParcel(parcel, flags);
        }
    }
}
