package com.example.recicoin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.recicoin.ui.theme.RecicoinTheme
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.example.recicoin.ui.theme.BranquinhoVerde
import com.example.recicoin.ui.theme.VerdeClaro
import com.example.recicoin.ui.theme.VerdeEscuro
import com.example.recicoin.ui.theme.cocoFontFamily
import com.example.recicoin.ui.theme.poppinsFontFamily


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecicoinTheme {


                App()
                }

            }
        }
    }




@Composable
fun gradientBackgroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {

    val endOffSet = if (isVerticalGradient) {
       Offset(x = 0f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

return Brush.linearGradient(
    colors = colors,
    start = Offset.Zero,
    end = endOffSet
)
    }








@Composable
fun Botao(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4AD840)),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .size(width = 300.dp, height = 75.dp)

        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 25.sp,
                fontFamily = poppinsFontFamily
            )
        }

}



@Composable
fun App() {

    val gradientColorsList = listOf(
        VerdeClaro,
        VerdeClaro,
        VerdeEscuro
    )






    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackgroundBrush(
                    isVerticalGradient = true,
                    colors = gradientColorsList
                )
            ),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.moeda_recicoin_bkrmv),
            contentDescription = "Ícone de Recicoin",
            modifier = Modifier
                .wrapContentSize()
                .size(150.dp)

        )
        Spacer(modifier = Modifier.size(100.dp))

        Text(
            text = "Bem-vindo ao Recicoin!",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 40.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            textAlign = TextAlign.Center

        )



        Spacer(modifier = Modifier.size(20.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Botao(text = "Faça o login", onClick = {})


        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "Não possui uma conta?",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = poppinsFontFamily
                )
            )

            val annotatedString = buildAnnotatedString {
                pushStringAnnotation(tag = "URL", annotation = "cadastrar")
                withStyle(style = SpanStyle(color = Color(0xFF4AD840), textDecoration = TextDecoration.Underline)) {
                    append(" Cadastre-se")
                }
                pop()
            }

            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                        .firstOrNull()?.let {
                        }
                },
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = poppinsFontFamily
                )
            )
        }
    }
}



@Preview
@Composable
fun AppPreview() {
    RecicoinTheme {
        App()
    }
}

