package app.dogo.com.dogo_android.d.e;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.util.e0.s;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeReportViewModel.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "challengeReportInfo", "Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;)V", "codeInput", "Landroidx/lifecycle/MutableLiveData;", "", "getCodeInput", "()Landroidx/lifecycle/MutableLiveData;", "saveReport", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ChallengeReportViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeReportInfo authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final m2 challengeReportInfo;
    private final h2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final x<String> firestoreService = new x<>("");

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ChallengeReportInfo_ReportType.values().length];
            iArr[ChallengeReportInfo_ReportType.ENTRY.ordinal()] = 1;
            iArr[ChallengeReportInfo_ReportType.COMMENT.ordinal()] = 2;
            app.dogo.com.dogo_android.challenge.report.e.a.a = iArr;
        }
    }
    public e(ChallengeReportInfo challengeReportInfo, m2 m2Var, h2 h2Var) {
        n.f(challengeReportInfo, "challengeReportInfo");
        n.f(m2Var, "firestoreService");
        n.f(h2Var, "authService");
        super();
        this.authService = challengeReportInfo;
        this.challengeReportInfo = m2Var;
        this.c = h2Var;
        final x xVar = new x("");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> getCodeInput() {
        return this.firestoreService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final void saveReport() {
        int i = app.dogo.com.dogo_android.challenge.report.e.a.a[this.authService.getReportType().ordinal()];
        if (this.authService == 1) {
            this.challengeReportInfo.startListeningToFollowedNotificationBranch(this.authService.getEntryId(), this.c.v(), (String)this.firestoreService.getValue());
        } else {
            if (this.authService == 2) {
                this.challengeReportInfo.updateDocument(this.authService.getCommentId(), this.c.v(), this.authService.getEntryId(), (String)this.firestoreService.getValue());
            }
        }
    }
}
