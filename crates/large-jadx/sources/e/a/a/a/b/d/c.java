package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.ModuleEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "", "module", "Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;", "lessons", "", "Lapp/dogo/android/persistencedb/room/relations/LessonFullEntity;", "exams", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;Ljava/util/List;Ljava/util/List;)V", "getExams", "()Ljava/util/List;", "getLessons", "getModule", "()Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    private final ModuleEntity a;
    private final List<e.a.a.a.b.d.b> b;
    private final List<e.a.a.a.b.d.g> c;
    public c(ModuleEntity moduleEntity, List<e.a.a.a.b.d.b> list2, List<e.a.a.a.b.d.g> list3) {
        n.f(moduleEntity, "module");
        n.f(list2, "lessons");
        n.f(list3, "exams");
        super();
        this.a = moduleEntity;
        this.b = list2;
        this.c = list3;
    }

    public final List<e.a.a.a.b.d.g> a() {
        return this.c;
    }

    public final List<e.a.a.a.b.d.b> b() {
        return this.b;
    }

    public final ModuleEntity c() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof c) {
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
        return i;
    }

    public int hashCode() {
        return i4 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModuleFullEntity(module=");
        stringBuilder.append(this.a);
        stringBuilder.append(", lessons=");
        stringBuilder.append(this.b);
        stringBuilder.append(", exams=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
