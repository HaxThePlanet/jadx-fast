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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/AddDogLogRequest;", "Landroid/os/Parcelable;", "logs", "", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "(Ljava/util/List;)V", "getLogs", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogLog", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AddDogLogRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.AddDogLogRequest> CREATOR;
    private final List<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> logs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.AddDogLogRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.AddDogLogRequest createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(AddDogLogRequest.DogLog.CREATOR.createFromParcel(parcel));
                i++;
            }
            AddDogLogRequest obj5 = new AddDogLogRequest(arrayList);
            return obj5;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.AddDogLogRequest[] newArray(int i) {
            return new AddDogLogRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "Landroid/os/Parcelable;", "type", "", "eventTimeMs", "", "(Ljava/lang/String;J)V", "getEventTimeMs", "()J", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogLog implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> CREATOR;
        private final long eventTimeMs;
        private final String type;
        static {
            AddDogLogRequest.DogLog.Creator creator = new AddDogLogRequest.DogLog.Creator();
            AddDogLogRequest.DogLog.CREATOR = creator;
        }

        public DogLog(String string, long l2) {
            n.f(string, "type");
            super();
            this.type = string;
            this.eventTimeMs = l2;
        }

        public DogLog(String string, long l2, int i3, g g4) {
            String obj1;
            obj1 = g4 &= 1 != 0 ? "" : obj1;
            super(obj1, l2, i3);
        }

        public static app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog copy$default(app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog addDogLogRequest$DogLog, String string2, long l3, int i4, Object object5) {
            String obj1;
            long obj2;
            if (object5 & 1 != 0) {
                obj1 = dogLog.type;
            }
            if (object5 &= 2 != 0) {
                obj2 = dogLog.eventTimeMs;
            }
            return dogLog.copy(obj1, obj2);
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
        public final app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog copy(String string, long l2) {
            n.f(string, "type");
            AddDogLogRequest.DogLog dogLog = new AddDogLogRequest.DogLog(string, l2, obj4);
            return dogLog;
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
            if (!object instanceof AddDogLogRequest.DogLog) {
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
            stringBuilder.append("DogLog(type=");
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
    static {
        AddDogLogRequest.Creator creator = new AddDogLogRequest.Creator();
        AddDogLogRequest.CREATOR = creator;
    }

    public AddDogLogRequest() {
        final int i = 0;
        super(i, 1, i);
    }

    public AddDogLogRequest(List<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> list) {
        n.f(list, "logs");
        super();
        this.logs = list;
    }

    public AddDogLogRequest(List list, int i2, g g3) {
        List obj1;
        if (i2 &= 1 != 0) {
            obj1 = p.g();
        }
        super(obj1);
    }

    public static app.dogo.externalmodel.model.requests.AddDogLogRequest copy$default(app.dogo.externalmodel.model.requests.AddDogLogRequest addDogLogRequest, List list2, int i3, Object object4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = addDogLogRequest.logs;
        }
        return addDogLogRequest.copy(obj1);
    }

    public final List<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> component1() {
        return this.logs;
    }

    public final app.dogo.externalmodel.model.requests.AddDogLogRequest copy(List<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> list) {
        n.f(list, "logs");
        AddDogLogRequest addDogLogRequest = new AddDogLogRequest(list);
        return addDogLogRequest;
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
        if (object instanceof AddDogLogRequest == null) {
            return i2;
        }
        if (!n.b(this.logs, object.logs)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog> getLogs() {
        return this.logs;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.logs.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddDogLogRequest(logs=");
        stringBuilder.append(this.logs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List logs = this.logs;
        parcel.writeInt(logs.size());
        Iterator iterator = logs.iterator();
        for (AddDogLogRequest.DogLog size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
