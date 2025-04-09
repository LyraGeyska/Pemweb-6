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

class EditeProfileView(context: Context, attributeSet: AttributeSet): View(context, attributeSet) {

    val radius = 140f
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val blueTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val blueBoldTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val paintCircle = Paint(Paint.ANTI_ALIAS_FLAG)
    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val normalTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val bioTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val linkTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val smallText = Paint(Paint.ANTI_ALIAS_FLAG)
    lateinit var vectorDrawable: Drawable
    lateinit var vectorBack: Drawable
    lateinit var vectorDrawable3: Drawable
    lateinit var vectorDrawable4: Drawable
    lateinit var vectorDrawable5: Drawable
    val buttonRect = RectF()
    private var btnDoneBounds = Rect()
    private var jmlFollowingBounds = Rect()

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
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        blueTextPaint.apply {
            color = Color.parseColor("#0096FF")
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
//            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        blueBoldTextPaint.apply {
            color = Color.parseColor("#0096FF")
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        normalTextPaint.apply {
            color = Color.BLACK
            textSize = 40f // Ukuran teks
            textAlign = Paint.Align.LEFT // Mengatur teks agar berada di tengah
        }
        smallText.apply {
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
        vectorDrawable = ContextCompat.getDrawable(context, R.drawable.baseline_arrow_back_24)!!
//        vectorDrawable2 = ContextCompat.getDrawable(context, R.drawable.baseline_add_location_24)!!
//        vectorDrawable3 = ContextCompat.getDrawable(context, R.drawable.baseline_calendar_month_24)!!
//        vectorDrawable4 = ContextCompat.getDrawable(context, R.drawable.baseline_link_24)!!
//        vectorDrawable5 = ContextCompat.getDrawable(context, R.drawable.baseline_arrow_back_241)!!
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paintCircle.color = Color.BLACK // Warna border
        paintCircle.style = Paint.Style.STROKE
        paintCircle.strokeWidth = 5f

        val textEditeX =  radius + 300f //jarak kanan kiri
        val textEditeY = radius - 40f //jarak atas bawah
        canvas.drawText("Edite profile", textEditeX, textEditeY, textPaint)

        val textDoneX =  textEditeX + 480f //jarak kanan kiri
        val textDoneY = radius - 40f //jarak atas bawah
        canvas.drawText("DONE", textDoneX, textDoneY, blueBoldTextPaint)
        blueTextPaint.getTextBounds("DONE", 0, "DONE".length, btnDoneBounds)
        btnDoneBounds.offset(textDoneX.toInt(), textDoneY.toInt())

        //GARIS BATAS
        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis1Y = 150f
        canvas.drawLine(0f, garis1Y, width.toFloat(), garis1Y, paint)

        val circleX = radius + 425f // Jarak dari tepi kiri
        val circleY = radius + 180f // Jarak dari tepi bawah
        val radius = 140f
        canvas?.drawCircle(circleX, circleY, radius, paintCircle)

        val textX1 = radius + 230f //jarak kanan kiri
        val textY1 = circleY + 220f //jarak atas bawah
        canvas.drawText("Change profile photo", textX1, textY1, bioTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis2Y = textY1 + 80f
        canvas.drawLine(0f, garis2Y, width.toFloat(), garis2Y, paint)

        val textNameX = radius - 95f //jarak kanan kiri
        val textNameY = garis2Y + 80f //jarak atas bawah
        canvas.drawText("Name", textNameX, textNameY, normalTextPaint)

        val textName2X = textNameX + 255f //jarak kanan kiri
        val textName2Y = garis2Y + 80f //jarak atas bawah
        canvas.drawText("ikan hiu makan lele, hitam putih lee", textName2X, textName2Y, normalTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis3Y = textNameY + 50f
        val offset3X = 300f
        canvas.drawLine(offset3X, garis3Y, width.toFloat(), garis3Y, paint)

        val textUserX = radius - 95f //jarak kanan kiri
        val textUserY = garis3Y + 80f //jarak atas bawah
        canvas.drawText("Username", textUserX, textUserY, normalTextPaint)

        val textUser2X = textNameX + 255f //jarak kanan kiri
        val textUser2Y = garis3Y + 80f //jarak atas bawah
        canvas.drawText("chcosmiless", textUser2X, textUser2Y, normalTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis4Y = textUserY + 50f
        val offset4X = 300f
        canvas.drawLine(offset4X, garis4Y, width.toFloat(), garis4Y, paint)

        val textPronounsX = radius - 95f //jarak kanan kiri
        val textPronounsY = garis4Y + 80f //jarak atas bawah
        canvas.drawText("Pronouns", textPronounsX, textPronounsY, normalTextPaint)

        val textPronouns2X = textNameX + 255f //jarak kanan kiri
        val textPronoun2Y = garis4Y + 80f //jarak atas bawah
        canvas.drawText("Kata ganti", textPronouns2X, textPronoun2Y, smallText)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis5Y = textPronounsY + 50f
        val offset5X = 300f
        canvas.drawLine(offset5X, garis5Y, width.toFloat(), garis5Y, paint)

        val textBioX = radius - 95f //jarak kanan kiri
        val textBioY = garis5Y + 80f //jarak atas bawah
        canvas.drawText("Bio", textBioX, textBioY, normalTextPaint)

        val textBio2X = textBioX + 255f //jarak kanan kiri
        val textBio2Y = garis5Y + 80f //jarak atas bawah
        canvas.drawText("mampir sini mau liat apa?", textBio2X, textBio2Y, normalTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis6Y = textBioY + 50f
        val offset6X = 300f
        canvas.drawLine(offset6X, garis6Y, width.toFloat(), garis6Y, paint)

        val textLinkX = radius - 95f //jarak kanan kiri
        val textLinkY = garis6Y + 80f //jarak atas bawah
        canvas.drawText("Link", textLinkX, textLinkY, normalTextPaint)

        val textLink2X = textPronounsX + 255f //jarak kanan kiri
        val textLink2Y = garis6Y + 80f //jarak atas bawah
        canvas.drawText("Tambahkan tautan", textLink2X, textLink2Y, smallText)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis7Y = textLink2Y + 50f
        val offset7X = 300f
        canvas.drawLine(offset7X, garis7Y, width.toFloat(), garis7Y, paint)

        val textBannerX = radius - 95f //jarak kanan kiri
        val textBannerY = garis7Y + 80f //jarak atas bawah
        canvas.drawText("Banner", textBannerX, textBannerY, normalTextPaint)

        val textBanner2X = textBannerX + 950f //jarak kanan kiri
        val textBanner2Y = garis7Y + 80f //jarak atas bawah
        canvas.drawText("1", textBanner2X, textBanner2Y, smallText)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis8Y = textBanner2Y + 50f
        val offset8X = 300f
        canvas.drawLine(offset8X, garis8Y, width.toFloat(), garis8Y, paint)

        val textMusicX = radius - 95f //jarak kanan kiri
        val textMusicY = garis8Y + 80f //jarak atas bawah
        canvas.drawText("Music", textMusicX, textMusicY, normalTextPaint)

        val textMusic2X = textMusicX + 255f //jarak kanan kiri
        val textMusic2Y = garis8Y + 80f //jarak atas bawah
        canvas.drawText("Tambahkan musik ke profil Anda", textMusic2X, textMusic2Y, smallText)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis9Y = textMusicY + 50f
        val offset9X = 300f
        canvas.drawLine(offset9X, garis9Y, width.toFloat(), garis9Y, paint)

        val textGenderX = radius - 95f //jarak kanan kiri
        val textGenderY = garis9Y + 80f //jarak atas bawah
        canvas.drawText("Gender", textGenderX, textGenderY, normalTextPaint)

        val textGender2X = textGenderX + 255f //jarak kanan kiri
        val textGender2Y = garis9Y + 80f //jarak atas bawah
        canvas.drawText("perempuan", textGender2X, textGender2Y, normalTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis10Y = textGenderY + 80f
        canvas.drawLine(0f, garis10Y, width.toFloat(), garis10Y, paint)

        val textNote1X = radius - 95f //jarak kanan kiri
        val textNote1Y = garis10Y + 80f //jarak atas bawah
        canvas.drawText("Beralih ke akun profesional", textNote1X, textNote1Y, blueTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis11Y = textNote1Y + 55f
        canvas.drawLine(0f, garis11Y, width.toFloat(), garis11Y, paint)

        val textNote2X = radius - 95f //jarak kanan kiri
        val textNote2Y = garis11Y + 80f //jarak atas bawah
        canvas.drawText("Pengaturan informasi pribadi", textNote2X, textNote2Y, blueTextPaint)

        paint.color = Color.LTGRAY // Warna garis
        paint.strokeWidth = 2f
        val garis12Y = textNote2Y + 55f
        canvas.drawLine(0f, garis12Y, width.toFloat(), garis12Y, paint)

        val textNote3X = radius - 95f //jarak kanan kiri
        val textNote3Y = garis12Y + 80f //jarak atas bawah
        canvas.drawText("Tampilkan bahwa profil Anda sudah diverifikasi", textNote3X, textNote3Y, blueTextPaint)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (btnDoneBounds.contains(event.x.toInt(), event.y.toInt())) {
                    //klik DONE
                    val intent = Intent(context, btnDoneBounds::class.java)
                    context.startActivity(intent)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }
}