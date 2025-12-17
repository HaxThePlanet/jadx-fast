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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 32\u00020\u0001:\u00013B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jh\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00052\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\u00052\u0008\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020%HÖ\u0001J\u0006\u0010,\u001a\u00020\u0005J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020%HÖ\u0001R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0004\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "Landroid/os/Parcelable;", "userId", "", "isDogPremium", "", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "customTags", "", "isHelpCenterEnabled", "isUserLoggedIn", "hasRequestHistory", "hasUnreadMessages", "(Ljava/lang/String;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/util/List;ZZZZ)V", "getCustomTags", "()Ljava/util/List;", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getHasRequestHistory", "()Z", "getHasUnreadMessages", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/util/List;ZZZZ)Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "describeContents", "", "equals", "other", "", "getDogAge", "getDogPremiumStatus", "hashCode", "isEmpty", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ZendeskConfigurationInfo implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo> CREATOR = null;
    public static final app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo.Companion Companion = null;
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
    private final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
    private final boolean hasRequestHistory;
    private final boolean hasUnreadMessages;
    private final Boolean isDogPremium;
    private final boolean isHelpCenterEnabled;
    private final boolean isUserLoggedIn;
    private final String userId;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo$Companion;", "", "()V", "MONTHS", "", "NPS_FEEDBACK", "PLATFORM", "STATUS_NONE", "STATUS_PREMIUM", "TAG_ANDROID", "TAG_CONTACT_US", "TAG_MOBILE", "YEARS", "createEmpty", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "userId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo createEmpty(String string) {
            n.f(string, "userId");
            super(string, 0, 0, 0, 0, 0, 0, 0, 254, 0);
            return zendeskConfigurationInfo;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo createFromParcel(Parcel parcel) {
            int valueOf;
            int cREATOR;
            int i4;
            int fromParcel;
            int i;
            int i3;
            int i2;
            int i5;
            int obj13;
            n.f(parcel, "parcel");
            int i7 = 1;
            int i9 = 0;
            if (parcel.readInt() == 0) {
                i = fromParcel;
            } else {
                i4 = parcel.readInt() != 0 ? i7 : i9;
                i = valueOf;
            }
            if (parcel.readInt() == 0) {
            } else {
                fromParcel = DogProfile.CREATOR.createFromParcel(parcel);
            }
            i3 = parcel.readInt() != 0 ? i7 : i9;
            i2 = parcel.readInt() != 0 ? i7 : i9;
            i5 = parcel.readInt() != 0 ? i7 : i9;
            obj13 = parcel.readInt() != 0 ? i7 : i9;
            super(parcel.readString(), i, (DogProfile)fromParcel, parcel.createStringArrayList(), i3, i2, i5, obj13);
            return zendeskConfigurationInfo;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo[] newArray(int i) {
            return new ZendeskConfigurationInfo[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ZendeskConfigurationInfo.Companion companion = new ZendeskConfigurationInfo.Companion(0);
        ZendeskConfigurationInfo.Companion = companion;
        ZendeskConfigurationInfo.Creator creator = new ZendeskConfigurationInfo.Creator();
        ZendeskConfigurationInfo.CREATOR = creator;
    }

    public ZendeskConfigurationInfo(String string, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, List<String> list4, boolean z5, boolean z6, boolean z7, boolean z8) {
        n.f(string, "userId");
        n.f(list4, "customTags");
        super();
        this.userId = string;
        this.isDogPremium = boolean2;
        this.dogProfile = dogProfile3;
        this.customTags = list4;
        this.isHelpCenterEnabled = z5;
        this.isUserLoggedIn = z6;
        this.hasRequestHistory = z7;
        this.hasUnreadMessages = z8;
    }

    public ZendeskConfigurationInfo(String string, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, List list4, boolean z5, boolean z6, boolean z7, boolean z8, int i9, g g10) {
        int i5;
        int i6;
        List list;
        int i3;
        int i2;
        int i;
        int i4;
        int i7 = i9;
        i5 = i7 & 2 != 0 ? i6 : boolean2;
        if (i7 & 4 != 0) {
        } else {
            i6 = dogProfile3;
        }
        if (i7 & 8 != 0) {
            list = p.g();
        } else {
            list = list4;
        }
        i2 = 0;
        i3 = i7 & 16 != 0 ? i2 : z5;
        i = i7 & 32 != 0 ? i2 : z6;
        i4 = i7 & 64 != 0 ? i2 : z7;
        if (i7 &= 128 != 0) {
        } else {
            i2 = z8;
        }
        super(string, i5, i6, list, i3, i, i4, i2);
    }

    public static app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo copy$default(app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo, String string2, Boolean boolean3, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile4, List list5, boolean z6, boolean z7, boolean z8, boolean z9, int i10, Object object11) {
        boolean hasUnreadMessages;
        String userId;
        Boolean isDogPremium;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
        List customTags;
        boolean isHelpCenterEnabled;
        boolean isUserLoggedIn;
        boolean hasRequestHistory;
        Object obj = zendeskConfigurationInfo;
        int i = i10;
        userId = i & 1 != 0 ? obj.userId : string2;
        isDogPremium = i & 2 != 0 ? obj.isDogPremium : boolean3;
        dogProfile = i & 4 != 0 ? obj.dogProfile : dogProfile4;
        customTags = i & 8 != 0 ? obj.customTags : list5;
        isHelpCenterEnabled = i & 16 != 0 ? obj.isHelpCenterEnabled : z6;
        isUserLoggedIn = i & 32 != 0 ? obj.isUserLoggedIn : z7;
        hasRequestHistory = i & 64 != 0 ? obj.hasRequestHistory : z8;
        hasUnreadMessages = i &= 128 != 0 ? obj.hasUnreadMessages : z9;
        return zendeskConfigurationInfo.copy(userId, isDogPremium, dogProfile, customTags, isHelpCenterEnabled, isUserLoggedIn, hasRequestHistory, hasUnreadMessages);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public final Boolean component2() {
        return this.isDogPremium;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogProfile component3() {
        return this.dogProfile;
    }

    public final List<String> component4() {
        return this.customTags;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isHelpCenterEnabled;
    }

    @Override // android.os.Parcelable
    public final boolean component6() {
        return this.isUserLoggedIn;
    }

    @Override // android.os.Parcelable
    public final boolean component7() {
        return this.hasRequestHistory;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.hasUnreadMessages;
    }

    public final app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo copy(String string, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile3, List<String> list4, boolean z5, boolean z6, boolean z7, boolean z8) {
        n.f(string, "userId");
        n.f(list4, "customTags");
        super(string, boolean2, dogProfile3, list4, z5, z6, z7, z8);
        return zendeskConfigurationInfo;
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
        if (!object instanceof ZendeskConfigurationInfo) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (!n.b(this.isDogPremium, object.isDogPremium)) {
            return i2;
        }
        if (n.b(this.dogProfile, object.dogProfile) == null) {
            return i2;
        }
        if (!n.b(this.customTags, object.customTags)) {
            return i2;
        }
        if (this.isHelpCenterEnabled != object.isHelpCenterEnabled) {
            return i2;
        }
        if (this.isUserLoggedIn != object.isUserLoggedIn) {
            return i2;
        }
        if (this.hasRequestHistory != object.hasRequestHistory) {
            return i2;
        }
        if (this.hasUnreadMessages != object.hasUnreadMessages) {
            return i2;
        }
        return i;
    }

    public final List<String> getCustomTags() {
        return this.customTags;
    }

    @Override // android.os.Parcelable
    public final String getDogAge() {
        Integer ageInMonths;
        String string;
        StringBuilder stringBuilder;
        int i;
        long l;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = this.dogProfile;
        if (dogProfile == null) {
            ageInMonths = 0;
        } else {
            ageInMonths = dogProfile.getAgeInMonths();
        }
        if (ageInMonths != null) {
            if (ageInMonths.intValue() >= 24) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(d /= l));
                stringBuilder.append(" years");
                string = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ageInMonths);
                stringBuilder.append(" months");
                string = stringBuilder.toString();
            }
        } else {
            string = "";
        }
        return string;
    }

    @Override // android.os.Parcelable
    public final String getDogPremiumStatus() {
        String str;
        str = n.b(this.isDogPremium, Boolean.TRUE) ? "premium" : "none";
        return str;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogProfile getDogProfile() {
        return this.dogProfile;
    }

    @Override // android.os.Parcelable
    public final boolean getHasRequestHistory() {
        return this.hasRequestHistory;
    }

    @Override // android.os.Parcelable
    public final boolean getHasUnreadMessages() {
        return this.hasUnreadMessages;
    }

    @Override // android.os.Parcelable
    public final String getUserId() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        boolean isHelpCenterEnabled;
        boolean isUserLoggedIn;
        boolean hasRequestHistory;
        int i2;
        boolean i3;
        Boolean isDogPremium = this.isDogPremium;
        if (isDogPremium == null) {
            i = i2;
        } else {
            i = isDogPremium.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = this.dogProfile;
        if (dogProfile == null) {
        } else {
            i2 = dogProfile.hashCode();
        }
        i3 = 1;
        if (this.isHelpCenterEnabled) {
            isHelpCenterEnabled = i3;
        }
        if (this.isUserLoggedIn) {
            isUserLoggedIn = i3;
        }
        if (this.hasRequestHistory) {
            hasRequestHistory = i3;
        }
        boolean hasUnreadMessages = this.hasUnreadMessages;
        if (hasUnreadMessages) {
        } else {
            i3 = hasUnreadMessages;
        }
        return i17 += i3;
    }

    @Override // android.os.Parcelable
    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    @Override // android.os.Parcelable
    public final boolean isEmpty() {
        Object isDogPremium;
        int i;
        if (this.isDogPremium == null && this.dogProfile == null) {
            i = this.dogProfile == null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isHelpCenterEnabled() {
        return this.isHelpCenterEnabled;
    }

    @Override // android.os.Parcelable
    public final boolean isUserLoggedIn() {
        return this.isUserLoggedIn;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ZendeskConfigurationInfo(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.isDogPremium);
        stringBuilder.append(", dogProfile=");
        stringBuilder.append(this.dogProfile);
        stringBuilder.append(", customTags=");
        stringBuilder.append(this.customTags);
        stringBuilder.append(", isHelpCenterEnabled=");
        stringBuilder.append(this.isHelpCenterEnabled);
        stringBuilder.append(", isUserLoggedIn=");
        stringBuilder.append(this.isUserLoggedIn);
        stringBuilder.append(", hasRequestHistory=");
        stringBuilder.append(this.hasRequestHistory);
        stringBuilder.append(", hasUnreadMessages=");
        stringBuilder.append(this.hasUnreadMessages);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Boolean isDogPremium;
        n.f(parcel, "out");
        parcel.writeString(this.userId);
        isDogPremium = this.isDogPremium;
        final int i = 0;
        final int i3 = 1;
        if (isDogPremium == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(isDogPremium.booleanValue());
        }
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = this.dogProfile;
        if (dogProfile == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            dogProfile.writeToParcel(parcel, i2);
        }
        parcel.writeStringList(this.customTags);
        parcel.writeInt(this.isHelpCenterEnabled);
        parcel.writeInt(this.isUserLoggedIn);
        parcel.writeInt(this.hasRequestHistory);
        parcel.writeInt(this.hasUnreadMessages);
    }
}
