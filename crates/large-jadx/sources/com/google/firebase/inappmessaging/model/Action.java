package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto.Button;

/* loaded from: classes2.dex */
public class Action {

    private final String actionUrl;
    private final com.google.firebase.inappmessaging.model.Button button;

    public static class Builder {

        private String actionUrl;
        private com.google.firebase.inappmessaging.model.Button button;
        public com.google.firebase.inappmessaging.model.Action build() {
            Action action = new Action(this.actionUrl, this.button, 0);
            return action;
        }

        public com.google.firebase.inappmessaging.model.Action.Builder setActionUrl(String string) {
            if (!TextUtils.isEmpty(string)) {
                this.actionUrl = string;
            }
            return this;
        }

        public com.google.firebase.inappmessaging.model.Action.Builder setButton(MessagesProto.Button messagesProto$Button) {
            Button.Builder builder = new Button.Builder();
            builder.setButtonHexColor(button.getButtonHexColor());
            builder.setText(button.getText());
            return this;
        }

        public com.google.firebase.inappmessaging.model.Action.Builder setButton(com.google.firebase.inappmessaging.model.Button button) {
            this.button = button;
            return this;
        }
    }
    private Action(String string, com.google.firebase.inappmessaging.model.Button button2) {
        super();
        this.actionUrl = string;
        this.button = button2;
    }

    Action(String string, com.google.firebase.inappmessaging.model.Button button2, com.google.firebase.inappmessaging.model.Action.1 action$13) {
        super(string, button2);
    }

    public static com.google.firebase.inappmessaging.model.Action.Builder builder() {
        Action.Builder builder = new Action.Builder();
        return builder;
    }

    public boolean equals(Object object) {
        String actionUrl;
        String actionUrl2;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof Action) {
            return i3;
        }
        if (hashCode() != (Action)object.hashCode()) {
            return i3;
        }
        actionUrl = this.actionUrl;
        if (actionUrl == null) {
            if (object.actionUrl == null && actionUrl != null && !actionUrl.equals(object.actionUrl)) {
                if (actionUrl != null) {
                    if (!actionUrl.equals(object.actionUrl)) {
                    }
                }
            }
            return i3;
        } else {
        }
        com.google.firebase.inappmessaging.model.Button button = this.button;
        if (button == null) {
            if (object.button != null && button != null && button.equals(object.button)) {
                if (button != null) {
                    if (button.equals(object.button)) {
                    }
                }
            }
            return i;
        } else {
        }
        return i3;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public com.google.firebase.inappmessaging.model.Button getButton() {
        return this.button;
    }

    public int hashCode() {
        int i2;
        int i;
        String actionUrl = this.actionUrl;
        if (actionUrl != null) {
            i2 = actionUrl.hashCode();
        } else {
            i2 = i;
        }
        final com.google.firebase.inappmessaging.model.Button button = this.button;
        if (button != null) {
            i = button.hashCode();
        }
        return i2 += i;
    }
}
