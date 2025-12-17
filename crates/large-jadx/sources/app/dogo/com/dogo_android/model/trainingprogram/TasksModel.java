package app.dogo.com.dogo_android.model.trainingprogram;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TasksModel;", "", "id", "", "text", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TasksModel {

    private final String id;
    private final String locale;
    private final String text;
    private final long updatedAt;
    public TasksModel() {
        super(0, 0, 0, obj4, 0, 15, 0);
    }

    public TasksModel(String string, String string2, long l3, String string4) {
        n.f(string, "id");
        n.f(string2, "text");
        n.f(obj6, "locale");
        super();
        this.id = string;
        this.text = string2;
        this.updatedAt = l3;
        this.locale = obj6;
    }

    public TasksModel(String string, String string2, long l3, String string4, int i5, g g6) {
        String str;
        int obj7;
        String obj10;
        String obj11;
        final String str2 = "";
        obj11 = g6 & 1 != 0 ? str2 : string;
        str = g6 & 2 != 0 ? str2 : string2;
        obj7 = g6 & 4 != 0 ? 0 : obj7;
        obj10 = g6 & 8 != 0 ? str2 : i5;
        super(obj11, str, obj7, i5, obj10);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.TasksModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.TasksModel tasksModel, String string2, String string3, long l4, String string5, int i6, Object object7) {
        String obj4;
        String obj5;
        long obj6;
        String obj8;
        if (object7 & 1 != 0) {
            obj4 = tasksModel.id;
        }
        if (object7 & 2 != 0) {
            obj5 = tasksModel.text;
        }
        if (object7 & 4 != 0) {
            obj6 = tasksModel.updatedAt;
        }
        if (object7 & 8 != 0) {
            obj8 = tasksModel.locale;
        }
        return tasksModel.copy(obj4, obj5, obj6, object7);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final long component3() {
        return this.updatedAt;
    }

    public final String component4() {
        return this.locale;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.TasksModel copy(String string, String string2, long l3, String string4) {
        n.f(string, "id");
        n.f(string2, "text");
        n.f(obj12, "locale");
        super(string, string2, l3, obj5, obj12);
        return tasksModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TasksModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        return i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TasksModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
