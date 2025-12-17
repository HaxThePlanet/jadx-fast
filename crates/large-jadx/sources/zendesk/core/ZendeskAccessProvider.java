package zendesk.core;

import f.g.c.a;
import f.g.e.g;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
class ZendeskAccessProvider implements zendesk.core.AccessProvider {

    private static final String LOG_TAG = "ZendeskAccessProvider";
    private final zendesk.core.AccessService accessService;
    private final zendesk.core.IdentityManager identityManager;
    ZendeskAccessProvider(zendesk.core.IdentityManager identityManager, zendesk.core.AccessService accessService2) {
        super();
        this.identityManager = identityManager;
        this.accessService = accessService2;
    }

    public Response<zendesk.core.AuthenticationResponse> getAuthTokenViaAnonymous(zendesk.core.AnonymousIdentity anonymousIdentity) {
        a.b("ZendeskAccessProvider", "Requesting an access token for anonymous identity.", new Object[0]);
        ApiAnonymousIdentity apiAnonymousIdentity = new ApiAnonymousIdentity(anonymousIdentity, this.identityManager.getSdkGuid());
        AuthenticationRequestWrapper authenticationRequestWrapper = new AuthenticationRequestWrapper(apiAnonymousIdentity);
        return this.accessService.getAuthTokenForAnonymous(authenticationRequestWrapper).execute();
    }

    public Response<zendesk.core.AuthenticationResponse> getAuthTokenViaJwt(zendesk.core.JwtIdentity jwtIdentity) {
        int i = 0;
        final String str2 = "ZendeskAccessProvider";
        a.b(str2, "Requesting an access token for jwt identity.", new Object[i]);
        if (g.e(jwtIdentity.getJwtUserIdentifier())) {
            a.e(str2, "The jwt user identifier is null or empty. We cannot proceed to get an access token", new Object[i]);
            return 0;
        }
        AuthenticationRequestWrapper authenticationRequestWrapper = new AuthenticationRequestWrapper(jwtIdentity);
        return this.accessService.getAuthTokenForJwt(authenticationRequestWrapper).execute();
    }
}
