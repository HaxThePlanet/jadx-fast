package com.google.firebase.installations;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_InstallationTokenResult extends com.google.firebase.installations.InstallationTokenResult {

    private final String token;
    private final long tokenCreationTimestamp;
    private final long tokenExpirationTimestamp;

    static final class Builder extends com.google.firebase.installations.InstallationTokenResult.Builder {

        private String token;
        private Long tokenCreationTimestamp;
        private Long tokenExpirationTimestamp;
        private Builder(com.google.firebase.installations.InstallationTokenResult installationTokenResult) {
            super();
            this.token = installationTokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.tokenCreationTimestamp = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }

        Builder(com.google.firebase.installations.InstallationTokenResult installationTokenResult, com.google.firebase.installations.AutoValue_InstallationTokenResult.1 autoValue_InstallationTokenResult$12) {
            super(installationTokenResult);
        }

        @Override // com.google.firebase.installations.InstallationTokenResult$Builder
        public com.google.firebase.installations.InstallationTokenResult build() {
            Object stringBuilder;
            Object tokenExpirationTimestamp;
            Object tokenCreationTimestamp;
            String string;
            if (this.token == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" token");
                string = stringBuilder.toString();
            }
            if (this.tokenExpirationTimestamp == null) {
                tokenExpirationTimestamp = new StringBuilder();
                tokenExpirationTimestamp.append(string);
                tokenExpirationTimestamp.append(" tokenExpirationTimestamp");
                string = tokenExpirationTimestamp.toString();
            }
            if (this.tokenCreationTimestamp == null) {
                tokenCreationTimestamp = new StringBuilder();
                tokenCreationTimestamp.append(string);
                tokenCreationTimestamp.append(" tokenCreationTimestamp");
                string = tokenCreationTimestamp.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.token, this.tokenExpirationTimestamp.longValue(), obj5, this.tokenCreationTimestamp.longValue(), obj7, 0);
                return autoValue_InstallationTokenResult;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult$Builder
        public com.google.firebase.installations.InstallationTokenResult.Builder setToken(String string) {
            Objects.requireNonNull(string, "Null token");
            this.token = string;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult$Builder
        public com.google.firebase.installations.InstallationTokenResult.Builder setTokenCreationTimestamp(long l) {
            this.tokenCreationTimestamp = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult$Builder
        public com.google.firebase.installations.InstallationTokenResult.Builder setTokenExpirationTimestamp(long l) {
            this.tokenExpirationTimestamp = Long.valueOf(l);
            return this;
        }
    }
    private AutoValue_InstallationTokenResult(String string, long l2, long l3) {
        super();
        this.token = string;
        this.tokenExpirationTimestamp = l2;
        this.tokenCreationTimestamp = obj4;
    }

    AutoValue_InstallationTokenResult(String string, long l2, long l3, com.google.firebase.installations.AutoValue_InstallationTokenResult.1 autoValue_InstallationTokenResult$14) {
        super(string, l2, l3, 14, obj5);
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public boolean equals(Object object) {
        int i;
        boolean equals;
        String tokenExpirationTimestamp2;
        long tokenExpirationTimestamp;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof InstallationTokenResult != null) {
            if (this.token.equals((InstallationTokenResult)object.getToken()) && Long.compare(tokenExpirationTimestamp2, tokenExpirationTimestamp) == 0 && Long.compare(tokenExpirationTimestamp2, tokenExpirationTimestamp) == 0) {
                if (Long.compare(tokenExpirationTimestamp2, tokenExpirationTimestamp) == 0) {
                    if (Long.compare(tokenExpirationTimestamp2, tokenExpirationTimestamp) == 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public int hashCode() {
        int i7 = 1000003;
        long tokenExpirationTimestamp = this.tokenExpirationTimestamp;
        final int i13 = 32;
        long tokenCreationTimestamp = this.tokenCreationTimestamp;
        return i5 ^= i9;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public com.google.firebase.installations.InstallationTokenResult.Builder toBuilder() {
        AutoValue_InstallationTokenResult.Builder builder = new AutoValue_InstallationTokenResult.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstallationTokenResult{token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", tokenExpirationTimestamp=");
        stringBuilder.append(this.tokenExpirationTimestamp);
        stringBuilder.append(", tokenCreationTimestamp=");
        stringBuilder.append(this.tokenCreationTimestamp);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
