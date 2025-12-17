package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "", "taskId", "", "text", "locale", "updatedAt", "", "locale_taskId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getLocale_taskId", "getTaskId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TaskEntity {

    private final String locale;
    private final String locale_taskId;
    private final String taskId;
    private final String text;
    private final long updatedAt;
    public TaskEntity(String string, String string2, String string3, long l4, String string5) {
        n.f(string, "taskId");
        n.f(string2, "text");
        n.f(string3, "locale");
        n.f(obj7, "locale_taskId");
        super();
        this.taskId = string;
        this.text = string2;
        this.locale = string3;
        this.updatedAt = l4;
        this.locale_taskId = obj7;
    }

    public TaskEntity(String string, String string2, String string3, long l4, String string5, int i6, g g7) {
        String obj13;
        int obj14;
        if (g7 &= 16 != 0) {
            obj13 = new StringBuilder();
            obj13.append(string3);
            obj13.append('_');
            obj13.append(string);
            obj13 = obj13.toString();
        }
        super(string, string2, string3, l4, obj5, obj13);
    }

    public static app.dogo.android.persistencedb.room.entity.TaskEntity copy$default(app.dogo.android.persistencedb.room.entity.TaskEntity taskEntity, String string2, String string3, String string4, long l5, String string6, int i7, Object object8) {
        String obj5;
        String obj6;
        String obj7;
        long obj8;
        String obj10;
        if (object8 & 1 != 0) {
            obj5 = taskEntity.taskId;
        }
        if (object8 & 2 != 0) {
            obj6 = taskEntity.text;
        }
        if (object8 & 4 != 0) {
            obj7 = taskEntity.locale;
        }
        if (object8 & 8 != 0) {
            obj8 = taskEntity.updatedAt;
        }
        if (object8 & 16 != 0) {
            obj10 = taskEntity.locale_taskId;
        }
        return taskEntity.copy(obj5, obj6, obj7, obj8, object8);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.locale;
    }

    public final long component4() {
        return this.updatedAt;
    }

    public final String component5() {
        return this.locale_taskId;
    }

    public final app.dogo.android.persistencedb.room.entity.TaskEntity copy(String string, String string2, String string3, long l4, String string5) {
        n.f(string, "taskId");
        n.f(string2, "text");
        n.f(string3, "locale");
        n.f(obj14, "locale_taskId");
        super(string, string2, string3, l4, obj6, obj14);
        return taskEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TaskEntity) {
            return i2;
        }
        if (!n.b(this.taskId, object.taskId)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_taskId, object.locale_taskId)) {
            return i2;
        }
        return i;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_taskId() {
        return this.locale_taskId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TaskEntity(taskId=");
        stringBuilder.append(this.taskId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_taskId=");
        stringBuilder.append(this.locale_taskId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
