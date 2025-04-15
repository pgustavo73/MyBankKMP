import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val airplane: ImageVector
	get() {
		if (_Airplanemode_active != null) {
			return _Airplanemode_active!!
		}
		_Airplanemode_active = ImageVector.Builder(
            name = "Airplanemode_active",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
			path(
    			fill = SolidColor(Color.Black),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.NonZero
			) {
				moveTo(340f, 880f)
				verticalLineToRelative(-60f)
				lineToRelative(80f, -60f)
				verticalLineToRelative(-220f)
				lineTo(80f, 640f)
				verticalLineToRelative(-80f)
				lineToRelative(340f, -200f)
				verticalLineToRelative(-220f)
				quadToRelative(0f, -25f, 17.5f, -42.5f)
				reflectiveQuadTo(480f, 80f)
				reflectiveQuadToRelative(42.5f, 17.5f)
				reflectiveQuadTo(540f, 140f)
				verticalLineToRelative(220f)
				lineToRelative(340f, 200f)
				verticalLineToRelative(80f)
				lineTo(540f, 540f)
				verticalLineToRelative(220f)
				lineToRelative(80f, 60f)
				verticalLineToRelative(60f)
				lineToRelative(-140f, -40f)
				close()
			}
		}.build()
		return _Airplanemode_active!!
	}

private var _Airplanemode_active: ImageVector? = null
