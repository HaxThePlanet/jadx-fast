package zendesk.support;

import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
class EmailValidator {
    boolean isValidEmail(String string) {
        return Patterns.EMAIL_ADDRESS.matcher(string).matches();
    }
}
