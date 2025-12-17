package com.facebook.e0;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.e0.s.a;
import com.facebook.e0.u.a;
import com.facebook.e0.v.b;
import com.facebook.e0.y.a;
import com.facebook.internal.b0;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.v;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.w;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(BE\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB)\u0008\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u0008\u0010\u001d\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0017J;\u0010 \u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010!J\u0008\u0010\"\u001a\u00020\u0003H\u0016J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0008\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006)", d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", "contextName", "", "eventName", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "isImplicitlyLogged", "", "isInBackground", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;)V", "jsonString", "isImplicit", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "isChecksumValid", "()Z", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "name", "getName", "()Ljava/lang/String;", "calculateChecksum", "getIsImplicit", "getJSONObject", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/JSONObject;", "toString", "validateParameters", "", "writeReplace", "", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c implements Serializable {

    private static final HashSet<String> a = null;
    public static final com.facebook.e0.c.a b = null;
    private static final long serialVersionUID = 1L;
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0008j\u0008\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", "", "()V", "MAX_IDENTIFIER_LENGTH", "", "serialVersionUID", "", "validatedIdentifiers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "md5Checksum", "toHash", "validateIdentifier", "", "identifier", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final String a(com.facebook.e0.c.a c$a, String string2) {
            return a.c(string2);
        }

        public static final void b(com.facebook.e0.c.a c$a, String string2) {
            a.d(string2);
        }

        private final String c(String string) {
            final String str = "Failed to generate checksum: ";
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Charset forName = Charset.forName("UTF-8");
            n.e(forName, "Charset.forName(charsetName)");
            if (string == null) {
            } else {
                byte[] obj5 = string.getBytes(forName);
                n.e(obj5, "(this as java.lang.String).getBytes(charset)");
                instance.update(obj5, 0, obj5.length);
                obj5 = instance.digest();
                n.e(obj5, "digest.digest()");
                return b.c(obj5);
            }
            try {
                obj5 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                throw obj5;
                b0.c0(obj0, string);
                string = "1";
                return string;
                b0.c0(obj0, string);
                string = "0";
                return string;
            }
        }

        private final void d(String string) {
            Object str;
            HashSet set;
            int length;
            Object obj9;
            int i = 40;
            final int i2 = 1;
            final int i3 = 0;
            if (string != null) {
                length = string.length() == 0 ? i2 : i3;
                if (length == 0) {
                    if (string.length() > i) {
                    } else {
                        set = c.a();
                        w wVar = w.a;
                        synchronized (set) {
                            set = c.a();
                            wVar = w.a;
                        }
                        h hVar = new h("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$");
                        if (!hVar.d(string)) {
                        } else {
                            str = c.a();
                            c.a().add(string);
                            synchronized (str) {
                                str = c.a();
                                c.a().add(string);
                            }
                        }
                        f0 f0Var = f0.a;
                        Object[] arr = new Object[i2];
                        arr[i3] = string;
                        obj9 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(arr, i2));
                        n.e(obj9, "java.lang.String.format(format, *args)");
                        FacebookException facebookException2 = new FacebookException(obj9);
                        throw facebookException2;
                    }
                }
            }
            if (string != null) {
            } else {
                obj9 = "<None Provided>";
            }
            f0 f0Var2 = f0.a;
            final int i4 = 2;
            final Object[] arr2 = new Object[i4];
            arr2[i3] = obj9;
            arr2[i2] = Integer.valueOf(i);
            obj9 = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(arr2, i4));
            n.e(obj9, "java.lang.String.format(locale, format, *args)");
            FacebookException facebookException = new FacebookException(obj9);
            throw facebookException;
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", "", "isImplicit", "", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Serializable {

        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;
        static {
        }

        public b(String string, boolean z2, boolean z3, String string4) {
            n.f(string, "jsonString");
            super();
            this.jsonString = string;
            this.isImplicit = z2;
            this.inBackground = z3;
            this.checksum = string4;
        }

        private final Object readResolve() {
            super(this.jsonString, this.isImplicit, this.inBackground, this.checksum, 0);
            return cVar2;
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.b = aVar;
        HashSet hashSet = new HashSet();
        c.a = hashSet;
    }

    public c(String string, String string2, Double double3, Bundle bundle4, boolean z5, boolean z6, UUID uUID7) {
        n.f(string, "contextName");
        n.f(string2, "eventName");
        super();
        this.isImplicit = z5;
        this.inBackground = z6;
        this.name = string2;
        this.jsonObject = this.d(string, string2, double3, bundle4, uUID7);
        this.checksum = b();
    }

    private c(String string, boolean z2, boolean z3, String string4) {
        super();
        JSONObject jSONObject = new JSONObject(string);
        this.jsonObject = jSONObject;
        this.isImplicit = z2;
        String obj2 = jSONObject.optString("_eventName");
        n.e(obj2, "jsonObject.optString(Con…nts.EVENT_NAME_EVENT_KEY)");
        this.name = obj2;
        this.checksum = string4;
        this.inBackground = z3;
    }

    public c(String string, boolean z2, boolean z3, String string4, g g5) {
        super(string, z2, z3, string4);
    }

    public static final HashSet a() {
        return c.a;
    }

    private final String b() {
        Object next2;
        boolean next;
        JSONObject jsonObject;
        if (Build.VERSION.SDK_INT > 19) {
            String string2 = this.jsonObject.toString();
            n.e(string2, "jsonObject.toString()");
            return c.a.a(c.b, string2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator keys = this.jsonObject.keys();
        for (Object next2 : keys) {
            arrayList.add(next2);
        }
        p.w(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = arrayList.iterator();
        for (String next4 : iterator) {
            stringBuilder.append(next4);
            stringBuilder.append(" = ");
            stringBuilder.append(this.jsonObject.optString(next4));
            stringBuilder.append(true);
        }
        String string = stringBuilder.toString();
        n.e(string, "sb.toString()");
        return c.a.a(c.b, string);
    }

    private final JSONObject d(String string, String string2, Double double3, Bundle bundle4, UUID uUID5) {
        String str;
        Object obj7;
        Object obj8;
        String obj9;
        Bundle obj10;
        Object obj11;
        com.facebook.e0.c.a aVar = c.b;
        c.a.b(aVar, string2);
        JSONObject jSONObject = new JSONObject();
        obj8 = a.e(string2);
        jSONObject.put("_eventName", obj8);
        jSONObject.put("_eventName_md5", c.a.a(aVar, obj8));
        jSONObject.put("_logTime", currentTimeMillis /= l);
        jSONObject.put("_ui", string);
        if (uUID5 != null) {
            jSONObject.put("_session_id", uUID5);
        }
        if (bundle4 != null) {
            obj7 = i(bundle4);
            obj8 = obj7.keySet().iterator();
            for (String obj10 : obj8) {
                jSONObject.put(obj10, obj7.get(obj10));
            }
        }
        if (double3 != null) {
            jSONObject.put("_valueToSum", double3.doubleValue());
        }
        obj8 = "1";
        if (this.inBackground) {
            jSONObject.put("_inBackground", obj8);
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", obj8);
        } else {
            obj9 = new Object[1];
            obj11 = jSONObject.toString();
            n.e(obj11, "eventObject.toString()");
            v.f.c(v.APP_EVENTS, "AppEvents", "Created app event '%s'", obj11);
        }
        return jSONObject;
    }

    private final Map<String, String> i(Bundle bundle) {
        Object next;
        String string;
        boolean z;
        HashMap hashMap = new HashMap();
        Iterator iterator = bundle.keySet().iterator();
        for (String next : iterator) {
            n.e(next, "key");
            c.a.b(c.b, next);
            Object obj = bundle.get(next);
            hashMap.put(next, obj.toString());
        }
        a.c(hashMap);
        a.f(g0.c(hashMap), this.name);
        a.c(g0.c(hashMap), this.name);
        return hashMap;
    }

    private final Object writeReplace() {
        String string = this.jsonObject.toString();
        n.e(string, "jsonObject.toString()");
        c.b bVar = new c.b(string, this.isImplicit, this.inBackground, this.checksum);
        return bVar;
    }

    @Override // java.io.Serializable
    public final boolean c() {
        return this.isImplicit;
    }

    @Override // java.io.Serializable
    public final JSONObject e() {
        return this.jsonObject;
    }

    @Override // java.io.Serializable
    public final String f() {
        return this.name;
    }

    @Override // java.io.Serializable
    public final boolean g() {
        int i;
        String checksum;
        if (this.checksum == null) {
            i = 1;
        } else {
            i = n.b(b(), this.checksum);
        }
        return i;
    }

    @Override // java.io.Serializable
    public final boolean h() {
        return this.isImplicit;
    }

    @Override // java.io.Serializable
    public String toString() {
        f0 f0Var = f0.a;
        int i = 3;
        Object[] arr = new Object[i];
        arr[0] = this.jsonObject.optString("_eventName");
        arr[1] = Boolean.valueOf(this.isImplicit);
        arr[2] = this.jsonObject.toString();
        String format = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
