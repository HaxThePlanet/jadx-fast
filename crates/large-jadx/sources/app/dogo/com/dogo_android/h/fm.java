package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class fm extends app.dogo.com.dogo_android.h.em {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
    }

    public fm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, fm.T, fm.U));
    }

    private fm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ProgressBar)object3Arr3[2], (TextView)object3Arr3[1]);
        this.S = -1;
        Object obj8 = object3Arr3[0];
        this.R = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        this.P.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.em
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.em
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.em
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((ModuleCompletionSummary)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.em
    public void T(ModuleCompletionSummary moduleCompletionSummary) {
        this.Q = moduleCompletionSummary;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = moduleCompletionSummary;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.em
    protected void m() {
        int cmp;
        int valueOf;
        int valueOf2;
        int moduleNumber;
        int currentModule;
        int string;
        int i;
        Object[] arr;
        valueOf2 = 0;
        this.S = valueOf2;
        final ModuleCompletionSummary moduleCompletionSummary = this.Q;
        string = 0;
        cmp = Long.compare(i2, valueOf2);
        valueOf = 0;
        synchronized (this) {
            valueOf2 = 0;
            this.S = valueOf2;
            moduleCompletionSummary = this.Q;
            string = 0;
            cmp = Long.compare(i2, valueOf2);
            valueOf = 0;
        }
        try {
            if (moduleCompletionSummary != null) {
            } else {
            }
            moduleNumber = moduleCompletionSummary.getModuleNumber();
            currentModule = moduleCompletionSummary.isCurrentModule();
            currentModule = moduleNumber;
            arr = new Object[1];
            arr[valueOf] = Integer.valueOf(moduleNumber);
            string = this.P.getResources().getString(2131887141, arr);
            valueOf = currentModule;
            if (cmp != 0) {
            }
            l.A(this.O, moduleCompletionSummary);
            l.V(this.P, Boolean.valueOf(valueOf));
            g.c(this.P, string);
        }
    }

    @Override // app.dogo.com.dogo_android.h.em
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
