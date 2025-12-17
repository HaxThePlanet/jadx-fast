package com.google.firebase.inappmessaging.model;

/* loaded from: classes2.dex */
public class TriggeredInAppMessage {

    private com.google.firebase.inappmessaging.model.InAppMessage inAppMessage;
    private String triggeringEvent;
    public TriggeredInAppMessage(com.google.firebase.inappmessaging.model.InAppMessage inAppMessage, String string2) {
        super();
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = string2;
    }

    public com.google.firebase.inappmessaging.model.InAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public String getTriggeringEvent() {
        return this.triggeringEvent;
    }
}
