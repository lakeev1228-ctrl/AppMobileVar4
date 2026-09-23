package com.example.AppMobileVar4

import android.os.Bundle
import android.util.Log
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
import com.example.AppMobileVar4.ui.theme.AppMobileVar4Theme
import com.example.appmobilevar4.ui.viewModel.PostViewModel
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

                LaunchedEffect(Unit) {
                    todoViewModel.addTodo(
                        todo = "Пропылесосить ковер",
                        completed = false,
                        userId = 31
                    ) { todo ->
                        Log.d(
                            "TodoLog",
                            "ID: ${todo.id} | " +
                                    "Задание: ${todo.todo} | " +
                                    "Отметка о завершении: ${todo.completed} | " +
                                    "Пользователь: ${todo.userId}"
                        )
                    }
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