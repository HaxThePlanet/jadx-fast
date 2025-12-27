package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.j1.a;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* compiled from: ClassicProgramCache.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/util/ClassicProgramCache;", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "()V", "getCacheLifetimeMs", "", "getData", "ownerId", "", "currentTimeMs", "isDataValid", "", "peekData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ClassicProgramCache extends z<ProgramProgress> {
    public h() {
        super(-1L, obj);
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final long getCacheLifetimeMs() {
        int i;
        int i2 = -1;
        int i3 = 0;
        boolean empty2;
        Collection values;
        ProgramProgress.ExamSubmission examSubmission;
        ArrayList arrayList2;
        boolean hasNext3;
        String examStatus;
        Object obj = b();
        i3 = 0;
        if (obj != null) {
            java.util.List modules = obj.getModules();
            if (modules != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it4 = modules.iterator();
                while (it4.hasNext()) {
                    Object item = it4.next();
                    int r3 = i3;
                    p.y(arrayList3, values);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                }
            }
        }
        if (i3 == 0) {
            java.util.List list = p.g();
        }
        empty = i3 instanceof Collection;
        i = 1;
        i = 0;
        int r0 = i;
        arrayList2 = new ArrayList();
        Iterator it5 = i3.iterator();
        while (it5.hasNext()) {
            examStatus = it5.next();
        }
        int r2 = i;
        if (i != 0) {
            i2 = 0;
        } else {
            if (i != 0) {
                long l = ProgramRepository.Companion.c();
            } else {
                i2 = -1;
            }
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.z
    /* renamed from: h, reason: from kotlin metadata */
    public ProgramProgress isDataValid(String ownerId, long currentTimeMs) {
        Object obj = null;
        n.f(ownerId, "ownerId");
        obj = this.d(ownerId, currentTimeMs, getCacheLifetimeMs()) ? (ProgramProgress)obj : 0;
        return obj;
    }

    @Override // app.dogo.com.dogo_android.util.z
    public final boolean i(String str, long j) {
        n.f(str, "ownerId");
        return this.d(str, j, getCacheLifetimeMs());
    }

    @Override // app.dogo.com.dogo_android.util.z
    /* renamed from: j, reason: from kotlin metadata */
    public final ProgramProgress peekData(String ownerId) {
        Object obj = null;
        n.f(ownerId, "ownerId");
        obj = n.b(c(), ownerId) ? (ProgramProgress)obj : 0;
        return obj;
    }
}
