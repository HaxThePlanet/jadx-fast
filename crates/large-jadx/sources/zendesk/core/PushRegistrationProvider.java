package zendesk.core;

import com.zendesk.service.f;

/* loaded from: classes3.dex */
public interface PushRegistrationProvider {
    public abstract boolean isRegisteredForPush();

    public abstract void registerWithDeviceIdentifier(String string, f<String> f2);

    public abstract void registerWithUAChannelId(String string, f<String> f2);

    public abstract void unregisterDevice(f<Void> f);
}
