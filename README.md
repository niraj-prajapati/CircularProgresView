# CircularProgresView [![](https://jitpack.io/v/niraj-prajapati/CircularProgresView.svg)](https://jitpack.io/#niraj-prajapati/CircularProgresView) ![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template)

It is customizable Circular ProgressView where you can customize progress and background colors, size and choose rounded corners if needed.

[![Watch the video](https://i.ibb.co/r4ckxKf/Screenshot-1.png)](https://youtu.be/6-0vl7dBCbU)

<h1>How to get?</h1>

<h3>Step 1.</h3>

Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

<h3>Step 2.</h3>

Add the dependency

```
dependencies {
    implementation 'com.github.niraj-prajapati:CircularProgresView:1.0.0'
}
```

<h1>How to use it?</h1>

<b>Note:</b> Do not set any parameters from XML.

```
<com.nirajprajapati.cpv.CircularProgressView
    android:id="@+id/circularProgressView"
    android:layout_width="200dp"
    android:layout_height="200dp" />
```

<h3>Set parameters programmatically</h3>

- To set progress value,

```
circularProgressView.setProgress(75F)
```

- To set progress corners rounded,

```
circularProgressView.setRounded(true)
```

- To set progress color,

```
circularProgressView.setProgressColor(COLOR)
```

- To set progress background color,

```
circularProgressView.setProgressBackgroundColor(COLOR)
```

- To set progress width,

```
circularProgressView.setProgressWidth(15F)
```

- To set progress background width,

```
circularProgressView.setBackgroundWidth(12F)
```
---
<h3>Your contributions are welcome.</h3>
