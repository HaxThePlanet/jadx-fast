package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import f.g.c.a;
import zendesk.commonui.d;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.drawable;

/* loaded from: classes3.dex */
public class ResponseOptionView extends AppCompatTextView {
    public ResponseOptionView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        int arr;
        Object mutate;
        int str;
        int zui_cell_response_option_stroke_width;
        setBackgroundDrawable(a.f(getContext(), R.drawable.zui_background_response_option));
        arr = d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary);
        setTextColor(arr);
        mutate = getBackground().mutate();
        if (mutate instanceof GradientDrawable) {
            (GradientDrawable)mutate.setStroke((int)dimension, arr);
        } else {
            a.k("ResponseOptionView", "Unable to set stroke on background as background is not of type GradientDrawable", new Object[0]);
        }
    }
}
