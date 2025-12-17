package com.facebook.share.a;

import com.facebook.share.b.e;
import com.facebook.share.b.g;
import com.facebook.share.b.h;
import com.facebook.share.b.i;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007¨\u0006\u0012", d2 = {"Lcom/facebook/share/internal/OpenGraphJSONUtility;", "", "()V", "toJSONArray", "Lorg/json/JSONArray;", "list", "", "photoJSONProcessor", "Lcom/facebook/share/internal/OpenGraphJSONUtility$PhotoJSONProcessor;", "toJSONObject", "Lorg/json/JSONObject;", "action", "Lcom/facebook/share/model/ShareOpenGraphAction;", "graphObject", "Lcom/facebook/share/model/ShareOpenGraphObject;", "toJSONValue", "value", "PhotoJSONProcessor", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    public static final com.facebook.share.a.b a;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/share/internal/OpenGraphJSONUtility$PhotoJSONProcessor;", "", "toJSONObject", "Lorg/json/JSONObject;", "photo", "Lcom/facebook/share/model/SharePhoto;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract JSONObject a(i i);
    }
    static {
        b bVar = new b();
        b.a = bVar;
    }

    private final JSONArray a(List<?> list, com.facebook.share.a.b.a b$a2) {
        Object obj;
        JSONArray jSONArray = new JSONArray();
        final Iterator obj3 = list.iterator();
        for (Object next2 : obj3) {
            jSONArray.put(b.d(next2, a2));
        }
        return jSONArray;
    }

    public static final JSONObject b(e e, com.facebook.share.a.b.a b$a2) {
        Object next;
        Object obj;
        if (e == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator iterator = e.d().iterator();
        for (String next : iterator) {
            jSONObject.put(next, b.d(e.a(next), a2));
        }
        return jSONObject;
    }

    private final JSONObject c(g g, com.facebook.share.a.b.a b$a2) {
        Object next;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        Iterator iterator = g.d().iterator();
        for (String next : iterator) {
            jSONObject.put(next, b.d(g.a(next), a2));
        }
        return jSONObject;
    }

    public static final Object d(Object object, com.facebook.share.a.b.a b$a2) {
        int i;
        boolean z;
        if (object == null) {
            return JSONObject.NULL;
        }
        if (object instanceof String == null && !object instanceof Boolean && !object instanceof Double && !object instanceof Float && !object instanceof Integer) {
            if (!object instanceof Boolean) {
                if (!object instanceof Double) {
                    if (!object instanceof Float) {
                        if (!object instanceof Integer) {
                            if (object instanceof Long) {
                            } else {
                                if (object instanceof i && a2 != null) {
                                    if (a2 != null) {
                                        i = a2.a((i)object);
                                    }
                                    return i;
                                }
                                if (object instanceof g) {
                                    return b.a.c((g)object, a2);
                                }
                                if (object instanceof List != null) {
                                    return b.a.a((List)object, a2);
                                }
                            }
                            return null;
                        }
                    }
                }
            }
        }
        return object;
    }
}
