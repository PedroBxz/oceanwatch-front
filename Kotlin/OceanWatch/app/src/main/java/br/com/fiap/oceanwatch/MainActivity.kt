package br.com.fiap.oceanwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.oceanwatch.ui.theme.OceanWatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OceanWatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagPrincipal() {
    val selectedItem = remember { mutableStateOf(0) }
    Box(modifier = Modifier.fillMaxSize()) {


        Scaffold(bottomBar = {
            BottomNavigationBar(selectedItem.value) { index ->
                selectedItem.value = index
            }
        }) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}

        }

    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfffe9e9e9))
                .height(70.dp)
                .padding(13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocean),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    Column {
        Spacer(modifier = Modifier.height(80.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Buscar") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Gray,
                containerColor = Color(0xfffe9e9e9)
            )

        )
        // Spacer for separation
        Spacer(modifier = Modifier.height(16.dp))

        // Section "Próximos a você"
        Text(
            text = "Próximos a você",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Content cards
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            ContentCard(
                name = "Marcelo Moryan",
                level = "Watcher • Nível 1",
                description = "Esgoto sendo despejado em praias de Guarapari, na Praia do Morro! Algo precisa ser feito.",
                imageUrl = R.drawable.videoexemplo
            )

        }


    }
}

@Composable
fun BottomNavigationBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xfffe9e9e9),
        contentColor = Color(0xfffe9e9e9)
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Face, contentDescription = null) },
            label = { Text("Comunidade") },
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.LocationOn, contentDescription = null) },
            label = { Text("Mapa") },
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
            label = { Text("Aprenda") },
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = null) },
            label = { Text("Perfil") },
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) }
        )
    }
}

@Composable
fun ContentCard(name: String, level: String, description: String, imageUrl: Int) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color(0xfffe9e9e9))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox, // Placeholder for profile picture
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(20.dp))
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = name, style = MaterialTheme.typography.bodyLarge)
                    Text(
                        text = level,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }
            }
            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = "Content Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color(0xfffe9e9e9))
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun PaginaAprender() {
    //header e menu começo
    val selectedItem = remember { mutableStateOf(0) }
    Box(modifier = Modifier.fillMaxSize()) {


        Scaffold(bottomBar = {
            BottomNavigationBar(selectedItem.value) { index ->
                selectedItem.value = index
            }
        }) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}

        }
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfffe9e9e9))
                .height(70.dp)
                .padding(13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocean),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    //header e menu final
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocean),
                contentDescription = "Logo",
                modifier = Modifier.height(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Header Text
        Text(
            text = "Proteger os oceanos é tarefa de todos. Aprenda como, agora!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Courses Section
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            CourseCard(
                title = "Mudanças Climáticas e os Oceanos",
                progress = "0% concluído",
                imageUrl = R.drawable.oceanos // Placeholder image resource
            )
            CourseCard(
                title = "Introdução aos Ecossistemas Marinhos",
                progress = "0% concluído",
                imageUrl = R.drawable.marinhos // Placeholder image resource
            )
            CourseCard(
                title = "Conservação dos Recifes de Coral",
                progress = "0% concluído",
                imageUrl = R.drawable.coral // Placeholder image resource
            )
        }
    }
}


@Composable
fun CourseCard(title: String, progress: String, imageUrl: Int) {
    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color(0xfff5581ea))
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = "Course Image",
                modifier = Modifier
                    .size(150.dp)
                    .background(Color(0xfff5581ea))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = progress, style = MaterialTheme.typography.bodyLarge)
            }

        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun PagPerfil() {
    //header e menu começo
    val selectedItem = remember { mutableStateOf(0) }
    Box(modifier = Modifier.fillMaxSize()) {


        Scaffold(bottomBar = {
            BottomNavigationBar(selectedItem.value) { index ->
                selectedItem.value = index
            }
        }) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}

        }
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfffe9e9e9))
                .height(70.dp)
                .padding(13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocean),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Maria Priscila Martins",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Watcher • Nível 2",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Progress Bar
                LinearProgressIndicator(
                    progress = 200 / 850f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("200/850 pontos")
                    Text("Ganhe mais pontos")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("5", fontWeight = FontWeight.Bold)
                        Text("contribuições", color = Color.Gray)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("0", fontWeight = FontWeight.Bold)
                        Text("seguidores", color = Color.Gray)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("12", fontWeight = FontWeight.Bold)
                        Text("seguindo", color = Color.Gray)
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp));
        Text(
            text = "Últimas contribuições",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        // Content cards
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            ContentCard(
                name = "Maria Priscila Martins",
                level = "Watcher • Nível 2",
                description = "Esgoto sendo despejado em praias de Guarapari, na Praia do Morro! Algo precisa ser feito.",
                imageUrl = R.drawable.videoexemplo
            )

        }
    }
    //header e menu final

}

@Composable
fun PagMapa() {
    //header e menu começo
    val selectedItem = remember { mutableStateOf(0) }
    Box(modifier = Modifier.fillMaxSize()) {


        Scaffold(bottomBar = {
            BottomNavigationBar(selectedItem.value) { index ->
                selectedItem.value = index
            }
        }) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}

        }
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfffe9e9e9))
                .height(70.dp)
                .padding(13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocean),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
        Image(
            painter = painterResource(id = R.drawable.mapa),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 60.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .offset(y = -50.dp)
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOcean() {
    OceanWatchTheme {
        PagPrincipal()
    }
}