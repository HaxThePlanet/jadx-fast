package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogInviteModel.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/DogInviteModel;", "Landroid/os/Parcelable;", "id", "", "inviterName", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;)V", "getDog", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "getId", "()Ljava/lang/String;", "getInviterName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogInviteModel implements Parcelable {

    public static final Parcelable.Creator<DogInviteModel> CREATOR = new DogInviteModel$Creator<>();
    private final UserApiModel.PublicApiDogModel dog;
    private final String id;
    private final String inviterName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogInviteModel> {
        @Override // android.os.Parcelable$Creator
        public final DogInviteModel createFromParcel(Parcel parcel) {
            UserApiModel.PublicApiDogModel publicApiDogModel = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = UserApiModel_PublicApiDogModel.CREATOR.createFromParcel(parcel);
            }
            DogInviteModel dogInviteModel = new DogInviteModel(parcel.readString(), parcel.readString(), (UserApiModel_PublicApiDogModel)publicApiDogModel);
            return dogInviteModel;
        }

        @Override // android.os.Parcelable$Creator
        public final DogInviteModel[] newArray(int i) {
            return new DogInviteModel[i];
        }
    }
    public DogInviteModel(String str, String str2, UserApiModel.PublicApiDogModel publicApiDogModel) {
        super();
        this.id = str;
        this.inviterName = str2;
        this.dog = publicApiDogModel;
    }

    public final UserApiModel.PublicApiDogModel getDog() {
        return this.dog;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInviterName() {
        return this.inviterName;
    }

    public /* synthetic */ DogInviteModel(String str, String str2, UserApiModel.PublicApiDogModel publicApiDogModel, int i, g gVar) {
        String str3;
        String str4;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(str3, str4, publicApiDogModel);
    }


    public DogInviteModel() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DogInviteModel copy$default(DogInviteModel dogInviteModel, String str, String str2, UserApiModel.PublicApiDogModel publicApiDogModel, int i, Object object) {
        String id2;
        String inviterName2;
        UserApiModel.PublicApiDogModel dog2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return dogInviteModel.copy(id2, inviterName2, dog2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.inviterName;
    }

    /* operator */ public final UserApiModel.PublicApiDogModel component3() {
        return this.dog;
    }

    public final DogInviteModel copy(String id, String inviterName, UserApiModel.PublicApiDogModel dog) {
        return new DogInviteModel(id, inviterName, dog);
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
        final boolean z5 = false;
        if (!(other instanceof DogInviteModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.inviterName, other.inviterName)) {
            return false;
        }
        return !n.b(this.dog, other.dog) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.id == null) {
        } else {
            i = this.id.hashCode();
        }
        if (this.inviterName == null) {
        } else {
            i = this.inviterName.hashCode();
        }
        if (this.dog != null) {
            i = this.dog.hashCode();
        }
        return (i * 31) + i * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogInviteModel(id=";
        String str3 = ", inviterName=";
        String str4 = ", dog=";
        str = str2 + this.id + str3 + this.inviterName + str4 + this.dog + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.inviterName);
        if (this.dog == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.dog.writeToParcel(parcel, flags);
        }
    }
}
