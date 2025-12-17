package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/requests/DogUpdateRequest;", "Landroid/os/Parcelable;", "dog", "Lapp/dogo/externalmodel/model/requests/DogUpdateRequest$WritableDogData;", "(Lapp/dogo/externalmodel/model/requests/DogUpdateRequest$WritableDogData;)V", "getDog", "()Lapp/dogo/externalmodel/model/requests/DogUpdateRequest$WritableDogData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WritableDogData", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogUpdateRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogUpdateRequest> CREATOR;
    private final app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData dog;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.DogUpdateRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogUpdateRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogUpdateRequest dogUpdateRequest = new DogUpdateRequest((DogUpdateRequest.WritableDogData)DogUpdateRequest.WritableDogData.CREATOR.createFromParcel(parcel));
            return dogUpdateRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.DogUpdateRequest[] newArray(int i) {
            return new DogUpdateRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BY\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u00082\u0008\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\r¨\u0006+", d2 = {"Lapp/dogo/externalmodel/model/requests/DogUpdateRequest$WritableDogData;", "Landroid/os/Parcelable;", "name", "", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCustomBreed", "getGender", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/externalmodel/model/requests/DogUpdateRequest$WritableDogData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WritableDogData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData> CREATOR;
        private final String avatarUrl;
        private final String birthday;
        private final Boolean birthdayExact;
        private final String breedId;
        private final String customBreed;
        private final String gender;
        private final String name;
        static {
            DogUpdateRequest.WritableDogData.Creator creator = new DogUpdateRequest.WritableDogData.Creator();
            DogUpdateRequest.WritableDogData.CREATOR = creator;
        }

        public WritableDogData() {
            super(0, 0, 0, 0, 0, 0, 0, 127, 0);
        }

        public WritableDogData(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7) {
            super();
            this.name = string;
            this.breedId = string2;
            this.customBreed = string3;
            this.birthday = string4;
            this.birthdayExact = boolean5;
            this.gender = string6;
            this.avatarUrl = string7;
        }

        public WritableDogData(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7, int i8, g g9) {
            int i;
            int i2;
            int i4;
            int i3;
            int i5;
            int obj14;
            int obj15;
            final int i6 = 0;
            obj15 = i8 & 1 != 0 ? i6 : string;
            i = i8 & 2 != 0 ? i6 : string2;
            i2 = i8 & 4 != 0 ? i6 : string3;
            i4 = i8 & 8 != 0 ? i6 : string4;
            i3 = i8 & 16 != 0 ? i6 : boolean5;
            i5 = i8 & 32 != 0 ? i6 : string6;
            obj14 = i8 & 64 != 0 ? i6 : string7;
            super(obj15, i, i2, i4, i3, i5, obj14);
        }

        public static app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData copy$default(app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData dogUpdateRequest$WritableDogData, String string2, String string3, String string4, String string5, Boolean boolean6, String string7, String string8, int i9, Object object10) {
            String obj6;
            String obj7;
            String obj8;
            String obj9;
            Boolean obj10;
            String obj11;
            String obj12;
            if (i9 & 1 != 0) {
                obj6 = writableDogData.name;
            }
            if (i9 & 2 != 0) {
                obj7 = writableDogData.breedId;
            }
            if (i9 & 4 != 0) {
                obj8 = writableDogData.customBreed;
            }
            if (i9 & 8 != 0) {
                obj9 = writableDogData.birthday;
            }
            if (i9 & 16 != 0) {
                obj10 = writableDogData.birthdayExact;
            }
            if (i9 & 32 != 0) {
                obj11 = writableDogData.gender;
            }
            if (i9 & 64 != 0) {
                obj12 = writableDogData.avatarUrl;
            }
            return writableDogData.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
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
        public final app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData copy(String string, String string2, String string3, String string4, Boolean boolean5, String string6, String string7) {
            super(string, string2, string3, string4, boolean5, string6, string7);
            return writableDogData;
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
            if (object instanceof DogUpdateRequest.WritableDogData == null) {
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
            int i5;
            int i6;
            int i7;
            int i3;
            int i2;
            int i4;
            int i;
            String name = this.name;
            i6 = 0;
            if (name == null) {
                i5 = i6;
            } else {
                i5 = name.hashCode();
            }
            String breedId = this.breedId;
            if (breedId == null) {
                i7 = i6;
            } else {
                i7 = breedId.hashCode();
            }
            String customBreed = this.customBreed;
            if (customBreed == null) {
                i3 = i6;
            } else {
                i3 = customBreed.hashCode();
            }
            String birthday = this.birthday;
            if (birthday == null) {
                i2 = i6;
            } else {
                i2 = birthday.hashCode();
            }
            Boolean birthdayExact = this.birthdayExact;
            if (birthdayExact == null) {
                i4 = i6;
            } else {
                i4 = birthdayExact.hashCode();
            }
            String gender = this.gender;
            if (gender == null) {
                i = i6;
            } else {
                i = gender.hashCode();
            }
            String avatarUrl = this.avatarUrl;
            if (avatarUrl == null) {
            } else {
                i6 = avatarUrl.hashCode();
            }
            return i18 += i6;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WritableDogData(name=");
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
    static {
        DogUpdateRequest.Creator creator = new DogUpdateRequest.Creator();
        DogUpdateRequest.CREATOR = creator;
    }

    public DogUpdateRequest(app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData dogUpdateRequest$WritableDogData) {
        n.f(writableDogData, "dog");
        super();
        this.dog = writableDogData;
    }

    public static app.dogo.externalmodel.model.requests.DogUpdateRequest copy$default(app.dogo.externalmodel.model.requests.DogUpdateRequest dogUpdateRequest, app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData dogUpdateRequest$WritableDogData2, int i3, Object object4) {
        app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData obj1;
        if (i3 &= 1 != 0) {
            obj1 = dogUpdateRequest.dog;
        }
        return dogUpdateRequest.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData component1() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogUpdateRequest copy(app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData dogUpdateRequest$WritableDogData) {
        n.f(writableDogData, "dog");
        DogUpdateRequest dogUpdateRequest = new DogUpdateRequest(writableDogData);
        return dogUpdateRequest;
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
        if (object instanceof DogUpdateRequest == null) {
            return i2;
        }
        if (!n.b(this.dog, object.dog)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.DogUpdateRequest.WritableDogData getDog() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.dog.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogUpdateRequest(dog=");
        stringBuilder.append(this.dog);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.dog.writeToParcel(parcel, i2);
    }
}
