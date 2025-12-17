package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0019\u0008\u0087\u0008\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000cHÆ\u0003JO\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\u0008\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;", "", "dogId", "", "workoutUnlocked", "", "workoutUnlockSource", "workoutUnlockScreenShown", "longestStreak", "", "currentStreak", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;ZLjava/lang/String;ZIIJ)V", "getCurrentStreak", "()I", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "getWorkoutUnlockScreenShown", "()Z", "getWorkoutUnlockSource", "getWorkoutUnlocked", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogLocalEntity {

    private final int currentStreak;
    private final String dogId;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;
    private final boolean workoutUnlockScreenShown;
    private final String workoutUnlockSource;
    private final boolean workoutUnlocked;
    public DogLocalEntity(String string, boolean z2, String string3, boolean z4, int i5, int i6, long l7) {
        n.f(string, "dogId");
        n.f(string3, "workoutUnlockSource");
        super();
        this.dogId = string;
        this.workoutUnlocked = z2;
        this.workoutUnlockSource = string3;
        this.workoutUnlockScreenShown = z4;
        this.longestStreak = i5;
        this.currentStreak = i6;
        this.lastAchievedStreakTimestampMs = l7;
    }

    public DogLocalEntity(String string, boolean z2, String string3, boolean z4, int i5, int i6, long l7, int i8, g g9) {
        int i3;
        int i4;
        String str;
        int i7;
        int i;
        int i2;
        i4 = 0;
        i3 = g9 & 2 != 0 ? i4 : z2;
        str = g9 & 4 != 0 ? "" : string3;
        i7 = g9 & 8 != 0 ? i4 : z4;
        i = g9 & 16 != 0 ? i4 : i5;
        if (g9 & 32 != 0) {
        } else {
            i4 = i6;
        }
        i2 = g9 & 64 != 0 ? 0 : l7;
        super(string, i3, str, i7, i, i4, i2, obj17);
    }

    public static app.dogo.android.persistencedb.room.entity.DogLocalEntity copy$default(app.dogo.android.persistencedb.room.entity.DogLocalEntity dogLocalEntity, String string2, boolean z3, String string4, boolean z5, int i6, int i7, long l8, int i9, Object object10) {
        String dogId;
        boolean workoutUnlocked;
        String workoutUnlockSource;
        boolean workoutUnlockScreenShown;
        int longestStreak;
        int currentStreak;
        long lastAchievedStreakTimestampMs;
        Object obj = dogLocalEntity;
        dogId = object10 & 1 != 0 ? obj.dogId : string2;
        workoutUnlocked = object10 & 2 != 0 ? obj.workoutUnlocked : z3;
        workoutUnlockSource = object10 & 4 != 0 ? obj.workoutUnlockSource : string4;
        workoutUnlockScreenShown = object10 & 8 != 0 ? obj.workoutUnlockScreenShown : z5;
        longestStreak = object10 & 16 != 0 ? obj.longestStreak : i6;
        currentStreak = object10 & 32 != 0 ? obj.currentStreak : i7;
        lastAchievedStreakTimestampMs = object10 & 64 != 0 ? obj.lastAchievedStreakTimestampMs : l8;
        return dogLocalEntity.copy(dogId, workoutUnlocked, workoutUnlockSource, workoutUnlockScreenShown, longestStreak, currentStreak, lastAchievedStreakTimestampMs);
    }

    public final String component1() {
        return this.dogId;
    }

    public final boolean component2() {
        return this.workoutUnlocked;
    }

    public final String component3() {
        return this.workoutUnlockSource;
    }

    public final boolean component4() {
        return this.workoutUnlockScreenShown;
    }

    public final int component5() {
        return this.longestStreak;
    }

    public final int component6() {
        return this.currentStreak;
    }

    public final long component7() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final app.dogo.android.persistencedb.room.entity.DogLocalEntity copy(String string, boolean z2, String string3, boolean z4, int i5, int i6, long l7) {
        n.f(string, "dogId");
        n.f(string3, "workoutUnlockSource");
        super(string, z2, string3, z4, i5, i6, l7, obj9);
        return dogLocalEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DogLocalEntity) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (this.workoutUnlocked != object.workoutUnlocked) {
            return i2;
        }
        if (!n.b(this.workoutUnlockSource, object.workoutUnlockSource)) {
            return i2;
        }
        if (this.workoutUnlockScreenShown != object.workoutUnlockScreenShown) {
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

    public final boolean getWorkoutUnlockScreenShown() {
        return this.workoutUnlockScreenShown;
    }

    public final String getWorkoutUnlockSource() {
        return this.workoutUnlockSource;
    }

    public final boolean getWorkoutUnlocked() {
        return this.workoutUnlocked;
    }

    public int hashCode() {
        boolean workoutUnlocked;
        int i;
        if (this.workoutUnlocked) {
            workoutUnlocked = i;
        }
        boolean workoutUnlockScreenShown = this.workoutUnlockScreenShown;
        if (workoutUnlockScreenShown) {
        } else {
            i = workoutUnlockScreenShown;
        }
        return i13 += i18;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogLocalEntity(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", workoutUnlocked=");
        stringBuilder.append(this.workoutUnlocked);
        stringBuilder.append(", workoutUnlockSource=");
        stringBuilder.append(this.workoutUnlockSource);
        stringBuilder.append(", workoutUnlockScreenShown=");
        stringBuilder.append(this.workoutUnlockScreenShown);
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
