package zendesk.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class SystemMessageView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.SystemMessageView.State> {

    private TextView systemMessage;

    static class State {

        private final zendesk.messaging.ui.MessagingCellProps props;
        private final String text;
        State(zendesk.messaging.ui.MessagingCellProps messagingCellProps, String string2) {
            super();
            this.props = messagingCellProps;
            this.text = string2;
        }

        static zendesk.messaging.ui.MessagingCellProps access$000(zendesk.messaging.ui.SystemMessageView.State systemMessageView$State) {
            return state.props;
        }

        public boolean equals(Object object) {
            boolean equals;
            boolean equals2;
            Class<zendesk.messaging.ui.SystemMessageView.State> obj;
            Object class;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (SystemMessageView.State.class != object.getClass()) {
                } else {
                    String text = this.text;
                    if (text != null) {
                        if (!text.equals(object.text)) {
                            return i;
                        }
                    } else {
                        if (object.text != null) {
                        }
                    }
                    zendesk.messaging.ui.MessagingCellProps props = this.props;
                    final zendesk.messaging.ui.MessagingCellProps obj5 = object.props;
                    if (props != null) {
                        equals = props.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals = i;
                        }
                    }
                }
                return equals;
            }
            return i;
        }

        public String getText() {
            return this.text;
        }

        public int hashCode() {
            int i;
            int i2;
            String text = this.text;
            if (text != null) {
                i = text.hashCode();
            } else {
                i = i2;
            }
            final zendesk.messaging.ui.MessagingCellProps props = this.props;
            if (props != null) {
                i2 = props.hashCode();
            }
            return i3 += i2;
        }
    }
    public SystemMessageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(1);
        LinearLayout.inflate(getContext(), R.layout.zui_view_system_message, this);
        this.systemMessage = (TextView)findViewById(R.id.zui_system_message_text);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((SystemMessageView.State)object);
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.SystemMessageView.State systemMessageView$State) {
        SystemMessageView.State.access$000(state).apply(this);
        this.systemMessage.setText(state.getText());
    }
}
