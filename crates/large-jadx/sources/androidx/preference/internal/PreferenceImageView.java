package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import androidx.preference.f;

/* loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    private int a;
    private int b;
    public PreferenceImageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int i = Integer.MAX_VALUE;
        this.a = i;
        this.b = i;
        final TypedArray obj4 = context.obtainStyledAttributes(attributeSet2, f.v0, i3, 0);
        setMaxWidth(obj4.getDimensionPixelSize(f.x0, i));
        setMaxHeight(obj4.getDimensionPixelSize(f.w0, i));
        obj4.recycle();
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.b;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.a;
    }

    @Override // android.widget.ImageView
    protected void onMeasure(int i, int i2) {
        int size;
        int maxHeight;
        int obj6;
        int obj7;
        int mode = View.MeasureSpec.getMode(i);
        final int i3 = Integer.MAX_VALUE;
        final int i4 = Integer.MIN_VALUE;
        if (mode != i4) {
            maxHeight = getMaxWidth();
            if (mode == 0 && maxHeight != i3) {
                maxHeight = getMaxWidth();
                if (maxHeight != i3) {
                    if (maxHeight >= View.MeasureSpec.getSize(i)) {
                        if (mode == 0) {
                            obj6 = View.MeasureSpec.makeMeasureSpec(maxHeight, i4);
                        }
                    } else {
                    }
                }
            }
        } else {
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != i4) {
            maxHeight = getMaxHeight();
            if (mode2 == 0 && maxHeight != i3) {
                maxHeight = getMaxHeight();
                if (maxHeight != i3) {
                    if (maxHeight >= View.MeasureSpec.getSize(i2)) {
                        if (mode2 == 0) {
                            obj7 = View.MeasureSpec.makeMeasureSpec(maxHeight, i4);
                        }
                    } else {
                    }
                }
            }
        } else {
        }
        super.onMeasure(obj6, obj7);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i) {
        this.b = i;
        super.setMaxHeight(i);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i) {
        this.a = i;
        super.setMaxWidth(i);
    }
}
