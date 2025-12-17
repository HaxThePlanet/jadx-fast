package com.facebook.e0.r.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\u0018\u0000 \"2\u00020\u0001:\u0003!\"#BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\r0\n8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\u0008 \u0010\u001e¨\u0006$", d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding;", "", "eventName", "", "method", "Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "type", "Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "appVersion", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "parameters", "Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "componentId", "pathType", "activityName", "(Ljava/lang/String;Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getAppVersion", "getComponentId", "getEventName", "getMethod", "()Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "getPathType", "getType", "()Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "viewParameters", "getViewParameters", "()Ljava/util/List;", "viewPath", "getViewPath", "ActionType", "Companion", "MappingMethod", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    public static final com.facebook.e0.r.g.a.b e;
    private final String a;
    private final List<com.facebook.e0.r.g.c> b;
    private final List<com.facebook.e0.r.g.b> c;
    private final String d;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "", "(Ljava/lang/String;I)V", "CLICK", "SELECTED", "TEXT_CHANGED", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        CLICK,
        SELECTED,
        TEXT_CHANGED;
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$Companion;", "", "()V", "getInstanceFromJson", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Lorg/json/JSONObject;", "parseArray", "", "array", "Lorg/json/JSONArray;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public final com.facebook.e0.r.g.a a(JSONObject jSONObject) {
            String length;
            int i;
            int i2;
            JSONObject jSONObject3;
            com.facebook.e0.r.g.c jSONObject2;
            String bVar;
            String str;
            n.f(jSONObject, "mapping");
            final String string2 = jSONObject.getString("event_name");
            String string = jSONObject.getString("method");
            n.e(string, "mapping.getString(\"method\")");
            Locale eNGLISH = Locale.ENGLISH;
            String str17 = "Locale.ENGLISH";
            n.e(eNGLISH, str17);
            String str18 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(string, str18);
            String upperCase = string.toUpperCase(eNGLISH);
            String str19 = "(this as java.lang.String).toUpperCase(locale)";
            n.e(upperCase, str19);
            String string4 = jSONObject.getString("event_type");
            n.e(string4, "mapping.getString(\"event_type\")");
            n.e(eNGLISH, str17);
            Objects.requireNonNull(string4, str18);
            String upperCase2 = string4.toUpperCase(eNGLISH);
            n.e(upperCase2, str19);
            String string3 = jSONObject.getString("app_version");
            JSONArray jSONArray = jSONObject.getJSONArray("path");
            ArrayList arrayList = new ArrayList();
            i2 = i;
            while (i2 < jSONArray.length()) {
                jSONObject3 = jSONArray.getJSONObject(i2);
                n.e(jSONObject3, "jsonPath");
                jSONObject2 = new c(jSONObject3);
                arrayList.add(jSONObject2);
                i2++;
            }
            String optString = jSONObject.optString("path_type", "absolute");
            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null) {
                while (i < optJSONArray.length()) {
                    jSONObject2 = optJSONArray.getJSONObject(i);
                    n.e(jSONObject2, "jsonParameter");
                    bVar = new b(jSONObject2);
                    arrayList2.add(bVar);
                    i++;
                }
            }
            String optString2 = jSONObject.optString("component_id");
            final String obj14 = jSONObject.optString("activity_name");
            n.e(string2, "eventName");
            n.e(string3, "appVersion");
            n.e(optString2, "componentId");
            n.e(optString, "pathType");
            n.e(obj14, "activityName");
            super(string2, a.c.valueOf(upperCase), a.a.valueOf(upperCase2), string3, arrayList, arrayList2, optString2, optString, obj14);
            return aVar2;
        }

        public final List<com.facebook.e0.r.g.a> b(JSONArray jSONArray) {
            int i;
            int length;
            com.facebook.e0.r.g.a aVar;
            String str;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    n.e(jSONObject, "array.getJSONObject(i)");
                    arrayList.add(a(jSONObject));
                    i++;
                }
            }
            return arrayList;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "", "(Ljava/lang/String;I)V", "MANUAL", "INFERENCE", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum c {

        MANUAL,
        INFERENCE;
    }
    static {
        a.b bVar = new a.b(0);
        a.e = bVar;
    }

    public a(String string, com.facebook.e0.r.g.a.c a$c2, com.facebook.e0.r.g.a.a a$a3, String string4, List<com.facebook.e0.r.g.c> list5, List<com.facebook.e0.r.g.b> list6, String string7, String string8, String string9) {
        n.f(string, "eventName");
        n.f(c2, "method");
        n.f(a3, "type");
        n.f(string4, "appVersion");
        n.f(list5, "path");
        n.f(list6, "parameters");
        n.f(string7, "componentId");
        n.f(string8, "pathType");
        n.f(string9, "activityName");
        super();
        this.a = string;
        this.b = list5;
        this.c = list6;
        this.d = string9;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.a;
    }

    public final List<com.facebook.e0.r.g.b> c() {
        List unmodifiableList = Collections.unmodifiableList(this.c);
        n.e(unmodifiableList, "Collections.unmodifiableList(parameters)");
        return unmodifiableList;
    }

    public final List<com.facebook.e0.r.g.c> d() {
        List unmodifiableList = Collections.unmodifiableList(this.b);
        n.e(unmodifiableList, "Collections.unmodifiableList(path)");
        return unmodifiableList;
    }
}
