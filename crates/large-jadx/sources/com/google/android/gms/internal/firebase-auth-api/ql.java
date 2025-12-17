package com.google.android.gms.internal.firebase-auth-api;

import android.accounts.Account;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseAuthWebException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ql {

    static final SparseArray<Pair<String, String>> a;
    static {
        SparseArray sparseArray = new SparseArray();
        ql.a = sparseArray;
        Pair pair = new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation.");
        sparseArray.put(17000, pair);
        Pair pair2 = new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience.");
        sparseArray.put(17002, pair2);
        Pair pair3 = new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired.");
        sparseArray.put(17004, pair3);
        Pair pair4 = new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted.");
        sparseArray.put(17008, pair4);
        Pair pair5 = new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password.");
        sparseArray.put(17009, pair5);
        Pair pair6 = new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user.");
        sparseArray.put(17024, pair6);
        Pair pair7 = new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request.");
        sparseArray.put(17014, pair7);
        Pair pair8 = new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address.");
        sparseArray.put(17012, pair8);
        Pair pair9 = new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account.");
        sparseArray.put(17007, pair9);
        Pair pair10 = new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account.");
        sparseArray.put(17025, pair10);
        Pair pair11 = new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator.");
        sparseArray.put(17005, pair11);
        Pair pair12 = new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again.");
        sparseArray.put(17021, pair12);
        Pair pair13 = new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted.");
        sparseArray.put(17011, pair13);
        Pair pair14 = new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key.");
        sparseArray.put(17017, pair14);
        Pair pair15 = new Pair("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section.");
        sparseArray.put(17006, pair15);
        Pair pair16 = new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid.");
        sparseArray.put(17026, pair16);
        Pair pair17 = new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired.");
        sparseArray.put(17029, pair17);
        Pair pair18 = new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used.");
        sparseArray.put(17030, pair18);
        Pair pair19 = new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console.");
        sparseArray.put(17031, pair19);
        Pair pair20 = new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid.");
        sparseArray.put(17033, pair20);
        Pair pair21 = new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console.");
        sparseArray.put(17032, pair21);
        Pair pair22 = new Pair("ERROR_MISSING_EMAIL", "An email address must be provided.");
        sparseArray.put(17034, pair22);
        Pair pair23 = new Pair("ERROR_MISSING_PASSWORD", "A password must be provided.");
        sparseArray.put(17035, pair23);
        Pair pair24 = new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient.");
        sparseArray.put(17041, pair24);
        Pair pair25 = new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code].");
        sparseArray.put(17042, pair25);
        Pair pair26 = new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code");
        sparseArray.put(17043, pair26);
        Pair pair27 = new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user.");
        sparseArray.put(17044, pair27);
        Pair pair28 = new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID");
        sparseArray.put(17045, pair28);
        Pair pair29 = new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid.");
        sparseArray.put(17046, pair29);
        Pair pair30 = new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication.");
        sparseArray.put(17049, pair30);
        Pair pair31 = new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again.");
        sparseArray.put(17051, pair31);
        Pair pair32 = new Pair("ERROR_QUOTA_EXCEEDED", "This project's quota for this operation has been exceeded.");
        sparseArray.put(17052, pair32);
        Pair pair33 = new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verify that the correct package name and SHA-1 are configured in the Firebase Console.");
        sparseArray.put(17028, pair33);
        Pair pair34 = new Pair("ERROR_API_NOT_AVAILABLE_WITHOUT_GOOGLE_PLAY", "The API that you are calling is not available on devices without Google Play services.");
        sparseArray.put(17063, pair34);
        Pair pair35 = new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget.");
        sparseArray.put(17062, pair35);
        Pair pair36 = new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash.");
        sparseArray.put(17064, pair36);
        Pair pair37 = new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled.");
        sparseArray.put(17065, pair37);
        Pair pair38 = new Pair("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request.");
        sparseArray.put(17040, pair38);
        Pair pair39 = new Pair("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions.");
        sparseArray.put(17068, pair39);
        Pair pair40 = new Pair("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid.");
        sparseArray.put(17071, pair40);
        Pair pair41 = new Pair("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish.");
        sparseArray.put(17057, pair41);
        Pair pair42 = new Pair("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user.");
        sparseArray.put(17058, pair42);
        Pair pair43 = new Pair("ERROR_TENANT_ID_MISMATCH", "The provided tenant ID does not match the Auth instance's tenant ID.");
        sparseArray.put(17072, pair43);
        Pair pair44 = new Pair("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context.");
        sparseArray.put(17073, pair44);
        Pair pair45 = new Pair("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project.");
        sparseArray.put(17074, pair45);
        Pair pair46 = new Pair("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials");
        sparseArray.put(17075, pair46);
        Pair pair47 = new Pair("ERROR_PHONE_NUMBER_NOT_FOUND", "The provided phone number does not match any of the second factor phone numbers associated with this user.");
        sparseArray.put(17077, pair47);
        Pair pair48 = new Pair("ERROR_INVALID_TENANT_ID", "The Auth instance's tenant ID is invalid.");
        sparseArray.put(17079, pair48);
        Pair pair49 = new Pair("ERROR_SECOND_FACTOR_REQUIRED", "Please complete a second factor challenge to finish signing into this account.");
        sparseArray.put(17078, pair49);
        Pair pair50 = new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available.");
        sparseArray.put(17080, pair50);
        Pair pair51 = new Pair("ERROR_MISSING_MULTI_FACTOR_SESSION", "The request is missing proof of first factor successful sign-in.");
        sparseArray.put(17081, pair51);
        Pair pair52 = new Pair("ERROR_MISSING_MULTI_FACTOR_INFO", "No second factor identifier is provided.");
        sparseArray.put(17082, pair52);
        Pair pair53 = new Pair("ERROR_INVALID_MULTI_FACTOR_SESSION", "The request does not contain a valid proof of first factor successful sign-in.");
        sparseArray.put(17083, pair53);
        Pair pair54 = new Pair("ERROR_MULTI_FACTOR_INFO_NOT_FOUND", "The user does not have a second factor matching the identifier provided.");
        sparseArray.put(17084, pair54);
        Pair pair55 = new Pair("ERROR_ADMIN_RESTRICTED_OPERATION", "This operation is restricted to administrators only.");
        sparseArray.put(17085, pair55);
        Pair pair56 = new Pair("ERROR_UNVERIFIED_EMAIL", "This operation requires a verified email.");
        sparseArray.put(17086, pair56);
        Pair pair57 = new Pair("ERROR_SECOND_FACTOR_ALREADY_ENROLLED", "The second factor is already enrolled on this account.");
        sparseArray.put(17087, pair57);
        Pair pair58 = new Pair("ERROR_MAXIMUM_SECOND_FACTOR_COUNT_EXCEEDED", "The maximum allowed number of second factors on a user has been exceeded.");
        sparseArray.put(17088, pair58);
        Pair pair59 = new Pair("ERROR_UNSUPPORTED_FIRST_FACTOR", "Enrolling a second factor or signing in with a multi-factor account requires sign-in with a supported first factor.");
        sparseArray.put(17089, pair59);
        Pair pair60 = new Pair("ERROR_EMAIL_CHANGE_NEEDS_VERIFICATION", "Multi-factor users must always have a verified email.");
        sparseArray.put(17090, pair60);
        Pair pair61 = new Pair("ERROR_INTERNAL_SUCCESS_SIGN_OUT", "This is an internal error code indicating that the operation was successful but the user needs to be signed out.");
        sparseArray.put(17091, pair61);
        Pair pair62 = new Pair("ERROR_MISSING_CLIENT_IDENTIFIER", "This request is missing a valid app identifier, meaning that neither SafetyNet checks nor reCAPTCHA checks succeeded. Please try again, or check the logcat for more details.");
        sparseArray.put(17093, pair62);
        Pair pair63 = new Pair("ERROR_MISSING_OR_INVALID_NONCE", "The request does not contain a valid nonce. This can occur if the SHA-256 hash of the provided raw nonce does not match the hashed nonce in the ID token payload.");
        sparseArray.put(17094, pair63);
        Pair pair64 = new Pair("ERROR_USER_CANCELLED", "The user did not grant your application the permissions it requested.");
        sparseArray.put(18001, pair64);
    }

    public static FirebaseException a(Status status) {
        String str;
        int str2;
        int i = status.k2();
        String str19 = ql.e(ql.f(i), status);
        if (i != 17020 && i != 17021 && i != 17051 && i != 17052 && i != 17057 && i != 17058) {
            if (i != 17021) {
                if (i != 17051) {
                    if (i != 17052) {
                        if (i != 17057) {
                            if (i != 17058) {
                                str2 = "An internal error has occurred.";
                                switch (i) {
                                    case 17000:
                                        FirebaseAuthInvalidCredentialsException obj3 = new FirebaseAuthInvalidCredentialsException(ql.d(i), str19);
                                        return obj3;
                                    case 17002:
                                        obj3 = new FirebaseAuthInvalidUserException(ql.d(i), str19);
                                        return obj3;
                                    case 17004:
                                        obj3 = new FirebaseAuthException(ql.d(i), str19);
                                        return obj3;
                                    case 17005:
                                        obj3 = new FirebaseAuthUserCollisionException(ql.d(i), str19);
                                        return obj3;
                                    case 17006:
                                        FirebaseTooManyRequestsException firebaseTooManyRequestsException = new FirebaseTooManyRequestsException(ql.e("We have blocked all requests from this device due to unusual activity. Try again later.", status));
                                        return firebaseTooManyRequestsException;
                                    case 17007:
                                        obj3 = new FirebaseApiNotAvailableException(str19);
                                        return obj3;
                                    case 17008:
                                        FirebaseNoSignedInUserException firebaseNoSignedInUserException = new FirebaseNoSignedInUserException(ql.e("Please sign in before trying to get a token.", status));
                                        return firebaseNoSignedInUserException;
                                    case 17009:
                                        FirebaseException firebaseException = new FirebaseException(ql.e(str2, status));
                                        return firebaseException;
                                    default:
                                        FirebaseNetworkException firebaseNetworkException2 = new FirebaseNetworkException(ql.e("There was a failure in the connection between the web widget and the Firebase Auth backend.", status));
                                        return firebaseNetworkException2;
                                        obj3 = new FirebaseAuthEmailException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthActionCodeException(ql.d(i), str19);
                                        return obj3;
                                        FirebaseAuthWeakPasswordException firebaseAuthWeakPasswordException = new FirebaseAuthWeakPasswordException(ql.d(i), str19, status.l2());
                                        return firebaseAuthWeakPasswordException;
                                        FirebaseException firebaseException2 = new FirebaseException(ql.e("User was not linked to an account with the given provider.", status));
                                        return firebaseException2;
                                        FirebaseException firebaseException3 = new FirebaseException(ql.e("User has already been linked to the given provider.", status));
                                        return firebaseException3;
                                        obj3 = new FirebaseAuthRecentLoginRequiredException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseApiNotAvailableException(str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthUserCollisionException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthWebException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthInvalidCredentialsException(ql.d(i), str19);
                                        return obj3;
                                        obj3 = new FirebaseAuthInvalidUserException(ql.d(i), str19);
                                        return obj3;
                                }
                                obj3 = new FirebaseException(str2);
                                return obj3;
                            }
                        }
                    }
                    obj3 = new FirebaseTooManyRequestsException(str19);
                    return obj3;
                }
            }
        }
        FirebaseNetworkException firebaseNetworkException = new FirebaseNetworkException(ql.e("A network error (such as timeout, interrupted connection or unreachable host) has occurred.", status));
        return firebaseNetworkException;
    }

    public static FirebaseException b(Status status, AuthCredential authCredential2, String string3, String string4) {
        int i;
        int i2 = status.k2();
        if (i2 != 17012 && i2 != 17007 && i2 == 17025) {
            if (i2 != 17007) {
                if (i2 == 17025) {
                }
                return ql.a(status);
            }
        }
        FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = new FirebaseAuthUserCollisionException(ql.d(i2), ql.e(ql.f(i2), status));
        firebaseAuthUserCollisionException.zza(authCredential2);
        firebaseAuthUserCollisionException.zzb(string3);
        firebaseAuthUserCollisionException.zzc(string4);
        return firebaseAuthUserCollisionException;
    }

    public static FirebaseAuthMultiFactorException c(FirebaseAuth firebaseAuth, com.google.android.gms.internal.firebase-auth-api.yf yf2, FirebaseUser firebaseUser3) {
        Object next;
        boolean z;
        Objects.requireNonNull(firebaseAuth);
        Objects.requireNonNull(yf2);
        Object obj = ql.a.get(17078);
        android.os.Parcelable.Creator cREATOR = zzae.CREATOR;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = yf2.k2().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof PhoneMultiFactorInfo) {
            }
            arrayList.add((PhoneMultiFactorInfo)(MultiFactorInfo)next);
        }
        super(arrayList, zzag.zzb(yf2.k2(), yf2.zzb()), firebaseAuth.getApp().getName(), yf2.j2(), (zzx)firebaseUser3);
        FirebaseAuthMultiFactorException firebaseAuthMultiFactorException = new FirebaseAuthMultiFactorException((String)obj.first, (String)obj.second, zzae);
        return firebaseAuthMultiFactorException;
    }

    private static String d(int i) {
        Object obj1;
        obj1 = ql.a.get(i);
        if ((Pair)obj1 != null) {
            obj1 = obj1.first;
        } else {
            obj1 = "INTERNAL_ERROR";
        }
        return obj1;
    }

    private static String e(String string, Status status2) {
        if (TextUtils.isEmpty(status2.l2())) {
            return string;
        }
        Object[] arr = new Object[1];
        return String.format(String.valueOf(string).concat(" [ %s ]"), status2.l2());
    }

    private static String f(int i) {
        Object obj1;
        obj1 = ql.a.get(i);
        if ((Pair)obj1 != null) {
            obj1 = obj1.second;
        } else {
            obj1 = "An internal error has occurred.";
        }
        return obj1;
    }
}
