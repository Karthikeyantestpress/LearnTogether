package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                    LearnTogetherApp(
                        image =painterResource(R.drawable.bg_compose_background),
                        title =stringResource(R.string.title_jetpack_compose_tutorial),
                        shortDescription= stringResource(R.string.short_description),
                        longDescription =stringResource(R.string.long_description),
                    )
            }
        }
    }
}

@Composable
fun LearnTogetherApp(image: Painter ,title:String, shortDescription:String, longDescription:String) {
    ArticleCard(
        imagePainter = image,
        title = title,
        shortDescription = shortDescription,
        longDescription = longDescription,
    )
}

@Composable
fun ArticleCard(
    imagePainter: Painter,
    title: String,
    shortDescription: String,
    longDescription: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    LearnTogetherTheme {
        LearnTogetherApp(
            image =painterResource(R.drawable.bg_compose_background),
            title =stringResource(R.string.title_jetpack_compose_tutorial),
            shortDescription= stringResource(R.string.short_description),
            longDescription =stringResource(R.string.long_description),
        )
    }
}