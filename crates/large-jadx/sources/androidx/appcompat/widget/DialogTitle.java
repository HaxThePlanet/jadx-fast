package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import d.a.j;

/* loaded from: classes.dex */
public class DialogTitle extends androidx.appcompat.widget.AppCompatTextView {
    public DialogTitle(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onMeasure(int i, int i2) {
        Layout ellipsisCount;
        int styledAttributes;
        int dimensionPixelSize;
        int[] iArr;
        int i3;
        int i4;
        super.onMeasure(i, i2);
        ellipsisCount = getLayout();
        styledAttributes = ellipsisCount.getLineCount();
        ellipsisCount = 0;
        setSingleLine(ellipsisCount);
        setMaxLines(2);
        styledAttributes = getContext().obtainStyledAttributes(0, j.J2, 16842817, 16973892);
        dimensionPixelSize = styledAttributes.getDimensionPixelSize(j.K2, ellipsisCount);
        if (ellipsisCount != null && styledAttributes > 0 && ellipsisCount.getEllipsisCount(styledAttributes--) > 0 && dimensionPixelSize != 0) {
            styledAttributes = ellipsisCount.getLineCount();
            if (styledAttributes > 0) {
                if (ellipsisCount.getEllipsisCount(styledAttributes--) > 0) {
                    ellipsisCount = 0;
                    setSingleLine(ellipsisCount);
                    setMaxLines(2);
                    styledAttributes = getContext().obtainStyledAttributes(0, j.J2, 16842817, 16973892);
                    dimensionPixelSize = styledAttributes.getDimensionPixelSize(j.K2, ellipsisCount);
                    if (dimensionPixelSize != 0) {
                        setTextSize(ellipsisCount, (float)dimensionPixelSize);
                    }
                    styledAttributes.recycle();
                    super.onMeasure(i, i2);
                }
            }
        }
    }
}
