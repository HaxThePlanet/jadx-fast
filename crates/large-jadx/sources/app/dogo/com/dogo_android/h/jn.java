package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutWelcomeChallengeParticipationBindingImpl.java */
/* loaded from: classes.dex */
public class jn extends in {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private long Q;
    static {
        obj.put(2131363450, 1);
        obj.put(2131363451, 2);
        obj.put(2131362112, 3);
        obj.put(2131363421, 4);
        obj.put(2131362322, 5);
        obj.put(2131362731, 6);
        obj.put(2131362619, 7);
        obj.put(2131362948, 8);
    }

    public jn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, jn.R, jn.S));
    }

    @Override // app.dogo.com.dogo_android.h.in
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.in
    protected void m() {
        synchronized (this) {
            try {
                this.Q = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.in
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Q != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private jn(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (CardView)objectArr[3], (ImageView)objectArr[5], (ImageView)objectArr[7], (LinearLayout)objectArr[6], (TextView)objectArr[8], (TextView)objectArr[4], (ImageView)objectArr[1], (ImageView)objectArr[2], (LinearLayout)objectArr[0]);
        eVar3.Q = -1L;
        eVar3.P.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.in
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.in
    public boolean O(int i, Object object) {
        return true;
    }
}
