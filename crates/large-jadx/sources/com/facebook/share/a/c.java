package com.facebook.share.a;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.p.g;
import com.facebook.share.b.f;
import com.facebook.share.b.i;
import com.facebook.t;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    static class a implements com.facebook.share.a.b.a {
        @Override // com.facebook.share.a.b$a
        public JSONObject a(i i) {
            Uri obj3 = i.a();
            if (!b0.Y(obj3)) {
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", obj3.toString());
                return jSONObject;
            }
            obj3 = new FacebookException("Only web images may be used in OG objects shared via the web dialog");
            throw obj3;
        }
    }
    public static Pair<String, String> a(String string) {
        String substring;
        int length;
        int i;
        String obj5;
        final int i3 = 0;
        if (a.d(c.class)) {
            return i3;
        }
        int indexOf = string.indexOf(58);
        i = indexOf + 1;
        if (indexOf != -1 && string.length() > i) {
            i = indexOf + 1;
            if (string.length() > i) {
                substring = string.substring(0, indexOf);
                obj5 = string.substring(i);
            } else {
                substring = i3;
            }
        } else {
        }
        Pair pair = new Pair(substring, obj5);
        return pair;
    }

    public static p b(a a, Uri uri2, p.b p$b3) {
        if (a.d(c.class)) {
            return null;
        }
        if (b0.U(uri2)) {
            File file = new File(uri2.getPath());
            return c.c(a, file, b3);
        }
        if (!b0.R(uri2)) {
        } else {
            p.g gVar = new p.g(uri2, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", gVar);
            super(a, "me/staging_resources", bundle, t.POST, b3);
            return obj11;
        }
        FacebookException obj10 = new FacebookException("The image Uri must be either a file:// or content:// Uri");
        throw obj10;
    }

    public static p c(a a, File file2, p.b p$b3) {
        if (a.d(c.class)) {
            return null;
        }
        p.g gVar = new p.g(ParcelFileDescriptor.open(file2, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", gVar);
        super(a, "me/staging_resources", bundle, t.POST, b3);
        return obj11;
    }

    public static JSONArray d(JSONArray jSONArray, boolean z2) {
        int i;
        Object obj;
        boolean z;
        if (a.d(c.class)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        i = 0;
        while (i < jSONArray.length()) {
            obj = jSONArray.get(i);
            if (obj instanceof JSONArray != null) {
            } else {
            }
            if (obj instanceof JSONObject != null) {
            }
            jSONArray2.put(obj);
            i++;
            obj = c.e((JSONObject)obj, z2);
            obj = c.d((JSONArray)obj, z2);
        }
        return jSONArray2;
    }

    public static JSONObject e(JSONObject jSONObject, boolean z2) {
        int i;
        boolean string;
        JSONObject jSONObject2;
        Object second;
        boolean z;
        Object equals;
        boolean equals2;
        int obj11;
        final int i2 = 0;
        if (a.d(c.class)) {
            return i2;
        }
        if (jSONObject == null) {
            return i2;
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        final JSONArray names = jSONObject.names();
        i = 0;
        while (i < names.length()) {
            string = names.getString(i);
            jSONObject2 = jSONObject.get(string);
            int i3 = 1;
            if (jSONObject2 instanceof JSONObject != null) {
            } else {
            }
            if (jSONObject2 instanceof JSONArray != null) {
            }
            Pair pair = c.a(string);
            equals = pair.first;
            second = pair.second;
            if (z2 != null) {
            } else {
            }
            if (equals != null && (String)equals.equals("fb")) {
            } else {
            }
            jSONObject3.put((String)second, jSONObject2);
            i++;
            if (equals.equals("fb")) {
            } else {
            }
            jSONObject3.put(string, jSONObject2);
            if (equals != null && equals.equals("fbsdk")) {
            } else {
            }
            if (equals != null) {
            } else {
            }
            jSONObject3.put(second, jSONObject2);
            if (equals.equals("og")) {
            } else {
            }
            jSONObject4.put(second, jSONObject2);
            if (equals.equals("fbsdk")) {
            } else {
            }
            jSONObject3.put(string, jSONObject2);
            jSONObject2 = c.d((JSONArray)jSONObject2, i3);
            jSONObject2 = c.e((JSONObject)jSONObject2, i3);
        }
        if (jSONObject4.length() > 0) {
            jSONObject3.put("data", jSONObject4);
        }
        return jSONObject3;
    }

    public static JSONObject f(f f) {
        if (a.d(c.class)) {
            return null;
        }
        c.a aVar = new c.a();
        return b.b(f.d(), aVar);
    }
}
