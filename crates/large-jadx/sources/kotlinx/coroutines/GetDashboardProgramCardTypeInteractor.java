package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GetDashboardProgramCardTypeInteractor.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardProgramCardTypeInteractor;", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "getDashboardProgramCardType", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram$CardType;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "isSurveyAnswered", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l2, reason: from kotlin metadata */
public final class GetDashboardProgramCardTypeInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    public l2(r2 r2Var) {
        n.f(r2Var, "remoteConfigService");
        super();
        this.remoteConfigService = r2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final DashboardProgram.CardType getDashboardProgramCardType(ProgramProgress progressModel, boolean isSurveyAnswered) {
        int i = 1;
        DashboardProgram.CardType qUESTIONNAIRE2;
        boolean passed;
        i = 1;
        i = 0;
        if (!isSurveyAnswered) {
            int r2 = i;
            r2 = i;
        }
        if (isSurveyAnswered) {
            int r3 = i;
            if (i == 0) {
                r3 = i;
            }
        }
        if (isSurveyAnswered) {
            isSurveyAnswered = i;
            if (i == 0) {
                isSurveyAnswered = i;
            }
        }
        int r4 = i;
        r4 = i;
        int r5 = i;
        if (i == 0 || progressModel.isPassed()) {
        }
        if (i != 0) {
            qUESTIONNAIRE2 = DashboardProgram_CardType.QUESTIONNAIRE;
        } else {
            if (this.remoteConfigService != null) {
                qUESTIONNAIRE2 = DashboardProgram_CardType.RECOMMENDED_PROGRAM;
            } else {
                if (this.remoteConfigService != null) {
                    qUESTIONNAIRE2 = DashboardProgram_CardType.RECOMMENDED_PROGRAM_V2;
                } else {
                    if (i != 0) {
                        qUESTIONNAIRE2 = DashboardProgram_CardType.PROGRAM_COMPLETED;
                    } else {
                        progressModel = i != 0 ? DashboardProgram_CardType.LESSON : DashboardProgram_CardType.QUESTIONNAIRE;
                    }
                }
            }
        }
        return (i != 0 ? DashboardProgram_CardType.LESSON : DashboardProgram_CardType.QUESTIONNAIRE);
    }
}
