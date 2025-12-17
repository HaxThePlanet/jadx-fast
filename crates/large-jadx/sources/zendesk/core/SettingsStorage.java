package zendesk.core;

import com.google.gson.JsonElement;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
interface SettingsStorage {
    public abstract boolean areSettingsUpToDate(long l, TimeUnit timeUnit2);

    public abstract void clear();

    public abstract Map<String, JsonElement> getRawSettings();

    public abstract <E> E getSettings(String string, Class<E> class2);

    public abstract boolean hasStoredSettings();

    public abstract void storeRawSettings(Map<String, JsonElement> map);
}
