package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u001c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J_\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\u0008\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u000c\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012¨\u0006&", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "", "reminderId", "", "ownerId", "days", "", "", "name", "type", "time", "repeating", "isActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDays", "()Ljava/util/List;", "()Z", "getName", "()Ljava/lang/String;", "getOwnerId", "getReminderId", "getRepeating", "getTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReminderEntity {

    private final List<Boolean> days;
    private final boolean isActive;
    private final String name;
    private final String ownerId;
    private final String reminderId;
    private final String repeating;
    private final String time;
    private final String type;
    public ReminderEntity(String string, String string2, List<Boolean> list3, String string4, String string5, String string6, String string7, boolean z8) {
        n.f(string, "reminderId");
        n.f(string2, "ownerId");
        n.f(list3, "days");
        n.f(string4, "name");
        n.f(string5, "type");
        n.f(string6, "time");
        n.f(string7, "repeating");
        super();
        this.reminderId = string;
        this.ownerId = string2;
        this.days = list3;
        this.name = string4;
        this.type = string5;
        this.time = string6;
        this.repeating = string7;
        this.isActive = z8;
    }

    public ReminderEntity(String string, String string2, List list3, String string4, String string5, String string6, String string7, boolean z8, int i9, g g10) {
        List i;
        List list;
        if (i9 & 4 != 0) {
            list = i;
        } else {
            list = list3;
        }
        super(string, string2, list, string4, string5, string6, string7, z8);
    }

    public static app.dogo.android.persistencedb.room.entity.ReminderEntity copy$default(app.dogo.android.persistencedb.room.entity.ReminderEntity reminderEntity, String string2, String string3, List list4, String string5, String string6, String string7, String string8, boolean z9, int i10, Object object11) {
        boolean isActive;
        String reminderId;
        String ownerId;
        List days;
        String name;
        String type;
        String time;
        String repeating;
        Object obj = reminderEntity;
        int i = i10;
        reminderId = i & 1 != 0 ? obj.reminderId : string2;
        ownerId = i & 2 != 0 ? obj.ownerId : string3;
        days = i & 4 != 0 ? obj.days : list4;
        name = i & 8 != 0 ? obj.name : string5;
        type = i & 16 != 0 ? obj.type : string6;
        time = i & 32 != 0 ? obj.time : string7;
        repeating = i & 64 != 0 ? obj.repeating : string8;
        isActive = i &= 128 != 0 ? obj.isActive : z9;
        return reminderEntity.copy(reminderId, ownerId, days, name, type, time, repeating, isActive);
    }

    public final String component1() {
        return this.reminderId;
    }

    public final String component2() {
        return this.ownerId;
    }

    public final List<Boolean> component3() {
        return this.days;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.time;
    }

    public final String component7() {
        return this.repeating;
    }

    public final boolean component8() {
        return this.isActive;
    }

    public final app.dogo.android.persistencedb.room.entity.ReminderEntity copy(String string, String string2, List<Boolean> list3, String string4, String string5, String string6, String string7, boolean z8) {
        n.f(string, "reminderId");
        n.f(string2, "ownerId");
        n.f(list3, "days");
        n.f(string4, "name");
        n.f(string5, "type");
        final Object obj = string6;
        n.f(obj, "time");
        final Object obj2 = string7;
        n.f(obj2, "repeating");
        super(string, string2, list3, string4, string5, obj, obj2, z8);
        return reminderEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ReminderEntity) {
            return i2;
        }
        if (!n.b(this.reminderId, object.reminderId)) {
            return i2;
        }
        if (!n.b(this.ownerId, object.ownerId)) {
            return i2;
        }
        if (!n.b(this.days, object.days)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (!n.b(this.time, object.time)) {
            return i2;
        }
        if (!n.b(this.repeating, object.repeating)) {
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

    public int hashCode() {
        boolean isActive;
        if (this.isActive) {
            isActive = 1;
        }
        return i14 += isActive;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReminderEntity(reminderId=");
        stringBuilder.append(this.reminderId);
        stringBuilder.append(", ownerId=");
        stringBuilder.append(this.ownerId);
        stringBuilder.append(", days=");
        stringBuilder.append(this.days);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", repeating=");
        stringBuilder.append(this.repeating);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.isActive);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
