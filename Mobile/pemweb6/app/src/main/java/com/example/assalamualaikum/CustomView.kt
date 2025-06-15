package com.example.assalamualaikum

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
    val smallText = Paint(Paint.ANTI_ALIAS_FLAG)
    lateinit var vectorDrawable: Drawable
    lateinit var vectorDrawable2: Drawable
    lateinit var vectorDrawable3: Drawable
    lateinit var vectorDrawable4: Drawable
    lateinit var vectorDrawable5: Drawable
    val buttonRect = RectF()
    private var editProfileBounds = Rect()
    private var jmlFollowingBounds = Rect()
    private val editProfileRect = RectF()

    private val fabPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE  // Warna FAB
        style = Paint.Style.FILL
    }

    private val fabTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK  // Warna ikon "+"
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }

    // Posisi FAB
    private var fabX = 0f
    private var fabY = 0f
    private val fabRadius = 35f

    init {
        fabPaint.apply {
            color = Color.WHITE
            style = Paint.Style.FILL
            textAlign = Paint.Align.CENTER
        }
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
        smallText.apply {
            color = Color.DKGRAY
            textSize = 30f // Ukuran teks
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
//        vectorDrawable = ContextCompat.getDrawable(context, R.drawable.baseline_badge_24)!!
//        vectorDrawable2 = ContextCompat.getDrawable(context, R.drawable.baseline_add_location_24)!!
//        vectorDrawable3 = ContextCompat.getDrawable(context, R.drawable.baseline_calendar_month_24)!!
//        vectorDrawable4 = ContextCompat.getDrawable(context, R.drawable.baseline_link_24)!!
//        vectorDrawable5 = ContextCompat.getDrawable(context, R.drawable.baseline_arrow_back_241)!!
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paintCircle.color = Color.BLACK // Warna border


        val textUserX =  radius - 50f //jarak kanan kiri
        val textUserY = radius - 40f //jarak atas bawah
        canvas.drawText("Chcosmiless", textUserX, textUserY, textPaint)



        // Variabel untuk posisi tiga titik
        val dotX = width - 75f // Posisi X (tepi kanan layar)
        val dotY = radius - 75f // Posisi Y (di bagian atas)
        val dotRadius = 8f // Ukuran titik
        val dotSpacing = 20f // Jarak antar titik
        paint.color = Color.BLACK // Warna titik
        canvas.drawCircle(dotX, dotY, dotRadius, paint)
        canvas.drawCircle(dotX, dotY + dotSpacing, dotRadius, paint)
        canvas.drawCircle(dotX, dotY + 2 * dotSpacing, dotRadius, paint)


        // CREATE BUTTON PLUS ADD
        val btnPlusX = width - 220f //kiri kanan
        val btnPlusY = radius - 85f //atas bawah
        val btnPlusWidth = 65f
        val btnPlusHeight = 65f

        // Mengatur batas tombol
        buttonRect.set(btnPlusX, btnPlusY, btnPlusX + btnPlusWidth, btnPlusY + btnPlusHeight)

        // Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 5f // Ketebalan border

        canvas.drawRoundRect(buttonRect, 20f, 20f, paint)

        // Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 60f

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 70f
        val PlusText = "+"
        val PlusWidth = paint.measureText(PlusText)
        canvas.drawText(PlusText, buttonRect.centerX() - PlusWidth / 2, buttonRect.centerY() + 22f, paint)

        // CREATE BUTTON THREADS
        val btnThreadsX = width - 350f //kiri kanan
        val btnThreadsY = radius - 80f //atas bawah
        val btnThreadsWidth = 65f
        val btnThreadsHeight = 65f

        // Mengatur batas tombol
        buttonRect.set(btnThreadsX, btnThreadsY, btnThreadsX + btnThreadsWidth, btnThreadsY + btnThreadsHeight)

        // Menggambar border tombol
        paint.color = Color.TRANSPARENT // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 5f // Ketebalan border

        canvas.drawRoundRect(buttonRect, 20f, 20f, paint)

        // Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.textSize = 60f

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 65f
        val ThreadsText = "@"
        val ThreadsWidth = paint.measureText(ThreadsText)
        canvas.drawText(ThreadsText, buttonRect.centerX() - ThreadsWidth / 2, buttonRect.centerY() + 10f, paint)

        val circleX = radius + 50f // Jarak dari tepi kiri
        val circleY = radius + 180f // Jarak dari tepi bawah
        val radius = 140f
        canvas?.drawCircle(circleX, circleY, radius, paintCircle)


        // CREATE BUTTON ADD PROFILE
        val btnAddX = circleX + 60f //kiri kanan
        val btnAddY = circleY + 70f //atas bawah
        val btnAddWidth = 65f
        val btnAddHeight = 65f

        // Mengatur batas tombol
        buttonRect.set(btnAddX, btnAddY, btnAddX + btnAddWidth, btnAddY + btnAddHeight)

        // Menggambar border tombol
        paint.color = Color.WHITE // Warna border
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 5f // Ketebalan border

        canvas.drawRoundRect(buttonRect, 100f, 100f, paint)

        //Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.textSize = 40f

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 60f
        val AddText = "+"
        val AddWidth = paint.measureText(AddText)
        canvas.drawText(AddText, buttonRect.centerX() - AddWidth / 2, buttonRect.centerY() + 20f, paint)


        val textX1 = radius + 230f
        val textY1 = radius + 100f
        canvas.drawText("Ikan hiu ikan lele, hitam putih le", textX1, textY1, bioTextPaint)

        val jmlPostX = circleX + 185f // Tambahkan 50 piksel di bawah lingkaran
        val jmlPostY = textY1 + 75f
        canvas.drawText("3", jmlPostX, jmlPostY, bioTextPaint)
//        bioTextPaint.getTextBounds("1150", 0, "1150".length, jmlFollowingBounds)
//        jmlFollowingBounds.offset(jmlFollowingX.toInt(), jmlFollowingY.toInt())

        val jmlFollowersX = jmlPostX + 235f // Tambahkan 50 piksel di bawah lingkaran
        val jmlFollowersY = textY1 + 75f
        canvas.drawText("63", jmlFollowersX, jmlFollowersY, bioTextPaint)

        val jmlFollowingX = jmlFollowersX + 260f // Tambahkan 50 piksel di bawah lingkaran
        val jmlFollowingY = textY1 + 75f
        canvas.drawText("78", jmlFollowingX, jmlFollowingY, bioTextPaint)

        val textPostX = circleX + 180f // jarak kanan kiri
        val textPostY = jmlPostY + 50f // jarak atas bawah
        canvas.drawText("posts", textPostX, textPostY, normalTextPaint)

        val textFollowersX = textPostX + 230f //jarak kanan kiri
        val textFollowersY = jmlPostY + 50f //jarak atas bawah
        canvas.drawText("followers", textFollowersX, textFollowersY, normalTextPaint)

        val textFollowingX = textFollowersX + 270f //jarak kanan kiri
        val textFollowingY = jmlPostY + 50f //jarak atas bawah
        canvas.drawText("following", textFollowingX, textFollowingY, normalTextPaint)

        val textBioX = radius - 85f //jarak kanan kiri
        val textBioY = circleY + 200f //jarak atas bawah
        canvas.drawText("Mampir sini mau liat apa?", textBioX, textBioY, normalTextPaint)

        val textAccX = radius - 85f //jarak kanan kiri
        val textAccY = circleY + 260f //jarak atas bawah
        canvas.drawText("@ chcosmiless", textAccX, textAccY, bioTextPaint)

        // CREATE BUTTON EDITE PROFILE
        val btnEditX = 40f
        val btnEditY = radius + 500f
        val btnEditWidth = 325f
        val btnEditHeight = 75f

        // Mengatur batas tombol
        editProfileRect.set(btnEditX, btnEditY, btnEditX + btnEditWidth, btnEditY + btnEditHeight)

        // Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 3f // Ketebalan border
        canvas.drawRoundRect(editProfileRect, 25f, 25f, paint)

        canvas.drawRoundRect(buttonRect, 25f, 25f, paint)

        // Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 30f

        // Menggambar teks tombol
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 40f
        val buttonText = "Edit Profile"
        val textWidth = paint.measureText(buttonText)
        canvas.drawText(buttonText, editProfileRect.centerX() - textWidth / 2, editProfileRect.centerY() + 13f, paint)

        // CREATE BUTTON SHARE PROFILE
        val btnShareX = btnEditX + 340f
        val btnShareY = radius + 500f
        val btnShareWidth = 325f
        val btnShareHeight = 75f

        // Mengatur batas tombol
        buttonRect.set(btnShareX, btnShareY, btnShareX + btnShareWidth, btnShareY + btnShareHeight)

        // Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 3f // Ketebalan border

        canvas.drawRoundRect(buttonRect, 25f, 25f, paint)

        // Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 40f

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 40f
        val shareText = "Bagikan Profil"
        val shareWidth = paint.measureText(shareText)
        canvas.drawText(shareText, buttonRect.centerX() - shareWidth / 2, buttonRect.centerY() + 13f, paint)

        // CREATE BUTTON CONTACT
        val btnFindX = btnShareX + 340f //jarak kanan kiri
        val btnFindY = radius + 500f //jarak atas bawah
        val btnFindWidth = 325f
        val btnFindHeight = 75f

        // Mengatur batas tombol
        buttonRect.set(btnFindX, btnFindY, btnFindX + btnFindWidth, btnFindY + btnFindHeight)

        // Menggambar border tombol
        paint.color = Color.LTGRAY // Warna border
        paint.style = Paint.Style.STROKE // Hanya menggambar garis luar
        paint.strokeWidth = 3f // Ketebalan border

        canvas.drawRoundRect(buttonRect, 25f, 25f, paint)

        // Reset kembali ke default agar teks bisa digambar dengan benar
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 40f

        // Menggambar teks tombol
        paint.color = Color.BLACK
        paint.textSize = 40f
        val FindText = "Contact"
        val FindWidth = paint.measureText(FindText)
        canvas.drawText(FindText, buttonRect.centerX() - FindWidth / 2, buttonRect.centerY() + 13f, paint)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (editProfileRect.contains(event.x, event.y)) {
                    val intent = Intent(context, EditeActivity::class.java)
                    context.startActivity(intent)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }
}