# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Applications/Android Studio.app/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keepattributes SourceFile,LineNumberTable

#Annotations

-dontwarn javax.lang.model.**
-dontwarn javax.annotation.**
-dontwarn javax.annotation.processing.**
-dontwarn javax.tools.**

#Butterknife

-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}

#AbstractViewAdapter
-keep class **$$AdapterInjector { *; }
-keepnames class * { @co.infinum.ava.InjectList *;}

#Retrofit

#https://github.com/square/retrofit/issues/372

-keep class com.google.gson.** { *; }
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class org.apache.james.mime4j.** { *; }
-keep class javax.inject.** { *; }
-keep class retrofit.** { *; }
-keep class okio.** { *; }
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn rx.**

# Ignore warnings: https://github.com/square/okio/issues/60
-dontwarn okio.**

# Ignore warnings: https://github.com/square/retrofit/issues/435
-dontwarn com.google.appengine.api.urlfetch.**

#Dagger

-dontwarn dagger.internal.codegen.**
-keepclassmembers,allowobfuscation class * {
        @javax.inject.* *;
        @dagger.* *;
        <init>();
    }
-keep class dagger.* { *; }
-keep class javax.inject.* { *; }
-keep class * extends dagger.internal.Binding
-keep class * extends dagger.internal.ModuleAdapter
-keep class * extends dagger.internal.StaticInjection

#GSON

# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# Gson specific classes
-keep class sun.misc.Unsafe { *; }

#Support library

-keep class android.support.v4.internal.** { *; }
-keep interface android.support.v4.internal.** { *; }

-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }

-keep class android.support.v7.widget.SearchView { *; }

# Google Play services

-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @ccom.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}


