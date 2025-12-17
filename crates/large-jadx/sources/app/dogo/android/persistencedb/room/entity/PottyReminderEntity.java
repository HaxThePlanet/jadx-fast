package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 +2\u00020\u0001:\u0001+BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u0008¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000cHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\"\u001a\u00020\u0008HÆ\u0003Jf\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u0008HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00082\u0008\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020\u0008J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0012¨\u0006,", d2 = {"Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "", "reminderId", "", "dogId", "ownerId", "days", "", "", "startTime", "endTime", "repeatIntervalMs", "", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getDays", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "getEndTime", "()Z", "getOwnerId", "getReminderId", "getRepeatIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "equals", "other", "hashCode", "", "isEmpty", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyReminderEntity {

    public static final app.dogo.android.persistencedb.room.entity.PottyReminderEntity.Companion Companion;
    private final List<Boolean> days;
    private final String dogId;
    private final String endTime;
    private final boolean isActive;
    private final String ownerId;
    private final String reminderId;
    private final Long repeatIntervalMs;
    private final String startTime;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity$Companion;", "", "()V", "createEmpty", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.android.persistencedb.room.entity.PottyReminderEntity createEmpty() {
            super("", "", "", p.g(), "", "", 0, 0);
            return pottyReminderEntity2;
        }
    }
    static {
        PottyReminderEntity.Companion companion = new PottyReminderEntity.Companion(0);
        PottyReminderEntity.Companion = companion;
    }

    public PottyReminderEntity(String string, String string2, String string3, List<Boolean> list4, String string5, String string6, Long long7, boolean z8) {
        n.f(string, "reminderId");
        n.f(string2, "dogId");
        n.f(string3, "ownerId");
        n.f(list4, "days");
        n.f(string5, "startTime");
        n.f(string6, "endTime");
        super();
        this.reminderId = string;
        this.dogId = string2;
        this.ownerId = string3;
        this.days = list4;
        this.startTime = string5;
        this.endTime = string6;
        this.repeatIntervalMs = long7;
        this.isActive = z8;
    }

    public PottyReminderEntity(String string, String string2, String string3, List list4, String string5, String string6, Long long7, boolean z8, int i9, g g10) {
        List i;
        int i3;
        List list;
        int i2;
        if (i9 & 8 != 0) {
            list = i;
        } else {
            list = list4;
        }
        i2 = i9 & 64 != 0 ? i3 : long7;
        super(string, string2, string3, list, string5, string6, i2, z8);
    }

    public static app.dogo.android.persistencedb.room.entity.PottyReminderEntity copy$default(app.dogo.android.persistencedb.room.entity.PottyReminderEntity pottyReminderEntity, String string2, String string3, String string4, List list5, String string6, String string7, Long long8, boolean z9, int i10, Object object11) {
        boolean isActive;
        String reminderId;
        String dogId;
        String ownerId;
        List days;
        String startTime;
        String endTime;
        Long repeatIntervalMs;
        Object obj = pottyReminderEntity;
        int i = i10;
        reminderId = i & 1 != 0 ? obj.reminderId : string2;
        dogId = i & 2 != 0 ? obj.dogId : string3;
        ownerId = i & 4 != 0 ? obj.ownerId : string4;
        days = i & 8 != 0 ? obj.days : list5;
        startTime = i & 16 != 0 ? obj.startTime : string6;
        endTime = i & 32 != 0 ? obj.endTime : string7;
        repeatIntervalMs = i & 64 != 0 ? obj.repeatIntervalMs : long8;
        isActive = i &= 128 != 0 ? obj.isActive : z9;
        return pottyReminderEntity.copy(reminderId, dogId, ownerId, days, startTime, endTime, repeatIntervalMs, isActive);
    }

    public final String component1() {
        return this.reminderId;
    }

    public final String component2() {
        return this.dogId;
    }

    public final String component3() {
        return this.ownerId;
    }

    public final List<Boolean> component4() {
        return this.days;
    }

    public final String component5() {
        return this.startTime;
    }

    public final String component6() {
        return this.endTime;
    }

    public final Long component7() {
        return this.repeatIntervalMs;
    }

    public final boolean component8() {
        return this.isActive;
    }

    public final app.dogo.android.persistencedb.room.entity.PottyReminderEntity copy(String string, String string2, String string3, List<Boolean> list4, String string5, String string6, Long long7, boolean z8) {
        n.f(string, "reminderId");
        n.f(string2, "dogId");
        n.f(string3, "ownerId");
        n.f(list4, "days");
        n.f(string5, "startTime");
        final Object obj = string6;
        n.f(obj, "endTime");
        super(string, string2, string3, list4, string5, obj, long7, z8);
        return pottyReminderEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PottyReminderEntity) {
            return i2;
        }
        if (!n.b(this.reminderId, object.reminderId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.ownerId, object.ownerId)) {
            return i2;
        }
        if (!n.b(this.days, object.days)) {
            return i2;
        }
        if (!n.b(this.startTime, object.startTime)) {
            return i2;
        }
        if (!n.b(this.endTime, object.endTime)) {
            return i2;
        }
        if (!n.b(this.repeatIntervalMs, object.repeatIntervalMs)) {
            return i2;
        }
        if (this.isActive != object.isActive) {
            return i2;
        }
        return i;
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getReminderId() {
        return this.reminderId;
    }

    public final Long getRepeatIntervalMs() {
        return this.repeatIntervalMs;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int i;
        boolean isActive;
        Long repeatIntervalMs = this.repeatIntervalMs;
        if (repeatIntervalMs == null) {
            i = 0;
        } else {
            i = repeatIntervalMs.hashCode();
        }
        if (this.isActive) {
            isActive = 1;
        }
        return i15 += isActive;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isEmpty() {
        return l.z(this.reminderId);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyReminderEntity(reminderId=");
        stringBuilder.append(this.reminderId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", ownerId=");
        stringBuilder.append(this.ownerId);
        stringBuilder.append(", days=");
        stringBuilder.append(this.days);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", repeatIntervalMs=");
        stringBuilder.append(this.repeatIntervalMs);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.isActive);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
