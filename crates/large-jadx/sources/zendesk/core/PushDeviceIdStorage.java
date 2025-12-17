package zendesk.core;

/* loaded from: classes3.dex */
interface PushDeviceIdStorage {
    public abstract zendesk.core.PushRegistrationRequest getPushRegistrationRequest();

    public abstract String getRegisteredDeviceId();

    public abstract boolean hasRegisteredDeviceId();

    public abstract void removePushRegistrationRequest();

    public abstract void removeRegisteredDeviceId();

    public abstract void storePushRegistrationRequest(zendesk.core.PushRegistrationRequest pushRegistrationRequest);

    public abstract void storeRegisteredDeviceId(String string);
}
