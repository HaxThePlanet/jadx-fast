package com.facebook.e0.r.g;

import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0008R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0008R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0008¨\u0006\u001b", d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "className", "", "getClassName", "()Ljava/lang/String;", "description", "getDescription", "hint", "getHint", "id", "", "getId", "()I", "index", "getIndex", "matchBitmask", "getMatchBitmask", "tag", "getTag", "text", "getText", "Companion", "MatchBitmaskType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private final String a;
    private final int b;
    private final int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$MatchBitmaskType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ID", "TEXT", "TAG", "DESCRIPTION", "HINT", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        ID(true),
        TEXT(false),
        TAG(true),
        DESCRIPTION(8),
        HINT(false);

        private final int value;
        @Override // java.lang.Enum
        public final int getValue() {
            return this.value;
        }
    }
    static {
    }

    public c(JSONObject jSONObject) {
        n.f(jSONObject, "component");
        super();
        String string = jSONObject.getString("class_name");
        n.e(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.a = string;
        this.b = jSONObject.optInt("index", -1);
        this.c = jSONObject.optInt("id");
        String optString = jSONObject.optString("text");
        n.e(optString, "component.optString(PATH_TEXT_KEY)");
        this.d = optString;
        String optString2 = jSONObject.optString("tag");
        n.e(optString2, "component.optString(PATH_TAG_KEY)");
        this.e = optString2;
        String optString3 = jSONObject.optString("description");
        n.e(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.f = optString3;
        String optString4 = jSONObject.optString("hint");
        n.e(optString4, "component.optString(PATH_HINT_KEY)");
        this.g = optString4;
        this.h = jSONObject.optInt("match_bitmask");
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final int f() {
        return this.h;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.d;
    }
}
