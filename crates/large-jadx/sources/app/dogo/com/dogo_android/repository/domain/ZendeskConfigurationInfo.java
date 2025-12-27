package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.y.p;

/* compiled from: ZendeskConfigurationInfo.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 32\u00020\u0001:\u00013B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jh\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00052\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\u00052\u0008\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020%HÖ\u0001J\u0006\u0010,\u001a\u00020\u0005J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020%HÖ\u0001R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0004\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "Landroid/os/Parcelable;", "userId", "", "isDogPremium", "", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "customTags", "", "isHelpCenterEnabled", "isUserLoggedIn", "hasRequestHistory", "hasUnreadMessages", "(Ljava/lang/String;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/util/List;ZZZZ)V", "getCustomTags", "()Ljava/util/List;", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getHasRequestHistory", "()Z", "getHasUnreadMessages", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/util/List;ZZZZ)Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "describeContents", "", "equals", "other", "", "getDogAge", "getDogPremiumStatus", "hashCode", "isEmpty", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ZendeskConfigurationInfo implements Parcelable {

    public static final Parcelable.Creator<ZendeskConfigurationInfo> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ZendeskConfigurationInfo.Companion INSTANCE = null;
    public static final String MONTHS = "months";
    public static final String NPS_FEEDBACK = "nps_feedback";
    public static final String PLATFORM = "Android";
    public static final String STATUS_NONE = "none";
    public static final String STATUS_PREMIUM = "premium";
    public static final String TAG_ANDROID = "android";
    public static final String TAG_CONTACT_US = "contact_us";
    public static final String TAG_MOBILE = "mobile";
    public static final String YEARS = "years";
    private final List<String> customTags;
    private final DogProfile dogProfile;
    private final boolean hasRequestHistory;
    private final boolean hasUnreadMessages;
    private final Boolean isDogPremium;
    private final boolean isHelpCenterEnabled;
    private final boolean isUserLoggedIn;
    private final String userId;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo$Companion;", "", "()V", "MONTHS", "", "NPS_FEEDBACK", "PLATFORM", "STATUS_NONE", "STATUS_PREMIUM", "TAG_ANDROID", "TAG_CONTACT_US", "TAG_MOBILE", "YEARS", "createEmpty", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "userId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final ZendeskConfigurationInfo createEmpty(String userId) {
            n.f(userId, "userId");
            ZendeskConfigurationInfo zendeskConfigurationInfo = new ZendeskConfigurationInfo(userId, null, null, null, false, false, false, false, 254, null);
            return zendeskConfigurationInfo;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ZendeskConfigurationInfo> {
        @Override // android.os.Parcelable$Creator
        public final ZendeskConfigurationInfo createFromParcel(Parcel parcel) {
            boolean z;
            int i2 = 0;
            int i;
            n.f(parcel, "parcel");
            i2 = 0;
            i = 1;
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
                int r1 = i;
                Boolean str = i;
            }
            if (parcel.readInt() != 0) {
                Object fromParcel = DogProfile.CREATOR.createFromParcel(parcel);
            }
            int r9 = i;
            int r10 = i;
            int r11 = i;
            parcel = i;
            ZendeskConfigurationInfo zendeskConfigurationInfo = new ZendeskConfigurationInfo(parcel.readString(), i2, (DogProfile)i2, parcel.createStringArrayList(), i, i, i, i);
            return zendeskConfigurationInfo;
        }

        @Override // android.os.Parcelable$Creator
        public final ZendeskConfigurationInfo[] newArray(int i) {
            return new ZendeskConfigurationInfo[i];
        }
    }
    public ZendeskConfigurationInfo(String str, Boolean boolean, DogProfile dogProfile, List<String> list, boolean z, boolean z2, boolean z3, boolean z4) {
        n.f(str, "userId");
        n.f(list, "customTags");
        super();
        this.userId = str;
        this.isDogPremium = boolean;
        this.dogProfile = dogProfile;
        this.customTags = list;
        this.isHelpCenterEnabled = z;
        this.isUserLoggedIn = z2;
        this.hasRequestHistory = z3;
        this.hasUnreadMessages = z4;
    }

    public final List<String> getCustomTags() {
        return this.customTags;
    }

    public final String getDogAge() {
        Object obj = null;
        String str;
        if (this.dogProfile == null) {
            int i3 = 0;
        } else {
            Integer ageInMonths = this.dogProfile.getAgeInMonths();
        }
        if (this.dogProfile == null) {
            str = "";
        } else {
            int i = 24;
            if (obj.intValue() >= 24) {
                StringBuilder stringBuilder = new StringBuilder();
                double d = 12d;
                int i2 = a.a((double)obj.intValue() / d);
                String str3 = " years";
                str = i2 + str3;
            } else {
                stringBuilder = new StringBuilder();
                String str2 = " months";
                str = obj + str2;
            }
        }
        return str;
    }

    public final String getDogPremiumStatus() {
        String str;
        String r0 = n.b(this.isDogPremium, Boolean.TRUE) ? "premium" : "none";
        return (n.b(this.isDogPremium, Boolean.TRUE) ? "premium" : "none");
    }

    public final DogProfile getDogProfile() {
        return this.dogProfile;
    }

    public final boolean getHasRequestHistory() {
        return this.hasRequestHistory;
    }

    public final boolean getHasUnreadMessages() {
        return this.hasUnreadMessages;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    public final boolean isEmpty() {
        boolean z = false;
        int r0 = this.isDogPremium == null && this.dogProfile == null ? 1 : 0;
        return (this.isDogPremium == null && this.dogProfile == null ? 1 : 0);
    }

    public final boolean isHelpCenterEnabled() {
        return this.isHelpCenterEnabled;
    }

    public final boolean isUserLoggedIn() {
        return this.isUserLoggedIn;
    }

    public /* synthetic */ ZendeskConfigurationInfo(String str, Boolean boolean, DogProfile dogProfile, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, g gVar) {
        int boolean22;
        List list42;
        int z52;
        int i92 = i;
        boolean22 = 0;
        int r1 = i92 & 2 != 0 ? 0 : boolean;
        if (i92 & 4 == 0) {
            boolean22 = dogProfile;
        }
        if (i92 & 8 != 0) {
            list42 = p.g();
        } else {
            list42 = list;
        }
        z52 = 0;
        int r4 = i92 & 16 != 0 ? z52 : z;
        int r6 = i92 & 32 != 0 ? z52 : z2;
        int r7 = i92 & 64 != 0 ? z52 : z3;
        if (i92 & 128 == 0) {
            z52 = z4;
        }
        this(str, boolean22, boolean22, list42, z52, z52, z52, z52);
    }

    static {
        ZendeskConfigurationInfo.INSTANCE = new ZendeskConfigurationInfo_Companion(null);
        ZendeskConfigurationInfo.CREATOR = new ZendeskConfigurationInfo.Creator();
    }

    public static /* synthetic */ ZendeskConfigurationInfo copy$default(ZendeskConfigurationInfo zendeskConfigurationInfo, String str, Boolean boolean, DogProfile dogProfile, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, Object object) {
        boolean z92;
        String str22;
        Boolean boolean32;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile42;
        List list52;
        boolean z62;
        boolean z72;
        boolean z82;
        Object zendeskConfigurationInfo2 = zendeskConfigurationInfo;
        int i102 = i;
        String r2 = i102 & 1 != 0 ? zendeskConfigurationInfo2.userId : str;
        Boolean r3 = i102 & 2 != 0 ? zendeskConfigurationInfo2.isDogPremium : boolean;
        app.dogo.com.dogo_android.repository.domain.DogProfile r4 = i102 & 4 != 0 ? zendeskConfigurationInfo2.dogProfile : dogProfile;
        List r5 = i102 & 8 != 0 ? zendeskConfigurationInfo2.customTags : list;
        boolean r6 = i102 & 16 != 0 ? zendeskConfigurationInfo2.isHelpCenterEnabled : z;
        boolean r7 = i102 & 32 != 0 ? zendeskConfigurationInfo2.isUserLoggedIn : z2;
        boolean r8 = i102 & 64 != 0 ? zendeskConfigurationInfo2.hasRequestHistory : z3;
        boolean r1 = i102 & 128 != 0 ? zendeskConfigurationInfo2.hasUnreadMessages : z4;
        return zendeskConfigurationInfo.copy(str22, boolean32, dogProfile42, list52, z62, z72, z82, (i102 & 128 != 0 ? zendeskConfigurationInfo2.hasUnreadMessages : z4));
    }

    /* operator */ public final String component1() {
        return this.userId;
    }

    /* operator */ public final Boolean component2() {
        return this.isDogPremium;
    }

    /* operator */ public final DogProfile component3() {
        return this.dogProfile;
    }

    /* operator */ public final List<String> component4() {
        return this.customTags;
    }

    /* operator */ public final boolean component5() {
        return this.isHelpCenterEnabled;
    }

    /* operator */ public final boolean component6() {
        return this.isUserLoggedIn;
    }

    /* operator */ public final boolean component7() {
        return this.hasRequestHistory;
    }

    /* operator */ public final boolean component8() {
        return this.hasUnreadMessages;
    }

    public final ZendeskConfigurationInfo copy(String userId, Boolean isDogPremium, DogProfile dogProfile, List<String> customTags, boolean isHelpCenterEnabled, boolean isUserLoggedIn, boolean hasRequestHistory, boolean hasUnreadMessages) {
        n.f(userId, "userId");
        n.f(customTags, "customTags");
        ZendeskConfigurationInfo zendeskConfigurationInfo = new ZendeskConfigurationInfo(userId, isDogPremium, dogProfile, customTags, isHelpCenterEnabled, isUserLoggedIn, hasRequestHistory, hasUnreadMessages);
        return zendeskConfigurationInfo;
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
        if (!(other instanceof ZendeskConfigurationInfo)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (!n.b(this.isDogPremium, other.isDogPremium)) {
            return false;
        }
        if (n.b(this.dogProfile, other.dogProfile) == null) {
            return false;
        }
        if (!n.b(this.customTags, other.customTags)) {
            return false;
        }
        if (this.isHelpCenterEnabled != other.isHelpCenterEnabled) {
            return false;
        }
        if (this.isUserLoggedIn != other.isUserLoggedIn) {
            return false;
        }
        if (this.hasRequestHistory != other.hasRequestHistory) {
            return false;
        }
        return this.hasUnreadMessages != other.hasUnreadMessages ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean isHelpCenterEnabled2;
        boolean isUserLoggedIn2;
        boolean hasRequestHistory2;
        boolean hasUnreadMessages2 = true;
        i = 0;
        if (this.isDogPremium == null) {
        } else {
            i = this.isDogPremium.hashCode();
        }
        if (this.dogProfile != null) {
            i = this.dogProfile.hashCode();
        }
        int i2 = 1;
        if (this.isHelpCenterEnabled) {
        }
        if (this.isUserLoggedIn) {
        }
        if (this.hasRequestHistory) {
        }
        if (!(this.hasUnreadMessages)) {
        }
        return (this.userId.hashCode() * 31) + i * 31 + i * 31 + this.customTags.hashCode() * 31 + isHelpCenterEnabled2 * 31 + isUserLoggedIn2 * 31 + hasRequestHistory2 * 31 + hasUnreadMessages2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ZendeskConfigurationInfo(userId=";
        String str3 = ", isDogPremium=";
        String str4 = ", dogProfile=";
        String str5 = ", customTags=";
        String str6 = ", isHelpCenterEnabled=";
        String str7 = ", isUserLoggedIn=";
        String str8 = ", hasRequestHistory=";
        String str9 = ", hasUnreadMessages=";
        str = str2 + this.userId + str3 + this.isDogPremium + str4 + this.dogProfile + str5 + this.customTags + str6 + this.isHelpCenterEnabled + str7 + this.isUserLoggedIn + str8 + this.hasRequestHistory + str9 + this.hasUnreadMessages + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.userId);
        final int i = 0;
        final int i2 = 1;
        if (this.isDogPremium == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.isDogPremium.booleanValue());
        }
        if (this.dogProfile == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            this.dogProfile.writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.customTags);
        parcel.writeInt(this.isHelpCenterEnabled);
        parcel.writeInt(this.isUserLoggedIn);
        parcel.writeInt(this.hasRequestHistory);
        parcel.writeInt(this.hasUnreadMessages);
    }
}
