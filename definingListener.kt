package com.example.shoppingingredients

//
//
//Exercise: Practice defining listeners in Android
//Overview
//Previously you discovered the concept of lambda expressions and explored how listeners can be defined using lambda expressions. In this exercise, you will practice using lambda expressions and defining listeners in Android.
//
//Scenario
//Let’s say that for the Little Lemon restaurant’s Android app, you need to implement a functionality so that when clicking a button, a customer’s details are saved on the device.
//
//These details might include their name, age, address and other items.
//
//Definition of key topic
//Listeners are often used to asynchronously communicate the occurrence of specific events. For instance, a button in Android can be assigned a click listener which executes code when the button is clicked. On button click, you will simulate the data being saved on the device. You will also learn various ways lambda expressions can be defined.
//
//Instructions
//To complete this exercise, you need to create a new Android Studio project with an Empty Activity template. Once you do that, you will have an activity with code similar to below:
//
//123456
//
//Replace the code in the activity_main.xml file with the code below:
//
//123456789101112131415161718
//<?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//android:layout_width="match_parent"
//android:layout_height="match_parent">
//
//<Button
//android:id="@+id/saveDataButton"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//
//This code includes some concepts you may not have encountered before but don’t worry, knowledge of them is not required for this exercise, and you will learn about them soon. The code above helps you define a button in your Android app’s UI with the id saveDataButton.
//
//Navigate back to the activity file MainActivity. Access and store your button reference in a variable as follows:
//
//1
//val saveDataButton = findViewById(R.id.saveDataButton)
//You will learn more about working with views later. For now, simply understand that this helps you store the button reference in a variable.
//
//Step 2: Defining click listener for the button
//You will then use the OnClickListener interface defined in Android’s View class. It has only one method:
//
//1
//abstract fun onClick(v: View): Unit
//Implementing the interface requires you to define the function body for the above onClick method. You need to assign the interface implementation using lambda expressions as the click listener for the saveDataButton.
//
//Step 3: Defining the body of the lambda expression
//For now, simply show a Toast message on the screen that the data is saved upon button click as:
//
//1

//Tip: Several ways of defining lambda expressions
//The most explicit form of writing a lambda expression includes defining the interface implementation instance at the site of being assigned. For example, for a button, a click listener can be defined as:
//
//1234
//button.setOnClickListener(OnClickListener() { view ->
//    println(view.id)
//})
//
//You can omit OnClickListener() as the setOnClickListener accepts only that type. Hence, it can be re-written as:
//
//123
//button.setOnClickListener({ view ->
//    println(view.id)
//})
//Since lambda expression is the last and only parameter for the function onClick of the OnClickListener, you can also omit the parenthesis and rewrite it as:
//
//123
//button.setOnClickListener { view ->
//    println(view.id)
//}
//In addition, you can skip the lambda parameter name, to use the implicit it:
//
//1234
//button.setOnClickListener {
//    println(it.id)
//}
//
//Conclusion
//You just practiced how to define a listener in Android and use lambda expressions while working with listeners. You also learned how to optimize lambda expressions for conciseness and readability. Listeners are widely used in programming to communicate event occurrences and in the future, you will work with many of them while developing your own applications.