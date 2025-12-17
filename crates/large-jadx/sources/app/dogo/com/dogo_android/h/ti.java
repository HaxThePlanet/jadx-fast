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

/* loaded from: classes.dex */
public class ti extends app.dogo.com.dogo_android.h.si implements b.a {

    private static final ViewDataBinding.g h0;
    private static final SparseIntArray i0;
    private final ConstraintLayout d0;
    private final View.OnClickListener e0;
    private final View.OnClickListener f0;
    private long g0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(15);
        ti.h0 = gVar;
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i9 = 0;
        iArr2[i9] = 12;
        int[] iArr = new int[i4];
        iArr[i9] = 2131558800;
        gVar.a(i9, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ti.i0 = sparseIntArray;
        sparseIntArray.put(2131362711, 13);
        sparseIntArray.put(2131363156, 14);
    }

    public ti(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, ti.h0, ti.i0));
    }

    private ti(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 1, (Button)object3Arr3[10], (RecyclerView)object3Arr3[11], (ImageView)object3Arr3[13], (CardView)object3Arr3[1], (km)object3Arr3[12], (ImageView)object3Arr3[3], (TextView)object3Arr3[4], (ImageView)object3Arr3[14], (Button)object3Arr3[9], (ImageView)object3Arr3[7], (TextView)object3Arr3[8], (TextView)object3Arr3[2], (ImageView)object3Arr3[5], (TextView)object3Arr3[6]);
        Object obj4 = this;
        obj4.g0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.d0 = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.L(obj4.R);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        obj4.V.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.e0 = bVar;
        b bVar2 = new b(obj4, 2);
        obj4.f0 = bVar2;
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.km km, int i2) {
        if (i2 == 0) {
            this.g0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.g0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void A() {
        this.g0 = 16;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.g0 = 16;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((km)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((ProgramLessonItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((t)object2);
            } else {
                if (150 == i) {
                    V((ProgramCompletionSummary)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void T(t t) {
        this.c0 = t;
        this.g0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.c0 = t;
            this.g0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void U(ProgramLessonItem programLessonItem) {
        this.a0 = programLessonItem;
        this.g0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.a0 = programLessonItem;
            this.g0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    public void V(ProgramCompletionSummary programCompletionSummary) {
        this.b0 = programCompletionSummary;
        this.g0 = l |= i2;
        notifyPropertyChanged(150);
        super.I();
        return;
        synchronized (this) {
            this.b0 = programCompletionSummary;
            this.g0 = l |= i2;
            notifyPropertyChanged(150);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    public final void b(int i, View view2) {
        t tVar;
        ProgramLessonItem obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                tVar = this.c0;
                if (tVar != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    tVar.y0(this.a0);
                }
            }
        } else {
            tVar = this.c0;
            if (tVar != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                tVar.T(this.a0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.si
    protected void m() {
        int cmp6;
        long l;
        int string3;
        int cmp4;
        String string;
        int i10;
        int i19;
        Object[] arr;
        int resources;
        int cmp2;
        int cmp;
        int string2;
        int string4;
        int cmp3;
        int i;
        int lessonNumber2;
        int i7;
        int i6;
        int i13;
        int i4;
        int cmp7;
        int i11;
        int i12;
        int moduleNumber;
        int cmp5;
        int lessonNumber;
        int nextLessonInDifferentModule;
        int i20;
        int i15;
        int i21;
        int nextLessonPositionData;
        int trainingComplete;
        int lessonPasses;
        int programColor;
        int i17;
        int currentLessonPositionData;
        int i8;
        int questionComplete;
        int lessonInProgress;
        int taskComplete;
        int i2;
        int i5;
        int i9;
        int i18;
        int i3;
        int i14;
        int i16;
        final Object obj = this;
        l = obj.g0;
        int i23 = 0;
        obj.g0 = i23;
        ProgramLessonItem programLessonItem = obj.a0;
        cmp7 = 65536;
        resources = 1;
        final int i42 = 18;
        i20 = 0;
        synchronized (this) {
            obj = this;
            l = obj.g0;
            i23 = 0;
            obj.g0 = i23;
            programLessonItem = obj.a0;
            cmp7 = 65536;
            resources = 1;
            i42 = 18;
            i20 = 0;
        }
        cmp3 = Long.compare(i15, i23);
        if (cmp3 != 0) {
            if (programLessonItem != null) {
                try {
                    nextLessonInDifferentModule = programLessonItem.isNextLessonInDifferentModule();
                    trainingComplete = programLessonItem.isTrainingComplete();
                    lessonPasses = programLessonItem.isLessonPasses();
                    programColor = programLessonItem.getProgramColor();
                    currentLessonPositionData = programLessonItem.getCurrentLessonPositionData();
                    questionComplete = programLessonItem.isQuestionComplete();
                    lessonInProgress = programLessonItem.isLessonInProgress();
                    taskComplete = programLessonItem.isTaskComplete();
                    taskComplete = lessonInProgress;
                    programColor = 0;
                    currentLessonPositionData = 0;
                    if (cmp3 != 0) {
                    }
                    if (nextLessonInDifferentModule != 0) {
                    } else {
                    }
                    l |= cmp7;
                    l |= i31;
                }
                i5 = trainingComplete != 0 ? 4096 : 2048;
                l |= i5;
                if (Long.compare(i9, i23) != 0) {
                    l = lessonPasses != 0 ? l | i33 : l | i9;
                }
                if (Long.compare(i18, i23) != 0) {
                    i18 = questionComplete != 0 ? 1024 : 512;
                    l |= i18;
                }
                if (Long.compare(i3, i23) != 0) {
                    i3 = lessonInProgress != 0 ? 64 : 32;
                    l |= i3;
                }
                if (Long.compare(i14, i23) != 0) {
                    i14 = taskComplete != 0 ? 16384 : 8192;
                    l |= i14;
                }
                i2 = 1053609165;
                i15 = trainingComplete != 0 ? 1065353216 : i2;
                i8 = questionComplete != 0 ? 1065353216 : i2;
                i = lessonInProgress != 0 ? R.string.general.continue : R.string.start.lesson.button;
                string2 = obj.U.getResources().getString(i);
                i16 = taskComplete != 0 ? 1065353216 : i2;
                if (currentLessonPositionData != null) {
                    lessonNumber2 = currentLessonPositionData.getLessonNumber();
                } else {
                    lessonNumber2 = i20;
                }
                Object[] arr3 = new Object[resources];
                arr3[i20] = Integer.valueOf(lessonNumber2);
                string4 = obj.X.getResources().getString(2131887585, arr3);
                i6 = i15;
                i4 = programColor;
                i7 = i8;
                i13 = i16;
            } else {
            }
        } else {
            i13 = i6;
            lessonPasses = nextLessonInDifferentModule;
            string2 = 0;
            string4 = 0;
            i4 = 0;
        }
        if (Long.compare(i17, i23) != 0) {
            if (programLessonItem != null) {
                nextLessonPositionData = programLessonItem.getNextLessonPositionData();
            } else {
                nextLessonPositionData = 0;
            }
            if (Long.compare(i36, i23) != 0) {
                if (nextLessonPositionData != null) {
                    moduleNumber = nextLessonPositionData.getModuleNumber();
                } else {
                    moduleNumber = i20;
                }
                arr = new Object[resources];
                arr[i20] = Integer.valueOf(moduleNumber);
                string = obj.O.getResources().getString(2131887353, arr);
            } else {
                string = 0;
            }
            i17 = 0;
            if (Long.compare(i38, i17) != 0 && nextLessonPositionData != null) {
                i10 = nextLessonPositionData != null ? resources : i20;
            } else {
            }
            if (Long.compare(i40, i17) != 0) {
                if (nextLessonPositionData != null) {
                    lessonNumber = nextLessonPositionData.getLessonNumber();
                } else {
                    lessonNumber = i20;
                }
                i21 = string;
                Object[] arr2 = new Object[1];
                arr2[i20] = Integer.valueOf(lessonNumber);
                string3 = obj.O.getResources().getString(2131887592, arr2);
            } else {
                i21 = string;
                string3 = 0;
            }
        } else {
            i10 = i20;
            string3 = 0;
            i21 = 0;
        }
        int cmp9 = Long.compare(i11, i45);
        if (cmp9 != 0) {
            if (nextLessonInDifferentModule != 0) {
                string3 = i21;
            }
            if (lessonPasses != 0) {
            } else {
                i10 = i20;
            }
            if (cmp9 != 0) {
                i11 = i10 != 0 ? 256 : 128;
                l |= i11;
            }
            if (i10 != 0) {
            } else {
                i20 = i10;
            }
            i19 = i20;
        } else {
            i19 = i20;
            string3 = 0;
        }
        int i43 = 0;
        if (Long.compare(i12, i43) != 0) {
            obj.O.setOnClickListener(obj.f0);
            obj.U.setOnClickListener(obj.e0);
        }
        g.c(obj.O, string3);
        obj.O.setVisibility(i19);
        n.E(obj.Q, i4);
        g.c(obj.U, string2);
        g.c(obj.X, string4);
        if (Long.compare(i35, i43) != 0 && ViewDataBinding.t() >= 11) {
            g.c(obj.O, string3);
            obj.O.setVisibility(i19);
            n.E(obj.Q, i4);
            g.c(obj.U, string2);
            g.c(obj.X, string4);
            if (ViewDataBinding.t() >= 11) {
                obj.S.setAlpha(i7);
                obj.T.setAlpha(i7);
                obj.V.setAlpha(i13);
                obj.W.setAlpha(i13);
                obj.Y.setAlpha(i6);
                obj.Z.setAlpha(i6);
            }
        }
        int i29 = 0;
        if (Long.compare(i25, i29) != 0) {
            l.R(obj.P, programLessonItem, obj.c0);
        }
        if (Long.compare(i22, i29) != 0) {
            obj.R.T(obj.b0);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.si
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
