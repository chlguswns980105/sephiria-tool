package com.hyeonjunchoi.sephiria

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

fun main() = application {
    val minimumSlot = 24
    val maximumSlot = 30

    Window(onCloseRequest = ::exitApplication, title = "Sephiria Tool By Hyeonjun-Choi") {
        MaterialTheme {
            var currentSlot by remember { mutableStateOf(minimumSlot) }
            val columns = ceil(currentSlot / 6.0).toInt()

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 인벤토리
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    repeat(columns) { rowIndex -> // 세로(줄) 조정
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            repeat(6) { columnIndex -> // 가로(칸) 조정
                                if (rowIndex * 6 + columnIndex < currentSlot) { // 슬롯 개수에 맞게 표시
                                    Box(modifier = Modifier.size(50.dp).background(Color.LightGray))
                                }
                            }
                        }
                    }
                }
                // 인벤토리 버튼
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("인벤토리 슬롯 조절")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { currentSlot = max(minimumSlot, currentSlot - 1) }) {
                            Text("-")
                        }
                        Button(onClick = { currentSlot = min(maximumSlot, currentSlot + 1) }) {
                            Text("+")
                        }
                    }
                }
            }
        }
    }
}
