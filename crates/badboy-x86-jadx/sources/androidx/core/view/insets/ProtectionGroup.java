package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.graphics.Insets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class ProtectionGroup implements androidx.core.view.insets.SystemBarStateMonitor.Callback {

    private int mAnimationCount;
    private boolean mDisposed;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final androidx.core.view.insets.SystemBarStateMonitor mMonitor;
    private final ArrayList<androidx.core.view.insets.Protection> mProtections;
    ProtectionGroup(androidx.core.view.insets.SystemBarStateMonitor monitor, List<androidx.core.view.insets.Protection> list2) {
        super();
        ArrayList arrayList = new ArrayList();
        this.mProtections = arrayList;
        this.mInsets = Insets.NONE;
        this.mInsetsIgnoringVisibility = Insets.NONE;
        addProtections(list2, false);
        addProtections(list2, true);
        monitor.addCallback(this);
        this.mMonitor = monitor;
    }

    private void addProtections(List<androidx.core.view.insets.Protection> list, boolean occupiesCorners) {
        int i;
        Object obj;
        boolean occupiesCorners2;
        ArrayList mProtections;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            occupiesCorners2 = obj.getController();
            obj.setController(this);
            this.mProtections.add(obj);
            i++;
        }
    }

    private void updateInsets() {
        Insets consumed;
        int i;
        Object obj;
        Insets dispatchInsets;
        Insets mInsetsIgnoringVisibility;
        consumed = Insets.NONE;
        size--;
        while (i >= 0) {
            consumed = Insets.max(consumed, (Protection)this.mProtections.get(i).dispatchInsets(this.mInsets, this.mInsetsIgnoringVisibility, consumed));
            i--;
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    void dispose() {
        int i3;
        int i;
        int i2;
        if (this.mDisposed) {
        }
        i3 = 1;
        this.mDisposed = i3;
        this.mMonitor.removeCallback(this);
        size -= i3;
        while (i >= 0) {
            (Protection)this.mProtections.get(i).setController(0);
            i--;
        }
        this.mProtections.clear();
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    androidx.core.view.insets.Protection getProtection(int index) {
        return (Protection)this.mProtections.get(index);
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    public void onAnimationEnd() {
        int i;
        int mAnimationCount;
        mAnimationCount = 1;
        i = this.mAnimationCount > 0 ? mAnimationCount : 0;
        this.mAnimationCount = mAnimationCount3 -= mAnimationCount;
        if (i != 0 && this.mAnimationCount == 0) {
            if (this.mAnimationCount == 0) {
                updateInsets();
            }
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    public void onAnimationProgress(int sides, Insets insets, RectF alpha) {
        int i;
        Object obj;
        int side;
        int bottom;
        int bottom2;
        int right;
        int top;
        int left;
        float f;
        final Insets mInsetsIgnoringVisibility = this.mInsetsIgnoringVisibility;
        final int i2 = 1;
        size -= i2;
        while (i >= 0) {
            obj = this.mProtections.get(i);
            side = (Protection)obj.getSide();
            if (side & sides == 0) {
            } else {
            }
            obj.setSystemVisible(i2);
            i--;
            if (mInsetsIgnoringVisibility.bottom > 0) {
            }
            obj.setSystemAlpha(alpha.bottom);
            obj.setSystemInsetAmount(f2 /= f);
            if (mInsetsIgnoringVisibility.right > 0) {
            }
            obj.setSystemAlpha(alpha.right);
            obj.setSystemInsetAmount(f3 /= f);
            if (mInsetsIgnoringVisibility.top > 0) {
            }
            obj.setSystemAlpha(alpha.top);
            obj.setSystemInsetAmount(f4 /= f);
            if (mInsetsIgnoringVisibility.left > 0) {
            }
            obj.setSystemAlpha(alpha.left);
            obj.setSystemInsetAmount(f5 /= f);
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    public void onAnimationStart() {
        this.mAnimationCount = mAnimationCount++;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    public void onColorHintChanged(int color) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            (Protection)this.mProtections.get(i).dispatchColorHint(color);
            i--;
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    public void onInsetsChanged(Insets insets, Insets insetsIgnoringVisibility) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
        updateInsets();
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor$Callback
    int size() {
        return this.mProtections.size();
    }
}
