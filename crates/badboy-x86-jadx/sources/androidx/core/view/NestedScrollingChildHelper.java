package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes5.dex */
public class NestedScrollingChildHelper {

    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;
    public NestedScrollingChildHelper(View view) {
        super();
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        boolean nestedScrollingEnabled;
        int i2;
        ViewParent nestedScrollingParentForType;
        int startX;
        View mView;
        int startY;
        View mView2;
        int i3;
        int[] iArr;
        int i;
        int i4;
        final int[] iArr2 = offsetInWindow;
        i2 = 0;
        i3 = type;
        nestedScrollingParentForType = getNestedScrollingParentForType(i3);
        if (isNestedScrollingEnabled() && nestedScrollingParentForType == null) {
            i3 = type;
            nestedScrollingParentForType = getNestedScrollingParentForType(i3);
            if (nestedScrollingParentForType == null) {
                return i2;
            }
            nestedScrollingEnabled = 1;
            if (dxConsumed == 0 && dyConsumed == 0 && dxUnconsumed == 0) {
                if (dyConsumed == 0) {
                    if (dxUnconsumed == 0) {
                        if (dyUnconsumed != 0) {
                            if (iArr2 != null) {
                                this.mView.getLocationInWindow(iArr2);
                                i = startX;
                                i4 = startY;
                            } else {
                                i = startX;
                                i4 = startY;
                            }
                            if (consumed == null) {
                                startX = getTempNestedScrollConsumed();
                                startX[i2] = i2;
                                startX[nestedScrollingEnabled] = i2;
                                iArr = startX;
                            } else {
                                iArr = consumed;
                            }
                            ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, i3, iArr);
                            if (iArr2 != null) {
                                this.mView.getLocationInWindow(iArr2);
                                iArr2[i2] = i6 -= i;
                                iArr2[nestedScrollingEnabled] = i5 -= i4;
                            }
                        }
                        if (iArr2 != null) {
                            iArr2[i2] = i2;
                            iArr2[nestedScrollingEnabled] = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return nestedScrollingEnabled;
        }
        return i2;
    }

    private ViewParent getNestedScrollingParentForType(int type) {
        switch (type) {
            case 0:
                return this.mNestedScrollingParentTouch;
            case 1:
                return this.mNestedScrollingParentNonTouch;
            default:
                return null;
        }
    }

    private int[] getTempNestedScrollConsumed() {
        int[] mTempNestedScrollConsumed;
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int type, ViewParent p) {
        switch (type) {
            case 0:
                this.mNestedScrollingParentTouch = p;
                break;
            case 1:
                this.mNestedScrollingParentNonTouch = p;
                break;
            default:
        }
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        boolean nestedScrollingEnabled;
        int i = 0;
        nestedScrollingEnabled = getNestedScrollingParentForType(i);
        if (isNestedScrollingEnabled() && nestedScrollingEnabled != null) {
            nestedScrollingEnabled = getNestedScrollingParentForType(i);
            if (nestedScrollingEnabled != null) {
                return ViewParentCompat.onNestedFling(nestedScrollingEnabled, this.mView, velocityX, velocityY, consumed);
            }
        }
        return i;
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        boolean nestedScrollingEnabled;
        int i = 0;
        nestedScrollingEnabled = getNestedScrollingParentForType(i);
        if (isNestedScrollingEnabled() && nestedScrollingEnabled != null) {
            nestedScrollingEnabled = getNestedScrollingParentForType(i);
            if (nestedScrollingEnabled != null) {
                return ViewParentCompat.onNestedPreFling(nestedScrollingEnabled, this.mView, velocityX, velocityY);
            }
        }
        return i;
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, 0);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        int nestedScrollingEnabled;
        int i5;
        ViewParent nestedScrollingParentForType;
        int startX;
        int dx2;
        int startY;
        int i2;
        View mView;
        int[] iArr;
        int i4;
        int i3;
        int i;
        int obj11;
        int[] obj13;
        i5 = 0;
        nestedScrollingParentForType = getNestedScrollingParentForType(type);
        if (isNestedScrollingEnabled() && nestedScrollingParentForType == null) {
            nestedScrollingParentForType = getNestedScrollingParentForType(type);
            if (nestedScrollingParentForType == null) {
                return i5;
            }
            nestedScrollingEnabled = 1;
            if (dx == 0) {
                if (dy != 0) {
                    if (offsetInWindow != null) {
                        this.mView.getLocationInWindow(offsetInWindow);
                        i3 = startX;
                        i = startY;
                    } else {
                        i3 = startX;
                        i = startY;
                    }
                    if (consumed == null) {
                        iArr = obj13;
                    } else {
                        iArr = consumed;
                    }
                    iArr[i5] = i5;
                    iArr[nestedScrollingEnabled] = i5;
                    ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, dx, dy, iArr, type);
                    if (offsetInWindow != null) {
                        this.mView.getLocationInWindow(offsetInWindow);
                        offsetInWindow[i5] = obj11 -= i3;
                        offsetInWindow[nestedScrollingEnabled] = obj11 -= i;
                    }
                    if (iArr[i5] == 0) {
                        if (iArr[nestedScrollingEnabled] != 0) {
                            i5 = nestedScrollingEnabled;
                        }
                    } else {
                    }
                }
                if (offsetInWindow != null) {
                    offsetInWindow[i5] = i5;
                    offsetInWindow[nestedScrollingEnabled] = i5;
                    dx2 = dx;
                    i2 = dy;
                    i4 = type;
                } else {
                    dx2 = dx;
                    i2 = dy;
                    i4 = type;
                }
                return i5;
            } else {
            }
            return i5;
        }
        dx2 = dx;
        i2 = dy;
        i4 = type;
    }

    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        dispatchNestedScrollInternal(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.dispatchNestedScrollInternal(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, 0, 0);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.dispatchNestedScrollInternal(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, 0);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int type) {
        int i;
        i = getNestedScrollingParentForType(type) != null ? 1 : 0;
        return i;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View child) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        boolean mIsNestedScrollingEnabled;
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = enabled;
    }

    public boolean startNestedScroll(int axes) {
        return startNestedScroll(axes, 0);
    }

    public boolean startNestedScroll(int axes, int type) {
        ViewParent p;
        View child;
        boolean z;
        final int i = 1;
        if (hasNestedScrollingParent(type)) {
            return i;
        }
        if (isNestedScrollingEnabled()) {
            p = this.mView.getParent();
            child = this.mView;
            while (p != null) {
                if (p instanceof View != null) {
                }
                p = p.getParent();
                child = p;
            }
        }
        return 0;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int type) {
        int i;
        final ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(type);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, type);
            setNestedScrollingParentForType(type, 0);
        }
    }
}
