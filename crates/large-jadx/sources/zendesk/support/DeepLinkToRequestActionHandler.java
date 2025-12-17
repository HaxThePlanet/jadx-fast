package zendesk.support;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.q;
import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListConfiguration.Builder;

/* loaded from: classes3.dex */
class DeepLinkToRequestActionHandler implements ActionHandler {

    private static final String BACK_STACK_ACTIVITIES = "back_stack_activities";
    private static final String REQUEST_INTENT = "request_ui_config";
    static final String REQUEST_VIEW_CONVERSATION = "request_view_conversation";
    static Map<String, Object> data(Intent intent, List<Intent> list2) {
        HashMap hashMap = new HashMap();
        hashMap.put("request_ui_config", intent);
        hashMap.put("back_stack_activities", list2);
        return hashMap;
    }

    @Override // zendesk.core.ActionHandler
    public boolean canHandle(String string) {
        return string.equals("request_view_conversation");
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
        Iterator iterator;
        Object next;
        Object obj4;
        Object obj5;
        final q qVar = q.i(context2);
        if (map != null) {
            iterator = (List)map.get("back_stack_activities").iterator();
            for (Intent next : iterator) {
                qVar.d(next);
            }
        }
        qVar.d(RequestListActivity.builder().intent(context2, new a[0]));
        if (map != null) {
            qVar.d((Intent)map.get("request_ui_config"));
        }
        qVar.l();
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
