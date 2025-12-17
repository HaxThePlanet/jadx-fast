package androidx.compose.ui.autofill;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import androidx.compose.material.ModalBottomSheetState.anchoredDraggableState.2;
import androidx.compose.material.icons.filled.ExitToAppKt;
import androidx.compose.material.ripple.AndroidRippleIndicationInstance;
import androidx.compose.ui.unit.DpKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0006\u0008\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0008\u0002\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0002\u0008\nR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/compose/ui/autofill/ContentType;", "", "contentHint", "", "(Ljava/lang/String;)V", "contentHints", "", "(Ljava/util/Set;)V", "plus", "other", "plus$ui_release", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentType {

    public static final int $stable = 8;
    private static final androidx.compose.ui.autofill.ContentType AddressAuxiliaryDetails;
    private static final androidx.compose.ui.autofill.ContentType AddressCountry;
    private static final androidx.compose.ui.autofill.ContentType AddressLocality;
    private static final androidx.compose.ui.autofill.ContentType AddressRegion;
    private static final androidx.compose.ui.autofill.ContentType AddressStreet;
    private static final androidx.compose.ui.autofill.ContentType BirthDateDay;
    private static final androidx.compose.ui.autofill.ContentType BirthDateFull;
    private static final androidx.compose.ui.autofill.ContentType BirthDateMonth;
    private static final androidx.compose.ui.autofill.ContentType BirthDateYear;
    public static final androidx.compose.ui.autofill.ContentType.Companion Companion;
    private static final androidx.compose.ui.autofill.ContentType CreditCardExpirationDate;
    private static final androidx.compose.ui.autofill.ContentType CreditCardExpirationDay;
    private static final androidx.compose.ui.autofill.ContentType CreditCardExpirationMonth;
    private static final androidx.compose.ui.autofill.ContentType CreditCardExpirationYear;
    private static final androidx.compose.ui.autofill.ContentType CreditCardNumber;
    private static final androidx.compose.ui.autofill.ContentType CreditCardSecurityCode;
    private static final androidx.compose.ui.autofill.ContentType EmailAddress;
    private static final androidx.compose.ui.autofill.ContentType Gender;
    private static final androidx.compose.ui.autofill.ContentType NewPassword;
    private static final androidx.compose.ui.autofill.ContentType NewUsername;
    private static final androidx.compose.ui.autofill.ContentType Password;
    private static final androidx.compose.ui.autofill.ContentType PersonFirstName;
    private static final androidx.compose.ui.autofill.ContentType PersonFullName;
    private static final androidx.compose.ui.autofill.ContentType PersonLastName;
    private static final androidx.compose.ui.autofill.ContentType PersonMiddleInitial;
    private static final androidx.compose.ui.autofill.ContentType PersonMiddleName;
    private static final androidx.compose.ui.autofill.ContentType PersonNamePrefix;
    private static final androidx.compose.ui.autofill.ContentType PersonNameSuffix;
    private static final androidx.compose.ui.autofill.ContentType PhoneCountryCode;
    private static final androidx.compose.ui.autofill.ContentType PhoneNumber;
    private static final androidx.compose.ui.autofill.ContentType PhoneNumberDevice;
    private static final androidx.compose.ui.autofill.ContentType PhoneNumberNational;
    private static final androidx.compose.ui.autofill.ContentType PostalAddress;
    private static final androidx.compose.ui.autofill.ContentType PostalCode;
    private static final androidx.compose.ui.autofill.ContentType PostalCodeExtended;
    private static final androidx.compose.ui.autofill.ContentType SmsOtpCode;
    private static final androidx.compose.ui.autofill.ContentType Username;
    private final Set<String> contentHints;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008J\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020OH\u0000¢\u0006\u0002\u0008PR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u0006R\u0011\u00101\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010\u0006R\u0011\u00103\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\u0006R\u0011\u00105\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010\u0006R\u0011\u0010C\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010\u0006R\u0011\u0010E\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010\u0006R\u0011\u0010G\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010\u0006R\u0011\u0010I\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010\u0006R\u0011\u0010K\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010\u0006¨\u0006Q", d2 = {"Landroidx/compose/ui/autofill/ContentType$Companion;", "", "()V", "AddressAuxiliaryDetails", "Landroidx/compose/ui/autofill/ContentType;", "getAddressAuxiliaryDetails", "()Landroidx/compose/ui/autofill/ContentType;", "AddressCountry", "getAddressCountry", "AddressLocality", "getAddressLocality", "AddressRegion", "getAddressRegion", "AddressStreet", "getAddressStreet", "BirthDateDay", "getBirthDateDay", "BirthDateFull", "getBirthDateFull", "BirthDateMonth", "getBirthDateMonth", "BirthDateYear", "getBirthDateYear", "CreditCardExpirationDate", "getCreditCardExpirationDate", "CreditCardExpirationDay", "getCreditCardExpirationDay", "CreditCardExpirationMonth", "getCreditCardExpirationMonth", "CreditCardExpirationYear", "getCreditCardExpirationYear", "CreditCardNumber", "getCreditCardNumber", "CreditCardSecurityCode", "getCreditCardSecurityCode", "EmailAddress", "getEmailAddress", "Gender", "getGender", "NewPassword", "getNewPassword", "NewUsername", "getNewUsername", "Password", "getPassword", "PersonFirstName", "getPersonFirstName", "PersonFullName", "getPersonFullName", "PersonLastName", "getPersonLastName", "PersonMiddleInitial", "getPersonMiddleInitial", "PersonMiddleName", "getPersonMiddleName", "PersonNamePrefix", "getPersonNamePrefix", "PersonNameSuffix", "getPersonNameSuffix", "PhoneCountryCode", "getPhoneCountryCode", "PhoneNumber", "getPhoneNumber", "PhoneNumberDevice", "getPhoneNumberDevice", "PhoneNumberNational", "getPhoneNumberNational", "PostalAddress", "getPostalAddress", "PostalCode", "getPostalCode", "PostalCodeExtended", "getPostalCodeExtended", "SmsOtpCode", "getSmsOtpCode", "Username", "getUsername", "from", "value", "", "from$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.autofill.ContentType from$ui_release(String value) {
            androidx.compose.ui.autofill.ContentType addressAuxiliaryDetails;
            int equals;
            switch (value) {
                case "creditCardExpirationMonth":
                    addressAuxiliaryDetails = getCreditCardExpirationMonth();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "newPassword":
                    addressAuxiliaryDetails = getNewPassword();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "creditCardSecurityCode":
                    addressAuxiliaryDetails = getCreditCardSecurityCode();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "creditCardExpirationDay":
                    addressAuxiliaryDetails = getCreditCardExpirationDay();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personMiddleInitial":
                    addressAuxiliaryDetails = getPersonMiddleInitial();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "phoneCountryCode":
                    addressAuxiliaryDetails = getPhoneCountryCode();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "gender":
                    addressAuxiliaryDetails = getGender();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "phoneNumber":
                    addressAuxiliaryDetails = getPhoneNumber();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "creditCardNumber":
                    addressAuxiliaryDetails = getCreditCardNumber();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "emailAddress":
                    addressAuxiliaryDetails = getEmailAddress();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "addressRegion":
                    addressAuxiliaryDetails = getAddressRegion();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personFamilyName":
                    addressAuxiliaryDetails = getPersonLastName();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "birthDateMonth":
                    addressAuxiliaryDetails = getBirthDateMonth();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "creditCardExpirationDate":
                    addressAuxiliaryDetails = getCreditCardExpirationDate();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "creditCardExpirationYear":
                    addressAuxiliaryDetails = getCreditCardExpirationYear();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "birthDateDay":
                    addressAuxiliaryDetails = getBirthDateDay();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "username":
                    addressAuxiliaryDetails = getUsername();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "phoneNational":
                    addressAuxiliaryDetails = getPhoneNumberNational();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "streetAddress":
                    addressAuxiliaryDetails = getAddressStreet();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "extendedAddress":
                    addressAuxiliaryDetails = getAddressAuxiliaryDetails();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "birthDateFull":
                    addressAuxiliaryDetails = getBirthDateFull();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "birthDateYear":
                    addressAuxiliaryDetails = getBirthDateYear();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personName":
                    addressAuxiliaryDetails = getPersonFullName();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "phoneNumberDevice":
                    addressAuxiliaryDetails = getPhoneNumberDevice();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "newUsername":
                    addressAuxiliaryDetails = getNewUsername();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "password":
                    addressAuxiliaryDetails = getPassword();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "addressCountry":
                    addressAuxiliaryDetails = getAddressCountry();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "extendedPostalCode":
                    addressAuxiliaryDetails = getPostalCodeExtended();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "postalAddress":
                    addressAuxiliaryDetails = getPostalAddress();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "addressLocality":
                    addressAuxiliaryDetails = getAddressLocality();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personGivenName":
                    addressAuxiliaryDetails = getPersonFirstName();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "smsOTPCode":
                    addressAuxiliaryDetails = getSmsOtpCode();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personNamePrefix":
                    addressAuxiliaryDetails = getPersonNamePrefix();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personMiddleName":
                    addressAuxiliaryDetails = getPersonMiddleName();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "personNameSuffix":
                    addressAuxiliaryDetails = getPersonNameSuffix();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                case "postalCode":
                    addressAuxiliaryDetails = getPostalCode();
                    addressAuxiliaryDetails = new ContentType(value);
                    break;
                default:
                    addressAuxiliaryDetails = new ContentType(value);
            }
            return addressAuxiliaryDetails;
        }

        public final androidx.compose.ui.autofill.ContentType getAddressAuxiliaryDetails() {
            return ContentType.access$getAddressAuxiliaryDetails$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getAddressCountry() {
            return ContentType.access$getAddressCountry$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getAddressLocality() {
            return ContentType.access$getAddressLocality$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getAddressRegion() {
            return ContentType.access$getAddressRegion$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getAddressStreet() {
            return ContentType.access$getAddressStreet$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getBirthDateDay() {
            return ContentType.access$getBirthDateDay$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getBirthDateFull() {
            return ContentType.access$getBirthDateFull$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getBirthDateMonth() {
            return ContentType.access$getBirthDateMonth$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getBirthDateYear() {
            return ContentType.access$getBirthDateYear$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardExpirationDate() {
            return ContentType.access$getCreditCardExpirationDate$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardExpirationDay() {
            return ContentType.access$getCreditCardExpirationDay$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardExpirationMonth() {
            return ContentType.access$getCreditCardExpirationMonth$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardExpirationYear() {
            return ContentType.access$getCreditCardExpirationYear$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardNumber() {
            return ContentType.access$getCreditCardNumber$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getCreditCardSecurityCode() {
            return ContentType.access$getCreditCardSecurityCode$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getEmailAddress() {
            return ContentType.access$getEmailAddress$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getGender() {
            return ContentType.access$getGender$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getNewPassword() {
            return ContentType.access$getNewPassword$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getNewUsername() {
            return ContentType.access$getNewUsername$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPassword() {
            return ContentType.access$getPassword$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonFirstName() {
            return ContentType.access$getPersonFirstName$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonFullName() {
            return ContentType.access$getPersonFullName$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonLastName() {
            return ContentType.access$getPersonLastName$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonMiddleInitial() {
            return ContentType.access$getPersonMiddleInitial$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonMiddleName() {
            return ContentType.access$getPersonMiddleName$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonNamePrefix() {
            return ContentType.access$getPersonNamePrefix$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPersonNameSuffix() {
            return ContentType.access$getPersonNameSuffix$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPhoneCountryCode() {
            return ContentType.access$getPhoneCountryCode$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPhoneNumber() {
            return ContentType.access$getPhoneNumber$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPhoneNumberDevice() {
            return ContentType.access$getPhoneNumberDevice$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPhoneNumberNational() {
            return ContentType.access$getPhoneNumberNational$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPostalAddress() {
            return ContentType.access$getPostalAddress$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPostalCode() {
            return ContentType.access$getPostalCode$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getPostalCodeExtended() {
            return ContentType.access$getPostalCodeExtended$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getSmsOtpCode() {
            return ContentType.access$getSmsOtpCode$cp();
        }

        public final androidx.compose.ui.autofill.ContentType getUsername() {
            return ContentType.access$getUsername$cp();
        }
    }
    static {
        ContentType.Companion companion = new ContentType.Companion(0);
        ContentType.Companion = companion;
        int i = 8;
        ContentType contentType = new ContentType("username");
        ContentType.Username = contentType;
        ContentType contentType2 = new ContentType("password");
        ContentType.Password = contentType2;
        ContentType contentType3 = new ContentType("emailAddress");
        ContentType.EmailAddress = contentType3;
        ContentType contentType4 = new ContentType("newUsername");
        ContentType.NewUsername = contentType4;
        ContentType contentType5 = new ContentType("newPassword");
        ContentType.NewPassword = contentType5;
        ContentType contentType6 = new ContentType("postalAddress");
        ContentType.PostalAddress = contentType6;
        ContentType contentType7 = new ContentType("postalCode");
        ContentType.PostalCode = contentType7;
        ContentType contentType8 = new ContentType("creditCardNumber");
        ContentType.CreditCardNumber = contentType8;
        ContentType contentType9 = new ContentType("creditCardSecurityCode");
        ContentType.CreditCardSecurityCode = contentType9;
        ContentType contentType10 = new ContentType("creditCardExpirationDate");
        ContentType.CreditCardExpirationDate = contentType10;
        ContentType contentType11 = new ContentType("creditCardExpirationMonth");
        ContentType.CreditCardExpirationMonth = contentType11;
        ContentType contentType12 = new ContentType("creditCardExpirationYear");
        ContentType.CreditCardExpirationYear = contentType12;
        ContentType contentType13 = new ContentType("creditCardExpirationDay");
        ContentType.CreditCardExpirationDay = contentType13;
        ContentType contentType14 = new ContentType("addressCountry");
        ContentType.AddressCountry = contentType14;
        ContentType contentType15 = new ContentType("addressRegion");
        ContentType.AddressRegion = contentType15;
        ContentType contentType16 = new ContentType("addressLocality");
        ContentType.AddressLocality = contentType16;
        ContentType contentType17 = new ContentType("streetAddress");
        ContentType.AddressStreet = contentType17;
        ContentType contentType18 = new ContentType("extendedAddress");
        ContentType.AddressAuxiliaryDetails = contentType18;
        ContentType contentType19 = new ContentType("extendedPostalCode");
        ContentType.PostalCodeExtended = contentType19;
        ContentType contentType20 = new ContentType("personName");
        ContentType.PersonFullName = contentType20;
        ContentType contentType21 = new ContentType("personGivenName");
        ContentType.PersonFirstName = contentType21;
        ContentType contentType22 = new ContentType("personFamilyName");
        ContentType.PersonLastName = contentType22;
        ContentType contentType23 = new ContentType("personMiddleName");
        ContentType.PersonMiddleName = contentType23;
        ContentType contentType24 = new ContentType("personMiddleInitial");
        ContentType.PersonMiddleInitial = contentType24;
        ContentType contentType25 = new ContentType("personNamePrefix");
        ContentType.PersonNamePrefix = contentType25;
        ContentType contentType26 = new ContentType("personNameSuffix");
        ContentType.PersonNameSuffix = contentType26;
        ContentType contentType27 = new ContentType("phoneNumber");
        ContentType.PhoneNumber = contentType27;
        ContentType contentType28 = new ContentType("phoneNumberDevice");
        ContentType.PhoneNumberDevice = contentType28;
        ContentType contentType29 = new ContentType("phoneCountryCode");
        ContentType.PhoneCountryCode = contentType29;
        ContentType contentType30 = new ContentType("phoneNational");
        ContentType.PhoneNumberNational = contentType30;
        ContentType contentType31 = new ContentType("gender");
        ContentType.Gender = contentType31;
        ContentType contentType32 = new ContentType("birthDateFull");
        ContentType.BirthDateFull = contentType32;
        ContentType contentType33 = new ContentType("birthDateDay");
        ContentType.BirthDateDay = contentType33;
        ContentType contentType34 = new ContentType("birthDateMonth");
        ContentType.BirthDateMonth = contentType34;
        ContentType contentType35 = new ContentType("birthDateYear");
        ContentType.BirthDateYear = contentType35;
        ContentType contentType36 = new ContentType("smsOTPCode");
        ContentType.SmsOtpCode = contentType36;
    }

    public ContentType(String contentHint) {
        super(SetsKt.setOf(contentHint));
    }

    private ContentType(Set<String> contentHints) {
        super();
        this.contentHints = contentHints;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getAddressAuxiliaryDetails$cp() {
        return ContentType.AddressAuxiliaryDetails;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getAddressCountry$cp() {
        return ContentType.AddressCountry;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getAddressLocality$cp() {
        return ContentType.AddressLocality;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getAddressRegion$cp() {
        return ContentType.AddressRegion;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getAddressStreet$cp() {
        return ContentType.AddressStreet;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getBirthDateDay$cp() {
        return ContentType.BirthDateDay;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getBirthDateFull$cp() {
        return ContentType.BirthDateFull;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getBirthDateMonth$cp() {
        return ContentType.BirthDateMonth;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getBirthDateYear$cp() {
        return ContentType.BirthDateYear;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardExpirationDate$cp() {
        return ContentType.CreditCardExpirationDate;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardExpirationDay$cp() {
        return ContentType.CreditCardExpirationDay;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardExpirationMonth$cp() {
        return ContentType.CreditCardExpirationMonth;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardExpirationYear$cp() {
        return ContentType.CreditCardExpirationYear;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardNumber$cp() {
        return ContentType.CreditCardNumber;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getCreditCardSecurityCode$cp() {
        return ContentType.CreditCardSecurityCode;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getEmailAddress$cp() {
        return ContentType.EmailAddress;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getGender$cp() {
        return ContentType.Gender;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getNewPassword$cp() {
        return ContentType.NewPassword;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getNewUsername$cp() {
        return ContentType.NewUsername;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPassword$cp() {
        return ContentType.Password;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonFirstName$cp() {
        return ContentType.PersonFirstName;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonFullName$cp() {
        return ContentType.PersonFullName;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonLastName$cp() {
        return ContentType.PersonLastName;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonMiddleInitial$cp() {
        return ContentType.PersonMiddleInitial;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonMiddleName$cp() {
        return ContentType.PersonMiddleName;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonNamePrefix$cp() {
        return ContentType.PersonNamePrefix;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPersonNameSuffix$cp() {
        return ContentType.PersonNameSuffix;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPhoneCountryCode$cp() {
        return ContentType.PhoneCountryCode;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPhoneNumber$cp() {
        return ContentType.PhoneNumber;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPhoneNumberDevice$cp() {
        return ContentType.PhoneNumberDevice;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPhoneNumberNational$cp() {
        return ContentType.PhoneNumberNational;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPostalAddress$cp() {
        return ContentType.PostalAddress;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPostalCode$cp() {
        return ContentType.PostalCode;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getPostalCodeExtended$cp() {
        return ContentType.PostalCodeExtended;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getSmsOtpCode$cp() {
        return ContentType.SmsOtpCode;
    }

    public static final androidx.compose.ui.autofill.ContentType access$getUsername$cp() {
        return ContentType.Username;
    }

    public final androidx.compose.ui.autofill.ContentType plus$ui_release(androidx.compose.ui.autofill.ContentType other) {
        ContentType contentType = new ContentType(SetsKt.plus(this.contentHints, (Iterable)other.contentHints));
        return contentType;
    }
}
