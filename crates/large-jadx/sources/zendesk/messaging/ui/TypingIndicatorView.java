package zendesk.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.v.a.a.b;
import d.v.a.a.c;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class TypingIndicatorView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.TypingIndicatorView.State> {

    private final b animationLoopCallback;
    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private View labelContainer;
    private TextView labelField;
    private ImageView typingIndicator;

    static class State {

        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean isBot;
        private final String label;
        private final zendesk.messaging.ui.MessagingCellProps props;
        State(zendesk.messaging.ui.MessagingCellProps messagingCellProps, String string2, boolean z3, zendesk.messaging.ui.AvatarState avatarState4, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer5) {
            super();
            this.props = messagingCellProps;
            this.label = string2;
            this.isBot = z3;
            this.avatarState = avatarState4;
            this.avatarStateRenderer = avatarStateRenderer5;
        }

        zendesk.messaging.ui.AvatarState getAvatarState() {
            return this.avatarState;
        }

        zendesk.messaging.ui.AvatarStateRenderer getAvatarStateRenderer() {
            return this.avatarStateRenderer;
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
    }
    public TypingIndicatorView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        TypingIndicatorView.1 obj1 = new TypingIndicatorView.1(this);
        this.animationLoopCallback = obj1;
        init();
    }

    private void init() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.zui_view_typing_indicator_content, this);
    }

    private void startAnimatedDrawable() {
        Drawable drawable = this.typingIndicator.getDrawable();
        c.b(drawable, this.animationLoopCallback);
        (Animatable)drawable.start();
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
        this.typingIndicator = (ImageView)findViewById(R.id.zui_cell_typing_indicator_image);
        startAnimatedDrawable();
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((TypingIndicatorView.State)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.TypingIndicatorView.State typingIndicatorView$State) {
        Object labelField;
        String label;
        int i;
        if (state.getLabel() != null) {
            this.labelField.setText(state.getLabel());
        }
        i = state.isBot() ? 0 : 8;
        this.botLabel.setVisibility(i);
        state.getAvatarStateRenderer().render(state.getAvatarState(), this.avatarView);
        state.getProps().apply(this, this.labelContainer, this.avatarView);
    }
}
