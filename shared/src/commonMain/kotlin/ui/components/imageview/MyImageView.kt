package ui.components.imageview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cmpworkshop.shared.generated.resources.Res
import cmpworkshop.shared.generated.resources.image_slider_one
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun MyImageView(modifier: Modifier = Modifier, imageRes:DrawableResource=Res.drawable.image_slider_one) {
    Box(modifier) {
        Image(
            painter = painterResource(resource = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
}
