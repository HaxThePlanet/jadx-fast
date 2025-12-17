package zendesk.support.requestlist;

import android.content.Context;
import com.google.gson.JsonElement;
import java.util.Map;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;

/* loaded from: classes3.dex */
class RequestListSyncHandler implements ActionHandler {

    private boolean outdated = false;
    private final zendesk.support.requestlist.RequestListPresenter presenter;
    private boolean running = false;
    RequestListSyncHandler(zendesk.support.requestlist.RequestListPresenter requestListPresenter) {
        super();
        final int i = 0;
        this.presenter = requestListPresenter;
    }

    @Override // zendesk.core.ActionHandler
    public boolean canHandle(String string) {
        return "request_list_refresh".equals(string);
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
        int obj1;
        if (this.running) {
            this.presenter.refresh();
            this.outdated = false;
        } else {
            this.outdated = true;
        }
    }

    @Override // zendesk.core.ActionHandler
    void setRunning(boolean z) {
        boolean obj1;
        this.running = z;
        if (this.outdated) {
            this.presenter.refresh();
            this.outdated = false;
        }
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
