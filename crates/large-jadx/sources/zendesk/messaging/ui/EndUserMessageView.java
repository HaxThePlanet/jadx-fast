package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.commonui.d;
import zendesk.messaging.MessagingItem.Query.Status;
import zendesk.messaging.R.color;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class EndUserMessageView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.EndUserCellMessageState> {

    private int errorTextColor;
    private TextView label;
    private zendesk.messaging.ui.MessageStatusView statusView;
    private int textColor;
    private TextView textField;
    public EndUserMessageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(8388693);
        LinearLayout.inflate(getContext(), R.layout.zui_view_end_user_message_cell_content, this);
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.textField = (TextView)findViewById(R.id.zui_end_user_message_cell_text_field);
        this.statusView = (MessageStatusView)findViewById(R.id.zui_cell_status_view);
        this.label = (TextView)findViewById(R.id.zui_cell_label_message);
        Context context = getContext();
        this.errorTextColor = d.b(R.color.zui_text_color_dark_primary, context);
        this.textColor = d.b(R.color.zui_text_color_light_primary, context);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((EndUserCellMessageState)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.EndUserCellMessageState endUserCellMessageState) {
        int errorTextColor;
        int i;
        UtilsEndUserCellView.setClickListener(endUserCellMessageState, this);
        UtilsEndUserCellView.setLongClickListener(endUserCellMessageState, this);
        UtilsEndUserCellView.setLabelErrorMessage(endUserCellMessageState, this.label, getContext());
        UtilsEndUserCellView.setCellBackground(endUserCellMessageState, this.textField);
        MessagingItem.Query.Status status = endUserCellMessageState.getStatus();
        errorTextColor = UtilsEndUserCellView.isFailedCell(endUserCellMessageState) ? this.errorTextColor : this.textColor;
        this.textField.setTextColor(errorTextColor);
        this.textField.setText(endUserCellMessageState.getMessage());
        i = status == MessagingItem.Query.Status.DELIVERED ? 1 : 0;
        this.textField.setTextIsSelectable(i);
        this.textField.requestLayout();
        this.statusView.setStatus(status);
        endUserCellMessageState.getProps().apply(this, this.statusView);
    }
}
