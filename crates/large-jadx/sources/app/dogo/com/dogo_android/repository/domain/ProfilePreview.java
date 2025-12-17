package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0018\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003Jc\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\u0013\u0010%\u001a\u00020\u00052\u0008\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000bHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0015R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "Landroid/os/Parcelable;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "userPremium", "", "isUserDogsCreator", "isLastDog", "isParticipateBannerVisible", "fullScreen", "currentStreak", "", "longestStreak", "timeTrained", "", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;ZZZZZIIJ)V", "getCurrentStreak", "()I", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getFullScreen", "()Z", "getLongestStreak", "getTimeTrained", "()J", "getUserPremium", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProfilePreview implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProfilePreview> CREATOR;
    private final int currentStreak;
    private final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
    private final boolean fullScreen;
    private final boolean isLastDog;
    private final boolean isParticipateBannerVisible;
    private final boolean isUserDogsCreator;
    private final int longestStreak;
    private final long timeTrained;
    private final boolean userPremium;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProfilePreview> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProfilePreview createFromParcel(Parcel parcel) {
            int i2;
            int i;
            int i5;
            int i3;
            int i4;
            n.f(parcel, "parcel");
            int i6 = 1;
            int i8 = 0;
            i2 = parcel.readInt() != 0 ? i6 : i8;
            i = parcel.readInt() != 0 ? i6 : i8;
            i5 = parcel.readInt() != 0 ? i6 : i8;
            i3 = parcel.readInt() != 0 ? i6 : i8;
            i4 = parcel.readInt() != 0 ? i6 : i8;
            final int int7 = parcel.readInt();
            super((DogProfile)DogProfile.CREATOR.createFromParcel(parcel), i2, i, i5, i3, i4, parcel.readInt(), int7, parcel.readLong(), int7);
            return profilePreview;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProfilePreview[] newArray(int i) {
            return new ProfilePreview[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ProfilePreview.Creator creator = new ProfilePreview.Creator();
        ProfilePreview.CREATOR = creator;
    }

    public ProfilePreview(app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i7, int i8, long l9) {
        n.f(dogProfile, "dogProfile");
        super();
        this.dogProfile = dogProfile;
        this.userPremium = z2;
        this.isUserDogsCreator = z3;
        this.isLastDog = z4;
        this.isParticipateBannerVisible = z5;
        this.fullScreen = z6;
        this.currentStreak = i7;
        this.longestStreak = i8;
        this.timeTrained = l9;
    }

    public ProfilePreview(app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i7, int i8, long l9, int i10, g g11) {
        int i3;
        int i4;
        int i2;
        int i;
        int i5 = g11;
        final int i11 = 0;
        i4 = i5 & 64 != 0 ? i11 : i7;
        i2 = i5 & 128 != 0 ? i11 : i8;
        i = i5 &= 256 != 0 ? i3 : l9;
        super(dogProfile, z2, z3, z4, z5, z6, i4, i2, i, obj13);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProfilePreview copy$default(app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview, app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i8, int i9, long l10, int i11, Object object12) {
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
        boolean userPremium;
        boolean isUserDogsCreator;
        boolean isLastDog;
        boolean isParticipateBannerVisible;
        boolean fullScreen;
        int currentStreak;
        int longestStreak;
        long timeTrained;
        Object obj = profilePreview;
        int i = object12;
        dogProfile = i & 1 != 0 ? obj.dogProfile : dogProfile2;
        userPremium = i & 2 != 0 ? obj.userPremium : z3;
        isUserDogsCreator = i & 4 != 0 ? obj.isUserDogsCreator : z4;
        isLastDog = i & 8 != 0 ? obj.isLastDog : z5;
        isParticipateBannerVisible = i & 16 != 0 ? obj.isParticipateBannerVisible : z6;
        fullScreen = i & 32 != 0 ? obj.fullScreen : z7;
        currentStreak = i & 64 != 0 ? obj.currentStreak : i8;
        longestStreak = i & 128 != 0 ? obj.longestStreak : i9;
        timeTrained = i &= 256 != 0 ? obj.timeTrained : l10;
        return profilePreview.copy(dogProfile, userPremium, isUserDogsCreator, isLastDog, isParticipateBannerVisible, fullScreen, currentStreak, longestStreak, timeTrained);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogProfile component1() {
        return this.dogProfile;
    }

    @Override // android.os.Parcelable
    public final boolean component2() {
        return this.userPremium;
    }

    @Override // android.os.Parcelable
    public final boolean component3() {
        return this.isUserDogsCreator;
    }

    @Override // android.os.Parcelable
    public final boolean component4() {
        return this.isLastDog;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.isParticipateBannerVisible;
    }

    @Override // android.os.Parcelable
    public final boolean component6() {
        return this.fullScreen;
    }

    @Override // android.os.Parcelable
    public final int component7() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final int component8() {
        return this.longestStreak;
    }

    @Override // android.os.Parcelable
    public final long component9() {
        return this.timeTrained;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProfilePreview copy(app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i7, int i8, long l9) {
        n.f(dogProfile, "dogProfile");
        super(dogProfile, z2, z3, z4, z5, z6, i7, i8, l9, obj11);
        return profilePreview;
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
        if (object instanceof ProfilePreview == null) {
            return i2;
        }
        if (n.b(this.dogProfile, object.dogProfile) == null) {
            return i2;
        }
        if (this.userPremium != object.userPremium) {
            return i2;
        }
        if (this.isUserDogsCreator != object.isUserDogsCreator) {
            return i2;
        }
        if (this.isLastDog != object.isLastDog) {
            return i2;
        }
        if (this.isParticipateBannerVisible != object.isParticipateBannerVisible) {
            return i2;
        }
        if (this.fullScreen != object.fullScreen) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (this.longestStreak != object.longestStreak) {
            return i2;
        }
        if (Long.compare(timeTrained, timeTrained2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogProfile getDogProfile() {
        return this.dogProfile;
    }

    @Override // android.os.Parcelable
    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    @Override // android.os.Parcelable
    public final int getLongestStreak() {
        return this.longestStreak;
    }

    @Override // android.os.Parcelable
    public final long getTimeTrained() {
        return this.timeTrained;
    }

    @Override // android.os.Parcelable
    public final boolean getUserPremium() {
        return this.userPremium;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean userPremium;
        boolean isUserDogsCreator;
        boolean isLastDog;
        boolean isParticipateBannerVisible;
        boolean i;
        i = 1;
        if (this.userPremium) {
            userPremium = i;
        }
        if (this.isUserDogsCreator) {
            isUserDogsCreator = i;
        }
        if (this.isLastDog) {
            isLastDog = i;
        }
        if (this.isParticipateBannerVisible) {
            isParticipateBannerVisible = i;
        }
        boolean fullScreen = this.fullScreen;
        if (fullScreen) {
        } else {
            i = fullScreen;
        }
        return i17 += i21;
    }

    @Override // android.os.Parcelable
    public final boolean isLastDog() {
        return this.isLastDog;
    }

    @Override // android.os.Parcelable
    public final boolean isParticipateBannerVisible() {
        return this.isParticipateBannerVisible;
    }

    @Override // android.os.Parcelable
    public final boolean isUserDogsCreator() {
        return this.isUserDogsCreator;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProfilePreview(dogProfile=");
        stringBuilder.append(this.dogProfile);
        stringBuilder.append(", userPremium=");
        stringBuilder.append(this.userPremium);
        stringBuilder.append(", isUserDogsCreator=");
        stringBuilder.append(this.isUserDogsCreator);
        stringBuilder.append(", isLastDog=");
        stringBuilder.append(this.isLastDog);
        stringBuilder.append(", isParticipateBannerVisible=");
        stringBuilder.append(this.isParticipateBannerVisible);
        stringBuilder.append(", fullScreen=");
        stringBuilder.append(this.fullScreen);
        stringBuilder.append(", currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", longestStreak=");
        stringBuilder.append(this.longestStreak);
        stringBuilder.append(", timeTrained=");
        stringBuilder.append(this.timeTrained);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.dogProfile.writeToParcel(parcel, i2);
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
