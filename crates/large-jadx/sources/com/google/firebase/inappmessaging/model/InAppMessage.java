package com.google.firebase.inappmessaging.model;

import java.util.Map;

/* loaded from: classes2.dex */
public abstract class InAppMessage {

    @Deprecated
    com.google.firebase.inappmessaging.model.Button actionButton;
    @Deprecated
    String backgroundHexColor;
    @Deprecated
    com.google.firebase.inappmessaging.model.Text body;
    @Deprecated
    String campaignId;
    com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata;
    @Deprecated
    String campaignName;
    private Map<String, String> data;
    @Deprecated
    com.google.firebase.inappmessaging.model.ImageData imageData;
    @Deprecated
    String imageUrl;
    @Deprecated
    Boolean isTestMessage;
    com.google.firebase.inappmessaging.model.MessageType messageType;
    @Deprecated
    com.google.firebase.inappmessaging.model.Text title;
    public InAppMessage(com.google.firebase.inappmessaging.model.CampaignMetadata campaignMetadata, com.google.firebase.inappmessaging.model.MessageType messageType2, Map<String, String> map3) {
        super();
        this.campaignMetadata = campaignMetadata;
        this.messageType = messageType2;
        this.data = map3;
    }

    @Deprecated
    public InAppMessage(com.google.firebase.inappmessaging.model.Text text, com.google.firebase.inappmessaging.model.Text text2, String string3, com.google.firebase.inappmessaging.model.ImageData imageData4, com.google.firebase.inappmessaging.model.Button button5, com.google.firebase.inappmessaging.model.Action action6, String string7, String string8, String string9, Boolean boolean10, com.google.firebase.inappmessaging.model.MessageType messageType11, Map<String, String> map12) {
        super();
        this.title = text;
        this.body = text2;
        this.imageUrl = string3;
        this.imageData = imageData4;
        this.actionButton = button5;
        this.backgroundHexColor = string7;
        this.campaignId = string8;
        this.campaignName = string9;
        this.isTestMessage = boolean10;
        this.messageType = messageType11;
        CampaignMetadata obj1 = new CampaignMetadata(string8, string9, boolean10.booleanValue());
        this.campaignMetadata = obj1;
        this.data = map12;
    }

    @Deprecated
    public abstract com.google.firebase.inappmessaging.model.Action getAction();

    @Deprecated
    public com.google.firebase.inappmessaging.model.Button getActionButton() {
        if (getAction() != null) {
            return getAction().getButton();
        }
        return this.actionButton;
    }

    @Deprecated
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Deprecated
    public com.google.firebase.inappmessaging.model.Text getBody() {
        return this.body;
    }

    @Deprecated
    public String getCampaignId() {
        return this.campaignMetadata.getCampaignId();
    }

    public com.google.firebase.inappmessaging.model.CampaignMetadata getCampaignMetadata() {
        return this.campaignMetadata;
    }

    @Deprecated
    public String getCampaignName() {
        return this.campaignMetadata.getCampaignName();
    }

    public Map<String, String> getData() {
        return this.data;
    }

    @Deprecated
    public com.google.firebase.inappmessaging.model.ImageData getImageData() {
        return this.imageData;
    }

    @Deprecated
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Deprecated
    public Boolean getIsTestMessage() {
        return Boolean.valueOf(this.campaignMetadata.getIsTestMessage());
    }

    public com.google.firebase.inappmessaging.model.MessageType getMessageType() {
        return this.messageType;
    }

    @Deprecated
    public com.google.firebase.inappmessaging.model.Text getTitle() {
        return this.title;
    }
}
