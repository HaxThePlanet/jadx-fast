package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.util.h0.j1;
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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramTricksInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getProgramTricksWithKnowledge", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y2 {

    private final j1 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramTricksInteractor", f = "GetProgramTricksInteractor.kt", l = 13, m = "getProgramTricksWithKnowledge")
    static final class a extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.y2 this$0;
        a(app.dogo.com.dogo_android.s.a.y2 y2, d<? super app.dogo.com.dogo_android.s.a.y2.a> d2) {
            this.this$0 = y2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(0, this);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<ProgramProgress.LessonProgress, Iterable<? extends ProgramProgress.TrickStatus>> {

        public static final app.dogo.com.dogo_android.s.a.y2.b a;
        static {
            y2.b bVar = new y2.b();
            y2.b.a = bVar;
        }

        b() {
            super(1);
        }

        public final Iterable<ProgramProgress.TrickStatus> a(ProgramProgress.LessonProgress programProgress$LessonProgress) {
            int values;
            Map obj2;
            values = 0;
            if (lessonProgress == null) {
            } else {
                obj2 = lessonProgress.getTricks();
                if (obj2 == null) {
                } else {
                    values = obj2.values();
                }
            }
            if (values != 0) {
            } else {
                values = p.g();
            }
            return values;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ProgramProgress.LessonProgress)object);
        }
    }
    public y2(j1 j1) {
        n.f(j1, "programRepository");
        super();
        this.a = j1;
    }

    public final Object a(ProgramSaveInfo programSaveInfo, d<? super List<TrickItem>> d2) {
        boolean aVar;
        int label;
        Object lessons;
        boolean values;
        ArrayList arrayList;
        int i7;
        int dogId;
        int i2;
        Object iterator;
        int i5;
        int i4;
        Integer next;
        int booleanValue;
        int i6;
        int i;
        int i3;
        String obj10;
        Object obj11;
        aVar = d2;
        label = aVar.label;
        i7 = Integer.MIN_VALUE;
        if (d2 instanceof y2.a && label & i7 != 0) {
            aVar = d2;
            label = aVar.label;
            i7 = Integer.MIN_VALUE;
            if (label & i7 != 0) {
                aVar.label = label -= i7;
            } else {
                aVar = new y2.a(this, d2);
            }
        } else {
        }
        obj11 = aVar.result;
        lessons = b.d();
        dogId = aVar.label;
        i4 = 1;
        if (dogId != 0) {
            if (dogId != i4) {
            } else {
                q.b(obj11);
                ArrayList arrayList2 = new ArrayList();
                obj10 = (k.b)obj11.a().getModules().iterator();
                for (ProgramModel.ModuleModel next2 : obj10) {
                    p.y(arrayList2, next2.getLessons());
                }
                obj10 = new ArrayList();
                Iterator iterator2 = arrayList2.iterator();
                for (ProgramModel.LessonModel next3 : iterator2) {
                    p.y(obj10, next3.getTricks().values());
                }
                obj11 = obj11.c();
                int i8 = 0;
                if (obj11 == null) {
                    obj11 = i8;
                } else {
                }
                ArrayList arrayList3 = new ArrayList(p.r(obj10, 10));
                obj10 = obj10.iterator();
                while (obj10.hasNext()) {
                    i4 = iterator;
                    if (obj11 == null) {
                    } else {
                    }
                    iterator = obj11.iterator();
                    for (Object next : iterator) {
                    }
                    next = i8;
                    if ((ProgramProgress.TrickStatus)next == null) {
                    } else {
                    }
                    next = iterator;
                    arrayList3.add(j1.T0(i4, next, 0, false, 6, 0));
                    next = i8;
                    if (b.a(n.b(i4.getId(), (ProgramProgress.TrickStatus)iterator.next().getId())).booleanValue()) {
                    } else {
                    }
                }
                return arrayList3;
            }
            obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj10;
        }
        q.b(obj11);
        aVar.label = i4;
        if (this.a.r(programSaveInfo.getDogId(), programSaveInfo.getProgramId(), aVar) == lessons) {
            return lessons;
        }
    }
}
