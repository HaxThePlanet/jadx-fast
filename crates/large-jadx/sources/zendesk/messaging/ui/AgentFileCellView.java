package zendesk.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import zendesk.commonui.d;
import zendesk.messaging.Attachment;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class AgentFileCellView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.AgentFileCellView.State> {

    private ImageView appIcon;
    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private LinearLayout bubble;
    private Drawable defaultAppIcon;
    private TextView fileDescriptor;
    private TextView fileName;
    private View labelContainer;
    private TextView labelField;

    static class State {

        private final Attachment attachment;
        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean isBot;
        private final String label;
        private final zendesk.messaging.ui.MessagingCellProps props;
        State(Attachment attachment, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, String string3, boolean z4, zendesk.messaging.ui.AvatarState avatarState5, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer6) {
            super();
            this.props = messagingCellProps2;
            this.label = string3;
            this.isBot = z4;
            this.avatarState = avatarState5;
            this.avatarStateRenderer = avatarStateRenderer6;
        }

        public boolean equals(Object object) {
            int equals3;
            boolean equals2;
            String equals;
            Class<zendesk.messaging.ui.AgentFileCellView.State> obj;
            zendesk.messaging.ui.MessagingCellProps props;
            Class class;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (AgentFileCellView.State.class != object.getClass()) {
                } else {
                    if (isBot() != (AgentFileCellView.State)object.isBot()) {
                        return i;
                    }
                    if (getAttachment() != null) {
                    } else {
                        if (object.getAttachment() != null) {
                            return i;
                        }
                        if (getProps() != null) {
                            if (!getProps().equals(object.getProps())) {
                                return i;
                            }
                        } else {
                            if (object.getProps() != null) {
                            }
                        }
                        if (getLabel() != null) {
                            if (!getLabel().equals(object.getLabel())) {
                                return i;
                            }
                        } else {
                            if (object.getLabel() != null) {
                            }
                        }
                        zendesk.messaging.ui.AvatarState avatarState = this.avatarState;
                        zendesk.messaging.ui.AvatarState obj5 = object.avatarState;
                        if (avatarState != null) {
                            equals3 = avatarState.equals(obj5);
                        } else {
                            if (obj5 == null) {
                            } else {
                                equals3 = i;
                            }
                        }
                        return equals3;
                    }
                }
                getAttachment().equals(object.getAttachment());
                throw 0;
            }
            return i;
        }

        public Attachment getAttachment() {
            return this.attachment;
        }

        String getLabel() {
            return this.label;
        }

        zendesk.messaging.ui.MessagingCellProps getProps() {
            return this.props;
        }

        public int hashCode() {
            int i3;
            int i2;
            int i;
            if (getAttachment() != null) {
            } else {
                i = 0;
                if (getProps() != null) {
                    i3 = getProps().hashCode();
                } else {
                    i3 = i;
                }
                if (getLabel() != null) {
                    i2 = getLabel().hashCode();
                } else {
                    i2 = i;
                }
                zendesk.messaging.ui.AvatarState avatarState = this.avatarState;
                if (avatarState != null) {
                    i = avatarState.hashCode();
                }
                return i12 += i;
            }
            getAttachment().hashCode();
            throw 0;
        }

        boolean isBot() {
            return this.isBot;
        }
    }
    public AgentFileCellView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.zui_view_agent_file_cell_content, this);
    }

    private void setBubbleClickListeners(zendesk.messaging.ui.AgentFileCellView.State agentFileCellView$State) {
        AgentFileCellView.1 anon = new AgentFileCellView.1(this, state);
        this.bubble.setOnClickListener(anon);
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.bubble = (LinearLayout)findViewById(R.id.zui_cell_file_container);
        this.fileName = (TextView)findViewById(R.id.zui_file_cell_name);
        this.fileDescriptor = (TextView)findViewById(R.id.zui_cell_file_description);
        this.appIcon = (ImageView)findViewById(R.id.zui_cell_file_app_icon);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
        this.defaultAppIcon = a.f(getContext(), R.drawable.zui_ic_insert_drive_file);
        d.c(d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary), this.defaultAppIcon, this.appIcon);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((AgentFileCellView.State)object);
        throw 0;
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.AgentFileCellView.State agentFileCellView$State) {
        state.getAttachment().getName();
        throw 0;
    }
}
