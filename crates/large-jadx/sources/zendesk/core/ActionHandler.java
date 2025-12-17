package zendesk.core;

import android.content.Context;
import com.google.gson.JsonElement;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ActionHandler {
    public abstract boolean canHandle(String string);

    public abstract zendesk.core.ActionDescription getActionDescription();

    public abstract int getPriority();

    public abstract void handle(Map<String, Object> map, Context context2);

    public abstract void updateSettings(Map<String, JsonElement> map);
}
