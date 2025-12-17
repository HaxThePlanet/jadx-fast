package zendesk.core;

import f.g.c.a;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes3.dex */
class ZendeskAccessInterceptor implements Interceptor {

    private static final String EMPTY_JSON = "{}";
    private static final String LOG_TAG = "ZendeskAccessIntercepto";
    private static final int RETRY_LIMIT = 3;
    private zendesk.core.AccessProvider accessProvider;
    private zendesk.core.CoreSettingsStorage coreSettingsStorage;
    private zendesk.core.IdentityManager identityManager;
    private int retryCounter;
    private zendesk.core.Storage storage;
    ZendeskAccessInterceptor(zendesk.core.IdentityManager identityManager, zendesk.core.AccessProvider accessProvider2, zendesk.core.Storage storage3, zendesk.core.CoreSettingsStorage coreSettingsStorage4) {
        super();
        this.identityManager = identityManager;
        this.accessProvider = accessProvider2;
        this.storage = storage3;
        this.coreSettingsStorage = coreSettingsStorage4;
    }

    private Response errorResponse(Interceptor.Chain interceptor$Chain, String string2) {
        Response.Builder builder = new Response.Builder();
        return builder.request(chain.request()).protocol(Protocol.HTTP_2).code(400).message(string2).body(ResponseBody.create(MediaType.parse("txt/json"), "{}")).build();
    }

    static String getErrorLogMessage(zendesk.core.AuthenticationType authenticationType, zendesk.core.Identity identity2) {
        zendesk.core.AuthenticationType aNONYMOUS;
        Object obj4;
        StringBuilder stringBuilder = new StringBuilder(160);
        stringBuilder.append("The expected type of authentication is ");
        String str2 = "jwt.";
        final String str3 = "anonymous.";
        if (authenticationType == null) {
            stringBuilder.append("null. Check that settings have been downloaded.");
        } else {
            if (authenticationType == AuthenticationType.ANONYMOUS) {
                stringBuilder.append(str3);
            } else {
                if (authenticationType == AuthenticationType.JWT) {
                    stringBuilder.append(str2);
                }
            }
        }
        stringBuilder.append('\n');
        stringBuilder.append("The local identity is");
        if (identity2 == null) {
            stringBuilder.append(" not");
        }
        stringBuilder.append(" present.\n");
        if (identity2 != null) {
            stringBuilder.append("The local identity is ");
            if (identity2 instanceof AnonymousIdentity) {
                stringBuilder.append(str3);
            } else {
                if (identity2 instanceof JwtIdentity) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append("unknown.");
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Response authTokenViaAnonymous;
        zendesk.core.AccessProvider accessProvider;
        Object identityManager;
        zendesk.core.AuthenticationType aNONYMOUS;
        zendesk.core.AuthenticationType jWT;
        String str;
        zendesk.core.Identity identity = this.identityManager.getIdentity();
        String str6 = "ZendeskAccessIntercepto";
        final int i4 = 0;
        if (this.identityManager.getStoredAccessTokenAsBearerToken() != null) {
            a.b(str6, "Access token present, no need to intercept.", new Object[i4]);
            return chain.proceed(chain.request());
        }
        a.b(str6, "Access token is required, intercepting.", new Object[i4]);
        zendesk.core.AuthenticationType authentication2 = this.coreSettingsStorage.getCoreSettings().getAuthentication();
        if (AuthenticationType.ANONYMOUS == authentication2 && identity instanceof AnonymousIdentity) {
            if (identity instanceof AnonymousIdentity) {
                a.b(str6, "Anonymous Identity found. Requesting and storing auth token.", new Object[i4]);
                authTokenViaAnonymous = this.accessProvider.getAuthTokenViaAnonymous((AnonymousIdentity)identity);
                if (authTokenViaAnonymous == null) {
                    return errorResponse(chain, "Response was null, failed to auth user.");
                }
                int retryCounter = this.retryCounter;
                if (authTokenViaAnonymous.code() == 409 && retryCounter < 3) {
                    retryCounter = this.retryCounter;
                    if (retryCounter < 3) {
                        this.retryCounter = retryCounter++;
                        return intercept(chain);
                    }
                    return errorResponse(chain, "Response was 409, failed to auth user.");
                }
                zendesk.core.AccessToken authentication = (AuthenticationResponse)authTokenViaAnonymous.body().getAuthentication();
                if (authTokenViaAnonymous.body() != null && authentication != null) {
                    authentication = (AuthenticationResponse)authTokenViaAnonymous.body().getAuthentication();
                    if (authentication != null) {
                        this.identityManager.storeAccessToken(authentication);
                    }
                    this.retryCounter = i4;
                    return chain.proceed(chain.request());
                }
                return errorResponse(chain, "Response body was null, failed to auth user.");
            } else {
                if (AuthenticationType.JWT == authentication2 && identity instanceof JwtIdentity) {
                    if (identity instanceof JwtIdentity) {
                        a.b(str6, "JWT Identity found. Requesting and storing auth token.", new Object[i4]);
                        authTokenViaAnonymous = this.accessProvider.getAuthTokenViaJwt((JwtIdentity)identity);
                    }
                }
            }
        } else {
        }
        this.storage.clear();
        String errorLogMessage = ZendeskAccessInterceptor.getErrorLogMessage(authentication2, identity);
        a.e(str6, errorLogMessage, new Object[i4]);
        return errorResponse(chain, errorLogMessage);
    }
}
