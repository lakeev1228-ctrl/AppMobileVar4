package com.example.appmobilevar4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmobilevar4.data.model.Todo
import com.example.appmobilevar4.ui.theme.AppMobileVar4Theme
import com.example.appmobilevar4.ui.viewModel.PostViewModel
import com.example.appmobilevar4.ui.viewModel.ProductViewModel
import com.example.appmobilevar4.ui.viewModel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMobileVar4Theme {
                val postViewModel: PostViewModel = viewModel()

                LaunchedEffect(Unit) {
                    postViewModel.fetchPosts()
                }

                val todoViewModel: TodoViewModel = viewModel()

                val todo = Todo(
                    todo = "Пропылесосить ковер",
                    completed = false,
                    userId = 31
                )

                LaunchedEffect(Unit) {
                    todoViewModel.addTodo(todo)
                }

                val productViewModel: ProductViewModel = viewModel()

                LaunchedEffect(Unit) {
                    productViewModel.updateProduct()
                    productViewModel.deleteTodo()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppMobileVar4Theme {
        Greeting("Android")
    }
}