package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Lapp/dogo/android/persistencedb/room/relations/ProgramFullEntity;", "", "program", "Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "modules", "", "Lapp/dogo/android/persistencedb/room/relations/ModuleFullEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;Ljava/util/List;)V", "getModules", "()Ljava/util/List;", "getProgram", "()Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e {

    private final ProgramEntity a;
    private final List<e.a.a.a.b.d.c> b;
    public e(ProgramEntity programEntity, List<e.a.a.a.b.d.c> list2) {
        n.f(programEntity, "program");
        n.f(list2, "modules");
        super();
        this.a = programEntity;
        this.b = list2;
    }

    public final List<e.a.a.a.b.d.c> a() {
        return this.b;
    }

    public final ProgramEntity b() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof e) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramFullEntity(program=");
        stringBuilder.append(this.a);
        stringBuilder.append(", modules=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
