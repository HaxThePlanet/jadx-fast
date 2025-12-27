package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.h.i.f.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public class i extends j {
    @Override // d.h.f.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        int context2;
        int i3 = 700;
        context2 = 0;
        try {
            c.c[] objArr = bVar.a();
            i = 0;
            i = 1;
            c.c cVar = objArr[i];
        } catch (java.io.IOException unused) {
            i = i + 1;
        } catch (Exception unused) {
            return customFallbackBuilder;
        }
        if (context2 == null) {
            return context2;
        }
        try {
            resources = i & 1 != 0 ? 700 : 400;
            if (i & 2 != 0) {
            }
            FontStyle fontStyle = new FontStyle(i3, i);
        } catch (java.io.IOException unused) {
            i = i + 1;
        } catch (Exception unused) {
            return new Typeface.CustomFallbackBuilder(context2.build()).setStyle(fontStyle).build();
        }
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        int i2 = 0;
        Throwable th;
        Object obj;
        String str;
        boolean z;
        int i3 = 700;
        i = 0;
        try {
            i2 = 0;
            i2 = 1;
            obj = bVarArr[i2];
        } catch (java.io.IOException unused) {
            i2 = i2 + 1;
        } catch (Exception unused) {
            return obj2;
        }
        if (i == 0) {
            return i;
        }
        try {
            cancellationSignal = i & 1 != 0 ? 700 : 400;
            if (i & 2 != 0) {
            }
            FontStyle fontStyle = new FontStyle(i3, i2);
        } catch (java.io.IOException unused) {
            i2 = i2 + 1;
        } catch (Exception unused) {
            return obj2;
        }
    }

    @Override // d.h.f.j
    protected Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // d.h.f.j
    public Typeface e(Context context, Resources resources, int i, String str, int i2) throws IOException {
        try {
            Font builder2 = new Font.Builder(resources, i).build();
        } catch (Exception unused) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(builder2).build()).setStyle(builder2.getStyle()).build();
    }

    @Override // d.h.f.j
    protected f.b h(f.b[] bVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
