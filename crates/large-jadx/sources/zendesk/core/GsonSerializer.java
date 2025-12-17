package zendesk.core;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
class GsonSerializer implements zendesk.core.Serializer {

    private static final String LOG_TAG = "GsonSerializer";
    private final Gson gson;
    GsonSerializer(Gson gson) {
        super();
        this.gson = gson;
    }

    public <E> E deserialize(Object object, Class<E> class2) {
        boolean z;
        Object obj5;
        Object obj6;
        if (object instanceof String != null) {
            if (g.c((String)object)) {
                return this.gson.fromJson(object, class2);
            }
        } else {
            if (object instanceof JsonElement) {
                return this.gson.fromJson((JsonElement)object, class2);
            }
            obj5 = new Object[1];
            a.b("GsonSerializer", "Unable to deserialize the provided object into %s", class2.getSimpleName());
        }
        return 0;
    }

    @Override // zendesk.core.Serializer
    public String serialize(Object object) {
        return this.gson.toJson(object);
    }
}
