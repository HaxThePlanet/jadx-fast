package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellProgramLessonIntroductionTopBindingImpl.java */
/* loaded from: classes.dex */
public class f5 extends e5 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private long W;
    static {
        obj.put(2131363448, 1);
        obj.put(2131362111, 2);
        obj.put(2131362119, 3);
        obj.put(2131362167, 4);
        obj.put(2131362124, 5);
        obj.put(2131362190, 6);
        obj.put(2131362117, 7);
        obj.put(2131361940, 8);
        obj.put(2131362068, 9);
        obj.put(2131362646, 10);
    }

    public f5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, f5.X, f5.Y));
    }

    @Override // app.dogo.com.dogo_android.h.e5
    public void A() {
        synchronized (this) {
            try {
                this.W = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e5
    protected void m() {
        synchronized (this) {
            try {
                this.W = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.e5
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private f5(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ImageView)objectArr[8], (ImageView)objectArr[9], (CardView)objectArr[2], (TextView)objectArr[7], (ImageView)objectArr[3], (TextView)objectArr[5], (ConstraintLayout)objectArr[0], (ImageView)objectArr[4], (ImageView)objectArr[6], (ImageView)objectArr[10], (ImageView)objectArr[1]);
        eVar3.W = -1L;
        eVar3.S.setTag(null);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.e5
    public boolean O(int i, Object object) {
        return true;
    }
}
