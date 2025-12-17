package zendesk.core;

/* loaded from: classes3.dex */
public interface BlipsProvider {
    public abstract void sendBlip(zendesk.core.PageView pageView, zendesk.core.BlipsGroup blipsGroup2);

    public abstract void sendBlip(zendesk.core.UserAction userAction, zendesk.core.BlipsGroup blipsGroup2);
}
