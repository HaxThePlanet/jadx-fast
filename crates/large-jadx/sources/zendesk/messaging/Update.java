package zendesk.messaging;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Update {

    private final String type;

    public static abstract class Action extends zendesk.messaging.Update {
        public Action(String string) {
            super(string);
        }
    }

    public static abstract class State extends zendesk.messaging.Update {
        public State(String string) {
            super(string);
        }
    }

    public static class ApplyMenuItems extends zendesk.messaging.Update.State {

        private final List<zendesk.messaging.MenuItem> menuItems;
        public ApplyMenuItems(zendesk.messaging.MenuItem... menuItemArr) {
            List obj2;
            super("apply_menu_items");
            if (menuItemArr == null) {
                obj2 = Collections.emptyList();
            } else {
                obj2 = Arrays.asList(menuItemArr);
            }
            this.menuItems = obj2;
        }

        public List<zendesk.messaging.MenuItem> getMenuItems() {
            return this.menuItems;
        }
    }

    public static class ShowBanner extends zendesk.messaging.Update.State {

        private final zendesk.messaging.Banner banner;
        @Override // zendesk.messaging.Update$State
        public zendesk.messaging.Banner getBanner() {
            return this.banner;
        }
    }

    public static class ShowDialog extends zendesk.messaging.Update.State {

        private final zendesk.messaging.DialogContent dialogContent;
        @Override // zendesk.messaging.Update$State
        public zendesk.messaging.DialogContent getDialogContent() {
            return this.dialogContent;
        }
    }
    public Update(String string) {
        super();
        this.type = string;
    }

    public String getType() {
        return this.type;
    }
}
