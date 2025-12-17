package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto.Text;

/* loaded from: classes2.dex */
public class Button {

    private final String buttonHexColor;
    private final com.google.firebase.inappmessaging.model.Text text;

    public static class Builder {

        private String buttonHexColor;
        private com.google.firebase.inappmessaging.model.Text text;
        public com.google.firebase.inappmessaging.model.Button build() {
            if (TextUtils.isEmpty(this.buttonHexColor)) {
            } else {
                com.google.firebase.inappmessaging.model.Text text = this.text;
                if (text == null) {
                } else {
                    Button button = new Button(text, this.buttonHexColor, 0);
                    return button;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Button model must have text");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Button model must have a color");
            throw illegalArgumentException2;
        }

        public com.google.firebase.inappmessaging.model.Button.Builder setButtonHexColor(String string) {
            this.buttonHexColor = string;
            return this;
        }

        public com.google.firebase.inappmessaging.model.Button.Builder setText(MessagesProto.Text messagesProto$Text) {
            Text.Builder builder = new Text.Builder();
            builder.setText(text);
            this.text = builder.build();
            return this;
        }

        public com.google.firebase.inappmessaging.model.Button.Builder setText(com.google.firebase.inappmessaging.model.Text text) {
            this.text = text;
            return this;
        }
    }
    private Button(com.google.firebase.inappmessaging.model.Text text, String string2) {
        super();
        this.text = text;
        this.buttonHexColor = string2;
    }

    Button(com.google.firebase.inappmessaging.model.Text text, String string2, com.google.firebase.inappmessaging.model.Button.1 button$13) {
        super(text, string2);
    }

    public static com.google.firebase.inappmessaging.model.Button.Builder builder() {
        Button.Builder builder = new Button.Builder();
        return builder;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof Button) {
            return i3;
        }
        if (hashCode() != (Button)object.hashCode()) {
            return i3;
        }
        if (!this.text.equals(object.text)) {
            return i3;
        }
        if (this.buttonHexColor.equals(object.buttonHexColor)) {
            return i;
        }
        return i3;
    }

    public String getButtonHexColor() {
        return this.buttonHexColor;
    }

    public com.google.firebase.inappmessaging.model.Text getText() {
        return this.text;
    }

    public int hashCode() {
        return i += i3;
    }
}
