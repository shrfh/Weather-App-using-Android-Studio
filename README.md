# Weather App using Android Studio
Created with Video Reference: https://www.youtube.com/watch?v=gj0g1a75Lmo

A Mobile Weather Application created in Android Studio using Java language programming; This application allows user to view real-time weather of a country they want. This is a simple and user-friendly application that consist the temperature, pressure, humidity of the country made for users to check the weather.

# Sample Layout
![image](https://user-images.githubusercontent.com/100700085/198860622-299bece5-ba4c-4911-813d-f3815a1c3c49.png)

This is the layout of the application. Here you can enter your country name.


![image](https://user-images.githubusercontent.com/100700085/198860669-f7134d47-7c53-494b-8d77-bcf02b30da86.png)

Here is the result after you enter a country. 


So let's get started on how to build our weather application! 

# Application Layout (XML Layout)

The first step in creating our application, we need to develop our layout. So what is a layout? Layout is basically how our application will looks like. 

Below is the code for layout:

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:background="@drawable/wallpaper4"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        android:layout_weight="1"
        android:gravity="center"
        android:text="Weather Update"
        android:textColor="#F1EFEF"
        android:textSize="40sp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:gravity="center"
        android:orientation="vertical">

        <EditText
            android:id="@+id/etCity"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="10dp"
            android:ems="10"
            android:hint="Enter City Name"
            android:inputType="textPersonName"
            android:textColor="#FFFFFF"
            android:textColorHint="#A19F9F" />

        <EditText
            android:id="@+id/etCountryCode"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="10dp"
            android:ems="10"
            android:hint="Enter Country Code(Optional)"
            android:inputType="textPersonName"
            android:textColorHint="#A19F9F" />

        <Button
            android:id="@+id/btnGet"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="10dp"
            android:background="#0070c7"
            android:onClick="getWeatherDetails"
            android:text="Get"
            android:textColor="#FFFFFF"
            app:backgroundTint="@null" />

        <TextView
            android:id="@+id/weatherRslt"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp" />

        <LinearLayout
            android:id="@+id/detailsContainer"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:orientation="vertical">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:weightSum="3">

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/temp"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Temperature"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/temperature"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>

                <Space
                    android:layout_width="10dp"
                    android:layout_height="wrap_content" />

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/humid"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Humidity"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/Humidity"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>

                <Space
                    android:layout_width="10dp"
                    android:layout_height="wrap_content" />

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/weather"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Description"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/Description"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>
            </LinearLayout>

            <Space
                android:layout_width="wrap_content"
                android:layout_height="10dp" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:weightSum="3">

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/wind"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Wind"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/Wind"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>

                <Space
                    android:layout_width="10dp"
                    android:layout_height="wrap_content" />

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/cloud"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Cloud"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/Cloud"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>

                <Space
                    android:layout_width="10dp"
                    android:layout_height="wrap_content" />

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="#3CF1EBF1"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">

                    <ImageView
                        android:layout_width="25dp"
                        android:layout_height="25dp"
                        android:src="@drawable/pressure"
                        android:tint="#FFFFFF" />

                    <Space
                        android:layout_width="wrap_content"
                        android:layout_height="5dp" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Pressure"
                        android:textSize="12dp"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/Pressure"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="14dp"
                        android:textStyle="bold" />
                </LinearLayout>
            </LinearLayout>
        </LinearLayout>


        <ProgressBar
            android:id="@+id/loader"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:visibility="gone" />

        <TextView
            android:id="@+id/errorText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="Something went wrong"
            android:visibility="gone" />


    </LinearLayout>
</LinearLayout>

```







