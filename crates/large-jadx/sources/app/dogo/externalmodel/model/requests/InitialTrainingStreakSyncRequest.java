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
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001dB\u001d\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;", "Landroid/os/Parcelable;", "events", "", "Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest$TrainingTimeClientEvent;", "dailyGoalSec", "", "(Ljava/util/List;J)V", "getDailyGoalSec", "()J", "getEvents", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingTimeClientEvent", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InitialTrainingStreakSyncRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest> CREATOR;
    private final long dailyGoalSec;
    private final List<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> events;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(InitialTrainingStreakSyncRequest.TrainingTimeClientEvent.CREATOR.createFromParcel(parcel));
                i++;
            }
            InitialTrainingStreakSyncRequest obj5 = new InitialTrainingStreakSyncRequest(arrayList, parcel.readLong(), fromParcel);
            return obj5;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest[] newArray(int i) {
            return new InitialTrainingStreakSyncRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest$TrainingTimeClientEvent;", "Landroid/os/Parcelable;", "dogId", "", "durationSec", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDogId", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingTimeClientEvent implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> CREATOR;
        private final String date;
        private final String dogId;
        private final long durationSec;
        static {
            InitialTrainingStreakSyncRequest.TrainingTimeClientEvent.Creator creator = new InitialTrainingStreakSyncRequest.TrainingTimeClientEvent.Creator();
            InitialTrainingStreakSyncRequest.TrainingTimeClientEvent.CREATOR = creator;
        }

        public TrainingTimeClientEvent(String string, long l2, String string3) {
            n.f(string, "dogId");
            n.f(obj5, "date");
            super();
            this.dogId = string;
            this.durationSec = l2;
            this.date = obj5;
        }

        public static app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent copy$default(app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent initialTrainingStreakSyncRequest$TrainingTimeClientEvent, String string2, long l3, String string4, int i5, Object object6) {
            String obj1;
            long obj2;
            String obj4;
            if (object6 & 1 != 0) {
                obj1 = trainingTimeClientEvent.dogId;
            }
            if (object6 & 2 != 0) {
                obj2 = trainingTimeClientEvent.durationSec;
            }
            if (object6 &= 4 != 0) {
                obj4 = trainingTimeClientEvent.date;
            }
            return trainingTimeClientEvent.copy(obj1, obj2, string4);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.dogId;
        }

        @Override // android.os.Parcelable
        public final long component2() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent copy(String string, long l2, String string3) {
            n.f(string, "dogId");
            n.f(obj5, "date");
            InitialTrainingStreakSyncRequest.TrainingTimeClientEvent trainingTimeClientEvent = new InitialTrainingStreakSyncRequest.TrainingTimeClientEvent(string, l2, string3, obj5);
            return trainingTimeClientEvent;
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
            if (!object instanceof InitialTrainingStreakSyncRequest.TrainingTimeClientEvent) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            if (Long.compare(durationSec, durationSec2) != 0) {
                return i2;
            }
            if (!n.b(this.date, object.date)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getDate() {
            return this.date;
        }

        @Override // android.os.Parcelable
        public final String getDogId() {
            return this.dogId;
        }

        @Override // android.os.Parcelable
        public final long getDurationSec() {
            return this.durationSec;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrainingTimeClientEvent(dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(", durationSec=");
            stringBuilder.append(this.durationSec);
            stringBuilder.append(", date=");
            stringBuilder.append(this.date);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.dogId);
            parcel.writeLong(this.durationSec);
            parcel.writeString(this.date);
        }
    }
    static {
        InitialTrainingStreakSyncRequest.Creator creator = new InitialTrainingStreakSyncRequest.Creator();
        InitialTrainingStreakSyncRequest.CREATOR = creator;
    }

    public InitialTrainingStreakSyncRequest(List<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> list, long l2) {
        n.f(list, "events");
        super();
        this.events = list;
        this.dailyGoalSec = l2;
    }

    public InitialTrainingStreakSyncRequest(List list, long l2, int i3, g g4) {
        List obj1;
        if (g4 &= 1 != 0) {
            obj1 = p.g();
        }
        super(obj1, l2, i3);
    }

    public static app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest copy$default(app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest initialTrainingStreakSyncRequest, List list2, long l3, int i4, Object object5) {
        List obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj1 = initialTrainingStreakSyncRequest.events;
        }
        if (object5 &= 2 != 0) {
            obj2 = initialTrainingStreakSyncRequest.dailyGoalSec;
        }
        return initialTrainingStreakSyncRequest.copy(obj1, obj2);
    }

    public final List<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> component1() {
        return this.events;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.dailyGoalSec;
    }

    public final app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest copy(List<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> list, long l2) {
        n.f(list, "events");
        InitialTrainingStreakSyncRequest initialTrainingStreakSyncRequest = new InitialTrainingStreakSyncRequest(list, l2, obj4);
        return initialTrainingStreakSyncRequest;
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
        if (object instanceof InitialTrainingStreakSyncRequest == null) {
            return i2;
        }
        if (!n.b(this.events, object.events)) {
            return i2;
        }
        if (Long.compare(dailyGoalSec, dailyGoalSec2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getDailyGoalSec() {
        return this.dailyGoalSec;
    }

    public final List<app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> getEvents() {
        return this.events;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InitialTrainingStreakSyncRequest(events=");
        stringBuilder.append(this.events);
        stringBuilder.append(", dailyGoalSec=");
        stringBuilder.append(this.dailyGoalSec);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List events = this.events;
        parcel.writeInt(events.size());
        Iterator iterator = events.iterator();
        boolean next = iterator.hasNext();
        for (InitialTrainingStreakSyncRequest.TrainingTimeClientEvent size : iterator) {
            size.writeToParcel(parcel, i2);
            next = iterator.hasNext();
        }
        parcel.writeLong(this.dailyGoalSec);
    }
}
