package com.google.firebase.inappmessaging.model;

import java.util.Map;

/* loaded from: classes2.dex */
public class ImageOnlyMessage extends com.google.firebase.inappmessaging.model.InAppMessage {

    private com.google.firebase.inappmessaging.model.Action action;
    private com.google.firebase.inappmessaging.model.ImageData imageData;

    public static class Builder {

        com.google.firebase.inappmessaging.model.Action action;
        com.google.firebase.inappmessaging.model.ImageData imageData;
        public com.google.firebase.inappmessaging.model.ImageOnlyMessage build(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, Map<String, String> map2) {
            final com.google.firebase.inappmessaging.model.ImageData imageData = this.imageData;
            if (imageData == null) {
            } else {
                super(campaignMetadata, imageData, this.action, map2, 0);
                return imageOnlyMessage2;
            }
            IllegalArgumentException obj8 = new IllegalArgumentException("ImageOnly model must have image data");
            throw obj8;
        }

        public com.google.firebase.inappmessaging.model.ImageOnlyMessage.Builder setAction(com.google.firebase.inappmessaging.model.Action action) {
            this.action = action;
            return this;
        }

        public com.google.firebase.inappmessaging.model.ImageOnlyMessage.Builder setImageData(com.google.firebase.inappmessaging.model.ImageData imageData) {
            this.imageData = imageData;
            return this;
        }
    }
    private ImageOnlyMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.ImageData imageData2, com.google.firebase.inappmessaging.model.Action action3, Map<String, String> map4) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map4);
        this.imageData = imageData2;
        this.action = action3;
    }

    ImageOnlyMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.ImageData imageData2, com.google.firebase.inappmessaging.model.Action action3, Map map4, com.google.firebase.inappmessaging.model.ImageOnlyMessage.1 imageOnlyMessage$15) {
        super(campaignMetadata, imageData2, action3, map4);
    }

    public static com.google.firebase.inappmessaging.model.ImageOnlyMessage.Builder builder() {
        ImageOnlyMessage.Builder builder = new ImageOnlyMessage.Builder();
        return builder;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public boolean equals(Object object) {
        com.google.firebase.inappmessaging.model.Action action2;
        com.google.firebase.inappmessaging.model.Action action;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof ImageOnlyMessage) {
            return i3;
        }
        if (hashCode() != (ImageOnlyMessage)object.hashCode()) {
            return i3;
        }
        action2 = this.action;
        if (action2 == null) {
            if (object.action == null && action2 != null && !action2.equals(object.action)) {
                if (action2 != null) {
                    if (!action2.equals(object.action)) {
                    }
                }
            }
            return i3;
        } else {
        }
        if (this.imageData.equals(object.imageData)) {
            return i;
        }
        return i3;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public com.google.firebase.inappmessaging.model.ImageData getImageData() {
        return this.imageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public int hashCode() {
        int i;
        com.google.firebase.inappmessaging.model.Action action = this.action;
        if (action != null) {
            i = action.hashCode();
        } else {
            i = 0;
        }
        return i2 += i;
    }
}
