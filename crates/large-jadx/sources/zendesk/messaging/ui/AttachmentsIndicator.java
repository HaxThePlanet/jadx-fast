package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import zendesk.commonui.d;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;
import zendesk.messaging.R.string;

/* loaded from: classes3.dex */
public class AttachmentsIndicator extends FrameLayout {

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
        AttachmentsIndicator.COUNT_THRESHOLD_TEXT = stringBuilder.toString();
    }

    public AttachmentsIndicator(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init(context);
    }

    static String getContentDescriptionForAttachmentButton(Context context, int i2) {
        String str;
        int zui_attachment_indicator_n_attachments_selected_accessibility;
        int i;
        String obj4;
        int obj5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(R.string.zui_attachment_indicator_accessibility));
        stringBuilder.append(". ");
        if (i2 == 0) {
            stringBuilder.append(context.getString(R.string.zui_attachment_indicator_no_attachments_selected_accessibility));
        } else {
            str = 1;
            if (i2 == str) {
                stringBuilder.append(context.getString(R.string.zui_attachment_indicator_one_attachments_selected_accessibility));
            } else {
                str = new Object[str];
                str[0] = Integer.valueOf(i2);
                stringBuilder.append(context.getString(R.string.zui_attachment_indicator_n_attachments_selected_accessibility, str));
            }
        }
        return stringBuilder.toString();
    }

    @Override // android.widget.FrameLayout
    void enableActiveState(boolean z) {
        int obj3;
        obj3 = z ? this.colorActive : this.colorInactive;
        d.c(obj3, this.attachmentsIndicatorIcon.getDrawable(), this.attachmentsIndicatorIcon);
    }

    @Override // android.widget.FrameLayout
    int getAttachmentsCount() {
        return this.attachmentsCount;
    }

    @Override // android.widget.FrameLayout
    void init(Context context) {
        FrameLayout.inflate(context, R.layout.zui_view_attachments_indicator, this);
        if (isInEditMode()) {
        }
        this.attachmentsIndicatorIcon = (ImageView)findViewById(R.id.attachments_indicator_icon);
        this.attachmentsIndicatorBottomBorder = findViewById(R.id.attachments_indicator_bottom_border);
        this.attachmentsIndicatorCounter = (TextView)findViewById(R.id.attachments_indicator_counter);
        this.colorActive = d.e(R.attr.colorPrimary, context, R.color.zui_color_primary);
        this.colorInactive = d.b(R.color.zui_attachment_indicator_color_inactive, context);
        (GradientDrawable)(LayerDrawable)this.attachmentsIndicatorCounter.getBackground().findDrawableByLayerId(R.id.inner_circle).setColor(this.colorActive);
        setContentDescription(AttachmentsIndicator.getContentDescriptionForAttachmentButton(getContext(), this.attachmentsCount));
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
        int zui_attachment_indicator_counter_width_single_digit;
        this.attachmentsCount = i;
        int i3 = 9;
        zui_attachment_indicator_counter_width_single_digit = i > i3 ? R.dimen.zui_attachment_indicator_counter_width_double_digit : R.dimen.zui_attachment_indicator_counter_width_single_digit;
        android.view.ViewGroup.LayoutParams layoutParams = this.attachmentsIndicatorCounter.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(zui_attachment_indicator_counter_width_single_digit);
        this.attachmentsIndicatorCounter.setLayoutParams(layoutParams);
        if (i > i3) {
            cOUNT_THRESHOLD_TEXT = AttachmentsIndicator.COUNT_THRESHOLD_TEXT;
        } else {
            cOUNT_THRESHOLD_TEXT = String.valueOf(i);
        }
        this.attachmentsIndicatorCounter.setText(cOUNT_THRESHOLD_TEXT);
        i2 = i > 0 ? 1 : 0;
        setCounterVisible(i2);
        setBottomBorderVisible(i2);
        enableActiveState(i2);
        setContentDescription(AttachmentsIndicator.getContentDescriptionForAttachmentButton(getContext(), i));
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
