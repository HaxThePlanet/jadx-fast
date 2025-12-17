package zendesk.core;

import android.content.Context;
import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
public enum Zendesk {

    INSTANCE;

    private zendesk.core.ActionHandlerRegistry actionHandlerRegistry;
    private zendesk.core.ZendeskShadow zendeskShadow;
    static boolean checkConfig(Context context, String string2, String string3, String string4) {
        boolean z;
        final int i = 3;
        final int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        String[] strArr = new String[i];
        strArr[i4] = string2;
        strArr[i3] = string3;
        strArr[i2] = string4;
        if (context != null && !g.d(strArr)) {
            strArr = new String[i];
            strArr[i4] = string2;
            strArr[i3] = string3;
            strArr[i2] = string4;
            if (!g.d(strArr)) {
            }
            return i3;
        }
        Object[] arr = new Object[4];
        arr[i4] = context;
        arr[i3] = Boolean.valueOf(g.c(string2));
        arr[i2] = Boolean.valueOf(g.c(string3));
        arr[i] = Boolean.valueOf(g.c(string4));
        a.e("Zendesk", String.format("Invalid zendesk configuration provided | Context: %b | Url: %b | Application Id: %b | OauthClientId: %b", arr), new Object[i4]);
        return i4;
    }

    @Override // java.lang.Enum
    public zendesk.core.ActionHandlerRegistry actionHandlerRegistry() {
        return this.actionHandlerRegistry;
    }

    @Override // java.lang.Enum
    public zendesk.core.CoreModule coreModule() {
        if (!isInitialized()) {
            a.e("Zendesk", "Cannot get CoreModule before SDK has been initialized. init() must be called before coreModule().", new Object[0]);
            return null;
        }
        return this.zendeskShadow.coreModule();
    }

    @Override // java.lang.Enum
    public zendesk.core.Identity getIdentity() {
        if (!isInitialized()) {
            return null;
        }
        return this.zendeskShadow.getIdentity();
    }

    @Override // java.lang.Enum
    public void init(Context context, String string2, String string3, String string4) {
        Zendesk.checkConfig(context, string2, string3, string4);
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration(string3, string2, string4);
        ZendeskApplicationModule obj4 = new ZendeskApplicationModule(context, applicationConfiguration);
        init(DaggerZendeskApplicationComponent.builder().zendeskApplicationModule(obj4).build(), applicationConfiguration);
    }

    @Override // java.lang.Enum
    void init(zendesk.core.ZendeskApplicationComponent zendeskApplicationComponent, zendesk.core.ApplicationConfiguration applicationConfiguration2) {
        int i;
        final zendesk.core.ZendeskShadow zendeskShadow = this.zendeskShadow;
        i = zendeskShadow != null ? 1 : 0;
        if (i != 0) {
            zendeskShadow.cleanupIfNewConfig(applicationConfiguration2);
        }
        final zendesk.core.ZendeskShadow obj3 = zendeskApplicationComponent.zendeskShadow();
        obj3.init(applicationConfiguration2, i);
        this.zendeskShadow = obj3;
    }

    @Override // java.lang.Enum
    public boolean isInitialized() {
        int i;
        i = this.zendeskShadow != null ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public zendesk.core.ProviderStore provider() {
        final int i = 0;
        int i2 = 0;
        final String str3 = "Zendesk";
        if (!isInitialized()) {
            a.e(str3, "Cannot get ProviderStore before SDK has been initialized. init() must be called before provider().", new Object[i2]);
            return i;
        }
        if (getIdentity() == null) {
            a.e(str3, "Cannot get ProviderStore before an identity has been set. Zendesk.INSTANCE.setIdentity() must be called before provider().", new Object[i2]);
            return i;
        }
        return this.zendeskShadow.providers();
    }

    @Override // java.lang.Enum
    void reset() {
        Object[] arr;
        String str;
        int i2 = 0;
        final String str2 = "Zendesk";
        if (isInitialized()) {
            this.zendeskShadow.reset();
            this.zendeskShadow = 0;
            a.g(str2, "Tearing down Zendesk", new Object[i2]);
        } else {
            a.g(str2, "Cant reset, Zendesk is uninitialized", new Object[i2]);
        }
    }

    @Override // java.lang.Enum
    public void setIdentity(zendesk.core.Identity identity) {
        if (!isInitialized()) {
            a.e("Zendesk", "Cannot get set identity before SDK has been initialized. init() must be called before setIdentity(...).", new Object[0]);
        }
        this.zendeskShadow.setIdentity(identity);
    }
}
