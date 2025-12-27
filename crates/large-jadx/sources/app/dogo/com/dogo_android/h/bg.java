package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.c0.f;
import app.dogo.com.dogo_android.y.c0.g;
import app.dogo.com.dogo_android.y.l;
import java.util.List;

/* compiled from: FragmentProgramTaskBindingImpl.java */
/* loaded from: classes.dex */
public class bg extends ag implements b.a {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(10);
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout R;
    private final LinearLayout S;
    private final Button T;
    private final FrameLayout U;
    private final ml V;
    private final View.OnClickListener W;
    private long X;
    static {
        int i7 = 1;
        final int[] iArr2 = new int[i7];
        final int i16 = 0;
        iArr2[i16] = 4;
        int[] iArr = new int[i7];
        iArr[i16] = R.layout.layout_loading_spinner;
        obj.a(3, new String[] { "layout_loading_spinner" }, iArr2, iArr);
        obj.put(2131363433, 5);
        obj.put(2131363356, 6);
        obj.put(2131363358, 7);
        obj.put(2131363355, 8);
        obj.put(2131362113, 9);
    }

    public bg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, bg.Y, bg.Z));
    }

    private boolean X(x<List<ProgramTasks>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void A() {
        synchronized (this) {
            try {
                this.X = 16L;
            } catch (Throwable th) {
            }
        }
        this.V.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ag
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void M(q qVar) {
        super.M(qVar);
        this.V.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void V(g gVar) {
        this.Q = gVar;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void W(f fVar) {
        this.P = fVar;
        synchronized (this) {
            try {
                this.X |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.Q != null ? 1 : 0;
        if (i2 != 0) {
            this.Q.onTasksCompletedButtonClick();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    protected void m() {
        y yVar;
        Object obj2;
        int cmp4;
        List list2 = null;
        List list3;
        Object obj3;
        Object value2;
        int cmp7 = 1;
        int i = 0;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.X = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 28L & l2;
        long l7 = 31L & l2;
        final long l8 = 26L;
        final long l9 = 25L;
        cmp4 = 0;
        if (l7 != l4) {
            if (l5 == l4 || obj.P == null) {
            } else {
                List list = obj.P.o();
            }
            long l10 = l2 & 25L;
            if (l10 != l4) {
                if (obj.P != null) {
                    x xVar = obj.P.m();
                } else {
                }
                i = 0;
                obj.Q(i, obj3);
                value2 = obj3 != null ? (List)value2 : cmp4;
            }
            long l11 = l2 & 26L;
            if (l11 != l4) {
                if (obj.P != null) {
                    f.d.a.a aVar = obj.P.n();
                } else {
                }
                cmp7 = 1;
                obj.Q(cmp7, obj2);
                if (obj.P != null) {
                }
            }
        } else {
        }
        if (l5 != l4) {
            ProgramBindingAdapters.j0(obj.S, list2, obj.Q);
        }
        long l6 = l2 & 25L;
        if (obj.S != l4) {
            ProgramBindingAdapters.setLessonTrickCoverAdapter(obj.T, list3);
        }
        l = 16L & l2;
        if (obj.S != l4) {
            obj.T.setOnClickListener(obj.W);
        }
        long l3 = l2 & 26L;
        if (obj.X != l4) {
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.U, yVar);
        }
        ViewDataBinding.o(obj.V);
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.V.y()) {
            return true;
        }
        return false;
    }

    private bg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (CardView)objectArr[9], (TextView)objectArr[8], (ImageView)objectArr[6], (TextView)objectArr[7], (MaterialToolbar)objectArr[5]);
        this.X = -1L;
        Object obj10 = objectArr[0];
        this.R = obj10;
        Object obj6 = null;
        obj10.setTag(obj6);
        int i12 = 1;
        Object obj7 = objectArr[i12];
        this.S = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[2];
        this.T = obj8;
        obj8.setTag(obj6);
        Object obj9 = objectArr[3];
        this.U = obj9;
        obj9.setTag(obj6);
        final Object obj11 = objectArr[4];
        this.V = obj11;
        L(obj11);
        N(view);
        this.W = new b(this, i12);
        A();
    }
}
