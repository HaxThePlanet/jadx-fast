package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: UpdateDogLogRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/requests/UpdateDogLogRequest;", "Landroid/os/Parcelable;", "type", "", "eventTimeMs", "", "(Ljava/lang/String;J)V", "getEventTimeMs", "()J", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UpdateDogLogRequest implements Parcelable {

    public static final Parcelable.Creator<UpdateDogLogRequest> CREATOR = new UpdateDogLogRequest$Creator<>();
    private final long eventTimeMs;
    private final String type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UpdateDogLogRequest> {
        @Override // android.os.Parcelable$Creator
        public final UpdateDogLogRequest createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new UpdateDogLogRequest(parcel.readString(), parcel.readLong(), r3);
        }

        @Override // android.os.Parcelable$Creator
        public final UpdateDogLogRequest[] newArray(int i) {
            return new UpdateDogLogRequest[i];
        }
    }
    public UpdateDogLogRequest(String str, long j) {
        n.f(str, "type");
        super();
        this.type = str;
        this.eventTimeMs = j;
    }

    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    public final String getType() {
        return this.type;
    }

    public /* synthetic */ UpdateDogLogRequest(String str, long j, int i, g gVar) {
        String str2;
        str2 = i & 1 != 0 ? "" : str2;
        i = i & 2 != 0 ? 0 : i;
        this(str2, i, r3);
    }


    public UpdateDogLogRequest() {
        this(null, 0L, i3, 3, 0);
    }

    public static /* synthetic */ UpdateDogLogRequest copy$default(UpdateDogLogRequest updateDogLogRequest, String str, long j, int i, Object object) {
        String type2;
        long eventTimeMs2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return updateDogLogRequest.copy(type2, eventTimeMs2);
    }

    /* operator */ public final String component1() {
        return this.type;
    }

    /* operator */ public final long component2() {
        return this.eventTimeMs;
    }

    public final UpdateDogLogRequest copy(String type, long eventTimeMs) {
        n.f(type, "type");
        return new UpdateDogLogRequest(type, eventTimeMs, r4);
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
        final boolean z4 = false;
        if (!(other instanceof UpdateDogLogRequest)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        return this.eventTimeMs != other.eventTimeMs ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.type.hashCode() * 31) + Long.hashCode(this.eventTimeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UpdateDogLogRequest(type=";
        String str3 = ", eventTimeMs=";
        str = str2 + this.type + str3 + this.eventTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.type);
        parcel.writeLong(this.eventTimeMs);
    }
}
