package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLocalEntity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0019\u0008\u0087\u0008\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000cHÆ\u0003JO\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\u0008\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016¨\u0006%", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogLocalEntity;", "", "dogId", "", "workoutUnlocked", "", "workoutUnlockSource", "workoutUnlockScreenShown", "longestStreak", "", "currentStreak", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;ZLjava/lang/String;ZIIJ)V", "getCurrentStreak", "()I", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "getWorkoutUnlockScreenShown", "()Z", "getWorkoutUnlockSource", "getWorkoutUnlocked", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogLocalEntity {

    private final int currentStreak;
    private final String dogId;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;
    private final boolean workoutUnlockScreenShown;
    private final String workoutUnlockSource;
    private final boolean workoutUnlocked;
    public DogLocalEntity(String str, boolean z, String str2, boolean z2, int i, int i2, long j) {
        n.f(str, "dogId");
        n.f(str2, "workoutUnlockSource");
        super();
        this.dogId = str;
        this.workoutUnlocked = z;
        this.workoutUnlockSource = str2;
        this.workoutUnlockScreenShown = z2;
        this.longestStreak = i;
        this.currentStreak = i2;
        this.lastAchievedStreakTimestampMs = j;
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

    public /* synthetic */ DogLocalEntity(String str, boolean z, String str2, boolean z2, int i, int i2, long j, int i3, g gVar) {
        int z22;
        String str32;
        int j72 = 0;
        z22 = 0;
        int r0 = i3 & 2 != 0 ? z22 : z;
        String r2 = i3 & 4 != 0 ? "" : str2;
        int r3 = i3 & 8 != 0 ? z22 : z2;
        int r4 = i3 & 16 != 0 ? z22 : i;
        if (i3 & 32 == 0) {
            z22 = i2;
        }
        int r5 = i3 & 64 != 0 ? 0 : j;
        this(str, z22, str32, z22, z22, z22, (i3 & 64 != 0 ? 0 : j), gVar);
    }

    public static /* synthetic */ DogLocalEntity copy$default(DogLocalEntity dogLocalEntity, String str, boolean z, String str2, boolean z2, int i, int i2, long j, int i3, Object object) {
        String str22;
        boolean z32;
        String str42;
        boolean z52;
        int i62;
        int i72;
        long j82;
        Object dogLocalEntity2 = dogLocalEntity;
        String r1 = i3 & 1 != 0 ? dogLocalEntity2.dogId : str;
        boolean r2 = i3 & 2 != 0 ? dogLocalEntity2.workoutUnlocked : z;
        String r3 = i3 & 4 != 0 ? dogLocalEntity2.workoutUnlockSource : str2;
        boolean r4 = i3 & 8 != 0 ? dogLocalEntity2.workoutUnlockScreenShown : z2;
        int r5 = i3 & 16 != 0 ? dogLocalEntity2.longestStreak : i;
        int r6 = i3 & 32 != 0 ? dogLocalEntity2.currentStreak : i2;
        long r7 = i3 & 64 != 0 ? dogLocalEntity2.lastAchievedStreakTimestampMs : j;
        return dogLocalEntity.copy(str22, z32, str42, z52, i62, i72, (i3 & 64 != 0 ? dogLocalEntity2.lastAchievedStreakTimestampMs : j), r17);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final boolean component2() {
        return this.workoutUnlocked;
    }

    /* operator */ public final String component3() {
        return this.workoutUnlockSource;
    }

    /* operator */ public final boolean component4() {
        return this.workoutUnlockScreenShown;
    }

    /* operator */ public final int component5() {
        return this.longestStreak;
    }

    /* operator */ public final int component6() {
        return this.currentStreak;
    }

    /* operator */ public final long component7() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final DogLocalEntity copy(String dogId, boolean workoutUnlocked, String workoutUnlockSource, boolean workoutUnlockScreenShown, int longestStreak, int currentStreak, long lastAchievedStreakTimestampMs) {
        n.f(dogId, "dogId");
        n.f(workoutUnlockSource, "workoutUnlockSource");
        DogLocalEntity dogLocalEntity = new DogLocalEntity(dogId, workoutUnlocked, workoutUnlockSource, workoutUnlockScreenShown, longestStreak, currentStreak, lastAchievedStreakTimestampMs, obj);
        return dogLocalEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof DogLocalEntity)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (this.workoutUnlocked != other.workoutUnlocked) {
            return false;
        }
        if (!n.b(this.workoutUnlockSource, other.workoutUnlockSource)) {
            return false;
        }
        if (this.workoutUnlockScreenShown != other.workoutUnlockScreenShown) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        return this.lastAchievedStreakTimestampMs != other.lastAchievedStreakTimestampMs ? z5 : z;
    }

    public int hashCode() {
        boolean workoutUnlocked2;
        int i = 1;
        i = 1;
        if (this.workoutUnlocked) {
        }
        if (!(this.workoutUnlockScreenShown)) {
        }
        return (this.dogId.hashCode() * 31) + workoutUnlocked2 * 31 + this.workoutUnlockSource.hashCode() * 31 + i * 31 + Integer.hashCode(this.longestStreak) * 31 + Integer.hashCode(this.currentStreak) * 31 + Long.hashCode(this.lastAchievedStreakTimestampMs);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogLocalEntity(dogId=";
        String str3 = ", workoutUnlocked=";
        String str4 = ", workoutUnlockSource=";
        String str5 = ", workoutUnlockScreenShown=";
        String str6 = ", longestStreak=";
        String str7 = ", currentStreak=";
        String str8 = ", lastAchievedStreakTimestampMs=";
        str = str2 + this.dogId + str3 + this.workoutUnlocked + str4 + this.workoutUnlockSource + str5 + this.workoutUnlockScreenShown + str6 + this.longestStreak + str7 + this.currentStreak + str8 + this.lastAchievedStreakTimestampMs + 41;
        return str;
    }
}
