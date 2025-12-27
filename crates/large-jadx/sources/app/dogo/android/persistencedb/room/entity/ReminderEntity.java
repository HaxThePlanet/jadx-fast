package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ReminderEntity.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u001c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J_\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\u0008\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012¨\u0006&", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "", "reminderId", "", "ownerId", "days", "", "", "name", "type", "time", "repeating", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDays", "()Ljava/util/List;", "()Z", "getName", "()Ljava/lang/String;", "getOwnerId", "getReminderId", "getRepeating", "getTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ReminderEntity {

    private final List<Boolean> days;
    private final boolean isActive;
    private final String name;
    private final String ownerId;
    private final String reminderId;
    private final String repeating;
    private final String time;
    private final String type;
    public ReminderEntity(String str, String str2, List<Boolean> list, String str3, String str4, String str5, String str6, boolean z) {
        n.f(str, "reminderId");
        n.f(str2, "ownerId");
        n.f(list, "days");
        n.f(str3, "name");
        n.f(str4, "type");
        n.f(str5, "time");
        n.f(str6, "repeating");
        super();
        this.reminderId = str;
        this.ownerId = str2;
        this.days = list;
        this.name = str3;
        this.type = str4;
        this.time = str5;
        this.repeating = str6;
        this.isActive = z;
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getReminderId() {
        return this.reminderId;
    }

    public final String getRepeating() {
        return this.repeating;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public /* synthetic */ ReminderEntity(String str, String str2, List list, String str3, String str4, String str5, String str6, boolean z, int i, g gVar) {
        List list32;
        list32 = i & 4 != 0 ? list32 : list;
        this(str, str2, list32, str3, str4, str5, str6, z);
    }

    public static /* synthetic */ ReminderEntity copy$default(ReminderEntity reminderEntity, String str, String str2, List list, String str3, String str4, String str5, String str6, boolean z, int i, Object object) {
        boolean z92;
        String str22;
        String str32;
        List list42;
        String str52;
        String str62;
        String str72;
        String str82;
        Object reminderEntity2 = reminderEntity;
        int i102 = i;
        String r2 = i102 & 1 != 0 ? reminderEntity2.reminderId : str;
        String r3 = i102 & 2 != 0 ? reminderEntity2.ownerId : str2;
        List r4 = i102 & 4 != 0 ? reminderEntity2.days : list;
        String r5 = i102 & 8 != 0 ? reminderEntity2.name : str3;
        String r6 = i102 & 16 != 0 ? reminderEntity2.type : str4;
        String r7 = i102 & 32 != 0 ? reminderEntity2.time : str5;
        String r8 = i102 & 64 != 0 ? reminderEntity2.repeating : str6;
        boolean r1 = i102 & 128 != 0 ? reminderEntity2.isActive : z;
        return reminderEntity.copy(str22, str32, list42, str52, str62, str72, str82, (i102 & 128 != 0 ? reminderEntity2.isActive : z));
    }

    /* operator */ public final String component1() {
        return this.reminderId;
    }

    /* operator */ public final String component2() {
        return this.ownerId;
    }

    /* operator */ public final List<Boolean> component3() {
        return this.days;
    }

    /* operator */ public final String component4() {
        return this.name;
    }

    /* operator */ public final String component5() {
        return this.type;
    }

    /* operator */ public final String component6() {
        return this.time;
    }

    /* operator */ public final String component7() {
        return this.repeating;
    }

    /* operator */ public final boolean component8() {
        return this.isActive;
    }

    public final ReminderEntity copy(String reminderId, String ownerId, List<Boolean> days, String name, String type, String time, String repeating, boolean isActive) {
        n.f(reminderId, "reminderId");
        n.f(ownerId, "ownerId");
        n.f(days, "days");
        n.f(name, "name");
        n.f(type, "type");
        final Object time2 = time;
        n.f(time2, "time");
        final Object repeating2 = repeating;
        n.f(repeating2, "repeating");
        ReminderEntity reminderEntity = new ReminderEntity(reminderId, ownerId, days, name, type, time2, repeating2, isActive);
        return reminderEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z10 = false;
        if (!(other instanceof ReminderEntity)) {
            return false;
        }
        if (!n.b(this.reminderId, other.reminderId)) {
            return false;
        }
        if (!n.b(this.ownerId, other.ownerId)) {
            return false;
        }
        if (!n.b(this.days, other.days)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (!n.b(this.time, other.time)) {
            return false;
        }
        if (!n.b(this.repeating, other.repeating)) {
            return false;
        }
        return this.isActive != other.isActive ? z10 : z;
    }

    public int hashCode() {
        boolean isActive2 = true;
        if (this.isActive) {
            int i22 = 1;
        }
        return (this.reminderId.hashCode() * 31) + this.ownerId.hashCode() * 31 + this.days.hashCode() * 31 + this.name.hashCode() * 31 + this.type.hashCode() * 31 + this.time.hashCode() * 31 + this.repeating.hashCode() * 31 + isActive2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ReminderEntity(reminderId=";
        String str3 = ", ownerId=";
        String str4 = ", days=";
        String str5 = ", name=";
        String str6 = ", type=";
        String str7 = ", time=";
        String str8 = ", repeating=";
        String str9 = ", isActive=";
        str = str2 + this.reminderId + str3 + this.ownerId + str4 + this.days + str5 + this.name + str6 + this.type + str7 + this.time + str8 + this.repeating + str9 + this.isActive + 41;
        return str;
    }
}
