package zendesk.core;

/* loaded from: classes3.dex */
public interface NetworkInfoProvider {
    public abstract void addNetworkAwareListener(Integer integer, zendesk.core.NetworkAware networkAware2);

    public abstract void addRetryAction(Integer integer, zendesk.core.RetryAction retryAction2);

    public abstract void clearNetworkAwareListeners();

    public abstract void clearRetryActions();

    public abstract boolean isNetworkAvailable();

    public abstract void register();

    public abstract void removeNetworkAwareListener(Integer integer);

    public abstract void removeRetryAction(Integer integer);

    public abstract void unregister();
}
