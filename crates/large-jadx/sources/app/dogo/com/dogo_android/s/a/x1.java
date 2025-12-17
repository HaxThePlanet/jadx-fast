package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;", "", "()V", "addCertificateHeaders", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "programExamList", "addProgressAndCertificateHeadersIfNeeded", "certificateEnabled", "", "buildExamHeader", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "sortedExamListWithHeaders", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x1 {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(j1.G((ProgramExam)t2)), Integer.valueOf(j1.G((ProgramExam)t)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {

        final Comparator a;
        public b(Comparator comparator) {
            this.a = comparator;
            super();
        }

        public final int compare(T t, T t2) {
            int compare;
            Object obj3;
            Object obj4;
            if (this.a.compare(t, t2) != 0) {
            } else {
                compare = a.c(Long.valueOf((ProgramExam)t.getOrderDate()), Long.valueOf((ProgramExam)t2.getOrderDate()));
            }
            return compare;
        }
    }
    private final ProgramExamList a(ProgramExamSummary programExamSummary, ProgramExamList programExamList2) {
        ProgramExam obj8;
        ArrayList arrayList = new ArrayList();
        if (programExamSummary.allExamsCompleted()) {
            arrayList.add(c(ProgramExam.Status.CERTIFICATE_HEADER));
        } else {
            arrayList.add(c(ProgramExam.Status.PROGRESS_HEADER));
        }
        arrayList.addAll(programExamList2.getExamList());
        return ProgramExamList.copy$default(programExamList2, arrayList, 0, 0, false, 14, 0);
    }

    private final ProgramExam c(ProgramExam.Status programExam$Status) {
        String str = "";
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(str, str, str, str);
        super(programSaveInfo, "", "", "", "", status, "", 0, obj9, "", "", 0, 0, obj14, Boolean.FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4188160, 0);
        return programExam2;
    }

    public final ProgramExamList b(ProgramExamList programExamList, boolean z2) {
        Object obj2;
        n.f(programExamList, "programExamList");
        ProgramExamSummary programExamSummary = programExamList.getProgramExamSummary();
        if (z2 && programExamSummary != null) {
            if (programExamSummary != null) {
                obj2 = a(programExamSummary, programExamList);
            }
        }
        return obj2;
    }

    public final ProgramExamList d(ProgramExamList programExamList) {
        int i2;
        Object examList2;
        boolean empty;
        List examList;
        int i;
        ProgramExam.Status lOCKED;
        boolean empty2;
        ProgramExam.Status lOCKED2;
        n.f(programExamList, "programExamList");
        List list = p.N0(programExamList.getExamList());
        examList2 = programExamList.getExamList();
        i = 0;
        int i4 = 1;
        if (examList2 instanceof Collection != null && examList2.isEmpty()) {
            if (examList2.isEmpty()) {
                i2 = i;
            } else {
                examList2 = examList2.iterator();
                while (examList2.hasNext()) {
                    if ((ProgramExam)examList2.next().getStatus() == ProgramExam.Status.LOCKED) {
                    } else {
                    }
                    empty = i;
                    empty = i4;
                }
            }
        } else {
        }
        examList = programExamList.getExamList();
        if (examList instanceof Collection != null && examList.isEmpty()) {
            if (examList.isEmpty()) {
                i = i4;
            } else {
                examList = examList.iterator();
                while (examList.hasNext()) {
                    if ((ProgramExam)examList.next().getStatus() == ProgramExam.Status.LOCKED) {
                    } else {
                    }
                    empty2 = i;
                    if (empty2) {
                        break;
                    }
                    empty2 = i4;
                }
            }
        } else {
        }
        if (i2 != 0) {
            list.add(c(ProgramExam.Status.UNAVAILABLE_HEADER));
        }
        if (i ^ 1 != 0) {
            list.add(c(ProgramExam.Status.AVAILABLE_HEADER));
        }
        x1.a aVar = new x1.a();
        x1.b bVar = new x1.b(aVar);
        return ProgramExamList.copy$default(programExamList, p.D0(list, bVar), 0, 0, false, 14, 0);
    }
}
