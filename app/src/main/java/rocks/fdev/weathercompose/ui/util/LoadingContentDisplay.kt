package rocks.fdev.weathercompose.ui.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Displays a loading indicator or content
 *
 * @param isLoading current loading state
 * @param modifier parent modifier presets
 * @param content content to be shown when not loading
 */
@Composable
fun LoadingContentDisplay(isLoading: Boolean, modifier: Modifier, content: @Composable () -> Unit) {
    if (isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        content()
    }
}
