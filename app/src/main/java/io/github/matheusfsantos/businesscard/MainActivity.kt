package io.github.matheusfsantos.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.matheusfsantos.businesscard.ui.theme.BusinessCardTheme
import io.github.matheusfsantos.businesscard.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fullName = resources.getString(R.string.full_name);
        val title = resources.getString(R.string.title);
        val email = resources.getString(R.string.email);
        val github = resources.getString(R.string.github);
        val reddit = resources.getString(R.string.reddit);

        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            Image(
                                contentDescription = "User image",
                                painter = painterResource(id = R.drawable.profile_image),
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(100))
                            )

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(60.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = fullName,
                                        style = Typography.titleMedium,
                                    )
                                    Text(
                                        text = title,
                                        style = Typography.bodySmall,
                                        color = Color.Gray
                                    )
                                    Text(
                                        text = email,
                                        style = Typography.labelSmall,
                                        color = Color.Gray,
                                    )
                                }

                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.github),
                                            contentDescription = "GitHub blue icon",
                                            modifier = Modifier
                                                .size(35.dp)
                                                .clip(RoundedCornerShape(100))
                                        )
                                        Text(
                                            text = github,
                                            style = Typography.bodyMedium,
                                        )
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    )  {
                                        Image(
                                            painter = painterResource(id = R.drawable.reddit),
                                            contentDescription = "Reddit icon",
                                            modifier = Modifier
                                                .size(35.dp)
                                                .clip(RoundedCornerShape(100))
                                        )
                                        Text(
                                            text = reddit,
                                            style = Typography.bodyMedium,
                                        )
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme { }
}