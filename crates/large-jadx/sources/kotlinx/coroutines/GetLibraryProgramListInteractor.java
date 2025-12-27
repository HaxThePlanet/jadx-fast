package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: GetLibraryProgramListInteractor.kt */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;", "", "getProgramListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;)V", "getSectionDataForLibraryList", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p2, reason: from kotlin metadata */
public final class GetLibraryProgramListInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final w2 getProgramListInteractor;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryProgramListInteractor", f = "GetLibraryProgramListInteractor.kt", l = 9, m = "getSectionDataForLibraryList")
    static final class a extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super p2.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return p2.this.a(this);
        }
    }
    public p2(w2 w2Var) {
        n.f(w2Var, "getProgramListInteractor");
        super();
        this.getProgramListInteractor = w2Var;
    }

    public final Object a(kotlin.b0.d<? super LibrarySection> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.p2.a;
        if (dVar instanceof kotlinx.coroutines.p2.a) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.p2.a aVar = new kotlinx.coroutines.p2.a(this, dVar);
            }
        }
        Object obj = b.d();
        int i5 = 1;
        if (dVar2.label != 0 && dVar2.label == i5) {
            q.b(dVar2.result);
            LibrarySection dVar3 = new LibrarySection(null, null, (List)result2, "", "", LibrarySection_SectionType.PROGRAM, null, 67, null);
            return dVar3;
        }
        q.b(dVar2.result);
        dVar2.label = i5;
        if (this.getProgramListInteractor.e(false, dVar2) == obj) {
            return obj;
        }
    }
}
