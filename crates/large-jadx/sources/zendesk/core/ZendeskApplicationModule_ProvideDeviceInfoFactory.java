package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideDeviceInfoFactory implements b<zendesk.core.DeviceInfo> {

    private final a<Context> contextProvider;
    public ZendeskApplicationModule_ProvideDeviceInfoFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideDeviceInfoFactory create(a<Context> a) {
        ZendeskApplicationModule_ProvideDeviceInfoFactory zendeskApplicationModule_ProvideDeviceInfoFactory = new ZendeskApplicationModule_ProvideDeviceInfoFactory(a);
        return zendeskApplicationModule_ProvideDeviceInfoFactory;
    }

    public static zendesk.core.DeviceInfo provideDeviceInfo(Context context) {
        final zendesk.core.DeviceInfo obj1 = ZendeskApplicationModule.provideDeviceInfo(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (DeviceInfo)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.DeviceInfo get() {
        return ZendeskApplicationModule_ProvideDeviceInfoFactory.provideDeviceInfo((Context)this.contextProvider.get());
    }
}
