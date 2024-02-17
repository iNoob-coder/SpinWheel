# SpinWheel Library

![Spin Wheel](https://github.com/iNoob-coder/SpinWheel/assets/76174472/d057fbd5-cb9a-4447-996d-6eb400486b7e)

### Overview: The SpinWheel Library provides an easy-to-use solution for implementing a spinning wheel feature in your Android applications. It allows users to spin a wheel and receive a random reward based on predefined options.

## Features

- Spin duration in milliseconds
- Custom spin prize
- Override function onSpinStart()
- Override function onSpinComplete()
- receive a reward on complete of wheel spin

## Installation:-

>Step 1. Add the JitPack repository to your build file
#### Add the following lines to your project's build.gradle file:
```kotlin
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

>Step 2. Add the dependency
#### Add the SpinWheel dependency to your app's build.gradle file:
```kotlin
dependencies {
    implementation 'com.github.iNoob-coder:SpinWheel:1.0.0'
}
```

>Step 3. Add ImageView and Button to your layout XML
#### In your layout XML file, add an ImageView to display the spinning wheel and a Button to initiate the spinning action:
```
<ImageView
    android:id="@+id/spinWheel"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    <!-- Add any necessary attributes for the ImageView -->
    />

<Button
    android:id="@+id/btnSpin"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Spin"
    <!-- Add any necessary attributes for the Button -->
    />
```
You're now ready to integrate the SpinWheel Library into your Android application!

>Step 4: Define the Prize Array
#### Create an array representing the prizes or rewards associated with each segment of the spinning wheel. The size of this array should match the number of segments on your wheel.

```
private val prizeArray = arrayOf(5, 1, 8, 2, 10, 3, 5, 4, 10, 5, 2, 7)
```

>Step 5: Initialize SpinWheel on Button Click
#### In your activity's onCreate method, initialize the SpinWheel when the Spin button is clicked:

```
binding.btnSpin.setOnClickListener {
    SpinWheel().startSpinning(this, binding.spinWheel, prizeArray, 4000)
}
```

>Step 6: Implement SpinStatus Interface
#### Implement the SpinStatus interface in your activity to handle spin events such as start and completion. Override the onSpinStart and onSpinComplete methods as needed:

```
class MainActivity : AppCompatActivity(), SpinWheel.SpinStatus {

    // Other code...

    override fun onSpinStart() {
        // Perform any other actions needed when the spin starts
        binding.btnSpin.isEnabled = false
    }

    override fun onSpinComplete(prize: Int, spinBlockNumber: Int) {
        // Perform any other actions needed when the spin completes
        binding.btnSpin.isEnabled = true
        Toast.makeText(this, prize.toString(), Toast.LENGTH_SHORT).show() 
    }
}
```

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/inoobcoder/)

## Feedback

If you have any feedback, please reach out to me at inoobcoder@gmail.com
