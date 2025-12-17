package com.facebook.e0;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.e0.q.c;
import com.facebook.e0.q.c.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.y.q0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001f\u001a\u00020 H\u0007J\u0008\u0010!\u001a\u00020\u0004H\u0007J\r\u0010\"\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008#J\u0008\u0010$\u001a\u00020 H\u0002J\u0008\u0010%\u001a\u00020 H\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J\u001c\u0010+\u001a\u00020 2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0015H\u0007J\u0012\u0010-\u001a\u00020 2\u0008\u0010,\u001a\u0004\u0018\u00010.H\u0007Jl\u0010-\u001a\u00020 2\u0008\u0010/\u001a\u0004\u0018\u00010\u00042\u0008\u00100\u001a\u0004\u0018\u00010\u00042\u0008\u00101\u001a\u0004\u0018\u00010\u00042\u0008\u00102\u001a\u0004\u0018\u00010\u00042\u0008\u00103\u001a\u0004\u0018\u00010\u00042\u0008\u00104\u001a\u0004\u0018\u00010\u00042\u0008\u00105\u001a\u0004\u0018\u00010\u00042\u0008\u00106\u001a\u0004\u0018\u00010\u00042\u0008\u00107\u001a\u0004\u0018\u00010\u00042\u0008\u00108\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00109\u001a\u00020 2\u0008\u0010,\u001a\u0004\u0018\u00010.H\u0002J\u0018\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u0006=", d2 = {"Lcom/facebook/appevents/UserDataStore;", "", "()V", "CITY", "", "COUNTRY", "DATA_SEPARATOR", "DATE_OF_BIRTH", "EMAIL", "FIRST_NAME", "GENDER", "INTERNAL_USER_DATA_KEY", "LAST_NAME", "MAX_NUM", "", "PHONE", "STATE", "TAG", "USER_DATA_KEY", "ZIP", "enabledInternalUserData", "", "getEnabledInternalUserData", "()Ljava/util/Map;", "externalHashedUserData", "Ljava/util/concurrent/ConcurrentHashMap;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "internalHashedUserData", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "getAllHashedUserData", "getHashedUserData", "getHashedUserData$facebook_core_release", "initAndWait", "initStore", "maybeSHA256Hashed", "", "data", "normalizeData", "type", "setInternalUd", "ud", "setUserDataAndHash", "Landroid/os/Bundle;", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "updateHashUserData", "writeDataIntoCache", "key", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class p {

    private static final String a;
    private static SharedPreferences b;
    private static final AtomicBoolean c;
    private static final ConcurrentHashMap<String, String> d;
    private static final ConcurrentHashMap<String, String> e;
    public static final com.facebook.e0.p f;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final String a;
        final String b;
        a(String string, String string2) {
            this.a = string;
            this.b = string2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            com.facebook.e0.p pVar = p.f;
            if (!p.a(pVar).get()) {
                p.c(pVar);
            }
            p.b(pVar).edit().putString(this.a, this.b).apply();
        }
    }
    static {
        p pVar = new p();
        p.f = pVar;
        String simpleName = p.class.getSimpleName();
        n.e(simpleName, "UserDataStore::class.java.simpleName");
        p.a = simpleName;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        p.c = atomicBoolean;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        p.d = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        p.e = concurrentHashMap2;
    }

    public static final AtomicBoolean a(com.facebook.e0.p p) {
        if (a.d(p.class)) {
            return null;
        }
        return p.c;
    }

    public static final SharedPreferences b(com.facebook.e0.p p) {
        final int i = 0;
        if (a.d(p.class)) {
            return i;
        }
        SharedPreferences sharedPreferences = p.b;
        if (sharedPreferences == null) {
        } else {
            return sharedPreferences;
        }
        n.w("sharedPreferences");
        throw i;
    }

    public static final void c(com.facebook.e0.p p) {
        if (a.d(p.class)) {
        }
        p.f();
    }

    public static final String d() {
        boolean z;
        if (a.d(p.class)) {
            return null;
        }
        if (!p.c.get()) {
            p.f.f();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(p.d);
        hashMap.putAll(p.f.e());
        return b0.f0(hashMap);
    }

    private final Map<String, String> e() {
        Object next;
        boolean contains;
        if (a.d(this)) {
            return 0;
        }
        HashMap hashMap = new HashMap();
        Iterator iterator = p.e.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (c.e.b().contains((String)next)) {
            }
            hashMap.put(next, p.e.get(next));
        }
        return hashMap;
    }

    private final void f() {
        String string2;
        String string;
        synchronized (this) {
            try {
                AtomicBoolean bool = p.c;
                if (bool.get()) {
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
                n.e(defaultSharedPreferences, "PreferenceManager.getDef….getApplicationContext())");
                p.b = defaultSharedPreferences;
                int i2 = 0;
            } catch (Throwable th) {
            }
            if (defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "") != null) {
            } else {
                string2 = "";
            }
            n.e(string2, "sharedPreferences.getStr…(USER_DATA_KEY, \"\") ?: \"\"");
            SharedPreferences sharedPreferences = p.b;
            if (sharedPreferences == null) {
            } else {
                try {
                    if (sharedPreferences.getString("com.facebook.appevents.UserDataStore.internalUserData", "") != null) {
                    } else {
                    }
                    string = "";
                    n.e(string, "sharedPreferences.getStr…_USER_DATA_KEY, \"\") ?: \"\"");
                    p.d.putAll(b0.b0(string2));
                    p.e.putAll(b0.b0(string));
                    bool.set(true);
                    n.w("sharedPreferences");
                    throw i2;
                    n.w("sharedPreferences");
                    throw i2;
                }
            }
        }
    }

    public static final void g() {
        if (a.d(p.class)) {
        }
        if (p.c.get()) {
        }
        p.f.f();
    }

    private final String h(String string, String string2) {
        int i3;
        int i4;
        int i2;
        String str;
        int i5;
        int i;
        int i6;
        int obj9;
        String obj10;
        if (a.d(this)) {
            return null;
        }
        final int i9 = 1;
        length -= i9;
        final int i10 = 0;
        i2 = i4;
        while (i4 <= i3) {
            if (i2 == 0) {
            } else {
            }
            i = i3;
            if (n.h(string2.charAt(i), 32) <= 0) {
            } else {
            }
            i5 = i10;
            if (i2 != 0) {
                break;
            } else {
            }
            if (i5 == 0) {
                break;
            } else {
            }
            i3--;
            if (i5 == 0) {
            } else {
            }
            i4++;
            i2 = i9;
            i5 = i9;
            i = i4;
        }
        obj10 = string2.subSequence(i4, i3 += i9).toString();
        String str2 = "null cannot be cast to non-null type java.lang.String";
        if (obj10 == null) {
        } else {
            obj10 = obj10.toLowerCase();
            n.e(obj10, "(this as java.lang.String).toLowerCase()");
            str = "";
            if (n.b("em", string)) {
                if (Patterns.EMAIL_ADDRESS.matcher(obj10).matches()) {
                } else {
                    Log.e(p.a, "Setting email failure: this is not a valid email address");
                    obj10 = str;
                }
                return obj10;
            }
            if (n.b("ph", string)) {
                h hVar = new h("[^0-9]");
                return hVar.e(obj10, str);
            }
            if (n.b("ge", string)) {
                obj9 = obj10.length() > 0 ? i9 : i10;
                if (obj9 != null) {
                    if (obj10 == null) {
                    } else {
                        n.e(obj10.substring(i10, i9), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (!n.b("f", obj9)) {
                            if (n.b("m", obj9)) {
                                str = obj9;
                            } else {
                                Log.e(p.a, "Setting gender failure: the supported value for gender is f or m");
                            }
                        } else {
                        }
                        return str;
                    }
                    obj9 = new NullPointerException(str2);
                    throw obj9;
                }
                obj9 = str;
            }
            return obj10;
        }
        obj9 = new NullPointerException(str2);
        throw obj9;
    }

    public static final void i(Map<String, String> map) {
        boolean z;
        String str;
        Object key2;
        Object string;
        Object obj;
        String key;
        int i2;
        int i;
        int i4;
        String[] strArr;
        Set strArr2;
        StringBuilder stringBuilder;
        int i3;
        int length;
        int i5;
        if (a.d(p.class)) {
        }
        n.f(map, "ud");
        if (!p.c.get()) {
            p.f.f();
        }
        Iterator obj12 = map.entrySet().iterator();
        for (Map.Entry next2 : obj12) {
            key2 = next2.getKey();
            Object value = next2.getValue();
            i = 1;
            length2 -= i;
            i4 = 0;
            strArr2 = strArr;
            while (strArr <= i2) {
                if (strArr2 == 0) {
                } else {
                }
                i3 = i2;
                if (n.h(value.charAt(i3), 32) <= 0) {
                } else {
                }
                stringBuilder = i4;
                if (strArr2 != 0) {
                    break loop_7;
                } else {
                }
                if (stringBuilder == null) {
                    break loop_7;
                } else {
                }
                i2--;
                if (stringBuilder == null) {
                } else {
                }
                strArr++;
                strArr2 = i;
                stringBuilder = i;
                i3 = strArr;
            }
            z = b0.y0(p.f.h((String)key2, value.subSequence(strArr, i2++).toString()));
            string = p.e;
            string.put(key2, z);
            obj = string.get(key2);
            key = ",";
            strArr = new String[i4];
            strArr2 = q0.e((String[])Arrays.copyOf(strArr, strArr.length));
            stringBuilder = new StringBuilder();
            if (strArr.length == 0) {
            } else {
            }
            length = i4;
            if (length != 0) {
            } else {
            }
            i5 = 5;
            if (strArr.length < i5) {
            }
            while (i < i5) {
                stringBuilder.append(strArr[i]);
                stringBuilder.append(key);
                i++;
            }
            stringBuilder.append(z);
            strArr2.remove(strArr[i4]);
            p.e.put(key2, stringBuilder.toString());
            stringBuilder.append(strArr[i]);
            stringBuilder.append(key);
            i++;
            stringBuilder.append((String)obj);
            stringBuilder.append(key);
            stringBuilder.append(z);
            n.e(stringBuilder, "sb.append(originalVal).a…_SEPARATOR).append(value)");
            stringBuilder.append(z);
            n.e(stringBuilder, "sb.append(value)");
            length = i;
            h hVar = new h(key);
            strArr = hVar.f(obj, i4);
            strArr = strArr.toArray(new String[i4]);
            if ((String[])strArr != null) {
            } else {
            }
            if (strArr2 == 0) {
            } else {
            }
            i3 = i2;
            if (n.h(value.charAt(i3), 32) <= 0) {
            } else {
            }
            stringBuilder = i4;
            if (strArr2 == 0) {
            } else {
            }
            if (stringBuilder == null) {
            } else {
            }
            i2--;
            if (stringBuilder == null) {
            } else {
            }
            strArr++;
            strArr2 = i;
            stringBuilder = i;
            i3 = strArr;
        }
        p.f.j("com.facebook.appevents.UserDataStore.internalUserData", b0.f0(p.e));
    }

    private final void j(String string, String string2) {
        if (a.d(this)) {
        }
        p.a aVar = new p.a(string, string2);
        o.n().execute(aVar);
    }
}
