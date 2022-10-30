# Weather App using Android Studio (WIP Documentation)
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

I will briefly explains the important features in our application:

```

    
        <TextView
            android:id="@+id/weatherRslt"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp" />

       
```

TextView is used to show the texts that we have created.

```
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

```

Button feature is for clicking

```
<Linear Layout>

   </Linear Layout>
```

For this application we will use LinearLayout







