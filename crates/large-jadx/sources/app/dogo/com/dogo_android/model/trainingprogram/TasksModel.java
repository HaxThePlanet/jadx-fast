package app.dogo.com.dogo_android.model.trainingprogram;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TasksModel.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TasksModel;", "", "id", "", "text", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TasksModel {

    private final String id;
    private final String locale;
    private final String text;
    private final long updatedAt;
    public TasksModel(String str, String str2, long j, String str3) {
        n.f(str, "id");
        n.f(str2, "text");
        n.f(str3, "locale");
        super();
        this.id = str;
        this.text = str2;
        this.updatedAt = j;
        this.locale = str3;
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

    public /* synthetic */ TasksModel(String str, String str2, long j, String str3, int i, g gVar) {
        String str22;
        int j32 = 0;
        str22 = "";
        gVar = i & 1 != 0 ? str22 : str;
        String r1 = i & 2 != 0 ? str22 : str2;
        j32 = i & 4 != 0 ? 0 : j32;
        i = i & 8 != 0 ? str22 : str3;
        this(str22, str22, j32, str3, (i & 8 != 0 ? str22 : str3));
    }

    public TasksModel() {
        this(null, null, 0L, str, 0, 15, 0);
    }

    public static /* synthetic */ TasksModel copy$default(TasksModel tasksModel, String str, String str2, long j, String str3, int i, Object object) {
        String str22;
        String str32;
        long j42;
        String i62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return tasksModel.copy(str22, str32, j42, i62);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.text;
    }

    /* operator */ public final long component3() {
        return this.updatedAt;
    }

    /* operator */ public final String component4() {
        return this.locale;
    }

    public final TasksModel copy(String id, String text, long updatedAt, String locale) {
        n.f(id, "id");
        n.f(text, "text");
        n.f(locale, "locale");
        TasksModel tasksModel = new TasksModel(id, text, updatedAt, str4, locale);
        return tasksModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof TasksModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale, other.locale) ? z5 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.text.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TasksModel(id=";
        String str3 = ", text=";
        String str4 = ", updatedAt=";
        String str5 = ", locale=";
        str = str2 + this.id + str3 + this.text + str4 + this.updatedAt + str5 + this.locale + 41;
        return str;
    }
}
