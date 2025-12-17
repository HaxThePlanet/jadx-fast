package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.commonui.d;
import zendesk.messaging.R.color;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class AgentMessageView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.AgentMessageView.State> {

    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private View labelContainer;
    private TextView labelField;
    private TextView textField;

    static class State {

        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean isBot;
        private final String label;
        private final String message;
        private final zendesk.messaging.ui.MessagingCellProps props;
        public State(zendesk.messaging.ui.MessagingCellProps messagingCellProps, String string2, String string3, boolean z4, zendesk.messaging.ui.AvatarState avatarState5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
            super();
            this.props = messagingCellProps;
            this.message = string2;
            this.label = string3;
            this.isBot = z4;
            this.avatarState = avatarState5;
            this.avatarStateRenderer = avatarStateRenderer6;
        }

        zendesk.messaging.ui.AvatarState getAvatarState() {
            return this.avatarState;
        }

        public zendesk.messaging.ui.AvatarStateRenderer getAvatarStateRenderer() {
            return this.avatarStateRenderer;
        }

        String getLabel() {
            return this.label;
        }

        String getMessage() {
            return this.message;
        }

        zendesk.messaging.ui.MessagingCellProps getProps() {
            return this.props;
        }

        boolean isBot() {
            return this.isBot;
        }
    }
    public AgentMessageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        final int i = 0;
        setOrientation(i);
        LinearLayout.inflate(getContext(), R.layout.zui_view_text_response_content, this);
        setClickable(i);
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.textField = (TextView)findViewById(R.id.zui_agent_message_cell_text_field);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
        this.labelField.setTextColor(d.b(R.color.zui_text_color_dark_secondary, getContext()));
        this.textField.setTextColor(d.b(R.color.zui_text_color_dark_primary, getContext()));
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((AgentMessageView.State)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.AgentMessageView.State agentMessageView$State) {
        int i;
        this.textField.setText(state.getMessage());
        this.textField.requestLayout();
        this.labelField.setText(state.getLabel());
        i = state.isBot() ? 0 : 8;
        this.botLabel.setVisibility(i);
        state.getAvatarStateRenderer().render(state.getAvatarState(), this.avatarView);
        state.getProps().apply(this, this.labelContainer, this.avatarView);
    }
}
