package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryProgramListInteractor;", "", "getProgramListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;)V", "getSectionDataForLibraryList", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p2 {

    private final app.dogo.com.dogo_android.s.a.w2 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryProgramListInteractor", f = "GetLibraryProgramListInteractor.kt", l = 9, m = "getSectionDataForLibraryList")
    static final class a extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.p2 this$0;
        a(app.dogo.com.dogo_android.s.a.p2 p2, d<? super app.dogo.com.dogo_android.s.a.p2.a> d2) {
            this.this$0 = p2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(this);
        }
    }
    public p2(app.dogo.com.dogo_android.s.a.w2 w2) {
        n.f(w2, "getProgramListInteractor");
        super();
        this.a = w2;
    }

    public final Object a(d<? super LibrarySection> d) {
        boolean aVar;
        int label2;
        int i;
        int label;
        int i2;
        Object obj11;
        aVar = d;
        label2 = aVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof p2.a && label2 & i != 0) {
            aVar = d;
            label2 = aVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                aVar.label = label2 -= i;
            } else {
                aVar = new p2.a(this, d);
            }
        } else {
        }
        obj11 = aVar.result;
        Object obj = b.d();
        label = aVar.label;
        int i5 = 1;
        if (label != 0) {
            if (label != i5) {
            } else {
                q.b(obj11);
                super(0, 0, (List)obj11, "", "", LibrarySection.SectionType.PROGRAM, 0, 67, 0);
                return obj11;
            }
            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj11;
        }
        q.b(obj11);
        aVar.label = i5;
        if (this.a.e(false, aVar) == obj) {
            return obj;
        }
    }
}
