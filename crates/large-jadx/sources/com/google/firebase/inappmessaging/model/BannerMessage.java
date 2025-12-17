package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class BannerMessage extends com.google.firebase.inappmessaging.model.InAppMessage {

    private final com.google.firebase.inappmessaging.model.Action action;
    private final String backgroundHexColor;
    private final com.google.firebase.inappmessaging.model.Text body;
    private final com.google.firebase.inappmessaging.model.ImageData imageData;
    private final com.google.firebase.inappmessaging.model.Text title;

    public static class Builder {

        com.google.firebase.inappmessaging.model.Action action;
        String backgroundHexColor;
        com.google.firebase.inappmessaging.model.Text body;
        com.google.firebase.inappmessaging.model.ImageData imageData;
        com.google.firebase.inappmessaging.model.Text title;
        public com.google.firebase.inappmessaging.model.BannerMessage build(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, Map<String, String> map2) {
            if (this.title == null) {
            } else {
                if (TextUtils.isEmpty(this.backgroundHexColor)) {
                } else {
                    super(campaignMetadata, this.title, this.body, this.imageData, this.action, this.backgroundHexColor, map2, 0);
                    return bannerMessage;
                }
                IllegalArgumentException obj11 = new IllegalArgumentException("Banner model must have a background color");
                throw obj11;
            }
            obj11 = new IllegalArgumentException("Banner model must have a title");
            throw obj11;
        }

        public com.google.firebase.inappmessaging.model.BannerMessage.Builder setAction(com.google.firebase.inappmessaging.model.Action action) {
            this.action = action;
            return this;
        }

        public com.google.firebase.inappmessaging.model.BannerMessage.Builder setBackgroundHexColor(String string) {
            this.backgroundHexColor = string;
            return this;
        }

        public com.google.firebase.inappmessaging.model.BannerMessage.Builder setBody(com.google.firebase.inappmessaging.model.Text text) {
            this.body = text;
            return this;
        }

        public com.google.firebase.inappmessaging.model.BannerMessage.Builder setImageData(com.google.firebase.inappmessaging.model.ImageData imageData) {
            this.imageData = imageData;
            return this;
        }

        public com.google.firebase.inappmessaging.model.BannerMessage.Builder setTitle(com.google.firebase.inappmessaging.model.Text text) {
            this.title = text;
            return this;
        }
    }
    private BannerMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.Text text2, com.google.firebase.inappmessaging.model.Text text3, com.google.firebase.inappmessaging.model.ImageData imageData4, com.google.firebase.inappmessaging.model.Action action5, String string6, Map<String, String> map7) {
        super(campaignMetadata, MessageType.BANNER, map7);
        this.title = text2;
        this.body = text3;
        this.imageData = imageData4;
        this.action = action5;
        this.backgroundHexColor = string6;
    }

    BannerMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.Text text2, com.google.firebase.inappmessaging.model.Text text3, com.google.firebase.inappmessaging.model.ImageData imageData4, com.google.firebase.inappmessaging.model.Action action5, String string6, Map map7, com.google.firebase.inappmessaging.model.BannerMessage.1 bannerMessage$18) {
        super(campaignMetadata, text2, text3, imageData4, action5, string6, map7);
    }

    public static com.google.firebase.inappmessaging.model.BannerMessage.Builder builder() {
        BannerMessage.Builder builder = new BannerMessage.Builder();
        return builder;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public boolean equals(Object object) {
        com.google.firebase.inappmessaging.model.Text equals;
        com.google.firebase.inappmessaging.model.ImageData imageData2;
        com.google.firebase.inappmessaging.model.Action action;
        com.google.firebase.inappmessaging.model.Text imageData;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof BannerMessage) {
            return i3;
        }
        if (hashCode() != (BannerMessage)object.hashCode()) {
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
        imageData2 = this.imageData;
        if (imageData2 == null) {
            if (object.imageData == null && imageData2 != null && !imageData2.equals(object.imageData)) {
                if (imageData2 != null) {
                    if (!imageData2.equals(object.imageData)) {
                    }
                }
            }
            return i3;
        } else {
        }
        action = this.action;
        if (action == null) {
            if (object.action == null && action != null && !action.equals(object.action)) {
                if (action != null) {
                    if (!action.equals(object.action)) {
                    }
                }
            }
            return i3;
        } else {
        }
        if (!this.title.equals(object.title)) {
            return i3;
        }
        if (this.backgroundHexColor.equals(object.backgroundHexColor)) {
            return i;
        }
        return i3;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Text getBody() {
        return this.body;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.ImageData getImageData() {
        return this.imageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Text getTitle() {
        return this.title;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public int hashCode() {
        int i2;
        int i3;
        int i;
        com.google.firebase.inappmessaging.model.Text body = this.body;
        i3 = 0;
        if (body != null) {
            i2 = body.hashCode();
        } else {
            i2 = i3;
        }
        com.google.firebase.inappmessaging.model.ImageData imageData = this.imageData;
        if (imageData != null) {
            i = imageData.hashCode();
        } else {
            i = i3;
        }
        com.google.firebase.inappmessaging.model.Action action = this.action;
        if (action != null) {
            i3 = action.hashCode();
        }
        return i8 += i4;
    }
}
