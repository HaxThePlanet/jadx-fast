package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest;", "Landroid/os/Parcelable;", "device", "Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "(Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;)V", "getDevice", "()Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DeviceUpdate", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserDeviceUpdateRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest> CREATOR;
    private final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate device;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            UserDeviceUpdateRequest userDeviceUpdateRequest = new UserDeviceUpdateRequest((UserDeviceUpdateRequest.DeviceUpdate)UserDeviceUpdateRequest.DeviceUpdate.CREATOR.createFromParcel(parcel));
            return userDeviceUpdateRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest[] newArray(int i) {
            return new UserDeviceUpdateRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00082\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006#", d2 = {"Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest$DeviceUpdate;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountryCode", "()Ljava/lang/String;", "getFcmToken", "getLocale", "getNotificationsEnabled", "()Z", "getTimeZone", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeviceUpdate implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate> CREATOR;
        private final String countryCode;
        private final String fcmToken;
        private final String locale;
        private final boolean notificationsEnabled;
        private final String timeZone;
        static {
            UserDeviceUpdateRequest.DeviceUpdate.Creator creator = new UserDeviceUpdateRequest.DeviceUpdate.Creator();
            UserDeviceUpdateRequest.DeviceUpdate.CREATOR = creator;
        }

        public DeviceUpdate(String string, String string2, String string3, String string4, boolean z5) {
            n.f(string, "timeZone");
            n.f(string2, "countryCode");
            n.f(string3, "locale");
            n.f(string4, "fcmToken");
            super();
            this.timeZone = string;
            this.countryCode = string2;
            this.locale = string3;
            this.fcmToken = string4;
            this.notificationsEnabled = z5;
        }

        public static app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate copy$default(app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate userDeviceUpdateRequest$DeviceUpdate, String string2, String string3, String string4, String string5, boolean z6, int i7, Object object8) {
            String obj4;
            String obj5;
            String obj6;
            String obj7;
            boolean obj8;
            if (i7 & 1 != 0) {
                obj4 = deviceUpdate.timeZone;
            }
            if (i7 & 2 != 0) {
                obj5 = deviceUpdate.countryCode;
            }
            if (i7 & 4 != 0) {
                obj6 = deviceUpdate.locale;
            }
            if (i7 & 8 != 0) {
                obj7 = deviceUpdate.fcmToken;
            }
            if (i7 & 16 != 0) {
                obj8 = deviceUpdate.notificationsEnabled;
            }
            return deviceUpdate.copy(obj4, obj5, obj6, obj7, obj8);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.timeZone;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.countryCode;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.locale;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.fcmToken;
        }

        @Override // android.os.Parcelable
        public final boolean component5() {
            return this.notificationsEnabled;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate copy(String string, String string2, String string3, String string4, boolean z5) {
            n.f(string, "timeZone");
            n.f(string2, "countryCode");
            n.f(string3, "locale");
            n.f(string4, "fcmToken");
            super(string, string2, string3, string4, z5);
            return deviceUpdate;
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
            if (!object instanceof UserDeviceUpdateRequest.DeviceUpdate) {
                return i2;
            }
            if (!n.b(this.timeZone, object.timeZone)) {
                return i2;
            }
            if (!n.b(this.countryCode, object.countryCode)) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            if (!n.b(this.fcmToken, object.fcmToken)) {
                return i2;
            }
            if (this.notificationsEnabled != object.notificationsEnabled) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getCountryCode() {
            return this.countryCode;
        }

        @Override // android.os.Parcelable
        public final String getFcmToken() {
            return this.fcmToken;
        }

        @Override // android.os.Parcelable
        public final String getLocale() {
            return this.locale;
        }

        @Override // android.os.Parcelable
        public final boolean getNotificationsEnabled() {
            return this.notificationsEnabled;
        }

        @Override // android.os.Parcelable
        public final String getTimeZone() {
            return this.timeZone;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean notificationsEnabled;
            if (this.notificationsEnabled) {
                notificationsEnabled = 1;
            }
            return i8 += notificationsEnabled;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DeviceUpdate(timeZone=");
            stringBuilder.append(this.timeZone);
            stringBuilder.append(", countryCode=");
            stringBuilder.append(this.countryCode);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(", fcmToken=");
            stringBuilder.append(this.fcmToken);
            stringBuilder.append(", notificationsEnabled=");
            stringBuilder.append(this.notificationsEnabled);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.timeZone);
            parcel.writeString(this.countryCode);
            parcel.writeString(this.locale);
            parcel.writeString(this.fcmToken);
            parcel.writeInt(this.notificationsEnabled);
        }
    }
    static {
        UserDeviceUpdateRequest.Creator creator = new UserDeviceUpdateRequest.Creator();
        UserDeviceUpdateRequest.CREATOR = creator;
    }

    public UserDeviceUpdateRequest(app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate userDeviceUpdateRequest$DeviceUpdate) {
        n.f(deviceUpdate, "device");
        super();
        this.device = deviceUpdate;
    }

    public static app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest copy$default(app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest userDeviceUpdateRequest, app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate userDeviceUpdateRequest$DeviceUpdate2, int i3, Object object4) {
        app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate obj1;
        if (i3 &= 1 != 0) {
            obj1 = userDeviceUpdateRequest.device;
        }
        return userDeviceUpdateRequest.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate component1() {
        return this.device;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest copy(app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate userDeviceUpdateRequest$DeviceUpdate) {
        n.f(deviceUpdate, "device");
        UserDeviceUpdateRequest userDeviceUpdateRequest = new UserDeviceUpdateRequest(deviceUpdate);
        return userDeviceUpdateRequest;
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
        if (object instanceof UserDeviceUpdateRequest == null) {
            return i2;
        }
        if (!n.b(this.device, object.device)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest.DeviceUpdate getDevice() {
        return this.device;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.device.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserDeviceUpdateRequest(device=");
        stringBuilder.append(this.device);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.device.writeToParcel(parcel, i2);
    }
}
