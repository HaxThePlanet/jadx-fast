package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.LessonEntity;
import app.dogo.android.persistencedb.room.entity.TaskEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LessonFullEntity.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011¨\u0006\u001f", d2 = {"Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "", "lesson", "Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "tasks", "", "Lapp/dogo/android/persistencedb/room/entity/TaskEntity;", "question", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "trick", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "(Lapp/dogo/android/persistencedb/room/entity/LessonEntity;Ljava/util/List;Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;Ljava/util/List;)V", "getLesson", "()Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "getQuestion", "()Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "getTasks", "()Ljava/util/List;", "getTrick", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final /* data */ class LessonFullEntity {

    /* renamed from: a, reason: from kotlin metadata */
    private final LessonEntity lesson;
    private final List<TaskEntity> b;
    private final f c;
    /* renamed from: d, reason: from kotlin metadata */
    private final List<g> trick;
    public b(LessonEntity lessonEntity, List<TaskEntity> list, f fVar, List<g> list2) {
        n.f(lessonEntity, "lesson");
        n.f(list, "tasks");
        n.f(fVar, "question");
        n.f(list2, "trick");
        super();
        this.lesson = lessonEntity;
        this.b = list;
        this.c = fVar;
        this.trick = list2;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final LessonEntity component1() {
        return this.lesson;
    }

    public final f b() {
        return this.c;
    }

    public final List<TaskEntity> c() {
        return this.b;
    }

    public final List<g> d() {
        return this.trick;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof LessonFullEntity)) {
            return false;
        }
        if (!n.b(this.lesson, other.lesson)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(this.c, other.c)) {
            return false;
        }
        return !n.b(this.trick, other.trick) ? z6 : z;
    }

    public int hashCode() {
        return (this.lesson.hashCode() * 31) + this.b.hashCode() * 31 + this.c.hashCode() * 31 + this.trick.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonFullEntity(lesson=";
        String str3 = ", tasks=";
        String str4 = ", question=";
        String str5 = ", trick=";
        str = str2 + this.lesson + str3 + this.b + str4 + this.c + str5 + this.trick + 41;
        return str;
    }
}
