package app.dogo.com.dogo_android.y;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B+\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AllDogoPrograms;", "", "classic", "", "", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "biting", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "potty", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "(Ljava/util/Map;Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;)V", "getBiting", "()Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getClassic", "()Ljava/util/Map;", "getPotty", "()Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "component1", "component2", "component3", "copy", "equals", "", "other", "getActiveClassicProgram", "getActiveClassicProgramId", "getStartedClassicProgramIds", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i {

    private final Map<String, app.dogo.com.dogo_android.y.k.b> a;
    private final app.dogo.com.dogo_android.y.k.a b;
    private final app.dogo.com.dogo_android.y.k.c c;
    public i(Map<String, app.dogo.com.dogo_android.y.k.b> map, app.dogo.com.dogo_android.y.k.a k$a2, app.dogo.com.dogo_android.y.k.c k$c3) {
        n.f(map, "classic");
        n.f(a2, "biting");
        n.f(c3, "potty");
        super();
        this.a = map;
        this.b = a2;
        this.c = c3;
    }

    public final app.dogo.com.dogo_android.y.k.b a() {
        int i2;
        boolean next2;
        Object next3;
        boolean next;
        ProgramProgress started;
        int i;
        int startTimeMs;
        long startTimeMs2;
        int cmp;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            started = (k.b)next3.c();
            i = 0;
            startTimeMs = 1;
            if (started == null) {
            } else {
            }
            if (started.isStarted() == startTimeMs) {
            }
            if (i != 0) {
            }
            arrayList.add(next3);
            i = startTimeMs;
        }
        Iterator iterator2 = arrayList.iterator();
        if (!iterator2.hasNext()) {
            i2 = 0;
        } else {
            if (iterator2.hasNext()) {
                next = (k.b)iterator2.next().c();
                started = 0;
                if (next == null) {
                    startTimeMs = started;
                } else {
                    startTimeMs = next.getStartTimeMs();
                }
                Object next4 = iterator2.next();
                ProgramProgress programProgress = (k.b)next4.c();
                do {
                    next4 = iterator2.next();
                    programProgress = (k.b)next4.c();
                    startTimeMs2 = programProgress.getStartTimeMs();
                    if (Long.compare(startTimeMs, startTimeMs2) < 0) {
                    }
                    if (iterator2.hasNext()) {
                    }
                    next2 = next4;
                    startTimeMs = startTimeMs2;
                    startTimeMs2 = started;
                } while (programProgress == null);
            }
            i2 = next2;
        }
        return (k.b)i2;
    }

    public final String b() {
        Object bVar;
        int i;
        bVar = a();
        i = 0;
        if (bVar == null) {
        } else {
            bVar = bVar.a();
            if (bVar == null) {
            } else {
                i = bVar.getId();
            }
        }
        return i;
    }

    public final app.dogo.com.dogo_android.y.k.a c() {
        return this.b;
    }

    public final Map<String, app.dogo.com.dogo_android.y.k.b> d() {
        return this.a;
    }

    public final app.dogo.com.dogo_android.y.k.c e() {
        return this.c;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof i) {
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

    public final List<String> f() {
        ProgramProgress programProgress;
        boolean next;
        int i;
        boolean started;
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            programProgress = (k.b)iterator.next().c();
            if (programProgress != null) {
            }
            arrayList2.add(programProgress);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator3 = arrayList2.iterator();
        while (iterator3.hasNext()) {
            next = iterator3.next();
            if ((ProgramProgress)next.isStarted()) {
            }
            arrayList.add(next);
        }
        ArrayList arrayList3 = new ArrayList(p.r(arrayList, 10));
        Iterator iterator2 = arrayList.iterator();
        for (ProgramProgress next5 : iterator2) {
            arrayList3.add(next5.getId());
        }
        return arrayList3;
    }

    public int hashCode() {
        return i4 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AllDogoPrograms(classic=");
        stringBuilder.append(this.a);
        stringBuilder.append(", biting=");
        stringBuilder.append(this.b);
        stringBuilder.append(", potty=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
