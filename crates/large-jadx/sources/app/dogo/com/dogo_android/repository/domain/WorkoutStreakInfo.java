package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: WorkoutStreakInfo.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "Landroid/os/Parcelable;", "currentStreak", "", "longestStreak", "lastAchievedStreakTimestampMs", "", "(IIJ)V", "getCurrentStreak", "()I", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WorkoutStreakInfo implements Parcelable {

    public static final Parcelable.Creator<WorkoutStreakInfo> CREATOR = new WorkoutStreakInfo$Creator<>();
    private final int currentStreak;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkoutStreakInfo> {
        @Override // android.os.Parcelable$Creator
        public final WorkoutStreakInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new WorkoutStreakInfo(parcel.readInt(), parcel.readInt(), parcel.readLong(), r4);
        }

        @Override // android.os.Parcelable$Creator
        public final WorkoutStreakInfo[] newArray(int i) {
            return new WorkoutStreakInfo[i];
        }
    }
    public WorkoutStreakInfo(int i, int i2, long j) {
        super();
        this.currentStreak = i;
        this.longestStreak = i2;
        this.lastAchievedStreakTimestampMs = j;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final long getLastAchievedStreakTimestampMs() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final int getLongestStreak() {
        return this.longestStreak;
    }


    public static /* synthetic */ WorkoutStreakInfo copy$default(WorkoutStreakInfo workoutStreakInfo, int i, int i2, long j, int i3, Object object) {
        int currentStreak2;
        int longestStreak2;
        long lastAchievedStreakTimestampMs2;
        if (i3 & 1 != 0) {
        }
        if (i3 & 2 != 0) {
        }
        if (i3 & 4 != 0) {
        }
        return workoutStreakInfo.copy(currentStreak2, longestStreak2, lastAchievedStreakTimestampMs2);
    }

    /* operator */ public final int component1() {
        return this.currentStreak;
    }

    /* operator */ public final int component2() {
        return this.longestStreak;
    }

    /* operator */ public final long component3() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final WorkoutStreakInfo copy(int currentStreak, int longestStreak, long lastAchievedStreakTimestampMs) {
        return new WorkoutStreakInfo(currentStreak, longestStreak, lastAchievedStreakTimestampMs, r5);
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
        if (!(other instanceof WorkoutStreakInfo)) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        return this.lastAchievedStreakTimestampMs != other.lastAchievedStreakTimestampMs ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Integer.hashCode(this.currentStreak) * 31) + Integer.hashCode(this.longestStreak) * 31 + Long.hashCode(this.lastAchievedStreakTimestampMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "WorkoutStreakInfo(currentStreak=";
        String str3 = ", longestStreak=";
        String str4 = ", lastAchievedStreakTimestampMs=";
        str = str2 + this.currentStreak + str3 + this.longestStreak + str4 + this.lastAchievedStreakTimestampMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.currentStreak);
        parcel.writeInt(this.longestStreak);
        parcel.writeLong(this.lastAchievedStreakTimestampMs);
    }
}
