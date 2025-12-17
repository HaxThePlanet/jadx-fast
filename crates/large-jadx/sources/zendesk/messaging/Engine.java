package zendesk.messaging;

/* loaded from: classes3.dex */
public interface Engine {

    public interface ConversationOnGoingCallback {
        public abstract void onConversationOngoing(zendesk.messaging.Engine engine, boolean z2);
    }

    public static class TransferOptionDescription {

        private final String displayName;
        private final String engineId;
        public TransferOptionDescription(String string, String string2) {
            super();
            this.engineId = string;
            this.displayName = string2;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getEngineId() {
            return this.engineId;
        }
    }

    public interface UpdateObserver {
        public abstract void update(zendesk.messaging.Update update);
    }
    public abstract String getId();

    public abstract zendesk.messaging.Engine.TransferOptionDescription getTransferOptionDescription();

    public abstract void isConversationOngoing(zendesk.messaging.Engine.ConversationOnGoingCallback engine$ConversationOnGoingCallback);

    public abstract void onEvent(zendesk.messaging.Event event);

    public abstract boolean registerObserver(zendesk.messaging.Engine.UpdateObserver engine$UpdateObserver);

    public abstract void start(zendesk.messaging.MessagingApi messagingApi);

    public abstract void stop();

    public abstract boolean unregisterObserver(zendesk.messaging.Engine.UpdateObserver engine$UpdateObserver);
}
