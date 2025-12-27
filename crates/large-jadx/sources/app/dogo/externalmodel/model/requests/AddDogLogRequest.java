package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: AddDogLogRequest.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/AddDogLogRequest;", "Landroid/os/Parcelable;", "logs", "", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "(Ljava/util/List;)V", "getLogs", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogLog", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AddDogLogRequest implements Parcelable {

    public static final Parcelable.Creator<AddDogLogRequest> CREATOR = new AddDogLogRequest$Creator<>();
    private final List<AddDogLogRequest.DogLog> logs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddDogLogRequest> {
        @Override // android.os.Parcelable$Creator
        public final AddDogLogRequest createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(AddDogLogRequest_DogLog.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new AddDogLogRequest(arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final AddDogLogRequest[] newArray(int i) {
            return new AddDogLogRequest[i];
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "Landroid/os/Parcelable;", "type", "", "eventTimeMs", "", "(Ljava/lang/String;J)V", "getEventTimeMs", "()J", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogLog implements Parcelable {

        public static final Parcelable.Creator<AddDogLogRequest.DogLog> CREATOR = new AddDogLogRequest$DogLog$Creator<>();
        private final long eventTimeMs;
        private final String type;
        public DogLog(String str, long j) {
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

        public /* synthetic */ DogLog(String str, long j, int i, g gVar) {
            String str2;
            str2 = i & 1 != 0 ? "" : str2;
            this(str2, j, r3);
        }


        public static /* synthetic */ AddDogLogRequest.DogLog copy$default(AddDogLogRequest.DogLog dogLog, String str, long j, int i, Object object) {
            String type2;
            long eventTimeMs2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return dogLog.copy(type2, eventTimeMs2);
        }

        /* operator */ public final String component1() {
            return this.type;
        }

        /* operator */ public final long component2() {
            return this.eventTimeMs;
        }

        public final AddDogLogRequest.DogLog copy(String type, long eventTimeMs) {
            n.f(type, "type");
            return new AddDogLogRequest_DogLog(type, eventTimeMs, r4);
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
            if (!(other instanceof AddDogLogRequest_DogLog)) {
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
            String str2 = "DogLog(type=";
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
    public AddDogLogRequest(List<AddDogLogRequest.DogLog> list) {
        n.f(list, "logs");
        super();
        this.logs = list;
    }

    public final List<AddDogLogRequest.DogLog> getLogs() {
        return this.logs;
    }

    public /* synthetic */ AddDogLogRequest(List list, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        this(list2);
    }


    public AddDogLogRequest() {
        final List list = null;
        this(list, 1, list);
    }

    public static /* synthetic */ AddDogLogRequest copy$default(AddDogLogRequest addDogLogRequest, List list, int i, Object object) {
        List logs2;
        if (i & 1 != 0) {
        }
        return addDogLogRequest.copy(logs2);
    }

    /* operator */ public final List<AddDogLogRequest.DogLog> component1() {
        return this.logs;
    }

    public final AddDogLogRequest copy(List<AddDogLogRequest.DogLog> logs) {
        n.f(logs, "logs");
        return new AddDogLogRequest(logs);
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
        if (!(other instanceof AddDogLogRequest)) {
            return false;
        }
        return !n.b(this.logs, other.logs) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.logs.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "AddDogLogRequest(logs=";
        str = str2 + this.logs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.logs.size());
        Iterator it = this.logs.iterator();
        while (it.hasNext()) {
            (AddDogLogRequest_DogLog)it.next().writeToParcel(parcel, flags);
        }
    }
}
