package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/requests/UpdateDogLogRequest;", "Landroid/os/Parcelable;", "type", "", "eventTimeMs", "", "(Ljava/lang/String;J)V", "getEventTimeMs", "()J", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateDogLogRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.UpdateDogLogRequest> CREATOR;
    private final long eventTimeMs;
    private final String type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.UpdateDogLogRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UpdateDogLogRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            UpdateDogLogRequest updateDogLogRequest = new UpdateDogLogRequest(parcel.readString(), parcel.readLong(), obj3);
            return updateDogLogRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UpdateDogLogRequest[] newArray(int i) {
            return new UpdateDogLogRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        UpdateDogLogRequest.Creator creator = new UpdateDogLogRequest.Creator();
        UpdateDogLogRequest.CREATOR = creator;
    }

    public UpdateDogLogRequest() {
        super(0, 0, obj3, 3, 0);
    }

    public UpdateDogLogRequest(String string, long l2) {
        n.f(string, "type");
        super();
        this.type = string;
        this.eventTimeMs = l2;
    }

    public UpdateDogLogRequest(String string, long l2, int i3, g g4) {
        String obj1;
        int obj2;
        obj1 = g4 & 1 != 0 ? "" : obj1;
        obj2 = g4 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, i3);
    }

    public static app.dogo.externalmodel.model.requests.UpdateDogLogRequest copy$default(app.dogo.externalmodel.model.requests.UpdateDogLogRequest updateDogLogRequest, String string2, long l3, int i4, Object object5) {
        String obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj1 = updateDogLogRequest.type;
        }
        if (object5 &= 2 != 0) {
            obj2 = updateDogLogRequest.eventTimeMs;
        }
        return updateDogLogRequest.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.UpdateDogLogRequest copy(String string, long l2) {
        n.f(string, "type");
        UpdateDogLogRequest updateDogLogRequest = new UpdateDogLogRequest(string, l2, obj4);
        return updateDogLogRequest;
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
        if (object instanceof UpdateDogLogRequest == null) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (Long.compare(eventTimeMs, eventTimeMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateDogLogRequest(type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", eventTimeMs=");
        stringBuilder.append(this.eventTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.type);
        parcel.writeLong(this.eventTimeMs);
    }
}
