package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.a;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: BitingProgramCardInteractor.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramCardInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getBitingProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y1, reason: from kotlin metadata */
public final class BitingProgramCardInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 programRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 userRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramCardInteractor", f = "BitingProgramCardInteractor.kt", l = {17, 18}, m = "getBitingProgramCard")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super y1.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return y1.this.a(this);
        }
    }
    public y1(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var) {
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        super();
        this.programRepository = p1Var;
        this.userRepository = j1Var;
    }

    public final Object a(kotlin.b0.d<? super Dashboard.BitingProgramCard> dVar) {
        Object result2;
        String str2;
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.a.y1 y1Var;
        int i2;
        BitingProgramProgress bitingProgramProgressItem = null;
        long l3 = 0;
        y1Var = this;
        dVar2 = dVar;
        z = dVar2 instanceof kotlinx.coroutines.y1.a;
        if (dVar2 instanceof kotlinx.coroutines.y1.a) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.y1.a aVar = new kotlinx.coroutines.y1.a(y1Var, dVar2);
            }
        }
        Object obj2 = b.d();
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar2.result);
                    app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = result2.c();
                    if (bitingProgressModel != null) {
                        bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
                    }
                    if (bitingProgramProgressItem == null) {
                        long l = 0L;
                        String str = null;
                        java.util.List list = null;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        int i5 = 0;
                        int i6 = 0;
                        boolean z5 = false;
                        int i7 = 0;
                        kotlin.d0.d.g gVar = null;
                        int i8 = 8191;
                        int i9 = 0;
                        bitingProgramProgressItem = new BitingProgramProgress(null, l, l2, str, str5, list, null, z2, z3, z4, i5, i6, z5, i7, gVar, i8, i9);
                    }
                    return new Dashboard_BitingProgramCard(bitingProgramProgressItem.isEnrolled(), bitingProgramProgressItem.getProgramIsCompleted(), app.dogo.com.dogo_android.util.extensionfunction.j1.c(result2.a(), ProgramDescriptionItem_State.NOT_STARTED, false, false, 0L, false, 0, null, 124, null), new SpecialProgramOverviewItem_ProgramProgressData(bitingProgramProgressItem.getArticleCompletionPercentage(), bitingProgramProgressItem.getArticlesAreCompleted(), bitingProgramProgressItem.getTrickCompletionPercentage(), bitingProgramProgressItem.getTricksAreCompleted()));
                }
            }
            q.b(dVar2.result);
        } else {
            q.b(dVar2.result);
            dVar2.L$0 = y1Var;
            dVar2.label = i4;
            if (y1Var.programRepository.u(dVar2) == obj2) {
                return obj2;
            }
        }
        dVar2.L$0 = null;
        dVar2.label = i3;
        if (y1Var.userRepository.q((String)str2, dVar2) == obj2) {
            return obj2;
        }
    }
}
