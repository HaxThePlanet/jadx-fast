package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/AcceptDogInviteResponse;", "Landroid/os/Parcelable;", "user", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "(Lapp/dogo/externalmodel/model/responses/UserApiModel;)V", "getUser", "()Lapp/dogo/externalmodel/model/responses/UserApiModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AcceptDogInviteResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.AcceptDogInviteResponse> CREATOR;
    private final app.dogo.externalmodel.model.responses.UserApiModel user;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.AcceptDogInviteResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.AcceptDogInviteResponse createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            AcceptDogInviteResponse acceptDogInviteResponse = new AcceptDogInviteResponse((UserApiModel)UserApiModel.CREATOR.createFromParcel(parcel));
            return acceptDogInviteResponse;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.AcceptDogInviteResponse[] newArray(int i) {
            return new AcceptDogInviteResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        AcceptDogInviteResponse.Creator creator = new AcceptDogInviteResponse.Creator();
        AcceptDogInviteResponse.CREATOR = creator;
    }

    public AcceptDogInviteResponse(app.dogo.externalmodel.model.responses.UserApiModel userApiModel) {
        n.f(userApiModel, "user");
        super();
        this.user = userApiModel;
    }

    public static app.dogo.externalmodel.model.responses.AcceptDogInviteResponse copy$default(app.dogo.externalmodel.model.responses.AcceptDogInviteResponse acceptDogInviteResponse, app.dogo.externalmodel.model.responses.UserApiModel userApiModel2, int i3, Object object4) {
        app.dogo.externalmodel.model.responses.UserApiModel obj1;
        if (i3 &= 1 != 0) {
            obj1 = acceptDogInviteResponse.user;
        }
        return acceptDogInviteResponse.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel component1() {
        return this.user;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.AcceptDogInviteResponse copy(app.dogo.externalmodel.model.responses.UserApiModel userApiModel) {
        n.f(userApiModel, "user");
        AcceptDogInviteResponse acceptDogInviteResponse = new AcceptDogInviteResponse(userApiModel);
        return acceptDogInviteResponse;
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
        if (object instanceof AcceptDogInviteResponse == null) {
            return i2;
        }
        if (!n.b(this.user, object.user)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel getUser() {
        return this.user;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.user.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AcceptDogInviteResponse(user=");
        stringBuilder.append(this.user);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.user.writeToParcel(parcel, i2);
    }
}
