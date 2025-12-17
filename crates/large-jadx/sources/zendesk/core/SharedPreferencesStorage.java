package zendesk.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import f.g.e.g;

/* loaded from: classes3.dex */
class SharedPreferencesStorage implements zendesk.core.BaseStorage {

    private final zendesk.core.Serializer serializer;
    private final SharedPreferences sharedPreferences;
    SharedPreferencesStorage(SharedPreferences sharedPreferences, zendesk.core.Serializer serializer2) {
        super();
        this.sharedPreferences = sharedPreferences;
        this.serializer = serializer2;
    }

    @Override // zendesk.core.BaseStorage
    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }

    public <E> E get(String string, Class<E> class2) {
        return this.serializer.deserialize(get(string), class2);
    }

    @Override // zendesk.core.BaseStorage
    public String get(String string) {
        return this.sharedPreferences.getString(string, 0);
    }

    @Override // zendesk.core.BaseStorage
    long getLong(String string) {
        return this.sharedPreferences.getLong(string, 0);
    }

    @Override // zendesk.core.BaseStorage
    public void put(String string, Object object2) {
        int serialize;
        serialize = 0;
        if (g.c(string) && object2 != null) {
            serialize = 0;
            if (object2 != null) {
                serialize = this.serializer.serialize(object2);
            }
            put(string, serialize);
        }
    }

    @Override // zendesk.core.BaseStorage
    public void put(String string, String string2) {
        boolean edit;
        Object obj2;
        if (g.c(string)) {
            this.sharedPreferences.edit().putString(string, string2).apply();
        }
    }

    @Override // zendesk.core.BaseStorage
    public void remove(String string) {
        boolean edit;
        Object obj2;
        if (g.c(string)) {
            this.sharedPreferences.edit().remove(string).apply();
        }
    }
}
