package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.a;
import f.g.d.a;
import f.g.d.c;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
public class ViewAttachmentsIndicator extends FrameLayout {

    private static final int COUNT_THRESHOLD = 9;
    private static final String COUNT_THRESHOLD_TEXT;
    private int attachmentsCount;
    private View attachmentsIndicatorBottomBorder;
    private TextView attachmentsIndicatorCounter;
    private ImageView attachmentsIndicatorIcon;
    private int colorActive;
    private int colorInactive;
    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(9));
        stringBuilder.append("+");
        ViewAttachmentsIndicator.COUNT_THRESHOLD_TEXT = stringBuilder.toString();
    }

    public ViewAttachmentsIndicator(Context context) {
        super(context);
        init(context);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init(context);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        init(context);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        init(context);
    }

    @Override // android.widget.FrameLayout
    void enableActiveState(boolean z) {
        int obj2;
        obj2 = z ? this.colorActive : this.colorInactive;
        a.n(a.r(this.attachmentsIndicatorIcon.getDrawable()).mutate(), obj2);
        this.attachmentsIndicatorIcon.invalidate();
    }

    @Override // android.widget.FrameLayout
    int getAttachmentsCount() {
        return this.attachmentsCount;
    }

    @Override // android.widget.FrameLayout
    void init(Context context) {
        FrameLayout.inflate(context, h.r, this);
        if (isInEditMode()) {
        }
        this.attachmentsIndicatorIcon = (ImageView)findViewById(f.r);
        this.attachmentsIndicatorBottomBorder = findViewById(f.p);
        this.attachmentsIndicatorCounter = (TextView)findViewById(f.q);
        this.colorActive = UiUtils.themeAttributeToColor(a.b, context, c.A);
        this.colorInactive = UiUtils.resolveColor(c.x, context);
        (GradientDrawable)(LayerDrawable)this.attachmentsIndicatorCounter.getBackground().findDrawableByLayerId(f.s).setColor(this.colorActive);
        getContext().getString(j.N);
        setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), getAttachmentsCount()));
    }

    @Override // android.widget.FrameLayout
    void reset() {
        final int i = 0;
        setCounterVisible(i);
        setAttachmentsCount(i);
        setBottomBorderVisible(i);
        enableActiveState(i);
    }

    @Override // android.widget.FrameLayout
    void setAttachmentsCount(int i) {
        String cOUNT_THRESHOLD_TEXT;
        int i2;
        int obj5;
        this.attachmentsCount = i;
        int i3 = 9;
        i2 = i > i3 ? d.b : d.c;
        android.view.ViewGroup.LayoutParams layoutParams = this.attachmentsIndicatorCounter.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i2);
        this.attachmentsIndicatorCounter.setLayoutParams(layoutParams);
        if (i > i3) {
            cOUNT_THRESHOLD_TEXT = ViewAttachmentsIndicator.COUNT_THRESHOLD_TEXT;
        } else {
            cOUNT_THRESHOLD_TEXT = String.valueOf(i);
        }
        this.attachmentsIndicatorCounter.setText(cOUNT_THRESHOLD_TEXT);
        obj5 = i > 0 ? 1 : 0;
        setCounterVisible(obj5);
        setBottomBorderVisible(obj5);
        enableActiveState(obj5);
        setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), getAttachmentsCount()));
    }

    @Override // android.widget.FrameLayout
    void setBottomBorderVisible(boolean z) {
        int obj2;
        obj2 = z ? 0 : 4;
        this.attachmentsIndicatorBottomBorder.setVisibility(obj2);
    }

    @Override // android.widget.FrameLayout
    void setCounterVisible(boolean z) {
        int obj2;
        obj2 = z ? 0 : 4;
        this.attachmentsIndicatorCounter.setVisibility(obj2);
    }
}
