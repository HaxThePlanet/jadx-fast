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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "challengeReportInfo", "Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;)V", "codeInput", "Landroidx/lifecycle/MutableLiveData;", "", "getCodeInput", "()Landroidx/lifecycle/MutableLiveData;", "saveReport", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final ChallengeReportInfo a;
    private final m2 b;
    private final h2 c;
    private final x<String> d;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ChallengeReportInfo.ReportType.ENTRY.ordinal()] = 1;
            iArr[ChallengeReportInfo.ReportType.COMMENT.ordinal()] = 2;
            e.a.a = iArr;
        }
    }
    public e(ChallengeReportInfo challengeReportInfo, m2 m22, h2 h23) {
        n.f(challengeReportInfo, "challengeReportInfo");
        n.f(m22, "firestoreService");
        n.f(h23, "authService");
        super();
        this.a = challengeReportInfo;
        this.b = m22;
        this.c = h23;
        x obj2 = new x("");
        this.d = obj2;
    }

    public final x<String> getCodeInput() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        m2 i;
        String commentId;
        String str;
        Object entryId;
        Object value;
        i = e.a.a[this.a.getReportType().ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                this.b.q0(this.a.getCommentId(), this.c.v(), this.a.getEntryId(), (String)this.d.getValue());
            }
        } else {
            this.b.o0(this.a.getEntryId(), this.c.v(), (String)this.d.getValue());
        }
    }
}
