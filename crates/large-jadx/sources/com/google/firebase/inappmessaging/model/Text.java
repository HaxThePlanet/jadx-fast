package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto.Text;

/* loaded from: classes2.dex */
public class Text {

    private final String hexColor;
    private final String text;

    public static class Builder {

        private String hexColor;
        private String text;
        public com.google.firebase.inappmessaging.model.Text build() {
            if (TextUtils.isEmpty(this.hexColor)) {
            } else {
                Text text = new Text(this.text, this.hexColor, 0);
                return text;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Text model must have a color");
            throw illegalArgumentException;
        }

        public com.google.firebase.inappmessaging.model.Text.Builder setHexColor(String string) {
            this.hexColor = string;
            return this;
        }

        public com.google.firebase.inappmessaging.model.Text.Builder setText(MessagesProto.Text messagesProto$Text) {
            setText(text.getText());
            setHexColor(text.getHexColor());
            return this;
        }

        public com.google.firebase.inappmessaging.model.Text.Builder setText(String string) {
            this.text = string;
            return this;
        }
    }
    private Text(String string, String string2) {
        super();
        this.text = string;
        this.hexColor = string2;
    }

    Text(String string, String string2, com.google.firebase.inappmessaging.model.Text.1 text$13) {
        super(string, string2);
    }

    public static com.google.firebase.inappmessaging.model.Text.Builder builder() {
        Text.Builder builder = new Text.Builder();
        return builder;
    }

    public boolean equals(Object object) {
        String equals;
        String text;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof Text) {
            return i3;
        }
        if (hashCode() != (Text)object.hashCode()) {
            return i3;
        }
        equals = this.text;
        if (equals == null) {
            if (object.text == null && equals != null && !equals.equals(object.text)) {
                if (equals != null) {
                    if (!equals.equals(object.text)) {
                    }
                }
            }
            return i3;
        } else {
        }
        if (this.hexColor.equals(object.hexColor)) {
            return i;
        }
        return i3;
    }

    public String getHexColor() {
        return this.hexColor;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        int i2;
        int i;
        String text = this.text;
        if (text != null) {
            i3 += i;
        } else {
            i2 = this.hexColor.hashCode();
        }
        return i2;
    }
}
