package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class ActionOptionsView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.ActionOptionsView.State> {

    private ViewGroup actionOptionsContainer;
    private TextView actionOptionsHeader;
    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private View labelContainer;
    private TextView labelField;

    static class ActionOptionState {

        private final String actionOptionName;
        private final View.OnClickListener onClickListener;
        ActionOptionState(String string, View.OnClickListener view$OnClickListener2) {
            super();
            this.actionOptionName = string;
            this.onClickListener = onClickListener2;
        }

        String getActionOptionName() {
            return this.actionOptionName;
        }

        View.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }
    }

    static class State {

        private final List<zendesk.messaging.ui.ActionOptionsView.ActionOptionState> actionOptions;
        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean enabled;
        private final String header;
        private boolean isBot;
        private final String label;
        private final zendesk.messaging.ui.MessagingCellProps props;
        public State(String string, String string2, boolean z3, zendesk.messaging.ui.MessagingCellProps messagingCellProps4, List<zendesk.messaging.ui.ActionOptionsView.ActionOptionState> list5, boolean z6, zendesk.messaging.ui.AvatarState avatarState7, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer8) {
            super();
            this.header = string;
            this.label = string2;
            this.isBot = z3;
            this.props = messagingCellProps4;
            this.actionOptions = list5;
            this.enabled = z6;
            this.avatarState = avatarState7;
            this.avatarStateRenderer = avatarStateRenderer8;
        }

        List<zendesk.messaging.ui.ActionOptionsView.ActionOptionState> getActionOptions() {
            return this.actionOptions;
        }

        zendesk.messaging.ui.AvatarState getAvatarState() {
            return this.avatarState;
        }

        public zendesk.messaging.ui.AvatarStateRenderer getAvatarStateRenderer() {
            return this.avatarStateRenderer;
        }

        String getHeader() {
            return this.header;
        }

        String getLabel() {
            return this.label;
        }

        zendesk.messaging.ui.MessagingCellProps getProps() {
            return this.props;
        }

        boolean isBot() {
            return this.isBot;
        }

        boolean isEnabled() {
            return this.enabled;
        }
    }
    public ActionOptionsView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.zui_view_action_options_content, this);
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.actionOptionsHeader = (TextView)findViewById(R.id.zui_answer_bot_action_options_header);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
        this.actionOptionsContainer = (ViewGroup)findViewById(R.id.zui_cell_action_options_container);
    }

    private void updateActionOptions(List<zendesk.messaging.ui.ActionOptionsView.ActionOptionState> list, boolean z2) {
        ViewGroup actionOptionsContainer;
        int zui_background_cell_options_footer;
        View inflate;
        int i;
        String actionOptionName;
        this.actionOptionsContainer.removeAllViews();
        this.actionOptionsContainer.addView(this.actionOptionsHeader);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.zui_view_action_option, this.actionOptionsContainer, false);
            (TextView)inflate.findViewById(R.id.zui_action_option_name).setText((ActionOptionsView.ActionOptionState)next2.getActionOptionName());
            inflate.setOnClickListener(next2.getOnClickListener());
            if (list.indexOf(next2) == size--) {
            }
            inflate.setEnabled(z2);
            this.actionOptionsContainer.addView(inflate);
            inflate.setBackgroundResource(R.drawable.zui_background_cell_options_footer);
        }
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((ActionOptionsView.State)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.ActionOptionsView.State actionOptionsView$State) {
        int i;
        this.actionOptionsHeader.setText(state.getHeader());
        this.labelField.setText(state.getLabel());
        i = state.isBot() ? 0 : 8;
        this.botLabel.setVisibility(i);
        updateActionOptions(state.getActionOptions(), state.isEnabled());
        state.getAvatarStateRenderer().render(state.getAvatarState(), this.avatarView);
        state.getProps().apply(this, this.labelContainer, this.avatarView);
    }
}
