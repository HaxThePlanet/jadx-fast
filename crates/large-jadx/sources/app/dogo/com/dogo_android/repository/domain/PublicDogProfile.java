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

/* compiled from: PublicDogProfile.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 )2\u00020\u0001:\u0001)B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006*", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "Landroid/os/Parcelable;", "id", "", "name", "breedId", "customBreed", "avatarUrl", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/enums/DogGender;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBreedId", "getCustomBreed", "getGender", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toDogModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PublicDogProfile implements Parcelable {

    public static final Parcelable.Creator<PublicDogProfile> CREATOR = new PublicDogProfile$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PublicDogProfile.Companion INSTANCE = new PublicDogProfile$Companion(0);
    private final String avatarUrl;
    private final String breedId;
    private final String customBreed;
    private final d gender;
    private final String id;
    private final String name;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile$Companion;", "", "()V", "fromApiModel", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final PublicDogProfile fromApiModel(UserApiModel.PublicApiDogModel dog) {
            String dog2;
            int i = 0;
            n.f(dog, "dog");
            if (dog.getId() == null) {
                i = 0;
            } else {
                String str2 = dog.getId();
                n.d(str2);
                dog2 = dog.getName();
                dog2 = "";
                String r3 = dog2;
                dog2 = dog.getBreedId();
                String r4 = dog2;
                dog2 = dog.getCustomBreed();
                String r5 = dog2;
                dog2 = dog.getAvatarUrl();
                String r6 = dog2;
                dog2 = dog.getGender();
                if (dog2 != null) {
                }
                PublicDogProfile publicDogProfile = new PublicDogProfile(str2, dog2, dog2, dog2, dog2, dog3);
            }
            return i;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PublicDogProfile> {
        @Override // android.os.Parcelable$Creator
        public final PublicDogProfile createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            PublicDogProfile publicDogProfile = new PublicDogProfile(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), DogGender.valueOf(parcel.readString()));
            return publicDogProfile;
        }

        @Override // android.os.Parcelable$Creator
        public final PublicDogProfile[] newArray(int i) {
            return new PublicDogProfile[i];
        }
    }
    public PublicDogProfile(String str, String str2, String str3, String str4, String str5, d dVar) {
        n.f(str, "id");
        n.f(str2, "name");
        n.f(str3, "breedId");
        n.f(str4, "customBreed");
        n.f(str5, "avatarUrl");
        n.f(dVar, "gender");
        super();
        this.id = str;
        this.name = str2;
        this.breedId = str3;
        this.customBreed = str4;
        this.avatarUrl = str5;
        this.gender = dVar;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getBreedId() {
        return this.breedId;
    }

    public final String getCustomBreed() {
        return this.customBreed;
    }

    public final d getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final DogProfileModel toDogModel() {
        int i;
        String avatarUrl2;
        int i2;
        String breedId2;
        String customBreed2;
        final Object obj = this;
        i = 1;
        i = 0;
        int r1 = i;
        i2 = 0;
        i2 = obj.name != 0 ? i2 : name2;
        r1 = i;
        i2 = obj.breedId != 0 ? i2 : breedId2;
        r1 = i;
        i2 = obj.breedId != 0 ? i2 : customBreed2;
        if (obj.avatarUrl.length() != 0) {
        }
        i2 = i != 0 ? i2 : avatarUrl2;
        DogProfileModel dogProfileModel = new DogProfileModel(i2, avatarUrl2, breedId2, customBreed2, null, null, obj.gender.ordinal(), obj.id, null, false, null, 1840, null);
        return dogProfileModel;
    }

    public /* synthetic */ PublicDogProfile(String str, String str2, String str3, String str4, String str5, d dVar, int i, g gVar) {
        String str22;
        d dVar62;
        str22 = "";
        String r0 = i & 2 != 0 ? str22 : str2;
        String r2 = i & 4 != 0 ? str22 : str3;
        String r3 = i & 8 != 0 ? str22 : str4;
        if (i & 16 == 0) {
            str22 = str5;
        }
        d r4 = i & 32 != 0 ? DogGender.UNKNOWN : dVar;
        this(str, str22, str22, str22, str22, (i & 32 != 0 ? DogGender.UNKNOWN : dVar));
    }


    public static /* synthetic */ PublicDogProfile copy$default(PublicDogProfile publicDogProfile, String str, String str2, String str3, String str4, String str5, d dVar, int i, Object object) {
        String str22;
        String object92;
        String str42;
        String str52;
        String str62;
        d dVar72;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        if (i & 32 != 0) {
        }
        return publicDogProfile.copy(str22, object92, str42, str52, str62, dVar72);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.breedId;
    }

    /* operator */ public final String component4() {
        return this.customBreed;
    }

    /* operator */ public final String component5() {
        return this.avatarUrl;
    }

    /* operator */ public final d component6() {
        return this.gender;
    }

    public final PublicDogProfile copy(String id, String name, String breedId, String customBreed, String avatarUrl, d gender) {
        n.f(id, "id");
        n.f(name, "name");
        n.f(breedId, "breedId");
        n.f(customBreed, "customBreed");
        n.f(avatarUrl, "avatarUrl");
        n.f(gender, "gender");
        PublicDogProfile publicDogProfile = new PublicDogProfile(id, name, breedId, customBreed, avatarUrl, gender);
        return publicDogProfile;
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
        final boolean z8 = false;
        if (!(other instanceof PublicDogProfile)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.breedId, other.breedId)) {
            return false;
        }
        if (!n.b(this.customBreed, other.customBreed)) {
            return false;
        }
        if (!n.b(this.avatarUrl, other.avatarUrl)) {
            return false;
        }
        return this.gender != other.gender ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.breedId.hashCode() * 31 + this.customBreed.hashCode() * 31 + this.avatarUrl.hashCode() * 31 + this.gender.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PublicDogProfile(id=";
        String str3 = ", name=";
        String str4 = ", breedId=";
        String str5 = ", customBreed=";
        String str6 = ", avatarUrl=";
        String str7 = ", gender=";
        str = str2 + this.id + str3 + this.name + str4 + this.breedId + str5 + this.customBreed + str6 + this.avatarUrl + str7 + this.gender + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.gender.name());
    }
}
