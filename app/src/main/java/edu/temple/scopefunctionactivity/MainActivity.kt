package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("testDataArray: output", getTestDataArray().toString())
        val listOfNumbers = listOf(1.0, 3.0, 5.0, 7.0, 9.0, 2.0, 8.0)
        val isAverageLessThanMedian = averageLessThanMedian(listOfNumbers)
        Log.d("averageLessThanMedian: output", isAverageLessThanMedian.toString())

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"


    private fun getTestDataArray(): List<Int> = MutableList(10) { Random.nextInt() }.apply{sort()}


    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>) =
    listOfNumbers.average() < listOfNumbers.sorted().let { sortedList ->
        if (sortedList.size % 2 == 0)
            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
        else
            sortedList[sortedList.size / 2]
    }

    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View =
        (recycledView as? TextView?: TextView(context)).apply {
            setPadding(5, 10, 10, 0)
            textSize = 22f }.apply { text = collection[position].toString() }
}