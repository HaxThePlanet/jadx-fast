package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 E2\u00020\u0001:\u0003CDEB\u0089\u0001\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0010\u0010\u0006\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\u0008\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011B\u000f\u0008\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010.\u001a\u00020/2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u001a\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\u0008\u00105\u001a\u000206H\u0016J\u0013\u00107\u001a\u00020!2\u0008\u00108\u001a\u0004\u0018\u000109H\u0096\u0002J\u0008\u0010:\u001a\u000206H\u0016J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\u0008=J\u0008\u0010>\u001a\u00020\u0003H\u0016J\u0008\u0010?\u001a\u00020\u0003H\u0002J\u0018\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u000206H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0019\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008 \u0010\"R\u0011\u0010#\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008#\u0010\"R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\u0008$\u0010\"R\u0011\u0010%\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001bR\u0011\u0010(\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0011\u0010+\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0016¨\u0006F", d2 = {"Lcom/facebook/AccessToken;", "Landroid/os/Parcelable;", "accessToken", "", "applicationId", "userId", "permissions", "", "declinedPermissions", "expiredPermissions", "accessTokenSource", "Lcom/facebook/AccessTokenSource;", "expirationTime", "Ljava/util/Date;", "lastRefreshTime", "dataAccessExpirationTime", "graphDomain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getDataAccessExpirationTime", "()Ljava/util/Date;", "", "getDeclinedPermissions", "()Ljava/util/Set;", "getExpiredPermissions", "expires", "getExpires", "getGraphDomain", "isDataAccessExpired", "", "()Z", "isExpired", "isInstagramToken", "lastRefresh", "getLastRefresh", "getPermissions", "source", "getSource", "()Lcom/facebook/AccessTokenSource;", "token", "getToken", "getUserId", "appendPermissions", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "convertTokenSourceForGraphDomain", "tokenSource", "describeContents", "", "equals", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "toString", "tokenToString", "writeToParcel", "dest", "flags", "AccessTokenCreationCallback", "AccessTokenRefreshCallback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a implements Parcelable {

    public static final Parcelable.Creator<com.facebook.a> CREATOR;
    private static final Date D;
    private static final Date E;
    private static final Date F;
    private static final com.facebook.f G;
    public static final com.facebook.a.c H;
    private final String A;
    private final Date B;
    private final String C;
    private final Date a;
    private final Set<String> b;
    private final Set<String> c;
    private final Set<String> v;
    private final String w;
    private final com.facebook.f x;
    private final Date y;
    private final String z;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H&¨\u0006\t", d2 = {"Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "", "OnTokenRefreshFailed", "", "exception", "Lcom/facebook/FacebookException;", "OnTokenRefreshed", "accessToken", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(com.facebook.FacebookException facebookException);

        public abstract void b(com.facebook.a a);
    }

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/AccessToken$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AccessToken;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Parcelable.Creator<com.facebook.a> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.a a(Parcel parcel) {
            n.f(parcel, "source");
            a aVar = new a(parcel);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.a[] b(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    @Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001e\u001a\u00020\u00082\u0006\u0010\u001f\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008 J<\u0010!\u001a\u0004\u0018\u00010\u00082\u0010\u0010\"\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0015\u0010)\u001a\u00020\u00082\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\u0008,J\u0017\u0010-\u001a\u0004\u0018\u00010\u00082\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0008.J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020\u00042\u0006\u00103\u001a\u000204H\u0007J\u001f\u00105\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u001f\u001a\u00020\u00082\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u00086J\u0008\u00107\u001a\u000200H\u0007J\n\u00108\u001a\u0004\u0018\u00010\u0008H\u0007J'\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010$\u001a\u00020%2\u0008\u0010:\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\u0008;J\u0008\u0010<\u001a\u00020=H\u0007J\u0008\u0010>\u001a\u00020=H\u0007J\u0008\u0010?\u001a\u00020=H\u0007J\u0008\u0010@\u001a\u000200H\u0007J\u0012\u0010@\u001a\u0002002\u0008\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u0012\u0010C\u001a\u0002002\u0008\u0010D\u001a\u0004\u0018\u00010\u0008H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006E", d2 = {"Lcom/facebook/AccessToken$Companion;", "", "()V", "ACCESS_TOKEN_KEY", "", "APPLICATION_ID_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AccessToken;", "CURRENT_JSON_FORMAT", "", "DATA_ACCESS_EXPIRATION_TIME", "DECLINED_PERMISSIONS_KEY", "DEFAULT_ACCESS_TOKEN_SOURCE", "Lcom/facebook/AccessTokenSource;", "DEFAULT_EXPIRATION_TIME", "Ljava/util/Date;", "DEFAULT_GRAPH_DOMAIN", "DEFAULT_LAST_REFRESH_TIME", "EXPIRED_PERMISSIONS_KEY", "EXPIRES_AT_KEY", "EXPIRES_IN_KEY", "GRAPH_DOMAIN", "LAST_REFRESH_KEY", "MAX_DATE", "PERMISSIONS_KEY", "SOURCE_KEY", "TOKEN_KEY", "USER_ID_KEY", "VERSION_KEY", "createExpired", "current", "createExpired$facebook_core_release", "createFromBundle", "requestedPermissions", "", "bundle", "Landroid/os/Bundle;", "source", "expirationBase", "applicationId", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "createFromLegacyCache", "createFromLegacyCache$facebook_core_release", "createFromNativeLinkingIntent", "", "intent", "Landroid/content/Intent;", "accessTokenCallback", "Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "createFromRefresh", "createFromRefresh$facebook_core_release", "expireCurrentAccessToken", "getCurrentAccessToken", "getPermissionsFromBundle", "key", "getPermissionsFromBundle$facebook_core_release", "isCurrentAccessTokenActive", "", "isDataAccessActive", "isLoggedInWithInstagram", "refreshCurrentAccessTokenAsync", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "setCurrentAccessToken", "accessToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c {
        public c(g g) {
            super();
        }

        public final com.facebook.a a(com.facebook.a a) {
            n.f(a, "current");
            Date date = new Date();
            Date date2 = new Date();
            super(a.m(), a.c(), a.n(), a.k(), a.f(), a.g(), a.l(), date, date2, a.e(), 0, 1024, 0);
            return aVar;
        }

        public final com.facebook.a b(JSONObject jSONObject) {
            Object arrayList;
            n.f(jSONObject, "jsonObject");
            if (jSONObject.getInt("version") > 1) {
            } else {
                String str4 = "token";
                final String string = jSONObject.getString(str4);
                Date date = new Date(jSONObject.getLong("expires_at"), obj4);
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
                JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
                Date date2 = new Date(jSONObject.getLong("last_refresh"), obj6);
                String string2 = jSONObject.getString("source");
                n.e(string2, "jsonObject.getString(SOURCE_KEY)");
                String string3 = jSONObject.getString("application_id");
                String string4 = jSONObject.getString("user_id");
                Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0), obj13);
                n.e(string, str4);
                n.e(string3, "applicationId");
                n.e(string4, "userId");
                n.e(jSONArray, "permissionsArray");
                n.e(jSONArray2, "declinedPermissionsArray");
                if (optJSONArray == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = b0.a0(optJSONArray);
                }
                super(string, string3, string4, b0.a0(jSONArray), b0.a0(jSONArray2), arrayList, f.valueOf(string2), date, date2, date3, jSONObject.optString("graph_domain", 0));
                return obj15;
            }
            FacebookException obj15 = new FacebookException("Unknown AccessToken serialization format.");
            throw obj15;
        }

        public final com.facebook.a c(Bundle bundle) {
            String str2;
            int string;
            String str;
            com.facebook.a aVar;
            final Object obj = this;
            final Object obj2 = bundle;
            n.f(obj2, "bundle");
            com.facebook.u.a aVar2 = u.d;
            if (b0.W(aVar2.a(obj2))) {
                str2 = o.g();
            }
            final String str8 = str2;
            String str7 = aVar2.f(obj2);
            int i = 0;
            if (str7 != null) {
                JSONObject jSONObject = b0.e(str7);
                if (jSONObject != null) {
                    string = jSONObject.getString("id");
                } else {
                    string = i;
                }
                if (str8 != null && string != null) {
                    if (string != null) {
                        super(str7, str8, string, obj.f(obj2, "com.facebook.TokenCachingStrategy.Permissions"), obj.f(obj2, "com.facebook.TokenCachingStrategy.DeclinedPermissions"), obj.f(obj2, "com.facebook.TokenCachingStrategy.ExpiredPermissions"), aVar2.e(obj2), aVar2.c(obj2), aVar2.d(obj2), 0, 0, 1024, 0);
                        return aVar;
                    }
                }
            }
            return i;
        }

        public final void d() {
            com.facebook.a aVar;
            aVar = d.g.e().g();
            if (aVar != null) {
                h(a(aVar));
            }
        }

        public final com.facebook.a e() {
            return d.g.e().g();
        }

        public final List<String> f(Bundle bundle, String string2) {
            List obj2;
            String obj3;
            n.f(bundle, "bundle");
            obj2 = bundle.getStringArrayList(string2);
            if (obj2 == null) {
                obj2 = p.g();
            } else {
                obj3 = new ArrayList(obj2);
                n.e(Collections.unmodifiableList(obj3), "Collections.unmodifiable…ist(originalPermissions))");
            }
            return obj2;
        }

        public final boolean g() {
            com.facebook.a aVar;
            int i;
            aVar = d.g.e().g();
            if (aVar != null && !aVar.p()) {
                i = !aVar.p() ? 1 : 0;
            } else {
            }
            return i;
        }

        public final void h(com.facebook.a a) {
            d.g.e().l(a);
        }
    }
    static {
        a.c cVar = new a.c(0);
        a.H = cVar;
        Date date = new Date(Long.MAX_VALUE, obj2);
        a.D = date;
        a.E = date;
        Date date2 = new Date();
        a.F = date2;
        a.G = f.FACEBOOK_APPLICATION_WEB;
        a.b bVar = new a.b();
        a.CREATOR = bVar;
    }

    public a(Parcel parcel) {
        com.facebook.f valueOf;
        n.f(parcel, "parcel");
        super();
        Date date = new Date(parcel.readLong(), obj2);
        this.a = date;
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        HashSet hashSet = new HashSet(arrayList);
        Set unmodifiableSet2 = Collections.unmodifiableSet(hashSet);
        final String str5 = "Collections.unmodifiable…HashSet(permissionsList))";
        n.e(unmodifiableSet2, str5);
        this.b = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        HashSet hashSet2 = new HashSet(arrayList);
        Set unmodifiableSet3 = Collections.unmodifiableSet(hashSet2);
        n.e(unmodifiableSet3, str5);
        this.c = unmodifiableSet3;
        arrayList.clear();
        parcel.readStringList(arrayList);
        HashSet hashSet3 = new HashSet(arrayList);
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet3);
        n.e(unmodifiableSet, str5);
        this.v = unmodifiableSet;
        String string = parcel.readString();
        c0.k(string, "token");
        this.w = string;
        String string2 = parcel.readString();
        if (string2 != null) {
            valueOf = f.valueOf(string2);
        } else {
            valueOf = a.G;
        }
        this.x = valueOf;
        Date date2 = new Date(parcel.readLong(), str5);
        this.y = date2;
        String string3 = parcel.readString();
        c0.k(string3, "applicationId");
        this.z = string3;
        String string4 = parcel.readString();
        c0.k(string4, "userId");
        this.A = string4;
        Date date3 = new Date(parcel.readLong(), str5);
        this.B = date3;
        this.C = parcel.readString();
    }

    public a(String string, String string2, String string3, Collection<String> collection4, Collection<String> collection5, Collection<String> collection6, com.facebook.f f7, Date date8, Date date9, Date date10) {
        super(string, string2, string3, collection4, collection5, collection6, f7, date8, date9, date10, 0, 1024, 0);
    }

    public a(String string, String string2, String string3, Collection<String> collection4, Collection<String> collection5, Collection<String> collection6, com.facebook.f f7, Date date8, Date date9, Date date10, String string11) {
        com.facebook.f obj4;
        Object obj6;
        com.facebook.f obj10;
        Date obj11;
        Date obj12;
        Date obj13;
        String obj14;
        final String str = "accessToken";
        n.f(string, str);
        final String str2 = "applicationId";
        n.f(string2, str2);
        final String str3 = "userId";
        n.f(string3, str3);
        super();
        c0.g(string, str);
        c0.g(string2, str2);
        c0.g(string3, str3);
        if (date8 != null) {
        } else {
            obj11 = a.E;
        }
        this.a = obj11;
        if (collection4 != null) {
            obj11 = new HashSet(collection4);
        } else {
            super();
        }
        Set obj7 = Collections.unmodifiableSet(obj11);
        obj11 = "Collections.unmodifiable…missions) else HashSet())";
        n.e(obj7, obj11);
        this.b = obj7;
        if (collection5 != null) {
            obj7 = new HashSet(collection5);
        } else {
            super();
        }
        obj7 = Collections.unmodifiableSet(obj7);
        n.e(obj7, obj11);
        this.c = obj7;
        if (collection6 != null) {
            obj7 = new HashSet(collection6);
        } else {
            super();
        }
        obj7 = Collections.unmodifiableSet(obj7);
        n.e(obj7, obj11);
        this.v = obj7;
        this.w = string;
        if (f7 != null) {
        } else {
            obj10 = a.G;
        }
        this.x = b(obj10, string11);
        if (date9 != null) {
        } else {
            obj12 = a.F;
        }
        this.y = obj12;
        this.z = string2;
        this.A = string3;
        if (date10 != null && Long.compare(obj4, obj6) != 0) {
            if (Long.compare(obj4, obj6) != 0) {
            } else {
                obj13 = a.E;
            }
        } else {
        }
        this.B = obj13;
        if (string11 != null) {
        } else {
            obj14 = "facebook";
        }
        this.C = obj14;
    }

    public a(String string, String string2, String string3, Collection collection4, Collection collection5, Collection collection6, com.facebook.f f7, Date date8, Date date9, Date date10, String string11, int i12, g g13) {
        String str;
        String str2;
        str2 = i &= 1024 != 0 ? str : string11;
        super(string, string2, string3, collection4, collection5, collection6, f7, date8, date9, date10, str2);
    }

    private final void a(StringBuilder stringBuilder) {
        stringBuilder.append(" permissions:");
        stringBuilder.append("[");
        stringBuilder.append(TextUtils.join(", ", this.b));
        stringBuilder.append("]");
    }

    private final com.facebook.f b(com.facebook.f f, String string2) {
        String str;
        com.facebook.f obj2;
        boolean obj3;
        if (string2 != null && string2.equals("instagram")) {
            if (string2.equals("instagram")) {
                obj3 = b.a[f.ordinal()];
                if (obj3 != 1) {
                    if (obj3 != 2) {
                        if (obj3 != 3) {
                        } else {
                            obj2 = f.INSTAGRAM_WEB_VIEW;
                        }
                    } else {
                        obj2 = f.INSTAGRAM_CUSTOM_CHROME_TAB;
                    }
                } else {
                    obj2 = f.INSTAGRAM_APPLICATION_WEB;
                }
            }
        }
        return obj2;
    }

    public static final com.facebook.a d() {
        return a.H.e();
    }

    public static final boolean o() {
        return a.H.g();
    }

    public static final void q(com.facebook.a a) {
        a.H.h(a);
    }

    private final String s() {
        String str;
        str = o.A(v.INCLUDE_ACCESS_TOKENS) ? this.w : "ACCESS_TOKEN_REMOVED";
        return str;
    }

    @Override // android.os.Parcelable
    public final String c() {
        return this.z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final Date e() {
        return this.B;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object date;
        Object obj5;
        i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.v, object.v) && n.b(this.w, object.w) && this.x == object.x && n.b(this.y, object.y) && n.b(this.z, object.z) && n.b(this.A, object.A) && n.b(this.B, object.B)) {
            if (n.b(this.b, object.b)) {
                if (n.b(this.c, object.c)) {
                    if (n.b(this.v, object.v)) {
                        if (n.b(this.w, object.w)) {
                            if (this.x == object.x) {
                                if (n.b(this.y, object.y)) {
                                    if (n.b(this.z, object.z)) {
                                        if (n.b(this.A, object.A)) {
                                            if (n.b(this.B, object.B)) {
                                                z = this.C;
                                                obj5 = object.C;
                                                if (z == null) {
                                                    obj5 = obj5 == null ? i : i2;
                                                } else {
                                                    obj5 = n.b(z, obj5);
                                                }
                                                if (obj5 != null) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final Set<String> f() {
        return this.c;
    }

    public final Set<String> g() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public final Date h() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        String str4 = this.C;
        if (str4 != null) {
            i = str4.hashCode();
        } else {
            i = 0;
        }
        return i32 += i;
    }

    @Override // android.os.Parcelable
    public final String i() {
        return this.C;
    }

    @Override // android.os.Parcelable
    public final Date j() {
        return this.y;
    }

    public final Set<String> k() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final com.facebook.f l() {
        return this.x;
    }

    @Override // android.os.Parcelable
    public final String m() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public final String n() {
        return this.A;
    }

    @Override // android.os.Parcelable
    public final boolean p() {
        Date date = new Date();
        return date.after(this.a);
    }

    @Override // android.os.Parcelable
    public final JSONObject r() {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        String str7 = "token";
        jSONObject.put(str7, this.w);
        jSONObject.put("expires_at", this.a.getTime());
        JSONArray jSONArray = new JSONArray(this.b);
        jSONObject.put("permissions", jSONArray);
        JSONArray jSONArray2 = new JSONArray(this.c);
        jSONObject.put("declined_permissions", jSONArray2);
        JSONArray jSONArray3 = new JSONArray(this.v);
        String str10 = "expired_permissions";
        jSONObject.put(str10, jSONArray3);
        jSONObject.put("last_refresh", this.y.getTime());
        jSONObject.put("source", this.x.name());
        jSONObject.put("application_id", this.z);
        str = "user_id";
        jSONObject.put(str, this.A);
        jSONObject.put("data_access_expiration_time", this.B.getTime());
        String str6 = this.C;
        if (str6 != null) {
            jSONObject.put("graph_domain", str6);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:");
        stringBuilder.append(s());
        a(stringBuilder);
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "builder.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeLong(this.a.getTime());
        ArrayList obj4 = new ArrayList(this.b);
        parcel.writeStringList(obj4);
        obj4 = new ArrayList(this.c);
        parcel.writeStringList(obj4);
        obj4 = new ArrayList(this.v);
        parcel.writeStringList(obj4);
        parcel.writeString(this.w);
        parcel.writeString(this.x.name());
        parcel.writeLong(this.y.getTime());
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeLong(this.B.getTime());
        parcel.writeString(this.C);
    }
}
