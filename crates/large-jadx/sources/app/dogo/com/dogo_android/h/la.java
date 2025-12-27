package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentClickerBindingImpl.java */
/* loaded from: classes.dex */
public class la extends ka {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private long S;
    static {
        obj.put(2131363433, 1);
        obj.put(2131363441, 2);
        obj.put(2131363024, 3);
        obj.put(2131362711, 4);
        obj.put(2131363156, 5);
        obj.put(2131362585, 6);
        obj.put(2131362181, 7);
        obj.put(2131362091, 8);
        obj.put(2131362089, 9);
        obj.put(2131363026, 10);
        obj.put(2131363025, 11);
    }

    public la(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, la.T, la.U));
    }

    @Override // app.dogo.com.dogo_android.h.ka
    public void A() {
        synchronized (this) {
            try {
                this.S = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ka
    protected void m() {
        synchronized (this) {
            try {
                this.S = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ka
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private la(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Guideline)objectArr[9], (Guideline)objectArr[8], (ClickerSoundMaterialButton)objectArr[7], (ConstraintLayout)objectArr[0], (Guideline)objectArr[6], (ImageView)objectArr[4], (ImageView)objectArr[3], (Guideline)objectArr[11], (Guideline)objectArr[10], (ImageView)objectArr[5], (AppBarLayout)objectArr[1], (MaterialToolbar)obj);
        Object eVar3 = this;
        eVar3.S = -1L;
        eVar3.P.setTag(null);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ka
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ka
    public boolean O(int i, Object object) {
        return true;
    }
}
