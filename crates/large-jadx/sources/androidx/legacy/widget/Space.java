package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

/* loaded from: classes.dex */
@Deprecated
public class Space extends View {
    @Deprecated
    public Space(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet2, int i3) {
        int obj1;
        super(context, attributeSet2, i3);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int a(int i, int i2) {
        int i3;
        int obj2;
        final int mode = View.MeasureSpec.getMode(i2);
        final int obj3 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
            } else {
                obj2 = obj3;
            }
        } else {
            obj2 = Math.min(i, obj3);
        }
        return obj2;
    }

    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Deprecated
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(Space.a(getSuggestedMinimumWidth(), i), Space.a(getSuggestedMinimumHeight(), i2));
    }
}
