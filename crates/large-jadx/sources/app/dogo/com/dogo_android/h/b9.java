package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.q.f.a;
import app.dogo.com.dogo_android.q.q.j;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogDogSelectBindingImpl.java */
/* loaded from: classes.dex */
public class b9 extends a9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private long T;
    static {
        obj.put(2131362591, 3);
        obj.put(2131362876, 4);
        obj.put(2131362322, 5);
        obj.put(2131362336, 6);
        obj.put(2131362965, 7);
        obj.put(2131362884, 8);
    }

    public b9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, b9.U, b9.V));
    }

    private boolean X(LiveData<y<Boolean>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public void A() {
        synchronized (this) {
            try {
                this.T = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public void V(f.a aVar) {
        this.S = aVar;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public void W(j jVar) {
        this.R = jVar;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.a9
    protected void m() {
        app.dogo.com.dogo_android.repository.domain.DogSelectData dogSelectData;
        int i = 0;
        y yVar = null;
        LiveData result;
        Object value;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        final long l5 = 14L;
        i = 0;
        if (l4 != l3) {
            if (this.R != null) {
                result = this.R.getResult();
            } else {
            }
            Q(0, result);
            value = result != null ? (LoadResult)value : i;
            long l7 = l & 14L;
            if (l7 != l3 && this.R != null) {
                app.dogo.com.dogo_android.repository.domain.DogSelectData dogSelectData2 = this.R.j();
            }
        } else {
        }
        if (l4 != l3) {
            DogProfileBindingAdapters.setupDogProfileParticipate(this.O, yVar, this.S);
        }
        long l6 = 11L & l;
        if (l6 != l3) {
            BindingAdapters.setTrainerAvatar(this.P, yVar);
        }
        long l2 = l & 14L;
        if (this.T != l3) {
            DogProfileBindingAdapters.y(this.Q, dogSelectData, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private b9(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (View)objectArr[2], (ConstraintLayout)objectArr[0], (ImageView)objectArr[5], (ImageView)objectArr[6], (Guideline)objectArr[3], (NestedScrollView)objectArr[4], (TextView)objectArr[8], (ImageView)objectArr[7], (RecyclerView)objectArr[1]);
        eVar3.T = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        N(view);
        A();
    }
}
