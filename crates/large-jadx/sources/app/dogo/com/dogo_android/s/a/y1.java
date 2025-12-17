package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.a;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getBitingProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y1 {

    private final p1 a;
    private final j1 b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramCardInteractor", f = "BitingProgramCardInteractor.kt", l = {17, 18}, m = "getBitingProgramCard")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.y1 this$0;
        a(app.dogo.com.dogo_android.s.a.y1 y1, d<? super app.dogo.com.dogo_android.s.a.y1.a> d2) {
            this.this$0 = y1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(this);
        }
    }
    public y1(p1 p1, j1 j12) {
        n.f(p1, "userRepository");
        n.f(j12, "programRepository");
        super();
        this.a = p1;
        this.b = j12;
    }

    public final Object a(d<? super Dashboard.BitingProgramCard> d) {
        Object result;
        boolean aVar;
        int label;
        int i3;
        j1 label2;
        Object l$0;
        int i12;
        BitingProgramProgress bitingProgramProgressItem;
        int i11;
        int i13;
        int i7;
        int i8;
        int i2;
        int i15;
        int i9;
        int i;
        int i14;
        int i16;
        int i4;
        int i10;
        int i6;
        int i17;
        int i18;
        int i5;
        final app.dogo.com.dogo_android.s.a.y1 y1Var = this;
        Object obj = d;
        aVar = obj;
        label = aVar.label;
        i3 = Integer.MIN_VALUE;
        if (obj instanceof y1.a && label & i3 != 0) {
            aVar = obj;
            label = aVar.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                aVar.label = label -= i3;
            } else {
                aVar = new y1.a(y1Var, obj);
            }
        } else {
        }
        result = aVar.result;
        Object obj2 = b.d();
        label2 = aVar.label;
        i11 = 2;
        i13 = 1;
        if (label2 != 0) {
            if (label2 != i13) {
                if (label2 != i11) {
                } else {
                    q.b(result);
                    app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = (k.a)result.c();
                    if (bitingProgressModel == null) {
                    } else {
                        bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
                    }
                    if (bitingProgramProgressItem == null) {
                        super(0, 0, obj9, 0, obj11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, 0);
                    }
                    SpecialProgramOverviewItem.ProgramProgressData programProgressData = new SpecialProgramOverviewItem.ProgramProgressData(bitingProgramProgressItem.getArticleCompletionPercentage(), bitingProgramProgressItem.getArticlesAreCompleted(), bitingProgramProgressItem.getTrickCompletionPercentage(), bitingProgramProgressItem.getTricksAreCompleted());
                    Dashboard.BitingProgramCard bitingProgramCard = new Dashboard.BitingProgramCard(bitingProgramProgressItem.isEnrolled(), bitingProgramProgressItem.getProgramIsCompleted(), j1.c(result.a(), ProgramDescriptionItem.State.NOT_STARTED, false, false, 0, i15, 0, 0, 0, 124), programProgressData);
                    return bitingProgramCard;
                }
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
            }
            l$0 = aVar.L$0;
            q.b(result);
        } else {
            q.b(result);
            aVar.L$0 = y1Var;
            aVar.label = i13;
            if (y1Var.a.u(aVar) == obj2) {
                return obj2;
            }
            l$0 = y1Var;
        }
        aVar.L$0 = 0;
        aVar.label = i11;
        if (l$0.b.q((String)result, aVar) == obj2) {
            return obj2;
        }
    }
}
