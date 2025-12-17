package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "context", "Landroid/content/Context;", "cacheKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cache", "Landroid/content/SharedPreferences;", "clear", "", "deserializeKey", "key", "bundle", "Landroid/os/Bundle;", "load", "save", "serializeKey", "editor", "Landroid/content/SharedPreferences$Editor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class u {

    private static final String c;
    public static final com.facebook.u.a d;
    private final String a;
    private final SharedPreferences b;

    @Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0007J\u001e\u0010*\u001a\u0004\u0018\u00010+2\u0008\u0010(\u001a\u0004\u0018\u00010)2\u0008\u0010,\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010.\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001022\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00106\u001a\u0002072\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u001a\u00108\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0008\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010;\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0008\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020+H\u0002J\u001e\u0010=\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010?\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020+H\u0007J\u0018\u0010@\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\nH\u0007J\u001e\u0010A\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010B\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020+H\u0007J\u0018\u0010C\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\nH\u0007J\u001e\u0010D\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010E\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u000204H\u0007J\u0018\u0010F\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "()V", "APPLICATION_ID_KEY", "", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "TAG", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "getApplicationId", "bundle", "Landroid/os/Bundle;", "getDate", "Ljava/util/Date;", "key", "getExpirationDate", "getExpirationMilliseconds", "getLastRefreshDate", "getLastRefreshMilliseconds", "getPermissions", "", "getSource", "Lcom/facebook/AccessTokenSource;", "getToken", "hasTokenInformation", "", "putApplicationId", "", "value", "putDate", "date", "putDeclinedPermissions", "", "putExpirationDate", "putExpirationMilliseconds", "putExpiredPermissions", "putLastRefreshDate", "putLastRefreshMilliseconds", "putPermissions", "putSource", "putToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final Date b(Bundle bundle, String string2) {
            int date;
            if (bundle == null) {
                return null;
            }
            long l = Long.MIN_VALUE;
            final long obj4 = bundle.getLong(string2, l);
            if (Long.compare(obj4, l) == 0) {
            } else {
                date = new Date(obj4, string2);
            }
            return date;
        }

        public final String a(Bundle bundle) {
            n.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
        }

        public final Date c(Bundle bundle) {
            n.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        public final Date d(Bundle bundle) {
            n.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        public final com.facebook.f e(Bundle bundle) {
            String str;
            Object obj3;
            n.f(bundle, "bundle");
            str = "com.facebook.TokenCachingStrategy.AccessTokenSource";
            if (bundle.containsKey(str)) {
                obj3 = bundle.getSerializable(str);
            } else {
                obj3 = bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? f.FACEBOOK_APPLICATION_WEB : f.WEB_VIEW;
            }
            return obj3;
        }

        public final String f(Bundle bundle) {
            n.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.Token");
        }

        public final boolean g(Bundle bundle) {
            int i2;
            int string;
            int i;
            int i3;
            long long;
            int obj8;
            i2 = 0;
            if (bundle == null) {
                return i2;
            }
            string = bundle.getString("com.facebook.TokenCachingStrategy.Token");
            if (string != null) {
                i = 1;
                string = string.length() == 0 ? i : i2;
                if (string != null) {
                } else {
                    i3 = 0;
                    if (Long.compare(long, i3) != 0) {
                        i2 = i;
                    }
                }
            }
            return i2;
        }
    }
    static {
        u.a aVar = new u.a(0);
        u.d = aVar;
        String simpleName = u.class.getSimpleName();
        n.e(simpleName, "LegacyTokenHelper::class.java.simpleName");
        u.c = simpleName;
    }

    public u(Context context, String string2) {
        int i;
        Object obj3;
        String obj4;
        n.f(context, "context");
        super();
        int i2 = 0;
        if (string2 != null) {
            i = string2.length() == 0 ? 1 : i2;
            obj4 = i != 0 ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : obj4;
        } else {
        }
        this.a = obj4;
        Context applicationContext = context.getApplicationContext();
        obj3 = applicationContext != null ? applicationContext : obj3;
        obj3 = obj3.getSharedPreferences(obj4, i2);
        n.e(obj3, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.b = obj3;
    }

    public u(Context context, String string2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(context, obj2);
    }

    private final void b(String string, Bundle bundle2) {
        JSONArray jSONArray;
        int jSONObject;
        boolean[] arrayList;
        String boolean;
        int i;
        int nULL;
        String charAt;
        int length;
        String string2 = this.b.getString(string, "{}");
        if (string2 == null) {
        } else {
            jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString("valueType");
            boolean = "value";
            if (n.b(string3, "bool")) {
                bundle2.putBoolean(string, jSONObject.getBoolean(boolean));
            } else {
                i = 0;
                if (n.b(string3, "bool[]")) {
                    jSONArray = jSONObject.getJSONArray(boolean);
                    jSONObject = jSONArray.length();
                    arrayList = new boolean[jSONObject];
                    while (i < jSONObject) {
                        arrayList[i] = jSONArray.getBoolean(i);
                        i++;
                    }
                    bundle2.putBooleanArray(string, arrayList);
                } else {
                    if (n.b(string3, "byte")) {
                        bundle2.putByte(string, (byte)int2);
                    } else {
                        if (n.b(string3, "byte[]")) {
                            jSONArray = jSONObject.getJSONArray(boolean);
                            jSONObject = jSONArray.length();
                            arrayList = new byte[jSONObject];
                            while (i < jSONObject) {
                                arrayList[i] = (byte)int3;
                                i++;
                            }
                            bundle2.putByteArray(string, arrayList);
                        } else {
                            if (n.b(string3, "short")) {
                                bundle2.putShort(string, (short)int);
                            } else {
                                if (n.b(string3, "short[]")) {
                                    jSONArray = jSONObject.getJSONArray(boolean);
                                    jSONObject = jSONArray.length();
                                    arrayList = new short[jSONObject];
                                    while (i < jSONObject) {
                                        arrayList[i] = (short)int4;
                                        i++;
                                    }
                                    bundle2.putShortArray(string, arrayList);
                                } else {
                                    if (n.b(string3, "int")) {
                                        bundle2.putInt(string, jSONObject.getInt(boolean));
                                    } else {
                                        if (n.b(string3, "int[]")) {
                                            jSONArray = jSONObject.getJSONArray(boolean);
                                            jSONObject = jSONArray.length();
                                            arrayList = new int[jSONObject];
                                            while (i < jSONObject) {
                                                arrayList[i] = jSONArray.getInt(i);
                                                i++;
                                            }
                                            bundle2.putIntArray(string, arrayList);
                                        } else {
                                            if (n.b(string3, "long")) {
                                                bundle2.putLong(string, jSONObject.getLong(boolean));
                                            } else {
                                                if (n.b(string3, "long[]")) {
                                                    jSONArray = jSONObject.getJSONArray(boolean);
                                                    jSONObject = jSONArray.length();
                                                    arrayList = new long[jSONObject];
                                                    while (i < jSONObject) {
                                                        arrayList[i] = jSONArray.getLong(i);
                                                        i++;
                                                    }
                                                    bundle2.putLongArray(string, arrayList);
                                                } else {
                                                    if (n.b(string3, "float")) {
                                                        bundle2.putFloat(string, (float)double);
                                                    } else {
                                                        if (n.b(string3, "float[]")) {
                                                            jSONArray = jSONObject.getJSONArray(boolean);
                                                            jSONObject = jSONArray.length();
                                                            arrayList = new float[jSONObject];
                                                            while (i < jSONObject) {
                                                                arrayList[i] = (float)nULL;
                                                                i++;
                                                            }
                                                            bundle2.putFloatArray(string, arrayList);
                                                        } else {
                                                            if (n.b(string3, "double")) {
                                                                bundle2.putDouble(string, jSONObject.getDouble(boolean));
                                                            } else {
                                                                if (n.b(string3, "double[]")) {
                                                                    jSONArray = jSONObject.getJSONArray(boolean);
                                                                    jSONObject = jSONArray.length();
                                                                    arrayList = new double[jSONObject];
                                                                    while (i < jSONObject) {
                                                                        arrayList[i] = jSONArray.getDouble(i);
                                                                        i++;
                                                                    }
                                                                    bundle2.putDoubleArray(string, arrayList);
                                                                } else {
                                                                    nULL = 1;
                                                                    if (n.b(string3, "char")) {
                                                                        jSONArray = jSONObject.getString(boolean);
                                                                        if (jSONArray != null && jSONArray.length() == nULL) {
                                                                            if (jSONArray.length() == nULL) {
                                                                                bundle2.putChar(string, jSONArray.charAt(i));
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (n.b(string3, "char[]")) {
                                                                            jSONArray = jSONObject.getJSONArray(boolean);
                                                                            jSONObject = jSONArray.length();
                                                                            arrayList = new char[jSONObject];
                                                                            boolean = i;
                                                                            while (boolean < jSONObject) {
                                                                                charAt = jSONArray.getString(boolean);
                                                                                if (charAt != null && charAt.length() == nULL) {
                                                                                }
                                                                                boolean++;
                                                                                if (charAt.length() == nULL) {
                                                                                }
                                                                                arrayList[boolean] = charAt.charAt(i);
                                                                            }
                                                                            bundle2.putCharArray(string, arrayList);
                                                                        } else {
                                                                            if (n.b(string3, "string")) {
                                                                                bundle2.putString(string, jSONObject.getString(boolean));
                                                                            } else {
                                                                                if (n.b(string3, "stringList")) {
                                                                                    jSONArray = jSONObject.getJSONArray(boolean);
                                                                                    jSONObject = jSONArray.length();
                                                                                    arrayList = new ArrayList(jSONObject);
                                                                                    while (i < jSONObject) {
                                                                                        boolean = jSONArray.get(i);
                                                                                        if (boolean == JSONObject.NULL) {
                                                                                        } else {
                                                                                        }
                                                                                        Objects.requireNonNull(boolean, "null cannot be cast to non-null type kotlin.String");
                                                                                        arrayList.add(i, boolean);
                                                                                        i++;
                                                                                        boolean = 0;
                                                                                    }
                                                                                    bundle2.putStringArrayList(string, arrayList);
                                                                                } else {
                                                                                    if (n.b(string3, "enum")) {
                                                                                        Class forName = Class.forName(jSONObject.getString("enumType"));
                                                                                        if (forName == null) {
                                                                                        } else {
                                                                                            bundle2.putSerializable(string, Enum.valueOf(forName, jSONObject.getString(boolean)));
                                                                                        }
                                                                                        NullPointerException obj9 = new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                                                                                        throw obj9;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        obj9 = new IllegalStateException("Required value was null.".toString());
        throw obj9;
    }

    public final void a() {
        this.b.edit().clear().apply();
    }

    public final Bundle c() {
        Bundle bundle;
        Iterator iterator;
        Object next;
        boolean next2;
        Object cACHE;
        int i;
        String str;
        StringBuilder stringBuilder;
        String str2;
        bundle = new Bundle();
        iterator = this.b.getAll().keySet().iterator();
        for (String next : iterator) {
            n.e(next, "key");
            b(next, bundle);
        }
        return bundle;
    }
}
