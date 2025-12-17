package com.google.firebase.installations.remote;

/* loaded from: classes2.dex */
final class AutoValue_TokenResult extends com.google.firebase.installations.remote.TokenResult {

    private final com.google.firebase.installations.remote.TokenResult.ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    static final class Builder extends com.google.firebase.installations.remote.TokenResult.Builder {

        private com.google.firebase.installations.remote.TokenResult.ResponseCode responseCode;
        private String token;
        private Long tokenExpirationTimestamp;
        private Builder(com.google.firebase.installations.remote.TokenResult tokenResult) {
            super();
            this.token = tokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.responseCode = tokenResult.getResponseCode();
        }

        Builder(com.google.firebase.installations.remote.TokenResult tokenResult, com.google.firebase.installations.remote.AutoValue_TokenResult.1 autoValue_TokenResult$12) {
            super(tokenResult);
        }

        @Override // com.google.firebase.installations.remote.TokenResult$Builder
        public com.google.firebase.installations.remote.TokenResult build() {
            Object tokenExpirationTimestamp;
            String string;
            if (this.tokenExpirationTimestamp == null) {
                tokenExpirationTimestamp = new StringBuilder();
                tokenExpirationTimestamp.append("");
                tokenExpirationTimestamp.append(" tokenExpirationTimestamp");
                string = tokenExpirationTimestamp.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.token, this.tokenExpirationTimestamp.longValue(), obj5, this.responseCode, 0);
                return autoValue_TokenResult;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing required properties:");
            stringBuilder.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.installations.remote.TokenResult$Builder
        public com.google.firebase.installations.remote.TokenResult.Builder setResponseCode(com.google.firebase.installations.remote.TokenResult.ResponseCode tokenResult$ResponseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult$Builder
        public com.google.firebase.installations.remote.TokenResult.Builder setToken(String string) {
            this.token = string;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult$Builder
        public com.google.firebase.installations.remote.TokenResult.Builder setTokenExpirationTimestamp(long l) {
            this.tokenExpirationTimestamp = Long.valueOf(l);
            return this;
        }
    }
    private AutoValue_TokenResult(String string, long l2, com.google.firebase.installations.remote.TokenResult.ResponseCode tokenResult$ResponseCode3) {
        super();
        this.token = string;
        this.tokenExpirationTimestamp = l2;
        this.responseCode = obj4;
    }

    AutoValue_TokenResult(String string, long l2, com.google.firebase.installations.remote.TokenResult.ResponseCode tokenResult$ResponseCode3, com.google.firebase.installations.remote.AutoValue_TokenResult.1 autoValue_TokenResult$14) {
        super(string, l2, responseCode3, 14);
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public boolean equals(Object object) {
        int i;
        com.google.firebase.installations.remote.TokenResult.ResponseCode responseCode;
        long tokenExpirationTimestamp;
        long tokenExpirationTimestamp2;
        boolean obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof TokenResult != null) {
            String token = this.token;
            if (token == null) {
                if ((TokenResult)object.getToken() == null) {
                    if (Long.compare(tokenExpirationTimestamp, tokenExpirationTimestamp2) == 0) {
                        responseCode = this.responseCode;
                        if (responseCode == null) {
                            if (object.getResponseCode() == null) {
                            } else {
                                i = i2;
                            }
                        } else {
                            if (responseCode.equals(object.getResponseCode())) {
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (token.equals(object.getToken()) && Long.compare(tokenExpirationTimestamp, tokenExpirationTimestamp2) == 0) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public com.google.firebase.installations.remote.TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public int hashCode() {
        int i2;
        int i;
        String token = this.token;
        if (token == null) {
            i2 = i;
        } else {
            i2 = token.hashCode();
        }
        int i8 = 1000003;
        long tokenExpirationTimestamp = this.tokenExpirationTimestamp;
        com.google.firebase.installations.remote.TokenResult.ResponseCode responseCode = this.responseCode;
        if (responseCode == null) {
        } else {
            i = responseCode.hashCode();
        }
        return i6 ^= i;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public com.google.firebase.installations.remote.TokenResult.Builder toBuilder() {
        AutoValue_TokenResult.Builder builder = new AutoValue_TokenResult.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TokenResult{token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", tokenExpirationTimestamp=");
        stringBuilder.append(this.tokenExpirationTimestamp);
        stringBuilder.append(", responseCode=");
        stringBuilder.append(this.responseCode);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
