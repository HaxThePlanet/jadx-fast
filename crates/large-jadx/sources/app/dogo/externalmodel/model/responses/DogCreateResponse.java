package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogCreateResponse.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/DogCreateResponse;", "Landroid/os/Parcelable;", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "(Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;)V", "getDog", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogCreateResponse implements Parcelable {

    public static final Parcelable.Creator<DogCreateResponse> CREATOR = new DogCreateResponse$Creator<>();
    private final UserApiModel.DogApiModel dog;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogCreateResponse> {
        @Override // android.os.Parcelable$Creator
        public final DogCreateResponse createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogCreateResponse((UserApiModel_DogApiModel)UserApiModel_DogApiModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final DogCreateResponse[] newArray(int i) {
            return new DogCreateResponse[i];
        }
    }
    public DogCreateResponse(UserApiModel.DogApiModel dogApiModel) {
        n.f(dogApiModel, "dog");
        super();
        this.dog = dogApiModel;
    }

    public final UserApiModel.DogApiModel getDog() {
        return this.dog;
    }


    public static /* synthetic */ DogCreateResponse copy$default(DogCreateResponse dogCreateResponse, UserApiModel.DogApiModel dogApiModel, int i, Object object) {
        app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel dog2;
        if (i & 1 != 0) {
        }
        return dogCreateResponse.copy(dog2);
    }

    /* operator */ public final UserApiModel.DogApiModel component1() {
        return this.dog;
    }

    public final DogCreateResponse copy(UserApiModel.DogApiModel dog) {
        n.f(dog, "dog");
        return new DogCreateResponse(dog);
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
        final boolean z3 = false;
        if (!(other instanceof DogCreateResponse)) {
            return false;
        }
        return !n.b(this.dog, other.dog) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.dog.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogCreateResponse(dog=";
        str = str2 + this.dog + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.dog.writeToParcel(parcel, flags);
    }
}
