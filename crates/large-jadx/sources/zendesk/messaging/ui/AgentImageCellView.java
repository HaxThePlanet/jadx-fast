package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.squareup.picasso.t;
import zendesk.messaging.Attachment;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class AgentImageCellView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.AgentImageCellView.State> {

    private zendesk.messaging.ui.AvatarView avatarView;
    private View botLabel;
    private int cornerRadius;
    private ImageView imageView;
    private View labelContainer;
    private TextView labelField;
    private final Drawable placeholder;

    static class State {

        private final Attachment attachment;
        private final zendesk.messaging.ui.AvatarState avatarState;
        private final zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer;
        private final boolean isBot;
        private final String label;
        private final t picasso;
        private final zendesk.messaging.ui.MessagingCellProps props;
        State(t t, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, Attachment attachment3, String string4, boolean z5, zendesk.messaging.ui.AvatarState avatarState6, zendesk.messaging.ui.AvatarStateRenderer avatarStateRenderer7) {
            super();
            this.picasso = t;
            this.props = messagingCellProps2;
            this.label = string4;
            this.isBot = z5;
            this.avatarState = avatarState6;
            this.avatarStateRenderer = avatarStateRenderer7;
        }

        public boolean equals(Object object) {
            int equals;
            boolean picasso;
            zendesk.messaging.ui.MessagingCellProps equals2;
            boolean equals3;
            Class<zendesk.messaging.ui.AgentImageCellView.State> obj;
            t picasso2;
            Class class;
            zendesk.messaging.ui.AvatarState obj5;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (AgentImageCellView.State.class != object.getClass()) {
                } else {
                    if (isBot() != (AgentImageCellView.State)object.isBot()) {
                        return i;
                    }
                    if (getPicasso() != null) {
                        if (!getPicasso().equals(object.getPicasso())) {
                            return i;
                        }
                    } else {
                        if (object.getPicasso() != null) {
                        }
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
                    if (getAttachment() != null) {
                    } else {
                        if (object.getAttachment() != null) {
                            return i;
                        }
                        if (getAvatarState() != null) {
                            equals = getAvatarState().equals(object.getAvatarState());
                        } else {
                            if (object.getAvatarState() == null) {
                            } else {
                                equals = i;
                            }
                        }
                        return equals;
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

        zendesk.messaging.ui.AvatarState getAvatarState() {
            return this.avatarState;
        }

        String getLabel() {
            return this.label;
        }

        t getPicasso() {
            return this.picasso;
        }

        zendesk.messaging.ui.MessagingCellProps getProps() {
            return this.props;
        }

        public int hashCode() {
            int i3;
            int i;
            int i4;
            int i2;
            i = 0;
            if (getPicasso() != null) {
                i3 = getPicasso().hashCode();
            } else {
                i3 = i;
            }
            if (getProps() != null) {
                i4 = getProps().hashCode();
            } else {
                i4 = i;
            }
            if (getLabel() != null) {
                i2 = getLabel().hashCode();
            } else {
                i2 = i;
            }
            if (getAttachment() != null) {
            } else {
                if (getAvatarState() != null) {
                    i = getAvatarState().hashCode();
                }
                return i13 += i;
            }
            getAttachment().hashCode();
            throw 0;
        }

        boolean isBot() {
            return this.isBot;
        }
    }
    public AgentImageCellView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        this.placeholder = a.f(getContext(), R.drawable.zui_background_agent_cell);
        init();
    }

    private void init() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.zui_view_agent_image_cell_content, this);
        this.cornerRadius = getResources().getDimensionPixelSize(R.dimen.zui_cell_bubble_corner_radius);
    }

    private void loadImageIntoImageView(zendesk.messaging.ui.AgentImageCellView.State agentImageCellView$State) {
        state.getPicasso();
        state.getAttachment().getUrl();
        throw 0;
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (AvatarView)findViewById(R.id.zui_agent_message_avatar);
        this.imageView = (ImageView)findViewById(R.id.zui_image_cell_image);
        this.labelContainer = findViewById(R.id.zui_cell_status_view);
        this.labelField = (TextView)findViewById(R.id.zui_cell_label_text_field);
        this.botLabel = findViewById(R.id.zui_cell_label_supplementary_label);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((AgentImageCellView.State)object);
        throw 0;
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.AgentImageCellView.State agentImageCellView$State) {
        loadImageIntoImageView(state);
        throw 0;
    }
}
