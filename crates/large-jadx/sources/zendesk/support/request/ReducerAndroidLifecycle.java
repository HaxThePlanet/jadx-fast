package zendesk.support.request;

import o.b.a;
import o.b.n;

/* loaded from: classes3.dex */
class ReducerAndroidLifecycle extends n<zendesk.support.request.StateAndroidLifecycle> {
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateAndroidLifecycle getInitialState() {
        StateAndroidLifecycle stateAndroidLifecycle = new StateAndroidLifecycle();
        return stateAndroidLifecycle;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateAndroidLifecycle)object, a2);
    }

    public zendesk.support.request.StateAndroidLifecycle reduce(zendesk.support.request.StateAndroidLifecycle stateAndroidLifecycle, a<?> a2) {
        String obj1 = a2.getActionType();
        obj1.hashCode();
        if (!obj1.equals("ANDROID_ON_PAUSE") && !obj1.equals("ANDROID_ON_RESUME")) {
            if (!obj1.equals("ANDROID_ON_RESUME")) {
                return null;
            }
            obj1 = new StateAndroidLifecycle(1);
            return obj1;
        }
        obj1 = new StateAndroidLifecycle(2);
        return obj1;
    }
}
