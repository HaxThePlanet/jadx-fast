package zendesk.messaging.ui;

import f.g.e.a;
import java.util.List;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.ConnectionState;
import zendesk.messaging.MessagingItem;

/* loaded from: classes3.dex */
public class MessagingState {

    final AttachmentSettings attachmentSettings;
    final ConnectionState connectionState;
    final boolean enabled;
    final String hint;
    final int keyboardInputType;
    final List<MessagingItem> messagingItems;
    final boolean progressBarVisible;
    final zendesk.messaging.ui.MessagingState.TypingState typingState;

    public static class Builder {

        private AttachmentSettings attachmentSettings;
        private ConnectionState connectionState;
        private boolean enabled;
        private String hint;
        private int keyboardInputType = 131073;
        private List<MessagingItem> messagingItems;
        private boolean progressBarVisible;
        private zendesk.messaging.ui.MessagingState.TypingState typingState;
        public Builder() {
            super();
            MessagingState.TypingState typingState = new MessagingState.TypingState(0);
            this.typingState = typingState;
            this.connectionState = ConnectionState.DISCONNECTED;
            int i = 131073;
        }

        public Builder(zendesk.messaging.ui.MessagingState messagingState) {
            super();
            MessagingState.TypingState typingState = new MessagingState.TypingState(0);
            this.typingState = typingState;
            this.connectionState = ConnectionState.DISCONNECTED;
            int i = 131073;
            this.messagingItems = messagingState.messagingItems;
            this.enabled = messagingState.enabled;
            this.typingState = messagingState.typingState;
            this.connectionState = messagingState.connectionState;
            this.hint = messagingState.hint;
            this.attachmentSettings = messagingState.attachmentSettings;
            this.keyboardInputType = messagingState.keyboardInputType;
        }

        public zendesk.messaging.ui.MessagingState build() {
            super(a.e(this.messagingItems), this.progressBarVisible, this.enabled, this.typingState, this.connectionState, this.hint, this.attachmentSettings, this.keyboardInputType, 0);
            return messagingState2;
        }

        public zendesk.messaging.ui.MessagingState.Builder withAttachmentSettings(AttachmentSettings attachmentSettings) {
            this.attachmentSettings = attachmentSettings;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withComposerHint(String string) {
            this.hint = string;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withConnectionState(ConnectionState connectionState) {
            this.connectionState = connectionState;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withEnabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withKeyboardInputType(int i) {
            this.keyboardInputType = i;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withMessagingItems(List<MessagingItem> list) {
            this.messagingItems = list;
            return this;
        }

        public zendesk.messaging.ui.MessagingState.Builder withTypingIndicatorState(zendesk.messaging.ui.MessagingState.TypingState messagingState$TypingState) {
            this.typingState = typingState;
            return this;
        }
    }

    public static class TypingState {

        private final AgentDetails agentDetails;
        private final boolean isTyping;
        public TypingState(boolean z) {
            super(z, 0);
        }

        public TypingState(boolean z, AgentDetails agentDetails2) {
            super();
            this.isTyping = z;
            this.agentDetails = agentDetails2;
        }

        public AgentDetails getAgentDetails() {
            return this.agentDetails;
        }

        public boolean isTyping() {
            return this.isTyping;
        }
    }
    private MessagingState(List<MessagingItem> list, boolean z2, boolean z3, zendesk.messaging.ui.MessagingState.TypingState messagingState$TypingState4, ConnectionState connectionState5, String string6, AttachmentSettings attachmentSettings7, int i8) {
        super();
        this.messagingItems = list;
        this.progressBarVisible = z2;
        this.enabled = z3;
        this.typingState = typingState4;
        this.connectionState = connectionState5;
        this.hint = string6;
        this.attachmentSettings = attachmentSettings7;
        this.keyboardInputType = i8;
    }

    MessagingState(List list, boolean z2, boolean z3, zendesk.messaging.ui.MessagingState.TypingState messagingState$TypingState4, ConnectionState connectionState5, String string6, AttachmentSettings attachmentSettings7, int i8, zendesk.messaging.ui.MessagingState.1 messagingState$19) {
        super(list, z2, z3, typingState4, connectionState5, string6, attachmentSettings7, i8);
    }

    public zendesk.messaging.ui.MessagingState.Builder newBuilder() {
        MessagingState.Builder builder = new MessagingState.Builder(this);
        return builder;
    }
}
