package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nJ\u0019\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "getProgramOverview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "programId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x2 {

    private final j1 a;
    private final p1 b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramOverviewInteractor", f = "GetProgramOverviewInteractor.kt", l = {15, 16}, m = "getProgramOverview")
    static final class a extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.x2 this$0;
        a(app.dogo.com.dogo_android.s.a.x2 x2, d<? super app.dogo.com.dogo_android.s.a.x2.a> d2) {
            this.this$0 = x2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(0, this);
        }
    }
    public x2(j1 j1, p1 p12) {
        n.f(j1, "programRepository");
        n.f(p12, "userRepository");
        super();
        this.a = j1;
        this.b = p12;
    }

    public final ProgramOverview a(ProgramModel programModel) {
        int i3;
        List exams;
        List lessons;
        boolean values;
        Object obj;
        Integer valueOf;
        int i5;
        int i;
        int i4;
        int i2;
        n.f(programModel, "program");
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = programModel.getModules().iterator();
        for (ProgramModel.ModuleModel next4 : iterator) {
            p.y(arrayList2, next4.getExams());
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator2 = programModel.getModules().iterator();
        for (ProgramModel.ModuleModel next7 : iterator2) {
            p.y(arrayList3, next7.getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator4 = arrayList3.iterator();
        for (ProgramModel.LessonModel next6 : iterator4) {
            p.y(arrayList, next6.getTricks().values());
        }
        ArrayList arrayList4 = new ArrayList(p.r(arrayList, 10));
        Iterator iterator3 = arrayList.iterator();
        for (Object next2 : iterator3) {
            arrayList4.add(j1.T0((TrickModel)next2, 0, 0, false, 6, 0));
        }
        super(programModel.getProgramOverviewImage(), programModel.getCertificatePreviewImage(), programModel.getName(), arrayList2.size(), programModel.getNumberOfEnrolledUsers(), arrayList4, programModel.getAverageCompletionTimeWeeks(), programModel.getDogSkillsOverview(), programModel.getUserSkillsOverview(), programModel.getId());
        return obj15;
    }

    public final Object b(String string, d<? super ProgramOverview> d2) {
        boolean aVar;
        int label2;
        int i4;
        Object label;
        int i2;
        j1 i3;
        int i;
        Object obj;
        app.dogo.com.dogo_android.s.a.x2 obj8;
        Object obj9;
        aVar = d2;
        label2 = aVar.label;
        i4 = Integer.MIN_VALUE;
        if (d2 instanceof x2.a && label2 & i4 != 0) {
            aVar = d2;
            label2 = aVar.label;
            i4 = Integer.MIN_VALUE;
            if (label2 & i4 != 0) {
                aVar.label = label2 -= i4;
            } else {
                aVar = new x2.a(this, d2);
            }
        } else {
        }
        obj9 = aVar.result;
        Object obj2 = b.d();
        label = aVar.label;
        int i5 = 2;
        i3 = 1;
        if (label != 0) {
            if (label != i3) {
                if (label != i5) {
                } else {
                    obj8 = aVar.L$0;
                    q.b(obj9);
                    return obj8.a((k.b)obj9.a());
                }
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
            }
            q.b(obj9);
            obj9 = obj8;
            obj8 = l$0;
            label = obj;
        } else {
            q.b(obj9);
            aVar.L$0 = this;
            aVar.L$1 = string;
            aVar.label = i3;
            obj9 = this.b.u(aVar);
            if (obj9 == obj2) {
                return obj2;
            }
            label = obj9;
            obj9 = string;
            obj8 = this;
        }
        aVar.L$0 = obj8;
        aVar.L$1 = 0;
        aVar.label = i5;
        if (obj8.a.r((String)label, obj9, aVar) == obj2) {
            return obj2;
        }
    }
}
