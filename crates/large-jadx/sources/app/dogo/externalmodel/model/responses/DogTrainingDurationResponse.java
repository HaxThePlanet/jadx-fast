package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* compiled from: DogTrainingDurationResponse.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001!B/\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\"", d2 = {"Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "Landroid/os/Parcelable;", "dailyTrainingTimes", "", "", "", "dailyTrainingTimeGoalStreak", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "totalTrainingTimeSec", "(Ljava/util/Map;Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;J)V", "getDailyTrainingTimeGoalStreak", "()Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "getDailyTrainingTimes", "()Ljava/util/Map;", "getTotalTrainingTimeSec", "()J", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Streak", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogTrainingDurationResponse implements Parcelable {

    public static final Parcelable.Creator<DogTrainingDurationResponse> CREATOR = new DogTrainingDurationResponse$Creator<>();
    private final DogTrainingDurationResponse.Streak dailyTrainingTimeGoalStreak;
    private final Map<String, Long> dailyTrainingTimes;
    private final long totalTrainingTimeSec;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogTrainingDurationResponse> {
        @Override // android.os.Parcelable$Creator
        public final DogTrainingDurationResponse createFromParcel(Parcel parcel) {
            int i = 0;
            String string;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), Long.valueOf(parcel.readLong()));
                i = i + 1;
            }
            return new DogTrainingDurationResponse(linkedHashMap, (DogTrainingDurationResponse_Streak)DogTrainingDurationResponse_Streak.CREATOR.createFromParcel(parcel), parcel.readLong(), string);
        }

        @Override // android.os.Parcelable$Creator
        public final DogTrainingDurationResponse[] newArray(int i) {
            return new DogTrainingDurationResponse[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "Landroid/os/Parcelable;", "currentStreak", "", "longestStreak", "(II)V", "getCurrentStreak", "()I", "getLongestStreak", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Streak implements Parcelable {

        public static final Parcelable.Creator<DogTrainingDurationResponse.Streak> CREATOR = new DogTrainingDurationResponse$Streak$Creator<>();
        private final int currentStreak;
        private final int longestStreak;
        public Streak(int i, int i2) {
            super();
            this.currentStreak = i;
            this.longestStreak = i2;
        }

        public final int getCurrentStreak() {
            return this.currentStreak;
        }

        public final int getLongestStreak() {
            return this.longestStreak;
        }

        public /* synthetic */ Streak(int i, int i2, int i3, g gVar) {
            int i4;
            i4 = 0;
            i4 = i3 & 1 != 0 ? i4 : i4;
            i4 = i3 & 2 != 0 ? i4 : i4;
            this(i4, i4);
        }


        public Streak() {
            final int i = 0;
            this(i, i, 3, null);
        }

        public static /* synthetic */ DogTrainingDurationResponse.Streak copy$default(DogTrainingDurationResponse.Streak streak, int i, int i2, int i3, Object object) {
            int currentStreak2;
            int longestStreak2;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            return streak.copy(currentStreak2, longestStreak2);
        }

        /* operator */ public final int component1() {
            return this.currentStreak;
        }

        /* operator */ public final int component2() {
            return this.longestStreak;
        }

        public final DogTrainingDurationResponse.Streak copy(int currentStreak, int longestStreak) {
            return new DogTrainingDurationResponse_Streak(currentStreak, longestStreak);
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
            if (!(other instanceof DogTrainingDurationResponse_Streak)) {
                return false;
            }
            if (this.currentStreak != other.currentStreak) {
                return false;
            }
            return this.longestStreak != other.longestStreak ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (Integer.hashCode(this.currentStreak) * 31) + Integer.hashCode(this.longestStreak);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Streak(currentStreak=";
            String str3 = ", longestStreak=";
            str = str2 + this.currentStreak + str3 + this.longestStreak + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.currentStreak);
            parcel.writeInt(this.longestStreak);
        }
    }
    public DogTrainingDurationResponse(Map<String, Long> map, DogTrainingDurationResponse.Streak streak, long j) {
        n.f(map, "dailyTrainingTimes");
        n.f(streak, "dailyTrainingTimeGoalStreak");
        super();
        this.dailyTrainingTimes = map;
        this.dailyTrainingTimeGoalStreak = streak;
        this.totalTrainingTimeSec = j;
    }

    public final DogTrainingDurationResponse.Streak getDailyTrainingTimeGoalStreak() {
        return this.dailyTrainingTimeGoalStreak;
    }

    public final Map<String, Long> getDailyTrainingTimes() {
        return this.dailyTrainingTimes;
    }

    public final long getTotalTrainingTimeSec() {
        return this.totalTrainingTimeSec;
    }

    public /* synthetic */ DogTrainingDurationResponse(Map map, DogTrainingDurationResponse.Streak streak, long j, int i, g gVar) {
        Map map2;
        app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse_Streak;
        int i2 = 0;
        if (i & 1 != 0) {
            map2 = j0.h();
        }
        i3 = i & 2;
        if (i & 2 != 0) {
            int i3 = 3;
            gVar = null;
            i = 0;
            dogTrainingDurationResponse_Streak = new DogTrainingDurationResponse_Streak(i, i, i3, gVar);
        }
        i2 = i & 4 != 0 ? 0 : i2;
        this(map2, dogTrainingDurationResponse_Streak, i2, r6);
    }


    public DogTrainingDurationResponse() {
        this(null, null, 0L, i4, 7, 0);
    }

    public static /* synthetic */ DogTrainingDurationResponse copy$default(DogTrainingDurationResponse dogTrainingDurationResponse, Map map, DogTrainingDurationResponse.Streak streak, long j, int i, Object object) {
        Map dailyTrainingTimes2;
        app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dailyTrainingTimeGoalStreak2;
        long totalTrainingTimeSec2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return dogTrainingDurationResponse.copy(dailyTrainingTimes2, dailyTrainingTimeGoalStreak2, totalTrainingTimeSec2);
    }

    /* operator */ public final Map<String, Long> component1() {
        return this.dailyTrainingTimes;
    }

    /* operator */ public final DogTrainingDurationResponse.Streak component2() {
        return this.dailyTrainingTimeGoalStreak;
    }

    /* operator */ public final long component3() {
        return this.totalTrainingTimeSec;
    }

    public final DogTrainingDurationResponse copy(Map<String, Long> dailyTrainingTimes, DogTrainingDurationResponse.Streak dailyTrainingTimeGoalStreak, long totalTrainingTimeSec) {
        n.f(dailyTrainingTimes, "dailyTrainingTimes");
        n.f(dailyTrainingTimeGoalStreak, "dailyTrainingTimeGoalStreak");
        return new DogTrainingDurationResponse(dailyTrainingTimes, dailyTrainingTimeGoalStreak, totalTrainingTimeSec, r5);
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
        final boolean z5 = false;
        if (!(other instanceof DogTrainingDurationResponse)) {
            return false;
        }
        if (!n.b(this.dailyTrainingTimes, other.dailyTrainingTimes)) {
            return false;
        }
        if (!n.b(this.dailyTrainingTimeGoalStreak, other.dailyTrainingTimeGoalStreak)) {
            return false;
        }
        return this.totalTrainingTimeSec != other.totalTrainingTimeSec ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dailyTrainingTimes.hashCode() * 31) + this.dailyTrainingTimeGoalStreak.hashCode() * 31 + Long.hashCode(this.totalTrainingTimeSec);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogTrainingDurationResponse(dailyTrainingTimes=";
        String str3 = ", dailyTrainingTimeGoalStreak=";
        String str4 = ", totalTrainingTimeSec=";
        str = str2 + this.dailyTrainingTimes + str3 + this.dailyTrainingTimeGoalStreak + str4 + this.totalTrainingTimeSec + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.dailyTrainingTimes.size());
        Iterator it = this.dailyTrainingTimes.entrySet().iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            Object item = it.next();
            Object key = item.getKey();
            parcel.writeString(key);
            parcel.writeLong((Number)item.getValue().longValue());
            hasNext = it.hasNext();
        }
        this.dailyTrainingTimeGoalStreak.writeToParcel(parcel, flags);
        parcel.writeLong(this.totalTrainingTimeSec);
    }
}
