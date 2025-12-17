package zendesk.support;

import android.content.Context;
import com.google.gson.JsonElement;
import f.g.c.a;
import f.g.d.e;
import f.g.d.j;
import java.util.List;
import java.util.Map;
import o.a.a;
import o.a.c;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.Zendesk;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestConfiguration.Builder;

/* loaded from: classes3.dex */
public final class CreateRequestActionHandler implements ActionHandler {

    private static final String LOG_TAG = "CreateRequestActionHandler";
    private final Context context;
    CreateRequestActionHandler(Context context) {
        super();
        this.context = context;
    }

    private static boolean isInitialized() {
        boolean initialized;
        if (Support.INSTANCE.isInitialized() && Zendesk.INSTANCE.isInitialized()) {
            if (Zendesk.INSTANCE.isInitialized()) {
                return 1;
            }
        }
        int i = 0;
        a.k("CreateRequestActionHandler", "Support SDK contact handler returning false because Support.init(..) or Zendesk.init(..) has not been called!", new Object[i]);
        return i;
    }

    @Override // zendesk.core.ActionHandler
    public boolean canHandle(String string) {
        boolean initialized;
        Object obj2;
        if (CreateRequestActionHandler.isInitialized() && "action_contact_option".equals(string)) {
            obj2 = "action_contact_option".equals(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    List<a> extractConfigs(Map<String, Object> map) {
        List obj2;
        obj2 = c.f(map, a.class);
        if (obj2 != null) {
            obj2 = obj2.getConfigurations();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // zendesk.core.ActionHandler
    public ActionDescription getActionDescription() {
        String string = this.context.getString(j.R);
        ActionDescription actionDescription = new ActionDescription(string, string, e.a);
        return actionDescription;
    }

    @Override // zendesk.core.ActionHandler
    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context2) {
        boolean initialized;
        Object obj2;
        if (CreateRequestActionHandler.isInitialized()) {
            obj2 = extractConfigs(map);
            if (obj2 != null) {
                RequestActivity.builder().show(context2, obj2);
            } else {
                RequestActivity.builder().show(context2, new a[0]);
            }
        }
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
