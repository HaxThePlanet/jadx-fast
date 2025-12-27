package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: UserDeviceModel.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001c\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 32\u00020\u0001:\u000234BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000cHÆ\u0003Jo\u0010'\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010(\u001a\u00020\u000cHÖ\u0001J\u0013\u0010)\u001a\u00020\u000e2\u0008\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u000cHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0013¨\u00065", d2 = {"Lapp/dogo/externalmodel/model/UserDeviceModel;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "id", "model", "platform", "appVersion", "appBuild", "", "notificationsEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getAppBuild", "()I", "getAppVersion", "()Ljava/lang/String;", "getCountryCode", "getFcmToken", "getId", "getLocale", "getModel", "getNotificationsEnabled", "()Z", "getPlatform", "getTimeZone", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "UserDeviceUpdateModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserDeviceModel implements Parcelable {

    public static final Parcelable.Creator<UserDeviceModel> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final UserDeviceModel.Companion INSTANCE = null;
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserDeviceModel> {
        @Override // android.os.Parcelable$Creator
        public final UserDeviceModel createFromParcel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            UserDeviceModel userDeviceModel = new UserDeviceModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (parcel.readInt() != 0 ? 1 : 0));
            return userDeviceModel;
        }

        @Override // android.os.Parcelable$Creator
        public final UserDeviceModel[] newArray(int i) {
            return new UserDeviceModel[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/UserDeviceModel$UserDeviceUpdateModel;", "Landroid/os/Parcelable;", "timeZone", "", "countryCode", "locale", "fcmToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getFcmToken", "getLocale", "getTimeZone", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UserDeviceUpdateModel implements Parcelable {

        public static final Parcelable.Creator<UserDeviceModel.UserDeviceUpdateModel> CREATOR = new UserDeviceModel$UserDeviceUpdateModel$Creator<>();
        private final String countryCode;
        private final String fcmToken;
        private final String locale;
        private final String timeZone;
        public UserDeviceUpdateModel(String str, String str2, String str3, String str4) {
            n.f(str, "timeZone");
            n.f(str2, "countryCode");
            n.f(str3, "locale");
            n.f(str4, "fcmToken");
            super();
            this.timeZone = str;
            this.countryCode = str2;
            this.locale = str3;
            this.fcmToken = str4;
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

        public final String getTimeZone() {
            return this.timeZone;
        }


        public static /* synthetic */ UserDeviceModel.UserDeviceUpdateModel copy$default(UserDeviceModel.UserDeviceUpdateModel userDeviceUpdateModel, String str, String str2, String str3, String str4, int i, Object object) {
            String timeZone2;
            String countryCode2;
            String locale2;
            String fcmToken2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return userDeviceUpdateModel.copy(timeZone2, countryCode2, locale2, fcmToken2);
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

        public final UserDeviceModel.UserDeviceUpdateModel copy(String timeZone, String countryCode, String locale, String fcmToken) {
            n.f(timeZone, "timeZone");
            n.f(countryCode, "countryCode");
            n.f(locale, "locale");
            n.f(fcmToken, "fcmToken");
            return new UserDeviceModel_UserDeviceUpdateModel(timeZone, countryCode, locale, fcmToken);
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
            final boolean z6 = false;
            if (!(other instanceof UserDeviceModel_UserDeviceUpdateModel)) {
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
            return !n.b(this.fcmToken, other.fcmToken) ? z6 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.timeZone.hashCode() * 31) + this.countryCode.hashCode() * 31 + this.locale.hashCode() * 31 + this.fcmToken.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "UserDeviceUpdateModel(timeZone=";
            String str3 = ", countryCode=";
            String str4 = ", locale=";
            String str5 = ", fcmToken=";
            str = str2 + this.timeZone + str3 + this.countryCode + str4 + this.locale + str5 + this.fcmToken + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.timeZone);
            parcel.writeString(this.countryCode);
            parcel.writeString(this.locale);
            parcel.writeString(this.fcmToken);
        }
    }
    public UserDeviceModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, boolean z) {
        n.f(str, "timeZone");
        n.f(str2, "countryCode");
        n.f(str3, "locale");
        n.f(str5, "id");
        n.f(str6, "model");
        n.f(str7, "platform");
        n.f(str8, "appVersion");
        super();
        this.timeZone = str;
        this.countryCode = str2;
        this.locale = str3;
        this.fcmToken = str4;
        this.id = str5;
        this.model = str6;
        this.platform = str7;
        this.appVersion = str8;
        this.appBuild = i;
        this.notificationsEnabled = z;
    }

    public final int getAppBuild() {
        return this.appBuild;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getModel() {
        return this.model;
    }

    public final boolean getNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    static {
        UserDeviceModel.INSTANCE = new UserDeviceModel_Companion(null);
        UserDeviceModel.CREATOR = new UserDeviceModel.Creator();
    }

    public static /* synthetic */ UserDeviceModel copy$default(UserDeviceModel userDeviceModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, boolean z, int i2, Object object) {
        boolean z112;
        String str22;
        String str32;
        String str42;
        String str52;
        String str62;
        String str72;
        String str82;
        String str92;
        int i102;
        Object userDeviceModel2 = userDeviceModel;
        int i122 = i2;
        String r2 = i122 & 1 != 0 ? userDeviceModel2.timeZone : str;
        String r3 = i122 & 2 != 0 ? userDeviceModel2.countryCode : str2;
        String r4 = i122 & 4 != 0 ? userDeviceModel2.locale : str3;
        String r5 = i122 & 8 != 0 ? userDeviceModel2.fcmToken : str4;
        String r6 = i122 & 16 != 0 ? userDeviceModel2.id : str5;
        String r7 = i122 & 32 != 0 ? userDeviceModel2.model : str6;
        String r8 = i122 & 64 != 0 ? userDeviceModel2.platform : str7;
        String r9 = i122 & 128 != 0 ? userDeviceModel2.appVersion : str8;
        int r10 = i122 & 256 != 0 ? userDeviceModel2.appBuild : i;
        boolean r1 = i122 & 512 != 0 ? userDeviceModel2.notificationsEnabled : z;
        return userDeviceModel.copy(str22, str32, str42, str52, str62, str72, str82, str92, i102, (i122 & 512 != 0 ? userDeviceModel2.notificationsEnabled : z));
    }

    /* operator */ public final String component1() {
        return this.timeZone;
    }

    /* operator */ public final boolean component10() {
        return this.notificationsEnabled;
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

    /* operator */ public final String component5() {
        return this.id;
    }

    /* operator */ public final String component6() {
        return this.model;
    }

    /* operator */ public final String component7() {
        return this.platform;
    }

    /* operator */ public final String component8() {
        return this.appVersion;
    }

    /* operator */ public final int component9() {
        return this.appBuild;
    }

    public final UserDeviceModel copy(String timeZone, String countryCode, String locale, String fcmToken, String id, String model, String platform, String appVersion, int appBuild, boolean notificationsEnabled) {
        n.f(timeZone, "timeZone");
        n.f(countryCode, "countryCode");
        n.f(locale, "locale");
        final Object id2 = id;
        n.f(id2, "id");
        final Object model2 = model;
        n.f(model2, "model");
        final Object platform2 = platform;
        n.f(platform2, "platform");
        final Object appVersion2 = appVersion;
        n.f(appVersion2, "appVersion");
        UserDeviceModel userDeviceModel = new UserDeviceModel(timeZone, countryCode, locale, fcmToken, id2, model2, platform2, appVersion2, appBuild, notificationsEnabled);
        return userDeviceModel;
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
        final boolean z11 = false;
        if (!(other instanceof UserDeviceModel)) {
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
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.model, other.model)) {
            return false;
        }
        if (!n.b(this.platform, other.platform)) {
            return false;
        }
        if (!n.b(this.appVersion, other.appVersion)) {
            return false;
        }
        if (this.appBuild != other.appBuild) {
            return false;
        }
        return this.notificationsEnabled != other.notificationsEnabled ? z11 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        boolean notificationsEnabled2 = true;
        if (this.fcmToken == null) {
            i = 0;
        } else {
            i = this.fcmToken.hashCode();
        }
        if (this.notificationsEnabled) {
            int i28 = 1;
        }
        return (this.timeZone.hashCode() * 31) + this.countryCode.hashCode() * 31 + this.locale.hashCode() * 31 + i * 31 + this.id.hashCode() * 31 + this.model.hashCode() * 31 + this.platform.hashCode() * 31 + this.appVersion.hashCode() * 31 + Integer.hashCode(this.appBuild) * 31 + notificationsEnabled2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserDeviceModel(timeZone=";
        String str3 = ", countryCode=";
        String str4 = ", locale=";
        String str5 = ", fcmToken=";
        String str6 = ", id=";
        String str7 = ", model=";
        String str8 = ", platform=";
        String str9 = ", appVersion=";
        String str10 = ", appBuild=";
        String str11 = ", notificationsEnabled=";
        str = str2 + this.timeZone + str3 + this.countryCode + str4 + this.locale + str5 + this.fcmToken + str6 + this.id + str7 + this.model + str8 + this.platform + str9 + this.appVersion + str10 + this.appBuild + str11 + this.notificationsEnabled + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
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
