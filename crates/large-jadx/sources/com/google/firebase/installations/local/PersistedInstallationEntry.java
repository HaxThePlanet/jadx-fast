package com.google.firebase.installations.local;

/* loaded from: classes2.dex */
public abstract class PersistedInstallationEntry {

    public static com.google.firebase.installations.local.PersistedInstallationEntry INSTANCE;

    public static abstract class Builder {
        public abstract com.google.firebase.installations.local.PersistedInstallationEntry build();

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setAuthToken(String string);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setExpiresInSecs(long l);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setFirebaseInstallationId(String string);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setFisError(String string);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setRefreshToken(String string);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setRegistrationStatus(com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus persistedInstallation$RegistrationStatus);

        public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long l);
    }
    static {
        PersistedInstallationEntry.INSTANCE = PersistedInstallationEntry.builder().build();
    }

    public static com.google.firebase.installations.local.PersistedInstallationEntry.Builder builder() {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        final int i = 0;
        return builder.setTokenCreationEpochInSecs(i).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(i);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        int i;
        i = getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR ? 1 : 0;
        return i;
    }

    public boolean isNotGenerated() {
        int i;
        com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus registrationStatus;
        com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus aTTEMPT_MIGRATION;
        if (getRegistrationStatus() != PersistedInstallation.RegistrationStatus.NOT_GENERATED) {
            if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public boolean isRegistered() {
        int i;
        i = getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED ? 1 : 0;
        return i;
    }

    public boolean isUnregistered() {
        int i;
        i = getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED ? 1 : 0;
        return i;
    }

    public boolean shouldAttemptMigration() {
        int i;
        i = getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION ? 1 : 0;
        return i;
    }

    public abstract com.google.firebase.installations.local.PersistedInstallationEntry.Builder toBuilder();

    public com.google.firebase.installations.local.PersistedInstallationEntry withAuthToken(String string, long l2, long l3) {
        return toBuilder().setAuthToken(string).setExpiresInSecs(l2).setTokenCreationEpochInSecs(obj5).build();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry withClearedAuthToken() {
        return toBuilder().setAuthToken(0).build();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry withFisError(String string) {
        return toBuilder().setFisError(string).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry withRegisteredFid(String string, String string2, long l3, String string4, long l5) {
        return toBuilder().setFirebaseInstallationId(string).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(l5).setRefreshToken(string2).setExpiresInSecs(obj7).setTokenCreationEpochInSecs(l3).build();
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry withUnregisteredFid(String string) {
        return toBuilder().setFirebaseInstallationId(string).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }
}
