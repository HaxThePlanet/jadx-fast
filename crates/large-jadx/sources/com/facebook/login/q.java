package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.e0.m;
import com.facebook.f;
import com.facebook.g;
import com.facebook.internal.b0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.l;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008'\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\u0012\u0010\u001d\u001a\u00020\u00162\u0008\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0014J\u0008\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020 H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020#H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u0004R,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014¨\u00062", d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "methodLoggingExtras", "", "", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "nameForLogging", "getNameForLogging", "()Ljava/lang/String;", "addLoggingExtra", "", "key", "value", "", "cancel", "getClientState", "authId", "logWebLoginCompleted", "e2e", "needsInternetPermission", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "putChallengeParam", "param", "Lorg/json/JSONObject;", "shouldKeepTrackOfMultipleIntents", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public abstract class q implements Parcelable {

    public static final com.facebook.login.q.a c;
    private Map<String, String> a;
    public com.facebook.login.l b;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0007J6\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000c\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0007J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u0012\u001a\u00020\n2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u0014", d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", "", "()V", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "", "createAccessTokenFromWebBundle", "requestedPermissions", "", "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final a a(Bundle bundle, f f2, String string3) {
            String length;
            Date date;
            int i;
            String string;
            Object obj = bundle;
            n.f(bundle, "bundle");
            n.f(string3, "applicationId");
            int i2 = 0;
            Date date2 = new Date(i2, obj3);
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            date = new Date(i2, obj3);
            if (string2 != null) {
                i = 0;
                length = string2.length() == 0 ? date : i;
                if (length != 0) {
                } else {
                    string = bundle.getString("com.facebook.platform.extra.USER_ID");
                    if (string != null) {
                        if (string.length() == 0) {
                        } else {
                            date = i;
                        }
                        if (date != 0) {
                        }
                        Date date4 = new Date();
                        super(string2, string3, string, bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), 0, 0, f2, b0.v(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", date2), date4, b0.v(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", date), bundle.getString("graph_domain"));
                        return aVar;
                    }
                }
            }
            return null;
        }

        public final a b(Collection<String> collection, Bundle bundle2, f f3, String string4) {
            Object str;
            String array;
            int strArr;
            int i5;
            java.util.ArrayList list;
            int length2;
            String str2;
            int i4;
            int length3;
            int i2;
            String length;
            String[] strArr2;
            int i6;
            int i;
            int i7;
            int i3;
            Object obj = bundle2;
            n.f(obj, "bundle");
            n.f(string4, "applicationId");
            Date date = new Date();
            final String string2 = obj.getString("access_token");
            int i8 = 0;
            if (string2 != null) {
                n.e(string2, "bundle.getString(AccessT…TOKEN_KEY) ?: return null");
                Date date3 = new Date(0, obj6);
                String string3 = obj.getString("granted_scopes");
                str = "null cannot be cast to non-null type kotlin.Array<T>";
                array = ",";
                strArr = 1;
                int i10 = 0;
                if (string3 != null) {
                    i5 = string3.length() > 0 ? strArr : i10;
                    if (i5 != 0) {
                        Object[] array2 = l.E0(string3, /* result */, false, 0, 6, 0).toArray(new String[i10]);
                        Objects.requireNonNull(array2, str);
                        list = p.c((String[])Arrays.copyOf((String[])array2, array2.length));
                    } else {
                        list = collection;
                    }
                } else {
                }
                String string5 = obj.getString("denied_scopes");
                if (string5 != null) {
                    str2 = string5.length() > 0 ? strArr : i10;
                    if (str2 != null) {
                        Object[] array3 = l.E0(string5, /* result */, false, 0, 6, 0).toArray(new String[i10]);
                        Objects.requireNonNull(array3, str);
                        i4 = p.c((String[])Arrays.copyOf((String[])array3, array3.length));
                    } else {
                        i4 = i8;
                    }
                } else {
                }
                String string6 = obj.getString("expired_scopes");
                if (string6 != null) {
                    if (string6.length() > 0) {
                    } else {
                        strArr = i10;
                    }
                    if (strArr != 0) {
                        array = l.E0(string6, /* result */, false, 0, 6, 0).toArray(new String[i10]);
                        Objects.requireNonNull(array, str);
                        i2 = str;
                    } else {
                        i2 = i8;
                    }
                } else {
                }
                if (b0.W(string2)) {
                    return i8;
                }
                Date date2 = new Date();
                super(string2, string4, this.e(obj.getString("signed_request")), list, i4, i2, f3, b0.v(obj, "expires_in", date), date2, b0.v(obj, "data_access_expiration_time", date3), obj.getString("graph_domain"));
                return aVar;
            }
            String[] obj3 = this;
            return i8;
        }

        public final g c(Bundle bundle, String string2) {
            int gVar;
            String length;
            int i;
            int i2;
            n.f(bundle, "bundle");
            final String obj4 = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (obj4 != null) {
                i2 = 0;
                length = obj4.length() == 0 ? i : i2;
                if (length == 0 && string2 != null) {
                    if (string2 != null) {
                        if (string2.length() == 0) {
                        } else {
                            i = i2;
                        }
                        if (i != 0) {
                            gVar = 0;
                        } else {
                            gVar = new g(obj4, string2);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return gVar;
        }

        public final g d(Bundle bundle, String string2) {
            int gVar;
            String length;
            int i;
            int i2;
            n.f(bundle, "bundle");
            final String obj4 = bundle.getString("id_token");
            if (obj4 != null) {
                i2 = 0;
                length = obj4.length() == 0 ? i : i2;
                if (length == 0 && string2 != null) {
                    if (string2 != null) {
                        if (string2.length() == 0) {
                        } else {
                            i = i2;
                        }
                        if (i != 0) {
                            gVar = 0;
                        } else {
                            gVar = new g(obj4, string2);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return gVar;
        }

        public final String e(String string) {
            int i;
            int i3;
            int i2;
            if (string == null) {
            } else {
                i3 = 1;
                i2 = 0;
                i = string.length() == 0 ? i3 : i2;
                if (i != 0) {
                } else {
                    Object[] obj10 = l.E0(string, /* result */, false, 0, 6, 0).toArray(new String[i2]);
                    if (obj10 == null) {
                    } else {
                        if (obj10.length != 2) {
                        } else {
                            obj10 = Base64.decode((String[])obj10[i3], i2);
                            n.e(obj10, "data");
                            String string2 = new String(obj10, d.a);
                            obj10 = new JSONObject(string2);
                            obj10 = obj10.getString("user_id");
                            n.e(obj10, "jsonObject.getString(\"user_id\")");
                            return obj10;
                        }
                        obj10 = new FacebookException("Failed to retrieve user_id from signed_request");
                        throw obj10;
                    }
                    obj10 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    throw obj10;
                }
            }
            obj10 = new FacebookException("Authorization response does not contain the signed_request");
            throw obj10;
        }
    }
    static {
        q.a aVar = new q.a(0);
        q.c = aVar;
    }

    protected q(Parcel parcel) {
        Map obj2;
        n.f(parcel, "source");
        super();
        obj2 = b0.n0(parcel);
        if (obj2 != null) {
            obj2 = j0.y(obj2);
        } else {
            obj2 = 0;
        }
        this.a = obj2;
    }

    public q(com.facebook.login.l l) {
        n.f(l, "loginClient");
        super();
        this.b = l;
    }

    public static final a c(Collection<String> collection, Bundle bundle2, f f3, String string4) {
        return q.c.b(collection, bundle2, f3, string4);
    }

    public static final g d(Bundle bundle, String string2) {
        return q.c.d(bundle, string2);
    }

    @Override // android.os.Parcelable
    protected void a(String string, Object object2) {
        Object hashMap;
        Object obj2;
        int obj3;
        if (this.a == null) {
            hashMap = new HashMap();
            this.a = hashMap;
        }
        Map map = this.a;
        if (map != null) {
            if (object2 != null) {
                obj3 = object2.toString();
            } else {
                obj3 = 0;
            }
            obj2 = map.put(string, obj3);
        }
    }

    @Override // android.os.Parcelable
    public void b() {
    }

    @Override // android.os.Parcelable
    protected String e(String string) {
        String str;
        String str2;
        String obj4;
        n.f(string, "authId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("0_auth_logger_id", string);
        jSONObject.put("3_method", h());
        l(jSONObject);
        obj4 = jSONObject.toString();
        n.e(obj4, "param.toString()");
        return obj4;
    }

    @Override // android.os.Parcelable
    public final com.facebook.login.l f() {
        com.facebook.login.l lVar = this.b;
        if (lVar == null) {
        } else {
            return lVar;
        }
        n.w("loginClient");
        throw 0;
    }

    public final Map<String, String> g() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public abstract String h();

    @Override // android.os.Parcelable
    protected void i(String string) {
        com.facebook.login.l lVar = this.b;
        String str2 = "loginClient";
        final int i = 0;
        if (lVar == null) {
        } else {
            com.facebook.login.l.d dVar = lVar.q();
            n.e(dVar, "loginClient.getPendingRequest()");
            String str = dVar.a();
            com.facebook.login.l lVar2 = this.b;
            if (lVar2 == null) {
            } else {
                m mVar = new m(lVar2.i(), str);
                Bundle bundle = new Bundle();
                bundle.putString("fb_web_login_e2e", string);
                bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
                bundle.putString("app_id", str);
                mVar.h("fb_dialogs_web_login_dialog_complete", i, bundle);
            }
            n.w(str2);
            throw i;
        }
        n.w(str2);
        throw i;
    }

    @Override // android.os.Parcelable
    public boolean j() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean k(int i, int i2, Intent intent3) {
        return 0;
    }

    @Override // android.os.Parcelable
    public void l(JSONObject jSONObject) {
        n.f(jSONObject, "param");
    }

    @Override // android.os.Parcelable
    public final void m(com.facebook.login.l l) {
        n.f(l, "<set-?>");
        this.b = l;
    }

    @Override // android.os.Parcelable
    public boolean n() {
        return 0;
    }

    @Override // android.os.Parcelable
    public abstract int o(com.facebook.login.l.d l$d);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        b0.z0(parcel, this.a);
    }
}
