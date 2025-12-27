package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutDashboardCurrentLessonCardBindingImpl.java */
/* loaded from: classes.dex */
public class ti extends si implements b.a {

    private static final ViewDataBinding.g h0 = new ViewDataBinding$g(15);
    private static final SparseIntArray i0 = new SparseIntArray();
    private final ConstraintLayout d0;
    private final View.OnClickListener e0;
    private final View.OnClickListener f0;
    private long g0;
    static {
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i9 = 0;
        iArr2[i9] = 12;
        int[] iArr = new int[i4];
        iArr[i9] = R.layout.layout_program_progress_bar;
        obj.a(i9, new String[] { "layout_program_progress_bar" }, iArr2, iArr);
        obj.put(2131362711, 13);
        obj.put(2131363156, 14);
    }

    public ti(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, ti.h0, ti.i0));
    }

    private boolean W(km kmVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.g0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void A() {
        synchronized (this) {
            try {
                this.g0 = 16L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.si
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                i2 = 150;
                if (150 == i) {
                    V(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void T(t tVar) {
        this.c0 = tVar;
        synchronized (this) {
            try {
                this.g0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void U(ProgramLessonItem programLessonItem) {
        this.a0 = programLessonItem;
        synchronized (this) {
            try {
                this.g0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void V(ProgramCompletionSummary programCompletionSummary) {
        this.b0 = programCompletionSummary;
        synchronized (this) {
            try {
                this.g0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(150);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.si
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.c0 != null) {
            }
            if (i2 != 0) {
                this.c0.onExamCardSelected(this.a0);
            }
        } else {
            if (this.a0 == 2) {
                if (this.c0 != null) {
                }
                if (i2 != 0) {
                    this.c0.onStartNextLessonSelected(this.a0);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    protected void m() {
        long l;
        int i = 0;
        java.lang.CharSequence charSequence = null;
        int lessonNumber;
        Object obj2 = null;
        int i2 = 2131887352;
        Object obj3 = null;
        int i3;
        String str = null;
        int i5 = 256;
        long l3;
        int i6 = 0;
        long l5;
        int i4 = 0;
        int i7 = 0;
        int i8 = 2048;
        int i9 = 8192;
        int i10 = 32;
        int i11 = 512;
        final Object obj = this;
        synchronized (this) {
            try {
                long l13 = 0L;
                obj.g0 = l13;
            } catch (Throwable th) {
            }
        }
        long l16 = l & 22L;
        long l2 = 65536L;
        lessonNumber = 1;
        final long l21 = 18L;
        lessonNumber = 0;
        if (l16 != l13) {
            l5 = l & 18L;
            if (l5 != l13) {
                if (obj.a0 != null) {
                    boolean nextLessonInDifferentModule = obj.a0.isNextLessonInDifferentModule();
                    boolean trainingComplete = obj.a0.isTrainingComplete();
                    boolean lessonPasses = obj.a0.isLessonPasses();
                    String programColor = obj.a0.getProgramColor();
                    ProgramLessonItem.LessonPositionData currentLessonPositionData = obj.a0.getCurrentLessonPositionData();
                    boolean questionComplete = obj.a0.isQuestionComplete();
                    boolean lessonInProgress = obj.a0.isLessonInProgress();
                    boolean taskComplete = obj.a0.isTaskComplete();
                } else {
                    i4 = 0;
                    i7 = 0;
                }
                if (l5 != l13) {
                    long r2 = lessonNumber != 0 ? l | l2 : l | 32768;
                }
                l7 = (lessonNumber != 0 ? l | l2 : l | 32768) & 18L;
                if (l7 != l13) {
                    int r28 = lessonNumber != 0 ? 4096 : 2048;
                    l = r2 | (lessonNumber != 0 ? 4096 : 2048);
                }
                l8 = l & 18L;
                if (l8 != l13) {
                    l = lessonNumber != 0 ? l | 262144 : l | l8;
                }
                l9 = l & 18L;
                if (l9 != l13) {
                    r28 = lessonNumber != 0 ? 1024 : 512;
                    l = l | (lessonNumber != 0 ? 1024 : 512);
                }
                l10 = l & 18L;
                if (l10 != l13) {
                    r28 = lessonNumber != 0 ? 64 : 32;
                    l = l | (lessonNumber != 0 ? 64 : 32);
                }
                l11 = l & 18L;
                if (l11 != l13 && lessonNumber != 0) {
                    i9 = 16384;
                    l = l | i9;
                }
                i3 = 1053609165;
                int r21 = lessonNumber != 0 ? 1065353216 : i3;
                int r25 = lessonNumber != 0 ? 1065353216 : i3;
                int r10 = lessonNumber != 0 ? R.string.general.continue : R.string.start.lesson.button;
                String string3 = obj.U.getResources().getString((lessonNumber != 0 ? R.string.general.continue : R.string.start.lesson.button));
                int r29 = lessonNumber != 0 ? 1065353216 : i3;
                if (i7 != 0) {
                    lessonNumber = i7.getLessonNumber();
                } else {
                }
                Object[] arr3 = new Object[lessonNumber];
                String string4 = obj.X.getResources().getString(2131887585, new Object[] { Integer.valueOf(lessonNumber) });
            } else {
                int i18 = 0;
                int i19 = 0;
                int i23 = 0;
            }
        }
        l6 = l & 360448L;
        if (l6 != l13) {
            if (obj.a0 != null) {
                ProgramLessonItem.LessonPositionData nextLessonPositionData = obj.a0.getNextLessonPositionData();
            } else {
                i6 = 0;
            }
            long l18 = 65536L & l;
            if (l18 != l13) {
                if (i6 != 0) {
                    lessonNumber = i6.getModuleNumber();
                } else {
                }
                Object[] arr = new Object[lessonNumber];
                int cmp6 = 2131887353;
                String string2 = obj.O.getResources().getString(cmp6, new Object[] { Integer.valueOf(lessonNumber) });
            } else {
                i = 0;
            }
            long l19 = 262144L & l;
            long l6 = 0L;
            int r5 = lessonNumber;
            long l20 = 32768L & l;
            if (l20 != l6) {
                if (i6 != 0) {
                    lessonNumber = i6.getLessonNumber();
                } else {
                }
                Object[] arr2 = new Object[1];
                String string = obj.O.getResources().getString(2131887592, new Object[] { Integer.valueOf(lessonNumber) });
            } else {
                i = 0;
            }
        } else {
            i = 0;
            i = 0;
        }
        l3 = l & 18L;
        if (l3 != 0) {
            if (lessonNumber != 0) {
            }
            if (lessonNumber == 0) {
            }
            if (l3 != 0) {
                int r15 = lessonNumber != 0 ? 256 : 128;
                l = l | (lessonNumber != 0 ? 256 : 128);
            }
            if (lessonNumber == 0) {
                lessonNumber = 8;
            }
        } else {
            int i12 = 0;
        }
        l4 = 16L & l;
        long l22 = 0L;
        if (l4 != l22) {
            obj.O.setOnClickListener(obj.f0);
            obj.U.setOnClickListener(obj.e0);
        }
        long l17 = l & 18L;
        if (obj.e0 != l22) {
            g.c(obj.O, charSequence);
            obj.O.setVisibility(lessonNumber);
            BindingAdapters.setRatingChange(obj.Q, str);
            g.c(obj.U, obj2);
            g.c(obj.X, obj3);
            lessonNumber = 11;
            if (ViewDataBinding.t() >= 11) {
                obj.S.setAlpha(i3);
                obj.T.setAlpha(i3);
                obj.V.setAlpha(i3);
                obj.W.setAlpha(i3);
                obj.Y.setAlpha(i3);
                obj.Z.setAlpha(i3);
            }
        }
        long l14 = 22L & l;
        long l15 = 0L;
        if (obj.O != l15) {
            ProgramBindingAdapters.setupOverviewCard(obj.P, obj.a0, obj.c0);
        }
        l &= 24;
        if (obj.g0 != l15) {
            obj.R.T(obj.b0);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.g0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private ti(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[10], (RecyclerView)objectArr[11], (ImageView)objectArr[13], (CardView)objectArr[1], (km)objectArr[12], (ImageView)objectArr[3], (TextView)objectArr[4], (ImageView)objectArr[14], (Button)objectArr[9], (ImageView)objectArr[7], (TextView)objectArr[8], (TextView)objectArr[2], (ImageView)objectArr[5], (TextView)objectArr[6]);
        Object eVar4 = this;
        eVar4.g0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.d0 = obj;
        obj.setTag(obj2);
        eVar4.L(eVar4.R);
        eVar4.S.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Y.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.N(view);
        eVar4.e0 = new b(eVar4, 1);
        eVar4.f0 = new b(eVar4, 2);
        A();
    }
}
