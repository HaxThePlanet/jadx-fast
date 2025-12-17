package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class EventRaiser {

    private final EventTarget eventTarget;
    private final LogWrapper logger;
    public EventRaiser(Context context) {
        super();
        this.eventTarget = context.getEventTarget();
        this.logger = context.getLogger("EventRaiser");
    }

    static LogWrapper access$000(com.google.firebase.database.core.view.EventRaiser eventRaiser) {
        return eventRaiser.logger;
    }

    public void raiseEvents(List<? extends com.google.firebase.database.core.view.Event> list) {
        boolean logsDebug;
        String string;
        Object[] arr;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Raising ");
            stringBuilder.append(list.size());
            stringBuilder.append(" event(s)");
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        ArrayList arrayList = new ArrayList(list);
        EventRaiser.1 anon = new EventRaiser.1(this, arrayList);
        this.eventTarget.postEvent(anon);
    }
}
