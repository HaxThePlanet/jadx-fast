package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

/* loaded from: classes5.dex */
public class DragStartHelper {

    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final androidx.core.view.DragStartHelper.OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener;
    private final View.OnTouchListener mTouchListener;
    private final View mView;

    public interface OnDragStartListener {
        public abstract boolean onDragStart(View view, androidx.core.view.DragStartHelper dragStartHelper2);
    }
    public DragStartHelper(View view, androidx.core.view.DragStartHelper.OnDragStartListener listener) {
        super();
        DragStartHelper$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new DragStartHelper$$ExternalSyntheticLambda0(this);
        this.mLongClickListener = externalSyntheticLambda0;
        DragStartHelper$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new DragStartHelper$$ExternalSyntheticLambda1(this);
        this.mTouchListener = externalSyntheticLambda1;
        this.mView = view;
        this.mListener = listener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        final int i = 0;
        this.mView.setOnLongClickListener(i);
        this.mView.setOnTouchListener(i);
    }

    public void getTouchPosition(Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View v) {
        if (this.mDragging) {
            return 1;
        }
        this.mDragging = this.mListener.onDragStart(v, this);
        return this.mDragging;
    }

    public boolean onTouch(View v, MotionEvent event) {
        int mLastTouchX;
        int i = (int)f;
        int i2 = (int)f2;
        final int i4 = 0;
        switch (mLastTouchX) {
            case 0:
                this.mLastTouchX = i;
                this.mLastTouchY = i2;
                break;
            case 1:
                this.mDragging = i4;
                break;
            case 2:
                this.mLastTouchX = i;
                this.mLastTouchY = i2;
                this.mDragging = this.mListener.onDragStart(v, this);
                return this.mDragging;
            default:
        }
        return i4;
    }
}
