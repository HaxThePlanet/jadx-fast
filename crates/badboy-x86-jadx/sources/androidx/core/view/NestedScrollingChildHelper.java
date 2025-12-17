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
        int i3;
        ViewParent nestedScrollingParentForType;
        int startX;
        View mView;
        int startY;
        View mView2;
        int i4;
        int[] iArr;
        int i;
        int i2;
        final int[] iArr2 = offsetInWindow;
        i3 = 0;
        i4 = type;
        nestedScrollingParentForType = getNestedScrollingParentForType(i4);
        if (isNestedScrollingEnabled() && nestedScrollingParentForType == null) {
            i4 = type;
            nestedScrollingParentForType = getNestedScrollingParentForType(i4);
            if (nestedScrollingParentForType == null) {
                return i3;
            }
            nestedScrollingEnabled = 1;
            if (dxConsumed == 0 && dyConsumed == 0 && dxUnconsumed == 0) {
                if (dyConsumed == 0) {
                    if (dxUnconsumed == 0) {
                        if (dyUnconsumed != 0) {
                            if (iArr2 != null) {
                                this.mView.getLocationInWindow(iArr2);
                                i = startX;
                                i2 = startY;
                            } else {
                                i = startX;
                                i2 = startY;
                            }
                            if (consumed == null) {
                                startX = getTempNestedScrollConsumed();
                                startX[i3] = i3;
                                startX[nestedScrollingEnabled] = i3;
                                iArr = startX;
                            } else {
                                iArr = consumed;
                            }
                            ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, i4, iArr);
                            if (iArr2 != null) {
                                this.mView.getLocationInWindow(iArr2);
                                iArr2[i3] = i6 -= i;
                                iArr2[nestedScrollingEnabled] = i5 -= i2;
                            }
                        }
                        if (iArr2 != null) {
                            iArr2[i3] = i3;
                            iArr2[nestedScrollingEnabled] = i3;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return nestedScrollingEnabled;
        }
        return i3;
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
        int i3;
        ViewParent nestedScrollingParentForType;
        int startX;
        int dx2;
        int startY;
        int i2;
        View mView;
        int[] iArr;
        int i5;
        int i;
        int i4;
        int obj11;
        int[] obj13;
        i3 = 0;
        nestedScrollingParentForType = getNestedScrollingParentForType(type);
        if (isNestedScrollingEnabled() && nestedScrollingParentForType == null) {
            nestedScrollingParentForType = getNestedScrollingParentForType(type);
            if (nestedScrollingParentForType == null) {
                return i3;
            }
            nestedScrollingEnabled = 1;
            if (dx == 0) {
                if (dy != 0) {
                    if (offsetInWindow != null) {
                        this.mView.getLocationInWindow(offsetInWindow);
                        i = startX;
                        i4 = startY;
                    } else {
                        i = startX;
                        i4 = startY;
                    }
                    if (consumed == null) {
                        iArr = obj13;
                    } else {
                        iArr = consumed;
                    }
                    iArr[i3] = i3;
                    iArr[nestedScrollingEnabled] = i3;
                    ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, dx, dy, iArr, type);
                    if (offsetInWindow != null) {
                        this.mView.getLocationInWindow(offsetInWindow);
                        offsetInWindow[i3] = obj11 -= i;
                        offsetInWindow[nestedScrollingEnabled] = obj11 -= i4;
                    }
                    if (iArr[i3] == 0) {
                        if (iArr[nestedScrollingEnabled] != 0) {
                            i3 = nestedScrollingEnabled;
                        }
                    } else {
                    }
                }
                if (offsetInWindow != null) {
                    offsetInWindow[i3] = i3;
                    offsetInWindow[nestedScrollingEnabled] = i3;
                    dx2 = dx;
                    i2 = dy;
                    i5 = type;
                } else {
                    dx2 = dx;
                    i2 = dy;
                    i5 = type;
                }
                return i3;
            } else {
            }
            return i3;
        }
        dx2 = dx;
        i2 = dy;
        i5 = type;
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
