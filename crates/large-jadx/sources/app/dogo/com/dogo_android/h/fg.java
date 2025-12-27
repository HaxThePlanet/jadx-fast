package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentProgramTrickTryBindingImpl.java */
/* loaded from: classes.dex */
public class fg extends eg {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout U;
    private long V;
    static {
        obj.put(2131362628, 4);
        obj.put(2131363459, 5);
        obj.put(2131362564, 6);
        obj.put(2131362721, 7);
        obj.put(2131362897, 8);
    }

    public fg(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, fg.W, fg.X));
    }

    @Override // app.dogo.com.dogo_android.h.eg
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.eg
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.eg
    public void V(app.dogo.com.dogo_android.y.e0.e eVar) {
        this.T = eVar;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.eg
    protected void m() {
        String name = null;
        Object obj = null;
        int i;
        String imageUrl;
        Object obj2;
        String description;
        synchronized (this) {
            try {
                long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.V & 3L;
        i = 0;
        if (l2 != l3) {
            if (this.T != null) {
                TrickItem trackLetsTryButtonTap = this.T.trackLetsTryButtonTap();
            } else {
            }
            if (i != 0) {
                description = i.getDescription();
            } else {
            }
            int i2 = 2131886812;
            Object[] arr = new Object[1];
            int i3 = 0;
            arr[i3] = name;
        } else {
        }
        if (l2 != l3) {
            g.c(this.O, obj);
            g.c(this.R, obj2);
            BindingAdapters.n0(this.S, imageUrl);
        }
    }

    @Override // app.dogo.com.dogo_android.h.eg
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fg(androidx.databinding.e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (TextView)objectArr[3], (TextView)objectArr[6], (ImageView)objectArr[4], (MaterialButton)objectArr[7], (TextView)objectArr[8], (TextView)objectArr[1], (TextView)objectArr[5], (ImageView)objectArr[2]);
        eVar3.V = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.U = obj9;
        obj9.setTag(obj10);
        eVar3.R.setTag(obj10);
        eVar3.S.setTag(obj10);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.eg
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
