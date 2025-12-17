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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001!B/\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\"", d2 = {"Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "Landroid/os/Parcelable;", "dailyTrainingTimes", "", "", "", "dailyTrainingTimeGoalStreak", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "totalTrainingTimeSec", "(Ljava/util/Map;Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;J)V", "getDailyTrainingTimeGoalStreak", "()Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "getDailyTrainingTimes", "()Ljava/util/Map;", "getTotalTrainingTimeSec", "()J", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Streak", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogTrainingDurationResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogTrainingDurationResponse> CREATOR;
    private final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dailyTrainingTimeGoalStreak;
    private final Map<String, Long> dailyTrainingTimes;
    private final long totalTrainingTimeSec;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.DogTrainingDurationResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse createFromParcel(Parcel parcel) {
            int i;
            String string;
            Long valueOf;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), Long.valueOf(parcel.readLong()));
                i++;
            }
            DogTrainingDurationResponse obj7 = new DogTrainingDurationResponse(linkedHashMap, (DogTrainingDurationResponse.Streak)DogTrainingDurationResponse.Streak.CREATOR.createFromParcel(parcel), parcel.readLong(), string);
            return obj7;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse[] newArray(int i) {
            return new DogTrainingDurationResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse$Streak;", "Landroid/os/Parcelable;", "currentStreak", "", "longestStreak", "(II)V", "getCurrentStreak", "()I", "getLongestStreak", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Streak implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak> CREATOR;
        private final int currentStreak;
        private final int longestStreak;
        static {
            DogTrainingDurationResponse.Streak.Creator creator = new DogTrainingDurationResponse.Streak.Creator();
            DogTrainingDurationResponse.Streak.CREATOR = creator;
        }

        public Streak() {
            final int i = 0;
            super(i, i, 3, 0);
        }

        public Streak(int i, int i2) {
            super();
            this.currentStreak = i;
            this.longestStreak = i2;
        }

        public Streak(int i, int i2, int i3, g g4) {
            int obj2;
            int obj3;
            final int i4 = 0;
            obj2 = i3 & 1 != 0 ? i4 : obj2;
            obj3 = i3 &= 2 != 0 ? i4 : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak copy$default(app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse$Streak, int i2, int i3, int i4, Object object5) {
            int obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = streak.currentStreak;
            }
            if (i4 &= 2 != 0) {
                obj2 = streak.longestStreak;
            }
            return streak.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final int component1() {
            return this.currentStreak;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.longestStreak;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak copy(int i, int i2) {
            DogTrainingDurationResponse.Streak streak = new DogTrainingDurationResponse.Streak(i, i2);
            return streak;
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
            if (!object instanceof DogTrainingDurationResponse.Streak) {
                return i2;
            }
            if (this.currentStreak != object.currentStreak) {
                return i2;
            }
            if (this.longestStreak != object.longestStreak) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getCurrentStreak() {
            return this.currentStreak;
        }

        @Override // android.os.Parcelable
        public final int getLongestStreak() {
            return this.longestStreak;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Streak(currentStreak=");
            stringBuilder.append(this.currentStreak);
            stringBuilder.append(", longestStreak=");
            stringBuilder.append(this.longestStreak);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.currentStreak);
            parcel.writeInt(this.longestStreak);
        }
    }
    static {
        DogTrainingDurationResponse.Creator creator = new DogTrainingDurationResponse.Creator();
        DogTrainingDurationResponse.CREATOR = creator;
    }

    public DogTrainingDurationResponse() {
        super(0, 0, 0, obj4, 7, 0);
    }

    public DogTrainingDurationResponse(Map<String, Long> map, app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse$Streak2, long l3) {
        n.f(map, "dailyTrainingTimes");
        n.f(streak2, "dailyTrainingTimeGoalStreak");
        super();
        this.dailyTrainingTimes = map;
        this.dailyTrainingTimeGoalStreak = streak2;
        this.totalTrainingTimeSec = l3;
    }

    public DogTrainingDurationResponse(Map map, app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse$Streak2, long l3, int i4, g g5) {
        int i;
        int i2;
        Map obj3;
        app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak obj4;
        int obj5;
        int obj8;
        if (g5 & 1 != 0) {
            obj3 = j0.h();
        }
        if (g5 & 2 != 0) {
            i2 = 0;
            obj4 = new DogTrainingDurationResponse.Streak(i2, i2, 3, 0);
        }
        obj5 = g5 &= 4 != 0 ? 0 : obj5;
        super(obj3, obj4, obj5, i4);
    }

    public static app.dogo.externalmodel.model.responses.DogTrainingDurationResponse copy$default(app.dogo.externalmodel.model.responses.DogTrainingDurationResponse dogTrainingDurationResponse, Map map2, app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse$Streak3, long l4, int i5, Object object6) {
        Map obj1;
        app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak obj2;
        long obj3;
        if (object6 & 1 != 0) {
            obj1 = dogTrainingDurationResponse.dailyTrainingTimes;
        }
        if (object6 & 2 != 0) {
            obj2 = dogTrainingDurationResponse.dailyTrainingTimeGoalStreak;
        }
        if (object6 &= 4 != 0) {
            obj3 = dogTrainingDurationResponse.totalTrainingTimeSec;
        }
        return dogTrainingDurationResponse.copy(obj1, obj2, obj3);
    }

    public final Map<String, Long> component1() {
        return this.dailyTrainingTimes;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak component2() {
        return this.dailyTrainingTimeGoalStreak;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.totalTrainingTimeSec;
    }

    public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse copy(Map<String, Long> map, app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak dogTrainingDurationResponse$Streak2, long l3) {
        n.f(map, "dailyTrainingTimes");
        n.f(streak2, "dailyTrainingTimeGoalStreak");
        DogTrainingDurationResponse dogTrainingDurationResponse = new DogTrainingDurationResponse(map, streak2, l3, obj5);
        return dogTrainingDurationResponse;
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
        if (object instanceof DogTrainingDurationResponse == null) {
            return i2;
        }
        if (!n.b(this.dailyTrainingTimes, object.dailyTrainingTimes)) {
            return i2;
        }
        if (!n.b(this.dailyTrainingTimeGoalStreak, object.dailyTrainingTimeGoalStreak)) {
            return i2;
        }
        if (Long.compare(totalTrainingTimeSec, totalTrainingTimeSec2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.DogTrainingDurationResponse.Streak getDailyTrainingTimeGoalStreak() {
        return this.dailyTrainingTimeGoalStreak;
    }

    public final Map<String, Long> getDailyTrainingTimes() {
        return this.dailyTrainingTimes;
    }

    @Override // android.os.Parcelable
    public final long getTotalTrainingTimeSec() {
        return this.totalTrainingTimeSec;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogTrainingDurationResponse(dailyTrainingTimes=");
        stringBuilder.append(this.dailyTrainingTimes);
        stringBuilder.append(", dailyTrainingTimeGoalStreak=");
        stringBuilder.append(this.dailyTrainingTimeGoalStreak);
        stringBuilder.append(", totalTrainingTimeSec=");
        stringBuilder.append(this.totalTrainingTimeSec);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int longValue;
        Object key;
        n.f(parcel, "out");
        Map dailyTrainingTimes = this.dailyTrainingTimes;
        parcel.writeInt(dailyTrainingTimes.size());
        Iterator iterator = dailyTrainingTimes.entrySet().iterator();
        boolean next = iterator.hasNext();
        for (Map.Entry next2 : iterator) {
            key = next2.getKey();
            parcel.writeString((String)key);
            parcel.writeLong((Number)next2.getValue().longValue());
            next = iterator.hasNext();
        }
        this.dailyTrainingTimeGoalStreak.writeToParcel(parcel, i2);
        parcel.writeLong(this.totalTrainingTimeSec);
    }
}
