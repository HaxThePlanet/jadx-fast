package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "Landroid/os/Parcelable;", "currentStreak", "", "longestStreak", "lastAchievedStreakTimestampMs", "", "(IIJ)V", "getCurrentStreak", "()I", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WorkoutStreakInfo implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo> CREATOR;
    private final int currentStreak;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            WorkoutStreakInfo workoutStreakInfo = new WorkoutStreakInfo(parcel.readInt(), parcel.readInt(), parcel.readLong(), obj4);
            return workoutStreakInfo;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo[] newArray(int i) {
            return new WorkoutStreakInfo[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        WorkoutStreakInfo.Creator creator = new WorkoutStreakInfo.Creator();
        WorkoutStreakInfo.CREATOR = creator;
    }

    public WorkoutStreakInfo(int i, int i2, long l3) {
        super();
        this.currentStreak = i;
        this.longestStreak = i2;
        this.lastAchievedStreakTimestampMs = l3;
    }

    public static app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo copy$default(app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo workoutStreakInfo, int i2, int i3, long l4, int i5, Object object6) {
        int obj1;
        int obj2;
        long obj3;
        if (object6 & 1 != 0) {
            obj1 = workoutStreakInfo.currentStreak;
        }
        if (object6 & 2 != 0) {
            obj2 = workoutStreakInfo.longestStreak;
        }
        if (object6 &= 4 != 0) {
            obj3 = workoutStreakInfo.lastAchievedStreakTimestampMs;
        }
        return workoutStreakInfo.copy(obj1, obj2, obj3);
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
    public final long component3() {
        return this.lastAchievedStreakTimestampMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo copy(int i, int i2, long l3) {
        WorkoutStreakInfo workoutStreakInfo = new WorkoutStreakInfo(i, i2, l3, obj5);
        return workoutStreakInfo;
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
        if (!object instanceof WorkoutStreakInfo) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (this.longestStreak != object.longestStreak) {
            return i2;
        }
        if (Long.compare(lastAchievedStreakTimestampMs, lastAchievedStreakTimestampMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    @Override // android.os.Parcelable
    public final long getLastAchievedStreakTimestampMs() {
        return this.lastAchievedStreakTimestampMs;
    }

    @Override // android.os.Parcelable
    public final int getLongestStreak() {
        return this.longestStreak;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkoutStreakInfo(currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", longestStreak=");
        stringBuilder.append(this.longestStreak);
        stringBuilder.append(", lastAchievedStreakTimestampMs=");
        stringBuilder.append(this.lastAchievedStreakTimestampMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.longestStreak);
        parcel.writeLong(this.lastAchievedStreakTimestampMs);
    }
}
