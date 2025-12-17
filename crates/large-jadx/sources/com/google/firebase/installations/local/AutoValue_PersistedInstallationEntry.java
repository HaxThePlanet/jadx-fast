package com.google.firebase.installations.local;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_PersistedInstallationEntry extends com.google.firebase.installations.local.PersistedInstallationEntry {

    private final String authToken;
    private final long expiresInSecs;
    private final String firebaseInstallationId;
    private final String fisError;
    private final String refreshToken;
    private final com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus registrationStatus;
    private final long tokenCreationEpochInSecs;

    static final class Builder extends com.google.firebase.installations.local.PersistedInstallationEntry.Builder {

        private String authToken;
        private Long expiresInSecs;
        private String firebaseInstallationId;
        private String fisError;
        private String refreshToken;
        private com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus registrationStatus;
        private Long tokenCreationEpochInSecs;
        private Builder(com.google.firebase.installations.local.PersistedInstallationEntry persistedInstallationEntry) {
            super();
            this.firebaseInstallationId = persistedInstallationEntry.getFirebaseInstallationId();
            this.registrationStatus = persistedInstallationEntry.getRegistrationStatus();
            this.authToken = persistedInstallationEntry.getAuthToken();
            this.refreshToken = persistedInstallationEntry.getRefreshToken();
            this.expiresInSecs = Long.valueOf(persistedInstallationEntry.getExpiresInSecs());
            this.tokenCreationEpochInSecs = Long.valueOf(persistedInstallationEntry.getTokenCreationEpochInSecs());
            this.fisError = persistedInstallationEntry.getFisError();
        }

        Builder(com.google.firebase.installations.local.PersistedInstallationEntry persistedInstallationEntry, com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.1 autoValue_PersistedInstallationEntry$12) {
            super(persistedInstallationEntry);
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry build() {
            Object registrationStatus;
            Object expiresInSecs;
            Object tokenCreationEpochInSecs;
            String string;
            if (this.registrationStatus == null) {
                registrationStatus = new StringBuilder();
                registrationStatus.append("");
                registrationStatus.append(" registrationStatus");
                string = registrationStatus.toString();
            }
            if (this.expiresInSecs == null) {
                expiresInSecs = new StringBuilder();
                expiresInSecs.append(string);
                expiresInSecs.append(" expiresInSecs");
                string = expiresInSecs.toString();
            }
            if (this.tokenCreationEpochInSecs == null) {
                tokenCreationEpochInSecs = new StringBuilder();
                tokenCreationEpochInSecs.append(string);
                tokenCreationEpochInSecs.append(" tokenCreationEpochInSecs");
                string = tokenCreationEpochInSecs.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), obj8, this.tokenCreationEpochInSecs.longValue(), obj10, this.fisError, 0);
                return autoValue_PersistedInstallationEntry;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing required properties:");
            stringBuilder.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setAuthToken(String string) {
            this.authToken = string;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setExpiresInSecs(long l) {
            this.expiresInSecs = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setFirebaseInstallationId(String string) {
            this.firebaseInstallationId = string;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setFisError(String string) {
            this.fisError = string;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setRefreshToken(String string) {
            this.refreshToken = string;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setRegistrationStatus(com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus persistedInstallation$RegistrationStatus) {
            Objects.requireNonNull(registrationStatus, "Null registrationStatus");
            this.registrationStatus = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry$Builder
        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long l) {
            this.tokenCreationEpochInSecs = Long.valueOf(l);
            return this;
        }
    }
    private AutoValue_PersistedInstallationEntry(String string, com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus persistedInstallation$RegistrationStatus2, String string3, String string4, long l5, long l6, String string7) {
        super();
        this.firebaseInstallationId = string;
        this.registrationStatus = registrationStatus2;
        this.authToken = string3;
        this.refreshToken = string4;
        this.expiresInSecs = l5;
        this.tokenCreationEpochInSecs = string7;
        this.fisError = obj9;
    }

    AutoValue_PersistedInstallationEntry(String string, com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus persistedInstallation$RegistrationStatus2, String string3, String string4, long l5, long l6, String string7, com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.1 autoValue_PersistedInstallationEntry$18) {
        super(string, registrationStatus2, string3, string4, l5, l6, string7, 18, obj9);
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public boolean equals(Object object) {
        int i;
        boolean firebaseInstallationId2;
        String firebaseInstallationId;
        long tokenCreationEpochInSecs;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof PersistedInstallationEntry) {
            String firebaseInstallationId3 = this.firebaseInstallationId;
            if (firebaseInstallationId3 == null) {
                if ((PersistedInstallationEntry)object.getFirebaseInstallationId() == null) {
                    if (this.registrationStatus.equals(object.getRegistrationStatus())) {
                        String authToken = this.authToken;
                        if (authToken == null) {
                            if (object.getAuthToken() == null) {
                                String refreshToken = this.refreshToken;
                                if (refreshToken == null) {
                                    if (object.getRefreshToken() == null) {
                                        if (Long.compare(firebaseInstallationId, tokenCreationEpochInSecs) == 0) {
                                            if (Long.compare(firebaseInstallationId, tokenCreationEpochInSecs) == 0) {
                                                firebaseInstallationId2 = this.fisError;
                                                if (firebaseInstallationId2 == null) {
                                                    if (object.getFisError() == null) {
                                                    } else {
                                                        i = i2;
                                                    }
                                                } else {
                                                    if (firebaseInstallationId2.equals(object.getFisError())) {
                                                    } else {
                                                    }
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                    if (refreshToken.equals(object.getRefreshToken()) && Long.compare(firebaseInstallationId, tokenCreationEpochInSecs) == 0 && Long.compare(firebaseInstallationId, tokenCreationEpochInSecs) == 0) {
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
                }
            } else {
                if (firebaseInstallationId3.equals(object.getFirebaseInstallationId()) && this.registrationStatus.equals(object.getRegistrationStatus())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getExpiresInSecs() {
        return this.expiresInSecs;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String getFisError() {
        return this.fisError;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.registrationStatus;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getTokenCreationEpochInSecs() {
        return this.tokenCreationEpochInSecs;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        String firebaseInstallationId = this.firebaseInstallationId;
        i2 = 0;
        if (firebaseInstallationId == null) {
            i = i2;
        } else {
            i = firebaseInstallationId.hashCode();
        }
        int i18 = 1000003;
        String authToken = this.authToken;
        if (authToken == null) {
            i3 = i2;
        } else {
            i3 = authToken.hashCode();
        }
        String refreshToken = this.refreshToken;
        if (refreshToken == null) {
            i4 = i2;
        } else {
            i4 = refreshToken.hashCode();
        }
        long expiresInSecs = this.expiresInSecs;
        int i24 = 32;
        long tokenCreationEpochInSecs = this.tokenCreationEpochInSecs;
        String fisError = this.fisError;
        if (fisError == null) {
        } else {
            i2 = fisError.hashCode();
        }
        return i16 ^= i2;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public com.google.firebase.installations.local.PersistedInstallationEntry.Builder toBuilder() {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersistedInstallationEntry{firebaseInstallationId=");
        stringBuilder.append(this.firebaseInstallationId);
        stringBuilder.append(", registrationStatus=");
        stringBuilder.append(this.registrationStatus);
        stringBuilder.append(", authToken=");
        stringBuilder.append(this.authToken);
        stringBuilder.append(", refreshToken=");
        stringBuilder.append(this.refreshToken);
        stringBuilder.append(", expiresInSecs=");
        stringBuilder.append(this.expiresInSecs);
        stringBuilder.append(", tokenCreationEpochInSecs=");
        stringBuilder.append(this.tokenCreationEpochInSecs);
        stringBuilder.append(", fisError=");
        stringBuilder.append(this.fisError);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
