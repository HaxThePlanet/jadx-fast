package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLocalStreakInfoUpdate.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u001b", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogLocalStreakInfoUpdate;", "", "dogId", "", "longestStreak", "", "currentStreak", "lastAchievedStreakTimestampMs", "", "(Ljava/lang/String;IIJ)V", "getCurrentStreak", "()I", "getDogId", "()Ljava/lang/String;", "getLastAchievedStreakTimestampMs", "()J", "getLongestStreak", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogLocalStreakInfoUpdate {

    private final int currentStreak;
    private final String dogId;
    private final long lastAchievedStreakTimestampMs;
    private final int longestStreak;
    public DogLocalStreakInfoUpdate(String str, int i, int i2, long j) {
        n.f(str, "dogId");
        super();
        this.dogId = str;
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

    public /* synthetic */ DogLocalStreakInfoUpdate(String str, int i, int i2, long j, int i3, g gVar) {
        int i22;
        int j42 = 0;
        i22 = 0;
        int r3 = i3 & 2 != 0 ? i22 : i;
        int r4 = i3 & 4 != 0 ? i22 : i2;
        j42 = i3 & 8 != 0 ? 0 : j42;
        this(str, i22, i22, j42, obj);
    }

    public static /* synthetic */ DogLocalStreakInfoUpdate copy$default(DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate, String str, int i, int i2, long j, int i3, Object object) {
        String str22;
        int i32;
        int i42;
        long j52;
        if (i3 & 1 != 0) {
        }
        if (i3 & 2 != 0) {
        }
        if (i3 & 4 != 0) {
        }
        if (i3 & 8 != 0) {
        }
        return dogLocalStreakInfoUpdate.copy(str22, i32, i42, j52);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final int component2() {
        return this.longestStreak;
    }

    /* operator */ public final int component3() {
        return this.currentStreak;
    }

    /* operator */ public final long component4() {
        return this.lastAchievedStreakTimestampMs;
    }

    public final DogLocalStreakInfoUpdate copy(String dogId, int longestStreak, int currentStreak, long lastAchievedStreakTimestampMs) {
        n.f(dogId, "dogId");
        DogLocalStreakInfoUpdate dogLocalStreakInfoUpdate = new DogLocalStreakInfoUpdate(dogId, longestStreak, currentStreak, lastAchievedStreakTimestampMs, obj);
        return dogLocalStreakInfoUpdate;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof DogLocalStreakInfoUpdate)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        return this.lastAchievedStreakTimestampMs != other.lastAchievedStreakTimestampMs ? z4 : z;
    }

    public int hashCode() {
        return (this.dogId.hashCode() * 31) + Integer.hashCode(this.longestStreak) * 31 + Integer.hashCode(this.currentStreak) * 31 + Long.hashCode(this.lastAchievedStreakTimestampMs);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogLocalStreakInfoUpdate(dogId=";
        String str3 = ", longestStreak=";
        String str4 = ", currentStreak=";
        String str5 = ", lastAchievedStreakTimestampMs=";
        str = str2 + this.dogId + str3 + this.longestStreak + str4 + this.currentStreak + str5 + this.lastAchievedStreakTimestampMs + 41;
        return str;
    }
}
