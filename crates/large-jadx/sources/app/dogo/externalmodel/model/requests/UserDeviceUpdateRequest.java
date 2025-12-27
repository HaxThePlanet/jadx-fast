package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserDeviceUpdateRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest;", "Landroid/os/Parcelable;", "device", "Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "(Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;)V", "getDevice", "()Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DeviceUpdate", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserDeviceUpdateRequest implements Parcelable {

    public static final Parcelable.Creator<UserDeviceUpdateRequest> CREATOR = new UserDeviceUpdateRequest$Creator<>();
    private final UserDeviceUpdateRequest.DeviceUpdate device;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserDeviceUpdateRequest> {
        @Override // android.os.Parcelable$Creator
        public final UserDeviceUpdateRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new UserDeviceUpdateRequest((UserDeviceUpdateRequest_DeviceUpdate)UserDeviceUpdateRequest_DeviceUpdate.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final UserDeviceUpdateRequest[] newArray(int i) {
            return new UserDeviceUpdateRequest[i];
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00082\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006#", d2 = {"Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountryCode", "()Ljava/lang/String;", "getFcmToken", "getLocale", "getNotificationsEnabled", "()Z", "getTimeZone", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeviceUpdate implements Parcelable {

        public static final Parcelable.Creator<UserDeviceUpdateRequest.DeviceUpdate> CREATOR = new UserDeviceUpdateRequest$DeviceUpdate$Creator<>();
        private final String countryCode;
        private final String fcmToken;
        private final String locale;
        private final boolean notificationsEnabled;
        private final String timeZone;
        public DeviceUpdate(String str, String str2, String str3, String str4, boolean z) {
            n.f(str, "timeZone");
            n.f(str2, "countryCode");
            n.f(str3, "locale");
            n.f(str4, "fcmToken");
            super();
            this.timeZone = str;
            this.countryCode = str2;
            this.locale = str3;
            this.fcmToken = str4;
            this.notificationsEnabled = z;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final String getFcmToken() {
            return this.fcmToken;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final boolean getNotificationsEnabled() {
            return this.notificationsEnabled;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }


        public static /* synthetic */ UserDeviceUpdateRequest.DeviceUpdate copy$default(UserDeviceUpdateRequest.DeviceUpdate deviceUpdate, String str, String str2, String str3, String str4, boolean z, int i, Object object) {
            String str22;
            String object82;
            String str42;
            String str52;
            boolean z62;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            if (i & 16 != 0) {
            }
            return deviceUpdate.copy(str22, object82, str42, str52, z62);
        }

        /* operator */ public final String component1() {
            return this.timeZone;
        }

        /* operator */ public final String component2() {
            return this.countryCode;
        }

        /* operator */ public final String component3() {
            return this.locale;
        }

        /* operator */ public final String component4() {
            return this.fcmToken;
        }

        /* operator */ public final boolean component5() {
            return this.notificationsEnabled;
        }

        public final UserDeviceUpdateRequest.DeviceUpdate copy(String timeZone, String countryCode, String locale, String fcmToken, boolean notificationsEnabled) {
            n.f(timeZone, "timeZone");
            n.f(countryCode, "countryCode");
            n.f(locale, "locale");
            n.f(fcmToken, "fcmToken");
            UserDeviceUpdateRequest_DeviceUpdate userDeviceUpdateRequest_DeviceUpdate = new UserDeviceUpdateRequest_DeviceUpdate(timeZone, countryCode, locale, fcmToken, notificationsEnabled);
            return userDeviceUpdateRequest_DeviceUpdate;
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
            final boolean z7 = false;
            if (!(other instanceof UserDeviceUpdateRequest_DeviceUpdate)) {
                return false;
            }
            if (!n.b(this.timeZone, other.timeZone)) {
                return false;
            }
            if (!n.b(this.countryCode, other.countryCode)) {
                return false;
            }
            if (!n.b(this.locale, other.locale)) {
                return false;
            }
            if (!n.b(this.fcmToken, other.fcmToken)) {
                return false;
            }
            return this.notificationsEnabled != other.notificationsEnabled ? z7 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean notificationsEnabled2 = true;
            if (this.notificationsEnabled) {
                int i13 = 1;
            }
            return (this.timeZone.hashCode() * 31) + this.countryCode.hashCode() * 31 + this.locale.hashCode() * 31 + this.fcmToken.hashCode() * 31 + notificationsEnabled2;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DeviceUpdate(timeZone=";
            String str3 = ", countryCode=";
            String str4 = ", locale=";
            String str5 = ", fcmToken=";
            String str6 = ", notificationsEnabled=";
            str = str2 + this.timeZone + str3 + this.countryCode + str4 + this.locale + str5 + this.fcmToken + str6 + this.notificationsEnabled + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.timeZone);
            parcel.writeString(this.countryCode);
            parcel.writeString(this.locale);
            parcel.writeString(this.fcmToken);
            parcel.writeInt(this.notificationsEnabled);
        }
    }
    public UserDeviceUpdateRequest(UserDeviceUpdateRequest.DeviceUpdate deviceUpdate) {
        n.f(deviceUpdate, "device");
        super();
        this.device = deviceUpdate;
    }

    public final UserDeviceUpdateRequest.DeviceUpdate getDevice() {
        return this.device;
    }


    public static /* synthetic */ UserDeviceUpdateRequest copy$default(UserDeviceUpdateRequest userDeviceUpdateRequest, UserDeviceUpdateRequest.DeviceUpdate deviceUpdate, int i, Object object) {
        app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate device2;
        if (i & 1 != 0) {
        }
        return userDeviceUpdateRequest.copy(device2);
    }

    /* operator */ public final UserDeviceUpdateRequest.DeviceUpdate component1() {
        return this.device;
    }

    public final UserDeviceUpdateRequest copy(UserDeviceUpdateRequest.DeviceUpdate device) {
        n.f(device, "device");
        return new UserDeviceUpdateRequest(device);
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
        if (!(other instanceof UserDeviceUpdateRequest)) {
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
        String str2 = "UserDeviceUpdateRequest(device=";
        str = str2 + this.device + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.device.writeToParcel(parcel, flags);
    }
}
