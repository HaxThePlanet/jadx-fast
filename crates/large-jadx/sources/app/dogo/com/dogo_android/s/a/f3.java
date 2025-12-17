package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.s.b.i1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.k.c;
import i.b.a0;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramCardInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPottyProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f3 {

    private final p1 a;
    private final j1 b;
    private final i1 c;
    private final l1 d;
    private final h0 e;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramCardInteractor$getPottyProgramCard$2", f = "PottyProgramCardInteractor.kt", l = {26, 27, 28}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super Dashboard.PottyProgramCard>, Object> {

        Object L$0;
        Object L$1;
        int label;
        final app.dogo.com.dogo_android.s.a.f3 this$0;
        a(app.dogo.com.dogo_android.s.a.f3 f3, d<? super app.dogo.com.dogo_android.s.a.f3.a> d2) {
            this.this$0 = f3;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super Dashboard.PottyProgramCard> d2) {
            return (f3.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f3.a obj2 = new f3.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$1;
            int pottyProgramProgress;
            Object l$0;
            Object obj;
            Object obj2;
            int i12;
            int i3;
            int i7;
            int i13;
            int i5;
            int i4;
            int i8;
            int i6;
            int i10;
            int i2;
            int i9;
            int i14;
            int i;
            int i11;
            final Object obj3 = this;
            l$1 = b.d();
            int label = obj3.label;
            int i15 = 3;
            int i16 = 2;
            i12 = 1;
            if (label != 0) {
                if (label != i12) {
                    if (label != i16) {
                        if (label != i15) {
                        } else {
                            l$0 = obj3.L$0;
                            q.b(object);
                            obj = object;
                            obj2 = l$1;
                            app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = (k.c)obj.c();
                            if (programStatus == null) {
                                pottyProgramProgress = 0;
                            } else {
                                pottyProgramProgress = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
                            }
                            if (pottyProgramProgress == 0) {
                                super(0, 0, obj8, 0, obj10, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
                            }
                            Object blockingGet = f3.c(obj3.this$0).e(l$0).blockingGet();
                            n.e((List)blockingGet, "reminders");
                            Dashboard.PottyProgramCard pottyProgramCard = new Dashboard.PottyProgramCard(pottyProgramProgress.isEnrolled(), pottyProgramProgress, j1.c(obj2, ProgramDescriptionItem.State.NOT_STARTED, false, false, 0, i13, 0, 0, 0, 124), blockingGet);
                            return pottyProgramCard;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    l$0 = obj3.L$0;
                    q.b(object);
                    obj2 = object;
                } else {
                    q.b(object);
                    l$0 = object;
                    obj3.L$0 = (String)l$0;
                    obj3.label = i16;
                    if (f3.a(obj3.this$0).g("id_potty_program", obj3) == l$1) {
                        return l$1;
                    }
                }
            } else {
                q.b(object);
                obj3.label = i12;
                if (f3.d(obj3.this$0).u(obj3) == l$1) {
                    return l$1;
                }
            }
            obj3.L$0 = l$0;
            obj3.L$1 = (ProgramModel)obj2;
            obj3.label = i15;
            if (f3.b(obj3.this$0).v(l$0, obj3) == l$1) {
                return l$1;
            }
        }
    }
    public f3(p1 p1, j1 j12, i1 i13, l1 l14, h0 h05) {
        n.f(p1, "userRepository");
        n.f(j12, "programRepository");
        n.f(i13, "programContentRepository");
        n.f(l14, "reminderRepository");
        n.f(h05, "dispatcher");
        super();
        this.a = p1;
        this.b = j12;
        this.c = i13;
        this.d = l14;
        this.e = h05;
    }

    public f3(p1 p1, j1 j12, i1 i13, l1 l14, h0 h05, int i6, g g7) {
        h0 obj11;
        if (i6 &= 16 != 0) {
            obj11 = c1.b();
        }
        super(p1, j12, i13, l14, obj11);
    }

    public static final i1 a(app.dogo.com.dogo_android.s.a.f3 f3) {
        return f3.c;
    }

    public static final j1 b(app.dogo.com.dogo_android.s.a.f3 f3) {
        return f3.b;
    }

    public static final l1 c(app.dogo.com.dogo_android.s.a.f3 f3) {
        return f3.d;
    }

    public static final p1 d(app.dogo.com.dogo_android.s.a.f3 f3) {
        return f3.a;
    }

    public final Object e(d<? super Dashboard.PottyProgramCard> d) {
        f3.a aVar = new f3.a(this, 0);
        return k.e(this.e, aVar, d);
    }
}
