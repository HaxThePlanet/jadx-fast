package com.facebook.e0.r.g;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0008R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0008¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "name", "", "getName", "()Ljava/lang/String;", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "getPath", "()Ljava/util/List;", "pathType", "getPathType", "value", "getValue", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private final String a;
    private final String b;
    private final List<com.facebook.e0.r.g.c> c;
    private final String d;
    static {
    }

    public b(JSONObject jSONObject) {
        int str;
        int length;
        com.facebook.e0.r.g.c cVar;
        JSONObject jSONObject2;
        String str2;
        n.f(jSONObject, "component");
        super();
        String string = jSONObject.getString("name");
        n.e(string, "component.getString(PARAMETER_NAME_KEY)");
        this.a = string;
        String optString = jSONObject.optString("value");
        n.e(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.b = optString;
        String optString2 = jSONObject.optString("path_type", "absolute");
        n.e(optString2, "component.optString(Cons…tants.PATH_TYPE_ABSOLUTE)");
        this.d = optString2;
        ArrayList arrayList = new ArrayList();
        final JSONArray obj7 = jSONObject.optJSONArray("path");
        if (obj7 != null) {
            str = 0;
            while (str < obj7.length()) {
                jSONObject2 = obj7.getJSONObject(str);
                n.e(jSONObject2, "jsonPathArray.getJSONObject(i)");
                cVar = new c(jSONObject2);
                arrayList.add(cVar);
                str++;
            }
        }
        this.c = arrayList;
    }

    public final String a() {
        return this.a;
    }

    public final List<com.facebook.e0.r.g.c> b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }
}
