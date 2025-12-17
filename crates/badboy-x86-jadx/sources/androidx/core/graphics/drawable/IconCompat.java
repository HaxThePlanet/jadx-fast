package androidx.core.graphics.drawable;

import _COROUTINE.ArtificialStackFrames;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager;
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
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public class IconCompat extends CustomVersionedParcelable {

    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public byte[] mData = null;
    public int mInt1 = 0;
    public int mInt2 = 0;
    Object mObj1;
    public Parcelable mParcelable = null;
    public String mString1;
    public ColorStateList mTintList = null;
    PorterDuff.Mode mTintMode = null;
    public String mTintModeStr = null;
    public int mType = -1;

    static class Api23Impl {
        static androidx.core.graphics.drawable.IconCompat createFromIcon(Context context, Icon icon) {
            switch (type) {
                case 2:
                    String resPackage2 = IconCompat.Api23Impl.getResPackage(icon);
                    return IconCompat.createWithResource(IconCompat.getResources(context, resPackage2), resPackage2, IconCompat.Api23Impl.getResId(icon));
                case 3:
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.mObj1 = icon;
                    return iconCompat;
                case 4:
                    return IconCompat.createWithContentUri(IconCompat.Api23Impl.getUri(icon));
                default:
                    return IconCompat.createWithAdaptiveBitmapContentUri(IconCompat.Api23Impl.getUri(icon));
            }
        }

        static androidx.core.graphics.drawable.IconCompat createFromIconInner(Object icon) {
            Preconditions.checkNotNull(icon);
            switch (type) {
                case 2:
                    return IconCompat.createWithResource(0, IconCompat.Api23Impl.getResPackage(icon), IconCompat.Api23Impl.getResId(icon));
                case 3:
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.mObj1 = icon;
                    return iconCompat;
                case 4:
                    return IconCompat.createWithContentUri(IconCompat.Api23Impl.getUri(icon));
                default:
                    return IconCompat.createWithAdaptiveBitmapContentUri(IconCompat.Api23Impl.getUri(icon));
            }
        }

        static int getResId(Object icon) {
            return IconCompat.Api28Impl.getResId(icon);
        }

        static String getResPackage(Object icon) {
            return IconCompat.Api28Impl.getResPackage(icon);
        }

        static int getType(Object icon) {
            return IconCompat.Api28Impl.getType(icon);
        }

        static Uri getUri(Object icon) {
            return IconCompat.Api28Impl.getUri(icon);
        }

        static Drawable loadDrawable(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon toIcon(androidx.core.graphics.drawable.IconCompat iconCompat, Context context) {
            Icon is;
            int withAdaptiveBitmap;
            ColorStateList mTintList;
            PorterDuff.Mode mTintMode;
            int mInt2;
            switch (mType) {
                case -1:
                    return (Icon)iconCompat.mObj1;
                case 0:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown type");
                    throw illegalArgumentException;
                case 1:
                    is = Icon.createWithBitmap((Bitmap)iconCompat.mObj1);
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
                case 2:
                    is = Icon.createWithResource(iconCompat.getResPackage(), iconCompat.mInt1);
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
                case 3:
                    is = Icon.createWithData((byte[])iconCompat.mObj1, iconCompat.mInt1, iconCompat.mInt2);
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
                case 4:
                    is = Icon.createWithContentUri((String)iconCompat.mObj1);
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
                case 5:
                    is = IconCompat.Api26Impl.createWithAdaptiveBitmap((Bitmap)iconCompat.mObj1);
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
                default:
                    is = IconCompat.Api30Impl.createWithAdaptiveBitmapContentUri(iconCompat.getUri());
                    InputStream uriInputStream = iconCompat.getUriInputStream(context);
                    is = withAdaptiveBitmap;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    IllegalStateException icon5 = new IllegalStateException(stringBuilder2.append("Cannot load adaptive icon from uri: ").append(iconCompat.getUri()).toString());
                    throw icon5;
                    is.setTintList(iconCompat.mTintList);
                    is.setTintMode(iconCompat.mTintMode);
                    return is;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException is2 = new IllegalArgumentException(stringBuilder.append("Context is required to resolve the file uri of the icon: ").append(iconCompat.getUri()).toString());
            throw is2;
        }
    }

    static class Api26Impl {
        static Drawable createAdaptiveIconDrawable(Drawable backgroundDrawable, Drawable foregroundDrawable) {
            AdaptiveIconDrawable adaptiveIconDrawable = new AdaptiveIconDrawable(backgroundDrawable, foregroundDrawable);
            return adaptiveIconDrawable;
        }

        static Icon createWithAdaptiveBitmap(Bitmap bits) {
            return Icon.createWithAdaptiveBitmap(bits);
        }
    }

    static class Api28Impl {
        static int getResId(Object icon) {
            return (Icon)icon.getResId();
        }

        static String getResPackage(Object icon) {
            return (Icon)icon.getResPackage();
        }

        static int getType(Object icon) {
            return (Icon)icon.getType();
        }

        static Uri getUri(Object icon) {
            return (Icon)icon.getUri();
        }
    }

    static class Api30Impl {
        static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }
    static {
        IconCompat.DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public IconCompat() {
        super();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        PorterDuff.Mode dEFAULT_TINT_MODE = IconCompat.DEFAULT_TINT_MODE;
    }

    IconCompat(int mType) {
        super();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        PorterDuff.Mode dEFAULT_TINT_MODE = IconCompat.DEFAULT_TINT_MODE;
        this.mType = mType;
    }

    public static androidx.core.graphics.drawable.IconCompat createFromBundle(Bundle bundle) {
        Object parcelable;
        Object valueOf;
        Object byteArray;
        int int = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(int);
        iconCompat.mInt1 = bundle.getInt("int1");
        iconCompat.mInt2 = bundle.getInt("int2");
        iconCompat.mString1 = bundle.getString("string1");
        parcelable = "tint_list";
        if (bundle.containsKey(parcelable)) {
            iconCompat.mTintList = (ColorStateList)bundle.getParcelable(parcelable);
        }
        valueOf = "tint_mode";
        if (bundle.containsKey(valueOf)) {
            iconCompat.mTintMode = PorterDuff.Mode.valueOf(bundle.getString(valueOf));
        }
        String str5 = "obj";
        switch (int) {
            case -1:
                iconCompat.mObj1 = bundle.getParcelable(str5);
                break;
            case 0:
                StringBuilder stringBuilder = new StringBuilder();
                Log.w("IconCompat", stringBuilder.append("Unknown type ").append(int).toString());
                return null;
            case 1:
                iconCompat.mObj1 = bundle.getString(str5);
                break;
            default:
                iconCompat.mObj1 = bundle.getByteArray(str5);
        }
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createFromIcon(Context context, Icon icon) {
        Preconditions.checkNotNull(icon);
        return IconCompat.Api23Impl.createFromIcon(context, icon);
    }

    public static androidx.core.graphics.drawable.IconCompat createFromIcon(Icon icon) {
        return IconCompat.Api23Impl.createFromIconInner(icon);
    }

    public static androidx.core.graphics.drawable.IconCompat createFromIconOrNullIfZeroResId(Icon icon) {
        int resId;
        if (IconCompat.Api23Impl.getType(icon) == 2 && IconCompat.Api23Impl.getResId(icon) == 0) {
            if (IconCompat.Api23Impl.getResId(icon) == 0) {
                return null;
            }
        }
        return IconCompat.Api23Impl.createFromIconInner(icon);
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap adaptiveIconBitmap, boolean addShadow) {
        int i;
        int i2;
        int i4;
        int i3;
        int i7 = (int)i6;
        Bitmap bitmap = Bitmap.createBitmap(i7, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(3);
        f2 *= i11;
        i12 *= i10;
        if (addShadow) {
            f3 *= i15;
            paint.setColor(0);
            i3 = 0;
            paint.setShadowLayer(i2, i3, f5 *= i17, 1023410176);
            canvas.drawCircle(i10, i10, i13, paint);
            paint.setShadowLayer(i2, i3, i3, 503316480);
            canvas.drawCircle(i10, i10, i13, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(adaptiveIconBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        int i23 = 1073741824;
        matrix.setTranslate(f4 /= i23, f6 /= i23);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(i10, i10, i13, paint);
        canvas.setBitmap(0);
        return bitmap;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmap(Bitmap bits) {
        ObjectsCompat.requireNonNull(bits);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.mObj1 = bits;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmapContentUri(Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return IconCompat.createWithAdaptiveBitmapContentUri(uri.toString());
    }

    public static androidx.core.graphics.drawable.IconCompat createWithAdaptiveBitmapContentUri(String uri) {
        ObjectsCompat.requireNonNull(uri);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.mObj1 = uri;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithBitmap(Bitmap bits) {
        ObjectsCompat.requireNonNull(bits);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.mObj1 = bits;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithContentUri(Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return IconCompat.createWithContentUri(uri.toString());
    }

    public static androidx.core.graphics.drawable.IconCompat createWithContentUri(String uri) {
        ObjectsCompat.requireNonNull(uri);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.mObj1 = uri;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithData(byte[] data, int offset, int length) {
        ObjectsCompat.requireNonNull(data);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.mObj1 = data;
        iconCompat.mInt1 = offset;
        iconCompat.mInt2 = length;
        return iconCompat;
    }

    public static androidx.core.graphics.drawable.IconCompat createWithResource(Context context, int resId) {
        ObjectsCompat.requireNonNull(context);
        return IconCompat.createWithResource(context.getResources(), context.getPackageName(), resId);
    }

    public static androidx.core.graphics.drawable.IconCompat createWithResource(Resources r, String pkg, int resId) {
        int resourceName;
        ObjectsCompat.requireNonNull(pkg);
        if (resId == 0) {
        } else {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.mInt1 = resId;
            if (r != null) {
                iconCompat.mObj1 = r.getResourceName(resId);
            } else {
                iconCompat.mObj1 = pkg;
            }
            iconCompat.mString1 = pkg;
            return iconCompat;
        }
        IllegalArgumentException rep = new IllegalArgumentException("Drawable resource ID must not be 0");
        throw rep;
    }

    static Resources getResources(Context context, String resPackage) {
        if ("android".equals(resPackage)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resPackage, 8192);
        if (applicationInfo != null) {
            return packageManager.getResourcesForApplication(applicationInfo);
        }
        return null;
    }

    private Drawable loadDrawableInner(Context context) {
        InputStream uriInputStream;
        String resPackage;
        Throwable th;
        int format;
        Object str;
        int i3 = 0;
        switch (uriInputStream) {
            case 1:
                BitmapDrawable resPackage2 = new BitmapDrawable(context.getResources(), (Bitmap)this.mObj1);
                return resPackage2;
            case 2:
                resPackage = context.getPackageName();
                return ResourcesCompat.getDrawable(IconCompat.getResources(context, resPackage), this.mInt1, context.getTheme());
            case 3:
                BitmapDrawable is = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[])this.mObj1, this.mInt1, this.mInt2));
                return is;
            case 4:
                uriInputStream = getUriInputStream(context);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                return bitmapDrawable;
            case 5:
                BitmapDrawable is2 = new BitmapDrawable(context.getResources(), IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
                return is2;
            case 6:
                uriInputStream = getUriInputStream(context);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                return IconCompat.Api26Impl.createAdaptiveIconDrawable(i3, bitmapDrawable2);
            default:
        }
        return i3;
    }

    private static String typeToString(int x) {
        switch (x) {
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
    public void addToShortcutIntent(Intent outIntent, Drawable badge, Context c) {
        Object context;
        Canvas canvas;
        Object drawable;
        int intrinsicHeight2;
        Bitmap size;
        int intrinsicHeight;
        int width;
        Bitmap.Config height;
        checkResource(c);
        canvas = 1;
        switch (mType) {
            case 1:
                context = this.mObj1;
                context = context.copy((Bitmap)context.getConfig(), canvas);
                break;
            case 2:
                int i = 0;
                Context packageContext = c.createPackageContext(getResPackage(), i);
                outIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(packageContext, this.mInt1));
                drawable = ContextCompat.getDrawable(packageContext, this.mInt1);
                size = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                int launcherLargeIconSize = (ActivityManager)packageContext.getSystemService("activity").getLauncherLargeIconSize();
                size = intrinsicHeight;
                drawable.setBounds(i, i, size.getWidth(), size.getHeight());
                canvas = new Canvas(size);
                drawable.draw(canvas);
                context = size;
                break;
            case 3:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Icon type not supported for intent shortcuts");
                throw illegalArgumentException;
            default:
                context = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, canvas);
        }
        if (badge != null) {
            canvas = context.getWidth();
            drawable = context.getHeight();
            badge.setBounds(canvas / 2, drawable / 2, canvas, drawable);
            size = new Canvas(context);
            badge.draw(size);
        }
        outIntent.putExtra("android.intent.extra.shortcut.ICON", context);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void checkResource(Context context) {
        int mType;
        int i;
        String resPackage;
        String resName;
        String str3;
        Resources resources;
        String str2;
        int identifier;
        int string;
        String str;
        mType = this.mObj1;
        String str4 = ":";
        if (this.mType == 2 && this.mObj1 != null && !(String)mType.contains(str4)) {
            if (this.mObj1 != null) {
                mType = this.mObj1;
                str4 = ":";
                if (!(String)mType.contains(str4)) {
                }
                int i2 = -1;
                int i3 = 1;
                String str7 = mType.split(str4, i2)[i3];
                String str8 = "/";
                int i4 = 0;
                resName = str7.split(str8, i2)[i3];
                str3 = "IconCompat";
                if ("0_resource_name_obfuscated".equals(resName)) {
                    Log.i(str3, "Found obfuscated resource, not trying to update resource id for it");
                }
                resPackage = getResPackage();
                identifier = IconCompat.getResources(context, resPackage).getIdentifier(resName, str7.split(str8, i2)[i4], mType.split(str4, i2)[i4]);
                if (this.mInt1 != identifier) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Log.i(str3, stringBuilder.append("Id has changed for ").append(resPackage).append(" ").append(mType).toString());
                    this.mInt1 = identifier;
                }
            }
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Bitmap getBitmap() {
        if (this.mType == -1 && mObj1 instanceof Bitmap != null) {
            if (mObj1 instanceof Bitmap != null) {
                return (Bitmap)this.mObj1;
            }
            return null;
        }
        int i3 = 1;
        if (this.mType == i3) {
            return (Bitmap)this.mObj1;
        }
        if (this.mType != 5) {
        } else {
            return IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, i3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("called getBitmap() on ").append(this).toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public int getResId() {
        if (this.mType == -1) {
            return IconCompat.Api23Impl.getResId(this.mObj1);
        }
        if (this.mType != 2) {
        } else {
            return this.mInt1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("called getResId() on ").append(this).toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public String getResPackage() {
        String empty;
        int i = -1;
        if (this.mType == i) {
            return IconCompat.Api23Impl.getResPackage(this.mObj1);
        }
        if (this.mType != 2) {
        } else {
            if (this.mString1 != null && TextUtils.isEmpty(this.mString1)) {
                if (TextUtils.isEmpty(this.mString1)) {
                }
                return this.mString1;
            }
            return (String)this.mObj1.split(":", i)[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("called getResPackage() on ").append(this).toString());
        throw illegalStateException;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public int getType() {
        if (this.mType == -1) {
            return IconCompat.Api23Impl.getType(this.mObj1);
        }
        return this.mType;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Uri getUri() {
        int mType;
        int i;
        if (this.mType == -1) {
            return IconCompat.Api23Impl.getUri(this.mObj1);
        }
        if (this.mType != 4) {
            if (this.mType != 6) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("called getUri() on ").append(this).toString());
            throw illegalStateException;
        }
        return Uri.parse((String)this.mObj1);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public InputStream getUriInputStream(Context context) {
        Throwable th;
        boolean equals;
        StringBuilder string;
        String str;
        final Uri uri = getUri();
        final String scheme = uri.getScheme();
        final String str4 = "IconCompat";
        if (!"content".equals(scheme) && "file".equals(scheme) != null) {
            if ("file".equals(scheme) != null) {
            }
            File file = new File((String)this.mObj1);
            FileInputStream fileInputStream = new FileInputStream(file);
            return fileInputStream;
        }
        return context.getContentResolver().openInputStream(uri);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Drawable loadDrawable(Context context) {
        checkResource(context);
        return IconCompat.Api23Impl.loadDrawable(toIcon(context), context);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        int mParcelable;
        int str;
        Charset forName;
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        int i2 = 0;
        switch (mParcelable) {
            case -1:
                this.mObj1 = this.mParcelable;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid icon");
                throw illegalArgumentException;
            case 0:
                break;
            case 1:
                this.mObj1 = this.mParcelable;
                this.mObj1 = this.mData;
                this.mType = 3;
                this.mInt1 = i2;
                this.mInt2 = mData2.length;
                break;
            case 2:
                String string = new String(this.mData, Charset.forName("UTF-16"));
                this.mObj1 = string;
                this.mString1 = (String)this.mObj1.split(":", -1)[i2];
                break;
            default:
                this.mObj1 = this.mData;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean isStream) {
        Object mType;
        Object byteArrayOutputStream;
        byte[] byteArray;
        int i;
        this.mTintModeStr = this.mTintMode.name();
        byteArrayOutputStream = "UTF-16";
        switch (mType) {
            case -1:
                this.mParcelable = (Parcelable)this.mObj1;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                throw illegalArgumentException;
            case 0:
                break;
            case 1:
                byteArrayOutputStream = new ByteArrayOutputStream();
                (Bitmap)this.mObj1.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.mData = byteArrayOutputStream.toByteArray();
                this.mParcelable = (Parcelable)this.mObj1;
                break;
            case 2:
                this.mData = (String)this.mObj1.getBytes(Charset.forName(byteArrayOutputStream));
                break;
            case 3:
                this.mData = (byte[])this.mObj1;
                break;
            default:
                this.mData = this.mObj1.toString().getBytes(Charset.forName(byteArrayOutputStream));
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public androidx.core.graphics.drawable.IconCompat setTint(int tint) {
        return setTintList(ColorStateList.valueOf(tint));
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public androidx.core.graphics.drawable.IconCompat setTintList(ColorStateList tintList) {
        this.mTintList = tintList;
        return this;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public androidx.core.graphics.drawable.IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Bundle toBundle() {
        Object mObj1;
        Object mTintList;
        Object mTintMode;
        Object mTintList2;
        Object dEFAULT_TINT_MODE;
        Bundle bundle2 = new Bundle();
        String str5 = "obj";
        switch (mType) {
            case -1:
                bundle2.putParcelable(str5, (Parcelable)this.mObj1);
                break;
            case 0:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid icon");
                throw illegalArgumentException;
            case 1:
                bundle2.putParcelable(str5, (Bitmap)this.mObj1);
                break;
            case 2:
                bundle2.putString(str5, (String)this.mObj1);
                break;
            default:
                bundle2.putByteArray(str5, (byte[])this.mObj1);
        }
        bundle2.putInt("type", this.mType);
        bundle2.putInt("int1", this.mInt1);
        bundle2.putInt("int2", this.mInt2);
        bundle2.putString("string1", this.mString1);
        if (this.mTintList != null) {
            bundle2.putParcelable("tint_list", this.mTintList);
        }
        if (this.mTintMode != IconCompat.DEFAULT_TINT_MODE) {
            bundle2.putString("tint_mode", this.mTintMode.name());
        }
        return bundle2;
    }

    @Deprecated
    public Icon toIcon() {
        return toIcon(0);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public Icon toIcon(Context context) {
        return IconCompat.Api23Impl.toIcon(this, context);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public String toString() {
        StringBuilder mType;
        ColorStateList mTintList;
        Object mTintMode;
        String format;
        PorterDuff.Mode dEFAULT_TINT_MODE;
        String str;
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
        StringBuilder append = stringBuilder.append(IconCompat.typeToString(this.mType));
        switch (mType) {
            case 1:
                append.append(" size=").append((Bitmap)this.mObj1.getWidth()).append("x").append((Bitmap)this.mObj1.getHeight());
                break;
            case 2:
                append.append(" pkg=").append(this.mString1).append(" id=").append(String.format("0x%08x", /* result */));
                break;
            case 3:
                append.append(" len=").append(this.mInt1);
                append.append(" off=").append(this.mInt2);
                break;
            case 4:
                append.append(" uri=").append(this.mObj1);
                break;
            default:
        }
        if (this.mTintList != null) {
            append.append(" tint=");
            append.append(this.mTintList);
        }
        if (this.mTintMode != IconCompat.DEFAULT_TINT_MODE) {
            append.append(" mode=").append(this.mTintMode);
        }
        append.append(")");
        return append.toString();
    }
}
