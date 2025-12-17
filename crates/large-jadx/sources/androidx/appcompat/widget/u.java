package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import d.h.k.i;

/* loaded from: classes.dex */
final class u {

    private TextView a;
    private TextClassifier b;
    u(TextView textView) {
        super();
        i.c(textView);
        this.a = (TextView)textView;
    }

    public TextClassifier a() {
        TextClassifier nO_OP;
        Class<TextClassificationManager> obj;
        Object systemService = this.a.getContext().getSystemService(TextClassificationManager.class);
        if (this.b == null && (TextClassificationManager)systemService != null) {
            systemService = this.a.getContext().getSystemService(TextClassificationManager.class);
            if ((TextClassificationManager)(TextClassificationManager)systemService != null) {
                return (TextClassificationManager)(TextClassificationManager)systemService.getTextClassifier();
            }
            nO_OP = TextClassifier.NO_OP;
        }
        return nO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.b = textClassifier;
    }
}
