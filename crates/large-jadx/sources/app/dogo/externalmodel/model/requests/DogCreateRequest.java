package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.RemoteDogModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogCreateRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/requests/DogCreateRequest;", "Landroid/os/Parcelable;", "dog", "Lapp/dogo/externalmodel/model/RemoteDogModel;", "(Lapp/dogo/externalmodel/model/RemoteDogModel;)V", "getDog", "()Lapp/dogo/externalmodel/model/RemoteDogModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogCreateRequest implements Parcelable {

    public static final Parcelable.Creator<DogCreateRequest> CREATOR = new DogCreateRequest$Creator<>();
    private final RemoteDogModel dog;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogCreateRequest> {
        @Override // android.os.Parcelable$Creator
        public final DogCreateRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogCreateRequest((RemoteDogModel)RemoteDogModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final DogCreateRequest[] newArray(int i) {
            return new DogCreateRequest[i];
        }
    }
    public DogCreateRequest(RemoteDogModel remoteDogModel) {
        n.f(remoteDogModel, "dog");
        super();
        this.dog = remoteDogModel;
    }

    public final RemoteDogModel getDog() {
        return this.dog;
    }


    public static /* synthetic */ DogCreateRequest copy$default(DogCreateRequest dogCreateRequest, RemoteDogModel remoteDogModel, int i, Object object) {
        RemoteDogModel dog2;
        if (i & 1 != 0) {
        }
        return dogCreateRequest.copy(dog2);
    }

    /* operator */ public final RemoteDogModel component1() {
        return this.dog;
    }

    public final DogCreateRequest copy(RemoteDogModel dog) {
        n.f(dog, "dog");
        return new DogCreateRequest(dog);
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
        if (!(other instanceof DogCreateRequest)) {
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
        String str2 = "DogCreateRequest(dog=";
        str = str2 + this.dog + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.dog.writeToParcel(parcel, flags);
    }
}
