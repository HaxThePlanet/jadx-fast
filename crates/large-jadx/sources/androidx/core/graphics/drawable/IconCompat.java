package androidx.core.graphics.drawable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    static final PorterDuff.Mode k;
    public int a = -1;
    Object b;
    public byte[] c = null;
    public Parcelable d = null;
    public int e = 0;
    public int f = 0;
    public ColorStateList g = null;
    PorterDuff.Mode h = null;
    public String i = null;
    public String j;
    static {
        IconCompat.k = PorterDuff.Mode.SRC_IN;
    }

    public IconCompat() {
        super();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        PorterDuff.Mode mode = IconCompat.k;
    }

    private IconCompat(int i) {
        super();
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        PorterDuff.Mode mode = IconCompat.k;
        this.a = i;
    }

    static Bitmap a(Bitmap bitmap, boolean z2) {
        float f;
        int i2;
        int i;
        int obj10;
        int i5 = (int)i4;
        Bitmap bitmap2 = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint(3);
        f = (float)i5;
        i9 *= f;
        i11 *= i10;
        if (z2 != 0) {
            obj10 *= f;
            paint.setColor(0);
            i = 0;
            paint.setShadowLayer(obj10, i, f *= i17, 1023410176);
            canvas.drawCircle(i10, i10, i12, paint);
            paint.setShadowLayer(obj10, i, i, 503316480);
            canvas.drawCircle(i10, i10, i12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode cLAMP = Shader.TileMode.CLAMP;
        obj10 = new BitmapShader(bitmap, cLAMP, cLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)i15, (float)obj9);
        obj10.setLocalMatrix(matrix);
        paint.setShader(obj10);
        canvas.drawCircle(i10, i10, i12, paint);
        canvas.setBitmap(0);
        return bitmap2;
    }

    public static androidx.core.graphics.drawable.IconCompat b(Bitmap bitmap) {
        if (bitmap == null) {
        } else {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.b = bitmap;
            return iconCompat;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Bitmap must not be null.");
        throw obj2;
    }

    public static androidx.core.graphics.drawable.IconCompat c(Resources resources, String string2, int i3) {
        Object obj2;
        if (string2 == null) {
        } else {
            if (i3 == 0) {
            } else {
                IconCompat iconCompat = new IconCompat(2);
                iconCompat.e = i3;
                if (resources != null) {
                    iconCompat.b = resources.getResourceName(i3);
                } else {
                    iconCompat.b = string2;
                }
                iconCompat.j = string2;
                return iconCompat;
            }
            obj2 = new IllegalArgumentException("Drawable resource ID must not be 0");
            throw obj2;
        }
        obj2 = new IllegalArgumentException("Package must not be null.");
        throw obj2;
    }

    private static int f(Icon icon) {
        final String str = "Unable to get icon resource";
        final String str2 = "IconCompat";
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        int i = 0;
        return (Integer)icon.getClass().getMethod("getResId", new Class[i]).invoke(icon, new Object[i]).intValue();
    }

    private static String h(Icon icon) {
        final String str = "Unable to get icon package";
        final String str2 = "IconCompat";
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        int i = 0;
        final int i3 = 0;
        return (String)icon.getClass().getMethod("getResPackage", new Class[i3]).invoke(icon, new Object[i3]);
    }

    private static int j(Icon icon) {
        final String str = "Unable to get icon type ";
        final String str2 = "IconCompat";
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        int i = -1;
        final int i3 = 0;
        return (Integer)icon.getClass().getMethod("getType", new Class[i3]).invoke(icon, new Object[i3]).intValue();
    }

    private static Uri l(Icon icon) {
        final String str = "Unable to get icon uri";
        final String str2 = "IconCompat";
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        int i = 0;
        final int i3 = 0;
        return (Uri)icon.getClass().getMethod("getUri", new Class[i3]).invoke(icon, new Object[i3]);
    }

    private static String r(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Bitmap d() {
        int sDK_INT;
        int i;
        int i2 = this.a;
        Object obj3 = this.b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23 && obj3 instanceof Bitmap != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                obj3 = this.b;
                if (obj3 instanceof Bitmap != null) {
                    return (Bitmap)obj3;
                }
                return null;
            }
        }
        int i4 = 1;
        if (i2 == i4) {
            return (Bitmap)this.b;
        }
        if (i2 != 5) {
        } else {
            return IconCompat.a((Bitmap)this.b, i4);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getBitmap() on ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public int e() {
        int sDK_INT;
        int i;
        int i2 = this.a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                return IconCompat.f((Icon)this.b);
            }
        }
        if (i2 != 2) {
        } else {
            return this.e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResId() on ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public String g() {
        int sDK_INT;
        int i;
        int i2 = this.a;
        int i3 = -1;
        if (i2 == i3 && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                return IconCompat.h((Icon)this.b);
            }
        }
        if (i2 != 2) {
        } else {
            if (TextUtils.isEmpty(this.j)) {
                return (String)this.b.split(":", i3)[0];
            }
            return this.j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResPackage() on ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public int i() {
        int i2;
        int sDK_INT;
        int i;
        if (this.a == -1 && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                i2 = IconCompat.j((Icon)this.b);
            }
        }
        return i2;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Uri k() {
        int sDK_INT;
        int i;
        int i2;
        int i3 = this.a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 23) {
                return IconCompat.l((Icon)this.b);
            }
        }
        if (i3 != 4) {
            if (i3 != 6) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("called getUri() on ");
            stringBuilder.append(this);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        return Uri.parse((String)this.b);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public InputStream m(Context context) {
        StringBuilder stringBuilder;
        String scheme;
        String str;
        boolean equals;
        final Uri uri = k();
        scheme = uri.getScheme();
        final String str3 = "IconCompat";
        if (!"content".equals(scheme) && "file".equals(scheme) != null) {
            if ("file".equals(scheme) != null) {
            }
            File file = new File((String)this.b);
            FileInputStream obj5 = new FileInputStream(file);
            return obj5;
        }
        return context.getContentResolver().openInputStream(uri);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void n() {
        String string;
        int i;
        int str;
        this.h = PorterDuff.Mode.valueOf(this.i);
        int i2 = 0;
        switch (string) {
            case -1:
                string = this.d;
                this.b = string;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid icon");
                throw illegalArgumentException;
            case 0:
                break;
            case 1:
                string = this.d;
                this.b = string;
                byte[] bArr = this.c;
                this.b = bArr;
                this.a = 3;
                this.e = i2;
                this.f = bArr.length;
                break;
            case 2:
                string = new String(this.c, Charset.forName("UTF-16"));
                this.b = string;
                this.j = (String)string.split(":", -1)[i2];
                break;
            default:
                this.b = this.c;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void o(boolean z) {
        int byteArrayOutputStream;
        Object pNG;
        int i;
        Object obj4;
        this.i = this.h.name();
        pNG = "UTF-16";
        switch (byteArrayOutputStream) {
            case -1:
                this.d = (Parcelable)this.b;
                obj4 = new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                throw obj4;
            case 0:
                break;
            case 1:
                byteArrayOutputStream = new ByteArrayOutputStream();
                (Bitmap)this.b.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.c = byteArrayOutputStream.toByteArray();
                this.d = (Parcelable)this.b;
                break;
            case 2:
                this.c = (String)this.b.getBytes(Charset.forName(pNG));
                break;
            case 3:
                this.c = (byte[])this.b;
                break;
            default:
                this.c = this.b.toString().getBytes(Charset.forName(pNG));
        }
    }

    @Deprecated
    public Icon p() {
        return q(0);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Icon q(Context context) {
        int sDK_INT;
        int i2;
        int i;
        Icon obj5;
        i2 = 0;
        final int i4 = 26;
        switch (sDK_INT) {
            case -1:
                return (Icon)this.b;
            case 0:
                obj5 = new IllegalArgumentException("Unknown type");
                throw obj5;
            case 1:
                obj5 = Icon.createWithBitmap((Bitmap)this.b);
                ColorStateList list = this.g;
                obj5.setTintList(list);
                PorterDuff.Mode mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
            case 2:
                obj5 = Icon.createWithResource(g(), this.e);
                list = this.g;
                obj5.setTintList(list);
                mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
            case 3:
                obj5 = Icon.createWithData((byte[])this.b, this.e, this.f);
                list = this.g;
                obj5.setTintList(list);
                mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
            case 4:
                obj5 = Icon.createWithContentUri((String)this.b);
                list = this.g;
                obj5.setTintList(list);
                mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
            case 5:
                obj5 = Icon.createWithAdaptiveBitmap((Bitmap)this.b);
                obj5 = Icon.createWithBitmap(IconCompat.a((Bitmap)this.b, i2));
                list = this.g;
                obj5.setTintList(list);
                mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
            default:
                sDK_INT = Build.VERSION.SDK_INT;
                obj5 = Icon.createWithAdaptiveBitmapContentUri(k());
                obj5 = m(context);
                obj5 = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(obj5));
                obj5 = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(obj5), i2));
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Cannot load adaptive icon from uri: ");
                stringBuilder2.append(k());
                obj5 = new IllegalStateException(stringBuilder2.toString());
                throw obj5;
                list = this.g;
                obj5.setTintList(list);
                mode = this.h;
                obj5.setTintMode(mode);
                return obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Context is required to resolve the file uri of the icon: ");
        stringBuilder.append(k());
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public String toString() {
        int i;
        String format;
        ColorStateList list;
        PorterDuff.Mode mode;
        String str;
        Integer valueOf;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
        stringBuilder.append(IconCompat.r(this.a));
        switch (format) {
            case 1:
                stringBuilder.append(" size=");
                stringBuilder.append((Bitmap)this.b.getWidth());
                stringBuilder.append("x");
                stringBuilder.append((Bitmap)this.b.getHeight());
                break;
            case 2:
                stringBuilder.append(" pkg=");
                stringBuilder.append(this.j);
                stringBuilder.append(" id=");
                Object[] arr = new Object[1];
                stringBuilder.append(String.format("0x%08x", Integer.valueOf(e())));
                break;
            case 3:
                stringBuilder.append(" len=");
                stringBuilder.append(this.e);
                stringBuilder.append(" off=");
                stringBuilder.append(this.f);
                break;
            case 4:
                stringBuilder.append(" uri=");
                stringBuilder.append(this.b);
                break;
            default:
        }
        if (this.g != null) {
            stringBuilder.append(" tint=");
            stringBuilder.append(this.g);
        }
        if (this.h != IconCompat.k) {
            stringBuilder.append(" mode=");
            stringBuilder.append(this.h);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
