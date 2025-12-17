package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.core.content.a;
import java.io.File;

/* loaded from: classes2.dex */
public class CropImageActivity extends d implements com.theartofdev.edmodo.cropper.CropImageView.i, com.theartofdev.edmodo.cropper.CropImageView.e {

    private com.theartofdev.edmodo.cropper.CropImageView a;
    private Uri b;
    private com.theartofdev.edmodo.cropper.f c;
    private void o(Menu menu, int i2, int i3) {
        PorterDuff.Mode sRC_ATOP;
        MenuItem obj2;
        int obj3;
        int obj4;
        obj2 = menu.findItem(i2);
        obj3 = obj2.getIcon();
        if (obj2 != null && obj3 != null) {
            obj3 = obj2.getIcon();
            if (obj3 != null) {
                obj3.mutate();
                obj3.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                obj2.setIcon(obj3);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void a(com.theartofdev.edmodo.cropper.CropImageView cropImageView, Uri uri2, Exception exception3) {
        int obj1;
        com.theartofdev.edmodo.cropper.CropImageView obj2;
        if (exception3 == null) {
            obj1 = obj1.e0;
            if (obj1 != null) {
                this.a.setCropRect(obj1);
            }
            obj1 = obj1.f0;
            if (obj1 > -1) {
                this.a.setRotatedDegrees(obj1);
            }
        } else {
            m(0, exception3, 1);
        }
    }

    @Override // androidx.appcompat.app.d
    public void b(com.theartofdev.edmodo.cropper.CropImageView cropImageView, com.theartofdev.edmodo.cropper.CropImageView.b cropImageView$b2) {
        m(b2.g(), b2.c(), b2.f());
    }

    @Override // androidx.appcompat.app.d
    protected void i() {
        int i2;
        int i;
        com.theartofdev.edmodo.cropper.CropImageView view2;
        Uri uri;
        Bitmap.CompressFormat compressFormat;
        int i5;
        int i4;
        int i3;
        com.theartofdev.edmodo.cropper.CropImageView.j view;
        if (fVar.d0) {
            i = 0;
            m(i, i, 1);
        } else {
            i2 = this.c;
            this.a.p(j(), i2.Y, i2.Z, i2.a0, i2.b0, i2.c0);
        }
    }

    @Override // androidx.appcompat.app.d
    protected Uri j() {
        String str;
        Uri file;
        boolean runtimeException;
        Bitmap.CompressFormat jPEG;
        File cacheDir;
        file = fVar.X;
        if (file != null) {
            if (file.equals(Uri.EMPTY) != null) {
                Bitmap.CompressFormat compressFormat = fVar2.Y;
                str = compressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : compressFormat == jPEG ? ".png" : ".webp";
                file = Uri.fromFile(File.createTempFile("cropped", str, getCacheDir()));
            }
        } else {
        }
        return file;
    }

    @Override // androidx.appcompat.app.d
    protected Intent k(Uri uri, Exception exception2, int i3) {
        super(this.a.getImageUri(), uri, exception2, this.a.getCropPoints(), this.a.getCropRect(), this.a.getRotatedDegrees(), this.a.getWholeImageRect(), i3);
        Intent obj11 = new Intent();
        obj11.putExtras(getIntent());
        obj11.putExtra("CROP_IMAGE_EXTRA_RESULT", cVar2);
        return obj11;
    }

    @Override // androidx.appcompat.app.d
    protected void l(int i) {
        this.a.o(i);
    }

    @Override // androidx.appcompat.app.d
    protected void m(Uri uri, Exception exception2, int i3) {
        int i;
        i = exception2 == null ? -1 : 204;
        setResult(i, k(uri, exception2, i3));
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void n() {
        setResult(0);
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        int obj2;
        int obj3;
        if (i == 200 && i2 == 0) {
            if (i2 == 0) {
                n();
            }
            if (i2 == -1) {
                obj2 = d.h(this, intent3);
                this.b = obj2;
                if (d.k(this, obj2)) {
                    requestPermissions(/* result */, 201);
                } else {
                    this.a.setImageUriAsync(this.b);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        super.onBackPressed();
        n();
    }

    @Override // androidx.appcompat.app.d
    public void onCreate(Bundle bundle) {
        Object parcelable;
        com.theartofdev.edmodo.cropper.f length;
        Object string;
        String str;
        Uri obj3;
        super.onCreate(bundle);
        setContentView(j.a);
        this.a = (CropImageView)findViewById(i.d);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.b = (Uri)bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.c = (f)bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            obj3 = this.b;
            if (obj3 != null) {
                if (obj3.equals(Uri.EMPTY)) {
                    if (d.j(this)) {
                        requestPermissions(/* result */, 2011);
                    } else {
                        d.m(this);
                    }
                } else {
                    if (d.k(this, this.b)) {
                        requestPermissions(/* result */, 201);
                    } else {
                        this.a.setImageUriAsync(this.b);
                    }
                }
            } else {
            }
        }
        obj3 = getSupportActionBar();
        if (obj3 != null) {
            length = this.c;
            length = length.V;
            if (length != null && length != null && length.length() > 0) {
                length = length.V;
                if (length != null) {
                    if (length.length() > 0) {
                        string = fVar.V;
                    } else {
                        string = getResources().getString(l.b);
                    }
                } else {
                }
            } else {
            }
            obj3.u(string);
            obj3.s(true);
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean item2;
        boolean z;
        Object item;
        int i2;
        boolean z2;
        int item3;
        int i;
        String str2;
        String str;
        getMenuInflater().inflate(k.a, menu);
        com.theartofdev.edmodo.cropper.f fVar = this.c;
        final int i9 = 1;
        if (!fVar.g0) {
            menu.removeItem(i.i);
            menu.removeItem(i.j);
        } else {
            if (fVar.i0) {
                menu.findItem(i.i).setVisible(i9);
            }
        }
        if (!fVar2.h0) {
            menu.removeItem(i.f);
        }
        if (fVar3.m0 != null) {
            menu.findItem(i.e).setTitle(fVar4.m0);
        }
        i2 = 0;
        item3 = fVar5.n0;
        if (item3 != null) {
            menu.findItem(i.e).setIcon(a.f(this, item3));
        }
        i = fVar6.W;
        o(menu, i.i, i);
        o(menu, i.j, fVar8.W);
        o(menu, i.f, fVar9.W);
        if (i != 0 && i2 != 0) {
            o(menu, i.i, i);
            o(menu, i.j, fVar8.W);
            o(menu, i.f, fVar9.W);
            if (i2 != 0) {
                o(menu, i.e, fVar7.W);
            }
        }
        return i9;
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        final int i7 = 1;
        if (menuItem.getItemId() == i.e) {
            i();
            return i7;
        }
        if (menuItem.getItemId() == i.i) {
            l(-obj4);
            return i7;
        }
        if (menuItem.getItemId() == i.j) {
            l(obj4.j0);
            return i7;
        }
        if (menuItem.getItemId() == i.g) {
            this.a.f();
            return i7;
        }
        if (menuItem.getItemId() == i.h) {
            this.a.g();
            return i7;
        }
        if (menuItem.getItemId() == 16908332) {
            n();
            return i7;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        int length;
        int obj3;
        com.theartofdev.edmodo.cropper.CropImageView obj4;
        if (i == 201) {
            obj3 = this.b;
            if (obj3 != null && i3Arr3.length > 0 && i3Arr3[0] == 0) {
                if (i3Arr3.length > 0) {
                    if (i3Arr3[0] == 0) {
                        this.a.setImageUriAsync(obj3);
                    } else {
                        Toast.makeText(this, l.a, 1).show();
                        n();
                    }
                } else {
                }
            } else {
            }
        }
        if (i == 2011) {
            d.m(this);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        super.onStart();
        this.a.setOnSetImageUriCompleteListener(this);
        this.a.setOnCropImageCompleteListener(this);
    }

    @Override // androidx.appcompat.app.d
    protected void onStop() {
        super.onStop();
        final int i = 0;
        this.a.setOnSetImageUriCompleteListener(i);
        this.a.setOnCropImageCompleteListener(i);
    }
}
