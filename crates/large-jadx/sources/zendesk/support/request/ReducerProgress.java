package zendesk.support.request;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import o.b.a;
import o.b.n;

/* loaded from: classes3.dex */
class ReducerProgress extends n<zendesk.support.request.StateProgress> {

    private static final Collection<String> DECREMENT_ACTION;
    private static final Collection<String> INCREMENT_ACTIONS;
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        ReducerProgress.INCREMENT_ACTIONS = hashSet;
        HashSet hashSet2 = new HashSet(Arrays.asList(/* result */));
        ReducerProgress.DECREMENT_ACTION = hashSet2;
    }

    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateProgress getInitialState() {
        StateProgress stateProgress = new StateProgress();
        return stateProgress;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateProgress)object, a2);
    }

    public zendesk.support.request.StateProgress reduce(zendesk.support.request.StateProgress stateProgress, a<?> a2) {
        if (ReducerProgress.INCREMENT_ACTIONS.contains(a2.getActionType())) {
            return stateProgress.increment();
        }
        if (ReducerProgress.DECREMENT_ACTION.contains(a2.getActionType())) {
            return stateProgress.decrement();
        }
        return null;
    }
}
