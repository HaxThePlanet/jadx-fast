package zendesk.core;

import com.zendesk.service.f;

/* loaded from: classes3.dex */
public interface SettingsProvider {
    public abstract void getCoreSettings(f<zendesk.core.CoreSettings> f);

    public abstract <E extends zendesk.core.Settings> void getSettingsForSdk(String string, Class<E> class2, f<zendesk.core.SettingsPack<E>> f3);
}
