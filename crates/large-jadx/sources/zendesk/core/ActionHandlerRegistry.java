package zendesk.core;

import com.google.gson.JsonElement;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ActionHandlerRegistry {
    public abstract void add(zendesk.core.ActionHandler actionHandler);

    public abstract void clear();

    public abstract zendesk.core.ActionHandler handlerByAction(String string);

    public abstract List<zendesk.core.ActionHandler> handlersByAction(String string);

    public abstract void remove(zendesk.core.ActionHandler actionHandler);

    public abstract void updateSettings(Map<String, JsonElement> map);
}
