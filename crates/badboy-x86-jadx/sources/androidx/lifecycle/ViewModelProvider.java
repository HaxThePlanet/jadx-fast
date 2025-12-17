package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import androidx.lifecycle.viewmodel.CreationExtras.Key;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0016\u0018\u0000 !2\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005B#\u0008\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\u0008\u0004\u0010\u000cB\u0011\u0008\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\u0008\u0004\u0010\u000fB\u0019\u0008\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\u0004\u0010\u0010J&\u0010\u0011\u001a\u0002H\u0012\"\u0008\u0008\u0000\u0010\u0012*\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u0016J&\u0010\u0011\u001a\u0002H\u0012\"\u0008\u0008\u0000\u0010\u0012*\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018J.\u0010\u0011\u001a\u0002H\u0012\"\u0008\u0008\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u001bJ.\u0010\u0011\u001a\u0002H\u0012\"\u0008\u0008\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "impl", "Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;", "<init>", "(Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;)V", "store", "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Factory", "OnRequeryFactory", "NewInstanceFactory", "AndroidViewModelFactory", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ViewModelProvider {

    public static final androidx.lifecycle.ViewModelProvider.Companion Companion;
    public static final CreationExtras.Key<String> VIEW_MODEL_KEY;
    private final ViewModelProviderImpl impl;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "<init>", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class OnRequeryFactory {
        public void onRequery(androidx.lifecycle.ViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u0000 \r2\u00020\u0001:\u0001\rJ%\u0010\u0002\u001a\u0002H\u0003\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J-\u0010\u0002\u001a\u0002H\u0003\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ-\u0010\u0002\u001a\u0002H\u0003\"\u0008\u0008\u0000\u0010\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000cø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory {

        public static final androidx.lifecycle.ViewModelProvider.Factory.Companion Companion;
        static {
            ViewModelProvider.Factory.Companion = ViewModelProvider.Factory.Companion.$$INSTANCE;
        }

        @JvmStatic
        public static androidx.lifecycle.ViewModelProvider.Factory from(ViewModelInitializer<?>... initializers) {
            return ViewModelProvider.Factory.Companion.from(initializers);
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel_release();
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(modelClass);
        }

        public <T extends androidx.lifecycle.ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(JvmClassMappingKt.getJavaClass(modelClass), extras);
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\u0008\u0008\u0000\u0010\u0005*\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0008H\u0016¢\u0006\u0002\u0010\tJ-\u0010\u0004\u001a\u0002H\u0005\"\u0008\u0008\u0000\u0010\u0005*\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000cJ-\u0010\u0004\u001a\u0002H\u0005\"\u0008\u0008\u0000\u0010\u0005*\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010", d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class NewInstanceFactory implements androidx.lifecycle.ViewModelProvider.Factory {

        public static final androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion Companion;
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY;
        private static androidx.lifecycle.ViewModelProvider.NewInstanceFactory _instance;
        static {
            ViewModelProvider.NewInstanceFactory.Companion companion = new ViewModelProvider.NewInstanceFactory.Companion(0);
            ViewModelProvider.NewInstanceFactory.Companion = companion;
            ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY = ViewModelProvider.VIEW_MODEL_KEY;
        }

        public static final androidx.lifecycle.ViewModelProvider.NewInstanceFactory access$get_instance$cp() {
            return ViewModelProvider.NewInstanceFactory._instance;
        }

        public static final void access$set_instance$cp(androidx.lifecycle.ViewModelProvider.NewInstanceFactory <set-?>) {
            ViewModelProvider.NewInstanceFactory._instance = <set-?>;
        }

        public static final androidx.lifecycle.ViewModelProvider.NewInstanceFactory getInstance() {
            return ViewModelProvider.NewInstanceFactory.Companion.getInstance();
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return JvmViewModelProviders.INSTANCE.createViewModel(modelClass);
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(modelClass);
        }

        public <T extends androidx.lifecycle.ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(JvmClassMappingKt.getJavaClass(modelClass), extras);
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007B\t\u0008\u0016¢\u0006\u0004\u0008\u0006\u0010\u0008B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\tJ-\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J%\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u0012J-\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "application", "Landroid/app/Application;", "unused", "", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AndroidViewModelFactory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {

        public static final CreationExtras.Key<Application> APPLICATION_KEY;
        public static final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion Companion;
        private static androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory _instance;
        private final Application application;
        static {
            ViewModelProvider.AndroidViewModelFactory.Companion companion = new ViewModelProvider.AndroidViewModelFactory.Companion(0);
            ViewModelProvider.AndroidViewModelFactory.Companion = companion;
            androidx.lifecycle.viewmodel.CreationExtras.Companion companion2 = CreationExtras.Companion;
            int i2 = 0;
            ViewModelProvider.AndroidViewModelFactory.special$$inlined.Key.1 anon = new ViewModelProvider.AndroidViewModelFactory.special$$inlined.Key.1();
            ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY = (CreationExtras.Key)anon;
        }

        public AndroidViewModelFactory() {
            super(0, 0);
        }

        public AndroidViewModelFactory(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            super(application, 0);
        }

        private AndroidViewModelFactory(Application application, int unused) {
            super();
            this.application = application;
        }

        public static final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory access$get_instance$cp() {
            return ViewModelProvider.AndroidViewModelFactory._instance;
        }

        public static final void access$set_instance$cp(androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory <set-?>) {
            ViewModelProvider.AndroidViewModelFactory._instance = <set-?>;
        }

        private final <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass, Application app) {
            Object instance;
            Object[] runtimeException;
            int sb;
            final String str = "Cannot create an instance of ";
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                Class[] arr = new Class[1];
                Intrinsics.checkNotNull((ViewModel)modelClass.getConstructor(Application.class).newInstance(/* result */));
            } else {
                instance = super.create(modelClass);
            }
            return instance;
        }

        @JvmStatic
        public static final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory getInstance(Application application) {
            return ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application);
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (this.application == null) {
            } else {
                return create(modelClass, this.application);
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            throw unsupportedOperationException;
        }

        public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            androidx.lifecycle.ViewModel application;
            androidx.lifecycle.ViewModel create;
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (this.application != null) {
                application = create(modelClass);
                return application;
            } else {
                Object obj = extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
                if ((Application)obj != null) {
                    application = create;
                } else {
                    if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                    } else {
                        application = create;
                    }
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            throw illegalArgumentException;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/lifecycle/ViewModelProvider$Companion;", "", "<init>", "()V", "create", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "store", "Landroidx/lifecycle/ViewModelStore;", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static androidx.lifecycle.ViewModelProvider create$default(androidx.lifecycle.ViewModelProvider.Companion viewModelProvider$Companion, androidx.lifecycle.ViewModelStore viewModelStore2, androidx.lifecycle.ViewModelProvider.Factory viewModelProvider$Factory3, CreationExtras creationExtras4, int i5, Object object6) {
            DefaultViewModelProviderFactory obj2;
            CreationExtras.Empty obj3;
            if (i5 & 2 != 0) {
                obj2 = DefaultViewModelProviderFactory.INSTANCE;
            }
            if (i5 &= 4 != 0) {
                obj3 = CreationExtras.Empty.INSTANCE;
            }
            return companion.create(viewModelStore2, obj2, obj3);
        }

        public static androidx.lifecycle.ViewModelProvider create$default(androidx.lifecycle.ViewModelProvider.Companion viewModelProvider$Companion, androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner2, androidx.lifecycle.ViewModelProvider.Factory viewModelProvider$Factory3, CreationExtras creationExtras4, int i5, Object object6) {
            androidx.lifecycle.ViewModelProvider.Factory obj2;
            CreationExtras obj3;
            if (i5 & 2 != 0) {
                obj2 = ViewModelProviders.INSTANCE.getDefaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner2);
            }
            if (i5 &= 4 != 0) {
                obj3 = ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel_release(viewModelStoreOwner2);
            }
            return companion.create(viewModelStoreOwner2, obj2, obj3);
        }

        @JvmStatic
        public final androidx.lifecycle.ViewModelProvider create(androidx.lifecycle.ViewModelStore store, androidx.lifecycle.ViewModelProvider.Factory factory, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(store, "store");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            ViewModelProvider viewModelProvider = new ViewModelProvider(store, factory, extras);
            return viewModelProvider;
        }

        @JvmStatic
        public final androidx.lifecycle.ViewModelProvider create(androidx.lifecycle.ViewModelStoreOwner owner, androidx.lifecycle.ViewModelProvider.Factory factory, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            ViewModelProvider viewModelProvider = new ViewModelProvider(owner.getViewModelStore(), factory, extras);
            return viewModelProvider;
        }
    }
    static {
        ViewModelProvider.Companion companion = new ViewModelProvider.Companion(0);
        ViewModelProvider.Companion = companion;
        androidx.lifecycle.viewmodel.CreationExtras.Companion companion2 = CreationExtras.Companion;
        int i2 = 0;
        ViewModelProvider.special$$inlined.Key.1 anon = new ViewModelProvider.special$$inlined.Key.1();
        ViewModelProvider.VIEW_MODEL_KEY = (CreationExtras.Key)anon;
    }

    public ViewModelProvider(androidx.lifecycle.ViewModelStore store, androidx.lifecycle.ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        super(store, factory, 0, 4, 0);
    }

    public ViewModelProvider(androidx.lifecycle.ViewModelStore store, androidx.lifecycle.ViewModelProvider.Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        ViewModelProviderImpl viewModelProviderImpl = new ViewModelProviderImpl(store, factory, defaultCreationExtras);
        super(viewModelProviderImpl);
    }

    public ViewModelProvider(androidx.lifecycle.ViewModelStore viewModelStore, androidx.lifecycle.ViewModelProvider.Factory viewModelProvider$Factory2, CreationExtras creationExtras3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        CreationExtras.Empty obj3;
        if (i4 &= 4 != 0) {
            obj3 = CreationExtras.Empty.INSTANCE;
        }
        super(viewModelStore, factory2, obj3);
    }

    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super(owner.getViewModelStore(), ViewModelProviders.INSTANCE.getDefaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel_release(owner));
    }

    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner owner, androidx.lifecycle.ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        super(owner.getViewModelStore(), factory, ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel_release(owner));
    }

    private ViewModelProvider(ViewModelProviderImpl impl) {
        super();
        this.impl = impl;
    }

    @JvmStatic
    public static final androidx.lifecycle.ViewModelProvider create(androidx.lifecycle.ViewModelStore store, androidx.lifecycle.ViewModelProvider.Factory factory, CreationExtras extras) {
        return ViewModelProvider.Companion.create(store, factory, extras);
    }

    @JvmStatic
    public static final androidx.lifecycle.ViewModelProvider create(androidx.lifecycle.ViewModelStoreOwner owner, androidx.lifecycle.ViewModelProvider.Factory factory, CreationExtras extras) {
        return ViewModelProvider.Companion.create(owner, factory, extras);
    }

    public <T extends androidx.lifecycle.ViewModel> T get(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return get(JvmClassMappingKt.getKotlinClass(modelClass));
    }

    public <T extends androidx.lifecycle.ViewModel> T get(String key, Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel_release(JvmClassMappingKt.getKotlinClass(modelClass), key);
    }

    public final <T extends androidx.lifecycle.ViewModel> T get(String key, KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel_release(modelClass, key);
    }

    public final <T extends androidx.lifecycle.ViewModel> T get(KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        final int i = 0;
        return ViewModelProviderImpl.getViewModel$lifecycle_viewmodel_release$default(this.impl, modelClass, i, 2, i);
    }
}
