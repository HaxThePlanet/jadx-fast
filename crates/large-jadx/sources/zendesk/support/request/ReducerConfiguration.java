package zendesk.support.request;

import o.b.a;
import o.b.n;

/* loaded from: classes3.dex */
class ReducerConfiguration extends n<zendesk.support.request.StateConfig> {
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateConfig getInitialState() {
        StateConfig stateConfig = new StateConfig();
        return stateConfig;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateConfig)object, a2);
    }

    public zendesk.support.request.StateConfig reduce(zendesk.support.request.StateConfig stateConfig, a<?> a2) {
        String actionType = a2.getActionType();
        actionType.hashCode();
        if (!actionType.equals("LOAD_SETTINGS_SUCCESS") && !actionType.equals("START_CONFIG")) {
            if (!actionType.equals("START_CONFIG")) {
                return null;
            }
            Object obj4 = a2.getData();
            return stateConfig.newBuilder().setTags((RequestConfiguration)obj4.getTags()).setTicketForm(obj4.getTicketForm()).setSubject(obj4.getRequestSubject()).build();
        }
        return stateConfig.newBuilder().setSettings((StateSettings)a2.getData()).build();
    }
}
