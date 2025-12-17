package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 +2\u00020\u0001:\u0001+BY\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u00082\u0008\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\r¨\u0006,", d2 = {"Lapp/dogo/externalmodel/model/RemoteDogModel;", "Landroid/os/Parcelable;", "name", "", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCustomBreed", "getGender", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/externalmodel/model/RemoteDogModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RemoteDogModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.RemoteDogModel> CREATOR = null;
    public static final app.dogo.externalmodel.model.RemoteDogModel.Companion Companion = null;
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
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.RemoteDogModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.RemoteDogModel createFromParcel(Parcel parcel) {
            int i;
            int valueOf;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = 0;
            } else {
                i = parcel.readInt() != 0 ? 1 : 0;
                valueOf = Boolean.valueOf(i);
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), valueOf, parcel.readString(), parcel.readString());
            return remoteDogModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.RemoteDogModel[] newArray(int i) {
            return new RemoteDogModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        RemoteDogModel.Companion companion = new RemoteDogModel.Companion(0);
        RemoteDogModel.Companion = companion;
        RemoteDogModel.Creator creator = new RemoteDogModel.Creator();
        RemoteDogModel.CREATOR = creator;
    }

    public RemoteDogModel() {
        super(0, 0, 0, 0, 0, 0, 0, 127, 0);
    }

    public RemoteDogModel(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7) {
        super();
        this.name = string;
        this.breedId = string2;
        this.customBreed = string3;
        this.birthday = string4;
        this.birthdayExact = boolean5;
        this.gender = string6;
        this.avatarUrl = string7;
    }

    public RemoteDogModel(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7, int i8, g g9) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int obj14;
        int obj15;
        final int i6 = 0;
        obj15 = i8 & 1 != 0 ? i6 : string;
        i = i8 & 2 != 0 ? i6 : string2;
        i2 = i8 & 4 != 0 ? i6 : string3;
        i3 = i8 & 8 != 0 ? i6 : string4;
        i4 = i8 & 16 != 0 ? i6 : boolean5;
        i5 = i8 & 32 != 0 ? i6 : string6;
        obj14 = i8 & 64 != 0 ? i6 : string7;
        super(obj15, i, i2, i3, i4, i5, obj14);
    }

    public static app.dogo.externalmodel.model.RemoteDogModel copy$default(app.dogo.externalmodel.model.RemoteDogModel remoteDogModel, String string2, String string3, String string4, String string5, Boolean boolean6, String string7, String string8, int i9, Object object10) {
        String obj6;
        String obj7;
        String obj8;
        String obj9;
        Boolean obj10;
        String obj11;
        String obj12;
        if (i9 & 1 != 0) {
            obj6 = remoteDogModel.name;
        }
        if (i9 & 2 != 0) {
            obj7 = remoteDogModel.breedId;
        }
        if (i9 & 4 != 0) {
            obj8 = remoteDogModel.customBreed;
        }
        if (i9 & 8 != 0) {
            obj9 = remoteDogModel.birthday;
        }
        if (i9 & 16 != 0) {
            obj10 = remoteDogModel.birthdayExact;
        }
        if (i9 & 32 != 0) {
            obj11 = remoteDogModel.gender;
        }
        if (i9 & 64 != 0) {
            obj12 = remoteDogModel.avatarUrl;
        }
        return remoteDogModel.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.breedId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.customBreed;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.birthday;
    }

    @Override // android.os.Parcelable
    public final Boolean component5() {
        return this.birthdayExact;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.avatarUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.RemoteDogModel copy(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7) {
        super(string, string2, string3, string4, boolean5, string6, string7);
        return remoteDogModel2;
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
        if (!object instanceof RemoteDogModel) {
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
        if (!n.b(this.birthday, object.birthday)) {
            return i2;
        }
        if (!n.b(this.birthdayExact, object.birthdayExact)) {
            return i2;
        }
        if (!n.b(this.gender, object.gender)) {
            return i2;
        }
        if (!n.b(this.avatarUrl, object.avatarUrl)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Override // android.os.Parcelable
    public final String getBirthday() {
        return this.birthday;
    }

    @Override // android.os.Parcelable
    public final Boolean getBirthdayExact() {
        return this.birthdayExact;
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
    public final String getGender() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i4;
        int i;
        int i2;
        int i3;
        int i5;
        int i6;
        int i7;
        String name = this.name;
        i = 0;
        if (name == null) {
            i4 = i;
        } else {
            i4 = name.hashCode();
        }
        String breedId = this.breedId;
        if (breedId == null) {
            i2 = i;
        } else {
            i2 = breedId.hashCode();
        }
        String customBreed = this.customBreed;
        if (customBreed == null) {
            i3 = i;
        } else {
            i3 = customBreed.hashCode();
        }
        String birthday = this.birthday;
        if (birthday == null) {
            i5 = i;
        } else {
            i5 = birthday.hashCode();
        }
        Boolean birthdayExact = this.birthdayExact;
        if (birthdayExact == null) {
            i6 = i;
        } else {
            i6 = birthdayExact.hashCode();
        }
        String gender = this.gender;
        if (gender == null) {
            i7 = i;
        } else {
            i7 = gender.hashCode();
        }
        String avatarUrl = this.avatarUrl;
        if (avatarUrl == null) {
        } else {
            i = avatarUrl.hashCode();
        }
        return i18 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RemoteDogModel(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", breedId=");
        stringBuilder.append(this.breedId);
        stringBuilder.append(", customBreed=");
        stringBuilder.append(this.customBreed);
        stringBuilder.append(", birthday=");
        stringBuilder.append(this.birthday);
        stringBuilder.append(", birthdayExact=");
        stringBuilder.append(this.birthdayExact);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", avatarUrl=");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj3;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.birthday);
        obj3 = this.birthdayExact;
        if (obj3 == null) {
            obj3 = 0;
        } else {
            parcel.writeInt(1);
            obj3 = obj3.booleanValue();
        }
        parcel.writeInt(obj3);
        parcel.writeString(this.gender);
        parcel.writeString(this.avatarUrl);
    }
}
