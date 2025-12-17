package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* loaded from: classes.dex */
public class hk extends app.dogo.com.dogo_android.h.gk implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final CardView U;
    private final ConstraintLayout V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private long Y;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(10);
        hk.Z = gVar;
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 5;
        int[] iArr2 = new int[i6];
        iArr2[i12] = 2131558817;
        gVar.a(i6, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        hk.a0 = sparseIntArray;
        sparseIntArray.put(2131362711, 6);
        sparseIntArray.put(2131363414, 7);
        sparseIntArray.put(2131362298, 8);
        sparseIntArray.put(2131363156, 9);
    }

    public hk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, hk.Z, hk.a0));
    }

    private hk(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        final int i13 = 2;
        super(e, view2, 1, (TextView)object3Arr3[8], (RecyclerView)object3Arr3[3], (ImageView)object3Arr3[i13], (ImageView)object3Arr3[6], (ImageView)object3Arr3[9], (Button)object3Arr3[4], (kn)object3Arr3[5], (TextView)object3Arr3[7]);
        obj20.Y = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        Object obj9 = object3Arr3[0];
        obj20.U = (CardView)obj9;
        obj9.setTag(i11);
        int i10 = 1;
        Object obj11 = object3Arr3[i10];
        obj20.V = (ConstraintLayout)obj11;
        obj11.setTag(i11);
        obj20.Q.setTag(i11);
        L(obj20.R);
        N(view2);
        b bVar2 = new b(this, i10);
        obj20.W = bVar2;
        b bVar = new b(this, i13);
        obj20.X = bVar;
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.kn kn, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void A() {
        this.Y = 8;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.Y = 8;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((kn)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((WorkoutSession)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((e0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void T(e0 e0) {
        this.S = e0;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = e0;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public void U(WorkoutSession workoutSession) {
        this.T = workoutSession;
        this.Y = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.T = workoutSession;
            this.Y = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    public final void b(int i, View view2) {
        int i2;
        e0 obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.S;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.p1();
                }
            }
        } else {
            obj3 = this.S;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.f1();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gk
    protected void m() {
        int cmp;
        int cmp3;
        long l;
        int valueOf;
        int i2;
        int cmp4;
        int cmp2;
        int i;
        int currentStreak;
        int i4;
        boolean streaksEnabled;
        int longestStreak;
        int i3;
        final Object obj = this;
        l = obj.Y;
        final int i5 = 0;
        obj.Y = i5;
        WorkoutSession workoutSession = obj.T;
        int i7 = 14;
        final int i10 = 10;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i5 = 0;
            obj.Y = i5;
            workoutSession = obj.T;
            i7 = 14;
            i10 = 10;
            i = 0;
        }
        cmp2 = Long.compare(i4, i5);
        if (cmp2 != 0) {
            if (workoutSession != null) {
                try {
                    currentStreak = workoutSession.getCurrentStreak();
                    streaksEnabled = workoutSession.isStreaksEnabled();
                    longestStreak = workoutSession.getLongestStreak();
                    longestStreak = streaksEnabled;
                    if (cmp2 != 0) {
                    }
                    if (streaksEnabled) {
                    } else {
                    }
                    i3 = 32;
                    i3 = 16;
                    l |= i3;
                }
                if (streaksEnabled) {
                } else {
                    i = cmp2;
                }
            } else {
            }
        } else {
            longestStreak = currentStreak;
        }
        if (Long.compare(i8, i5) != 0) {
            i.D(obj.O, workoutSession, obj.S);
        }
        if (Long.compare(i2, i5) != 0) {
            obj.P.setOnClickListener(obj.W);
            obj.Q.setOnClickListener(obj.X);
        }
        if (Long.compare(valueOf, i5) != 0) {
            obj.R.w().setVisibility(i);
            obj.R.T(Integer.valueOf(currentStreak));
            obj.R.U(Integer.valueOf(longestStreak));
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.gk
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
