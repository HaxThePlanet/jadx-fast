package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.b;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: GetProgramTricksInteractor.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getProgramTricksWithKnowledge", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y2, reason: from kotlin metadata */
public final class GetProgramTricksInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 programRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramTricksInteractor", f = "GetProgramTricksInteractor.kt", l = 13, m = "getProgramTricksWithKnowledge")
    static final class a extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super y2.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return y2.this.a(null, this);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<ProgramProgress.LessonProgress, Iterable<? extends ProgramProgress.TrickStatus>> {

        public static final y2.b a = new y2$b();
        @Override // kotlin.d0.d.p
        public final Iterable<ProgramProgress.TrickStatus> a(ProgramProgress.LessonProgress lessonProgress) {
            int i = 0;
            List list;
            i = 0;
            if (lessonProgress != null) {
                Map tricks = lessonProgress.getTricks();
                if (tricks != null) {
                    Collection values = tricks.values();
                }
            }
            if (i == 0) {
                list = p.g();
            }
            return list;
        }


        b() {
            super(1);
        }
    }
    public y2(app.dogo.com.dogo_android.s.b.j1 j1Var) {
        n.f(j1Var, "programRepository");
        super();
        this.programRepository = j1Var;
    }

    public final Object a(ProgramSaveInfo programSaveInfo, kotlin.b0.d<? super List<TrickItem>> dVar) {
        Object dVar22;
        int label2;
        int i2 = -2147483648;
        int label22;
        List lessons;
        Object item;
        int i4;
        Integer item2;
        List list = null;
        boolean z2 = false;
        String str;
        Object result2;
        List list2;
        z = dVar instanceof kotlinx.coroutines.y2.a;
        if (dVar instanceof kotlinx.coroutines.y2.a) {
            dVar22 = dVar;
            i2 = Integer.MIN_VALUE;
            i4 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar22.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.a.y2.a aVar = new kotlinx.coroutines.y2.a(this, dVar);
            }
        }
        Object obj = b.d();
        int i5 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = result2.a().getModules().iterator();
                while (it3.hasNext()) {
                    p.y(arrayList2, (ProgramModel_ModuleModel)it3.next().getLessons());
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    p.y(arrayList4, (ProgramModel_LessonModel)it.next().getTricks().values());
                }
                ProgramProgress programProgress = result2.c();
                int i = 0;
                dVar = i;
                ArrayList arrayList3 = new ArrayList(p.r(arrayList4, 10));
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    TrickModel trickModel = it4.next();
                    int r4 = i;
                    list = null;
                    z2 = false;
                    int i6 = 6;
                    Object obj2 = null;
                    arrayList3.add(app.dogo.com.dogo_android.util.extensionfunction.j1.T0(trickModel, i, null, false, 6, null));
                }
                return arrayList3;
            }
        }
        q.b(dVar22.result);
        dVar22.label = i5;
        if (this.programRepository.r(programSaveInfo.getDogId(), programSaveInfo.getProgramId(), dVar22) == obj) {
            return obj;
        }
    }
}
