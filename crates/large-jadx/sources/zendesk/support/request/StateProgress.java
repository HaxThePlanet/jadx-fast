package zendesk.support.request;

import java.io.Serializable;
import o.b.o;

/* loaded from: classes3.dex */
class StateProgress implements Serializable {

    private final int runningRequests;
    StateProgress() {
        super();
        this.runningRequests = 0;
    }

    StateProgress(int i) {
        super();
        this.runningRequests = i;
    }

    static zendesk.support.request.StateProgress fomState(o o) {
        Object obj1 = o.b(StateProgress.class);
        if ((StateProgress)obj1 != null) {
            return (StateProgress)obj1;
        }
        obj1 = new StateProgress();
        return obj1;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateProgress decrement() {
        int runningRequests = this.runningRequests;
        if (runningRequests > 0) {
            StateProgress stateProgress2 = new StateProgress(runningRequests--);
            return stateProgress2;
        }
        StateProgress stateProgress = new StateProgress(0);
        return stateProgress;
    }

    @Override // java.io.Serializable
    int getRunningRequests() {
        return this.runningRequests;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateProgress increment() {
        StateProgress stateProgress = new StateProgress(runningRequests++);
        return stateProgress;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Progress{runningRequests=");
        stringBuilder.append(this.runningRequests);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
