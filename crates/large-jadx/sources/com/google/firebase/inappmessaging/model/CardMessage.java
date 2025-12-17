package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class CardMessage extends com.google.firebase.inappmessaging.model.InAppMessage {

    private final String backgroundHexColor;
    private final com.google.firebase.inappmessaging.model.Text body;
    private final com.google.firebase.inappmessaging.model.ImageData landscapeImageData;
    private final com.google.firebase.inappmessaging.model.ImageData portraitImageData;
    private final com.google.firebase.inappmessaging.model.Action primaryAction;
    private final com.google.firebase.inappmessaging.model.Action secondaryAction;
    private final com.google.firebase.inappmessaging.model.Text title;

    public static class Builder {

        String backgroundHexColor;
        com.google.firebase.inappmessaging.model.Text body;
        com.google.firebase.inappmessaging.model.ImageData landscapeImageData;
        com.google.firebase.inappmessaging.model.ImageData portraitImageData;
        com.google.firebase.inappmessaging.model.Action primaryAction;
        com.google.firebase.inappmessaging.model.Action secondaryAction;
        com.google.firebase.inappmessaging.model.Text title;
        public com.google.firebase.inappmessaging.model.CardMessage build(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, Map<String, String> map2) {
            Object secondaryAction;
            com.google.firebase.inappmessaging.model.ImageData landscapeImageData;
            com.google.firebase.inappmessaging.model.Action primaryAction = this.primaryAction;
            if (primaryAction == null) {
            } else {
                if (primaryAction.getButton() == null) {
                } else {
                    secondaryAction = this.secondaryAction;
                    if (secondaryAction != null) {
                        if (secondaryAction.getButton() == null) {
                        } else {
                        }
                        IllegalArgumentException obj13 = new IllegalArgumentException("Card model secondary action must be null or have a button");
                        throw obj13;
                    }
                    if (this.title == null) {
                    } else {
                        if (this.portraitImageData == null) {
                            if (this.landscapeImageData == null) {
                            } else {
                            }
                            obj13 = new IllegalArgumentException("Card model must have at least one image");
                            throw obj13;
                        }
                        if (TextUtils.isEmpty(this.backgroundHexColor)) {
                        } else {
                            super(campaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction, map2, 0);
                            return cardMessage;
                        }
                        obj13 = new IllegalArgumentException("Card model must have a background color");
                        throw obj13;
                    }
                    obj13 = new IllegalArgumentException("Card model must have a title");
                    throw obj13;
                }
                obj13 = new IllegalArgumentException("Card model must have a primary action button");
                throw obj13;
            }
            obj13 = new IllegalArgumentException("Card model must have a primary action");
            throw obj13;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setBackgroundHexColor(String string) {
            this.backgroundHexColor = string;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setBody(com.google.firebase.inappmessaging.model.Text text) {
            this.body = text;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setLandscapeImageData(com.google.firebase.inappmessaging.model.ImageData imageData) {
            this.landscapeImageData = imageData;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setPortraitImageData(com.google.firebase.inappmessaging.model.ImageData imageData) {
            this.portraitImageData = imageData;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setPrimaryAction(com.google.firebase.inappmessaging.model.Action action) {
            this.primaryAction = action;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setSecondaryAction(com.google.firebase.inappmessaging.model.Action action) {
            this.secondaryAction = action;
            return this;
        }

        public com.google.firebase.inappmessaging.model.CardMessage.Builder setTitle(com.google.firebase.inappmessaging.model.Text text) {
            this.title = text;
            return this;
        }
    }
    private CardMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.Text text2, com.google.firebase.inappmessaging.model.Text text3, com.google.firebase.inappmessaging.model.ImageData imageData4, com.google.firebase.inappmessaging.model.ImageData imageData5, String string6, com.google.firebase.inappmessaging.model.Action action7, com.google.firebase.inappmessaging.model.Action action8, Map<String, String> map9) {
        super(campaignMetadata, MessageType.CARD, map9);
        this.title = text2;
        this.body = text3;
        this.portraitImageData = imageData4;
        this.landscapeImageData = imageData5;
        this.backgroundHexColor = string6;
        this.primaryAction = action7;
        this.secondaryAction = action8;
    }

    CardMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.Text text2, com.google.firebase.inappmessaging.model.Text text3, com.google.firebase.inappmessaging.model.ImageData imageData4, com.google.firebase.inappmessaging.model.ImageData imageData5, String string6, com.google.firebase.inappmessaging.model.Action action7, com.google.firebase.inappmessaging.model.Action action8, Map map9, com.google.firebase.inappmessaging.model.CardMessage.1 cardMessage$110) {
        super(campaignMetadata, text2, text3, imageData4, imageData5, string6, action7, action8, map9);
    }

    public static com.google.firebase.inappmessaging.model.CardMessage.Builder builder() {
        CardMessage.Builder builder = new CardMessage.Builder();
        return builder;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public boolean equals(Object object) {
        com.google.firebase.inappmessaging.model.Text equals;
        com.google.firebase.inappmessaging.model.Action secondaryAction;
        com.google.firebase.inappmessaging.model.ImageData portraitImageData;
        com.google.firebase.inappmessaging.model.ImageData landscapeImageData2;
        int landscapeImageData;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof CardMessage) {
            return i3;
        }
        if (hashCode() != (CardMessage)object.hashCode()) {
            return i3;
        }
        equals = this.body;
        if (equals == null) {
            if (object.body == null && equals != null && !equals.equals(object.body)) {
                if (equals != null) {
                    if (!equals.equals(object.body)) {
                    }
                }
            }
            return i3;
        } else {
        }
        secondaryAction = this.secondaryAction;
        if (secondaryAction == null) {
            if (object.secondaryAction == null && secondaryAction != null && !secondaryAction.equals(object.secondaryAction)) {
                if (secondaryAction != null) {
                    if (!secondaryAction.equals(object.secondaryAction)) {
                    }
                }
            }
            return i3;
        } else {
        }
        portraitImageData = this.portraitImageData;
        if (portraitImageData == null) {
            if (object.portraitImageData == null && portraitImageData != null && !portraitImageData.equals(object.portraitImageData)) {
                if (portraitImageData != null) {
                    if (!portraitImageData.equals(object.portraitImageData)) {
                    }
                }
            }
            return i3;
        } else {
        }
        landscapeImageData2 = this.landscapeImageData;
        if (landscapeImageData2 == null) {
            if (object.landscapeImageData == null && landscapeImageData2 != null && !landscapeImageData2.equals(object.landscapeImageData)) {
                if (landscapeImageData2 != null) {
                    if (!landscapeImageData2.equals(object.landscapeImageData)) {
                    }
                }
            }
            return i3;
        } else {
        }
        if (!this.title.equals(object.title)) {
            return i3;
        }
        if (!this.primaryAction.equals(object.primaryAction)) {
            return i3;
        }
        if (this.backgroundHexColor.equals(object.backgroundHexColor)) {
            return i;
        }
        return i3;
    }

    @Deprecated
    public com.google.firebase.inappmessaging.model.Action getAction() {
        return this.primaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Text getBody() {
        return this.body;
    }

    @Deprecated
    public com.google.firebase.inappmessaging.model.ImageData getImageData() {
        return this.portraitImageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Action getPrimaryAction() {
        return this.primaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Text getTitle() {
        return this.title;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public int hashCode() {
        int i;
        int i4;
        int i3;
        int i2;
        com.google.firebase.inappmessaging.model.Text body = this.body;
        i4 = 0;
        if (body != null) {
            i = body.hashCode();
        } else {
            i = i4;
        }
        com.google.firebase.inappmessaging.model.Action secondaryAction = this.secondaryAction;
        if (secondaryAction != null) {
            i3 = secondaryAction.hashCode();
        } else {
            i3 = i4;
        }
        com.google.firebase.inappmessaging.model.ImageData portraitImageData = this.portraitImageData;
        if (portraitImageData != null) {
            i2 = portraitImageData.hashCode();
        } else {
            i2 = i4;
        }
        com.google.firebase.inappmessaging.model.ImageData landscapeImageData = this.landscapeImageData;
        if (landscapeImageData != null) {
            i4 = landscapeImageData.hashCode();
        }
        return i12 += i4;
    }
}
