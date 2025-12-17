package zendesk.support;

/* loaded from: classes3.dex */
interface ZendeskTracker {

    public static class DefaultTracker implements zendesk.support.ZendeskTracker {
        @Override // zendesk.support.ZendeskTracker
        public void requestCreated() {
        }

        @Override // zendesk.support.ZendeskTracker
        public void requestUpdated() {
        }
    }
    public abstract void requestCreated();

    public abstract void requestUpdated();
}
