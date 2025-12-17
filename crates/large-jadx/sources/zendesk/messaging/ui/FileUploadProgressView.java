package zendesk.messaging.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import zendesk.commonui.d;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;

/* loaded from: classes3.dex */
public class FileUploadProgressView extends ProgressBar {
    public FileUploadProgressView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setIndeterminate(true);
        getIndeterminateDrawable().setColorFilter(d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary), PorterDuff.Mode.SRC_IN);
    }
}
