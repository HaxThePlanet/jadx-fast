package app.dogo.android.persistencedb.room.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0087\u0008\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006$", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "", "userId", "", "currentStreak", "", "longestStreak", "trainingTimesSec", "", "", "totalTrainingTimeSec", "remoteUpdateTimeMs", "(Ljava/lang/String;IILjava/util/Map;JJ)V", "getCurrentStreak", "()I", "getLongestStreak", "getRemoteUpdateTimeMs", "()J", "getTotalTrainingTimeSec", "getTrainingTimesSec", "()Ljava/util/Map;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrainingStreakEntity {

    public static final app.dogo.android.persistencedb.room.entity.TrainingStreakEntity.Companion Companion;
    private final int currentStreak;
    private final int longestStreak;
    private final long remoteUpdateTimeMs;
    private final long totalTrainingTimeSec;
    private final Map<String, Long> trainingTimesSec;
    private final String userId;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity$Companion;", "", "()V", "emptyInstance", "Lapp/dogo/android/persistencedb/room/entity/TrainingStreakEntity;", "userId", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.android.persistencedb.room.entity.TrainingStreakEntity emptyInstance(String string) {
            n.f(string, "userId");
            super(string, 0, 0, j0.h(), 0, obj7, 0, obj9);
            return trainingStreakEntity;
        }
    }
    static {
        TrainingStreakEntity.Companion companion = new TrainingStreakEntity.Companion(0);
        TrainingStreakEntity.Companion = companion;
    }

    public TrainingStreakEntity(String string, int i2, int i3, Map<String, Long> map4, long l5, long l6) {
        n.f(string, "userId");
        n.f(map4, "trainingTimesSec");
        super();
        this.userId = string;
        this.currentStreak = i2;
        this.longestStreak = i3;
        this.trainingTimesSec = map4;
        this.totalTrainingTimeSec = l5;
        this.remoteUpdateTimeMs = obj8;
    }

    public static app.dogo.android.persistencedb.room.entity.TrainingStreakEntity copy$default(app.dogo.android.persistencedb.room.entity.TrainingStreakEntity trainingStreakEntity, String string2, int i3, int i4, Map map5, long l6, long l7, int i8, Object object9) {
        String userId;
        int currentStreak;
        int longestStreak;
        Map trainingTimesSec;
        long totalTrainingTimeSec;
        long remoteUpdateTimeMs;
        Object obj = trainingStreakEntity;
        userId = obj18 & 1 != 0 ? obj.userId : string2;
        currentStreak = obj18 & 2 != 0 ? obj.currentStreak : i3;
        longestStreak = obj18 & 4 != 0 ? obj.longestStreak : i4;
        trainingTimesSec = obj18 & 8 != 0 ? obj.trainingTimesSec : map5;
        totalTrainingTimeSec = obj18 & 16 != 0 ? obj.totalTrainingTimeSec : l6;
        remoteUpdateTimeMs = obj18 & 32 != 0 ? obj.remoteUpdateTimeMs : i8;
        return trainingStreakEntity.copy(userId, currentStreak, longestStreak, trainingTimesSec, totalTrainingTimeSec, l7);
    }

    public final String component1() {
        return this.userId;
    }

    public final int component2() {
        return this.currentStreak;
    }

    public final int component3() {
        return this.longestStreak;
    }

    public final Map<String, Long> component4() {
        return this.trainingTimesSec;
    }

    public final long component5() {
        return this.totalTrainingTimeSec;
    }

    public final long component6() {
        return this.remoteUpdateTimeMs;
    }

    public final app.dogo.android.persistencedb.room.entity.TrainingStreakEntity copy(String string, int i2, int i3, Map<String, Long> map4, long l5, long l6) {
        n.f(string, "userId");
        n.f(map4, "trainingTimesSec");
        super(string, i2, i3, map4, l5, obj7, obj17, obj9);
        return trainingStreakEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrainingStreakEntity) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (this.currentStreak != object.currentStreak) {
            return i2;
        }
        if (this.longestStreak != object.longestStreak) {
            return i2;
        }
        if (!n.b(this.trainingTimesSec, object.trainingTimesSec)) {
            return i2;
        }
        if (Long.compare(totalTrainingTimeSec, totalTrainingTimeSec2) != 0) {
            return i2;
        }
        if (Long.compare(remoteUpdateTimeMs, remoteUpdateTimeMs2) != 0) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingStreakEntity(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", currentStreak=");
        stringBuilder.append(this.currentStreak);
        stringBuilder.append(", longestStreak=");
        stringBuilder.append(this.longestStreak);
        stringBuilder.append(", trainingTimesSec=");
        stringBuilder.append(this.trainingTimesSec);
        stringBuilder.append(", totalTrainingTimeSec=");
        stringBuilder.append(this.totalTrainingTimeSec);
        stringBuilder.append(", remoteUpdateTimeMs=");
        stringBuilder.append(this.remoteUpdateTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
