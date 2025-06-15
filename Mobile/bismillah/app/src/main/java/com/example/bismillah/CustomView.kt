package com.example.bismillah

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

class CustomView(context: Context, attributeSet: AttributeSet): View(context, attributeSet) {

    val radius = 140f
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val paintCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val normalTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val bioTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val linkTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    lateinit var vectorDrawable: Drawable
    lateinit var vectorDrawable2: Drawable
    lateinit var vectorDrawable3: Drawable
    lateinit var vectorDrawable4: Drawable
    lateinit var vectorDrawable5: Drawable
    val buttonRect = RectF()
    private var followingBounds = Rect()
    private var jmlFollowingBounds = Rect()

    private val fabPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE  // Warna FAB
        style = Paint.Style.FILL
    }

    private val fabTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE  // Warna ikon "+"
        textSize = 80f
        textAlign = Paint.Align.CENTER
    }
    // Posisi FAB
    private var fabX = 0f
    private var fabY = 0f
    private val fabRadius = 90f

    init {
        textPaint.apply {
            color = Color.BLACK
            textSize = 50f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        normalTextPaint.apply {
            color = Color.DKGRAY
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
        }
        bioTextPaint.apply {
            color = Color.BLACK
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        linkTextPaint.apply {
            color = Color.parseColor("#87CEFA")
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        vectorDrawable = ContextCompat.getDrawable(context, R.drawable.baseline_badge_24)!!
        vectorDrawable2 = ContextCompat.getDrawable(context, R.drawable.baseline_add_location_24)!!
        vectorDrawable3 = ContextCompat.getDrawable(context, R.drawable.baseline_calendar_month_24)!!
        vectorDrawable4 = ContextCompat.getDrawable(context, R.drawable.baseline_link_24)!!
        vectorDrawable5 = ContextCompat.getDrawable(context, R.drawable.baseline_arrow_back_241)!!
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paintCircle.color = Color.GRAY

        canvas?.drawRect(0f, 0f, width - 0f, height - 1800f, paint)

        val backX = 45f // Menyesuaikan posisi X gambar vektor
        val backY = 40f
        val backWidth = 70
        val backHeight = 70
        vectorDrawable5.setBounds(backX.toInt(), backY.toInt(), backX.toInt() + backWidth, backY.toInt() + backHeight)
        vectorDrawable5.draw(canvas)

        // Variabel untuk posisi tiga titik
        val dotX = width - 85f // Posisi X (tepi kanan layar)
        val dotY = 50f // Posisi Y (di bagian atas)
        val dotRadius = 8f // Ukuran titik
        val dotSpacing = 25f // Jarak antar titik
        paint.color = Color.WHITE // Warna titik
        canvas.drawCircle(dotX, dotY, dotRadius, paint)
        canvas.drawCircle(dotX, dotY + dotSpacing, dotRadius, paint)
        canvas.drawCircle(dotX, dotY + 2 * dotSpacing, dotRadius, paint)

        val circleX = radius + 30f // Jarak dari tepi kiri
        val circleY = height - radius - 1700f // Jarak dari tepi bawah
        canvas?.drawCircle(circleX, circleY, radius, paintCircle)

        val textY = circleY + radius + 60f // Tambahkan 50 piksel di bawah lingkaran
        val textX = circleX - radius
        canvas.drawText("Laura Zakkia", textX, textY, textPaint)

        val textY2 = textY + 55f // Tambahkan 50 piksel di bawah teks pertama
        canvas.drawText("@laurazakkia", textX, textY2, normalTextPaint)

        val textY3 = textY2 + 70f // Tambahkan 50 piksel di bawah teks pertama
        canvas.drawText("Jangan Lupa Sholat, DM For Support !", textX, textY3, bioTextPaint)

        val badgeX = textX  // Menyesuaikan posisi X gambar vektor
        val badgeY = textY3 + 40f // Menempatkan gambar di bawah teks bio
        val badgeWidth = 50
        val badgeHeight = 50
        vectorDrawable.setBounds(badgeX.toInt(), badgeY.toInt(), badgeX.toInt() + badgeWidth, badgeY.toInt() + badgeHeight)
        vectorDrawable.draw(canvas)

        val verY4 = badgeX + 70f // Jarak dari tepi kiri
        val horiY4 = textY3 + 80f // Jarak dari tepi bawah
        canvas.drawText("Advertising & Marketing Agency", verY4, horiY4, normalTextPaint)

        val locX = textX  // Menyesuaikan posisi X gambar vektor kedua
        val locY = badgeY + badgeHeight + 20f // Menempatkan gambar kedua di bawah gambar pertama dengan jarak 20 piksel
        val locWidth = 50
        val locHeight = 50
        vectorDrawable2.setBounds(locX.toInt(), locY.toInt(), locX.toInt() + locWidth, locY.toInt() + locHeight)
        vectorDrawable2.draw(canvas)

        val loctextX = locX + 70f // Jarak dari tepi kiri
        val loctextY = horiY4 + 70f // Jarak dari tepi bawah
        canvas.drawText("Jakarta, Indonesia", loctextX, loctextY, normalTextPaint)

        val linkX = loctextX + 390f // Menyesuaikan posisi X gambar vektor
        val linkY = locY
        val linkWidth = 50
        val linkHeight = 50
        vectorDrawable4.setBounds(linkX.toInt(), linkY.toInt(), linkX.toInt() + linkWidth, linkY.toInt() + linkHeight)
        vectorDrawable4.draw(canvas)

        val linktextX = linkX + 70f // Jarak dari tepi kiri
        val linktextY = linkY + 40f // Jarak dari tepi bawah
        canvas.drawText("Https://laurazakkia..", linktextX, linktextY, linkTextPaint)

        val calX = textX  // Menyesuaikan posisi X gambar vektor kedua
        val calY = locY + locHeight + 20f // Menempatkan gambar kedua di bawah gambar pertama dengan jarak 20 piksel
        val calWidth = 50
        val calHeight = 50
        vectorDrawable3.setBounds(calX.toInt(), calY.toInt(), calX.toInt() + calWidth, calY.toInt() + calHeight)
        vectorDrawable3.draw(canvas)

        val caltextX = calX + 70f // Jarak dari tepi kiri
        val caltextY = loctextY + 70f // Jarak dari tepi bawah
        canvas.drawText("Joined May, 2010", caltextX, caltextY, normalTextPaint)

        val jmlFollowingX = circleX - radius // Tambahkan 50 piksel di bawah lingkaran
        val jmlFollowingY = caltextY + 70f
        canvas.drawText("1150", jmlFollowingX, jmlFollowingY, bioTextPaint)
        bioTextPaint.getTextBounds("1150", 0, "1150".length, jmlFollowingBounds)
        jmlFollowingBounds.offset(jmlFollowingX.toInt(), jmlFollowingY.toInt())

        val FollowingX = jmlFollowingX + 115f // Tambahkan 50 piksel di bawah lingkaran
        val FollowingY = caltextY + 70f
        canvas.drawText("Following", FollowingX, FollowingY, normalTextPaint)
        normalTextPaint.getTextBounds("Following", 0, "Following".length, followingBounds)
        followingBounds.offset(FollowingX.toInt(), FollowingY.toInt())

        val jmlFollowerX = FollowingX + 250f // Tambahkan 50 piksel di bawah lingkaran
        val jmlFollowerY = caltextY + 70f
        canvas.drawText("1111", jmlFollowerX, jmlFollowerY, bioTextPaint)

        val FollowerX = jmlFollowerX + 115f // Tambahkan 50 piksel di bawah lingkaran
        val FollowerY = caltextY + 70f
        canvas.drawText("Followers", FollowerX, FollowerY, normalTextPaint)

        val btnEditX = width / 4f + 400f
        val btnEditY = height - radius - 1620f
        val btnEditWidth = 350f
        val btnEditHeight = 100f

// Mengatur batas tombol
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

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 45f
        val buttonText = "Edit Profile"
        val textWidth = paint.measureText(buttonText)
        canvas.drawText(buttonText, buttonRect.centerX() - textWidth / 2, buttonRect.centerY() + 15f, paint)

        val btnTweetX = width - 1000f
        val btnTweetY = height -1150f // Sesuaikan posisi Y tombol
        val btnTweetWidth = 370f
        val btnTweetHeight = 100f
        // Mengatur batas tombol
        buttonRect.set(btnTweetX, btnTweetY, btnTweetX + btnTweetWidth, btnTweetY + btnTweetHeight)
        // Menggambar tombol
        paint.color = Color.TRANSPARENT // Warna tombol
        canvas.drawRoundRect(buttonRect, 35f, 35f, paint)

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 45f
        val btnTweetText = "Tweets"
        val textTweetWidth = paint.measureText(btnTweetText)
        canvas.drawText(btnTweetText, buttonRect.centerX() - textTweetWidth / 2, buttonRect.centerY() + 15f, paint)

        val btnRepliesX = width - 500f
        val btnRepliesY = height -1150f // Sesuaikan posisi Y tombol
        val btnRepliesWidth = 370f
        val btnRepliesHeight = 100f
        // Mengatur batas tombol
        buttonRect.set(btnRepliesX, btnRepliesY, btnRepliesX + btnRepliesWidth, btnRepliesY + btnRepliesHeight)
        // Menggambar tombol
        paint.color = Color.TRANSPARENT // Warna tombol
        canvas.drawRoundRect(buttonRect, 35f, 35f, paint)
        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 45f
        val btnRepliesText = "Replies"
        val textRepliesWidth = paint.measureText(btnTweetText)
        canvas.drawText(btnRepliesText, buttonRect.centerX() - textRepliesWidth / 2, buttonRect.centerY() + 15f, paint)

        paint.color = Color.BLACK // Warna garis
        val underlineY = btnTweetY + btnTweetHeight
        canvas.drawRect(btnTweetX, underlineY, btnTweetX + btnTweetWidth, underlineY + 5f, paint)

        // Hitung posisi FAB (pojok kanan bawah)
        fabX = width - fabRadius - 50
        fabY = height - fabRadius - 50

// Gambar lingkaran FAB
        canvas.drawCircle(fabX, fabY, fabRadius, fabPaint)

// Gambar tanda "+"
        canvas.drawText("+", fabX, fabY + 30f, fabTextPaint)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (followingBounds.contains(event.x.toInt(), event.y.toInt())) {
                    // Jika klik pada "Following"
                    val intent = Intent(context, FollowingActivity::class.java)
                    context.startActivity(intent)
                    return true
                }

                if (jmlFollowingBounds.contains(event.x.toInt(), event.y.toInt())) {
                    // Jika klik pada "1150" (bisa diarahkan ke halaman yang sama atau berbeda)
                    val intent = Intent(context, FollowingActivity::class.java)
                    context.startActivity(intent)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }
}