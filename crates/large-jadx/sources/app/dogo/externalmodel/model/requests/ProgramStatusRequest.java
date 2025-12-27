package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramStatusRequest.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "Landroid/os/Parcelable;", "startedAt", "", "stoppedAt", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStartedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStoppedAt", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramStatusRequest implements Parcelable {

    public static final Parcelable.Creator<ProgramStatusRequest> CREATOR = new ProgramStatusRequest$Creator<>();
    private final Long startedAt;
    private final Long stoppedAt;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramStatusRequest> {
        @Override // android.os.Parcelable$Creator
        public final ProgramStatusRequest createFromParcel(Parcel parcel) {
            Long num;
            Long num2 = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
            } else {
                num = Long.valueOf(parcel.readLong());
            }
            int _int2 = parcel.readInt();
            if (_int2 != 0) {
                num2 = Long.valueOf(parcel.readLong());
            }
            ProgramStatusRequest programStatusRequest = new ProgramStatusRequest(num, num2);
            return programStatusRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramStatusRequest[] newArray(int i) {
            return new ProgramStatusRequest[i];
        }
    }
    public ProgramStatusRequest(Long long, Long long2) {
        super();
        this.startedAt = long;
        this.stoppedAt = long2;
    }

    public final Long getStartedAt() {
        return this.startedAt;
    }

    public final Long getStoppedAt() {
        return this.stoppedAt;
    }

    public /* synthetic */ ProgramStatusRequest(Long long, Long long2, int i, g gVar) {
        Long l;
        Long l2;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        this(l, l2);
    }


    public ProgramStatusRequest() {
        final Long l = null;
        this(l, l, 3, l);
    }

    public static /* synthetic */ ProgramStatusRequest copy$default(ProgramStatusRequest programStatusRequest, Long long, Long long2, int i, Object object) {
        Long startedAt2;
        Long stoppedAt2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return programStatusRequest.copy(startedAt2, stoppedAt2);
    }

    /* operator */ public final Long component1() {
        return this.startedAt;
    }

    /* operator */ public final Long component2() {
        return this.stoppedAt;
    }

    public final ProgramStatusRequest copy(Long startedAt, Long stoppedAt) {
        return new ProgramStatusRequest(startedAt, stoppedAt);
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
        if (!(other instanceof ProgramStatusRequest)) {
            return false;
        }
        if (!n.b(this.startedAt, other.startedAt)) {
            return false;
        }
        return !n.b(this.stoppedAt, other.stoppedAt) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.startedAt == null) {
        } else {
            i = this.startedAt.hashCode();
        }
        if (this.stoppedAt != null) {
            i = this.stoppedAt.hashCode();
        }
        return (i * 31) + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramStatusRequest(startedAt=";
        String str3 = ", stoppedAt=";
        str = str2 + this.startedAt + str3 + this.stoppedAt + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        int i = 0;
        final int i2 = 1;
        if (this.startedAt == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.startedAt.longValue());
        }
        if (this.stoppedAt == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.stoppedAt.longValue());
        }
    }
}
