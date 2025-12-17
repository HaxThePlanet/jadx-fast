package zendesk.core;

/* loaded from: classes3.dex */
class ZendeskPushDeviceIdStorage implements zendesk.core.PushDeviceIdStorage {

    private final zendesk.core.BaseStorage deviceIdStorage;
    ZendeskPushDeviceIdStorage(zendesk.core.BaseStorage baseStorage) {
        super();
        this.deviceIdStorage = baseStorage;
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public zendesk.core.PushRegistrationRequest getPushRegistrationRequest() {
        return (PushRegistrationRequest)this.deviceIdStorage.get("pushRegistrationRequest", PushRegistrationRequest.class);
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public String getRegisteredDeviceId() {
        return this.deviceIdStorage.get("pushDeviceIdentifier");
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public boolean hasRegisteredDeviceId() {
        int i;
        i = this.deviceIdStorage.get("pushDeviceIdentifier") != null ? 1 : 0;
        return i;
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public void removePushRegistrationRequest() {
        this.deviceIdStorage.remove("pushRegistrationRequest");
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public void removeRegisteredDeviceId() {
        this.deviceIdStorage.remove("pushDeviceIdentifier");
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public void storePushRegistrationRequest(zendesk.core.PushRegistrationRequest pushRegistrationRequest) {
        this.deviceIdStorage.put("pushRegistrationRequest", pushRegistrationRequest);
    }

    @Override // zendesk.core.PushDeviceIdStorage
    public void storeRegisteredDeviceId(String string) {
        zendesk.core.BaseStorage deviceIdStorage;
        String str;
        if (string != null) {
            this.deviceIdStorage.put("pushDeviceIdentifier", string);
        }
    }
}
