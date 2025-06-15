package com.example.bismillah

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

class FollowingCustomView(context: Context, attributeSet: AttributeSet): View(context, attributeSet) {

    val radius = 100f
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val textName = Paint(Paint.ANTI_ALIAS_FLAG)
    val textUser = Paint(Paint.ANTI_ALIAS_FLAG)
    val textBio = Paint(Paint.ANTI_ALIAS_FLAG)
    lateinit var vectorProfil: Drawable
    lateinit var vectorAddFriend: Drawable
    lateinit var vectorBack: Drawable
    val buttonRect = RectF()

    init {
        textPaint.apply {
            color = Color.BLACK
            textSize = 55f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        textName.apply {
            color = Color.BLACK
            textSize = 43f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        textUser.apply {
            color = Color.GRAY
            textSize = 35f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
        }
        textBio.apply {
            color = Color.BLACK
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
        }
        vectorProfil = ContextCompat.getDrawable(context, R.drawable.baseline_account_circle_24)!!
        vectorAddFriend = ContextCompat.getDrawable(context, R.drawable.baseline_group_add_24)!!
        vectorBack = ContextCompat.getDrawable(context, R.drawable.baseline_arrow_back_24)!!
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.WHITE
        canvas?.drawRect(0f, 0f, width.toFloat(), 150f, paint)

        val backX = 45f // Menyesuaikan posisi X gambar vektor
        val backY = 40f
        val backWidth = 70
        val backHeight = 70
        vectorBack.setBounds(backX.toInt(), backY.toInt(), backX.toInt() + backWidth, backY.toInt() + backHeight)
        vectorBack.draw(canvas)

        canvas.drawText("Following", 190f, 95f, textPaint)

        val AddX = 950f // Menyesuaikan posisi X gambar vektor
        val AddY = 45f
        val AddWidth = 65
        val AddHeight = 65
        vectorAddFriend.setBounds(AddX.toInt(), AddY.toInt(), AddX.toInt() + AddWidth, AddY.toInt() + AddHeight)
        vectorAddFriend.draw(canvas)

        paint.color = Color.BLACK // Warna garis
        paint.strokeWidth = 2f
        val garisY = 150f
        canvas.drawLine(0f, garisY, width.toFloat(), garisY, paint)

        val profilX = width - 1050 // Menyesuaikan posisi X gambar vektor
        val profilY = garisY + 30f
        val profilWidth = 135
        val profilHeight = 135
        vectorProfil.setBounds(profilX.toInt(), profilY.toInt(), profilX.toInt() + profilWidth, profilY.toInt() + profilHeight)
        vectorProfil.draw(canvas)

        val nama1X = profilX + 160f
        val nama1Y = garisY + 85f
        canvas.drawText("BASE UINSA", nama1X, nama1Y, textName)
        val user1X = profilX + 160f
        val user1Y = nama1Y + 40f
        canvas.drawText("@uinsafess", user1X, user1Y, textUser)
        val bio1X = profilX + 160f
        val bio1Y = user1Y + 55f
        canvas.drawText("Kirim menfess kamu di @UINSAFESS!!", bio1X, bio1Y, textBio)

        val btnEditX = profilX + 750f
        val btnEditY = garisY + 45f
        val btnEditWidth = 250f
        val btnEditHeight = 70f
        buttonRect.set(btnEditX, btnEditY, btnEditX + btnEditWidth, btnEditY + btnEditHeight)
// Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 3f // Ketebalan border
        canvas.drawRoundRect(buttonRect, 50f, 50f, paint)
// Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 45f
// Menggambar teks di tengah tombol
       // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 40f
        val buttonText = "Following"
        val textWidth = paint.measureText(buttonText)
        canvas.drawText(buttonText, buttonRect.centerX() - textWidth / 2, buttonRect.centerY() + 15f, paint)

        val profil2X = width - 1050 // Menyesuaikan posisi X gambar vektor
        val profil2Y = profilY + 200f
        val profil2Width = 135
        val profil2Height = 135
        vectorProfil.setBounds(profil2X.toInt(), profil2Y.toInt(), profil2X.toInt() + profil2Width, profil2Y.toInt() + profil2Height)
        vectorProfil.draw(canvas)

        val nama2X = profil2X + 160f
        val nama2Y = nama1Y + 200f
        canvas.drawText("SBMPTNFESS", nama2X, nama2Y, textName)
        val user2X = profil2X + 160f
        val user2Y = nama2Y + 40f
        canvas.drawText("@sbmptnfess", user2X, user2Y, textUser)
        val bio2X = profil2X + 160f
        val bio2Y = user2Y + 55f
        canvas.drawText("Sharing about SNMPTN, SBMPTN, etc", bio2X, bio2Y, textBio)

        val btnFollowing2X = profil2X + 750f
        val btnFollowing2Y = btnEditY + 200f
        val btnFollowing2Width = 250f
        val btnFollowing2Height = 70f
        buttonRect.set(btnFollowing2X, btnFollowing2Y, btnFollowing2X + btnFollowing2Width, btnFollowing2Y + btnFollowing2Height)
// Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 3f // Ketebalan border
        canvas.drawRoundRect(buttonRect, 50f, 50f, paint)
// Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 45f
// Menggambar teks di tengah tombol
        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 40f
        val buttonTextFol2 = "Following"
        val textWidthFol2 = paint.measureText(buttonText)
        canvas.drawText(buttonTextFol2, buttonRect.centerX() - textWidthFol2 / 2, buttonRect.centerY() + 15f, paint)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Deteksi klik pada tombol panah
                if (event.x in 0f..150f && event.y in 0f..150f) {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }

}