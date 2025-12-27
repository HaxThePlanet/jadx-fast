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

/* compiled from: AllDogoPrograms.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B+\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/AllDogoPrograms;", "", "classic", "", "", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "biting", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "potty", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "(Ljava/util/Map;Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;)V", "getBiting", "()Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getClassic", "()Ljava/util/Map;", "getPotty", "()Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "component1", "component2", "component3", "copy", "equals", "", "other", "getActiveClassicProgram", "getActiveClassicProgramId", "getStartedClassicProgramIds", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final /* data */ class AllDogoPrograms {

    private final Map<String, k.b> a;
    private final k.a b;
    private final k.c c;
    public i(Map<String, k.b> map, k.a aVar, k.c cVar) {
        n.f(map, "classic");
        n.f(aVar, "biting");
        n.f(cVar, "potty");
        super();
        this.a = map;
        this.b = aVar;
        this.c = cVar;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final k.b component1() {
        int i = 0;
        Object item;
        boolean hasNext2;
        ProgramProgress programProgress2;
        int i3 = 0;
        long startTimeMs;
        int cmp;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            programProgress2 = (DogoProgram_ClassicProgram)item2.c();
            i3 = 0;
            i3 = 1;
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            i = 0;
        } else {
            if (it2.hasNext()) {
                ProgramProgress programProgress = (DogoProgram_ClassicProgram)item.c();
                int i2 = 0;
                if (programProgress == null) {
                } else {
                    startTimeMs = programProgress.getStartTimeMs();
                }
                item = it2.next();
                ProgramProgress programProgress3 = (DogoProgram_ClassicProgram)item.c();
                do {
                    item = it2.next();
                    programProgress3 = (DogoProgram_ClassicProgram)item.c();
                    startTimeMs = programProgress3.getStartTimeMs();
                } while (programProgress3 == null);
            }
        }
        return (DogoProgram_ClassicProgram)i;
    }

    public final String b() {
        int i = 0;
        app.dogo.com.dogo_android.y.k.b component1 = component1();
        i = 0;
        if (component1 != null) {
            ProgramModel programModel = component1.a();
            if (programModel != null) {
                String id = programModel.getId();
            }
        }
        return i;
    }

    public final k.a c() {
        return this.b;
    }

    public final Map<String, k.b> d() {
        return this.a;
    }

    public final k.c e() {
        return this.c;
    }

    public final List<String> f() {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ProgramProgress programProgress = (DogoProgram_ClassicProgram)it.next().c();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Object item = it3.next();
        }
        ArrayList arrayList3 = new ArrayList(p.r(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((ProgramProgress)it2.next().getId());
        }
        return arrayList3;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof AllDogoPrograms)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        return !n.b(this.c, other.c) ? z5 : z;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "AllDogoPrograms(classic=";
        String str3 = ", biting=";
        String str4 = ", potty=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + 41;
        return str;
    }
}
