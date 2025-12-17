package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/DogCreateResponse;", "Landroid/os/Parcelable;", "dog", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "(Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;)V", "getDog", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogCreateResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogCreateResponse> CREATOR;
    private final app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel dog;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.DogCreateResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogCreateResponse createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogCreateResponse dogCreateResponse = new DogCreateResponse((UserApiModel.DogApiModel)UserApiModel.DogApiModel.CREATOR.createFromParcel(parcel));
            return dogCreateResponse;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogCreateResponse[] newArray(int i) {
            return new DogCreateResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogCreateResponse.Creator creator = new DogCreateResponse.Creator();
        DogCreateResponse.CREATOR = creator;
    }

    public DogCreateResponse(app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel userApiModel$DogApiModel) {
        n.f(dogApiModel, "dog");
        super();
        this.dog = dogApiModel;
    }

    public static app.dogo.externalmodel.model.responses.DogCreateResponse copy$default(app.dogo.externalmodel.model.responses.DogCreateResponse dogCreateResponse, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel userApiModel$DogApiModel2, int i3, Object object4) {
        app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel obj1;
        if (i3 &= 1 != 0) {
            obj1 = dogCreateResponse.dog;
        }
        return dogCreateResponse.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel component1() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogCreateResponse copy(app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel userApiModel$DogApiModel) {
        n.f(dogApiModel, "dog");
        DogCreateResponse dogCreateResponse = new DogCreateResponse(dogApiModel);
        return dogCreateResponse;
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
        if (object instanceof DogCreateResponse == null) {
            return i2;
        }
        if (!n.b(this.dog, object.dog)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel getDog() {
        return this.dog;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.dog.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogCreateResponse(dog=");
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
