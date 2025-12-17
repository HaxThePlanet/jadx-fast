package zendesk.messaging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public enum EngineListRegistry {

    INSTANCE;

    private final Map<String, List<zendesk.messaging.Engine>> enginesRegistry;
    public String register(List<zendesk.messaging.Engine> list) {
        String string = UUID.randomUUID().toString();
        this.enginesRegistry.put(string, list);
        return string;
    }

    public List<zendesk.messaging.Engine> retrieveEngineList(String string) {
        return (List)this.enginesRegistry.remove(string);
    }
}
