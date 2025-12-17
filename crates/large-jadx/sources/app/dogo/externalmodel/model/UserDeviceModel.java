package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001c\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 32\u00020\u0001:\u000234BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000cHÆ\u0003Jo\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010(\u001a\u00020\u000cHÖ\u0001J\u0013\u0010)\u001a\u00020\u000e2\u0008\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u000cHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0013¨\u00065", d2 = {"Lapp/dogo/externalmodel/model/UserDeviceModel;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "id", "model", "platform", "appVersion", "appBuild", "", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getAppBuild", "()I", "getAppVersion", "()Ljava/lang/String;", "getCountryCode", "getFcmToken", "getId", "getLocale", "getModel", "getNotificationsEnabled", "()Z", "getPlatform", "getTimeZone", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "UserDeviceUpdateModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserDeviceModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.UserDeviceModel> CREATOR = null;
    public static final app.dogo.externalmodel.model.UserDeviceModel.Companion Companion = null;
    public static final String PLATFORM_ANDROID = "android";
    public static final String PLATFORM_IOS = "ios";
    public static final String PLATFORM_UNKNOWN = "unknown";
    private final int appBuild;
    private final String appVersion;
    private final String countryCode;
    private final String fcmToken;
    private final String id;
    private final String locale;
    private final String model;
    private final boolean notificationsEnabled;
    private final String platform;
    private final String timeZone;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/externalmodel/model/UserDeviceModel$Companion;", "", "()V", "PLATFORM_ANDROID", "", "PLATFORM_IOS", "PLATFORM_UNKNOWN", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.UserDeviceModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.UserDeviceModel createFromParcel(Parcel parcel) {
            int obj13;
            n.f(parcel, "parcel");
            obj13 = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), obj13);
            return userDeviceModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.UserDeviceModel[] newArray(int i) {
            return new UserDeviceModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/UserDeviceModel$UserDeviceUpdateModel;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getFcmToken", "getLocale", "getTimeZone", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UserDeviceUpdateModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.UserDeviceModel.UserDeviceUpdateModel> CREATOR;
        private final String countryCode;
        private final String fcmToken;
        private final String locale;
        private final String timeZone;
        static {
            UserDeviceModel.UserDeviceUpdateModel.Creator creator = new UserDeviceModel.UserDeviceUpdateModel.Creator();
            UserDeviceModel.UserDeviceUpdateModel.CREATOR = creator;
        }

        public UserDeviceUpdateModel(String string, String string2, String string3, String string4) {
            n.f(string, "timeZone");
            n.f(string2, "countryCode");
            n.f(string3, "locale");
            n.f(string4, "fcmToken");
            super();
            this.timeZone = string;
            this.countryCode = string2;
            this.locale = string3;
            this.fcmToken = string4;
        }

        public static app.dogo.externalmodel.model.UserDeviceModel.UserDeviceUpdateModel copy$default(app.dogo.externalmodel.model.UserDeviceModel.UserDeviceUpdateModel userDeviceModel$UserDeviceUpdateModel, String string2, String string3, String string4, String string5, int i6, Object object7) {
            String obj1;
            String obj2;
            String obj3;
            String obj4;
            if (i6 & 1 != 0) {
                obj1 = userDeviceUpdateModel.timeZone;
            }
            if (i6 & 2 != 0) {
                obj2 = userDeviceUpdateModel.countryCode;
            }
            if (i6 & 4 != 0) {
                obj3 = userDeviceUpdateModel.locale;
            }
            if (i6 &= 8 != 0) {
                obj4 = userDeviceUpdateModel.fcmToken;
            }
            return userDeviceUpdateModel.copy(obj1, obj2, obj3, obj4);
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
        public final app.dogo.externalmodel.model.UserDeviceModel.UserDeviceUpdateModel copy(String string, String string2, String string3, String string4) {
            n.f(string, "timeZone");
            n.f(string2, "countryCode");
            n.f(string3, "locale");
            n.f(string4, "fcmToken");
            UserDeviceModel.UserDeviceUpdateModel userDeviceUpdateModel = new UserDeviceModel.UserDeviceUpdateModel(string, string2, string3, string4);
            return userDeviceUpdateModel;
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
            if (!object instanceof UserDeviceModel.UserDeviceUpdateModel) {
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
        public final String getTimeZone() {
            return this.timeZone;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i6 += i10;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UserDeviceUpdateModel(timeZone=");
            stringBuilder.append(this.timeZone);
            stringBuilder.append(", countryCode=");
            stringBuilder.append(this.countryCode);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(", fcmToken=");
            stringBuilder.append(this.fcmToken);
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
        }
    }
    static {
        UserDeviceModel.Companion companion = new UserDeviceModel.Companion(0);
        UserDeviceModel.Companion = companion;
        UserDeviceModel.Creator creator = new UserDeviceModel.Creator();
        UserDeviceModel.CREATOR = creator;
    }

    public UserDeviceModel(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int i9, boolean z10) {
        n.f(string, "timeZone");
        n.f(string2, "countryCode");
        n.f(string3, "locale");
        n.f(string5, "id");
        n.f(string6, "model");
        n.f(string7, "platform");
        n.f(string8, "appVersion");
        super();
        this.timeZone = string;
        this.countryCode = string2;
        this.locale = string3;
        this.fcmToken = string4;
        this.id = string5;
        this.model = string6;
        this.platform = string7;
        this.appVersion = string8;
        this.appBuild = i9;
        this.notificationsEnabled = z10;
    }

    public static app.dogo.externalmodel.model.UserDeviceModel copy$default(app.dogo.externalmodel.model.UserDeviceModel userDeviceModel, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int i10, boolean z11, int i12, Object object13) {
        boolean notificationsEnabled;
        String timeZone;
        String countryCode;
        String locale;
        String fcmToken;
        String str;
        String model;
        String platform;
        String appVersion;
        int appBuild;
        Object obj = userDeviceModel;
        int i = i12;
        timeZone = i & 1 != 0 ? obj.timeZone : string2;
        countryCode = i & 2 != 0 ? obj.countryCode : string3;
        locale = i & 4 != 0 ? obj.locale : string4;
        fcmToken = i & 8 != 0 ? obj.fcmToken : string5;
        str = i & 16 != 0 ? obj.id : string6;
        model = i & 32 != 0 ? obj.model : string7;
        platform = i & 64 != 0 ? obj.platform : string8;
        appVersion = i & 128 != 0 ? obj.appVersion : string9;
        appBuild = i & 256 != 0 ? obj.appBuild : i10;
        notificationsEnabled = i &= 512 != 0 ? obj.notificationsEnabled : z11;
        return userDeviceModel.copy(timeZone, countryCode, locale, fcmToken, str, model, platform, appVersion, appBuild, notificationsEnabled);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.timeZone;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.notificationsEnabled;
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
    public final String component5() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.model;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.platform;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.appVersion;
    }

    @Override // android.os.Parcelable
    public final int component9() {
        return this.appBuild;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.UserDeviceModel copy(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int i9, boolean z10) {
        n.f(string, "timeZone");
        n.f(string2, "countryCode");
        n.f(string3, "locale");
        final Object obj = string5;
        n.f(obj, "id");
        final Object obj2 = string6;
        n.f(obj2, "model");
        final Object obj3 = string7;
        n.f(obj3, "platform");
        final Object obj4 = string8;
        n.f(obj4, "appVersion");
        super(string, string2, string3, string4, obj, obj2, obj3, obj4, i9, z10);
        return userDeviceModel;
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
        if (!object instanceof UserDeviceModel) {
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
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.model, object.model)) {
            return i2;
        }
        if (!n.b(this.platform, object.platform)) {
            return i2;
        }
        if (!n.b(this.appVersion, object.appVersion)) {
            return i2;
        }
        if (this.appBuild != object.appBuild) {
            return i2;
        }
        if (this.notificationsEnabled != object.notificationsEnabled) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getAppBuild() {
        return this.appBuild;
    }

    @Override // android.os.Parcelable
    public final String getAppVersion() {
        return this.appVersion;
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
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getLocale() {
        return this.locale;
    }

    @Override // android.os.Parcelable
    public final String getModel() {
        return this.model;
    }

    @Override // android.os.Parcelable
    public final boolean getNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    @Override // android.os.Parcelable
    public final String getPlatform() {
        return this.platform;
    }

    @Override // android.os.Parcelable
    public final String getTimeZone() {
        return this.timeZone;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        boolean notificationsEnabled;
        String fcmToken = this.fcmToken;
        if (fcmToken == null) {
            i = 0;
        } else {
            i = fcmToken.hashCode();
        }
        if (this.notificationsEnabled) {
            notificationsEnabled = 1;
        }
        return i19 += notificationsEnabled;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserDeviceModel(timeZone=");
        stringBuilder.append(this.timeZone);
        stringBuilder.append(", countryCode=");
        stringBuilder.append(this.countryCode);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", fcmToken=");
        stringBuilder.append(this.fcmToken);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", appVersion=");
        stringBuilder.append(this.appVersion);
        stringBuilder.append(", appBuild=");
        stringBuilder.append(this.appBuild);
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
        parcel.writeString(this.id);
        parcel.writeString(this.model);
        parcel.writeString(this.platform);
        parcel.writeString(this.appVersion);
        parcel.writeInt(this.appBuild);
        parcel.writeInt(this.notificationsEnabled);
    }
}
