package com.google.firebase.installations.remote;

/* loaded from: classes2.dex */
final class AutoValue_InstallationResponse extends com.google.firebase.installations.remote.InstallationResponse {

    private final com.google.firebase.installations.remote.TokenResult authToken;
    private final String fid;
    private final String refreshToken;
    private final com.google.firebase.installations.remote.InstallationResponse.ResponseCode responseCode;
    private final String uri;

    static final class Builder extends com.google.firebase.installations.remote.InstallationResponse.Builder {

        private com.google.firebase.installations.remote.TokenResult authToken;
        private String fid;
        private String refreshToken;
        private com.google.firebase.installations.remote.InstallationResponse.ResponseCode responseCode;
        private String uri;
        private Builder(com.google.firebase.installations.remote.InstallationResponse installationResponse) {
            super();
            this.uri = installationResponse.getUri();
            this.fid = installationResponse.getFid();
            this.refreshToken = installationResponse.getRefreshToken();
            this.authToken = installationResponse.getAuthToken();
            this.responseCode = installationResponse.getResponseCode();
        }

        Builder(com.google.firebase.installations.remote.InstallationResponse installationResponse, com.google.firebase.installations.remote.AutoValue_InstallationResponse.1 autoValue_InstallationResponse$12) {
            super(installationResponse);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse build() {
            super(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode, 0);
            return autoValue_InstallationResponse;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse.Builder setAuthToken(com.google.firebase.installations.remote.TokenResult tokenResult) {
            this.authToken = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse.Builder setFid(String string) {
            this.fid = string;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse.Builder setRefreshToken(String string) {
            this.refreshToken = string;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse.Builder setResponseCode(com.google.firebase.installations.remote.InstallationResponse.ResponseCode installationResponse$ResponseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse$Builder
        public com.google.firebase.installations.remote.InstallationResponse.Builder setUri(String string) {
            this.uri = string;
            return this;
        }
    }
    private AutoValue_InstallationResponse(String string, String string2, String string3, com.google.firebase.installations.remote.TokenResult tokenResult4, com.google.firebase.installations.remote.InstallationResponse.ResponseCode installationResponse$ResponseCode5) {
        super();
        this.uri = string;
        this.fid = string2;
        this.refreshToken = string3;
        this.authToken = tokenResult4;
        this.responseCode = responseCode5;
    }

    AutoValue_InstallationResponse(String string, String string2, String string3, com.google.firebase.installations.remote.TokenResult tokenResult4, com.google.firebase.installations.remote.InstallationResponse.ResponseCode installationResponse$ResponseCode5, com.google.firebase.installations.remote.AutoValue_InstallationResponse.1 autoValue_InstallationResponse$16) {
        super(string, string2, string3, tokenResult4, responseCode5);
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public boolean equals(Object object) {
        int i;
        com.google.firebase.installations.remote.InstallationResponse.ResponseCode refreshToken;
        com.google.firebase.installations.remote.TokenResult refreshToken2;
        boolean obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof InstallationResponse != null) {
            String uri = this.uri;
            if (uri == null) {
                if ((InstallationResponse)object.getUri() == null) {
                    String fid = this.fid;
                    if (fid == null) {
                        if (object.getFid() == null) {
                            String refreshToken3 = this.refreshToken;
                            if (refreshToken3 == null) {
                                if (object.getRefreshToken() == null) {
                                    com.google.firebase.installations.remote.TokenResult authToken = this.authToken;
                                    if (authToken == null) {
                                        if (object.getAuthToken() == null) {
                                            refreshToken = this.responseCode;
                                            if (refreshToken == null) {
                                                if (object.getResponseCode() == null) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                                if (refreshToken.equals(object.getResponseCode())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                        if (authToken.equals(object.getAuthToken())) {
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            } else {
                                if (refreshToken3.equals(object.getRefreshToken())) {
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                        if (fid.equals(object.getFid())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
                if (uri.equals(object.getUri())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public com.google.firebase.installations.remote.TokenResult getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getFid() {
        return this.fid;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public com.google.firebase.installations.remote.InstallationResponse.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getUri() {
        return this.uri;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public int hashCode() {
        int i2;
        int i;
        int i4;
        int i5;
        int i3;
        String uri = this.uri;
        i = 0;
        if (uri == null) {
            i2 = i;
        } else {
            i2 = uri.hashCode();
        }
        int i15 = 1000003;
        String fid = this.fid;
        if (fid == null) {
            i4 = i;
        } else {
            i4 = fid.hashCode();
        }
        String refreshToken = this.refreshToken;
        if (refreshToken == null) {
            i5 = i;
        } else {
            i5 = refreshToken.hashCode();
        }
        com.google.firebase.installations.remote.TokenResult authToken = this.authToken;
        if (authToken == null) {
            i3 = i;
        } else {
            i3 = authToken.hashCode();
        }
        com.google.firebase.installations.remote.InstallationResponse.ResponseCode responseCode = this.responseCode;
        if (responseCode == null) {
        } else {
            i = responseCode.hashCode();
        }
        return i13 ^= i;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public com.google.firebase.installations.remote.InstallationResponse.Builder toBuilder() {
        AutoValue_InstallationResponse.Builder builder = new AutoValue_InstallationResponse.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstallationResponse{uri=");
        stringBuilder.append(this.uri);
        stringBuilder.append(", fid=");
        stringBuilder.append(this.fid);
        stringBuilder.append(", refreshToken=");
        stringBuilder.append(this.refreshToken);
        stringBuilder.append(", authToken=");
        stringBuilder.append(this.authToken);
        stringBuilder.append(", responseCode=");
        stringBuilder.append(this.responseCode);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
