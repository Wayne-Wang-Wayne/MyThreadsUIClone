package com.example.mythreadsuiclone.ui.threadshomescreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mythreadsuiclone.utils.timeStampToReadableDate

@Composable
fun UserName(userName: String, modifier: Modifier) {
    Text(
        text = userName,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
    )
}

@Composable
fun EditButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Icon(
        imageVector = Icons.Default.MoreVert,
        contentDescription = "更多選項",
        modifier = modifier.clickable { onClick() } ,
    )
}

@Composable
fun PostTime(postTime: Long, modifier: Modifier) {
    Text(
        text = postTime.timeStampToReadableDate(),
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun PostContent(postContent: String, modifier: Modifier) {
    Text(
        text = postContent,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
    )
}

@Composable
fun PostPictures(
    postImageUrl: List<String>, modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(start = 58.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(200.dp)
    ) {
        itemsIndexed(postImageUrl, key = {index, _ -> index}) { _, url ->
            PostImage(
                imageUrl = url,
                modifier = modifier
            )
        }
    }
}

@Composable
fun PostImage(
    imageUrl: String,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .height(250.dp)
            .aspectRatio(3f / 4f)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
@Preview
fun PreviewPostImage() {
    PostPictures(
        postImageUrl = listOf(
            "https://picsum.photos/400/800?random=1",
            "https://picsum.photos/400/800?random=2",
            "https://picsum.photos/600/400?random=3"
        )
    )
}
