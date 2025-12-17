package zendesk.messaging.ui;

import f.g.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.a;
import zendesk.belvedere.e;
import zendesk.belvedere.s;
import zendesk.messaging.BelvedereMediaHolder;
import zendesk.messaging.BelvedereMediaResolverCallback;
import zendesk.messaging.EventFactory;
import zendesk.messaging.EventListener;

/* loaded from: classes3.dex */
public class InputBoxConsumer implements zendesk.messaging.ui.InputBox.InputTextConsumer {

    private final a belvedere;
    private final BelvedereMediaHolder belvedereMediaHolder;
    private final BelvedereMediaResolverCallback belvedereMediaResolverCallback;
    private final EventFactory eventFactory;
    private final EventListener eventListener;
    private final e imageStream;
    public InputBoxConsumer(EventListener eventListener, EventFactory eventFactory2, e e3, a a4, BelvedereMediaHolder belvedereMediaHolder5, BelvedereMediaResolverCallback belvedereMediaResolverCallback6) {
        super();
        this.eventListener = eventListener;
        this.eventFactory = eventFactory2;
        this.imageStream = e3;
        this.belvedere = a4;
        this.belvedereMediaHolder = belvedereMediaHolder5;
        this.belvedereMediaResolverCallback = belvedereMediaResolverCallback6;
    }

    @Override // zendesk.messaging.ui.InputBox$InputTextConsumer
    public boolean onConsumeText(String string) {
        boolean eventListener;
        boolean belvedere;
        EventFactory eventFactory;
        boolean belvedereMediaResolverCallback;
        String str;
        Object obj4;
        if (g.c(string)) {
            this.eventListener.onEvent(this.eventFactory.textInput(string));
        }
        obj4 = new ArrayList();
        Iterator iterator = this.belvedereMediaHolder.getSelectedMedia().iterator();
        for (s next : iterator) {
            obj4.add(next.n());
        }
        if (!obj4.isEmpty()) {
            this.belvedere.h(obj4, "zendesk/messaging", this.belvedereMediaResolverCallback);
            this.belvedereMediaHolder.clear();
        }
        if (this.imageStream.G1()) {
            this.imageStream.dismiss();
        }
        return 1;
    }
}
