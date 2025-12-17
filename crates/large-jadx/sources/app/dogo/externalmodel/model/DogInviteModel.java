package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/DogInviteModel;", "Landroid/os/Parcelable;", "id", "", "inviterName", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;)V", "getDog", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "getId", "()Ljava/lang/String;", "getInviterName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogInviteModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.DogInviteModel> CREATOR;
    private final UserApiModel.PublicApiDogModel dog;
    private final String id;
    private final String inviterName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.DogInviteModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.DogInviteModel createFromParcel(Parcel parcel) {
            int cREATOR;
            int obj5;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                obj5 = 0;
            } else {
                obj5 = UserApiModel.PublicApiDogModel.CREATOR.createFromParcel(parcel);
            }
            DogInviteModel dogInviteModel = new DogInviteModel(parcel.readString(), parcel.readString(), (UserApiModel.PublicApiDogModel)obj5);
            return dogInviteModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.DogInviteModel[] newArray(int i) {
            return new DogInviteModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogInviteModel.Creator creator = new DogInviteModel.Creator();
        DogInviteModel.CREATOR = creator;
    }

    public DogInviteModel() {
        super(0, 0, 0, 7, 0);
    }

    public DogInviteModel(String string, String string2, UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel3) {
        super();
        this.id = string;
        this.inviterName = string2;
        this.dog = publicApiDogModel3;
    }

    public DogInviteModel(String string, String string2, UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel3, int i4, g g5) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        obj2 = i4 & 1 != 0 ? i : obj2;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.externalmodel.model.DogInviteModel copy$default(app.dogo.externalmodel.model.DogInviteModel dogInviteModel, String string2, String string3, UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel4, int i5, Object object6) {
        String obj1;
        String obj2;
        UserApiModel.PublicApiDogModel obj3;
        if (i5 & 1 != 0) {
            obj1 = dogInviteModel.id;
        }
        if (i5 & 2 != 0) {
            obj2 = dogInviteModel.inviterName;
        }
        if (i5 &= 4 != 0) {
            obj3 = dogInviteModel.dog;
        }
        return dogInviteModel.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.inviterName;
    }

    @Override // android.os.Parcelable
    public final UserApiModel.PublicApiDogModel component3() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.DogInviteModel copy(String string, String string2, UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel3) {
        DogInviteModel dogInviteModel = new DogInviteModel(string, string2, publicApiDogModel3);
        return dogInviteModel;
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
        if (!object instanceof DogInviteModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.inviterName, object.inviterName)) {
            return i2;
        }
        if (!n.b(this.dog, object.dog)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final UserApiModel.PublicApiDogModel getDog() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getInviterName() {
        return this.inviterName;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i3;
        int i2;
        String str = this.id;
        i3 = 0;
        if (str == null) {
            i = i3;
        } else {
            i = str.hashCode();
        }
        String inviterName = this.inviterName;
        if (inviterName == null) {
            i2 = i3;
        } else {
            i2 = inviterName.hashCode();
        }
        UserApiModel.PublicApiDogModel dog = this.dog;
        if (dog == null) {
        } else {
            i3 = dog.hashCode();
        }
        return i6 += i3;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogInviteModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", inviterName=");
        stringBuilder.append(this.inviterName);
        stringBuilder.append(", dog=");
        stringBuilder.append(this.dog);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.inviterName);
        UserApiModel.PublicApiDogModel dog = this.dog;
        if (dog == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dog.writeToParcel(parcel, i2);
        }
    }
}
