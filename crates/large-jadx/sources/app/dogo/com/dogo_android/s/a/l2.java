package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "getDashboardProgramCardType", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "isSurveyAnswered", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l2 {

    private final r2 a;
    public l2(r2 r2) {
        n.f(r2, "remoteConfigService");
        super();
        this.a = r2;
    }

    public final DashboardProgram.CardType a(ProgramProgress programProgress, boolean z2) {
        int i2;
        int i3;
        boolean started4;
        boolean started3;
        int i4;
        boolean started;
        int passed;
        int i5;
        boolean started2;
        int i;
        boolean obj7;
        int obj8;
        i2 = 1;
        final int i6 = 0;
        if (z2 == 0) {
            if (!programProgress) {
                started4 = i6;
            } else {
            }
            i3 = started4 == 0 ? i2 : i6;
        } else {
        }
        if (z2 != 0) {
            if (!programProgress) {
                started3 = i6;
            } else {
            }
            if (started3 == 0 && !this.a.Z()) {
                i4 = !this.a.Z() ? i2 : i6;
            } else {
            }
        } else {
        }
        if (z2 != 0) {
            if (!programProgress) {
                obj8 = i6;
            } else {
            }
            if (obj8 == null && this.a.Z()) {
                obj8 = this.a.Z() ? i2 : i6;
            } else {
            }
        } else {
        }
        if (!programProgress) {
            passed = i6;
        } else {
        }
        if (passed != 0 && programProgress.isPassed()) {
            i5 = programProgress.isPassed() ? i2 : i6;
        } else {
        }
        if (!programProgress) {
            i = i6;
        } else {
        }
        if (i != 0 && !programProgress.isPassed()) {
            if (!programProgress.isPassed()) {
            } else {
                i2 = i6;
            }
        } else {
        }
        obj7 = i3 != 0 ? DashboardProgram.CardType.QUESTIONNAIRE : i4 != 0 ? DashboardProgram.CardType.RECOMMENDED_PROGRAM : obj8 != null ? DashboardProgram.CardType.RECOMMENDED_PROGRAM_V2 : i5 != 0 ? DashboardProgram.CardType.PROGRAM_COMPLETED : i2 != 0 ? DashboardProgram.CardType.LESSON : DashboardProgram.CardType.QUESTIONNAIRE;
        return obj7;
    }
}
