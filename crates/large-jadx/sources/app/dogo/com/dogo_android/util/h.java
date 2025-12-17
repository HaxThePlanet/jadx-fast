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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/util/ClassicProgramCache;", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "()V", "getCacheLifetimeMs", "", "getData", "ownerId", "", "currentTimeMs", "isDataValid", "", "peekData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends app.dogo.com.dogo_android.util.z<ProgramProgress> {
    public h() {
        super(-1, obj1);
    }

    private final long g() {
        Object arrayList;
        int i2;
        int i3;
        boolean iterator2;
        int i4;
        boolean iterator;
        Iterator iterator3;
        int i;
        boolean values;
        Object exams;
        boolean examSubmission;
        boolean next;
        ArrayList arrayList2;
        String examStatus2;
        boolean z;
        String examStatus;
        arrayList = b();
        i4 = 0;
        if ((ProgramProgress)arrayList == null) {
        } else {
            arrayList = (ProgramProgress)arrayList.getModules();
            if (arrayList == null) {
            } else {
                ArrayList arrayList3 = new ArrayList();
                Iterator iterator4 = arrayList.iterator();
                while (iterator4.hasNext()) {
                    exams = iterator4.next();
                    if ((ProgramProgress.ModuleProgress)exams == null) {
                    } else {
                    }
                    exams = (ProgramProgress.ModuleProgress)exams.getExams();
                    if (exams == null) {
                    } else {
                    }
                    values = exams.values();
                    if (values == null) {
                    }
                    p.y(arrayList3, values);
                    values = p.g();
                    values = i4;
                }
                arrayList = new ArrayList();
                iterator3 = arrayList3.iterator();
                while (iterator3.hasNext()) {
                    Object next2 = iterator3.next();
                    if ((ProgramProgress.ModuleExam)next2 == null) {
                    } else {
                    }
                    examSubmission = (ProgramProgress.ModuleExam)next2.getExamSubmission();
                    if (examSubmission) {
                    }
                    arrayList.add(examSubmission);
                    examSubmission = i4;
                }
                i4 = arrayList;
            }
        }
        if (i4 == 0) {
            i4 = p.g();
        }
        int i5 = 0;
        if (i4 instanceof Collection != null && i4.isEmpty()) {
            if (i4.isEmpty()) {
                i2 = i5;
            } else {
                iterator2 = i4.iterator();
                for (ProgramProgress.ExamSubmission next4 : iterator2) {
                }
            }
        } else {
        }
        arrayList2 = new ArrayList();
        Iterator iterator5 = i4.iterator();
        while (iterator5.hasNext()) {
            examStatus2 = iterator5.next();
            if (n.b((ProgramProgress.ExamSubmission)examStatus2.getStatus(), ProgramProgress.ProgramExamStatus.PENDING.getExamStatus())) {
            }
            arrayList2.add(examStatus2);
        }
        if (arrayList2.isEmpty()) {
            i = i5;
        } else {
            iterator = arrayList2.iterator();
            while (iterator.hasNext() != null) {
                if (l.z((ProgramProgress.ExamSubmission)iterator.next().getVideoThumbnailUrl()) == null) {
                    break;
                }
            }
        }
        if (i != 0) {
            i3 = 0;
        } else {
            if (i2 != 0) {
                i3 = j1.Companion.c();
            } else {
                i3 = -1;
            }
        }
        return i3;
    }

    @Override // app.dogo.com.dogo_android.util.z
    public Object a(String string, long l2) {
        return h(string, l2);
    }

    @Override // app.dogo.com.dogo_android.util.z
    public ProgramProgress h(String string, long l2) {
        Object obj8;
        n.f(string, "ownerId");
        if (this.d(string, l2, obj4)) {
            obj8 = b();
        } else {
            obj8 = 0;
        }
        return obj8;
    }

    @Override // app.dogo.com.dogo_android.util.z
    public final boolean i(String string, long l2) {
        n.f(string, "ownerId");
        return this.d(string, l2, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.z
    public final ProgramProgress j(String string) {
        Object obj2;
        n.f(string, "ownerId");
        if (n.b(c(), string)) {
            obj2 = b();
        } else {
            obj2 = 0;
        }
        return obj2;
    }
}
