package com.google.firebase.inappmessaging.internal;

/* loaded from: classes2.dex */
public class ProgramaticContextualTriggers {

    private com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener listener;

    public interface Listener {
        public abstract void onEventTrigger(String string);
    }
    public void removeListener(com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener programaticContextualTriggers$Listener) {
        this.listener = 0;
    }

    public void setListener(com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener programaticContextualTriggers$Listener) {
        this.listener = listener;
    }

    public void triggerEvent(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Programmatically trigger: ");
        stringBuilder.append(string);
        Logging.logd(stringBuilder.toString());
        this.listener.onEventTrigger(string);
    }
}
