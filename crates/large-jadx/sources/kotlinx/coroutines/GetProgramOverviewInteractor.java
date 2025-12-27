package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* compiled from: GetProgramOverviewInteractor.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nJ\u0019\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;)V", "getProgramOverview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "programId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x2, reason: from kotlin metadata */
public final class GetProgramOverviewInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 programRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 userRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramOverviewInteractor", f = "GetProgramOverviewInteractor.kt", l = {15, 16}, m = "getProgramOverview")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super x2.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return x2.this.b(null, this);
        }
    }
    public x2(app.dogo.com.dogo_android.s.b.j1 j1Var, p1 p1Var) {
        n.f(j1Var, "programRepository");
        n.f(p1Var, "userRepository");
        super();
        this.programRepository = j1Var;
        this.userRepository = p1Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final ProgramOverview getProgramOverview(ProgramModel program) {
        n.f(program, "program");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = program.getModules().iterator();
        while (it.hasNext()) {
            p.y(arrayList2, (ProgramModel_ModuleModel)it.next().getExams());
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = program.getModules().iterator();
        while (it2.hasNext()) {
            p.y(arrayList3, (ProgramModel_ModuleModel)it2.next().getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            p.y(arrayList, (ProgramModel_LessonModel)it4.next().getTricks().values());
        }
        ArrayList arrayList4 = new ArrayList(p.r(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            List list = null;
            boolean z = false;
            int i2 = 6;
            Object obj = null;
            arrayList4.add(app.dogo.com.dogo_android.util.extensionfunction.j1.T0((TrickModel)it3.next(), null, list, z, i2, obj));
        }
        ProgramOverview program2 = new ProgramOverview(program.getProgramOverviewImage(), program.getCertificatePreviewImage(), program.getName(), arrayList2.size(), program.getNumberOfEnrolledUsers(), arrayList4, program.getAverageCompletionTimeWeeks(), program.getDogSkillsOverview(), program.getUserSkillsOverview(), program.getId());
        return program2;
    }

    public final Object b(String str, kotlin.b0.d<? super ProgramOverview> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        String str2;
        int i2;
        Object dVar24;
        app.dogo.com.dogo_android.s.a.x2 x2Var;
        String str5;
        z = dVar instanceof kotlinx.coroutines.x2.a;
        if (dVar instanceof kotlinx.coroutines.x2.a) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.x2.a aVar = new kotlinx.coroutines.x2.a(this, dVar);
            }
        }
        Object obj3 = b.d();
        int i3 = 2;
        int i4 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i4) {
                if (dVar22.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar22.result);
                    return x2Var.getProgramOverview((DogoProgram_ClassicProgram)dVar24.a());
                }
            }
            q.b(dVar22.result);
        } else {
            q.b(dVar22.result);
            dVar22.L$0 = this;
            dVar22.L$1 = str;
            dVar22.label = i4;
            Object dVar23 = this.userRepository.u(dVar22);
            if (dVar23 == obj3) {
                return obj3;
            }
            Object str3 = str;
            x2Var = this;
        }
        dVar22.L$0 = x2Var;
        Object obj2 = null;
        dVar22.L$1 = obj2;
        dVar22.label = i3;
        if (x2Var.programRepository.r((String)str2, str5, dVar22) == obj3) {
            return obj3;
        }
    }
}
