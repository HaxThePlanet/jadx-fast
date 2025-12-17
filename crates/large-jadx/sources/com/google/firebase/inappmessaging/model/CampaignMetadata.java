package com.google.firebase.inappmessaging.model;

/* loaded from: classes2.dex */
public class CampaignMetadata {

    private final String campaignId;
    private final String campaignName;
    private final boolean isTestMessage;
    public CampaignMetadata(String string, String string2, boolean z3) {
        super();
        this.campaignId = string;
        this.campaignName = string2;
        this.isTestMessage = z3;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCampaignName() {
        return this.campaignName;
    }

    public boolean getIsTestMessage() {
        return this.isTestMessage;
    }
}
