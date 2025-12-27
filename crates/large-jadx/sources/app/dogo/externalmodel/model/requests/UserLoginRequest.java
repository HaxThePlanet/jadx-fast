package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.UserDeviceModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserLoginRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/requests/UserLoginRequest;", "Landroid/os/Parcelable;", "device", "Lapp/dogo/externalmodel/model/UserDeviceModel;", "(Lapp/dogo/externalmodel/model/UserDeviceModel;)V", "getDevice", "()Lapp/dogo/externalmodel/model/UserDeviceModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserLoginRequest implements Parcelable {

    public static final Parcelable.Creator<UserLoginRequest> CREATOR = new UserLoginRequest$Creator<>();
    private final UserDeviceModel device;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserLoginRequest> {
        @Override // android.os.Parcelable$Creator
        public final UserLoginRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new UserLoginRequest((UserDeviceModel)UserDeviceModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final UserLoginRequest[] newArray(int i) {
            return new UserLoginRequest[i];
        }
    }
    public UserLoginRequest(UserDeviceModel userDeviceModel) {
        n.f(userDeviceModel, "device");
        super();
        this.device = userDeviceModel;
    }

    public final UserDeviceModel getDevice() {
        return this.device;
    }


    public static /* synthetic */ UserLoginRequest copy$default(UserLoginRequest userLoginRequest, UserDeviceModel userDeviceModel, int i, Object object) {
        UserDeviceModel device2;
        if (i & 1 != 0) {
        }
        return userLoginRequest.copy(device2);
    }

    /* operator */ public final UserDeviceModel component1() {
        return this.device;
    }

    public final UserLoginRequest copy(UserDeviceModel device) {
        n.f(device, "device");
        return new UserLoginRequest(device);
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
        if (!(other instanceof UserLoginRequest)) {
            return false;
        }
        return !n.b(this.device, other.device) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.device.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserLoginRequest(device=";
        str = str2 + this.device + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.device.writeToParcel(parcel, flags);
    }
}
