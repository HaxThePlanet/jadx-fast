package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class GrammaticalInflectionManagerCompat {

    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED;

    static class Api34Impl {
        static int getApplicationGrammaticalGender(Context context) {
            return GrammaticalInflectionManagerCompat.Api34Impl.getGrammaticalInflectionManager(context).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager getGrammaticalInflectionManager(Context context) {
            return (GrammaticalInflectionManager)context.getSystemService(GrammaticalInflectionManager.class);
        }

        static void setRequestedApplicationGrammaticalGender(Context context, int grammaticalGender) {
            GrammaticalInflectionManagerCompat.Api34Impl.getGrammaticalInflectionManager(context).setRequestedApplicationGrammaticalGender(grammaticalGender);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }
    public static int getApplicationGrammaticalGender(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return GrammaticalInflectionManagerCompat.Api34Impl.getApplicationGrammaticalGender(context);
        }
        return 0;
    }

    public static void setRequestedApplicationGrammaticalGender(Context context, int grammaticalGender) {
        if (Build.VERSION.SDK_INT >= 34) {
            GrammaticalInflectionManagerCompat.Api34Impl.setRequestedApplicationGrammaticalGender(context, grammaticalGender);
        }
    }
}
