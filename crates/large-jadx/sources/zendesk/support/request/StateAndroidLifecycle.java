package zendesk.support.request;

import java.io.Serializable;
import o.b.o;

/* loaded from: classes3.dex */
class StateAndroidLifecycle implements Serializable {

    public static final int STARTED = 1;
    public static final int STOPPED = 2;
    private final int state;
    public StateAndroidLifecycle() {
        super();
        this.state = 1;
    }

    public StateAndroidLifecycle(int i) {
        super();
        this.state = i;
    }

    static zendesk.support.request.StateAndroidLifecycle fromState(o o) {
        Object obj1 = o.b(StateAndroidLifecycle.class);
        if ((StateAndroidLifecycle)obj1 != null) {
            return (StateAndroidLifecycle)obj1;
        }
        obj1 = new StateAndroidLifecycle();
        return obj1;
    }

    @Override // java.io.Serializable
    public int getState() {
        return this.state;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AndroidLifeCycle{state=");
        stringBuilder.append(this.state);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
