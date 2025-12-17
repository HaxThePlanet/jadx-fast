package zendesk.core;

import com.google.gson.JsonElement;
import f.g.a.a;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class ZendeskActionHandlerRegistry implements zendesk.core.ActionHandlerRegistry {

    private static final Comparator<zendesk.core.ActionHandler> PRIORITY_ACTION_HANDLER_COMPARATOR;
    private List<zendesk.core.ActionHandler> registry;
    static {
        ZendeskActionHandlerRegistry.2 anon = new ZendeskActionHandlerRegistry.2();
        ZendeskActionHandlerRegistry.PRIORITY_ACTION_HANDLER_COMPARATOR = anon;
    }

    ZendeskActionHandlerRegistry() {
        super();
        ArrayList arrayList = new ArrayList();
        this.registry = arrayList;
    }

    @Override // zendesk.core.ActionHandlerRegistry
    public void add(zendesk.core.ActionHandler actionHandler) {
        if (actionHandler == null) {
        }
        this.registry.add(actionHandler);
    }

    @Override // zendesk.core.ActionHandlerRegistry
    public void clear() {
        this.registry.clear();
    }

    @Override // zendesk.core.ActionHandlerRegistry
    public zendesk.core.ActionHandler handlerByAction(String string) {
        Comparator pRIORITY_ACTION_HANDLER_COMPARATOR;
        boolean handle;
        final int i = 0;
        if (g.e(string)) {
            return i;
        }
        ArrayList arrayList = new ArrayList(this.registry);
        Collections.sort(arrayList, ZendeskActionHandlerRegistry.PRIORITY_ACTION_HANDLER_COMPARATOR);
        Iterator iterator = arrayList.iterator();
        for (ActionHandler pRIORITY_ACTION_HANDLER_COMPARATOR : iterator) {
        }
        return i;
    }

    public List<zendesk.core.ActionHandler> handlersByAction(String string) {
        if (g.e(string)) {
            return Collections.emptyList();
        }
        ZendeskActionHandlerRegistry.1 anon = new ZendeskActionHandlerRegistry.1(this, string);
        List obj3 = a.f(this.registry, anon);
        Collections.sort(obj3, ZendeskActionHandlerRegistry.PRIORITY_ACTION_HANDLER_COMPARATOR);
        return obj3;
    }

    @Override // zendesk.core.ActionHandlerRegistry
    public void remove(zendesk.core.ActionHandler actionHandler) {
        if (actionHandler == null) {
        }
        this.registry.remove(actionHandler);
    }

    public void updateSettings(Map<String, JsonElement> map) {
        Object next;
        Iterator iterator = this.registry.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((ActionHandler)next != null) {
            }
            (ActionHandler)next.updateSettings(map);
        }
    }
}
