package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "Landroid/os/Parcelable;", "startedAt", "", "stoppedAt", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStartedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStoppedAt", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramStatusRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.ProgramStatusRequest> CREATOR;
    private final Long startedAt;
    private final Long stoppedAt;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.ProgramStatusRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.ProgramStatusRequest createFromParcel(Parcel parcel) {
            int valueOf;
            Long valueOf2;
            long long;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = valueOf2;
            } else {
                valueOf = Long.valueOf(parcel.readLong());
            }
            int int2 = parcel.readInt();
            if (int2 == 0) {
            } else {
                valueOf2 = Long.valueOf(parcel.readLong());
            }
            ProgramStatusRequest programStatusRequest = new ProgramStatusRequest(valueOf, valueOf2);
            return programStatusRequest;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.ProgramStatusRequest[] newArray(int i) {
            return new ProgramStatusRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ProgramStatusRequest.Creator creator = new ProgramStatusRequest.Creator();
        ProgramStatusRequest.CREATOR = creator;
    }

    public ProgramStatusRequest() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public ProgramStatusRequest(Long long, Long long2) {
        super();
        this.startedAt = long;
        this.stoppedAt = long2;
    }

    public ProgramStatusRequest(Long long, Long long2, int i3, g g4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    public static app.dogo.externalmodel.model.requests.ProgramStatusRequest copy$default(app.dogo.externalmodel.model.requests.ProgramStatusRequest programStatusRequest, Long long2, Long long3, int i4, Object object5) {
        Long obj1;
        Long obj2;
        if (i4 & 1 != 0) {
            obj1 = programStatusRequest.startedAt;
        }
        if (i4 &= 2 != 0) {
            obj2 = programStatusRequest.stoppedAt;
        }
        return programStatusRequest.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final Long component1() {
        return this.startedAt;
    }

    @Override // android.os.Parcelable
    public final Long component2() {
        return this.stoppedAt;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.requests.ProgramStatusRequest copy(Long long, Long long2) {
        ProgramStatusRequest programStatusRequest = new ProgramStatusRequest(long, long2);
        return programStatusRequest;
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
        if (object instanceof ProgramStatusRequest == null) {
            return i2;
        }
        if (!n.b(this.startedAt, object.startedAt)) {
            return i2;
        }
        if (!n.b(this.stoppedAt, object.stoppedAt)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final Long getStartedAt() {
        return this.startedAt;
    }

    @Override // android.os.Parcelable
    public final Long getStoppedAt() {
        return this.stoppedAt;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        Long startedAt = this.startedAt;
        if (startedAt == null) {
            i = i2;
        } else {
            i = startedAt.hashCode();
        }
        final Long stoppedAt = this.stoppedAt;
        if (stoppedAt == null) {
        } else {
            i2 = stoppedAt.hashCode();
        }
        return i3 += i2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramStatusRequest(startedAt=");
        stringBuilder.append(this.startedAt);
        stringBuilder.append(", stoppedAt=");
        stringBuilder.append(this.stoppedAt);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        long longValue2;
        n.f(parcel, "out");
        Long obj6 = this.startedAt;
        longValue = 0;
        final int i = 1;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
        obj6 = this.stoppedAt;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
    }
}
