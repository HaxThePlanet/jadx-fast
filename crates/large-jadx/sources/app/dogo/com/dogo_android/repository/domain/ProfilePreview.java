package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProfilePreview.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0018\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003Jc\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\u0013\u0010%\u001a\u00020\u00052\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000bHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0015R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "Landroid/os/Parcelable;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "userPremium", "", "isUserDogsCreator", "isLastDog", "isParticipateBannerVisible", "fullScreen", "currentStreak", "", "longestStreak", "timeTrained", "", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;ZZZZZIIJ)V", "getCurrentStreak", "()I", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getFullScreen", "()Z", "getLongestStreak", "getTimeTrained", "()J", "getUserPremium", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProfilePreview implements Parcelable {

    public static final Parcelable.Creator<ProfilePreview> CREATOR = new ProfilePreview$Creator<>();
    private final int currentStreak;
    private final DogProfile dogProfile;
    private final boolean fullScreen;
    private final boolean isLastDog;
    private final boolean isParticipateBannerVisible;
    private final boolean isUserDogsCreator;
    private final int longestStreak;
    private final long timeTrained;
    private final boolean userPremium;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProfilePreview> {
        @Override // android.os.Parcelable$Creator
        public final ProfilePreview createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = 1;
            i = 0;
            int r5 = i;
            int r6 = i;
            int r7 = i;
            int r8 = i;
            int r9 = i;
            final int _int2 = parcel.readInt();
            ProfilePreview profilePreview = new ProfilePreview((DogProfile)DogProfile.CREATOR.createFromParcel(parcel), i, i, i, i, i, parcel.readInt(), i, parcel.readLong(), _int2);
            return profilePreview;
        }

        @Override // android.os.Parcelable$Creator
        public final ProfilePreview[] newArray(int i) {
            return new ProfilePreview[i];
        }
    }
    public ProfilePreview(DogProfile dogProfile, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, long j) {
        n.f(dogProfile, "dogProfile");
        super();
        this.dogProfile = dogProfile;
        this.userPremium = z;
        this.isUserDogsCreator = z2;
        this.isLastDog = z3;
        this.isParticipateBannerVisible = z4;
        this.fullScreen = z5;
        this.currentStreak = i;
        this.longestStreak = i2;
        this.timeTrained = j;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final DogProfile getDogProfile() {
        return this.dogProfile;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final int getLongestStreak() {
        return this.longestStreak;
    }

    public final long getTimeTrained() {
        return this.timeTrained;
    }

    public final boolean getUserPremium() {
        return this.userPremium;
    }

    public final boolean isLastDog() {
        return this.isLastDog;
    }

    public final boolean isParticipateBannerVisible() {
        return this.isParticipateBannerVisible;
    }

    public final boolean isUserDogsCreator() {
        return this.isUserDogsCreator;
    }

    public /* synthetic */ ProfilePreview(DogProfile dogProfile, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, long j, int i3, g gVar) {
        int i72;
        int j92;
        int gVar112 = i3;
        i72 = 0;
        int r10 = gVar112 & 64 != 0 ? i72 : i;
        int r11 = gVar112 & 128 != 0 ? i72 : i2;
        j92 = gVar112 & 256;
        j92 = gVar112 & 256 != 0 ? j92 : j;
        this(dogProfile, z, z2, z3, z4, z5, i72, i72, j92, obj);
    }


    public static /* synthetic */ ProfilePreview copy$default(ProfilePreview profilePreview, DogProfile dogProfile, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, long j, int i3, Object object) {
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile22;
        boolean z32;
        boolean z42;
        boolean z52;
        boolean z62;
        boolean z72;
        int i82;
        int i92;
        long j102;
        Object profilePreview2 = profilePreview;
        int object122 = i3;
        app.dogo.com.dogo_android.repository.domain.DogProfile r2 = object122 & 1 != 0 ? profilePreview2.dogProfile : dogProfile;
        boolean r3 = object122 & 2 != 0 ? profilePreview2.userPremium : z;
        boolean r4 = object122 & 4 != 0 ? profilePreview2.isUserDogsCreator : z2;
        boolean r5 = object122 & 8 != 0 ? profilePreview2.isLastDog : z3;
        boolean r6 = object122 & 16 != 0 ? profilePreview2.isParticipateBannerVisible : z4;
        boolean r7 = object122 & 32 != 0 ? profilePreview2.fullScreen : z5;
        int r8 = object122 & 64 != 0 ? profilePreview2.currentStreak : i;
        int r9 = object122 & 128 != 0 ? profilePreview2.longestStreak : i2;
        long r10 = object122 & 256 != 0 ? profilePreview2.timeTrained : j;
        return profilePreview.copy(dogProfile22, z32, z42, z52, z62, z72, i82, i92, (object122 & 256 != 0 ? profilePreview2.timeTrained : j), r22);
    }

    /* operator */ public final DogProfile component1() {
        return this.dogProfile;
    }

    /* operator */ public final boolean component2() {
        return this.userPremium;
    }

    /* operator */ public final boolean component3() {
        return this.isUserDogsCreator;
    }

    /* operator */ public final boolean component4() {
        return this.isLastDog;
    }

    /* operator */ public final boolean component5() {
        return this.isParticipateBannerVisible;
    }

    /* operator */ public final boolean component6() {
        return this.fullScreen;
    }

    /* operator */ public final int component7() {
        return this.currentStreak;
    }

    /* operator */ public final int component8() {
        return this.longestStreak;
    }

    /* operator */ public final long component9() {
        return this.timeTrained;
    }

    public final ProfilePreview copy(DogProfile dogProfile, boolean userPremium, boolean isUserDogsCreator, boolean isLastDog, boolean isParticipateBannerVisible, boolean fullScreen, int currentStreak, int longestStreak, long timeTrained) {
        n.f(dogProfile, "dogProfile");
        ProfilePreview profilePreview = new ProfilePreview(dogProfile, userPremium, isUserDogsCreator, isLastDog, isParticipateBannerVisible, fullScreen, currentStreak, longestStreak, timeTrained, obj);
        return profilePreview;
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
        final boolean z4 = false;
        if (!(other instanceof ProfilePreview)) {
            return false;
        }
        if (n.b(this.dogProfile, other.dogProfile) == null) {
            return false;
        }
        if (this.userPremium != other.userPremium) {
            return false;
        }
        if (this.isUserDogsCreator != other.isUserDogsCreator) {
            return false;
        }
        if (this.isLastDog != other.isLastDog) {
            return false;
        }
        if (this.isParticipateBannerVisible != other.isParticipateBannerVisible) {
            return false;
        }
        if (this.fullScreen != other.fullScreen) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        return this.timeTrained != other.timeTrained ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean userPremium2;
        boolean isUserDogsCreator2;
        boolean isLastDog2;
        boolean isParticipateBannerVisible2;
        int i = 1;
        i = 1;
        if (this.userPremium) {
        }
        if (this.isUserDogsCreator) {
        }
        if (this.isLastDog) {
        }
        if (this.isParticipateBannerVisible) {
        }
        if (!(this.fullScreen)) {
        }
        return (this.dogProfile.hashCode() * 31) + userPremium2 * 31 + isUserDogsCreator2 * 31 + isLastDog2 * 31 + isParticipateBannerVisible2 * 31 + i * 31 + Integer.hashCode(this.currentStreak) * 31 + Integer.hashCode(this.longestStreak) * 31 + Long.hashCode(this.timeTrained);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProfilePreview(dogProfile=";
        String str3 = ", userPremium=";
        String str4 = ", isUserDogsCreator=";
        String str5 = ", isLastDog=";
        String str6 = ", isParticipateBannerVisible=";
        String str7 = ", fullScreen=";
        String str8 = ", currentStreak=";
        String str9 = ", longestStreak=";
        String str10 = ", timeTrained=";
        str = str2 + this.dogProfile + str3 + this.userPremium + str4 + this.isUserDogsCreator + str5 + this.isLastDog + str6 + this.isParticipateBannerVisible + str7 + this.fullScreen + str8 + this.currentStreak + str9 + this.longestStreak + str10 + this.timeTrained + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.dogProfile.writeToParcel(parcel, flags);
        parcel.writeInt(this.userPremium);
        parcel.writeInt(this.isUserDogsCreator);
        parcel.writeInt(this.isLastDog);
        parcel.writeInt(this.isParticipateBannerVisible);
        parcel.writeInt(this.fullScreen);
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.longestStreak);
        parcel.writeLong(this.timeTrained);
    }
}
