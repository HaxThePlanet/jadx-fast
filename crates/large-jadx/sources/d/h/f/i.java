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

/* loaded from: classes.dex */
public class i extends d.h.f.j {
    @Override // d.h.f.j
    public Typeface b(Context context, c.b c$b2, Resources resources3, int i4) {
        int i2;
        int i3;
        int i5;
        Font build;
        int i;
        FontFamily.Builder builder;
        int i6;
        boolean z;
        int obj11;
        int obj9 = 0;
        c.c[] obj10 = b2.a();
        i2 = 0;
        i5 = obj9;
        i3 = i2;
        try {
            while (i3 < obj10.length) {
                c.c cVar = obj10[i3];
                Font.Builder builder2 = new Font.Builder(resources3, cVar.b());
                if (cVar.f()) {
                } else {
                }
                i = i2;
                build = builder2.setWeight(cVar.e()).setSlant(i).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
                if (i5 == 0) {
                } else {
                }
                i5.addFont(build);
                i3++;
                builder = new FontFamily.Builder(build);
                i5 = builder;
            }
            cVar = obj10[i3];
            builder2 = new Font.Builder(resources3, cVar.b());
            if (cVar.f()) {
            } else {
            }
            i = i2;
            build = builder2.setWeight(cVar.e()).setSlant(i).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
            if (i5 == 0) {
            } else {
            }
            builder = new FontFamily.Builder(build);
            i5 = builder;
            i5.addFont(build);
            i3++;
            if (i5 == 0) {
            }
            return obj9;
            if (i4 & 1 != 0) {
            } else {
            }
            obj11 = 700;
            obj11 = 400;
        } catch (java.io.IOException ioException) {
        } catch (Exception e1) {
        }
        try {
            if (i4 &= 2 != 0) {
            }
            i2 = i;
            obj10 = new FontStyle(obj11, i2);
            obj11 = new Typeface.CustomFallbackBuilder(i5.build());
            return obj11.setStyle(obj10).build();
        }
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        int i2;
        int i;
        int i3;
        Throwable build;
        Throwable builder;
        ParcelFileDescriptor fileDescriptor;
        String weight;
        boolean z;
        int obj12;
        final int i5 = 0;
        i2 = 0;
        i3 = i5;
        i = i2;
        while (i < b3Arr3.length) {
            builder = b3Arr3[i];
            fileDescriptor = context.getContentResolver().openFileDescriptor(builder.d(), "r", cancellationSignal2);
            if (fileDescriptor == null) {
            } else {
            }
            Font.Builder builder2 = new Font.Builder(fileDescriptor);
            if (builder.f()) {
            } else {
            }
            build = i2;
            build = builder2.setWeight(builder.e()).setSlant(build).setTtcIndex(builder.c()).build();
            if (i3 == 0) {
            } else {
            }
            i3.addFont(build);
            if (fileDescriptor != null) {
            }
            i++;
            fileDescriptor.close();
            builder = new FontFamily.Builder(build);
            i3 = builder;
            if (fileDescriptor != null) {
            }
        }
        if (i3 == 0) {
            return i5;
        }
        obj12 = i4 & 1 != 0 ? 700 : 400;
        if (i4 & 2 != 0) {
            i2 = build;
        }
        FontStyle obj11 = new FontStyle(obj12, i2);
        obj12 = new Typeface.CustomFallbackBuilder(i3.build());
        return obj12.setStyle(obj11).build();
    }

    @Override // d.h.f.j
    protected Typeface d(Context context, InputStream inputStream2) {
        RuntimeException obj1 = new RuntimeException("Do not use this function in API 29 or later.");
        throw obj1;
    }

    @Override // d.h.f.j
    public Typeface e(Context context, Resources resources2, int i3, String string4, int i5) {
        try {
            Font.Builder obj1 = new Font.Builder(resources2, i3);
            obj1 = obj1.build();
            FontFamily.Builder obj2 = new FontFamily.Builder(obj1);
            Typeface.CustomFallbackBuilder obj3 = new Typeface.CustomFallbackBuilder(obj2.build());
            return obj3.setStyle(obj1.getStyle()).build();
            context = 0;
            return context;
        }
    }

    @Override // d.h.f.j
    protected f.b h(f.b[] f$bArr, int i2) {
        RuntimeException obj1 = new RuntimeException("Do not use this function in API 29 or later.");
        throw obj1;
    }
}
