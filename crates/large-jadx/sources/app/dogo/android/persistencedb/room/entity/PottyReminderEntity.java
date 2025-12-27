package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* compiled from: PottyReminderEntity.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u001b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 +2\u00020\u0001:\u0001+BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u0008¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000cHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\"\u001a\u00020\u0008HÆ\u0003Jf\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u0008HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00082\u0008\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020\u0008J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0012¨\u0006,", d2 = {"Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "", "reminderId", "", "dogId", "ownerId", "days", "", "", "startTime", "endTime", "repeatIntervalMs", "", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "getDays", "()Ljava/util/List;", "getDogId", "()Ljava/lang/String;", "getEndTime", "()Z", "getOwnerId", "getReminderId", "getRepeatIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "equals", "other", "hashCode", "", "isEmpty", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PottyReminderEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PottyReminderEntity.Companion INSTANCE = new PottyReminderEntity$Companion(0);
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
        private Companion() {
            super();
        }

        public final PottyReminderEntity createEmpty() {
            PottyReminderEntity pottyReminderEntity = new PottyReminderEntity("", "", "", p.g(), "", "", null, false);
            return pottyReminderEntity;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public PottyReminderEntity(String str, String str2, String str3, List<Boolean> list, String str4, String str5, Long long, boolean z) {
        n.f(str, "reminderId");
        n.f(str2, "dogId");
        n.f(str3, "ownerId");
        n.f(list, "days");
        n.f(str4, "startTime");
        n.f(str5, "endTime");
        super();
        this.reminderId = str;
        this.dogId = str2;
        this.ownerId = str3;
        this.days = list;
        this.startTime = str4;
        this.endTime = str5;
        this.repeatIntervalMs = long;
        this.isActive = z;
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

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isEmpty() {
        return l.z(this.reminderId);
    }

    public /* synthetic */ PottyReminderEntity(String str, String str2, String str3, List list, String str4, String str5, Long long, boolean z, int i, g gVar) {
        List list42;
        Long long72;
        list42 = i & 8 != 0 ? list42 : list;
        i = i & 64;
        i = i & 64 != 0 ? i : long;
        this(str, str2, str3, list42, str4, str5, long72, z);
    }


    public static /* synthetic */ PottyReminderEntity copy$default(PottyReminderEntity pottyReminderEntity, String str, String str2, String str3, List list, String str4, String str5, Long long, boolean z, int i, Object object) {
        boolean z92;
        String str22;
        String str32;
        String str42;
        List list52;
        String str62;
        String str72;
        Long long82;
        Object pottyReminderEntity2 = pottyReminderEntity;
        int i102 = i;
        String r2 = i102 & 1 != 0 ? pottyReminderEntity2.reminderId : str;
        String r3 = i102 & 2 != 0 ? pottyReminderEntity2.dogId : str2;
        String r4 = i102 & 4 != 0 ? pottyReminderEntity2.ownerId : str3;
        List r5 = i102 & 8 != 0 ? pottyReminderEntity2.days : list;
        String r6 = i102 & 16 != 0 ? pottyReminderEntity2.startTime : str4;
        String r7 = i102 & 32 != 0 ? pottyReminderEntity2.endTime : str5;
        Long r8 = i102 & 64 != 0 ? pottyReminderEntity2.repeatIntervalMs : long;
        boolean r1 = i102 & 128 != 0 ? pottyReminderEntity2.isActive : z;
        return pottyReminderEntity.copy(str22, str32, str42, list52, str62, str72, long82, (i102 & 128 != 0 ? pottyReminderEntity2.isActive : z));
    }

    /* operator */ public final String component1() {
        return this.reminderId;
    }

    /* operator */ public final String component2() {
        return this.dogId;
    }

    /* operator */ public final String component3() {
        return this.ownerId;
    }

    /* operator */ public final List<Boolean> component4() {
        return this.days;
    }

    /* operator */ public final String component5() {
        return this.startTime;
    }

    /* operator */ public final String component6() {
        return this.endTime;
    }

    /* operator */ public final Long component7() {
        return this.repeatIntervalMs;
    }

    /* operator */ public final boolean component8() {
        return this.isActive;
    }

    public final PottyReminderEntity copy(String reminderId, String dogId, String ownerId, List<Boolean> days, String startTime, String endTime, Long repeatIntervalMs, boolean isActive) {
        n.f(reminderId, "reminderId");
        n.f(dogId, "dogId");
        n.f(ownerId, "ownerId");
        n.f(days, "days");
        n.f(startTime, "startTime");
        final Object endTime2 = endTime;
        n.f(endTime2, "endTime");
        PottyReminderEntity pottyReminderEntity = new PottyReminderEntity(reminderId, dogId, ownerId, days, startTime, endTime2, repeatIntervalMs, isActive);
        return pottyReminderEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z10 = false;
        if (!(other instanceof PottyReminderEntity)) {
            return false;
        }
        if (!n.b(this.reminderId, other.reminderId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.ownerId, other.ownerId)) {
            return false;
        }
        if (!n.b(this.days, other.days)) {
            return false;
        }
        if (!n.b(this.startTime, other.startTime)) {
            return false;
        }
        if (!n.b(this.endTime, other.endTime)) {
            return false;
        }
        if (!n.b(this.repeatIntervalMs, other.repeatIntervalMs)) {
            return false;
        }
        return this.isActive != other.isActive ? z10 : z;
    }

    public int hashCode() {
        int i = 0;
        boolean isActive2 = true;
        if (this.repeatIntervalMs == null) {
            i = 0;
        } else {
            i = this.repeatIntervalMs.hashCode();
        }
        if (this.isActive) {
            int i22 = 1;
        }
        return (this.reminderId.hashCode() * 31) + this.dogId.hashCode() * 31 + this.ownerId.hashCode() * 31 + this.days.hashCode() * 31 + this.startTime.hashCode() * 31 + this.endTime.hashCode() * 31 + i * 31 + isActive2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PottyReminderEntity(reminderId=";
        String str3 = ", dogId=";
        String str4 = ", ownerId=";
        String str5 = ", days=";
        String str6 = ", startTime=";
        String str7 = ", endTime=";
        String str8 = ", repeatIntervalMs=";
        String str9 = ", isActive=";
        str = str2 + this.reminderId + str3 + this.dogId + str4 + this.ownerId + str5 + this.days + str6 + this.startTime + str7 + this.endTime + str8 + this.repeatIntervalMs + str9 + this.isActive + 41;
        return str;
    }
}
