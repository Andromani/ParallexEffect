package com.myParallexEffectCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myParallexEffectCompose.ui.theme.MyParallexEffectComposeTheme

class MainActivity : ComponentActivity() {

    private var list1 = arrayListOf(1, 2, 3, 5, 6, 7)
    private var list2 = arrayListOf(0, 2, 4, 5, 9, 7)
    private var list3: MutableSet<Int> = mutableSetOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // duplicate()
            mapVsFlatMap()
            MyParallexEffectComposeTheme {
                Surface {
//                    CollapsingToolbarParallaxEffect()
                    //RememberExample()
                }
            }
        }
    }

    private fun mapVsFlatMap() {
        val interviewList = listOf(
            Interview(listOf("Manikandan", "Mani", "Kandan")),
            Interview(listOf("Manikandan-1", "Mani-1", "Kandan-2")),
            Interview(listOf("Manikandan-2", "Mani-2", "Kandan-2")),
        )

        var map = interviewList.map { it.item }
        println(map) // One to one

        var flatMap = interviewList.flatMap { it.item }
        println(flatMap) // one to many
    }


    private fun duplicate() {

        list1.intersect(list2).forEach { x ->
            println("Intersect --> $x")
            list3.add(x)
        }

        // list2.addAll(list1)
        //val groupBy = list2.filter { !list3.add(it) }.toSet()
        //println("Testing...$groupBy")


        println("Intersect --> $list3")
    }

//    @Composable
//    fun RememberExample() {
//        val savedCount: Int by rememberSaveable { mutableStateOf(0) }
//        // var count by remember { mutableStateOf()}
//        var count by remember { mutableStateOf("") }
//
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text("Remember Example: $count")
//            Button(
//                onClick = { count = "Manikandan" },
//                modifier = Modifier.padding(top = 16.dp)
//            ) {
//                Text("Increment")
//            }
//
//            Spacer(modifier = Modifier.height(32.dp))
//
//            Text("RememberSaveable Example: $savedCount")
//            Button(
//                onClick = { /* No operation here, the value will be saved automatically */ },
//                modifier = Modifier.padding(top = 16.dp)
//            ) {
//                Text("Do Nothing")
//            }
//        }
//    }
}