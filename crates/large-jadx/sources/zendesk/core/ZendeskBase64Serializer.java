package zendesk.core;

import android.util.Base64;
import f.g.c.a;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class ZendeskBase64Serializer implements zendesk.core.Serializer {

    private static final String LOG_TAG = "ZendeskBase64Serializer";
    private zendesk.core.Serializer jsonSerializer;
    ZendeskBase64Serializer(zendesk.core.Serializer serializer) {
        super();
        this.jsonSerializer = serializer;
    }

    public <E> E deserialize(Object object, Class<E> class2) {
        if (object instanceof String != null) {
            String string = new String(Base64.decode((String)object, 2));
            return this.jsonSerializer.deserialize(string, class2);
        }
        a.k("ZendeskBase64Serializer", "Data was not of type string. Cannot deserialize. Returning null.", new Object[0]);
        return 0;
    }

    @Override // zendesk.core.Serializer
    public String serialize(Object object) {
        String obj2 = this.jsonSerializer.serialize(object);
        if (obj2 != null) {
            return Base64.encodeToString(obj2.getBytes(Charset.defaultCharset()), 2);
        }
        return null;
    }
}
