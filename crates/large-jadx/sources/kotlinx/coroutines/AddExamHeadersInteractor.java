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

/* compiled from: AddExamHeadersInteractor.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/AddExamHeadersInteractor;", "", "()V", "addCertificateHeaders", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "programExamSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "programExamList", "addProgressAndCertificateHeadersIfNeeded", "certificateEnabled", "", "buildExamHeader", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "sortedExamListWithHeaders", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x1, reason: from kotlin metadata */
public final class AddExamHeadersInteractor {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.flatMapNotNull(t2)), Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.flatMapNotNull(t)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {

        final /* synthetic */ Comparator a;
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare;
            if (this.a.compare(t, t2) == 0) {
                compare = a.c(Long.valueOf(t.getOrderDate()), Long.valueOf(t2.getOrderDate()));
            }
            return compare;
        }

        public b(Comparator comparator) {
            this.a = comparator;
            super();
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramExamList addCertificateHeaders(ProgramExamSummary programExamSummary, ProgramExamList programExamList) {
        final ArrayList arrayList = new ArrayList();
        if (programExamSummary.allExamsCompleted()) {
            arrayList.add(buildExamHeader(ProgramExam_Status.CERTIFICATE_HEADER));
        } else {
            arrayList.add(buildExamHeader(ProgramExam_Status.PROGRESS_HEADER));
        }
        arrayList.addAll(programExamList.getExamList());
        return ProgramExamList.copy$default(programExamList, arrayList, null, null, false, 14, null);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final ProgramExam buildExamHeader(ProgramExam.Status status) {
        String str = "";
        ProgramExam programExam = new ProgramExam(programSaveInfo, "", "", "", "", status, "", 0L, str7, "", "", 0L, null, bool, Boolean.FALSE, null, null, null, null, null, false, null, 0, null, 4188160, 0);
        return programExam;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final ProgramExamList addProgressAndCertificateHeadersIfNeeded(ProgramExamList programExamList, boolean certificateEnabled) {
        ProgramExamList certificateHeaders;
        n.f(programExamList, "programExamList");
        ProgramExamSummary programExamSummary = programExamList.getProgramExamSummary();
        if (certificateEnabled && programExamSummary != null) {
            certificateHeaders = addCertificateHeaders(programExamSummary, programExamList);
        }
        return certificateHeaders;
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final ProgramExamList sortedExamListWithHeaders(ProgramExamList programExamList) {
        int i;
        boolean hasNext;
        List examList;
        ProgramExam.Status lOCKED2;
        boolean hasNext2;
        ProgramExam.Status lOCKED22;
        n.f(programExamList, "programExamList");
        List list = p.N0(programExamList.getExamList());
        List examList3 = programExamList.getExamList();
        hasNext = examList3 instanceof Collection;
        i = 0;
        i = 1;
        int r1 = i;
        examList = programExamList.getExamList();
        hasNext2 = examList instanceof Collection;
        int r3 = i;
        if (i != 0) {
            list.add(buildExamHeader(ProgramExam_Status.UNAVAILABLE_HEADER));
        }
        if (i ^ 1 != 0) {
            list.add(buildExamHeader(ProgramExam_Status.AVAILABLE_HEADER));
        }
        return ProgramExamList.copy$default(programExamList, p.D0(list, new kotlinx.coroutines.x1.b(new kotlinx.coroutines.x1.a())), null, null, false, 14, null);
    }
}
