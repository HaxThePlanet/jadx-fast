package app.dogo.com.dogo_android.v;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.UserDeviceModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B9\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/temp/Device;", "Landroid/os/Parcelable;", "country", "", "timezone", "fcmToken", "deviceId", "language", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountry", "()Ljava/lang/String;", "getDeviceId", "getFcmToken", "getLanguage", "getNotificationsEnabled", "()Z", "getTimezone", "buildUserDeviceModel", "Lapp/dogo/externalmodel/model/UserDeviceModel;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.v.a> CREATOR;
    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final String w;
    private final boolean x;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.v.a> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.a a(Parcel parcel) {
            int obj9;
            n.f(parcel, "parcel");
            obj9 = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), obj9);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.a[] b(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    public a(String string, String string2, String string3, String string4, String string5, boolean z6) {
        n.f(string2, "timezone");
        n.f(string4, "deviceId");
        n.f(string5, "language");
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = string4;
        this.w = string5;
        this.x = z6;
    }

    @Override // android.os.Parcelable
    public final UserDeviceModel a() {
        String str;
        String str2;
        if (this.a == null) {
            str = "null";
        }
        if (this.c == null) {
            str2 = 0;
        }
        final String mODEL = Build.MODEL;
        n.e(mODEL, "MODEL");
        super(this.b, str, this.w, str2, this.v, mODEL, "android", "7.22.1", 70220100, this.x);
        return userDeviceModel2;
    }

    @Override // android.os.Parcelable
    public final String b() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final String c() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public final String d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final String e() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public final String f() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeInt(this.x);
    }
}
