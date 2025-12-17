package zendesk.support.request;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import f.g.d.a;
import f.g.d.c;
import f.g.d.f;
import f.g.d.h;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
class ViewCellAttachmentMenuItem extends FrameLayout {

    private TextView badge;
    private View badgeContainer;
    private View shadow;
    public ViewCellAttachmentMenuItem(Context context) {
        super(context);
        viewInit();
    }

    public ViewCellAttachmentMenuItem(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        viewInit();
    }

    public ViewCellAttachmentMenuItem(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        viewInit();
    }

    private void bindViews() {
        this.badgeContainer = findViewById(f.x);
        this.badge = (TextView)findViewById(f.w);
        this.shadow = findViewById(f.y);
    }

    private void tintBadge() {
        UiUtils.setTint(UiUtils.themeAttributeToColor(a.a, getContext(), c.A), this.badge.getBackground(), this.badge);
    }

    private void viewInit() {
        int sDK_INT;
        FrameLayout.inflate(getContext(), h.h, this);
        bindViews();
        tintBadge();
        int i2 = 0;
        if (Build.VERSION.SDK_INT < 21) {
            this.shadow.setVisibility(i2);
        }
        setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), i2));
    }

    @Override // android.widget.FrameLayout
    void setBadgeCount(int i) {
        Object badgeContainer;
        String valueOf;
        if (i > 0) {
            this.badgeContainer.setVisibility(0);
            this.badge.setText(String.valueOf(i));
        } else {
            this.badgeContainer.setVisibility(8);
        }
        setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), i));
    }
}
