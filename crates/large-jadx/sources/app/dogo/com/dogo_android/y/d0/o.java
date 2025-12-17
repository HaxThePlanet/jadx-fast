package app.dogo.com.dogo_android.y.d0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "list", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "firstTrick", "getFirstTrick", "()Landroidx/lifecycle/MutableLiveData;", "getList", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends s {

    private final TrainingSession a;
    private final x<y<TrickItem>> b;
    private final LiveData<y<TrickItem>> c;
    private final x<TrickItem> d;
    public o(TrainingSession trainingSession, ProgramSaveInfo programSaveInfo2) {
        n.f(trainingSession, "list");
        n.f(programSaveInfo2, "programSaveInfo");
        super();
        this.a = trainingSession;
        x obj3 = new x();
        this.b = obj3;
        this.c = obj3;
        obj3 = new x(p.a0(trainingSession.getTrainingTricksList(), 0));
        this.d = obj3;
    }

    public final LiveData<y<TrickItem>> getResult() {
        return this.c;
    }

    public final x<TrickItem> h() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrainingSession i() {
        return this.a;
    }
}
