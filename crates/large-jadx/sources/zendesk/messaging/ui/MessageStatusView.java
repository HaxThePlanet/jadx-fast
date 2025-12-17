package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.g;
import zendesk.commonui.d;
import zendesk.messaging.MessagingItem.Query.Status;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.drawable;

/* loaded from: classes3.dex */
public class MessageStatusView extends AppCompatImageView {

    private int deliveredIconColor;
    private int failedIconColor;
    private int pendingIconColor;
    public MessageStatusView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        this.deliveredIconColor = d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary);
        this.failedIconColor = d.b(R.color.zui_error_text_color, getContext());
        this.pendingIconColor = d.b(R.color.zui_cell_pending_indicator_color, getContext());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setStatus(MessagingItem.Query.Status messagingItem$Query$Status) {
        int i;
        int obj2;
        obj2 = MessageStatusView.1.$SwitchMap$zendesk$messaging$MessagingItem$Query$Status[status.ordinal()];
        if (obj2 != 1 && obj2 != 2) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                    if (obj2 != 4) {
                        setImageResource(0);
                    } else {
                        g.c(this, ColorStateList.valueOf(this.pendingIconColor));
                        setImageResource(R.drawable.zui_ic_status_pending);
                    }
                } else {
                    g.c(this, ColorStateList.valueOf(this.deliveredIconColor));
                    setImageResource(R.drawable.zui_ic_status_sent);
                }
            } else {
                g.c(this, ColorStateList.valueOf(this.failedIconColor));
                setImageResource(R.drawable.zui_ic_status_fail);
            }
        } else {
        }
    }
}
