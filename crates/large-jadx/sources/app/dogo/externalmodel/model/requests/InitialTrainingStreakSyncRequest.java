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

/* compiled from: InitialTrainingStreakSyncRequest.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001dB\u001d\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;", "Landroid/os/Parcelable;", "events", "", "Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest$TrainingTimeClientEvent;", "dailyGoalSec", "", "(Ljava/util/List;J)V", "getDailyGoalSec", "()J", "getEvents", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrainingTimeClientEvent", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InitialTrainingStreakSyncRequest implements Parcelable {

    public static final Parcelable.Creator<InitialTrainingStreakSyncRequest> CREATOR = new InitialTrainingStreakSyncRequest$Creator<>();
    private final long dailyGoalSec;
    private final List<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> events;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InitialTrainingStreakSyncRequest> {
        @Override // android.os.Parcelable$Creator
        public final InitialTrainingStreakSyncRequest createFromParcel(Parcel parcel) {
            int i = 0;
            Object fromParcel;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(InitialTrainingStreakSyncRequest_TrainingTimeClientEvent.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new InitialTrainingStreakSyncRequest(arrayList, parcel.readLong(), fromParcel);
        }

        @Override // android.os.Parcelable$Creator
        public final InitialTrainingStreakSyncRequest[] newArray(int i) {
            return new InitialTrainingStreakSyncRequest[i];
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest$TrainingTimeClientEvent;", "Landroid/os/Parcelable;", "dogId", "", "durationSec", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDogId", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrainingTimeClientEvent implements Parcelable {

        public static final Parcelable.Creator<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> CREATOR = new InitialTrainingStreakSyncRequest$TrainingTimeClientEvent$Creator<>();
        private final String date;
        private final String dogId;
        private final long durationSec;
        public TrainingTimeClientEvent(String str, long j, String str2) {
            n.f(str, "dogId");
            n.f(str2, "date");
            super();
            this.dogId = str;
            this.durationSec = j;
            this.date = str2;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final long getDurationSec() {
            return this.durationSec;
        }


        public static /* synthetic */ InitialTrainingStreakSyncRequest.TrainingTimeClientEvent copy$default(InitialTrainingStreakSyncRequest.TrainingTimeClientEvent trainingTimeClientEvent, String str, long j, String str2, int i, Object object) {
            String dogId2;
            long durationSec2;
            String date2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return trainingTimeClientEvent.copy(dogId2, durationSec2, date2);
        }

        /* operator */ public final String component1() {
            return this.dogId;
        }

        /* operator */ public final long component2() {
            return this.durationSec;
        }

        /* operator */ public final String component3() {
            return this.date;
        }

        public final InitialTrainingStreakSyncRequest.TrainingTimeClientEvent copy(String dogId, long durationSec, String date) {
            n.f(dogId, "dogId");
            n.f(date, "date");
            return new InitialTrainingStreakSyncRequest_TrainingTimeClientEvent(dogId, durationSec, r4, date);
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
            if (!(other instanceof InitialTrainingStreakSyncRequest_TrainingTimeClientEvent)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (this.durationSec != other.durationSec) {
                return false;
            }
            return !n.b(this.date, other.date) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.dogId.hashCode() * 31) + Long.hashCode(this.durationSec) * 31 + this.date.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrainingTimeClientEvent(dogId=";
            String str3 = ", durationSec=";
            String str4 = ", date=";
            str = str2 + this.dogId + str3 + this.durationSec + str4 + this.date + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.dogId);
            parcel.writeLong(this.durationSec);
            parcel.writeString(this.date);
        }
    }
    public InitialTrainingStreakSyncRequest(List<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> list, long j) {
        n.f(list, "events");
        super();
        this.events = list;
        this.dailyGoalSec = j;
    }

    public final long getDailyGoalSec() {
        return this.dailyGoalSec;
    }

    public final List<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> getEvents() {
        return this.events;
    }

    public /* synthetic */ InitialTrainingStreakSyncRequest(List list, long j, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        this(list2, j, r3);
    }


    public static /* synthetic */ InitialTrainingStreakSyncRequest copy$default(InitialTrainingStreakSyncRequest initialTrainingStreakSyncRequest, List list, long j, int i, Object object) {
        List events2;
        long dailyGoalSec2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return initialTrainingStreakSyncRequest.copy(events2, dailyGoalSec2);
    }

    /* operator */ public final List<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> component1() {
        return this.events;
    }

    /* operator */ public final long component2() {
        return this.dailyGoalSec;
    }

    public final InitialTrainingStreakSyncRequest copy(List<InitialTrainingStreakSyncRequest.TrainingTimeClientEvent> events, long dailyGoalSec) {
        n.f(events, "events");
        return new InitialTrainingStreakSyncRequest(events, dailyGoalSec, r4);
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
        if (!(other instanceof InitialTrainingStreakSyncRequest)) {
            return false;
        }
        if (!n.b(this.events, other.events)) {
            return false;
        }
        return this.dailyGoalSec != other.dailyGoalSec ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.events.hashCode() * 31) + Long.hashCode(this.dailyGoalSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "InitialTrainingStreakSyncRequest(events=";
        String str3 = ", dailyGoalSec=";
        str = str2 + this.events + str3 + this.dailyGoalSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.events.size());
        Iterator it = this.events.iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            (InitialTrainingStreakSyncRequest_TrainingTimeClientEvent)it.next().writeToParcel(parcel, flags);
            hasNext = it.hasNext();
        }
        parcel.writeLong(this.dailyGoalSec);
    }
}
