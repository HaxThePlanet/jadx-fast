package zendesk.core;

import retrofit2.Call;
import retrofit2.http.POST;

/* loaded from: classes3.dex */
interface AccessService {
    @POST("/access/sdk/anonymous")
    public abstract Call<zendesk.core.AuthenticationResponse> getAuthTokenForAnonymous(zendesk.core.AuthenticationRequestWrapper authenticationRequestWrapper);

    @POST("/access/sdk/jwt")
    public abstract Call<zendesk.core.AuthenticationResponse> getAuthTokenForJwt(zendesk.core.AuthenticationRequestWrapper authenticationRequestWrapper);
}
