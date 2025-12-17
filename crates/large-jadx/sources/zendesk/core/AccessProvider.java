package zendesk.core;

import retrofit2.Response;

/* loaded from: classes3.dex */
interface AccessProvider {

    public static final String NO_JWT_ERROR_MESSAGE = "The jwt user identifier is null or empty. We cannot proceed to get an access token";
    public abstract Response<zendesk.core.AuthenticationResponse> getAuthTokenViaAnonymous(zendesk.core.AnonymousIdentity anonymousIdentity);

    public abstract Response<zendesk.core.AuthenticationResponse> getAuthTokenViaJwt(zendesk.core.JwtIdentity jwtIdentity);
}
