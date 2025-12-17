package zendesk.support;

/* loaded from: classes3.dex */
interface HelpCenterTracker {

    public static class DefaultTracker implements zendesk.support.HelpCenterTracker {
        @Override // zendesk.support.HelpCenterTracker
        public void helpCenterArticleViewed() {
        }

        @Override // zendesk.support.HelpCenterTracker
        public void helpCenterLoaded() {
        }

        @Override // zendesk.support.HelpCenterTracker
        public void helpCenterSearched(String string) {
        }
    }
    public abstract void helpCenterArticleViewed();

    public abstract void helpCenterLoaded();

    public abstract void helpCenterSearched(String string);
}
