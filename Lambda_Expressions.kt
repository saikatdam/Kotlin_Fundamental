package com.example.shoppingingredients
//
//Overview
//Previously, you learned about the idea of functions as objects and Lambda expressions as an implementation of that concept. This functional programming tool is very powerful and will help you write code that’s more reusable and concise. With these advantages, however, come a few challenges. Knowing about these challenges will help you overcome them.
//
//Introduction
//You've learned about the strengths of Lambda expressions. Lambda expressions work some magic in the background, meaning that there are some subtle risks that are worth noting.
//
//One of the challenges when using Lambda expressions is the risk of introducing memory leaks. Another challenge is unit testing code that uses Lambda expressions.
//
//In this reading, you will learn about these challenges and how they can be avoided or overcome.
//
//Memory leaks
//Kotlin in Android runs on the Java Virtual Machine (JVM). The JVM utilizes a mechanism called garbage collection (GC) to make sure the app memory usage doesn’t exceed the device's capabilities. A simplified explanation of GC is that when free memory runs low, it looks for objects and deletes them from memory. Loose objects are objects that are not referenced by the running code anymore.
//
//Memory leaks happen when we keep a reference to an object we no longer need. This kind of reference prevents the GC from doing its job. Let’s see how a Lambda expression could lead to such a scenario:
//
//1234567891011121314151617
//class LittleLemonApplication {
//    var onOrderReady: () -> Unit = {}
//    …
//}
//
//
//class MainActivity {
//    fun onCreate(savedInstanceState: Bundle?) {
//        …
//        (application as LittleLemonApplication).onOrderReady = {
//
//            Can you spot the memory leak? The Lambda expression passed from MainActivity to LittleLemonApplication executes showOrderReadyMessage(). This function belongs to MainActivity. This means LittleLemonApplication now holds a reference to MainActivity. Even if MainActivity is destroyed, it cannot be garbage collected.
//
//            To avoid such memory leaks, it helps to think about the scope of each class. Activities have a smaller scope than the application. This means we should not pass a Lambda expression to the application class that references an activity. An even safer approach is to avoid passing references to the calling class at all where possible.
//
//            Another challenge with using Lambda expressions is testing the code that uses them. We will explore this challenge next.
//
//        Testing Lambda expressions
//            When calling higher-order functions (more on these in the next lesson) on a mock (you can refresh your memory on mocks by going back to lesson 2 of module 2), you might expect the mock to execute the Lambda expression that was passed in.
//
//            The example below demonstrates such a scenario:
//
//            123456789
//            class TestableClass(private val dependency: Dependency)
//
//            fun doSomething() {
//
//                val doThisInTheDependency = { … }
//
//                dependency.doSomethingElse(doThisInTheDependency)
//
//            }
//            When you test doSomething(), you expect doThisInTheDependency to be executed, just like it would in a real-life scenario. However, because in a test, dependency is a mock and mocks don’t contain the actual implementation of the classes they mock, the Lambda expression will not be executed without some more work.
//
//            If you use Mockito, you can configure the mock to execute the lambda:
//
//            123456789
//            val mockDependency: Dependency = mock {
//
//                on { doSomethingElse() }.willAnswer { invocation ->
//
//                    invocation.getArgument<() -> Unit>(0) ()
//
//                }
//
//            }
//            The above stubs the doSomethingElse function. When it is called, its first argument is obtained as a Lambda expression and gets executed. Now, the test can count on the Lambda expression to run.
//
//            Concluding thoughts
//                    Lambda expressions are very useful tools to have in your career as an Android developer. It is important to remember that these tools come with some challenges. Keep those challenges in mind and you will be able to fully utilize their strengths.

//Solution: Practice defining listeners in Android
//In this reading, you will review the solution code. The code blocks below outline the outcome of each activity of the exercise.
////
//Solution code in MainActivity.kt
//123456789101112131415161718
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        Solution code in activity_main.xml
//                123456789101112131415161718