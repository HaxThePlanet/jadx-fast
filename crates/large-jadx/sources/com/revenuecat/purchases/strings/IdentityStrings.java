package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0004¨\u0006\u0011", d2 = {"Lcom/revenuecat/purchases/strings/IdentityStrings;", "", "", "IDENTIFYING_ANON_ID", "Ljava/lang/String;", "IDENTIFYING_APP_USER_ID", "LOG_OUT_CALLED_ON_ANONYMOUS_USER", "LOG_OUT_SUCCESSFUL", "CREATING_ALIAS_SUCCESS", "SETTING_NEW_ANON_ID", "LOGGING_IN", "CHANGING_APP_USER_ID", "CREATING_ALIAS", "LOG_IN_ERROR_MISSING_APP_USER_ID", "LOG_IN_SUCCESSFUL", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class IdentityStrings {

    public static final String CHANGING_APP_USER_ID = "Changing App User ID: %s -> %s";
    public static final String CREATING_ALIAS = "Creating an alias to %s from %s";
    public static final String CREATING_ALIAS_SUCCESS = "Alias created";
    public static final String IDENTIFYING_ANON_ID = "Identifying from an anonymous ID: %s. An alias will be created.";
    public static final String IDENTIFYING_APP_USER_ID = "Identifying App User ID: %s";
    public static final com.revenuecat.purchases.strings.IdentityStrings INSTANCE = null;
    public static final String LOGGING_IN = "Logging in from %s -> %s";
    public static final String LOG_IN_ERROR_MISSING_APP_USER_ID = "Error logging in: appUserID can't be null, empty or blank";
    public static final String LOG_IN_SUCCESSFUL = "Logged in successfully as %s. Created: %s";
    public static final String LOG_OUT_CALLED_ON_ANONYMOUS_USER = "Called logOut but the current user is anonymous";
    public static final String LOG_OUT_SUCCESSFUL = "Logged out successfully";
    public static final String SETTING_NEW_ANON_ID = "Setting new anonymous App User ID - %s";
    static {
        IdentityStrings identityStrings = new IdentityStrings();
        IdentityStrings.INSTANCE = identityStrings;
    }
}
