package zendesk.support;

/* loaded from: classes3.dex */
public interface SupportBlipsProvider {
    public abstract void requestCreated(String string);

    public abstract void requestListViewed();

    public abstract void requestUpdated(String string);

    public abstract void requestViewed(String string);

    public abstract void supportSdkInit();
}
