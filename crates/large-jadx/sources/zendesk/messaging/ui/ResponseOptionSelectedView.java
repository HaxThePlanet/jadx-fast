package zendesk.messaging.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import zendesk.commonui.d;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.drawable;

/* loaded from: classes3.dex */
public class ResponseOptionSelectedView extends AppCompatTextView {
    public ResponseOptionSelectedView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setTextColor(a.d(getContext(), R.color.zui_color_white_100));
        setBackgroundDrawable(a.f(getContext(), R.drawable.zui_background_response_option_selected));
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary), PorterDuff.Mode.SRC_ATOP);
        getBackground().mutate().setColorFilter(porterDuffColorFilter);
    }
}
