//package com.parul.whatsappclone
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import com.parul.whatsappclone.presentation.chat_box.ChatListModel
//
//
//@Composable
//fun ChatListBox(
//    chat: ChatListModel,
//    onClick: (ChatListModel) -> Unit
//) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onClick(chat) }
//            .padding(horizontal = 12.dp, vertical = 8.dp)
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Profile Image
//            Image(
//                painter =(painterResource(id = R.drawable.kohli, contentDescription = null)
//                modifier = Modifier
//                    .size(56.dp)
//                    .clip(CircleShape),
//                contentScale = ContentScale.Crop
//            )
//
//            Spacer(modifier = Modifier.width(12.dp))
//
//            // Chat Details
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        text = chat.name,
//                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                    Text(
//                        text = chat.time,
//                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = chat.lastMessage,
//                        style = MaterialTheme.typography.bodyMedium,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
//                        modifier = Modifier.weight(1f)
//                    )
//
//                    if (chat.unreadCount > 0) {
//                        Box(
//                            modifier = Modifier
//                                .padding(start = 6.dp)
//                                .size(20.dp)
//                                .background(Color(0xFF25D366), CircleShape),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                text = chat.unreadCount.toString(),
//                                color = Color.White,
//                                style = MaterialTheme.typography.bodySmall
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
