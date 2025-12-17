package zendesk.support;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.util.Map;
import o.a.c;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListConfiguration.Builder;

/* loaded from: classes3.dex */
class RequestListActionHandler implements ActionHandler {

    private boolean conversationsEnabled;
    private final Gson gson;
    RequestListActionHandler() {
        super();
        GsonBuilder gsonBuilder = new GsonBuilder();
        this.gson = gsonBuilder.create();
    }

    @Override // zendesk.core.ActionHandler
    public boolean canHandle(String string) {
        boolean obj2;
        if (string.equals("action_conversation_list") && this.conversationsEnabled) {
            obj2 = this.conversationsEnabled ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // zendesk.core.ActionHandler
    public ActionDescription getActionDescription() {
        return null;
    }

    @Override // zendesk.core.ActionHandler
    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context2) {
        o.a.a[] arr = new a[1];
        RequestListActivity.builder().show(context2, (RequestListConfiguration)c.f(map, RequestListConfiguration.class));
    }

    public void updateSettings(Map<String, JsonElement> map) {
        String str;
        int obj3;
        if (map == null) {
            obj3 = 0;
        } else {
            obj3 = map.get("support");
        }
        obj3 = this.gson.fromJson(obj3, SupportSettings.class);
        if ((SupportSettings)obj3 != null) {
            this.conversationsEnabled = (SupportSettings)obj3.getConversations().isEnabled();
        }
    }
}
