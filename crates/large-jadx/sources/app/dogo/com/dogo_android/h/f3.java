package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public class f3 extends app.dogo.com.dogo_android.h.e3 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final Chip P;
    private long Q;
    static {
    }

    public f3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 1, f3.R, f3.S));
    }

    private f3(e e, View view2, Object[] object3Arr3) {
        final int i = 0;
        super(e, view2, i);
        this.Q = -1;
        final Object obj4 = object3Arr3[i];
        this.P = (Chip)obj4;
        obj4.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public void A() {
        this.Q = 2;
        I();
        return;
        synchronized (this) {
            this.Q = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((LibraryTag)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public void V(LibraryTag libraryTag) {
        this.O = libraryTag;
        this.Q = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.O = libraryTag;
            this.Q = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e3
    protected void m() {
        int cmp;
        int name;
        final int i2 = 0;
        this.Q = i2;
        name = 0;
        final LibraryTag libraryTag = this.O;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.Q = i2;
            name = 0;
            libraryTag = this.O;
            cmp = Long.compare(i, i2);
        }
        try {
            if (libraryTag != null) {
            }
            name = libraryTag.getName();
            if (cmp != 0) {
            }
            g.c(this.P, name);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.e3
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
