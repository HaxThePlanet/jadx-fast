package androidx.compose.ui.autofill;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\"2\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00028@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"androidAutofillTypes", "Ljava/util/HashMap;", "Landroidx/compose/ui/autofill/AutofillType;", "", "Lkotlin/collections/HashMap;", "getAndroidAutofillTypes$annotations", "()V", "androidType", "getAndroidType$annotations", "(Landroidx/compose/ui/autofill/AutofillType;)V", "getAndroidType", "(Landroidx/compose/ui/autofill/AutofillType;)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAutofillType_androidKt {

    private static final HashMap<androidx.compose.ui.autofill.AutofillType, String> androidAutofillTypes;
    static {
        kotlin.Pair[] arr = new Pair[36];
        AndroidAutofillType_androidKt.androidAutofillTypes = MapsKt.hashMapOf(TuplesKt.to(AutofillType.EmailAddress, "emailAddress"), TuplesKt.to(AutofillType.Username, "username"), TuplesKt.to(AutofillType.Password, "password"), TuplesKt.to(AutofillType.NewUsername, "newUsername"), TuplesKt.to(AutofillType.NewPassword, "newPassword"), TuplesKt.to(AutofillType.PostalAddress, "postalAddress"), TuplesKt.to(AutofillType.PostalCode, "postalCode"), TuplesKt.to(AutofillType.CreditCardNumber, "creditCardNumber"), TuplesKt.to(AutofillType.CreditCardSecurityCode, "creditCardSecurityCode"), TuplesKt.to(AutofillType.CreditCardExpirationDate, "creditCardExpirationDate"), TuplesKt.to(AutofillType.CreditCardExpirationMonth, "creditCardExpirationMonth"), TuplesKt.to(AutofillType.CreditCardExpirationYear, "creditCardExpirationYear"), TuplesKt.to(AutofillType.CreditCardExpirationDay, "creditCardExpirationDay"), TuplesKt.to(AutofillType.AddressCountry, "addressCountry"), TuplesKt.to(AutofillType.AddressRegion, "addressRegion"), TuplesKt.to(AutofillType.AddressLocality, "addressLocality"), TuplesKt.to(AutofillType.AddressStreet, "streetAddress"), TuplesKt.to(AutofillType.AddressAuxiliaryDetails, "extendedAddress"), TuplesKt.to(AutofillType.PostalCodeExtended, "extendedPostalCode"), TuplesKt.to(AutofillType.PersonFullName, "personName"), TuplesKt.to(AutofillType.PersonFirstName, "personGivenName"), TuplesKt.to(AutofillType.PersonLastName, "personFamilyName"), TuplesKt.to(AutofillType.PersonMiddleName, "personMiddleName"), TuplesKt.to(AutofillType.PersonMiddleInitial, "personMiddleInitial"), TuplesKt.to(AutofillType.PersonNamePrefix, "personNamePrefix"), TuplesKt.to(AutofillType.PersonNameSuffix, "personNameSuffix"), TuplesKt.to(AutofillType.PhoneNumber, "phoneNumber"), TuplesKt.to(AutofillType.PhoneNumberDevice, "phoneNumberDevice"), TuplesKt.to(AutofillType.PhoneCountryCode, "phoneCountryCode"), TuplesKt.to(AutofillType.PhoneNumberNational, "phoneNational"), TuplesKt.to(AutofillType.Gender, "gender"), TuplesKt.to(AutofillType.BirthDateFull, "birthDateFull"), TuplesKt.to(AutofillType.BirthDateDay, "birthDateDay"), TuplesKt.to(AutofillType.BirthDateMonth, "birthDateMonth"), TuplesKt.to(AutofillType.BirthDateYear, "birthDateYear"), TuplesKt.to(AutofillType.SmsOtpCode, "smsOTPCode"));
    }

    private static void getAndroidAutofillTypes$annotations() {
    }

    public static final String getAndroidType(androidx.compose.ui.autofill.AutofillType $this$androidType) {
        Object obj = AndroidAutofillType_androidKt.androidAutofillTypes.get($this$androidType);
        if ((String)obj == null) {
        } else {
            return (String)obj;
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullAndroidAutofillType_androidKt$androidType$1 = new IllegalArgumentException("Unsupported autofill type".toString());
        throw $i$a$RequireNotNullAndroidAutofillType_androidKt$androidType$1;
    }

    public static void getAndroidType$annotations(androidx.compose.ui.autofill.AutofillType autofillType) {
    }
}
