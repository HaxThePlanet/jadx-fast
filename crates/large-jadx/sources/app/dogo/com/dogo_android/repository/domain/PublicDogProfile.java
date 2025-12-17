package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 )2\u00020\u0001:\u0001)B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "Landroid/os/Parcelable;", "id", "", "name", "breedId", "customBreed", "avatarUrl", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/DogGender;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBreedId", "getCustomBreed", "getGender", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toDogModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PublicDogProfile implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PublicDogProfile> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.PublicDogProfile.Companion Companion;
    private final String avatarUrl;
    private final String breedId;
    private final String customBreed;
    private final d gender;
    private final String id;
    private final String name;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile$Companion;", "", "()V", "fromApiModel", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.PublicDogProfile fromApiModel(UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel) {
            Object obj;
            String str2;
            String str4;
            String str6;
            String str10;
            String str7;
            String str;
            String str5;
            String str3;
            String str8;
            d dVar;
            String str9;
            app.dogo.com.dogo_android.repository.domain.PublicDogProfile publicDogProfile;
            int obj9;
            n.f(publicApiDogModel, "dog");
            if (publicApiDogModel.getId() == null) {
                obj9 = 0;
            } else {
                str2 = publicApiDogModel.getId();
                n.d(str2);
                String name = publicApiDogModel.getName();
                str6 = "";
                str7 = name == null ? str6 : name;
                String breedId = publicApiDogModel.getBreedId();
                str5 = breedId == null ? str6 : breedId;
                String customBreed = publicApiDogModel.getCustomBreed();
                str8 = customBreed == null ? str6 : customBreed;
                String avatarUrl = publicApiDogModel.getAvatarUrl();
                str9 = avatarUrl == null ? str6 : avatarUrl;
                obj9 = publicApiDogModel.getGender();
                if (obj9 == null) {
                } else {
                    str6 = obj9;
                }
                super(str2, str7, str5, str8, str9, d.Companion.a(str6));
                obj9 = publicDogProfile;
            }
            return obj9;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.PublicDogProfile> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PublicDogProfile createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), d.valueOf(parcel.readString()));
            return publicDogProfile;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.PublicDogProfile[] newArray(int i) {
            return new PublicDogProfile[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        PublicDogProfile.Companion companion = new PublicDogProfile.Companion(0);
        PublicDogProfile.Companion = companion;
        PublicDogProfile.Creator creator = new PublicDogProfile.Creator();
        PublicDogProfile.CREATOR = creator;
    }

    public PublicDogProfile(String string, String string2, String string3, String string4, String string5, d d6) {
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "breedId");
        n.f(string4, "customBreed");
        n.f(string5, "avatarUrl");
        n.f(d6, "gender");
        super();
        this.id = string;
        this.name = string2;
        this.breedId = string3;
        this.customBreed = string4;
        this.avatarUrl = string5;
        this.gender = d6;
    }

    public PublicDogProfile(String string, String string2, String string3, String string4, String string5, d d6, int i7, g g8) {
        String str;
        String str4;
        String str2;
        String str3;
        d uNKNOWN;
        str4 = "";
        str = i7 & 2 != 0 ? str4 : string2;
        str2 = i7 & 4 != 0 ? str4 : string3;
        str3 = i7 & 8 != 0 ? str4 : string4;
        if (i7 & 16 != 0) {
        } else {
            str4 = string5;
        }
        uNKNOWN = i7 & 32 != 0 ? d.UNKNOWN : d6;
        super(string, str, str2, str3, str4, uNKNOWN);
    }

    public static app.dogo.com.dogo_android.repository.domain.PublicDogProfile copy$default(app.dogo.com.dogo_android.repository.domain.PublicDogProfile publicDogProfile, String string2, String string3, String string4, String string5, String string6, d d7, int i8, Object object9) {
        String obj5;
        String obj6;
        String obj7;
        String obj8;
        String obj9;
        d obj10;
        if (i8 & 1 != 0) {
            obj5 = publicDogProfile.id;
        }
        if (i8 & 2 != 0) {
            obj6 = publicDogProfile.name;
        }
        if (i8 & 4 != 0) {
            obj7 = publicDogProfile.breedId;
        }
        if (i8 & 8 != 0) {
            obj8 = publicDogProfile.customBreed;
        }
        if (i8 & 16 != 0) {
            obj9 = publicDogProfile.avatarUrl;
        }
        if (i8 & 32 != 0) {
            obj10 = publicDogProfile.gender;
        }
        return publicDogProfile.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.breedId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.customBreed;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.avatarUrl;
    }

    @Override // android.os.Parcelable
    public final d component6() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.PublicDogProfile copy(String string, String string2, String string3, String string4, String string5, d d6) {
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "breedId");
        n.f(string4, "customBreed");
        n.f(string5, "avatarUrl");
        n.f(d6, "gender");
        super(string, string2, string3, string4, string5, d6);
        return publicDogProfile;
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
        if (object instanceof PublicDogProfile == null) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.breedId, object.breedId)) {
            return i2;
        }
        if (!n.b(this.customBreed, object.customBreed)) {
            return i2;
        }
        if (!n.b(this.avatarUrl, object.avatarUrl)) {
            return i2;
        }
        if (this.gender != object.gender) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Override // android.os.Parcelable
    public final String getBreedId() {
        return this.breedId;
    }

    @Override // android.os.Parcelable
    public final String getCustomBreed() {
        return this.customBreed;
    }

    @Override // android.os.Parcelable
    public final d getGender() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i10 += i16;
    }

    @Override // android.os.Parcelable
    public final DogProfileModel toDogModel() {
        int name;
        int breedId;
        int customBreed;
        int avatarUrl;
        int i3;
        int i2;
        int i;
        String str;
        String str2;
        final Object obj = this;
        i3 = 1;
        int i5 = 0;
        name = obj.name.length() == 0 ? i3 : i5;
        int i6 = 0;
        i = name != null ? i6 : name;
        breedId = obj.breedId.length() == 0 ? i3 : i5;
        str = breedId != 0 ? i6 : breedId;
        customBreed = obj.customBreed.length() == 0 ? i3 : i5;
        str2 = customBreed != 0 ? i6 : customBreed;
        if (obj.avatarUrl.length() == 0) {
        } else {
            i3 = i5;
        }
        i2 = i3 != 0 ? i6 : avatarUrl;
        super(i, i2, str, str2, 0, 0, obj.gender.ordinal(), obj.id, 0, 0, 0, 1840, 0);
        return dogProfileModel2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PublicDogProfile(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", breedId=");
        stringBuilder.append(this.breedId);
        stringBuilder.append(", customBreed=");
        stringBuilder.append(this.customBreed);
        stringBuilder.append(", avatarUrl=");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.gender.name());
    }
}
