package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogLocalStreakInfoUpdate;", "", "dogId", "", "longestStreak", "", "currentStreak", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;IIJ)V", "getCurrentStreak", "()I", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogLocalStreakInfoUpdate {

    private final int currentStreak;
    private final String dogId;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;
    public DogLocalStreakInfoUpdate(String string, int i2, int i3, long l4) {
        n.f(string, "dogId");
        super();
        this.dogId = string;
        this.longestStreak = i2;
        this.currentStreak = i3;
        this.lastAchievedStreakTimestampMs = l4;
    }

    public DogLocalStreakInfoUpdate(String string, int i2, int i3, long l4, int i5, g g6) {
        int i;
        int i4;
        int obj11;
        final int i6 = 0;
        i = g6 & 2 != 0 ? i6 : i2;
        i4 = g6 & 4 != 0 ? i6 : i3;
        obj11 = g6 & 8 != 0 ? 0 : obj11;
        super(string, i, i4, obj11, obj6);
    }

    public static app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate copy$default(app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate, String string2, int i3, int i4, long l5, int i6, Object object7) {
        String obj4;
        int obj5;
        int obj6;
        long obj7;
        if (object7 & 1 != 0) {
            obj4 = dogLocalStreakInfoUpdate.dogId;
        }
        if (object7 & 2 != 0) {
            obj5 = dogLocalStreakInfoUpdate.longestStreak;
        }
        int obj10 = obj5;
        if (object7 & 4 != 0) {
            obj6 = dogLocalStreakInfoUpdate.currentStreak;
        }
        if (object7 & 8 != 0) {
            obj7 = dogLocalStreakInfoUpdate.lastAchievedStreakTimestampMs;
        }
        return dogLocalStreakInfoUpdate.copy(obj4, obj10, obj6, obj7);
    }

    public final String component1() {
        return this.dogId;
    }

    public final int component2() {
        return this.longestStreak;
    }

    public final int component3() {
        return this.currentStreak;
    }

    public final long component4() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final app.dogo.android.persistencedb.room.entity.DogLocalStreakInfoUpdate copy(String string, int i2, int i3, long l4) {
        n.f(string, "dogId");
        super(string, i2, i3, l4, obj6);
        return dogLocalStreakInfoUpdate;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DogLocalStreakInfoUpdate) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (this.longestStreak != object.longestStreak) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (Long.compare(lastAchievedStreakTimestampMs, lastAchievedStreakTimestampMs2) != 0) {
            return i2;
        }
        return i;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final long getLastAchievedStreakTimestampMs() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final int getLongestStreak() {
        return this.longestStreak;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogLocalStreakInfoUpdate(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", longestStreak=");
        stringBuilder.append(this.longestStreak);
        stringBuilder.append(", currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", lastAchievedStreakTimestampMs=");
        stringBuilder.append(this.lastAchievedStreakTimestampMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
