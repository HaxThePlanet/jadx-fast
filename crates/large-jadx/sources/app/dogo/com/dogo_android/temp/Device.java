package app.dogo.com.dogo_android.v;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.UserDeviceModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: Device.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B9\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/temp/Device;", "Landroid/os/Parcelable;", "country", "", "timezone", "fcmToken", "deviceId", "language", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountry", "()Ljava/lang/String;", "getDeviceId", "getFcmToken", "getLanguage", "getNotificationsEnabled", "()Z", "getTimezone", "buildUserDeviceModel", "Lapp/dogo/externalmodel/model/UserDeviceModel;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class Device implements Parcelable {

    public static final Parcelable.Creator<a> CREATOR = new a$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String country;
    /* renamed from: b, reason: from kotlin metadata */
    private final String deviceId;
    /* renamed from: c, reason: from kotlin metadata */
    private final String fcmToken;
    /* renamed from: v, reason: from kotlin metadata */
    private final String language;
    private final String w;
    private final boolean x;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<a> {
        public final a a(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            Device device = new Device(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return device;
        }

        public final a[] b(int i) {
            return new a[i];
        }
    }
    public a(String str, String str2, String str3, String str4, String str5, boolean z) {
        n.f(str2, "timezone");
        n.f(str4, "deviceId");
        n.f(str5, "language");
        super();
        this.country = str;
        this.deviceId = str2;
        this.fcmToken = str3;
        this.language = str4;
        this.w = str5;
        this.x = z;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final UserDeviceModel buildUserDeviceModel() {
        String str;
        String fcmToken2 = null;
        if (this.country == null) {
            str = "null";
        }
        if (this.fcmToken == null) {
            int i = 0;
        }
        final String mODEL2 = Build.MODEL;
        n.e(mODEL2, "MODEL");
        UserDeviceModel userDeviceModel = new UserDeviceModel(this.deviceId, str, this.w, fcmToken2, this.language, mODEL2, "android", "7.22.1", 70220100, this.x);
        return userDeviceModel;
    }

    public final String b() {
        return this.country;
    }

    public final String c() {
        return this.language;
    }

    public final String d() {
        return this.fcmToken;
    }

    public final String e() {
        return this.w;
    }

    public final String f() {
        return this.deviceId;
    }


    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.country);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.fcmToken);
        parcel.writeString(this.language);
        parcel.writeString(this.w);
        parcel.writeInt(this.x);
    }
}
