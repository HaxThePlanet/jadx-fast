package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.s.b.i1;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.y.k.c;
import i.b.a0;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: PottyProgramCardInteractor.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPottyProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f3, reason: from kotlin metadata */
public final class PottyProgramCardInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 programContentRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final i1 programRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final l1 reminderRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final h0 userRepository;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramCardInteractor$getPottyProgramCard$2", f = "PottyProgramCardInteractor.kt", l = {26, 27, 28}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super Dashboard.PottyProgramCard>, Object> {

        Object L$0;
        Object L$1;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int i = 0;
            PottyProgramProgress pottyProgramProgress;
            String str;
            Object object2;
            int i2 = 1;
            int i3 = 0;
            final Object object3 = this;
            object2 = b.d();
            int i7 = 3;
            int i8 = 2;
            i2 = 1;
            if (object3.label != 0) {
                if (object3.label != i2) {
                    if (object3.label != i8) {
                        if (object3.label != i7) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            object2 = object;
                            app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = (DogoProgram_PottyProgram)object2.c();
                            if (programStatus == null) {
                                i = 0;
                            } else {
                                PottyProgramProgress pottyProgramProgressItem = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
                            }
                            if (i == 0) {
                                String str2 = null;
                                long l = 0L;
                                i3 = 0;
                                java.util.List list = null;
                                java.util.List list2 = null;
                                boolean z = false;
                                boolean z2 = false;
                                String str3 = null;
                                String str4 = null;
                                int i4 = 0;
                                g gVar = null;
                                int i5 = 2047;
                                int i6 = 0;
                                pottyProgramProgress = new PottyProgramProgress(str2, l, l2, i3, i12, list, list2, z, z2, str3, str4, i4, gVar, i5, i6);
                            }
                            Object blockingGet = object3.this$0.reminderRepository.e(str).blockingGet();
                            n.e(blockingGet, "reminders");
                            return new Dashboard_PottyProgramCard(pottyProgramProgress.isEnrolled(), pottyProgramProgress, app.dogo.com.dogo_android.util.extensionfunction.j1.c(object2, ProgramDescriptionItem_State.NOT_STARTED, false, false, 0L, false, 0, null, 124, null), blockingGet);
                        }
                    }
                    q.b(object);
                    object2 = object;
                } else {
                    q.b(object);
                    object2 = object;
                    object3.L$0 = (String)object2;
                    object3.label = i8;
                    if (object3.this$0.programRepository.g("id_potty_program", object3) == object2) {
                        return object2;
                    }
                }
            } else {
                q.b(object);
                object3.label = i2;
                if (object3.this$0.dispatcher.u(object3) == object2) {
                    return object2;
                }
            }
            object3.L$0 = str;
            object3.L$1 = (ProgramModel)object2;
            object3.label = i7;
            if (object3.this$0.programContentRepository.v(str, object3) == object2) {
                return object2;
            }
        }

        a(d<? super f3.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super Dashboard.PottyProgramCard> dVar) {
            return (kotlinx.coroutines.f3.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.f3.a(f3.this, dVar);
        }
    }
    public f3(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, i1 i1Var, l1 l1Var, h0 h0Var) {
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        n.f(i1Var, "programContentRepository");
        n.f(l1Var, "reminderRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = p1Var;
        this.programContentRepository = j1Var;
        this.programRepository = i1Var;
        this.reminderRepository = l1Var;
        this.userRepository = h0Var;
    }

    public static final /* synthetic */ i1 a(f3 f3Var) {
        return f3Var.programRepository;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.b.j1 b(f3 f3Var) {
        return f3Var.programContentRepository;
    }

    public static final /* synthetic */ l1 c(f3 f3Var) {
        return f3Var.reminderRepository;
    }

    public static final /* synthetic */ p1 d(f3 f3Var) {
        return f3Var.dispatcher;
    }

    public final Object e(d<? super Dashboard.PottyProgramCard> dVar) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.f3.a(this, null), dVar);
    }

    public /* synthetic */ f3(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, i1 i1Var, l1 l1Var, h0 h0Var, int i, g gVar) {
        h0 h0Var52;
        if (i & 16 != 0) {
            h0Var52 = Dispatchers.b();
        }
        this(p1Var, j1Var, i1Var, l1Var, h0Var52);
    }
}
