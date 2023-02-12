package com.colisa.tetris.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.colisa.tetris.theme.BodyColor
import com.colisa.tetris.theme.ScreenBackground


@Composable
private fun AppIcon() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .background(BodyColor, RoundedCornerShape(50.dp))
            .padding(top = 30.dp)
    ) {
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .size(360.dp, 220.dp)
                    .padding(all = 20.dp)
            ) {
                Canvas(Modifier.fillMaxSize()) {
                    drawScreenBorder(
                        Offset(0f, 0f),
                        Offset(size.width, 0f),
                        Offset(0f, size.height),
                        Offset(size.width, size.height)
                    )
                }

                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                        .background(ScreenBackground)
                )

                Text(
                    text = "TETRIS",
                    textAlign = TextAlign.Center,
                    fontSize = 75.sp,
                    modifier = Modifier.align(Alignment.Center),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 45.dp, end = 45.dp)
                .height(160.dp)
                .padding(bottom = 10.dp)
        ) {
            // DIRECTION BUTTON
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(0.55f)
            ) {
                GameButton(
                    Modifier.align(Alignment.TopCenter),
                    size = DirectionButtonSize
                )
                GameButton(
                    Modifier.align(Alignment.CenterStart),
                    size = DirectionButtonSize
                )
                GameButton(
                    Modifier.align(Alignment.CenterEnd),
                    size = DirectionButtonSize
                )
                GameButton(
                    Modifier.align(Alignment.BottomCenter),
                    size = DirectionButtonSize
                )
            }

            //ROTATE BTN
            Box(
                modifier = Modifier
                    .weight(0.45f)
                    .fillMaxHeight()
            ) {
                GameButton(
                    Modifier.align(Alignment.CenterEnd),
                    size = RotateButtonSize
                )
            }
        }
    }
}

fun DrawScope.drawScreenBorder(
    topLef: Offset,
    topRight: Offset,
    bottomLeft: Offset,
    bottomRight: Offset
) {
    var path = Path().apply {
        moveTo(topLef.x, topLef.y)
        lineTo(topRight.x, topRight.y)
        lineTo(topLef.x / 2 + topRight.x / 2, topLef.y + topLef.x / 2 + topRight.x / 2)
        lineTo(topLef.x / 2 + topRight.x / 2, bottomLeft.y - topRight.x / 2 + topLef.x / 2)
        lineTo(bottomLeft.x, bottomRight.y)
        close()
    }
    drawPath(path, Color.Black.copy(0.5f))

    path = Path().apply {
        moveTo(bottomLeft.x, bottomLeft.y)
        lineTo(bottomRight.x, bottomRight.y)
        lineTo(topRight.x, topRight.y)
        lineTo(topLef.x / 2 + topRight.x / 2, topLef.y + topLef.x / 2 + topRight.x / 2)
        lineTo(topLef.x / 2 + topRight.x / 2, bottomLeft.y - topRight.x / 2 + topLef.x / 2)
        close()
    }
    drawPath(path, Color.White.copy(0.5f))

}

val DirectionButtonSize = 60.dp
val RotateButtonSize = 90.dp
val SettingButtonSize = 15.dp

@Preview(widthDp = 400, heightDp = 400)
@Composable
private fun AppIconPreview() {
    AppIcon()
}