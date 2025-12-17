package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011¨\u0006\u001f", d2 = {"Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "", "lesson", "Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "tasks", "", "Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "question", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "trick", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "(Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Ljava/util/List;Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;Ljava/util/List;)V", "getLesson", "()Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "getQuestion", "()Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "getTasks", "()Ljava/util/List;", "getTrick", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b {

    private final LessonEntity a;
    private final List<TaskEntity> b;
    private final e.a.a.a.b.d.f c;
    private final List<e.a.a.a.b.d.g> d;
    public b(LessonEntity lessonEntity, List<TaskEntity> list2, e.a.a.a.b.d.f f3, List<e.a.a.a.b.d.g> list4) {
        n.f(lessonEntity, "lesson");
        n.f(list2, "tasks");
        n.f(f3, "question");
        n.f(list4, "trick");
        super();
        this.a = lessonEntity;
        this.b = list2;
        this.c = f3;
        this.d = list4;
    }

    public final LessonEntity a() {
        return this.a;
    }

    public final e.a.a.a.b.d.f b() {
        return this.c;
    }

    public final List<TaskEntity> c() {
        return this.b;
    }

    public final List<e.a.a.a.b.d.g> d() {
        return this.d;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonFullEntity(lesson=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tasks=");
        stringBuilder.append(this.b);
        stringBuilder.append(", question=");
        stringBuilder.append(this.c);
        stringBuilder.append(", trick=");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
