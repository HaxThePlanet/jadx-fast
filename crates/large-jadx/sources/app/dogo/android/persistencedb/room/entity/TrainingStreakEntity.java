package app.dogo.android.persistencedb.room.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* compiled from: TrainingStreakEntity.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0087\u0008\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006$", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "", "userId", "", "currentStreak", "", "longestStreak", "trainingTimesSec", "", "", "totalTrainingTimeSec", "remoteUpdateTimeMs", "(Ljava/lang/String;IILjava/util/Map;JJ)V", "getCurrentStreak", "()I", "getLongestStreak", "getRemoteUpdateTimeMs", "()J", "getTotalTrainingTimeSec", "getTrainingTimesSec", "()Ljava/util/Map;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrainingStreakEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final TrainingStreakEntity.Companion INSTANCE = new TrainingStreakEntity$Companion(0);
    private final int currentStreak;
    private final int longestStreak;
    private final long remoteUpdateTimeMs;
    private final long totalTrainingTimeSec;
    private final Map<String, Long> trainingTimesSec;
    private final String userId;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity$Companion;", "", "()V", "emptyInstance", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "userId", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final TrainingStreakEntity emptyInstance(String userId) {
            n.f(userId, "userId");
            TrainingStreakEntity trainingStreakEntity = new TrainingStreakEntity(userId, 0, 0, j0.h(), 0L, l, 0, obj);
            return trainingStreakEntity;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public TrainingStreakEntity(String str, int i, int i2, Map<String, Long> map, long j, long j2) {
        n.f(str, "userId");
        n.f(map, "trainingTimesSec");
        super();
        this.userId = str;
        this.currentStreak = i;
        this.longestStreak = i2;
        this.trainingTimesSec = map;
        this.totalTrainingTimeSec = j;
        this.remoteUpdateTimeMs = j2;
    }

    public final int getCurrentStreak() {
        return this.currentStreak;
    }

    public final int getLongestStreak() {
        return this.longestStreak;
    }

    public final long getRemoteUpdateTimeMs() {
        return this.remoteUpdateTimeMs;
    }

    public final long getTotalTrainingTimeSec() {
        return this.totalTrainingTimeSec;
    }

    public final Map<String, Long> getTrainingTimesSec() {
        return this.trainingTimesSec;
    }

    public final String getUserId() {
        return this.userId;
    }


    public static /* synthetic */ TrainingStreakEntity copy$default(TrainingStreakEntity trainingStreakEntity, String str, int i, int i2, Map map, long j, long j2, int i3, Object object) {
        String str22;
        int i32;
        int i42;
        Map map52;
        long j62;
        long i82;
        Object trainingStreakEntity2 = trainingStreakEntity;
        String r1 = i3 & 1 != 0 ? trainingStreakEntity2.userId : str;
        int r2 = i3 & 2 != 0 ? trainingStreakEntity2.currentStreak : i;
        int r3 = i3 & 4 != 0 ? trainingStreakEntity2.longestStreak : i2;
        Map r4 = i3 & 8 != 0 ? trainingStreakEntity2.trainingTimesSec : map;
        long r5 = i3 & 16 != 0 ? trainingStreakEntity2.totalTrainingTimeSec : j;
        long r7 = i3 & 32 != 0 ? trainingStreakEntity2.remoteUpdateTimeMs : j2;
        return trainingStreakEntity.copy(str22, i32, i42, map52, j62, r15, (i3 & 32 != 0 ? trainingStreakEntity2.remoteUpdateTimeMs : j2), r17);
    }

    /* operator */ public final String component1() {
        return this.userId;
    }

    /* operator */ public final int component2() {
        return this.currentStreak;
    }

    /* operator */ public final int component3() {
        return this.longestStreak;
    }

    /* operator */ public final Map<String, Long> component4() {
        return this.trainingTimesSec;
    }

    /* operator */ public final long component5() {
        return this.totalTrainingTimeSec;
    }

    /* operator */ public final long component6() {
        return this.remoteUpdateTimeMs;
    }

    public final TrainingStreakEntity copy(String userId, int currentStreak, int longestStreak, Map<String, Long> trainingTimesSec, long totalTrainingTimeSec, long remoteUpdateTimeMs) {
        n.f(userId, "userId");
        n.f(trainingTimesSec, "trainingTimesSec");
        TrainingStreakEntity trainingStreakEntity = new TrainingStreakEntity(userId, currentStreak, longestStreak, trainingTimesSec, totalTrainingTimeSec, l, remoteUpdateTimeMs, obj2);
        return trainingStreakEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof TrainingStreakEntity)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (this.currentStreak != other.currentStreak) {
            return false;
        }
        if (this.longestStreak != other.longestStreak) {
            return false;
        }
        if (!n.b(this.trainingTimesSec, other.trainingTimesSec)) {
            return false;
        }
        if (this.totalTrainingTimeSec != other.totalTrainingTimeSec) {
            return false;
        }
        return this.remoteUpdateTimeMs != other.remoteUpdateTimeMs ? z5 : z;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + Integer.hashCode(this.currentStreak) * 31 + Integer.hashCode(this.longestStreak) * 31 + this.trainingTimesSec.hashCode() * 31 + Long.hashCode(this.totalTrainingTimeSec) * 31 + Long.hashCode(this.remoteUpdateTimeMs);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrainingStreakEntity(userId=";
        String str3 = ", currentStreak=";
        String str4 = ", longestStreak=";
        String str5 = ", trainingTimesSec=";
        String str6 = ", totalTrainingTimeSec=";
        String str7 = ", remoteUpdateTimeMs=";
        str = str2 + this.userId + str3 + this.currentStreak + str4 + this.longestStreak + str5 + this.trainingTimesSec + str6 + this.totalTrainingTimeSec + str7 + this.remoteUpdateTimeMs + 41;
        return str;
    }
}
