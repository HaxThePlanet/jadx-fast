package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: RemoteDogModel.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 +2\u00020\u0001:\u0001+BY\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u00082\u0008\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\r¨\u0006,", d2 = {"Lapp/dogo/externalmodel/model/RemoteDogModel;", "Landroid/os/Parcelable;", "name", "", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCustomBreed", "getGender", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/externalmodel/model/RemoteDogModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RemoteDogModel implements Parcelable {

    public static final Parcelable.Creator<RemoteDogModel> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final RemoteDogModel.Companion INSTANCE = null;
    public static final String DOG_GENDER_FEMALE = "female";
    public static final String DOG_GENDER_MALE = "male";
    public static final String DOG_GENDER_OTHER = "other";
    private final String avatarUrl;
    private final String birthday;
    private final Boolean birthdayExact;
    private final String breedId;
    private final String customBreed;
    private final String gender;
    private final String name;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/externalmodel/model/RemoteDogModel$Companion;", "", "()V", "DOG_GENDER_FEMALE", "", "DOG_GENDER_MALE", "DOG_GENDER_OTHER", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RemoteDogModel> {
        @Override // android.os.Parcelable$Creator
        public final RemoteDogModel createFromParcel(Parcel parcel) {
            boolean z = false;
            Boolean str = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                int r1 = parcel.readInt() != 0 ? 1 : 0;
                str = Boolean.valueOf((parcel.readInt() != 0 ? 1 : 0));
            }
            RemoteDogModel remoteDogModel = new RemoteDogModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), str, parcel.readString(), parcel.readString());
            return remoteDogModel;
        }

        @Override // android.os.Parcelable$Creator
        public final RemoteDogModel[] newArray(int i) {
            return new RemoteDogModel[i];
        }
    }
    public RemoteDogModel(String str, String str2, String str3, String str4, Boolean boolean, String str5, String str6) {
        super();
        this.name = str;
        this.breedId = str2;
        this.customBreed = str3;
        this.birthday = str4;
        this.birthdayExact = boolean;
        this.gender = str5;
        this.avatarUrl = str6;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final Boolean getBirthdayExact() {
        return this.birthdayExact;
    }

    public final String getBreedId() {
        return this.breedId;
    }

    public final String getCustomBreed() {
        return this.customBreed;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ RemoteDogModel(String str, String str2, String str3, String str4, Boolean boolean, String str5, String str6, int i, g gVar) {
        int str22;
        String str72;
        str22 = 0;
        gVar = i & 1 != 0 ? str22 : str;
        int r1 = i & 2 != 0 ? str22 : str2;
        int r2 = i & 4 != 0 ? str22 : str3;
        int r3 = i & 8 != 0 ? str22 : str4;
        int r4 = i & 16 != 0 ? str22 : boolean;
        int r5 = i & 32 != 0 ? str22 : str5;
        i = i & 64 != 0 ? str22 : str6;
        this(str22, str22, str22, str22, str22, str22, (i & 64 != 0 ? str22 : str6));
    }

    static {
        RemoteDogModel.INSTANCE = new RemoteDogModel_Companion(null);
        RemoteDogModel.CREATOR = new RemoteDogModel.Creator();
    }

    public RemoteDogModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RemoteDogModel copy$default(RemoteDogModel remoteDogModel, String str, String str2, String str3, String str4, Boolean boolean, String str5, String str6, int i, Object object) {
        String str22;
        String object102;
        String str42;
        String str52;
        Boolean boolean62;
        String str72;
        String str82;
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
        if (i & 64 != 0) {
        }
        return remoteDogModel.copy(str22, object102, str42, str52, boolean62, str72, str82);
    }

    /* operator */ public final String component1() {
        return this.name;
    }

    /* operator */ public final String component2() {
        return this.breedId;
    }

    /* operator */ public final String component3() {
        return this.customBreed;
    }

    /* operator */ public final String component4() {
        return this.birthday;
    }

    /* operator */ public final Boolean component5() {
        return this.birthdayExact;
    }

    /* operator */ public final String component6() {
        return this.gender;
    }

    /* operator */ public final String component7() {
        return this.avatarUrl;
    }

    public final RemoteDogModel copy(String name, String breedId, String customBreed, String birthday, Boolean birthdayExact, String gender, String avatarUrl) {
        RemoteDogModel remoteDogModel = new RemoteDogModel(name, breedId, customBreed, birthday, birthdayExact, gender, avatarUrl);
        return remoteDogModel;
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
        final boolean z9 = false;
        if (!(other instanceof RemoteDogModel)) {
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
        if (!n.b(this.birthday, other.birthday)) {
            return false;
        }
        if (!n.b(this.birthdayExact, other.birthdayExact)) {
            return false;
        }
        if (!n.b(this.gender, other.gender)) {
            return false;
        }
        return !n.b(this.avatarUrl, other.avatarUrl) ? z9 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.name == null) {
        } else {
            i = this.name.hashCode();
        }
        if (this.breedId == null) {
        } else {
            i = this.breedId.hashCode();
        }
        if (this.customBreed == null) {
        } else {
            i = this.customBreed.hashCode();
        }
        if (this.birthday == null) {
        } else {
            i = this.birthday.hashCode();
        }
        if (this.birthdayExact == null) {
        } else {
            i = this.birthdayExact.hashCode();
        }
        if (this.gender == null) {
        } else {
            i = this.gender.hashCode();
        }
        if (this.avatarUrl != null) {
            i = this.avatarUrl.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RemoteDogModel(name=";
        String str3 = ", breedId=";
        String str4 = ", customBreed=";
        String str5 = ", birthday=";
        String str6 = ", birthdayExact=";
        String str7 = ", gender=";
        String str8 = ", avatarUrl=";
        str = str2 + this.name + str3 + this.breedId + str4 + this.customBreed + str5 + this.birthday + str6 + this.birthdayExact + str7 + this.gender + str8 + this.avatarUrl + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int i2 = 0;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.birthday);
        if (this.birthdayExact == null) {
            i2 = 0;
        } else {
            int i = 1;
            parcel.writeInt(i);
            boolean booleanValue = this.birthdayExact.booleanValue();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.gender);
        parcel.writeString(this.avatarUrl);
    }
}
