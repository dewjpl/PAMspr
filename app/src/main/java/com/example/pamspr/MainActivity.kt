import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF6200EE),
            background = Color.White,
            onBackground = Color.Black,
        )
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
fun UserHeader(name: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "User Icon",
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Column {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun ActivityItem(icon: ImageVector, name: String, count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(
            text = count.toString(),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ActivityList() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Recent Activities",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        HorizontalDivider(
            modifier = Modifier.padding(bottom = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        ActivityItem(Icons.Default.Refresh, "Committed changes", 22)
        ActivityItem(Icons.Default.Refresh, "Comment count", 15)
        ActivityItem(Icons.Default.Done, "Merged pull requests", 8)
        ActivityItem(Icons.Default.Close, "Closed pull requests", 3)
    }
}

@Composable
fun BottomButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Display message",
                color = Color.White
            )
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            UserHeader(name = "Grześ Grzegorzewski", subtitle = "Git statistics")
            Spacer(modifier = Modifier.height(16.dp))
            ActivityList()
        }
        BottomButton()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApp {
        MainScreen()
    }
}
